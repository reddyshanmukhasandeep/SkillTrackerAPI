package com.cts.fsd.SkillTrackerAPI.associate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociateRepoDAO extends JpaRepository<AssociateDTO, Long> {
	
	
	public List<AssociateDTO> findByNameIgnoreCaseContaining( String name);
    public List<AssociateDTO> findByAssociateID(Long id);
	public List<AssociateDTO> findByEmailIgnoreCaseContaining(String Email);
	public List<AssociateDTO> findByMobileIgnoreCaseContaining(String Mobile);
	public List<AssociateDTO> findByStrengthIgnoreCaseContaining(String Strength);
	public AssociateDTO findByAscID(Long id);
	
}
