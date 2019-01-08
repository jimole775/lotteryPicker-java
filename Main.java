//import analyze.AwardRate;
import utils.FileReader;
import utils.Callback;
// import lotteryPickerJava.utils.CallbackEmitter;

public class Main {
    public static void main(String[] args) {
        readFiles();
    }

    private static void readFiles(){
        FileReader fr = new FileReader("db/base/behind_rate_foundation.json");
        /*fr.pipe(new Callback(){
            public void entries(byte data){
                System.out.println("is run success " + data);
            }
        }).end(new Callback(){
            public void entries(byte data){
                System.out.println("is run end " + data);
            }
        });*/
//        byte[] line = fr.readLine();
        byte[] file = fr.readFile();
        System.out.println(new String(file));
    }
}
