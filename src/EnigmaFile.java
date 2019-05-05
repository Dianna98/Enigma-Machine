import java.io.*;
import java.util.ArrayList;

public class EnigmaFile {

    public static void main(String[] args) {
        EnigmaMachine myEnigma = new EnigmaMachine();
        ArrayList<String> text = new ArrayList<String>();
        ArrayList<String> convert = new ArrayList<String>();

        //This is an EXTENSION which converts the input file into appropriate text for encoding.
        try {
            BufferedReader in = new BufferedReader(new FileReader("EnigmaInput.txt"));
            String line = null;
            StringBuilder message=new StringBuilder();

            // This loop works until the end of file is reached.
            while ((line=in.readLine()) != null) {
                // The value of the StringBuilder is being reinitialised with the next line of the file capitalised.
                message.delete(0, message.length());
                message.append(line.toUpperCase());

                int i = 0;
                // This structure loops over the StringBuilder and deletes spaces and punctuation.
                while (i < message.length()) {
                    if ((message.charAt(i) <'A') || (message.charAt(i)>'Z')){
                        message.deleteCharAt(i);
                    }
                    else {
                        i++;
                    }
                }
                // The result is added to an ArrayList.
                convert.add(message.toString());
            }
            in.close();
        }
        catch (FileNotFoundException e){
            System.err.println("Unable to open file 'EnigmaInput.txt'");
        }
        catch(IOException e){
            System.out.println("Error reading file 'EnigmaInput.txt'");
        }

        try{
            BufferedWriter out = new BufferedWriter(new FileWriter("EnigmaInput.txt"));

            // This structure loops over the previously created ArrayList and writes in the same 'EnigmaInput.txt' file the Strings.
            for(String message : convert) {
                out.write(message);
                out.newLine();
            }
            out.close();
        }
        catch(IOException e){
            System.out.println("Error writing to file 'EnigmaInput.txt'");
        }

        // This command calls the configuration() method from the EnigmaMachine in orfer to add Plugs, Rotors and a Reflector.
        myEnigma.configuration();

        // This block reads from 'EnigmaInput.txt' file and adds into an ArrayList each encoded line.
        try {
            BufferedReader in = new BufferedReader(new FileReader("EnigmaInput.txt"));
            String line = null;
            StringBuilder message=new StringBuilder();

            // This loop works until the end of file is reached.
            while ((line=in.readLine()) != null){

                message.delete(0,message.length());

                // This structure loops through every character from each line and creates an encoded StringBuilder.
                for (char c : line.toCharArray()) {
                    message.append(myEnigma.encodeLetter(c));
                }
                // The result is added to an ArrayList.
                text.add(message.toString());
            }

            in.close();
        }
        catch (FileNotFoundException e){
            System.err.println("Unable to open file 'EnigmaInput.txt'");
        }
        catch(IOException e){
            System.out.println("Error reading file 'EnigmaInput.txt'");
        }

        try{
            BufferedWriter out = new BufferedWriter(new FileWriter("EnigmaOutput.txt"));

            // This structure loops over the previously created ArrayList and writes in 'EnigmaOutput.txt' the encoded message.
            for(String message : text) {
                out.write(message);
                out.newLine();
            }
            out.close();
        }
        catch(IOException e){
            System.out.println("Error writing to file 'EnigmaOutput.txt'");
        }
    }
}