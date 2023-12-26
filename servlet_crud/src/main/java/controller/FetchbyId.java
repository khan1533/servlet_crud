package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet_crud.dao.SampleDao;

@WebServlet("/fetch")
public class FetchbyId extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	super.doGet(req, resp);
	String id=req.getParameter("id");
	int cid=Integer.parseInt(id);
		SampleDao dao=new SampleDao();
		Object o=dao.fetchbyid(cid);
		resp.getWriter().print(o);
		
	}
	
	
}
