import lotteryPickerJava.analyze.AwardRate;
// import lotteryPickerJava.utils.FileReader;
// import lotteryPickerJava.utils.Callback;
// import lotteryPickerJava.utils.CallbackEmitter;

public class Main {
    public static void main(String[] args) {
        readFile();
    }

    private static void readFile(){
        FileReader fr = new FileReader("db/base/amount.txt");
        fr.read(new Callback(){
            public void entries(byte[] data){
                System.out.println("is run success");
                callbackHandler(data);
            }
        });
    }

    private static void callbackHandler(byte[] data) {
        System.out.println(new String(data));
    }

}
