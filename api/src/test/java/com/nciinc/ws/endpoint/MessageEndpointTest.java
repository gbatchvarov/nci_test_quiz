package com.nciinc.ws.endpoint;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.nciinc.ws.dto.TopicCategoryInfo;
import com.nciinc.ws.repository.TopicCategoryDAO;
import com.nciinc.ws.repository.TopicDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(MessageEndpoint.class)
public class MessageEndpointTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	MessageEndpoint messageEndpoint;

	@MockBean
	TopicCategoryDAO topicCategoryDAO;

	@MockBean
	TopicDAO topicDAO;

	/**
	 * @throws Exception
	 * @ApiOperation(value = "Get the list of all categories")
	 * @RequestMapping(value = "/category", method = RequestMethod.GET, produces
	 *                       = "application/json") )
	 */
	@Test
	public void getCategories() throws Exception {
		Date createDate = new Date();

		TopicCategoryInfo cat1 = new TopicCategoryInfo(1, "Cat1", "Cat1Desc", createDate);
		TopicCategoryInfo cat2 = new TopicCategoryInfo(2, "Cat2", "Cat2Desc", createDate);

		List<TopicCategoryInfo> categories = new ArrayList<>();
		categories.add(cat1);
		categories.add(cat2);

		given(this.messageEndpoint.getCategories()).willReturn(categories);

		//@formatter:off
		mockMvc.perform(
	                get("/category").accept(MediaType.APPLICATION_JSON))
		                .andExpect(status().isOk())
		                .andExpect(content().contentType("application/json;charset=UTF-8"))
		                .andExpect(jsonPath("$", hasSize(2)))
		                .andExpect(jsonPath("$.[0].id", is(1)))
		                .andExpect(jsonPath("$.[0].name", is(cat1.getName())))
		                .andExpect(jsonPath("$.[0].description", is(cat1.getDescription())))
		                .andExpect(jsonPath("$.[0].createDate", is(cat1.getCreateDate().getTime())));
		 //@formatter:on

	}

	/**
	 * @throws Exception
	 * @ApiOperation(value = "Get topic by id")
	 * @RequestMapping(value = "/topic/{topicId}", method = RequestMethod.GET,
	 *                       produces = "application/json")
	 */
	@Test
	public void getTopic() throws Exception {

	}

	/**
	 * @ApiOperation(value = "Create topic")
	 * @RequestMapping(value = "/topic", method = RequestMethod.POST, consumes =
	 *                       "application/json")
	 */
	@Test
	public void createTopic() {

	}

	/**
	 * @ApiOperation(value = "Update topic")
	 * @RequestMapping(value = "/topic/{topicId}", method = RequestMethod.POST,
	 *                       consumes = "application/json")
	 */
	@Test
	public void updateTopic() {

	}

	/**
	 * @ApiOperation(value = "Get the list of all topics by category")
	 * @RequestMapping(value = "/topic/bycategory/{categoryId}", method =
	 *                       RequestMethod.GET, produces = "application/json")
	 */
	@Test
	public void getCategoriesByTopic() {

	}
}
