package JavaProject.storage;

import JavaProject.model.Resume;


/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage{

    @Override
    protected int resumeAvailabilityCheck(String uuid) {

        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) return i;
        }
        return -1;
    }

    @Override
    protected void saveElement(Resume r, int index){
        storage[size] = r;
    }
}
