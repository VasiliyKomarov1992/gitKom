package jdbcTestCourses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PersisterTest {

	@Test
	public void test() {
		User fakeUser = new User("Michel", "321", "mich@gmail.com");
		Persister.persist(fakeUser);
		assertTrue(Persister.tables.size() > 0);
		assertEquals("User", Persister.tables.get(0));
	}
}