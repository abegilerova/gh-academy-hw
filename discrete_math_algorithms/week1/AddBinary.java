public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while ( i >= 0 || j >= 0 || carry > 0) {
            int digitA = (i >= 0) ? a.charAt(i) - '0' : 0;
            int digitB = (j >=0)? b.charAt(j) -  '0' : 0;
            int sum = digitA + digitB + carry;
            result.append(sum % 2);
            carry = sum /2;
            j--;
            i--;
        }

       return result.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "11"; String b = "1";
        System.out.println(addBinary(a, b));
    }
}
