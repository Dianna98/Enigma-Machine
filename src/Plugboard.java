public class Plugboard {

    private Plug[] plugs = new Plug[13];
    private int nrPlugs = 0;
    private int i = 0;
    private Boolean check = true;

    // This method adds a new Plug in Plugboard and returns true if the plug passed the requirements and has been added in the array of Plugs, and false in the other case..
    protected Boolean addPlug(char end1, char end2) {

        // A new Plug with the given ends is created.
        Plug newPlug = new Plug(end1, end2);
        // A new empty Plug is initialised in the array of Plugs
        plugs[nrPlugs] = new Plug();
        // The new Plug is checked if it has common ends with any Plug from the array
        for (i=0;i<nrPlugs;i++){
            if (plugs[i].clashesWith(newPlug)) {
                check = false;
            }
        }
        // If the conditions are met the number of plugs increases and the Plug is added in the array.
        if (check) {
            plugs[nrPlugs] = newPlug;
            nrPlugs++;
            return true;
        }
        else {
            return false;
        }
    }

    // This method returns the number of Plugs existent in the Plugboard.
    protected int getNumPlugs(){
        return nrPlugs;
    }

    // This method removes all the Plugs from the Plugboard.
    protected void clear(){
        for (Plug plugToRemove : plugs){
            plugToRemove=null;
        }
        nrPlugs = 0;
    }

    // This method returns the given character if a Plug containing it is not existent or the other end of the Plug if the letter is found as one end of a Plug.
    protected char substitute(char letter){
         char returnLetter = letter;
        for(i=0;i<getNumPlugs();i++){
           Plug testPlug=plugs[i];
            if (testPlug.getEnd1()==letter || testPlug.getEnd2()==letter) {
                returnLetter=testPlug.encode(letter);
            }
        }
        return returnLetter;
    }
}
