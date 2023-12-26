package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.SampleDto;
import servlet_crud.dao.SampleDao;

@WebServlet("/crud")
public class SampleCntrlr extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);

		String id = req.getParameter("id");
		int cid = Integer.parseInt(id);
		String name = req.getParameter("name");
		System.out.println(id);
		System.out.println(name);
		SampleDto dto = new SampleDto();
		dto.setId(cid);
		dto.setName(name);

		SampleDao dao = new SampleDao();
		String msg = dao.insert(dto);
		resp.getWriter().print(msg);

	}

}
