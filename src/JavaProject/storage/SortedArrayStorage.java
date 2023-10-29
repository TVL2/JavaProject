package JavaProject.storage;

import JavaProject.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    /*private static class ResumeComparator implements Comparator<Resume> {

        @Override
        public int compare(Resume o1, Resume o2) {
            return o1.toString().compareTo(o2.toString());
        }
    }*/
    /*
    private  static final Comparator<Resume> RESUME_COMPARATOR = new Comparator<>(){
        @Override
        public int compare(Resume o1, Resume o2) {
            return o1.toString().compareTo(o2.toString());
        }
    };*/
    private static final Comparator<Resume> RESUME_COMPARATOR = (o1, o2)-> o1.getUuid().compareTo(o2.getUuid());


    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "dummy");
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }


    protected void saveElement(Resume r, int index){
        index = - index - 1;
        System.arraycopy(storage, index, storage, index + 1, size() - index);
        storage[index] = r;
    }


}
