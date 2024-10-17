package Models;

public class Student {
    private int id;
    private String name;
    private double mark;
    private String rank;

    public Student(int id, String name, double mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }
    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMark() {
        return mark;
    }

    public String getRank() {
        return rank;
    }

    public void setRank() {
        this.rank = sortRank(mark);
    }
    public String sortRank(double mark) {
        if(mark >=0 && mark < 5) {
            rank = "Fail";
        } else if(mark >=5 && mark < 6.5) {
            rank = "Medium";
        } else if(mark >=6.5 && mark < 7.5) {
            rank = "Good";
        } else if(mark >=7.5 && mark < 9) {
            rank = "Very Good";
        } else if(mark >=9 && mark < 10.5) {
            rank = "Excellent";
        }
        return rank;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}
