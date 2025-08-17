package com.milestone1.ques;
import java.util.Scanner;

public class Ques2 {
    public static String replaceSpaces(String S) {
        // Write your logic here:
        if (S.indexOf(' ') == -1) {
            return S + "%40";
        }
        
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < S.length()) {
            if (S.charAt(i) == ' ') {
                int j = i;
                while (j < S.length() && S.charAt(j) == ' ') {
                    j++;
                }
                int spaceCount = j - i;
                if (spaceCount == 1) {
                    result.append("%20");
                } else {
                    result.append("%30");
                }
                i = j;
            } else {
                result.append(S.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // Non editable starts here
       Scanner sc = new Scanner(System.in);  //input- ab, a , abcd, a b c d  
        String S = sc.nextLine();
        sc.close();
        System.out.println(replaceSpaces(S));
        // Non editable ends here
    }
}