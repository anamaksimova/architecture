package lesson2;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {
    private int capacity=0;
    private Object[] list;
    private int size;
    private final int CAPACITY = 3;
    public MyArrayList() {
        capacity = CAPACITY;
        list = new Object[capacity];
    }

    @Override
    public boolean add(T item) {
    if(size>=capacity){
    increaseCapacity();}
    list[size] = item;
    size++;
    return true;
    }
    @Override
    public boolean add(int index, T item) {
        if(index<0){ return false;}
        if(size>=capacity){
            increaseCapacity();}

        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
        return true;
    }

    private void increaseCapacity() {
    capacity = capacity*2;

        Object[] newList = new Object[capacity];
            System.arraycopy(list, 0, newList, 0, size);
            list =  newList;
        }


    @Override
    public boolean delete(T item) {
   int  position = indexOf(item);
   if(isEmpty()){return false;}
   if(position<0){
       return false;
   } else{
       T temp = (T) list[position];
       for (int i = position; i < size; i++) {
           list[i] = list[i + 1];
       }
       size--;
       return true;}
    }

    @Override
    public int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(list[i])){
                return i;
            }
        }
        return -1;
    }



    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, size));
    }
}
