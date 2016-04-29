public class APcs extends Homework {
    
    APcs() {
        super();
        setTypeHomework("APCS");
    }
    
    // Implemented method
    public void doReading() {
        pagesRead = pagesRead - 4;    
    }
    
    public void createAssignment(int p) {
        setPagesRead(p);
    }
}
