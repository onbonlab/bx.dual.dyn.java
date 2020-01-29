package com.onbonbx.dual;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class BxFrameWrapperTest {

    @Test
    public void wrapTest1() {

        byte[] src = {
                (byte) 0xA5, 0x5A
        };

        byte[] expected = {
                (byte) 0xA5, (byte) 0xA5, (byte) 0xA5, (byte) 0xA5, (byte) 0xA5, (byte) 0xA5, (byte) 0xA5, (byte) 0xA5,
                (byte) 0xA6, 0x02,
                (byte) 0x5B, 0x02,
                0x5a
        };

        // 测试封包
        assertArrayEquals(expected, BxFrameWrapper.wrap(src));

        //
        // 测试解包
        assertArrayEquals(src, BxFrameWrapper.unwrap(expected, expected.length));
    }

    @Test
    public void wrapTest2() {
        byte[] src = {
                (byte) 0xA5, (byte) 0xA6, 0x00, 0x5b, 0x00, 0x5A
        };

        byte[] expected = {
                (byte) 0xA5, (byte) 0xA5, (byte) 0xA5, (byte) 0xA5, (byte) 0xA5, (byte) 0xA5, (byte) 0xA5, (byte) 0xA5,
                (byte) 0xA6, 0x02,
                (byte) 0xA6, 0x01,
                0x00,
                0x5b, 0x01,
                0x00,
                (byte) 0x5B, 0x02,
                0x5a
        };

        //
        assertArrayEquals(expected, BxFrameWrapper.wrap(src));

        //
        // 测试解包
        assertArrayEquals(src, BxFrameWrapper.unwrap(expected, expected.length));
    }
}
