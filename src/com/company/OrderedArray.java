package com.company;

// demonstrates ordered array class:

import java.lang.reflect.AnnotatedElement;

public class OrderedArray {

    private long[] orderedArr; // ref to array
    private int nElems; // num of data

    // constructor:
    public OrderedArray(int max){

        // create array:
        orderedArr = new long[max];
        nElems = 0;
    }

    // ------------------------------------------------------------------------
    // size():
    public int size(){
        return nElems;
    }

    // ------------------------------------------------------------------------
    // find(value): Utilizing Binary Search
    public int find(long searchKey){

        int lowerbound = 0;
        int upperbound = nElems - 1;
        int currentIndex;

        while(true){

            // this will make the current index the middle of the ordered array:
            currentIndex = (lowerbound + upperbound)/2;

            if(orderedArr[currentIndex] == searchKey){
                // if you've found it return the current index:
                return currentIndex;
            } else if(lowerbound > upperbound){
                // cant find the item in the current state
                // when nelems == 0 then the find method will return a false
                return nElems;
            } else {
                // divide range:

                if(orderedArr[currentIndex] < searchKey){

                    // it's in the upper half:
                    lowerbound = currentIndex + 1;

                } else {
                    upperbound = currentIndex - 1;
                    // its in the lower half:

                }
            } // end else divide range
        } // end while
    } // ends find

    // ------------------------------------------------------------------------
    // insert(value)
    public void insert(long value){

        int j; // to hold to run through the array:

        // find where it goes by using a linear search and traverse through the loop:
        for(j = 0; j < nElems; j++){

            // if a value is larger than value then -> it's time to stop and
            // store the location of J so that we can do the moving over of the
            // bigger ones down:
            if(orderedArr[j] > value){
                break;
            }
        }

        // now j hosts the value of the index that is needed
        // move bigger ones down:
        // we're doing it backwards though:
        for(int reverseindex = nElems; reverseindex > j; reverseindex--){

            orderedArr[reverseindex] = orderedArr[reverseindex - 1];
        }

        // insert the value:
        orderedArr[j] = value;

        // increase size of the array:
        nElems++;
    }

    // ------------------------------------------------------------------------
    // delete(value)
    public boolean delete(long value){

        int j;

        // locate the item:
        j = find(value);

        // can't find it:
        // when j == nelems; the find method returns the value of the size of the array
        // when it can't locate the value within
        if(j == nElems){
            return false; // can't delete a value that doesn't exist
        } else {
            // if you find the item: do the moving down
            for(int newindex = j; newindex < nElems; newindex++){

                orderedArr[newindex] = orderedArr[newindex + 1];
            }
            // decrement the size of the array
            nElems--;
            return true; // item found!
        }
    } // end delete


    // ------------------------------------------------------------------------
    // display()
    public void display(){

        System.out.println(" ");
        for(int i = 0; i < nElems; i++){
            System.out.print(orderedArr[i] + " ");
        }
    }
} // ends OrderedArray Class

//////////////////////////////////////////////////////////////////////////

class OrderedArrayApp{

    public static void main(String[] args){

        int max = 100; // array size:
        OrderedArray orderedArray; // ref to array:
        orderedArray = new OrderedArray(max); // create the array:

        // insert 10 items:
        orderedArray.insert(77);
        orderedArray.insert(99);
        orderedArray.insert(44);
        orderedArray.insert(55);
        orderedArray.insert(22);
        orderedArray.insert(88);
        orderedArray.insert(11);
        orderedArray.insert(00);
        orderedArray.insert(66);
        orderedArray.insert(33);

        // search for item:
        int searchKey = 55;

        // if the item isn't equal to the size of the array then it was found within the obj
        if(orderedArray.find(searchKey) != orderedArray.size()){
            System.out.println("Found Item: " + searchKey + "\n");
        } else {
            System.out.println("Item wasn't found: " + searchKey + "\n");
        }

        // display:
        orderedArray.display();

        // delete:
        orderedArray.delete(00);
        orderedArray.delete(55);
        orderedArray.delete(99);

        // display
        orderedArray.display();
    } // ends main
} // ends OrderedArrayApp
