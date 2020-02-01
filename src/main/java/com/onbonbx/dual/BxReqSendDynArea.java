package com.onbonbx.dual;

public class BxReqSendDynArea extends BxReq {


    private BxAreaDynamic area;

    public BxReqSendDynArea(BxAreaDynamic area) {
        super(BxCmdCode.CMD_SEND_DYNC_AREA);
        this.area = area;
    }

    @Override
    public byte[] build() {
        BxByteArray array = new BxByteArray();

        // reserved
        // 2bytes
        for(int i=0; i<2; i++) {
            array.add((byte)0x00);
        }

        // area number
        // 固定为 0x01
        array.add((short)0x01);

        //
        BxData bd = area.build();

        // 数据长度
        array.add(bd.para.length);

        // 参数
        array.add(bd.para);

        // 数据
        array.add(bd.data);

        // 返回参数
        return array.build();
    }
}
