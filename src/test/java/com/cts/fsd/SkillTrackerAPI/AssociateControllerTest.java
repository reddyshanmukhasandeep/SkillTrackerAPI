package com.cts.fsd.SkillTrackerAPI;


import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertArrayEquals;
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
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.fsd.SkillTrackerAPI.associate.AssociateController;
import com.cts.fsd.SkillTrackerAPI.associate.AssociateDTO;
import com.cts.fsd.SkillTrackerAPI.associate.AssociateRepoDAO;
import com.cts.fsd.SkillTrackerAPI.skills.SkillRepoDAO;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(AssociateController.class)
public class AssociateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AssociateRepoDAO associateRepoDAO;
    
    @MockBean
    private SkillRepoDAO skillRepoDAO;

    @Test
    public void getAssociateDetailsTest() throws Exception{
        List<AssociateDTO> associateDetails = new ArrayList<AssociateDTO>();
        AssociateDTO associateDTO;
        associateDTO= new AssociateDTO();
        associateDTO.setAsc_ID(new Long(1));
        associateDetails.add(associateDTO);
        associateDTO = new AssociateDTO();
        associateDTO.setAsc_ID(new Long(2));
        associateDetails.add(associateDTO);

        given(associateRepoDAO.findAll()).willReturn(associateDetails);

        mockMvc.perform(get("/api/associate").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].asc_ID", is(1)))
                .andExpect(jsonPath("$[1].asc_ID", is(2)));

    }

    @Test
    public void getAssociateDetailByIdTest() throws Exception{
    	List<AssociateDTO> associateDetails = new ArrayList<AssociateDTO>();
    	AssociateDTO associateDTO;
        associateDTO= new AssociateDTO();
        associateDTO.setAsc_ID(new Long(1));
        associateDetails.add(associateDTO);

        given(associateRepoDAO.findByAssociateID(new Long(1))).willReturn(associateDetails);

        mockMvc.perform(get("/api/associate/searchById?id=1").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].asc_ID", is(1)));
    }
    
    @Test
    public void getAssociateDetailByNameTest() throws Exception{
    	List<AssociateDTO> associateDetails = new ArrayList<AssociateDTO>();
    	AssociateDTO associateDTO;
        associateDTO= new AssociateDTO();
        associateDTO.setAsc_ID(new Long(1));
        associateDetails.add(associateDTO);

        given(associateRepoDAO.findByNameIgnoreCaseContaining("abc")).willReturn(associateDetails);

        mockMvc.perform(get("/api/associate/searchByName?name=abc").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].asc_ID", is(1)));
    }
    
    @Test
    public void getAssociateDetailByEmailTest() throws Exception{
    	List<AssociateDTO> associateDetails = new ArrayList<AssociateDTO>();
    	AssociateDTO associateDTO;
        associateDTO= new AssociateDTO();
        associateDTO.setAsc_ID(new Long(1));
        associateDetails.add(associateDTO);

        given(associateRepoDAO.findByEmailIgnoreCaseContaining("abc@abc.com")).willReturn(associateDetails);

        mockMvc.perform(get("/api/associate/searchByEmail?email=abc@abc.com").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].asc_ID", is(1)));
    }
    
    @Test
    public void getAssociateDetailByMobileTest() throws Exception{
    	List<AssociateDTO> associateDetails = new ArrayList<AssociateDTO>();
    	AssociateDTO associateDTO;
        associateDTO= new AssociateDTO();
        associateDTO.setAsc_ID(new Long(1));
        associateDetails.add(associateDTO);

        given(associateRepoDAO.findByMobileIgnoreCaseContaining("1234567890")).willReturn(associateDetails);

        mockMvc.perform(get("/api/associate/searchByMobile?mobile=1234567890").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].asc_ID", is(1)));
    }
    
    @Test
    public void getAssociateDetailByIdStrength() throws Exception{
    	List<AssociateDTO> associateDetails = new ArrayList<AssociateDTO>();
    	AssociateDTO associateDTO;
        associateDTO= new AssociateDTO();
        associateDTO.setAsc_ID(new Long(1));
        associateDetails.add(associateDTO);

        given(associateRepoDAO.findByStrengthIgnoreCaseContaining("1")).willReturn(associateDetails);

        mockMvc.perform(get("/api/associate/searchByStrength?strength=1").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].asc_ID", is(1)));
    }
    
    @Test
    public void addAssociateTest() throws Exception{
        AssociateDTO associateDTO = new AssociateDTO();
        associateDTO.setAsc_ID(new Long(1));

        given(associateRepoDAO.save(associateDTO)).willReturn(associateDTO);

        mockMvc.perform(post("/api/associate").contentType(MediaType.APPLICATION_JSON).content(asJsonString(associateDTO)).accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    public void updateAssociateTest() throws Exception{
    	AssociateDTO associateDTO = new AssociateDTO();
        associateDTO.setAsc_ID(new Long(1));

        given(associateRepoDAO.save(associateDTO)).willReturn(associateDTO);

        mockMvc.perform(put("/api/associate").contentType(MediaType.APPLICATION_JSON).content(asJsonString(associateDTO)).accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteAssociateTest() throws Exception{

    	AssociateDTO associateDTO = new AssociateDTO();
        associateDTO.setAsc_ID(new Long(1));

        doNothing().when(associateRepoDAO).deleteById(new Long(1));

        mockMvc.perform(delete("/api/associate/1").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }
    
    @Test
    public void getSkillByIDTest() throws Exception{

    	AssociateDTO associateDTO;
        associateDTO= new AssociateDTO(new Long(1), "123", "Test", "abc@abc.com", "1234567890", null,
    			true, false, false, true, false, false,
    			"Test", "Test", "Test");
        
        given(associateRepoDAO.findByAscID(new Long(1))).willReturn(associateDTO);

        mockMvc.perform(get("/api/associate/1").accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.asc_ID", is(1)));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
