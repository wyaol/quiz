package com.twuc.shopping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.dto.GoodDto;
import com.twuc.shopping.entity.GoodEntity;
import com.twuc.shopping.repository.GoodRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ShoppingApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	GoodRepository goodRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void shouldAddGood() throws Exception {
		GoodDto goodDto = new GoodDto("good1", 1, "个", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2795307672,1765335907&fm=26&gp=0.jpg");
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(goodDto);

		mockMvc.perform(post("/goods").content(json).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
	}

	@Test
	void shouldGetGoods() throws Exception {
		GoodEntity goodEntity = new GoodEntity(1, "good1", 1, "个", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2795307672,1765335907&fm=26&gp=0.jpg");
		goodRepository.save(goodEntity);

		mockMvc.perform(get("/goods"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)));
	}

}
