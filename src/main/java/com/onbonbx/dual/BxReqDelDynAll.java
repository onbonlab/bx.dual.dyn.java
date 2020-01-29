package com.onbonbx.dual;

public class BxReqDelDynAll extends BxReq {


    public BxReqDelDynAll() {
        super(BxCmdCode.CMD_DEL_DYNC_AREA);
    }

    @Override
    public byte[] build() {
        BxByteArray array = new BxByteArray();
        array.add((byte)0xff);
        return array.build();
    }
}
