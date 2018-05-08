package com.cts.fsd.SkillTrackerAPI.associate;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.fsd.SkillTrackerAPI.skills.SkillsDTO;

@RestController
@CrossOrigin()
@RequestMapping("/api/associate")

public class AssociateController {

	@Autowired
	private  AssociateService associateService;
	
	
	@GetMapping("")
	public ResponseEntity<List<AssociateDTO>> getAssociateDetails(){
		List<AssociateDTO> Associate = associateService.getAssociateDetails();
		return new ResponseEntity<List<AssociateDTO>>(Associate,HttpStatus.OK);
	}
	
	@GetMapping("/searchByName")
public ResponseEntity<List<AssociateDTO>> getAssociateDetailsByName(@RequestParam("name") String name){

	List<AssociateDTO> Associate=associateService.getAssociateDetailsByName(name);
	return new ResponseEntity<List<AssociateDTO>>(Associate,HttpStatus.OK);
}
	@GetMapping("/searchById")
	public ResponseEntity<List<AssociateDTO>> getAssociateDetailsById(@RequestParam(value="id") Long id){
			
			List<AssociateDTO> Associate=associateService.getAssociateDetailsByAsscoiateId(id);
			return new ResponseEntity<List<AssociateDTO>>(Associate,HttpStatus.OK);
		}
		
		@GetMapping("/searchByEmail")
	public ResponseEntity<List<AssociateDTO>> getAssociateDetailsByEmail(@RequestParam(value = "email") String email){
			
			List<AssociateDTO> Associate=associateService.getAssociateDetailsByEmail(email);
			return new ResponseEntity<List<AssociateDTO>>(Associate,HttpStatus.OK);
		}
		
		@GetMapping("/searchByMobile")
	public ResponseEntity<List<AssociateDTO>> getAssociateDetailsByMobile(@RequestParam(value="mobile") String mobile){
			
			List<AssociateDTO> Associate=associateService.getAssociateDetailsByMobile(mobile);
			return new ResponseEntity<List<AssociateDTO>>(Associate,HttpStatus.OK);
		}
		
		@GetMapping("/searchByStrength")
	public ResponseEntity<List<AssociateDTO>> getAssociateDetailsByStrength(@RequestParam(value="strength") String strength){
			
			List<AssociateDTO> Associate=associateService.getAssociateDetailsByStrength(strength);
			return new ResponseEntity<List<AssociateDTO>>(Associate,HttpStatus.OK);
		}
		
	
	
	@PostMapping("")
	public ResponseEntity<AssociateDTO> postAssociate(@RequestBody AssociateDTO Associate){
		
		AssociateDTO AssociateDetail = associateService.addAssociate(Associate);
		return new ResponseEntity<AssociateDTO>(AssociateDetail,HttpStatus.OK);
	}
	@PutMapping("")
	public ResponseEntity<AssociateDTO> putAssociate(@RequestBody AssociateDTO Associate){
		
			
		AssociateDTO AssociateDetail = associateService.updateAssociate(Associate);
		return new ResponseEntity<AssociateDTO>(AssociateDetail,HttpStatus.OK);
		
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteAssociate(@PathVariable Long id){
		
		associateService.deleteAssociate(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@GetMapping(value="{id}")
	public ResponseEntity<AssociateDTO> getSkillsByID(@PathVariable Long id){
		
		AssociateDTO AssociateDetail =associateService.getAssociateByID(id);
		return new ResponseEntity<AssociateDTO>(AssociateDetail,HttpStatus.OK);
	}
}
