package JavaProject.storage;

import JavaProject.exception.ExistStorageException;
import JavaProject.exception.NotExistStorageException;
import JavaProject.exception.StorageException;
import JavaProject.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    protected abstract int resumeAvailabilityCheck(String uuid);

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int index = resumeAvailabilityCheck(r.toString());
        if(index < 0){
            throw new NotExistStorageException(r.toString());
        }
        else{
            storage[index] = r;
        }
    }

    public void save(Resume r) {
        int index = resumeAvailabilityCheck(r.toString());
        if(index >= 0){
            throw new ExistStorageException(r.toString());
            }
        else if (storage.length == size()) {
            throw new StorageException("Resume storage is full!!!", r.toString());
        }
        else{
            saveElement(r, index);
            size++;
        }
    }

    protected abstract void saveElement(Resume r, int index);

    public Resume get(String uuid) {
        int index = resumeAvailabilityCheck(uuid);
        if(index < 0){
            throw new NotExistStorageException(uuid);
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = resumeAvailabilityCheck(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
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
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }
}
