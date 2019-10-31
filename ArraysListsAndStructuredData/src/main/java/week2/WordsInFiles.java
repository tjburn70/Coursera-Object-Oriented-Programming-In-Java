package week2;

import edu.duke.DirectoryResource;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class WordsInFiles {
    public HashMap<String,ArrayList<String>> wordToFileList;

    public WordsInFiles(){
        this.wordToFileList = new HashMap<>();
    }

    private void addWordsFromFile(File f){
        try {
           Scanner scan = new Scanner(f);
           while (scan.hasNext()){
               String word = scan.next();
               if (this.wordToFileList.keySet().contains(word)){
                   ArrayList<String> fileList = this.wordToFileList.get(word);
                   String fileName = f.getName();
                   if(!fileList.contains(fileName)){
                       fileList.add(f.getName());
                   }
                   this.wordToFileList.put(word, fileList);
               } else {
                   ArrayList<String> fileList = new ArrayList<>(Arrays.asList(f.getName()));
                   this.wordToFileList.put(word, fileList);
               }
           }
        } catch (java.io.FileNotFoundException fnfe){
            System.out.println(fnfe.getMessage());
        }
    }

    public void buildWordFileMap(){
        this.wordToFileList.clear();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            this.addWordsFromFile(f);
        }
    }

    public int maxNumber(){
        int maxNumberOfFiles = 0;
        for (String word : this.wordToFileList.keySet()){
            ArrayList<String> files = this.wordToFileList.get(word);
            int numberOfFiles = files.size();
            if (numberOfFiles > maxNumberOfFiles){
                maxNumberOfFiles = numberOfFiles;
            }
        }

        return maxNumberOfFiles;
    }

    public ArrayList<String> wordsInNumFiles(Integer number){
        ArrayList<String> wordsFoundInGivenNumberOfFiles = new ArrayList<>();
        for (String word : this.wordToFileList.keySet()) {
            ArrayList<String> files = this.wordToFileList.get(word);
            int numberOfFiles = files.size();
            if (numberOfFiles == number){
                wordsFoundInGivenNumberOfFiles.add(word);
            }
        }

        return wordsFoundInGivenNumberOfFiles;
    }

    public void printFilesIn(String word){
        ArrayList<String> filesWithWord = this.wordToFileList.get(word);
        for(String fileName : filesWithWord){
            System.out.println(fileName+"\n");
        }
    }


}
