package com.cts.fsd.SkillTrackerAPI;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.mockito.BDDMockito.doNothing;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.fsd.SkillTrackerAPI.associate.AssociateRepoDAO;
import com.cts.fsd.SkillTrackerAPI.skills.SkillController;
import com.cts.fsd.SkillTrackerAPI.skills.SkillRepoDAO;
import com.cts.fsd.SkillTrackerAPI.skills.SkillsDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(SkillController.class)
public class SkillControllerTest {
	
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private AssociateRepoDAO associateRepoDAO;
    
    @MockBean
    private SkillRepoDAO skillRepoDAO;
	
  @Test
  public void getSkillsTest() throws Exception{
      List<SkillsDTO> skills = new ArrayList<SkillsDTO>();
      SkillsDTO skillsDTO;
      skillsDTO= new SkillsDTO();
      skillsDTO.setSkillId(new Long(1));
      skills.add(skillsDTO);
      skillsDTO = new SkillsDTO();
      skillsDTO.setSkillId(new Long(2));
      skills.add(skillsDTO);

      given(skillRepoDAO.findAll()).willReturn(skills);

      mockMvc.perform(get("/api/skills/").accept(MediaType.APPLICATION_JSON_VALUE))
              .andExpect(status().isOk())
              .andExpect(jsonPath("$[0].skillId", is(1)))
              .andExpect(jsonPath("$[1].skillId", is(2)));

  }

  @Test
  public void getSkillTest() throws Exception{
	  SkillsDTO skillsDTO = new SkillsDTO();
	  skillsDTO.setSkillId(new Long(1));

      given(skillRepoDAO.findBySkillId(new Long(1))).willReturn(skillsDTO);

      mockMvc.perform(get("/api/skills/1").accept(MediaType.APPLICATION_JSON_VALUE))
              .andExpect(status().isOk())
              .andExpect(jsonPath("$.skillId", is(1)));
  }

  @Test
  public void addCategoryTest() throws Exception{
	  SkillsDTO skillsDTO = new SkillsDTO();
	  skillsDTO.setSkillId(new Long(1));

      given(skillRepoDAO.save(skillsDTO)).willReturn(skillsDTO);

      mockMvc.perform(post("/api/skills/").contentType(MediaType.APPLICATION_JSON).content(asJsonString(skillsDTO)).accept(MediaType.APPLICATION_JSON_VALUE))
              .andExpect(status().isOk());
  }

  @Test
  public void updateCategoryTest() throws Exception{
	  SkillsDTO skillsDTO = new SkillsDTO();
      skillsDTO.setSkillId(new Long(1));

      given(skillRepoDAO.save(skillsDTO)).willReturn(skillsDTO);

      mockMvc.perform(put("/api/skills/").contentType(MediaType.APPLICATION_JSON).content(asJsonString(skillsDTO)).accept(MediaType.APPLICATION_JSON_VALUE))
              .andExpect(status().isOk());
  }

  @Test
  public void deleteCategoryTest() throws Exception{

      doNothing().when(skillRepoDAO).deleteById(new Long(1));

      mockMvc.perform(delete("/api/skills/1").accept(MediaType.APPLICATION_JSON_VALUE))
              .andExpect(status().isOk());
  }
  
  public static String asJsonString(final Object obj) {
      try {
          return new ObjectMapper().writeValueAsString(obj);
      } catch (Exception e) {
          throw new RuntimeException(e);
      }
  }


}
