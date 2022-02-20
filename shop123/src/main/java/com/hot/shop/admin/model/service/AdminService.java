package com.hot.shop.admin.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.hot.shop.admin.model.vo.Auction;
import com.hot.shop.admin.model.vo.Refund;
import com.hot.shop.admin.model.vo.SellForm;
import com.hot.shop.farm.model.vo.Farm;
import com.hot.shop.member.model.vo.Member;
import com.hot.shop.question.model.vo.QuestionAnswer;
import com.hot.shop.question.model.vo.QuestionFarm;
import com.hot.shop.question.model.vo.QuestionUser;

public interface AdminService {
	
	
	/**
	 * 대분류 : 메인 대시 보드 기능
	 * 사용 컨트롤러 : adminDashboardPage (메인 페이지 불러오기)
	 */
	HashMap<String, Integer> countOutput();

	void countInput();

	HashMap<String, Integer> joinOutput();

	HashMap<String, Integer> farmOutput();

	ArrayList<QuestionUser> questionUser();

	ArrayList<QuestionFarm> questionFarm();
	
	HashMap<String, Object> sugWork();
	
	ArrayList<Refund> refund();
	
	
	/**
	 * 대분류 : 옥션 기능 모음(경매)
	 * 사용 컨트롤러 : adminAuctionPage (경매 페이지 불러오기)
	 */
	HashMap<String, Object> auctionCheck();
	
	HashMap<String, Object> sellFormCheck();
	/**
	 * 대분류 : 옥션 기능 모음(경매)
	 * 사용 컨트롤러 : auctionInput (경매 입력 및 종료)
	 */
	int auctionUpdate(Auction au);
	
	int auctionInput(Auction au);
	/**
	 * 대분류 : 옥션 기능 모음(판매)
	 * 사용 컨트롤러 : adminAuctionInfoPage (낙찰 정보 가져오기 팝업창)
	 */
	void BIDInfo(HashMap<String, Object>map);
	/**
	 * 대분류 : 옥션 기능 모음(판매)
	 * 사용 컨트롤러 : outputAucionInfo (낙찰 정보 토대로 경매 정보 가져오기)
	 */
	Auction outputAucionInfo(int auctionNo);
	/**
	 * 대분류 : 옥션 기능 모음(판매)
	 * 사용 컨트롤러 : sellInput (판매 정보 입력 및 시작)
	 */
	int sellInput(SellForm sf);
	/**
	 * 대분류 : 옥션 기능 모음(판매)
	 * 사용 컨트롤러 : sellUpdate (판매 정보 변경)
	 */
	int sellUpdate(SellForm sf);

	/**
	 * 대분류 : 농가 문의 기능 모음
	 * 사용 컨트롤러 : farmQNAPage (농가 문의 목록 불러오기)
	 */
	void farmQNASearchList(HashMap<String, Object> map);
	/**
	 * 대분류 : 농가 문의 기능 모음
	 * 사용 컨트롤러 : farmQNAContent (농가 문의 내용 불러오기)
	 */
	QuestionFarm questionFarmContent(int questionFarmNo);
	/**
	 * 대분류 : 농가 문의 기능 모음
	 * 사용 컨트롤러 : farmQNAContent (농가 문의 답변 불러오기)
	 */
	QuestionAnswer questionFarmAnswer(int questionFarmNo);

	/**
	 * 대분류 : 유저 문의 기능 모음
	 * 사용 컨트롤러 : userQNAPage (유저 문의 목록 불러오기)
	 */
	void userQNASearchList(HashMap<String, Object> map);
	/**
	 * 대분류 : 유저 문의 기능 모음
	 * 사용 컨트롤러 : userQNAContent (유저 문의 내용 불러오기)
	 */
	QuestionUser questionUserContent(int questionUserNo);
	/**
	 * 대분류 : 유저 문의 기능 모음
	 * 사용 컨트롤러 : userQNAContent (유저 문의 답변 불러오기)
	 */
	QuestionAnswer questionUserAnswer(int questionUserNo);
	
	/**
	 * 대분류 : 환불 기능 모음
	 * 사용 컨트롤러 : adminRefundPage (환불 목록 불러오기)
	 */
	void refundList(HashMap<String, Object> map);
	/**
	 * 대분류 : 환불 기능 모음 
	 * 사용 컨트롤러 : adminRefundUpdate (환불 승인/거절 업데이트)
	 */
	boolean refundUpdate(HashMap<String, Object> map);

	/**
	 * 대분류 : 농가 기능 모음
	 * 사용 컨트롤러 : farmPage (농가 목록 불러오기)
	 */
	void farmSearchList(HashMap<String, Object> map);
	/**
	 * 대분류 : 농가 기능 모음
	 * 사용 컨트롤러 : farmEndYNUpdate (농가 탈퇴/복구 업데이트)
	 */
	int farmEndYNUpdate(HashMap<String, Object> map);
	
	/**
	 * 대분류 : 농가 기능 모음
	 * 사용 컨트롤러 : farmInfoPage (농가 정보 팝업창)
	 */
	Farm farmInfo(int farmNo);

	/**
	 * 대분류 : 유저 기능 모음
	 * 사용 컨트롤러 : memberPage (유저 목록 불러오기)
	 */
	void memberSearchList(HashMap<String, Object> map);
	/**
	 * 대분류 : 유저 기능 모음
	 * 사용 컨트롤러 : memberEndYNUpdate (유저 탈퇴/복구 업데이트)
	 */
	int memberEndYNUpdate(HashMap<String, Object> map);
	/**
	 * 대분류 : 유저 기능 모음
	 * 사용 컨트롤러 : memberInfoPage (유저 정보 팝업창)
	 */
	Member selectMember(int userNo);

	/**
	 * 대분류 : 게시판 기능 모음
	 * 사용 컨트롤러 : adminBoardPage (홍보게시판 목록 불러오기)
	 */
	void adminBoard(HashMap<String, Object> map);
	/**
	 * 대분류 : 게시판 기능 모음
	 * 사용 컨트롤러 : promotionEndYNUpdate (게시판 삭제/복구 업데이트)
	 */
	boolean promotionEndYNUpdate(HashMap<String, Object> map);
	
	/**
	 * 대분류 : 예약 작업 모음
	 * 사용 컨트롤러 : BIDScheduler (각종 예약 작업 실행)
	 */
	void BIDScheduler();
	
	void test();
}
