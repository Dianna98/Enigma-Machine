public class Bombe {
    private EnigmaMachine myEnigma = new EnigmaMachine();

    // This method solves challenge1.
    private void challenge1(){
        myEnigma.clearPlugboard();
        System.out.println("Challenge 1:");

        String encodedMessage = "JBZAQVEBRPEVPUOBXFLCPJQSYFJI";
        String possibleWord = "ANSWER";
        StringBuilder decodedMessage = new StringBuilder();

        // The BasicRotors and the Reflector are added.
        myEnigma.addRotor(new BasicRotor("typeIV",8),0);
        myEnigma.addRotor(new BasicRotor("typeIII",4),1);
        myEnigma.addRotor(new BasicRotor("typeII", 21),2);
        myEnigma.setPosition(0, 8);
        myEnigma.setPosition(1, 4);
        myEnigma.setPosition(2, 21);
        myEnigma.addReflector(new Reflector("ReflectorI"));

        // The for loops go through all the possible combinations of plugs
        for (char missingEnd1='A'; missingEnd1<='Z';missingEnd1++){
            for(char missingEnd2='A';missingEnd2<='Z';missingEnd2++){

                // This condition does not allow same ends to create a plug.
                if(missingEnd1!=missingEnd2&&missingEnd1!='D'&&missingEnd1!='S'&&missingEnd2!='D'&&missingEnd2!='S')
                {
                    // The Plugs are being added to the EnigmaMachine
                    myEnigma.addPlug('D', missingEnd1);
                    myEnigma.addPlug('S', missingEnd2);

                    //The message is being reinitialised.
                    decodedMessage.delete(0, decodedMessage.length());

                    // The characters are being encoded.
                    char[] characters = encodedMessage.toCharArray();
                    for (char c : characters) {
                        //a StringBuilder is being created from the encoded letters
                        decodedMessage.append(myEnigma.encodeLetter(c));
                    }

                    // If the message contains the possible word then the plugs and the message is written.
                    if (decodedMessage.indexOf(possibleWord) >= 0) {
                        System.out.println("The first plug is [D," + missingEnd1 + "].");
                        System.out.println("The second plug is [S," + missingEnd2 + "].");
                        System.out.println("The decoded message is:      " + decodedMessage);
                    }
                }
                // The plugboard and the Rotors are being reinitialised.
                myEnigma.clearPlugboard();
                myEnigma.setPosition(0, 8);
                myEnigma.setPosition(1, 4);
                myEnigma.setPosition(2, 21);
            }
        }
        System.out.println("----------------------------");
    }

    private void challenge2(){
        myEnigma.clearPlugboard();
        System.out.println("Challenge 2:");

        String encodedMessage = "AVPBLOGHFRLTFELQEZQINUAXHTJMXDWERTTCHLZTGBFUPORNHZSLGZMJNEINTBSTBPPQFPMLSVKPETWFD";
        String possibleWord = "ELECTRIC";
        StringBuilder decodedMessage = new StringBuilder();

        // The plugs, the Rotors (on position 0 to start with)  and the Reflector are being added the the EnigmaMachine.
        myEnigma.addPlug('H','L');
        myEnigma.addPlug('G','P');
        myEnigma.addReflector(new Reflector("ReflectorI"));
        myEnigma.addRotor(new BasicRotor("typeV",0),0);
        myEnigma.addRotor(new BasicRotor("typeIII",0),1);
        myEnigma.addRotor(new BasicRotor("typeII",0),2);

        // The for loops go through all the possible combinations of positions.
        for (int i=0; i<26; i++){
            for (int j=0; j<26; j++){
                for (int k=0; k<26; k++){

                    // The positions are being set.
                    myEnigma.setPosition(0,i);
                    myEnigma.setPosition(1,j);
                    myEnigma.setPosition(2,k);

                    // The decoded message is being reinitialised.
                    decodedMessage.delete(0,decodedMessage.length());

                    // The characters are being encoded.
                    char[] characters = encodedMessage.toCharArray();
                    for (char c : characters) {
                        //a StringBuilder is being created from the encoded letters
                        decodedMessage.append(myEnigma.encodeLetter(c));
                    }

                    // If the message contains the possible word then the positions and the message is written.
                    if (decodedMessage.indexOf(possibleWord)>=0){
                        System.out.println("Rotors positions are, in order: "+i+", "+j+", "+k);
                        System.out.println("The decoded message is:      "+decodedMessage);
                    }

                }
            }
        }
        System.out.println("----------------------------");
    }

    private void challenge3(){
        myEnigma.clearPlugboard();

        System.out.println("Challenge 3:");

        String encodedMessage = "WMTIOMNXDKUCQCGLNOIBUYLHSFQSVIWYQCLRAAKZNJBOYWW";
        String possibleWord = "JAVA";
        StringBuilder decodedMessage = new StringBuilder();

        //The Plugs and the Reflector are being added.
        myEnigma.addPlug('M','F');
        myEnigma.addPlug('O','I');
        myEnigma.addReflector(new Reflector("ReflectorI"));

        // The for loops go through all the possible combinations of types of BasicRotors.
        // The if statements add a Rotor to the EnigmaMachine with the specific type, position and slot.
        for (int i = 1; i <= 5; i++) {

            if(i==1){
                myEnigma.addRotor(new BasicRotor("typeI", 22),0);
            }
            else if(i==2){
                myEnigma.addRotor(new BasicRotor("typeII", 22),0);
            }
            else if(i==3){
                myEnigma.addRotor(new BasicRotor("typeIII", 22),0);
            }
            else if(i==4){
                myEnigma.addRotor(new BasicRotor("typeIV", 22),0);
            }
            else if(i==5){
                myEnigma.addRotor(new BasicRotor("typeV", 22),0);
            }

            for (int j = 1; j <= 5; j++) {

                if(j==1){
                    myEnigma.addRotor(new BasicRotor("typeI", 24),1);
                }
                else if(j==2){
                    myEnigma.addRotor(new BasicRotor("typeII", 24),1);
                }
                else if(j==3){
                    myEnigma.addRotor(new BasicRotor("typeIII", 24),1);
                }
                else if(j==4){
                    myEnigma.addRotor(new BasicRotor("typeIV", 24),1);
                }
                else if(j==5){
                    myEnigma.addRotor(new BasicRotor("typeV", 24),1);
                }

                for (int k = 1; k <= 5; k++) {

                    if(k==1){
                        myEnigma.addRotor(new BasicRotor("typeI", 23),2);
                    }
                    else if(k==2){
                        myEnigma.addRotor(new BasicRotor("typeII", 23),2);
                    }
                    else if(k==3){
                        myEnigma.addRotor(new BasicRotor("typeIII", 23),2);
                    }
                    else if(k==4){
                        myEnigma.addRotor(new BasicRotor("typeIV", 23),2);
                    }
                    else if(k==5){
                        myEnigma.addRotor(new BasicRotor("typeV", 23),2);
                    }

                    // The positions are being reseted.
                    myEnigma.setPosition(0,22);
                    myEnigma.setPosition(1,24);
                    myEnigma.setPosition(2,23);

                    // The message is being reinitialised.
                    decodedMessage.delete(0, decodedMessage.length());

                    // The characters are being encoded.
                    char[] characters = encodedMessage.toCharArray();
                    for (char c : characters) {
                        //a StringBuilder is being created from the encoded letters
                        decodedMessage.append(myEnigma.encodeLetter(c));
                    }

                    // If the message contains the possible word then the types and the message are written.
                    if (decodedMessage.indexOf(possibleWord) >= 0) {
                        System.out.println("The first rotor is type "+i);
                        System.out.println("The second rotor is type "+j);
                        System.out.println("The third rotor is type "+k);
                        System.out.println("The decoded message is:    " + decodedMessage);
                    }
                }
            }
        }
        System.out.println("----------------------------");
    }

    //The main method calls all the challenges methods.
    public static void main (String[] args){
        Bombe test = new Bombe();
        test.challenge1();
        test.challenge2();
        test.challenge3();
    }

}