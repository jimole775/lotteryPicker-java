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
        FileReader fr = new FileReader("db/base/amount.txt");
        fr.callbackRegister(new CallbackIml());
        fr.read();
    }

    public void cbHandle(byte[] data) {
        System.out.println(data);
    }

}
