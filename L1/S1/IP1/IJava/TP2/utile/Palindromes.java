public class Palindromes {

    public static String reverse(String str) {
        char[] reverse_str_char = str.toCharArray();
        String reverse_str = "";
        
        for (char i : reverse_str_char) {
            reverse_str = i + reverse_str;
        } 
        return (reverse_str);
    }
    public static boolean Palindrome(String str) {
        return (str.equals(reverse(str)));
    }

    public static boolean Palindrome_bis(String str) {
        char[] str_char_arr = str.toCharArray();
        char[] reverse_str_char_arr = reverse(str).toCharArray();

        for (int i = 0; i < str.length(); i++) {
            if (str_char_arr[i] != reverse_str_char_arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(Palindrome("radar"));
        System.out.println(Palindrome_bis("radar"));
    
    }
}
