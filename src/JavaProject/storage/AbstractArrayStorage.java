package JavaProject.storage;

import JavaProject.exception.StorageException;
import JavaProject.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;


    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }


    @Override
    protected abstract Integer getSearchKey(String uuid);

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        storage[(Integer) searchKey] = r;
    }


    @Override
    protected void doSave(Resume r, Object index) {
        if (STORAGE_LIMIT == size()) {
            throw new StorageException("Resume storage is full!!!", r.toString());
        } else {
            saveElement(r, (Integer) index);
            size++;
        }
    }


    @Override
    protected void doDelete(Object searchKey) {
        Integer index = (Integer) searchKey;
        storage[index] = null;
        if (this.size() - 1 - index >= 0) System.arraycopy(storage, index + 1, storage, index, this.size() - 1 - index);
        storage[this.size() - 1] = null;
        size--;
    }

    @Override
    protected Resume doGet(Object index) {
        return storage[(Integer) index];
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    @Override
    public List<Resume> doCopyAll() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }

    public int size() {
        return size;
    }
}
