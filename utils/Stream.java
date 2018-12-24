package utils;
public interface Stream{
    public void on(Callback onEvent);
    public void trigger();
}