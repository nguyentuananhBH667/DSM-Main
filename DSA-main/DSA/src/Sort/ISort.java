package Sort;

import Models.Student;
public interface ISort {
    Student[] sortById(Student[] students, int low, int high);
    Student[] sortByName(Student[] students, int low, int high);
    Student[] sortByMark(Student[] students, int low, int high);
}
