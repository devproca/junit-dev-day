package com.jimrennie.junit.world3;

import com.jimrennie.junit.world3.controller.StudentController;
import com.jimrennie.junit.world3.controller.StudentDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

/**
 * 1.2 Controller tests
 *
 * Let's use the Spring TestContext Framework to its full potential and write some controller integration tests on the
 * {@link StudentController} by using the {@link TestRestTemplate}. This level is a little less guided than previous
 * ones, so you might need to do some googling.
 *
 * Instructions:
 * - Run test class as a {@link SpringBootTest} with a web environment on a random port.
 * - Add test data using the student-test-data.sql located in src/test/resources using the {@link Sql} annotation.
 * - Follow test instructions
 */
@SpringBootTest(webEnvironment = RANDOM_PORT)
@Sql(scripts = "classpath:student-test-data.sql")
@Sql(scripts = "classpath:tear-down.sql", executionPhase = AFTER_TEST_METHOD)
class TestWorld3Level2 {

	@Autowired
	private TestRestTemplate restTemplate;

	/**
	 * Test that GET /api/students returns 4 students
	 */
	@Test
	void testFindAll() {
		StudentDto[] students = restTemplate.getForObject("/api/students", StudentDto[].class);

		assertEquals(4, students.length);
	}

	/**
	 * Test that GET /api/students?year=2012 returns one student with the name of Mark
	 * <p>
	 * Before you declare this test working try running all the tests in this test class. You can use tear-down.sql
	 * to clean up test data between classes if needed.
	 */
	@Test
	void testFindByGraduationYear() {
		StudentDto[] students = restTemplate.getForObject("/api/students?year=2012", StudentDto[].class);

		assertEquals(1, students.length);
		assertEquals("Mark", students[0].getName());
	}

	/**
	 * Test that GET /api/students/1231231 returns 404 not found
	 */
	@Test
	void testInvalidStudentId() {
		ResponseEntity<Object> response = restTemplate.getForEntity("/api/students/1231231", Object.class);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

}
