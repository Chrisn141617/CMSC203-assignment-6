import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {
	Customer c1, c2;
	@BeforeEach
	void setUp() throws Exception {
		c1 = new Customer("name 1", 10);
	}

	@AfterEach
	void tearDown() throws Exception {
		c1 = null;
	}

	@Test
	void testCustomerStringInt() {
		Customer c2  = new Customer(c1);
		
		assertFalse(c1 == c2);
		c2.setName("name2");
		c2.setAge(20);
		assertFalse(c2.getName().equals(c1.getName()));
		assertFalse(c2.getAge() == c1.getAge());

	}

}
