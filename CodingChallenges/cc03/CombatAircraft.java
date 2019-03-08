public class CombatAircraft extends Aircraft {
  public static void main(String[] args) {

  }

  private String type;

  public CombatAircraft(String name, String anOrigin, int aSpeed, String aType) {
    super(name, anOrigin, aSpeed);
    if(aType == "Attack" || aType == "Interceptor" || aType == "Fighter") {
      this.type = aType;
    }
    else {
      this.type = null;
    }
  }

  public CombatAircraft(CombatAircraft toCopy) {
    super(toCopy.getName(), toCopy.getOrigin(), toCopy.getSpeed());
    this.type = toCopy.getType();
  }

  public String getType() {
    return this.type;
  }

  public void setType(String aType) {
    if(aType == "Attack" || aType == "Interceptor" || aType == "Fighter") {
      this.type = aType;
    }
    else {
      this.type = null;
    }
  }

  public char getAircraftCategoryBySpeed() {
    if(this.getSpeed() <= 550) {
      if(getType() == "Interceptor") {
        return 68; // d for Interceptor
      }
      else if(getType() == "Attack") {
        return 66;
      }
      else if(getType() == "Fighter") {
        return 66;
      }
      else {
        return 65; // a
      }
    }
    else if(this.getSpeed() >= 551 && this.getSpeed() < 750) {
      if(getType() == "Attack") {
        return 67; // c for attack
      }
      else if(getType() == "Interceptor") {
        return 65;
      }
      else if(getType() == "Fighter") {
        return 68;
      }
      else {
        if(getType() == "Interceptor") {
          return 65;
        }
        return 66; // b
      }
    }
    else {
      if(getType() == "Attack") {
        return 68;
      }
      else if(getType() == "Fighter") {
        return 65;
      }
      if(getType() == "Interceptor") {
        return 66;
      }
      return 67; // c
    }
    // return 'c';
    // return 'a';
  }

}
