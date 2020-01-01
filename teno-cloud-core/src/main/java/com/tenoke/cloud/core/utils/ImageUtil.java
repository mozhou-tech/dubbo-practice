package com.tenoke.cloud.core.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author jerrylau
 */
public class ImageUtil {

    /**
     * 修改图片大小
     *
     * @param prevImage
     * @param size
     * @return
     * @throws IOException
     */
    public static BufferedImage resizeImage(BufferedImage prevImage, int size) throws IOException {
        double width = prevImage.getWidth();
        double height = prevImage.getHeight();
        double percent = size / width;
        int newWidth = (int) (width * percent);
        int newHeight = (int) (height * percent);
        BufferedImage image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_BGR);
        Graphics graphics = image.createGraphics();
        graphics.drawImage(prevImage, 0, 0, newWidth, newHeight, null);
        return image;
    }

}
