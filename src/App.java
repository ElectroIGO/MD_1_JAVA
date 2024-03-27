import models.Address;
import models.City;
import models.users.Driver;
import models.users.Person;

public class App {
    public static void main(String[] args) throws Exception {
        Person Rodrigo = new Person("Rodrigo","Laurinovičs","050800-93872");
        System.out.println(Rodrigo);
        Driver Kaspars = new Driver("Kārlis", "Jampatracis", "323232-98765", "AL123456", 5.4);
        System.out.println(Kaspars);
        Address Majoklis = new Address(City.Daugavpils, "Jaunatnes iela", 20);
        System.out.println(Majoklis);
    }
}
