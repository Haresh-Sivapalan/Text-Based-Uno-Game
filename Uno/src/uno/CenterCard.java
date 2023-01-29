package uno;

public class CenterCard extends Hand{
        
     public CenterCard(){
        super();
    }
     
      //Method to decide on the center card
     @Override
    public void cc(int sel){
        if(sel==12312312){
            //Create a center card
             //Call to the value number generator
            numn = randnumgen();

            //This switch case will determine what the value is for the card
            switch (numn) {
                case 0:cc[0][0] = "0"; break;
                case 1:cc[0][0] = "1";break;
                case 2:cc[0][0] = "2";break;
                case 3:cc[0][0] = "3";break;
                case 4:cc[0][0] = "4";break;
                case 5:cc[0][0] = "5";break;
                case 6:cc[0][0] = "6";break;
                case 7:cc[0][0] = "7";break;
                case 8:cc[0][0] = "8";break;
                case 9:cc[0][0] = "9";break;
                default: cc[0][0] = "0"; break;
            }

            //Call to the colour number generator
            numc = randcolgen();

            //This switch case will determine what the number is for the card
            switch (numc) {
                case 1:cc[1][0] = "Blue";break;
                case 2:cc[1][0] = "Red";break;
                case 3:cc[1][0] = "Green";break;
                case 4:cc[1][0] = "Yellow";break;
            }
        }else{
            
        }
    }    
     
     //Display Method for the center card
    @Override
    public void Display(String[][] h) {
            //Display for wildcards
            switch (cc[0][0]) {
                case "":
                    break;
                case "+4":
                case "WD":
                    System.out.println("--------\n"
                            + "|      |\n"                            
                            + "|  " + cc[0][0] + "  |\n"
                            + "|      |\n"
                            + "--------");
                    break;
                case "+2":
                    switch(cc[1][0]){
                        case "Blue":
                            System.out.println("--------\n"
                            + "|  " + cc[0][0] + "  |\n"
                            + "|      |\n"
                            + "| Blue |\n"
                            + "--------");
                            break;
                        case "Red":
                            System.out.println("--------\n"
                            + "|  " + cc[0][0] + "  |\n"
                            + "|      |\n"
                            + "| Red  |\n"
                            + "--------");
                            break;
                        case "Green":
                            System.out.println("--------\n"
                            + "|  " + cc[0][0] + "  |\n"
                            + "|      |\n"
                            + "|Green |\n"
                            + "--------");
                            break;
                        case "Yellow":
                            System.out.println("--------\n"
                            + "|  " + cc[0][0] + "  |\n"
                            + "|      |\n"
                            + "|Yellow|\n"
                            + "--------");
                            break;
                    }
                    break;
                    
                 //Display for Number cards
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
            switch (cc[1][0]) {
               case "Blue":
                            System.out.println("--------\n"
                            + "|  " + cc[0][0] + "   |\n"
                            + "|      |\n"
                            + "| Blue |\n"
                            + "--------");
                            break;
                        case "Red":
                            System.out.println("--------\n"
                            + "|  " + cc[0][0] + "   |\n"
                            + "|      |\n"
                            + "| Red  |\n"
                            + "--------");
                            break;
                        case "Green":
                            System.out.println("--------\n"
                            + "|  " + cc[0][0] + "   |\n"
                            + "|      |\n"
                            + "|Green |\n"
                            + "--------");
                            break;
                        case "Yellow":
                            System.out.println("--------\n"
                            + "|  " + cc[0][0] + "   |\n"
                            + "|      |\n"
                            + "|Yellow|\n"
                            + "--------");
                            break;
            }
            break;
            }
        }
    
    
    //This will get the colour
     @Override
    public String getColour(int sel) {
        
        return cc[1][0];
    }
    
    //This will get the number
     @Override
    public String getNumber(int sel) {
      
        return cc[0][0];
    }
  
     @Override
    public void setColour(String colp) {
        cc[1][0] = colp;
    }

     @Override
    public void setNumber(String nump) {
        cc[0] [0] = nump;
    }
    
}

