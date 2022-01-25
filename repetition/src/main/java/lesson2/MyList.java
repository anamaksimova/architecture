package lesson2;

interface MyList<T>{
  boolean add(T item);
  boolean delete(T item);
  int indexOf(T item);
  int size();
  boolean isEmpty();
  boolean add(int index, T item);
}
