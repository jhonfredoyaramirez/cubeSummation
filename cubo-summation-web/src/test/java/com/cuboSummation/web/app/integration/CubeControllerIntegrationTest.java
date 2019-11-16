package com.cuboSummation.web.app.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import com.cuboSummation.web.app.domain.Cube;
import com.cuboSummation.web.app.domain.SumCube;
import com.cuboSummation.web.app.testDataBuilder.CubeTestDataBuilder;
import com.cuboSummation.web.app.testDataBuilder.SumCubeTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration
public class CubeControllerIntegrationTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	private final ObjectMapper om = new ObjectMapper();

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	@Rollback(true)
	public void createCubeTest() throws Exception {
		URI uri = UriComponentsBuilder.fromUriString("/cube/create/4").build().encode().toUri();
		mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_FORM_URLENCODED).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	@Rollback(true)
	public void UpdateValuePositionCubeTest() throws Exception {
		URI uri = UriComponentsBuilder.fromUriString("/cube/updatePosition").build().encode().toUri();
		createCubeTest();
		Cube cube = new CubeTestDataBuilder().build();
		mockMvc.perform(post(uri).content(om.writeValueAsString(cube))
				.contentType(MediaType.APPLICATION_FORM_URLENCODED).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void SumPositionCube() throws Exception {
		URI uri = UriComponentsBuilder.fromUriString("/cube/sumPositions").build().encode().toUri();
		createCubeTest();
		UpdateValuePositionCubeTest();

		SumCube sumCube = new SumCubeTestDataBuilder().build();

		mockMvc.perform(post(uri).content(om.writeValueAsString(sumCube))
				.contentType(MediaType.APPLICATION_FORM_URLENCODED).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

}
