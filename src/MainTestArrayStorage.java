import JavaProject.model.Resume;
import JavaProject.storage.SortedArrayStorage;

/**
 * Test for your JavaProject.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    //static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();
    static final SortedArrayStorage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        final Resume r1 = new Resume("uuid1", "Name1");

        final Resume r2 = new Resume("uuid2", "Name2");

        final Resume r3 = new Resume("uuid3", "Name3");

        final Resume r6 = new Resume("uuid6", "Name4");

        final Resume r5 = new Resume("uuid5", "Name4");

        final Resume r4 = new Resume("uuid4", "Name5");

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);
        ARRAY_STORAGE.save(r6);
        ARRAY_STORAGE.save(r5);
        printAll();
        ARRAY_STORAGE.save(r4);
        printAll();
        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.toString()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.delete(r1.toString());
        printAll();
        ARRAY_STORAGE.save(r1);
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }
}
