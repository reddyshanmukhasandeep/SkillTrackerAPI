package com.cts.fsd.SkillTrackerAPI.associate;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Associate")
public class AssociateDTO {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="Asc_ID")
	private Long ascID; 
	@Column(name="Associate_ID")
	 private String  associateID;
	@Column(name="Name")
	  private String name;
	
	@Column(name="Email")
	  private String email;
	@Column(name="Mobile")
	  private String mobile;
	@Column(name="Pic")
	  private byte[] pic;
	
	@Column(name="Status_Green")
	  private boolean statusGreen;
	@Column(name="Status_Blue")
	  private boolean statusBlue;
	@Column(name="Status_Red")
	  private boolean statusRed;
	
	@Column(name="Level_1")
	  private boolean level1;
	@Column(name="Level_2")
	  private boolean level2;
	@Column(name="Level_3")
	  private boolean level3;
	@Column(name="Remark")
	  private String remark;
	
	@Column(name="Strength")
	  private String strength;
	
	@Column(name="Weakness")
	  private String weakness;

	public Long getAsc_ID() {
		return ascID;
	}

	public void setAsc_ID(Long asc_ID) {
		ascID = asc_ID;
	}

	public String getAssociateID() {
		return associateID;
	}

	public void setAssociateID(String associateID) {
		this.associateID = associateID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public boolean isStatusGreen() {
		return statusGreen;
	}

	public void setStatusGreen(boolean statusGreen) {
		this.statusGreen = statusGreen;
	}

	public boolean isStatusBlue() {
		return statusBlue;
	}

	public void setStatusBlue(boolean statusBlue) {
		this.statusBlue = statusBlue;
	}

	public boolean isStatusRed() {
		return statusRed;
	}

	public void setStatusRed(boolean statusRed) {
		this.statusRed = statusRed;
	}

	public boolean isLevel1() {
		return level1;
	}

	public void setLevel1(boolean level1) {
		this.level1 = level1;
	}

	public boolean isLevel2() {
		return level2;
	}

	public void setLevel2(boolean level2) {
		this.level2 = level2;
	}

	public boolean isLevel3() {
		return level3;
	}

	public void setLevel3(boolean level3) {
		this.level3 = level3;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	public String getWeakness() {
		return weakness;
	}

	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}

	public AssociateDTO(Long asc_ID, String associateID, String name, String email, String mobile, byte[] pic,
			boolean statusGreen, boolean statusBlue, boolean statusRed, boolean level1, boolean level2, boolean level3,
			String remark, String strength, String weakness) {
		super();
		ascID = asc_ID;
		this.associateID = associateID;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.pic = pic;
		this.statusGreen = statusGreen;
		this.statusBlue = statusBlue;
		this.statusRed = statusRed;
		this.level1 = level1;
		this.level2 = level2;
		this.level3 = level3;
		this.remark = remark;
		this.strength = strength;
		this.weakness = weakness;
	}

	public AssociateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AssociateDTO [Asc_ID=" + ascID + ", associateID=" + associateID + ", name=" + name + ", email=" + email
				+ ", mobile=" + mobile + ", pic=" + Arrays.toString(pic) + ", statusGreen=" + statusGreen
				+ ", statusBlue=" + statusBlue + ", statusRed=" + statusRed + ", level1=" + level1 + ", level2="
				+ level2 + ", level3=" + level3 + ", remark=" + remark + ", strength=" + strength + ", weakness="
				+ weakness + "]";
	}


	
	
	
}
