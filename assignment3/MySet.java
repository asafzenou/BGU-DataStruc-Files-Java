package assignment3;

import java.io.Serializable;
import java.util.Iterator;

public class MySet<T extends Serializable> extends MyArrayList<T> implements Serializable, Iterable<T> {

    /**
     * Empty input constructor
     */
    public MySet(){
        super();  // Setting an empty
    }

    /**
     * Iterable T type input constructor
     */
    public MySet(Iterable<? extends T> collection){
        Iterator<? extends T> iter = collection.iterator(); //for iterating on the collection variables
        MyArrayList<T> temp_myArrayList = new MyArrayList<>();
        while (iter.hasNext()){  //convert collection type to MyArrayList
            temp_myArrayList.add(iter.next());
        }
        for (int i=0; i < temp_myArrayList.size(); i++){
            T var = temp_myArrayList.get(i);
            if (checks_multiple_var(var) && var != null){  // checks if the var is in the set already
                this.add(var);  // if not add
            }
        }
    }

    /**
     * Array input constructor
     */
    public MySet(T[] arr){
        for (T t : arr) {
            if (checks_multiple_var(t)) {
                super.add(t);
            }
        }
    }

    /**
     * Before adding to the set, we check if the element is already in the set
     */
    private boolean checks_multiple_var(T var){  // checks if the var is in the set already
        if (super.get_arr() != null) {
            for (int j = 0; j < super.size(); j++) {
                if (super.get(j) == var) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Adding to set, after checking if the element is already in the set
     */
    public void add(T element){
        if (checks_multiple_var(element)){
            super.add(element);
        }
    }

    /**
     * Opposite of checks_multiple_var func
     */
    public boolean contains(T element){
        return !checks_multiple_var(element);
    }

    public int size(){
        return super.size();
    }

    /**
     * Removing the element(in O(n) - better time complexity then remove MyArrayList)
     */
    public void remove(T element) {  // example - 2
        boolean was_t = false;  // If the element was in the arr
        for (int i= 0; i < size()-1; i++){   // 1234
            if (element == get_arr().get(i) || was_t){  // Looping until getting to the element(if!)
                was_t = true;
                T next_element = get_arr().get(i+1);
                get_arr().set(i, next_element);  // moving the element we want to remove to the end
                get_arr().set(i+1, element);

            }
        }
        if (was_t || element == get_arr().get(size()-1)) {  // If the element was in the arr -> delete the last element
            get_arr().set(size() - 1, null);
            full_index--;
            // 1324 1342 134
        }


    }

    public T set_getting_var(int index){
        return super.get(index);
    }


    /**
     * Taking 2 sets(A,B) and returning a copy of A and B
     */
    public MySet<T> intersection(MySet<T> other){  // A = this, B = other
        MySet<T> temp = new MySet<T>();
        for (int i=0; i < this.size(); i++){
            T item = this.get(i);
            if (other.contains(item)){
                temp.add(item);  // add if xeA and xeB
            }
        }
        return temp;
    }

    /**
     * Taking 2 sets(A,B) and returning a copy of A\B
     */
    public MySet<T> difference(MySet<T> other){ // A = this, B = other
        MySet<T> temp = new MySet<T>();
        for (int i =0; i < size(); i++){
            if (!other.contains(super.get(i))){
                temp.add(super.get(i)); // add if xeA and x not in B
            }
        }
        return temp;
    }

    /**
     * Taking 2 sets(A,B) and returning a copy of AUB
     */
    public MySet<T> union(MySet<T> other){  // A = this, B = other
        MySet<T> temp = new MySet<T>();
        for (int j=0; j < super.size(); j++){  // Adding all the element in A to temp
            temp.add(super.get(j));  // AUB
        }
            for (int i=0; i < other.size(); i++){  // Adding all the element in B to temp
            temp.add(other.set_getting_var(i));  // if its already xeA and xeB then it will not add
        }
        return temp;
    }


    /**
     * Taking 2 sets(A,B) and checking if for all xeA, xeB and if for all xeB, xeA
     */
    public boolean equals(MySet<T> other) {
        for (int i=0; i < super.size(); i++){
            if (!other.contains(super.get(i))){ // if for all xeA, xeB
                if (super.get(i) != null) {
                    return false;
                }
            }
        }
        for (int i=0; i < other.size(); i++){
            if (!contain_for_array(other.set_getting_var(i), super.get_arr())){
                if (other.set_getting_var(i) != null) {  // if for all xeB, xeA
                    return false;
                }
            }
        }
        return true;  // check if A C B  and for sure A = B
    }

    /**
     * Helper function to check if for any SimpleArray contain specific var
     */
    private boolean contain_for_array(T var, SimpleArray<T> an_arr){
        for (int i=0; i < an_arr.size(); i++){
            if (an_arr.get(i) == var){
                return true;
            }
        }
        return false;
    }
}
