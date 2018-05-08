package com.cts.fsd.SkillTrackerAPI.associate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociateServiceImpl implements AssociateService {

	@Autowired
	private AssociateRepoDAO associateRepo;
	
	@Override
	public List<AssociateDTO> getAssociateDetails() {
		// TODO Auto-generated method stub
		return (List<AssociateDTO>) associateRepo.findAll();
	}

	@Override
	public AssociateDTO addAssociate(AssociateDTO associate) {
		// TODO Auto-generated method stub
		return associateRepo.save(associate);
	}

	@Override
	public AssociateDTO updateAssociate(AssociateDTO associate) {
		// TODO Auto-generated method stub
		return associateRepo.save(associate);
	}

	@Override
	public void deleteAssociate(Long id) {
		// TODO Auto-generated method stub
		associateRepo.deleteById(id);
	}

	@Override
	public List<AssociateDTO> getAssociateDetailsByName(String name) {
		// TODO Auto-generated method stub
		
		return associateRepo.findByNameIgnoreCaseContaining(name);
	}
	@Override
	public List<AssociateDTO> getAssociateDetailsByAsscoiateId(Long id) {
		// TODO Auto-generated method stub
		return associateRepo.findByAssociateID(id);
	}

	@Override
	public List<AssociateDTO> getAssociateDetailsByEmail(String email) {
		// TODO Auto-generated method stub
		return associateRepo.findByEmailIgnoreCaseContaining(email);
	}

	@Override
	public List<AssociateDTO> getAssociateDetailsByMobile(String mobile) {
		// TODO Auto-generated method stub
		return associateRepo.findByMobileIgnoreCaseContaining(mobile);
	}

	@Override
	public List<AssociateDTO> getAssociateDetailsByStrength(String strength) {
		// TODO Auto-generated method stub
		return associateRepo.findByStrengthIgnoreCaseContaining(strength);
	}

	@Override
	public AssociateDTO getAssociateByID(Long id) {
		// TODO Auto-generated method stub
		return associateRepo.findByAscID(id);
	}

	

}
