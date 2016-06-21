package el.utils;

import java.math.BigInteger;

public class ByteUtils {
    public static int unsigned(byte b) {
        return b & 0xFF;
    }

    public static int nex2(byte[] data, int start) {
        return ((data[start + 1] & 0xFF) << 8) | (data[start] & 0xFF);
    }

    public static int nex4(byte[] data, int start) {
        return
                (data[start + 3] & 0xFF) << 24 |
                (data[start + 2] & 0xFF) << 16 |
                (data[start + 1] & 0xFF) << 8  |
                data[start] & 0xFF;
    }

    public static int find(byte[] bytes, int start, int value) {
        int index = start;
        while(index < bytes.length && bytes[index] != value) {
            index++;
        }
        return index == bytes.length ? -1 : index;
    }

    public static byte[] hexStringToByteArray(String string) {
        int len = string.length();
        if ( len % 2 != 0 ) {
            len++;
            string = "0" + string;
        }

        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(string.charAt(i), 16) << 4)
                    + Character.digit(string.charAt(i+1), 16));
        }
        return data;
    }

    public static String byteArrayToHexString(byte[] b) {
        String hex = new BigInteger(1, b).toString(16);
        hex = StringUtils.leftPad(hex, b.length*2, "0");
        return hex;
    }



}
