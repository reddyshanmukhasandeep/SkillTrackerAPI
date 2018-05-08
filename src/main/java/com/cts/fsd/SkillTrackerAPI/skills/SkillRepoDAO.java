package com.cts.fsd.SkillTrackerAPI.skills;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepoDAO extends JpaRepository<SkillsDTO, Long> {

	
	public SkillsDTO findBySkillId(Long id);

}
