public class ReverseString {
    public static void main(String[] args) {
        System.out.println(new ReverseString().reverseString("abc"));
    }
    public String reverseString(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length / 2; i ++) {
            char tmp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = tmp;
        }
        return new String(array);
    }
}
