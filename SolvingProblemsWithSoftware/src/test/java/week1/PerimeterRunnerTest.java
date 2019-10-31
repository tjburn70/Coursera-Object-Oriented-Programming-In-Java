package week1;

import edu.duke.FileResource;
import edu.duke.Shape;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;


public class PerimeterRunnerTest {
    @Test
    public void testPerimeter(){
        double expectedPerimeter = 16.0;
        String filePath = "./SolvingProblemsWithSoftware/src/test/resources/week1/example1.txt";
        FileResource fr = new FileResource(filePath);
        Shape s = new Shape(fr);
        double actualPerimeter = PerimeterRunner.getPerimeter(s);
        System.out.println("actualPerimeter: " + actualPerimeter);
        Assert.assertEquals(expectedPerimeter, actualPerimeter, 0.1);
    }

    @Test
    public void testNumPoints () {
        int expectedNumPoints = 4;
        String filePath = "./SolvingProblemsWithSoftware/src/test/resources/week1/example1.txt";
        FileResource fr = new FileResource(filePath);
        Shape s = new Shape(fr);
        int actualNumPoints = PerimeterRunner.getNumPoints(s);
        System.out.println("actualNumPoints: " + actualNumPoints);
        Assert.assertEquals(expectedNumPoints, actualNumPoints, 0.1);
    }

    @Test
    public void testAverageLength () {
        double expectedAverageLength = 4.0;
        String filePath = "./SolvingProblemsWithSoftware/src/test/resources/week1/example1.txt";
        FileResource fr = new FileResource(filePath);
        Shape s = new Shape(fr);
        double actualAverageLength = PerimeterRunner.getAverageLength(s);
        System.out.println("actualNumPoiints: " + actualAverageLength);
        Assert.assertEquals(expectedAverageLength, actualAverageLength, 0.1);
    }

    @Test
    public void testLargestSide () {
        double expectedLargestSide = 5.0;
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double actualLargestSide = PerimeterRunner.getLargestSide(s);
        System.out.println("actualLargestSide: " + actualLargestSide);
        Assert.assertEquals(expectedLargestSide, actualLargestSide, 0.1);
    }

    @Test
    public void testLargestX () {
        double expectedLargestX = 4.0;
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double actualLargestX = PerimeterRunner.getLargestX(s);
        System.out.println("actualLargestX: " + actualLargestX);
        Assert.assertEquals(expectedLargestX, actualLargestX, 0.1);
    }

    @Test
    public void testPerimeterMultipleFiles() {
        // Choose datatest1.txt through datatest6.txt
        double expectedLargestPerimeter = 62.65;
        double actualLargestPerimeter = PerimeterRunner.getLargestPerimeterMultipleFiles();
        System.out.println("largestPerimeter = " + actualLargestPerimeter);
        Assert.assertEquals(expectedLargestPerimeter, actualLargestPerimeter, 0.001);
    }

    @Test
    public void testFileWithLargestPerimeter() {
        // Choose datatest1.txt through datatest6.txt
        String expectedFilePath = "./SolvingProblemsWithSoftware/src/test/resources/week1/example1.txt";
        File expectedFile = new File(expectedFilePath);
        File actualFileWithLargestPerimeter = PerimeterRunner.getFileWithLargestPerimeter();
        System.out.println("actualFileWithLargestPerimeter = " + actualFileWithLargestPerimeter);
        Assert.assertEquals(expectedFile, actualFileWithLargestPerimeter);
    }


}
