package com.onbonbx.dual;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );


        BufferedImage img = null;
        BufferedImage img2 = null;

        try {
            img = ImageIO.read(new File("e:\\p1.png"));
            img2 = ImageIO.read(new File("e:\\p2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        BxAreaDynamic area = new BxAreaDynamic(0, 64, 0, 64, 64);
        area.clearAttachedProList();
        area.attachToProgram(0);
        area.setAttachToAllPro(false);

        BxPageBmp page = new BxPageBmp(img);
        BxPageBmp p2 = new BxPageBmp(img2);
        area.addPage(page);
        area.addPage(p2);

        BxReq req = new BxReqSendDynArea(area);
        byte[] data = req.pack();
        BxDebugFileWriter.writeToFile(data, "e:\\a.txt");

        //
        // 创建 Socket
        Socket client = new Socket();

        //
        // 创建 socket 地址
        SocketAddress address = new InetSocketAddress("192.168.31.188", 5005);


        try {
            //
            // 建立 TCP 连接
            client.connect(address, 3000);
            //
            // 设置读超时时间
            client.setSoTimeout(3000);

            //
            // 创建输出流
            OutputStream out = client.getOutputStream();

            //
            // 创建输入流
            InputStream in = client.getInputStream();

            //
            /*
            List<Byte> areas = new ArrayList<Byte>();
            areas.add((byte)0x00);
            areas.add((byte)0x03);
            req = new BxReqDelDynAreas(areas);
             */
            byte [] seq = req.pack();


            // 写入数据
            out.write(seq);

            //
            // 回读返回帧
            byte[] resp = new byte[1024];
            int len = in.read(resp);

            //
            out.close();
            in.close();
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
