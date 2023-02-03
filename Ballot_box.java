package Voting_Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Ballot_box{
  private HashMap<String, Integer> candidates = new HashMap<String, Integer>();
  private ArrayList<Ballot> ballots = new ArrayList<Ballot>();

  public Ballot_box(String c1, String c2, String c3){
    candidates.put(c1,0);
    candidates.put(c2,0);
    candidates.put(c3,0);
  }

  public void vote(String c1, String c2, String c3){
    if(candidates.containsKey(c1) && candidates.containsKey(c2) && candidates.containsKey(c3)){
      Ballot vote = new Ballot(c1, c2, c3);
      ballots.add(vote);
      candidates.put(c1,candidates.get(c1)+1);
      System.out.println("Your vote has been successfully submitted!");
    }
    else
      System.out.println("One or more of the candidates you entered isn't running check your spelling.");
  }

  public void list(){
    System.out.println("The following candidates are running for ellection: ");
    for(Entry<String, Integer> entry: candidates.entrySet()){
      System.out.println(entry.getKey()+" with "+entry.getValue()+" votes.");
    }
  }

  public void close(){
    Integer majority = (ballots.size()/2) + 1;
    String biggest_loser = null;
    System.out.println("With "+ballots.size()+" voters in this election candidates will need a "+majority+" vote majority to win.");
    for(Entry<String, Integer> entry: candidates.entrySet()){
      if(entry.getValue() >= majority){
        list();
        System.out.println("Congratulations "+entry.getKey()+" has won the ellection with a majority of "+entry.getValue()+" votes!");
        return;
      }
      if(biggest_loser == null || entry.getValue() <= candidates.get(biggest_loser))
        biggest_loser=entry.getKey();
    }
    list();
    for(Ballot b : ballots){
      if(b.ranking.get(0) == biggest_loser){
        b.ranking.remove(0);
        for(String s : b.ranking){
          if(candidates.containsKey(s)){
            candidates.put(b.ranking.get(0),candidates.get(b.ranking.get(0))+1);
            break;
          //I could remove the invalid choices here to minimize potential future loops but that might cause issues while still itterating over the list
          }
        }
      }
    }
    System.out.println("No majority was found this round so the biggest loser will be eliminated and all of their supporters will get their next valid choice.");
    candidates.remove(biggest_loser);
    if(candidates.size() >= 1)
      close();
    else{
      System.out.println("It seems there is only one candidate left.");
    }
  }
}
