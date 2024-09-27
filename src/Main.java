public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String bracketString) {
        int count = 0;
        for (int i = 0; i < bracketString.length(); i++) {
            char c = bracketString.charAt(i);
            if (i + 1 == bracketString.length() && c == '(') {
                return false;
            } else if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count <= 0) {
                    return false;
                }
                count--;
            }
        }
        return true;
    }

    // 2. reverseInteger
    public static String reverseInteger(int a) {
        String intString = Integer.toString(a);
        String reversed = "";
        for (int i = intString.length() - 1; i >= 0; i--) {
            reversed += intString.charAt(i);
        }
        return reversed;
    }

    // 3. encryptThis
    public static String encryptThis(String code) {
        String[] words = code.split(" ");
        StringBuilder encrypted = new StringBuilder();

        for (String word : words) {
            char firstChar = word.charAt(0);
            String encryptedWord = (int) firstChar + "";

            if (word.length() > 2) {
                encryptedWord += word.charAt(word.length() - 1);
                encryptedWord += word.substring(2, word.length() - 1);
                encryptedWord += word.charAt(1);
            }

            else if (word.length() == 2) {
                encryptedWord += word.charAt(1);
            }

            encrypted.append(encryptedWord).append(" ");
        }

        return encrypted.toString().trim();
    }

    // 4. decipherThis
    public static String decipherThis(String codeText) {
        String[] words = codeText.split(" ");
        String result = "";
        for (String word : words) {
            String newWord = "";
            String charCode = "";
            int i = 0;

            while (i < word.length() && Character.isDigit(word.charAt(i))) {
                charCode += word.charAt(i);
                i++;
            }

            newWord += (char) Integer.parseInt(charCode);

            if (word.length()-i > 1) {
                char secondChar = word.charAt(word.length() - 1);
                String middlePart = word.substring(i + 1, word.length() - 1);
                newWord += secondChar + middlePart + word.charAt(i);
            }

            else if ((word.length()-i) == 1) {
                newWord += word.charAt(i);
            }

            result += newWord + " ";
        }
        
        return result.trim();
    }
}
