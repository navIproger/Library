import java.io.*;
import java.util.List;
import java.util.Scanner;

public class App {
    private static Scanner scan = new Scanner(System.in);

    private static Library library;

    private static String fileNameBook = "book.book";
    private static String fileNameReader = "reader.reader";
    private static File fileBook = new File(fileNameBook);
    private static File fileReader = new File(fileNameReader);

    private static void startApp() {
        isFileExist(fileBook);
        isFileExist(fileReader);

        if (!isFileEmpty(fileBook)) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileBook))) {
                library.setAllBooks((List<Book>) objectInputStream.readObject());
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        if (!isFileEmpty(fileReader)) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileReader))) {
                library.setAllReaders((List<Reader>) objectInputStream.readObject());
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        System.out.println("\nВітаю в моїй простій програмі, організація біліотеки");
    }

    private static void endApp() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileBook))) {
            objectOutputStream.writeObject(library.getAllBooks());
        } catch (Exception e) {
            System.out.println(e);
        }

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileReader))) {
            objectOutputStream.writeObject(library.getAllReaders());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static boolean isFileEmpty(File file) {
        if (file.length() == 0) {
            return true;
        }
        return false;
    }

    private static void isFileExist(File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        library = new Library();
        startApp();

        String title;
        String dateOfDelivery;
        int dateOfPublication;

        String name;
        String surname;
        int age;
        String number;

        int operation = 0;

        do{
            System.out.print("\nОперації\n" +
                    "1.Додати книгу\n" +
                    "2.Видалити книгу\n" +
                    "3.Видати книгу читачу\n" +
                    "4.Повернути книгу\n" +
                    "5.Знайти книгу\n" +
                    "6.Додати читача\n" +
                    "7.Видалити читача\n" +
                    "8.Знайти читача\n" +
                    "9.Оновити дані читача\n" +
                    "10.Вивести всі книги\n" +
                    "11.Вивести всіх читачів\n" +
                    "0.Вихід\n" +
                    "Ваша операція: ");

            operation = scan.nextInt();

            switch (operation){

                case 1:
                    System.out.print("\nВведіть назву книги: ");
                    title = scan.next();
                    System.out.print("Введіть дату публікації книги: ");
                    dateOfPublication = scan.nextInt();
                    System.out.print("Введіть сьогоднішню дату: ");
                    dateOfDelivery = scan.next();
                    library.addBooks(new Book(title, dateOfPublication, dateOfDelivery));
                    break;

                case 2:
                    System.out.print("\nВведіть назву книги: ");
                    title = scan.next();
                    System.out.print("Введіть дату публікації книги: ");
                    dateOfPublication = scan.nextInt();
                    System.out.println("\n" + library.removeBook(title, dateOfPublication) + "n");
                    break;

                case 3:
                    System.out.print("\nВведіть назву книги: ");
                    title = scan.next();
                    System.out.print("Введіть ім'я  читача: ");
                    name = scan.next();
                    System.out.print("Введіть прізвище читача: ");
                    surname = scan.next();
                    System.out.print("Введіть сьогоднішню дату: ");
                    dateOfDelivery = scan.next();
                    System.out.println("\n" + library.takeBook(title, name, surname, dateOfDelivery) + "\n");
                    break;

                case 4:
                    System.out.print("Введіть назву книги: ");
                    title = scan.next();
                    System.out.print("Введіть ім'я  читача: ");
                    name = scan.next();
                    System.out.print("Введіть прізвище читача: ");
                    surname = scan.next();
                    System.out.print("Введіть сьогоднішню дату: ");
                    dateOfDelivery = scan.next();
                    System.out.println("\n" + library.returnBook(title, name, surname, dateOfDelivery) + "\n");
                    break;

                case 5:
                    System.out.print("\nВведіть назву книги: ");
                    title = scan.next();
                    System.out.println("\n" + library.searchBook(title) + "\n");
                    break;

                case 6:
                    System.out.print("\nВведіть і'мя читачи: ");
                    name = scan.next();
                    System.out.print("Введіть прізвище читача: ");
                    surname = scan.next();
                    System.out.print("Введіть вік читача: ");
                    age = scan.nextInt();
                    System.out.print("Введіть тел.номер читача: ");
                    number = scan.next();
                    library.addReader(new Reader(name, surname, age, number));
                    break;

                case 7:
                    System.out.print("\nВведіть і'мя читачи: ");
                    name = scan.next();
                    System.out.print("Введіть прізвище читача: ");
                    surname = scan.next();
                    System.out.println("\n" + library.removeReader(name, surname) + "\n");
                    break;

                case 8:
                    System.out.print("\nВведіть і'мя читачи: ");
                    name = scan.next();
                    System.out.print("Введіть прізвище читача: ");
                    surname = scan.next();
                    System.out.println("\n" + library.searchReader(name, surname) + "\n");
                    break;

                case 9:
                    System.out.print("\nВведіть і'мя читачи: ");
                    name = scan.next();
                    System.out.print("Введіть прізвище читача: ");
                    surname = scan.next();
                    System.out.print("Введіть вік читача: ");
                    age = scan.nextInt();
                    System.out.print("Введіть тел.номер читача: ");
                    number = scan.next();
                    library.updateReader(name, surname, age, number);
                    break;

                case 10:
                    System.out.println();
                    for (Book book : library.getAllBooks()){
                        System.out.println(book);
                    }
                    System.out.println();
                    break;

                case 11:
                    System.out.println();
                    for (Reader reader : library.getAllReaders()){
                        System.out.println(reader);
                    }
                    System.out.println();
                    break;

                default:
                    if (operation != 0){
                        System.out.println("\nНевірна операція\n");
                    }
                    break;
            }
        } while (operation != 0);

        endApp();
    }
}