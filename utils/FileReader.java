package utils;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;

public class FileReader implements Pipe{
    private InputStream ins;
    int insByteIndex = 0;
    private ArrayList<Callback> pipeCbRegister = new ArrayList<Callback>();

    public FileReader(String path) {    
        File direction = new File("");
        String filePath = direction.getAbsolutePath() + File.separator;
        try {
            ins = new FileInputStream(filePath += path);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

  /*  public byte[] read() {
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
    }*/

    // pipe需要存储所有回调，每读取一字节，就循环调用所有回调
    @Override
    public FileReader pipe(Callback pipeCb){
        pipeCbRegister.add(pipeCb);
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

        int cbLen = pipeCbRegister.size();
        for (Callback pipeCb : pipeCbRegister) {

            insByteIndex ++;
            System.out.println(insByteIndex);
            pipeCb.entries((byte)data);

            cbLen--;
            // pipe组跑完了，来个递归
            if(cbLen == 0){
                emit();
                break;
            }

        }

    }

    // private byte[] readLineHandle(){
    //     byte[] line = new byte[10];
    //     insByteIndex ++;
    //     return new Byte();
    // }
    
    private int readByte(){
        int data = -1;
        try {
            data = ins.read();
            if(data == -1){
                ins.close();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return data; 
    }
}