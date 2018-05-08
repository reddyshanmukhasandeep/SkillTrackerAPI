/**
 * 
 */
package com.cts.fsd.SkillTrackerAPI.skills;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Sandeep
 *
 */
@Service
public class SkillServiceImpl implements SkillsService {

	 @Autowired
	private  SkillRepoDAO skillRepoDAO;
	@Override
	public List<SkillsDTO> getSkillsDetails() {
		// TODO Auto-generated method stub
		return skillRepoDAO.findAll();
	}

	@Override
	public SkillsDTO addSkills(SkillsDTO skills) {
		// TODO Auto-generated method stub
		return skillRepoDAO.save(skills);
	}

	@Override
	public SkillsDTO updateSkills(SkillsDTO skills) {
		// TODO Auto-generated method stub
		return skillRepoDAO.save(skills);
	}

	@Override
	public void deleteSkills(Long id) {
		skillRepoDAO.deleteById(id);
	}

	@Override
	public SkillsDTO getSkillsByID(Long id) {
		return skillRepoDAO.findBySkillId(id);
		// TODO Auto-generated method stub
		
	}

}
