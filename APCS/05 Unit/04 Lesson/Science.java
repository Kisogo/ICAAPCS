public class Science extends Homework {
    
    Science() {
        super();
        setTypeHomework("Science");
    }
    
    // Implemented method
    public void doReading() {
        pagesRead = pagesRead - 3;    
    }
    
    public void createAssignment(int p) {
        setPagesRead(p);
    }
}
