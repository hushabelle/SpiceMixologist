import java.util.List;
import java.util.ArrayList;
import java.lang.*;
import java.io.IOException;
//import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class PicnicPlanner{
  private PicnicItemStore fruitLoad;
  private CheeseStore cheeseLoad;
  private DrinkStore drinkLoad;

  public PicnicPlanner()throws IOException{
    fruitLoad = new PicnicItemStore("fruits.txt");
    cheeseLoad = new CheeseStore("cheeses.txt");
    drinkLoad = new DrinkStore("drinks.txt");
  }

  public List<String> generate(String input){
    //number of letters in a word
    int itemsToPrint = input.length();
    //number of letters sorted
    int sortedCount = 0;
    int cheeseCount = 0;
    int drinkCount = 0;
    String PicnicItem = "";
    List<String> picnicItemList = new ArrayList<>();
    //Boolean inLoop = true;
    int i=0;
    //while (inLoop) {
    //for (int i=0 ; i<itemsToPrint ; i++){
      char letter = input.charAt(i);
      String letterToGenerate = String.valueOf(letter);
  //  if (cheeseCount >= drinkCount) {
      if (itemsToPrint >= 1){
        PicnicItem = fruitLoad.getRandomItem(letterToGenerate);
        picnicItemList.add(PicnicItem + "\n");
        System.out.println(PicnicItem);
        sortedCount++;
        if (sortedCount == itemsToPrint) {
          break;
        }
        else{
          i++;
          continue;
        }
      }
      if (itemsToPrint >= 2){
        PicnicItem = cheeseLoad.getRandomItem(letterToGenerate);
        picnicItemList.add(PicnicItem + "\n");
        System.out.println(PicnicItem);
        sortedCount++;
        if (sortedCount == itemsToPrint) {
          break;
        }
        else{
          i++;
          continue;
        }
      }
      if (itemsToPrint >= 3){
        PicnicItem = drinkLoad.getRandomItem(letterToGenerate);
        picnicItemList.add(PicnicItem + "\n");
        System.out.println(PicnicItem);
        sortedCount++;
        if (sortedCount == itemsToPrint) {
          break;
        }
        else{
          i++;
          continue;
        }
      }
  //  }
  //}
  //}
  return picnicItemList;
}

  public static void main (String args[]) throws IOException{
    //System.out.println("Enter name: ");
    BufferedReader breader = new BufferedReader(new InputStreamReader(System.in));
    String picnicIn = breader.readLine();
    PicnicPlanner wordToGenerate = new PicnicPlanner();
    wordToGenerate.generate(picnicIn);
  }
}

// >=1 one fruit
// >=2 one cheese
// >=3 one drink
// cheese and drinks must same number
