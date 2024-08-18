package opensourceselfdevelopment.btsApi.entities.concretes;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name="expo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Expo {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	@NotNull
	@NotBlank
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
	@NotNull
	@NotBlank
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
	
	@OneToMany(mappedBy ="expo")
	private List<ExpoStock> expoStocks;

	
	
}
