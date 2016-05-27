class Movie {

	// Array of String arrays containing movie metadata
	private String[][] myMovies = {
		{"The Muppets Take Manhattan", 		"2001", "Columbia Tristar"},
		{"Mulan Special Edition", 		"2004", "Disney"},
		{"Shrek 2", 				"2004", "Dreamworks"},
		{"The Incredibles", 			"2004", "Pixar"},
		{"Nanny McPhee", 			"2006", "Universal"},
		{"The Curse of the Were-Rabbit", 	"2006", "Aardman"},
		{"Ice Age", 				"2002", "20th Century Fox"},
		{"Lilo & Stitch", 			"2002", "Disney"},
		{"Robots", 				"2005", "20th Century Fox"},
		{"Monsters Inc.", 			"2001", "Pixar"}
	};

	protected void printMovies() {
        String format = "%-30s";
		for(String[] m: myMovies) {
            for(String s: m) {
                System.out.printf(format, s);
            }
            System.out.print("\n");
		}
        System.out.print("\n\n");
	}

	protected void sort(int column, int direction) {
		/* Show the array before sorting */
        switch (column) {
            case 0:     System.out.println("Before sorting by Title: ");
                        break;
            case 1:     System.out.println("Before sorting by Year: ");
                        break;
            case 2:     System.out.println("Before sorting by Studio: ");
                        break;
            default:    System.out.println("Invalid selection. ");
                        return;
        }
        printMovies();
        
        
        /* Begin sorting array */
        
        /* Typing myMovies all the time is a pain
           I'm going to reference it with a shorter variable name. */
        String[][] arr = myMovies;
        int iMin = 0; 
        int j, i;
        
        switch (direction) {
            /* Array will be sorted in descending order when direction == 0.
               Array will be sorted in ascending order when direction == 1. */
            case 0:
                for(j = 0; j < arr.length; j++) {
                    iMin = j;
                    
                    for(i = j+1; i < arr.length; i++) {
                        if(arr[i][column].compareToIgnoreCase(arr[iMin][column]) > 0) {
                            iMin = i;
                        }
                    }
                    
                    if(iMin != j) {
                        String[] tmp = arr[j];
                        arr[j] = arr[iMin];
                        arr[iMin] = tmp;
                    }
                }
                break;
                
            case 1:
                for(j = 0; j < arr.length; j++) {
                    iMin = j;
                    
                    for(i = j+1; i < arr.length; i++) {
                        if(arr[i][column].compareToIgnoreCase(arr[iMin][column]) < 0) {
                            iMin = i;
                        }
                    }
                    
                    if(iMin != j) {
                        String[] tmp = arr[j];
                        arr[j] = arr[iMin];
                        arr[iMin] = tmp;
                    }
                }
                break;
                
            default: System.out.println("Invalid direction.");
                     return;
        }
        /* End sorting array */
        
        /* Show the array after sorting */
        switch (column) {
            case 0:     System.out.println("After sorting by Title: ");
                        break;
            case 1:     System.out.println("After sorting by Year: ");
                        break;
            case 2:     System.out.println("After sorting by Studio: ");
                        break;
            default:    System.out.println("Invalid selection. ");
                        return;
        }
        printMovies();
	}
}
