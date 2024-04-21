package assignment3;


import java.util.*;

public class MainRun {
    public static boolean fequal(double v1, double v2) {
        return Math.abs(v1 - v2) <= 1e-5;
    }

    public static void ArrayListTest() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        if (myArrayList.get(0) != 1 || myArrayList.get(1) != 2 || myArrayList.get(2) != 3) {
            System.out.println("MyArrayList Problem with add or get");
        }
        if (myArrayList.size() != 3) {
            System.out.println("MyArrayList Problem with size");
        }
        if (myArrayList.index(2) != 1) {
            System.out.println("MyArrayList Problem with index");
        }
        myArrayList.remove(2);
        //System.out.println(myArrayList.get(2));
        if (myArrayList.get(0) != 1) {
            System.out.println("MyArrayList Problem with remove 0");
        }
        //System.out.println(myArrayList.get(0));
        //System.out.println(myArrayList.get(1));
        //System.out.println(myArrayList.get(2));
        //System.out.println(myArrayList.get(3));
        if (myArrayList.get(1) != 3) {
            System.out.println("MyArrayList Problem with remove 1");
        }
        if (myArrayList.size() != 2) {
            System.out.println("MyArrayList Problem with remove size");
        }
        if (myArrayList.index(2) != -1) {
            System.out.println("MyArrayList Problem with remove index");
        }
        myArrayList.add(3);
        if (myArrayList.count(3) != 2) {
            System.out.println("MyArrayList problem with count");
        }

        // Size checking
        MyArrayList<Integer> second_array = new MyArrayList<>();
        if (second_array.size() != 0){
            System.out.println("second_array problem with Size");
        }
        MyArrayList<Integer> third_array = new MyArrayList<>(new Integer[]{3,null,3,3});
        third_array.remove(3);
        if (third_array.size() != 0){
            System.out.println("third_array problem with Size");
        }

        MyArrayList<Integer> myArrayList_2 = new MyArrayList<>(new Integer[]{1,2,3,4,5,6,null,7,8});
//        for (int i=0; i < myArrayList_2.size(); i++){
//            System.out.println(myArrayList_2.get(i));
//        }
        myArrayList_2.remove(4);  // 1,2,3,5,6,7,8 -> index 0-6
//        for (int i=0; i < myArrayList_2.size(); i++){
//            System.out.println(myArrayList_2.get(i));
//        }
        if (myArrayList_2.get(0) != 1){
            System.out.println("MyArrayList_2 problem with remove index 0");
        }
        if (myArrayList_2.get(1) != 2){
            System.out.println("MyArrayList_2 problem with remove index 1");
        }
        if (myArrayList_2.get(2) != 3){
            System.out.println("MyArrayList_2 problem with remove index 2");
        }
        if (myArrayList_2.get(3) != 5){
            System.out.println("MyArrayList_2 problem with remove index 3");
        }
        if (myArrayList_2.get(4) != 6){
            System.out.println("MyArrayList_2 problem with remove index 4");
        }
        if (myArrayList_2.get(5) != 7){
            System.out.println("MyArrayList_2 problem with remove index 5");
        }
        if (myArrayList_2.get(6) != 8){
            System.out.println("MyArrayList_2 problem with remove index 6");
        }


    }
    public static void SetTest() {
        MySet<Integer> set1 = new MySet<>();
        MySet<Integer> set2 = new MySet<>();
        set1.add(1);
        set1.add(1);
        if (!set1.contains(1) || set1.contains(4)) {
            System.out.println("MySet problem with contains");
        }
        set1.add(2);
        set1.add(3);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        if (set1.size() != 3 || set2.size() != 3) {
            System.out.println("MySet Problem with size");
        }
        MySet<Integer> set3 = new MySet<>(new Integer[]{1, 2, 3});
        if (!set3.equals(set1)) {
            System.out.println("MySet Problem with equals");
        }
        MySet<Integer> union = new MySet<>(new Integer[]{1, 2, 3, 4, 5});
        MySet<Integer> intersection = new MySet<>(new Integer[]{3});
        MySet<Integer> difference = new MySet<>(new Integer[]{5, 4});

        if (!set1.union(set2).equals(union)) {
            System.out.println("MySet problem with union");
        }


        if (!set2.difference(set1).equals(difference)) {
            System.out.println("MySet problem with difference");
        }


        if (!set1.intersection(set2).equals(intersection)) {
            System.out.println("MySet problem with intersection");
        }

        set1.remove(3);
        if (set1.contains(3) || set1.size() != 2) {
            System.out.println("MySet Problem with remove");
        }

        MySet<Integer> third_array = new MySet<>(new Integer[]{3, null, 3, 3});
        third_array.remove(3);
        if (third_array.size() != 0) {
            System.out.println("MyArrayList_3 problem with Size");
        }

        MySet<Integer> myset_2 = new MySet<>(new Integer[]{1, 2, 2, 3, 4, 5, null, 5, 5}); // 1,2,3,4,5
//        for (int i=0; i < myset_2.size(); i++){
//            System.out.println(myset_2.get(i));
//        }
        myset_2.remove(4);  // 1,2,3,5 -> index 0-3
//        for (int i=0; i < myset_2.size(); i++){
//            System.out.println(myset_2.get(i));
//        }
        if (myset_2.get(0) != 1) {
            System.out.println("myset_2 problem with remove index 0");
        }
        if (myset_2.get(1) != 2) {
            System.out.println("myset_2 problem with remove index 1");
        }
        if (myset_2.get(2) != 3) {
            System.out.println("myset_2 problem with remove index 2");
        }
        if (myset_2.get(3) != 5) {
            System.out.println("myset_2 problem with remove index 3");
        }


        MySet<Integer> mySet_3 = new MySet<>((new Integer[]{3, 3, 3, 3}));
        if (mySet_3.get(0) != 3) {
            System.out.println("mySet_3 problem with remove index 0");
        }
        if (mySet_3.size() != 1) {
            System.out.println("mySet_3 problem with size after initialization ");
        }
        mySet_3.remove(2);
        if (mySet_3.get(0) != 3) {
            System.out.println("mySet_3 problem with remove index 0");
        }
        mySet_3.remove(3);
        if (mySet_3.size() != 0) {
            System.out.println("mySet_3 problem with size after remove");
        }


        MySet<Integer> mySet_4 = new MySet<>((new Integer[]{3, 3, 3, 3}));
        if (mySet_4.size() != 1) {
            System.out.println("mySet_4 problem with size after initialization");
        }


        // Create a list of integers
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 3, 2);

        // Create a MySet object using the Iterable constructor
        MySet<Integer> mySet_5 = new MySet<>(integerList);
        if (mySet_5.size() != 5) {
            System.out.println("integerList- myset_5 problem with iter constructor");
        }
        mySet_5.remove(2);
        if (mySet_5.size() != 4) {
            System.out.println("integerList- problem with remove");
        }

        // Create an array of strings
        String[] stringArray = {"apple", "banana", "orange", "banana", "kiwi"};
            // Create a MySet object using the array constructor
        MySet<String> mySet_6 = new MySet<>(stringArray);
        if (mySet_6.size() != 4) {
            System.out.println("stringArray - myset_6 problem with iter constructor");
        }
        mySet_6.remove("banana");
        if (mySet_6.size() != 3) {
            System.out.println("stringArray - myset_6 problem with remove");
        }
//        for (int i =0; i < mySet_6.size(); i++){
//            System.out.println(mySet_6.get(i));
//        }
        if (!Objects.equals(mySet_6.get(0), "apple")) {
            System.out.println("apple - index 0 - myset_6 problem");
        }
        if (!Objects.equals(mySet_6.get(1), "orange")) {
            System.out.println("orange - index 1 - myset_6 problem");
        }
        if (!Objects.equals(mySet_6.get(2), "kiwi")) {
            System.out.println("kiwi - index 2 - myset_6 problem");
        }

    }

    public static void PersonRegistryTest() {
        PersonRegistry pr = new PersonRegistry();
        pr.add(new Person("a", 1, 1));
        pr.add(new Person("b", 2, 2));
        if (pr.maxAge() != 2) {
            System.out.println("PersonRegistry problem with maxAge");
        }
        if (!fequal(pr.meanLuckyNumber(), 1.5)) {
            System.out.println(pr.meanLuckyNumber() + " need to be " + 1.5);
            System.out.println("PersonRegistry problem with meabLuckyNumber");
        }
        MyArrayList<String> uniqueNames = pr.uniqueNames();
        if (uniqueNames.count("a") != 1 || uniqueNames.count("b") != 1) {
            System.out.println("PersonRegistry problem with uniqueNames");
        }
        pr.add(new Person("a", 1, 1));
        if(pr.count(new Person("a", 1, 1))!=2){
            System.out.println("PersonRegistry problem with count");
        }

    }


    public static void main(String[] args) {
        ArrayListTest();
        SetTest();
        PersonRegistryTest();
    }
}





//        System.out.println("set1");
//        for (int i= 0; i < set1.size(); i++){
//            System.out.println(set1.set_getting_var(i));
//        }
//        System.out.println("set2");
//        for (int i= 0; i < set2.size(); i++){
//            System.out.println(set2.set_getting_var(i));
//        }
//        System.out.println("set2");
//        for (int i= 0; i < set2.size(); i++){
//            System.out.println(set2.set_getting_var(i));
//        }
//
//        System.out.println("set1");
//        for (int i= 0; i < set1.size(); i++){
//            System.out.println(set1.set_getting_var(i));
//        }
//        System.out.println("set2");
//        for (int i= 0; i < set2.size(); i++){
//            System.out.println(set2.set_getting_var(i));
//        }
//        System.out.println("diffrence_func");
//        MySet<Integer> diff = set2.difference(set1);
//        for (int i= 0; i < diff.size(); i++){
//            System.out.println(diff.set_getting_var(i));
//        }
//
//        System.out.println("diffrence");
//        for (int i= 0; i < difference.size(); i++){
//            System.out.println(difference.set_getting_var(i));
//        }
//        System.out.println("set1");
//        for (int i= 0; i < set1.size(); i++){
//            System.out.println(set1.set_getting_var(i));
//        }

//        System.out.println("set1-after remove");
//        for (int i= 0; i < set1.size(); i++){
//            System.out.println(set1.set_getting_var(i));
//        }

//        System.out.println(set1.contains(3));
//        System.out.println(set1.size());
//System.out.println(myArrayList.get(0));
//System.out.println(myArrayList.get(1));
//System.out.println(myArrayList.get(2));