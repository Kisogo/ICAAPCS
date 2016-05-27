class MusicTest {
	public static void main(String[] args) {
            Music mu = new Music();
            
            mu.printMusic();
            mu.searchTitle("Misunderstood");
            mu.searchTitle("Under Paid");
            mu.searchYear(2005);
            mu.searchYear(2006);
            mu.searchSinger("Darth Maul");
            mu.searchSinger("Dido");

	}
}
