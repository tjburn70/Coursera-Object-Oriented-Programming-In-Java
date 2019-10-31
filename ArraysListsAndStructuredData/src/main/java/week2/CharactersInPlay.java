package week2;

import edu.duke.FileResource;

import java.util.ArrayList;

public class CharactersInPlay {
    public ArrayList<String> characters;
    public ArrayList<Integer> characterLineCount;

    public CharactersInPlay(){
        characters = new ArrayList<String>();
        characterLineCount = new ArrayList<Integer>();
    }

    public void update(String character){
        int index = characters.indexOf(character);
        if (index == -1){
            characters.add(character);
            characterLineCount.add(1);
        } else {
            int value = characterLineCount.get(index);
            characterLineCount.set(index, value+1);
        }

    }

    public void findAllCharacters(){
        characters.clear();
        characterLineCount.clear();

        String period = ".";
        FileResource fr = new FileResource();
        for(String line : fr.lines()){
            int periodIndex = line.indexOf(period);
            while (periodIndex != -1) {
                String character = line.substring(0, periodIndex+1);
                update(character);
                line = line.substring(periodIndex+1);
                periodIndex = line.indexOf(period);
            }

        }
    }


    public ArrayList<String> charactersWithNumParts(int num1, int num2) throws Exception {
        if (num1 >= num2){
            throw new Exception("num1 greater than num2");
        }

        ArrayList<String> charactersWith = new ArrayList<String>();

        for (int j=0; j < characters.size(); j++){
            int freq = characterLineCount.get(j);
            if (freq >= num1 && freq <= num2){
                String character = characters.get(j);
                charactersWith.add(character);
            }
        }

        return charactersWith;
    }
}
