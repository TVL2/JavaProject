package JavaProject.storage;

import JavaProject.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int resumeAvailabilityCheck(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }


    protected void saveElement(Resume r, int index){
        index = Math.abs(index + 1);
        if(size() - index - 1 >= 0) System.arraycopy(storage, index, storage, index + 1, size() - index);
        storage[index] = r;
    }

}
