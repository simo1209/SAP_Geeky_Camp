package bg.simo1209.cows_bulls;

public class CowsBulls{
    InputHandler inputHandler;
    String guess;

    SequenceUtils utils;

    OutputHandler outputHandler;

    public CowsBulls(InputHandler inputHandler, SequenceUtils utils, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.guess = this.inputHandler.receiveInput();

        this.utils = utils;
        this.outputHandler = outputHandler;

    }

    public void print() {
        System.out.println(outputHandler.printMatch(guess.toCharArray(),utils.calcMatch(guess.toCharArray())));
    }
}
