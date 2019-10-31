package week2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class WordsInFilesTest {

    @Test
    public void testBuildWordFileMap(){
        WordsInFiles wordsInFiles = new WordsInFiles();
        wordsInFiles.buildWordFileMap();

        int maxNumber = wordsInFiles.maxNumber();
        System.out.println("Max Number of Files: "+maxNumber);

        int numOfFiles = 5;
        ArrayList<String> words = wordsInFiles.wordsInNumFiles(numOfFiles);
        System.out.println("Words found in 5 files: " +words.size());
        for(String word : words){
            System.out.println(word);
        }

        String word = "red";
        wordsInFiles.printFilesIn(word);

        System.out.println(wordsInFiles.wordToFileList);

    }

    @Test
    public void testNumberOfWordsInFiveFiles(){
        WordsInFiles wordsInFiles = new WordsInFiles();
        wordsInFiles.buildWordFileMap();

        int numOfFiles = 5;
        ArrayList<String> words = wordsInFiles.wordsInNumFiles(numOfFiles);
        int numOfWords = words.size();
        System.out.println("Words found in 5 files: " +numOfWords);

        int expected = 880;
        int actual = numOfWords;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNumberOfWordsInFourFiles(){
        WordsInFiles wordsInFiles = new WordsInFiles();
        wordsInFiles.buildWordFileMap();

        int numOfFiles = 4;
        ArrayList<String> words = wordsInFiles.wordsInNumFiles(numOfFiles);
        int numOfWords = words.size();
        System.out.println("Words found in 5 files: " +numOfWords);

        int expected = 780;
        int actual = numOfWords;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindFilesWithWordSad(){
        WordsInFiles wordsInFiles = new WordsInFiles();
        wordsInFiles.buildWordFileMap();

        String word = "sad";
        wordsInFiles.printFilesIn(word);
    }

    @Test
    public void testFindFilesWithWordRed(){
        WordsInFiles wordsInFiles = new WordsInFiles();
        wordsInFiles.buildWordFileMap();

        String word = "red";
        wordsInFiles.printFilesIn(word);
    }

    @Test
    public void testFindFilesWithWordSea(){
        WordsInFiles wordsInFiles = new WordsInFiles();
        wordsInFiles.buildWordFileMap();

        String word = "sea";
        wordsInFiles.printFilesIn(word);
    }

    @Test
    public void testFindFilesWithWordTree(){
        WordsInFiles wordsInFiles = new WordsInFiles();
        wordsInFiles.buildWordFileMap();

        String word = "tree";
        wordsInFiles.printFilesIn(word);
    }

    @Test
    public void testNumberOfWordsInSevenFilesOutOfSeven(){
        WordsInFiles wordsInFiles = new WordsInFiles();
        wordsInFiles.buildWordFileMap();

        int numOfFiles = 7;
        ArrayList<String> words = wordsInFiles.wordsInNumFiles(numOfFiles);
        int numOfWords = words.size();
        System.out.println("Words found in 7 files: " +numOfWords);

        int expected = 570;
        int actual = numOfWords;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNumberOfWordsInFourFilesOutOfSeven(){
        WordsInFiles wordsInFiles = new WordsInFiles();
        wordsInFiles.buildWordFileMap();

        int numOfFiles = 4;
        ArrayList<String> words = wordsInFiles.wordsInNumFiles(numOfFiles);
        int numOfWords = words.size();
        System.out.println("Words found in 4 files: " +numOfWords);

        int expected = 826;
        int actual = numOfWords;

        Assert.assertEquals(expected, actual);
    }

}

