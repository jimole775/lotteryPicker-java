package lotteryPickerJava.utils;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.util.Arrays;

public class FileReader {

    File direction = new File("");
    String filePath = direction.getAbsolutePath() + File.separator;
    Callback callback;

    public FileReader(String path) {

        filePath += path;
    }

    // public byte[] read() {
    // return readHandle();
    // }

    public void callbackRegister(Callback thatCallbackFn) {
        callback = thatCallbackFn;
    }

    public void read() {
        callback();
    }

    public void pipe(Object CallbackTarget) {

    }

    private byte[] readHandle() {

        InputStream ins = new FileInputStream(filePath);
        byte wholeData[] = new byte[1024];
        int data = ins.read();
        int byteIndex = 0;
        while (data != -1) {
            wholeData[byteIndex] = (byte) data;
            byteIndex++;
            if (byteIndex >= wholeData.length) {
                wholeData = Arrays.copyOf(wholeData, byteIndex * 2);
            }
            data = ins.read();
        }
        ins.close();

        return wholeData;
    }
}