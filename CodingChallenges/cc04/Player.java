public abstract class Player {
    private int id = 1111;
    private int score = 0;

    // public abstract int chooseMove();
    // public abstract String nextMove();

    public Player(int id) {
        this.setId(id);
    }

    public Player(Player toCopy) {
        this.setId(toCopy.getId());
        this.updateScore(toCopy.getScore());
    }

    public int getScore() {
        return this.score;
    }

    protected int getId() {
        return this.id;
    }
    
    protected void setId(int id) {
        if(id >= 1000 && id <= 9999) {
            this.id = id;
        }
        else {
            this.id = 1111;
        }
    }

    protected void updateScore(int amount) {
        if (amount >= 0) {
            this.score += amount;

        }
    }
    
    public void takeTurn() {
        int addToScore = chooseMove();
        if ((getScore() % 7) != 0){

            updateScore(addToScore/ (getScore() % 7));
        }
        else {
            updateScore(addToScore/ 1);
        }
    }

    public String getCategory() {
        if(score >= 0 && score <= 10) {
            return "beginner";
            
        }
        if(score >= 11 && score <= 100) {
            return "intermediate";
            
        }
        else {
            return "expert";
        }
    }

    public String toString() {
        return "ID: " + this.id + " Score: " + this.score + " nextMove: " + nextMove();
    }
    
}
