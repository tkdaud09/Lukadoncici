package xyz.itwill10.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class Product {
	//@NotEmpty(message = "��ǰ�ڵ带 �Է��� �ּ���.")
	@NotEmpty
	private String productCode;
	@NotEmpty
	private String productName;
	@Min(value = 1)
	@Max(value = 100)
	private int productQuantity;
}