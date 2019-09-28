import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String input = new String();
        do{
            input = showMenu();
            switch(input){
                case "1":
                    listPeople();
                    break;
                case "2":
                    addPerson();
                    break;
                case "3":
                    deletePerson();
                    break;
                default:
                    break;
            }

        }while(!input.equals("0"));
    }
    private static String showMenu() {
        String input = new String();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1. List people");
            System.out.println("2. Add person");
            System.out.println("3. Delete person");
            System.out.println("0. Exit");
            System.out.print("Insert option (integer): ");
            input = scanner.next();
        } while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("0"));
        return input;
    }
    private static void listPeople(){
        List<Person> peopleList;
        peopleList = FileManager.read();
        System.out.println("");
        for(Person person : peopleList){
            System.out.println(person.toString());
        }
        System.out.println("");
    }
    private static Person readPerson(){
        Person person = new Person();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Loading person");
        System.out.println("Input Preson's name: ");
        person.name = scanner.nextLine();
        System.out.println("Input Preson's age: ");
        person.age = scanner.nextInt();

        return person;
    }
    private static void addPerson(){
        String input = "";
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<Person>();
        do{
            people.add(readPerson());
            System.out.print("Load another person?(y / n): ");
            input = scanner.next();
        }while(input.equals("y"));
        FileManager.appendWrite(people);
    }
    static public void deletePerson(){
        Scanner scanner = new Scanner(System.in);
        int id;
        do {
            System.out.print("Input ID of person, You want to delete: ");
            id = scanner.nextInt();
        }while(id < 0);
        boolean deleteResult = FileManager.delete(id);
        if(deleteResult)
            System.out.println("Person deleted");
        else
            System.out.println("Person not found");
    }
}
