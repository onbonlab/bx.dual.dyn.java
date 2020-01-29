package com.onbonbx.dual;

import java.util.ArrayList;
import java.util.List;

public class BxReqDelDynAreas extends BxReq {

    // 要删除的区域 id
    private List<Byte> areaIds;

    public BxReqDelDynAreas() {
        super(BxCmdCode.CMD_DEL_DYNC_AREA);
        areaIds = new ArrayList<>();
    }

    public BxReqDelDynAreas(List<Byte> areaIds) {
        super(BxCmdCode.CMD_DEL_DYNC_AREA);
        this.areaIds = areaIds;
    }

    @Override
    public byte[] build() {
        //
        BxByteArray array = new BxByteArray();

        // reserved
        // 2bytes
        for(int i=0; i<2; i++) {
            array.add((byte)0x00);
        }

        // area numbers
        array.add((byte)areaIds.size());

        // area ids
        for(Byte id : areaIds) {
            array.add((byte)id);
        }

        return array.build();
    }
}
