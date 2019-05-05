// This is an abstract class which modelates all types of rotors and reflectors.
public abstract class Rotor {

    protected final int ROTORSIZE = 26;
    protected int position = 0;
    protected String name ="";
    protected int[] mapping=new int[26];

    // This method sets the position of the rotor.
    protected void setPosition(int position){
        this.position=position;
    }

    // This method returns the position of the rotor.
    protected int getPosition(){
        return position;
    }

    // This abstract method is being implemented in all subclasses.
    protected abstract void initialise (String name);

    // This abstract method is being implemented in all subclasses.
    protected abstract int substitute (int integer);

    // This abstract method is being implemented in BasicRotor and TurnoverRotor
    protected abstract void rotate();

    // This abstract method is being implemented in TurnoverRotor.
    protected abstract void setNextRotor(Rotor rotor);
}
