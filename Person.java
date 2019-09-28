import java.io.Serializable;

public class Person implements Serializable{
    private static final long serialVersionUID = 1L;
    String name;
    int age;
    int ID;

    Person(){
    };

    Person(int ID, String name, int age){
        this.name = name;
        this.age = age;
        this.ID = ID;
    }

    @Override
    public String toString() {
            return ID + "   " + name + "    " + age;
        //return ID + ":" + name + ":" + age;
    }
}
