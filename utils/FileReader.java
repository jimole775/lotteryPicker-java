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
    private int insByteIndex = 0;
    private ArrayList<Callback> pipeCbRegister = new ArrayList<Callback>();
    private String osName = System.getProperties().getProperty("os.name");
    public FileReader(String path) {    
        File direction = new File("");
        String filePath = direction.getAbsolutePath() + File.separator + path;
        try {
            ins = new FileInputStream(filePath);
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
    }

    @Override
    public void emit(){        
        int data = readByte();

        // 文件读完了，回调最后的方法
        if(data == -1){ 
            return;       
        }

        int cbLen = pipeCbRegister.size();
        for (Callback pipeCb : pipeCbRegister) {

            pipeCb.entries((byte)data);

            cbLen--;
            // pipe组跑完了，来个递归
            if(cbLen == 0){
                emit();
                break;
            }
        }
    }

    public byte[] readLine(){
        int loopIndex = 0;
        int lineLength = 10;
        byte[] aline = new byte[lineLength];
        boolean breakSign = true;
        while(breakSign){
            byte data = readByte();

            // 如果超出了原数组尺寸，重新调整长度
            if(loopIndex == lineLength){
                lineLength = lineLength*3/2 + 1;
                aline = Arrays.copyOf(aline,lineLength);
            }

            // 赋值
            aline[loopIndex ++] = data;

            // 如果遇到换行符，就结束循环
            if(isWindows() && data == 0x0A || !isWindows() && (data == 0x0D || data == 0x0A)){
                loopIndex = 0;
                breakSign = false;
            }
        }
        return aline;
    }

    private byte readByte(){
        int data = -1;
        try {
            data = ins.read();
            insByteIndex ++;
            if(data == -1){
                ins.close();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return (byte)data;
    }

    private boolean isWindows(){
        return osName.contains("Windows");
    }
}