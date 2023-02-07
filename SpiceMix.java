public class SpiceMix{
  //initialise fiveSpices as a char array of length 5
  private char[] fiveSpices = new char[5];

  //assign spiceInput as char array, fiveSpices
  public SpiceMix(char[] spiceInput){
    fiveSpices = spiceInput;
  }

  //return spice at position i
  public char getSpice(int i){
    return fiveSpices[i];
  }

  //returns spices separated by spaces
  public String toString(){
    String lines = "";
    int i =0;
    for (i=0; i<4; i++){
      lines += fiveSpices[i];
      lines += " ";
    }
    lines += fiveSpices[i];
    return lines ;
  }
}
