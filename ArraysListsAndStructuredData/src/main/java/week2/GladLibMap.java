package week2;

import edu.duke.FileResource;
import edu.duke.URLResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GladLibMap {
    private ArrayList<String> alreadyUsedWordList;
    private Integer totalNumWordsReplaced;
    private ArrayList<String> labelsUsed;
    private HashMap<String, ArrayList<String>> myMap = new HashMap<>();

    private Random myRandom;
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "./ArraysListsAndStructuredData/resources/data";


    public GladLibMap(){
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
        alreadyUsedWordList = new ArrayList<String>();
        labelsUsed = new ArrayList<>();
        totalNumWordsReplaced = 0;
    }

    public GladLibMap(String source){
        initializeFromSource(source);
        myRandom = new Random();
        alreadyUsedWordList = new ArrayList<String>();
        labelsUsed = new ArrayList<>();
        totalNumWordsReplaced = 0;
    }

    private void initializeFromSource(String source) {
        String[] labels = {"country", "noun", "animal", "adjective", "name", "color", "timeframe", "verb", "fruit"};
        for (String label : labels){
            String path = source+"/"+label+".txt";
            ArrayList<String> wordList = readIt(path);
            myMap.put(label, wordList);
        }

    }

    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }

    private String getSubstitute(String label) {
        labelsUsed.add(label);
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        return randomFrom(myMap.get(label));
    }

    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        while (alreadyUsedWordList.contains(sub)){
            sub = getSubstitute(w.substring(first+1, last));
        }
        alreadyUsedWordList.add(sub);
        totalNumWordsReplaced+=1;

        return prefix+sub+suffix;
    }

    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
        System.out.println("\n\nTotal Number of Words Replaced: "+totalNumWordsReplaced);
    }

    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }

    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }

    public void makeStory(){
        System.out.println("\n");
        alreadyUsedWordList.clear();
        String story = fromTemplate(dataSourceDirectory+"/madtemplate2.txt");
        printOut(story, 60);
    }

    public int totalWordsInMap(){
        int totalWords = 0;
        for(String label : myMap.keySet()){
            ArrayList<String> wordList = myMap.get(label);
            totalWords += wordList.size();
        }
        return totalWords;
    }

    public int totalWordsConsidered(){
        int totalWordsConsidered = 0;
        for(String label : labelsUsed){
            ArrayList<String> wordList = myMap.get(label);
            totalWordsConsidered += wordList.size();
        }
        return totalWordsConsidered;
    }

}
