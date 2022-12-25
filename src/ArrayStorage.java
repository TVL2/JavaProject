import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private Resume[] storage = new Resume[5];
    private int size = 0;

    private boolean resumeAvailabilityCheck(Object o){
            if (o.getClass().isInstance(String.class)) {
                for ( Resume r: storage) {
                    if (r.uuid.equals(o)) return true;
                }
            }
            if (o.getClass().isInstance(Resume.class)) {
                return Arrays.asList(this.storage).contains((Resume) o);
            }
            return false;
    }

    void clear() {
        storage = new Resume[5];
        size = 0;
    }

    void update(Resume r) {
        //TODO check if resume present
        if (resumeAvailabilityCheck(r)) {
            for (int i = 0; i < size(); i++) {
                if (storage[i] == r) {
                    storage[i].uuid = r.uuid;
                    break;
                }
            }
        }
        else System.out.println("Resume not found");
    }

    void save(Resume r) {
        //TODO check if resume not present
        if (!resumeAvailabilityCheck(r)) {
            for (int i = 0; i < storage.length; i++) {
                if (storage[i] == null) {
                    storage[i] = r;
                    size++;
                    break;
                }
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < this.size(); i++) {
            if (storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        //TODO check if resume present
        if (resumeAvailabilityCheck(uuid)) {
            for (int i = 0; i < this.size(); i++) {
                if (storage[i].toString().equals(uuid)) {
                    storage[i] = null;
                    if (this.size() - 1 - i >= 0) System.arraycopy(storage, i + 1, storage, i, this.size() - 1 - i);
                    storage[this.size() - 1] = null;
                    size--;
                    break;
                }
            }
        }
        else System.out.println("Resume not found");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] storageWithResumes = new Resume[this.size];
        if (this.size() >= 0) System.arraycopy(storage, 0, storageWithResumes, 0, this.size());
        return storageWithResumes;
    }

    int size() {
        return size;
    }
}
