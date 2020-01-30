package com.onbonbx.dual;

public class BxReqDelDynAll extends BxReq {


    public BxReqDelDynAll() {
        super(BxCmdCode.CMD_DEL_DYNC_AREA);
    }

    @Override
    public byte[] build() {
        BxByteArray array = new BxByteArray();
        // 2 reserved bytes
        for(int i=0; i<2; i++) {
            array.add((byte)0x00);
        }

        // delete all areas
        array.add((byte)0xff);
        return array.build();
    }
}
