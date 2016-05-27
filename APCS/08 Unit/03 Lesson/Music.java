import java.util.Arrays;

class Music {

	private String[][] myMusic = {
		{"Pieces of You",			"1994",		"Jewel"},
		{"Jagged Little Pill",		"1995",		"Alanis Morissette"},
		{"What if it's You",		"1995",		"Reba McEntire"},
		{"Misunderstood",			"2001",		"Pink"},
		{"Laundry Service",			"2001",		"Shakira"},
		{"Taking the Long Way",		"2006",		"Dixie Chicks"},
		{"Under My Skin",			"2004",		"Avril Lavigne"},
		{"Let Go",					"2007",		"Tim McGraw"},
		{"White Flag",				"2004",		"Dido"} };


	// Helper method: sort myMusic by title/year/artist
	private void selSort(int sel) {
		String[][] arr = myMusic; // automatic pointer initialization! wow such java!
		int iMin = 0;

		for (int j = 0; j < arr.length; j++) {
			iMin = j;

			for (int i = j+1; i < arr.length; i++) {
				if(arr[i][sel].compareToIgnoreCase(arr[iMin][sel]) > 0) {
					iMin = i;
				}
			}

			if (iMin != j) {
				String[] tmp = arr[j];
				arr[j] = arr[iMin];
				arr[iMin] = tmp;
			}
		}
	}

	// Helper method: perform recursive binary search
	private String[] binSearch(int col, String query) {
        
        // create a new array containing only elements from the column we're searching
        String[] searchArr = new String[myMusic.length];
        for(int i = 0; i < myMusic.length; i++) {
            searchArr[i] =  myMusic[i][col];
        }
        
        int low = 0;
        int hi = searchArr.length - 1;
        
        while(low <= hi) {
            int mid = low + (hi - low) / 2;
            if(query.compareToIgnoreCase(searchArr[mid]) > 0) {
                hi = mid - 1;
            } else if(query.compareToIgnoreCase(searchArr[mid]) < 0 ) {
                low = mid + 1;
            } else {
                return myMusic[mid];
            }
        }
        return null;        
	}



	// Helper method: print every element in myMusic
	protected void printMusic() {
        System.out.println("Music Library : ");
		for(String[] a: myMusic) {
			System.out.println("\t" + a[0] + ", " + a[1] + ", " + a[2]);
		}
	}
    /*
    protected void printMusic(String[][] arr) {
		for(String[] a: arr) {
			System.out.println(a[0] + ", " + a[1] + ", " + a[2] + "\n");
		}
	}
    */

	// Helper method: print every element in subarray of myMusic
	protected void printMusic(String[] subarr) {
		System.out.println("\t" + subarr[0] + ", " + subarr[1] + ", " + subarr[2] + "\n");
	}

	protected String[] searchTitle(String title) {
        
        String arr[][] = myMusic;
        
        // sort by title
        selSort(0);
        
        // perform binary search
        String[] out = binSearch(0, title);
        
        if(out != null) {
            System.out.println("\nMatch found for " + title + ":");
            printMusic(out);
            return out;
            
        } else {
            System.out.println("\nNo matches for " + title);
            return null;
        }
	}

	protected String[] searchYear(int year) {
        
        String arr[][] = myMusic;
        
        // sort by year
        selSort(1);
        
        // perform binary search
        String[] out = binSearch( 1, Integer.toString(year));
        
        if(out != null) {
            System.out.println("\nMatch found for " + Integer.toString(year) + ":");
                printMusic(out);
                return out;
            
        } else {
            System.out.println("\nNo matches for " + Integer.toString(year));
            return null;
        }
        
	}

	protected String[] searchSinger(String name) {
        
        String arr[][] = myMusic;
                
        // sort by singer
        selSort(2);
        
        // perform binary search
        String[] out = binSearch(2, name);
        
        if(out != null) {
            System.out.println("\nMatch found for " + name + ":");
                printMusic(out);
                return out;
            
        } else {
            System.out.println("\nNo matches for " + name);
            return null;
        }
	}
}
