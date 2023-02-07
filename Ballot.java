package Voting_Algorithms;

import java.util.ArrayList;

public class Ballot{
  public ArrayList<String> ranking = new ArrayList<String>();

  public Ballot(ArrayList<String> choices){
    for(String choice : choices)
      ranking.add(choice);
  }

  public void ranking(){
    System.out.println("You ranked the candidates in the following order: "+ranking.subList(0, ranking.size()));
  }
}
