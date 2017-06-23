/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hamza
 */
public abstract class VowelComparator implements Comparable<String> {

    /**
     *
     * @param s1
     * @param s2
     * @return
     */
    public int compare(String s1, String s2) {
        int countS1 = countVowels(s1);
        int countS2 = countVowels(s2);
        if (countS1 == countS2) {
            return s1.compareTo(s2);
        }
        return countS1 - countS2;
    }

    public int countVowels(String word) {
        char[] word_loweCase = word.toLowerCase().toCharArray();
        int vowels = 0;
        for (int w = 0; w < word.length(); w++) {
            if (word_loweCase[w] == 'a' || word_loweCase[w] == 'e' || word_loweCase[w] == 'i' || word_loweCase[w] == 'o' || word_loweCase[w] == 'u') {
                vowels++;
            }
        }
        return vowels;
    }
}
