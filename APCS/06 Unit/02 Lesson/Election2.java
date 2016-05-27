import java.util.ArrayList;

public class Election2 {

	Election2() {

		numCandidates = 0;
		totalVotes = 0;
		//arr = new Candidate[1024];
        arr = new ArrayList<Candidate>();
	}

	private int numCandidates;
	private int totalVotes;
	private ArrayList<Candidate> arr;

	void addCandidate(Candidate c) {
		arr.add(c);
		numCandidates++;
	}

	void printVotes() {
		for(Candidate c : arr) {
			System.out.println(c.toString());
		}
	}

	int getTotal() {
		if(totalVotes == 0) {
			for(Candidate c : arr) {
				if(c != null) {
					totalVotes = totalVotes + c.getNumVoters();
				} else {
					break;
				}
			}
		}
		return totalVotes;
	}

	void printResults() {
		// header
		System.out.printf("%15s%20s%20s%n%s%n"
				  ,"Candidate"
				  ,"Votes Recieved"
				  ,"% of Total Votes"
				  ,"-------------------------------------------------------"
				 );

		// content
		for(Candidate c : arr) {
			if(c != null) {
				System.out.format("%14s%20d%20.0f%n"
						  , c.getName()
						  , c.getNumVoters()
						  , ((double)c.getNumVoters() / (double)getTotal()) * 100
						 );
			} else {
				break;
			}
		}

		// footer
		System.out.println("\nTotal number of votes in election: " + totalVotes);
	}

	ArrayList<Candidate> getCandidates() {
		return arr;
	}
}
