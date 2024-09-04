package lab2.ans2.prob2A;

public class Student {
    private String name;
    private GradeReport gr;

    public Student(String name, String grade) {
        this.name = name;
        this.gr = new GradeReport(grade, this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGr(GradeReport gr) {
        this.gr = gr;
    }

    public GradeReport getGr() {
        return gr;
    }
}
