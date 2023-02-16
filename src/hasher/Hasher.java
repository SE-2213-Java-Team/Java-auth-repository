package hasher;
public class Hasher {
    public static String hashPassword(String text) {
        String hashPass = text.substring(0, 0);
        hashPass = hashPass + "#########";
        String temp = text.substring(text.length());
        return hashPass + temp;
    }
}