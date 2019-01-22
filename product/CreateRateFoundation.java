package product;
import utils.FileReader;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonIOException;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import com.google.gson.JsonSyntaxException;
/**
 * Created by Administrator on 2019/1/22.
 */
public class CreateRateFoundation {
    private short[] front;
    private short[] behind;
    private String filePath_front = "db/base/front_sum.json";
    private String filePath_behind = "db/base/behind_sum.json";

    public String getJsonString(){
        FileReader frontReader = new FileReader(filePath_front);
        byte[] jsonByte = frontReader.readFile();
        return new String(jsonByte);
    }

}
