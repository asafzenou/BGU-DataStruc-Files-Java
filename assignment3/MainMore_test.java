package assignment3;

import assignment3.*;

public class MainMore_test {
        public static boolean fequal(double v1, double v2) {
            return Math.abs(v1 - v2) <= 1e-5;
        }

        public static void ArrayListTest() {
            System.out.println("-----------MyArrayList-----------");
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
            if (myArrayList.get(0) != 1 || myArrayList.get(1) != 3 || myArrayList.size() != 2 || myArrayList.index(2) != -1) {
                System.out.println("MyArrayList Problem with remove");
            }
            myArrayList.add(3);
            if (myArrayList.count(3) != 2) {
                System.out.println("MyArrayList problem with count");
            }
            MyArrayList<Integer> myArrayList_2 = new MyArrayList<>();
            myArrayList_2.add(1);
            myArrayList_2.add(2);
            myArrayList_2.add(3);
            myArrayList_2.add(10);
            myArrayList_2.add(2);
            myArrayList_2.add(34);
            if(myArrayList_2.size() != 6)
                System.out.println("The size of the array need to be 6, got : " + myArrayList_2.size());
            if(myArrayList_2.capacity() != 8)
                System.out.println("The capacity of the array need to be 8, got : " + myArrayList_2.capacity());
            if(myArrayList_2.get(5) != 34)
                System.out.println("The index 5 of the array need to be 34, got : " + myArrayList_2.get(5));
            myArrayList_2.remove(10);
            if(myArrayList_2.size() != 5)
                System.out.println("The size of the array need to be 5, got : " + myArrayList_2.size());
            if(myArrayList_2.capacity() != 8)
                System.out.println("The capacity of the array need to be 8, got : " + myArrayList_2.capacity());
            if(myArrayList_2.get(3) != 2)
                System.out.println("The index 3 of the array need to be 2, got : " + myArrayList_2.get(3));
            if(myArrayList_2.size() != 5)
                System.out.println("The size of the array need to be 5, got : " + myArrayList_2.size());
            if(myArrayList_2.capacity() != 8)
                System.out.println("The capacity of the array need to be 8, got : " + myArrayList_2.capacity());
            if(myArrayList_2.count(2) != 2)
                System.out.println("The count 2 of the array need to be 2, got : " + myArrayList_2.count(2));

            MyArrayList<Integer> myArrayList_3 = new MyArrayList<>(new Integer[]{1, 2, 2, 2, 2, 3, 2, 2, 2, 2, 2, 2, 4});
            if(myArrayList_3.size() != 13)
                System.out.println("The size of the array need to be 13, got : " + myArrayList_3.size());
            myArrayList_3.remove(2);
            if (myArrayList_3.get(0) != 1)
                System.out.println("MyArrayList Problem with remove, index 0 need to be 1, got: " + myArrayList_3.get(0));
            if(myArrayList_3.get(1) != 3)
                System.out.println("MyArrayList Problem with remove, index 1 need to be 3, got: " + myArrayList_3.get(1));
            if(myArrayList_3.get(2) != 4)
                System.out.println("MyArrayList Problem with remove, index 2 need to be 4, got: " + myArrayList_3.get(2));
            if(myArrayList.size() != 3)
                System.out.println("MyArrayList Problem with remove, size need to be 3, got: " + myArrayList_3.size());

            MyArrayList<Integer> myArrayList_4 = new MyArrayList<>(new Integer[]{1, 1, 1, 1, 5, 2, 1, 1, 1, 9});
            if(myArrayList_4.size() != 10)
                System.out.println("The size of the array need to be 10, got : " + myArrayList_4.size());
            myArrayList_4.remove(1);
            if (myArrayList_4.get(0) != 5)
                System.out.println("MyArrayList Problem with remove, index 0 need to be 5, got: " + myArrayList_4.get(0));
            if(myArrayList_4.get(1) != 2)
                System.out.println("MyArrayList Problem with remove, index 1 need to be 2, got: " + myArrayList_4.get(1));
            if(myArrayList_4.get(2) != 9)
                System.out.println("MyArrayList Problem with remove, index 2 need to be 9, got: " + myArrayList_4.get(2));
            if(myArrayList_4.size() != 3)
                System.out.println("MyArrayList Problem with remove, size need to be 3, got: " + myArrayList_4.size());

        }

        public static void SetTest() {
            System.out.println();
            System.out.println();
            System.out.println("-----------MySet--------------------");
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
            MySet<Integer> set4 = new MySet<>();
            set4.add(1);
            set4.add(2);
            set4.add(3);
            set4.add(4);
            set4.add(5);
            set4.add(6);
            if(set4.size() != 6)
                System.out.println("The size of set4 need to be 6, got : " + set4.size());
            MySet<Integer> set5 = new MySet<>();
            set5.add(4);
            set5.add(5);
            set5.add(6);
            set5.add(7);
            set5.add(8);
            set5.add(9);
            set5.add(10);
            if(set5.size() != 7)
                System.out.println("The size of set5 need to be 7, got : " + set5.size());
            MySet<Integer> union2 = new MySet<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
            MySet<Integer> intersection2 = new MySet<>(new Integer[]{4, 5, 6});
            MySet<Integer> difference2 = new MySet<>(new Integer[]{1, 2, 3});
            MySet<Integer> difference3 = new MySet<>(new Integer[]{7, 8, 9, 10});
            if (!set4.union(set5).equals(union2)) {
                System.out.println("MySet problem with union");
            }
            if (!set4.difference(set5).equals(difference2)) {
                System.out.println("MySet problem with difference set4/set5");
            }

            if (!set5.difference(set4).equals(difference3)) {
                System.out.println("MySet problem with difference set5/set4");
            }

            if (!set4.intersection(set5).equals(intersection2)) {
                System.out.println("MySet problem with intersection");
            }

            if(set4.contains(17)){System.out.println("problem contain");}
            set5.remove(8);
            if(set5.size() != 6){System.out.println("problem size");}
            if(set5.contains(8)){System.out.println("problem contain");}
        }

        public static void PersonRegistryTest1() {
            System.out.println();
            System.out.println();
            System.out.println("-----------PersonRegistry1----------");
            PersonRegistry pr = new PersonRegistry();
            pr.add(new Person("a", 1, 1));
            pr.add(new Person("b", 2, 2));
            if (pr.maxAge() != 2) {
                System.out.println("PersonRegistry problem with maxAge");
            }
            if (!fequal(pr.meanLuckyNumber(), 1.5)) {
                System.out.println("PersonRegistry problem with maxAge");
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

        public static void PersonRegistryTest2() {
            System.out.println();
            System.out.println();
            System.out.println("-----------PersonRegistry2----------");
            PersonRegistry prp = new PersonRegistry();
            prp.add(new Person("a", 1, 1));
            prp.add(new Person("b", 2, 2));
            if (prp.maxAge() != 2) {
                System.out.println("PersonRegistry problem with maxAge");
            }
            if (!fequal(prp.meanLuckyNumber(), 1.5)) {
                System.out.println("PersonRegistry problem with maxAge");
            }
            MyArrayList<String> uniqueNames = prp.uniqueNames();
            if (uniqueNames.count("a") != 1 || uniqueNames.count("b") != 1) {
                System.out.println("PersonRegistry problem with uniqueNames");
            }
            prp.add(new Person("a", 1, 1));
            if(prp.count(new Person("a", 1, 1))!=2){
                System.out.println("PersonRegistry problem with count");
            }
            PersonRegistry pr2 = new PersonRegistry();
            pr2.add(new Person("Alon",12,7.0));
            pr2.add(new Person("Itamar",16,2.1));
            pr2.add(new Person("Omer",16,2.1));
            pr2.add(new Person("Segal",18,5.2));
            pr2.add(new Person("Koby",20,4.4));
            pr2.add(new Person("Asaf",26,7.8));
            if (!pr2.writeCSV("C:\\Users\\asafz\\IntellijProjects\\OOP\\assignment3\\src\\assignment3\\persons.csv")) {
                System.out.println("cant write to the csv");
            }
        }


        public static void main(String[] args) {
            ArrayListTest();
            SetTest();
            PersonRegistryTest1();
            PersonRegistryTest2();
        }
    }