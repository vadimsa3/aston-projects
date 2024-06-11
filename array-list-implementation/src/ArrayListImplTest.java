import org.junit.jupiter.api.Test;

class ArrayListImplTest {

    ArrayListImpl array = new ArrayListImpl<>();

    @Test
    void add() {
        int countElements = 15;
        String element = "test element";
        for (int i = 1; i <= countElements; i++) {
            array.add(element + " " + i);
        }
    }

    @Test
    void addByIndex() {
        System.out.println("Test metod -> addByIndex");
        add();
        System.out.println("Old element is - " + array.get(0));
        array.addByIndex(0, "new test element");
        System.out.println("New element is - " + array.get(0));
    }

    @Test
    void length() {
        System.out.println("Test metod -> length");
        add();
        System.out.println("Size is: " + array.length());
    }

    @Test
    void get() {
        System.out.println("Test metod -> get");
        add();
        System.out.println("Size: " + array.length());
        System.out.println("element: " + array.get(0));
        System.out.println("element: " + array.get(4));
    }

    @Test
    void remove() {
        System.out.println("Test metod -> remove");
        add();
        System.out.println("Old element is - " + array.get(3));
        int indexForDelete = 3;
        array.remove(3);
        System.out.println("Now element is - " + array.get(3));
    }
}