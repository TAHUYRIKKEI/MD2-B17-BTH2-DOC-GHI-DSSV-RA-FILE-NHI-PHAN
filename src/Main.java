
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static <Student> void main(String[] args) {
        String PATH_FILE = "D:\\HTML data\\MD2\\Bai17_TH2_doc ghi Nhi Phan\\src\\student.txt";
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Bui duy Hung", "Nghe An"));
        students.add(new Student(2, "Le viet anh", "Thanh Hoa"));
        students.add(new Student(3, "Nguyen van tron", "VP"));
        students.add(new Student(4, "Tran van Hung", "Ca Mau"));
        students.add(new Student(5, "Pham thi HA", "Ha Noi"));

        writeToFile(PATH_FILE, students);
        List<Student> studentDataFromFile = (List<Student>) readDataFromFile(PATH_FILE);
        for (Student student : studentDataFromFile){
            System.out.println(student);
        }
    }

    public static <Student> void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <Student> List<Student> readDataFromFile(String path){
        List<Student> students = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return students;
    }
}