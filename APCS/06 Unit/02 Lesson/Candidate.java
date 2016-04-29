public class Candidate {

	Candidate(String n, int votes) {

		name = n;
		numVoters = votes;

	}

	private String name;
	private int numVoters;



	@Override
	public String toString() {
		return new String(  name
				  + " recieved "
				  + numVoters
				  + " votes."
				   );
	}

	protected String getName() {
		return name;
	}

	protected int getNumVoters() {
		return numVoters;
	}
}
