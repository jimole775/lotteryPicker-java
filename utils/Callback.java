
public interface Callback{
    public void entries(byte[] data); // 主要是为了兼容readLine方法
    public void entries(byte data);
}