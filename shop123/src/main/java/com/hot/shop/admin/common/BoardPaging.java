package com.hot.shop.admin.common;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component(value = "page")
public class BoardPaging {

	public void paging(HashMap<String, Object> map) {
		int currentPage = (int)map.get("currentPage");
		int recordCountPerPage = (int)map.get("recordCountPerPage");
		int start = currentPage*recordCountPerPage-(recordCountPerPage-1);
		int end = currentPage*recordCountPerPage;
		
		map.put("start", start);
		map.put("end", end);
	}
	
	public void navi(HashMap<String, Object> map) {
		int currentPage = (int)map.get("currentPage");
		int recordCountPerPage = (int)map.get("recordCountPerPage");
		int recordTotalCount = (int)map.get("recordTotalCount");
		int naviCountPerPage = (int)map.get("naviCountPerPage");
		
		if(map.get("formNo")!=null) {
		int formNo = (int)map.get("formNo");
		
		int pageTotalCount = (int)Math.ceil(recordTotalCount/(double)recordCountPerPage);
		
		int startNavi = ((currentPage-1)/naviCountPerPage) *naviCountPerPage+1;
		int endNavi = startNavi+naviCountPerPage-1;
		
		if(endNavi>pageTotalCount) {
			endNavi=pageTotalCount;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<a href='/admin/adminAuctionInfoPage.do?currentPage=1&formNo="+formNo+"' class='naviArrow'>&lt;&lt;</a>");
		sb.append("<a href='/admin/adminAuctionInfoPage.do?currentPage="+(currentPage-10)+"&formNo="+formNo+"' class='naviArrow' id='prev'>&lt;</a>");
		for(int i= startNavi; i<=endNavi; i++) {
			if(i==currentPage) {
				sb.append("<a href='/admin/adminAuctionInfoPage.do?currentPage="+i+"&formNo="+formNo+"' id='currentNavi'>"+i+"</a>");
			}else {
				sb.append("<a href='/admin/adminAuctionInfoPage.do?currentPage="+i+"&formNo="+formNo+"' class='otherNavi'>"+i+"</a>");
			}
		}
		if((currentPage+10)<pageTotalCount) {
			sb.append("<a href='/admin/adminAuctionInfoPage.do?currentPage="+pageTotalCount+"&formNo="+formNo+"' class='naviArrow' id='next'>&gt;</a>");
		}else {
			sb.append("<a href='/admin/adminAuctionInfoPage.do?currentPage="+(currentPage+10)+"&formNo="+formNo+"' class='naviArrow' id='next'>&gt;</a>");
		}
		
		sb.append("<a href='/admin/adminAuctionInfoPage.do?currentPage="+pageTotalCount+"&formNo="+formNo+"' class='naviArrow'>&gt;&gt;</a>");
		
		map.put("pageNavi", sb.toString());
		}
	}
}
