import java.util.Random;

public class RandomAI extends Player{
    private int level = 1;
    Random random = new Random();

    public RandomAI(int id, int level) {
        super(id);
        this.setLevel(level);
    }

    public RandomAI(RandomAI toCopy) {
        super(toCopy);
        this.setLevel(toCopy.level);
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        if (level > 0 && level < 11) {
            this.level = level;
        }
    }

    @Override
    public int chooseMove() {
        return random.nextInt(10) * level;
    }

    @Override
    public String nextMove() {
        return "Random";
    }

    public String toString() {
        return "[Random Level " + level + "] " + super.toString();
    }
}
