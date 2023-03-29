import java.io.Serializable;
import java.util.*;

public class Book implements Serializable {
    private String title;
    private int yearOfPublication;
    private String dateOfDelivery;
    private boolean availabilityBook;
    private Reader reader;

    private List<String> dataTake = new ArrayList<>();
    private List<String> dataReturn = new ArrayList<>();

    public Book(String title, int ageOfPublication, String dateOfDelivery) {
        this.title = title;
        this.yearOfPublication = ageOfPublication;
        this.dateOfDelivery = dateOfDelivery;
        availabilityBook = true;
        reader = null;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public String getDateOfDelivery() {
        return dateOfDelivery;
    }

    public boolean isAvailabilityBook() {
        return availabilityBook;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader Customer) {
        this.reader = Customer;
    }

    public void setAvailabilityBook(boolean availabilityBook) {
        this.availabilityBook = availabilityBook;
    }

    public void takeBook(String dataTake) {
        availabilityBook = false;
        this.dataTake.add(dataTake);
    }

    public void returnBook(String dataReturn) {
        availabilityBook = true;
        this.dataReturn.add(dataReturn);
    }

    @Override
    public String toString() {
        return "Book{" +
                "Назва = '" + title + '\'' +
                ", Рік випуску = " + yearOfPublication +
                ", Дата дославлення в бібліотеку = '" + dateOfDelivery + '\'' +
                ", Наявність = " + availabilityBook +
                ", В кого находиться книги = '" + reader + '\'' +
                '}';
    }
}
