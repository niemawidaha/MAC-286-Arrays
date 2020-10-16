package com.company;

public class HighArray {

    private long[] highArray; // ref to array a
    private int nelems;

    // ------------------------------------------------------------------------
    // constuctor:

    public HighArray(int max){
        highArray = new long[max];
        nelems = 0; // no items yet
    }
    // ------------------------------------------------------------------------
    // find(searchkey): find the specified value:

    public boolean find(long searchKey){
        int j;

        for(j = 0; j < nelems;j++){
            if(highArray[j] == searchKey) {
                break; // item was was found; j holds the value of the found item
            }
        }

        // j now holds the value of the item:
        // if j = nelems -> item wasnt found; end of array was triggered
        // otherwise the items in the object array:
        if(j == nelems){
            return false;
        } else {
            return true;
        }
    }

    // ------------------------------------------------------------------------
    // insert(value): put element into array

    public void insert(long value){

        // nelems: has the index # for the next variable in the array that's available

        highArray[nelems] = value;
        nelems++; // increment the size of nelems so that it can be used throughout
    }

    // ------------------------------------------------------------------------
    // delete(value):

    public boolean delete(long value){

        int j;

        // look for it:
        for(j = 0; j < nelems; j++){

            if(highArray[j] == value){
                break;
            }
        }

        // can't find it:
        // this will only happen when j == nelems and it's gone towards the end of the obj
        if(j == nelems){
            return false;
        } else {

            // item was found:
            // move higher ones down
            for(int newindex = j; newindex < nelems; newindex++){
                highArray[newindex] = highArray[newindex + 1];
            }

            // decrement size:
            nelems--;
            return true;
        }
    }

    // ------------------------------------------------------------------------
    //display():
    public void display(){
        for(int j = 0; j < nelems; j++){
            System.out.print(highArray[j] + " ");
        }
    }


} // ends HighArray class

//////////////////////////////////////////////////////////////////////////

class HighArrayApp{

    public static void main(String[] args){

        int max = 100; // array size:
        HighArray highArray; // reference to array:
        highArray = new HighArray(max); // create the array:

        // insert 10 items:
        highArray.insert(77); // insert 10 items
        highArray.insert(99);
        highArray.insert(44);
        highArray.insert(55);
        highArray.insert(22);
        highArray.insert(88);
        highArray.insert(11);
        highArray.insert(00);
        highArray.insert(66);
        highArray.insert(33);

        // DISPLAY:
        highArray.display();

        // SEARCH FOR ITEMS:
        int searchKey = 55;
        if(highArray.find(searchKey)){
            System.out.println("\nFound: " + searchKey);
        } else {
            System.out.println("\nDid not find: " + searchKey);
        }

        // DELETE ITEMS:
        highArray.delete(00);
        highArray.delete(55);
        highArray.delete(99);

        highArray.display();

    }
}