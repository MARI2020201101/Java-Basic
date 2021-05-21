package net.bbs2;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.action.CommandAction;
import net.utility.Utility;

public class BbsList implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int total_cnt=0;
		BoardDBBean dao = new BoardDBBean();
		total_cnt = dao.getArticleCount();
		
		int numPerPage = 3;
		int pagePerBlock = 10;
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) {
			pageNum="1";
		}
		int currentPage=Integer.parseInt(pageNum);
		int startRow = (currentPage-1)*numPerPage+1;
		int endRow = currentPage*numPerPage;
		
		double totcnt = (double)(total_cnt/numPerPage);
		int totalPage = (int) Math.ceil(totcnt);
		
		double d_page = (double)currentPage/pagePerBlock;
		int pages = (int) (Math.ceil(d_page)-1);
		int startPage = pages*pagePerBlock;
		int endPage = startPage+pagePerBlock+1;
		
		List<BoardDataBean> list = null;
		if(total_cnt>0) {
			list = dao.getArticles(startRow, endRow);
		}else {
			list = Collections.EMPTY_LIST;
		}
		int number=0;
		number = total_cnt-(currentPage-1)*numPerPage;
		request.setAttribute("number", number);
		request.setAttribute("pageNum", currentPage);
		request.setAttribute("startRow", startRow);
		request.setAttribute("endRow", endRow);
		request.setAttribute("count", total_cnt);
		request.setAttribute("pageSize", pagePerBlock);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("list", list);
		request.setAttribute("root", Utility.getRoot());
		return "bbsList.jsp";
	}

}
