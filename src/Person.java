import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by BennettIronYard on 10/19/15.
 */
public class Person implements Comparable {
    int id;
    String first_name;
    String last_name;
    String email;
    String country;
    String ip_address;

    public Person(int id, String first_name, String last_name, String email, String country, String ip_address) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.country = country;
        this.ip_address = ip_address;
    }

    @Override
    public int compareTo(Object o) { // the compare to method "what we are comparing it to".
        Person p = (Person) o;
        return last_name.compareTo(p.last_name);
    }

    @Override
    public String toString() {
        return String.format("%s %s form %s\n", first_name, last_name, country);
    }

}//end of public class
