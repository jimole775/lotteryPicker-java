import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.util.Arrays;
public class Main{
    public static void main(String[] args) {
        File direction = new File("");
        String filePath = direction.getAbsolutePath() + File.separator + "db/base/amount.txt";
        try {
            
            InputStream ins = new FileInputStream(filePath);
            int data = ins.read();
            byte dataArray[] = new byte[24];
            int index = 0;
            while(data != -1){
                dataArray[index] = (byte) data;
                index ++;
                if(index >= dataArray.length){
                    index = 0;
                    // dataArray = Arrays.copyOf(dataArray,index + dataArray.length);
                    System.out.println(new String(dataArray));    
                }
                data = ins.read();      
            }
        
        ins.close();
      
        } catch (Exception e) {
            System.out.println(e);
            //TODO: handle exception
        }
    }
}
