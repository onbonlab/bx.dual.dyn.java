package com.onbonbx.dual;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BxPageBmp extends BxPage {

    private BufferedImage image;

    public BxPageBmp(BufferedImage image) {
        this.image = image;
    }

    @Override
    public byte[] buildData(int w, int h) {

        // 缩放图片
        BufferedImage newimg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D gd = newimg.createGraphics();
        gd.drawImage(image, 0, 0, w, h, null);
        gd.dispose();

        // rgb 字节数组
        byte[] data = new byte[w*h*3];

        int offset = 0;
        for(int y=0; y<h; y++) {
            for(int x=0; x<w; x++) {
                int pixel = newimg.getRGB(x, y);
                data[offset++] = (byte) ((pixel >> 16) & 0xff);
                data[offset++] = (byte) ((pixel >> 8) & 0xff);
                data[offset++] = (byte) (pixel & 0xff);
            }
        }

        return data;
    }
}
