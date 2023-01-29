package uno;

class Hand {

    //Declare Array
    String[][] hand = new String[][]{
        {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}
    };
    String[][] cc = new String[][]{
        {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}
    };

//Declare local variables
    int numn = 0;
    int numc = 0;

    //Method to give the player and ai the starting hand
    public void starth(String[][] h) {

    }

    //Method to output the cards
    public void Display(String[][] h) {
    }
    
    //Method to decide Center card
    public void cc(int sel){
    }
    

    //Random Number generator for the value of the card
    public int randnumgen() {
        //This will choose and return the number
        int rand = (int) (Math.random() * 13 + 0);
        return rand;
    }

    //Random Number generator for the colour
    public int randcolgen() {
        //This will choose and return the number
        int rand = (int) (Math.random() * 4 + 1);
        return rand;
    }

    public String getColour(int sel) {
        return ("");
    }

    public String getNumber(int sel) {
        return ("");
    }

    public void setColour(String colp) {
        cc[1][0] = colp;
    }

    public void setNumber(String nump) {
        cc[0] [0] = nump;
    }


//Method to draw a card
    public void Draw(){
        int rand = 0;
        String col = "", num = "";
        rand = randnumgen();
        //This is for the num of the card
        switch(rand){
            case 0: num = "0"; break;
            case 1: num = "1"; break;
            case 2: num = "2"; break;
            case 3: num = "3"; break;
            case 4: num = "4"; break;
            case 5: num = "5"; break;
            case 6: num = "6"; break;
            case 7: num = "7"; break;
            case 8: num = "8"; break;
            case 9: num = "9"; break;
            case 10: num = "+2"; break;
            case 11: num = "+4"; break;
            case 12: num = "WD"; break;
        }
         //Call to the colour number generator
            if(num.equals("WD")  ||  num.equals("+4")){
                rand =0;
            }else{             
            rand = randcolgen();   
            }
        switch (rand) {
                case 1:col = "Blue";break;
                case 2:col = "Red";break;
                case 3:col = "Green";break;
                case 4:col = "Yellow"; break;
                default: col = ""; break;
        }
        
        //Call the store method
        Store(col, num);
}


    public void Store(String col, String num) {
        //This is the store method
        for(int i = 0; i < 24; i++){
            if(hand[0][i].equals("")){
                hand[1][i] = col;
                hand[0][i] = num;
                i = 25;
            }
        }
    }
    
    //This method will shift the cards up if a card is played
    public void Shift(){
        int counter = 0;
        String[][] temp = new String[][]{
        {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
        {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}
    };
        //This will store the hand array into the hand array
        
        for(int i = 0; i < 24; i++){
            if(hand[0][i].equals("")){
            //do nothing
            }else{
            temp[0][counter] = hand [0][i];
            temp[1][counter] = hand [1][i];
            counter++;
            }
        }
        //This will store the temp array back into the hand array
        for(int i = 0; i < 24; i++){
            hand[0][i] = temp [0][i];
            hand[1][i] = temp [1][i];
            if(temp[0][i].equals("")){
                hand[0][i] = "";
            hand[1][i] = "";
            }
        }
      }

    public void setColourp(int sel) {
       hand[1][sel] = "";
    }

    public void setNumberp(int sel) {
       hand[0][sel] = "";
    }
    

public int SearchAI(String col, String num){
        return 1000;
     }

//This will be called if AI has 1 Card
     public int LastCard(){
        return 0;
     }


}

