package com.codeup.codeupspringblog;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertNotNull;
import static org.springframework.security.config.http.MatcherType.mvc;
@SpringBootTest
class CodeupSpringBlogApplicationTests {
	@Test
	void contextLoads() {
		// Sanity Test, just to make sure the MVC bean is working
		assertNotNull(mvc);
	}
	@Test
	public void testIfUserSessionIsActive() throws Exception {
		// It makes sure the returned session is not null
		assertNotNull(httpSession);
	}

}
