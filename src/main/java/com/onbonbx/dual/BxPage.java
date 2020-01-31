package com.onbonbx.dual;

public abstract class BxPage {

    // 页类型
    private byte style = 0x00;
    // 特技方式
    private byte dispMode = 0x00;
    // 清屏方式
    private byte clearMode = 0x00;
    // 特技速度
    private byte speed = 0x00;
    // 停留时间
    private short holdTime = 100;
    // 重复次数
    private byte repeatTime = 0x01;
    // 有效长度
    private short validLen;
    // 保留字 - 9bytes
    private byte [] r0 = new byte[9];

    public BxPage() {
    }

    /**
     * 生成数据页的参数部分数据
     * @return 数据页的参数数据
     */
    public byte[] buildPara(short w, short h) {

        //
        BxByteArray array = new BxByteArray();
        // page 类型
        array.add((byte)0x00);
        // 显示模式
        array.add(dispMode);
        // clearmode
        array.add(clearMode);
        // 速度等级
        array.add(speed);
        // 停留时间
        array.add(holdTime);
        // 重复次数
        array.add(repeatTime);
        // 有效长度
        array.add(w);
        // 保留字
        array.add(r0);

        // @todo
        // data offset - 4 bytes
        // data length - 4 bytes

        //
        return array.build();
    }

    /**
     * 生成数据页的显示数据
     * @return 数据页的数据
     */
    public abstract byte[] buildData(int w, int h);

    public byte getStyle() {
        return style;
    }

    public void setStyle(byte style) {
        this.style = style;
    }

    public byte getDispMode() {
        return dispMode;
    }

    public void setDispMode(byte dispMode) {
        this.dispMode = dispMode;
    }

    public byte getClearMode() {
        return clearMode;
    }

    public void setClearMode(byte clearMode) {
        this.clearMode = clearMode;
    }

    public byte getSpeed() {
        return speed;
    }

    public void setSpeed(byte speed) {
        this.speed = speed;
    }

    public short getHoldTime() {
        return holdTime;
    }

    public void setHoldTime(short holdTime) {
        this.holdTime = holdTime;
    }

    public short getValidLen() {
        return validLen;
    }

    public void setValidLen(short validLen) {
        this.validLen = validLen;
    }

    public byte[] getR0() {
        return r0;
    }

    public void setR0(byte[] r0) {
        this.r0 = r0;
    }
}
