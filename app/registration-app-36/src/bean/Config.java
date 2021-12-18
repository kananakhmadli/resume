package bean;

import java.io.Serializable;

public class Config implements Serializable {

    private static Config config = null;
    private static final String fileName = "app.obj";
    private static boolean loggedIn;
    private Student[] students = new Student[0];
    private Teacher[] teacher = new Teacher[0];

    public static void save() {
//        FileUtility.writeFileObject(Config.instance(), fileName);
    }

    public static void intialize() throws Exception {
//        Object obj = FileUtility.readFileObject(fileName);
//        if (obj == null) {
//            return;
//        }
//        if (obj instanceof Config) {
//            config = (Config) obj;
//        }
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Teacher[] getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher[] teacher) {
        this.teacher = teacher;
    }

    public void appendStudent(Student s) {
        Student[] newStudent = new Student[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            newStudent[i] = students[i];
        }
        newStudent[newStudent.length - 1] = s;
        students = newStudent;
    }

    public void appendTeacher(Teacher t) {
        Teacher[] newTeacher = new Teacher[teacher.length + 1];
        for (int i = 0; i < teacher.length; i++) {
            newTeacher[i] = teacher[i];
        }
        newTeacher[newTeacher.length - 1] = t;
        teacher = newTeacher;
    }

    public static Config instance() {
        if (config == null) {
            config = new Config();
        }
        return config;
    }

    public static Config getConfig() {
        return config;
    }

    public static void setConfig(Config config) {
        Config.config = config;
    }

    public static boolean isLoggedIn() {
        return loggedIn;
    }

    public static void setLoggedIn(boolean loggedIn) {
        Config.loggedIn = loggedIn;
    }
}
