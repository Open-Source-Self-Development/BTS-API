package opensourceselfdevelopment.btsApi.entities.concretes;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="expo")
@AllArgsConstructor
@NoArgsConstructor
public class Expo {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;

	@Column(name="expo_start_date")
	private Date expoStartDate;
	
	@Column(name="expo_end_date")
	private Date expoEndDate;
	
	@Column(name="city")
	private int city;
	
	@Column(name="district")
	private int district;
	
	@Column(name="tax")
	private Double tax;
	
	@Column(name="discount")
	private Double discount;
	
	
	@Column(name="address")
	private String address;
	
	@Column(name="status")
	private boolean status;
	
	@Column(name="created_at")
	private LocalDateTime createdAt;
	
	@Column(name="updated_at")
	private LocalDateTime updatedAt;
	
	@Column(name="deleted_at")
	private LocalDateTime deletedAt;
	
//	public Expo(int id, String name, Date expoStartDate, Date expoEndDate, int city, int district, Double tax,
//			Double discount, Map<String, Object> geoLocation, String address, boolean status, LocalDateTime createdAt,
//			LocalDateTime updatedAt, LocalDateTime deletedAt) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.expoStartDate = expoStartDate;
//		this.expoEndDate = expoEndDate;
//		this.city = city;
//		this.district = district;
//		this.tax = tax;
//		this.discount = discount;
//		this.address = address;
//		this.status = status;
//		this.createdAt = createdAt;
//		this.updatedAt = updatedAt;
//		this.deletedAt = deletedAt;
//	}
//	public Expo() {}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public Date getExpoStartDate() {
//		return expoStartDate;
//	}
//
//	public void setExpoStartDate(Date expoStartDate) {
//		this.expoStartDate = expoStartDate;
//	}
//
//	public Date getExpoEndDate() {
//		return expoEndDate;
//	}
//
//	public void setExpoEndDate(Date expoEndDate) {
//		this.expoEndDate = expoEndDate;
//	}
//
//	public int getCity() {
//		return city;
//	}
//
//	public void setCity(int city) {
//		this.city = city;
//	}
//
//	public int getDistrict() {
//		return district;
//	}
//
//	public void setDistrict(int district) {
//		this.district = district;
//	}
//
//	public Double getTax() {
//		return tax;
//	}
//
//	public void setTax(Double tax) {
//		this.tax = tax;
//	}
//
//	public Double getDiscount() {
//		return discount;
//	}
//
//	public void setDiscount(Double discount) {
//		this.discount = discount;
//	}
//
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public boolean isStatus() {
//		return status;
//	}
//
//	public void setStatus(boolean status) {
//		this.status = status;
//	}
//
//	public LocalDateTime getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(LocalDateTime createdAt) {
//		this.createdAt = createdAt;
//	}
//
//	public LocalDateTime getUpdatedAt() {
//		return updatedAt;
//	}
//
//	public void setUpdatedAt(LocalDateTime updatedAt) {
//		this.updatedAt = updatedAt;
//	}
//
//	public LocalDateTime getDeletedAt() {
//		return deletedAt;
//	}
//
//	public void setDeletedAt(LocalDateTime deletedAt) {
//		this.deletedAt = deletedAt;
//	}
	
	
}
