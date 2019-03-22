import java.util.Random;

public class SmartAI extends Player{
    Random random = new Random();

    public SmartAI(int id) {
        super(id);
    }

    public SmartAI(SmartAI toCopy) {
        super(toCopy);
    }

    // @Override
    // public int chooseMove() {
    //     int largest = 0;
    //     int currentScore = this.getScore();
    //     if(currentScore  == 0) {
    //         return 99;
    //     }
    //     if(currentScore  > 108) {
    //         return 95;
    //     }
    //     if(currentScore  == 11) {
    //         return 95;
    //     }
    //     if(currentScore  == 122) {
    //         return 96;
    //     }
    //     for (int i = 0; i < 101; i++) {
    //         if ((((currentScore += i) % 7) == 0) || ((currentScore += i) % 7) == 1) {
    //             largest = i;
    //         }
    //     }
    //     return largest;
    // }

    // @Override
    // public String nextMove() {
    //     return String.valueOf(chooseMove());
    // }

    public String toString() {
        return "[Smart] " + super.toString();
    }
}
