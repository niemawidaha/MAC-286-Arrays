package com.company;

// demonstrates array class with low-level interface
// to run this program: C> java LowArrayApp

public class LowArray {

    private long[] arr; // ref to arr

    // constuctor:
    public LowArray(int size){
        arr = new long[size]; // creates array with size given
    }

    // -----------------------------------------------------------
    // setElem:
    public void setElem(int index, long value){
        arr[index] = value;
    }

    // -----------------------------------------------------------
    // getElem:
    public long getElem(int index){
        return arr[index];
    }
} // ends class

class LowArrayApp{

    public static void main(String[] args){
        LowArray lowArray;                   // reference
        lowArray = new LowArray(100);   // create la object
        int nelems = 0; // num of items in array
        int j; // loop variable

        // insert 10 items:
        lowArray.setElem(0,77);
        lowArray.setElem(1, 99);
        lowArray.setElem(2, 44);
        lowArray.setElem(3, 55);
        lowArray.setElem(4, 22);
        lowArray.setElem(5, 88);
        lowArray.setElem(6, 11);
        lowArray.setElem(7, 00);
        lowArray.setElem(8, 66);
        lowArray.setElem(9, 33);

        nelems = 10;

        // -----------------------------------------------------------

        // display items:
        for(j = 0; j < nelems; j++){
            System.out.print(lowArray.getElem(j) + " ");
        }
        // -----------------------------------------------------------


        // search for data item:
        // for each elem,
        // found item:
        // no:
        int searchKey = 26;
        for(j = 0; j < nelems; j++){
            if(lowArray.getElem(j) == searchKey){
                break; // elem was found now J holds the location of the found value
            }
        }

        // when j == nelems: item wasnt found display:
        if(j == nelems){
            System.out.println("\nItem wasn't found");
        } else {
            System.out.println("\nFound Search Key");

        }
        // -----------------------------------------------------------

        // delete value 55
        // look for it:
        // move the higher ones down:
        searchKey = 55;
        for(j = 0; j < nelems; j++){
            if( lowArray.getElem(j) == searchKey) {
                System.out.println("\nYour search key was found in the array");
                break; // now j holds the value of where the item is
            } else {
                System.out.println("\nYour search key wasn't found in the array");
            }
        }

        for(int newindex = j; newindex < nelems; newindex++){

            // this will take the current j and set it's value to the value next to it
            lowArray.setElem(newindex, lowArray.getElem(newindex + 1));
        }
        nelems--;

        // -----------------------------------------------------------
        // display items:
        for(j = 0; j < nelems; j++){
            System.out.println(lowArray.getElem(j) + " ");
        }
    } // ends main
} // ends lowarray app
