package com.hot.shop.admin.model.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hot.shop.admin.common.BoardPaging;
import com.hot.shop.admin.model.vo.Auction;
import com.hot.shop.admin.model.vo.BID;
import com.hot.shop.admin.model.vo.Count;
import com.hot.shop.admin.model.vo.Refund;
import com.hot.shop.admin.model.vo.SellForm;
import com.hot.shop.farm.model.vo.Farm;
import com.hot.shop.member.model.vo.Member;
import com.hot.shop.promotion.model.vo.Promotion;
import com.hot.shop.question.model.vo.QuestionAnswer;
import com.hot.shop.question.model.vo.QuestionFarm;
import com.hot.shop.question.model.vo.QuestionPhoto;
import com.hot.shop.question.model.vo.QuestionUser;

@Repository
public class AdminDAO {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private BoardPaging page;
	
//경매 기능 모음
	//경매 정보 설정
	public int auctionInput(Auction au) {
		// 경매 폼 데이터 토대로 경매 정보 저장
		return sql.insert("admin.auctionInput", au);
	}
	//관리자 페이지 경매 정보 불러오기
	public HashMap<String, Object> auctionCheck() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 옥션페이지 접속시 경매 진행중인 정보를 가져옴
		for(int i=1; i<4; i++) {
			Auction au = new Auction();
			au = sql.selectOne("admin.auctionCheck",i);
			map.put("au"+i, au);
		}
		return map;
	}
	// 경매 종료 업데이트
	public int auctionUpdate(Auction au) {
		return sql.update("admin.auctionUpdate",au);
	}
	
//스케쥴러 기능 모음
	public void BIDScheduler() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 경매가 종료된 날을 기준으로 제일 마지막(낙찰된) 경매 정보를 가져와서 맵에 저장
		for(int i=1; i<=3; i++) {
			Auction au = new Auction();
			au = sql.selectOne("admin.BIDScheduler",i);
			map.put("bid"+i, au);
		}
		System.out.println("낙찰 정보 저장 완료");
		
		for(int i=1; i<=3; i++) {
			if(map.get("bid"+i)!=null) {
				// 날짜가 지난 모든 경매를 endYN = 'Y'로 변경
				sql.update("admin.auctionEndYN",(Auction)map.get("bid"+i));
				// 낙찰된 경매 번호를 낙찰DB에 저장
				sql.insert("admin.BIDinsert",(Auction)map.get("bid"+i));
			}
		}
		System.out.println("경매 날짜 지난 경매 종료");
		
		sql.update("admin.sellFormEndYN");
		System.out.println("판매 날짜 지난 판매 종료");
		
		List<QuestionPhoto> list = sql.selectList("admin.fileCheck");
		for(QuestionPhoto qPhoto : list ) {
			String path = context.getRealPath("/resources/questionphoto/img/");
			String filePath = path+qPhoto.getQuestionPhotoFilePath().substring(29);
			
			File file = new File(filePath);
			file.delete();
		}
		sql.update("admin.fileDelYNUpdate",list);
		System.out.println("찌꺼기 파일 제거");
		System.out.println("예약 작업 종료");
	}

//판매 폼 관련 모음
	// BID 목록과 정보 가져오는 로직
	public void BIDList(HashMap<String,Object> map) {
		ArrayList<BID>list = new ArrayList<BID>(sql.selectList("admin.BIDList",map));
		map.put("list", list);
	}
	// BID 목록 페이징 처리
	public void getPageNavi(HashMap<String, Object>map) {
		int recordTotalCount = sql.selectOne("admin.BIDTotalCount");
		map.put("recordTotalCount", recordTotalCount);
	}
	// 경매 정보 1개 가져오는 로직 (판매 폼에 정보 입력하게 위한 용도)
	public Auction outputAucionInfo(int auctionNo) {
		return sql.selectOne("admin.selectOneAuction",auctionNo);
	}
	// 판매 시작할 경우 낙찰DB에 판매유무 Y로 변경 + 판매 정보 입력하는 로직
	public int sellInput(SellForm sf) {
		return sql.insert("admin.sellInput",sf)+sql.update("admin.BIDEndYNUpdate",sf.getAuctionNo());
	}
	// 판매 중인 경우 판매중인 정보 가져오는 로직
	public HashMap<String, Object> sellFormCheck() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		for(int i=1; i<4; i++) {
			SellForm sf = new SellForm();
			Auction au = new Auction();
			sf = sql.selectOne("admin.sellFormCheck",i);
			if(sf!=null) {
				au = sql.selectOne("admin.selectOneAuction",sf.getAuctionNo());
				map.put("au"+i, au);
			}
			map.put("sf"+i, sf);
		}
		return map;
	}
	// 판매중인 상품의 판매기간/홍보주소/종료여부 변경하는 로직
	public int sellUpdate(SellForm sf) {
		return sql.update("admin.sellUpdate",sf);
	}
	
// 농가 문의 모음
	// 농가 문의 목록 가져오기
	public void questionFarmSearchList(HashMap<String, Object> map) {
		ArrayList<QuestionFarm> list = new ArrayList<QuestionFarm>(sql.selectList("admin.questionFarmSearchList",map));
		map.put("list", list);
	}
	// 농가 문의 목록 페이징 처리
	public void getFarmQNASearchPageNavi(HashMap<String, Object> map) {
		int recordTotalCount = sql.selectOne("admin.farmQNASearchTotalCount",map); 
		map.put("recordTotalCount", recordTotalCount);
	}
	// 농가 문의 내용 가져오기
	public QuestionFarm questionFarmContent(int questionFarmNo) {
		return sql.selectOne("admin.questionFarmContent",questionFarmNo);
	}
	// 농가 문의 답변 내용 가져오기
	public QuestionAnswer questionFarmAnswer(int questionFarmNo) {
		return sql.selectOne("admin.questionFarmAnswer",questionFarmNo);
	}

	
//유저 문의 기능 모음
	// 유저 문의 목록 가져오기
	public void questionUserSearchList(HashMap<String, Object> map) {
		ArrayList<QuestionUser> list = new ArrayList<QuestionUser>(sql.selectList("admin.questionUserSearchList",map));
		map.put("list", list);
	}
	
	// 유저 문의 페이징 처리
	public void getUserQNASearchPageNavi(HashMap<String, Object> map) {
		int recordTotalCount = sql.selectOne("admin.userQNASearchTotalCount",map); 
		map.put("recordTotalCount", recordTotalCount);
	}
	// 유저 문의 내용 가져오기
	public QuestionUser questionUserContent(int questionUserNo) {
		return sql.selectOne("admin.questionUserContent",questionUserNo);
	}
	// 유저 문의 답변 내용 가져오기
	public QuestionAnswer questionUserAnswer(int questionUserNo) {
		return sql.selectOne("admin.questionUserAnswer",questionUserNo);
	}

// 유저 관련 기능 모음
	// 유저 정보 가져오기
	public Member selectMember(int userNo) {
		return sql.selectOne("admin.selectMember",userNo);
	}
	// 유저 탈퇴 / 복구 시키기
	public int memberEndYNUpdate(HashMap<String, Object> map) {
		return sql.update("admin.memberEndYNUpdate",map);
	}
	// 유저 목록 가져오기
	public void memberSearchList(HashMap<String, Object> map) {
		ArrayList<Member> list = new ArrayList<Member>(sql.selectList("admin.memberSearchList",map));
		map.put("list", list);
	}
	// 유저 목록 페이징 처리
	public void getMemberSearchPageNavi(HashMap<String, Object> map) {
		int recordTotalCount = sql.selectOne("admin.memberSearchTotalCount",map); 
		map.put("recordTotalCount", recordTotalCount);
	}

// 농가 관련 기능 모음
	// 농가 정보 가져오기
	public Farm farmInfo(int farmNo) {
		return sql.selectOne("admin.farmInfo",farmNo);
	}
	// 농가 목록 가져오기
	public void farmSearchList(HashMap<String, Object> map) {
		ArrayList<Farm> list = new ArrayList<Farm>(sql.selectList("admin.farmSearchList",map));
		map.put("list", list);
	}
	// 농가 목록 페이징 처리
	public void getFarmSearchPageNavi(HashMap<String, Object> map) {
		int recordTotalCount = sql.selectOne("admin.farmSearchTotalCount",map); 
		map.put("recordTotalCount", recordTotalCount);
		
	}
	// 농가 탈퇴 / 복구 처리
	public int farmEndYNUpdate(HashMap<String, Object> map) {
		return sql.update("admin.farmEndYNUpdate",map);
	}
	
//환불 관련 기능 모음
	// 환불 목록 가져오기
	public void refundList(HashMap<String, Object> map) {
		ArrayList<Refund> list = new ArrayList<Refund>(sql.selectList("admin.refundList",map));
		map.put("list", list);
	}
	// 환불 목록 페이징 처리
	public void getRefundPageNavi(HashMap<String, Object> map) {
		int recordTotalCount = sql.selectOne("admin.refundTotalCount",map); 
		map.put("recordTotalCount", recordTotalCount);
	}
	// 환불 승인 및 거절 업데이트
	public boolean refundUpdate(HashMap<String, Object> map) {
		return sql.update("admin.refundUpdate",map)>0;
	}

//홍보 게시판 기능 모음
	//홍보 게시판 목록 가져오기
	public void promotionList(HashMap<String, Object> map) {
		ArrayList<Promotion> list = new ArrayList<Promotion>(sql.selectList("admin.promotionList",map));
		map.put("list", list);
	}
	//홍보 게시판 페이징 처리
	public void getPromotionPageNavi(HashMap<String, Object> map) {
		int recordTotalCount = sql.selectOne("admin.promotionTotalCount",map); 
		map.put("recordTotalCount", recordTotalCount);
	}
	// 홍보 게시판 삭제 / 복구 기능
	public boolean promotionEndYNUpdate(HashMap<String, Object> map) {
		return sql.update("admin.promotionYNUpdate",map)>0;
	}

// 메인화면 대시보드 기능 관련 모음
	// 카운트 가져오기
	public HashMap<String, Integer> countOutput() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Count yester = sql.selectOne("admin.countOutput", 1);
		Count today = sql.selectOne("admin.countOutput", 0);
		if(yester!=null) {
			map.put("yester", yester.getCountSum());
		}else {
			map.put("yester", 0);
		}
		if(today!=null) {
			map.put("today", today.getCountSum());
		}else {
			map.put("today", 0);
		}
		
		return map;
	}
	// 카운트 넣기 및 업데이트
	public void countInput() {
		if(sql.selectOne("admin.countCheck")==null) {
			sql.insert("admin.countInsert");
		}else {
			sql.update("admin.countUpdate");
		}
	}
	// 가입수 가져오기
	public HashMap<String, Integer> joinOutput() {
		HashMap<String, Integer> joinMap = new HashMap<String, Integer>();
		joinMap.put("yester",sql.selectOne("admin.joinOutput",1));
		joinMap.put("today", sql.selectOne("admin.joinOutput",0));
		return joinMap;
	}
	// 농가 가입수 가져오기
	public HashMap<String, Integer> farmOutpuf() {
		HashMap<String, Integer> farmMap = new HashMap<String, Integer>();
		farmMap.put("yester",sql.selectOne("admin.farmOutput",1));
		farmMap.put("today", sql.selectOne("admin.farmOutput",0));
		return farmMap;
	}
	// 유저문의 최신 5개 가져오기
	public ArrayList<QuestionUser> questionUser() {
		return new ArrayList<QuestionUser>(sql.selectList("admin.questionUserListMain"));
	}
	// 농가문의 최신 5개 가져오기
	public ArrayList<QuestionFarm> questionFarm() {
		return new ArrayList<QuestionFarm>(sql.selectList("admin.questionFarmListMain"));
	}
	// 환불문의 최신 5개 가져오기
	public ArrayList<Refund> refund() {
		return new ArrayList<Refund>(sql.selectList("admin.refund"));
	}
	// 추천 작업 목록 가져오기
	public HashMap<String, Object> sugWork() {
		HashMap<String, Object> sugMap = sql.selectOne("admin.sugWork");
		return sugMap;
	}
	public void test() {
		
	}
	
}
