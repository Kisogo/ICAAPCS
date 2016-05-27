public class Science extends Homework {
    
    Science() {
        super();
        setTypeHomework("Science");
    }
    
    // Implemented method
    public void doReading() {
        setPagesRead(getPagesRead() - 4);    
    }
    
    public void createAssignment(int p) {
        setPagesRead(p);
    }
}
