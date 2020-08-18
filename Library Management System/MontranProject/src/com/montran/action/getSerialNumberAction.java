package com.montran.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import com.montran.dao.LibraryDAO;
import com.montran.pojo.Issue;

public class getSerialNumberAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LibraryDAO dao = new LibraryDAO();
		List<Issue> issuebookslist = dao.getIssuedBooks();
		int serialno =issuebookslist.get(issuebookslist.size()-1).getIssueSerialNumber();
		request.setAttribute("serialnum", serialno);
		request.setAttribute("issuebooklist", issuebookslist);
		return mapping.findForward("success");
	}
}
