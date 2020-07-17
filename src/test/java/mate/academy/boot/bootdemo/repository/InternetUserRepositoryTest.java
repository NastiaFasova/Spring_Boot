package mate.academy.boot.bootdemo.repository;

import mate.academy.boot.bootdemo.model.InternetUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class InternetUserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private InternetUserRepository internetUserRepository;

    private InternetUser internetUser = new InternetUser();

    @Test
    public void saveInternetUserTest() {
        Assert.assertEquals(internetUser, entityManager.persistAndFlush(internetUser));
    }

    @Test
    public void findByLoginTest() {
        internetUser.setLogin("login");
        internetUser = entityManager.persistAndFlush(internetUser);
        Assert.assertEquals(internetUser, internetUserRepository.findByLogin("login"));
    }
}
