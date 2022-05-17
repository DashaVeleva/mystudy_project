package spring_introduction;

public class Person {
    private Pet pet;
    String surname;
    int age;

    public Person(Pet pet){
       this.pet = pet;
    }

    public void setSurname(String name) {
        this.surname = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void callYourPet(){
        System.out.println("Hello");
        pet.say();
    }
}
