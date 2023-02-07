import java.util.Random;

public class SpiceMixGame{
  public SpiceMix solution;
  public ListNode head;
  public SpiceMixGame(SpiceMix solution){
    this.solution = solution;
    this.head = null;
  }

  //generate random solution
  public SpiceMixGame(){
    char[] mix = new char[5];
    Random rand = new Random();
    //loop 5 times
    for (int i=0; i<=4; i++){
      //'T'-'N' will give 5 because first position is 0, thus add 1 to generate random number between 1 to 6
      int toAdd = rand.nextInt(('T' - 'N') +1);
      mix [i] = (char)('N'+toAdd);
    }
    this.solution = new SpiceMix(mix);
    this.head = null;
  }

  //returns if new attempt is correct
  public boolean attemptSpiceMix(SpiceMix spiceMix){
    Attempt newAttempt = new Attempt(spiceMix, this.solution);
    if (this.head == null){
      this.head = new ListNode(newAttempt);
    }
    else{
      this.head = new ListNode(newAttempt, this.head);
    }
    return newAttempt.isCorrect();
  }

  //returns head of previous attempts
  public ListNode getPreviousAttempts(){
    return this.head;
  }

  //reuturns game solution
  public SpiceMix getSolution(){
    return this.solution;
  }
}
