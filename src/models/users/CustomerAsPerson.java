package models.users;

import models.Address;

public class CustomerAsPerson extends AbstractCustomerAsPerson {
    //1. variable
    //2 get and set
    //3. constructors
    public CustomerAsPerson() {
      super();
      setCustomerCode();
    }
 
    public CustomerAsPerson(String name, String surname, String personCode, Address address, String phone) {
        super(name, surname, personCode, address, phone);
        setCustomerCode();
    }
 
    //4. toString
     public String toString(){
         return "Vārds: " + super.getPerson().getName() + " Uzvārds: " + super.getPerson().getSurname() + " Klienta kods: " + super.getCustomerCode() + " " + super.getAddress();
     }
    //5. other functions
    @Override
    public void setCustomerCode() {
        super.customerCode = String.format("%d_person_%s", super.getcID(), super.getPerson().getPersonCode());
    }
    

}
