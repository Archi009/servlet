package co.yedam.vo;

import lombok.Data;

@Data
public class ProductVO {
	private String prdCode;
	private String prdName;
	private String prdDesc;
	private int originPrice;
	private int salePrice;
	private int starPoint;
	private String prodImage;
}
