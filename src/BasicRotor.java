public class BasicRotor extends Rotor {

    protected int[] rotorI= new int[]{ 4, 10, 12, 5, 11, 6, 3, 16, 21, 25, 13, 19, 14, 22, 24, 7, 23, 20, 18, 15, 0, 8, 1, 17, 2, 9 };
    protected int[] rotorII= new int[]{ 0, 9, 3, 10, 18, 8, 17, 20, 23, 1, 11, 7, 22, 19, 12, 2, 16, 6, 25, 13, 15, 24, 5, 21, 14, 4 };
    protected int[] rotorIII= new int[]{ 1, 3, 5, 7, 9, 11, 2, 15, 17, 19, 23, 21, 25, 13, 24, 4, 8, 22, 6, 0, 10, 12, 20, 18, 16, 14 };
    protected int[] rotorIV= new int[]{4, 18, 14, 21, 15, 25, 9, 0, 24, 16, 20, 8, 17, 7, 23, 11, 13, 5, 19, 6, 10, 3, 2, 12, 22, 1 };
    protected int[] rotorV= new int[]{ 21, 25, 1, 17, 6, 8, 19, 24, 20, 15, 18, 3, 13, 7, 11, 23, 0, 22, 12, 9, 16, 14, 5, 4, 2, 10 };
    protected int[] inverseMapping= new int[26];
    protected int i =0;

    // The constructor gets a name and a position, and initialises the BasicRotor.
    protected BasicRotor (String type, int position){
        name=type;
        this.position=position;
        initialise(type);
    }

    // This method initialises each BasicRotor with the mapping given in the instructions.
    protected void initialise(String name){
        if (name.equals("typeI")) {
            this.mapping = rotorI;
        }
        else if (name.equals("typeII")) {
            this.mapping = rotorII;
        }
        else if (name.equals("typeIII")) {
            this.mapping = rotorIII;
        }
        else if (name.equals("typeIV")) {
            this.mapping = rotorIV;
        }
        else if (name.equals("typeV")) {
            this.mapping = rotorV;
        }
        else {
            // This message reminds the user what BasicRotors can use if an inappropriate one is selected.
            System.out.println("Please choose from one of the available Rotors (I,II,III,IV,V).");
        }
    }

    // This method returns the position in the mapping of the given letter written as an integer.
    protected int substitute(int integerLetter) {

        // This condition is meant to not allow the position to be out of bounds (less than 0)
        if ((integerLetter-position)<0) {
            integerLetter = integerLetter + ROTORSIZE - position;
        }
        else{
            integerLetter=integerLetter-position;
        }

        integerLetter=mapping[integerLetter]+position;
        // The method returns the integerLetter%ROTORSIZE so it would not exceed the number of positions.
        // A rotor is a circular shape so everytime it reaches the last position the next one is the first one.
        return integerLetter%ROTORSIZE;
    }

    // This method changes the letter written as an integer passed to it using the reverse mapping, by applying the same principle as in substitute method.
    protected int substituteBack(int integerLetter){
        for(i=0;i<ROTORSIZE;i++){
            inverseMapping[mapping[i]]=i;
        }
        if ((integerLetter-position)<0) {
            integerLetter = integerLetter + ROTORSIZE - position;
        }
        else{
            integerLetter=integerLetter-position;
        }
        integerLetter=inverseMapping[integerLetter]+position;
        return integerLetter%ROTORSIZE;
    }

    // This method increments the position by 1.
    protected void rotate(){
        // If the next position is out of the size, the position is being reseted to 0.
        if((position+1)==ROTORSIZE){
            position=0;
        }
        else{
            position++;
        }
    }

    // This method is not implemented in this class.
    protected void setNextRotor(Rotor rotor){}
}
