package JavaProject.storage;


import JavaProject.exception.StorageException;
import JavaProject.model.Resume;
import org.junit.Assert;
import org.junit.Test;


public abstract class AbstractArrayStorageTest extends AbstractStorageTest{


    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }



    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {

        try {
            for (int i = 3; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("New"));
            }
        } catch (StorageException e) {
            Assert.fail();
        }
        storage.save(new Resume("Overflow"));
    }


}