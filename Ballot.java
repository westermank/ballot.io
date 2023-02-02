import java.util.LinkedList;
import java.util.ArrayList;

public class Ballot{
  private String[] candidates = new String[3];
  private String[] ranking = new String[3];

  public Ballot(String c1, String c2, String c3){
    candidates = new String[]{c1,c2,c3};
    //ranked = new LinkedList<String>();
  }

  public void list(){
    System.out.println("The following candidates are running for ellection: "+candidates[0]+", "+candidates[1]+", and "+candidates[2]);
  }
  public void rank(String first, String second, String third){
    ranking = new String[]{first,second,third};
    //ranked.add(first); will want to decide between linkedlist and ArrayList data structure later
    //ranked.add(second);
    //ranked.add(third);
  }

  public void ranking(){
    System.out.println("You ranked the candidates in the following order: first choice"+ranking[0]+", second choice"+ranking[1]+", and third choice"+ranking[2]);
  }


  public static void main(String[] args){
    Ballot b1 = new Ballot("Bob","Sally","Nelson");
    b1.list();
    b1.rank("Sally","Nelson","Bob");//need to validate inputs are contained within Ballot.candidates
    b1.ranking();
  }
}
