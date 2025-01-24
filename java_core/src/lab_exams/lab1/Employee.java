package lab_exams.lab1;

import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private transient String password;
    private static final long serialVersionUID=1L;

    public Employee() {
    }

    public Employee(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString(){
        return (name+" "+password);
    }

}

