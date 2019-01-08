
/**
 * Created by Andy-Super on 2018/12/20.
 */
//import analyze.AwardRate;
import utils.FileReader;
import utils.Callback;
// import lotteryPickerJava.utils.CallbackEmitter;

public class Main {
    public static void main(String[] args) {
        readFiles();
    }

    private static void readFile(){
        FileReader fr = new FileReader("db/base/amount.txt");
//        fr.pipe(new Callback(){
//            public void entries(byte data){
//                System.out.println("is run success " + data);
//            }
//        }).end(new Callback(){
//            public void entries(byte data){
//                System.out.println("is run end " + data);
//            }
//        });
        byte[] line = fr.readLine();
//        System.out.println(new String(line));

    }
}
