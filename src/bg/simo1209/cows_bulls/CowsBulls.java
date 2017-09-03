package bg.simo1209.cows_bulls;

public class CowsBulls implements Game{
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


    @Override
    public void print() {
        System.out.println(outputHandler.printMatch(guess.toCharArray(),utils.calcMatch(guess.toCharArray())));
    }
}
