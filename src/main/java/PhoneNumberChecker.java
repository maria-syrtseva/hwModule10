import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PhoneNumberChecker {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
        String phone;

        while ((phone = reader.readLine()) != null) {
            if (isValidPhoneNumber(phone)) {
                System.out.println("Phone number is valid");
            }
        }
        reader.close();
    }

    public static boolean isValidPhoneNumber(String phone) {

        if (phone.length() == 14 && phone.charAt(0) == '(' && phone.charAt(4) == ')' && phone.charAt(5) == ' '
                && phone.charAt(9) == '-') {

            if (isDigitSequence(phone.substring(1, 4)) && isDigitSequence(phone.substring(6, 9)) &&
                    isDigitSequence(phone.substring(10, 14))) {
                return true;
            }
        }

        if (phone.length() == 12 && phone.charAt(3) == '-' && phone.charAt(7) == '-') {

            if (isDigitSequence(phone.substring(0, 3)) && isDigitSequence(phone.substring(4, 7)) &&
                    isDigitSequence(phone.substring(8, 12))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDigitSequence(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

}
