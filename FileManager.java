import java.io.*;
import java.util.ArrayList;

public class FileManager {
    public static ArrayList<Person> read(){
        ArrayList<Person> peopleList = new ArrayList<Person>();
        try {
            FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            while(fi.available() > 0) {
                Person person = (Person) oi.readObject();
                    peopleList.add(person);
            }

            oi.close();
            fi.close();

        }
        catch (FileNotFoundException e) {
            //System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println(e);
        }
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return peopleList;
    }
    public static void appendWrite(ArrayList<Person> people){
        ArrayList<Person> currentPeople = FileManager.read();
        int index = -1;
        if(currentPeople.size() > 0)
            index = currentPeople.get(currentPeople.size()-1).ID;
        try {
            File file = new File("myObjects.txt");
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream o = new ObjectOutputStream(f);
            int length = people.size();
            Person tmp;
            for(int i=0; i<length; i++){
                tmp = people.get(i);
                tmp.ID = ++index;
                currentPeople.add(tmp);
            }

            length = currentPeople.size();
            for(int i=0; i<length; i++) {
                o.writeObject(currentPeople.get(i));
            }
            o.close();
            f.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
    public static void write(ArrayList<Person> people){
        try {
            File file = new File("myObjects.txt");
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream o = new ObjectOutputStream(f);

            int length = people.size();
            Person tmp;
            for(int i=0; i<length; i++) {
                //tmp = people.get(i);
                o.writeObject(people.get(i));
            }
            o.close();
            f.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
    static boolean delete(int id){
        ArrayList<Person> people = FileManager.read();
        for (Person p:people)
            if(p.ID == id){
                people.remove(p);
                FileManager.write(people);
                return true;
            }
        return false;
    }

}
