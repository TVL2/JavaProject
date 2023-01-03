import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    public static final int STORAGE_LIMIT = 10000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    private int resumeAvailabilityCheck(String uuid) {

        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) return i;
        }
        return -1;
    }

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void update(Resume r) {
        int index = resumeAvailabilityCheck(r.toString());
        if(index == -1){
            System.out.println("Resume not found");
        }
        else{
            storage[index] = r;
        }
    }

    void save(Resume r) {
        int index = resumeAvailabilityCheck(r.toString());
        if(index != -1){
            System.out.println("Resume " + r.toString() + " already exist!");
            }
        else if (storage.length == size()) {
            System.out.println("Resume storage is full!!!");
        }
        else{
            storage[size] = r;
            size++;
        }
    }

    Resume get(String uuid) {
        int index = resumeAvailabilityCheck(uuid);
        if(index == -1){
            System.out.println("Resume not found");
            return  null;
        }
        return storage[index];
    }

    void delete(String uuid) {
        int index = resumeAvailabilityCheck(uuid);
        if (index == -1) {
            System.out.println("Resume not found");
        }
        else {
            storage[index] = null;
            if (this.size() - 1 - index >= 0) System.arraycopy(storage, index + 1, storage, index, this.size() - 1 - index);
            storage[this.size() - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    int size() {
        return size;
    }
}
