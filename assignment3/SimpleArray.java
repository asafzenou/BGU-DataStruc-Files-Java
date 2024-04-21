package assignment3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class SimpleArray<T extends Serializable> implements Serializable, Iterable<T> {
    private ArrayList<T> arr;

    // Given a size of the array, it will create a SimpleArray of that size, initialized with nulls
    public SimpleArray(int size) {
        arr = new ArrayList<>(1);
        for (int i = 0; i < size; i++) {
            this.arr.add(null);
        }
    }

    // Given an array, it will copy it into the SimpleArray
    public SimpleArray(T[] arr) {
        this.arr = new ArrayList<>(arr.length);
        this.arr.addAll(Arrays.asList(arr));
    }

    // Set an element in index, similar to arr[index]=element
    public void set(int index, T element) {
        if (index >= this.arr.size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        arr.set(index, element);
    }

    // Gets an element from index, similar to arr[index]
    public T get(int index) {
        return arr.get(index);
    }

    // Length of the SimpleArray
    public int length() {
        return this.arr.size();
    }

    // size of the SimpleArray
    public int size() {
        return this.arr.size();
    }


    @Override
    public Iterator<T> iterator() {
        return this.arr.iterator();
    }
}
