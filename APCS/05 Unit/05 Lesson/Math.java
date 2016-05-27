public class Math extends Homework {
    
    Math() {
        super();
        setTypeHomework("Math");
    }
    
    // Implemented method
    public void doReading() {
        setPagesRead(getPagesRead() - 2);
    }
    
    public void createAssignment(int p) {
        setPagesRead(p);
    }
}
