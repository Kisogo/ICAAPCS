public class English extends Homework {
    
    English() {
        super();
        setTypeHomework("English");
    }
    
    // Implemented method
    public void doReading() {
        pagesRead = pagesRead - 1;    
    }
    
    public void createAssignment(int p) {
        setPagesRead(p);
    }
}
