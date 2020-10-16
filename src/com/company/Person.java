package com.company;
// data items as class objects


public class Person {

    private String lastName;
    private String firstName;
    private int age;

    // constructor:
    public Person(String last, String first, int a){
        this.lastName = last;
        this.firstName = first;
        this.age = a;
    }
    // ------------------------------------------------------------------------
    // displayPerson()
    public void displayPerson(){
        System.out.print("Last Name: " + lastName);
        System.out.print("First Name: " + firstName);
        System.out.println("Age" + age);
    }
    // -------------------------------------------------------------------------
    // getLast();
    public String getLast(){
        return lastName;
    }
    // ------------------------------------------------------------------------
    // getFirst();
    public String getFirst() {
        return firstName;
    }
} // end class Person

////////////////////////////////////////////////////////////////////////////////////////////////

class ClassDataArray{
    private Person[] people; // ref to array
    private int nElems; // # of data items

    // constructor:
    // create the array; no items yet:
    public ClassDataArray(int max){

        people = new Person[max];
        nElems = 0;
    }
    // ----------------------------------------------------------------------------------------


    // find a specified value:
    public Person find(String searchName){

        int j;

        for(j = 0; j < nElems; j++){

            // look for the item in the array:
            if(people[j].getLast().equals(searchName)){
                break; // j now hosts the number:
            }
        }

        // Now that you have access to what J is you have to ->
        // check if the person exists
        // if he does: return person
        // if he doesnt: return null
        if(j == nElems){
            return null; // person not found in our record
        } else {
            return people[j];
        }
    } // ends find

    //----------------------------------------------------------------------------------------
    // insert(): puts person into array:
    public void insert(String last, String first, int age){

        // since nelems contains the number of items in the array:
        // remember that an array starts at 0
        // the nelems = the number of total items so you can change that last value:
        people[nElems] = new Person(last, first, age);
        nElems++; // increase what elems has changed to
    }

    //---------------------------------------------------------------------------------------
    // delete: removes from array

    public boolean delete(String searchName){

        // search for person:
        // once found you have to shift the elements down:
        // decrease the size of the array

        int j;

        for(j = 0; j < nElems; j++){

            // search for item:
            if(people[j].getLast().equals(searchName)){
                break; // now j hosts the value of the index of the item that was found for deletion
            }
        } // ends for

        // now tell the compiler that we havent found the item:
        if(j == nElems){
            return false;
        } else {

            for(int newindex = j; newindex < nElems; newindex++){

                people[newindex] = people[newindex + 1];
            }

            nElems--; // decrease the elements
            return true;
        }
    } // ends delete

    //---------------------------------------------------------------------------------------
    // display()

    public void display(){

        for(int j = 0; j < nElems; j++){
            people[j].displayPerson();
        }
    } // ends display

} // ends ClassDataArray

////////////////////////////////////////////////////////////////////////////////////////////////////
class ClassDataApp{

    public static void main(String[] args){

        // array size;
        // reference to array:
        // create the array:
        int max = 100;

        ClassDataArray classDataArray;

        classDataArray = new ClassDataArray(max);

        // insert 10 items:
        classDataArray.insert("Evens", "Patty",24);
        classDataArray.insert("Evens", "Patty", 37);
        classDataArray.insert("Evens", "Patty", 43);
        classDataArray.insert("Stimson", "Patty", 63);
        classDataArray.insert("Vang", "Patty", 21);
        classDataArray.insert("Bella", "Patty", 29);
        classDataArray.insert("Edward", "Patty", 72);
        classDataArray.insert("Steward", "Patty", 54);
        classDataArray.insert("Liddle", "Patty", 22);
        classDataArray.insert("John", "Patty", 18);

        // display:
        classDataArray.display();

        String searchKey = "Vang";

        // take the person and locate them in the array:
        Person found;

        found = classDataArray.find(searchKey);

        if (found != null) {
            System.out.println("Found: ");
            found.displayPerson();
        } else
            System.out.println("Can't find: " + searchKey);

        System.out.println("Deleting Bella, Edward and Liddy");

        classDataArray.delete("Bella");
        classDataArray.delete("Edward");
        classDataArray.delete("Liddle");

        classDataArray.display(); // display items again

    }
}