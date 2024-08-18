package opensourceselfdevelopment.btsApi.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateExpoRequest {
	private int id;
	private String name;

}
