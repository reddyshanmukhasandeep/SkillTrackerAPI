package com.cts.fsd.SkillTrackerAPI.associate;

import java.util.List;

public interface AssociateService {

	List<AssociateDTO> getAssociateDetails();

	AssociateDTO addAssociate(AssociateDTO associate);

	AssociateDTO updateAssociate(AssociateDTO associate);

	void deleteAssociate(Long id);

	List<AssociateDTO> getAssociateDetailsByName(String name);

	List<AssociateDTO> getAssociateDetailsByAsscoiateId(Long id);

	List<AssociateDTO> getAssociateDetailsByEmail(String email);

	List<AssociateDTO> getAssociateDetailsByMobile(String mobile);

	List<AssociateDTO> getAssociateDetailsByStrength(String strength);

	

	AssociateDTO getAssociateByID(Long id);

}
