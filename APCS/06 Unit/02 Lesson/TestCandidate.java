class TestCandidate {
	public static void main(String[] args)	{
		Election elect = new Election();

		elect.addCandidate(new Candidate("John Smith", 5000));
		elect.addCandidate(new Candidate("Mary Miller", 4000));
		elect.addCandidate(new Candidate("Michael Duffy", 6000));
		elect.addCandidate(new Candidate("Tim Robinson", 2500));
		elect.addCandidate(new Candidate("Joe Ashtony", 1800));

		for(Candidate c : elect.getCandidates()) {
			if(c != null) {
				System.out.println(c.toString());
			} else {
				System.out.println();
				break;
			}
		}

		elect.printResults();
	}
}
