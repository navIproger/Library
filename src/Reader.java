import java.io.Serializable;

public class Reader implements Serializable {
    private String first_name;
    private String last_name;
    private int age;
    private String number;

    public Reader(String first_name, String last_name, int age, String number) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.number = number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "Ім'я = '" + first_name + '\'' +
                ", Прізвище = '" + last_name + '\'' +
                ", Вік = " + age +
                ", Моб.номер = '" + number + '\'' +
                '}';
    }
}
