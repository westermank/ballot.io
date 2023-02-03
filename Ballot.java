package Voting_Algorithms;

import java.util.ArrayList;

public class Ballot{
  public ArrayList<String> ranking = new ArrayList<String>();

  public Ballot(String c1, String c2, String c3){
    ranking.add(c1);
    ranking.add(c2);
    ranking.add(c3);
  }

  public void ranking(){
    System.out.println("You ranked the candidates in the following order: first choice "+ranking.get(0)+", second choice "+ranking.get(1)+", and third choice "+ranking.get(2));
  }
}
