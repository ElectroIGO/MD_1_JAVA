package models.users;

import models.Address;

public abstract class AbstractCustomerAsPerson extends AbstractCustomer{
    //1. variable
    protected Person person;
    //2 get and set
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    //3. constructors
    public AbstractCustomerAsPerson() {
        super();
        setPerson(new Person());
    }
 
    public AbstractCustomerAsPerson(String name, String surname, String personCode, Address address, String phone) {
        super(address, phone);
        setPerson(new Person(name, surname, personCode));
    }
 
    //4. toString
     public String toString(){
         return "";
     }
    //5. other functions
}
