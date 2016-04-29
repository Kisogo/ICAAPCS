import java.util.ArrayList;

class testHomework {
    public static void main(String[] args) {
     
        Math math = new Math();
        math.createAssignment(20);
        
        English eng = new English();
        eng.createAssignment(40);
        
        Science sci = new Science();
        sci.createAssignment(60);
        
        APcs apcs = new APcs();
        apcs.createAssignment(100);     
     
     
        ArrayList<Homework> hw = new ArrayList<Homework>();
        hw.add(math);
        hw.add(eng);
        hw.add(sci);
        hw.add(apcs);
        
        for(Homework i : hw) {
            i.homeworkInfo();
        }
        
    }
}
