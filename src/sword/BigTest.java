package sword;

import java.util.Scanner;

public class BigTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1, s2;
        s1 = sc.next();
        s2 = sc.next();
        StringBuilder result = new StringBuilder();
        s1 = new StringBuilder(s1).reverse().toString();
        s2 = new StringBuilder(s2).reverse().toString();
        int len1 = s1.length(), len2 = s2.length();
        int maxLen = len1 > len2 ? len1 : len2;
        if(len1 < len2) {
            for(int i = len1; i < len2; i++) {
                s1 += "0";
            }
        } else if(len2 < len1) {
            for(int i = len2; i < len1; i++) {
                s2 += "0";
            }
        }

        int carry = 0;
        boolean overFlow = false;

        for(int i = 0; i < maxLen; i++) {
            int sum = Integer.parseInt(s1.charAt(i) + "") + Integer.parseInt(s2.charAt(i) + "") + carry;
            if(sum >= 10) {
                if(i == maxLen - 1) {
                    overFlow = true;
                }
                carry = 1;
                result.append(sum - 10);
            } else {
                carry = 0;
                result.append(sum);
            }
        }

        if(overFlow) {
            result.append(carry);
        }

        System.out.println(result.reverse());
    }
}
