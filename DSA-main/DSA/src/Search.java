import Models.Student;
import Search.ISearch;

import java.util.ArrayList;
import Sort.ISort;
public class Search implements ISearch {
    @Override
    public int searchById(Student[] students, String x) {
        int left = 0;
        int right = students.length - 1;
        try{
            int findId = Integer.parseInt(x);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Id");
        }
        ISort sort = new Sort();
        Student[] sortedStudent = sort.sortById(students, 0, students.length - 1);
        while (left <= right){
            int mid = left + (right - left)/2;
            if(sortedStudent[mid].getId() == Integer.parseInt(x)){
                return mid;
            } else if(sortedStudent[mid].getId() > Integer.parseInt(x)){
                right = mid - 1;

            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    @Override
    public Student[] searchByName(Student[] students, String x) {
        ArrayList<Student> studentsList = new ArrayList<Student>();
        for(Student student : students){
            if(student.getName().contains(x)){
                studentsList.add(student);
            }
        }
        return studentsList.toArray(new Student[studentsList.size()]);
    }
}
