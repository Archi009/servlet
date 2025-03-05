package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Control;
import co.yedam.common.DataSource;
import co.yedam.mapper.ProductMapper;
import co.yedam.vo.ProductVO;

public class ProductControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = req.getParameter("prdCode");
		
		SqlSession session = DataSource.getInstance().openSession();
		ProductMapper mapper = session.getMapper(ProductMapper.class);
		
		ProductVO pro = mapper.proDetail(code);
		
		req.setAttribute("prd", pro);
		req.getRequestDispatcher("product/productInfo.tiles").forward(req, resp);
		

}
}