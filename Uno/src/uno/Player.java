
package uno;

public class Player extends Hand{
    
     public Player(){
        super();
    }
     
     @Override
     public void starth(String[][] h) {

        //Create a loop to determine the hand
        for (int i = 0; i < 7; i++) {

            //Call to the value number generator
            numn = randnumgen();

            //This switch case will determine what the value is for the card
            switch (numn) {
                case 0:hand[0][i] = "0"; break;
                case 1:hand[0][i] = "1";break;
                case 2:hand[0][i] = "2";break;
                case 3:hand[0][i] = "3";break;
                case 4:hand[0][i] = "4";break;
                case 5:hand[0][i] = "5";break;
                case 6:hand[0][i] = "6";break;
                case 7:hand[0][i] = "7";break;
                case 8:hand[0][i] = "8";break;
                case 9:hand[0][i] = "9";break;
                case 10:hand[0][i] = "+2";break;
                case 11:hand[0][i] = "+4";break;
                case 12:hand[0][i] = "WD";break;
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
        for (int i = 0; i < 24; i++) { 
            
            switch (hand[0][i]) {
                case "":
                    break;
                case "+4":
                case "WD":
                    System.out.println("--------\n"
                            + "|      |\n"                            
                            + "|  " + hand[0][i] + "  |\n"
                            + "|      |\n"
                            + "--------");
                    break;
                case "+2":
                    switch(hand[1][i]){
                        case "Blue":
                            System.out.println("--------\n"
                            + "|  " + hand[0][i] + "  |\n"
                            + "|      |\n"
                            + "| Blue |\n"
                            + "--------");
                            break;
                        case "Red":
                            System.out.println("--------\n"
                            + "|  " + hand[0][i] + "  |\n"
                            + "|      |\n"
                            + "| Red  |\n"
                            + "--------");
                            break;
                        case "Green":
                            System.out.println("--------\n"
                            + "|  " + hand[0][i] + "  |\n"
                            + "|      |\n"
                            + "|Green |\n"
                            + "--------");
                            break;
                        case "Yellow":
                            System.out.println("--------\n"
                            + "|  " + hand[0][i] + "  |\n"
                            + "|      |\n"
                            + "|Yellow|\n"
                            + "--------");
                            break;
                    }
                    break;
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
            //DISPLAY NUMBER CARDS
            switch (hand[1][i]) {
               case "Blue":
                            System.out.println("--------\n"
                            + "|  " + hand[0][i] + "   |\n"
                            + "|      |\n"
                            + "| Blue |\n"
                            + "--------");
                            break;
                        case "Red":
                            System.out.println("--------\n"
                            + "|  " + hand[0][i] + "   |\n"
                            + "|      |\n"
                            + "| Red  |\n"
                            + "--------");
                            break;
                        case "Green":
                            System.out.println("--------\n"
                            + "|  " + hand[0][i] + "   |\n"
                            + "|      |\n"
                            + "|Green |\n"
                            + "--------");
                            break;
                        case "Yellow":
                            System.out.println("--------\n"
                            + "|  " + hand[0][i] + "   |\n"
                            + "|      |\n"
                            + "|Yellow|\n"
                            + "--------");
                            break;
            }
            break;
            }
        }
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
          System.out.println("Player has reached UNO!");
      }else if (counter == 0){
          System.out.println("YOU WON!!!");
          return 2;
      } else if (counter == 20){
          System.out.println("YOU HAVE SUCCUMBED TO THE MERCY RULE :(\nAI WON!!!");
          return 1;
      }
      return(0);
     }

}



