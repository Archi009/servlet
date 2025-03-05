package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.ProductVO;

public interface ProductMapper {
	String selectMessage();
	String selectHint(String remainTimeString);
	public List<ProductVO>proList();
	public ProductVO proDetail(String prdCode);
	public List<ProductVO>decendingList(ProductVO pro);
}
