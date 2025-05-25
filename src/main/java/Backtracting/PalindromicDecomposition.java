package Backtracting;

/*
Palindromic Decomposition Of A String
Find all palindromic decompositions of a given string s.

A palindromic decomposition of string is a decomposition of the string into substrings, such that all those substrings are valid palindromes.
 */

import java.util.ArrayList;
import java.util.List;

public class PalindromicDecomposition {
    public static void main(String[] args) {

    }

    private ArrayList<String> generatePalindromicDecomposition(String input){
        List<List<String>> results = new ArrayList<>();
        backTrack(input, 0, new ArrayList<>(), results);

        ArrayList<String> finalResults = new ArrayList<>();
        for (List<String> result : results){
            finalResults.add(String.join("|", result));

        }
        for (String result : finalResults){
            System.out.println(result);
        }

        return finalResults;
    }

    private static void backTrack(String input, int start, List<String> current, List<List<String>> result){
        if (start == input.length()){
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i<= input.length()-1;i++){
            String sub = input.substring(start, i+1);
            if (ispalindrome(sub)){
                current.add(sub);
                backTrack(input, i+1, current, result);
                current.remove(current.size()-1);
            }
        }

    }

    private static boolean ispalindrome(String s){
        int l = 0, r = s.length()-1;
        while (l<r){
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }

        return true;
    }
}
