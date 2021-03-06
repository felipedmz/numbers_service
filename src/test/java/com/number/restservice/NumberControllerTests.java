/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.number.restservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class NumberControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void isPerfectInvalidEntries() throws Exception {
		this.mockMvc.perform(get("/check/aaaa"))
			.andDo(print()).andExpect(status().isBadRequest());

		this.mockMvc.perform(get("/check/6.1"))
			.andDo(print()).andExpect(status().isBadRequest());

		this.mockMvc.perform(get("/check/6,2"))
			.andDo(print()).andExpect(status().isBadRequest());
	}

	@Test
	public void isPerfectNonNaturalNumbers() throws Exception {
		this.mockMvc.perform(get("/check/-50"))
			.andDo(print()).andExpect(status().isOk())
			.andExpect(jsonPath("$.perfect").value("false"));

		this.mockMvc.perform(get("/check/-1"))
			.andDo(print()).andExpect(status().isOk())
			.andExpect(jsonPath("$.perfect").value("false"));

		this.mockMvc.perform(get("/check/0"))
			.andDo(print()).andExpect(status().isOk())
			.andExpect(jsonPath("$.perfect").value("false"));
	}

	@Test
	public void isPerfectFalse() throws Exception {
		this.mockMvc.perform(get("/check/8"))
			.andDo(print()).andExpect(status().isOk())
			.andExpect(jsonPath("$.perfect").value("false"));

		this.mockMvc.perform(get("/check/42"))
			.andDo(print()).andExpect(status().isOk())
			.andExpect(jsonPath("$.perfect").value("false"));

		this.mockMvc.perform(get("/check/50135"))
			.andDo(print()).andExpect(status().isOk())
			.andExpect(jsonPath("$.perfect").value("false"));
	}

	@Test
	public void isPerfectTrue() throws Exception {
		this.mockMvc.perform(get("/check/6"))
			.andDo(print()).andExpect(status().isOk())
			.andExpect(jsonPath("$.perfect").value("true"));

		this.mockMvc.perform(get("/check/28"))
			.andDo(print()).andExpect(status().isOk())
			.andExpect(jsonPath("$.perfect").value("true"));

		this.mockMvc.perform(get("/check/496"))
			.andDo(print()).andExpect(status().isOk())
			.andExpect(jsonPath("$.perfect").value("true"));

		this.mockMvc.perform(get("/check/8128"))
			.andDo(print()).andExpect(status().isOk())
			.andExpect(jsonPath("$.perfect").value("true"));
	}
	
}