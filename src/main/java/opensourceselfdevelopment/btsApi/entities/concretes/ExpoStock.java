package opensourceselfdevelopment.btsApi.entities.concretes;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="expo_stock")
public class ExpoStock {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
//	@Column(name="expo_id")
//	private int expoId;
	
	@Column(name="expo_stock_id")
	private int expoStockId;
	
	@Column(name="product_id")
	private int productId;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="created_at")
	private LocalDateTime createdAt;
	
	@Column(name="updated_at")
	private LocalDateTime updatedAt;
	
	@Column(name="deleted_at")
	private LocalDateTime deletedAt;
	
	@ManyToOne()
	@JoinColumn(name="expo_id")
	private Expo expo;
}
