import java.util.*;

public class personSorter {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Guillaume", 20));
        persons.add(new Person("John", 20));
        persons.add(new Person("Guillaume", 10));
        persons.add(new Person("John", 10));
        persons.add(new Person("Luc", 5));

        sortPerson(persons);
        System.out.println(persons);

    }

    public static void sortPerson(ArrayList<Person> persons) {
        persons.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int order = (o1.name).compareTo(o2.name);
                if (order != 0) {
                    return order;
                } else {
                    return o1.age - o2.age;
                }
            }
        });
    }
}

class Person{

    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}