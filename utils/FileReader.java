package lotteryPickerJava.utils;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.util.Arrays;

public interface Callback{
    public void entries(byte[] data);
}

public class FileReader{

    File direction = new File("");
    String filePath = direction.getAbsolutePath() + File.separator;

    public FileReader(String path) {

        filePath += path;
    }

    public byte[] read() {
        return readHandle();
    }

    public void read(Callback cb) {
        byte[] data = readHandle();
        cb.entries(data);
    }
    
    private byte[] readHandle(){
        byte[] wholeData = new byte[512];
        try {            
        InputStream ins = new FileInputStream(filePath);
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
        } catch (Exception e) {
            System.err.println(e);
        }    
        return wholeData;
    }
}