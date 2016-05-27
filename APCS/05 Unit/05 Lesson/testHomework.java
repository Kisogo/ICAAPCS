import java.util.ArrayList;

class testHomework {
    public static void main(String[] args) {
     
        Math math = new Math();
        math.createAssignment(20);
        
        English eng = new English();
        eng.createAssignment(40);
        
        Science sci = new Science();
        sci.createAssignment(100);
        
        APcs apcs = new APcs();
        apcs.createAssignment(100);     
     
     
        ArrayList<Homework> hw = new ArrayList<Homework>();
        hw.add(math);
        hw.add(eng);
        hw.add(sci);
        hw.add(apcs);
        
        System.out.println("Before reading:\n");
        for(Homework i : hw) {
            i.homeworkInfo();
        }
        
        System.out.println("\nAfter reading:\n");
        for(Homework i : hw) {
            i.doReading();
            i.homeworkInfo();
        }
        System.out.println();
        
        sci.compareTo(apcs);
        apcs.compareTo(math);
        eng.compareTo(math);
        
    }
}
