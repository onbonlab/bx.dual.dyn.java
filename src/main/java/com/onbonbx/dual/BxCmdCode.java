package com.onbonbx.dual;

/**
 *
 */
public enum  BxCmdCode {

    CMD_ACK("ack", (byte)0xa0, (byte)0x00),
    CMD_NACK("nack", (byte)0xa0, (byte)0x01),
    CMD_DEL_DYNC_AREA("Delete dynamic areas", (byte)0xa7, (byte)0x01),
    CMD_SEND_DYNC_AREA("send dynamic area", (byte)0xa7, (byte)0x00);


    public byte group;
    public byte code;
    public String name;

    BxCmdCode(String name, byte group, byte code) {
        this.name = name;
        this.group = group;
        this.code = code;
    }

    BxCmdCode(byte group, byte code) {
        this.group = group;
        this.code = code;
    }
}
