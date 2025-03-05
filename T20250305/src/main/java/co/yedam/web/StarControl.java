package co.yedam.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.chrono.IsoChronology;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.common.DataSource;
import co.yedam.mapper.ProductMapper;
import co.yedam.vo.ProductVO;

public class StarControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/json;charset=utf-8");
		BufferedReader reader = req.getReader();
		Gson gson = new GsonBuilder().create();
		ProductVO eve = gson.fromJson(reader, ProductVO.class);

		System.out.println(eve.getPrdCode());
		SqlSession session = DataSource.getInstance().openSession();
		ProductMapper mapper = session.getMapper(ProductMapper.class);
		List<ProductVO> pro = mapper.decendingList(eve);
		
		String json = gson.toJson(pro);

		resp.getWriter().print(json);

	}

}
