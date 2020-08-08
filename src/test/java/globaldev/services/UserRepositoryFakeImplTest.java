package globaldev.services;

import org.globaldev.services.impl.UserRepositoryFakeImpl;
import org.junit.Assert;
import org.junit.Test;


public class UserRepositoryFakeImplTest {

    @Test
    public void verifyIfUserisReturned() {
        UserRepositoryFakeImpl repo = new UserRepositoryFakeImpl();

        String user = "USER";
        Assert.assertNotNull(repo.findByUsername(user));
    }

    @Test
    public void verifyIfUserisNotReturned() {
        UserRepositoryFakeImpl repo = new UserRepositoryFakeImpl();

        String user = "DSADADA";
        Assert.assertNull(repo.findByUsername(user));
    }
}
