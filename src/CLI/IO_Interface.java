package CLI;

import Logic.Coordinates;
import Logic.PieceColor;
import Logic.Player;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class IO_Interface {

    private final Scanner scanner;

    public IO_Interface() {
        scanner = new Scanner(System.in);
    }


    public String ChooseInterface(){
        String res = "";
        System.out.println("Welcome to Brique!");
        boolean valid = false;
        System.out.println("Do you want to play with GUI? type yes or no");
        while(valid==false){
            String input = scanner.next();
            if(input.equals("yes")){
                valid = true;
                res =  "GUI";
            }
            else if(input.equals("no")){
                valid = true;
                res =  "CLI";}
            else{
                System.out.println("not a valid answer! try again.");
            }
        }
        return res;
    }

    public String getName(PieceColor control) {
        System.out.println("Enter name for " + control.toString() + " player:");
        return scanner.next();
    }

    Coordinates getCoordinates(Player player) {
        System.out.println(player.getName() + "'s move.");
        int r, c;
        boolean valid = false;
        Coordinates coordinates = new Coordinates(-1,-1);
        System.out.println("Insert coordinates or type 'res' to resign:");

        while(!valid) {
            String input = scanner.next();
            if (input.equals("res")) {
                player.setResigned();
                coordinates.setCoordinates(-1,-1);
                return coordinates;
            }
            if(!input.substring(0,1).matches("[a-o]") || !input.substring(1).matches("[0-9]+")){
                System.out.println("Not valid, please insert again (a-o and 1-15, e.g. f3)");
                continue;
            }
            c = input.charAt(0) -'a';
            r = 15 - Integer.parseInt(input.substring(1));
            coordinates.setCoordinates(r,c);
            valid = coordinates.areValid();
            if(!valid) System.out.println("Coordinates are not valid or position is already occupied, please insert again:");
        }
        return coordinates;
    }

    boolean getPieRule(Player current_player) {
        System.out.println(current_player.getName() + " has to choose whether to apply the pie rule or not.");
        System.out.println("If you want to apply the pie rule, type 1, otherwise type 0");
        boolean status = false;
        boolean valid = false;
        while(!valid){
            System.out.println("Insert your decision: ");
            String input = scanner.next();
            if(input.matches("[0-1]")){
                valid=true;}
            else {
                System.out.println("Please type 0 or 1.");
                continue;
            }
            if (input.matches("[1]")){
                status=true;
            }
        }
        return status;
    }

    public int getMenuChoice(){
        AtomicBoolean valid = new AtomicBoolean(false);
        AtomicReference<String> input;
        input = new AtomicReference<>("2");
        while(!valid.get()){
            input.set(scanner.next());
            if(!input.get().matches("[0-2]")){
                System.out.println("Not valid, please insert again a number between 0 and 2:");
                continue;
            }
            valid.set(true);
        }
        return Integer.parseInt(input.get());
    }
}