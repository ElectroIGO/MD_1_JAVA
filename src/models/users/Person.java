package models.users;

public class Person {
    //1. variable
    private String name;
    private String surname;
    private String personCode;
    
    //2 get and set
    public String getName() {
        return name;
    }
    public String getPersonCode() {
        return personCode;
    }
    public String getSurname() {
        return surname;
    }
    public void setName(String name) {
        if(name !=null && name.matches("/^[\\p{Letter}\\s\\-.']{1,40}/u"))
            this.name = name;
        else
            this.name = "------";
    }
    public void setPersonCode(String personCode) {
        if(surname !=null && surname.matches("/^(\\d{6})-[012]\\d{4}$/"))
            this.personCode = personCode;
        else
            this.personCode = "------";
    }
    public void setSurname(String surname) {
        if(surname !=null && surname.matches("/^[\\p{Letter}\\s\\-.']{1,40}/u"))
            this.surname = surname;
        else
            this.surname = "------";
    }
    //3. constructors
    public Person() {
        setName("-----");
        setSurname("-----");
        setPersonCode("-----");
        
    }

    public Person(String name, String surname, String personCode) {
        setName(name);
        setSurname(surname);
        setPersonCode(personCode);
    }

    //4. toString
    public String toString(){
        return "Vārds: " + name + "\n" + "Uzvārds: " + "\n" + "Personas kods: " + personCode + "\n";
    }
    //5. other functions
}
