public class Attempt{
  private SpiceMix suggestion;
  private SpiceMix solution;
  private int numGood;
  private int numWrongQuantity;

  //Attempt class constructor
  public Attempt(SpiceMix suggestion, SpiceMix solution){
    this.suggestion = suggestion;
    this.solution = solution;
  }

  //returns suggested spice mix
  public SpiceMix getSpiceMix(){
    return this.suggestion;
  }

  //returns number of correct spices, i.e. right spice(character) and right quantity(position(s))
  public int getNumGood(){
    int numGood = 0;
    String checkedSpices = "";
    //loop 5 times
    for (int currentSpice = 0; currentSpice < 5; currentSpice++){
      char spice = this.solution.getSpice(currentSpice);
      int quantitySuggestion = this.getQuantity(spice, this.suggestion);
      int quantitySolution = this.getQuantity(spice, this.solution);
      //if quantity(position) of suggested and solution spice is the same,
      if (quantitySuggestion == quantitySolution){
        numGood ++;
      }
      checkedSpices += spice;
    }
    return numGood;
  }

  //returns number of right spice(character) but wrong quantity(position(s))
  public int getNumWrongQuantity(){
    int numWrong = 0;
    String checkedSpices = "";
    //loop 5 times
    for (int currentSpice = 0; currentSpice < 5; currentSpice++){
      char spice = this.solution.getSpice(currentSpice);
      int quantitySuggestion = this.getQuantity(spice, this.suggestion);
      int quantitySolution = this.getQuantity(spice, this.solution);
      //if quantity(position) of suggested and solution spice not same,
      if ((quantitySuggestion != quantitySolution) && (quantitySolution > 0) && (quantitySuggestion >0)){
        numWrong++;
      }
      checkedSpices += spice;
    }
    return numWrong;
  }

  //returns quantity of given spice in a suggestion
  public int getQuantity(char spice, SpiceMix suggested){
    int index = 0;
    //loop 5 times
    for (int i=0; i<=4; i++){
      //if spice position i of suggested is equal to spice given(can have multiple),
      if (suggested.getSpice(i) == spice){
        //add 1 in if statement so first position is 1 instead of 0 for every instance
        index += (i+1);
      }
    }
    return (index);
  }

  //returns if all spices are of correct character and position
  public boolean isCorrect(){
    if (getNumGood()==5){
      return true;
    }
    else{
      return false;
    }
  }

  //returns feedback in a formatted string
  public String toString(){
    return String.format("%s (Good %d, Wrong Quantity %d)", this.suggestion, this.numGood, this.numWrongQuantity);
  }
}
