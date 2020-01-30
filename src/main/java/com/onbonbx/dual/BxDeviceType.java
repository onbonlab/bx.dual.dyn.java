package com.onbonbx.dual;

public enum BxDeviceType {


    //
    // none
    NONE("NONE", 0x0000, BxDeviceType.DEVICE_SERIAL_5G),
    COMMON("COMMON", 0x0001, BxDeviceType.DEVICE_SERIAL_5G),

    //
    // 6Q系列
    BX6Q0("BX-6Q0", 0x0066, BxDeviceType.DEVICE_SERIAL_6Q),
    BX6Q1("BX-6Q1", 0x0166, BxDeviceType.DEVICE_SERIAL_6Q),
    BX6Q2("BX-6Q2", 0x0266, BxDeviceType.DEVICE_SERIAL_6Q),
    BX6Q3("BX-6Q3", 0x0366, BxDeviceType.DEVICE_SERIAL_6Q),
    BX6Q2L("BX-6Q2L", 0x0466, BxDeviceType.DEVICE_SERIAL_6Q),
    BX6Q3L("BX-6Q3L", 0x0566, BxDeviceType.DEVICE_SERIAL_6Q),

    //
    // 6w 系列
    BX6W0("BX-6W0", 0x0064, BxDeviceType.DEVICE_SERIAL_6W),
    BX6W1("BX-6W1", 0x0164, BxDeviceType.DEVICE_SERIAL_6W),
    BX6W2("BX-6W2", 0x0264, BxDeviceType.DEVICE_SERIAL_6W),
    BX6W3("BX-6W3", 0x0364, BxDeviceType.DEVICE_SERIAL_6W),
    BX6W("BX-6W", 0x0464, BxDeviceType.DEVICE_SERIAL_6W),
    BX6WT("BX-6WT", 0x0564, BxDeviceType.DEVICE_SERIAL_6W),

    //
    // 6m 系列
    BX6M0("BX-6M0", 0x0062, BxDeviceType.DEVICE_SERIAL_6M),
    BX6M1("BX-6M1", 0x0162, BxDeviceType.DEVICE_SERIAL_6M),
    BX6M2("BX-6M2", 0x0262, BxDeviceType.DEVICE_SERIAL_6M),
    BX6M3("BX-6M3", 0x0362, BxDeviceType.DEVICE_SERIAL_6M),
    BX6M("BX-6M", 0x0462, BxDeviceType.DEVICE_SERIAL_6M),
    BX6MT("BX-6MT", 0x0562, BxDeviceType.DEVICE_SERIAL_6M),


    BX6M0YY("BX-6M0-YY", 0x1062, BxDeviceType.DEVICE_SERIAL_6M),
    BX6M1YY("BX-6M1-YY", 0x1162, BxDeviceType.DEVICE_SERIAL_6M),
    BX6M2YY("BX-6M2-YY", 0x1262, BxDeviceType.DEVICE_SERIAL_6M),
    BX6M3YY("BX-6M3-YY", 0x1362, BxDeviceType.DEVICE_SERIAL_6M),
    BX6MYY("BX-6M-YY", 0x1462, BxDeviceType.DEVICE_SERIAL_6M),

    BX6X1("BX-6X1", 0x2162, BxDeviceType.DEVICE_SERIAL_6M),
    BX6X2("BX-6X2", 0x2262, BxDeviceType.DEVICE_SERIAL_6M),
    BX6X3("BX-6X3", 0x2362, BxDeviceType.DEVICE_SERIAL_6M),

    BX6U0("BX-6U0", 0x0063, BxDeviceType.DEVICE_SERIAL_6M),
    BX6U1("BX-6U1", 0x0163, BxDeviceType.DEVICE_SERIAL_6M),
    BX6U2("BX-6U2", 0x0263, BxDeviceType.DEVICE_SERIAL_6M),
    BX6U3("BX-6U3", 0x0363, BxDeviceType.DEVICE_SERIAL_6M),
    BX6U("BX-6U", 0x0463, BxDeviceType.DEVICE_SERIAL_6M),
    BX6UT("BX-6U2", 0x0563, BxDeviceType.DEVICE_SERIAL_6M),

    //
    // 6A
    BX6A0("BX-6A0", 0x2063, BxDeviceType.DEVICE_SERIAL_6M),
    BX6A1("BX-6A1", 0x2163, BxDeviceType.DEVICE_SERIAL_6M),
    BX6A2("BX-6A2", 0x2263, BxDeviceType.DEVICE_SERIAL_6M),
    BX6A3("BX-6A3", 0x2363, BxDeviceType.DEVICE_SERIAL_6M),
    BX6A("BX-6A", 0x2463, BxDeviceType.DEVICE_SERIAL_6M),

    BX6A0YY("BX-6A0YY", 0x3063, BxDeviceType.DEVICE_SERIAL_6M),
    BX6A1YY("BX-6A1YY", 0x3163, BxDeviceType.DEVICE_SERIAL_6M),
    BX6A2YY("BX-6A2YY", 0x3263, BxDeviceType.DEVICE_SERIAL_6M),
    BX6A3YY("BX-6A3YY", 0x3363, BxDeviceType.DEVICE_SERIAL_6M),
    BX6AYY("BX-6AYY", 0x3463, BxDeviceType.DEVICE_SERIAL_6M),

    //
    // 6E
    BX6E1("BX-6E1", 0x0174, BxDeviceType.DEVICE_SERIAL_6E),
    BX6E2("BX-6E2", 0x0274, BxDeviceType.DEVICE_SERIAL_6E),
    BX6E3("BX-6E3", 0x0374, BxDeviceType.DEVICE_SERIAL_6E),
    BX6E1X("BX-6E1X", 0x0474, BxDeviceType.DEVICE_SERIAL_6EX),
    BX6E2X("BX-6E2X", 0x0574, BxDeviceType.DEVICE_SERIAL_6EX),


    //
    // 五代控制器
    BX5A("BX-5A", 0x0951, BxDeviceType.DEVICE_SERIAL_5G),
    BX5A1("BX-5A1", 0x0251, BxDeviceType.DEVICE_SERIAL_5G),
    BX5A3("BX-5A3", 0x0451, BxDeviceType.DEVICE_SERIAL_5G),
    BX5A4("BX-5A4", 0x0551, BxDeviceType.DEVICE_SERIAL_5G),

    BX5ATWIFI("BX-5AT-WIFI", 0x1651, BxDeviceType.DEVICE_SERIAL_5G),
    BX5A0WIFI("BX-5A0-WIFI", 0x2251, BxDeviceType.DEVICE_SERIAL_5G),
    BX5A1WIFI("BX-5A1-WIFI", 0x0651, BxDeviceType.DEVICE_SERIAL_5G),
    BX5A2WIFI("BX-5A2-WIFI", 0x0751, BxDeviceType.DEVICE_SERIAL_5G),
    BX5A4WIFI("BX-5A4-WIFI", 0x0851, BxDeviceType.DEVICE_SERIAL_5G),

    //
    // 5E系列
    BX5E1("BX-5E1", 0x0154, BxDeviceType.DEVICE_SERIAL_5E),
    BX5E2("BX-5E2", 0x0254, BxDeviceType.DEVICE_SERIAL_5E),
    BX5E3("BX-5E3", 0x0354, BxDeviceType.DEVICE_SERIAL_5E),

    //
    // 5M系列
    BX5M1("BX-5M1", 0x0052, BxDeviceType.DEVICE_SERIAL_5G),
    BX5M1X("BX-5M1X", 0x0152, BxDeviceType.DEVICE_SERIAL_5G),
    BX5M2("BX-5M2", 0x0252, BxDeviceType.DEVICE_SERIAL_5G),
    BX5M3("BX-5M3", 0x0352, BxDeviceType.DEVICE_SERIAL_5G),
    BX5M4("BX-5M4", 0x0452, BxDeviceType.DEVICE_SERIAL_5G),
    BX5MT("BX-5MT", 0x0552, BxDeviceType.DEVICE_SERIAL_5G),

    //
    // 5U
    BX5UT("BX-5UT", 0x0055, BxDeviceType.DEVICE_SERIAL_5G),
    BX5U0("BX-5U0", 0x0155, BxDeviceType.DEVICE_SERIAL_5G),
    BX5U1("BX-5U1", 0x0255, BxDeviceType.DEVICE_SERIAL_5G),
    BX5U2("BX-5U2", 0x0355, BxDeviceType.DEVICE_SERIAL_5G),
    BX5U3("BX-5U3", 0x0455, BxDeviceType.DEVICE_SERIAL_5G),
    BX5U4("BX-5U4", 0x0555, BxDeviceType.DEVICE_SERIAL_5G),
    BX5U5("BX-5U5", 0x0655, BxDeviceType.DEVICE_SERIAL_5G),
    BX5U("BX-5U", 0x0755, BxDeviceType.DEVICE_SERIAL_5G),
    BX5UL("BX-5UL", 0x0855, BxDeviceType.DEVICE_SERIAL_5G),

    //
    // xw 系列
    XW2L("X-W2L", 0x015e, BxDeviceType.DEVICE_SERIAL_XW),
    XW2("X-W2", 0x025e, BxDeviceType.DEVICE_SERIAL_XW),
    XW3L("X-W3L", 0x035e, BxDeviceType.DEVICE_SERIAL_XW),
    XW3("X-W3", 0x045e, BxDeviceType.DEVICE_SERIAL_XW),
    XW4L("X-W4L", 0x055e, BxDeviceType.DEVICE_SERIAL_XW),
    XW4("X-W4", 0x065e, BxDeviceType.DEVICE_SERIAL_XW),
    XW16("X-W16", 0x075e, BxDeviceType.DEVICE_SERIAL_XW),

    //
    // xu 系列
    XU2L("X-U2L", 0x015f, BxDeviceType.DEVICE_SERIAL_5G),
    XU2("X-U2", 0x025f, BxDeviceType.DEVICE_SERIAL_5G),
    XU3L("X-U3L", 0x035f, BxDeviceType.DEVICE_SERIAL_5G),
    XU3("X-U3", 0x045f, BxDeviceType.DEVICE_SERIAL_5G),
    XU4L("X-U4L", 0x055f, BxDeviceType.DEVICE_SERIAL_5G),
    XU4("X-XU4", 0x065f, BxDeviceType.DEVICE_SERIAL_5G);


    //
    // device serial
    public static final int DEVICE_SERIAL_5G    =   0x00;
    public static final int DEVICE_SERIAL_5Q    =   0x01;
    public static final int DEVICE_SERIAL_5E    =   0x02;
    public static final int DEVICE_SERIAL_XW    =   0x03;
    public static final int DEVICE_SERIAL_6M    =   0x10;
    public static final int DEVICE_SERIAL_6Q    =   0x11;
    public static final int DEVICE_SERIAL_6W    =   0x12;
    public static final int DEVICE_SERIAL_6E    =   0x13;
    public static final int DEVICE_SERIAL_6EX   =   0x14;

    //
    // controller name
    private String name;

    //
    // code
    private int code;

    //
    // serial
    private int serial;


    BxDeviceType(String name, int code, int serial) {
        this.name = name;
        this.code = code;
        this.serial = serial;
    }

    //
    public static BxDeviceType fromDeviceCode(int code) {
        for(BxDeviceType type : BxDeviceType.values()) {
            if(type.getCode() == code) {
                return type;
            }
        }

        return NONE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }
}
