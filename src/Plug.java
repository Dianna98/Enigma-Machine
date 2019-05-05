public class Plug {

    private char end1;
    private char end2;

    // This constructor creates a plug with the given ends.
    protected Plug(char end1,char end2){
        this.end1 = end1;
        this.end2 = end2;
    }

    // This constructor creates an empty plug which helps in the addPlug method from the Plugboard.
    protected Plug() {
    }

    //This method returns the first end.
    protected char getEnd1() {
        return end1;
    }

    // This method returns the second end.
    protected char getEnd2() {
        return end2;
    }

    // This method sets the first end.
    protected void setEnd1(char setter1){
        end1 = setter1;
    }

    // This method sets the second end.
    protected void setEnd2(char setter2){
        end2 = setter2;
    }

    // This method checks if one of the two ends of the plug is the same as the given letter. If so, it retruns the other end.
    // If neither end is the same as the given letter, it returns the given character.
    protected char encode(char letterIn){
        if (getEnd1()==letterIn) {
            return getEnd2();
        }
        else if (getEnd2()==letterIn) {
            return getEnd1();
        }
        else {
            return letterIn;
        }
    }

    // This method checks if the given plug has common ends with another plug.
    protected Boolean clashesWith (Plug plugin) {
        if (plugin.getEnd1()==this.end1 || plugin.getEnd2()==this.end2 || plugin.getEnd1() == this.end2 || plugin.getEnd2() == this.end1){
            return true;
        }
        else {
            return false;
        }
    }
}
