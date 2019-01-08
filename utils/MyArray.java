package utils;

import java.util.Arrays;

/**
 * Created by Administrator on 2019/1/8.
 */
public class MyArray<T>{
    public MyArray(){

    }

    public T[] concat(T[]...arrs){
        T[] a = (T[]) new Object[10];
        T[] result = extendLength(arrs[0]);
        return result;
    }

    private T[] extendLength(T[] arr){
        return Arrays.copyOf(arr,arr.length*3/2+1);
    }
}

//class Info<T>{
//    private T var;
//    public void set(T var){
//        this.var = var;
//    }
//
//    public T get(){
//        return this.var;
//    }
//}