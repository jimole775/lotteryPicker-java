import lotteryPickerJava.analyze.AwardRate;
import lotteryPickerJava.utils.FileReader;
import lotteryPickerJava.utils.Callback;

public class Main {
    public static void main(String[] args) {
        FileReader fr = new FileReader("db/base/amount.txt");
        fr.read(new CallBack(){
            public void init(){
                System.out.println("is run success");
            }
        });
    }

    public void cbHandle(byte[] data) {
        System.out.println(data);
    }

}
