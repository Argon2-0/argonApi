package vision2cloud.argon.controller.user.auth;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Decrypt {
    public Decrypt(){}

    public static String desEncrypt(String data) throws Exception {

        try
        {
            String key = "ab4q8g6j5j7o5s63";
            String iv = "8q7d4g86s2f4h26s";

            byte[] encrypted1 = Base64.getDecoder().decode(data);

            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

            byte[] original = cipher.doFinal(encrypted1);
            return new String(original);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
