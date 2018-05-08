package com.cts.fsd.SkillTrackerAPI.skills;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="skills")
public class SkillsDTO {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="Skill_ID")
	 private Long skillId;
	
	  @Column(name="Skill_Name")
	  private String skillName;
	  @Column(name="Points")
	  private Integer points;
	  
	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	

	public SkillsDTO(Long skillId, String skillName, Integer points) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.points = points;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "SkillsDTO [skillId=" + skillId + ", skillName=" + skillName + ", points=" + points + "]";
	}

	public SkillsDTO() {
		
		// TODO Auto-generated constructor stub
	}

	
	  
	  
	  
}
