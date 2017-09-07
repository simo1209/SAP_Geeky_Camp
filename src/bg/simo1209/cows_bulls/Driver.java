package bg.simo1209.cows_bulls;

public class Driver {
    public static void main(String[] args) {
        int digitCount = 4;
        CowsBulls cowsBulls = new CowsBulls(new ConsoleInput(),new NumberUtils(digitCount),new ConsoleOutput());
        cowsBulls.print();
        while (true){
            cowsBulls.guess = cowsBulls.inputHandler.receiveInput();
            cowsBulls.print();
            if(cowsBulls.utils.calcMatch(cowsBulls.guess.toCharArray()).getBulls()==digitCount){
                System.out.println("you won");
                break;
            }
            if (cowsBulls.guess.length() != digitCount) break;
        }
    }
}
