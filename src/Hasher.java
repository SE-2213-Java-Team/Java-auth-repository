package hasher;
public class Hasher {
    public static String hashString(String text) {
        String hashedText = text.substring(0, 0);
        hashedText = hashedText + "#################";
        String temp = text.substring(text.length());
        return hashedText + temp;
    }
}