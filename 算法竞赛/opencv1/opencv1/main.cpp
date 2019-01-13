//
//  main.cpp
//  opencv1
//
//  Created by Haoyu Guo on 18/04/2017.
//  Copyright © 2017 Haoyu Guo. All rights reserved.
//

#include <iostream>
#include <opencv2/opencv.hpp>
using namespace cv;
using namespace std;
int main()
{
    Mat input_image;
    VideoCapture cam(0);
    if (!cam.isOpened()) exit(0);
    Size s(320, 240);
    VideoWriter writer = VideoWriter("myvideo.avi", CV_FOURCC('M', 'J', 'P', 'G'), 25, s);
    if (!writer.isOpened())
    {
        cout << "cannot create a file.\n" << endl;
        return -1;
    }
    
    namedWindow("input image");
    while (true) {
        cam >> input_image;
        //WriteFrame(writer, outimage)
        //                cvWriteFrame(writer, input_image);
        imshow("input image", input_image);
        //                writer << input_image;
        if (27 == waitKey(30))
        break;
    }
    
}

