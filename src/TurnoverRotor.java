public class TurnoverRotor extends BasicRotor {

    protected int turnoverPosition = 0;
    protected Rotor nextRotor;

    // The constructor gets a name and a position, and initialises the TurnoverRotor.
    protected TurnoverRotor(String type, int position){
        super(type,position);
        this.initialise(type);
    }

    // This method initialises each TurnoverRotor with the mapping and the turnoverPosition given in the instructions.
    protected void initialise(String type) {
        if (type.equals("typeI")){
            mapping = rotorI;
            turnoverPosition = 24;
        }
        else if (type.equals("typeII")){
            mapping = rotorII;
            turnoverPosition = 12;
        }
        else if (type.equals("typeIII")){
            mapping = rotorIII;
            turnoverPosition = 3;
        }
        else if (type.equals("typeIV")){
            mapping = rotorIV;
            turnoverPosition = 17;
        }
        else if (type.equals("typeV")){
            mapping = rotorV;
            turnoverPosition = 7;
        }
        else{
            System.out.println("Please choose from one of the available Rotors (I,II,III,IV,V).");
        }
    }

    // This method sets the next rotor ( the rotor to its right).
    protected void setNextRotor(Rotor rotor){
        nextRotor = rotor;
    }

    // This method increments the position by 1 and if it reaches the turnoverPosition it also increments the position of the next rotor.
    protected void rotate(){
        if((position+1) == ROTORSIZE){
            position=0;
        }
        else {
            position++;
        }

        if (position == turnoverPosition) {
            nextRotor.rotate();
        }

    }
}
