import lotteryPickerJava.analyze.AwardRate;
// import lotteryPickerJava.utils.FileReader;
// import lotteryPickerJava.utils.Callback;
// import lotteryPickerJava.utils.CallbackEmitter;

public class Main {
    public static void main(String[] args) {
        FileReader fr = new FileReader("db/base/amount.txt");
        fr.read(new Callback() {
            @Override
            public void entries() {
                System.out.println("is run success");
            }
        });
    }

}
