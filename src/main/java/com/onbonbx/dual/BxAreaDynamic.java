package com.onbonbx.dual;

import java.util.ArrayList;
import java.util.List;

public class BxAreaDynamic extends BxArea {

    // 区域 id
    private byte id;

    // 运行模式
    private byte runMode;
    // 动态区数据超时时间
    private short timeout;
    // 是否与所有节目关联
    private boolean attachToAllPro;
    // 与哪些节目进行关联
    private List<Short> attachedProList = new ArrayList<>();
    // immePlay
    // 是否停止节目而立即播放
    private boolean stopProToPlay = false;
    // 保留字 4bytes
    private byte[] r0 = new byte[4];
    // 区域类型
    private byte type = 0x10;
    // x, y, w, h
    private short x;
    private short y;
    private short w;
    private short h;
    // 是否显示边框
    private boolean frameFlag = false;
    // 背景标志
    private byte background = 0x00;
    // 透明度
    private byte transparent = 0x00;
    // page 页
    List<BxPage> pages = new ArrayList<>();

    public BxAreaDynamic(short x, short y, short w, short h) {
        this.id = 0x00;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public BxAreaDynamic(byte id, short x, short y, short w, short h) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public byte[] build() {

        BxByteArray array = new BxByteArray();
        // 区域 id
        array.add(id);
        // 运行模式
        array.add(runMode);
        // timeout
        array.add(timeout);
        // 是否绑定所有节目
        // 即使此处为0x01, attachedProList 也要发送
        array.add(attachToAllPro);

        // 绑定的节目个数
        array.add((short)attachedProList.size());
        for(int i=0; i<attachedProList.size(); i++) {
            array.add(attachedProList.get(i));
        }

        // 是否立即播放
        array.add(stopProToPlay);

        // r0
        // 4 字节
        array.add(r0);

        // area type
        // 0x10
        array.add(type);

        // x, y, w, h
        array.add(x);
        array.add(y);
        array.add(w);
        array.add(h);

        // 是否显示边框
        // 不显示
        array.add(frameFlag);

        // 背景标志
        array.add(background);

        // 透明度
        array.add(transparent);

        // areaEqual
        // 0x00 - 前后背景相同
        // 0x01 - 前后背景不同
        array.add(0x00);

        // 是否使能语音
        // 0x00
        array.add(false);

        // 5byte 保留字
        for(int i=0; i<5; i++) {
            array.add((byte)0x00);
        }

        // page 页数
        array.add((short)pages.size());

        BxByteArray dataArray = new BxByteArray();
        int dataOffset = 0;
        for(BxPage page : pages) {

            byte[] para = page.buildPara(w, h);
            byte[] data = page.buildData(w, h);

            // 每页的数据长度
            // 4 bytes
            // 4bytes data offset & 4bytes data offset
            array.add(para.length + 8);

            // page 参数
            array.add(para);

            // 数据偏移量
            array.add(dataOffset);
            // 数据长度
            array.add(data.length);

            //
            dataOffset += data.length;
            dataArray.add(data);
        }

        //
        // 将页数据附加到最后
        array.add(dataArray.build());

        //
        return array.build();
    }

    public void addPage(BxPage page) {
        pages.add(page);
    }

    public void clearPage() {
        pages.clear();
    }

    /**
     *  将区域附加到指定的节目
     * @param pid 节目 id
     */
    public void attachToProgram(short pid) {
        attachedProList.add(pid);
    }

    /**
     * 清空绑定的节目列表
     */
    public void clearAttachedProList() {
        attachedProList.clear();
    }

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public byte getRunMode() {
        return runMode;
    }

    public void setRunMode(byte runMode) {
        this.runMode = runMode;
    }

    public short getTimeout() {
        return timeout;
    }

    public void setTimeout(short timeout) {
        this.timeout = timeout;
    }

    public boolean isAttachToAllPro() {
        return attachToAllPro;
    }

    public void setAttachToAllPro(boolean attachToAllPro) {
        this.attachToAllPro = attachToAllPro;
    }

    public boolean isStopProToPlay() {
        return stopProToPlay;
    }

    public void setStopProToPlay(boolean stopProToPlay) {
        this.stopProToPlay = stopProToPlay;
    }

    public short getX() {
        return x;
    }

    public void setX(short x) {
        this.x = x;
    }

    public short getY() {
        return y;
    }

    public void setY(short y) {
        this.y = y;
    }

    public short getW() {
        return w;
    }

    public void setW(short w) {
        this.w = w;
    }

    public short getH() {
        return h;
    }

    public void setH(short h) {
        this.h = h;
    }


}
