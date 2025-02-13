import java.util.Random;

public class CaptchaGenerator {
    public static String generateCaptcha() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder captcha = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 6; i++) { // 6-character CAPTCHA
            captcha.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return captcha.toString();
    }
}


