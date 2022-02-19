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

	int auctionInput(Auction au);

	HashMap<String, Object> auctionCheck();
	
	void BIDScheduler();

	void BIDInfo(HashMap<String, Object>map);

	Auction outputAucionInfo(int auctionNo);

	int sellInput(SellForm sf);

	HashMap<String, Object> sellFormCheck();

	int sellUpdate(SellForm sf);

	HashMap<String, Integer> countOutput();

	void countInput();

	HashMap<String, Integer> joinOutput();

	HashMap<String, Integer> farmOutput();

	ArrayList<QuestionUser> questionUser();

	ArrayList<QuestionFarm> questionFarm();

	void farmQNASearchList(HashMap<String, Object> map);

	QuestionFarm questionFarmContent(int questionFarmNo);

	void userQNASearchList(HashMap<String, Object> map);

	Member selectMember(int userNo);

	int memberEndYNUpdate(HashMap<String, Object> map);

	void memberSearchList(HashMap<String, Object> map);

	void refundList(HashMap<String, Object> map);

	boolean refundUpdate(HashMap<String, Object> map);

	Farm farmInfo(int farmNo);

	void farmSearchList(HashMap<String, Object> map);

	int farmEndYNUpdate(HashMap<String, Object> map);

	ArrayList<Refund> refund();

	QuestionUser questionUserContent(int questionUserNo);

	QuestionAnswer questionUserAnswer(int questionUserNo);

	QuestionAnswer questionFarmAnswer(int questionFarmNo);

	int auctionUpdate(Auction au);

	HashMap<String, Object> sugWork();

	void adminBoard(HashMap<String, Object> map);

	boolean promotionEndYNUpdate(HashMap<String, Object> map);

	void test();
}
