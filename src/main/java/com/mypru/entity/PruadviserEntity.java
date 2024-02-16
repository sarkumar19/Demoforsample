package com.mypru.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pruadviserentity",catalog="pruadviser1")
public class PruadviserEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String pruadviserName;
	private String pruadviserAddress;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPruadviserName() {
		return pruadviserName;
	}
	public void setPruadviserName(String pruadviserName) {
		this.pruadviserName = pruadviserName;
	}
	public String getPruadviserAddress() {
		return pruadviserAddress;
	}
	public void setPruadviserAddress(String pruadviserAddress) {
		this.pruadviserAddress = pruadviserAddress;
	}
	public PruadviserEntity(Long id, String pruadviserName, String pruadviserAddress) {
		this.id = id;
		this.pruadviserName = pruadviserName;
		this.pruadviserAddress = pruadviserAddress;
	}
	public PruadviserEntity() {
		
	}
	@Override
	public String toString() {
		return "PruadviserEntity [id=" + id + ", pruadviserName=" + pruadviserName + ", pruadviserAddress="
				+ pruadviserAddress + "]";
	}
	
	
	

}
