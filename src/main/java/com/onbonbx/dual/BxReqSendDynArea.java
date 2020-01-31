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


        return new byte[0];
    }
}
