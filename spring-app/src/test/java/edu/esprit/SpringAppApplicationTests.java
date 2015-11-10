package edu.esprit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

//@SpringBootApplication
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppInitializer.class)
@WebAppConfiguration
public class SpringAppApplicationTests {

	@Test
	public void contextLoads() {
	}

}
