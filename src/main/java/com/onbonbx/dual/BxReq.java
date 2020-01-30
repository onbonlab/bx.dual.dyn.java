package com.onbonbx.dual;

public abstract class BxReq {

    // 帧头
    private BxFrameHeader header;
    // 是否需要命令返回
    private boolean rtnResp;
    // 命令组
    private byte cmdGrp;
    // 命令字
    private byte cmd;
    // 生成字节流
    public abstract byte[] build();


    public BxReq(BxCmdCode cmdCode) {

        this.cmdGrp = cmdCode.group;
        this.cmd = cmdCode.code;

        //
        header = new BxFrameHeader();
        // 需要返回帧
        rtnResp = true;
    }

    /**
     * 将 Request 命令封装为字节流
     * @return  生成的字节流
     */
    public byte[] pack() {

        BxByteArray array = new BxByteArray();

        // 帧头
        array.add(header.build());

        // 生成数据
        byte[] data = build();

        // 数据长度 = rtn, grp, cmd
        // int
        array.add(data.length + 3);

        // 是否需要返回值
        array.add(rtnResp);
        // 命令组
        array.add(cmdGrp);
        // 命令字
        array.add(cmd);

        // 压入数据
        array.add(data);
        // 数据
        byte[] src = array.build();

        // crc校验
        short crc = BxUtils.CRC16(src, 0, src.length);
        BxByteArray a = new BxByteArray();
        a.add(src);
        a.add(crc);

        // 进行转义封装
        byte[] dst = BxFrameWrapper.wrap(a.build());

        return dst;
    }


}
