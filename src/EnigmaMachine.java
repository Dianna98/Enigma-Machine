// Imports
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnigmaMachine {

    public Plugboard myPlugboard;
    private BasicRotor[] rotors = new BasicRotor[3];
    private Reflector newReflector;

    // The constructor initialises a new Plugboard.
    protected EnigmaMachine(){
        myPlugboard = new Plugboard();
    }

    // This method adds a new Plug in the Plugboard.
    protected void addPlug(char end1, char end2){
        myPlugboard.addPlug(end1, end2);
    }

    // This method removes all the Plugs from the Plugboard.
    protected void clearPlugboard(){
        myPlugboard.clear();
    }

    // This method adds a Rotor in the specified slot to the EnigmaMachine.
    protected void addRotor(BasicRotor rotor,int slot){
        rotors[slot] = rotor;
    }

    // This method returns the rotor from the given slot from the Enigma Machine.
    protected BasicRotor getRotor(int slot){
        return rotors[slot];
    }

    // This method adds a Reflector to the Enigma Machine.
    protected void addReflector(Reflector reflector){
        newReflector = reflector;
    }

    // This method returns the Reflector from the Enigma Machine.
    protected Reflector getReflector(){
        return newReflector;
    }

    // This method sets the position of the Rotor from the given slot.
    protected void setPosition(int slot, int position){
        rotors[slot].setPosition(position);
    }

    // This method encodes a letter.
    protected char encodeLetter(char letterToEncode){

        // The letter to encode is being substituted in the Plugboard with the encoded letter.
        char encodedLetter = myPlugboard.substitute(letterToEncode);
        // The encoded letter is changed in an integer.
        int integerLetter = encodedLetter - 'A';

        // The letter is being changed in every one of the Rotors.
        for(int i = 0; i< rotors.length; i++){
            integerLetter = rotors[i].substitute(integerLetter);
        }

        // The letter is being substituted in the Reflector.
        integerLetter = getReflector().substitute(integerLetter);

        // The letter goes back to every Rotor and is being substituted back.
        for(int i = rotors.length-1; i>=0; i--){
            integerLetter = rotors[i].substituteBack(integerLetter);
        }

        // The encoded letter is being substituted again in the Plugboard with the equivalent of the letter as an integer.
        encodedLetter = myPlugboard.substitute((char)(integerLetter + 'A'));

        // The encoded letter could be printed directly using the following command:
        //System.out.print(encodedLetter);

        //The first Rotor rotates.
        rotors[0].rotate();
        return encodedLetter;
    }

    // This method lets the use to input a message and prints the output.
    protected void start(){
        clearPlugboard();

        String message = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            message = reader.readLine();
            message = message.toUpperCase();
        }
        catch(IOException e){
            System.err.println("Unexpected error while reading from the keyboard");
        }

        // The configurations are being made.
        configuration();

        // The message is being encoded and printed on the screen.
        StringBuilder decodedMessage = new StringBuilder();
        char[] characters = message.toCharArray();
        for (char c : characters) {
            decodedMessage.append(encodeLetter(c));
        }
        System.out.println(decodedMessage);

        // In the following comment are the given tests from 1 to 3.
        /*System.out.print("Test 1:  ");
        test1();
        System.out.println();

        System.out.print("Test 2:  ");
        test2();
        System.out.println();

        System.out.print("Test 3:  ");
        test3();
        System.out.println();*/
    }

    // The main method creates a new EnigmaMachine object and calls the start() method.
    public static void main (String[] args){
        EnigmaMachine enigma = new EnigmaMachine();
        enigma.start();
    }

    // This method sets the configuration for the EnigmaMachine.
    // It adds Plugs, Rotors and a Reflector.
    protected void configuration(){
        addPlug('A','M');
        addPlug('G','L');
        addPlug('E','T');
        addRotor(new BasicRotor("typeI", 6),0);
        addRotor(new BasicRotor("typeII",12),1);
        addRotor(new BasicRotor("typeIII", 5), 2);
        addReflector(new Reflector("ReflectorI"));
    }

    // This method checks the test1 from the instructions.
    protected void test1(){
        clearPlugboard();
        String message = "GFWIQH";
        addPlug('A','M');
        addPlug('G','L');
        addPlug('E','T');
        addRotor(new BasicRotor("typeI", 6),0);
        addRotor(new BasicRotor("typeII",12),1);
        addRotor(new BasicRotor("typeIII", 5), 2);
        addReflector(new Reflector("ReflectorI"));

        StringBuilder decodedMessage = new StringBuilder();
        char[] characters = message.toCharArray();
        for (char c : characters) {
            decodedMessage.append(encodeLetter(c));
        }
        System.out.println(decodedMessage);
    }

    // This method checks the test2 from the instructions.
    protected void test2(){
        clearPlugboard();
        String message = "GACIG";
        addPlug('B','C');
        addPlug('R','I');
        addPlug('S','M');
        addPlug('A','F');
        addRotor(new BasicRotor("typeIV",23),0);
        addRotor(new BasicRotor("typeV", 4),1);
        addRotor(new BasicRotor("typeII", 9),2);
        addReflector( new Reflector("ReflectorII"));

        StringBuilder decodedMessage = new StringBuilder();
        char[] characters = message.toCharArray();
        for (char c : characters) {
            decodedMessage.append(encodeLetter(c));
        }
        System.out.println(decodedMessage);

    }

    // This method checks the test3 from the instructions.
    protected void test3(){
        clearPlugboard();
        String message = "OJVAYFGUOFIVOTAYRNIWJYQWMXUEJGXYGIFT";
        addPlug('Q','F');
        addRotor(new TurnoverRotor("typeI",23),0);
        addRotor(new TurnoverRotor("typeII", 11), 1);
        rotors[0].setNextRotor(rotors[1]);
        addRotor(new TurnoverRotor("typeIII", 7),2);
        rotors[1].setNextRotor(rotors[2]);
        addReflector(new Reflector("ReflectorI"));

        StringBuilder decodedMessage = new StringBuilder();
        char[] characters = message.toCharArray();
        for (char c : characters) {
            decodedMessage.append(encodeLetter(c));
        }
        System.out.println(decodedMessage);

    }
}
