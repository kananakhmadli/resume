package bean;

import java.io.Serializable;

public abstract class Person implements Serializable{

    private String name;
    private String surname;
    private int age;

    Person() {
    }

    Person(String name, String suraname, int age) {
        this.name = name;
        this.surname = suraname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuraname() {
        return surname;
    }

    public void setSuraname(String suraname) {
        this.surname = suraname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
     @Override
    public String toString() {
        return name+" "+surname;
    }

}
