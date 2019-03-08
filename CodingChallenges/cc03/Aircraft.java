public class Aircraft {
  public static void main(String[] args) {

  }

  private String name;
  private String origin;
  private int speed;

  public Aircraft(String aName, String anOrigin, int aSpeed) {
    this.setName(aName);
    this.setOrigin(anOrigin);
    this.setSpeed(aSpeed);
  }

  public Aircraft(Aircraft toCopy) {
    this.setName(toCopy.getName());
    this.setSpeed(toCopy.getSpeed());
    this.setOrigin(toCopy.getOrigin());
  }

  public String getName() {
    return this.name.toLowerCase();
  }

  public void setName(String aName) {
    this.name = aName;
  }

  public String getOrigin() {
    return this.origin.toUpperCase();
  }


  public void setOrigin(String anOrigin) {
    this.origin = anOrigin;
  }
  public int getSpeed() {
    return this.speed;
  }

  public void setSpeed(int aSpeed) {
    if (aSpeed > 0 ) {
      this.speed = aSpeed;
    }
  }

  public char getAircraftCategoryBySpeed() {
    if(this.getSpeed() <= 550) {
      return 65; // a
    }
    else if(this.getSpeed() >= 551 && this.getSpeed() < 750) {
      return 66; // b
    }
    // else if(this.getSpeed() >= 751) {
    else {
      return 67; // c
    }
    // return 'c';
  }

  public String toString() {
    return "Name: " + getName() + " Origin: " + getOrigin() + " Aircraft Category: " + getAircraftCategoryBySpeed();
  }

}
