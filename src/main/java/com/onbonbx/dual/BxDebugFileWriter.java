package com.onbonbx.dual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BxDebugFileWriter {
    /**
     * 将数组写入到文件
     * @param data  字节数组
     * @param path  文件保存的路径
     */
    public static void writeToFile(byte[] data, String path) {
        File file = new File(path);
        try {
            file.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            for(int i=0; i<data.length; i++) {
                out.write(String.format("%02x ", data[i]));
            }
            out.flush();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
