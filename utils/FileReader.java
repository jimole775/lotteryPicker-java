package lotteryPickerJava.utils;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;

public class FileReader implements Pipe{
    InputStream ins;
    int insByteIndex = 0; 
    ArrayList<Callback> pipeCbRegisted = new ArrayList<Callback>(); 

    public FileReader(String path) {    
        File direction = new File("");
        String filePath = direction.getAbsolutePath() + File.separator;        
        ins = new FileInputStream(filePath += path);
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

    // pipe需要存储所有回调，每读取一字节，就循环调用所有回调
    @Override
    public FileReader pipe(Callback pipeCb){
        pipeCbRegisted.add(pipeCb);
        return this;
    }

    // end算是pipe触发器
    @Override
    public void end(Callback pipeEndCb){
        emit();
        pipeEndCb.entries((byte)-1);
    };

    @Override
    public void emit(){        
        int data = readByte();
        // 文件读完了，回调最后的方法
        if(data == -1){ 
            return;       
        }

        int cbLen = pipeCbRegisted.size();
        for (Callback pipeCb : pipeCbRegisted) {    

            pipeCb.entries((byte)data);

            // pipe组跑完了，来个递归
            if(cbLen == 0){
                emit();
                break;
            }

            cbLen--;
        }

    }

    // private byte[] readLineHandle(){
    //     byte[] line = new byte[10];
    //     insByteIndex ++;
    //     return new Byte();
    // }
    
    private int readByte(){
        int data = null;
        try {            
            data = ins.read();
            if(data == -1){
                ins.close();
            } 
        } catch (Exception e) {
            System.err.println(e);
        }           
        return data; 
    }
}