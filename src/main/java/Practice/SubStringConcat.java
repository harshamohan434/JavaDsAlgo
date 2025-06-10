package Practice;

import java.util.*;
import java.util.stream.Collectors;

public class SubStringConcat {
    public static void main(String[] args) {
        findAnagrams();
    }

    static void findAnagrams(){
        List<String> strs = Arrays.asList("eat","tea","tan","ate","nat","bat");
        Map<String,List<String>> groups = new HashMap<>();
        for (String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String group = String.join("",String.valueOf(chars));
            groups.computeIfAbsent(group, g -> new ArrayList<>()).add(str);
        }
        groups.values().stream()
                .forEach(System.out::println);
    }

    static void calculateLongestSubstring(){
        /*
        Problem Statement:
        Given a string s, find the length of the longest substring without repeating characters.

        Example :
            Input: s = "abcabcbb"
            Output: 3
            Explanation: The answer is "abc", with length 3.
         */
        String input  = "abcabcbb";
        System.out.println(getLongestSubstring(input));

    }

    static int getLongestSubstring(String s){
        int maxLen = 0;
        PriorityQueue<Character> characters = new PriorityQueue<>();
        int left = 0;
        for (int i=0; i< s.length();i++){

            while (characters.contains(s.charAt(i))){
                characters.poll();
                left++;
            }
            characters.add(s.charAt(i));
            maxLen = Math.max(maxLen, i-left+1);
        }

        return maxLen;
    }


    void subStringWithConcatedWords(){
        /*
        Problem Statement:You are given a string s and an array of strings words,
        where all strings in words are of the same length.
        Return all starting indices of substring(s) in s that is a concatenation of each word
        in words exactly once and without any intervening characters.

        Example:
            Input:
            s = "barfoothefoobarman"
            words = ["foo", "bar"]

            Output: [0,9]
         */

        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo","bar"};
        int[] expectedOutput = new int[]{0,9};
        List<Integer> actualOutput = getMatchingIndices(s, words);
        actualOutput.stream()
                .forEach(System.out::println);
    }
    static  List<Integer> getMatchingIndices(String s, String[] words){
        /* Approach
    1. get the frequency of the words
    2. length of concat is k = words.length * word[0].length.
    3. get the substring of s[0..k]
    4. take substring.substring of length word[0].length check if present in frequency key
        a. if not slide the string window
        b. check current word count in sub string if exceed the count in freq then slid the window.
        c. if pointer reaches to end then increment count.
     */
        Map<String, Integer> frequency = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (String word : words){
            frequency.put(word, frequency.getOrDefault(word,0)+1);
        }
        int wordlen = words[0].length();

        int concatLength = words.length * words[0].length();
        if (concatLength > s.length()) return result;
        for (int i=0; i< s.length()-concatLength;i++){
            Map<String, Integer> seen = new HashMap<>();
            int currentWord = 0;
            while (currentWord < words.length){
                int start = i+currentWord*wordlen;
                String subString = s.substring(start, start+wordlen);
                if (!frequency.containsKey(subString)) break;
                seen.put(subString, seen.getOrDefault(subString, 0)+1);
                if (seen.get(subString) > frequency.get(subString)) break;
                currentWord++;
            }
            if (currentWord == words.length) result.add(i);

        }
        return result;
    }

}
