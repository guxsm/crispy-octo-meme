/*
    Plus Minus

 * Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero. 
 * Print the decimal value of each fraction on a new line with  places after the decimal.
 * Note: This challenge introduces precision problems. The test cases are scaled to six decimal places, 
 * though answers with absolute error of up to  are acceptable.
 *
 * Example
 *      A=[1,1,0,-1,-1]
 *      There are n=5 elements, two positive, two negative and one zero. Their ratios are 2/5=0.400000, 2/5=0.400000 and 1/5=0.200000
 * 
 * Constrainst
 *      0<n<=100
 *      -100<=A[i]<=100
 */

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class PlusMinus {
    private void start(List<Integer> array) {
        int i=0, negN=0, posN=0, zero=0;

        while(i<array.size()) {
            if(array.get(i)<0)  
                negN++;
            if(array.get(i)==0)
                zero++;
            if(array.get(i)>0)
                posN++;

            i++;
        }

        print(array, negN, zero, posN);
    }

    private void print(List<Integer> array, Integer negN, Integer zero, Integer posN ) {
        DecimalFormat df = new DecimalFormat("#.######");
        df.setMinimumFractionDigits(6);
        df.setMaximumFractionDigits(6);

        System.out.println("Array: " + array);
        System.out.println("N: " + array.size());
        System.out.println("Negatives: " + negN);
        System.out.println("Zeroes: " + zero);
        System.out.println("Positives: " + posN);

        if(posN!=0) {
            System.out.println("Positive ratio: " + df.format((double)posN/array.size()));
        } else {
            System.out.println("No Positives found");
        }

        if(negN!=0) {            
            System.out.println("Negative ratio: " + df.format((double)negN/array.size()));
        } else {
            System.out.println("No Negatives found");
        }

        if(zero!=0) {
            System.out.println("Zero ratio: " + df.format((double)zero/array.size()));
        } else {
            System.out.println("No Zeroes found");
        }
    }
     
    public static void main(String[] args) throws Exception {
        new PlusMinus().start(new ArrayList<>(Arrays.asList(1,-2,-7,9,1,-8,-5)));
        //new PlusMinus().start(new ArrayList<>(Arrays.asList(55,48,48,45,91,97,45,1,39,54,36,6,19,35,66,36,72,93,38,21,65,70,36,63,39,76,82,26,67,29,24,82,62,53,1,50,47,65,67,19,66,90,77)));        
        
    }
}
