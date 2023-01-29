package uno;
//Import Toolkits
import java.io.*;

public class Uno {
    
    public static void main(String[] args) throws IOException{
        //Declare Buffered Reader
            BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
            
            
        //Declare Variables
            long time = -1; //timer variable
            int selection = 12312312, colsel = 0, dummy = 0, aisel =0, decidepl=0, decideai=0, uno, sel = 0, wins = 0;
            boolean play = false;
            String col = "", num = "", colp = "", nump = "", colai= "", numai ="", name;
            
                    
        //Declare 2 2D Array list
         String[][]  ph = new String[2][25];
         String[][] aih = new String[2][25];
         String[][] cc = new String[2][25];
         
         //Start a timer
          time = System.currentTimeMillis();
          
         //Check who they are
         System.out.println("What is your name?");
         name = br.readLine();
         if (name.equals("kevin ku")||name.equals("ku")||name.equals("kevin")||name.equals("Mr. Ku")){
             System.out.println("Oh you're Kevin Ku? You automatically win!");
             
            time = System.currentTimeMillis() - time;
            
            System.out.println("The game Ended in: "+(time/1000) + " seconds");
             System.exit(0);
         }else{
             System.out.println("Oh, you're not the one im looking for...continue on then");
         }
              
            
        //Welcome the Player
            System.out.println("==================================================================================================================================\n                                                   Welcome to the game of Uno.\n==================================================================================================================================\nThis is a card game where you aim to clear your hand after you are dealt 7 cards.\nThere will be a center card where you will have to either match the colour or the number of the card to be able to play a card.\nIf no cards that meet these requirements are in your hand then you must draw a card.\nThere are also Wildcards which include a skip, draw four, draw two and a colour changer.\nWe have put a twist on this version adding a 'Mercy Rule' to where if you or the ai has more than 20 you lose.\nGoodluck and have fun trying to win against our AI. :)\n==================================================================================================================================");

        //Call to the Hand Super Class and create objects
            Hand player, ai, center;
            player = new Player();
            ai = new AI();
            center = new CenterCard();
            player.starth(ph);
            ai.starth(aih);
            
        //Display Center Card
        System.out.println("CENTER CARD:");
        center.cc(selection);
        center.Display(cc);
        
       while(decideai==0 || decidepl ==0){ 
          
        //Call to the method to display the hand for the player and the number of cards the ai has
        System.out.println("===================================================================================================================================");
        System.out.println("YOUR HAND:");
        player.Display(ph);
        ai.Display(aih);
        
        
            
        //Ask the user which card they would like to play and determine if they can play that card
        System.out.println("Which card would you like to play? i.e. (First card is 0, second card is 1 etc.)\nPress '20' To Draw A Card. ");
      
        while(true){
            //Error Check
            while (selection > 20 || selection <0) {
            try {
                selection = Integer.parseInt(br.readLine()); 
                if (selection > 20 || selection <0) {
                    System.out.println("Enter A Valid Amount");
                }
            } catch (Exception e) {
                System.out.println("Please Enter an Integer value:");
               
            }
            }
            
                 //Draw a card if player cannot go
        if(selection==20){
            player.Draw();
            System.out.println("You chose to Draw a Card");
            //Get the value of the center colour and number
            col = center.getColour(selection);
            num = center.getNumber(selection);
            
            break;
        }else {
            
            //Get the value of the center colour and number
            col = center.getColour(selection);
            num = center.getNumber(selection);
        
            
        //Get the value of the player colour and number
            colp = player.getColour(selection);
            nump = player.getNumber(selection);
         
        //Compare the player selection and the center card to see if it is playable
            if(col.equals(colp) || num.equals(nump) || nump.equals("WD") || nump.equals("+4")){
                System.out.println("Your selection was valid the new center card is now:");
                center.setColour(colp);
                center.setNumber(nump);
                center.Display(cc); 
                col= colp;
                num=nump;
                break;
            } else{
                System.out.println("Your selection was not valid.Please Choose a different card:");
                selection = -1;
            }
        }
        
       }     
        
            //If a Wild is played
            if (nump.equals("WD") && selection != 20){
                System.out.println("What colour would you like?\n1-Blue\n2-Red\n3-Green\n4-Yellow");
                while(colsel<1 || colsel >4){
            try {
                colsel = Integer.parseInt(br.readLine());
                if (colsel < 1 || colsel > 4) {
                    System.out.println("Enter A Valid Amount");
                }
            } catch (Exception e) {
                System.out.println("Please Enter an Integer value:");
            }
                        //Set the new colour
            switch (colsel) {
                case 1: center.setColour("Blue"); System.out.println("The colour chosen is Blue"); col = "Blue"; num="WD"; break;
                case 2: center.setColour("Red"); System.out.println("The colour chosen is Red");col = "Red"; num="WD";break;
                case 3: center.setColour("Green"); System.out.println("The colour chosen is Green"); col = "Green"; num="WD";break;
                case 4: center.setColour("Yellow"); System.out.println("The colour chosen is Yellow"); col = "Yellow"; num="WD";break;
            }
            center.setNumber("WD");
        }
            }
     
            
            //If a Wild is played
            if (nump.equals("+4") && selection != 20){
                System.out.println("What colour would you like?\n1-Blue\n2-Red\n3-Green\n4-Yellow");
                while(colsel<1 || colsel >4){
            try {
                colsel = Integer.parseInt(br.readLine());
                if (colsel < 1 || colsel > 4) {
                    System.out.println("Enter A Valid Amount");
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Please Enter an Integer value:");
            }
            //Set the new colour
            switch (colsel) {
                case 1: center.setColour("Blue"); System.out.println("The colour chosen is Blue"); col = "Blue"; num="+4"; break;
                case 2: center.setColour("Red"); System.out.println("The colour chosen is Red");col = "Red"; num="+4";break;
                case 3: center.setColour("Green"); System.out.println("The colour chosen is Green"); col = "Green"; num="+4";break;
                case 4: center.setColour("Yellow"); System.out.println("The colour chosen is Yellow"); col = "Yellow"; num="+4";break;
            }
            center.setNumber("+4");
        }
         
                //Draw 4 cards for the ai
                for(int i= 0; i<4; i++){
                    //Call method to draw the cards and store them
                    ai.Draw();
                }
                ai.Display(aih);
     }
                
            //If +2 is played draw 2  cards for the AI
            if (nump.equals("+2") && selection != 20){
                 for(int i= 0; i<2; i++){
                    //Call method to draw the cards and store them
                    ai.Draw();
                    
                }
                 
                ai.Display(aih);
            }

            //Clear the slot in players hand
                 player.setColourp(selection);
                 player.setNumberp(selection);
            
            //Shift the cards up
            player.Shift(); 
            
            //Decide if the player won or has uno
            decidepl = player.LastCard();
            if(decidepl==2 || decidepl ==1){
                
            time = System.currentTimeMillis() - time;
            System.out.println("The game Ended in: "+(time/1000) + " seconds");
                System.exit(0);
            }
            
            System.out.println("===================================================================================================================================");            
            System.out.println("AI'S Turn:");    
            
            //This will determine if the AI can play a card
            aisel = ai.SearchAI(col, num);
            if(aisel==-1){
                ai.Draw();
                System.out.println("The AI had to draw....");
                ai.Display(aih);
                center.Display(cc);
            }else{
                System.out.println("The AI plays:");
               colai = ai.getColour(aisel);
               numai =ai.getNumber(aisel);
            
                center.setColour(colai);
                center.setNumber(numai);
                center.Display(cc);
                col = colai;
                num = numai;
                
                System.out.println("Is the new center card.");
                 //Clear the slot in ai hand
                 ai.setColourp(aisel);
                 ai.setNumberp(aisel);
            }
            //Shift the Ai's Card
            ai.Shift();
            
            
            //Determine if the user must pick up cards
            if(numai.equals("+4") || numai.equals("+2") && aisel != -1){
                if(numai.equals("+4")){
                    System.out.println("You must draw 4 cards.");
                    for(int i=0; i<4; i++){
                        player.Draw();
                    }
                    //Let the ai choose a colour
                    colsel = ai.randcolgen();
                    switch (colsel) {
                case 1: center.setColour("Blue"); System.out.println("The colour chosen is Blue"); col = "Blue"; num="+4"; break;
                case 2: center.setColour("Red"); System.out.println("The colour chosen is Red");col = "Red"; num="+4";break;
                case 3: center.setColour("Green"); System.out.println("The colour chosen is Green"); col = "Green"; num="+4";break;
                case 4: center.setColour("Yellow"); System.out.println("The colour chosen is Yellow"); col = "Yellow"; num="+4";break;
            }
            center.setNumber("+4");
        }else if(numai.equals("+2") && aisel != -1){
                    System.out.println("You must draw 2 cards.");
                    for(int i=0; i<2; i++){
                        player.Draw();
                    }
                }
            }
            
            //Let the Ai Choose a colour if WD is played
            if(numai.equals("WD") && aisel != -1){
                colsel = ai.randcolgen();
            switch (colsel) {
                case 1: center.setColour("Blue"); System.out.println("The colour chosen is Blue"); col = "Blue"; num=""; break;
                case 2: center.setColour("Red"); System.out.println("The colour chosen is Red");col = "Red"; num="";break;
                case 3: center.setColour("Green"); System.out.println("The colour chosen is Green"); col = "Green"; num="";break;
                case 4: center.setColour("Yellow"); System.out.println("The colour chosen is Yellow"); col = "Yellow"; num="";break;
            }
            center.setNumber("WD");
            
            }
          
            decideai = ai.LastCard();
                
            
            
//Reset Selection
        selection = 100;
        colsel = 100;
    }
    }
}
