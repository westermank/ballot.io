import Voting_Algorithms.Ballot_box;
import Voting_Algorithms.Ballot;

public class Main{
  public static void main(String[] args){
    Ballot_box box = new Ballot_box("Bob","Sally","Nelson");
    box.list();
    box.vote("bob","Sally","Nelson");//test case for input validation
    box.vote("Sally","Nelson","Bob");
    box.vote("Nelson","Sally","Bob");//setting up a 2 cycle election where Sally wins after Bob losses in the first round and b3 gets their second vote to give Sally majority win
    box.vote("Bob","Sally","Nelson");
    box.vote("Sally","Bob","Nelson");
    box.vote("Nelson","Bob","Sally");
    box.close();
  }
}
