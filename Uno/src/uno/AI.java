
package uno;

public class AI extends Hand{
    
     public AI(){
        super();
    }
     
     //Generates the Ai's starting hand
   @Override
   public void starth(String[][] h) {

        //Create a loop to determine the hand
        for (int i = 0; i < 7; i++) {

            //Call to the value number generator
            numn = randnumgen();

            //This switch case will determine what the value is for the card
            switch (numn) {
                case 0:
                    hand[0][i] = "0";
                    break;
                case 1:
                    hand[0][i] = "1";
                    break;
                case 2:
                    hand[0][i] = "2";
                    break;
                case 3:
                    hand[0][i] = "3";
                    break;
                case 4:
                    hand[0][i] = "4";
                    break;
                case 5:
                    hand[0][i] = "5";
                    break;
                case 6:
                    hand[0][i] = "6";
                    break;
                case 7:
                    hand[0][i] = "7";
                    break;
                case 8:
                    hand[0][i] = "8";
                    break;
                case 9:
                    hand[0][i] = "9";
                    break;
                case 10:
                    hand[0][i] = "+2";
                    break;
                case 11:
                    hand[0][i] = "+4";
                    break;
                case 12:
                    hand[0][i] = "WD";
                    break;
            }

            //Call to the colour number generator
            if(hand[0][i].equals("WD")  ||  hand[0][i].equals("+4")){
                numc =0;
            }else{             
            numc = randcolgen();   
            }
            

            //This switch case will determine what the number is for the card
            switch (numc) {
                case 1:
                    hand[1][i] = "Blue";
                    break;
                case 2:
                    hand[1][i] = "Red";
                    break;
                case 3:
                    hand[1][i] = "Green";
                    break;
                case 4:
                    hand[1][i] = "Yellow";
                    break;
                default: hand[1][i] = "";break;
                    
            }

        }

    }

     
     
     
     
     //Display Method for the players cards
    @Override
    public void Display(String[][] h) {
      int counter = 0;    
      for(int i = 0; i < 24; i++){
            if(hand[0][i].equals("")){
            //do nothing
            }else{
            counter ++;
                    }
            }
        System.out.println("The AI has " + counter + " cards left.......");
    }
    
//This method will search for the number and colour
     @Override
     public int SearchAI(String col, String num){
        for(int i = 0; i < 24; i++){
        if(hand[0][i].equals(num) || hand[1][i].equals(col)) {
            return i;
    }
  }
        return -1;
     }

 //This will get the colour
     @Override
    public String getColour(int sel) {
        
        return hand[1][sel];
    }
    
    
  //This will get the number
     @Override
    public String getNumber(int sel) {
      
        return hand[0][sel];
    }
    
    //This will be called if AI has 1 Card
     @Override
     public int LastCard(){
         int counter = 0;
      for(int i = 0; i < 24; i++){
            if(hand[0][i].equals("")){
            //do nothing
            }else{
            counter ++;
                    }
            }
      if (counter == 1){
          System.out.println("AI has reached UNO!");
      }else if (counter == 0){
          System.out.println("AI HAS WON!!!");
          return 2;
      } else if (counter == 20){
          System.out.println("AI HAS SUCCUMBED TO THE MERCY RULE :(\nYOU WON!!!");
          return 1;
      }
      return(0);
     }

}




