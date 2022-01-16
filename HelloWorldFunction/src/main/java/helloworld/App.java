package helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;

/**
 * Handler for requests to Lambda function.
 */
public class App implements RequestHandler<String, String> {

    public String handleRequest(final String input, final Context context) {
        //byte[] decodeImg = decodeBase64Binary(input);
        try {
            URL imgUrl = new URL(input);
            BufferedImage image = ImageIO.read(imgUrl);
            BufferedImage croppedImg = image.getSubimage(500, 500, 500, 500);
            String encodedImg = encodeBase64Binary(croppedImg);
            return encodedImg;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String();
    }

    private static byte[] decodeBase64Binary(String imageString) {
        byte[] decodeImg = Base64.getDecoder().decode(imageString);
        return decodeImg;
    }

    private static String encodeBase64Binary(BufferedImage croppedImg) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(croppedImg, "jpg", baos);
        byte[] bytes = baos.toByteArray();
        String encodeImg = Base64.getEncoder().encodeToString(bytes);
        return encodeImg;
    }

    private static BufferedImage returnImage(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        BufferedImage bImage = ImageIO.read(bis);
        return bImage;
    }
}
