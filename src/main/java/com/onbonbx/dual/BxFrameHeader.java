package com.onbonbx.dual;

public class BxFrameHeader {

    // 目标地址
    private short dstAddr = (short) 0xfffe;
    // 源地址
    private short srcAddr = (short) 0x8000;
    // 协议版本
    private byte protocolVer = 0x10;
    // 保留字
    private byte r0 = 0x00;
    // 控制器型号
    private short deviceType = (short) 0xfffe;
    // 保留字
    private byte[] r1;
    // 数据长度
    private int dataLen;

    public BxFrameHeader() {

        //

        // 4个字节的保留字
        r1 = new byte[4];
        for(int i=0; i<4; i++) {
            r1[i] = 0x00;
        }
    }

    public byte[] build() {

        BxByteArray array = new BxByteArray();

        //
        // 目标地址
        array.add(dstAddr);

        // 源地址
        array.add(srcAddr);

        // 协议版本号
        array.add(protocolVer);

        // 保留字
        array.add(r0);

        // 控制器型号
        array.add(deviceType);

        // 保留字
        array.add(r1);

        return array.build();
    }

    public short getDstAddr() {
        return dstAddr;
    }

    public void setDstAddr(short dstAddr) {
        this.dstAddr = dstAddr;
    }

    public short getSrcAddr() {
        return srcAddr;
    }

    public void setSrcAddr(short srcAddr) {
        this.srcAddr = srcAddr;
    }

    public byte getProtocolVer() {
        return protocolVer;
    }

    public void setProtocolVer(byte protocolVer) {
        this.protocolVer = protocolVer;
    }

    public byte getR0() {
        return r0;
    }

    public void setR0(byte r0) {
        this.r0 = r0;
    }

    public short getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(short deviceType) {
        this.deviceType = deviceType;
    }

    public byte[] getR1() {
        return r1;
    }

    public void setR1(byte[] r1) {
        this.r1 = r1;
    }

    public int getDataLen() {
        return dataLen;
    }

    public void setDataLen(int dataLen) {
        this.dataLen = dataLen;
    }
}