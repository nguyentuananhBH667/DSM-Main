import Models.Student;
import Sort.ISort;

import java.util.Arrays;
import java.util.Comparator;

public class Sort implements ISort {
    public int partition(Student[] students, int low, int high) {
        int pivot = students[high].getId();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (students[j].getId() < pivot) {
                i++;
                Student temp = students[i];
                students[i] = students[j];
                students[j] = temp;
            }
        }
        Student temp = students[i + 1];
        students[i + 1] = students[high];
        students[high] = temp;
        return i + 1;
    }
    public Student[] sortById(Student[] students, int low, int high) {
        if (low < high) {
            int pi = partition(students, low, high);
            sortById(students, low, pi - 1);
            sortById(students, pi + 1, high);
        }
        return students;
    }
    public static void merge(Student[] students, int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
        Student[] L = new Student[n1];
        Student[] R = new Student[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = students[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = students[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].getMark() <= R[j].getMark()) {
                students[k] = L[i];
                i++;
            }
            else {
                students[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            students[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            students[k] = R[j];
            j++;
            k++;
        }
    }
    public static Student[] sort(Student[] students, int l, int r)
    {
        if (l < r) {

            int m = l + (r - l) / 2;
            sort(students, l, m);
            sort(students, m + 1, r);
            merge(students, l, m, r);
        }
        return students;
    }
    public Student[] sortByName(Student[] students, int low, int high) {
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (students[j].getName().compareTo(students[minIndex].getName()) < 0) {
                    minIndex = j;
                }
            }
            Student temp = students[minIndex];
            students[minIndex] = students[i];
            students[i] = temp;
        }
        return students;
    }
    public Student[] sortByMark(Student[] students, int low, int high) {
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].getMark() > students[j + 1].getMark()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        return students;
    }

}
