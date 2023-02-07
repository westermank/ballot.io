import Voting_Algorithms.Ballot_box;
import Voting_Algorithms.Ballot;
import java.util.ArrayList;

public class Main{
  public static void main(String[] args){
    ArrayList<String> choices = new ArrayList<String>();
    choices.add("Bob");
    choices.add("Sally");
    choices.add("Nelson");
    choices.add("Alex");
    choices.add("Frederick");
    Ballot_box box = new Ballot_box(choices);
    box.list();
    box.simulate(choices,100);
  }
}
