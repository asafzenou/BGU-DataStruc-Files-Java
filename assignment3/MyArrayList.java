package assignment3;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T extends Serializable> implements Serializable, Iterable<T> {  //Iterator<T>
    private SimpleArray<T> arr;
    protected int full_index = -1;

    /**
     * Iterable interface realization
     */
    public class IterIterable implements Iterator<T> {
        private int count_if_next = 0;
        @Override
        public boolean hasNext() {
            return (count_if_next < full_index+1);
        }

        @Override
        public T next() {
            T var = get(count_if_next);
            count_if_next++;
            return var;
        }
    }

    /**
     * Empty input constructor
     */
    public MyArrayList(){
        set_array_null();
    }

    /**
     * Array input constructor
     * @param arr - Array with var type T
     */
    public MyArrayList(T[] arr){
        int index_set = -1;  // when variable is null and after it's not
        if (arr.length > 0){
            SimpleArray<T> temp_arr = new SimpleArray<T>(arr.length);
            for (T t : arr) {
                if (t != null) {
                    index_set++;
                    temp_arr.set(index_set, t);
                    full_index++;
                }
            }
            this.arr = temp_arr;
        }
        else {
            set_array_null();  // Same as empty input constructor
        }
    }

    /**
     * Setting {null} if the input is null or {} or 0
     */
    private void set_array_null(){
        arr = new SimpleArray<T>(1);
    }

    /**
     * Variable getter
     * @return - The variable in the index and if their not a variable in the index, raise exception
     */
    public T get(int index){
        if (index <= full_index){
            return get_arr().get(index);
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Getter
     * @return - The private arr
     */
    protected SimpleArray<T> get_arr(){
        return arr;
    }


    /**
     * @return - size of filled index's
     */
    public int size(){
        return full_index+1;
    }

    /**
     * Adding varible to my arrat list
     */
    public void add (T element){
        if (full_index == -1 && arr.get(0) == null){  // when arr = {null}
            arr.set(0, element);
            full_index = full_index +1;
        }
        else {
            if (element != null) {
                if (full_index + 2 > arr.size()) {
                    make_arr_bigger();  // Making the arr twice bigger
                }
                full_index = full_index + 1;
                arr.set(full_index, element);  // filing the new element
            }
        }
    }

    /**
     * Making an array twice bigger
     */
    void make_arr_bigger(){
        int size = arr.size();
        SimpleArray<T> temp_arr = new SimpleArray<>(2 * size);  // make 2*size-length array with nulls
        for (int i=0; i <= full_index; i++) {
            temp_arr.set(i, arr.get(i));  // filing all the element that already there
        }
        arr = temp_arr;  // {variable} + {new_element} + {nulls}

    }

    /**
     *Didn't use it but it's returning the array
     */
    public SimpleArray<T> getUnderlyingSimpleArray() {
        return this.arr;
    }

    /**
     *
     * Removing the element in the arr(if its there)
     */
    public void remove(T element){
        boolean was_remove = true;  // If the element was in the arr
        int need_to_remove = count(element);  // How many times the element in the array
        for (int i=0;i < size(); i++){
            if (arr.get(i) == element){  // Looping until getting to the element(if!)
                was_remove = false;
                for (int j=i; j < size(); j++){
                    if (i != j && arr.get(j) != element && arr.get(j) != null) {
                        arr.set(i, arr.get(j)); // Switching element's- we want to get all the element we want to remove to the end
                        arr.set(j, element);// "   "
                        break;

                    }
                }

            }

        }
        for (int i=0; i < arr.size();i++){
            if(arr.get(i) == element){  // element we want to remove = x, {elements} + {x,x,x} -> want to make x to null
                arr.set(i, null);
            }
        }
        if (was_remove){
            throw new NoSuchElementException();
        }
        full_index = full_index - need_to_remove;  // We deleted x elements then we need to know the index
    }


    /**
     *Helper - Getting the first index if the element is there
     */
    private int get_index(T element){
        for (int i=0; i <= full_index;i++){
            if (arr.get(i).equals(element)){
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }

    /**
     * Getting the first index if the element is there
     */
    public int index(T element){
        int value = get_index(element);
        if (value == Integer.MAX_VALUE){
            return -1;
        }
        return value;
    }

    /**
     *Counting how many times the element exists
     */
    public int count(T element){
        int count = 0;
        for (int i=0; i < full_index+1; i++){
            if (arr.get(i) == element){
                count++;
            }
        }
        return count;
    }

    /**
     * Length of the array-with nulls
     */
    public int capacity() {
        return this.arr.length();
    }

    /**
     * calling for the iterator class
     */
    public Iterator<T> iterator(){
        return new IterIterable();
    }

}
