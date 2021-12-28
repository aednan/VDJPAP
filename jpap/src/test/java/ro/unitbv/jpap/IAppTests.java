package ro.unitbv.jpap;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ro.unitbv.jpap.dto.StudentDTO;
import ro.unitbv.jpap.service.IStudentService;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@EnabledOnJre({JRE.JAVA_11, JRE.JAVA_17})
class IAppTests {

	@Autowired
	TestRestTemplate testRestTemplate;

	@Autowired
	@Qualifier("StudentService")
	IStudentService studentService;

	@Test
	@Order(1)
	void login() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", "Basic YWRuYW46YWRuYW4=");
		HttpEntity request = new HttpEntity(httpHeaders);
		ResponseEntity response = this.testRestTemplate.exchange("/",HttpMethod.GET, request, List.class);
		assertEquals(HttpStatus.OK,response.getStatusCode());
	}
	@Test
	@Order(2)
	void fetchAll() {

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", "Basic YWRuYW46YWRuYW4=");
		HttpEntity request = new HttpEntity(httpHeaders);
		ResponseEntity response = this.testRestTemplate.exchange("/student/fetchAll", HttpMethod.GET, request, new ParameterizedTypeReference<List<StudentDTO>>() {
		});
		assertEquals(HttpStatus.OK,response.getStatusCode());
		assertNotNull(response.getBody());
		List<StudentDTO> studentDTOs = (List<StudentDTO>) response.getBody();
		assertEquals(4, studentDTOs.size());
	}

}
