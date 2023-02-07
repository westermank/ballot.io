package Voting_Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Collections;

public class Ballot_box{
  private HashMap<String, Integer> candidates = new HashMap<String, Integer>();
  private ArrayList<Ballot> ballots = new ArrayList<Ballot>();

  public Ballot_box(ArrayList<String> options){
    for(String option : options)
      candidates.put(option,0);
  }

  public void vote(ArrayList<String> choices){
    ArrayList<String> vote = new ArrayList<String>();
    for(String choice : choices){
      if(candidates.containsKey(choice))
        vote.add(choice);
      else{
        System.out.println("One or more of the candidates you entered isn't running check your spelling.");
        return;
      }
    }
    Ballot submission = new Ballot(vote);
    ballots.add(submission);
    candidates.put(vote.get(0),candidates.get(vote.get(0))+1);
    System.out.println("Your vote has been successfully submitted! "+submission.ranking.subList(0, submission.ranking.size()));
  }


  public void list(){
    int total = 0;
    System.out.println("The following candidates are running for ellection: ");
    for(Entry<String, Integer> entry: candidates.entrySet()){
      System.out.println(entry.getKey()+" with "+entry.getValue()+" votes.");
      total+=entry.getValue();
    }
    System.out.println("with a total of "+total+" votes counted.");
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
      if(biggest_loser == null || entry.getValue() < candidates.get(biggest_loser))
        biggest_loser=entry.getKey();
    }
    list();
    for(Ballot b : ballots){
      if(b.ranking.get(0) == biggest_loser){
        System.out.println("---------------------");
        System.out.println(b.ranking.subList(0, b.ranking.size()));
        b.ranking.remove(0);
        System.out.println(b.ranking.subList(0, b.ranking.size()));
        System.out.println("---------------------");
        int i = 0;
        nextchoice:
        for(String s : b.ranking){
          if(candidates.containsKey(s)){
            System.out.println(b.ranking.get(i)+" with "+candidates.get(b.ranking.get(i))+" votes is the next choice.");
            candidates.put(b.ranking.get(i),candidates.get(b.ranking.get(i))+1);
            break nextchoice;
          }
          else{
            i++;
          }
        }
      }
    }
    System.out.println("No majority was found this round and "+biggest_loser+" is the biggest loser. They will be eliminated and all of their supporters will get their next valid choice.");
    candidates.remove(biggest_loser);
    if(candidates.size() >= 1)
      close();
    else{
      System.out.println("It seems there is only one candidate left.");
      list();
    }
  }

public void simulate(ArrayList<String> options, Integer Ballots){
  for (int b = Ballots ; b > 0 ; b--){
    Collections.shuffle(options);
    vote(options);
  }
  close();
}

}
