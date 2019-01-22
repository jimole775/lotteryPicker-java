
/**
 * Created by Andy-Super on 2018/12/20.
 */
//import analyze.AwardRate;
import utils.FileReader;
import product.CreateRateFoundation;
// import lotteryPickerJava.utils.CallbackEmitter;

public class Main {
    public static void main(String[] args) {
        readFile();
    }

    private static void readFile(){
//        FileReader fr = new FileReader("db/base/amount.txt");
//        fr.pipe(new Callback(){
//            public void entries(byte data){
//                System.out.println("is run success " + data);
//            }
//        }).end(new Callback(){
//            public void entries(byte data){
//                System.out.println("is run end " + data);
//            }
//        });
//        byte[] line = fr.readLine();
//        System.out.println(new String(line));
        CreateRateFoundation crf = new CreateRateFoundation();
        System.out.println(crf.getJsonString());
    }

}
