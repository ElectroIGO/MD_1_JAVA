package service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

import models.Address;
import models.City;
import models.Parcel;
import models.ParcelSize;
import models.users.AbstractCustomer;
import models.users.CustomerAsCompany;
import models.users.CustomerAsPerson;
import models.users.Driver;

public class MainService {
    public static ArrayList<Driver> allDrivers = new ArrayList<Driver>();
    public static ArrayList<AbstractCustomer> allCustomers = new ArrayList<AbstractCustomer>();
public static void main(String[] args) throws Exception {
        System.out.println("-----Driver CRUD-----");
        Driver guy1 = new Driver("Rodrigo", "Laurinovičs", "050800-11034", "AL343235", 1);
        Driver guy2 = new Driver("Karina", "Škirmante", "000000-00000", "AL123456", 5.4);
        Driver guy3 = new Driver("Alfrēds", "Mazspānis", "111111-22222", "AL049583", 11);
        Driver guy4 = new Driver();
        System.out.println(guy1);
        System.out.println(guy2);
        System.out.println(guy3);
        System.out.println(guy4);
        allDrivers.addAll(Arrays.asList(guy1, guy2, guy3, guy4));
        try {
            System.out.println("Atrastais šoferis: \n" + findDriverWithPersonCode("000000-00000"));
            System.out.println("Atrastais šoferis: \n" + findDriverWithPersonCode("050800-11034"));
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        try {
            updateDriverLicenceNoByPersonCode("050800-11034", "AL999999");
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(guy2);
        System.out.println("-----Customer Company/Person CRUD-----");

        CustomerAsCompany cc1 = new CustomerAsCompany();
        Address address_cc2 = new Address(City.Riga, "Gatves iela", 5);
        CustomerAsCompany cc2 = new CustomerAsCompany(address_cc2, "23336666", "DeWans", "98765432");

        Address address_cp1 = new Address(City.Liepaja, "Muku iela", 77);
        CustomerAsPerson cp1 = new CustomerAsPerson("Rodrigo", "Laurinovičs", "050800-11034", address_cp1, "22830631");

        Address address_cp2 = new Address(City.Jelgava, "Darvas iela", 88);
        CustomerAsPerson cp2 = new CustomerAsPerson("Jānis", "Šate", "210988-65543", address_cp2, "22427226");

        System.out.println(cc1);
        System.out.println(cc2);
        System.out.println(cp1);
        System.out.println(cp2);

        allCustomers.addAll(Arrays.asList(cc1, cc2, cp1, cp2));
        
        System.out.println("\nAll company customers:\n");

        try{
            getAllCustomersAsCompany(allCustomers);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nAll person customers:\n");

        try{
            getAllCustomersAsPerson(allCustomers);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("----------");
        try {
            Address address_cc5 = new Address(City.Daugavpils, "Meza iela", 99);
            CustomerAsPerson cc5 = createNewCustomerAsPerson("Kārlis", "Bērziņš", "110199-71320", address_cc5, "25508433");
            allCustomers.add(cc5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Address address_cp6 = new Address(City.Ventspils, "Inzeniera iela", 101);
            CustomerAsCompany cp6 = createNewCustomerAsCompany(address_cp6, "25100965", "SIA Ventspils Nafta", "78787878");
            allCustomers.add(cp6);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nAll company customers:\n");


        try{
            getAllCustomersAsCompany(allCustomers);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nAll person customers:\n");

        try{
            getAllCustomersAsPerson(allCustomers);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-----Parcel Company/Person CRUD-----");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(1), ParcelSize.XS, false, findDriverWithPersonCode("050800-11034"), "4_person_210988-65543");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(3), ParcelSize.S, false, findDriverWithPersonCode("050800-11034"), "4_person_210988-65543");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(5), ParcelSize.XS, true, findDriverWithPersonCode("050800-11034"), "4_person_210988-65543");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(2), ParcelSize.M, false, findDriverWithPersonCode("050800-11034"), "3_person_050800-11034");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(1), ParcelSize.L, true, findDriverWithPersonCode("050800-11034"), "3_person_050800-11034");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(1), ParcelSize.XS, true, findDriverWithPersonCode("050800-11034"), "3_person_050800-11034");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(6), ParcelSize.XL, false, findDriverWithPersonCode("000000-00000"), "5_person_110199-71320");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(2), ParcelSize.M, true, findDriverWithPersonCode("000000-00000"), "5_person_110199-71320");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(8), ParcelSize.XS, true, findDriverWithPersonCode("111111-22222"), "5_person_110199-71320");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(1), ParcelSize.XL, false, findDriverWithPersonCode("111111-22222"), "1_company_12345678");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(10), ParcelSize.L, true, findDriverWithPersonCode("000000-00000"), "1_company_12345678");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(2), ParcelSize.XS, false, findDriverWithPersonCode("000000-00000"), "2_company_98765432");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(5), ParcelSize.XL, false, findDriverWithPersonCode("000000-00000"), "2_company_98765432");
            createNewParcelForCustomer(LocalDateTime.now().plusDays(3), ParcelSize.L, true, findDriverWithPersonCode("000000-00000"), "6_company_78787878");
            for (Parcel e : getAllParcelsByCustomerCode("4_person_210988-65543")){
                System.out.println(e);
            }
            for (Parcel e : getAllParcelsByCustomerCode("2_company_98765432")){
                System.out.println(e);
            }
            System.out.println("---------------------------------");
            for (Parcel e : getAllParcelsByCity(City.Riga)){
                System.out.println(e);
            }
            System.out.println("---------------------------------");
            for (Parcel e : getAllParcelsBySize(ParcelSize.XS)){
                System.out.println(e);
            }
            System.out.println("---------------------------------");
            System.out.println("6_company_78787878 Adresse Pays: " + calculatePriceOfAllParcelsByCustomerCode("6_company_78787878"));
            int[] stats = getStatisticsOfParcelsSize("2_company_98765432");
            System.out.println("X:"+ stats[0] + " S:" + stats[1] + " M:" + stats[2] + " L:" + stats[3] + " XL:" + stats[4]);
            for (Parcel e : getAllParcelsByCustomerCode("2_company_98765432")){
                System.out.println(e);
            }
            System.out.println("---------------------------------");
            allDrivers = sortDriversByExperience(allDrivers);
            printDrivers();
            System.out.println("---------------------------------");
            System.out.println("Parcels to deliver ASAP: " + deliverParcelsToSpecificCity(City.Liepaja));

    }
    public static void printDrivers(){
        for (Driver d: allDrivers){
            System.out.println(d);
        }
    }
    public static void printCustomers(){
        for (AbstractCustomer c : allCustomers){
            System.out.println(c);
        }
    }

    public static Driver findDriverWithPersonCode(String personCode) throws Exception{
        if(personCode == null) {
            throw new Exception("Person code not provided\n");
        }

        for(Driver d: allDrivers) {
            if(d instanceof Driver){
                if(d.getPersonCode().equals(personCode)) {
                    return d;
                }
            }
        }
        throw new Exception("Driver not registered\n");
    }

    public static void updateDriverLicenceNoByPersonCode(String personCode, String newLicenseNo) throws Exception {
        if(personCode == null || newLicenseNo == null) {
            throw new Exception("Person code not provided or new License number\n");
        }
        for(Driver d: allDrivers) {
            if(d instanceof Driver){
                if(d.getPersonCode().equals(personCode)) {
                    if (!d.getLicenseNo().equals(newLicenseNo)) {
                        d.setLicenseNo(newLicenseNo);
                    }
                    return;
                }

            }
        }
        throw new Exception("Driver not registered\n");
    }
    public static void deleteDriverByPersonCode(String personCode) throws Exception{
        if(personCode == null) {
            throw new Exception("Person code not provided\\");
        }
        for(Driver d: allDrivers) {
            if(d instanceof Driver) {
                if (d.getPersonCode().equals(personCode)) {
                    allDrivers.remove(d);
                    return;
                }
            }
        }
        throw new Exception("Driver not registered\n");
    }

    public static ArrayList<CustomerAsCompany> getAllCustomersAsCompany(ArrayList<AbstractCustomer> customers) throws Exception {
        if(customers == null) {
            throw new Exception("No customers provided");
        }
    
        ArrayList<CustomerAsCompany> companyCustomers = new ArrayList<>();
    
        for (AbstractCustomer c : customers) {
            if (c instanceof CustomerAsCompany) {
                companyCustomers.add((CustomerAsCompany) c);
            }
        }
    
        if (companyCustomers.isEmpty()) {
            throw new Exception("No company customers found");
        }
    
        return companyCustomers;
    }

    public static ArrayList<CustomerAsPerson> getAllCustomersAsPerson(ArrayList<AbstractCustomer> customers) throws Exception {
        if(customers == null) {
            throw new Exception("No customers provided");
        }
    
        ArrayList<CustomerAsPerson> personCustomers = new ArrayList<>();
    
        for (AbstractCustomer c : customers) {
            if (c instanceof CustomerAsPerson) {
                personCustomers.add((CustomerAsPerson) c);
            }
        }
    
        if (personCustomers.isEmpty()) {
            throw new Exception("No customers as person found");
        }
    
        return personCustomers;
    }

    public static CustomerAsPerson createNewCustomerAsPerson(String name, String surname, String personCode, Address address, String phone) throws Exception {
        if (name == null || surname == null || personCode == null || address == null || phone == null) {
            throw new Exception("Wrong params\n");
        }

        return new CustomerAsPerson(name, surname, personCode, address, phone);
    }

    public static CustomerAsCompany createNewCustomerAsCompany(Address address, String phoneNo, String title, String companyRegNo) throws Exception {
        if (address == null || phoneNo == null || title == null || companyRegNo == null) {
            throw new Exception("Wrong params\n");
        }

        return new CustomerAsCompany(address, phoneNo, title, companyRegNo);
    }
    public static void createNewParcelForCustomer(LocalDateTime plannedDelivery, ParcelSize size, boolean isFargile, Driver driver, String customerCode) throws Exception {
        for (AbstractCustomer e : allCustomers){
            if ((e.getCustomerCode().matches(customerCode))) {
                e.addNewParcel(new Parcel(plannedDelivery, size, isFargile, driver));
                return;
            }
        }
        throw new Exception("Customer not found\n");
    } 

    public static ArrayList<Parcel> getAllParcelsByCustomerCode(String customerCode) throws Exception {
        for (AbstractCustomer e : allCustomers){
            if ((e.getCustomerCode().matches(customerCode))) {
                return e.getParcels();
            }
        }
        throw new Exception("Customer not found\n");
    }

    public static ArrayList<Parcel> getAllParcelsByDriverPersonCode(String personCode) throws Exception {
        if (personCode == null) {
            throw new Exception("Person code not provided \n");
        }
        ArrayList<Parcel> parcels = new ArrayList<Parcel>();
        for (AbstractCustomer e : allCustomers){
            for (Parcel p : e.getParcels()) {
                if (p.getDriver().getPersonCode().matches(personCode)) {
                    parcels.add(p);
                }
            }
        }
        return parcels;
    }

    public static ArrayList<Parcel> getAllParcelsByCity(City city) throws Exception {
        ArrayList<Parcel> parcels = new ArrayList<Parcel>();
        for (AbstractCustomer c: allCustomers){
            if (c.getAddress().getCity() == city) {
                for (Parcel p : c.getParcels()) {
                        parcels.add(p);
                }
            }
        }
        return parcels;
    }

    public static ArrayList<Parcel> getAllParcelsBySize(ParcelSize size) throws Exception {
        ArrayList<Parcel> parcels = new ArrayList<Parcel>();
        for (AbstractCustomer e : allCustomers){
            for (Parcel p : e.getParcels()) {
                if (p.getSize() == size) {
                    parcels.add(p);
                }
            }
        }
        return parcels;
    }

    public static float calculatePriceOfAllParcelsByCustomerCode(String customerCode) throws Exception{
        if (customerCode == null) {
            throw new Exception("Customer code not provided \n");
        }
        float sum = 0;
        for (AbstractCustomer e : allCustomers){
            if ((e.getCustomerCode().matches(customerCode))) {
                for (Parcel p : e.getParcels()) {
                    sum += p.getPrice();
                }
                return sum;
            }
        }
        throw new Exception("Nothing to calculate\n");
    }

    public static int[] getStatisticsOfParcelsSize(String customerCode) throws Exception {
        if (customerCode == null) {
            throw new Exception("Customer code not provided \n");
        }
        int[] stats = {0,0,0,0,0};
        for (AbstractCustomer e : allCustomers){
            if ((e.getCustomerCode().matches(customerCode))) {
                for (Parcel p : e.getParcels()) {
                    switch (p.getSize()) {
                        case XS: 
                            stats[0]++;
                            break;
                        case S:
                            stats[1]++;
                            break;
                        case M:
                            stats[2]++;
                            break; 
                        case L:
                            stats[3]++;
                            break;
                        case XL:
                            stats[4]++;
                            break;
                        default:
                            break;
                    }
                }
                return stats;
            }
        }
        throw new Exception("Customer not found\n");
    }
    public static int deliverParcelsToSpecificCity(City city) {
        int count = 0;
        for (AbstractCustomer e : allCustomers){
            for ( Parcel p : e.getParcels() ){
                if (p.getPlannedDelivery().getDayOfWeek() == LocalDateTime.now().getDayOfWeek().plus(1) && e.getAddress().getCity().equals(city)){
                    count++;
                }
            }
        }
        return count;
    }
    public static ArrayList<Driver> sortDriversByExperience(ArrayList<Driver> allDrivers) {
        Comparator<Driver> compareByExperience = Comparator.comparing(Driver::getExperienceInYears);
        Collections.sort(allDrivers, compareByExperience);
        return allDrivers;
    }
}
