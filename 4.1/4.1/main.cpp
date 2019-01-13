//
//  main.cpp
//  4.1
//
//  Created by Haoyu Guo on 2018/12/24.
//  Copyright © 2018 Haoyu Guo. All rights reserved.
//

#define GLUT_DISABLE_ATEXIT_HACK
#include <GLUT/glut.h>


int view_width = 300,view_height = 300;
double left = -100,right = 100,bottom = -100,top = 100;

typedef float Point2D[2];
Point2D sP = {0,0},eP = {30,50};

//You could draw many lines as you like

#include <vector>
struct Line2D{
    Point2D PQ[2];
};
typedef std::vector<Line2D> lines;


//===================rubble line tool using mouse====================
bool first = true;
void mouseClicked(int button, int state, int x, int y){
    if(state==GLUT_DOWN&&button==GLUT_LEFT_BUTTON){
        y = view_height-y;
        float xf = (x-(float)view_width/2)/view_width*(right-left);
        float yf = (y-(float)view_height/2)/view_height*(top-bottom);
        if(first){
            sP[0] = xf; sP[1] = yf;
            first = false;
        }
        else{
            eP[0] = xf; eP[1] = yf;
            first = true;
            glutPostRedisplay();
        }
    }
}
void mousePassiveMotion(int x,int y){
    if(!first){
        y = view_height-y;
        float xf = (x-(float)view_width/2)/view_width*(right-left);
        float yf = (y-(float)view_height/2)/view_height*(top-bottom);
        eP[0] = xf; eP[1] = yf;
        glutPostRedisplay();
    }
}


void renderScene(void) {
    
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    
    // please fill the following code into the renderScene() function
    glBegin(GL_LINES);
    glVertex2f(sP[0],sP[1]);
    glVertex2f(eP[0],eP[1]);
    glEnd();
    
    glutSwapBuffers();
}

//Called once when the application starts and again every time the window is resized by the user.
GLvoid resizeScene(GLsizei width, GLsizei height)
{
    //--------------reset the viewport--------------
    // avoid divide by zero
    if (height==0)
    {
        height=1;
    }
    
    // reset the viewport to the new dimensions
    glViewport(0, 0, width, height);
    
    // -----------set up the projection-------------------
    // select the projection matrix and clear it out
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    
    //choose the appropriate projection based on the currently toggled mode
    //gluOrtho2D(GLdouble left, GLdouble right, GLdouble bottom, GLdouble top);
    gluOrtho2D(left,right,bottom,top);
    
    //-----------set up the modelview--------------------
    // select modelview matrix and clear it out
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
    
} // end resizeScene()

int main(int argc, char **argv) {
    
    // init GLUT and create Window
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_DEPTH | GLUT_DOUBLE | GLUT_RGBA);
    glutInitWindowPosition(100,100);
    glutInitWindowSize(view_width,view_height);
    glutCreateWindow("Lighthouse3D - GLUT Tutorial");
    
    
    glutDisplayFunc(renderScene);               // register dispaly callbacks
    glutReshapeFunc(resizeScene);               //register reshape callbacks
    glutMouseFunc(mouseClicked);                //register mouse clicking callback
    glutPassiveMotionFunc(mousePassiveMotion);  //register passive motion callback
    
    // enter GLUT event processing cycle
    glutMainLoop();
    
    return 1;
}

