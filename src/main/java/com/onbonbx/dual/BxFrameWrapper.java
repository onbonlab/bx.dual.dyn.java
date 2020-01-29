package com.onbonbx.dual;

/**
 *
 */
public class BxFrameWrapper {

    // 帧头 0xA5 的个数
    private static final int WRAP_A5_NUM = 8;
    // 帧尾 0x5A 的个数
    private static final int WRAP_5A_NUM = 1;

    /**
     * 对数据帧进行转义封包
     * @param src   原始数据
     * @return 转义后的数据
     */
    public static byte[] wrap(byte[] src) {


        int len = 0;

        len = src.length;

        for(byte d : src) {
            if((d == (byte)0xa5) || (d == (byte)0x5a) || (d == (byte)0xa6) || (d == (byte)0x5b)) {
                len++;
            }
        }

        //
        // 加上帧头和帧尾的A5,5A
        //len += 2;
        len += WRAP_5A_NUM;
        len += WRAP_A5_NUM;


        //
        // 开始转义
        byte[] dst;
        dst = new byte[len];

        int offset = 0;

        //
        // 帧头
        for(int i=0; i<WRAP_A5_NUM; i++){
            dst[offset++] = (byte) 0xa5;
        }


        for(byte data : src) {
            if(data == (byte)0xa5) {
                dst[offset++] = (byte) 0xa6;
                dst[offset++] = 0x02;
            }
            else if(data == (byte)0xa6) {
                dst[offset++] = (byte) 0xa6;
                dst[offset++] = 0x01;
            }
            else if(data == 0x5a) {
                dst[offset++] = 0x5b;
                dst[offset++] = 0x02;
            }
            else if(data == 0x5b) {
                dst[offset++] = 0x5b;
                dst[offset++] = 0x01;
            }
            else{
                dst[offset++] = data;
            }
        }

        // 帧尾
        for(int i=0; i<WRAP_5A_NUM; i++){
            dst[offset++] = 0x5a;
        }

        //
        return dst;
    }

    /**
     * 对数据包进行反转义
     * @param src       已转义的源数据包
     * @param length    有效数据的长度
     * @return 去转义后的数据包
     */
    public static byte[] unwrap(byte[] src, int length) {

        int len = 0;

        if(length == 0)
            len = 0;

        if(src[0] != (byte)0xa5)
            len = 0;

        if(src[length-1] != (byte)0x5a)
            len = 0;

        len = length;

        for(byte d : src) {
            if((d == (byte)0xa5) || (d == (byte)0x5a) || (d == (byte)0xa6) || (d == (byte)0x5b)) {
                len--;
            }
        }

        byte[] dst;

        //
        // 如果计算的帧长度为0，说明数据不正确
        if(len == 0)
            return null;

        dst = new byte[len];

        int offset = 0;
        for(int i=0; i<length; ) {

            if((src[i] == (byte)0xa5) || (src[i] == 0x5a)) {
                i++;
            }
            else if(src[i] == (byte)0xa6) {
                if(src[i+1] == 0x01) {
                    dst[offset++] = (byte)0xa6;
                    i = i+2;
                }
                else if(src[i+1] == 0x02) {
                    dst[offset++] = (byte)0xa5;
                    i = i+2;
                }
                else
                    return null;
            }

            else if(src[i] == 0x5b) {
                if(src[i+1] == 0x01) {
                    dst[offset++] = (byte)0x5b;
                    i = i+2;
                }
                else if(src[i+1] == 0x02) {
                    dst[offset++] = (byte)0x5a;
                    i = i+2;
                }
                else
                    return null;
            }

            else {
                dst[offset++] = src[i++];
            }
        }


        return dst;
    }
}
