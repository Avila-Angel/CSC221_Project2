package com.example.csc221_project2;

import javafx.application.Application;
// import javafx.scene.paint.Color;
// import javafx.scene.shape.ArcType;
// java.util.vector;
// java.lang.Math;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;


public class Project2 extends Application {
    static int x = 900; // window x coordinate
    static int y = 900; // window y coordinate
    @Override
    public void start(Stage stage) {
        int colorValues = MyColor.values().length;
        MyColor [] colorsList = MyColor.values();
        Group root = new Group();
        stage.setTitle("CSC 22100 Assignment 2"); // create a title for our scene at the top
        Canvas canvas = new Canvas(x,y); // creates screen canvas with x and y values
        GraphicsContext gc = canvas.getGraphicsContext2D(); // returns graphic context

        root.getChildren().add(canvas);
        stage.setScene(new Scene(root)); // adds scene to stage

        MyOval testOval = new MyOval(x/2,x/2,new MyPoint(x/2,y/2),MyColor.TAN);
        MyRectangle border  = new MyRectangle(3*x/5,3*y/5,new MyPoint(x/5,y/5),MyColor.BURLYWOOD);
        border.outline(gc);
        for(int i = 0, x = 6; i<=x ;++i){
            int degree = 360/x;
            MyArc testArc = new MyArc(testOval,degree,degree*i,MyColor.values()[i % MyColor.values().length]);
            testArc.draw(gc);
        }

        //Bounding Rectangle of MyArc and MyCircle
        MyOval oval = new MyOval(60,60,new MyPoint(60,60),MyColor.TAN);
        MyArc arc = new MyArc(oval,90,90,MyColor.PALEGOLDENROD);
        MyCircle circle = new MyCircle(30,new MyPoint(240,60),MyColor.GOLDENROD);

        arc.draw(gc);
        circle.draw(gc);

        arc.getMyBoundingRectangle().outline(gc);
        circle.getMyBoundingRectangle().outline(gc);


        //Area of Intersection
        MyRectangle s1 = new MyRectangle(20,90,new MyPoint(685,30), MyColor.GOLD);
        MyRectangle s2 = new MyRectangle(140,20,new MyPoint(625,30), MyColor.GOLDENROD);
        MyRectangle s3 = new MyRectangle(120,30,new MyPoint(435,40), MyColor.GOLDENROD);
        MyCircle s4 = new MyCircle(40, new MyPoint(450,60), MyColor.GOLD);
        MyPoint s5 = new MyPoint(425,59,MyColor.BLACK); //Testing

        MyShapeInterface.drawIntersectMyShapes(s1, s2, gc);
        MyShapeInterface.drawIntersectMyShapes(s3, s4, gc);
        s5.draw(gc); //Testing

        stage.show(); // shows stage (keep at end of start method)

    }

    public static void main(String[] args) {
        launch();
    }
}