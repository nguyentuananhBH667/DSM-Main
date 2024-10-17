package Search;

import Models.Student;

public interface ISearch {
    int searchById(Student[] students, String x);
    Student[] searchByName(Student[] students, String x);
}
