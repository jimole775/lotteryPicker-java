package utils;
import java.util.ArrayList;
public interface Pipe{

    // 注册管理pipe的所有回调，等到emit或者end调用的时候，统一调用
    public ArrayList<Callback> pipeCbRegisted = new ArrayList<Callback>();

    // pipe需要存储所有回调，每读取一字节，就循环调用所有回调
    public <T>T pipe(Callback pipeCb);

    // end算是pipe触发器
    public void end(Callback endCb);

    public void emit();
}