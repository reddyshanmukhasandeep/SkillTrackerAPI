package com.cts.fsd.SkillTrackerAPI.skills;

import java.util.List;

public interface SkillsService {

	List<SkillsDTO> getSkillsDetails();

	SkillsDTO addSkills(SkillsDTO skills);

	SkillsDTO updateSkills(SkillsDTO Skills);


	void deleteSkills(Long id);

	SkillsDTO getSkillsByID(Long id);

	

}
