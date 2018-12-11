import lotteryPickerJava.analyze.AwardRate;
import lotteryPickerJava.utils.FileReader;

class CallbackIml implements Callback {
    public void callbackRegister() {

    }

    public void callbackFn() {
        System.out.println("is run success");
    }
}

public class Main {

    public static void main(String[] args) {
<<<<<<< HEAD
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
                    // System.out.println(new String(dataArray));

                }
                data = ins.read();      
            }
        
        ins.close();
      
        } catch (Exception e) {
            System.out.println(e);
            //TODO: handle exception
        }
=======
        FileReader fr = new FileReader("db/base/amount.txt");
        fr.callbackRegister(new CallbackIml());
        fr.read();
    }

    public void cbHandle(byte[] data) {
        System.out.println(data);
>>>>>>> 58c4d5013d7040b0186082ae8371be5c98fa9ba6
    }

}
