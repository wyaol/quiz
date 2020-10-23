package com.twuc.shopping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.dto.GoodDto;
import com.twuc.shopping.dto.GoodsBuyDto;
import com.twuc.shopping.dto.OrderDto;
import com.twuc.shopping.entity.GoodEntity;
import com.twuc.shopping.entity.OrderEntity;
import com.twuc.shopping.repository.GoodRepository;
import com.twuc.shopping.repository.OrderRepository;
import com.twuc.shopping.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ShoppingApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	GoodRepository goodRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderService orderService;

	void addGood(Integer id) {
		GoodEntity goodEntity = new GoodEntity(id, "good1", 1, "个", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2795307672,1765335907&fm=26&gp=0.jpg");
		goodRepository.save(goodEntity);
	}

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

	@Test
	void shouldAddOrder() throws Exception {
		Integer goodId = 1;
		addGood(goodId);

		ArrayList<GoodsBuyDto> goodsBuyDtos = new ArrayList<>();
		goodsBuyDtos.add(new GoodsBuyDto(goodId, 1));
		OrderDto orderDto = new OrderDto(1, goodsBuyDtos);
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(orderDto);
		System.out.println(json);
		mockMvc.perform(post("/orders").content(json).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
	}

	@Test
	void shouldAddOrderByService() throws Exception {
		OrderEntity orderEntity = new OrderEntity(1, 1, 1, 1);
		orderRepository.save(orderEntity);
	}

	@Test
	void shouldGetOrders() throws Exception {
		OrderEntity orderEntity = new OrderEntity(1, 1, 1, 1);
		orderRepository.save(orderEntity);

		mockMvc.perform(get("/orders"))
				.andExpect(status().isOk());
	}

}
