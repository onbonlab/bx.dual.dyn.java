package com.onbonbx.dual;

import sun.awt.image.OffScreenImage;

import java.util.List;

public class BxResp {

    // 最小的帧长度
    // 16 + 9 + 2
    private static final int FRAME_LEN_MIN = 27;

    //
    private BxFrameHeader header = new BxFrameHeader();

    //
    // r0 - 1byte
    private byte r0;

    // cmd group
    private byte grp;

    // cmd code
    private byte cmd;

    // status
    private short status;

    // error id
    private short error;

    // data
    private byte[] data;

    /**
     * 从字节流中解析 BxResp 对象
     * @param idata 字节流
     * @return BxResp 对象
     */
    public static BxResp parse(byte[] idata, int len) {

        // 将数据反转义
        byte[] unwrapData = BxFrameWrapper.unwrap(idata, len);

        // 数据长度
        if(len < FRAME_LEN_MIN) {
            return null;
        }

        // 数据 crc
        short crcCal = BxUtils.CRC16(unwrapData, 0, unwrapData.length-2);
        short crc = BxUtils.bytesToShort(unwrapData, unwrapData.length-2, BxUtils.ENDIAN.LITTLE);
        if(crc != crcCal) {
            return null;
        }

        // 解析帧头
        BxResp resp = new BxResp();
        resp.header = BxFrameHeader.parse(unwrapData, 0);

        int offset = 16;
        // r0
        resp.r0 = unwrapData[offset++];

        // cmd grp
        resp.grp = unwrapData[offset++];

        // cmd code
        resp.cmd = unwrapData[offset++];

        // status
        resp.status = BxUtils.bytesToShort(unwrapData, offset, BxUtils.ENDIAN.LITTLE);
        offset += 2;

        // error
        resp.error = BxUtils.bytesToShort(unwrapData, offset, BxUtils.ENDIAN.LITTLE);
        offset += 2;

        // datalen
        int datalen = BxUtils.bytesToShort(unwrapData, offset, BxUtils.ENDIAN.LITTLE);
        offset += 2;

        resp.data = new byte[datalen];
        for(int i=0; i<datalen; i++) {
            resp.data[i] = unwrapData[offset++];
        }

        return resp;
    }

    /**
     * 确认当前 response 是否为 Ack
     * @return
     */
    public boolean isAck () {
        if((grp == BxCmdCode.CMD_ACK.group) && (cmd == BxCmdCode.CMD_ACK.code)) {
            return true;
        }
        else {
            return false;
        }
    }

    public BxFrameHeader getHeader() {
        return header;
    }

    public byte getR0() {
        return r0;
    }

    public byte getGrp() {
        return grp;
    }

    public byte getCmd() {
        return cmd;
    }

    public short getStatus() {
        return status;
    }

    public short getError() {
        return error;
    }

    public byte[] getData() {
        return data;
    }
}
