//linked list data structure storing the list of attempts
public class ListNode{
  private Attempt payload;
  private ListNode next;

  //initialise linked list nodes
  public ListNode(Attempt payload, ListNode next){
    this.payload = payload;
    this.next = next;
  }

  //for end of linked list
  public ListNode(Attempt payload){
    this.payload = payload;
    this.next = null;
  }

  public Attempt getPayload(){
    return this.payload;
  }

  public ListNode getNext(){
    return this.next;
  }

  //string representation of list
  public String toString(){
    String stringBuilder ="";
    for (ListNode cursor = this; cursor!= null; cursor=cursor.getNext()){
      stringBuilder += cursor.getPayload();
      if (cursor.getNext() != null){
        stringBuilder += ("\n");
      }
    }
    return stringBuilder.toString();
  }
}
