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
        if(name !=null && name.matches("^[A-ZĀČĒĢĪĶĻŅŠŪŽ][a-zāčēģīķļņšūž]*$"))
            this.name = name;
        else
            this.name = "------";
    }
    public void setPersonCode(String personCode) {
        if(personCode !=null && personCode.matches("[0-9]{6}-[0-9]{5}"))
            this.personCode = personCode;
        else
            this.personCode = "------";
    }
    public void setSurname(String surname) {
        if(surname !=null && surname.matches("^[A-ZĀČĒĢĪĶĻŅŠŪŽ][a-zāčēģīķļņšūž]*$"))
            this.surname = surname;
        else
            this.surname = "------";
    }
    //3. constructors
    public Person() {
        setName("UNKNOWN");
        setSurname("UNKNOWN");
        setPersonCode("111111-11111");
        
    }

    public Person(String name, String surname, String personCode) {
        setName(name);
        setSurname(surname);
        setPersonCode(personCode);
    }

    //4. toString
    public String toString(){
        return "Vārds: " + name + "\n" + "Uzvārds: " + surname + "\n" + "Personas kods: " + personCode + "\n";
    }
    //5. other functions
}
