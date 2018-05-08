package com.cts.fsd.SkillTrackerAPI.skills;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin
public class SkillController {

	@Autowired
	private  SkillsService SkillService;
	
	@GetMapping("/")
	public ResponseEntity<List<SkillsDTO>> getSkillsDetails(){
		List<SkillsDTO> Skills = SkillService.getSkillsDetails();
		return new ResponseEntity<List<SkillsDTO>>(Skills,HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<SkillsDTO> postSkills(@RequestBody SkillsDTO skills){
		
		SkillsDTO SkillsDetail = SkillService.addSkills(skills);
		return new ResponseEntity<SkillsDTO>(SkillsDetail,HttpStatus.OK);
	}
	@PutMapping("/")
	public ResponseEntity<SkillsDTO> putSkills(@RequestBody SkillsDTO skills){
		
		SkillsDTO skillsDetail = SkillService.updateSkills(skills);
		return new ResponseEntity<SkillsDTO>(skillsDetail,HttpStatus.OK);
	}
	@DeleteMapping(value="{id}")
	public ResponseEntity<Void> deleteSkills(@PathVariable Long id){
		
		SkillService.deleteSkills(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@GetMapping(value="{id}")
	public ResponseEntity<SkillsDTO> getSkillsByID(@PathVariable Long id){
		
		SkillsDTO SkillsDetail =SkillService.getSkillsByID(id);
		return new ResponseEntity<SkillsDTO>(SkillsDetail,HttpStatus.OK);
	}
}
