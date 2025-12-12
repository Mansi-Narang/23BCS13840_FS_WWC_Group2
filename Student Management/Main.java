import java.util.*;

class Student {
    private String name;
    private String id;
    private int marks;

    public Student(String name, String id, int marks) {
        this.name = name;
        this.id = id;
        this.marks = marks;
    }

    public String getId(){
        return id;
    }

    public int getMarks(){
        return marks;
    }

    public String getRole(){
        return "UnderGraduate";
    }

    @Override
    public String toString(){
        return id + " " + name + " ( " + marks + " ) " + getRole();
    }
}

class GraduateStudent extends Student {
    private String field;

    public GraduateStudent(String id, String name, int marks, String field){
        super(name, id, marks);
        this.field = field;
    }

    @Override
    public String getRole(){
        return "Graduated ( " + field + " ) ";
    }
}


// custom generics
class Repository<T>{
    private Map<String, T> data = new HashMap<>();

    public void save(String id, T obj){
        data.put(id, obj);
    }

    public T find(String id){
        return data.get(id);
    }

    public void delete(String id){
        data.remove(id);
    }
}





public class Main{
    public static void main(String[] args){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Mansi", "123", 100));
        students.add(new Student("Mishika", "456", 400));
        students.add(new Student("Itika", "586", 900));

        Repository<Student> repo = new Repository<>();
        for(Student student : students){
            repo.save(student.getId(), student);
        }

        System.out.println("ALL : ");
        students.forEach(System.out :: println);

        System.out.println("\n Lookup : ");
        Student s = repo.find("586");
        System.out.println(s != null ? s : "Not found");

        Iterator<Student> it = students.iterator();

        while(it.hasNext()){
            Student st = it.next();

            if(st.getMarks() < 400){
                it.remove();
                repo.delete(st.getId());
            }
        }

        System.out.println("\nALL AFTER REMOVAL: ");
        students.forEach(System.out :: println);

        Teacher t = new Teacher();
        System.out.println("\n Report of Students : ");
        t.getReport(students);
    }
}

class Teacher {
    void getReport(List<Student> lst){
        lst.forEach(System.out::println);
    }
}
