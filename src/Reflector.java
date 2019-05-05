public class Reflector extends Rotor {

    private int[] reflectorI= new int[]{ 24, 17, 20, 7, 16, 18, 11, 3, 15, 23, 13, 6, 14, 10, 12, 8, 4, 1, 5, 25, 2, 22, 21, 9, 0, 19 };
    private int[] reflectorII= new int[]{ 5, 21, 15, 9, 8, 0, 14, 24, 4, 3, 17, 25, 23, 22, 6, 2, 19, 10, 20, 16, 18, 1, 13, 12, 7, 11 };

    // The constructor gets a name and initialises the Reflector.
    protected Reflector(String name){
        this.name=name;
        initialise(name);
    }

    // This method initialises each Reflector with the mapping given in the instructions.
    protected void initialise(String name ) {
        if (name.equals("ReflectorI")) {
            mapping = reflectorI;
        }
        else if (name.equals("ReflectorII")) {
            mapping = reflectorII;
        }
        else{
            // This message reminds the user what Reflectors can use if an inappropriate one is selected.
            System.out.println("Choose from one of the available Reflectors (ReflectorI or ReflectorII).");

        }
    }

    // This method returns the number corresponding to the given element from the mapping.
    protected int substitute(int number){
        return mapping[number];
    }

    // The following methods are not implemented in this class.
    protected void rotate(){}
    protected void setNextRotor(Rotor rotor){}

}