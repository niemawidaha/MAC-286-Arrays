package com.company;

public class StringArray {

    // private items:
    public String[] stringArray;
    private int nElems;

    // constructor:
    public StringArray(int size){

        // create array:
        stringArray = new String[size];
        nElems = 0;
    }

    //--------------------------------------------------------------------------------
    // search(value): utilizing binary search:
    public boolean search(String checkString){

        int     j; // to hold the value if the string exists

        for(j = 0; j < nElems; j++){

            // look for the item in the array:
            if(stringArray[j].equals(checkString)){
                return true;
            }
        }
        return false;
    }


    //--------------------------------------------------------------------------------
    // insert(value):
    public void insert(String insertString){

        // find where the string goes by using a linear search
        // check if the string all ready exists:
        // no duplicates allowed so if you try to insert a dupe it will give an error:

        int j; // to hold to run through the array
        int insertChar;  // to store the 1st char of insert string
        int arrayChar; // to store the 1st char of comparison string

        if(search(insertString)){
            // checks if the string currently exists:
            System.out.println("Error: String all ready exists in array.");
        } else {

            // check where to insert the value depending on its order
            // store the location of j in order to do the moving over of the bigger ones down
            for (j = 0; j < nElems; j++) {

                // since the string doesn't exist, here I'm going to store the first characters:
                insertChar = insertString.charAt(0);
                arrayChar = stringArray[j].charAt(0);

                if(arrayChar > insertChar){
                    break;
                }
            }

            // now j hosts the value of the index that's needed:
            // this is the reverse way of replacing elements from the end of the string:
            // first we'll move it over and replace all elements except where J now needs to exist
            for( int reverseindex = nElems; reverseindex > j; reverseindex--){

                stringArray[reverseindex] = stringArray[reverseindex - 1]; // this will shift it over from the last value
            }

            // Replacing the j element with the insertion value:
            stringArray[j] = insertString;

            // increase the size of the array:
            nElems++;

        } // ends else
    } // ends insert()


    //--------------------------------------------------------------------------------
    // delete(value): removes string from list
    public boolean delete(String deleteKey) {

        int j; // to hold where the item is that is being deleted

        //j = find(deleteKey); // look for the item first


        for (j = 0; j < nElems; j++) {
            if (stringArray[j].equals(deleteKey)) {
                break;
            }
        }

        // now that j holds the value of what is needed:
        // if == nelems: item wasnt found:
        if (j == nElems) {
            return false;
        } else {
            // do the shifting for the array and remove the string from the array:
            for(int newIndex = j; newIndex < nElems; newIndex++){
                stringArray[newIndex] = stringArray[newIndex + 1];
            }

            nElems--; // decrement the size of the array because item was officially deleted
            return true;
        } // ends else
    } // ends delete()


    //--------------------------------------------------------------------------------
    // display():
    public void display(){

        for(int i = 0; i < nElems; i++){
            System.out.println("String: " + stringArray[i]);
        }
    }

} // ends StringArray class

//////////////////////////////////////////////////////////////////////////////////////
// Here I will test the StringArray class created above:
class MilkyWay{

    public static void main(String[] args){

        int max = 100; // array size
        StringArray planetarySystem; // ref to array
        planetarySystem = new StringArray(max); // create the array

        // insert the planets:
        planetarySystem.insert("Mars");
        planetarySystem.insert("Jupiter");
        planetarySystem.insert("Neptune");
        planetarySystem.insert("Uranus");
        planetarySystem.insert("Earth");
        planetarySystem.insert("Venus");
        planetarySystem.insert("Saturn");
        planetarySystem.insert("Mercury");
        planetarySystem.insert("Pluto");

        // display:
        planetarySystem.display();

        // search for planet:
        String searchPlanet = "Pluto";

        // check whether string exists:
        if(planetarySystem.search(searchPlanet)){
            System.out.println("\nThis object is a member of your planetary system! \n");
        } else {
            System.out.println("\nThis object is not a member of your planetary system! \n");
        }

        // ---------------------------------------------------------------------------

        // Here: Test Deletion
        // Delete Pluto from the planetary system
        // display deletion changes:
        // planetarySystem.display();
        System.out.println("Testing Deletion of Pluto: ");
        planetarySystem.delete("Pluto");
        planetarySystem.display();
        System.out.println();

        // Here: Test Duplicate Check:
        System.out.println("Testing Duplicate Insertion of Earth: ");
        planetarySystem.insert("Earth");
        planetarySystem.display();

    } // ends main()
} // ends MilkyWay class
