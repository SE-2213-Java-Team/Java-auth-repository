package hasher;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class Hasher {
    public static String hashPassword(String text) {
        String hashPass = text.substring(0, 0);
        String hashedPassword = null;
        try {
            MessageDigest mdh = MessageDigest.getInstance("MD5");
            mdh.update(hashPass.getBytes());
            byte[] bytes = mdh.digest();
            StringBuilder sbh = new StringBuilder();
            for(int i = 0; i < bytes.length; i++){
                sbh.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashedPassword = sbh.toString();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return hashedPassword;
    }
}
