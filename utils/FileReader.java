package lotteryPickerJava.utils;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;

public interface Callback{
    public void entries(byte[] data);
}

public abstract class Stream{
    public void pipeInterface(ArrayList<Callback> cbRegisted){

    };
}

public class FileReader extends Stream{

    File direction = new File("");
    String filePath = direction.getAbsolutePath() + File.separator; 

    public FileReader(String path) {
        filePath += path;
    }

    public byte[] read() {
        return readHandle();
    }

    public FileReader read(Callback cb) {
        byte[] data = readByteHandle();
        cb.entries(data);
        return this;
    }

    public FileReader readLine(Callback cb){
        byte[] data = readLineHandle();
        cb.entries(data);
        return this;
    }

    
    public ArrayList<Callback> callbackRegisted = new ArrayList<Callback>(); 
    // pipe需要存储所有回调，每读取一字节，就循环调用所有回调
    public FileReader pipe(Callback pipeCb){
        byte[] data = readHandle();
        callbackRegisted.push(pipeCb);
        return this;
    }

    @Override
    public void pipeInterface(ArrayList<Callback> cbRegisted) {
        // 从下标0开始执行回调函数
    }

    public void end(Callback pipeEndCb){
        // callbackRegisted;
        pipeInterface(callbackRegisted);
    };

    private byte[] readLineHandle(){
        return new Byte();
    }
    
    private byte[] readByteHandle(){
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