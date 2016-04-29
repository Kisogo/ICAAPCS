public abstract class Homework {

    Homework() {
        pagesRead = 0;
        typeHomework = "none";
    }


    int pagesRead;
    String typeHomework;
    
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
    
    public abstract void createAssignment(int p);

}
