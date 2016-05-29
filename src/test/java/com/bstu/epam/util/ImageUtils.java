package com.bstu.epam.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Holger on 12.4.16.
 */
public class ImageUtils {
    public static void screen(WebDriver driver, WebElement element, String imageName) throws IOException {
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        Point p = element.getLocation();

        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();

        BufferedImage img = ImageIO.read(screen);

        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), width,
                height);

        ImageIO.write(dest, "png", screen);

        File f = new File(imageName);

        FileUtils.copyFile(screen, f);
    }

    public static String getMD5(String imageName) throws NoSuchAlgorithmException, FileNotFoundException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        File f = new File(imageName);
        InputStream is = new FileInputStream(f);
        byte[] buffer = new byte[8192];
        int read = 0;
        try {
            while ((read = is.read(buffer)) > 0) {
                digest.update(buffer, 0, read);
            }
            byte[] md5sum = digest.digest();
            BigInteger bigInt = new BigInteger(1, md5sum);
            return bigInt.toString(16);
        } catch (IOException e) {
            throw new RuntimeException("Unable to process file for MD5", e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                throw new RuntimeException("Unable to close input stream for MD5 calculation", e);
            }
        }
    }

    public static boolean compareMd5ByImage(String beforeImage, String afterImage) {
        boolean result = false;

        try {
            result = ImageUtils.getMD5(beforeImage).equals(ImageUtils.getMD5(afterImage));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ImageUtils.deleteImage(beforeImage);
        ImageUtils.deleteImage(afterImage);

        return result;
    }

    public static void deleteImage(String patch) {
        try {

            File file = new File(patch);

            if (file.delete()) {
                System.out.println(file.getName() + " is deleted!");
            } else {
                System.out.println("Delete operation is failed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
