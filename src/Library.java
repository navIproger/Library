import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Library implements Serializable {
    private List<Book> library;
    private List<Reader> readers;

    public Library(Book... books) {      //Constructor which takes from 0 to many books, and add to the library
        library = new ArrayList<>();
        readers = new ArrayList<>();
        for (Book book : books) {
            library.add(book);
        }
    }

    public void addBooks(Book b, Book... books) {     //Method for add one or more books to the library
        library.add(b);
        for (Book book : books) {
            library.add(book);
        }
    }

    public void removeBooks(Book b, Book... books) {     //Method for remove one or more books from the library
        library.remove(b);
        for (Book book : books) {
            library.remove(book);
        }
    }

    public boolean removeBook(String title, int yearOfPublication) {       //Method for remove by using title, year of publication
        for (Book book : library) {
            if (book.getTitle().equals(title) && book.getYearOfPublication() == yearOfPublication) {
                library.remove(book);
                return true;
            }
        }
        return false;
    }

    public boolean removeBook(String title, int yearOfPublication, String dateOfDelivery) {       //Method for remove by using title, year of publication and date of delivery
        for (Book book : library) {
            if (book.getTitle().equals(title) && book.getYearOfPublication() == yearOfPublication && book.getDateOfDelivery().equals(dateOfDelivery)) {
                library.remove(book);
                return true;
            }
        }
        return false;
    }

    public boolean takeBook(String title, String name, String surname, String date) {     //Method for take book from the library
        for (Book book : library) {
            if (book.getTitle().equals(title) && book.isAvailabilityBook()) {
                for (Reader reader : readers) {
                    if (reader.getFirst_name().equals(name) && reader.getLast_name().equals(surname)) {
                        book.setReader(reader);
                        book.takeBook(date);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean returnBook(String title, String name, String surname, String date) {      //Method for return book to the library
        for (Book book : library) {
            if (book.getTitle().equals(title) && book.getReader().getFirst_name().equals(name) && book.getReader().getLast_name().equals(surname) && !book.isAvailabilityBook()) {
                book.setReader(null);
                book.returnBook(date);
                return true;
            }
//            else if (book.getTitle().equals(title) && !book.isAvailabilityBook()) {
//                System.out.println("Неправильний клієнт, повертає книгу");
//                book.setReader(null);
//                book.returnBook(date);
//            } else {
//                System.out.println("Невідома книга");
//            }
//        }
        }
        return false;
    }

    public Book searchBook(String title) {       //Method for search book in the library by using title
        for (Book book : library) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public Book searchBook(String title, int yearOfPublication) {        //Method for search book in the library by using title, year of publication
        for (Book book : library) {
            if (book.getTitle().equals(title) && book.getYearOfPublication() == yearOfPublication) {
                library.remove(book);
                return book;
            }
        }
        return null;
    }

    public Book searchBook(String title, int yearOfPublication, String dateOfDelivery) {     //Method for search book in the library by using title, year of publication and date of delivery
        for (Book book : library) {
            if (book.getTitle().equals(title) && book.getYearOfPublication() == yearOfPublication && book.getDateOfDelivery().equals(dateOfDelivery)) {
                library.remove(book);
                return book;
            }
        }
        return null;
    }


    public void addReader(Reader r, Reader... readers) {     //Method for add one or more readers to the library
        this.readers.add(r);
        for (Reader reader : readers) {
            this.readers.add(reader);
        }
    }

    public void removeReaders(Reader r, Reader... readers) {     //Method for remove one or more readers from the library
        this.readers.remove(r);
        for (Reader reader : readers) {
            this.readers.remove(reader);
        }
    }

    public boolean removeReader(String first_name, String last_name) {       //Method for remove reader by using first name and last name
        for (Reader reader : readers) {
            if (reader.getFirst_name().equals(first_name) && reader.getLast_name().equals(last_name)) {
                readers.remove(reader);
                return true;
            }
        }
        return false;
    }

    public Reader searchReader(String first_name, String last_name) {       //Method for search reader in the library by using first name and last name
        for (Reader reader : readers) {
            if (reader.getFirst_name().equals(first_name) && reader.getLast_name().equals(last_name)) {
                return reader;
            }
        }
        return null;
    }

    public Reader searchReader(String first_name, String last_name, String number) {       //Method for search book in the library by using first name, last name and age
        for (Reader reader : readers) {
            if (reader.getFirst_name().equals(first_name) && reader.getLast_name().equals(last_name) && reader.getNumber().equals(number)) {
                return reader;
            }
        }
        return null;
    }

    public void updateReader(String first_name, String last_name, int age, String number){
        for (Reader reader : readers){
            if (reader.getFirst_name().equals(first_name) && reader.getLast_name().equals(last_name)){
                reader.setAge(age);
                reader.setNumber(number);
            }
        }
    }

    public List<Book> getAllBooks() {       //Method for return DB books;
        return library;
    }

    public void setAllBooks(List<Book> lib) {        //Method for add books to DB for other DB;
        library = lib;
    }

    public List<Reader> getAllReaders() {        //Method for return DB readers;
        return readers;
    }

    public void setAllReaders(List<Reader> red) {       //Method for add readers to DB for other DB;
        readers = red;
    }


}

