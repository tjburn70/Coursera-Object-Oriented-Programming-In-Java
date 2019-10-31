package week1;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import edu.duke.Point;
import edu.duke.Shape;

import java.io.File;


public class PerimeterRunner {
    public static double getPerimeter (Shape s) {
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();

        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
        }
        return totalPerim;
    }

    public static int getNumPoints (Shape s) {
        int numPoints = 0;
        for (Point point : s.getPoints()) {
            numPoints = numPoints + 1;
        }
        return numPoints;
    }

    public static double getAverageLength (Shape s) {
        double totalPerim = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double averageLength = totalPerim / (double)numPoints;
        return averageLength;
    }

    public static double getLargestSide (Shape s) {
        double largestSide = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if (currDist > largestSide){
                largestSide = currDist;
            }
            prevPt = currPt;
        }
        return largestSide;
    }

    public static double getLargestX (Shape s) {
        double largestX = 0.0;
        for (Point currPt : s.getPoints()) {
            if(currPt.getX() > largestX){
                largestX = currPt.getX();
            }
        }
        return largestX;
    }

    public static double getLargestPerimeterMultipleFiles () {
        Double largestPerimeter = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerimeter = getPerimeter(s);
            if (currPerimeter > largestPerimeter){
                largestPerimeter = currPerimeter;
            }
        }
        return largestPerimeter;
    }

    public static File getFileWithLargestPerimeter () {
        File fileWithLargestPerimeter = null;
        Double largestPerimeter = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerimeter = getPerimeter(s);
            if (currPerimeter > largestPerimeter){
                fileWithLargestPerimeter = f;
            }
        }
        return fileWithLargestPerimeter;
    }

    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
    }

}
