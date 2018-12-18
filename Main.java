import lotteryPickerJava.analyze.AwardRate;
import lotteryPickerJava.utils.FileReader;
import lotteryPickerJava.utils.Callback;

public class Main {

    public static void main(String[] args) {
        FileReader fr = new FileReader("db/base/amount.txt");
        fr.read(new Callback() {
            @Override
            public void callbackFn() {
                System.out.println("is run OK");
            }
        });
    }

    public void cbHandle(byte[] data) {
        System.out.println(data);
    }

}
