public abstract class Homework implements Processing,
                                          Comparable<Homework> {

    Homework() {
        pagesRead = 0;
        typeHomework = "none";
    }

    private int pagesRead;
    private String typeHomework;
    
    public int getPagesRead() {
        return pagesRead;
    }
    
    public void setPagesRead(int num) {
        pagesRead = num;
    }
    
    public String getTypeHomework() {
        return typeHomework;
    }
    
    public void setTypeHomework(String type) {
        typeHomework = type;
    }
    
    public void homeworkInfo() {
        System.out.println(getTypeHomework() + " : " + "must read " + getPagesRead() + " pages.");
    }
    
    public int compareTo(Homework arg) {
        if(pagesRead > arg.pagesRead) {
            System.out.println(getPagesRead() - arg.getPagesRead() 
            + " more pages must be read to complete " 
            + getTypeHomework() + " than " + arg.getTypeHomework());
            
            return -1;
        } else if(pagesRead == arg.pagesRead) {
            System.out.println(getTypeHomework() + " and " + arg.getTypeHomework()
            + " are equal in length. ");
            
            return 0;
        } else {
            System.out.println(arg.getPagesRead() - getPagesRead() 
            + " more pages must be read to complete " 
            + arg.getTypeHomework() + " than " + getTypeHomework());
            
            return 1;
        }
    }
    
    public abstract void createAssignment(int p);

}
