// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.ArrayList;
import java.util.List;

/**
 * Purpose: Use Candidate.java to simulate an election and sort out the data based on votes.
 * Make Methods so that changing the name or votes of any candidate is simple
 *
 *  Maria H * 2/13/2023
 */

public class ElectionTesterV6 {
	public static void main (String[] args) {
		List<Candidate> candidate = new ArrayList<Candidate>();
		candidate.add(new Candidate("Tony Stark", 2691));
		candidate.add(new Candidate("Clint Barton", 3890));
		candidate.add(new Candidate("Stephen Strange", 3678));
		candidate.add(new Candidate("Peter Parker", 1234));
		candidate.add(new Candidate("Natasha Romanoff", 2468));
		System.out.println("\tOriginal Results: ");
		System.out.println();
		System.out.println("\tVotes\t % of Total ");
		System.out.println("Candidate \tRecieved\tVotes ");
		System.out.println("===============================================");
		canTable(candidate);
		System.out.println();
		System.out.println("The total number of votes is: " + totalVotes(candidate));
		System.out.println();
		changeCanName(candidate, "Tony Stark", "Bruce Banner");
		System.out.println("<<Changing Tony Stark to Bruce Banner>>");
		System.out.println();
		System.out.println("\tVotes\t % of Total ");
		System.out.println("Candidate \tRecieved\tVotes ");
		System.out.println("===============================================");
		canTable(candidate);
		System.out.println();
		System.out.println("The total number of votes is: " + totalVotes(candidate));
		System.out.println();
		changeCanVote(candidate, "Stephen Strange", 4321);
		System.out.println("<<Changing Stephen Strange votes to 4321>>");
		System.out.println(); System.out.println("\tVotes\t % of Total ");
		System.out.println("Candidate \tRecieved\tVotes ");
		System.out.println("===============================================");
		canTable(candidate);
		System.out.println();
		System.out.println("The total number of votes is: " + totalVotes(candidate));
		System.out.println();
		changeCanVoteandName(candidate,"Peter Parker", "Scott Lang", 6543);
		System.out.println("<<Changing Peter Parker name and votes to Scott Lang and 6543>>");
		System.out.println();
		System.out.println("\tVotes\t % of Total ");
		System.out.println("Candidate \tRecieved\tVotes ");
		System.out.println("===============================================");
		canTable(candidate);
		System.out.println();
		System.out.println("The total number of votes is: " + totalVotes(candidate));
		System.out.println();
		insertCan1(candidate, 1, "Phil Coulson", 6789);
		System.out.println("<<In position 1, add Phil Coulson, 6789 votes>>");
		System.out.println();
		System.out.println("\tVotes\t % of Total ");
		System.out.println("Candidate \tRecieved\tVotes ");
		System.out.println("===============================================");
		canTable(candidate);
		System.out.println();
		System.out.println("The total number of votes is: " + totalVotes(candidate));
		System.out.println();
		insertCan2(candidate, "Natasha Romanoff", "Thor Odinson", 1357);
		System.out.println("<<Before Natasha Romanoff, add Thor Odinson, 1357 votes>>");
		System.out.println();
		System.out.println("\tVotes\t % of Total ");
		System.out.println("Candidate \tRecieved\tVotes ");
		System.out.println("===============================================");
		canTable(candidate);
		System.out.println();
		System.out.printf("The total number of votes is: %s%n", totalVotes(candidate));
		System.out.println();
		removeCan1(candidate,3);
		System.out.println("<<From location 3, removing the Candidate in position 3>>");
		System.out.println();
		System.out.println("\tVotes\t % of Total ");
		System.out.println("Candidate \tRecieved\tVotes ");
		System.out.println("===============================================");
		canTable(candidate);
		System.out.println();
		System.out.println("The total number of votes is: " + totalVotes(candidate));
		System.out.println();
		removeCan2(candidate, "Thor Odinson");
		System.out.println("<<Removing Thor Odinson>>");
		System.out.println();
		System.out.println("\tVotes\t % of Total ");
		System.out.println("Candidate \tRecieved\tVotes ");
		System.out.println("===============================================");
		canTable(candidate);
		System.out.println();
		System.out.printf("The total number of votes is: %s%n", totalVotes(candidate));
	}
	public static void printCanInfo(List<Candidate> candidate) {
		for(Candidate can: candidate){
			System.out.println("" + (can));
		}
	}
	private static void canTable(List<Candidate> candidate) {
		int total = totalVotes(candidate);
		for(Candidate can: candidate){
			System.out.println(String.format("%-20s %-15d %.2f", can.getName(), can.getVotes(), ((double)can.getVotes() / total) * 100.0));
		}
	}
	private static int totalVotes(List<Candidate> candidate) {
		int sum = 0; for (Candidate can: candidate)
		{ sum += can.getVotes(); } return sum;
	}
	public static void changeCanName(List<Candidate> candidate, String find, String replace){
		for(Candidate can: candidate){
			if(can.getName().equals(find)){
				can.setName(replace);
			}
		}
	}
	public static void changeCanVote(List<Candidate> candidate, String find, int replace){
		for(Candidate can: candidate){
			if(can.getName().equals(find)){
				can.setVotes(replace);
			}
		}
	}
	public static void changeCanVoteandName(List<Candidate> candidate, String find, String replace, int replaces){
		for(Candidate can: candidate){
			if(can.getName().equals(find)){
				can.setName(replace);
				can.setVotes(replaces);
			}
		}
	}
	private static void insertCan1(List<Candidate> candidate, int location, String addN, int addS) {
		candidate.add(location, new Candidate(addN, addS));
	}
	public static void insertCan2(List<Candidate> candidate, String find, String addN, int addS){
		int location = 0;
		for(int i = 0; i < candidate.size(); i++){
			if(candidate.get(i).getName().equals(find)){
				location = i;
			}
		}
		candidate.add(location,new Candidate(addN,addS));
	}
	private static void removeCan1(List<Candidate> candidate ,int location) {
		candidate.remove(location);
	}
	private static void removeCan2(List<Candidate> candidate, String remN) {
		for(int i = candidate.size() - 1; i >= 0; i--) {
			if(candidate.get(i).getName().equals(remN)){
				candidate.remove(i);
			}
		}
	}
}