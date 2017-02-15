package general.utils;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.ashot.AShot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Screenshots {

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] makeScreenshot(String testName) {
        try {
            BufferedImage image = new AShot().takeScreenshot(Driver.getInstance().getDriver()).getImage();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "png", byteArrayOutputStream);
            byteArrayOutputStream.flush();
            byte[] imageInByte = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return imageInByte;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Attachment Content Empty, can't create screenshot".getBytes();
    }
}
