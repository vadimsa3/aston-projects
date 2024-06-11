import java.util.logging.Level;
import java.util.logging.Logger;

public class ArrayListImpl<T> {

    private final int FIRST_ARRAY_CAPACITY = 10;
    private Object[] myArray = new Object[FIRST_ARRAY_CAPACITY];
    private int size;

    Logger logger = Logger.getLogger("ArrayListImpl");

    public void add(T element) {
        if (size == myArray.length) {
            extensionArray();
        }
        myArray[size++] = element;
    }

    public void addByIndex(int index, T element) {
        myArray[index] = element;
        size++;
        logger.log(Level.INFO, "Element " + element + " added to the array list to the index " + index);
        if (size == myArray.length) {
            extensionArray();
        }
    }

    public int length() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " not found, Size ArrayList: " + size);
        }
        return (T) myArray[index];
    }

    public void extensionArray() {
        Object[] newArray = new Object[myArray.length * 2];
        System.arraycopy(myArray, 0, newArray, 0, size);
        myArray = newArray;
        logger.log(Level.INFO, "Array extension success");
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " not found, Size ArrayList: " + size);
        }
        myArray[index] = null;
        logger.log(Level.INFO, "Element " + index + " removed from the array list");
    }
}