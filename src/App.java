import java.time.LocalDateTime;

import models.Address;
import models.City;
import models.Parcel;
import models.users.Driver;
import models.users.Person;
import models.ParcelSize;

public class App {
    public static void main(String[] args) throws Exception {
        Person Rodrigo = new Person("Rodrigo","Laurinovičs","050800-93872");
        System.out.println(Rodrigo);
        Driver Kaspars = new Driver("Kārlis", "Jampatracis", "323232-98765", "AL123456", 5.4);
        System.out.println(Kaspars);
        Address Majoklis = new Address(City.Daugavpils, "Jaunatnes iela", 20);
        System.out.println(Majoklis);
        Parcel pas1 = new Parcel(LocalDateTime.now().plusDays(3), ParcelSize.XL, true, Kaspars);
        System.out.println(pas1);
    }
}
