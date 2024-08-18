package opensourceselfdevelopment.btsApi.business.requests;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateExpoRequest {
	@NotNull
	@NotBlank
	@Size(min=3,max=20)
	private String name;
	private Date expoStartDate;
	private Date expoEndDate;
	private int city;
	private int district;

}
