package assignment3;
import java.io.*;
import java.util.Scanner;

public class PersonRegistry {
    private boolean corrupted;
    private MyArrayList<Person> arr_list = new MyArrayList<Person>();
    public boolean isCorrupted() {
        return this.corrupted;
    }

    /**
     * Constructor - taking info from csv with bytes wrote and adding it to MyArrayList(if we have problem with file, corrupted turning on)
     */
    public PersonRegistry(String filePath){
        String sub = filePath.substring(filePath.length()-4);  // checking last 4 letters
        try {

            if (sub.equals(".bin")){  //data is represented as bytes and need to make it as MyArrayList
                MyArrayList<Person> temp = bytes_to_object(filePath);  //from bytes to object's
                if (temp != null){
                    arr_list = temp;
                }
                else {
                    corrupted = true;
                }
            }
            else {  // data represented as csv-text and every line represent info of a person
                Scanner file = new Scanner(filePath);
                while (file.hasNextLine()) {  // iterator of the lines in the file
                    String temp = file.nextLine();
                    String[] split = temp.split(",", 3);  // [name, age, lucky number]
                    Person temp_person = new Person(split[0], Integer.parseInt(split[1]), Double.parseDouble(split[2]));  // creating new person
                    arr_list.add(temp_person);

                }

            }
        } catch (Exception e) {
            corrupted = true;
        }
    }

    /**
     * Taking file wrote with bytes and making it as file with Objects
     */
    private MyArrayList<Person> bytes_to_object(String filePath){
        try {
            // Input is Binary file... then I need FileOutputStream and ObjectOutputStream
            FileInputStream file = new FileInputStream(filePath);  //Reading data in the form of Bytes - can take file names as arguments
            ObjectInputStream array_file = new ObjectInputStream(file);  //knowing the data inside is an Object - can't take file names as arguments
            Object result_as_obj = array_file.readObject();
            file.close(); // closing the streaming- important!
            array_file.close();  // closing the streaming- important!
            return (MyArrayList<Person>) result_as_obj;  // We know the object inside is in the type MyArrayList
        } catch (Exception e){
            corrupted = true;
            return null;
        }
    }

    /**
     * Empty constructor
     */
    public PersonRegistry(){
        arr_list = new MyArrayList<Person>();
    }

    /**
     * Iterable constructor with objects type person
     */
    public PersonRegistry(Iterable<? extends Person> persons) {
        arr_list = new MyArrayList<>();
        for (Person person : persons) {
            arr_list.add(person);
        }
    }

    /**
     * Array constructor with objects type person
     */
    public PersonRegistry(Person[] persons){
        arr_list = new MyArrayList<>();
        for (Person person : persons) {
            arr_list.add(person);
        }
    }

    /**
     * Adding person to MyArrayList
     */
    public void add(Person p){
        arr_list.add(p);
    }

    /**
     * Getting person and if not there raise an exception
     */
    public Person get(int index){
        try {
            return arr_list.get(index);
        } catch (Exception e) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returning max age person
     */
    public int maxAge(){
        int max = arr_list.get(0).getAge();
        for (int i=1; i < arr_list.size(); i++){
            int temp = arr_list.get(i).getAge();
            if (temp > max){
                max = temp;
            }
        }
        return max;
    }

    /**
     * Return the avg of all persons in My Array List
     */
    public double meanLuckyNumber(){
        double count =0;
        for (int i=0; i < arr_list.size(); i++){
            count = count + arr_list.get(i).getLuckyNumber();
        }
        return count/(arr_list.size());
    }

    /**
     * Counting the amount of persons in My Array List
     */
    public int count(Person person){
        int counting = 0;
        for (int i=0; i < arr_list.size(); i++){
            if (arr_list.get(i).equals(person)){
                counting++;
            }
        }
        return counting;
    }

    /**
     * Retuning an array of persons how are the only name in the array
     */
    public MyArrayList<String> uniqueNames(){
        MyArrayList<String> unique = new MyArrayList<>();
        for (int j=0; j < arr_list.size(); j++){
            if (count(arr_list.get(j)) == 1){
                unique.add(arr_list.get(j).getName());
            }
        }
        return unique;
    }

    /**
     * Writing MyArrayList to new file path file
     */
    public boolean writeCSV(String filePath){
        try {
            PrintWriter output = new PrintWriter(new FileOutputStream(filePath));
            for (int i=0; i < arr_list.size()-1; i++){
                Person person = arr_list.get(i);
                String line = person.getName()+","+person.getAge()+person.getLuckyNumber();
                output.write(line+"\n");
            }
            Person person = arr_list.get(arr_list.size()-1);
            String line = person.getName()+","+person.getAge()+person.getLuckyNumber();
            output.write(line);
            output.close();
        }catch (Exception e){
            return false;
        }
        return true;
    }



}
