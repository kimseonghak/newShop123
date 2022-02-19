package com.hot.shop.admin.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hot.shop.admin.model.dao.AdminDAO;
import com.hot.shop.admin.model.vo.Auction;
import com.hot.shop.admin.model.vo.BID;
import com.hot.shop.admin.model.vo.Refund;
import com.hot.shop.admin.model.vo.SellForm;
import com.hot.shop.farm.model.vo.Farm;
import com.hot.shop.member.model.vo.Member;
import com.hot.shop.promotion.model.vo.Promotion;
import com.hot.shop.question.model.vo.QuestionAnswer;
import com.hot.shop.question.model.vo.QuestionFarm;
import com.hot.shop.question.model.vo.QuestionUser;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDAO aDAO;
	
// 대시보드 관련 기능
	@Override
	public HashMap<String, Integer> countOutput() {
		return aDAO.countOutput();
	}

	@Override
	public void countInput() {
		aDAO.countInput();
	}

	@Override
	public HashMap<String, Integer> joinOutput() {
		return aDAO.joinOutput();
	}

	@Override
	public HashMap<String, Integer> farmOutput() {
		return aDAO.farmOutpuf();
	}
	
	@Override
	public HashMap<String, Object> sugWork() {
		return aDAO.sugWork();
	}

	@Override
	public ArrayList<QuestionUser> questionUser() {
		return aDAO.questionUser();
	}

	@Override
	public ArrayList<QuestionFarm> questionFarm() {
		return aDAO.questionFarm();
	}
	
// 경매 관련 기능	
	@Override
	public int auctionInput(Auction au) {
		return aDAO.auctionInput(au);
	}

	@Override
	public HashMap<String, Object> auctionCheck() {
		return aDAO.auctionCheck();
	}
	
	@Override
	public Auction outputAucionInfo(int auctionNo) {
		return aDAO.outputAucionInfo(auctionNo);
	}
	
	@Override
	public int auctionUpdate(Auction au) {
		return aDAO.auctionUpdate(au);
	}
	
// 판매 관련 기능
	
	@Override
	public int sellInput(SellForm sf) {
		return aDAO.sellInput(sf);
	}

	@Override
	public HashMap<String, Object> sellFormCheck() {
		return aDAO.sellFormCheck();
	}

	@Override
	public int sellUpdate(SellForm sf) {
		return aDAO.sellUpdate(sf);
	}

// 스케쥴러 기능
	@Override
	public void BIDScheduler() {
		aDAO.BIDScheduler();
	}

	@Override
	public void BIDInfo(HashMap<String, Object>map) {
		aDAO.BIDList(map);
		aDAO.getPageNavi(map);
	}

// 멤버 관리 관련 기능
	@Override
	public int memberEndYNUpdate(HashMap<String, Object> map) {
		return aDAO.memberEndYNUpdate(map);
	}

	@Override
	public void memberSearchList(HashMap<String, Object> map) {
		aDAO.memberSearchList(map);
		aDAO.getMemberSearchPageNavi(map);
	}
	
	@Override
	public Member selectMember(int userNo) {
		return aDAO.selectMember(userNo);
	}

// 농가 관련 기능
	@Override
	public void farmSearchList(HashMap<String, Object> map) {
		aDAO.farmSearchList(map);
		aDAO.getFarmSearchPageNavi(map);
	}
	
	@Override
	public int farmEndYNUpdate(HashMap<String, Object> map) {
		return aDAO.farmEndYNUpdate(map);
	}
	
	@Override
	public Farm farmInfo(int farmNo) {
		return aDAO.farmInfo(farmNo);
	}
	
// 환불 관련 기능
	@Override
	public void refundList(HashMap<String, Object> map) {
		aDAO.refundList(map);
		aDAO.getRefundPageNavi(map);
	}

	@Override
	public boolean refundUpdate(HashMap<String, Object> map) {
		return aDAO.refundUpdate(map);
	}

	@Override
	public ArrayList<Refund> refund() {
		return aDAO.refund();
	}

// 농가 문의 관련 기능
	@Override
	public void farmQNASearchList(HashMap<String, Object> map) {
		aDAO.questionFarmSearchList(map);
		aDAO.getFarmQNASearchPageNavi(map);
	}

	@Override
	public QuestionFarm questionFarmContent(int questionFarmNo) {
		return aDAO.questionFarmContent(questionFarmNo);
	}

// 유저 문의 관련 기능
	@Override
	public void userQNASearchList(HashMap<String, Object> map) {
		aDAO.questionUserSearchList(map);
		aDAO.getUserQNASearchPageNavi(map);
	}
	
	@Override
	public QuestionUser questionUserContent(int questionUserNo) {
		return aDAO.questionUserContent(questionUserNo);
	}
	
// 문의 답변 관련 기능
	@Override
	public QuestionAnswer questionUserAnswer(int questionUserNo) {
		return aDAO.questionUserAnswer(questionUserNo);
	}

	@Override
	public QuestionAnswer questionFarmAnswer(int questionFarmNo) {
		return aDAO.questionFarmAnswer(questionFarmNo);
	}
	
// 게시판 관련 기능
	@Override
	public void adminBoard(HashMap<String, Object> map) {
		aDAO.promotionList(map);
		aDAO.getPromotionPageNavi(map);
	}

	@Override
	public boolean promotionEndYNUpdate(HashMap<String, Object> map) {
		return aDAO.promotionEndYNUpdate(map);
	}

	@Override
	public void test() {
		aDAO.test();
	}

}
