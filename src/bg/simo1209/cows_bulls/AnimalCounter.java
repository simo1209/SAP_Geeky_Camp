package bg.simo1209.cows_bulls;

public class AnimalCounter {
    private int bulls;
    private int cows;

    public int getCows() {
        return cows;
    }

    public void setCows(int cows) {
        this.cows = cows;
    }

    public int getBulls() {
        return bulls;
    }

    public void setBulls(int bulls) {
        this.bulls = bulls;
    }

    public AnimalCounter() {
        this.bulls=0;
        this.cows=0;
    }

    public void increaseBulls(int i){
        this.bulls+=i;
    }

    public void increaseCows(int i){
        this.cows+=i;
    }
}
