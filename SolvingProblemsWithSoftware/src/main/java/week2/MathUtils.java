package week2;

import java.util.List;

public class MathUtils {
    public static Integer getMinValue(List<Integer> ints){
        Integer minValue = ints.get(0);
        for(Integer i =1; i < ints.size(); i++){
            Integer currentValue = ints.get(i);
            if(currentValue < minValue) {
                minValue = currentValue;
            }
        }
        return minValue;
    }
}
