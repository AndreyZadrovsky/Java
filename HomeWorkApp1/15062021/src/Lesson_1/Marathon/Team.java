package Lesson_1.Marathon;

public class Team {
    String name;
    Competitor[] competitors;

    public Team(String name, Competitor... competitors){
        this.name = name;
        this.competitors = competitors;
    }
    void Start ( Course[] course){
        for (Competitor c : competitors) {
            for (Course o : course) {
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }
    }


    void Info(){
        for (Competitor c : competitors) {
            c.info();
        }
    }
}

