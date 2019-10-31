package week2;

import org.junit.Test;

import java.util.ArrayList;

public class CharactersInPlayTest {
    @Test
    public void testFindAllCharacters(){
        CharactersInPlay charactersInPlay = new CharactersInPlay();
        charactersInPlay.findAllCharacters();

        for(int k=0; k < charactersInPlay.characters.size(); k++){
            int lineCount = charactersInPlay.characterLineCount.get(k);
            String character = charactersInPlay.characters.get(k);
            System.out.println(lineCount + "\t" + character);
        }

        int num1 = 10;
        int num2 = 15;
        ArrayList<String> charactersWithNumParts = new ArrayList<String>();
        try {
            charactersWithNumParts = charactersInPlay.charactersWithNumParts(num1, num2);
        } catch (Exception exc) {
            System.out.println(exc.toString());
        }

        for(String character : charactersWithNumParts){
            System.out.println(character);
        }
    }
}
