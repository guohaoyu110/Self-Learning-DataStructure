#include <caffe/caffe.hpp>
#include <opencv2/core/core.hpp>
#include <opencv2/highgui/highgui.hpp>
#include <opencv2/imgproc/imgproc.hpp>
#include <iosfwd>
#include <memory>
#include <string>
#include <utility>
#include <vector>
using namespace caffe; // NOLINT(build/namespaces)
using std::string;
class NetOperator
{
public:
    NetOperator(const string& net_prototxt);
    NetOperator(const string& net_prototxt, const string& trained_file);
    ~NetOperator() { }
    int batch_size() { return batch_size_; }
    Blob<float>* processImage(const string &img_path, bool is_color = true);
    Blob<float>* processImages(const vector<string> &img_paths, bool is_color = true);
private:
    void createNet(const string& net_prototxt);
    // read the image and store it in the idx position of images in the blob
    void readImageToBlob(const string &img_path, int idx = 0, bool is_color = true);
    shared_ptr<Net<float> > net_;
    cv::Size input_geometry_;
    int batch_size_;
    int num_channels_;
    Blob<float>* input_blob_;
    TransformationParameter transform_param_;
    shared_ptr<DataTransformer<float> > data_transformer_;
    Blob<float> transformed_data_;
};
NetOperator::NetOperator(const string& net_prototxt) {
    createNet(net_prototxt);
}
NetOperator::NetOperator(const string& net_prototxt, const string& trained_file) {
    createNet(net_prototxt);
    net_->CopyTrainedLayersFrom(trained_file);
}
void NetOperator::createNet(const string& net_prototxt) {
#ifdef CPU_ONLY
    Caffe::set_mode(Caffe::CPU);
#else
    Caffe::set_mode(Caffe::GPU);
#endif
    net_.reset(new Net<float>(net_prototxt, TEST));
    CHECK_EQ(net_->num_inputs(), 1) << "Network should have exactly one input.";
    CHECK_EQ(net_->num_outputs(), 1) << "Network should have exactly one output.";
    Blob<float>* input_layer = net_->input_blobs()[0];
    batch_size_ = input_layer->num();
    num_channels_ = input_layer->channels();
    CHECK(num_channels_ == 3 || num_channels_ == 1)
    << "Input layer should have 1 or 3 channels.";
    input_geometry_ = cv::Size(input_layer->width(), input_layer->height());
    // reshape the output shape of the DataTransformer
    vector<int> top_shape(4);
    top_shape[0] = 1;
    top_shape[1] = num_channels_;
    top_shape[2] = input_geometry_.height;
    top_shape[3] = input_geometry_.width;
    this->transformed_data_.Reshape(top_shape);
}
Blob<float>* NetOperator::processImage(const string &img_path, bool is_color) {
    // reshape the net for the input
    input_blob_ = net_->input_blobs()[0];
    input_blob_->Reshape(1, num_channels_,
                         input_geometry_.height, input_geometry_.width);
    net_->Reshape();
    readImageToBlob(img_path, 0, is_color);
    net_->ForwardPrefilled();
    return net_->output_blobs()[0];
}
Blob<float>* NetOperator::processImages(const vector<string> &img_paths, bool is_color) {
    int img_num = img_paths.size();
    // reshape the net for the input
    input_blob_ = net_->input_blobs()[0];
    input_blob_->Reshape(img_num, num_channels_,
                         input_geometry_.height, input_geometry_.width);
    net_->Reshape();
    for (int i=0; i<img_num; i++) {
        readImageToBlob(img_paths[i], i, is_color);
    }
    net_->ForwardPrefilled();
    return net_->output_blobs()[0];
}
void NetOperator::readImageToBlob(const string &img_path, int idx, bool is_color) {
    // read the image and resize to the target size
    cv::Mat img;
    int cv_read_flag = (is_color ? CV_LOAD_IMAGE_COLOR :
                        CV_LOAD_IMAGE_GRAYSCALE);
    cv::Mat cv_img_origin = cv::imread(img_path, cv_read_flag);
    if (!cv_img_origin.data) {
        LOG(ERROR) << "Could not open or find file " << img_path;
        return ;
    }
    if (input_geometry_.height > 0 && input_geometry_.width > 0) {
        cv::resize(cv_img_origin, img, input_geometry_);
    } else {
        img = cv_img_origin;
    }
    // transform the image to a blob using DataTransformer
    // create a DataTransformer using default TransformationParameter (no transformation)
    data_transformer_.reset(
                            new DataTransformer<float>(transform_param_, TEST));
    data_transformer_->InitRand();
    // set the output of DataTransformer to the idx image of the input blob
    int offset = input_blob_->offset(idx);
    this->transformed_data_.set_cpu_data(input_blob_->mutable_cpu_data() + offset);
    // transform the input image
    data_transformer_->Transform(img, &(this->transformed_data_));
}
