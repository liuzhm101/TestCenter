package com.finance.stock.gui;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

import com.finance.stock.data.*;


public class ModelCenter {

	String stockAllDataFull="C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode\\StockAllDataFull";
	String fundAllDataFull="C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode\\FundAllDataFull";
	String stockFileFolder=stockAllDataFull+"\\all";  // ԭģ�ͼ���������Ŀ¼
	String stockSecondFileFolder=stockAllDataFull+"\\each";
	
	String dateType="";  // stock �����о�����
	
	Map stockIndexMap;
	
	String lastSaleDate="";
	
	Map marketDataRecordMap;
	
	public static void main(String args[])
	{
		
		ModelCenter mc=new ModelCenter();
		
		try
		{
			
			long starttime=System.currentTimeMillis();
			
			mc.analyzeDataByModel();
			
//			mc.searchDataByModel();
			
			long endtime=System.currentTimeMillis();
			int time=(int)(endtime-starttime)/1000;
			System.out.println("Total time: "+time+"��");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public void analyzeDataByModel()
	{
		
		// ��ȡȫ��ָ������
//		stockIndexMap=CommonTool.getAllStockIndexDataMap();  // �ṹ (type, indexDataList)
		
		// ��ȡ��ʷ�����г�����
//		marketDataRecordMap=CommonTool.loadMarketDataRecordMap("all");
		
		// ��ȡȫ����Ʊ����
		System.out.println("Read all stock code list.");
		String stockCodeListFile="stockcodelist";
		ResultSet rs=CommonTool.readDataFromSASDataSet(stockAllDataFull, stockCodeListFile);
		List stockCodeList=CommonTool.getColumnDataList(rs, "stockcode");
		
		// �Թ�Ʊ���밴�������ѡȡ
		List researchStockCodeList=new ArrayList();
		
		// ȫ��ѡ��
		researchStockCodeList=stockCodeList; 	// ѡȫ����Ʊ��Ϊ�о�����
		
		// �����ѡ��
//		researchStockCodeList=CommonTool.getAllStock_600(stockCodeList);  // ��600���ѡ��
//		researchStockCodeList=CommonTool.getAllStock_300(stockCodeList);  // ��300���ѡ��
//		researchStockCodeList=CommonTool.getAllStock_000(stockCodeList);  // ��000���ѡ��
//		researchStockCodeList=CommonTool.getAllStock_002(stockCodeList);  // ��002���ѡ��
		
		// ���ѡ��
//		researchStockCodeList=CommonTool.getAllStock_Random(stockCodeList, 100);    // ȫ����Ʊ���ѡ��n��
//		researchStockCodeList=CommonTool.getAllStock_Random(researchStockCodeList, 500);  // ĳ��������ѡ��n��
//		researchStockCodeList=CommonTool.getAllStock_ByOrderNo(researchStockCodeList, 0, 10);
//		researchStockCodeList=CommonTool.getAllStock_ByMarketValue(researchStockCodeList, 50, "top");
		
		// ָ��ѡ��
//		researchStockCodeList.add("sh600516");  // ����̼��
//		researchStockCodeList.add("sh600698");  // ��������
//		researchStockCodeList.add("sz300676");  // �������
//		researchStockCodeList.add("sh600519");  // ����ę́
//		researchStockCodeList.add("sz000651");  // ��������
//		researchStockCodeList.add("sh601318");  // �й�ƽ��
//		researchStockCodeList.add("sz002230");  // �ƴ�Ѷ��
//		researchStockCodeList.add("sh601313");  // ���ϼν�
//		researchStockCodeList.add("sh600530");  // ������
//		researchStockCodeList.add("sz000858");  // ����Һ
//		researchStockCodeList.add("sh600903");  // ����ȼ��
//		researchStockCodeList.add("sz000877");  // ��ɽ�ɷ�
//		researchStockCodeList.add("sh601111");  // �й�����
//		researchStockCodeList.add("sh600036");  // ��������
//		researchStockCodeList.add("sh601398");  // ��������
//		researchStockCodeList.add("sh600104");  // ��������
//		researchStockCodeList.add("sh600547");  // ɽ���ƽ�
//		researchStockCodeList.add("sh600887");  // �����ɷ�
//		researchStockCodeList.add("sz002751");  // ����չʾ
//		researchStockCodeList.add("sh600097");  // ��������
//		researchStockCodeList.add("sz002330");  // ����˹
//		researchStockCodeList.add("sh600848");  // �Ϻ��ٸ�
//		researchStockCodeList.add("sh601857");  // �й�ʯ��
//		researchStockCodeList.add("sz000700");  // ģ�ܿƼ�
//		researchStockCodeList.add("sz002239");  // ���ؼ�
//		researchStockCodeList.add("sz002328");  // ����ɷ�
//		researchStockCodeList.add("sz002838");  // �����ɷ�
//		researchStockCodeList.add("sz002481");  // ˫��ʳƷ
		
		
//		researchStockCodeList.add("index510050");  // 50ETF
//		researchStockCodeList.add("index510500");  // 500ETF	
//		researchStockCodeList.add("index510300");  // 300ETF

//		researchStockCodeList.add("index159949");  // ��ҵ��50		
//		researchStockCodeList.add("index159915");  // ��ҵ��
//		researchStockCodeList.add("index159902");  // ��С��

		
		
		// ����ģ�Ͷ���ѡ��Ʊ����ʷ���׼�¼���з�����������
//		processStockByModel_dtplgj(researchStockCodeList,  "2008/01/01", "2020/12/01");  // ��ͷ���иĽ�ģ��
		
//		processStockByModel_cmwd(researchStockCodeList,  "2010/01/01", "2017/12/01");  // �����ȶ�ģ��
		
//		processStockByModel_dztd(researchStockCodeList, "2010/01/01", "2020/12/01");	 // ����̽��ģ��		
		
//		processStockByModel_wjz(researchStockCodeList, "2016/01/01", "2019/12/01");		 // ������ѡ��
//		processStockByModel_wjzgj(researchStockCodeList, "2016/01/01", "2018/01/01");	 // ������ѡ�ɸĽ�ģ��
		
//		processStockByModel_macdgj(researchStockCodeList,  "2000/01/01", "2019/12/01");  // macd�Ľ�ģ��
		
//		processStockByModel_yg(researchStockCodeList, "2010/01/01", "2020/12/30");	  	 // ����ģ��
//		processStockByModel_ygtp(researchStockCodeList, "2016/01/01", "2020/12/30");	 // ����ͻ��ģ��
//		processStockByModel_yggj(researchStockCodeList, "2015/01/01", "2018/02/15");	 // ���ɸĽ�ģ��
//		processStockByModel_ygsb(researchStockCodeList, "2014/01/01", "2019/12/31");	 // ����˫��ģ��
//		processStockByModel_yghdy(researchStockCodeList, "2015/01/01", "2018/01/12");	 // ���ɺ����ģ��
		
//		processStockByModel_ztb(researchStockCodeList, "2017/12/15", "2018/01/06");		 // ��ͣ��
//		processStockByModel_ztbyj(researchStockCodeList, "2017/11/01", "2018/02/01");	 // ��ͣ���о�
//		processStockByModel_slb(researchStockCodeList, "2016/01/04", "2018/02/01");		 // ��ͣ�������о�  
		
//		processStockByModel_lztp(researchStockCodeList);	 							 // ����ͻ��ģ��
//		processStockByModel_lzgs(researchStockCodeList);	 							 // ���Ǹ���ģ��
//		processStockByModel_hptp(researchStockCodeList, "2017/01/01", "2018/01/26");  	 // ����ͻ��ģ��		
//		processStockByModel_tztp(researchStockCodeList, "2017/01/01", "2019/01/01");  	 // ����ͻ��ģ��	
//		processStockByModel_ztdb(researchStockCodeList, "2013/01/01", "2020/12/31");  	 // ��ͣ�Ա�ģ��	
//		processStockByModel_zddb5(researchStockCodeList, "2015/01/01", "2015/12/31");  	 // �ǵ�5%�Ա�ģ��	
		
//		processStockByModel_syft(researchStockCodeList);	 							 // ��Ӱ����ģ��
//		processStockByModel_zxsz(researchStockCodeList, 2000, 2017);  					 // ��С��ֵ
//		processStockByModel_zfpm(researchStockCodeList, "2017/10/01", "2017/12/01", 0);  // �Ƿ�����
//		processStockByModel_kpqzt(researchStockCodeList, "2017/01/03", "2017/01/31");    // ��������ͣ
//		processStockByModel_wrjx(researchStockCodeList);  								 // ���վ���ģ��

//		processStockByModel_dzzh(researchStockCodeList, "2017/01/01", "2018/01/13");	 // ����֮��ģ��
//		processStockByModel_bkzj(researchStockCodeList, "2016/01/01", "2018/01/13");	 // �����ʽ�ģ��
		
//		processStockByModel_macd_ddz(researchStockCodeList, "2010/01/01", "2018/06/30");    // MACD DDZģ��
//		processStockByModel_macd_zth(researchStockCodeList, "2010/01/01", "2018/04/05");	// MACD_ZTHģ��
//		processStockByModel_macd_zdd(researchStockCodeList, "2015/01/01", "2018/06/30");    // MACD ZDD ��͵�ģ��
//		processStockByModel_macd_dbl(researchStockCodeList, "2010/01/01", "2018/06/30");    // MACD DBL �ױ���ģ��
//		processStockByModel_macd_trend(researchStockCodeList, "2017/12/01", "2018/01/16");  // MACD ����ģ��
		
//		processStockByModel_fundselect();   												// ����ѡ��
//		processStockByModel_beststock(researchStockCodeList, "2010/01/01", "2018/02/23");	// ��ѹ�Ʊ
		
		
		
		// ����Ͷ�ʲ���ģ�������ʷ���׼�¼������ȶ�
//		List stockPoolCodeList=getStockPoolCodeList(researchStockCodeList);  // ��ó�����ѡѡ�ɳ�
//		List stockPoolCodeList=getStockPoolCodeListByStable(researchStockCodeList);  // �����ȶ��Ի�ó�����ѡѡ�ɳ�
		

		List stockPoolCodeList=new ArrayList();

		// ����
//		stockPoolCodeList.add("sh600519");	// ����ę́
//		stockPoolCodeList.add("sz000858");  // ����Һ
//		stockPoolCodeList.add("sz002304");  // ��ӹɷ�
//		stockPoolCodeList.add("sh601111");  // �й�����
//		stockPoolCodeList.add("sh600036");  // ��������
//		stockPoolCodeList.add("sz000651");  // ��������
//		stockPoolCodeList.add("sh601318");  // �й�ƽ��
//		stockPoolCodeList.add("sh600000");  // �ַ�����
//		stockPoolCodeList.add("sh601668");  // �й�����
//		stockPoolCodeList.add("sh601766");  // �й��г�
//		stockPoolCodeList.add("sh601857");  // �й�ʯ��
//		stockPoolCodeList.add("sh600383");  // ��ؼ���
//		stockPoolCodeList.add("sz002751");  // ����չʾ
//		stockPoolCodeList.add("sh600097");  // ��������
//		stockPoolCodeList.add("sz002330");  // ����˹
//		stockPoolCodeList.add("sh600848");  // �Ϻ��ٸ�
//		stockPoolCodeList.add("sz000700");  // ģ�ܿƼ�
//		stockPoolCodeList.add("sz002239");  // ���ؼ�
//		stockPoolCodeList.add("sz002328");  // ����ɷ�
//		stockPoolCodeList.add("sz002838");  // �����ɷ�
//		stockPoolCodeList.add("sz002481");  // ˫��ʳƷ
		
		// ETF
//		stockPoolCodeList.add("index510050");  // 50ETF
//		stockPoolCodeList.add("index510500");  // 500ETF	
//		stockPoolCodeList.add("index510300");  // 300ETF
//		stockPoolCodeList.add("index159949");  // ��ҵ��50		
//		stockPoolCodeList.add("index159915");  // ��ҵ��
//		stockPoolCodeList.add("index159902");  // ��С��
		
		// ���
//		stockPoolCodeList.add("index880380");  // ��ư��
//		stockPoolCodeList.add("index880471");  // ���а��
//		stockPoolCodeList.add("index880472");  // ֤ȯ���
//		stockPoolCodeList.add("index880473");  // ���հ��
//		stockPoolCodeList.add("index880398");  // ҽ�ư��
//		stockPoolCodeList.add("index880400");  // ҽҩ���
//		stockPoolCodeList.add("index880324");  // ��ɫ���
//		stockPoolCodeList.add("index880301");  // ú̿���
//		stockPoolCodeList.add("index880318");  // �������
//		stockPoolCodeList.add("index880310");  // ʯ�Ͱ��
//		stockPoolCodeList.add("index880494");  // ���������
//		stockPoolCodeList.add("index880464");  // �ִ��������
		
		
		// ETF��ʱ��
//		stockPoolCodeList.add("minute510050");	// 50ETF��ʱ
//		stockPoolCodeList.add("minute510500");  // 500ETF��ʱ
//		stockPoolCodeList.add("minute510300");	// 300ETF��ʱ
//		stockPoolCodeList.add("minute159915");	// ��ҵ���ʱ
//		stockPoolCodeList.add("minute515050");  // "5GETF��ʱ"
//		stockPoolCodeList.add("minute512690");  // "��ETF��ʱ"
//		stockPoolCodeList.add("minute512010");  // "ҽҩETF��ʱ"
//		stockPoolCodeList.add("minute512880");  // "֤ȯETF��ʱ"
//		stockPoolCodeList.add("minute512800");  // "����ETF��ʱ"
		 
		
		// ��ͷ�ɷ�ʱ��
//		stockPoolCodeList.add("minute600519"); //"����ę́��ʱ"
//		stockPoolCodeList.add("minute600036"); //"�������з�ʱ"
//		stockPoolCodeList.add("minute000858"); //"����Һ��ʱ"
//		stockPoolCodeList.add("minute603259"); //"ҩ�����·�ʱ"
//		stockPoolCodeList.add("minute000725"); //"����������ʱ"
//		stockPoolCodeList.add("minute600760"); //"�к���ɷ�ʱ"
//		stockPoolCodeList.add("minute600309"); //"�򻪻�ѧ��ʱ"
//		stockPoolCodeList.add("minute601111"); //"�й�������ʱ"
//		stockPoolCodeList.add("minute601766"); //"�й��г�"
//		stockPoolCodeList.add("minute601857"); //"�й�ʯ��"
//		stockPoolCodeList.add("minute601012"); //"¡���ɷ�"
		

		
		// ����ɣ���ͨ�ɣ�����
//		stockPoolCodeList.add("601111");  // �й�����
//		stockPoolCodeList.add("601857");  // �й�ʯ��
//		stockPoolCodeList.add("601766");  // �й��г�
//		stockPoolCodeList.add("000651");  // ��������
//		stockPoolCodeList.add("600097");  // ��������
//		stockPoolCodeList.add("002330");  // ����˹
//		stockPoolCodeList.add("600848");  // �Ϻ��ٸ�
//		stockPoolCodeList.add("000700");  // ģ�ܿƼ�
		
		// ��ţ��
//		stockPoolCodeList.add("600519");  // ����ę́
//		stockPoolCodeList.add("000858");  // ����Һ
//		stockPoolCodeList.add("000333");  // ���ļ���
//		stockPoolCodeList.add("000002");  // ���A
//		stockPoolCodeList.add("000568");  // �����Ͻ�
//		stockPoolCodeList.add("600036");  // ��������
//		stockPoolCodeList.add("601318");  // �й�ƽ��
//		stockPoolCodeList.add("600309");  // �򻪻�ѧ
//		stockPoolCodeList.add("601012");  // ¡���ɷ�
//		stockPoolCodeList.add("600703");  // �������
//		stockPoolCodeList.add("600276");  // ����ҽҩ
//		stockPoolCodeList.add("600438");  // ͨ���ɷ�
//		stockPoolCodeList.add("600588");  // ��������
//		stockPoolCodeList.add("600887");  // �����ɷ�
//		stockPoolCodeList.add("601888");  // �й�����
//		stockPoolCodeList.add("603259");  // ҩ������
//		stockPoolCodeList.add("603288");  // ����ζҵ
//		stockPoolCodeList.add("300014");  // ��γ���
//		stockPoolCodeList.add("300122");  // �Ƿ�����
//		stockPoolCodeList.add("300601");  // ��̩����
//		stockPoolCodeList.add("300760");  // ����ҽ��
//		stockPoolCodeList.add("300450");  // �ȵ�����

//		stockPoolCodeList.add("600519");  // ����ę́
		
//		stockPoolCodeList.add("600009");  // �Ϻ�����
//		stockPoolCodeList.add("600018");  // �ϸۼ���
//		stockPoolCodeList.add("600895");  // �Ž��߿�
//		stockPoolCodeList.add("000333");  // ���ļ���
//		stockPoolCodeList.add("000002");  // ���A
//		stockPoolCodeList.add("600036");  // ��������
//		stockPoolCodeList.add("601318");  // �й�ƽ��
//		stockPoolCodeList.add("600379");  // ����ɷ�
//		stockPoolCodeList.add("600101");  // ���ǵ���
//		
//		stockPoolCodeList.add("600429");  // ��Ԫ�ɷ�
//		stockPoolCodeList.add("300106");  // ������ҵ
//		stockPoolCodeList.add("300257");  // ��ɽ�ɷ�
//		stockPoolCodeList.add("603619");  // ����ʯ��
//		stockPoolCodeList.add("603323");  // ��ũ����
//		stockPoolCodeList.add("600674");  // ��Ͷ��Դ
//		stockPoolCodeList.add("600661");  // ��������
		
//		stockPoolCodeList.add("515220");  // "ú̿ETF"
//		stockPoolCodeList.add("513100");  // ��ָETF
		
		// ָ��ETF
//		stockPoolCodeList.add("510050");  // 50ETF
//		stockPoolCodeList.add("510500");  // 500ETF
//		stockPoolCodeList.add("510300");  // 300ETF
//		stockPoolCodeList.add("159949");  // ��ҵ��50
//		stockPoolCodeList.add("159915");  // ��ҵ��		
//		stockPoolCodeList.add("588000");  // �ƴ�50ETF
//		stockPoolCodeList.add("510900");  // H��ETF
//		stockPoolCodeList.add("513520");  // �վ�ETF
//		stockPoolCodeList.add("513100");  // ��ָETF
//		stockPoolCodeList.add("513500");  // ����500ETF
//
//		stockPoolCodeList.add("512010");  // ҽҩETF
//		stockPoolCodeList.add("512170");  // ҽ��ETF
//		stockPoolCodeList.add("515220");  // ú̿ETF
//		stockPoolCodeList.add("515050");  // 5GETF
//		stockPoolCodeList.add("512690");  // ��ETF
//		stockPoolCodeList.add("512880");  // ֤ȯETF
//		stockPoolCodeList.add("512800");  // ����ETF
//		stockPoolCodeList.add("512660");  // ����ETF
//		stockPoolCodeList.add("515210");  // ����ETF
//		stockPoolCodeList.add("512200");  // ���ز�ETF
//		stockPoolCodeList.add("512480");  // �뵼��ETF
//		stockPoolCodeList.add("512760");  // оƬETF
//		stockPoolCodeList.add("515030");  // ����Դ��ETF
//		stockPoolCodeList.add("515790");  // ���ETF
//
//
//		stockPoolCodeList.add("516110");  // ����ETF		
//		stockPoolCodeList.add("516970");  // ����50ETF
//		stockPoolCodeList.add("512400");  // ��ɫETF
//		stockPoolCodeList.add("518880");  // �ƽ�ETF
//		stockPoolCodeList.add("516020");  // ����ETF
//		stockPoolCodeList.add("515880");  // ͨ��ETF
//		stockPoolCodeList.add("515000");  // �Ƽ�ETF		
//		stockPoolCodeList.add("159996");  // �ҵ�ETF
//		stockPoolCodeList.add("512720");  // �����ETF
//		stockPoolCodeList.add("159852");  // ���ETF
//		stockPoolCodeList.add("159869");  // ��ϷETF
//		stockPoolCodeList.add("159939");  // ��Ϣ����ETF
		
		
		// ������������ETF
		stockPoolCodeList.add("512010");  // ҽҩETF
		stockPoolCodeList.add("515220");  // ú̿ETF
		stockPoolCodeList.add("512690");  // ��ETF
		stockPoolCodeList.add("512880");  // ֤ȯETF
		stockPoolCodeList.add("512800");  // ����ETF
		stockPoolCodeList.add("512660");  // ����ETF
		stockPoolCodeList.add("512200");  // ���ز�ETF
		stockPoolCodeList.add("512480");  // �뵼��ETF
		stockPoolCodeList.add("516020");  // ����ETF
		stockPoolCodeList.add("516970");  // ����50ETF
		stockPoolCodeList.add("516110");  // ����ETF		
		stockPoolCodeList.add("159996");  // �ҵ�ETF
		
//		stockPoolCodeList.add("510050");  // 50ETF
//		stockPoolCodeList.add("510500");  // 500ETF
//		stockPoolCodeList.add("159949");  // ��ҵ��50
//		stockPoolCodeList.add("588000");  // �ƴ�50ETF
//		stockPoolCodeList.add("510900");  // H��ETF
		
		
		//stock �����о�����
//		dateType=StockKey.day;  
//		dateType=StockKey.minute1;  
//		dateType=StockKey.minute5;
		dateType=StockKey.minute15;  
//		dateType=StockKey.minute30; 
//		dateType=StockKey.minute60; 

		
		System.out.println("Get pool stock data.");
		Map stockDataMap=getStockAllDataMap(stockPoolCodeList);	 // ��ñ�ѡ�ع�Ʊ����ʷ����
		
//		processInvestmentByStrategy_dtpl(stockDataMap, "2004/01/01", "2020/12/01");  // ģ��Ͷ�ʲ���������׼�¼�����
//		processInvestmentByStrategy_jjcl(stockCodeList, "2010/01/01", "2019/12/30");
//		processInvestmentByStrategy_znzj(stockDataMap, "2010/01/01", "2020/12/31"); 
//		processInvestmentByStrategy_znzj(stockDataMap, "2011/01/01", "2012/01/01"); 
		
//		processInvestmentByStrategy_wrzb(stockDataMap, "2010/01/01", "2020/12/31"); 
//		processInvestmentByStrategy_wrzbfs(stockDataMap, "2010/01/01", "2020/12/31"); 
//		processInvestmentByStrategy_wrzbcd(stockDataMap, "2010/06/15", "2020/12/31"); 
//		processInvestmentByStrategy_wrzbcdgj(stockDataMap, "2015/06/15", "2020/12/31"); 
		
//		processInvestmentByStrategy_cci(stockDataMap, "2010/01/01", "2020/12/31"); 

//		processInvestmentByStrategy_wr100(stockDataMap, "2020/01/01", "2020/12/31");
		
		
		// ȫ����������

//		processEvaluationByMultipleStock(stockDataMap, "2014/01/01", "2014/12/31");  // ţ��
//		processEvaluationByMultipleStock(stockDataMap, "2015/01/01", "2015/12/31");	 // ţ��
//		processEvaluationByMultipleStock(stockDataMap, "2008/01/01", "2008/12/31");  // ����
//		processEvaluationByMultipleStock(stockDataMap, "2018/01/01", "2018/12/31");  // ����
		
//		processEvaluationByMultipleStock(stockDataMap, "2000/01/01", "2021/12/31");  // ȫ��
//		processEvaluationByMultipleStock(stockDataMap, "2000/01/01", "2010/12/31");  // ȫ����ʮ��
//		processEvaluationByMultipleStock(stockDataMap, "2011/01/01", "2021/12/31");  // ȫ����ʮ��
		
		processEvaluationByMultipleStock(stockDataMap, "2021/01/01", "2022/03/31");  // ��ʱ
		
	}
	
	public void processEvaluationByMultipleStock(Map stockDataMap, String startDate, String endDate)
	{
		
		// ����������
		MarketMonitor.rankStockRiseSpeed(stockDataMap, startDate, endDate, dateType);
		
		Iterator it=stockDataMap.keySet().iterator();
		List allTransactionDataList=new ArrayList();
		List reportLineList=new ArrayList();
		
		ModelEvaluationReport mer=new ModelEvaluationReport();
		while(it.hasNext())
		{
			String stockCode=it.next().toString();
			List stockRecordList=(List)stockDataMap.get(stockCode); 
			Map singleStockDataMap=new TreeMap();
			singleStockDataMap.put(stockCode, stockRecordList);

			// ��ģ�Ͳ���ÿֻ��Ʊ
//			mer=processInvestmentByStrategy_wr100_K60(singleStockDataMap, startDate, endDate);
//			mer=processInvestmentByStrategy_macd_ndbl(singleStockDataMap, startDate, endDate);
//			mer=processInvestmentByStrategy_macd_ndtpl(singleStockDataMap, startDate, endDate); 
//			mer=processInvestmentByStrategy_macd_ndtpl_ma20(singleStockDataMap, startDate, endDate);
//			mer=processInvestmentByStrategy_zspm_minute(singleStockDataMap, startDate, endDate); // ��������
//			mer=processInvestmentByStrategy_zzyl_minute(singleStockDataMap, startDate, endDate); // ׷��ӯ��
			mer=processInvestmentByStrategy_zzpm_minute(singleStockDataMap, startDate, endDate); // ׷������
			
			allTransactionDataList.addAll(mer.getTransactionDataList());
			double selfProfit=CommonTool.getReferenceProfit(stockCode, "day", startDate, endDate);
			reportLineList.add(mer.getReportLine()+"  "+CommonTool.getDoubleNumberWithTwoBit(selfProfit)+"%");
			
		}
		
		
		outputTransactionRecordReport_total(allTransactionDataList, mer.getModelName());
		
		System.out.println(mer.getModelName()+" "+startDate+" - "+endDate);
//		String reportTitle=CommonTool.formatStringLength("��Ʊ����", 25)
//				+CommonTool.formatStringLength("��Ʊ����",12)
//				+CommonTool.formatStringLength("���״���",10)
//				+CommonTool.formatStringLength("�ɹ�",14)
//				+CommonTool.formatStringLength("ʧ��",14)
//				+CommonTool.formatStringLength("ʤ��",15)
//				+CommonTool.formatStringLength("���Ƿ�(DBJ)",12)
//				+CommonTool.formatStringLength("���Ƿ�(FL)",12)
//				+CommonTool.formatStringLength("ͬ�ڱ���",10)
//				+CommonTool.formatStringLength("ͬ��50ETF",10)
//				+CommonTool.formatStringLength("ͬ��300ETF",10)
//				+CommonTool.formatStringLength("ͬ�ڻ���",10);
		String reportTitle="��Ʊ����"+"\t\t"
				+"��Ʊ����"+"\t\t"
				+"���״���"+"\t"
				+"�ɹ�"+"\t"
				+"ʧ��"+"\t"
				+"ʤ��"+"\t\t"
				+"���Ƿ�(DBJ)"+"\t"
				+"���Ƿ�(FL)"+"\t"
				+"ͬ�ڱ���"+"\t";
		
		System.out.println(reportTitle);
		for (int i=0; i<reportLineList.size(); i++)
		{
			String reportLine=(String)reportLineList.get(i);
			System.out.println(reportLine);
		}
		
	}
	
	
	// ģ��Ͷ�� - CMDN ���붯�ܲ���
	public ModelEvaluationReport processInvestmentByStrategy_CMDN(Map stockDataMap, String startDate, String endDate)
	{
		
		// ����һ������ģ���˻�
		PersonalStockAccount psa=new PersonalStockAccount();
		
		List dateList=CommonTool.generateTimeReferenceList(startDate, endDate, dateType);
		
		// ���������accountDD_pre
 		AccountDayData accountDD_pre=new AccountDayData();  
		accountDD_pre.setCashValue(psa.investMoney);
		
		double lastSalePrice=10000;  // ��һ���׳�ʱ�ļ۸�, ��ʼֵ10000
		String lastSaleDate="";
		boolean isMACDChanged=false;   // ��һ���׳�������MACD 5>60�������Ƿ�ı�
		
		
		// ģ��ÿ�������ս���
		for (int i=0; i<dateList.size(); i++)
		{
			
			// ȡ��һ����������
			String transDate=dateList.get(i).toString();
			
			// ����һ�����յĽ����˻�����accountDD�����̳����յĳֲֺ��ֽ�
			AccountDayData accountDD=new AccountDayData();
			accountDD.setPosNum(i);
			accountDD.setDate(transDate);
			accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // �̳����յĳֲ�
			accountDD.setCashValue(accountDD_pre.getCashValue());	// �̳����յ��ֽ�
			
			// ��鵱ǰ�ֲֵĹ�Ʊ����״�����Ⱦ����Ƿ������������³ֲֹ�Ʊ�����ɳֲּ۸�
			List stockHoldList=accountDD.getStockHoldList();
			int stockHoldSize=stockHoldList.size();
			for (int j=stockHoldSize-1; j>=0; j--)
			{
				// ȡ��һ���ֹɶ���
				StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
				
				// ��ô˳ֹɵ���ʷ����
				String stockcode=shs.getCode();
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
				// ȡ���˹�ǰ���������
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
				
				
				if (sdd==null || sdd_b1==null || sdd_b2==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
				{
					shs.setCurDate(transDate);
					continue;
				}
				
				TransactionRecordData trd=new TransactionRecordData();
				StockDayData buySDD=shs.getBuySDD();
				
				double wr_wave=sdd.getWR10()-sdd_b1.getWR10();
				double wr_wave1=sdd_b1.getWR10()-sdd_b2.getWR10();
				double wr_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
				
				// ��ȡǰ���������
				List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
				List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10); 
				List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
				List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
				
//				sdd_b1=(StockDayData)pastStockList.get(1);   // ��������ȡ��
						
//				System.out.println(i);
				
				
				// �жϴ˹ɵ�ǰ���ƣ��Ƿ���ֳ������ƣ������Ƿ�����
				int wr_vavel=70;
				if ( 
				i==dateList.size()-2     // ���˽��׶��е����һ��
				
//				||(sdd_b1.getWR100()<wr_vavel && sdd.getWR100()>wr_vavel) 	// WR100�ϴ�40
//				||(sdd_b1.getWR100()>wr_vavel && sdd.getWR100()>sdd_b1.getWR100())  // 40���ϣ��������ϣ�����������;�³�������������
//				||(checkPastdays_WR100_Rise(pastStockList5, sdd)>20)   // ��ǰWR100ֵ����ڹ�ȥ�������͵������˶���
//				||(checkPastdays_TopRiseDown(pastStockList20, sdd)<-10)  // ����ߵ��µ�15%��ֹ���׳�
				 
//				sdd_b1.getCCI14()>100 && sdd.getCCI14()<100
//				(sdd_b2.getWR10()<30 && sdd_b1.getWR10()>30 ) &&
						
//				 (sdd_b1.getWR42()<50 && sdd.getWR42()>50) 
						
//				 ( 
//				 sdd.getDate().endsWith("7")  // ��14:30��������
//				 &&		 
//				 sdd.getWR42()>70	// �ڶ�����;���ַ����ϴ�30����, ���ֵ��Ȼ��Խ��Խ�ã���ΪԽ����Ա���󲨶�������;����³�
//				 ||
//				 sdd.getDate().endsWith("8")  // �ڶ�����������
//				 && checkPastdays_WR42_EndNumberRise(pastStockList)>30 
//				 ) 
//				 || 
				 
//				 || checkPastdays_WR42_TopNumber(pastStockList, 85)>2
//				 ( checkPastdays_WR42_EndNumber(pastStockList5, 20)>0 && sdd.getWR42()>50 )
//				 ||
//				 ( checkPastdays_WR42_EndNumber(pastStockList5, 20)<0 && sdd.getWR42()>50 )
//				 sdd.getWR42()>50
//				 || wr_profit<-5
//				 (sdd.getHigh_rise()-sdd.getLow_rise()>4 && sdd.getReal_rise()<0) ||
//				 (!checkDayData_MA_dtpl_5_10(sdd_b1)) || (!checkDayData_MA_dtpl_10_20(sdd_b1)) ||
//				 (sdd_b1.getReal_rise()<0 && sdd.getReal_rise()<0 && sdd_b1.getClose_rise()+sdd.getClose_rise()<-5 ) ||  // ����˫��  

//				 (sdd.getReal_rise()<-5) ||  // �����������������ȴ���5%		
//				 (sdd.getReal_rise()<0 && (sdd.getLow()+sdd.getHigh())/2<sdd.getMa_20())   // ��������������λ�۵���20����
				 
//				 (sdd.getReal_rise()<0 && sdd.getHigh_rise()-sdd.getLow_rise()>5)   // ������������ߵ㵽���̵�������5%	
				 
//				  sdd.getWR100()<10 || sdd.getWR100()>50 
				
				)
				{
					// ������CCI����ָ��
//					TransactionRecordData trd=new TransactionRecordData();
//					StockDayData buySDD=shs.getBuySDD();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(buySDD);
					trd.setSaleSDD(sdd);
					
					// wr �������
					double transactionProfit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getClose())/trd.getBuySDD().getClose())*100-0.2;
					trd.setTransactionProfit(transactionProfit);
					
					accountDD.saleTransList.add(trd);
					
					if(lastSalePrice==10000 || sdd.getClose()>lastSalePrice)
					{
						lastSalePrice=sdd.getClose(); // ��¼��һ������ʱ�ļ۸�
					}
					
					// ����accountDD�ֲ��б�
					accountDD.stockHoldList.remove(j);
					
					// ����accountDD�ֽ��ֵ
					int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
					int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
					
					
				}
				else
				{
					// �粻�������ͼ������в��䣬���³ֲּ۸�
					shs.setCurDate(transDate);
					shs.setCurPrice(sdd.getClose());	
				}
				
			}
			
			
			// ����Ʊ���ﱸѡ�Ĺ�Ʊ����������پ����Ƿ����룬�����³ֲֹ�Ʊ
			Iterator it=stockDataMap.keySet().iterator();
			while(it.hasNext())
			{
				
				// �ӱ�ѡ��Ʊ����ȡ��һֻ��Ʊ
				String stockcode=it.next().toString();  
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
			
				if (checkStockHoldList(stockHoldList, stockcode)==true)  // ����Ѿ��ֹɣ�������������
				{
					continue;
				}
				
				// ȡ���˹�ǰ���������
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
//				StockDayData sdd_b3=CommonTool.getStockDayData(stockDataRecordList, transDate, -3);
//				StockDayData sdd_b4=CommonTool.getStockDayData(stockDataRecordList, transDate, -4);
//				StockDayData sdd_b5=CommonTool.getStockDayData(stockDataRecordList, transDate, -5);
//				StockDayData sdd_b6=CommonTool.getStockDayData(stockDataRecordList, transDate, -6);
//				StockDayData sdd_b7=CommonTool.getStockDayData(stockDataRecordList, transDate, -7);
//				StockDayData sdd_b8=CommonTool.getStockDayData(stockDataRecordList, transDate, -8);
//				StockDayData sdd_b9=CommonTool.getStockDayData(stockDataRecordList, transDate, -9);
//				StockDayData sdd_b10=CommonTool.getStockDayData(stockDataRecordList, transDate, -10);
//				StockDayData sdd_b11=CommonTool.getStockDayData(stockDataRecordList, transDate, -11);
//				StockDayData sdd_b12=CommonTool.getStockDayData(stockDataRecordList, transDate, -12);
//				StockDayData sdd_b13=CommonTool.getStockDayData(stockDataRecordList, transDate, -13);
//				StockDayData sdd_b14=CommonTool.getStockDayData(stockDataRecordList, transDate, -14);
//				StockDayData sdd_b15=CommonTool.getStockDayData(stockDataRecordList, transDate, -15);
				
				
//				if (sdd!=null && sdd_b1!=null)
//				{
//					System.out.println(sdd_b1.getName()+" "+sdd_b1.getCode()+" "+sdd_b1.getDate()+" "+sdd_b1.getClose());
//					System.out.println(sdd.getName()+" "+sdd.getCode()+" "+sdd.getDate()+" "+sdd.getClose());
//				}
				
				if (sdd==null || sdd_b1==null)
				{
					continue;
				}
				
//				if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null || sdd_b4==null || sdd_b5==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
//				{
//					continue;
//				}
//				
//				if (sdd_b6==null || sdd_b7==null || sdd_b8==null || sdd_b9==null)
//				{
//					continue;
//				}
//				
//				if (sdd_b10==null || sdd_b11==null || sdd_b12==null || sdd_b13==null || sdd_b14==null || sdd_b15==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
//				{
//					continue;
//				}
				
				// ��ȡǰ���������
				List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
				List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);
				List pastStockList15=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 15);
				List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
				List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
				List pastStockList100=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 100);
				List pastStockList150=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 150);
//				String dateb1=sdd_b1.getDate();   // debug����
//				System.out.println(dateb1);
//				if (sdd_b1.getDate().contains("2020/11/02"))
//				{
//					int t=1;
//					t++;
//				}
				
				
				// �����̼۸��������λ�۸ߣ������������������������
//				if ( sdd_b1.getWR10()>90 && sdd_b1.getWR6()>90 )
				if ( 
					
					( ( sdd.getOpen()>(sdd_b1.getHigh()+sdd_b1.getLow())/2) && sdd_b1.getReal_rise()>0 )
//					sdd.getWR100()<15
//					&& checkDayData_MA_dtpl(sdd)
//					&& (sdd.getClose()-sdd.getMa_5())/sdd.getMa_5()<0.02
//					&& sdd.getDate().endsWith("-004")
//					|| (sdd.getClose()>lastSalePrice && sdd.getMa_5()>sdd.getMa_20() && sdd.getMa_20()>sdd.getMa_60() && sdd.getWR100()<50) 
//					&& sdd.getDate().compareTo(lastSaleDate)>0)
//					&& checkPastdays_WR42_TopNumber(pastStockList150, 80)>=1
					
//					sdd_b1.getCCI14()<100 && sdd.getCCI14()>100
//					sdd_b2.getWR6()>75 && sdd_b2.getWR6()-sdd_b1.getWR6()>10    // WR�´�10����
//					sdd_b2.getWR6()>50
//					sdd_b2.getWR6()<75 && sdd_b1.getWR6()>75    // WR�´�70
//					&& sdd_b1.getWR6()-sdd_b2.getWR6()>30
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_10()
//					&& !(sdd_b1.getMa_5()<sdd_b1.getMa_10() && sdd_b1.getMa_10()<sdd_b1.getMa_20())   // ��MACD��ͷ����
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_20()     
//					&& !(sdd_b1.getReal_rise()<0 && sdd_b2.getReal_rise()<0 && sdd_b3.getReal_rise()<0)   // ����������
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2) 


//					&& checkPastdaysWR42(transDate, -20, 90);  // ����transDate֮ǰ20�죬�Ƿ��г���90��ֵ
//					&& sdd_b1.getWR42()>85 
//					( checkPastdays_WR42_TopNumber_TopNumber(pastStockList10, 85)==1 && checkPastdays_WR42_EndNumber(pastStockList5, 60)>=1 )
//					||
						
//					( 
//					sdd_b1.getDate().endsWith("7")  // ��14:30����
//					&&
//					checkPastdays_WR42_TopNumber(pastStockList20, 50)==0   // �ǴӸ�λ�´�							
//					&& 
//					checkPastdays_WR42_EndNumber(pastStockList40, 20)>=20   // ����ǰ��ν���WR42��20��������
//					&& 
//					sdd_b1.getWR42()<20 	// ����ʱWR42��20����
//					&&
//					sdd_b1.getWR100()<20
//					&& 
//					checkPastdays_WR42_EndNumberRise(pastStockList10)<-20
//					)
//					||
//					( 
//					checkPastdays_WR42_TopNumber(pastStockList10, 85)>=1
//					&&
//					checkPastdays_WR42_TopNumber(pastStockList5, 50)>=1
//					&&
//					sdd_b1.getWR42()<50
//					)
					
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_60()
//					&& sdd_b4.getWR42()-sdd_b1.getWR42()>10
					
//					&& (sdd_b4.getWR42()-sdd_b1.getWR42()>15 || sdd.getOpen()>lastSalePrice) 
//					&& checkDayData_MA_dtpl(sdd_b2)
//					&& checkDayData_MA_dtpl(sdd_b3)
//					&& checkDayData_MA_dtpl(sdd_b4)
					
//					&& sdd_b6.getWR42()<50
//					&& sdd_b10.getWR42()-sdd_b6.getWR42()>15				
//					&& sdd_b6.getMa_5()>sdd_b6.getMa_60()     // �ǳ���Ҫ��һ����������׼ȷ������������̬	
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2)
//					&& checkDayData_MA_dtpl(sdd_b3)
//					&& checkDayData_MA_dtpl(sdd_b4)
//					&& checkDayData_MA_dtpl(sdd_b5)
					
//					&& sdd_b2.getWR100()>50 && sdd_b1.getWR100()<50    // WR100�´�50
						
					)
				{
					
					// �����ֶ�ͷ���У������룬����¼���뽻��
					TransactionRecordData trd=new TransactionRecordData();
					trd.setBuySDD(sdd);
					accountDD.buyTransList.add(trd);
					
					// ����accountDD�ֲ��б�
					StockHoldShare shs=new StockHoldShare();
					
					// ����������Ʊ����
//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
//					int amount=0;
//					if (accountDD.cashValue>eachStockInvestMoney)
//					{
//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // ʣ���ֽ��㹻Ͷ��һ�ݵ�ǰ��Ʊ
//					}
//					else
//					{
//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ𲻹�Ͷ��һ�ݵ�ǰ��Ʊ����ȫ������
//					}
					
					int amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ�ȫ������
					
					// ���������ĳֲֹ�Ʊ
					shs.setAmount(amount);
					shs.setCode(sdd.getCode());
					shs.setName(sdd.getName());
					shs.setBuyPrice(sdd.getOpen());
					shs.setBuyDate(sdd.getDate());
					shs.setCurPrice(sdd.getClose());
					shs.setCurDate(sdd.getDate());
					shs.setBuySDD(sdd);
					stockHoldList.add(shs);
					
					// ����accountDD�ֽ��ֵ
					int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
					int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
					
				}
				else
				{
					
					// ���δ���ϼ������ǣ����Ǽ����µ��ˣ�WR100�ؼ�������80���ϣ���˵�������ѻ������ܼ����ùɼ۽����ķ�����
					// Ҫ�ȴ�WR100�ٴλص�20�����ٴη���һ���µ�����
					if (sdd.getWR100()>80)   
					{
//						System.out.println("SDD WR: "+sdd.getDate()+"  "+sdd.getWR100());
						lastSalePrice=10000;  
					}
					
				}
				
			}
			
			// ���¸����˻���ÿ���˻���Ϣ
			Map accountDataMap=psa.getAccountDataMap();
			accountDataMap.put(transDate, accountDD);
			accountDD_pre=accountDD;
			
		}
		
		// ���Ͷ�ʽ��׼�¼��ģ�⽻�׽��仯���ߣ��Ա��������ײ���
		String modelName="Ͷ�����_CMDN";
		List transactionDataList=generateTransactionDataListFromPSA(psa);
		String reportLine=outputTransactionRecordReport(transactionDataList, modelName);
		// code name date_c saledate year days buy_price sale_price profit 
		
//		outputAccountRecordReport(psa); // ���account��ÿ��Ͷ�����ݣ��۸�仯���ֽ��ֵ/�ܼ�ֵ  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
		
//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, �׷������� 
		
		ModelEvaluationReport mer=new ModelEvaluationReport();
		mer.setTransactionDataList(transactionDataList);
		mer.setReportLine(reportLine);
		mer.setModelName(modelName);
		
		return mer;
	}
	
	
	// ģ��Ͷ�� - WR100 ָ�����
	public ModelEvaluationReport processInvestmentByStrategy_wr100_K60(Map stockDataMap, String startDate, String endDate)
	{
		
		// ����һ������ģ���˻�
		PersonalStockAccount psa=new PersonalStockAccount();
		
		List dateList=CommonTool.generateTimeReferenceList(startDate, endDate, dateType);
		
		// ���������accountDD_pre
 		AccountDayData accountDD_pre=new AccountDayData();  
		accountDD_pre.setCashValue(psa.investMoney);
		
		double lastSalePrice=10000;  // ��һ���׳�ʱ�ļ۸�, ��ʼֵ10000
		String lastSaleDate="";
		boolean isMACDChanged=false;   // ��һ���׳�������MACD 5>60�������Ƿ�ı�
		
		
		// ģ��ÿ�������ս���
		for (int i=0; i<dateList.size(); i++)
		{
			
			// ȡ��һ����������
			String transDate=dateList.get(i).toString();
			
			// ����һ�����յĽ����˻�����accountDD�����̳����յĳֲֺ��ֽ�
			AccountDayData accountDD=new AccountDayData();
			accountDD.setPosNum(i);
			accountDD.setDate(transDate);
			accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // �̳����յĳֲ�
			accountDD.setCashValue(accountDD_pre.getCashValue());	// �̳����յ��ֽ�
			
			// ��鵱ǰ�ֲֵĹ�Ʊ����״�����Ⱦ����Ƿ������������³ֲֹ�Ʊ�����ɳֲּ۸�
			List stockHoldList=accountDD.getStockHoldList();
			int stockHoldSize=stockHoldList.size();
			for (int j=stockHoldSize-1; j>=0; j--)
			{
				// ȡ��һ���ֹɶ���
				StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
				
				// ��ô˳ֹɵ���ʷ����
				String stockcode=shs.getCode();
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
				// ȡ���˹�ǰ���������
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
				
				
				if (sdd==null || sdd_b1==null || sdd_b2==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
				{
					shs.setCurDate(transDate);
					continue;
				}
				
				TransactionRecordData trd=new TransactionRecordData();
				StockDayData buySDD=shs.getBuySDD();
				
				double wr_wave=sdd.getWR10()-sdd_b1.getWR10();
				double wr_wave1=sdd_b1.getWR10()-sdd_b2.getWR10();
				double wr_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
				
				// ��ȡǰ���������
				List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
				List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10); 
				List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
				List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
				
//				sdd_b1=(StockDayData)pastStockList.get(1);   // ��������ȡ��
						
//				System.out.println(i);
				
				
				// �жϴ˹ɵ�ǰ���ƣ��Ƿ���ֳ������ƣ������Ƿ�����
				int wr_vavel=70;
				if ( 
				i==dateList.size()-2     // ���˽��׶��е����һ��
				||(sdd_b1.getWR100()<wr_vavel && sdd.getWR100()>wr_vavel) 	// WR100�ϴ�40
//				||(sdd_b1.getWR100()>wr_vavel && sdd.getWR100()>sdd_b1.getWR100())  // 40���ϣ��������ϣ�����������;�³�������������
//				||(checkPastdays_WR100_Rise(pastStockList5, sdd)>20)   // ��ǰWR100ֵ����ڹ�ȥ�������͵������˶���
//				||(checkPastdays_TopRiseDown(pastStockList20, sdd)<-10)  // ����ߵ��µ�15%��ֹ���׳�
				 
//				sdd_b1.getCCI14()>100 && sdd.getCCI14()<100
//				(sdd_b2.getWR10()<30 && sdd_b1.getWR10()>30 ) &&
						
//				 (sdd_b1.getWR42()<50 && sdd.getWR42()>50) 
						
//				 ( 
//				 sdd.getDate().endsWith("7")  // ��14:30��������
//				 &&		 
//				 sdd.getWR42()>70	// �ڶ�����;���ַ����ϴ�30����, ���ֵ��Ȼ��Խ��Խ�ã���ΪԽ����Ա���󲨶�������;����³�
//				 ||
//				 sdd.getDate().endsWith("8")  // �ڶ�����������
//				 && checkPastdays_WR42_EndNumberRise(pastStockList)>30 
//				 ) 
//				 || 
				 
//				 || checkPastdays_WR42_TopNumber(pastStockList, 85)>2
//				 ( checkPastdays_WR42_EndNumber(pastStockList5, 20)>0 && sdd.getWR42()>50 )
//				 ||
//				 ( checkPastdays_WR42_EndNumber(pastStockList5, 20)<0 && sdd.getWR42()>50 )
//				 sdd.getWR42()>50
//				 || wr_profit<-5
//				 (sdd.getHigh_rise()-sdd.getLow_rise()>4 && sdd.getReal_rise()<0) ||
//				 (!checkDayData_MA_dtpl_5_10(sdd_b1)) || (!checkDayData_MA_dtpl_10_20(sdd_b1)) ||
//				 (sdd_b1.getReal_rise()<0 && sdd.getReal_rise()<0 && sdd_b1.getClose_rise()+sdd.getClose_rise()<-5 ) ||  // ����˫��  

//				 (sdd.getReal_rise()<-5) ||  // �����������������ȴ���5%		
//				 (sdd.getReal_rise()<0 && (sdd.getLow()+sdd.getHigh())/2<sdd.getMa_20())   // ��������������λ�۵���20����
				 
//				 (sdd.getReal_rise()<0 && sdd.getHigh_rise()-sdd.getLow_rise()>5)   // ������������ߵ㵽���̵�������5%	
				 
//				  sdd.getWR100()<10 || sdd.getWR100()>50 
				
				)
				{
					// ������CCI����ָ��
//					TransactionRecordData trd=new TransactionRecordData();
//					StockDayData buySDD=shs.getBuySDD();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(buySDD);
					trd.setSaleSDD(sdd);
					
					// wr �������
					double transactionProfit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getClose())/trd.getBuySDD().getClose())*100-0.2;
					trd.setTransactionProfit(transactionProfit);
					
					accountDD.saleTransList.add(trd);
					
					if(lastSalePrice==10000 || sdd.getClose()>lastSalePrice)
					{
						lastSalePrice=sdd.getClose(); // ��¼��һ������ʱ�ļ۸�
					}
					
					// ����accountDD�ֲ��б�
					accountDD.stockHoldList.remove(j);
					
					// ����accountDD�ֽ��ֵ
					int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
					int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
					
					
				}
				else
				{
					// �粻�������ͼ������в��䣬���³ֲּ۸�
					shs.setCurDate(transDate);
					shs.setCurPrice(sdd.getClose());	
				}
				
			}
			
			
			// ����Ʊ���ﱸѡ�Ĺ�Ʊ����������پ����Ƿ����룬�����³ֲֹ�Ʊ
			Iterator it=stockDataMap.keySet().iterator();
			while(it.hasNext())
			{
				
				// �ӱ�ѡ��Ʊ����ȡ��һֻ��Ʊ
				String stockcode=it.next().toString();  
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
			
				if (checkStockHoldList(stockHoldList, stockcode)==true)  // ����Ѿ��ֹɣ�������������
				{
					continue;
				}
				
				// ȡ���˹�ǰ���������
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
//				StockDayData sdd_b3=CommonTool.getStockDayData(stockDataRecordList, transDate, -3);
//				StockDayData sdd_b4=CommonTool.getStockDayData(stockDataRecordList, transDate, -4);
//				StockDayData sdd_b5=CommonTool.getStockDayData(stockDataRecordList, transDate, -5);
//				StockDayData sdd_b6=CommonTool.getStockDayData(stockDataRecordList, transDate, -6);
//				StockDayData sdd_b7=CommonTool.getStockDayData(stockDataRecordList, transDate, -7);
//				StockDayData sdd_b8=CommonTool.getStockDayData(stockDataRecordList, transDate, -8);
//				StockDayData sdd_b9=CommonTool.getStockDayData(stockDataRecordList, transDate, -9);
//				StockDayData sdd_b10=CommonTool.getStockDayData(stockDataRecordList, transDate, -10);
//				StockDayData sdd_b11=CommonTool.getStockDayData(stockDataRecordList, transDate, -11);
//				StockDayData sdd_b12=CommonTool.getStockDayData(stockDataRecordList, transDate, -12);
//				StockDayData sdd_b13=CommonTool.getStockDayData(stockDataRecordList, transDate, -13);
//				StockDayData sdd_b14=CommonTool.getStockDayData(stockDataRecordList, transDate, -14);
//				StockDayData sdd_b15=CommonTool.getStockDayData(stockDataRecordList, transDate, -15);
				
				
//				if (sdd!=null && sdd_b1!=null)
//				{
//					System.out.println(sdd_b1.getName()+" "+sdd_b1.getCode()+" "+sdd_b1.getDate()+" "+sdd_b1.getClose());
//					System.out.println(sdd.getName()+" "+sdd.getCode()+" "+sdd.getDate()+" "+sdd.getClose());
//				}
				
				if (sdd==null || sdd_b1==null)
				{
					continue;
				}
				
//				if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null || sdd_b4==null || sdd_b5==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
//				{
//					continue;
//				}
//				
//				if (sdd_b6==null || sdd_b7==null || sdd_b8==null || sdd_b9==null)
//				{
//					continue;
//				}
//				
//				if (sdd_b10==null || sdd_b11==null || sdd_b12==null || sdd_b13==null || sdd_b14==null || sdd_b15==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
//				{
//					continue;
//				}
				
				// ��ȡǰ���������
				List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
				List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);
				List pastStockList15=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 15);
				List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
				List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
				List pastStockList100=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 100);
				List pastStockList150=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 150);
//				String dateb1=sdd_b1.getDate();   // debug����
//				System.out.println(dateb1);
//				if (sdd_b1.getDate().contains("2020/11/02"))
//				{
//					int t=1;
//					t++;
//				}
				
				
				// ����WR������������
//				if ( sdd_b1.getWR10()>90 && sdd_b1.getWR6()>90 )
				if ( 
					
					sdd.getWR100()<15
//					&& checkDayData_MA_dtpl(sdd)
//					&& (sdd.getClose()-sdd.getMa_5())/sdd.getMa_5()<0.02
//					&& sdd.getDate().endsWith("-004")
//					|| (sdd.getClose()>lastSalePrice && sdd.getMa_5()>sdd.getMa_20() && sdd.getMa_20()>sdd.getMa_60() && sdd.getWR100()<50) 
//					&& sdd.getDate().compareTo(lastSaleDate)>0)
//					&& checkPastdays_WR42_TopNumber(pastStockList150, 80)>=1
					
//					sdd_b1.getCCI14()<100 && sdd.getCCI14()>100
//					sdd_b2.getWR6()>75 && sdd_b2.getWR6()-sdd_b1.getWR6()>10    // WR�´�10����
//					sdd_b2.getWR6()>50
//					sdd_b2.getWR6()<75 && sdd_b1.getWR6()>75    // WR�´�70
//					&& sdd_b1.getWR6()-sdd_b2.getWR6()>30
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_10()
//					&& !(sdd_b1.getMa_5()<sdd_b1.getMa_10() && sdd_b1.getMa_10()<sdd_b1.getMa_20())   // ��MACD��ͷ����
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_20()     
//					&& !(sdd_b1.getReal_rise()<0 && sdd_b2.getReal_rise()<0 && sdd_b3.getReal_rise()<0)   // ����������
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2) 


//					&& checkPastdaysWR42(transDate, -20, 90);  // ����transDate֮ǰ20�죬�Ƿ��г���90��ֵ
//					&& sdd_b1.getWR42()>85 
//					( checkPastdays_WR42_TopNumber_TopNumber(pastStockList10, 85)==1 && checkPastdays_WR42_EndNumber(pastStockList5, 60)>=1 )
//					||
						
//					( 
//					sdd_b1.getDate().endsWith("7")  // ��14:30����
//					&&
//					checkPastdays_WR42_TopNumber(pastStockList20, 50)==0   // �ǴӸ�λ�´�							
//					&& 
//					checkPastdays_WR42_EndNumber(pastStockList40, 20)>=20   // ����ǰ��ν���WR42��20��������
//					&& 
//					sdd_b1.getWR42()<20 	// ����ʱWR42��20����
//					&&
//					sdd_b1.getWR100()<20
//					&& 
//					checkPastdays_WR42_EndNumberRise(pastStockList10)<-20
//					)
//					||
//					( 
//					checkPastdays_WR42_TopNumber(pastStockList10, 85)>=1
//					&&
//					checkPastdays_WR42_TopNumber(pastStockList5, 50)>=1
//					&&
//					sdd_b1.getWR42()<50
//					)
					
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_60()
//					&& sdd_b4.getWR42()-sdd_b1.getWR42()>10
					
//					&& (sdd_b4.getWR42()-sdd_b1.getWR42()>15 || sdd.getOpen()>lastSalePrice) 
//					&& checkDayData_MA_dtpl(sdd_b2)
//					&& checkDayData_MA_dtpl(sdd_b3)
//					&& checkDayData_MA_dtpl(sdd_b4)
					
//					&& sdd_b6.getWR42()<50
//					&& sdd_b10.getWR42()-sdd_b6.getWR42()>15				
//					&& sdd_b6.getMa_5()>sdd_b6.getMa_60()     // �ǳ���Ҫ��һ����������׼ȷ������������̬	
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2)
//					&& checkDayData_MA_dtpl(sdd_b3)
//					&& checkDayData_MA_dtpl(sdd_b4)
//					&& checkDayData_MA_dtpl(sdd_b5)
					
//					&& sdd_b2.getWR100()>50 && sdd_b1.getWR100()<50    // WR100�´�50
						
					)
				{
					
					// �����ֶ�ͷ���У������룬����¼���뽻��
					TransactionRecordData trd=new TransactionRecordData();
					trd.setBuySDD(sdd);
					accountDD.buyTransList.add(trd);
					
					// ����accountDD�ֲ��б�
					StockHoldShare shs=new StockHoldShare();
					
					// ����������Ʊ����
//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
//					int amount=0;
//					if (accountDD.cashValue>eachStockInvestMoney)
//					{
//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // ʣ���ֽ��㹻Ͷ��һ�ݵ�ǰ��Ʊ
//					}
//					else
//					{
//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ𲻹�Ͷ��һ�ݵ�ǰ��Ʊ����ȫ������
//					}
					
					int amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ�ȫ������
					
					// ���������ĳֲֹ�Ʊ
					shs.setAmount(amount);
					shs.setCode(sdd.getCode());
					shs.setName(sdd.getName());
					shs.setBuyPrice(sdd.getOpen());
					shs.setBuyDate(sdd.getDate());
					shs.setCurPrice(sdd.getClose());
					shs.setCurDate(sdd.getDate());
					shs.setBuySDD(sdd);
					stockHoldList.add(shs);
					
					// ����accountDD�ֽ��ֵ
					int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
					int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
					
				}
				else
				{
					
					// ���δ���ϼ������ǣ����Ǽ����µ��ˣ�WR100�ؼ�������80���ϣ���˵�������ѻ������ܼ����ùɼ۽����ķ�����
					// Ҫ�ȴ�WR100�ٴλص�20�����ٴη���һ���µ�����
					if (sdd.getWR100()>80)   
					{
//						System.out.println("SDD WR: "+sdd.getDate()+"  "+sdd.getWR100());
						lastSalePrice=10000;  
					}
					
				}
				
			}
			
			// ���¸����˻���ÿ���˻���Ϣ
			Map accountDataMap=psa.getAccountDataMap();
			accountDataMap.put(transDate, accountDD);
			accountDD_pre=accountDD;
			
		}
		
		// ���Ͷ�ʽ��׼�¼��ģ�⽻�׽��仯���ߣ��Ա��������ײ���
		String modelName="Ͷ�����_WR100ָ��_K60";
		List transactionDataList=generateTransactionDataListFromPSA(psa);
		String reportLine=outputTransactionRecordReport(transactionDataList, modelName);
		// code name date_c saledate year days buy_price sale_price profit 
		
//		outputAccountRecordReport(psa); // ���account��ÿ��Ͷ�����ݣ��۸�仯���ֽ��ֵ/�ܼ�ֵ  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
		
//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, �׷������� 
		
		ModelEvaluationReport mer=new ModelEvaluationReport();
		mer.setTransactionDataList(transactionDataList);
		mer.setReportLine(reportLine);
		mer.setModelName(modelName);
		
		return mer;
	}
	
	
	
	
	
	// ģ��Ͷ�� - WR100 ָ�����
	public ModelEvaluationReport processInvestmentByStrategy_wr100(Map stockDataMap, String startDate, String endDate)
	{
		
		// ����һ������ģ���˻�
		PersonalStockAccount psa=new PersonalStockAccount();
		
		List dateList=CommonTool.generateTimeReferenceList(startDate, endDate, dateType);
		
		// ���������accountDD_pre
 		AccountDayData accountDD_pre=new AccountDayData();  
		accountDD_pre.setCashValue(psa.investMoney);
		
		double lastSalePrice=10000;  // ��һ���׳�ʱ�ļ۸�, ��ʼֵ10000
		String lastSaleDate="";
		boolean isMACDChanged=false;   // ��һ���׳�������MACD 5>60�������Ƿ�ı�
		
		
		// ģ��ÿ�������ս���
		for (int i=0; i<dateList.size(); i++)
		{
			
			// ȡ��һ����������
			String transDate=dateList.get(i).toString();
			
			// ����һ�����յĽ����˻�����accountDD�����̳����յĳֲֺ��ֽ�
			AccountDayData accountDD=new AccountDayData();
			accountDD.setPosNum(i);
			accountDD.setDate(transDate);
			accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // �̳����յĳֲ�
			accountDD.setCashValue(accountDD_pre.getCashValue());	// �̳����յ��ֽ�
			
			// ��鵱ǰ�ֲֵĹ�Ʊ����״�����Ⱦ����Ƿ������������³ֲֹ�Ʊ�����ɳֲּ۸�
			List stockHoldList=accountDD.getStockHoldList();
			int stockHoldSize=stockHoldList.size();
			for (int j=stockHoldSize-1; j>=0; j--)
			{
				// ȡ��һ���ֹɶ���
				StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
				
				// ��ô˳ֹɵ���ʷ����
				String stockcode=shs.getCode();
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
				// ȡ���˹�ǰ���������
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
				
				
				if (sdd==null || sdd_b1==null || sdd_b2==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
				{
					shs.setCurDate(transDate);
					continue;
				}
				
				TransactionRecordData trd=new TransactionRecordData();
				StockDayData buySDD=shs.getBuySDD();
				
				double wr_wave=sdd.getWR10()-sdd_b1.getWR10();
				double wr_wave1=sdd_b1.getWR10()-sdd_b2.getWR10();
				double wr_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
				
				// ��ȡǰ���������
				List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
				List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10); 
				List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
				List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
				
//				sdd_b1=(StockDayData)pastStockList.get(1);   // ��������ȡ��
						
//				System.out.println(i);
				
				
				// �жϴ˹ɵ�ǰ���ƣ��Ƿ���ֳ������ƣ������Ƿ�����
				int wr_vavel=1000;
				if ( 
				i==dateList.size()-2     // ���˽��׶��е����һ��
				||(sdd_b1.getWR100()<wr_vavel && sdd.getWR100()>wr_vavel) 	// WR100�ϴ�40
				||(sdd_b1.getWR100()>wr_vavel && sdd.getWR100()>sdd_b1.getWR100())  // 40���ϣ��������ϣ�����������;�³�������������
//				||(checkPastdays_WR100_Rise(pastStockList5, sdd)>20)   // ��ǰWR100ֵ����ڹ�ȥ�������͵������˶���
//				||(checkPastdays_TopRiseDown(pastStockList20, sdd)<-10)  // ����ߵ��µ�15%��ֹ���׳�
				 
//				sdd_b1.getCCI14()>100 && sdd.getCCI14()<100
//				(sdd_b2.getWR10()<30 && sdd_b1.getWR10()>30 ) &&
						
//				 (sdd_b1.getWR42()<50 && sdd.getWR42()>50) 
						
//				 ( 
//				 sdd.getDate().endsWith("7")  // ��14:30��������
//				 &&		 
//				 sdd.getWR42()>70	// �ڶ�����;���ַ����ϴ�30����, ���ֵ��Ȼ��Խ��Խ�ã���ΪԽ����Ա���󲨶�������;����³�
//				 ||
//				 sdd.getDate().endsWith("8")  // �ڶ�����������
//				 && checkPastdays_WR42_EndNumberRise(pastStockList)>30 
//				 ) 
//				 || 
				 
//				 || checkPastdays_WR42_TopNumber(pastStockList, 85)>2
//				 ( checkPastdays_WR42_EndNumber(pastStockList5, 20)>0 && sdd.getWR42()>50 )
//				 ||
//				 ( checkPastdays_WR42_EndNumber(pastStockList5, 20)<0 && sdd.getWR42()>50 )
//				 sdd.getWR42()>50
//				 || wr_profit<-5
//				 (sdd.getHigh_rise()-sdd.getLow_rise()>4 && sdd.getReal_rise()<0) ||
//				 (!checkDayData_MA_dtpl_5_10(sdd_b1)) || (!checkDayData_MA_dtpl_10_20(sdd_b1)) ||
//				 (sdd_b1.getReal_rise()<0 && sdd.getReal_rise()<0 && sdd_b1.getClose_rise()+sdd.getClose_rise()<-5 ) ||  // ����˫��  

//				 (sdd.getReal_rise()<-5) ||  // �����������������ȴ���5%		
//				 (sdd.getReal_rise()<0 && (sdd.getLow()+sdd.getHigh())/2<sdd.getMa_20())   // ��������������λ�۵���20����
				 
//				 (sdd.getReal_rise()<0 && sdd.getHigh_rise()-sdd.getLow_rise()>5)   // ������������ߵ㵽���̵�������5%	
				 
//				  sdd.getWR100()<10 || sdd.getWR100()>50 
				
				)
				{
					// ������CCI����ָ��
//					TransactionRecordData trd=new TransactionRecordData();
//					StockDayData buySDD=shs.getBuySDD();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(buySDD);
					trd.setSaleSDD(sdd);
					
					// cci �������
					double transactionProfit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getClose())/trd.getBuySDD().getClose())*100-0.2;
					trd.setTransactionProfit(transactionProfit);
					
					accountDD.saleTransList.add(trd);
					
					if(lastSalePrice==10000 || sdd.getClose()>lastSalePrice)
					{
						lastSalePrice=sdd.getClose(); // ��¼��һ������ʱ�ļ۸�
					}
					
					// ����accountDD�ֲ��б�
					accountDD.stockHoldList.remove(j);
					
					// ����accountDD�ֽ��ֵ
					int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
					int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
					
					
				}
				else
				{
					// �粻�������ͼ������в��䣬���³ֲּ۸�
					shs.setCurDate(transDate);
					shs.setCurPrice(sdd.getClose());	
				}
				
			}
			
			
			// ����Ʊ���ﱸѡ�Ĺ�Ʊ����������پ����Ƿ����룬�����³ֲֹ�Ʊ
			Iterator it=stockDataMap.keySet().iterator();
			while(it.hasNext())
			{
				
				// �ӱ�ѡ��Ʊ����ȡ��һֻ��Ʊ
				String stockcode=it.next().toString();  
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
			
				if (checkStockHoldList(stockHoldList, stockcode)==true)  // ����Ѿ��ֹɣ�������������
				{
					continue;
				}
				
				// ȡ���˹�ǰ���������
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
//				StockDayData sdd_b3=CommonTool.getStockDayData(stockDataRecordList, transDate, -3);
//				StockDayData sdd_b4=CommonTool.getStockDayData(stockDataRecordList, transDate, -4);
//				StockDayData sdd_b5=CommonTool.getStockDayData(stockDataRecordList, transDate, -5);
//				StockDayData sdd_b6=CommonTool.getStockDayData(stockDataRecordList, transDate, -6);
//				StockDayData sdd_b7=CommonTool.getStockDayData(stockDataRecordList, transDate, -7);
//				StockDayData sdd_b8=CommonTool.getStockDayData(stockDataRecordList, transDate, -8);
//				StockDayData sdd_b9=CommonTool.getStockDayData(stockDataRecordList, transDate, -9);
//				StockDayData sdd_b10=CommonTool.getStockDayData(stockDataRecordList, transDate, -10);
//				StockDayData sdd_b11=CommonTool.getStockDayData(stockDataRecordList, transDate, -11);
//				StockDayData sdd_b12=CommonTool.getStockDayData(stockDataRecordList, transDate, -12);
//				StockDayData sdd_b13=CommonTool.getStockDayData(stockDataRecordList, transDate, -13);
//				StockDayData sdd_b14=CommonTool.getStockDayData(stockDataRecordList, transDate, -14);
//				StockDayData sdd_b15=CommonTool.getStockDayData(stockDataRecordList, transDate, -15);
				
				
//				if (sdd!=null && sdd_b1!=null)
//				{
//					System.out.println(sdd_b1.getName()+" "+sdd_b1.getCode()+" "+sdd_b1.getDate()+" "+sdd_b1.getClose());
//					System.out.println(sdd.getName()+" "+sdd.getCode()+" "+sdd.getDate()+" "+sdd.getClose());
//				}
				
				if (sdd==null || sdd_b1==null)
				{
					continue;
				}
				
//				if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null || sdd_b4==null || sdd_b5==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
//				{
//					continue;
//				}
//				
//				if (sdd_b6==null || sdd_b7==null || sdd_b8==null || sdd_b9==null)
//				{
//					continue;
//				}
//				
//				if (sdd_b10==null || sdd_b11==null || sdd_b12==null || sdd_b13==null || sdd_b14==null || sdd_b15==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
//				{
//					continue;
//				}
				
				// ��ȡǰ���������
				List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
				List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);
				List pastStockList15=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 15);
				List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
				List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
				List pastStockList100=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 100);
				List pastStockList150=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 150);
//				String dateb1=sdd_b1.getDate();   // debug����
//				System.out.println(dateb1);
//				if (sdd_b1.getDate().contains("2020/11/02"))
//				{
//					int t=1;
//					t++;
//				}
				
				
				// ����WR������������
//				if ( sdd_b1.getWR10()>90 && sdd_b1.getWR6()>90 )
				if ( 
					
					sdd.getWR100()<10 
					|| (sdd.getClose()>lastSalePrice && sdd.getMa_5()>sdd.getMa_20() && sdd.getMa_20()>sdd.getMa_60() && sdd.getWR100()<50) 
//					&& sdd.getDate().compareTo(lastSaleDate)>0)
//					&& checkPastdays_WR42_TopNumber(pastStockList150, 80)>=1
					
//					sdd_b1.getCCI14()<100 && sdd.getCCI14()>100
//					sdd_b2.getWR6()>75 && sdd_b2.getWR6()-sdd_b1.getWR6()>10    // WR�´�10����
//					sdd_b2.getWR6()>50
//					sdd_b2.getWR6()<75 && sdd_b1.getWR6()>75    // WR�´�70
//					&& sdd_b1.getWR6()-sdd_b2.getWR6()>30
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_10()
//					&& !(sdd_b1.getMa_5()<sdd_b1.getMa_10() && sdd_b1.getMa_10()<sdd_b1.getMa_20())   // ��MACD��ͷ����
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_20()     
//					&& !(sdd_b1.getReal_rise()<0 && sdd_b2.getReal_rise()<0 && sdd_b3.getReal_rise()<0)   // ����������
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2) 


//					&& checkPastdaysWR42(transDate, -20, 90);  // ����transDate֮ǰ20�죬�Ƿ��г���90��ֵ
//					&& sdd_b1.getWR42()>85 
//					( checkPastdays_WR42_TopNumber_TopNumber(pastStockList10, 85)==1 && checkPastdays_WR42_EndNumber(pastStockList5, 60)>=1 )
//					||
						
//					( 
//					sdd_b1.getDate().endsWith("7")  // ��14:30����
//					&&
//					checkPastdays_WR42_TopNumber(pastStockList20, 50)==0   // �ǴӸ�λ�´�							
//					&& 
//					checkPastdays_WR42_EndNumber(pastStockList40, 20)>=20   // ����ǰ��ν���WR42��20��������
//					&& 
//					sdd_b1.getWR42()<20 	// ����ʱWR42��20����
//					&&
//					sdd_b1.getWR100()<20
//					&& 
//					checkPastdays_WR42_EndNumberRise(pastStockList10)<-20
//					)
//					||
//					( 
//					checkPastdays_WR42_TopNumber(pastStockList10, 85)>=1
//					&&
//					checkPastdays_WR42_TopNumber(pastStockList5, 50)>=1
//					&&
//					sdd_b1.getWR42()<50
//					)
					
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_60()
//					&& sdd_b4.getWR42()-sdd_b1.getWR42()>10
					
//					&& (sdd_b4.getWR42()-sdd_b1.getWR42()>15 || sdd.getOpen()>lastSalePrice) 
//					&& checkDayData_MA_dtpl(sdd_b2)
//					&& checkDayData_MA_dtpl(sdd_b3)
//					&& checkDayData_MA_dtpl(sdd_b4)
					
//					&& sdd_b6.getWR42()<50
//					&& sdd_b10.getWR42()-sdd_b6.getWR42()>15				
//					&& sdd_b6.getMa_5()>sdd_b6.getMa_60()     // �ǳ���Ҫ��һ����������׼ȷ������������̬	
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2)
//					&& checkDayData_MA_dtpl(sdd_b3)
//					&& checkDayData_MA_dtpl(sdd_b4)
//					&& checkDayData_MA_dtpl(sdd_b5)
					
//					&& sdd_b2.getWR100()>50 && sdd_b1.getWR100()<50    // WR100�´�50
						
					)
				{
					
					// �����ֶ�ͷ���У������룬����¼���뽻��
					TransactionRecordData trd=new TransactionRecordData();
					trd.setBuySDD(sdd);
					accountDD.buyTransList.add(trd);
					
					// ����accountDD�ֲ��б�
					StockHoldShare shs=new StockHoldShare();
					
					// ����������Ʊ����
//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
//					int amount=0;
//					if (accountDD.cashValue>eachStockInvestMoney)
//					{
//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // ʣ���ֽ��㹻Ͷ��һ�ݵ�ǰ��Ʊ
//					}
//					else
//					{
//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ𲻹�Ͷ��һ�ݵ�ǰ��Ʊ����ȫ������
//					}
					
					int amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ�ȫ������
					
					// ���������ĳֲֹ�Ʊ
					shs.setAmount(amount);
					shs.setCode(sdd.getCode());
					shs.setName(sdd.getName());
					shs.setBuyPrice(sdd.getOpen());
					shs.setBuyDate(sdd.getDate());
					shs.setCurPrice(sdd.getClose());
					shs.setCurDate(sdd.getDate());
					shs.setBuySDD(sdd);
					stockHoldList.add(shs);
					
					// ����accountDD�ֽ��ֵ
					int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
					int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
					
				}
				else
				{
					
					// ���δ���ϼ������ǣ����Ǽ����µ��ˣ�WR100�ؼ�������80���ϣ���˵�������ѻ������ܼ����ùɼ۽����ķ�����
					// Ҫ�ȴ�WR100�ٴλص�20�����ٴη���һ���µ�����
					if (sdd.getWR100()>80)   
					{
//						System.out.println("SDD WR: "+sdd.getDate()+"  "+sdd.getWR100());
						lastSalePrice=10000;  
					}
					
				}
				
			}
			
			// ���¸����˻���ÿ���˻���Ϣ
			Map accountDataMap=psa.getAccountDataMap();
			accountDataMap.put(transDate, accountDD);
			accountDD_pre=accountDD;
			
		}
		
		// ���Ͷ�ʽ��׼�¼��ģ�⽻�׽��仯���ߣ��Ա��������ײ���
		String modelName="Ͷ�����_WR100ָ��";
		List transactionDataList=generateTransactionDataListFromPSA(psa);
		String reportLine=outputTransactionRecordReport(transactionDataList, modelName);
		// code name date_c saledate year days buy_price sale_price profit 
		
//		outputAccountRecordReport(psa); // ���account��ÿ��Ͷ�����ݣ��۸�仯���ֽ��ֵ/�ܼ�ֵ  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
		
//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, �׷������� 
		
		ModelEvaluationReport mer=new ModelEvaluationReport();
		mer.setTransactionDataList(transactionDataList);
		mer.setReportLine(reportLine);
		mer.setModelName(modelName);
		
		return mer;
	}
	
	
	// ģ��Ͷ�� - CCIָ�����
	public void processInvestmentByStrategy_cci(Map stockDataMap, String startDate, String endDate)
	{
		
		// ����һ������ģ���˻�
		PersonalStockAccount psa=new PersonalStockAccount();
		
		// ��òο��������ڶ���  - �л���������/��ʱ���ݵ�ʱ����
		List dateList=CommonTool.getDateReferenceList(startDate, endDate);		// ����ָ֤���Ľ�������Ϊ�ο�ֵ
//		List dateList=CommonTool.getDateReferenceList(startDate, endDate, 30);		// ����ָ֤���Ľ��׷�ʱΪ�ο�ֵ - ������
				
		// ���������accountDD_pre
 		AccountDayData accountDD_pre=new AccountDayData();  
		accountDD_pre.setCashValue(psa.investMoney);
		
		double lastSalePrice=0;  // ��һ���׳�ʱ�ļ۸�
		boolean isMACDChanged=false;   // ��һ���׳�������MACD 5>60�������Ƿ�ı�
		
		// ģ��ÿ�������ս���
		for (int i=0; i<dateList.size(); i++)
		{
			
			// ȡ��һ����������
			String transDate=dateList.get(i).toString();
			
			// ����һ�����յĽ����˻�����accountDD�����̳����յĳֲֺ��ֽ�
			AccountDayData accountDD=new AccountDayData();
			accountDD.setPosNum(i);
			accountDD.setDate(transDate);
			accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // �̳����յĳֲ�
			accountDD.setCashValue(accountDD_pre.getCashValue());	// �̳����յ��ֽ�
			
			// ��鵱ǰ�ֲֵĹ�Ʊ����״�����Ⱦ����Ƿ������������³ֲֹ�Ʊ�����ɳֲּ۸�
			List stockHoldList=accountDD.getStockHoldList();
			int stockHoldSize=stockHoldList.size();
			for (int j=stockHoldSize-1; j>=0; j--)
			{
				// ȡ��һ���ֹɶ���
				StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
				
				// ��ô˳ֹɵ���ʷ����
				String stockcode=shs.getCode();
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
				// ȡ���˹�ǰ���������
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
			
				
				if (sdd==null || sdd_b1==null || sdd_b2==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
				{
					shs.setCurDate(transDate);
					continue;
				}
				
				TransactionRecordData trd=new TransactionRecordData();
				StockDayData buySDD=shs.getBuySDD();
				
				double wr_wave=sdd.getWR10()-sdd_b1.getWR10();
				double wr_wave1=sdd_b1.getWR10()-sdd_b2.getWR10();
				double wr_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
				
				// ��ȡǰ���������
				List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
				List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);  
//				sdd_b1=(StockDayData)pastStockList.get(1);   // ��������ȡ��
						
				// �жϴ˹ɵ�ǰ���ƣ��Ƿ���ֳ������ƣ������Ƿ�����
				if ( 
				
				sdd_b1.getCCI14()>100 && sdd.getCCI14()<100
//				(sdd_b2.getWR10()<30 && sdd_b1.getWR10()>30 ) &&
						
//				 (sdd_b1.getWR42()<50 && sdd.getWR42()>50) 
						
//				 ( 
//				 sdd.getDate().endsWith("7")  // ��14:30��������
//				 &&		 
//				 sdd.getWR42()>70	// �ڶ�����;���ַ����ϴ�30����, ���ֵ��Ȼ��Խ��Խ�ã���ΪԽ����Ա���󲨶�������;����³�
//				 ||
//				 sdd.getDate().endsWith("8")  // �ڶ�����������
//				 && checkPastdays_WR42_EndNumberRise(pastStockList)>30 
//				 ) 
//				 || 
				 
//				 || checkPastdays_WR42_TopNumber(pastStockList, 85)>2
//				 ( checkPastdays_WR42_EndNumber(pastStockList5, 20)>0 && sdd.getWR42()>50 )
//				 ||
//				 ( checkPastdays_WR42_EndNumber(pastStockList5, 20)<0 && sdd.getWR42()>50 )
//				 sdd.getWR42()>50
//				 || wr_profit<-5
//				 (sdd.getHigh_rise()-sdd.getLow_rise()>4 && sdd.getReal_rise()<0) ||
//				 (!checkDayData_MA_dtpl_5_10(sdd_b1)) || (!checkDayData_MA_dtpl_10_20(sdd_b1)) ||
//				 (sdd_b1.getReal_rise()<0 && sdd.getReal_rise()<0 && sdd_b1.getClose_rise()+sdd.getClose_rise()<-5 ) ||  // ����˫��  

//				 (sdd.getReal_rise()<-5) ||  // �����������������ȴ���5%		
//				 (sdd.getReal_rise()<0 && (sdd.getLow()+sdd.getHigh())/2<sdd.getMa_20())   // ��������������λ�۵���20����
				 
//				 (sdd.getReal_rise()<0 && sdd.getHigh_rise()-sdd.getLow_rise()>5)   // ������������ߵ㵽���̵�������5%	
				 
//				  sdd.getWR100()<10 || sdd.getWR100()>50 
				
				)
				{
					// ������CCI����ָ��
//					TransactionRecordData trd=new TransactionRecordData();
//					StockDayData buySDD=shs.getBuySDD();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(buySDD);
					trd.setSaleSDD(sdd);
					
					// cci �������
					double transactionProfit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getClose())/trd.getBuySDD().getClose())*100-0.2;
					trd.setTransactionProfit(transactionProfit);
					
					accountDD.saleTransList.add(trd);
					
					lastSalePrice=sdd.getClose();  // ��¼��һ������ʱ�ļ۸�
					
					// ����accountDD�ֲ��б�
					accountDD.stockHoldList.remove(j);
					
					// ����accountDD�ֽ��ֵ
					int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
					int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
				}
				else
				{
					// �粻�������ͼ������в��䣬���³ֲּ۸�
					shs.setCurDate(transDate);
					shs.setCurPrice(sdd.getClose());	
				}
				
			}
			
			
			// ����Ʊ���ﱸѡ�Ĺ�Ʊ����������پ����Ƿ����룬�����³ֲֹ�Ʊ
			Iterator it=stockDataMap.keySet().iterator();
			while(it.hasNext())
			{
				
				// �ӱ�ѡ��Ʊ����ȡ��һֻ��Ʊ
				String stockcode=it.next().toString();  
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
			
				if (checkStockHoldList(stockHoldList, stockcode)==true)  // ����Ѿ��ֹɣ�������������
				{
					continue;
				}
				
				// ȡ���˹�ǰ���������
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
//				StockDayData sdd_b3=CommonTool.getStockDayData(stockDataRecordList, transDate, -3);
//				StockDayData sdd_b4=CommonTool.getStockDayData(stockDataRecordList, transDate, -4);
//				StockDayData sdd_b5=CommonTool.getStockDayData(stockDataRecordList, transDate, -5);
//				StockDayData sdd_b6=CommonTool.getStockDayData(stockDataRecordList, transDate, -6);
//				StockDayData sdd_b7=CommonTool.getStockDayData(stockDataRecordList, transDate, -7);
//				StockDayData sdd_b8=CommonTool.getStockDayData(stockDataRecordList, transDate, -8);
//				StockDayData sdd_b9=CommonTool.getStockDayData(stockDataRecordList, transDate, -9);
//				StockDayData sdd_b10=CommonTool.getStockDayData(stockDataRecordList, transDate, -10);
//				StockDayData sdd_b11=CommonTool.getStockDayData(stockDataRecordList, transDate, -11);
//				StockDayData sdd_b12=CommonTool.getStockDayData(stockDataRecordList, transDate, -12);
//				StockDayData sdd_b13=CommonTool.getStockDayData(stockDataRecordList, transDate, -13);
//				StockDayData sdd_b14=CommonTool.getStockDayData(stockDataRecordList, transDate, -14);
//				StockDayData sdd_b15=CommonTool.getStockDayData(stockDataRecordList, transDate, -15);
				
				
//				if (sdd!=null && sdd_b1!=null)
//				{
//					System.out.println(sdd_b1.getName()+" "+sdd_b1.getCode()+" "+sdd_b1.getDate()+" "+sdd_b1.getClose());
//					System.out.println(sdd.getName()+" "+sdd.getCode()+" "+sdd.getDate()+" "+sdd.getClose());
//				}
				
				if (sdd==null || sdd_b1==null)
				{
					continue;
				}
				
//				if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null || sdd_b4==null || sdd_b5==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
//				{
//					continue;
//				}
//				
//				if (sdd_b6==null || sdd_b7==null || sdd_b8==null || sdd_b9==null)
//				{
//					continue;
//				}
//				
//				if (sdd_b10==null || sdd_b11==null || sdd_b12==null || sdd_b13==null || sdd_b14==null || sdd_b15==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
//				{
//					continue;
//				}
				
				// ��ȡǰ���������
				List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
				List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);
				List pastStockList15=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 15);
				List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
				List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
				List pastStockList100=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 100);
				
//				String dateb1=sdd_b1.getDate();   // debug����
//				System.out.println(dateb1);
//				if (sdd_b1.getDate().contains("2020/11/02"))
//				{
//					int t=1;
//					t++;
//				}
				
				
				// ����WR������������
//				if ( sdd_b1.getWR10()>90 && sdd_b1.getWR6()>90 )
				if ( 
					
					(sdd_b1.getCCI14()<100 && sdd.getCCI14()>100) 
//					sdd_b2.getWR6()>75 && sdd_b2.getWR6()-sdd_b1.getWR6()>10    // WR�´�10����
//					sdd_b2.getWR6()>50
//					sdd_b2.getWR6()<75 && sdd_b1.getWR6()>75    // WR�´�70
//					&& sdd_b1.getWR6()-sdd_b2.getWR6()>30
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_10()
//					&& !(sdd_b1.getMa_5()<sdd_b1.getMa_10() && sdd_b1.getMa_10()<sdd_b1.getMa_20())   // ��MACD��ͷ����
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_20()     
//					&& !(sdd_b1.getReal_rise()<0 && sdd_b2.getReal_rise()<0 && sdd_b3.getReal_rise()<0)   // ����������
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2) 


//					&& checkPastdaysWR42(transDate, -20, 90);  // ����transDate֮ǰ20�죬�Ƿ��г���90��ֵ
//					&& sdd_b1.getWR42()>85 
//					( checkPastdays_WR42_TopNumber(pastStockList, 85)==1 && checkPastdays_WR42_EndNumber(pastStockList1, 60)>=1 )
//					||
						
//					( 
//					sdd_b1.getDate().endsWith("7")  // ��14:30����
//					&&
//					checkPastdays_WR42_TopNumber(pastStockList20, 50)==0   // �ǴӸ�λ�´�							
//					&& 
//					checkPastdays_WR42_EndNumber(pastStockList40, 20)>=20   // ����ǰ��ν���WR42��20��������
//					&& 
//					sdd_b1.getWR42()<20 	// ����ʱWR42��20����
//					&&
//					sdd_b1.getWR100()<20
//					&& 
//					checkPastdays_WR42_EndNumberRise(pastStockList10)<-20
//					)
//					||
//					( 
//					checkPastdays_WR42_TopNumber(pastStockList10, 85)>=1
//					&&
//					checkPastdays_WR42_TopNumber(pastStockList5, 50)>=1
//					&&
//					sdd_b1.getWR42()<50
//					)
					
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_60()
//					&& sdd_b4.getWR42()-sdd_b1.getWR42()>10
					
//					&& (sdd_b4.getWR42()-sdd_b1.getWR42()>15 || sdd.getOpen()>lastSalePrice) 
//					&& checkDayData_MA_dtpl(sdd_b2)
//					&& checkDayData_MA_dtpl(sdd_b3)
//					&& checkDayData_MA_dtpl(sdd_b4)
					
//					&& sdd_b6.getWR42()<50
//					&& sdd_b10.getWR42()-sdd_b6.getWR42()>15				
//					&& sdd_b6.getMa_5()>sdd_b6.getMa_60()     // �ǳ���Ҫ��һ����������׼ȷ������������̬	
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2)
//					&& checkDayData_MA_dtpl(sdd_b3)
//					&& checkDayData_MA_dtpl(sdd_b4)
//					&& checkDayData_MA_dtpl(sdd_b5)
					
//					&& sdd_b2.getWR100()>50 && sdd_b1.getWR100()<50    // WR100�´�50
						
					)
				{
					
					// �����ֶ�ͷ���У������룬����¼���뽻��
					TransactionRecordData trd=new TransactionRecordData();
					trd.setBuySDD(sdd);
					accountDD.buyTransList.add(trd);
					
					// ����accountDD�ֲ��б�
					StockHoldShare shs=new StockHoldShare();
					
					// ����������Ʊ����
//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
//					int amount=0;
//					if (accountDD.cashValue>eachStockInvestMoney)
//					{
//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // ʣ���ֽ��㹻Ͷ��һ�ݵ�ǰ��Ʊ
//					}
//					else
//					{
//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ𲻹�Ͷ��һ�ݵ�ǰ��Ʊ����ȫ������
//					}
					
					int amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ�ȫ������
					
					// ���������ĳֲֹ�Ʊ
					shs.setAmount(amount);
					shs.setCode(sdd.getCode());
					shs.setName(sdd.getName());
					shs.setBuyPrice(sdd.getOpen());
					shs.setBuyDate(sdd.getDate());
					shs.setCurPrice(sdd.getClose());
					shs.setCurDate(sdd.getDate());
					shs.setBuySDD(sdd);
					stockHoldList.add(shs);
					
					// ����accountDD�ֽ��ֵ
					int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
					int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
					
				}
				
			}
			
			// ���¸����˻���ÿ���˻���Ϣ
			Map accountDataMap=psa.getAccountDataMap();
			accountDataMap.put(transDate, accountDD);
			accountDD_pre=accountDD;
			
		}
		
		// ���Ͷ�ʽ��׼�¼��ģ�⽻�׽��仯���ߣ��Ա��������ײ���
		List transactionDataList=generateTransactionDataListFromPSA(psa);
		outputTransactionRecordReport(transactionDataList, "Ͷ�����_CCIָ��");
		// code name date_c saledate year days buy_price sale_price profit 
		
//		outputAccountRecordReport(psa); // ���account��ÿ��Ͷ�����ݣ��۸�仯���ֽ��ֵ/�ܼ�ֵ  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
		
//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, �׷������� 
		
	}
	
	// ģ��Ͷ�� - ����ָ����� WR42 ��ʱ
	public void processInvestmentByStrategy_wrzbfs(Map stockDataMap, String startDate, String endDate)
	{
		
		// ����һ������ģ���˻�
		PersonalStockAccount psa=new PersonalStockAccount();
		
		// ��òο��������ڶ���  - �л���������/��ʱ���ݵ�ʱ����
//		List dateList=CommonTool.getDateReferenceList(startDate, endDate);		// ����ָ֤���Ľ�������Ϊ�ο�ֵ
		List dateList=CommonTool.getDateReferenceList(startDate, endDate, 30);		// ����ָ֤���Ľ��׷�ʱΪ�ο�ֵ - ������
				
		// ���������accountDD_pre
 		AccountDayData accountDD_pre=new AccountDayData();  
		accountDD_pre.setCashValue(psa.investMoney);
		
		double lastSalePrice=0;  // ��һ���׳�ʱ�ļ۸�
		boolean isMACDChanged=false;   // ��һ���׳�������MACD 5>60�������Ƿ�ı�
		
		// ģ��ÿ�������ս���
		for (int i=0; i<dateList.size(); i++)
		{
			
			// ȡ��һ����������
			String transDate=dateList.get(i).toString();
			
			// ����һ�����յĽ����˻�����accountDD�����̳����յĳֲֺ��ֽ�
			AccountDayData accountDD=new AccountDayData();
			accountDD.setPosNum(i);
			accountDD.setDate(transDate);
			accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // �̳����յĳֲ�
			accountDD.setCashValue(accountDD_pre.getCashValue());	// �̳����յ��ֽ�
			
			// ��鵱ǰ�ֲֵĹ�Ʊ����״�����Ⱦ����Ƿ������������³ֲֹ�Ʊ�����ɳֲּ۸�
			List stockHoldList=accountDD.getStockHoldList();
			int stockHoldSize=stockHoldList.size();
			for (int j=stockHoldSize-1; j>=0; j--)
			{
				// ȡ��һ���ֹɶ���
				StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
				
				// ��ô˳ֹɵ���ʷ����
				String stockcode=shs.getCode();
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
				// ȡ���˹�ǰ���������
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
			
				
				if (sdd==null || sdd_b1==null || sdd_b2==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
				{
					shs.setCurDate(transDate);
					continue;
				}
				
				TransactionRecordData trd=new TransactionRecordData();
				StockDayData buySDD=shs.getBuySDD();
				
				double wr_wave=sdd.getWR10()-sdd_b1.getWR10();
				double wr_wave1=sdd_b1.getWR10()-sdd_b2.getWR10();
				double wr_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
				
				// ��ȡǰ���������
				List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
				List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);  
//				sdd_b1=(StockDayData)pastStockList.get(1);   // ��������ȡ��
						
				// �жϴ˹ɵ�ǰ���ƣ��Ƿ���ֳ������ƣ������Ƿ�����
				if ( 
//				(sdd_b2.getWR10()<30 && sdd_b1.getWR10()>30 ) &&
						
//				 (sdd_b1.getWR42()<50 && sdd.getWR42()>50) 
						
//				 ( 
//				 sdd.getDate().endsWith("7")  // ��14:30��������
//				 &&		 
//				 sdd.getWR42()>70	// �ڶ�����;���ַ����ϴ�30����, ���ֵ��Ȼ��Խ��Խ�ã���ΪԽ����Ա���󲨶�������;����³�
//				 ||
//				 sdd.getDate().endsWith("8")  // �ڶ�����������
//				 && checkPastdays_WR42_EndNumberRise(pastStockList)>30 
//				 ) 
//				 || 
				 
//				 || checkPastdays_WR42_TopNumber(pastStockList, 85)>2
				 ( checkPastdays_WR42_EndNumber(pastStockList5, 20)>0 && sdd.getWR42()>50 )
				 ||
				 ( checkPastdays_WR42_EndNumber(pastStockList5, 20)<0 && sdd.getWR42()>50 )
//				 sdd.getWR42()>50
//				 || wr_profit<-5
//				 (sdd.getHigh_rise()-sdd.getLow_rise()>4 && sdd.getReal_rise()<0) ||
//				 (!checkDayData_MA_dtpl_5_10(sdd_b1)) || (!checkDayData_MA_dtpl_10_20(sdd_b1)) ||
//				 (sdd_b1.getReal_rise()<0 && sdd.getReal_rise()<0 && sdd_b1.getClose_rise()+sdd.getClose_rise()<-5 ) ||  // ����˫��  

//				 (sdd.getReal_rise()<-5) ||  // �����������������ȴ���5%		
//				 (sdd.getReal_rise()<0 && (sdd.getLow()+sdd.getHigh())/2<sdd.getMa_20())   // ��������������λ�۵���20����
				 
//				 (sdd.getReal_rise()<0 && sdd.getHigh_rise()-sdd.getLow_rise()>5)   // ������������ߵ㵽���̵�������5%	
				 
//				  sdd.getWR100()<10 || sdd.getWR100()>50 
				
				)
				{
					// ������WR����ָ��
//					TransactionRecordData trd=new TransactionRecordData();
//					StockDayData buySDD=shs.getBuySDD();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(buySDD);
					trd.setSaleSDD(sdd);
					accountDD.saleTransList.add(trd);
					
					lastSalePrice=sdd.getClose();  // ��¼��һ������ʱ�ļ۸�
					
					// ����accountDD�ֲ��б�
					accountDD.stockHoldList.remove(j);
					
					// ����accountDD�ֽ��ֵ
					int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
					int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
				}
				else
				{
					// �粻�������ͼ������в��䣬���³ֲּ۸�
					shs.setCurDate(transDate);
					shs.setCurPrice(sdd.getClose());	
				}
				
			}
			
			
			// ����Ʊ���ﱸѡ�Ĺ�Ʊ����������پ����Ƿ����룬�����³ֲֹ�Ʊ
			Iterator it=stockDataMap.keySet().iterator();
			while(it.hasNext())
			{
				
				// �ӱ�ѡ��Ʊ����ȡ��һֻ��Ʊ
				String stockcode=it.next().toString();  
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
			
				if (checkStockHoldList(stockHoldList, stockcode)==true)  // ����Ѿ��ֹɣ�������������
				{
					continue;
				}
				
				// ȡ���˹�ǰ���������
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
//				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
//				StockDayData sdd_b3=CommonTool.getStockDayData(stockDataRecordList, transDate, -3);
//				StockDayData sdd_b4=CommonTool.getStockDayData(stockDataRecordList, transDate, -4);
//				StockDayData sdd_b5=CommonTool.getStockDayData(stockDataRecordList, transDate, -5);
//				StockDayData sdd_b6=CommonTool.getStockDayData(stockDataRecordList, transDate, -6);
//				StockDayData sdd_b7=CommonTool.getStockDayData(stockDataRecordList, transDate, -7);
//				StockDayData sdd_b8=CommonTool.getStockDayData(stockDataRecordList, transDate, -8);
//				StockDayData sdd_b9=CommonTool.getStockDayData(stockDataRecordList, transDate, -9);
//				StockDayData sdd_b10=CommonTool.getStockDayData(stockDataRecordList, transDate, -10);
//				StockDayData sdd_b11=CommonTool.getStockDayData(stockDataRecordList, transDate, -11);
//				StockDayData sdd_b12=CommonTool.getStockDayData(stockDataRecordList, transDate, -12);
//				StockDayData sdd_b13=CommonTool.getStockDayData(stockDataRecordList, transDate, -13);
//				StockDayData sdd_b14=CommonTool.getStockDayData(stockDataRecordList, transDate, -14);
//				StockDayData sdd_b15=CommonTool.getStockDayData(stockDataRecordList, transDate, -15);
				
				
//				if (sdd!=null && sdd_b1!=null)
//				{
//					System.out.println(sdd_b1.getName()+" "+sdd_b1.getCode()+" "+sdd_b1.getDate()+" "+sdd_b1.getClose());
//					System.out.println(sdd.getName()+" "+sdd.getCode()+" "+sdd.getDate()+" "+sdd.getClose());
//				}
				
				if (sdd==null || sdd_b1==null)
				{
					continue;
				}
				
//				if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null || sdd_b4==null || sdd_b5==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
//				{
//					continue;
//				}
//				
//				if (sdd_b6==null || sdd_b7==null || sdd_b8==null || sdd_b9==null)
//				{
//					continue;
//				}
//				
//				if (sdd_b10==null || sdd_b11==null || sdd_b12==null || sdd_b13==null || sdd_b14==null || sdd_b15==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
//				{
//					continue;
//				}
				
				// ��ȡǰ���������
				List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
				List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);
				List pastStockList15=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 15);
				List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
				List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
				List pastStockList100=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 100);
				
//				String dateb1=sdd_b1.getDate();   // debug����
//				System.out.println(dateb1);
//				if (sdd_b1.getDate().contains("2020/11/02"))
//				{
//					int t=1;
//					t++;
//				}
				
				
				// ����WR������������
//				if ( sdd_b1.getWR10()>90 && sdd_b1.getWR6()>90 )
				if ( 
//					sdd_b2.getWR6()>75 && sdd_b2.getWR6()-sdd_b1.getWR6()>10    // WR�´�10����
//					sdd_b2.getWR6()>50
//					sdd_b2.getWR6()<75 && sdd_b1.getWR6()>75    // WR�´�70
//					&& sdd_b1.getWR6()-sdd_b2.getWR6()>30
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_10()
//					&& !(sdd_b1.getMa_5()<sdd_b1.getMa_10() && sdd_b1.getMa_10()<sdd_b1.getMa_20())   // ��MACD��ͷ����
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_20()     
//					&& !(sdd_b1.getReal_rise()<0 && sdd_b2.getReal_rise()<0 && sdd_b3.getReal_rise()<0)   // ����������
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2) 


//					&& checkPastdaysWR42(transDate, -20, 90);  // ����transDate֮ǰ20�죬�Ƿ��г���90��ֵ
//					&& sdd_b1.getWR42()>85 
//					( checkPastdays_WR42_TopNumber(pastStockList, 85)==1 && checkPastdays_WR42_EndNumber(pastStockList1, 60)>=1 )
//					||
						
//					( 
//					sdd_b1.getDate().endsWith("7")  // ��14:30����
//					&&
//					checkPastdays_WR42_TopNumber(pastStockList20, 50)==0   // �ǴӸ�λ�´�							
//					&& 
//					checkPastdays_WR42_EndNumber(pastStockList40, 20)>=20   // ����ǰ��ν���WR42��20��������
//					&& 
//					sdd_b1.getWR42()<20 	// ����ʱWR42��20����
//					&&
//					sdd_b1.getWR100()<20
//					&& 
//					checkPastdays_WR42_EndNumberRise(pastStockList10)<-20
//					)
//					||
					( 
					checkPastdays_WR42_TopNumber(pastStockList10, 85)>=1
					&&
					checkPastdays_WR42_TopNumber(pastStockList5, 50)>=1
					&&
					sdd_b1.getWR42()<50
					)
					
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_60()
//					&& sdd_b4.getWR42()-sdd_b1.getWR42()>10
					
//					&& (sdd_b4.getWR42()-sdd_b1.getWR42()>15 || sdd.getOpen()>lastSalePrice) 
//					&& checkDayData_MA_dtpl(sdd_b2)
//					&& checkDayData_MA_dtpl(sdd_b3)
//					&& checkDayData_MA_dtpl(sdd_b4)
					
//					&& sdd_b6.getWR42()<50
//					&& sdd_b10.getWR42()-sdd_b6.getWR42()>15				
//					&& sdd_b6.getMa_5()>sdd_b6.getMa_60()     // �ǳ���Ҫ��һ����������׼ȷ������������̬	
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2)
//					&& checkDayData_MA_dtpl(sdd_b3)
//					&& checkDayData_MA_dtpl(sdd_b4)
//					&& checkDayData_MA_dtpl(sdd_b5)
					
//					&& sdd_b2.getWR100()>50 && sdd_b1.getWR100()<50    // WR100�´�50
						
					)
				{
					
					// �����ֶ�ͷ���У������룬����¼���뽻��
					TransactionRecordData trd=new TransactionRecordData();
					trd.setBuySDD(sdd);
					accountDD.buyTransList.add(trd);
					
					// ����accountDD�ֲ��б�
					StockHoldShare shs=new StockHoldShare();
					
					// ����������Ʊ����
//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
//					int amount=0;
//					if (accountDD.cashValue>eachStockInvestMoney)
//					{
//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // ʣ���ֽ��㹻Ͷ��һ�ݵ�ǰ��Ʊ
//					}
//					else
//					{
//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ𲻹�Ͷ��һ�ݵ�ǰ��Ʊ����ȫ������
//					}
					
					int amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ�ȫ������
					
					// ���������ĳֲֹ�Ʊ
					shs.setAmount(amount);
					shs.setCode(sdd.getCode());
					shs.setName(sdd.getName());
					shs.setBuyPrice(sdd.getOpen());
					shs.setBuyDate(sdd.getDate());
					shs.setCurPrice(sdd.getClose());
					shs.setCurDate(sdd.getDate());
					shs.setBuySDD(sdd);
					stockHoldList.add(shs);
					
					// ����accountDD�ֽ��ֵ
					int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
					int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
					
				}
				
			}
			
			// ���¸����˻���ÿ���˻���Ϣ
			Map accountDataMap=psa.getAccountDataMap();
			accountDataMap.put(transDate, accountDD);
			accountDD_pre=accountDD;
			
		}
			
		// ���Ͷ�ʽ��׼�¼��ģ�⽻�׽��仯���ߣ��Ա��������ײ���
		List transactionDataList=generateTransactionDataListFromPSA(psa);
		outputTransactionRecordReport(transactionDataList, "Ͷ�����_����ָ��");
		// code name date_c saledate year days buy_price sale_price profit 
		
//		outputAccountRecordReport(psa); // ���account��ÿ��Ͷ�����ݣ��۸�仯���ֽ��ֵ/�ܼ�ֵ  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
		
//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, �׷������� 
		
	}
	
	
	
	// ģ��Ͷ�� - ����ָ����� WR42
	public void processInvestmentByStrategy_wrzb(Map stockDataMap, String startDate, String endDate)
	{
		
		// ����һ������ģ���˻�
		PersonalStockAccount psa=new PersonalStockAccount();
		
		// ��òο��������ڶ���  - �л���������/��ʱ���ݵ�ʱ����
//		List dateList=CommonTool.getDateReferenceList(startDate, endDate);		// ����ָ֤���Ľ�������Ϊ�ο�ֵ
		List dateList=CommonTool.getDateReferenceList(startDate, endDate, 30);		// ����ָ֤���Ľ��׷�ʱΪ�ο�ֵ - ������
				
		// ���������accountDD_pre
 		AccountDayData accountDD_pre=new AccountDayData();  
		accountDD_pre.setCashValue(psa.investMoney);
		
		double lastSalePrice=0;  // ��һ���׳�ʱ�ļ۸�
		boolean isMACDChanged=false;   // ��һ���׳�������MACD 5>60�������Ƿ�ı�
		
		// ģ��ÿ�������ս���
		for (int i=0; i<dateList.size(); i++)
		{
			
			// ȡ��һ����������
			String transDate=dateList.get(i).toString();
			
			// ����һ�����յĽ����˻�����accountDD�����̳����յĳֲֺ��ֽ�
			AccountDayData accountDD=new AccountDayData();
			accountDD.setPosNum(i);
			accountDD.setDate(transDate);
			accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // �̳����յĳֲ�
			accountDD.setCashValue(accountDD_pre.getCashValue());	// �̳����յ��ֽ�
			
			// ��鵱ǰ�ֲֵĹ�Ʊ����״�����Ⱦ����Ƿ������������³ֲֹ�Ʊ�����ɳֲּ۸�
			List stockHoldList=accountDD.getStockHoldList();
			int stockHoldSize=stockHoldList.size();
			for (int j=stockHoldSize-1; j>=0; j--)
			{
				// ȡ��һ���ֹɶ���
				StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
				
				// ��ô˳ֹɵ���ʷ����
				String stockcode=shs.getCode();
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
				// ȡ���˹�ǰ���������
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
			
				
				if (sdd==null || sdd_b1==null || sdd_b2==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
				{
					shs.setCurDate(transDate);
					continue;
				}
				
				TransactionRecordData trd=new TransactionRecordData();
				StockDayData buySDD=shs.getBuySDD();
				
				double wr_wave=sdd.getWR10()-sdd_b1.getWR10();
				double wr_wave1=sdd_b1.getWR10()-sdd_b2.getWR10();
				double wr_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
				
				// ��ȡǰ���������
				List pastStockList=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
//				sdd_b1=(StockDayData)pastStockList.get(1);   // ��������ȡ��
						
				// �жϴ˹ɵ�ǰ���ƣ��Ƿ���ֳ������ƣ������Ƿ�����
				if ( 
//				(sdd_b2.getWR10()<30 && sdd_b1.getWR10()>30 ) &&
						
//				 (sdd_b1.getWR42()<50 && sdd.getWR42()>50) 
						
//				 ( 
//				 sdd.getDate().endsWith("7")  // ��14:30��������
//				 &&		 
				 sdd.getWR42()>70	// �ڶ�����;���ַ����ϴ�30����, ���ֵ��Ȼ��Խ��Խ�ã���ΪԽ����Ա���󲨶�������;����³�
//				 ||
//				 sdd.getDate().endsWith("8")  // �ڶ�����������
//				 && checkPastdays_WR42_EndNumberRise(pastStockList)>30 
//				 ) 
//				 || 
				 
//				 || checkPastdays_WR42_TopNumber(pastStockList, 85)>2
//				 sdd.getWR42()>50 
						
//				 || wr_profit<-5
//				 (sdd.getHigh_rise()-sdd.getLow_rise()>4 && sdd.getReal_rise()<0) ||
//				 (!checkDayData_MA_dtpl_5_10(sdd_b1)) || (!checkDayData_MA_dtpl_10_20(sdd_b1)) ||
//				 (sdd_b1.getReal_rise()<0 && sdd.getReal_rise()<0 && sdd_b1.getClose_rise()+sdd.getClose_rise()<-5 ) ||  // ����˫��  

//				 (sdd.getReal_rise()<-5) ||  // �����������������ȴ���5%		
//				 (sdd.getReal_rise()<0 && (sdd.getLow()+sdd.getHigh())/2<sdd.getMa_20())   // ��������������λ�۵���20����
				 
//				 (sdd.getReal_rise()<0 && sdd.getHigh_rise()-sdd.getLow_rise()>5)   // ������������ߵ㵽���̵�������5%	
				 
//				  sdd.getWR100()<10 || sdd.getWR100()>50 
				
				)
				{
					// ������WR����ָ��
//					TransactionRecordData trd=new TransactionRecordData();
//					StockDayData buySDD=shs.getBuySDD();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(buySDD);
					trd.setSaleSDD(sdd);
					accountDD.saleTransList.add(trd);
					
					lastSalePrice=sdd.getClose();  // ��¼��һ������ʱ�ļ۸�
					
					// ����accountDD�ֲ��б�
					accountDD.stockHoldList.remove(j);
					
					// ����accountDD�ֽ��ֵ
					int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
					int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
				}
				else
				{
					// �粻�������ͼ������в��䣬���³ֲּ۸�
					shs.setCurDate(transDate);
					shs.setCurPrice(sdd.getClose());	
				}
				
			}
			
			
			// ����Ʊ���ﱸѡ�Ĺ�Ʊ����������پ����Ƿ����룬�����³ֲֹ�Ʊ
			Iterator it=stockDataMap.keySet().iterator();
			while(it.hasNext())
			{
				
				// �ӱ�ѡ��Ʊ����ȡ��һֻ��Ʊ
				String stockcode=it.next().toString();  
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
			
				if (checkStockHoldList(stockHoldList, stockcode)==true)  // ����Ѿ��ֹɣ�������������
				{
					continue;
				}
				
				// ȡ���˹�ǰ���������
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
//				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
//				StockDayData sdd_b3=CommonTool.getStockDayData(stockDataRecordList, transDate, -3);
//				StockDayData sdd_b4=CommonTool.getStockDayData(stockDataRecordList, transDate, -4);
//				StockDayData sdd_b5=CommonTool.getStockDayData(stockDataRecordList, transDate, -5);
//				StockDayData sdd_b6=CommonTool.getStockDayData(stockDataRecordList, transDate, -6);
//				StockDayData sdd_b7=CommonTool.getStockDayData(stockDataRecordList, transDate, -7);
//				StockDayData sdd_b8=CommonTool.getStockDayData(stockDataRecordList, transDate, -8);
//				StockDayData sdd_b9=CommonTool.getStockDayData(stockDataRecordList, transDate, -9);
//				StockDayData sdd_b10=CommonTool.getStockDayData(stockDataRecordList, transDate, -10);
//				StockDayData sdd_b11=CommonTool.getStockDayData(stockDataRecordList, transDate, -11);
//				StockDayData sdd_b12=CommonTool.getStockDayData(stockDataRecordList, transDate, -12);
//				StockDayData sdd_b13=CommonTool.getStockDayData(stockDataRecordList, transDate, -13);
//				StockDayData sdd_b14=CommonTool.getStockDayData(stockDataRecordList, transDate, -14);
//				StockDayData sdd_b15=CommonTool.getStockDayData(stockDataRecordList, transDate, -15);
				
				
//				if (sdd!=null && sdd_b1!=null)
//				{
//					System.out.println(sdd_b1.getName()+" "+sdd_b1.getCode()+" "+sdd_b1.getDate()+" "+sdd_b1.getClose());
//					System.out.println(sdd.getName()+" "+sdd.getCode()+" "+sdd.getDate()+" "+sdd.getClose());
//				}
				
				if (sdd==null || sdd_b1==null)
				{
					continue;
				}
				
//				if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null || sdd_b4==null || sdd_b5==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
//				{
//					continue;
//				}
//				
//				if (sdd_b6==null || sdd_b7==null || sdd_b8==null || sdd_b9==null)
//				{
//					continue;
//				}
//				
//				if (sdd_b10==null || sdd_b11==null || sdd_b12==null || sdd_b13==null || sdd_b14==null || sdd_b15==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
//				{
//					continue;
//				}
				
				// ��ȡǰ���������
				List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
				List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);
				List pastStockList15=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 15);
				List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
				List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
				List pastStockList100=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 100);
				
//				String dateb1=sdd_b1.getDate();   // debug����
//				System.out.println(dateb1);
//				if (sdd_b1.getDate().contains("2020/11/02"))
//				{
//					int t=1;
//					t++;
//				}
				
				
				// ����WR������������
//				if ( sdd_b1.getWR10()>90 && sdd_b1.getWR6()>90 )
				if ( 
//					sdd_b2.getWR6()>75 && sdd_b2.getWR6()-sdd_b1.getWR6()>10    // WR�´�10����
//					sdd_b2.getWR6()>50
//					sdd_b2.getWR6()<75 && sdd_b1.getWR6()>75    // WR�´�70
//					&& sdd_b1.getWR6()-sdd_b2.getWR6()>30
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_10()
//					&& !(sdd_b1.getMa_5()<sdd_b1.getMa_10() && sdd_b1.getMa_10()<sdd_b1.getMa_20())   // ��MACD��ͷ����
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_20()     
//					&& !(sdd_b1.getReal_rise()<0 && sdd_b2.getReal_rise()<0 && sdd_b3.getReal_rise()<0)   // ����������
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2) 


//					&& checkPastdaysWR42(transDate, -20, 90);  // ����transDate֮ǰ20�죬�Ƿ��г���90��ֵ
//					&& sdd_b1.getWR42()>85 
//					( checkPastdays_WR42_TopNumber(pastStockList, 85)==1 && checkPastdays_WR42_EndNumber(pastStockList1, 60)>=1 )
//					||
						
					( 
//					sdd_b1.getDate().endsWith("7")  // ��14:30����
//					&&
//					checkPastdays_WR42_TopNumber(pastStockList20, 50)==0   // �ǴӸ�λ�´�							
//					&& 
//					checkPastdays_WR42_EndNumber(pastStockList40, 20)>=20   // ����ǰ��ν���WR42��20��������
//					&& 
					sdd_b1.getWR42()<20 	// ����ʱWR42��20����
					&&
					sdd_b1.getWR100()<20
//					&& 
//					checkPastdays_WR42_EndNumberRise(pastStockList10)<-20
					)
//					||
//					( 
//					checkPastdays_WR42_TopNumber(pastStockList5, 80)==1
//					&&
//					sdd_b1.getWR42()<50
//					)
					
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_60()
//					&& sdd_b4.getWR42()-sdd_b1.getWR42()>10
					
//					&& (sdd_b4.getWR42()-sdd_b1.getWR42()>15 || sdd.getOpen()>lastSalePrice) 
//					&& checkDayData_MA_dtpl(sdd_b2)
//					&& checkDayData_MA_dtpl(sdd_b3)
//					&& checkDayData_MA_dtpl(sdd_b4)
					
//					&& sdd_b6.getWR42()<50
//					&& sdd_b10.getWR42()-sdd_b6.getWR42()>15				
//					&& sdd_b6.getMa_5()>sdd_b6.getMa_60()     // �ǳ���Ҫ��һ����������׼ȷ������������̬	
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2)
//					&& checkDayData_MA_dtpl(sdd_b3)
//					&& checkDayData_MA_dtpl(sdd_b4)
//					&& checkDayData_MA_dtpl(sdd_b5)
					
//					&& sdd_b2.getWR100()>50 && sdd_b1.getWR100()<50    // WR100�´�50
						
					)
				{
					
					// �����ֶ�ͷ���У������룬����¼���뽻��
					TransactionRecordData trd=new TransactionRecordData();
					trd.setBuySDD(sdd);
					accountDD.buyTransList.add(trd);
					
					// ����accountDD�ֲ��б�
					StockHoldShare shs=new StockHoldShare();
					
					// ����������Ʊ����
//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
//					int amount=0;
//					if (accountDD.cashValue>eachStockInvestMoney)
//					{
//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // ʣ���ֽ��㹻Ͷ��һ�ݵ�ǰ��Ʊ
//					}
//					else
//					{
//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ𲻹�Ͷ��һ�ݵ�ǰ��Ʊ����ȫ������
//					}
					
					int amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ�ȫ������
					
					// ���������ĳֲֹ�Ʊ
					shs.setAmount(amount);
					shs.setCode(sdd.getCode());
					shs.setName(sdd.getName());
					shs.setBuyPrice(sdd.getOpen());
					shs.setBuyDate(sdd.getDate());
					shs.setCurPrice(sdd.getClose());
					shs.setCurDate(sdd.getDate());
					shs.setBuySDD(sdd);
					stockHoldList.add(shs);
					
					// ����accountDD�ֽ��ֵ
					int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
					int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
					
				}
				
			}
			
			// ���¸����˻���ÿ���˻���Ϣ
			Map accountDataMap=psa.getAccountDataMap();
			accountDataMap.put(transDate, accountDD);
			accountDD_pre=accountDD;
			
		}
			
		// ���Ͷ�ʽ��׼�¼��ģ�⽻�׽��仯���ߣ��Ա��������ײ���
		List transactionDataList=generateTransactionDataListFromPSA(psa);
		outputTransactionRecordReport(transactionDataList, "Ͷ�����_����ָ��");
		// code name date_c saledate year days buy_price sale_price profit 
		
//		outputAccountRecordReport(psa); // ���account��ÿ��Ͷ�����ݣ��۸�仯���ֽ��ֵ/�ܼ�ֵ  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
		
//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, �׷������� 
		
	}
	
	
	
	
	// ģ��Ͷ�� - ����ָ�곭�׸Ľ����� WR10
	public void processInvestmentByStrategy_wrzbcdgj(Map stockDataMap, String startDate, String endDate)
	{
		
		// ����һ������ģ���˻�
		PersonalStockAccount psa=new PersonalStockAccount();
		
		// ��òο��������ڶ���
		List dateList=CommonTool.getDateReferenceList(startDate, endDate);		
		
		// ���������accountDD_pre
		AccountDayData accountDD_pre=new AccountDayData();  
		accountDD_pre.setCashValue(psa.investMoney);
		
		double lastSalePrice=0;  // ��һ���׳�ʱ�ļ۸�
		boolean isMACDChanged=false;   // ��һ���׳�������MACD 5>60�������Ƿ�ı�
		
		// ģ��ÿ�������ս���
		for (int i=0; i<dateList.size(); i++)
		{
			
			// ȡ��һ����������
			String transDate=dateList.get(i).toString();
			
			// ����һ�����յĽ����˻�����accountDD�����̳����յĳֲֺ��ֽ�
			AccountDayData accountDD=new AccountDayData();
			accountDD.setPosNum(i);
			accountDD.setDate(transDate);
			accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // �̳����յĳֲ�
			accountDD.setCashValue(accountDD_pre.getCashValue());	// �̳����յ��ֽ�
			
			// ��鵱ǰ�ֲֵĹ�Ʊ����״�����Ⱦ����Ƿ������������³ֲֹ�Ʊ�����ɳֲּ۸�
			List stockHoldList=accountDD.getStockHoldList();
			int stockHoldSize=stockHoldList.size();
			for (int j=stockHoldSize-1; j>=0; j--)
			{
				// ȡ��һ���ֹɶ���
				StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
				
				// ��ô˳ֹɵ���ʷ����
				String stockcode=shs.getCode();
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
				// ȡ���˹�ǰ���������
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
			
				
				if (sdd==null || sdd_b1==null || sdd_b2==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
				{
					shs.setCurDate(transDate);
					continue;
				}
				
				TransactionRecordData trd=new TransactionRecordData();
				StockDayData buySDD=shs.getBuySDD();
				
				double wr_wave=sdd.getWR10()-sdd_b1.getWR10();
				double wr_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
				// �жϴ˹ɵ�ǰ���ƣ��Ƿ���ֳ������ƣ������Ƿ�����
				if (
				
				 wr_profit<-10   // ֹ���
				 || (wr_wave>0)  // ����WR��������
//				 (sdd_b1.getWR10()<40 && sdd.getWR10()>40)  // ����WR��������
//				 || (sdd_b2.getWR10()<40 && sdd_b1.getWR10()>40)  // ����WR��������
//				 || (sdd.getReal_rise()<-5)   // �����������������ȴ���5%		
//				 (sdd.getReal_rise()<0 && (sdd.getLow()+sdd.getHigh())/2<sdd.getMa_20())  // ��������������λ�۵���20����

//				 ||(checkDayData_MA_ktpl(sdd_b1))
//				 ||(sdd.getWR10()>80)
//				 ||(sdd.getClose()<sdd.getMa_5()&&sdd.getClose()<sdd.getMa_10()&&sdd.getClose()<sdd.getMa_20()&&sdd.getClose()<sdd.getMa_60() )
//				 && sdd_b1.getWR10()<40
//				(sdd_b2.getWR10()<30 && sdd_b1.getWR10()>30 ) &&
//				 sdd_b1.getWR6()<50 && sdd.getWR6()>50 
//				 (sdd.getHigh_rise()-sdd.getLow_rise()>4 && sdd.getReal_rise()<0) ||
//				 (!checkDayData_MA_dtpl_5_10(sdd_b1)) || (!checkDayData_MA_dtpl_10_20(sdd_b1)) ||
//				 (sdd_b1.getReal_rise()<0 && sdd.getReal_rise()<0 && sdd_b1.getClose_rise()+sdd.getClose_rise()<-5 ) ||  // ����˫��  

//				 (sdd.getReal_rise()<-5) ||  // �����������������ȴ���5%		
//				 (sdd.getReal_rise()<0 && sdd.getHigh_rise()-sdd.getClose_rise()>5) ||  // ������������ߵ㵽���̵�������5%	
//				 (sdd.getReal_rise()<0 && (sdd.getLow()+sdd.getHigh())/2<sdd.getMa_20())  // ��������������λ�۵���20����
				 
//				  sdd.getWR100()<10 || sdd.getWR100()>50 
				
				)
				{
					// ������WR����ָ��

					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(buySDD);
					trd.setSaleSDD(sdd);
					accountDD.saleTransList.add(trd);
					
					lastSalePrice=sdd.getClose();  // ��¼��һ������ʱ�ļ۸�
					
					// ����accountDD�ֲ��б�
					accountDD.stockHoldList.remove(j);
					
					// ����accountDD�ֽ��ֵ
					int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
					int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
				}
				else
				{
					// �粻�������ͼ������в��䣬���³ֲּ۸�
					shs.setCurDate(transDate);
					shs.setCurPrice(sdd.getClose());	
				}
				
			}
			
			
			// ����Ʊ���ﱸѡ�Ĺ�Ʊ����������پ����Ƿ����룬�����³ֲֹ�Ʊ
			Iterator it=stockDataMap.keySet().iterator();
			while(it.hasNext())
			{
				
				// �ӱ�ѡ��Ʊ����ȡ��һֻ��Ʊ
				String stockcode=it.next().toString();  
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
			
				if (checkStockHoldList(stockHoldList, stockcode)==true)  // ����Ѿ��ֹɣ�������������
				{
					continue;
				}
				
				// ȡ���˹�ǰ���������
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
				StockDayData sdd_b3=CommonTool.getStockDayData(stockDataRecordList, transDate, -3);
				StockDayData sdd_b4=CommonTool.getStockDayData(stockDataRecordList, transDate, -4);
				StockDayData sdd_b5=CommonTool.getStockDayData(stockDataRecordList, transDate, -5);
				StockDayData sdd_b6=CommonTool.getStockDayData(stockDataRecordList, transDate, -6);
				StockDayData sdd_b7=CommonTool.getStockDayData(stockDataRecordList, transDate, -7);
				StockDayData sdd_b8=CommonTool.getStockDayData(stockDataRecordList, transDate, -8);
				StockDayData sdd_b9=CommonTool.getStockDayData(stockDataRecordList, transDate, -9);
				StockDayData sdd_b10=CommonTool.getStockDayData(stockDataRecordList, transDate, -10);
				StockDayData sdd_b11=CommonTool.getStockDayData(stockDataRecordList, transDate, -11);
				StockDayData sdd_b12=CommonTool.getStockDayData(stockDataRecordList, transDate, -12);
				StockDayData sdd_b13=CommonTool.getStockDayData(stockDataRecordList, transDate, -13);
				StockDayData sdd_b14=CommonTool.getStockDayData(stockDataRecordList, transDate, -14);
				StockDayData sdd_b15=CommonTool.getStockDayData(stockDataRecordList, transDate, -15);
				
//				if (sdd!=null && sdd_b1!=null)
//				{
//					System.out.println(sdd_b1.getName()+" "+sdd_b1.getCode()+" "+sdd_b1.getDate()+" "+sdd_b1.getClose());
//					System.out.println(sdd.getName()+" "+sdd.getCode()+" "+sdd.getDate()+" "+sdd.getClose());
//				}
				
				if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null || sdd_b4==null || sdd_b5==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
				{
					continue;
				}
				
				if (sdd_b6==null || sdd_b7==null || sdd_b8==null || sdd_b9==null)
				{
					continue;
				}
				
				if (sdd_b10==null || sdd_b11==null || sdd_b12==null || sdd_b13==null || sdd_b14==null || sdd_b15==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
				{
					continue;
				}
				
				// ����WR������������
//				if ( sdd_b1.getWR10()>90 && sdd_b1.getWR6()>90 )
				double wr_value1=sdd_b2.getWR10();
				double wr_wave1=sdd_b2.getWR10()-sdd_b1.getWR10();
				double rise_wave1=sdd_b1.getClose_rise();
				double wr_speed1=(rise_wave1/wr_wave1)*100;  // ���磺���10*100/20=50, ��С0/100=0, ��ͨ2*100/40=5��ԽСԽ��
				
				double wr_value2=sdd_b3.getWR10();
				double wr_wave2=sdd_b3.getWR10()-sdd_b1.getWR10();
				double rise_wave2=sdd_b2.getClose_rise()+sdd_b1.getClose_rise();
				double wr_speed2=(rise_wave2/wr_wave2)*100;  // ���磺���10*100/20=50, ��С0/100=0, ��ͨ2*100/40=5��ԽСԽ��

				if ( 1>0
					&& 
					(
					(
					1>0
					&& wr_value1>90
					&& wr_wave1>5
					&& !checkDayData_MA_ktpl(sdd_b1)
//					&& wr_wave1>30 
//					&& wr_speed1<20
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_60()
					)
//					||
//					(
//					1>0
////					&& wr_value2>80 
//					&& wr_wave2>30 
////					&& wr_speed2<10
//					)
					)
//					sdd_b2.getWR6()>75 && sdd_b2.getWR6()-sdd_b1.getWR6()>10    // WR�´�10����
//					sdd_b2.getWR6()>50
//					sdd_b2.getWR6()<75 && sdd_b1.getWR6()>75    // WR�´�70
//					&& sdd_b1.getWR6()-sdd_b2.getWR6()>30
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_10()
//					&& !(sdd_b1.getMa_5()<sdd_b1.getMa_10() && sdd_b1.getMa_10()<sdd_b1.getMa_20())   // ��MACD��ͷ����
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_20()     
//					&& !(sdd_b1.getReal_rise()<0 && sdd_b2.getReal_rise()<0 && sdd_b3.getReal_rise()<0)   // ����������
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2) 


//					&& checkPastdaysWR42(transDate, -20, 90);  // ����transDate֮ǰ20�죬�Ƿ��г���90��ֵ
//					&& sdd_b1.getWR42()<50
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_60()
//					&& sdd_b4.getWR42()-sdd_b1.getWR42()>10
//					&& (sdd_b4.getWR42()-sdd_b1.getWR42()>15 || sdd.getOpen()>lastSalePrice) 
//					&& checkDayData_MA_dtpl(sdd_b2)
//					&& checkDayData_MA_dtpl(sdd_b3)
//					&& checkDayData_MA_dtpl(sdd_b4)
					
//					&& sdd_b6.getWR42()<50
//					&& sdd_b10.getWR42()-sdd_b6.getWR42()>15				
//					&& sdd_b6.getMa_5()>sdd_b6.getMa_60()     // �ǳ���Ҫ��һ����������׼ȷ������������̬	
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2)
//					&& checkDayData_MA_dtpl(sdd_b3)
//					&& checkDayData_MA_dtpl(sdd_b4)
//					&& checkDayData_MA_dtpl(sdd_b5)
					
//					&& sdd_b2.getWR100()>50 && sdd_b1.getWR100()<50    // WR100�´�50
						
					)
				{
					
					// �����ֶ�ͷ���У������룬����¼���뽻��
					TransactionRecordData trd=new TransactionRecordData();
					trd.setBuySDD(sdd);
					accountDD.buyTransList.add(trd);
					
					// ����accountDD�ֲ��б�
					StockHoldShare shs=new StockHoldShare();
					
					// ����������Ʊ����
//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
//					int amount=0;
//					if (accountDD.cashValue>eachStockInvestMoney)
//					{
//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // ʣ���ֽ��㹻Ͷ��һ�ݵ�ǰ��Ʊ
//					}
//					else
//					{
//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ𲻹�Ͷ��һ�ݵ�ǰ��Ʊ����ȫ������
//					}
					
					int amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ�ȫ������
					
					// ���������ĳֲֹ�Ʊ
					shs.setAmount(amount);
					shs.setCode(sdd.getCode());
					shs.setName(sdd.getName());
					shs.setBuyPrice(sdd.getOpen());
					shs.setBuyDate(sdd.getDate());
					shs.setCurPrice(sdd.getClose());
					shs.setCurDate(sdd.getDate());
					shs.setBuySDD(sdd);
					stockHoldList.add(shs);
					
					// ����accountDD�ֽ��ֵ
					int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
					int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
					
				}
				
			}
			
			// ���¸����˻���ÿ���˻���Ϣ
			Map accountDataMap=psa.getAccountDataMap();
			accountDataMap.put(transDate, accountDD);
			accountDD_pre=accountDD;
			
		}
			
		// ���Ͷ�ʽ��׼�¼��ģ�⽻�׽��仯���ߣ��Ա��������ײ���
		List transactionDataList=generateTransactionDataListFromPSA(psa);
		outputTransactionRecordReport(transactionDataList, "Ͷ�����_����ָ�곭�׸Ľ�");
		// code name date_c saledate year days buy_price sale_price profit 
		
//		outputAccountRecordReport(psa); // ���account��ÿ��Ͷ�����ݣ��۸�仯���ֽ��ֵ/�ܼ�ֵ  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
		
//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, �׷������� 
		
	}
	
	
	// ģ��Ͷ�� - ����ָ�곭�ײ��� WR10
	public void processInvestmentByStrategy_wrzbcd(Map stockDataMap, String startDate, String endDate)
	{
		
		// ����һ������ģ���˻�
		PersonalStockAccount psa=new PersonalStockAccount();
		
		// ��òο��������ڶ���
		List dateList=CommonTool.getDateReferenceList(startDate, endDate);		
		
		// ���������accountDD_pre
		AccountDayData accountDD_pre=new AccountDayData();  
		accountDD_pre.setCashValue(psa.investMoney);
		
		double lastSalePrice=0;  // ��һ���׳�ʱ�ļ۸�
		boolean isMACDChanged=false;   // ��һ���׳�������MACD 5>60�������Ƿ�ı�
		
		// ģ��ÿ�������ս���
		for (int i=0; i<dateList.size(); i++)
		{
			
			// ȡ��һ����������
			String transDate=dateList.get(i).toString();
			
			// ����һ�����յĽ����˻�����accountDD�����̳����յĳֲֺ��ֽ�
			AccountDayData accountDD=new AccountDayData();
			accountDD.setPosNum(i);
			accountDD.setDate(transDate);
			accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // �̳����յĳֲ�
			accountDD.setCashValue(accountDD_pre.getCashValue());	// �̳����յ��ֽ�
			
			// ��鵱ǰ�ֲֵĹ�Ʊ����״�����Ⱦ����Ƿ������������³ֲֹ�Ʊ�����ɳֲּ۸�
			List stockHoldList=accountDD.getStockHoldList();
			int stockHoldSize=stockHoldList.size();
			for (int j=stockHoldSize-1; j>=0; j--)
			{
				// ȡ��һ���ֹɶ���
				StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
				
				// ��ô˳ֹɵ���ʷ����
				String stockcode=shs.getCode();
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
				// ȡ���˹�ǰ���������
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
			
				
				if (sdd==null || sdd_b1==null || sdd_b2==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
				{
					shs.setCurDate(transDate);
					continue;
				}
				
				TransactionRecordData trd=new TransactionRecordData();
				StockDayData buySDD=shs.getBuySDD();
				
				double wr_wave=sdd.getWR10()-sdd_b1.getWR10();
				double wr_wave1=sdd_b1.getWR10()-sdd_b2.getWR10();
				double wr_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
				// �жϴ˹ɵ�ǰ���ƣ��Ƿ���ֳ������ƣ������Ƿ�����
				if (
				
				 wr_profit<-10   // ֹ���
				 || (wr_wave1>0 && sdd_b1.getWR10()>50)
//				 || (sdd_b1.getWR10()<40 && sdd.getWR10()>40)  // ����WR��������
				 || (sdd_b2.getWR10()<40 && sdd_b1.getWR10()>40)  // ����WR��������
//				 || (sdd.getReal_rise()<-5)   // �����������������ȴ���5%		
//				 (sdd.getReal_rise()<0 && (sdd.getLow()+sdd.getHigh())/2<sdd.getMa_20())  // ��������������λ�۵���20����

//				 ||(checkDayData_MA_ktpl(sdd_b1))
//				 ||(sdd.getWR10()>80)
//				 ||(sdd.getClose()<sdd.getMa_5()&&sdd.getClose()<sdd.getMa_10()&&sdd.getClose()<sdd.getMa_20()&&sdd.getClose()<sdd.getMa_60() )
//				 && sdd_b1.getWR10()<40
//				(sdd_b2.getWR10()<30 && sdd_b1.getWR10()>30 ) &&
//				 sdd_b1.getWR6()<50 && sdd.getWR6()>50 
//				 (sdd.getHigh_rise()-sdd.getLow_rise()>4 && sdd.getReal_rise()<0) ||
//				 (!checkDayData_MA_dtpl_5_10(sdd_b1)) || (!checkDayData_MA_dtpl_10_20(sdd_b1)) ||
//				 (sdd_b1.getReal_rise()<0 && sdd.getReal_rise()<0 && sdd_b1.getClose_rise()+sdd.getClose_rise()<-5 ) ||  // ����˫��  

//				 (sdd.getReal_rise()<-5) ||  // �����������������ȴ���5%		
//				 (sdd.getReal_rise()<0 && sdd.getHigh_rise()-sdd.getClose_rise()>5) ||  // ������������ߵ㵽���̵�������5%	
//				 (sdd.getReal_rise()<0 && (sdd.getLow()+sdd.getHigh())/2<sdd.getMa_20())  // ��������������λ�۵���20����
				 
//				  sdd.getWR100()<10 || sdd.getWR100()>50 
				
				)
				{
					// ������WR����ָ��

					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(buySDD);
					trd.setSaleSDD(sdd);
					accountDD.saleTransList.add(trd);
					
					lastSalePrice=sdd.getClose();  // ��¼��һ������ʱ�ļ۸�
					
					// ����accountDD�ֲ��б�
					accountDD.stockHoldList.remove(j);
					
					// ����accountDD�ֽ��ֵ
					int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
					int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
				}
				else
				{
					// �粻�������ͼ������в��䣬���³ֲּ۸�
					shs.setCurDate(transDate);
					shs.setCurPrice(sdd.getClose());	
				}
				
			}
			
			
			// ����Ʊ���ﱸѡ�Ĺ�Ʊ����������پ����Ƿ����룬�����³ֲֹ�Ʊ
			Iterator it=stockDataMap.keySet().iterator();
			while(it.hasNext())
			{
				
				// �ӱ�ѡ��Ʊ����ȡ��һֻ��Ʊ
				String stockcode=it.next().toString();  
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
			
				if (checkStockHoldList(stockHoldList, stockcode)==true)  // ����Ѿ��ֹɣ�������������
				{
					continue;
				}
				
				// ȡ���˹�ǰ���������
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
				StockDayData sdd_b3=CommonTool.getStockDayData(stockDataRecordList, transDate, -3);
				StockDayData sdd_b4=CommonTool.getStockDayData(stockDataRecordList, transDate, -4);
				StockDayData sdd_b5=CommonTool.getStockDayData(stockDataRecordList, transDate, -5);
				StockDayData sdd_b6=CommonTool.getStockDayData(stockDataRecordList, transDate, -6);
				StockDayData sdd_b7=CommonTool.getStockDayData(stockDataRecordList, transDate, -7);
				StockDayData sdd_b8=CommonTool.getStockDayData(stockDataRecordList, transDate, -8);
				StockDayData sdd_b9=CommonTool.getStockDayData(stockDataRecordList, transDate, -9);
				StockDayData sdd_b10=CommonTool.getStockDayData(stockDataRecordList, transDate, -10);
				StockDayData sdd_b11=CommonTool.getStockDayData(stockDataRecordList, transDate, -11);
				StockDayData sdd_b12=CommonTool.getStockDayData(stockDataRecordList, transDate, -12);
				StockDayData sdd_b13=CommonTool.getStockDayData(stockDataRecordList, transDate, -13);
				StockDayData sdd_b14=CommonTool.getStockDayData(stockDataRecordList, transDate, -14);
				StockDayData sdd_b15=CommonTool.getStockDayData(stockDataRecordList, transDate, -15);
				
//				if (sdd!=null && sdd_b1!=null)
//				{
//					System.out.println(sdd_b1.getName()+" "+sdd_b1.getCode()+" "+sdd_b1.getDate()+" "+sdd_b1.getClose());
//					System.out.println(sdd.getName()+" "+sdd.getCode()+" "+sdd.getDate()+" "+sdd.getClose());
//				}
				
				if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null || sdd_b4==null || sdd_b5==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
				{
					continue;
				}
				
				if (sdd_b6==null || sdd_b7==null || sdd_b8==null || sdd_b9==null)
				{
					continue;
				}
				
				if (sdd_b10==null || sdd_b11==null || sdd_b12==null || sdd_b13==null || sdd_b14==null || sdd_b15==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
				{
					continue;
				}
				
				// ����WR������������
//				if ( sdd_b1.getWR10()>90 && sdd_b1.getWR6()>90 )
				double wr_value1=sdd_b2.getWR10();
				double wr_wave1=sdd_b2.getWR10()-sdd_b1.getWR10();
				double rise_wave1=sdd_b1.getClose_rise();
				double wr_speed1=(rise_wave1/wr_wave1)*100;  // ���磺���10*100/20=50, ��С0/100=0, ��ͨ2*100/40=5��ԽСԽ��
				
				double wr_value2=sdd_b3.getWR10();
				double wr_wave2=sdd_b3.getWR10()-sdd_b1.getWR10();
				double rise_wave2=sdd_b2.getClose_rise()+sdd_b1.getClose_rise();
				double wr_speed2=(rise_wave2/wr_wave2)*100;  // ���磺���10*100/20=50, ��С0/100=0, ��ͨ2*100/40=5��ԽСԽ��

				if ( 1>0
					&& 
					(
					(
					1>0
//					&& wr_value1>80 
					&& wr_wave1>30 
//					&& wr_speed1<20
					&& sdd_b1.getClose()>sdd_b1.getMa_60()
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_60()
					)
//					||
//					(
//					1>0
////					&& wr_value2>80 
//					&& wr_wave2>30 
////					&& wr_speed2<10
//					)
					)
//					sdd_b2.getWR6()>75 && sdd_b2.getWR6()-sdd_b1.getWR6()>10    // WR�´�10����
//					sdd_b2.getWR6()>50
//					sdd_b2.getWR6()<75 && sdd_b1.getWR6()>75    // WR�´�70
//					&& sdd_b1.getWR6()-sdd_b2.getWR6()>30
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_10()
//					&& !(sdd_b1.getMa_5()<sdd_b1.getMa_10() && sdd_b1.getMa_10()<sdd_b1.getMa_20())   // ��MACD��ͷ����
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_20()     
//					&& !(sdd_b1.getReal_rise()<0 && sdd_b2.getReal_rise()<0 && sdd_b3.getReal_rise()<0)   // ����������
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2) 


//					&& checkPastdaysWR42(transDate, -20, 90);  // ����transDate֮ǰ20�죬�Ƿ��г���90��ֵ
//					&& sdd_b1.getWR42()<50
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_60()
//					&& sdd_b4.getWR42()-sdd_b1.getWR42()>10
//					&& (sdd_b4.getWR42()-sdd_b1.getWR42()>15 || sdd.getOpen()>lastSalePrice) 
//					&& checkDayData_MA_dtpl(sdd_b2)
//					&& checkDayData_MA_dtpl(sdd_b3)
//					&& checkDayData_MA_dtpl(sdd_b4)
					
//					&& sdd_b6.getWR42()<50
//					&& sdd_b10.getWR42()-sdd_b6.getWR42()>15				
//					&& sdd_b6.getMa_5()>sdd_b6.getMa_60()     // �ǳ���Ҫ��һ����������׼ȷ������������̬	
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2)
//					&& checkDayData_MA_dtpl(sdd_b3)
//					&& checkDayData_MA_dtpl(sdd_b4)
//					&& checkDayData_MA_dtpl(sdd_b5)
					
//					&& sdd_b2.getWR100()>50 && sdd_b1.getWR100()<50    // WR100�´�50
						
					)
				{
					
					// �����ֶ�ͷ���У������룬����¼���뽻��
					TransactionRecordData trd=new TransactionRecordData();
					trd.setBuySDD(sdd);
					accountDD.buyTransList.add(trd);
					
					// ����accountDD�ֲ��б�
					StockHoldShare shs=new StockHoldShare();
					
					// ����������Ʊ����
//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
//					int amount=0;
//					if (accountDD.cashValue>eachStockInvestMoney)
//					{
//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // ʣ���ֽ��㹻Ͷ��һ�ݵ�ǰ��Ʊ
//					}
//					else
//					{
//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ𲻹�Ͷ��һ�ݵ�ǰ��Ʊ����ȫ������
//					}
					
					int amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ�ȫ������
					
					// ���������ĳֲֹ�Ʊ
					shs.setAmount(amount);
					shs.setCode(sdd.getCode());
					shs.setName(sdd.getName());
					shs.setBuyPrice(sdd.getOpen());
					shs.setBuyDate(sdd.getDate());
					shs.setCurPrice(sdd.getClose());
					shs.setCurDate(sdd.getDate());
					shs.setBuySDD(sdd);
					stockHoldList.add(shs);
					
					// ����accountDD�ֽ��ֵ
					int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
					int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
					
				}
				
			}
			
			// ���¸����˻���ÿ���˻���Ϣ
			Map accountDataMap=psa.getAccountDataMap();
			accountDataMap.put(transDate, accountDD);
			accountDD_pre=accountDD;
			
		}
			
		// ���Ͷ�ʽ��׼�¼��ģ�⽻�׽��仯���ߣ��Ա��������ײ���
		List transactionDataList=generateTransactionDataListFromPSA(psa);
		outputTransactionRecordReport(transactionDataList, "Ͷ�����_����ָ�곭��");
		// code name date_c saledate year days buy_price sale_price profit 
		
//		outputAccountRecordReport(psa); // ���account��ÿ��Ͷ�����ݣ��۸�仯���ֽ��ֵ/�ܼ�ֵ  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
		
//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, �׷������� 
		
	}
	
	

	
	
	// ģ��Ͷ�� - ��ͷ���в���
	public void processInvestmentByStrategy_dtpl(Map stockDataMap, String startDate, String endDate)
	{
		
		// ����һ������ģ���˻�
		PersonalStockAccount psa=new PersonalStockAccount();
		
		// ��òο��������ڶ���
		List dateList=CommonTool.getDateReferenceList(startDate, endDate);		
		
		// ���������accountDD_pre
		AccountDayData accountDD_pre=new AccountDayData();  
		accountDD_pre.setCashValue(psa.investMoney);
		
		// ģ��ÿ�������ս���
		for (int i=0; i<dateList.size(); i++)
		{
			
			// ȡ��һ����������
			String transDate=dateList.get(i).toString();
			
			// ����һ�����յĽ����˻�����accountDD�����̳����յĳֲֺ��ֽ�
			AccountDayData accountDD=new AccountDayData();
			accountDD.setPosNum(i);
			accountDD.setDate(transDate);
			accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // �̳����յĳֲ�
			accountDD.setCashValue(accountDD_pre.getCashValue());	// �̳����յ��ֽ�
			
			// ��鵱ǰ�ֲֵĹ�Ʊ����״�����Ⱦ����Ƿ������������³ֲֹ�Ʊ�����ɳֲּ۸�
			List stockHoldList=accountDD.getStockHoldList();
			int stockHoldSize=stockHoldList.size();
			for (int j=stockHoldSize-1; j>=0; j--)
			{
				// ȡ��һ���ֹɶ���
				StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
				
				// ��ô˳ֹɵ���ʷ����
				String stockcode=shs.getCode();
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
				// ȡ���˹�ǰ���������
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
				
				if (sdd==null || sdd_b1==null || sdd_b2==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
				{
					shs.setCurDate(transDate);
					continue;
				}
				
				// �жϴ˹ɵ�ǰ���ƣ������Ƿ�����
//				if (sdd_b1.getReal_rise()<0 && sdd.getOpen_rise()<0) 
				if (checkDayData_MA_dtpl_10_20(sdd_b2) && !checkDayData_MA_dtpl_10_20(sdd_b1))
//				if (checkDayData_MA_dtpl_5_10(sdd_b2) && !checkDayData_MA_dtpl_5_10(sdd_b1))
				{
					// ����������������������¼��������
					TransactionRecordData trd=new TransactionRecordData();
					StockDayData buySDD=shs.getBuySDD();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(buySDD);
					trd.setSaleSDD(sdd);
					accountDD.saleTransList.add(trd);
					
					// ����accountDD�ֲ��б�
					accountDD.stockHoldList.remove(j);
					
					// ����accountDD�ֽ��ֵ
					int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
					int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
				}
				else
				{
					// �粻�������ͼ������в��䣬���³ֲּ۸�
					shs.setCurDate(transDate);
					shs.setCurPrice(sdd.getClose());	
				}
				
			}
			
			
			// ����Ʊ���ﱸѡ�Ĺ�Ʊ����������پ����Ƿ����룬�����³ֲֹ�Ʊ
			Iterator it=stockDataMap.keySet().iterator();
			while(it.hasNext())
			{
				
				// �ӱ�ѡ��Ʊ����ȡ��һֻ��Ʊ
				String stockcode=it.next().toString();  
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
			
				// ȡ���˹�ǰ���������
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
				StockDayData sdd_b3=CommonTool.getStockDayData(stockDataRecordList, transDate, -3);
				
				if (sdd!=null && sdd_b1!=null)
				{
					System.out.println(sdd_b1.getName()+" "+sdd_b1.getCode()+" "+sdd_b1.getDate()+" "+sdd_b1.getClose());
					System.out.println(sdd.getName()+" "+sdd.getCode()+" "+sdd.getDate()+" "+sdd.getClose());
				}
				
				// �����ֶ�ͷ���о�������
//				if (checkDayData_MA_dtpl(sdd_b1)&&checkDayData_MA_dtpl(sdd_b2)&&checkDayData_MA_dtpl(sdd_b3))
				if (checkDayData_MA_dtpl_10_20(sdd_b1) && !checkDayData_MA_dtpl_10_20(sdd_b2)
//				if (checkDayData_MA_dtpl_5_10(sdd_b1) && !checkDayData_MA_dtpl_5_10(sdd_b2)
//				&& sdd_b1.getClose()>sdd_b1.getMa_60()
//				&& sdd_b2.getClose()>sdd_b2.getMa_60()
//				&& sdd_b1.getMa_10()>sdd_b1.getMa_60()
//				&& sdd_b1.getMa_20()>sdd_b1.getMa_60()
				)
				{
					
					// �����ֶ�ͷ���У������룬����¼���뽻��
					TransactionRecordData trd=new TransactionRecordData();
					trd.setBuySDD(sdd);
					accountDD.buyTransList.add(trd);
					
					// ����accountDD�ֲ��б�
					StockHoldShare shs=new StockHoldShare();
					
					// ����������Ʊ����
//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
//					int amount=0;
//					if (accountDD.cashValue>eachStockInvestMoney)
//					{
//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // ʣ���ֽ��㹻Ͷ��һ�ݵ�ǰ��Ʊ
//					}
//					else
//					{
//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ𲻹�Ͷ��һ�ݵ�ǰ��Ʊ����ȫ������
//					}
					
					int amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ�ȫ������
					
					// ���������ĳֲֹ�Ʊ
					shs.setAmount(amount);
					shs.setCode(sdd.getCode());
					shs.setName(sdd.getName());
					shs.setBuyPrice(sdd.getOpen());
					shs.setBuyDate(sdd.getDate());
					shs.setCurPrice(sdd.getClose());
					shs.setCurDate(sdd.getDate());
					shs.setBuySDD(sdd);
					stockHoldList.add(shs);
					
					// ����accountDD�ֽ��ֵ
					int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
					int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
					
				}
				
			}
			
			// ���¸����˻���ÿ���˻���Ϣ
			Map accountDataMap=psa.getAccountDataMap();
			accountDataMap.put(transDate, accountDD);
			accountDD_pre=accountDD;
			
		}
			
		// ���Ͷ�ʽ��׼�¼��ģ�⽻�׽��仯���ߣ��Ա��������ײ���
		List transactionDataList=generateTransactionDataListFromPSA(psa);
		outputTransactionRecordReport(transactionDataList, "Ͷ�����_��ͷ����");
		// code name date_c saledate year days buy_price sale_price profit 
		
		outputAccountRecordReport(psa); // ���account��ÿ��Ͷ�����ݣ��۸�仯���ֽ��ֵ/�ܼ�ֵ  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
		
//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, �׷������� 
		
	}
	
	
	
	// ģ��Ͷ�� - �����ȶ�����
	public void processInvestmentByStrategy_cmwd(Map stockDataMap, String startDate, String endDate)
	{
		
		// ����һ������ģ���˻�
		PersonalStockAccount psa=new PersonalStockAccount();
		
		// ��òο��������ڶ���
		List dateList=CommonTool.getDateReferenceList(startDate, endDate);		
		
		// ���������accountDD_pre
		AccountDayData accountDD_pre=new AccountDayData();  
		accountDD_pre.setCashValue(psa.investMoney);
		
		// ģ��ÿ�������ս���
		for (int i=0; i<dateList.size(); i++)
		{
			
			// ȡ��һ����������
			String transDate=dateList.get(i).toString();
			
			// ����һ�����յĽ����˻�����accountDD�����̳����յĳֲֺ��ֽ�
			AccountDayData accountDD=new AccountDayData();
			accountDD.setPosNum(i);
			accountDD.setDate(transDate);
			accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // �̳����յĳֲ�
			accountDD.setCashValue(accountDD_pre.getCashValue());	// �̳����յ��ֽ�
			
			// ��鵱ǰ�ֲֵĹ�Ʊ����״�����Ⱦ����Ƿ������������³ֲֹ�Ʊ�����ɳֲּ۸�
			List stockHoldList=accountDD.getStockHoldList();
			int stockHoldSize=stockHoldList.size();
			for (int j=stockHoldSize-1; j>=0; j--)
			{
				// ȡ��һ���ֹɶ���
				StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
				
				// ��ô˳ֹɵ���ʷ����
				String stockcode=shs.getCode();
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
				// ȡ���˹�ǰ���������
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
				
				if (sdd==null || sdd_b1==null || sdd_b2==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
				{
					shs.setCurDate(transDate);
					continue;
				}
				
				// �жϴ˹ɵ�ǰ���ƣ�����������̼۸��������󲿷ֳ���۸���������
				double sdd_sale=sdd_b1.getLow()+(sdd_b1.getHigh()-sdd_b1.getLow())*0.2;   // ����80%ǰ��ɼ����䣬������
				StockDayData buySDD=shs.getBuySDD();
				
//				double sdd_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
				
				if ( 
//					sdd_profit<-5 || 
					sdd.getClose()<sdd_sale
				)
				{
					// ��¼����
					TransactionRecordData trd=new TransactionRecordData();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(buySDD);
					trd.setSaleSDD(sdd);
					accountDD.saleTransList.add(trd);
					
					// ����accountDD�ֲ��б�
					accountDD.stockHoldList.remove(j);
					
					// ����accountDD�ֽ��ֵ
					int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
					int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
				}
				else
				{
					// �粻�������ͼ������в��䣬���³ֲּ۸�
					shs.setCurDate(transDate);
					shs.setCurPrice(sdd.getClose());	
				}
				
			}
			
			
			// ����Ʊ���ﱸѡ�Ĺ�Ʊ����������پ����Ƿ����룬�����³ֲֹ�Ʊ
			Iterator it=stockDataMap.keySet().iterator();
			while(it.hasNext())
			{
				
				// �ӱ�ѡ��Ʊ����ȡ��һֻ��Ʊ
				String stockcode=it.next().toString();  
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
			
				// ȡ���˹�ǰ���������
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
				StockDayData sdd_b3=CommonTool.getStockDayData(stockDataRecordList, transDate, -3);
				
				if (sdd!=null)
				{
					System.out.println(sdd.getName()+" "+sdd.getCode()+" "+sdd.getDate()+" "+sdd.getClose());
				}
				else
				{
					continue;
				}
				
				// ���������̼۳���ǰ��󲿷ֳ���۸񣬽��쿪������
				double sdd_buy=sdd_b2.getLow()+(sdd_b2.getHigh()-sdd_b2.getLow())*0.8;   // ����80%ǰ��ɼ����䣬������
				if ( sdd_b1.getClose()>sdd_buy
//					 && checkDayData_MA_dtpl_5_10(sdd_b1)
//					 && checkDayData_MA_dtpl_10_20(sdd_b1)
					 && checkDayData_MA_dtpl(sdd_b1)
					)
				{
					
					// �����ֶ�ͷ���У������룬����¼���뽻��
					TransactionRecordData trd=new TransactionRecordData();
					trd.setBuySDD(sdd);
					accountDD.buyTransList.add(trd);
					
					// ����accountDD�ֲ��б�
					StockHoldShare shs=new StockHoldShare();
					
					// ����������Ʊ����
//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
//					int amount=0;
//					if (accountDD.cashValue>eachStockInvestMoney)
//					{
//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // ʣ���ֽ��㹻Ͷ��һ�ݵ�ǰ��Ʊ
//					}
//					else
//					{
//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ𲻹�Ͷ��һ�ݵ�ǰ��Ʊ����ȫ������
//					}
					
					int amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ�ȫ������,�����̼�����
					
					// ���������ĳֲֹ�Ʊ
					shs.setAmount(amount);
					shs.setCode(sdd.getCode());
					shs.setName(sdd.getName());
					shs.setBuyPrice(sdd.getOpen());
					shs.setBuyDate(sdd.getDate());
					shs.setCurPrice(sdd.getClose());
					shs.setCurDate(sdd.getDate());
					shs.setBuySDD(sdd);
					stockHoldList.add(shs);
					
					// ����accountDD�ֽ��ֵ
					int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
					int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
					
				}
				
			}
			
			// ���¸����˻���ÿ���˻���Ϣ
			Map accountDataMap=psa.getAccountDataMap();
			accountDataMap.put(transDate, accountDD);
			accountDD_pre=accountDD;
			
		}
			
		// ���Ͷ�ʽ��׼�¼��ģ�⽻�׽��仯���ߣ��Ա��������ײ���
		List transactionDataList=generateTransactionDataListFromPSA(psa);
		outputTransactionRecordReport(transactionDataList, "Ͷ�����_�����ȶ�");
		// code name date_c saledate year days buy_price sale_price profit 
		
//		outputAccountRecordReport(psa); // ���account��ÿ��Ͷ�����ݣ��۸�仯���ֽ��ֵ/�ܼ�ֵ  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
		
//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, �׷������� 
		
	}


	// ģ��Ͷ�� - ���ɲ���
	public void processInvestmentByStrategy_ygcl(String startDate, String endDate)
	{
		
		
		
		
		
		
		
		
	}
	
	// ģ��Ͷ�� - �������
	public void processInvestmentByStrategy_znzj(Map stockDataMap, String startDate, String endDate)
	{
		
		
		// ����һ������ģ���˻�
		PersonalStockAccount psa=new PersonalStockAccount();
		
		// ��òο��������ڶ���
		List dateList=CommonTool.getDateReferenceList(startDate, endDate);		
		
		// ���������accountDD_pre
		AccountDayData accountDD_pre=new AccountDayData();  
		accountDD_pre.setCashValue(psa.investMoney);
		
		List xq1List=new ArrayList();
		List xq2List=new ArrayList();
		List xq3List=new ArrayList();
		List xq4List=new ArrayList();
		List xq5List=new ArrayList();
		
		// ģ��ÿ�������ս���
		for (int i=0; i<dateList.size(); i++)
		{
			
			// ȡ��һ����������
			String transDate=dateList.get(i).toString();
		
			// ����Ʊ���ﱸѡ�Ĺ�Ʊ����������پ����Ƿ����룬�����³ֲֹ�Ʊ
			Iterator it=stockDataMap.keySet().iterator();
			while(it.hasNext())
			{
				
				// �ӱ�ѡ��Ʊ����ȡ��һֻ��Ʊ
				String stockcode=it.next().toString();  
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
			
				// ȡ���˹�ǰ���������
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				if (sdd==null)
					continue;
				
				if (checkDateXQJ(transDate)==1)
				{
					xq1List.add(sdd.getClose_rise());
				}
				
				else if (checkDateXQJ(transDate)==2)
				{
					xq2List.add(sdd.getClose_rise());
				}
				
				else if (checkDateXQJ(transDate)==3)
				{
					xq3List.add(sdd.getClose_rise());
				}
				
				else if (checkDateXQJ(transDate)==4)
				{
					xq4List.add(sdd.getClose_rise());
				}
			
				else if (checkDateXQJ(transDate)==5)
				{
					xq5List.add(sdd.getClose_rise());
				}
		
			}
			
		}
		
		outputXQJAVGProfit(1, xq1List);
		outputXQJAVGProfit(2, xq2List);
		outputXQJAVGProfit(3, xq3List);
		outputXQJAVGProfit(4, xq4List);
		outputXQJAVGProfit(5, xq5List);
		
	}
	
	public void addTrdListToMap(Map trdMap, List trdList)
	{
		for (int i=0; i<trdList.size(); i++)
		{
			TransactionRecordData trd=(TransactionRecordData)trdList.get(i);
			String key=trd.getBuySDD().getDate()+"_"
					+trd.getModelPrt()+"_"
					+trd.getStockPrt()+"_"
					+trd.getStockcode();
			trdMap.put(key, trd);
		}
		
	}
	
	public void searchDataByModel_yg(String startDate, String endDate)
	{
		
		// ��ȡȫ��ָ������
		stockIndexMap=CommonTool.getAllStockIndexDataMap();  // �ṹ (type, indexDataList)
		
		// ��ȡȫ����Ʊ����
		String stockCodeListFile="stockcodelist";
		ResultSet rs=CommonTool.readDataFromSASDataSet(stockAllDataFull, stockCodeListFile);
		List stockCodeList=CommonTool.getColumnDataList(rs, "stockcode");
		
		// �Թ�Ʊ���밴�������ѡȡ
		List researchStockCodeList=new ArrayList();
		
		// ȫ��ѡ��
		researchStockCodeList=stockCodeList; 	// ѡȫ����Ʊ��Ϊ�о�����
		
		// �����ѡ��
//		researchStockCodeList=CommonTool.getAllStock_600(stockCodeList);  // ��600���ѡ��
//		researchStockCodeList=CommonTool.getAllStock_300(stockCodeList);  // ��300���ѡ��
//		researchStockCodeList=CommonTool.getAllStock_000(stockCodeList);  // ��000���ѡ��
//		researchStockCodeList=CommonTool.getAllStock_002(stockCodeList);  // ��002���ѡ��
		
//		String startDate="2017/12/01";
//		String endDate="2017/12/29";
		
		List transactionDataList=search_yg(researchStockCodeList, startDate, endDate, 3);  // ֮ǰ3���������Ϊ�ο�
		
		outputTransactionRecordReport(transactionDataList, "����ѡ��");
		
	}
	
	
	// ��ͷ����ѡ��ģ��
	public void processStockByModel_dtpl(List researchStockCodeList)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename);
			
			System.out.println("Process stock: "+stockcode);
			
			// ���磺0-59(����ǰ60��), 60-64(��ǰ5��), 65(������)
			int obv_days=100; // �۲���
			int sta_days=5;  // ������
			int prof_days=30; // ��������������
			int pre_days=obv_days+sta_days;
			
			int total_days=obv_days+sta_days+prof_days;  // �ܹ��Ľ��׼�¼����
			
			if(stockDataList.size()<total_days)   // ���׼�¼���������жϣ�����
				return;
			
			for (int j=pre_days; j<stockDataList.size(); j++)
			{	
				
				// ��ͷ����������ÿ�������
				StockDayData sdd=(StockDayData)stockDataList.get(j);  // ������Ϊj
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				StockDayData sdd_b4=(StockDayData)stockDataList.get(j-4);
				StockDayData sdd_b5=(StockDayData)stockDataList.get(j-5);
				StockDayData sdd_b6=(StockDayData)stockDataList.get(j-6);
				
				// ��ͷ�������������Ƿ�
				double total_rise_b=sdd_b1.getClose_rise()+sdd_b2.getClose_rise()+sdd_b3.getClose_rise()+sdd_b4.getClose_rise()+sdd_b5.getClose_rise();
				double sdd_total_value=CommonTool.getDoubleNumberWithTwoBit(sdd.getLiquid_value()/100000000);
				double current_total_value=CommonTool.getStockCurrentLiquidValue(stockDataList);
				
				if (1>0 
				 && checkDayData_MA(sdd_b1) 
				 && checkDayData_MA(sdd_b2) 
				 && checkDayData_MA(sdd_b3) 
				 && checkDayData_MA(sdd_b4) 
				 && checkDayData_MA(sdd_b5) 
				 && checkPastDaysHighPrice(sdd_b1, stockDataList, j, 120) // ����Ƿ�ͻ����ǰn���λ
//				 && current_total_value>1000
				 && sdd_b6.getLow()<sdd_b6.getMa_5()  // b6����ǰ�۸������վ�����
	//			 && total_rise_b>15 && total_rise_b<30  // b1-b5���Ƿ�����15%,С��30%
				 && sdd_b1.getClose_rise()>-2 && sdd_b1.getClose_rise()-sdd_b1.getOpen_rise()>-2   // b1Ϊ���� 
				 && sdd_b2.getClose_rise()>-2 && sdd_b2.getClose_rise()-sdd_b2.getOpen_rise()>-2   // b2Ϊ���� 
				 && sdd_b3.getClose_rise()>-2 && sdd_b3.getClose_rise()-sdd_b3.getOpen_rise()>-2   // b3Ϊ���� 
				 && sdd_b4.getClose_rise()>-2 && sdd_b4.getClose_rise()-sdd_b4.getOpen_rise()>-2   // b4Ϊ���� 
				 && sdd_b5.getClose_rise()>-2 && sdd_b5.getClose_rise()-sdd_b5.getOpen_rise()>-2   // b5Ϊ���� 
	//			 && sdd_b1.getMa_5()-sdd_b1.getMa_20()>sdd_b5.getMa_5()-sdd_b5.getMa_20()  // b1��5,20�߾����b5��5,20�߾�,�ʷ�ɢ
	//			 && (sdd_b1.getMa_5()-sdd_b1.getMa_60())/sdd_b1.getMa_5()<0.3  // b1��5�վ��߻�û��Զ��60�վ��ߣ�����������
				)
				{
					
					List preDaysDataList=stockDataList.subList(j-pre_days, j-sta_days-1);
//					int preStockTrend=checkStockTrend(preDaysDataList);  // 0: flat, 1: small rise, 2: middle rise, 3: big rise
					
//					if (preStockTrend==0)
					{
						// ��¼�����¼������������棬��̬��������׳��ղ���¼�׳�ʱ������ֵ
						for (int k=j; k<stockDataList.size()-3 && k<j+120 ; k++)
						{
							StockDayData sdd_a1=(StockDayData)stockDataList.get(k);
							StockDayData sdd_a2=(StockDayData)stockDataList.get(k+1);
							if (sdd_a1.getOpen()>sdd_a1.getClose() && sdd_a2.getOpen()>sdd_a2.getClose()  // ��������
							 && sdd_a1.getClose()>sdd_a2.getClose()  // ���������µ�
							 && sdd_a2.getLow()<sdd_a2.getMa_10())  // �ڶ���������ͼ۴̴�10�վ���
							{
								TransactionRecordData trd=new TransactionRecordData();
								trd.setStockcode(stockcode);
								
								trd.setBuySDD(sdd);
								trd.setSaleSDD(sdd_a2);

								transactionDataList.add(trd);
								break;
							}
							
						}
						
					}
					
				}  // end if 
				
			}
			
		} // end for 
		
		
		outputTransactionRecordReport(transactionDataList, "��ͷ����");
		
	}
	

	// ��ͷ���иĽ�ѡ��ģ��
	public List processStockByModel_dtplgj(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻETF���Ʊ����ʷ��������
			String researchcode=((String)researchStockCodeList.get(i));
			List stockDataList;
			if (researchcode.startsWith("index"))
			{
				String stockfilename=researchcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
				System.out.println("Process stock: "+researchcode);
			}
			else
			{
				String stockcode=researchcode.substring(2); // ȥ��ǰ׺ sh, sz
				String stockfilename="stock"+stockcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
				System.out.println("Process stock: "+stockcode);
			}
			
			
			// ���磺0-59(����ǰ60��), 60-64(��ǰ5��), 65(������)
			int obv_days=10; // �۲���
			int rise_days=0;  // ������
			int pre_days=obv_days+rise_days;  // ����ǰ�ܹ�ʱ��
			int pastHighPriceDays_distance=0;   // ��ȥͬ��λ����ʱ��ľ���
//			int hold_days=2500;  // ����ʱ��
//			int hold_days=15;  // ����ʱ��
			int hold_days=1000;  // ����ʱ��
			
			boolean checkAssetsBack=true;
//			boolean checkAssetsBack=false;			
			String assetsBackDate="";   // �ʲ��������ڣ���Ϊ�������������µ����ʽ���ã���Ҫ��һ����������ʶ�ʲ�����������
			
			for (int j=pre_days; j<stockDataList.size(); j++)
			{	
				
				// ��ͷ����������ÿ�������
				StockDayData sdd=(StockDayData)stockDataList.get(j);  // ������Ϊj
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				StockDayData sdd_b4=(StockDayData)stockDataList.get(j-4);
				StockDayData sdd_b5=(StockDayData)stockDataList.get(j-5);
				StockDayData sdd_b6=(StockDayData)stockDataList.get(j-6);
				StockDayData sdd_b7=(StockDayData)stockDataList.get(j-7);
				StockDayData sdd_b8=(StockDayData)stockDataList.get(j-8);
				StockDayData sdd_b9=(StockDayData)stockDataList.get(j-9);
				StockDayData sdd_b10=(StockDayData)stockDataList.get(j-10);
				
				if (sdd.getDate().compareTo(assetsBackDate)<=0 && checkAssetsBack)   // ��鵱ǰ�ʲ��Ƿ���ã������û�л������ܽ���
					continue;
				
				// ��ͷ�������������Ƿ�
				double total_rise_b=sdd_b1.getClose_rise()+sdd_b2.getClose_rise()+sdd_b3.getClose_rise()+sdd_b4.getClose_rise()+sdd_b5.getClose_rise();
				double sdd_total_value=CommonTool.getDoubleNumberWithTwoBit(sdd.getLiquid_value()/100000000);
				double current_total_value=CommonTool.getStockCurrentLiquidValue(stockDataList);
			
//				double lastday_valv=(sdd_b1.getHigh()-sdd_b1.getLow())*1+sdd_b1.getLow();
				double lastday_valv=sdd_b1.getClose();
						
				if (1>0 
//				 && sdd_b1.getMa_macd()>sdd_b2.getMa_macd()
//				 && sdd_b2.getMa_macd()>sdd_b3.getMa_macd()
//				 && sdd_b3.getMa_macd()<sdd_b4.getMa_macd()
//				 && checkDayData_MA(sdd_b1) 
//				 && checkDayData_MA(sdd_b2) 
//				 && checkDayData_MA(sdd_b3) 
//				 && checkDayData_MA(sdd_b4) 
//				 && checkDayData_MA(sdd_b5) 
//				 && checkDayData_MA(sdd_b6) 
//				 && checkDayData_MA(sdd_b7) 
//				 && checkDayData_MA(sdd_b8) 
//				 && checkDayData_MA(sdd_b9) 
//				 && checkDayData_MA(sdd_b10) 
				 && sdd_b1.getReal_rise()>0
				 && sdd.getOpen()> lastday_valv
//				 && (sdd_b1.getClose()>sdd_b2.getHigh())
//				 && (sdd_b1.getClose()>sdd_b3.getHigh())
//				 && (sdd_b1.getClose()>sdd_b4.getHigh())
//				 && (sdd_b1.getClose()>sdd_b5.getHigh())
//				 && (sdd_b1.getClose()>sdd_b6.getHigh())
//				 && getPastHighPriceDaysDistance(sdd_b1, stockDataList)>pastHighPriceDays_distance
//				 && checkPastDaysHighPrice(sdd_b1, stockDataList, j, obv_days) // ����Ƿ�ͻ����ǰn���λ
//				 && current_total_value>1000
//				 && sdd_b6.getLow()<sdd_b6.getMa_5()    // b6����ǰ�۸������վ�����
//				 && total_rise_b>15 && total_rise_b<30  // b1-b5���Ƿ�����15%,С��30%
//				 && sdd_b1.getClose_rise()>-2 && sdd_b1.getClose_rise()-sdd_b1.getOpen_rise()>-2   // b1Ϊ���� 
//				 && sdd_b2.getClose_rise()>-2 && sdd_b2.getClose_rise()-sdd_b2.getOpen_rise()>-2   // b2Ϊ���� 
//				 && sdd_b3.getClose_rise()>-2 && sdd_b3.getClose_rise()-sdd_b3.getOpen_rise()>-2   // b3Ϊ���� 
//				 && sdd_b4.getClose_rise()>-2 && sdd_b4.getClose_rise()-sdd_b4.getOpen_rise()>-2   // b4Ϊ���� 
//				 && sdd_b5.getClose_rise()>-2 && sdd_b5.getClose_rise()-sdd_b5.getOpen_rise()>-2   // b5Ϊ���� 
	//			 && sdd_b1.getMa_5()-sdd_b1.getMa_20()>sdd_b5.getMa_5()-sdd_b5.getMa_20()  // b1��5,20�߾����b5��5,20�߾�,�ʷ�ɢ
	//			 && (sdd_b1.getMa_5()-sdd_b1.getMa_60())/sdd_b1.getMa_5()<0.3  // b1��5�վ��߻�û��Զ��60�վ��ߣ�����������
				)
				{
					
						double buy_price=sdd.getOpen();  // �ڶ��쿪�̾������ۼ۸�ߵ�
						
						TransactionRecordData trd=new TransactionRecordData();
						trd.setModelType("dtplgj");
						trd.setModelParam("��ͷ��������: 10 "+"��ͷ���з�ʽ: close>5>10>20>60 "+" ��������: "+hold_days+" ����ظ�����: "+checkAssetsBack);
						trd.setStockPrt(calculateStockPrt_dtplgj(sdd_b1));
						
						trd.setStockcode(sdd.getCode());
						trd.setBuySDD(sdd);
						trd.setTransactionBuyPrice(buy_price);
						
						int hold_endday_pos=j+hold_days;
						if (hold_endday_pos>stockDataList.size()-1)
						{
							hold_endday_pos=stockDataList.size()-1;
						}
						
						// ����һ��Ĭ�ϵ������ն���
						StockDayData sdd_end=(StockDayData)stockDataList.get(hold_endday_pos);  // ������Ϊj
						double sale_price=sdd_end.getClose();
						double profit=(sdd_end.getClose()-buy_price)/buy_price*100-0.2; 
						sdd_end.setProfit(profit);
						trd.setSaleSDD(sdd_end);   // Ĭ���Ȱѹ�������Ϊ������sdd���Ա���Ϊ��
						trd.setTransactionSalePrice(sale_price);  // �����յ����̼۸�Ĭ����Ϊ�����۸�price
						
						
						for (int s=j+1; s<hold_endday_pos; s++)	// �鿴����n���ڵĽ��׾�����������s
						{
							
							StockDayData sdd_s=(StockDayData)stockDataList.get(s);
							StockDayData sdd_s1=(StockDayData)stockDataList.get(s+1);
							
							
							if (sdd_s.getReal_rise()<-1 && sdd_s1.getOpen_rise()<0)
							{
								profit=(sdd_s1.getOpen()-buy_price)/buy_price*100-0.2; 
								sdd_s.setProfit(profit);
								trd.setSaleSDD(sdd_s1);
								trd.setTransactionProfit(profit);
								trd.setTransactionSalePrice(sdd_s1.getOpen());
								
								break;
							}
							
//							if (sdd_s.getHigh()>sale_price)  // ���ĳһ�����м۸��ϳ嵽Ԥ���������۸�������ֹӯ
//							{
//									double profit=(sdd_s.getClose()-buy_price)/buy_price*100;
//									sdd_s.setProfit(profit);
//									trd.setSaleSDD(sdd_s);
//									trd.setTransactionProfit(profit);
//									break;
//							}
							
//							MarketRDDayData mdd=(MarketRDDayData)marketDataRecordMap.get(sdd_s.getDate());
//							if (mdd!=null && mdd.getDown10()>500) // ���ĳһ����̳��ִ������ͣ��������ʱ����ֹ��
//							{
//									System.out.println(mdd.getDate()+" Down10: "+mdd.getDown10());
//									double profit=(sdd_s.getClose()-buy_price)/buy_price*100-0.2;
//									sdd_s.setProfit(profit);
//									trd.setSaleSDD(sdd_s);
//									trd.setTransactionProfit(profit);
//									break;
//							}
							
//							else if (sdd_s.getClose()<sdd_s.getMa_20()    // ���ĳһ�����̳��ִ����5��10��20�վ��ߣ���ֹ��
//									&& sdd_s.getClose()<sdd_s.getMa_10() 
//									&& sdd_s.getClose()<sdd_s.getMa_5())
//							{
//									double profit=(sdd_s.getClose()-buy_price)/buy_price*100-0.2; 
//									sdd_s.setProfit(profit);
//									trd.setSaleSDD(sdd_s);
//									trd.setTransactionProfit(profit);
//									trd.setTransactionSalePrice(sdd_s.getClose());
//									break;
//								
//							}
							
							else   // �������û�з������գ����¼�������ʱ������
							{
									profit=(sdd_s.getClose()-buy_price)/buy_price*100-0.2; 
									sdd_s.setProfit(profit);
									trd.setSaleSDD(sdd_s);
									trd.setTransactionProfit(profit);
									trd.setTransactionSalePrice(sdd_s.getClose());
							}
							
						}
							
							
						transactionDataList.add(trd);
						if (trd.getSaleSDD()!=null)
							assetsBackDate=trd.getSaleSDD().getDate();
						
							
					}
						
				}		
					
			
		} // end for 
		
		
		outputTransactionRecordReport(transactionDataList, "��ͷ���иĽ�");
		
		return transactionDataList;
		
	}
	
	
	// �����ȶ�ģ��
	public List processStockByModel_cmwd(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻETF���Ʊ����ʷ��������
			String researchcode=((String)researchStockCodeList.get(i));
			List stockDataList;
			if (researchcode.startsWith("index"))
			{
				String stockfilename=researchcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
				System.out.println("Process stock: "+researchcode);
			}
			else
			{
				String stockcode=researchcode.substring(2); // ȥ��ǰ׺ sh, sz
				String stockfilename="stock"+stockcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
				System.out.println("Process stock: "+stockcode);
			}
			
			
			// ���磺0-59(����ǰ60��), 60-64(��ǰ5��), 65(������)
			int obv_days=10; // �۲���
			int rise_days=0;  // ������
			int pre_days=obv_days+rise_days;  // ����ǰ�ܹ�ʱ��
			int hold_days=1000;  // ����ʱ��
			
			boolean checkAssetsBack=true;
//			boolean checkAssetsBack=false;			
			String assetsBackDate="";   // �ʲ��������ڣ���Ϊ�������������µ����ʽ���ã���Ҫ��һ����������ʶ�ʲ�����������
			
			for (int j=pre_days; j<stockDataList.size(); j++)
			{
				
				// ��ͷ����������ÿ�������
				StockDayData sdd=(StockDayData)stockDataList.get(j);  // ������Ϊj
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				StockDayData sdd_b4=(StockDayData)stockDataList.get(j-4);
				StockDayData sdd_b5=(StockDayData)stockDataList.get(j-5);
				StockDayData sdd_b6=(StockDayData)stockDataList.get(j-6);
				StockDayData sdd_b7=(StockDayData)stockDataList.get(j-7);
				StockDayData sdd_b8=(StockDayData)stockDataList.get(j-8);
				StockDayData sdd_b9=(StockDayData)stockDataList.get(j-9);
				StockDayData sdd_b10=(StockDayData)stockDataList.get(j-10);
				
				if (sdd.getDate().compareTo(assetsBackDate)<=0 && checkAssetsBack)   // ��鵱ǰ�ʲ��Ƿ���ã������û�л������ܽ���
					continue;
				
				// ��ͷ�������������Ƿ�
				double total_rise_b=sdd_b1.getClose_rise()+sdd_b2.getClose_rise()+sdd_b3.getClose_rise()+sdd_b4.getClose_rise()+sdd_b5.getClose_rise();
				double sdd_total_value=CommonTool.getDoubleNumberWithTwoBit(sdd.getLiquid_value()/100000000);
				double current_total_value=CommonTool.getStockCurrentLiquidValue(stockDataList);
			
//				double lastday_valv=(sdd_b1.getHigh()-sdd_b1.getLow())*1+sdd_b1.getLow();
				double lastday_valv=(sdd_b1.getHigh()-sdd_b1.getLow())*0.8+sdd_b1.getLow();
//				double lastday_valv=sdd_b1.getClose();
						
				if (1>0 
//				 && sdd_b1.getMa_macd()>sdd_b2.getMa_macd()
//				 && sdd_b2.getMa_macd()>sdd_b3.getMa_macd()
//				 && sdd_b3.getMa_macd()<sdd_b4.getMa_macd()
				 && checkDayData_MA(sdd_b1) 
//				 && checkDayData_MA(sdd_b2) 
//				 && checkDayData_MA(sdd_b3) 
//				 && checkDayData_MA(sdd_b4) 
//				 && checkDayData_MA(sdd_b5) 
//				 && checkDayData_MA(sdd_b6) 
//				 && checkDayData_MA(sdd_b7) 
//				 && checkDayData_MA(sdd_b8) 
//				 && checkDayData_MA(sdd_b9) 
//				 && checkDayData_MA(sdd_b10) 
//				 && sdd_b1.getReal_rise()>1
				 && (sdd.getOpen()> sdd_b1.getClose())
				 && (sdd_b1.getReal_rise()>0)
//				 && (sdd_b1.getClose()>sdd_b2.getHigh())
//				 && (sdd_b1.getClose()>sdd_b3.getHigh())
//				 && (sdd_b1.getClose()>sdd_b4.getHigh())
//				 && (sdd_b1.getClose()>sdd_b5.getHigh())
//				 && (sdd_b1.getClose()>sdd_b6.getHigh())
//				 && getPastHighPriceDaysDistance(sdd_b1, stockDataList)>pastHighPriceDays_distance
//				 && checkPastDaysHighPrice(sdd_b1, stockDataList, j, obv_days) // ����Ƿ�ͻ����ǰn���λ
//				 && current_total_value>1000
//				 && sdd_b6.getLow()<sdd_b6.getMa_5()    // b6����ǰ�۸������վ�����
//				 && total_rise_b>15 && total_rise_b<30  // b1-b5���Ƿ�����15%,С��30%
//				 && sdd_b1.getClose_rise()>-2 && sdd_b1.getClose_rise()-sdd_b1.getOpen_rise()>-2   // b1Ϊ���� 
//				 && sdd_b2.getClose_rise()>-2 && sdd_b2.getClose_rise()-sdd_b2.getOpen_rise()>-2   // b2Ϊ���� 
//				 && sdd_b3.getClose_rise()>-2 && sdd_b3.getClose_rise()-sdd_b3.getOpen_rise()>-2   // b3Ϊ���� 
//				 && sdd_b4.getClose_rise()>-2 && sdd_b4.getClose_rise()-sdd_b4.getOpen_rise()>-2   // b4Ϊ���� 
//				 && sdd_b5.getClose_rise()>-2 && sdd_b5.getClose_rise()-sdd_b5.getOpen_rise()>-2   // b5Ϊ���� 
	//			 && sdd_b1.getMa_5()-sdd_b1.getMa_20()>sdd_b5.getMa_5()-sdd_b5.getMa_20()  // b1��5,20�߾����b5��5,20�߾�,�ʷ�ɢ
	//			 && (sdd_b1.getMa_5()-sdd_b1.getMa_60())/sdd_b1.getMa_5()<0.3  // b1��5�վ��߻�û��Զ��60�վ��ߣ�����������
				)
				{
					
						double buy_price=0;
						if (sdd.getOpen()> sdd_b1.getClose())  // �ڶ��쿪�̳���������ߣ����̾������ۼ۸�ߵ�
						{
							buy_price=sdd.getOpen();  
						}
//						else if (sdd.getHigh()>sdd_b1.getHigh())  // �ڶ������г���������ߣ������г���ʱ��
//						{
//							buy_price=sdd_b1.getHigh(); 
//						}
						
						TransactionRecordData trd=new TransactionRecordData();
						trd.setModelType("cmwd");
						trd.setModelParam("�����ȶ�: ����ظ�����: "+checkAssetsBack);
						trd.setStockPrt(calculateStockPrt_dtplgj(sdd_b1));
						
						trd.setStockcode(sdd.getCode());
						trd.setBuySDD(sdd);
						trd.setTransactionBuyPrice(buy_price);
						
						int hold_endday_pos=j+hold_days;
						if (hold_endday_pos>stockDataList.size()-1)
						{
							hold_endday_pos=stockDataList.size()-1;
						}
						
						// ����һ��Ĭ�ϵ������ն���
						StockDayData sdd_end=(StockDayData)stockDataList.get(hold_endday_pos);  // ������Ϊj
						double sale_price=sdd_end.getClose();
						double profit=(sdd_end.getClose()-buy_price)/buy_price*100-0.2; 
						sdd_end.setProfit(profit);
						trd.setSaleSDD(sdd_end);   // Ĭ���Ȱѹ�������Ϊ������sdd���Ա���Ϊ��
						trd.setTransactionSalePrice(sale_price);  // �����յ����̼۸�Ĭ����Ϊ�����۸�price
						
						
						for (int s=j+1; s<hold_endday_pos; s++)	// �鿴����n���ڵĽ��׾�����������s
						{
							
							StockDayData sdd_s=(StockDayData)stockDataList.get(s);
							StockDayData sdd_s1=(StockDayData)stockDataList.get(s+1);
							
							
							if ( sdd.getReal_rise()<0 )  // ���뵱�����sdd_s�ڶ��쿪������
							{
								
								sale_price=sdd_s.getOpen();
								
								profit=(sale_price-buy_price)/buy_price*100-0.2;  
								sdd_s.setProfit(profit);
								trd.setSaleSDD(sdd_s);
								trd.setTransactionProfit(profit);
								trd.setTransactionSalePrice(sale_price);
								
								break;
								
							}
							else if ( checkPastDays_CMSD(sdd, sdd_s) )  // ���ڶ�����ֳ����ɶ�����������
							{
								
								sale_price=getSalePrice_CMSD(sdd, sdd_s);
								
								profit=(sale_price-buy_price)/buy_price*100-0.2; 
								sdd_s.setProfit(profit);
								trd.setSaleSDD(sdd_s);
								trd.setTransactionProfit(profit);
								trd.setTransactionSalePrice(sale_price);
								
								break;
							}
							else if ( checkPastDays_CMSD(sdd_s, sdd_s1) ) // �����������ֳ����ɶ�����������
							{
								sale_price=getSalePrice_CMSD(sdd_s, sdd_s1);
								
								profit=(sale_price-buy_price)/buy_price*100-0.2; 
								sdd_s1.setProfit(profit);
								trd.setSaleSDD(sdd_s1);
								trd.setTransactionProfit(profit);
								trd.setTransactionSalePrice(sale_price);
								
								break;
								
								
							}
							
//							if (sdd_s.getHigh()>sale_price)  // ���ĳһ�����м۸��ϳ嵽Ԥ���������۸�������ֹӯ
//							{
//									double profit=(sdd_s.getClose()-buy_price)/buy_price*100;
//									sdd_s.setProfit(profit);
//									trd.setSaleSDD(sdd_s);
//									trd.setTransactionProfit(profit);
//									break;
//							}
							
//							MarketRDDayData mdd=(MarketRDDayData)marketDataRecordMap.get(sdd_s.getDate());
//							if (mdd!=null && mdd.getDown10()>500) // ���ĳһ����̳��ִ������ͣ��������ʱ����ֹ��
//							{
//									System.out.println(mdd.getDate()+" Down10: "+mdd.getDown10());
//									double profit=(sdd_s.getClose()-buy_price)/buy_price*100-0.2;
//									sdd_s.setProfit(profit);
//									trd.setSaleSDD(sdd_s);
//									trd.setTransactionProfit(profit);
//									break;
//							}
							
//							else if (sdd_s.getClose()<sdd_s.getMa_20()    // ���ĳһ�����̳��ִ����5��10��20�վ��ߣ���ֹ��
//									&& sdd_s.getClose()<sdd_s.getMa_10() 
//									&& sdd_s.getClose()<sdd_s.getMa_5())
//							{
//									double profit=(sdd_s.getClose()-buy_price)/buy_price*100-0.2; 
//									sdd_s.setProfit(profit);
//									trd.setSaleSDD(sdd_s);
//									trd.setTransactionProfit(profit);
//									trd.setTransactionSalePrice(sdd_s.getClose());
//									break;
//								
//							}
							
							else   // �������û�з������գ����¼�������ʱ�����棬��������
							{
									profit=(sdd_s.getClose()-buy_price)/buy_price*100-0.2; 
									sdd_s.setProfit(profit);
									trd.setSaleSDD(sdd_s);
									trd.setTransactionProfit(profit);
									trd.setTransactionSalePrice(sdd_s.getClose());
							}
							
						}
							
							
						transactionDataList.add(trd);
						if (trd.getSaleSDD()!=null)
							assetsBackDate=trd.getSaleSDD().getDate();
						
							
					}
						
				}		
					
			
		} // end for 
		
		
		outputTransactionRecordReport(transactionDataList, "�����ȶ�");
		
		return transactionDataList;
		
	}
	
	
	// ����ѡ��ģ��
	public void processStockByModel_yg(List researchStockCodeList, String startDate, String endDate)
	{
		
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			// ����Ľ��׼�¼����
			int total_days=10;  
		
			if(stockDataList.size()<=total_days)   // ���׼�¼���������жϣ�����
				continue;
			
			int hold_days=2;  // ����ʱ��
			
//			boolean checkAssetsBack=true;
			boolean checkAssetsBack=false;			
			String assetsBackDate="";   // �ʲ��������ڣ���Ϊ�������������µ����ʽ���ã���Ҫ��һ����������ʶ�ʲ�����������
			
			for (int j=5; j<stockDataList.size(); j++)
			{	
				
				StockDayData sdd=(StockDayData)stockDataList.get(j);  // ������Ϊj
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				StockDayData sdd_b4=(StockDayData)stockDataList.get(j-4);
				StockDayData sdd_b5=(StockDayData)stockDataList.get(j-5);
				
				double total_rise_b=sdd_b1.getClose_rise()+sdd_b2.getClose_rise()+sdd_b3.getClose_rise();
				double sdd_c_openRate=(sdd.getOpen()-sdd_b1.getLow())/(sdd_b1.getHigh()-sdd_b1.getLow());

				if (sdd.getDate().compareTo(assetsBackDate)<0 && checkAssetsBack)   // ��鵱ǰ�ʲ��Ƿ���ã������û�л������ܽ���
					continue;
				
				if (1>0 
				 && sdd_b1.getClose_rise()<9.9 
				 && sdd_b1.getClose_rise()>0
				 && sdd_b1.getClose()-sdd_b1.getOpen()>=0   // b1Ϊ�����ǰ� 
				 && sdd_b2.getClose_rise()>9.9
				 && sdd_b2.getClose()-sdd_b2.getOpen()>=0   // b2Ϊ������ͣ�� 
				 && sdd_b3.getClose_rise()>0
				 && sdd_b3.getClose()-sdd_b3.getOpen()>=0   // b3Ϊ���� 
				 && total_rise_b>20
				 && total_rise_b<30  	// b1-b3���Ƿ�����20%,С��30%
				 && sdd.getOpen_rise()<3 && sdd.getOpen_rise()>-9 // ���뵱�쿪��Ϊ�Ϳ���С���߿�
//				 && sdd_c.getOpen()<sdd_b1.getOpen()
//				 && sdd_c_openRate<0.2
	//			 && checkIndexEnv(sdd_c)  // �鿴֮ǰ��ָ�����
	//			 && checkOpenEnv(sdd_c)   // �鿴���쿪�̵��������		
//				 && idd_b1!=null && idd_b1.getMa_ddz()>0
	//			 && sdd_c.getClose_rise()-sdd_c.getOpen_rise()>0 && sdd_c.getClose_rise()-sdd_c.getOpen_rise()<4
	//			 && sdd_c.getClose_rise()>0
				 
				)
				{
					
					List preStockDayDataList=new ArrayList();
					List preIndexDayDataList=new ArrayList();
					
					preStockDayDataList.add(sdd_b1);
					preStockDayDataList.add(sdd_b2);
					preStockDayDataList.add(sdd_b3);
					preStockDayDataList.add(sdd_b4);
					preStockDayDataList.add(sdd_b5);
					
					String stockType=CommonTool.getStockMarketType(sdd.getCode());
					List indexDataList=(List)stockIndexMap.get(stockType);
					StockDayData idd_b1=CommonTool.getStockDayData(indexDataList, sdd_b1.getDate());
					StockDayData idd_b2=CommonTool.getStockDayData(indexDataList, sdd_b2.getDate());
					StockDayData idd_b3=CommonTool.getStockDayData(indexDataList, sdd_b3.getDate());
					StockDayData idd_b4=CommonTool.getStockDayData(indexDataList, sdd_b4.getDate());
					StockDayData idd_b5=CommonTool.getStockDayData(indexDataList, sdd_b5.getDate());
					preIndexDayDataList.add(idd_b1);
					preIndexDayDataList.add(idd_b2);
					preIndexDayDataList.add(idd_b3);
					preIndexDayDataList.add(idd_b4);
					preIndexDayDataList.add(idd_b5);
					
//					double minDDZ=checkPastDaysDDZMin(indexDataList, idd_b1);
					
//					if (
//					    (idd_b1!=null
//						&& idd_b1.getMa_ddz()>3)
//						||
//					   (
//						idd_b1!=null
//						&& idd_b1.getMa_ddz()>3	   
//						&& idd_b2!=null
//						&& idd_b2.getMa_ddz()<idd_b1.getMa_ddz()
//						&& idd_b3!=null
//						&& idd_b3.getMa_ddz()<idd_b2.getMa_ddz()
//						)
//						)
					
//					if (
//							
//					   idd_b1!=null &&
//					   (
//					      (stockType.equals("600") && idd_b1.getMa_macd()>10 && checkPastDaysMACDTrends(indexDataList, idd_b1)) 
//					   || (stockType.equals("000") && idd_b1.getMa_macd()>30 && checkPastDaysMACDTrends(indexDataList, idd_b1))
//					   || (stockType.equals("002") && idd_b1.getMa_macd()>20 && checkPastDaysMACDTrends(indexDataList, idd_b1))
//					   || (stockType.equals("300") && idd_b1.getMa_macd()>10 && checkPastDaysMACDTrends(indexDataList, idd_b1))
//					   )
//					   
//					  )
					{
						// �������׼�¼����
						TransactionRecordData trd=new TransactionRecordData();
						
						double buy_price=sdd.getOpen();
						
						// ��¼������sdd��Ϣ
						trd.setStockcode(stockcode);
						trd.setBuySDD(sdd);
						trd.setPreStockDayDataList(preStockDayDataList);   // �ڽ��׶���trd�б���ǰ�����stock��Ʊ����
						trd.setPreIndexDayDataList(preIndexDayDataList);   // �ڽ��׶���trd�б���ǰ�����indexָ������
						
						trd.setModelType("yg");
						trd.setModelParam("����ǰ�������: 3 "+"������̬: 2��ͣ+1���� "+" ��������: "+hold_days+" ����ظ�����: "+checkAssetsBack);
						trd.setTransactionBuyPrice(buy_price);
						
						
						// �жϲ�����������sdd��Ϣ
						StockDayData sdd_s;
						if (j+1<stockDataList.size()) // �����һ�쳬�����������һ��Ϊsdd_a1
						{
							sdd_s=(StockDayData)stockDataList.get(j+1);
						}
						else
						{
							sdd_s=(StockDayData)stockDataList.get(j);
						}
						trd.setSaleSDD(sdd_s);
							
						double profit=(sdd_s.getClose()-buy_price)/buy_price*100-0.2; 
						sdd_s.setProfit(profit);
						trd.setSaleSDD(sdd_s);
						trd.setTransactionProfit(profit);
						trd.setTransactionSalePrice(sdd_s.getClose());
						
						transactionDataList.add(trd);
							
						if (trd.getSaleSDD()!=null)
							assetsBackDate=trd.getSaleSDD().getDate();
						
					}
					
					
				}
				
				
				
				
				
			}
			
		}
		
		outputTransactionRecordReport_yg(transactionDataList, "����");
	
		
	}
	
	
	// ����ͻ��ѡ��ģ��
	public void processStockByModel_ygtp(List researchStockCodeList, String startDate, String endDate)
	{
		
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			// ����Ľ��׼�¼����
			int total_days=10;  
		
			if(stockDataList.size()<=total_days)   // ���׼�¼���������жϣ�����
				continue;
			
			int hold_days=2;  // ����ʱ��
			
//			boolean checkAssetsBack=true;
			boolean checkAssetsBack=false;			
			String assetsBackDate="";   // �ʲ��������ڣ���Ϊ�������������µ����ʽ���ã���Ҫ��һ����������ʶ�ʲ�����������
			
			for (int j=5; j<stockDataList.size(); j++)
			{	
				
				StockDayData sdd=(StockDayData)stockDataList.get(j);  // ������Ϊj
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				StockDayData sdd_b4=(StockDayData)stockDataList.get(j-4);
				StockDayData sdd_b5=(StockDayData)stockDataList.get(j-5);
				
				double total_rise_b=sdd_b1.getClose_rise()+sdd_b2.getClose_rise()+sdd_b3.getClose_rise();
				double sdd_c_openRate=(sdd.getOpen()-sdd_b1.getLow())/(sdd_b1.getHigh()-sdd_b1.getLow());

				if (sdd.getDate().compareTo(assetsBackDate)<0 && checkAssetsBack)   // ��鵱ǰ�ʲ��Ƿ���ã������û�л������ܽ���
					continue;
				
				StockDayData sdd_down=checkPastDaysExistDownDay(stockDataList, sdd_b1.getPosNum(), 2);  // ����Ƿ��г�������
				
				if (sdd_down==null)
				{
					continue;
				}
				
				double riseRate=checkPastDaysRiseRate(stockDataList, sdd_down.getPosNum(), 5);  // ���down��ǰ������Ƿ��Ƿ�޴�
				
				if (riseRate<30)
				{
					continue;
				}
				
				if (1>0 
				 && checkPastDaysHighPrice(sdd_b1, stockDataList, sdd_b1.getPosNum(), 100) // sdd_b1�Ƿ�ͻ����ǰ100�����ߵ�
				 && sdd.getOpen_rise()<9.9 && sdd.getOpen_rise()>-9 // ���뵱�쿪�̿�������
//				 && sdd_c.getOpen()<sdd_b1.getOpen()
//				 && sdd_c_openRate<0.2
	//			 && checkIndexEnv(sdd_c)  // �鿴֮ǰ��ָ�����
	//			 && checkOpenEnv(sdd_c)   // �鿴���쿪�̵��������		
//				 && idd_b1!=null && idd_b1.getMa_ddz()>0
	//			 && sdd_c.getClose_rise()-sdd_c.getOpen_rise()>0 && sdd_c.getClose_rise()-sdd_c.getOpen_rise()<4
	//			 && sdd_c.getClose_rise()>0
				 
				)
				{
					
					List preStockDayDataList=new ArrayList();
					List preIndexDayDataList=new ArrayList();
					
					preStockDayDataList.add(sdd_b1);
					preStockDayDataList.add(sdd_b2);
					preStockDayDataList.add(sdd_b3);
					preStockDayDataList.add(sdd_b4);
					preStockDayDataList.add(sdd_b5);
					
					String stockType=CommonTool.getStockMarketType(sdd.getCode());
					List indexDataList=(List)stockIndexMap.get(stockType);
					StockDayData idd_b1=CommonTool.getStockDayData(indexDataList, sdd_b1.getDate());
					StockDayData idd_b2=CommonTool.getStockDayData(indexDataList, sdd_b2.getDate());
					StockDayData idd_b3=CommonTool.getStockDayData(indexDataList, sdd_b3.getDate());
					StockDayData idd_b4=CommonTool.getStockDayData(indexDataList, sdd_b4.getDate());
					StockDayData idd_b5=CommonTool.getStockDayData(indexDataList, sdd_b5.getDate());
					preIndexDayDataList.add(idd_b1);
					preIndexDayDataList.add(idd_b2);
					preIndexDayDataList.add(idd_b3);
					preIndexDayDataList.add(idd_b4);
					preIndexDayDataList.add(idd_b5);
					
//					double minDDZ=checkPastDaysDDZMin(indexDataList, idd_b1);
					
//					if (
//					    (idd_b1!=null
//						&& idd_b1.getMa_ddz()>3)
//						||
//					   (
//						idd_b1!=null
//						&& idd_b1.getMa_ddz()>3	   
//						&& idd_b2!=null
//						&& idd_b2.getMa_ddz()<idd_b1.getMa_ddz()
//						&& idd_b3!=null
//						&& idd_b3.getMa_ddz()<idd_b2.getMa_ddz()
//						)
//						)
					
//					if (
//							
//					   idd_b1!=null &&
//					   (
//					      (stockType.equals("600") && idd_b1.getMa_macd()>10 && checkPastDaysMACDTrends(indexDataList, idd_b1)) 
//					   || (stockType.equals("000") && idd_b1.getMa_macd()>30 && checkPastDaysMACDTrends(indexDataList, idd_b1))
//					   || (stockType.equals("002") && idd_b1.getMa_macd()>20 && checkPastDaysMACDTrends(indexDataList, idd_b1))
//					   || (stockType.equals("300") && idd_b1.getMa_macd()>10 && checkPastDaysMACDTrends(indexDataList, idd_b1))
//					   )
//					   
//					  )
					{
						// �������׼�¼����
						TransactionRecordData trd=new TransactionRecordData();
						
						double buy_price=sdd.getOpen();
						
						// ��¼������sdd��Ϣ
						trd.setStockcode(stockcode);
						trd.setBuySDD(sdd);
						trd.setPreStockDayDataList(preStockDayDataList);   // �ڽ��׶���trd�б���ǰ�����stock��Ʊ����
						trd.setPreIndexDayDataList(preIndexDayDataList);   // �ڽ��׶���trd�б���ǰ�����indexָ������
						
						trd.setModelType("ygtp");
						trd.setModelParam("����ǰ�������: 5 "+"������̬: ������ͻ�� "+" ��������: "+hold_days+" ����ظ�����: "+checkAssetsBack);
						trd.setTransactionBuyPrice(buy_price);
						
						
						// �жϲ�����������sdd��Ϣ
						StockDayData sdd_s=new StockDayData();
						if (j+1<stockDataList.size()) // �����һ�쳬�����������һ��Ϊsdd_a1
						{
							for (int k=j+1;k<stockDataList.size();k++)
							{
								sdd_s=(StockDayData)stockDataList.get(k);
								if (sdd_s.getClose_rise()<0 || sdd_s.getReal_rise()<0)  // �������������׵�������
								{
									break;
								}
							}
						
						}
						else
						{
							sdd_s=(StockDayData)stockDataList.get(j);		// ����������һ���������׳�����
						}
						trd.setSaleSDD(sdd_s);
							
						double profit=(sdd_s.getClose()-buy_price)/buy_price*100-0.2; 
						sdd_s.setProfit(profit);
						trd.setSaleSDD(sdd_s);
						trd.setTransactionProfit(profit);
						trd.setTransactionSalePrice(sdd_s.getClose());
						
						transactionDataList.add(trd);
							
						if (trd.getSaleSDD()!=null)
							assetsBackDate=trd.getSaleSDD().getDate();
						
					}
					
					
				}
				
				
			}
			
		}
		
		outputTransactionRecordReport_yg(transactionDataList, "����ͻ��");
	
		
	}
	
	
	
	
	// ���ɸĽ�ѡ��ģ��
	public void processStockByModel_yggj(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			// ����Ľ��׼�¼����
			int total_days=5;  
			int pre_days=100;
		
			if(stockDataList.size()<=total_days)   // ���׼�¼���������жϣ�����
				continue;
			
			for (int j=pre_days; j<stockDataList.size(); j++)
			{	
				
				StockDayData sdd_c=(StockDayData)stockDataList.get(j);  // ������Ϊj
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				
				double total_rise_b=sdd_b1.getClose_rise()+sdd_b2.getClose_rise()+sdd_b3.getClose_rise();
						
				if (1>0 
				 && sdd_b1.getClose_rise()<9.9 
				 && sdd_b1.getClose_rise()>0
				 && sdd_b1.getClose()-sdd_b1.getOpen()>=0   // b1Ϊ�����ǰ� 
				 && sdd_b2.getClose_rise()>9.9
				 && sdd_b2.getClose()-sdd_b2.getLow()>1   // b2Ϊ������ͣ�� 
				 && sdd_b3.getClose_rise()>0
				 && sdd_b3.getClose()-sdd_b3.getLow()>1   // b3Ϊ����  
				 && total_rise_b>20 && total_rise_b<30  	// b1-b3���Ƿ�����25%,С��30%
				 && sdd_c.getOpen_rise()<0 && sdd_c.getOpen_rise()>-9 // ���뵱�쿪��Ϊ�Ϳ���С���߿�
	//			 && checkIndexEnv(sdd_c)  // �鿴֮ǰ��ָ�����
	//			 && checkOpenEnv(sdd_c)   // �鿴���쿪�̵��������		 
	//			 && sdd_c.getClose_rise()-sdd_c.getOpen_rise()>0 && sdd_c.getClose_rise()-sdd_c.getOpen_rise()<4
	//			 && sdd_c.getClose_rise()>0
				 && checkPastDaysHighPrice(sdd_b1, stockDataList, j, pre_days) // ����Ƿ�ͻ����ǰn���λ
				)
				{
	
						// �������׼�¼����
						TransactionRecordData trd=new TransactionRecordData();
						
						// ��¼������sdd��Ϣ
						trd.setStockcode(stockcode);
						trd.setBuySDD(sdd_c);
						
						// �жϲ�����������sdd��Ϣ
						StockDayData sdd_a1;
						if (j+1<stockDataList.size()) // �����һ�쳬�����������һ��Ϊsdd_a1
						{
							sdd_a1=(StockDayData)stockDataList.get(j+1);
						}
						else
						{
							sdd_a1=(StockDayData)stockDataList.get(j);
						}
						trd.setSaleSDD(sdd_a1);
							
						transactionDataList.add(trd);
							
				}
				
			}
			
		}
		
		outputTransactionRecordReport(transactionDataList, "���ɸĽ�");
	
		
	}
	
	// ����˫��ѡ��ģ��
	public void processStockByModel_ygsb(List researchStockCodeList, String startDate, String endDate)
	{
		
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			// ����Ľ��׼�¼����
			int total_days=6;  
		
			if(stockDataList.size()<=total_days)   // ���׼�¼���������жϣ�����
				continue;
			
			for (int j=4; j<stockDataList.size()-1; j++)
			{	
				
				StockDayData sdd_c=(StockDayData)stockDataList.get(j);  // ������Ϊj
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				StockDayData sdd_b4=(StockDayData)stockDataList.get(j-4);
				
				double total_rise_b=sdd_b1.getClose_rise()+sdd_b2.getClose_rise()+sdd_b3.getClose_rise();
				
				if (
				 (1>0
				 && sdd_b1.getClose_rise()>9.9
				 && sdd_b1.getClose_rise()-sdd_b1.getOpen_rise()>1   // b1Ϊ������ͣ�� 
				 && sdd_b2.getClose_rise()>9.9
				 && sdd_b2.getClose_rise()-sdd_b2.getOpen_rise()>1   // b2Ϊ������ͣ�� 
//				 && sdd_b3.getClose_rise()+sdd_b4.getClose_rise()<6  // ���������ã����ƺܶ������
				 && sdd_c.getOpen_rise()<8
//				 ||
//				 (1>0
//				 && sdd_b1.getClose_rise()<9.9 
//				 && sdd_b1.getClose()-sdd_b1.getOpen()>=0   // b1Ϊ�����ǰ� 
//				 && sdd_b2.getClose_rise()>9.9
//				 && sdd_b2.getClose()-sdd_b2.getLow()>=1   // b2Ϊ������ͣ�� 
//				 && sdd_b3.getClose_rise()>0
//				 && sdd_b3.getClose()-sdd_b3.getOpen()>=0   // b3Ϊ���� 
//				 && total_rise_b>20 
//				 && total_rise_b<30  	// b1-b3���Ƿ�����20%,С��30%
//				 && sdd_c.getOpen_rise()<3 && sdd_c.getOpen_rise()>-9 // ���뵱�쿪��Ϊ�Ϳ���С���߿�
				 )
				 
	//		     && sdd_b3.getClose_rise()+sdd_b4.getClose_rise()<6
	//			 && sdd_c.getOpen_rise()<3 && sdd_c.getOpen_rise()>-9 // ���뵱�쿪��Ϊ�Ϳ���С���߿�
	//			 && checkIndexEnv(sdd_c)  // �鿴֮ǰ��ָ�����
	//			 && checkOpenEnv(sdd_c)   // �鿴���쿪�̵��������		 
	//			 && sdd_c.getClose_rise()-sdd_c.getOpen_rise()>0 && sdd_c.getClose_rise()-sdd_c.getOpen_rise()<4
	//			 && sdd_c.getClose_rise()>0
				)
				{
					String stockType=CommonTool.getStockMarketType(sdd_c.getCode());
					List indexDataList=(List)stockIndexMap.get(stockType);
					StockDayData idd_b1=CommonTool.getStockDayData(indexDataList, sdd_b1.getDate());
					StockDayData idd_b2=CommonTool.getStockDayData(indexDataList, sdd_b2.getDate());
					StockDayData idd_b3=CommonTool.getStockDayData(indexDataList, sdd_b3.getDate());
					
//					double minDDZ=checkPastDaysDDZMin(indexDataList, idd_b1);
					
//					if (
//					    (idd_b1!=null
//						&& idd_b1.getMa_ddz()>7)
//						||
//					   (
//						idd_b1!=null
//						&& idd_b1.getMa_ddz()>3	   
//						&& idd_b2!=null
//						&& idd_b2.getMa_ddz()<idd_b1.getMa_ddz()
//						&& idd_b3!=null
//						&& idd_b3.getMa_ddz()<idd_b2.getMa_ddz()
//						)
//						)
					
					if (
							
					   idd_b1!=null &&
					   (
					      (stockType.equals("600") && idd_b1.getMa_macd()>10 && checkPastDaysMACDTrends(indexDataList, idd_b1)) 
					   || (stockType.equals("000") && idd_b1.getMa_macd()>30 && checkPastDaysMACDTrends(indexDataList, idd_b1))
					   || (stockType.equals("002") && idd_b1.getMa_macd()>20 && checkPastDaysMACDTrends(indexDataList, idd_b1))
					   || (stockType.equals("300") && idd_b1.getMa_macd()>10 && checkPastDaysMACDTrends(indexDataList, idd_b1))
					   )
					   
					  )
					{
						// �������׼�¼����
						TransactionRecordData trd=new TransactionRecordData();
						
						// ��¼������sdd��Ϣ
						trd.setStockcode(stockcode);
						trd.setBuySDD(sdd_c);
						
						// �жϲ�����������sdd��Ϣ
						StockDayData sdd_a1;
						if (j+1<stockDataList.size()) // �����һ�쳬�����������һ��Ϊsdd_a1
						{
							sdd_a1=(StockDayData)stockDataList.get(j+1);
						}
						else
						{
							sdd_a1=(StockDayData)stockDataList.get(j);
						}
						trd.setSaleSDD(sdd_a1);
							
						transactionDataList.add(trd);
							
					}
				}
				
			}
			
		}
		
//		transactionDataList=getBestCandidateList(transactionDataList);
		
		outputTransactionRecordReport(transactionDataList, "����˫��");
	
		
	}
	

	
	
	
	// ����ѡ��ģ��
	public List search_yg(List researchStockCodeList, String startDate, String endDate, int preRefDays)
	{
		
		
		String preStartDate=CommonTool.getStockTransDate(startDate, -preRefDays+1);  // �ҳ������вο����ڽ��׼�¼����ʼ����
		
		List transactionDataList=new ArrayList(); 
		

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+preStartDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Search stock by model_yg: "+stockcode);
			
			// ����Ľ��׼�¼����
			int total_days=preRefDays;  
		
			if(stockDataList.size()<total_days)   // ���׼�¼���������жϣ�����
				continue;
			
			for (int j=preRefDays-1; j<stockDataList.size(); j++)
			{	
				
//				StockDayData sdd_c=(StockDayData)stockDataList.get(j);  // ������Ϊj
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-2);
				
				double total_rise_b=sdd_b1.getClose_rise()+sdd_b2.getClose_rise()+sdd_b3.getClose_rise();
						
				if (1>0 
				 && sdd_b1.getClose_rise()<9.9 
				 && sdd_b1.getClose_rise()>0
				 && sdd_b1.getClose()-sdd_b1.getOpen()>=0   // b1Ϊ�����ǰ� 
				 && sdd_b2.getClose_rise()>9.9
				 && sdd_b2.getClose()-sdd_b2.getOpen()>=0   // b2Ϊ������ͣ�� 
				 && sdd_b3.getClose_rise()>0
				 && sdd_b3.getClose()-sdd_b3.getOpen()>=0   // b3Ϊ����  
				 && total_rise_b>20 && total_rise_b<30  	// b1-b3���Ƿ�����15%,С��30%
//				 && sdd_c.getOpen_rise()<3 && sdd_c.getOpen_rise()>-9 // ���뵱�쿪��Ϊ�Ϳ���С���߿�
	//			 && checkIndexEnv(sdd_c)  // �鿴֮ǰ��ָ�����
	//			 && checkOpenEnv(sdd_c)   // �鿴���쿪�̵��������		 
	//			 && sdd_c.getClose_rise()-sdd_c.getOpen_rise()>0 && sdd_c.getClose_rise()-sdd_c.getOpen_rise()<4
	//			 && sdd_c.getClose_rise()>0
				 
				)
				{

						// �������׼�¼����
						TransactionRecordData trd=new TransactionRecordData();
						
						// ��¼������sdd��Ϣ
						trd.setStockcode(stockcode);
						trd.setBuySDD(sdd_b1);
						trd.setSaleSDD(sdd_b1);
							
						transactionDataList.add(trd);
							
				}
				
			}
			
		}
		
		return transactionDataList;	
		
	}
	
	public boolean checkIndexEnv(StockDayData sdd)
	{
		boolean result=true;
		
		String stockCode=sdd.getCode();
		String preCode=stockCode.substring(0, 3);
		List stockIndexList=new ArrayList();
		
		// ���ݹ�Ʊ����ѡ�����Ӧ�Ĺ�ָ
		if (preCode.substring(0,1).equals("6") )
		{
			stockIndexList=(List)stockIndexMap.get("600");
		}
		
		if (preCode.substring(0,1).equals("3") )
		{
			stockIndexList=(List)stockIndexMap.get("300");
		}

		if (preCode.equals("002") )
		{
			stockIndexList=(List)stockIndexMap.get("002");
		}

		if (preCode.equals("000") )
		{
			stockIndexList=(List)stockIndexMap.get("000");
		}
		
		// �鿴��ָ����
		for (int i=5; i<stockIndexList.size(); i++)
		{
			
			StockDayData idd=(StockDayData)stockIndexList.get(i);
			
			if (idd.getDate().equals(sdd.getDate()))
			{
				StockDayData idd_b1=(StockDayData)stockIndexList.get(i-1);
				StockDayData idd_b2=(StockDayData)stockIndexList.get(i-2);
				StockDayData idd_b3=(StockDayData)stockIndexList.get(i-3);
				StockDayData idd_b4=(StockDayData)stockIndexList.get(i-4);
				StockDayData idd_b5=(StockDayData)stockIndexList.get(i-5);
				
//				if (
//					idd_b2.getReal_rise()<-0.2 && idd_b2.getClose_rise()<-0.2 && 
//					idd_b1.getReal_rise()<0 && idd_b1.getClose_rise()<0)  // b1, b2��ָ��Ϊ��������
//				{
//					result=false;  // ����
//				}
				
				if (
//					(idd_b1.getReal_rise()<-0.1 && idd_b2.getReal_rise()>0.1)
//					|| (idd_b1.getReal_rise()>0.1 && idd_b2.getReal_rise()>0.1)
					idd_b1.getMa_5()>idd_b1.getMa_10()
					)
				{
					result=true;
				}
				else
				{
					result=false;
				}
				
			}
	
		}
		
		return result;
		
	}

	
	
	//	����ͻ��ģ��
	public void processStockByModel_hptp(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			int trend_days=100; // ǰn���Ʊ���ƺ���ƽ̹ 5����
			int pre_days=120;  // ���ڹ�ȥ������Ĺɼ�8����
			int total_value=300; // ����ֵ1000������
			double max_wave=20; // ��󲨶�15%
			
			int prof_days=10;
			int total_days=pre_days+prof_days;  // �ܹ��Ľ��׼�¼����
			if(stockDataList.size()<total_days)   // ���׼�¼���������жϣ�����
				continue;
			
			for (int j=pre_days; j<stockDataList.size(); j++)
			{	
				
				// ��ͷ����������ÿ�������
				StockDayData sdd=(StockDayData)stockDataList.get(j);  // ������Ϊj
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				
				// ��ǰ����ֵ
				double sdd_total_value=CommonTool.getDoubleNumberWithTwoBit(sdd.getTotal_value()/100000000);
				double current_total_value=CommonTool.getStockCurrentLiquidValue(stockDataList);
				
				if (1>0 
				 && checkPastDaysHighPrice(sdd_b1, stockDataList, j, pre_days) // ����Ƿ�ͻ����ǰn���λ
//				 && sdd_total_value>total_value
//				 && sdd.getClose()/sdd_b3.getOpen()>1.1
//				 && sdd_b1.getClose_rise()>9.9
				)
				{
					
					List preDaysDataList=stockDataList.subList(j-trend_days, j-1);
					boolean preStockTrend=checkStockPreTrend_DDR_RUR(preDaysDataList, max_wave); 
					
					if (preStockTrend==true)
					{
						
						// ��¼�����¼������������棬��̬��������׳��ղ���¼�׳�ʱ������ֵ
						TransactionRecordData trd=new TransactionRecordData();
						trd.setStockcode(stockcode);
						trd.setBuySDD(sdd);
						trd.setSaleSDD(sdd);
						for (int k=j+1; k<stockDataList.size()-1 && k<j+365 ; k++)
						{
							
							StockDayData sdd_k=(StockDayData)stockDataList.get(k);
							trd.setSaleSDD(sdd_k);
								
							List profitDayDataList=stockDataList.subList(j, k);
							StockRecordDDR srd=CommonTool.calculateMaxDrawDownBySDD(profitDayDataList);
							if (srd.getDDR()>15) // ���ֻس�����10%ʱ�ͽ�������������
							{
								break;								
							}
							
						}
						
						transactionDataList.add(trd);
						
				
					}
					
				}  // end if 
				
			}
			
		} // end for 
		
		
		outputTransactionRecordReport(transactionDataList, "����ͻ��");
		
	}
	
	
	//	����ͻ��ģ��
	public void processStockByModel_tztp(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			int n=10; // �۲�ǰn���Ʊ����
//			double max_wave=15; // ��󲨶�15%
		
			if(stockDataList.size()<n)   // ���׼�¼���������жϣ�����
				continue;
			
			for (int j=n; j<stockDataList.size()-2; j++) // �ӵ�n�쿪ʼ�ж��Ƿ�����,֮ǰ��0~n-1�����ƹ۲���
			{
				
				StockDayData sdd_buy=(StockDayData)stockDataList.get(j);
				StockDayData sdd_buy_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_buy_a1=(StockDayData)stockDataList.get(j+1);
				StockDayData sdd_buy_a2=(StockDayData)stockDataList.get(j+2);
				
				if (sdd_buy.getDate().trim().equals("2019/02/01"))
				{
					int s=0;
					s++;
				}
				
				// ���ƹ۲���list
				List observeList=stockDataList.subList(j-n, j);    // ��ȥn��Ĺ۲�
				StockDayData highestPriceSDD=getHighestPriceSDD(observeList);  // ��ȥn�����߼���
				int highPos=highestPriceSDD.getPosNum();
				List beforeHighestList=stockDataList.subList(j-n, highPos);
				
				// ����Ƿ�ͻ����ǰn���λ
				if (
					sdd_buy.getClose()>highestPriceSDD.getClose()		   // �������̴��¸�
					&& sdd_buy.getPosNum()-highestPriceSDD.getPosNum()>2  // ��������>=3��
					&& sdd_buy.getPosNum()-highestPriceSDD.getPosNum()<5
//					&& checkDayData_MA_dtpl(sdd_buy)					   // �����Ƕ�ͷ����
					&& checkDayData_MA_dtpl(beforeHighestList)			   // highestǰ���춼�Ƕ�ͷ����
					&& checkDayData_MA_dtfs(beforeHighestList)			   // highestǰ���춼�Ƕ�ͷ��ɢ
					&& sdd_buy.getReal_rise()>0 						   // ����rise����������
					&& sdd_buy.getMa_macd()>0 							   // ����macd������
	//				&& sdd_buy.getMa_macd()>=sdd_buy_b1.getMa_macd()	   // ����macd�������macd��������
	//				&& sdd_buy.getClose()/highestPriceSDD.getClose()<1.1   // ����۱�ǰ�ڸߵ㲻������̫��
				)
				{
						
						// ����������������¼���룬��̬��������׳��ղ���¼�׳�ʱ������ֵ
						TransactionRecordData trd=new TransactionRecordData();
						trd.setStockcode(stockcode);
						trd.setBuySDD(sdd_buy_a1);  // j+1�ڶ��쿪������
						trd.setSaleSDD(sdd_buy_a2); // Ĭ���ڵ�������������
						
						System.out.print("BuyDate: "+sdd_buy_a1.getDate()+" ");
						int days=sdd_buy.getPosNum()-highestPriceSDD.getPosNum();
						System.out.print(" "+highestPriceSDD.getDate()+" ");
						System.out.print(" "+days+" ");
						
						for (int k=j+2; k<stockDataList.size()-1; k++)   // �����������
						{
							
							StockDayData sdd_sale=(StockDayData)stockDataList.get(k);  // ��������Ľ�����
							StockDayData sdd_sale_b1=(StockDayData)stockDataList.get(k-1);
							
							if (
							sdd_sale.getReal_rise()<0				// �����������µ�
							&& sdd_sale.getClose_rise()<0			// ����ʵ�����յ�
							&& sdd_sale.getMa_macd()<=sdd_sale_b1.getMa_macd() // ����macd�������macd�����½�									
							)
							{
								trd.setSaleSDD(sdd_sale);		// ���ڵ�������ʱ�����̼�����
								System.out.println("SaleDate: "+sdd_sale.getDate());
								
								break;
							}
							
//							List profitDayDataList=stockDataList.subList(j, k);
//							StockRecordDDR srd=CommonTool.calculateMaxDrawDownBySDD(profitDayDataList);
//							if (srd.getDDR()>15) // ���ֻس�����10%ʱ�ͽ�������������
//							{
//								break;								
//							}
							
						}
						
						transactionDataList.add(trd);
						
				
				}  // end if 
				
			}
			
		} // end for 
		
		
		outputTransactionRecordReport(transactionDataList, "����ͻ��");
		
	}
	
	
	//	��ͣ�Ա�ģ��
	public void processStockByModel_ztdb(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			String code=(String)researchStockCodeList.get(i);
			
			List stockDataList=new ArrayList();
			String stockcode="";
			if (code.startsWith("index"))
			{
				// ���һָֻ������ʷ��������
				stockcode=((String)researchStockCodeList.get(i)).substring(5); // ȥ��ǰ׺ index
				String stockfilename="index"+stockcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);

			}
			else
			{
				// ���һֻ��Ʊ����ʷ��������
				stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
				String stockfilename="stock"+stockcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
				
			}
			
			
			System.out.println("Process stock: "+stockcode);
			
			String stockType=CommonTool.getStockMarketType(stockcode);
			Map stockMarketDataRecordMap=CommonTool.getStockMarketDataRecordMap(stockType); 
			
			int n=2; // �۲�ǰn���Ʊ����
		
			if(stockDataList.size()<n)   // ���׼�¼���������жϣ�����
				continue;
			
			for (int j=n; j<stockDataList.size()-2; j++) // �ӵ�n�쿪ʼ�ж��Ƿ�����,֮ǰ��0~n-1�����ƹ۲���
			{
				
				StockDayData sdd_buy=(StockDayData)stockDataList.get(j);
				StockDayData sdd_buy_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_buy_a1=(StockDayData)stockDataList.get(j+1);
				MarketRDDayData mdd_buy=(MarketRDDayData)stockMarketDataRecordMap.get(sdd_buy.getDate());
				MarketRDDayData mdd_buy_b1=(MarketRDDayData)stockMarketDataRecordMap.get(sdd_buy_b1.getDate());
				MarketRDDayData mdd_buy_a1=(MarketRDDayData)stockMarketDataRecordMap.get(sdd_buy_a1.getDate());
				
				// �����ͣ��仯
				double ztb_riseRate=(double)mdd_buy.getRise10()/(double)mdd_buy_b1.getRise10();
				if (
					1>0
					&& ztb_riseRate>1.7   // �г���ͣ���ǰһ��������
//					&& mdd_buy.getRise10()>80
					&& sdd_buy.getReal_rise()>0  // �����Ǻ�������
//					&& sdd_buy.getMa_ddz()-sdd_buy_b1.getMa_ddz()>0  // macd�Ǻ���
//					&& mdd_buy.getRise10()>70 && mdd_buy.getRise10()<200
//					&& sdd_buy.getMa_ddz()>=0
//					&& sdd_buy_b1.getClose_rise()>-3
//					&& checkDayData_MA(sdd_buy)
//					&& mdd_buy.getRise10()>40		// �����г���ͣ�����m��
				)
				{
						
						// ����������������¼���룬��̬��������׳��ղ���¼�׳�ʱ������ֵ
						TransactionRecordData trd=new TransactionRecordData();
						trd.setStockcode(stockcode);
						trd.setBuySDD(sdd_buy);  // ������������,������ETF��ͣ������;���룬���ּ��亱������ʷ��ֻ���ֹ�һ��
						trd.setSaleSDD(sdd_buy_a1); // Ĭ���ڵڶ�������������������ETF��ͣ������;����������Ҳ���亱��
						
						System.out.print("BuyDate: "+sdd_buy.getDate()+" ");						
						
						for (int k=j+1; k<stockDataList.size()-1; k++)   // �����������
						{
							
							StockDayData sdd_sale=(StockDayData)stockDataList.get(k);  // ��������Ľ�����
							StockDayData sdd_sale_b1=(StockDayData)stockDataList.get(k-1);
							MarketRDDayData mdd_sale=(MarketRDDayData)stockMarketDataRecordMap.get(sdd_sale.getDate());
							MarketRDDayData mdd_sale_b1=(MarketRDDayData)stockMarketDataRecordMap.get(sdd_sale_b1.getDate());
							
							double profit=0;
							
							// ���ڴ��������ֹ��
							double profit_low=((sdd_sale.getLow()-sdd_buy.getClose())/sdd_buy.getClose())*100-0.2;  // ��ȥ������0.16���������
							if (profit_low<-2)
							{
								profit=-2;
								
								sdd_sale.profit=profit;
								trd.setSaleSDD(sdd_sale);		// ���ڵ�������ʱ�����̼�����
								trd.setTransactionProfit(profit);
								System.out.println("SaleDate: "+sdd_sale.getDate()+" Profit: "+profit);
								
								break;
							}
							else
							{
								// �������зǴ������������ͣ�ԱȾ���
								double ztb_downRate=(double)(mdd_sale.getRise10()/(double)mdd_sale_b1.getRise10());
								if (
										1>0
//										&& sdd_sale.getReal_rise()<0
//										&& sdd_sale.getClose_rise()<0
										&& ztb_downRate<0.7	
//										
								)
								{
									
									profit=((sdd_sale.getClose()-sdd_buy.getClose())/sdd_buy.getClose())*100-0.2;  // ��ȥ������0.16���������								
									
									sdd_sale.profit=profit;
									trd.setSaleSDD(sdd_sale);		// ���ڵ�������ʱ�����̼�����
									trd.setTransactionProfit(profit);
									System.out.println("SaleDate: "+sdd_sale.getDate()+" Profit: "+profit);
									
									break;
								}
						
							}
							
						}
						
						transactionDataList.add(trd);
						
				
				}  // end if 
				
			}
			
		} // end for 
		
		
		outputTransactionRecordReport(transactionDataList, "��ͣ�Ա�");
		
	}
	
	
	
	//	5%�ǵ��Ա�ģ��
	public void processStockByModel_zddb5(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			String code=(String)researchStockCodeList.get(i);
			
			List stockDataList=new ArrayList();
			String stockcode="";
			if (code.startsWith("index"))
			{
				// ���һָֻ������ʷ��������
				stockcode=((String)researchStockCodeList.get(i)).substring(5); // ȥ��ǰ׺ index
				String stockfilename="index"+stockcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);

			}
			else
			{
				// ���һֻ��Ʊ����ʷ��������
				stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
				String stockfilename="stock"+stockcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
				
			}
			
			
			System.out.println("Process stock: "+stockcode);
			
			String stockType=CommonTool.getStockMarketType(stockcode);
			Map stockMarketDataRecordMap=CommonTool.getStockMarketDataRecordMap(stockType); 
			
			int n=2; // �۲�ǰn���Ʊ����
		
			if(stockDataList.size()<n)   // ���׼�¼���������жϣ�����
				continue;
			
			for (int j=n; j<stockDataList.size()-2; j++) // �ӵ�n�쿪ʼ�ж��Ƿ�����,֮ǰ��0~n-1�����ƹ۲���
			{
				
				StockDayData sdd_buy=(StockDayData)stockDataList.get(j);
				StockDayData sdd_buy_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_buy_a1=(StockDayData)stockDataList.get(j+1);
				MarketRDDayData mdd_buy=(MarketRDDayData)stockMarketDataRecordMap.get(sdd_buy.getDate());
				MarketRDDayData mdd_buy_b1=(MarketRDDayData)stockMarketDataRecordMap.get(sdd_buy_b1.getDate());
				MarketRDDayData mdd_buy_a1=(MarketRDDayData)stockMarketDataRecordMap.get(sdd_buy_a1.getDate());
				
				// ���5%�ǵ��Ա�
				double zd5_compareRate_buy=(double)(mdd_buy.getRise10()+mdd_buy.getRise7()+mdd_buy.getRise5())
						/(double)(mdd_buy.getDown10()+mdd_buy.getDown7()+mdd_buy.getDown5());
				if (
					mdd_buy.getDate().compareTo(lastSaleDate)>0
					&& zd5_compareRate_buy>3   // �г��ǵ�5%�ļ����Ա�
					&& sdd_buy.getReal_rise()>0  // �����Ǻ�������
//					&& sdd_buy_b1.getReal_rise()<0  // �����������µ�
//					&& sdd_buy.getMa_5()>sdd_buy.getMa_10() 
//					&& sdd_buy.getMa_10()>sdd_buy.getMa_20()
//					&& mdd_buy.getRise10()>40		// �����г���ͣ�����m��
				)
				{
						
						// ����������������¼���룬��̬��������׳��ղ���¼�׳�ʱ������ֵ
						TransactionRecordData trd=new TransactionRecordData();
						trd.setStockcode(stockcode);
						trd.setBuySDD(sdd_buy);  // ������������,������ETF��ͣ������;���룬���ּ��亱������ʷ��ֻ���ֹ�һ��
						trd.setSaleSDD(sdd_buy_a1); // Ĭ���ڵڶ�������������������ETF��ͣ������;����������Ҳ���亱��
						
						System.out.print("BuyDate: "+sdd_buy.getDate()+" ");						
						
						for (int k=j+1; k<stockDataList.size()-1; k++)   // �����������
						{
							
							StockDayData sdd_sale=(StockDayData)stockDataList.get(k);  // ��������Ľ�����
							StockDayData sdd_sale_b1=(StockDayData)stockDataList.get(k-1);
							MarketRDDayData mdd_sale=(MarketRDDayData)stockMarketDataRecordMap.get(sdd_sale.getDate());
							MarketRDDayData mdd_sale_b1=(MarketRDDayData)stockMarketDataRecordMap.get(sdd_sale_b1.getDate());
							
							double profit=0;
							
							// ���ڴ��������ֹ��
							if (sdd_sale.getLow_rise()<-2)
							{
								
								profit=((sdd_sale_b1.getClose()*0.98-sdd_buy.getClose())/sdd_buy.getClose())*100-0.2;  // ��ȥ������0.16���������
								
								sdd_sale.profit=profit;
								trd.setSaleSDD(sdd_sale);		// ���ڵ�������ʱ�����̼�����
								trd.setTransactionProfit(profit);
								System.out.println("SaleDate: "+sdd_sale.getDate()+" Profit: "+profit);
								
								lastSaleDate=sdd_sale.getDate();
								
								break;
							}
							else
							{
								// �������зǴ������������ͣ�ԱȾ���
								double zd5_compareRate_sale=(double)(mdd_sale.getRise10()+mdd_sale.getRise7()+mdd_sale.getRise5())
										/(double)(mdd_sale.getDown10()+mdd_sale.getDown7()+mdd_sale.getDown5());
								if (
										1>0
										&& sdd_sale.getReal_rise()<0
										&& zd5_compareRate_sale<2						
								)
								{
									
									profit=((sdd_sale.getClose()-sdd_buy.getClose())/sdd_buy.getClose())*100-0.2;  // ��ȥ������0.16���������								
									
									sdd_sale.profit=profit;
									trd.setSaleSDD(sdd_sale);		// ���ڵ�������ʱ�����̼�����
									trd.setTransactionProfit(profit);
									System.out.println("SaleDate: "+sdd_sale.getDate()+" Profit: "+profit);
									
									lastSaleDate=sdd_sale.getDate();
									
									break;
								}
						
								
								if (k==stockDataList.size()-2)   // �������ݵ����һ�죬��������һ��Ϊ�����ռ���
								{

									profit=((sdd_sale.getClose()-sdd_buy.getClose())/sdd_buy.getClose())*100-0.2;  // ��ȥ������0.16���������								
									
									sdd_sale.profit=profit;
									trd.setSaleSDD(sdd_sale);		// ���ڵ�������ʱ�����̼�����
									trd.setTransactionProfit(profit);
									System.out.println("SaleDate: "+sdd_sale.getDate()+" Profit: "+profit);
									
									lastSaleDate=sdd_sale.getDate();
									
									break;
									
									
								}
								
								
							}
							
						}
						
						transactionDataList.add(trd);
						
				
				}  // end if 
				
			}
			
		} // end for 
		
		
		outputTransactionRecordReport(transactionDataList, "�ǵ�5�Ա�");
		
	}
	

	//	���Ǹ���ģ��
	public void processStockByModel_lzgs(List researchStockCodeList)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename);
			
			System.out.println("Process stock: "+stockcode);	
	
			int obv_days=100; // �۲���
			int sta_days=5;  // ������
			int prof_days=30; // ��������������
			int pre_days=obv_days+sta_days;
			
			int total_days=obv_days+sta_days+prof_days;  // �ܹ��Ľ��׼�¼����
			
			if(stockDataList.size()<total_days)   // ���׼�¼���������жϣ�����
				return;
			
			for (int j=pre_days; j<stockDataList.size(); j++)
			{	
				
				// ��ͷ����������ÿ�������
				StockDayData sdd=(StockDayData)stockDataList.get(j);  // ������Ϊj
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				StockDayData sdd_b4=(StockDayData)stockDataList.get(j-4);
				StockDayData sdd_b5=(StockDayData)stockDataList.get(j-5);
				
				// ��ͷ�������������Ƿ�
				double total_rise_b=sdd_b1.getClose_rise()+sdd_b2.getClose_rise()+sdd_b3.getClose_rise()+sdd_b4.getClose_rise()+sdd_b5.getClose_rise();
				double sdd_total_value=CommonTool.getDoubleNumberWithTwoBit(sdd.getLiquid_value()/100000000);
				double current_total_value=CommonTool.getStockCurrentLiquidValue(stockDataList);
				
				if (1>0 
	//			 && checkDayData_MA(sdd_b1) 
				 && checkDayData_MA(sdd_b2) 
				 && checkDayData_MA(sdd_b3) 
				 && checkDayData_MA(sdd_b4) 
	//			 && checkDayData_MA(sdd_b5) 
				 && checkPastDaysHighPrice(sdd, stockDataList, j, 120) // ����Ƿ�ͻ����ǰn���λ
	//			 && current_total_value>1000
	//			 && sdd_b6.getLow()<sdd_b6.getMa_5()  // b6����ǰ�۸������վ�����
	//			 && total_rise_b>15 && total_rise_b<30  // b1-b5���Ƿ�����15%,С��30%
				 && sdd.getClose_rise()>0 && sdd.getClose()>sdd.getOpen() && sdd.getClose()>sdd_b1.getHigh()   // c����Ϊ����
				 && sdd_b1.getClose()-sdd_b1.getOpen()<0   // b1Ϊ���� 
				 && sdd_b2.getClose_rise()>0 && sdd_b2.getClose()-sdd_b2.getOpen()>0   // b2Ϊ���� 
				 && sdd_b3.getClose_rise()>0 && sdd_b3.getClose()-sdd_b3.getOpen()>0   // b3Ϊ���� 
				 && sdd_b4.getClose_rise()>0 && sdd_b4.getClose()-sdd_b4.getOpen()>0   // b4Ϊ���� 
	//			 && sdd_b1.getMa_5()-sdd_b1.getMa_20()>sdd_b5.getMa_5()-sdd_b5.getMa_20()  // b1��5,20�߾����b5��5,20�߾�,�ʷ�ɢ
	//			 && (sdd_b1.getMa_5()-sdd_b1.getMa_60())/sdd_b1.getMa_5()<0.3  // b1��5�վ��߻�û��Զ��60�վ��ߣ�����������
				)
				{
					
	//				List preDaysDataList=stockDataList.subList(j-pre_days, j-sta_days-1);
	//				int preStockTrend=checkStockTrend(preDaysDataList);  // 0: flat, 1: small rise, 2: middle rise, 3: big rise
	//				
	//				if (preStockTrend==0)
					{
						// ��¼�����¼������������棬��̬��������׳��ղ���¼�׳�ʱ������ֵ
						for (int k=j+1; k<stockDataList.size()-3 && k<j+120 ; k++)
						{
							StockDayData sdd_a1=(StockDayData)stockDataList.get(k);
	//						StockDayData sdd_a2=(StockDayData)stockDataList.get(k+1);
							if (sdd_a1.getOpen()>sdd_a1.getClose() )  // ��������
							{
								TransactionRecordData trd=new TransactionRecordData();
								trd.setStockcode(stockcode);
								trd.setBuySDD(sdd);
								
								double profit=(sdd_a1.getClose()-sdd.getClose())/sdd.getClose()*100;
								sdd_a1.setProfit(profit);
								trd.setSaleSDD(sdd_a1);
								
								transactionDataList.add(trd);
								break;
							}
							
						}
						
					}
					
				}
				
			}
			
		}
		
		
		outputTransactionRecordReport(transactionDataList, "���Ǹ���");
		
		
	}
	
	
	// ��Ӱ����ģ��
	public void processStockByModel_syft(List researchStockCodeList)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename);
			
			System.out.println("Process stock: "+stockcode);
			int upPercent=3;
			int downPercent=4;
			double profit=3;
			for (int j=10; j<stockDataList.size()-1; j++)
			{	
				
				// ÿ�������
				StockDayData sdd=(StockDayData)stockDataList.get(j); 
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1); 
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);  // ��ͣ
				
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				StockDayData sdd_b4=(StockDayData)stockDataList.get(j-4);
				StockDayData sdd_b5=(StockDayData)stockDataList.get(j-5);
				StockDayData sdd_b6=(StockDayData)stockDataList.get(j-6);
				StockDayData sdd_b7=(StockDayData)stockDataList.get(j-7);
				
				StockDayData sdd_a1=(StockDayData)stockDataList.get(j+1);
				
				
					
				if 
				(
					sdd_b3.getClose_rise()<9.9  // b3 ��һ����ͣ����ͣ��ȥ�����¹�
					&& sdd_b3.getClose_rise()<9.9
					&& sdd_b4.getClose_rise()<9.9
					&& sdd_b5.getClose_rise()<9.9
					&& sdd_b6.getClose_rise()<9.9
					 && checkDayData_MA(sdd_b3)
					 && checkDayData_MA(sdd_b4) 
					 && checkDayData_MA(sdd_b5) 
					 && checkDayData_MA(sdd_b6) 
					 && checkDayData_MA(sdd_b7)  
					&& sdd_b2.getClose_rise()>9.9 	// b2 ����ͣ
					&& sdd_b1.getHigh_rise()-sdd_b1.getClose_rise()>upPercent  // b1�г���Ӱ��>4%
					&& sdd_b1.getOpen_rise()>0	// b1�߿�
					&& sdd_b1.getClose()-sdd_b1.getOpen()>0	// b1�Ǻ���
					&& sdd.getLow_rise()<-downPercent	// c�����д����̽<-4%
				)
				{
				
					// �������׼�¼
					TransactionRecordData trd=new TransactionRecordData();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(sdd);
					
					// �������롢�����ļ۸��׼
					double buyPrice=sdd_b1.getClose()*(1-downPercent/100);
					double salePrice=buyPrice*(1+profit/100);
					
					// ���ݵڶ����������profit����
	//				if (sdd_a1.getHigh()>salePrice)
	//				{
	//					sdd_a1.setProfit(3);
	//				}
	//				else
					{
						profit=(sdd_a1.getClose()-buyPrice)/buyPrice*100;
						sdd_a1.setProfit(profit);
					}
					trd.setSaleSDD(sdd_a1);
					
					// ��¼���׽��
					transactionDataList.add(trd);
					
				}
				
			}
			
		}
		
		// ���ȫ�����׼�¼������
		outputTransactionRecordReport(transactionDataList, "��Ӱ����");
		
	}
	
	
	//	����̽��ģ��
	public List processStockByModel_dztd(List researchStockCodeList, String startDate, String endDate)
	{
		
		// ��ȡ��ʷ�����г�����
		marketDataRecordMap=CommonTool.loadMarketDataRecordMap("all");
		
		List transactionDataList=new ArrayList();
				 
		// ȡ��ÿֻ  ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻETF���Ʊ����ʷ��������
			String researchcode=((String)researchStockCodeList.get(i));
			List stockDataList;
			if (researchcode.startsWith("index"))
			{
				String stockfilename=researchcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
				System.out.println("Process stock: "+researchcode);
			}
			else
			{
				String stockcode=researchcode.substring(2); // ȥ��ǰ׺ sh, sz
				String stockfilename="stock"+stockcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
				System.out.println("Process stock: "+stockcode);
			}
			
			
			int check_days=5;   // �����������������
			int hold_days=20;    // �������е�����
			double td_length=1.5;  // ����̽�׵ĳ���: ���̵����͵�߼����㣨����ƽ������̽�볤�ȣ���Щ����Զ����ƽ��ֵ����̽�붼�ǽ��׶���
//			double buy_rise=2;   // �����: ��������͵�߼����㣨�������Ҫ���ؼ�������۸�����̽��ĳ����м۸�Ҫ���ͣ��ӽ������ĳɱ���
//			double sale_rise=2;  // ������: ������������߼����� �����Է�����������Ҫ̰�ƣ���׬���У�
//			double over_rise=8;  // ���߻����: ������������͵�߼����㣨�����������ӯ���ϴ�����ۣ��Ͳ����ٽ����ˣ��Է������������ߣ�
//			double loss_rise=5;  // ��ֹ���: ���ֿ������͵�ͼ����㣨���Բ���һ�Σ�̯�ͳɱ���һ������������������
			double down10=500;   // ֹ���ͣ��
			boolean checkAssetsBack=true;
			String assetsBackDate="";   // �ʲ��������ڣ���Ϊ�������������µ����ʽ���ã���Ҫ��һ����������ʶ�ʲ�����������
			
			for (int j=0; j<stockDataList.size(); j++)
			{	
				
				// ÿ�������
				StockDayData sdd=(StockDayData)stockDataList.get(j); 
				
				if (sdd.getDate().compareTo(assetsBackDate)<0 && checkAssetsBack)   // ��鵱ǰ�ʲ��Ƿ���ã������û�л������ܽ���
					continue;
				
				double dz_rise=0;
				if (sdd.getClose()>sdd.getOpen())
				{
					// ������
					dz_rise=sdd.getOpen_rise()-sdd.getLow_rise();
				}
				else
				{
					// ������
					dz_rise=sdd.getClose_rise()-sdd.getLow_rise();
				}
				
				if (dz_rise>td_length)
				{
//					double buy_price=(sdd.getLow()+sdd.getHigh())/2;   // Ԥ��������۸񣺵����յ��м��
//					double buy_price=sdd.getHigh();
//					double over_price=sdd.getLow()*(1+over_rise/100);   // Ԥ���Ŀ��ܳ��ָߵ�۸�5�����Ƿ�
//					double sale_price=buy_price*(1+sale_rise/100);   // Ԥ���������۸�2��������
//					double loss_price=sdd.getLow()*(1-loss_rise/100);   // Ԥ���Ŀ���ֹ���۸� 5�������
					
					
					int check_endday_pos=j+check_days;
					if (check_endday_pos>stockDataList.size()-1)
					{
						check_endday_pos=stockDataList.size()-1;
					}
						
					for (int b=j+1; b<=check_endday_pos; b++)  // �鿴����check_days���ڵĽ��׾�����������b
					{
						
						StockDayData sdd_b=(StockDayData)stockDataList.get(b);
						
//						if ( sdd_b.getHigh()>over_price )  // ��������˽ϸ��Ƿ������ٽ��н��ײ���
//						{
//							break;
//						}							
						
//						if ( sdd_b.getLow()<buy_price )  // ���������̽��Ԥ��������۸�����������
						{
//							
//							if (sdd_b.getOpen()<buy_price)   // ����ǿ��̾͵�������۸���������
//							{
//								buy_price=sdd_b.getOpen();  
//							}								
							
							double buy_price=sdd_b.getOpen();  // �ڶ��쿪�̾������ۼ۸�ߵ�
							
							TransactionRecordData trd=new TransactionRecordData();
							trd.setModelType("dztd");
							trd.setModelParam("����̽�׳���: "+td_length+" ��������: "+hold_days+"ֹ�����������ͣ��: "+down10);
							trd.setStockPrt(calculateStockPrt_dztd(sdd));
							
							trd.setStockcode(sdd.getCode());
							trd.setBuySDD(sdd_b);
							trd.setTransactionBuyPrice(buy_price);
							
							
							int hold_endday_pos=b+hold_days;
							if (hold_endday_pos>stockDataList.size()-1)
							{
								hold_endday_pos=stockDataList.size()-1;
							}
							
							for (int s=b+1; s<=hold_endday_pos; s++)	// �鿴����n���ڵĽ��׾�����������s
							{
								StockDayData sdd_s=(StockDayData)stockDataList.get(s);
//								if (sdd_s.getHigh()>sale_price)  // ���ĳһ�����м۸��ϳ嵽Ԥ���������۸�������ֹӯ
//								{
//										double profit=(sdd_s.getClose()-buy_price)/buy_price*100;
//										sdd_s.setProfit(profit);
//										trd.setSaleSDD(sdd_s);
//										trd.setTransactionProfit(profit);
//										break;
//								}
								
								MarketRDDayData mdd=(MarketRDDayData)marketDataRecordMap.get(sdd_s.getDate());
								
								if (mdd!=null && mdd.getDown10()>down10) // ���ĳһ����̳��ִ������ͣ��������ʱ����ֹ��
								{
										System.out.println(mdd.getDate()+" Down10: "+mdd.getDown10());
										double profit=(sdd_s.getClose()-buy_price)/buy_price*100-0.2;
										sdd_s.setProfit(profit);
										trd.setSaleSDD(sdd_s);
										trd.setTransactionProfit(profit);
										break;
								}
								else   // �������û�з������գ����¼�������ʱ������
								{
										double profit=(sdd_s.getClose()-buy_price)/buy_price*100-0.2; 
										sdd_s.setProfit(profit);
										trd.setSaleSDD(sdd_s);
										trd.setTransactionProfit(profit);
										trd.setTransactionSalePrice(sdd_s.getClose());
								}
								
							}
							
							
							transactionDataList.add(trd);
							assetsBackDate=trd.getSaleSDD().getDate();
							
							break;  // ֻ����һ��
							
						}
						
					}	
						
				
				}	
				
			}
			
		}
		
		outputTransactionRecordReport(transactionDataList, "����̽��");	
		
		return transactionDataList;
		
	}
	
	
	//	��С��ֵ��
	public void processStockByModel_zxsz(List stockCodeList, int startyear, int endyear)
	{
		
		List transactionDataList=new ArrayList();
		
		List totalMonthStartDateList=getTotalMonthStartDateList();
		
		
		// ��ȡ�ڼ�������ÿ�µ�һ�������յ�����
		List monthStartDateList=new ArrayList();
		for (int year=startyear; year<=endyear; year++)
		{
			 
//			for (int month=1; month<=9; month++)
//			{
//				String monthStartDate=year+"/0"+month+"/01";
//				monthStartDateList.add(monthStartDate);
//				System.out.println(monthStartDate);
//			}
//
//			for (int month=10; month<=12; month++)
//			{
//				String monthStartDate=year+"/"+month+"/01";
//				monthStartDateList.add(monthStartDate);
//				System.out.println(monthStartDate);
//			}
			
			for (int k=0; k<totalMonthStartDateList.size(); k++)
			{
				String monthStartDate=(String)totalMonthStartDateList.get(k);
				if(monthStartDate.startsWith(year+""))
				{
					monthStartDateList.add(monthStartDate);
				}
			
			}
		}
		
		
			
		// �鿴���й�Ʊ��ʷ��Ϣ�����ÿ��1�ŵ����й�Ʊ���׼�¼sdd��������������TreeMap��
		Map minlvSddMap=new TreeMap(); // minlvSddMap�ṹ: TreeMap(monthStartDate, TreeMap(marketvalue, sdd));
		
		String stockFileFolder=stockAllDataFull+"\\all";
		for (int i=0; i<stockCodeList.size(); i++)   // ���ÿֻ��Ʊ������ sddList
		{
				
			// ���ÿֻ��Ʊ����ʷ��������
			String stockcode=((String)stockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename);
			
			for (int j=0; j<stockDataList.size(); j++)  // ���ÿֻ��Ʊÿ������� sdd
			{
				
				StockDayData sdd=(StockDayData)stockDataList.get(j);
				if (sdd.getOpen_rise()>9.9)
				{
					continue;
				}
				
				for (int d=0; d<monthStartDateList.size(); d++)  // ���ÿ�� monthStartDate
				{
					
					String monthStartDate=monthStartDateList.get(d).toString();  
					
					if (sdd.getDate().trim().substring(0, 8).equals(monthStartDate.substring(0, 8)) 
						&& sdd.getDate().trim().equals(monthStartDate)) 
					{
						StockDayData sdd_next=getNextMonthStartSDD(stockDataList, sdd.getDate(), j);
						sdd.setSaleSDD(sdd_next);
						
						if (minlvSddMap.get(monthStartDate)==null)
						{
							Map lvSddMap=new TreeMap();
							lvSddMap.put(sdd.getLiquid_value(), sdd);  // ��������ֵ����
//							lvSddMap.put(sdd.getTotal_value(), sdd);   // ������ֵ����
							minlvSddMap.put(monthStartDate, lvSddMap);
							
							System.out.println(monthStartDate+": create "+sdd.getCode()+" "+sdd.getDate());
						}
						else
						{
							Map lvSddMap=(TreeMap)minlvSddMap.get(monthStartDate);
							lvSddMap.put(sdd.getLiquid_value(), sdd);  // ��������ֵ����
//							lvSddMap.put(sdd.getTotal_value(), sdd);   // ������ֵ����
							minlvSddMap.put(monthStartDate, lvSddMap);
							
							System.out.println(monthStartDate+": insert "+sdd.getCode()+" "+sdd.getDate());
						}
						
					}
								
				}
					
			}
				
		}		
		
		// 
		Iterator it=minlvSddMap.keySet().iterator();
		while(it.hasNext())
		{
			
			String monthStartDate=it.next().toString();
			TreeMap lvSddMap=(TreeMap)minlvSddMap.get(monthStartDate);
			
			Iterator mit=lvSddMap.keySet().iterator();
			int count=0;
			while(mit.hasNext())
			{
				if (count>9)  // ��ȡǰʮ����ֵ��С�Ĺ�Ʊ��Ϊ���׶���
					break;
				
				StockDayData sdd=(StockDayData)lvSddMap.get(mit.next());
				TransactionRecordData trd=new TransactionRecordData();
				trd.setStockcode(sdd.getCode());
				trd.setBuySDD(sdd);
				trd.setSaleSDD(sdd.getSaleSDD());
					
				transactionDataList.add(trd);
				count++;
				
			}
			
		}
		
		
		outputTransactionRecordReport(transactionDataList, "��С��ֵ");	
		
		
	}
	
	public StockDayData getNextMonthStartSDD(List stockDataList, String sddDate, int j)
	{
		StockDayData sdd_next=(StockDayData)stockDataList.get(j);
		
		int days=1;
		for (int s=j+1; s<stockDataList.size(); s++)
		{ 
			
			sdd_next=(StockDayData)stockDataList.get(s);
			if ( !sdd_next.getDate().trim().substring(0,8).equals(sddDate.trim().substring(0,8)) || days>30)
			{
				break;
			}
			days++;
			
		}
		
		return sdd_next;
	}
	
	public List getTotalMonthStartDateList()
	{
		
		List totalMonthStartDateList=new ArrayList();
		
		// ��ȡȫ����Ʊ����
		String monthstartdatelistfile="monthstartdate";
		String filePath=stockAllDataFull+"\\totalresult\\total_��С��ֵ";
		ResultSet rs=CommonTool.readDataFromSASDataSet(filePath, monthstartdatelistfile);
		totalMonthStartDateList=CommonTool.getColumnDataList(rs, "date");
				
		
//		totalMonthStartDateList.add("2015/01/04");
//		totalMonthStartDateList.add("2015/02/01");
//		totalMonthStartDateList.add("2015/03/01");
//		totalMonthStartDateList.add("2015/04/01");
//		totalMonthStartDateList.add("2015/05/03");
//		totalMonthStartDateList.add("2015/06/01");
//		totalMonthStartDateList.add("2015/07/01");
//		totalMonthStartDateList.add("2015/08/01");
//		totalMonthStartDateList.add("2015/09/01");
//		totalMonthStartDateList.add("2015/10/10");
//		totalMonthStartDateList.add("2015/11/01");
//		totalMonthStartDateList.add("2015/12/01");
//		
//		totalMonthStartDateList.add("2016/01/04");
//		totalMonthStartDateList.add("2016/02/01");
//		totalMonthStartDateList.add("2016/03/01");
//		totalMonthStartDateList.add("2016/04/01");
//		totalMonthStartDateList.add("2016/05/03");
//		totalMonthStartDateList.add("2016/06/01");
//		totalMonthStartDateList.add("2016/07/01");
//		totalMonthStartDateList.add("2016/08/01");
//		totalMonthStartDateList.add("2016/09/01");
//		totalMonthStartDateList.add("2016/10/10");
//		totalMonthStartDateList.add("2016/11/01");
//		totalMonthStartDateList.add("2016/12/01");
//		
//		totalMonthStartDateList.add("2017/01/03");
//		totalMonthStartDateList.add("2017/02/03");
//		totalMonthStartDateList.add("2017/03/01");
//		totalMonthStartDateList.add("2017/04/05");
//		totalMonthStartDateList.add("2017/05/02");
//		totalMonthStartDateList.add("2017/06/01");
//		totalMonthStartDateList.add("2017/07/03");
//		totalMonthStartDateList.add("2017/08/01");
//		totalMonthStartDateList.add("2016/09/01");
//		totalMonthStartDateList.add("2016/10/10");
//		totalMonthStartDateList.add("2016/11/01");
//		totalMonthStartDateList.add("2016/12/01");
		

		return totalMonthStartDateList;
		
	}
	

	
	public boolean checkDayData_MA(StockDayData sdd)  // Ĭ�ϼ�� ma5, ma10, ma20, ma60 ��ֵ"��ͷ����"
	{
		boolean result = false;
		
		if (1>0 
		  && sdd.getClose()>sdd.getMa_10()
		  && sdd.getMa_5()>sdd.getMa_10()
		  && sdd.getMa_10()>sdd.getMa_20()
		  && sdd.getMa_20()>sdd.getMa_60()     // 60�վ�����һ������Ҫ��ָ�꣬������20�վ����·����У����������鲻�õ�ʱ��ɹ��ʺܵ�
//		  && sdd.getMa_5()>sdd.getMa_60()
		)
		{
			result=true;
		}
		
		return result;	
	}
	
	public boolean checkDayData_MA_dtpl_10_20(StockDayData sdd)  // ������ĵ���ma5, ma10, ma20, ma60 ��ֵ"��ͷ����"
	{
		boolean result = false;
		
		if (sdd==null)
			return result;
		
		if ( 
		  sdd.getMa_10()>sdd.getMa_20()
		 )
		{
			result=true;
		}
		
		return result;	
	}
	
	public boolean checkDayData_MA_dtpl_5_10(StockDayData sdd)  // ������ĵ���ma5, ma10, ma20, ma60 ��ֵ"��ͷ����"
	{
		boolean result = false;
		
		if (sdd==null)
			return result;
		
		if ( 
		  sdd.getMa_5()>sdd.getMa_10()
		 )
		{
			result=true;
		}
		
		return result;	
	}
	
	
	public boolean checkDayData_MA_dtpl(StockDayData sdd)  // ������ĵ���ma5, ma10, ma20, ma60 ��ֵ"��ͷ����"
	{
		boolean result = false;
		
		if (sdd==null)
			return result;
		
		if ( 
//		  sdd.getClose()>sdd.getMa_5()
		  sdd.getMa_5()>sdd.getMa_20()
		  && sdd.getMa_10()>sdd.getMa_20()
		  && sdd.getMa_20()>sdd.getMa_60()
		  
//		  sdd.getMa_5()>sdd.getMa_60()
//		  && sdd.getMa_10()>sdd.getMa_60()
//		  && sdd.getMa_20()>sdd.getMa_60()
		)
		{
			result=true;
		}
		
		return result;	
	}
	
	

	public boolean checkDayData_MA_dtpl(List sddList)  // ���������ݵ�sdd ma��"��ͷ����"
	{
		boolean result = true;

		for (int i=0; i<sddList.size(); i++)
		{
			StockDayData sdd=(StockDayData)sddList.get(i);
			boolean sdd_result=checkDayData_MA_dtpl(sdd);
			if (sdd_result==false)  // ֻҪ��һ���ma�����Ͼͷ���false
			{
				result=false;
				return result; 
			}
		}
		
		return result;	
		
	}
	
	
	public boolean checkDayData_MA_ktpl(StockDayData sdd)  // ������ĵ���ma5, ma10, ma20, ma60 ��ֵ"��ͷ����"
	{
		boolean result = false;
		
		if (sdd==null)
			return result;
		
		if ( 
//		   sdd.getClose()<sdd.getMa_5()
		   sdd.getMa_5()<sdd.getMa_10()
		  && sdd.getMa_10()<sdd.getMa_20()
		  && sdd.getMa_20()<sdd.getMa_60()
		 )
		{
			result=true;
		}
		
		return result;	
	}
	
	
	public boolean checkDayData_MA_ktpl(List sddList)  // ���������ݵ�sdd ma��"��ͷ����"
	{
		boolean result = true;

		for (int i=0; i<sddList.size(); i++)
		{
			StockDayData sdd=(StockDayData)sddList.get(i);
			boolean sdd_result=checkDayData_MA_ktpl(sdd);
			if (sdd_result==false)  // ֻҪ��һ���ma�����Ͼͷ���false
			{
				result=false;
				return result; 
			}
		}
		
		return result;	
		
	}
	
	
	public boolean checkDayData_MA_dtfs(StockDayData sdd_b1, StockDayData sdd_b2)  // �������2�յ�ma5, 10, 20, 60 ��ֵ"��ͷ��ɢ"
	{
		boolean result = false;
		
		if ( 
		  sdd_b2.getMa_5()>=sdd_b1.getMa_5()
		  && sdd_b2.getMa_10()>=sdd_b1.getMa_10()
		  && sdd_b2.getMa_20()>=sdd_b1.getMa_20()
		  && sdd_b2.getMa_60()>=sdd_b1.getMa_60()
		 )
		{
			result=true;
		}
		
		return result;	
	}
	
	public boolean checkDayData_MA_dtfs(List sddList)   // ����������յ�ma5, 10, 20, 60 ��ֵ"��ͷ��ɢ"
	{
		boolean result = true;
		
		if (sddList.size()<2)
			return false;
		
		for (int i=0; i<sddList.size()-1; i++)
		{
			StockDayData sdd_b1=(StockDayData)sddList.get(i);
			StockDayData sdd_b2=(StockDayData)sddList.get(i+1);
			boolean sdd_result=checkDayData_MA_dtfs(sdd_b1, sdd_b2);
			if (sdd_result==false)  // ֻҪ��һ���ma�����Ͼͷ���false
			{
				result=false;
				return result; 
			}
		}

		return result;	
	}
	
	public int checkStockPreTrend_MMW(List stockDataList)   // Max Min Wave
	{
		double max=CommonTool.getStockMax(stockDataList, "close");
		double min=CommonTool.getStockMin(stockDataList, "close");
		double mean_rise=CommonTool.getStockMeanRise(stockDataList, "close");
		double last=((StockDayData)stockDataList.get(stockDataList.size()-1)).getClose();  // ���һ������ֵ
		
		if (min==0)
		{
			min=100;
		}
		
		double last_min_rise=CommonTool.getDoubleNumberWithTwoBit((last-min)/min);  // ���һ�������͵���Ƿ�
		double max_min_rise=CommonTool.getDoubleNumberWithTwoBit((max-min)/min);  // ��ߵ����͵�֮�䲨�����Ƿ�
		
		
		
		
		int result=1;
//		if (last_min_rise<0.3 && max_min_rise<0.3 && mean_rise<5)
		if (max_min_rise<0.15)
		{
			result=0;
			
			System.out.println(" max="+max+" min="+min+" last="+last);
			System.out.println("last_min_rise="+last_min_rise+" max_min_rise="+max_min_rise);
			System.out.println("result="+result);
		}
		else
		{
			result=1;
		}
		
		
		return result;
		
		
	}

	public boolean checkStockPreTrend_DDR_RUR(List stockDataList, double maxValue)     // Drop Down Rate
	{
		
		StockRecordDDR srd=CommonTool.calculateMaxDrawDownBySDD(stockDataList);
		StockRecordRUR srr=CommonTool.calculateMaxRiseUpBySDD(stockDataList);
		double maxDDR=srd.getDDR();
		double maxRUR=srr.getRUR();
		
		boolean result=false;
		if (maxDDR<maxValue && maxRUR<maxValue)  // maxValue
		{
			result=true;
			
			System.out.println("DDR "+maxDDR+" RUR"+maxRUR);
			System.out.println("result="+result);
		}
		else
		{
			result=false;
		}
		

		
		return result;
		
		
	}
	
	public boolean checkPastDaysHighPrice(StockDayData sdd, List sddList, int buyDateNo, int days)
	{
		
		boolean result=true;
		
		// ʵ�ʽ�������buyDateNo����Ҫ���Ľ�������days
		if (buyDateNo>days)
		{
			// �ӹ�������ǰ����i�������գ������߼۳�����ǰ���̼ۣ���ǰ�����¸ߣ�֮ǰ��������
			for (int i=1; i<=days; i++)
			{
				StockDayData preSdd=(StockDayData)sddList.get(buyDateNo-i);  // ��õ�ǰi�������
				if (sdd.getClose()<preSdd.getClose() || sdd.getClose()<preSdd.getOpen())
//				if (sdd.getClose()<preSdd.getHigh())
				{
					result=false;
					break;
				}
			}
			
		}
		else
		{
			
			// ���ʵ�ʽ�������buyDateNo����Ҫ���Ľ�������days����ʵ�ʽ���������
			for (int i=1; i<=buyDateNo; i++)
			{
				StockDayData preSdd=(StockDayData)sddList.get(buyDateNo-i);  // ��õ�ǰi�������
				if (sdd.getClose()<preSdd.getClose() || sdd.getClose()<preSdd.getOpen())
//				if (sdd.getClose()<preSdd.getHigh())
				{
					result=false;
					break;
				}
			}
			
		}
		
		return result;
		
	}
	
	public double calculateStockPrt_dtplgj(StockDayData sdd)
	{
		double stockPrt=0;
		
		stockPrt=sdd.getLiquid_value();   // ����ֵ��������ͷ�������ĸ�
		
		return stockPrt;
		
	}
	
	public double calculateStockPrt_dztd(StockDayData sdd)
	{
		double stockPrt=0;
		
		stockPrt=sdd.getLiquid_value();   // ����ֵ��������ͷ�������ĸ�
		
		return stockPrt;
		
	}
	
	public double calculatePriceGapRatio(double price1, double price2)
	{
		
		double gap=price1-price2;
		double ratio=CommonTool.getDoubleNumberWithTwoBit(gap/price1);
		
		return ratio;
		
	}
	
	public int getPastHighPriceDaysDistance(StockDayData sdd, List sddList)
	{
		
		int daysDistance=0;
		for (int i=sdd.getPosNum(); i>=0; i--)
		{
			StockDayData sdd_past=(StockDayData)sddList.get(i);
			double pastPrice=sdd_past.getClose();
			
			if (sdd_past.getClose()>sdd.getClose())
			{
				daysDistance=sdd.getPosNum()-sdd_past.getPosNum();
				break;
			}
		}
		
		return daysDistance;
		
	}
	
	public double getPastDaysLowestPrice(StockDayData sdd, List sddList, int buyDateNo, int days)
	{
		
		// ʵ�ʽ�������buyDateNo����Ҫ���Ľ�������days
		double lowestPrice=10000;
		if (buyDateNo>days)
		{
			// �ӹ�������ǰ����i��������,�Ƚ���͵�۸�
			for (int i=1; i<=days; i++)
			{
				StockDayData preSdd=(StockDayData)sddList.get(buyDateNo-i);  // ��õ�ǰi�������
				if (preSdd.getMa_ddz()>0)
				{
					return lowestPrice;
				}
				lowestPrice=Math.min(lowestPrice, preSdd.getLow());
			}	
		}
		else
		{
			// ���ʵ�ʽ�������buyDateNo����Ҫ���Ľ�������days����ʵ�ʽ���������
			for (int i=1; i<=buyDateNo; i++)
			{
				StockDayData preSdd=(StockDayData)sddList.get(buyDateNo-i);  // ��õ�ǰi�������
				if (preSdd.getMa_ddz()>0)
				{
					return lowestPrice;
				}
				lowestPrice=Math.min(lowestPrice, preSdd.getLow());
			}
		}
		
		return lowestPrice;
		
	}
	
	
	public StockDayData getHighestPriceSDD(List sddList)
	{
		StockDayData highestPriceSDD=new StockDayData();
		double highestPrice=0;
		for (int i=0; i<sddList.size(); i++)
		{
			StockDayData sdd=(StockDayData)sddList.get(i);
			if (sdd.getClose()>highestPrice)
			{
				highestPrice=sdd.getClose();
				highestPriceSDD=sdd;
			}
		}
		
		return highestPriceSDD;
		
	}
	
	public StockDayData getLowestPriceSDD(List sddList)
	{
		StockDayData lowestPriceSDD=new StockDayData();
		int lowestPrice=10000;
		for (int i=0; i<sddList.size(); i++)
		{
			StockDayData sdd=(StockDayData)sddList.get(i);
			if (sdd.getLow()<lowestPrice)
			{
				lowestPriceSDD=sdd;
			}
		}
		
		return lowestPriceSDD;
		
		
	}
	
	public boolean checkPastDaysHighRise(StockDayData sdd, List sddList, int buyDateNo, int days)
	{
		
		boolean result=true;
		
		if (buyDateNo>days)
		{
			// �ӹ�������ǰ����i�������գ��������Ƿ�����5%�Ͳ�������
			for (int i=1; i<=days; i++)
			{
				StockDayData preSdd=(StockDayData)sddList.get(buyDateNo-i);  // ��õ�ǰi�������
				if (preSdd.getClose_rise()>6)
				{
					result=false;
					break;
				}
			}
			
		}
		else
		{
			// û���㹻��ǰ�ý����ռ�¼�ɹ��ο���Ҳ������
			result=false;
		}
		
		return result;
		
	}
	
	
	public StockDayData checkPastDaysExistDownDay(List sddList, int buyDateNo, int days)
	{
		
		StockDayData downDayData=null;
		
		if (buyDateNo>days)
		{
			// �ӹ�������ǰ����i�������գ��������Ƿ�����5%�Ͳ�������
			for (int i=1; i<=days; i++)
			{
				StockDayData preSdd=(StockDayData)sddList.get(buyDateNo-i);  // ��õ�ǰi�������
				if (preSdd.getClose_rise()<0)
				{
					downDayData=preSdd;
					break;
				}
			}
			
		}

		return downDayData;
		
	}
	
	public double checkPastDaysRiseRate(List sddList, int buyDateNo, int days)
	{
		
		double totalRiseRate=0;
		
		if (buyDateNo>days)
		{
			// �ӹ�������ǰ����i�������գ��������Ƿ�����5%�Ͳ�������
			for (int i=1; i<=days; i++)
			{
				StockDayData preSdd=(StockDayData)sddList.get(buyDateNo-i);  // ��õ�ǰi�������
				totalRiseRate=totalRiseRate+preSdd.getClose_rise();
			}
			
		}

		return totalRiseRate;
		
	}
	
	
	
	public boolean checkPastDaysKDJ(List sddList, StockDayData ztSdd, int days)
	{
		
		boolean result=false;
		int ztDateNo=ztSdd.getPosNum();
		
		if (ztDateNo>days)    // ztDateNo: ��ͣ�����    days: ֮ǰ����������
		{
			// �ӹ�������ǰ����i�������գ��鿴KDJָ��
			for (int i=3; i<=days; i++)
			{
				StockDayData sdd_b1=(StockDayData)sddList.get(ztDateNo-i+2);  // ��õ�ǰi-2�������
				StockDayData sdd_b3=(StockDayData)sddList.get(ztDateNo-i);  // ��õ�ǰi�������
				if (
						sdd_b1.getKdj_k()<20 && sdd_b1.getKdj_d()<20   // K,D<20		
						&& sdd_b1.getKdj_k()>sdd_b1.getKdj_d()	// KD���
						&& sdd_b3.getKdj_k()<sdd_b3.getKdj_d()	// KD���
						&& sdd_b1.getEq_ratio()>1			// ���ȴ���1
						&& sdd_b1.getClose()>sdd_b1.getMa_5()   // վ��5�վ���		
						
				)
				{
					result=true;
					break;
				}
			}
			
		}
		else
		{
			// û���㹻��ǰ�ý����ռ�¼�ɹ��ο���Ҳ������
			result=false;
		}
		
		return result;
		
	}
	
	
	public boolean checkPastDaysZTB(List sddList, StockDayData ztSdd, int days)
	{
		
		boolean result=true;
		int ztDateNo=ztSdd.getPosNum();
		
		if (ztDateNo>days)    // ztDateNo: ��ͣ�����    days: ֮ǰ����������
		{
			// �ӹ�������ǰ����i�������գ��鿴KDJָ��
			for (int i=1; i<=days; i++)
			{

				StockDayData sdd_b=(StockDayData)sddList.get(ztDateNo-i);  // ��õ�ǰi�������
				if (
						sdd_b.getClose_rise()>9.9		
				)
				{
					result=false;   // ֻҪ��һ������ͣ�����㺬����ͣ�壬�����ý��Ϊfalse
					break;
				}
			}
			
		}
		else
		{
			// û���㹻��ǰ�ý����ռ�¼�ɹ��ο���Ҳ������
			result=true;
		}
		
		return result;
		
	}
	
	
	public boolean checkPastDays_PZZF(List sddList, double topRise)
	{
		
		boolean result=true;
		
		for (int i=0; i<sddList.size(); i++)
		{

			StockDayData sdd=(StockDayData)sddList.get(i);  // ��õ�ǰi�������
			if (sdd.getHigh_rise()>topRise)
			{
				result=false;
			}
				
		}
		
		return result;
	
	}
	
	public boolean checkPastDays_CMSD(StockDayData sdd, StockDayData sdd_s)
	{
		
		boolean result=false;
		
		if (sdd_s.getLow()<((sdd.getHigh()+sdd.getLow())/2))
		{
			result=true;
		}
			
		return result;
	
	}
	
	public double getSalePrice_CMSD(StockDayData sdd, StockDayData sdd_s)
	{
		
		double sale_price=0;
		
		if (sdd_s.getOpen()<((sdd.getHigh()+sdd.getLow())/2))
		{
			sale_price=sdd_s.getOpen();
		}
		else
		{
			sale_price=(sdd.getHigh()+sdd.getLow())/2;
		}
			
		return sale_price;
	
	}
	
	public double checkPastDaysDDZ(List sddList, StockDayData curDDZSdd, int days)
	{
		
		double ddz_ratio=0;  // ����һ����ֵ�����ddz��������Сddz�����ı�ֵ����������������������򷵻�0
		int m=0;
		int curDDZDateNo=curDDZSdd.getPosNum();
		double max_ddz=-10000;
		double min_ddz=10000;
		
		if (curDDZDateNo>days)    // curDDZDateNo: DDZ�������    days: ֮ǰ���������
		{
			// �ӹ�������ǰ����i�������գ��鿴DDZָ��
			for (int i=1; i<=days; i++)
			{
				
				StockDayData preDDZSdd=(StockDayData)sddList.get(curDDZDateNo-i);  // ��õ�ǰi�������
				curDDZSdd=(StockDayData)sddList.get(curDDZDateNo-i+1);  // ��õ�ǰi+1�������
				if ( preDDZSdd.getMa_ddz()>0 )
				{
					ddz_ratio=0;
					break;
				}
				else
				{
					max_ddz=Math.max(max_ddz, curDDZSdd.getMa_ddz());   // �ҳ�����ddzֵ
					min_ddz=Math.min(min_ddz, curDDZSdd.getMa_ddz());   // �ҳ���С��ddzֵ
					if ( preDDZSdd.getMa_ddz()>curDDZSdd.getMa_ddz() )	// ��¼��һ���ǰһ��ddz��ֵ�����Ĵ���
					{
						m++;
					}
				}
		
			}
			
			if (m>days-1)  // ����days�죬����Ҫ��days-1�β��ϱ�С
			{
				ddz_ratio=Math.abs(min_ddz/max_ddz);  // �������/��С������
			}

		}
		else
		{
			// û���㹻��ǰ�ý����ռ�¼�ɹ��ο���Ҳ������
			ddz_ratio=0;
		}
		
		return ddz_ratio;
		
	}
	
	
	public boolean checkPastDaysMACDTrends(List indexSddList, StockDayData idd)
	{
		
		boolean result=false;
		int posNum=idd.getPosNum();
		
		for (int i=posNum; i>0; i--)
		{
			StockDayData curIdd=(StockDayData)indexSddList.get(i);
			StockDayData preIdd=(StockDayData)indexSddList.get(i-1); 	
			
			if (preIdd.getMa_macd()>0 && curIdd.getMa_macd()>0)
			{
				double trendsRatio=(curIdd.getMa_macd()-preIdd.getMa_macd())/preIdd.getMa_macd();
				if (trendsRatio>-0.2)   
				{
					result=true;
				}
				
				if (trendsRatio<-0.2)
				{
					result=false;
				}
				
				break;		// ֻ�鿴֮ǰ��b1, b2��macd, ֻҪmacdֵû�д���ͽ��ף������ǲ鿴��ȥȫ��macd�仯
			}
			else
			{
				break;
			}
			
		}
		
		return result;
		
	}
	
	public boolean checkPastDaysMACDTrends_UP(List pastDaysSddList, int trend)  // ���MACD��������
	{
		
		boolean result=false;
		int days=pastDaysSddList.size();
		
		for (int i=0; i<days-1; i++)
		{
			StockDayData curSdd=(StockDayData)pastDaysSddList.get(i);
			StockDayData preSdd=(StockDayData)pastDaysSddList.get(i+1); 	
			
			if ( trend==0 || (preSdd.getMa_macd()*trend>0 && curSdd.getMa_macd()*trend>0) )  // ������trend=-1  ������trend=1  ����ν��trend=0
			{
		
				if (preSdd.getMa_macd()<curSdd.getMa_macd())   
				{
					result=true; 
					continue;  // ���������һ��macd�Ա�
				}
				else
				{
					result=false;
					break;  // ��ֹmacd�Աȣ�����false
				}
				
			}
			
		}
		
		return result;
		
	}
	
	
	public boolean checkPastDaysMACDTrends_DOWN(List pastDaysSddList, int trend)  // ���MACD�½�����
	{
		
		boolean result=false;
		int days=pastDaysSddList.size();
		
		for (int i=0; i<days-1; i++)
		{
			StockDayData curSdd=(StockDayData)pastDaysSddList.get(i);
			StockDayData preSdd=(StockDayData)pastDaysSddList.get(i+1); 	
			
			if ( trend==0 || (preSdd.getMa_macd()*trend>0 && curSdd.getMa_macd()*trend>0) )  // ������trend=-1  ������trend=1  ����ν��trend=0
			{
		
				if (preSdd.getMa_macd()>curSdd.getMa_macd())   
				{
					result=true; 
					continue;  // ���������һ��macd�Ա�
				}
				else
				{
					result=false;
					break;  // ��ֹmacd�Աȣ�����false
				}
				
			}

			
			
		}
		
		return result;
		
	}
	
	
	public boolean checkPastDaysMACDTrends_NDBL_DEEP(List pastDaysSddList, double deep)   // ���MACD�ױ������
	{
		
		boolean result=false;
		int days=pastDaysSddList.size();
		
		double maxDeep=0;
		for (int i=0; i<days-1; i++)
		{
			StockDayData curSdd=(StockDayData)pastDaysSddList.get(i);
			StockDayData preSdd=(StockDayData)pastDaysSddList.get(i+1); 		
			
			if (preSdd.getMa_macd()<0 && curSdd.getMa_macd()<0)
			{
		
				if (preSdd.getMa_macd()<curSdd.getMa_macd())   
				{
					maxDeep=preSdd.getMa_macd();  // �ҳ�macd����ȵ�
				}
				
			}
			
		}
		
		if (maxDeep<deep)
		{
			result=true;
		}
		else
		{
			result=false;
		}
		
		return result;
		
	}
	
	
	public boolean checkPastDaysMACDTrends_MA20(List pastDaysSddList, int maxDays)  // ���MACD����
	{
		
		boolean result=false;
		int days=pastDaysSddList.size();
		
		if (days<maxDays)
			return result;
		
		int midNum=days/2;
		int farNum=days-1;
		
		StockDayData curSdd=(StockDayData)pastDaysSddList.get(0);
		StockDayData midSdd=(StockDayData)pastDaysSddList.get(midNum); 	
		StockDayData farSdd=(StockDayData)pastDaysSddList.get(farNum);
			
		if ( curSdd.getMa_20()>midSdd.getMa_20() && midSdd.getMa_20()>farSdd.getMa_20() )  
		{
	
			result=true;
			
		}
		
		return result;
		
	}
	
	public boolean checkPastDaysMACDTrends_MA10(List pastDaysSddList, int maxDays)  // ���MACD����
	{
		
		boolean result=false;
		int days=pastDaysSddList.size();
		
		if (days<maxDays)
			return result;
		
		int midNum=days/2;
		int farNum=days-1;
		
		StockDayData curSdd=(StockDayData)pastDaysSddList.get(0);
		StockDayData preSdd=(StockDayData)pastDaysSddList.get(1);
		StockDayData midSdd=(StockDayData)pastDaysSddList.get(midNum); 	
		StockDayData farSdd=(StockDayData)pastDaysSddList.get(farNum);
			
		if ( curSdd.getMa_10()>preSdd.getMa_10() 
			 && preSdd.getMa_10()>midSdd.getMa_10() 
			 && midSdd.getMa_10()>farSdd.getMa_10() )  
		{
	
			result=true;
			
		}
		
		return result;
		
	}
	
	public double checkPastDaysDDZMin(List indexSddList, StockDayData idd)
	{
		double result=0;
		int posNum=idd.getPosNum();
		
		for (int i=posNum; i>0; i--)
		{
			StockDayData curIndexDDZSdd=(StockDayData)indexSddList.get(i);
			StockDayData preIndexDDZSdd=(StockDayData)indexSddList.get(i-1); 	
			
			if (preIndexDDZSdd.getMa_ddz()<=0 && curIndexDDZSdd.getMa_ddz()<=0
			&& preIndexDDZSdd.getMa_ddz()>curIndexDDZSdd.getMa_ddz())
			{
				result=curIndexDDZSdd.getMa_ddz();
				break;
			}
			
		}
		
		return result;
		
		
	}
			
	public double checkPastDaysDDZMax(List indexSddList, StockDayData idd)
	{
		double result=0;
		int posNum=idd.getPosNum();
		
		for (int i=posNum; i>0; i--)
		{
			StockDayData curIndexDDZSdd=(StockDayData)indexSddList.get(i);
			StockDayData preIndexDDZSdd=(StockDayData)indexSddList.get(i-1); 	
			
			if (preIndexDDZSdd.getMa_ddz()>=0 && curIndexDDZSdd.getMa_ddz()>=0
			&& preIndexDDZSdd.getMa_ddz()<curIndexDDZSdd.getMa_ddz())
			{
				result=curIndexDDZSdd.getMa_ddz();
				break;
			}
			
		}
		
		return result;
		
		
	}
	
	
	public boolean checkPastDays_DownLowestPrice(List pastStockList, StockDayData sdd)
	{
		
		boolean result=false;
		double lowestPrice=10000;
		
		for (int i=0; i<pastStockList.size(); i++)
		{
			
			StockDayData pastDayData=(StockDayData)pastStockList.get(i);
			
			if (pastDayData.getLow()<lowestPrice)
			{
				lowestPrice=pastDayData.getLow();
			}
			
		}
		
		if (sdd.getClose()<lowestPrice)
		{
			result=true;
		}
		
		return result;
		
	}
	
	
	public StockSecondData checkOpenEnviroment(StockDayData buySdd)
	{
		
		StockSecondData result=null;
		
		String stockcode=buySdd.getCode(); // ȥ��ǰ׺ sh, sz
		String stockfilename="stock"+stockcode;
		List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename);
		
		if (stockDataList.size()<10)
		{
			return result;
		}
		
		for (int i=5; i<stockDataList.size(); i++)
		{

			StockDayData sdd=(StockDayData)stockDataList.get(i);
			if (sdd.getDate().equals(buySdd.getDate()))
			{
				StockDayData sdd_b1=(StockDayData)stockDataList.get(i-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(i-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(i-3);
				StockDayData sdd_b4=(StockDayData)stockDataList.get(i-4);
				StockDayData sdd_b5=(StockDayData)stockDataList.get(i-5);
				
				System.out.println("Check open environment: "+sdd.getCode());
				if (sdd_b1.getClose_rise()<-9 
				|| sdd_b1.getClose_rise()>6 
				|| sdd_b1.getClose_rise()+sdd_b2.getClose_rise()>6
				|| sdd_b1.getClose_rise()+sdd_b2.getClose_rise()+sdd_b3.getClose_rise()>10)  // ǰ�����Ƿ����ߣ�������
				{
					result=null;
				}
				else
				{
					String date=sdd.getDate();
					List stockSecondDataRecordList=CommonTool.getStockSecondDataRecordList(stockSecondFileFolder, date, stockcode);
					
					StockSecondData ssd=(StockSecondData)stockSecondDataRecordList.get(0); // ���9:25�ּ��Ͼ��۵�����
					if (ssd.getSaleAmount1()>0 && ssd.getBuyAmount1()/ssd.getSaleAmount1()>10 && ssd.getBuyAmount1()>1000)
					{
						System.out.println(sdd.getDate()+" "+sdd.getCode()+" "+sdd.getName()+" "
								+ssd.getBuyAmount1()+" "+ssd.getSaleAmount1()+" "+sdd.getOpen_rise()+"% ");
						result=ssd;
					}
					else
					{
						result=null;
					}
					
				}
			}
			

			
		}
		
				
		return result;
		
	}

	
	// �����ֻ��Ʊ���׽���������������ݼ��ļ�
	public String outputTransactionRecordReport(List transactionDataList, String modelName)
	{
		
		String reportLine="";
		String stockName="";
		String stockCode="";
		
		String columnDef="stockcode varchar(10), stockname varchar(20),  liquid_value double precision format 12.2, total_value double precision format 12.2, " +
				"date_c varchar(20), saledate varchar(20), year varchar(20), days varchar(20), buy_price double precision format 12.2, sale_price double precision format 12.2, profit double precision format 12.2, " +
				"days_60 varchar(20), modelType varchar(20), modelParam varchar(200)";
		
		String timeStr=CommonTool.getCurrentTimeStr().replace("-", "").replace(",", "").replace(":", ""); 
		String filename="SelectTransResult_"+timeStr;
		String resultFileFolder=stockAllDataFull+"\\totalresult\\total_"+modelName;
		FileTool.createFolder(resultFileFolder);
//		CommonTool.createSASDataSet(resultFileFolder, filename, columnDef);
		
		int rise_count=0;
		int down_count=0;
		
		int rise_0_count=0;
		int down_0_count=0;		
		int rise_10_count=0;
		int down_10_count=0;
		int rise_20_count=0;
		int down_20_count=0;
		
		List transDataList=new ArrayList();
		double total_profit=0;
		double total_profit_fl=1;
		
		for (int i=0; i<transactionDataList.size(); i++)
		{
			TransactionRecordData trd=(TransactionRecordData)transactionDataList.get(i);
			
			stockCode=trd.getBuySDD().getCode();
			stockName=trd.getBuySDD().getName();
			
			double profit=trd.getTransactionProfit();
			double buyPrice=trd.getTransactionBuyPrice();
			double salePrice=trd.getTransactionSalePrice();
			
			if (profit==0)
			{
				profit=trd.getSaleSDD().getProfit();
			}
			
			if (buyPrice==0)
			{
			    buyPrice=trd.getBuySDD().getOpen();
			}
			
			if (salePrice==0)
			{
				salePrice=trd.getSaleSDD().getClose();
			}
			   
			if (profit==0)
			{
				if (trd.getBuySDD().getOpen()!=0)
				{
					profit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getOpen())/trd.getBuySDD().getOpen())*100-0.2;
				}
				else
				{
					profit=0;
				}
			}
			
			if (profit>0)
			{
				rise_count++;
			}
			
			if (profit<0)
			{
				down_count++;
			}
			
			if (profit>0 && profit<10)
			{
				rise_0_count++;
			}
			
			if (profit>10 && profit<20)
			{
				rise_10_count++;
			}
			
			if (profit>20)
			{
				rise_20_count++;
			}
			
			if (profit<0 && profit>=-10)
			{
				down_0_count++;
			}
			
			if (profit<-10 && profit>=-20)
			{
				down_10_count++;
			}
	
			if (profit<-20)
			{
				down_20_count++;
			}
			
			int days=trd.getSaleSDD().getPosNum()-trd.getBuySDD().getPosNum();
//			int days_30=(int)(days/8+1);
			int days_60=(int)(days/4+1);
			double total_value=CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getTotal_value()/100000000);
			double liquid_value=CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getLiquid_value()/100000000);
			String dataDef= "'"+trd.getStockcode()+"',"+
							"'"+trd.getBuySDD().getName()+"',"+
							+liquid_value+","+
							+total_value+","+
							"'"+trd.getBuySDD().getDate().trim()+"',"+
							"'"+trd.getSaleSDD().getDate().trim()+"',"+
							"'"+trd.getBuySDD().getDate().substring(0,4)+"',"+
							"'"+days+"',"+
							+CommonTool.getDoubleNumberWithTwoBit(buyPrice)+","+
							+CommonTool.getDoubleNumberWithTwoBit(salePrice)+","+
							+CommonTool.getDoubleNumberWithTwoBit(profit)+","+
							"'"+days_60+"',"+
							"'"+trd.getModelType()+"',"+
							"'"+trd.getModelParam()+"',"
							;
							
			transDataList.add(dataDef);
			total_profit=total_profit+profit;
			total_profit_fl=total_profit_fl*(1+profit/100);
			
			System.out.print(trd.getStockcode()+"("+trd.getBuySDD().getName()+"): "+trd.getBuySDD().getDate().trim()+" ");
			System.out.print(trd.getSaleSDD().getDate().trim()+" "+days+"��  "+CommonTool.getDoubleNumberWithTwoBit(profit)+"%");
			System.out.println("");
			
		}
		
		double winRate=0;
		int totalCount=rise_count+down_count;
		if (totalCount>0)
		{
			winRate=(double)rise_count/totalCount*100;
		}
		
//		CommonTool.insertDataToSASDataSet(resultFileFolder, filename, transDataList);  // ����������������
		System.out.println("rise: "+rise_count+"  down: "+down_count);
		System.out.println("Win Rate: "+CommonTool.getDoubleNumberWithTwoBit(winRate)+"%");
		System.out.println("Total Profit: "+CommonTool.getDoubleNumberWithTwoBit(total_profit)+"%");
		System.out.println("Total Profit FL: "+CommonTool.getDoubleNumberWithTwoBit(total_profit_fl-1)*100+"%");
		
		int total_Count=rise_count+down_count;
		String winRate_str=CommonTool.formatNumberStrWithTwoBit(CommonTool.getDoubleNumberWithTwoBit(winRate)+"")+"%";
		String total_profit_str=CommonTool.formatNumberStrWithTwoBit(CommonTool.getDoubleNumberWithTwoBit(total_profit)+"")+"%";
		String total_profit_fl_str=CommonTool.formatNumberStrWithTwoBit(CommonTool.getDoubleNumberWithTwoBit(total_profit_fl-1)*100+"")+"%";
		

//		reportLine=CommonTool.formatStockNameLength(stockName, 20)
//				+CommonTool.formatStringLength(stockCode,12)
//				+CommonTool.formatStringLength(total_Count+"",9)
//				+CommonTool.formatStringLength(rise_count+"",9)
//				+CommonTool.formatStringLength(down_count+"",9)
//				+CommonTool.formatStringLength(winRate_str,11)
//				+CommonTool.formatStringLength(total_profit_str,15)
//				+CommonTool.formatStringLength(total_profit_fl_str,12);
		
		reportLine=stockName+"\t"
				+stockCode+"\t\t"
				+total_Count+"\t"
				+rise_count+"\t"
				+down_count+"\t"
				+winRate_str+"\t\t"
				+total_profit_str+"\t\t"
				+total_profit_fl_str+"\t\t";
		
		return reportLine;
		
		
	}
	
	// ������н��ף�������ֻ��Ʊ��д�����ݼ��ļ�
	public String outputTransactionRecordReport_total(List transactionDataList, String modelName)
	{
		
		String reportLine="";
		String stockName="";
		String stockCode="";
		
		String columnDef="stockcode varchar(10), stockname varchar(20),  liquid_value double precision format 12.2, total_value double precision format 12.2, " +
				"date_c varchar(20), saledate varchar(20), year varchar(20), days varchar(20), buy_price double precision format 12.2, sale_price double precision format 12.2, profit double precision format 12.2, " +
				"days_60 varchar(20), modelType varchar(20), modelParam varchar(200)";
		
		String timeStr=CommonTool.getCurrentTimeStr().replace("-", "").replace(",", "").replace(":", ""); 
		String filename="SelectTransResult_"+timeStr;
		String resultFileFolder=stockAllDataFull+"\\totalresult\\total_"+modelName;
		FileTool.createFolder(resultFileFolder);
		CommonTool.createSASDataSet(resultFileFolder, filename, columnDef);
		
		int rise_count=0;
		int down_count=0;
		
		int rise_0_count=0;
		int down_0_count=0;		
		int rise_10_count=0;
		int down_10_count=0;
		int rise_20_count=0;
		int down_20_count=0;
		
		List transDataList=new ArrayList();
		double total_profit=0;
		double total_profit_fl=1;
		
		for (int i=0; i<transactionDataList.size(); i++)
		{
			TransactionRecordData trd=(TransactionRecordData)transactionDataList.get(i);
			
			stockCode=trd.getBuySDD().getCode();
			stockName=trd.getBuySDD().getName();
			
			double profit=trd.getTransactionProfit();
			double buyPrice=trd.getTransactionBuyPrice();
			double salePrice=trd.getTransactionSalePrice();
			
			if (profit==0)
			{
				profit=trd.getSaleSDD().getProfit();
			}
			
			if (buyPrice==0)
			{
			    buyPrice=trd.getBuySDD().getOpen();
			}
			
			if (salePrice==0)
			{
				salePrice=trd.getSaleSDD().getClose();
			}
			   
			if (profit==0)
			{
				if (trd.getBuySDD().getOpen()!=0)
				{
					profit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getOpen())/trd.getBuySDD().getOpen())*100-0.2;
				}
				else
				{
					profit=0;
				}
			}
			
			if (profit>0)
			{
				rise_count++;
			}
			
			if (profit<0)
			{
				down_count++;
			}
			
			if (profit>0 && profit<10)
			{
				rise_0_count++;
			}
			
			if (profit>10 && profit<20)
			{
				rise_10_count++;
			}
			
			if (profit>20)
			{
				rise_20_count++;
			}
			
			if (profit<0 && profit>=-10)
			{
				down_0_count++;
			}
			
			if (profit<-10 && profit>=-20)
			{
				down_10_count++;
			}
	
			if (profit<-20)
			{
				down_20_count++;
			}
			
			int days=trd.getSaleSDD().getPosNum()-trd.getBuySDD().getPosNum();
//			int days_30=(int)(days/8+1);
			int days_60=(int)(days/4+1);
			double total_value=CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getTotal_value()/100000000);
			double liquid_value=CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getLiquid_value()/100000000);
			String dataDef= "'"+trd.getStockcode()+"',"+
							"'"+trd.getBuySDD().getName()+"',"+
							+liquid_value+","+
							+total_value+","+
							"'"+trd.getBuySDD().getDate().trim()+"',"+
							"'"+trd.getSaleSDD().getDate().trim()+"',"+
							"'"+trd.getBuySDD().getDate().substring(0,4)+"',"+
							"'"+days+"',"+
							+CommonTool.getDoubleNumberWithTwoBit(buyPrice)+","+
							+CommonTool.getDoubleNumberWithTwoBit(salePrice)+","+
							+CommonTool.getDoubleNumberWithTwoBit(profit)+","+
							"'"+days_60+"',"+
							"'"+trd.getModelType()+"',"+
							"'"+trd.getModelParam()+"',"
							;
							
			transDataList.add(dataDef);
			total_profit=total_profit+profit;
			total_profit_fl=total_profit_fl*(1+profit/100);
			
			System.out.print(trd.getStockcode()+"("+trd.getBuySDD().getName()+"): "+trd.getBuySDD().getDate().trim()+" ");
			System.out.print(trd.getSaleSDD().getDate().trim()+" "+days+"��  "+CommonTool.getDoubleNumberWithTwoBit(profit)+"%");
			System.out.println("");
			
		}
		
		double winRate=0;
		int totalCount=rise_count+down_count;
		if (totalCount>0)
		{
			winRate=(double)rise_count/totalCount*100;
		}
		
		CommonTool.insertDataToSASDataSet(resultFileFolder, filename, transDataList);  // ����������������
		System.out.println("rise: "+rise_count+"  down: "+down_count);
		System.out.println("Win Rate: "+CommonTool.getDoubleNumberWithTwoBit(winRate)+"%");
		System.out.println("Total Profit: "+CommonTool.getDoubleNumberWithTwoBit(total_profit)+"%");
		System.out.println("Total Profit FL: "+CommonTool.getDoubleNumberWithTwoBit(total_profit_fl-1)*100+"%");
		
		int total_Count=rise_count+down_count;
		String winRate_str=CommonTool.formatNumberStrWithTwoBit(CommonTool.getDoubleNumberWithTwoBit(winRate)+"")+"%";
		String total_profit_str=CommonTool.formatNumberStrWithTwoBit(CommonTool.getDoubleNumberWithTwoBit(total_profit)+"")+"%";
		String total_profit_fl_str=CommonTool.formatNumberStrWithTwoBit(CommonTool.getDoubleNumberWithTwoBit(total_profit_fl-1)*100+"")+"%";
		

		reportLine=CommonTool.formatStockNameLength(stockName, 20)
				+CommonTool.formatStringLength(stockCode,12)
				+CommonTool.formatStringLength(total_Count+"",9)
				+CommonTool.formatStringLength(rise_count+"",9)
				+CommonTool.formatStringLength(down_count+"",9)
				+CommonTool.formatStringLength(winRate_str,11)
				+CommonTool.formatStringLength(total_profit_str,15)
				+CommonTool.formatStringLength(total_profit_fl_str,12);
		return reportLine;
		
		
	}
	
		
	public void outputTransactionRecordReport_yg(List transactionDataList, String modelName)
	{
		
		String columnDef="stockcode varchar(10), " +
				"stockname varchar(10),  " +
				"liquid_value double precision format 12.2, " +
				"total_value double precision format 12.2, " +
				"date_c varchar(20), " +
				"saledate varchar(20), " +
				"days varchar(20), " +
				"buy_price double precision format 12.2, " +
				"sale_price double precision format 12.2, " +
				"profit double precision format 12.2, " +
				"macd_change_b varchar(50), " +
				"ddz_change_b varchar(50), " +
				"yg_change_b varchar(50), " +
				getColumnDef_currentDayData() + "," +   // ���뵱��
				getColumnDef_preDayData(1) + "," +
				getColumnDef_preDayData(2) + "," +
				getColumnDef_preDayData(3) + "," + 
				getColumnDef_preDayData(4) + "," + 
				getColumnDef_preDayData(5)  
				;
		
		
		String timeStr=CommonTool.getCurrentTimeStr().replace("-", "").replace(",", "").replace(":", ""); 
		String filename="SelectTransResult_"+timeStr;
		String resultFileFolder=stockAllDataFull+"\\totalresult\\total_"+modelName;
		FileTool.createFolder(resultFileFolder);
		CommonTool.createSASDataSet(resultFileFolder, filename, columnDef);
		
		int rise_count=0;
		int down_count=0;
		
		int rise_0_count=0;
		int down_0_count=0;		
		int rise_10_count=0;
		int down_10_count=0;
		int rise_20_count=0;
		int down_20_count=0;
		
		List transDataList=new ArrayList();
		double total_profit=0;
		for (int i=0; i<transactionDataList.size(); i++)
		{
			TransactionRecordData trd=(TransactionRecordData)transactionDataList.get(i);
			
			double profit=trd.getSaleSDD().getProfit();
			if (profit==0)
			{
				if (trd.getBuySDD().getOpen()!=0)
				{
					profit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getOpen())/trd.getBuySDD().getOpen())*100;
				}
				else
				{
					profit=0;
				}
			}
			
			if (profit>0)
			{
				rise_count++;
			}
			
			if (profit<0)
			{
				down_count++;
			}
			
			if (profit>0 && profit<10)
			{
				rise_0_count++;
			}
			
			if (profit>10 && profit<20)
			{
				rise_10_count++;
			}
			
			if (profit>20)
			{
				rise_20_count++;
			}
			
			if (profit<0 && profit>=-10)
			{
				down_0_count++;
			}
			
			if (profit<-10 && profit>=-20)
			{
				down_10_count++;
			}

			if (profit<-20)
			{
				down_20_count++;
			}
			
			int days=trd.getSaleSDD().getPosNum()-trd.getBuySDD().getPosNum();
			double total_value=CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getTotal_value()/100000000);
			double liquid_value=CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getLiquid_value()/100000000);
			String dataDef= "'"+trd.getStockcode()+"',"+
							"'"+trd.getBuySDD().getName()+"',"+
							liquid_value+","+
							total_value+","+
							"'"+trd.getBuySDD().getDate().trim()+"',"+
							"'"+trd.getSaleSDD().getDate().trim()+"',"+
							"'"+days+"',"+
							CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getOpen())+","+
							CommonTool.getDoubleNumberWithTwoBit(trd.getSaleSDD().getClose())+","+
							CommonTool.getDoubleNumberWithTwoBit(profit)+","+
							"'"+getMacdChangeData(trd, 5)+"',"+  // �������5��ı仯ֵƴ��һ���ַ���
							"'"+getDDZChangeData(trd, 5)+"',"+
							"'"+getYGChangeData(trd, 5)+"',"+
							getDataDef_currentDayData(trd)+ "," +
							getDataDef_preDayData(trd, 1)+ "," +
							getDataDef_preDayData(trd, 2)+ "," +
							getDataDef_preDayData(trd, 3)+ "," +
							getDataDef_preDayData(trd, 4)+ "," +
							getDataDef_preDayData(trd, 5)
							;
			transDataList.add(dataDef);
			total_profit=total_profit+profit;
			
			System.out.print(trd.getStockcode()+"("+trd.getBuySDD().getName()+"): "+trd.getBuySDD().getDate().trim()+" ");
			System.out.print(trd.getSaleSDD().getDate().trim()+" "+days+"��  "+CommonTool.getDoubleNumberWithTwoBit(profit)+"%");
			System.out.println("");
			
		}
		
		double winRate=0;
		int totalCount=rise_count+down_count;
		if (totalCount>0)
		{
			winRate=(double)rise_count/totalCount*100;
		}
		
		CommonTool.insertDataToSASDataSet(resultFileFolder, filename, transDataList);
		System.out.println("rise: "+rise_count+"  down: "+down_count);
		System.out.println("Win Rate: "+CommonTool.getDoubleNumberWithTwoBit(winRate)+"%");
		System.out.println("Total Profit: "+CommonTool.getDoubleNumberWithTwoBit(total_profit)+"%");
		
		
	}
	
	public void outputTransactionRecordReport_beststock(List transactionDataList, String modelName)
	{
		
		String columnDef="stockcode varchar(10), " +
				"stockname varchar(10),  " +
				"industry varchar(10),  " +
				"liquid_value double precision format 12.2, " +
				"total_value double precision format 12.2, " +
				"date_c varchar(20), " +
				"saledate varchar(20), " +
				"days varchar(20), " +
				"buy_price double precision format 12.2, " +
				"sale_price double precision format 12.2, " +
				"profit double precision format 12.2, "+
				"profit_PerYear double precision format 12.2, "+
				"maxDDR double precision format 12.2, "+
				"maxRUR double precision format 12.2, "+
				"fundCount int format best12."				
				;    // PE�仯��earn�仯��profitÿ��仯�����Ҽ���ϸ��ѯ
		
		String timeStr=CommonTool.getCurrentTimeStr().replace("-", "").replace(",", "").replace(":", ""); 
		String filename="SelectTransResult_"+timeStr;
		String resultFileFolder=stockAllDataFull+"\\totalresult\\total_"+modelName;
		FileTool.createFolder(resultFileFolder);
		CommonTool.createSASDataSet(resultFileFolder, filename, columnDef);
		
		int rise_count=0;
		int down_count=0;
		
		int rise_0_count=0;
		int down_0_count=0;		
		int rise_10_count=0;
		int down_10_count=0;
		int rise_20_count=0;
		int down_20_count=0;
		
		List transDataList=new ArrayList();
		for (int i=0; i<transactionDataList.size(); i++)
		{
			TransactionRecordData trd=(TransactionRecordData)transactionDataList.get(i);
			
			double profit=trd.getSaleSDD().getProfit();
			if (profit==0)
			{
				if (trd.getBuySDD().getOpen()!=0)
				{
					profit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getOpen())/trd.getBuySDD().getOpen())*100;
				}
				else
				{
					profit=0;
				}
			}
			
			if (profit>0)
			{
				rise_count++;
			}
			
			if (profit<0)
			{
				down_count++;
			}
			
			if (profit>0 && profit<10)
			{
				rise_0_count++;
			}
			
			if (profit>10 && profit<20)
			{
				rise_10_count++;
			}
			
			if (profit>20)
			{
				rise_20_count++;
			}
			
			if (profit<0 && profit>=-10)
			{
				down_0_count++;
			}
			
			if (profit<-10 && profit>=-20)
			{
				down_10_count++;
			}

			if (profit<-20)
			{
				down_20_count++;
			}
			
			int days=trd.getSaleSDD().getPosNum()-trd.getBuySDD().getPosNum();
			double total_value=CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getTotal_value()/100000000);
			double liquid_value=CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getLiquid_value()/100000000);
			String dataDef= "'"+trd.getStockcode()+"',"+
							"'"+trd.getBuySDD().getName()+"',"+
							"'"+trd.getBuySDD().getIndustry()+"',"+
							+liquid_value+","+
							+total_value+","+
							"'"+trd.getBuySDD().getDate().trim()+"',"+
							"'"+trd.getSaleSDD().getDate().trim()+"',"+
							"'"+days+"',"+
							+CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getOpen())+","+
							+CommonTool.getDoubleNumberWithTwoBit(trd.getSaleSDD().getClose())+","+
							+CommonTool.getDoubleNumberWithTwoBit(profit)
							;
			transDataList.add(dataDef);
			
			System.out.print(trd.getStockcode()+"("+trd.getBuySDD().getName()+"): "+trd.getBuySDD().getDate().trim()+" ");
			System.out.print(trd.getSaleSDD().getDate().trim()+" "+CommonTool.getDoubleNumberWithTwoBit(profit)+"%");
			System.out.println("");
			
		}
		
		CommonTool.insertDataToSASDataSet(resultFileFolder, filename, transDataList);
		System.out.println("rise: "+rise_count+"  down: "+down_count);
		
		
	}
	
	public void outputTransactionRecordReport_ztb(List transactionDataList, String modelName)
	{
		
		String columnDef="stockcode varchar(10), stockname varchar(10),  liquid_value double precision format 12.2, total_value double precision format 12.2, " +
				"date_c varchar(20), saledate varchar(20), " +
				"profit double precision format 12.2, " +
				"days varchar(20), " +
				"buy_price double precision format 12.2, " +
				"open_rise_b double precision format 12.2, high_rise_b double precision format 12.2, final_rise_b double precision format 12.2, " +
				"sale_price double precision format 12.2, " +
				"open_rise_s double precision format 12.2, high_rise_s double precision format 12.2, final_rise_s double precision format 12.2, " +
				"swing double precision format 12.2, " +
				"profit_open double precision format 12.2, profit_high double precision format 12.2, " +
				"profit_low double precision format 12.2, profit_close double precision format 12.2," +
				"ai_profit double precision format 12.2 ";
		
		String timeStr=CommonTool.getCurrentTimeStr().replace("-", "").replace(",", "").replace(":", ""); 
		String filename="SelectTransResult_"+timeStr;
		String resultFileFolder=stockAllDataFull+"\\totalresult\\total_"+modelName;
		FileTool.createFolder(resultFileFolder);
		CommonTool.createSASDataSet(resultFileFolder, filename, columnDef);
		
		int rise_count=0;
		int down_count=0;
		
		int rise_0_count=0;
		int down_0_count=0;		
		int rise_10_count=0;
		int down_10_count=0;
		int rise_20_count=0;
		int down_20_count=0;
		
		List transDataList=new ArrayList();
		for (int i=0; i<transactionDataList.size(); i++)
		{
			TransactionRecordData trd=(TransactionRecordData)transactionDataList.get(i);
			
			double swing=trd.getBuySDD().getHigh_rise()-trd.getBuySDD().getLow_rise();
			
//			double profit=trd.getSaleSDD().getOpen_rise()-0.2;  // Ĭ���ǵڶ��������׳����������Ƿ�
			double profit=0;  // Ĭ���ǵڶ��������׳����������Ƿ�
			if (trd.getBuySDD().getOpen()!=0)
			{
				profit=((trd.getSaleSDD().getOpen()-trd.getBuySDD().getHigh())/trd.getBuySDD().getHigh())*100;
			}
			
			double profit_open=trd.getSaleSDD().getOpen_rise()-0.2;  // Ĭ���ǵڶ��쿪���׳����������Ƿ�
			double profit_high=trd.getSaleSDD().getHigh_rise()-0.2;  // Ĭ���ǵڶ��쿪���׳����������Ƿ�
			double profit_low=trd.getSaleSDD().getLow_rise()-0.2;  // Ĭ���ǵڶ��쿪���׳����������Ƿ�
			double profit_close=trd.getSaleSDD().getClose_rise()-0.2;  // Ĭ���ǵڶ��쿪���׳����������Ƿ�
			
			double ai_profit=0;
			if (profit_high>4)
			{
				ai_profit=4;
			}
			else
			{
				ai_profit=profit_close;
			}
			
			if (profit>0)
			{
				rise_count++;
			}
			
			if (profit<0)
			{
				down_count++;
			}
			
			if (profit>0 && profit<10)
			{
				rise_0_count++;
			}
			
			if (profit>10 && profit<20)
			{
				rise_10_count++;
			}
			
			if (profit>20)
			{
				rise_20_count++;
			}
			
			if (profit<0 && profit>=-10)
			{
				down_0_count++;
			}
			
			if (profit<-10 && profit>=-20)
			{
				down_10_count++;
			}

			if (profit<-20)
			{
				down_20_count++;
			}
			
			int days=trd.getSaleSDD().getPosNum()-trd.getBuySDD().getPosNum();
			double total_value=CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getTotal_value()/100000000);
			double liquid_value=CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getLiquid_value()/100000000);
			String dataDef= "'"+trd.getStockcode()+"',"+
							"'"+trd.getBuySDD().getName()+"',"+
							+liquid_value+","+
							+total_value+","+
							"'"+trd.getBuySDD().getDate().trim()+"',"+
							"'"+trd.getSaleSDD().getDate().trim()+"',"+
							+CommonTool.getDoubleNumberWithTwoBit(profit)+","+
							"'"+days+"',"+
							+CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getOpen())+","+
							+CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getOpen_rise())+","+
							+CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getHigh_rise())+","+
							+CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getClose_rise())+","+
							+CommonTool.getDoubleNumberWithTwoBit(trd.getSaleSDD().getClose())+","+
							+CommonTool.getDoubleNumberWithTwoBit(trd.getSaleSDD().getOpen_rise())+","+
							+CommonTool.getDoubleNumberWithTwoBit(trd.getSaleSDD().getHigh_rise())+","+
							+CommonTool.getDoubleNumberWithTwoBit(trd.getSaleSDD().getClose_rise())+","+
							+CommonTool.getDoubleNumberWithTwoBit(swing)+","+
							+CommonTool.getDoubleNumberWithTwoBit(profit_open)+","+
							+CommonTool.getDoubleNumberWithTwoBit(profit_high)+","+
							+CommonTool.getDoubleNumberWithTwoBit(profit_low)+","+
							+CommonTool.getDoubleNumberWithTwoBit(profit_close)+","+
							+CommonTool.getDoubleNumberWithTwoBit(ai_profit);
			
			transDataList.add(dataDef);
			
			System.out.print(trd.getStockcode()+"("+trd.getBuySDD().getName()+"): "+trd.getBuySDD().getDate().trim()+" ");
			System.out.print(trd.getSaleSDD().getDate().trim()+" "+CommonTool.getDoubleNumberWithTwoBit(profit)+"%");
			System.out.println("");
			
		}
		
		CommonTool.insertDataToSASDataSet(resultFileFolder, filename, transDataList);
		System.out.println("rise: "+rise_count+"  down: "+down_count);
		
		
	}
	
	
	
	public void outputTransactionRecordReport_slb(List transactionDataList, String modelName)
	{
		
		String columnDef="stockcode varchar(10), stockname varchar(10),  liquid_value double precision format 12.2, total_value double precision format 12.2, " +
				"date_c varchar(20), saledate varchar(20), days varchar(20), " +
				"buy_price double precision format 12.2, " +
				"open_rise_b double precision format 12.2, high_rise_b double precision format 12.2, final_rise_b double precision format 12.2, " +
				"sale_price double precision format 12.2, " +
				"open_rise_s double precision format 12.2, high_rise_s double precision format 12.2, final_rise_s double precision format 12.2, " +
				"swing double precision format 12.2, " +
				"profit double precision format 12.2, " +
				"profit_open double precision format 12.2, profit_high double precision format 12.2, " +
				"profit_low double precision format 12.2, profit_close double precision format 12.2," +
				"ai_profit double precision format 12.2 ";
		
		String timeStr=CommonTool.getCurrentTimeStr().replace("-", "").replace(",", "").replace(":", ""); 
		String filename="SelectTransResult_"+timeStr;
		String resultFileFolder=stockAllDataFull+"\\totalresult\\total_"+modelName;
		FileTool.createFolder(resultFileFolder);
		CommonTool.createSASDataSet(resultFileFolder, filename, columnDef);
		
		int rise_count=0;
		int down_count=0;
		
		int rise_0_count=0;
		int down_0_count=0;		
		int rise_10_count=0;
		int down_10_count=0;
		int rise_20_count=0;
		int down_20_count=0;
		
		List transDataList=new ArrayList();
		for (int i=0; i<transactionDataList.size(); i++)
		{
			TransactionRecordData trd=(TransactionRecordData)transactionDataList.get(i);
			
			double swing=trd.getBuySDD().getHigh_rise()-trd.getBuySDD().getLow_rise();
			
			double profit=0;  // Ĭ���ǵڶ��������׳����������Ƿ�
			if (trd.getBuySDD().getOpen()!=0)
			{
				profit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getOpen())/trd.getBuySDD().getOpen())*100-0.2;
			}
			
			
			double profit_open=trd.getSaleSDD().getOpen_rise()-0.2;  // Ĭ���ǵڶ��쿪���׳����������Ƿ�
			double profit_high=trd.getSaleSDD().getHigh_rise()-0.2;  // Ĭ���ǵڶ��쿪���׳����������Ƿ�
			double profit_low=trd.getSaleSDD().getLow_rise()-0.2;  // Ĭ���ǵڶ��쿪���׳����������Ƿ�
			double profit_close=trd.getSaleSDD().getClose_rise()-0.2;  // Ĭ���ǵڶ��쿪���׳����������Ƿ�
			
			double ai_profit=0;
			if (profit_high>4)
			{
				ai_profit=4;
			}
			else
			{
				ai_profit=profit_close;
			}
			
			if (profit>0)
			{
				rise_count++;
			}
			
			if (profit<0)
			{
				down_count++;
			}
			
			if (profit>0 && profit<10)
			{
				rise_0_count++;
			}
			
			if (profit>10 && profit<20)
			{
				rise_10_count++;
			}
			
			if (profit>20)
			{
				rise_20_count++;
			}
			
			if (profit<0 && profit>=-10)
			{
				down_0_count++;
			}
			
			if (profit<-10 && profit>=-20)
			{
				down_10_count++;
			}

			if (profit<-20)
			{
				down_20_count++;
			}
			
			int days=trd.getSaleSDD().getPosNum()-trd.getBuySDD().getPosNum();
			double total_value=CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getTotal_value()/100000000);
			double liquid_value=CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getLiquid_value()/100000000);
			String dataDef= "'"+trd.getStockcode()+"',"+
							"'"+trd.getBuySDD().getName()+"',"+
							+liquid_value+","+
							+total_value+","+
							"'"+trd.getBuySDD().getDate().trim()+"',"+
							"'"+trd.getSaleSDD().getDate().trim()+"',"+
							"'"+days+"',"+
							+CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getOpen())+","+
							+CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getOpen_rise())+","+
							+CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getHigh_rise())+","+
							+CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getClose_rise())+","+
							+CommonTool.getDoubleNumberWithTwoBit(trd.getSaleSDD().getClose())+","+
							+CommonTool.getDoubleNumberWithTwoBit(trd.getSaleSDD().getOpen_rise())+","+
							+CommonTool.getDoubleNumberWithTwoBit(trd.getSaleSDD().getHigh_rise())+","+
							+CommonTool.getDoubleNumberWithTwoBit(trd.getSaleSDD().getClose_rise())+","+
							+CommonTool.getDoubleNumberWithTwoBit(swing)+","+
							+CommonTool.getDoubleNumberWithTwoBit(profit)+","+
							+CommonTool.getDoubleNumberWithTwoBit(profit_open)+","+
							+CommonTool.getDoubleNumberWithTwoBit(profit_high)+","+
							+CommonTool.getDoubleNumberWithTwoBit(profit_low)+","+
							+CommonTool.getDoubleNumberWithTwoBit(profit_close)+","+
							+CommonTool.getDoubleNumberWithTwoBit(ai_profit);
			
			transDataList.add(dataDef);
			
			System.out.print(trd.getStockcode()+"("+trd.getBuySDD().getName()+"): "+trd.getBuySDD().getDate().trim()+" ");
			System.out.print(trd.getSaleSDD().getDate().trim()+" "+CommonTool.getDoubleNumberWithTwoBit(profit)+"%");
			System.out.println("");
			
		}
		
		CommonTool.insertDataToSASDataSet(resultFileFolder, filename, transDataList);
		System.out.println("rise: "+rise_count+"  down: "+down_count);
		
		
	}
	
	
	public void outputTransactionRecordReport_kpqzt(List transactionDataList, String modelName)
	{
		
		String columnDef="stockcode varchar(10), stockname varchar(10),  liquid_value double precision format 12.2, total_value double precision format 12.2, " +
				"date_c varchar(20), saledate varchar(20), days varchar(20), profit double precision format 12.2, " +
				"buy1Amount varchar(20), sale1Amount varchar(20), count varchar(20), money varchar(20), amount varchar(20), bsp varchar(5)";   // ����   �ɽ���	�ɽ���	������

		String filename="SelectTransResult";
		String resultFileFolder=stockAllDataFull+"\\totalresult\\total_"+modelName;
		FileTool.createFolder(resultFileFolder);
		CommonTool.createSASDataSet(resultFileFolder, filename, columnDef);
		
		int rise_count=0;
		int down_count=0;
		
		int rise_0_count=0;
		int down_0_count=0;		
		int rise_10_count=0;
		int down_10_count=0;
		int rise_20_count=0;
		int down_20_count=0;
		
		List transDataList=new ArrayList();
		for (int i=0; i<transactionDataList.size(); i++)
		{
			TransactionRecordData trd=(TransactionRecordData)transactionDataList.get(i);
			
			double profit=trd.getSaleSDD().getProfit();
			if (profit==0)
			{
				profit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getOpen())/trd.getBuySDD().getOpen())*100;
			}
			
			if (profit>0)
			{
				rise_count++;
			}
			
			if (profit<0)
			{
				down_count++;
			}
			
			if (profit>0 && profit<10)
			{
				rise_0_count++;
			}
			
			if (profit>10 && profit<20)
			{
				rise_10_count++;
			}
			
			if (profit>20)
			{
				rise_20_count++;
			}
			
			if (profit<0 && profit>=-10)
			{
				down_0_count++;
			}
			
			if (profit<-10 && profit>=-20)
			{
				down_10_count++;
			}

			if (profit<-20)
			{
				down_20_count++;
			}
			
			int days=trd.getSaleSDD().getPosNum()-trd.getBuySDD().getPosNum();
			double total_value=CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getTotal_value()/100000000);
			double liquid_value=CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getLiquid_value()/100000000);
			String dataDef= "'"+trd.getStockcode()+"',"+
							"'"+trd.getBuySDD().getName()+"',"+
							+liquid_value+","+
							+total_value+","+
							"'"+trd.getBuySDD().getDate().trim()+"',"+
							"'"+trd.getSaleSDD().getDate().trim()+"',"+
							"'"+days+"',"+
							CommonTool.getDoubleNumberWithTwoBit(profit)+
							"'"+trd.getSsd().getBuyAmount1()+"',"+
							"'"+trd.getSsd().getSaleAmount1()+"',"+
							"'"+trd.getSsd().getCount()+"',"+
							"'"+trd.getSsd().getMoney()+"',"+
							"'"+trd.getSsd().getAmount()+"',"+
							"'"+trd.getSsd().getBsp()+"',"
							;
			transDataList.add(dataDef);
			
			System.out.print(trd.getStockcode()+"("+trd.getBuySDD().getName()+"): "+trd.getBuySDD().getDate().trim()+" ");
			System.out.print(trd.getSaleSDD().getDate().trim()+" "+CommonTool.getDoubleNumberWithTwoBit(profit)+"%");
			System.out.println("");
			
		}
		
		CommonTool.insertDataToSASDataSet(resultFileFolder, filename, transDataList);
		System.out.println("rise: "+rise_count+"  down: "+down_count);
		
		
	}
	
	//	�Ƿ�����
	public void processStockByModel_zfpm(List researchStockCodeList, String startDate, String endDate, int minRiseDays)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename);
			
			System.out.println("Process stock: "+stockcode);
			
			List researchStockDayDataList=new ArrayList();
			for (int j=0; j<stockDataList.size(); j++)
			{	
				
				// ÿ�������
				StockDayData sdd=(StockDayData)stockDataList.get(j); 
				if (sdd.getDate().compareTo(startDate)>0 && sdd.getDate().compareTo(endDate)<0)
				{
					researchStockDayDataList.add(sdd);
				}
				
			}
			
			List RURList=new ArrayList();
			for (int m=0; m<researchStockDayDataList.size(); m++)
			{
				StockDayData sddm=(StockDayData)researchStockDayDataList.get(m);
				StockDayData maxSdd=sddm;
				for (int n=m; n<researchStockDayDataList.size(); n++)  // �ӵ�ǰ�۸�ֵ����������۸�ֵ
				{		
					StockDayData sddn=(StockDayData)researchStockDayDataList.get(n);
					if (sddn.getClose()>maxSdd.getClose())
					{
						maxSdd=sddn;
					}
				}
				
				double RUR=CommonTool.getDoubleNumberWithTwoBit((maxSdd.getClose()-sddm.getClose())*100/sddm.getClose()); // ���㵱ǰ�۸�ֵΪ����������Ƿ�
				maxSdd.setProfit(RUR);
				
				StockRecordRUR srr=new StockRecordRUR();
				srr.setCurSDD(sddm);
				srr.setMaxSDD(maxSdd);
				srr.setRUR(RUR);
			
				// ��¼ÿ��Ϊ���֮���������ǲ��μ�¼
				RURList.add(srr);
			}
			
			// ���ҳ�����������ǲ��μ�¼���������Ǹ�
			StockRecordRUR maxSRR=null;
			for (int p=0; p<RURList.size(); p++)
			{

				StockRecordRUR srr=(StockRecordRUR)RURList.get(p);
				if (maxSRR==null || srr.getRUR()>maxSRR.getRUR())
				{
					maxSRR=srr;
				}
			}
			
			if (maxSRR!=null)
			{
				if (maxSRR.getMaxSDD().getPosNum()-maxSRR.getCurSDD().getPosNum()<minRiseDays) continue; 
				
				TransactionRecordData trd=new TransactionRecordData();
				trd.setBuySDD(maxSRR.getCurSDD());
				trd.setSaleSDD(maxSRR.getMaxSDD());
				trd.setStockcode(stockcode);
				
				transactionDataList.add(trd);
			}
			
		}
		
		outputTransactionRecordReport(transactionDataList, "�Ƿ�����");	
		
	}
	
	
	public void outputTransactionRecordReport_fundselect(List transactionDataList, String modelName)
	{
		
		String columnDef="stockcode varchar(10), " +
				"stockname varchar(10),  " +
				"date_qt varchar(20), " +
				"count int format best12., "+
				"amount double precision format 12.2, " +
				"amount_change double precision format 12.2, " +
				"amount_change_percent double precision format 12.2, " +
				"value double precision format 12.2, " +
				"value_change double precision format 12.2, " +
				"percent double precision format 12.2, " +
				"percent_change double precision format 12.2, " +
				"date_c varchar(20), " +
				"saledate varchar(20), " +
				"days varchar(20), " +
				"buy_price double precision format 12.2, " +
				"sale_price double precision format 12.2, " +
				"profit double precision format 12.2, "+
				"pe double precision format 12.2, "+
				"pe_avg double precision format 12.2, "+
				"pe_over double precision format 12.2, "+
				"pe_min double precision format 12.2, "+
				"pe_max double precision format 12.2, "+
				"pe_mindate varchar(20), "+
				"pe_maxdate varchar(20), "+
				"earnChangeHistory varchar(500)"
				;
		
		String timeStr=CommonTool.getCurrentTimeStr().replace("-", "").replace(",", "").replace(":", ""); 
		String filename="SelectTransResult_"+timeStr;
		String resultFileFolder=stockAllDataFull+"\\totalresult\\total_"+modelName;
		FileTool.createFolder(resultFileFolder);
		CommonTool.createSASDataSet(resultFileFolder, filename, columnDef);
		
		int rise_count=0;
		int down_count=0;
		
		int rise_0_count=0;
		int down_0_count=0;		
		int rise_10_count=0;
		int down_10_count=0;
		int rise_20_count=0;
		int down_20_count=0;
		
		List transDataList=new ArrayList();
		for (int i=0; i<transactionDataList.size(); i++)
		{
			TransactionRecordData trd=(TransactionRecordData)transactionDataList.get(i);
			
			StockDayData buySDD=trd.getBuySDD();
			StockDayData saleSDD=trd.getSaleSDD();
			
			// ��ȡ������֮ǰ�˹�Ʊ�Ĳ�����Ϣ��Ϊ�ο�����
			String startDate=buySDD.getDate();
			String stockfilename="stock"+buySDD.getCode();
			String monitorStartDate=CommonTool.getStockTransDate(startDate, -600);	  // ��ȥ����۲����ʼ����
			String monitorEndDate=CommonTool.getStockTransDate(startDate, -1);	
			String condition3=" date>=\""+monitorStartDate+"\" and date<=\""+monitorEndDate+"\"";  // sql �����б�����˫���Ž�string����������
			List researchStockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition3);
			StockFinanceIndicator sfi=CommonTool.calculateStockFinanceIndicator(researchStockDataList);
		
			
			// ��������ͳ�ƽ������ǵ�����
			double profit=saleSDD.getProfit();
			if (profit==0)
			{
				if (trd.getBuySDD().getOpen()!=0)
				{
					profit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getOpen())/trd.getBuySDD().getOpen())*100;
				}
				else
				{
					profit=0;
				}
			}
			
			if (profit>0)
			{
				rise_count++;
			}
			
			if (profit<0)
			{
				down_count++;
			}
			
			if (profit>0 && profit<10)
			{
				rise_0_count++;
			}
			
			if (profit>10 && profit<20)
			{
				rise_10_count++;
			}
			
			if (profit>20)
			{
				rise_20_count++;
			}
			
			if (profit<0 && profit>=-10)
			{
				down_0_count++;
			}
			
			if (profit<-10 && profit>=-20)
			{
				down_10_count++;
			}

			if (profit<-20)
			{
				down_20_count++;
			}
			
			int days=trd.getSaleSDD().getPosNum()-trd.getBuySDD().getPosNum();
			double total_value=CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getTotal_value()/100000000);
			double liquid_value=CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getLiquid_value()/100000000);
			if (sfi.pe_avg==0) sfi.pe_avg=10;
			String dataDef= "'"+trd.getStockcode()+"',"+
							"'"+trd.getBuySDD().getName()+"',"+
							"'"+trd.fsd.date.trim()+"',"+
							+trd.fsd.stockHolderCount+","+
							+trd.fsd.stockHoldAmonut+","+
							+trd.fsd.stockHoldAmonutChange+","+
							+trd.fsd.stockHoldAmonutChangePercent+","+
							+trd.fsd.stockHoldValue+","+
							+trd.fsd.stockHoldValueChange+","+
							+trd.fsd.stockHoldPercent+","+
							+trd.fsd.stockHoldPercentChange+","+
							"'"+trd.getBuySDD().getDate().trim()+"',"+
							"'"+trd.getSaleSDD().getDate().trim()+"',"+
							"'"+days+"',"+
							+CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getOpen())+","+
							+CommonTool.getDoubleNumberWithTwoBit(trd.getSaleSDD().getClose())+","+
							+CommonTool.getDoubleNumberWithTwoBit(profit)+","+
							+CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getPe_ratio())+","+
							+CommonTool.getDoubleNumberWithTwoBit(sfi.pe_avg)+","+
							+CommonTool.getDoubleNumberWithTwoBit(trd.getBuySDD().getPe_ratio()/sfi.pe_avg-1)*100+","+
							+CommonTool.getDoubleNumberWithTwoBit(sfi.pe_min)+","+
							+CommonTool.getDoubleNumberWithTwoBit(sfi.pe_max)+","+
							"'"+sfi.pe_mindate+"',"+
							"'"+sfi.pe_maxdate+"',"+
							"'"+sfi.earnChangeHistory+"'"
							;
			transDataList.add(dataDef);
			
			System.out.print(trd.getStockcode()+"("+trd.getBuySDD().getName()+"): "+trd.getBuySDD().getDate().trim()+" ");
			System.out.print(trd.getSaleSDD().getDate().trim()+" "+CommonTool.getDoubleNumberWithTwoBit(profit)+"%");
			System.out.println("");
			
		}
		
		CommonTool.insertDataToSASDataSet(resultFileFolder, filename, transDataList);
		System.out.println("rise: "+rise_count+"  down: "+down_count);
		
		
	}
	
	
	//	��������ͣ
	public void processStockByModel_kpqzt(List researchStockCodeList, String startDate, String endDate)
	{
		
		double open_high=0;
		double open_low=-9;
		int top_count=100;
		
		List transactionDataList=new ArrayList();
		TreeMap allDaysStockMap=new TreeMap();  // key=date, value=stockOneDayAllStockMap
		
		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition); 
			
			System.out.println("Process stock: "+stockcode+"("+stockDataList.size()+")");
			
			for (int j=0; j<stockDataList.size()-1; j++)
			{	
				
				// ÿ�������
				StockDayData sdd=(StockDayData)stockDataList.get(j); 
				StockDayData sdd_a1=(StockDayData)stockDataList.get(j+1); // ȡ�õڶ����sdd
				sdd.setSaleSDD(sdd_a1);  // ���õڶ���sddΪ������
				
				if (sdd.getOpen_rise()>open_high || sdd.getOpen_rise()<open_low)  // ���ڿ����Ƿ�����open_high�͵���open_low�ľͲ�������
					continue;
				
				String code=sdd.getCode();
				String date=sdd.getDate();
				TreeMap stockOneDayAllStockMap;
				if (allDaysStockMap.get(date)==null)
				{
					stockOneDayAllStockMap=new TreeMap();  // key=open_rise, value=sdd
					stockOneDayAllStockMap.put(sdd.getOpen_rise(), sdd);
				}
				else
				{
					stockOneDayAllStockMap=(TreeMap)allDaysStockMap.get(date);
					stockOneDayAllStockMap.put(sdd.getOpen_rise(), sdd);
				}
				allDaysStockMap.put(date, stockOneDayAllStockMap);
				
			}
			
		}
		
		// ��ÿ���ȫ���Ʊ���Ͼ����������з���
		Iterator it=allDaysStockMap.keySet().iterator();
		while(it.hasNext())
		{
			// ȡ��ĳһ��ľ���������Ʊ����
			TreeMap stockOneDayAllStockMap=(TreeMap)allDaysStockMap.get(it.next());	
			Iterator sit=stockOneDayAllStockMap.descendingKeySet().iterator();
			int count=1;
			while(sit.hasNext())
			{
				if (count>top_count)  // ��ȡǰtop_count֧�Ƿ���ߵĹ�Ʊ��Ϊ�������
					break;
				
				StockDayData sdd=(StockDayData)stockOneDayAllStockMap.get(sit.next());
				
				StockSecondData ssd=checkOpenEnviroment(sdd);  // ������Ͼ���ssd��������Ҫ����ǰ�����sdd����Ҳ����Ҫ�󣬷���ssd
				if ( ssd!=null )
				{
					TransactionRecordData trd=new TransactionRecordData();
					trd.setStockcode(sdd.getCode());
					double profit=0;
//					if (sdd.getReal_rise()>0)
					if (1<0)
					{
						profit=((sdd.getSaleSDD().getClose()-sdd.getOpen())/sdd.getOpen())*100-0.2;  // ��ȥ������0.16�Ϳ��̼���
					}
					else
					{
						profit=((sdd.getSaleSDD().getOpen()-sdd.getOpen())/sdd.getOpen())*100-0.16;  // ��ȥ������0.16�Ϳ��̼���
					}
					sdd.getSaleSDD().setProfit(profit);
					trd.setBuySDD(sdd);
					trd.setSaleSDD(sdd.getSaleSDD());	
					trd.setSsd(ssd);
					
					transactionDataList.add(trd);
					System.out.print("  "+CommonTool.getDoubleNumberWithTwoBit(profit));
				}				
				
				count++;
				
			}
			
		}
		
		
		outputTransactionRecordReport_kpqzt(transactionDataList, "��������ͣ");	
		
	}
	
	
	//	���վ���ģ��
	public void processStockByModel_wrjx(List researchStockCodeList)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename);
			
			System.out.println("Process stock: "+stockcode);
			
			if (stockDataList.size()<=15)
				continue;
			
			for (int j=15; j<stockDataList.size()-1; j++)
			{

				StockDayData sdd=(StockDayData)stockDataList.get(j);
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				StockDayData sdd_b4=(StockDayData)stockDataList.get(j-4);
				StockDayData sdd_b5=(StockDayData)stockDataList.get(j-5);

				double sdd_total_value=CommonTool.getDoubleNumberWithTwoBit(sdd.getTotal_value()/100000000);
				double current_liquid_value=CommonTool.getStockCurrentLiquidValue(stockDataList);
				
				if (sdd_b1.getOpen()<sdd_b1.getMa_5() 
				 && sdd_b1.getOpen()<sdd_b1.getMa_10()
				 && sdd_b1.getClose()>sdd_b1.getMa_5()
				 && sdd_b1.getClose()>sdd_b1.getMa_10()
				 && sdd_b1.getHigh_rise()<9.9
				 && Math.abs(sdd_b1.getMa_5()-sdd_b1.getMa_10())*2/(sdd_b1.getMa_5()+sdd_b1.getMa_10())>0.04
				 && sdd.getOpen_rise()>0
				 && sdd_total_value>1000 // 500��������ֵ
				 )
				{
					
					TransactionRecordData trd=new TransactionRecordData();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(sdd);
										
					// ��¼�����¼������������棬��̬��������׳��ղ���¼�׳�ʱ������ֵ
//					for (int k=j+1; k<stockDataList.size()-3 && k<j+120; k++)
					{
						int k=j+1;
						StockDayData sdd_a1=(StockDayData)stockDataList.get(k);
//						if (sdd_a1.getReal_rise()<-2 && sdd_a1.getClose_rise()<0) // ���������������µ�
						{
							
							double profit=0;
							profit=((sdd_a1.getClose()-sdd.getOpen())/sdd.getOpen())*100-0.2;  // ��ȥ������0.16�Ϳ��̼���
							sdd_a1.setProfit(profit);
							trd.setSaleSDD(sdd_a1);
							transactionDataList.add(trd);
							break;
							
						}
						
					}
										
					
				}
				
				
			}
				
		}
		
		outputTransactionRecordReport(transactionDataList, "���վ���");	
		
	}
	
	
	//	�����ֹ�
	public void processStockByModel_zjcg(List researchStockCodeList)
	{
		
		// ����ֹɼ�¼
		
		
		
		// ѭ������˹�Ʊ�ڳֹ�֮ǰ�����£�ǰһ���£���һ���£���������
		
		
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename);
			
			System.out.println("Process stock: "+stockcode);
			
			for (int j=0; j<stockDataList.size(); j++)
			{	
				
				// ÿ�������
				StockDayData sdd=(StockDayData)stockDataList.get(j); 
				
				
			}
			
		}
		
		outputTransactionRecordReport(transactionDataList, "");	
		
	}
	
	
	
	//	������ģ��
	public void processStockByModel_wjz(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻETF���Ʊ����ʷ��������
			String researchcode=((String)researchStockCodeList.get(i));
			List stockDataList;
			if (researchcode.startsWith("index"))
			{
				String stockfilename=researchcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
				System.out.println("Process stock: "+researchcode);
			}
			else
			{
				String stockcode=researchcode.substring(2); // ȥ��ǰ׺ sh, sz
				String stockfilename="stock"+stockcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
				System.out.println("Process stock: "+stockcode);
			}
			
			int hold_days=20;    // �������е�����
			double eq_ratio=1.5;
			int k_value=20;
			int d_value=20;
//			double sale_rise=2;  // ������: ������������߼����� �����Է�����������Ҫ̰�ƣ���׬���У�
//			double over_rise=8;  // ���߻����: ������������͵�߼����㣨�����������ӯ���ϴ�����ۣ��Ͳ����ٽ����ˣ��Է������������ߣ�
//			double loss_rise=5;  // ��ֹ���: ���ֿ������͵�ͼ����㣨���Բ���һ�Σ�̯�ͳɱ���һ������������������
			boolean checkAssetsBack=true;
			String assetsBackDate="";   // �ʲ��������ڣ���Ϊ�������������µ����ʽ���ã���Ҫ��һ����������ʶ�ʲ�����������
			
			
			for (int j=10; j<stockDataList.size()-1; j++)
			{

				StockDayData sdd=(StockDayData)stockDataList.get(j);
		
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				StockDayData sdd_b4=(StockDayData)stockDataList.get(j-4);
				StockDayData sdd_b5=(StockDayData)stockDataList.get(j-5);

				if (sdd.getDate().compareTo(assetsBackDate)<0 && checkAssetsBack)   // ��鵱ǰ�ʲ��Ƿ���ã������û�л������ܽ���
					continue;
				
				double sdd_total_value=CommonTool.getDoubleNumberWithTwoBit(sdd.getTotal_value()/100000000);
				double current_liquid_value=CommonTool.getStockCurrentLiquidValue(stockDataList);
				
				if (
				sdd_b1.getKdj_k()<k_value && sdd_b1.getKdj_d()<d_value   // K,D<20		
				&& sdd_b1.getKdj_k()>sdd_b1.getKdj_d()	// KD���
				&& sdd_b3.getKdj_k()<sdd_b3.getKdj_d()	// KD���
				&& sdd_b1.getEq_ratio()>eq_ratio			// ���ȴ���1
				&& sdd_b1.getOpen()>sdd_b1.getMa_5() && sdd_b1.getClose()>sdd_b1.getMa_5()    // վ��5�վ���
//				&& sdd.getReal_rise()>0
				)
				{
					
					double buy_price=sdd.getOpen();  // �ڶ��쿪�̾������ۼ۸�ߵ�
					
					TransactionRecordData trd=new TransactionRecordData();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(sdd);
					trd.setTransactionBuyPrice(buy_price);
					
					
					int hold_endday_pos=j+hold_days;
					if (hold_endday_pos>stockDataList.size()-1)
					{
						hold_endday_pos=stockDataList.size()-1;
					}
					
					for (int s=j+1; s<=hold_endday_pos; s++)	// �鿴����10���ڵĽ��׾�����������s
					{
						StockDayData sdd_s=(StockDayData)stockDataList.get(s);
//						if (sdd_s.getHigh()>sale_price)  // ���ĳһ�����м۸��ϳ嵽Ԥ���������۸�������ֹӯ
//						{
//								double profit=(sdd_s.getClose()-buy_price)/buy_price*100;
//								sdd_s.setProfit(profit);
//								trd.setSaleSDD(sdd_s);
//								trd.setTransactionProfit(profit);
//								break;
//						}
						
//						MarketRDDayData mdd=(MarketRDDayData)marketDataRecordMap.get(sdd_s.getDate());
//						
//						if (mdd.getDown10()>500) // ���ĳһ����̳��ִ������ͣ��������ʱ����ֹ��
//						{
//								double profit=(sdd_s.getClose()-buy_price)/buy_price*100-0.2;
//								sdd_s.setProfit(profit);
//								trd.setSaleSDD(sdd_s);
//								trd.setTransactionProfit(profit);
//								break;
//						}
//						else   // �������û�з������գ����¼�������ʱ������
						{
								double profit=(sdd_s.getClose()-buy_price)/buy_price*100-0.2; 
								sdd_s.setProfit(profit);
								trd.setSaleSDD(sdd_s);
								trd.setTransactionProfit(profit);
								trd.setTransactionSalePrice(sdd_s.getClose());
						}
						
					}
					
					
					transactionDataList.add(trd);
					assetsBackDate=trd.getSaleSDD().getDate();
					
					
				}
			
			
			}
			
		}
		
		outputTransactionRecordReport(transactionDataList, "������ѡ��");	
		
	}	
	
	
	
	//	������ģ�ͳ�ʼ�о�
	public void processStockByModel_wjzcs(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			for (int j=10; j<stockDataList.size()-1; j++)
			{

				StockDayData sdd=(StockDayData)stockDataList.get(j);
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				StockDayData sdd_b4=(StockDayData)stockDataList.get(j-4);
				StockDayData sdd_b5=(StockDayData)stockDataList.get(j-5);

				double sdd_total_value=CommonTool.getDoubleNumberWithTwoBit(sdd.getTotal_value()/100000000);
				double current_liquid_value=CommonTool.getStockCurrentLiquidValue(stockDataList);
				
				if (
				sdd_b1.getKdj_k()<20 && sdd_b1.getKdj_d()<20   // K,D<20		
				&& sdd_b1.getKdj_k()>sdd_b1.getKdj_d()	// KD���
				&& sdd_b3.getKdj_k()<sdd_b3.getKdj_d()	// KD���
				&& sdd_b1.getEq_ratio()>2			// ���ȴ���1
				&& sdd_b1.getClose()>sdd_b1.getMa_5()   // վ��5�վ���
//				&& sdd.getReal_rise()>0
				)
				{
					TransactionRecordData trd=new TransactionRecordData();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(sdd);
					
					// ��¼�����¼������������棬��̬��������׳��ղ���¼�׳�ʱ������ֵ
					for (int k=j+1; k<stockDataList.size()-3 && k<j+120; k++)
					{
						
						StockDayData sdd_a1=(StockDayData)stockDataList.get(k);
						StockDayData sdd_a2=(StockDayData)stockDataList.get(k+1);
						double profit=((sdd_a2.getClose()-sdd.getOpen())/sdd.getOpen())*100-0.2;  // ��ȥ������0.16�Ϳ��̼���
//						double profit=((sdd_a2.getClose()-sdd.getClose())/sdd.getClose())*100-0.2;  // ��ȥ������0.16�Ϳ��̼���
						if (profit<-10)
						{
							// �����̳����ܿ������-5%��ֹ��
							if (sdd_a1.getClose_rise()>-9.9)
							{
								sdd_a1.setProfit(profit);
								trd.setSaleSDD(sdd_a1);
								transactionDataList.add(trd);
								break;
							}
							else if (sdd_a2.getOpen_rise()>-9)
							{
								profit=((sdd_a2.getOpen()-sdd.getOpen())/sdd.getOpen())*100-0.2;
//								profit=((sdd_a2.getOpen()-sdd.getClose())/sdd.getClose())*100-0.2;
								sdd_a1.setProfit(profit);
								trd.setSaleSDD(sdd_a2);
								transactionDataList.add(trd);
								break;
							}
						}
						else
						{
							// �����̳������������������������µ��Ҵ���10�վ��ߣ�ֹӯ
							if(sdd_a1.getOpen()>=sdd_a1.getClose() && sdd_a2.getOpen()>=sdd_a2.getClose()  // ��������
							 && sdd_a1.getClose()>sdd_a2.getClose()  // ���������µ�
							 && sdd_a2.getLow()<sdd_a2.getMa_10())  // �ڶ���������ͼ۴̴�10�վ���
							{
								profit=((sdd_a2.getOpen()-sdd.getOpen())/sdd.getOpen())*100-0.2;
//								profit=((sdd_a2.getOpen()-sdd.getClose())/sdd.getClose())*100-0.2;
								sdd_a2.setProfit(profit);
								trd.setSaleSDD(sdd_a2);
								transactionDataList.add(trd);
								break;
							}
							
							
						}
						
					}
				}
			
			
			}
			
		}
		
		outputTransactionRecordReport(transactionDataList, "������ѡ��");	
		
	}
	
	
	//	�����ҸĽ�ģ��
	public void processStockByModel_wjzgj(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			int days=30; // ǰ��KDJ��������
			
			for (int j=days; j<stockDataList.size()-1; j++)  
			{

				StockDayData sdd=(StockDayData)stockDataList.get(j);  // ������ 1��
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);	// ��ͣ�� 1��

				double sdd_total_value=CommonTool.getDoubleNumberWithTwoBit(sdd.getTotal_value()/100000000);
				double current_liquid_value=CommonTool.getStockCurrentLiquidValue(stockDataList);
				
				if (
					sdd_b1.getClose_rise()>9.9  // ��ͣ��
					&& sdd_b1.getEq_ratio()>1.8	// ��ͣ������>1.8
					&& sdd.getOpen_rise()<9.9  // ��ͣ�պ�һ�������
					&& checkPastDaysKDJ(stockDataList, sdd_b1, days-1)  // ��ͣ��ǰ days-1 ��
				)
				{
					
					TransactionRecordData trd=new TransactionRecordData();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(sdd);
					
					
						// ��¼�����¼������������棬��̬��������׳��ղ���¼�׳�ʱ������ֵ
						for (int k=j+1; k<stockDataList.size()-3 && k<j+120; k++)
						{
							
							StockDayData sdd_a1=(StockDayData)stockDataList.get(k);
							StockDayData sdd_a2=(StockDayData)stockDataList.get(k+1);						
							
							
							double profit=((sdd_a2.getClose()-sdd.getOpen())/sdd.getOpen())*100-0.2;  // ��ȥ������0.16�Ϳ��̼���
	//						double profit=((sdd_a2.getClose()-sdd.getClose())/sdd.getClose())*100-0.2;  // ��ȥ������0.16�Ϳ��̼���
							if (profit<-20)
							{
								// �����̳����ܿ������-5%��ֹ��
								if (sdd_a1.getClose_rise()>-9.9)
								{
									sdd_a1.setProfit(profit);
									trd.setSaleSDD(sdd_a1);
									transactionDataList.add(trd);
									break;
								}
								else if (sdd_a2.getOpen_rise()>-9)
								{
									profit=((sdd_a2.getOpen()-sdd.getOpen())/sdd.getOpen())*100-0.2;
	//								profit=((sdd_a2.getOpen()-sdd.getClose())/sdd.getClose())*100-0.2;
									sdd_a1.setProfit(profit);
									trd.setSaleSDD(sdd_a2);
									transactionDataList.add(trd);
									break;
								}
							}
							else
							{
								// �����̳������������������������µ��Ҵ���10�վ��ߣ�ֹӯ
								if(sdd_a1.getOpen()>=sdd_a1.getClose() && sdd_a2.getOpen()>=sdd_a2.getClose()  // ��������
								 && sdd_a1.getClose()>sdd_a2.getClose()  // ���������µ�
								 && sdd_a2.getLow()<sdd_a2.getMa_10())  // �ڶ���������ͼ۴̴�10�վ���
								{
									profit=((sdd_a2.getOpen()-sdd.getOpen())/sdd.getOpen())*100-0.2;
	//								profit=((sdd_a2.getOpen()-sdd.getClose())/sdd.getClose())*100-0.2;
									sdd_a2.setProfit(profit);
									trd.setSaleSDD(sdd_a2);
									transactionDataList.add(trd);
									break;
								}
								
								
							}
							
						}
						
					
					break;   // ֻ�ҵ�һ����ͣ
					
				}
			
			
			}
			
		}
		
		outputTransactionRecordReport(transactionDataList, "������ѡ�ɸĽ�");	
		
	}
	
	
	
	//	��ͣ�����ģ��
	public void processStockByModel_ztb(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			int days=10; // ǰ�ڿ�������
			
			for (int j=days; j<stockDataList.size()-1; j++)
			{
				
				// ÿ�������
				StockDayData sdd=(StockDayData)stockDataList.get(j); 
				
				if (
						sdd.getClose_rise()>9  // ��ͣ��
						&& sdd.getReal_rise()>3  // ��ͣ��������룬�г��뽻������һ����ͣ
//						&& checkPastDaysZTB(stockDataList, sdd, days-1)   // ֮ǰdays��û����ͣ����
					)
					{
						
						TransactionRecordData trd=new TransactionRecordData();
						trd.setStockcode(sdd.getCode());
						trd.setBuySDD(sdd);
						
						// �жϲ�����������sdd��Ϣ
						StockDayData sdd_a1=(StockDayData)stockDataList.get(j+1);
						trd.setSaleSDD(sdd_a1);
							
						transactionDataList.add(trd);
					
					}
				
			}
			
		}
		
		outputTransactionRecordReport_ztb(transactionDataList, "��ͣ��");	
		
	}
	
	
	//	��ͣ������о�ģ��
	public void processStockByModel_ztbyj(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			int days=5; // ǰ�ڿ�������
			
			for (int j=days; j<stockDataList.size()-1; j++)
			{
				
				// ÿ�������
				StockDayData sdd=(StockDayData)stockDataList.get(j); 
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1); 
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				
				if (
						sdd.getHigh_rise()>9  // ��ͣ��
						&& sdd.getOpen_rise()<7
//						&& sdd.getHigh_rise()-sdd.getLow_rise()>7  // ��ͣ��������룬�г��뽻������һ����ͣ
						&& sdd_b1.getClose_rise()>9.9   // ������ͣ
						&& sdd_b1.getReal_rise()>2
						&& sdd_b2.getClose_rise()>9.9	// ǰ����ͣ
						&& sdd_b2.getReal_rise()>2
//						&& checkPastDaysZTB(stockDataList, sdd_b2, days-3)   // ֮ǰdays��û����ͣ����
					)
					{
						
						TransactionRecordData trd=new TransactionRecordData();
						trd.setStockcode(sdd.getCode());
						trd.setBuySDD(sdd);
						
						// �жϲ�����������sdd��Ϣ
						StockDayData sdd_a1=(StockDayData)stockDataList.get(j+1);
						trd.setSaleSDD(sdd_a1);
							
						transactionDataList.add(trd);
					
					}
				
			}
			
		}
		
		outputTransactionRecordReport_ztb(transactionDataList, "��ͣ���о�");	
		
	}
	
	
	//	���������ģ��
	public void processStockByModel_slb(List researchStockCodeList, String startDate, String endDate)
	{
		
		int days=100; // ǰ�ڿ�������
		startDate=CommonTool.getStockTransDate(startDate, -100);  // ��ú�ʵ����Ҫ�����Ŀ�ʼ����
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			int startPos=10;
			if (stockDataList.size()>days)
			{
				startPos=days;
			}
			
			for (int j=startPos; j<stockDataList.size()-1; j++)
			{
				
				// ÿ�������
				StockDayData sdd=(StockDayData)stockDataList.get(j); 
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1); 
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				
				List preStockDataList=new ArrayList();
				for (int s=1; s<=7; s++)
				{
					preStockDataList.add(stockDataList.get(j-3-s));  // ȡ��b3ǰ7��Ľ�������
				}
				
				if (
						sdd.getOpen_rise()<8  // ����������
						&& sdd_b1.getClose_rise()>9.9  // ��ͣ��
						&& sdd_b1.getOpen_rise()>0
						&& sdd_b1.getReal_rise()>1
						&& sdd_b1.getLow()>sdd_b2.getHigh()
						&& sdd_b2.getClose_rise()>9.9  // ��ͣ��
						&& sdd_b2.getOpen_rise()>0
						&& sdd_b2.getReal_rise()>1
						&& sdd_b2.getLow()>sdd_b3.getHigh()
						&& sdd_b3.getClose_rise()>9.9  // ��ͣ��
//						&& sdd_b3.getReal_rise()>1
//						&& sdd_b2.getReal_rise()>1
//						&& sdd.getLow()>sdd_b1.getHigh()
//						&& sdd_b1.getLow()>sdd_b1.getHigh()
//						&& checkPastDaysZTB(stockDataList, sdd, days-1)   // ֮ǰdays��û����ͣ����
//						&& checkStockPreTrend_DDR_RUR(preStockDataList, 15)
						&& checkPastDaysHighPrice(sdd_b1, stockDataList, sdd_b3.getPosNum(), days)
					)
					{
						
						TransactionRecordData trd=new TransactionRecordData();
						trd.setStockcode(sdd.getCode());
						trd.setBuySDD(sdd);
						
						// �жϲ�����������sdd��Ϣ
						StockDayData sdd_a1=(StockDayData)stockDataList.get(j+1);
						trd.setSaleSDD(sdd_a1);
							
						transactionDataList.add(trd);
					
					}
				
			}
			
		}
		
		outputTransactionRecordReport_slb(transactionDataList, "������");	
		
	}
	
	//	���ɺ��������ģ��
	public void processStockByModel_yghdy(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			int days=10; // ǰ�ڿ�������
			
			for (int j=days; j<stockDataList.size()-1; j++)
			{
				
				// ÿ�������
				StockDayData sdd=(StockDayData)stockDataList.get(j); 
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1); 
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3); 
				
				if (
						sdd.getOpen_rise()<-4  // ����������
						&& sdd_b1.getClose_rise()>9.9  // ��ͣ��
						&& sdd_b2.getClose_rise()>9.9  // ��ͣ��
						&& sdd.getHigh_rise()-sdd.getLow_rise()>10
						&& sdd.getHigh_rise()>5
//						&& sdd.getLow()>sdd_b1.getHigh()
//						&& sdd_b1.getLow()>sdd_b1.getHigh()
//						&& checkPastDaysZTB(stockDataList, sdd, days-1)   // ֮ǰdays��û����ͣ����
					)
					{
						
						TransactionRecordData trd=new TransactionRecordData();
						trd.setStockcode(sdd.getCode());
						trd.setBuySDD(sdd);
						
						// �жϲ�����������sdd��Ϣ
						StockDayData sdd_a1=(StockDayData)stockDataList.get(j+1);
						
						double profit=0;
						if (sdd.getReal_rise()>=0)
						{
							// ���sdd���������ڶ���������
							profit=sdd_a1.getClose_rise()+(sdd.getClose_rise()-sdd.getLow_rise()-10);
						}
						else
						{
							// ���sdd���������ڶ��쿪�̾���
							profit=sdd_a1.getOpen_rise()+(sdd.getClose_rise()-sdd.getLow_rise()-10);
						}
						
						sdd_a1.setProfit(profit);
						trd.setSaleSDD(sdd_a1);
						
						transactionDataList.add(trd);
					
					}
				
			}
			
		}
		
		outputTransactionRecordReport(transactionDataList, "���ɺ����");	
		
	}
	
	
	//	����֮��ģ��
	public void processStockByModel_dzzh(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);

			int days=10; // ǰ�ڿ���������0 �� days-1 ��
			double zyd=2;  // ֹӯ��
			
			for (int j=days; j<stockDataList.size(); j++)  
			{
				
				if(j+2<stockDataList.size())
				{

					// ÿ�������
					StockDayData sdd=(StockDayData)stockDataList.get(j); 
					StockDayData sdd_a1=(StockDayData)stockDataList.get(j+1);
					StockDayData sdd_a2=(StockDayData)stockDataList.get(j+2);
				
					List preDaysStockDataList=stockDataList.subList(j-days, j-1);
					if (sdd.getClose_rise()>8 
					&& sdd.getClose_rise()<9.9 
//					&& checkPastDaysHighRise(sdd, stockDataList, sdd.getPosNum(), days)
//					&& checkStockPreTrend_DDR_RUR(preDaysStockDataList, 10)
//					&& CommonTool.calculateMaxRiseUpBySDD(preDaysStockDataList).getRUR()<10
					&& checkPastDays_PZZF(preDaysStockDataList, 9.9)
					)
					{					
					
						double sdd_total_value=CommonTool.getDoubleNumberWithTwoBit(sdd.getTotal_value()/100000000);
						double current_liquid_value=CommonTool.getStockCurrentLiquidValue(stockDataList);
						
						if (sdd_total_value<500)
							continue;
						
						
						TransactionRecordData trd=new TransactionRecordData();
						trd.setStockcode(sdd.getCode());
						trd.setBuySDD(sdd);
						
						double highRise_a1=((sdd_a1.getHigh()-sdd.getClose())/sdd.getClose())*100-0.2;
						double highRise_a2=((sdd_a2.getHigh()-sdd.getClose())/sdd.getClose())*100-0.2;
						double openRise_a1=((sdd_a1.getOpen()-sdd.getClose())/sdd.getClose())*100-0.2;
						double openRise_a2=((sdd_a2.getOpen()-sdd.getClose())/sdd.getClose())*100-0.2;
						
						double profit=0;
						if (openRise_a1>zyd)
						{
							profit=openRise_a1;
						}
						else if (highRise_a1>zyd)
						{
							profit=zyd;
						}
						else if (openRise_a2>zyd)
						{
							profit=openRise_a2;
						}
						else if (highRise_a2>zyd)
						{
							profit=zyd;
						}
						else
						{
							profit=((sdd_a2.getClose()-sdd.getClose())/sdd.getClose())*100-0.2;
						}
						
						sdd_a2.setProfit(profit);
						trd.setSaleSDD(sdd_a2);
						
						transactionDataList.add(trd);
						
					}
					
				}
				else
				{
					
				}
				
			}
			
		}
		
		outputTransactionRecordReport(transactionDataList, "����֮��");	
		
	}
	
	
	//	�����ʽ�ģ��
	public void processStockByModel_bkzj(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			int days=10; // ǰ�ڿ�������
			
			for (int j=days; j<stockDataList.size()-1; j++)  
			{
				
					// ÿ�������
					StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
					StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
					StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
					StockDayData sdd=(StockDayData)stockDataList.get(j); 
				
					List preDaysStockDataList=stockDataList.subList(j-days, j-1);
					
					if (
					sdd_b3.getClose_rise()>9.9
					&& sdd_b2.getReal_rise()>2
					&& sdd_b1.getHigh()<sdd_b2.getLow()
					&& sdd_b2.getMoney()>300000000
//					&& checkPastDaysHighRise(sdd, stockDataList, sdd.getPosNum(), days)
//					&& checkStockPreTrend_DDR_RUR(preDaysStockDataList, 10)
//					&& CommonTool.calculateMaxRiseUpBySDD(preDaysStockDataList).getRUR()<10
//					&& checkPastDays_PZZF(preDaysStockDataList, 9.9)
					)
					{		
						
						TransactionRecordData trd=new TransactionRecordData();
						trd.setStockcode(stockcode);
						trd.setBuySDD(sdd);
						trd.setSaleSDD(sdd);
						for (int k=j+1; k<stockDataList.size()-1 && k<j+365 ; k++)
						{
							
							StockDayData sdd_k=(StockDayData)stockDataList.get(k);
							trd.setSaleSDD(sdd_k);
								
							List profitDayDataList=stockDataList.subList(j, k);
							StockRecordDDR srd=CommonTool.calculateMaxDrawDownBySDD(profitDayDataList);
							if (srd.getDDR()>10) // ���ֻس�����10%ʱ�ͽ�������������
							{
								break;								
							}
							
						}
						
						transactionDataList.add(trd);
						
						
					}
				
			}
			
		}
		
		outputTransactionRecordReport(transactionDataList, "�����ʽ�");	
		
	}
	
	
	//	ģ��ģ��
	public void processStockByModel_fundselect()
	{
		
		List transactionDataList=new ArrayList();
		
		try
		{
			
			//	����fund����ÿһ������
			String fundSelectListFile="fund_all";
			String fundAllFileFolder=fundAllDataFull+"\\All";
//			String condition1="1>0 order by date asc, percent_change desc";
//			String condition1="1>0 order by date asc, amount_increase desc";
//			String condition1="1>0 order by date asc, value_change desc";
//			String condition1="count>20 and value_change>0 order by date asc, value_change desc";
			String condition1="1>0 order by date asc, value_change desc";
			ResultSet rs=CommonTool.readDataFromSASDataSet(fundAllFileFolder, fundSelectListFile, condition1);
			
			String dateNo="";
			int i=0;
			String lastDate="2011/03/31";
			while (rs.next()) {
				
				i++;
				String date=rs.getString("date").trim();			// �����ȿ�ʼ��
				
//				if (date.equals(lastDate))
//				{
//					if (i>=20)
//					continue;
//				}
//				else
//				{
//					i=0;
//				}
				lastDate=date;
				
				int no=rs.getInt("no");
				String stockcode=rs.getString("stockcode").trim();
				String stockname=rs.getString("stockname").trim();
				int count=rs.getInt("count");
				int amount=rs.getInt("amount");
				int amount_change=rs.getInt("amount_change");
				double amount_increase=rs.getDouble("amount_increase");
				double value=rs.getDouble("value");
				double value_change=rs.getDouble("value_change");
				double percent=rs.getDouble("percent");
				double percent_change=rs.getDouble("percent_change");
				
				String preDate=CommonTool.getStockTransDate(date, -40);	  // �ϼ��ȳֲֹ�����, ��ʱ����
				String startDate=CommonTool.getStockTransDate(date, 20);  // �����ȳֲֹ�����
				String endDate=CommonTool.getStockTransDate(date, 80);	  // �¼��ȳֲֹ�����
				
				String stockfilename="stock"+stockcode;
				String condition2=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
				List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition2);
				
				for (int j=0; j<stockDataList.size(); j++)  
				{
					
					// ÿ�������
					StockDayData sdd=(StockDayData)stockDataList.get(j); 
					
					if (sdd.getDate().equals(startDate))
					{
							
						TransactionRecordData trd=new TransactionRecordData();
						trd.setStockcode(stockcode);
						trd.setBuySDD(sdd);
						
						FundStatData fsd=new FundStatData();
						fsd.date=date;
						fsd.stockNo=no;
						fsd.stockCode=stockcode;
						fsd.stockName=stockname;
						fsd.stockHolderCount=count;
						fsd.stockHoldAmonut=amount;
						fsd.stockHoldAmonutChange=amount_change;
						fsd.stockHoldAmonutChangePercent=amount_increase;
						fsd.stockHoldPercent=percent;
						fsd.stockHoldPercentChange=percent_change;
						fsd.stockHoldValue=value;
						fsd.stockHoldValueChange=value_change;
						trd.fsd=fsd;
						
//						StockDayData saleSdd=(StockDayData)stockDataList.get(stockDataList.size()-1); 
//						trd.setSaleSDD(saleSdd);
//						
//						double profit=((saleSdd.getClose()-sdd.getOpen())/sdd.getOpen())*100-0.2;  // ��ȥ������0.16�Ϳ��̼���
//						profit=CommonTool.getDoubleNumberWithTwoBit(profit);
//						transactionDataList.add(trd);
					
						
						// ��¼�����¼������������棬��̬��������׳��ղ���¼�׳�ʱ������ֵ
						StockDayData sdd_a1=(StockDayData)stockDataList.get(j);
						StockDayData sdd_a2=(StockDayData)stockDataList.get(j);
						double profit=0;
						for (int k=j+1; k<stockDataList.size()-1 && k<j+120; k++)
						{
							
							sdd_a1=(StockDayData)stockDataList.get(k);
							sdd_a2=(StockDayData)stockDataList.get(k+1);
							profit=((sdd_a2.getClose()-sdd.getOpen())/sdd.getOpen())*100-0.2;  // ��ȥ������0.16�Ϳ��̼���
							
							if (profit<-10)
							{
								// �����̳����ܿ������-15%��ֹ��
								break;
							}
							else if (profit>10)
							{
								// �����̳������������������������µ��Ҵ���10�վ��ߣ�ֹӯ
								if(sdd_a1.getOpen()>=sdd_a1.getClose() && sdd_a2.getOpen()>=sdd_a2.getClose()  // ��������
								 && sdd_a1.getClose()>sdd_a2.getClose()  // ���������µ�
								 && sdd_a2.getLow()<sdd_a2.getMa_10())  // �ڶ���������ͼ۴̴�10�վ���
								{
									break;
								}
								
							}
							
							
						}
						
						sdd_a2.setProfit(profit);
						trd.setSaleSDD(sdd_a2);
						transactionDataList.add(trd);
						
						System.out.println(date+" Process stock: "+stockcode+" "+stockname+" "+startDate+" "+endDate+" "+profit);
						
						
					}
					
				}
					
				
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

		
		outputTransactionRecordReport_fundselect(transactionDataList, "����ѡ��");	
		
	}
	
	
	//	������ģ��
	public void processStockByModel_macd_ddz(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			for (int j=10; j<stockDataList.size()-1; j++)
			{

				StockDayData sdd=(StockDayData)stockDataList.get(j);
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);


				double sdd_total_value=CommonTool.getDoubleNumberWithTwoBit(sdd.getTotal_value()/100000000);
				double current_liquid_value=CommonTool.getStockCurrentLiquidValue(stockDataList);
				
				
				boolean ma_trends=true;
				
				if (sdd_b1.getMa_5()<sdd_b1.getMa_10() 
				&& sdd_b1.getMa_10()<sdd_b1.getMa_20()
				&& sdd_b1.getMa_20()<sdd_b1.getMa_60())
				{
					ma_trends=false;
				}
				
				double ddz_ratio=checkPastDaysDDZ(stockDataList, sdd_b2, 7);
//				double stock_rate=checkStockPastRate(stockDataList);
				
				if (
					ddz_ratio>0			// ddz�����������С��ֵ>8
				    && sdd_b2.getMa_ddz()<-100   // ddzֵ<-100 --- ���Ҳ��һ����Ҫ�����������ò��������Է���
//					&& sdd_b2.getMa_ddz()>-900   // ddzֵ>-900 
					&& sdd_b1.getMa_ddz()>sdd_b2.getMa_ddz() // b1��ddzֵ��b2��ddzֵ����� --- �������Ҫ��ת���������������ֺܶ��ظ����
//					&& sdd_b1.getReal_rise()<4    // b1�Ƿ�����̫��ҪС��3%  
					&& sdd.getOpen_rise()>-9      // �����ղ����ǵ�ͣ����   
					&& sdd_total_value>500      // ��λ����
//					&& ma_trends
//					&& sdd_b2.getKdj_k()<20
//					&& sdd_b2.getKdj_d()<20
//					&& sdd_b2.getEq_ratio()>1
				)
				{
					TransactionRecordData trd=new TransactionRecordData();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(sdd);
					
					// ��¼�����¼������������棬��̬��������׳��ղ���¼�׳�ʱ������ֵ
					for (int k=j+1; k<stockDataList.size()-3 && k<j+120; k++)
					{
						
						StockDayData sdd_a1=(StockDayData)stockDataList.get(k);
						StockDayData sdd_a2=(StockDayData)stockDataList.get(k+1);
						double profit=((sdd_a1.getClose()-sdd.getOpen())/sdd.getOpen())*100-0.2;  // ��ȥ������0.16�Ϳ��̼���
						double profit_high=((sdd_a1.getHigh()-sdd.getOpen())/sdd.getOpen())*100-0.2; 
						double profit_low=((sdd_a1.getLow()-sdd.getOpen())/sdd.getOpen())*100-0.2; 
						
						if (profit_low<-5)
						{
							// �����̳����ܿ������-10%��ֹ��
//							if (sdd_a1.getClose_rise()>-9.9)
//							{
//								sdd_a1.setProfit(profit);
//								trd.setSaleSDD(sdd_a1);
//								transactionDataList.add(trd);
//								break;
//							}
//							else if (sdd_a2.getOpen_rise()>-9)
//							{
//								profit=((sdd_a2.getOpen()-sdd.getOpen())/sdd.getOpen())*100-0.2;
//								sdd_a2.setProfit(profit);
//								trd.setSaleSDD(sdd_a2);
//								transactionDataList.add(trd);
//								break;
//							}
							
							// �����̳���-5%���Ͽ�����ֹ��							
							sdd_a1.setProfit(-5);
							trd.setSaleSDD(sdd_a1);
							transactionDataList.add(trd);
							break;
							
						}
						else 
						{
							// ������ddz���������������׳�
//							if(sdd_a1.getMa_ddz()>0 && sdd_a2.getMa_ddz()>0
//							&& sdd_a1.getMa_ddz()>sdd_a2.getMa_ddz())
//							{
//								profit=((sdd_a2.getClose()-sdd.getOpen())/sdd.getOpen())*100-0.2;
//								sdd_a2.setProfit(profit);
//								trd.setSaleSDD(sdd_a2);
//								transactionDataList.add(trd);
//								break;
//							}
							
							// �����г���5%����ӯ������ֹӯ		
							if (profit_high>5)
							{
								sdd_a1.setProfit(5);
								trd.setSaleSDD(sdd_a1);
								transactionDataList.add(trd);
								break;
							}
							
						}
						
					}
				}
			
			
			}
			
		}
		
		outputTransactionRecordReport(transactionDataList, "MACD_DDZѡ��");	
		
	}
	
	
	//	MACD ��͵�ģ��
	public void processStockByModel_macd_zdd(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			for (int j=10; j<stockDataList.size()-1; j++)
			{

				StockDayData sdd=(StockDayData)stockDataList.get(j);   // ��������
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);


				double sdd_total_value=CommonTool.getDoubleNumberWithTwoBit(sdd.getTotal_value()/100000000);
				double current_liquid_value=CommonTool.getStockCurrentLiquidValue(stockDataList);
				
				
				boolean ma_trends=false;
				
				// ��׽��macd�任��ʱ��
				if (sdd_b1.getMa_ddz()>0
				&& sdd_b2.getMa_ddz()<0)
				{
					ma_trends=true;
				}
				
				double ddz_ratio=checkPastDaysDDZ(stockDataList, sdd_b2, 20);
//				double stock_rate=checkStockPastRate(stockDataList);
				double lowestPrice=getPastDaysLowestPrice(sdd, stockDataList, sdd.getPosNum(), 20);
				
				if (
					ma_trends==true
					&& ddz_ratio>8			// ddz�����������С��ֵ>8
					
				)
				{
					TransactionRecordData trd=new TransactionRecordData();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(sdd);
					
					// ��¼�����¼������������棬��̬��������׳��ղ���¼�׳�ʱ������ֵ
					for (int k=j+1; k<stockDataList.size()-3 && k<j+120; k++)
					{
						
						StockDayData sdd_a1=(StockDayData)stockDataList.get(k);
						StockDayData sdd_a2=(StockDayData)stockDataList.get(k+1);
						double profit=((sdd_a1.getClose()-sdd.getOpen())/sdd.getOpen())*100-0.2;  // ��ȥ������0.16�Ϳ��̼���
						double profit_high=((sdd_a1.getHigh()-sdd.getOpen())/sdd.getOpen())*100-0.2; 
						double profit_low=((sdd_a1.getLow()-sdd.getOpen())/sdd.getOpen())*100-0.2; 
						
						if (profit_low<-5)
						{
							// �����̳����ܿ������-10%��ֹ��
//							if (sdd_a1.getClose_rise()>-9.9)
//							{
//								sdd_a1.setProfit(profit);
//								trd.setSaleSDD(sdd_a1);
//								transactionDataList.add(trd);
//								break;
//							}
//							else if (sdd_a2.getOpen_rise()>-9)
//							{
//								profit=((sdd_a2.getOpen()-sdd.getOpen())/sdd.getOpen())*100-0.2;
//								sdd_a2.setProfit(profit);
//								trd.setSaleSDD(sdd_a2);
//								transactionDataList.add(trd);
//								break;
//							}
							
							// �����̳���-5%���Ͽ�����ֹ��							
							sdd_a1.setProfit(-5);
							trd.setSaleSDD(sdd_a1);
							transactionDataList.add(trd);
							break;
							
						}
						else 
						{
							// ������ddz���������������׳�
//							if(sdd_a1.getMa_ddz()>0 && sdd_a2.getMa_ddz()>0
//							&& sdd_a1.getMa_ddz()>sdd_a2.getMa_ddz())
//							{
//								profit=((sdd_a2.getClose()-sdd.getOpen())/sdd.getOpen())*100-0.2;
//								sdd_a2.setProfit(profit);
//								trd.setSaleSDD(sdd_a2);
//								transactionDataList.add(trd);
//								break;
//							}
							
							// �����г���5%����ӯ������ֹӯ		
							if (profit_high>5)
							{
								sdd_a1.setProfit(5);
								trd.setSaleSDD(sdd_a1);
								transactionDataList.add(trd);
								break;
							}
							
						}
						
					}
				}
			
			
			}
			
		}
		
		outputTransactionRecordReport(transactionDataList, "MACD_ZDDѡ��");	
		
	}	
	
	
	//	MACD �ױ���ģ��
	public void processStockByModel_macd_dbl(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++) 
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			for (int j=10; j<stockDataList.size()-1; j++)
			{

				StockDayData sdd=(StockDayData)stockDataList.get(j);   // ��������
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);

				double sdd_total_value=CommonTool.getDoubleNumberWithTwoBit(sdd.getTotal_value()/100000000);
				double current_liquid_value=CommonTool.getStockCurrentLiquidValue(stockDataList);
				
				boolean ma_trends=false;
				double buy_price=0;
				
				// ��׽��macd�ױ���任��ʱ��
				if (sdd_b1.getMa_ddz()<0
				&& sdd_b2.getMa_ddz()<0
				&& sdd_b1.getMa_ddz()>sdd_b2.getMa_ddz()
//				&& sdd_b1.getMa_ddz()/sdd_b2.getMa_ddz()<0.8
//				&& sdd.getLow()<sdd_b1.getMa_5()*0.97
//				&& sdd.getLow()<sdd_b1.getMa_10()
//				&& sdd.getLow()<sdd_b1.getMa_20()
//				&& sdd.getLow()<sdd_b1.getMa_60()
//				&& sdd_total_value>100
				)
				{
					ma_trends=true;
					buy_price=sdd.getOpen();
				}
				
				double ddz_ratio=checkPastDaysDDZ(stockDataList, sdd_b2, 5);
//				double stock_rate=checkStockPastRate(stockDataList);
//				double lowestPrice=getPastDaysLowestPrice(sdd, stockDataList, sdd.getPosNum(), 20);
				
				if (
					ma_trends==true
					&& ddz_ratio>1			// ddz �������������С��ֵ>6
					
				)
				{
					TransactionRecordData trd=new TransactionRecordData();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(sdd);
					
					// ��¼�����¼������������棬��������׳��ղ���¼�׳�ʱ������ֵ
					for (int k=j+1; k<j+2; k++)
					{
						
						StockDayData sdd_a1=(StockDayData)stockDataList.get(k);
						double profit=((sdd_a1.getClose()-buy_price)/buy_price)*100-0.2;  // ��ȥ������0.16�Ϳ��̼���
						double profit_open=((sdd_a1.getOpen()-buy_price)/buy_price)*100-0.2;  // ��ȥ������0.16�Ϳ��̼���
						double profit_high=((sdd_a1.getHigh()-buy_price)/buy_price)*100-0.2; 
						double profit_low=((sdd_a1.getLow()-buy_price)/buy_price)*100-0.2; 
						
//						if (profit_low<-4)
//						{							
//							// �����̳���-4%���Ͽ�����ֹ��							
//							sdd_a1.setProfit(-4);
//							trd.setSaleSDD(sdd_a1);
//							transactionDataList.add(trd);
//							break;
//						}
//						else 
						{
							
							// �����г���2%����ӯ������ֹӯ		
							if (profit_open>2)
							{
								sdd_a1.setProfit(profit_open);  
								trd.setSaleSDD(sdd_a1);
								transactionDataList.add(trd);
							}
							else if (profit_high>1.2)
							{
								sdd_a1.setProfit(1.2-0.2);  // ��ȥ������0.16�Ϳ��̼���
								trd.setSaleSDD(sdd_a1);
								transactionDataList.add(trd);
							}
							else
							{
								sdd_a1.setProfit(profit);
								trd.setSaleSDD(sdd_a1);
								transactionDataList.add(trd);
								
							}
							
						}
						
					}
				}
			
			
			}
			
		}
		
		outputTransactionRecordReport(transactionDataList, "MACD_DBLѡ��");	
		
	}		
	
	
	//	MACD TREND����ģ��
	public void processStockByModel_macd_trend(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++) 
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			for (int j=10; j<stockDataList.size()-1; j++)
			{

				StockDayData sdd=(StockDayData)stockDataList.get(j);   // ��������
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);  // ǰһ������
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);  // ǰ�������� 

				double sdd_total_value=CommonTool.getDoubleNumberWithTwoBit(sdd.getTotal_value()/100000000);
				double current_liquid_value=CommonTool.getStockCurrentLiquidValue(stockDataList);
				
				boolean ma_trends=false;
				double buy_price=0;
				double macd_change=0;
				if (sdd_b1.getMa_macd()!=0)
				{
				   macd_change=Math.abs((sdd.getMa_macd()-sdd_b1.getMa_macd())/sdd_b1.getMa_macd());
				}
				
				// ��׽��macd���Ƶ�
				if (1>0 ||
				sdd.getMa_macd()-sdd_b1.getMa_macd()>0
//				&& macd_change>0.2    // �������ƽ�Ϊ����
//				&& Math.abs(sdd.getMa_macd())>200
//				&& sdd.getLow()<sdd_b1.getMa_5()*0.97
//				&& sdd.getLow()<sdd_b1.getMa_10()
//				&& sdd.getLow()<sdd_b1.getMa_20()
//				&& sdd.getLow()<sdd_b1.getMa_60()
//				&& sdd_total_value>100
				)
				{
					ma_trends=true;
					buy_price=sdd.getClose();
				}
				
				double ddz_ratio=checkPastDaysDDZ(stockDataList, sdd_b1, 5);
//				double stock_rate=checkStockPastRate(stockDataList);
//				double lowestPrice=getPastDaysLowestPrice(sdd, stockDataList, sdd.getPosNum(), 20);
				
				if (
					ma_trends==true
//					&& ddz_ratio>1			// ddz �������������С��ֵ>6
				)
				{
					TransactionRecordData trd=new TransactionRecordData();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(sdd);
					
					// ��¼�����¼������������棬��������׳��ղ���¼�׳�ʱ������ֵ
					for (int k=j+1; k<j+2; k++)
					{
						
						StockDayData sdd_a1=(StockDayData)stockDataList.get(k);					
						double profit_open=((sdd_a1.getOpen()-buy_price)/buy_price)*100-0.2;  // ��ȥ������0.16�Ϳ��̼���
						double profit_high=((sdd_a1.getHigh()-buy_price)/buy_price)*100-0.2; 
						double profit_low=((sdd_a1.getLow()-buy_price)/buy_price)*100-0.2; 
						double profit_close=((sdd_a1.getClose()-buy_price)/buy_price)*100-0.2;  // ��ȥ������0.16�Ϳ��̼���
						
//						if (profit_low<-4)
//						{							
//							// �����̳���-4%���Ͽ�����ֹ��							
//							sdd_a1.setProfit(-4);
//							trd.setSaleSDD(sdd_a1);
//							transactionDataList.add(trd);
//							break;
//						}
//						else 
						{
							
							// ���ڶ���������յͿ��������׳�	
							if (sdd_a1.getOpen()<sdd.getLow())
							{
								sdd_a1.setProfit(profit_open);  
								trd.setSaleSDD(sdd_a1);
								transactionDataList.add(trd);
							}
							// ���ڶ���û�г������յͿ�������β�׳�
							else
							{
								sdd_a1.setProfit(profit_close);
								trd.setSaleSDD(sdd_a1);
								transactionDataList.add(trd);
							}
							
						}
						
					}
				}
			
			
			}
			
		}
		
		outputTransactionRecordReport(transactionDataList, "MACD_trendѡ��");	
		
	}	
	
	
	//	ģ��ģ��
	public void processStockByModel_beststock(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			if (stockDataList.size()<=0)
				continue;
			
			System.out.println("Process stock: "+stockcode);
			
			// ÿ�������
			StockDayData sdd_start=(StockDayData)stockDataList.get(0); 
			StockDayData sdd_end=(StockDayData)stockDataList.get(stockDataList.size()-1); 

			double profit=0;
			if (sdd_start.getOpen()!=0)
			{
				profit=((sdd_end.getClose()-sdd_start.getOpen())/sdd_start.getOpen())*100-0.2;  // ��ȥ������0.16�Ϳ��̼���
			}
			
//			double maxDDR=CommonTool.calculateMaxDrawDownBySDD(stockDataList).getDDR();
//			double maxRUR=CommonTool.calculateMaxRiseUpBySDD(stockDataList).getRUR();
			
			// columnName, columnType, columnValue 
			sdd_end.setProfit(profit);
			
			TransactionRecordData trd=new TransactionRecordData();
			trd.setStockcode(stockcode);
			trd.setBuySDD(sdd_start);
			trd.setSaleSDD(sdd_end);
			
			transactionDataList.add(trd);
			
		}
		
		outputTransactionRecordReport_beststock(transactionDataList, "��ѹ�Ʊ");	
		
	}
	
	
	//	ģ��ģ��  MACD_��ͣ��߿�
	public void processStockByModel_macd_zth(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			int days=10; // ǰ�ڿ�������
			
			for (int j=days; j<stockDataList.size()-1; j++)  
			{
				
				// ÿ�������
				StockDayData sdd_c=(StockDayData)stockDataList.get(j);  // ������Ϊj
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				StockDayData sdd_b4=(StockDayData)stockDataList.get(j-4);
				StockDayData sdd_b5=(StockDayData)stockDataList.get(j-5);
				StockDayData sdd_b6=(StockDayData)stockDataList.get(j-6);
			
				double total_rise_b=sdd_b1.getClose_rise()+sdd_b2.getClose_rise()+sdd_b3.getClose_rise()+sdd_b4.getClose_rise()+sdd_b5.getClose_rise();
				double sdd_total_value=CommonTool.getDoubleNumberWithTwoBit(sdd_c.getLiquid_value()/100000000);
				double current_total_value=CommonTool.getStockCurrentLiquidValue(stockDataList);
				
				if (1>0 
					&& sdd_b1.getClose_rise()>9.9
					&& sdd_b1.getClose_rise()-sdd_b1.getOpen_rise()>0   // b1Ϊ������ͣ�� 
					&& sdd_b1.getMa_ddz()>0
					&& sdd_c.getOpen_rise()<1
					&& sdd_c.getOpen_rise()>-9
					)
				{
					
						String stockType=CommonTool.getStockMarketType(sdd_c.getCode());
						List indexDataList=(List)stockIndexMap.get(stockType);
						StockDayData idd_b1=CommonTool.getStockDayData(indexDataList, sdd_b1.getDate());
						StockDayData idd_b2=CommonTool.getStockDayData(indexDataList, sdd_b2.getDate());
					
						if (idd_b1!=null
							&& idd_b1.getMa_ddz()>3
//							&& idd_b2!=null
//							&& idd_b2.getMa_ddz()<idd_b1.getMa_ddz()
//							&& minDDZ<-25
							)
						{
							// �������׼�¼����
							TransactionRecordData trd=new TransactionRecordData();
							
							// ��¼������sdd��Ϣ
							trd.setStockcode(stockcode);
							trd.setBuySDD(sdd_c);
							
							// �жϲ�����������sdd��Ϣ
							StockDayData sdd_a1;
							if (j+1<stockDataList.size()) // �����һ�쳬�����������һ��Ϊsdd_a1
							{
								sdd_a1=(StockDayData)stockDataList.get(j+1);
							}
							else
							{
								sdd_a1=(StockDayData)stockDataList.get(j);
							}
			
//							// �����ڶ��쿪�̾��� --- ����֤�����ֿ����׵ķ�ʽ����ܴ�Զ����������
//							double profit=0;
//							if (sdd_c.getOpen()!=0)
//							{
//								profit=((sdd_a1.getOpen()-sdd_c.getOpen())/sdd_c.getOpen())*100-0.2;  // ��ȥ������0.16�Ϳ��̼���
//							}		
//							sdd_a1.setProfit(profit);
							
							trd.setSaleSDD(sdd_a1);
								
							transactionDataList.add(trd);
								
						}
						
						
					}					
					
					
				}
				
			}
			
		
		
		outputTransactionRecordReport(transactionDataList, "MACD_��ͣ��");	
		
	}
	
	
	// macd �Ľ�ѡ��ģ��
	public List processStockByModel_macdgj(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻETF���Ʊ����ʷ��������
			String researchcode=((String)researchStockCodeList.get(i));
			List stockDataList;
			if (researchcode.startsWith("index"))
			{
				String stockfilename=researchcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
				System.out.println("Process stock: "+researchcode);
			}
			else
			{
				String stockcode=researchcode.substring(2); // ȥ��ǰ׺ sh, sz
				String stockfilename="stock"+stockcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
				System.out.println("Process stock: "+stockcode);
			}
			
			
			// ���磺0-59(����ǰ60��), 60-64(��ǰ5��), 65(������)
			int obv_days=6; // �۲���
			int rise_days=0;  // ������
			int pre_days=obv_days+rise_days;  // ����ǰ�ܹ�ʱ��
			int pastHighPriceDays_distance=0;   // ��ȥͬ��λ����ʱ��ľ���
//			int hold_days=2500;  // ����ʱ��
			int hold_days=2500;  // ����ʱ��
			
			boolean checkAssetsBack=true;
//			boolean checkAssetsBack=false;			
			String assetsBackDate="";   // �ʲ��������ڣ���Ϊ�������������µ����ʽ���ã���Ҫ��һ����������ʶ�ʲ�����������
			
			for (int j=pre_days; j<stockDataList.size(); j++)
			{	
				
				// ��ͷ����������ÿ�������
				StockDayData sdd=(StockDayData)stockDataList.get(j);  // ������Ϊj
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				StockDayData sdd_b4=(StockDayData)stockDataList.get(j-4);
				StockDayData sdd_b5=(StockDayData)stockDataList.get(j-5);
				StockDayData sdd_b6=(StockDayData)stockDataList.get(j-6);
				
				if (sdd.getDate().compareTo(assetsBackDate)<=0 && checkAssetsBack)   // ��鵱ǰ�ʲ��Ƿ���ã������û�л������ܽ���
					continue;
				
				// ��ͷ�������������Ƿ�
				double total_rise_b=sdd_b1.getClose_rise()+sdd_b2.getClose_rise()+sdd_b3.getClose_rise()+sdd_b4.getClose_rise()+sdd_b5.getClose_rise();
				double sdd_total_value=CommonTool.getDoubleNumberWithTwoBit(sdd.getLiquid_value()/100000000);
				double current_total_value=CommonTool.getStockCurrentLiquidValue(stockDataList);
				
				if (1>0 
				 && sdd_b1.getMa_macd()>0
				 && sdd_b2.getMa_macd()<0
//				 && sdd_b1.getClose()>sdd_b1.getMa_60()
//				 && sdd_b3.getMa_macd()<0
//				 && checkDayData_MA(sdd_b1) 
//				 && checkDayData_MA(sdd_b2) 
//				 && checkDayData_MA(sdd_b3) 
//				 && checkDayData_MA(sdd_b4) 
//				 && checkDayData_MA(sdd_b5) 
//				 && !checkDayData_MA(sdd_b6)
//				 && getPastHighPriceDaysDistance(sdd_b1, stockDataList)>pastHighPriceDays_distance
//				 && checkPastDaysHighPrice(sdd_b1, stockDataList, j, obv_days) // ����Ƿ�ͻ����ǰn���λ
//				 && current_total_value>1000
//				 && sdd_b6.getLow()<sdd_b6.getMa_5()    // b6����ǰ�۸������վ�����
//				 && total_rise_b>15 && total_rise_b<30  // b1-b5���Ƿ�����15%,С��30%
//				 && sdd_b1.getClose_rise()>-2 && sdd_b1.getClose_rise()-sdd_b1.getOpen_rise()>-2   // b1Ϊ���� 
//				 && sdd_b2.getClose_rise()>-2 && sdd_b2.getClose_rise()-sdd_b2.getOpen_rise()>-2   // b2Ϊ���� 
//				 && sdd_b3.getClose_rise()>-2 && sdd_b3.getClose_rise()-sdd_b3.getOpen_rise()>-2   // b3Ϊ���� 
//				 && sdd_b4.getClose_rise()>-2 && sdd_b4.getClose_rise()-sdd_b4.getOpen_rise()>-2   // b4Ϊ���� 
//				 && sdd_b5.getClose_rise()>-2 && sdd_b5.getClose_rise()-sdd_b5.getOpen_rise()>-2   // b5Ϊ���� 
	//			 && sdd_b1.getMa_5()-sdd_b1.getMa_20()>sdd_b5.getMa_5()-sdd_b5.getMa_20()  // b1��5,20�߾����b5��5,20�߾�,�ʷ�ɢ
	//			 && (sdd_b1.getMa_5()-sdd_b1.getMa_60())/sdd_b1.getMa_5()<0.3  // b1��5�վ��߻�û��Զ��60�վ��ߣ�����������
				)
				{
					
						double buy_price=sdd.getOpen();  // �ڶ��쿪�̾������ۼ۸�ߵ�
						
						TransactionRecordData trd=new TransactionRecordData();
						trd.setModelType("macdgj");
						trd.setModelParam("");
						trd.setStockPrt(calculateStockPrt_dtplgj(sdd_b1));
						
						trd.setStockcode(sdd.getCode());
						trd.setBuySDD(sdd);
						trd.setTransactionBuyPrice(buy_price);
						
						int hold_endday_pos=j+hold_days;
						if (hold_endday_pos>stockDataList.size()-1)
						{
							hold_endday_pos=stockDataList.size()-1;
						}
							
						if (j==stockDataList.size()-1)
						{
							double sale_price=sdd.getClose();
							trd.setSaleSDD(sdd);   // Ĭ���Ȱѹ�������Ϊ������sdd���Ա���Ϊ��
							trd.setTransactionSalePrice(sale_price);  // �����յ����̼۸�Ĭ����Ϊ�����۸�price
						}
						
						for (int s=j+1; s<=hold_endday_pos; s++)	// �鿴����n���ڵĽ��׾�����������s
						{
							
							StockDayData sdd_s=(StockDayData)stockDataList.get(s);
//								if (sdd_s.getHigh()>sale_price)  // ���ĳһ�����м۸��ϳ嵽Ԥ���������۸�������ֹӯ
//								{
//										double profit=(sdd_s.getClose()-buy_price)/buy_price*100;
//										sdd_s.setProfit(profit);
//										trd.setSaleSDD(sdd_s);
//										trd.setTransactionProfit(profit);
//										break;
//								}
							
							MarketRDDayData mdd=(MarketRDDayData)marketDataRecordMap.get(sdd_s.getDate());
							
							if (mdd!=null && mdd.getDown10()>500) // ���ĳһ����̳��ִ������ͣ��������ʱ����ֹ��
							{
//									System.out.println(mdd.getDate()+" Down10: "+mdd.getDown10());
//									double profit=(sdd_s.getClose()-buy_price)/buy_price*100-0.2;
//									sdd_s.setProfit(profit);
//									trd.setSaleSDD(sdd_s);
//									trd.setTransactionProfit(profit);
//									break;
							}
							else if (sdd_s.getMa_macd()<0)    
							{
									double profit=(sdd_s.getClose()-buy_price)/buy_price*100-0.2; 
									sdd_s.setProfit(profit);
									trd.setSaleSDD(sdd_s);
									trd.setTransactionProfit(profit);
									trd.setTransactionSalePrice(sdd_s.getClose());
									break;
								
							}
							else   // �������û�з������գ����¼�������ʱ������
							{
									double profit=(sdd_s.getClose()-buy_price)/buy_price*100-0.2; 
									sdd_s.setProfit(profit);
									trd.setSaleSDD(sdd_s);
									trd.setTransactionProfit(profit);
									trd.setTransactionSalePrice(sdd_s.getClose());
							}
							
						}
							
							
						transactionDataList.add(trd);
						if (trd.getSaleSDD()!=null)
							assetsBackDate=trd.getSaleSDD().getDate();
						
							
					}
						
				}		
					
			
		} // end for 
		
		
		outputTransactionRecordReport(transactionDataList, "macd�Ľ�");
		
		return transactionDataList;
		
	}
	
	
	
	//	��ˮܽ��
	public void processStockByModel_csfr(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			int days=30; // ǰ�ڿ�������
			
			for (int j=days; j<stockDataList.size()-1; j++)  
			{
				
				StockDayData sdd=(StockDayData)stockDataList.get(j);
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);


				double sdd_total_value=CommonTool.getDoubleNumberWithTwoBit(sdd.getTotal_value()/100000000);
				double current_liquid_value=CommonTool.getStockCurrentLiquidValue(stockDataList);
				
				
				boolean ma_trends=false;
				
				if (sdd_b1.getMa_5()>sdd_b1.getMa_10() 
				&& sdd_b1.getMa_10()>sdd_b1.getMa_20()
				&& sdd_b1.getMa_20()>sdd_b1.getMa_60())
				{
					ma_trends=true;
				}
				
				double ddz_ratio=checkPastDaysDDZ(stockDataList, sdd_b2, 7);
//				double stock_rate=checkStockPastRate(stockDataList);
				
				if (
					1>0
//					&& ddz_ratio>0			// ddz�����������С��ֵ>8
//				    && sdd_b2.getMa_ddz()<-100   // ddzֵ<-100 --- ���Ҳ��һ����Ҫ�����������ò��������Է���
//					&& sdd_b2.getMa_ddz()>-900   // ddzֵ>-900 
//					&& sdd_b1.getMa_ddz()>sdd_b2.getMa_ddz() // b1��ddzֵ��b2��ddzֵ����� --- �������Ҫ��ת���������������ֺܶ��ظ����
//					&& sdd_b1.getReal_rise()<4    // b1�Ƿ�����̫��ҪС��3%  
//					&& sdd.getOpen_rise()>-9      // �����ղ����ǵ�ͣ����   
//					&& sdd_total_value>500      // ��λ����
//					&& ma_trends
//					&& sdd_b2.getKdj_k()<20
//					&& sdd_b2.getKdj_d()<20
//					&& sdd_b2.getEq_ratio()>1
				)
				{
					TransactionRecordData trd=new TransactionRecordData();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(sdd);
					
					// ��¼�����¼������������棬��̬��������׳��ղ���¼�׳�ʱ������ֵ
					for (int k=j+1; k<stockDataList.size()-3 && k<j+120; k++)
					{
						
						StockDayData sdd_a1=(StockDayData)stockDataList.get(k);
						StockDayData sdd_a2=(StockDayData)stockDataList.get(k+1);
						double profit=((sdd_a1.getClose()-sdd.getOpen())/sdd.getOpen())*100-0.2;  // ��ȥ������0.16�Ϳ��̼���
						double profit_high=((sdd_a1.getHigh()-sdd.getOpen())/sdd.getOpen())*100-0.2; 
						double profit_low=((sdd_a1.getLow()-sdd.getOpen())/sdd.getOpen())*100-0.2; 
						
						if (profit_low<-5)
						{
							// �����̳����ܿ������-10%��ֹ��
//							if (sdd_a1.getClose_rise()>-9.9)
//							{
//								sdd_a1.setProfit(profit);
//								trd.setSaleSDD(sdd_a1);
//								transactionDataList.add(trd);
//								break;
//							}
//							else if (sdd_a2.getOpen_rise()>-9)
//							{
//								profit=((sdd_a2.getOpen()-sdd.getOpen())/sdd.getOpen())*100-0.2;
//								sdd_a2.setProfit(profit);
//								trd.setSaleSDD(sdd_a2);
//								transactionDataList.add(trd);
//								break;
//							}
							
							// �����̳���-5%���Ͽ�����ֹ��							
							sdd_a1.setProfit(-5);
							trd.setSaleSDD(sdd_a1);
							transactionDataList.add(trd);
							break;
							
						}
						else 
						{
							// ������ddz���������������׳�
//							if(sdd_a1.getMa_ddz()>0 && sdd_a2.getMa_ddz()>0
//							&& sdd_a1.getMa_ddz()>sdd_a2.getMa_ddz())
//							{
//								profit=((sdd_a2.getClose()-sdd.getOpen())/sdd.getOpen())*100-0.2;
//								sdd_a2.setProfit(profit);
//								trd.setSaleSDD(sdd_a2);
//								transactionDataList.add(trd);
//								break;
//							}
							
							// �����г���5%����ӯ������ֹӯ		
							if (profit_high>5)
							{
								sdd_a1.setProfit(5);
								trd.setSaleSDD(sdd_a1);
								transactionDataList.add(trd);
								break;
							}
							
						}
						
					}
					
				}
				
			}
			
		}
		
		outputTransactionRecordReport(transactionDataList, "��ˮܽ��");	
		
	}
	
	//	ģ��ģ��
	public void processStockByModel(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ��������
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // ȥ��ǰ׺ sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			int days=30; // ǰ�ڿ�������
			
			for (int j=days; j<stockDataList.size()-1; j++)  
			{
				
				// ÿ�������
				StockDayData sdd=(StockDayData)stockDataList.get(j); 
				

				
			}
			
		}
		
		outputTransactionRecordReport(transactionDataList, "");	
		
	}
	
	public String getColumnDef_preDayData(int dayNo)
	{
		String columnDef=
		" date_b"+dayNo+" varchar(20), " +
		" open_rise_b"+dayNo+" double precision format 12.2, " +
		" high_rise_b"+dayNo+" double precision format 12.2, " +
		" low_rise_b"+dayNo+" double precision format 12.2, " +
		" final_rise_b"+dayNo+" double precision format 12.2, " +
		" real_rise_b"+dayNo+" double precision format 12.2, " +
		" swing_b"+dayNo+" double precision format 12.2, " +
		" exchange_ratio_b"+dayNo+" double precision format 12.2, " +
		" index_macd_b"+dayNo+" double precision format 12.2, " +	// yg ���ڴ���macdָ��
		" index_ddz_b"+dayNo+" double precision format 12.2, " +	// yg ���ڴ���ddzָ��
		" index_yg_b"+dayNo+" double precision format 12.2 ";    // yg �����ygָ��
		
		return columnDef;
		
	}
	
	public String getDataDef_preDayData(TransactionRecordData trd, int days)
	{
		
		List preStockDayDataList=trd.getPreStockDayDataList();	
		List preIndexDayDataList=trd.getPreIndexDayDataList();
		
		String dataDef="";
		if (preStockDayDataList.get(days-1)!=null && preIndexDayDataList.get(days-1)!=null)    // ��ű����1
		{
			StockDayData sdd=(StockDayData)preStockDayDataList.get(days-1);
			StockDayData idd=(StockDayData)preIndexDayDataList.get(days-1);
			
			dataDef="'"+sdd.getDate().trim()+"',"+
					CommonTool.getDoubleNumberWithTwoBit(sdd.getOpen_rise())+","+
					CommonTool.getDoubleNumberWithTwoBit(sdd.getHigh_rise())+","+
					CommonTool.getDoubleNumberWithTwoBit(sdd.getLow_rise())+","+
					CommonTool.getDoubleNumberWithTwoBit(sdd.getClose_rise())+","+
					CommonTool.getDoubleNumberWithTwoBit(sdd.getReal_rise())+","+
					CommonTool.getDoubleNumberWithTwoBit(sdd.getSwing()*100)+","+
					CommonTool.getDoubleNumberWithTwoBit(sdd.getChange_ratio())+","+
					CommonTool.getDoubleNumberWithTwoBit(idd.getMa_macd())+","+
					CommonTool.getDoubleNumberWithTwoBit(idd.getMa_ddz())+","+
					CommonTool.getDoubleNumberWithTwoBit(idd.getMa_ddz());  // ��������ygָ��
		}
		else
		{
			dataDef="'',0,0,0,0,0,0,0,0,0,0";
		}
		
		return dataDef;
		
	}
	
	
	public String getColumnDef_currentDayData()
	{
		String columnDef=
		" open_rise_c double precision format 12.2, " +
		" high_rise_c double precision format 12.2, " +
		" low_rise_c double precision format 12.2, " +
		" final_rise_c double precision format 12.2, " +
		" real_rise_c double precision format 12.2, " +
		" swing_c double precision format 12.2, " +
		" exchange_ratio_c double precision format 12.2 " ;
//		" index_macd_c double precision format 12.2, " +	// yg ���ڴ���macdָ��
//		" index_ddz_c double precision format 12.2, " +	// yg ���ڴ���ddzָ��
//		" index_yg_c double precision format 12.2 ";    // yg �����ygָ��
		
		return columnDef;
		
	}
	
	
	public String getDataDef_currentDayData(TransactionRecordData trd)
	{
		
			String dataDef="";
			
			if (trd.getBuySDD()!=null)    // ��ű����1
			{
				
				StockDayData sdd=(StockDayData)trd.getBuySDD();
//				StockDayData idd=(StockDayData)preIndexDayDataList.get(days-1);
			
				dataDef=
					CommonTool.getDoubleNumberWithTwoBit(sdd.getOpen_rise())+","+
					CommonTool.getDoubleNumberWithTwoBit(sdd.getHigh_rise())+","+
					CommonTool.getDoubleNumberWithTwoBit(sdd.getLow_rise())+","+
					CommonTool.getDoubleNumberWithTwoBit(sdd.getClose_rise())+","+
					CommonTool.getDoubleNumberWithTwoBit(sdd.getReal_rise())+","+
					CommonTool.getDoubleNumberWithTwoBit(sdd.getSwing()*100)+","+
					CommonTool.getDoubleNumberWithTwoBit(sdd.getChange_ratio());
//					CommonTool.getDoubleNumberWithTwoBit(idd.getMa_macd())+","+
//					CommonTool.getDoubleNumberWithTwoBit(idd.getMa_ddz())+","+
//					CommonTool.getDoubleNumberWithTwoBit(idd.getMa_ddz());  // ��������ygָ��
			}
			else
			{
				dataDef="'',0,0,0,0,0,0,0";
				
			}
		
		return dataDef;
		
	}
	
	
	public String getMacdChangeData(TransactionRecordData trd, int days)
	{
		
		List preIndexDayDataList=trd.getPreIndexDayDataList();
		
		String dataDef="";
		for (int i=days-1; i>=0; i--)
		{
			if (preIndexDayDataList.get(i)!=null)    
			{
				StockDayData idd=(StockDayData)preIndexDayDataList.get(i);
				dataDef=dataDef+"*"+CommonTool.getDoubleNumberWithTwoBit(idd.getMa_macd());
			}
			else
			{
				dataDef=dataDef+"*0";
			}
		}
		
		dataDef=dataDef.substring(1);   // ȥ����һ��"-"��
		
		return dataDef;
		
	}
	
	public String getDDZChangeData(TransactionRecordData trd, int days)
	{
		
		List preIndexDayDataList=trd.getPreIndexDayDataList();
		
		String dataDef="";
		for (int i=days-1; i>=0; i--)
		{
			if (preIndexDayDataList.get(i)!=null)    
			{
				StockDayData idd=(StockDayData)preIndexDayDataList.get(i);
				dataDef=dataDef+"*"+CommonTool.getDoubleNumberWithTwoBit(idd.getMa_ddz());
			}
			else
			{
				dataDef=dataDef+"*0";
			}
		}
		
		dataDef=dataDef.substring(1);   // ȥ����һ��"-"��
		
		return dataDef;
		
	}
	
	public String getYGChangeData(TransactionRecordData trd, int days)
	{
		
		List preIndexDayDataList=trd.getPreIndexDayDataList();
		
		String dataDef="";
		for (int i=days-1; i>0; i--)
		{
			if (preIndexDayDataList.get(i)!=null)   
			{
				StockDayData idd=(StockDayData)preIndexDayDataList.get(i);
				dataDef=dataDef+"*"+CommonTool.getDoubleNumberWithTwoBit(idd.getMa_ddz());
			}
			else
			{
				dataDef=dataDef+"*0";
			}
		}
		
		dataDef=dataDef.substring(1);   // ȥ����һ��"-"��
		
		return dataDef;
		
	}
	
	public Map getStockMapByIndustry(List researchStockCodeList, String startDate, String endDate)
	{
			
			Map stockMapByIndustry=new TreeMap();	

			// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
			for (int i=0; i<researchStockCodeList.size(); i++)  
			{
				
				// ���һֻETF���Ʊ����ʷ��������
				String researchcode=((String)researchStockCodeList.get(i));
				List stockDataList;
				if (researchcode.startsWith("index"))
				{
					String stockfilename=researchcode;
					String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
					stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
					System.out.println("Process stock: "+researchcode);
				}
				else
				{
					String stockcode=researchcode.substring(2); // ȥ��ǰ׺ sh, sz
					String stockfilename="stock"+stockcode;
					String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
					stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
					System.out.println("Process stock: "+stockcode);
					
					if (stockDataList!=null && stockDataList.size()>0)
					{
						StockDayData sdd=(StockDayData)stockDataList.get(0);
						String industry=sdd.getIndustry();
						
						if (industry!=null)
						{
						
							List stockIndustryOrderList;
							if (stockMapByIndustry.get(industry)!=null)
							{
								stockIndustryOrderList=(List)stockMapByIndustry.get(industry);
							}
							else
							{
								stockIndustryOrderList=new ArrayList();		
								stockMapByIndustry.put(industry, stockIndustryOrderList);
							}
							stockIndustryOrderList.add(sdd);
							
						}
						
					}
										
				}
			}
			
			
			return stockMapByIndustry;
		
	}
	
	public List getStockPoolCodeList(List researchStockCodeList)
	{
		
		List stockPoolCodeList=new ArrayList();
				
		Map stockMapByIndustry=getStockMapByIndustry(researchStockCodeList, "2019/12/31", "2019/12/31"); 
	
		Iterator it=stockMapByIndustry.keySet().iterator();
		while (it.hasNext())
		{
			String industry=(String)it.next();
			List stockListByIndustry=(List)stockMapByIndustry.get(industry);
			
			// ��ĳ��industry��stocklist����
			Collections.sort(stockListByIndustry, new Comparator <StockDayData>() {
			
				public int compare(StockDayData sdd1, StockDayData sdd2) 
				{
					double diff = sdd1.getLiquid_value()-sdd2.getLiquid_value();  // �Ƚ�������ֵ
					if (diff > 0) {
						return -1;
					}else if (diff < 0) {
						return 1;
					}
						return 0; //���Ϊ0
				}
			
			}); 
			
			for (int i=0; i<stockListByIndustry.size(); i++)
			{

				
				StockDayData sdd=(StockDayData)stockListByIndustry.get(i);
				
				stockPoolCodeList.add(sdd.getCode());
				
				double liquidValue=sdd.getLiquid_value()/100000000;
				
				System.out.println(sdd.getIndustry()+" "+sdd.getCode()+" "+sdd.getName()+" "+liquidValue+"��");

				if (liquidValue<1000 && i>=4) // ֻȡ����ǰ5��
				{
					System.out.println();
					break;
				}

			}
			
		}
		
		return stockPoolCodeList;
		
	}
	
	
	
	public Map getStockAllDataMap(List stockPoolCodeList)
	{
		
		Map stockDataMap=new TreeMap();  // (stockcode, sddList)  ÿֻ��Ʊ����ʷȫ�����ݣ��ɷ����ڴ�Ķ���	
		
		stockFileFolder=stockAllDataFull+"\\all\\"+dateType;  // ����research code����ѡ��ͬ������Ŀ¼, day/minute1/minute30/minute60
		
		
		// ȡ��ÿֻ��Ʊ����ʷ��¼���з���
		for (int i=0; i<stockPoolCodeList.size(); i++)  
		{
			
			// ���һֻ��Ʊ����ʷ�������� - �������ļ���
			String researchcode=((String)stockPoolCodeList.get(i));
			String stockfilename="";
			if (dateType.startsWith("minute"))
			{
				stockfilename="minute"+researchcode;
			}
			else if (dateType.startsWith("day"))
			{
				stockfilename="day"+researchcode;
			}
			else if (dateType.startsWith("index"))
			{
				stockfilename="index"+researchcode;
			}
			else if (dateType.startsWith("fund"))
			{
				stockfilename="fund"+researchcode;
			}
			
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename);
			stockDataMap.put(researchcode, stockDataList);
			
			System.out.println("Process stock: "+researchcode+" "+CommonTool.getStockNameByCode(researchcode)+" "+dateType);
			
/*			
			if (researchcode.startsWith("index"))
			{
				String stockcode=researchcode.substring(5); // ȥ��ǰ׺ index
				String stockfilename=researchcode;
		//		String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename);
				
				System.out.println("Process index: "+stockcode);
				stockDataMap.put(stockcode, stockDataList);
			}
			else if (researchcode.startsWith("minute"))
			{
				String stockcode=researchcode.substring(6); // ȥ��ǰ׺ minute
				String stockfilename=researchcode;
		//		String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename);
				
				System.out.println("Process minute: "+stockcode);
				stockDataMap.put(stockcode, stockDataList);
			}
			else if (researchcode.startsWith("day"))
			{
				String stockcode=researchcode.substring(3); // ȥ��ǰ׺ minute
				String stockfilename=researchcode;
		//		String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename);
				
				System.out.println("Process day: "+stockcode);
				stockDataMap.put(stockcode, stockDataList);
			}
			else 
			{
				String stockcode=researchcode.substring(2); // ȥ��ǰ׺ sh, sz
				String stockfilename="stock"+stockcode;
		//		String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql �����б�����˫���Ž�string����������
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename);
				
				System.out.println("Process stock: "+stockcode);
				stockDataMap.put(stockcode, stockDataList);
			}
	
			
			// ���һֻ��Ʊ����ʷ�������� - ���ڴ����
			
*/
			
			
		}
	
		return stockDataMap;
		
	}
	
	public List generateTransactionDataListFromPSA(PersonalStockAccount psa)
	{
		
		List transactionDataList=new ArrayList();
		
		Map accountMap=psa.getAccountDataMap();
		Iterator it=accountMap.keySet().iterator();
		while(it.hasNext())
		{
			String date=it.next().toString();
			AccountDayData accountDD=(AccountDayData)accountMap.get(date);
			List saleList=accountDD.getSaleTransList();
			transactionDataList.addAll(saleList);
		}
		
		for (int i=0; i<transactionDataList.size(); i++)
		{
			TransactionRecordData trd=(TransactionRecordData)transactionDataList.get(i);
		}
		
		return transactionDataList;
		
	}
	
	
	public void outputAccountRecordReport(PersonalStockAccount psa)
	{
		
		Map accountMap=psa.getAccountDataMap();
		Iterator it=accountMap.keySet().iterator();
		while(it.hasNext())
		{
			String date=it.next().toString();
			AccountDayData accountDD=(AccountDayData)accountMap.get(date);
			
			List stockHoldList=accountDD.getStockHoldList();
			for (int i=0; i<stockHoldList.size(); i++)
			{
				StockHoldShare shs=(StockHoldShare)stockHoldList.get(i);
				String holdStr=shs.getBuyDate()+" "+shs.getCurDate()+" "+shs.getCode()+" "+shs.getName()+" "+shs.getCurPrice()+" "+shs.getAmount()+"�� "+(int)shs.getCurPrice()*shs.getAmount()+"Ԫ ";
				System.out.println(holdStr);
			}
			
			System.out.println("��"+date+"�� �ֲ�: "+accountDD.getStockValue()+"Ԫ  �ֽ�: "+accountDD.getCashValue()+"Ԫ  �ܽ��: "+accountDD.getTotalValue()+"Ԫ ");
			System.out.println(" ");
		}
		
	}
	
	
	public void outputXQJAVGProfit(int xqj, List xqjList)
	{
		
		double totalRise=0;
		double avgRise=0;
		int riseCount=0;
		int downCount=0;
		for (int i=0; i<xqjList.size(); i++)
		{
			double rise=Double.parseDouble(xqjList.get(i).toString());
//			System.out.println("rise "+CommonTool.getDoubleNumberWithTwoBit(rise));
			totalRise=totalRise+rise;
			
			if (rise>=0)
			{
				riseCount++;
			}
			else
			{
				downCount++;
			}
		}
		
		avgRise=totalRise/xqjList.size();
		double risePercent=(riseCount*100)/(riseCount+downCount);
		
		System.out.println("����"+xqj+": "+CommonTool.getDoubleNumberWithTwoBit(avgRise)
				+"("+riseCount+"/"+downCount+" "+CommonTool.getDoubleNumberWithTwoBit(risePercent)+"%)"
				+" Total: "+CommonTool.getDoubleNumberWithTwoBit(totalRise)+"%");
		
		
	}
	
	public int checkDateXQJ(String date)
	{
		
		 int[] weekDays = { 7, 1, 2, 3, 4, 5, 6 };
		 int w=0;
		 
		 try
		 {
			 
	        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");  
	        Date tmpDate = format.parse(date);  
	        Calendar cal = Calendar.getInstance(); 

            cal.setTime(tmpDate);	       
	        w = cal.get(Calendar.DAY_OF_WEEK) - 1; // ָʾһ�������е�ĳ�졣

	        if (w < 0)

	            w = 0;
	        
		 }  
		 catch(Exception e)
		 {
				
			e.printStackTrace();
				
		 }

	      return weekDays[w];

	}

	public boolean checkStockHoldList(List stockHoldList, String stockcode)
	{
		boolean result=false;
		
		for (int i=0; i<stockHoldList.size(); i++)
		{
			StockHoldShare shs=(StockHoldShare)stockHoldList.get(i);
			if (shs.getCode().equals(stockcode))
			{
				result=true;
				break;
			}
		}
		
		return result;
	}
	
	
	// ����ȥ�����м�����
	public int checkPastdays_WR42_TopNumber(List stockDayDataList, int wrValve)  
	{
		
		int topNumber=0;
		
		for (int i=0; i<stockDayDataList.size(); i++)
		{
			
			StockDayData sdd=(StockDayData)stockDayDataList.get(i);
			
			if (sdd.getWR42()>wrValve)
			{
				topNumber++;  // ǰ�����м���>85��ֵ
			}
				
		}
		
		return topNumber;
		
	}
	
	// ����ȥ�����м�����
	public int checkPastdays_WR100_TopNumber(List stockDayDataList, int wrValve)  
	{
		
		int topNumber=0;
		
		for (int i=0; i<stockDayDataList.size(); i++)
		{
			
			StockDayData sdd=(StockDayData)stockDayDataList.get(i);
			
			if (sdd.getWR100()>wrValve)
			{
				topNumber++;  // ǰ�����м���>85��ֵ
			}
				
		}
		
		return topNumber;
		
	}
	
	
	// ����ȥ�����м�����
	public int checkPastdays_WR42_EndNumber(List stockDayDataList, int wrValve)  
	{
		
		int endNumber=0;
		
		for (int i=0; i<stockDayDataList.size(); i++)
		{
			
			StockDayData sdd=(StockDayData)stockDayDataList.get(i);
			
			if (sdd.getWR42()<wrValve)
			{
				endNumber++;  // ǰ�����м���<50��ֵ
			}
		}
		
		return endNumber;
		
	}
	
	// ����ȥ������ȱ仯��ֵ
	public double checkPastdays_WR42_EndNumberRise(List stockDayDataList)  
	{
		
		double totalValue=0;
		
		for (int i=0; i<stockDayDataList.size()-1; i++)
		{
			
			StockDayData sdd_b1=(StockDayData)stockDayDataList.get(i);
			StockDayData sdd_b2=(StockDayData)stockDayDataList.get(i+1);
			
			totalValue=totalValue+(sdd_b1.getWR42()-sdd_b2.getWR42());
		}
		
		return totalValue;
		
	}
	
	// ����ȥ����WR100ֵ��������˶���
	public double checkPastdays_WR100_Rise(List stockDayDataList, StockDayData sdd)
	{
		
		
		double minWR100=1000;
		for (int i=0; i<stockDayDataList.size(); i++)
		{
			StockDayData sddpre=(StockDayData)stockDayDataList.get(i);
			if (sddpre.getWR100()<minWR100)
			{
				minWR100=sddpre.getWR100();
			}
		}
		double riseValue=sdd.getWR100()-minWR100;
		
		return riseValue;
		
	}
	
	// ����ȥ����WR100ֵ������µ��˶���
	public double checkPastdays_WR100_Down(List stockDayDataList, StockDayData sdd)
	{
		
		double maxWR100=0;
		for (int i=0; i<stockDayDataList.size(); i++)
		{
			StockDayData sddpre=(StockDayData)stockDayDataList.get(i);
			if (sddpre.getWR100()>maxWR100)
			{
				maxWR100=sddpre.getWR100();
			}
		}
		double downValue=maxWR100-sdd.getWR100();
		
		return downValue;
		
	}
	
	
	// ����ȥ����WR100ֵ������˶���
	public double checkPastdays_TopRiseDown(List stockDayDataList, StockDayData sdd)
	{
		
		
		double maxPrice=0;
		for (int i=0; i<stockDayDataList.size(); i++)
		{
			StockDayData sddpre=(StockDayData)stockDayDataList.get(i);
			if (sddpre.getHigh()>maxPrice)
			{
				maxPrice=sddpre.getHigh();
			}
		}
		double riseRatio=((sdd.getClose()-maxPrice)/maxPrice)*100;
		
		return riseRatio;
		
	}
	
	

		
		
		
		// ģ��Ͷ�� - macd new dbl �µױ���ָ�����
		public ModelEvaluationReport processInvestmentByStrategy_macd_ndbl(Map stockDataMap, String startDate, String endDate)
		{
			
			// ����һ������ģ���˻�
			PersonalStockAccount psa=new PersonalStockAccount();
			List dateList=CommonTool.generateTimeReferenceList(startDate, endDate, dateType);
			
			// ���������accountDD_pre
	 		AccountDayData accountDD_pre=new AccountDayData();  
			accountDD_pre.setCashValue(psa.investMoney);
			
			double lastSalePrice=10000;  // ��һ���׳�ʱ�ļ۸�, ��ʼֵ10000
			String lastSaleDate="";
			boolean isMACDChanged=false;   // ��һ���׳�������MACD 5>60�������Ƿ�ı�
			
			
			// ģ��ÿ�������ս���
			for (int i=0; i<dateList.size(); i++)
			{
				
				// ȡ��һ����������
				String transDate=dateList.get(i).toString();
				
				// ����һ�����յĽ����˻�����accountDD�����̳����յĳֲֺ��ֽ�
				AccountDayData accountDD=new AccountDayData();
				accountDD.setPosNum(i);
				accountDD.setDate(transDate);
				accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // �̳����յĳֲ�
				accountDD.setCashValue(accountDD_pre.getCashValue());	// �̳����յ��ֽ�
				
				// ��鵱ǰ�ֲֵĹ�Ʊ����״�����Ⱦ����Ƿ������������³ֲֹ�Ʊ�����ɳֲּ۸�
				List stockHoldList=accountDD.getStockHoldList();
				int stockHoldSize=stockHoldList.size();
				for (int j=stockHoldSize-1; j>=0; j--)
				{
					// ȡ��һ���ֹɶ���
					StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
					
					// ��ô˳ֹɵ���ʷ����
					String stockcode=shs.getCode();
					List stockDataRecordList=(List)stockDataMap.get(stockcode);
					
					// ȡ���˹�ǰ���������
					StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
					StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
					StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
					
					
					if (sdd==null || sdd_b1==null || sdd_b2==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
					{
						shs.setCurDate(transDate);
						continue;
					}
					
					TransactionRecordData trd=new TransactionRecordData();
					StockDayData buySDD=shs.getBuySDD();
					
					
					double current_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
					
					// ��ȡǰ���������
					List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
					List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10); 
					List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
					List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
					
	//				sdd_b1=(StockDayData)pastStockList.get(1);   // ��������ȡ��
							
	//				System.out.println(i);
					
					
    // *****************************  �жϴ˹ɵ�ǰ���ƣ������Ƿ�����  *****************************  
	
					if ( 
					i==dateList.size()-2     // ���˽��׶��е����һ�죬������
					||(sdd.getHigh()>=sdd.getMa_20()*0.95) 	// �����ϳ嵽20�վ����ϣ���ֹӯ���� 
//					||(sdd.getHigh()>=sdd.getMa_10()) 	// �����ϳ嵽10�վ����ϣ���ֹӯ���� 
//					||(sdd.getClose()<sdd.getMa_5())    // ���̼۵���5�վ����·�����ֹ������
//					||(current_profit<-3)  // ������ʧ����5%����ֹ������
//					||(checkPastDays_DownLowestPrice(pastStockList20, sdd)) // ����ǰ����͵��λ
					
					)
					{
						// �����ֳ���ָ��
						trd.setStockcode(sdd.getCode());
						trd.setBuySDD(buySDD);
						trd.setSaleSDD(sdd);
						
						// �������
						double transactionProfit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getOpen())/trd.getBuySDD().getOpen())*100-0.2;
						trd.setTransactionProfit(transactionProfit);
						
						accountDD.saleTransList.add(trd);
						
						if(lastSalePrice==10000 || sdd.getClose()>lastSalePrice)
						{
							lastSalePrice=sdd.getClose(); // ��¼��һ������ʱ�ļ۸�
						}
						
						// ����accountDD�ֲ��б�
						accountDD.stockHoldList.remove(j);
						
						// ����accountDD�ֽ��ֵ
						int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
						int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
						accountDD.setCashValue(newCashValue);
						accountDD.setStockValue(newStockValue);
						
						
					}
					else
					{
						// �粻�������ͼ������в��䣬���³ֲּ۸�
						shs.setCurDate(transDate);
						shs.setCurPrice(sdd.getClose());	
					}
					
				}
				
				
				// ����Ʊ���ﱸѡ�Ĺ�Ʊ����������پ����Ƿ����룬�����³ֲֹ�Ʊ
				Iterator it=stockDataMap.keySet().iterator();
				while(it.hasNext())
				{
					
					// �ӱ�ѡ��Ʊ����ȡ��һֻ��Ʊ
					String stockcode=it.next().toString();  
					List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
					if (checkStockHoldList(stockHoldList, stockcode)==true)  // ����Ѿ��ֹɣ�������������
					{
						continue;
					}
					
					// ȡ���˹�ǰ���������
					StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
					StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
					StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
	//				StockDayData sdd_b3=CommonTool.getStockDayData(stockDataRecordList, transDate, -3);
	//				StockDayData sdd_b4=CommonTool.getStockDayData(stockDataRecordList, transDate, -4);
	//				StockDayData sdd_b5=CommonTool.getStockDayData(stockDataRecordList, transDate, -5);
	//				StockDayData sdd_b6=CommonTool.getStockDayData(stockDataRecordList, transDate, -6);
	//				StockDayData sdd_b7=CommonTool.getStockDayData(stockDataRecordList, transDate, -7);
	//				StockDayData sdd_b8=CommonTool.getStockDayData(stockDataRecordList, transDate, -8);
	//				StockDayData sdd_b9=CommonTool.getStockDayData(stockDataRecordList, transDate, -9);
	//				StockDayData sdd_b10=CommonTool.getStockDayData(stockDataRecordList, transDate, -10);
					
					
					if (sdd==null || sdd_b1==null || sdd_b2==null)
					{
						continue;
					}
					
					
					// ��ȡǰ�������������
					List pastStockList3=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 3);  
					List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
					List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);
					List pastStockList15=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 15);
					List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
					List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
					List pastStockList100=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 100);
					List pastStockList150=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 150);
	//				String dateb1=sdd_b1.getDate();   // debug����
	//				System.out.println(dateb1);
					
//					if (sdd_b1.getDate().contains("2021/08/09"))
//					{
//						int t=1;
//						t++;
//					}
					
	
// *****************************  �жϴ˹ɵ�ǰ���ƣ������Ƿ�����  *****************************  
					
					// ����macd �µױ����������
					if ( 
						
						sdd_b2.getClose()<sdd_b2.getMa_5()     //ǰ��������̼���ma5��
						&& (sdd_b1.getClose()+sdd_b1.getHigh())/2>sdd_b1.getMa_5()  //ǰһ������̼ۻ���λֵ��ma5��
						&& (sdd_b1.getClose()+sdd_b1.getHigh())/2<sdd_b1.getMa_10() //ǰһ������̼ۻ���λֵ��ma10��
//						&& sdd.getOpen()<(sdd_b1.getMa_10()+sdd_b1.getMa_5())/2
//						&& sdd_b1.getClose_rise()<3			   //ǰһ����Ƿ�����̫��ҪС��3
						&& sdd_b1.getReal_rise()>0  		   //ǰһ��������
						&& checkPastDaysMACDTrends_UP(pastStockList3, 0)	 // macd ������������
//						&& checkPastDaysMACDTrends_NDBL_DEEP(pastStockList3, -0.3)	// ���macdֵ������̽����-0.6
						&& checkDayData_MA_ktpl(sdd_b1)  // ǰһ���macd�ʿ�ͷ����

							
						)
					{
						
//						sdd.setOpen(sdd_b1.getClose());  // ����������ʱ�����
						
						// �����ֶ�ͷ���У������룬����¼���뽻��
						TransactionRecordData trd=new TransactionRecordData();
						trd.setBuySDD(sdd);
						accountDD.buyTransList.add(trd);
						
						// ����accountDD�ֲ��б�
						StockHoldShare shs=new StockHoldShare();
						
						// ����������Ʊ����
	//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
	//					int amount=0;
	//					if (accountDD.cashValue>eachStockInvestMoney)
	//					{
	//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // ʣ���ֽ��㹻Ͷ��һ�ݵ�ǰ��Ʊ
	//					}
	//					else
	//					{
	//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ𲻹�Ͷ��һ�ݵ�ǰ��Ʊ����ȫ������
	//					}
						
						int amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ�ȫ������
						
						// ���������ĳֲֹ�Ʊ
						shs.setAmount(amount);
						shs.setCode(sdd.getCode());
						shs.setName(sdd.getName());
						shs.setBuyPrice(sdd.getOpen());
						shs.setBuyDate(sdd.getDate());
						shs.setCurPrice(sdd.getClose());
						shs.setCurDate(sdd.getDate());
						shs.setBuySDD(sdd);
						stockHoldList.add(shs);
						
						// ����accountDD�ֽ��ֵ
						int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
						int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
						accountDD.setCashValue(newCashValue);
						accountDD.setStockValue(newStockValue);
						
					}
					else
					{
						
						// ���δ���ϼ������ǣ����Ǽ����µ��ˣ�WR100�ؼ�������80���ϣ���˵�������ѻ������ܼ����ùɼ۽����ķ�����
						// Ҫ�ȴ�WR100�ٴλص�20�����ٴη���һ���µ�����
						if (sdd.getWR100()>80)   
						{
	//						System.out.println("SDD WR: "+sdd.getDate()+"  "+sdd.getWR100());
							lastSalePrice=10000;  
						}
						
					}
					
				}
				
				// ���¸����˻���ÿ���˻���Ϣ
				Map accountDataMap=psa.getAccountDataMap();
				accountDataMap.put(transDate, accountDD);
				accountDD_pre=accountDD;
				
			}
			
			// ���Ͷ�ʽ��׼�¼��ģ�⽻�׽��仯���ߣ��Ա��������ײ���
			String modelName="Ͷ�����_MACD�µױ���ָ��";
			List transactionDataList=generateTransactionDataListFromPSA(psa);
			String reportLine=outputTransactionRecordReport(transactionDataList, modelName);
			// code name date_c saledate year days buy_price sale_price profit 
			
	//		outputAccountRecordReport(psa); // ���account��ÿ��Ͷ�����ݣ��۸�仯���ֽ��ֵ/�ܼ�ֵ  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
			
	//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
	//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, �׷������� 
			
			ModelEvaluationReport mer=new ModelEvaluationReport();
			mer.setTransactionDataList(transactionDataList);
			mer.setReportLine(reportLine);
			mer.setModelName(modelName);
			
			return mer;
		}	
			
		
		
		
		
		// ģ��Ͷ�� - macd new dtpl �¶�ͷ����ָ�����
		public ModelEvaluationReport processInvestmentByStrategy_macd_ndtpl(Map stockDataMap, String startDate, String endDate)
		{
			
			// ����һ������ģ���˻�
			PersonalStockAccount psa=new PersonalStockAccount();
			
			List dateList=CommonTool.generateTimeReferenceList(startDate, endDate, dateType);
			
			// ���������accountDD_pre
	 		AccountDayData accountDD_pre=new AccountDayData();  
			accountDD_pre.setCashValue(psa.investMoney);
			
			double lastSalePrice=10000;  // ��һ���׳�ʱ�ļ۸�, ��ʼֵ10000
			String lastSaleDate="";
			boolean isMACDChanged=false;   // ��һ���׳�������MACD 5>60�������Ƿ�ı�
			
			
			// ģ��ÿ�������ս���
			for (int i=0; i<dateList.size(); i++)
			{
				
				// ȡ��һ����������
				String transDate=dateList.get(i).toString();
				
				// ����һ�����յĽ����˻�����accountDD�����̳����յĳֲֺ��ֽ�
				AccountDayData accountDD=new AccountDayData();
				accountDD.setPosNum(i);
				accountDD.setDate(transDate);
				accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // �̳����յĳֲ�
				accountDD.setCashValue(accountDD_pre.getCashValue());	// �̳����յ��ֽ�
				
				// ��鵱ǰ�ֲֵĹ�Ʊ����״�����Ⱦ����Ƿ������������³ֲֹ�Ʊ�����ɳֲּ۸�
				List stockHoldList=accountDD.getStockHoldList();
				int stockHoldSize=stockHoldList.size();
				for (int j=stockHoldSize-1; j>=0; j--)
				{
					// ȡ��һ���ֹɶ���
					StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
					
					// ��ô˳ֹɵ���ʷ����
					String stockcode=shs.getCode();
					List stockDataRecordList=(List)stockDataMap.get(stockcode);
					
					// ȡ���˹�ǰ���������
					StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
					StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
					StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
					
					
					if (sdd==null || sdd_b1==null || sdd_b2==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
					{
						shs.setCurDate(transDate);
						continue;
					}
					
					TransactionRecordData trd=new TransactionRecordData();
					StockDayData buySDD=shs.getBuySDD();
					
					
					double macd_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
					
					// ��ȡǰ���������
					List pastStockList3=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 3);
					List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
					List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10); 
					List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
					List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
					
	//				sdd_b1=(StockDayData)pastStockList.get(1);   // ��������ȡ��
							
	//				System.out.println(i);
					
					
// *****************************  �жϴ˹ɵ�ǰ���ƣ������Ƿ�����  *****************************  

					if ( 
					i==dateList.size()-2     // ���˽��׶��е����һ�죬������
//					|| calculatePriceGapRatio(sdd.getClose(), sdd.getMa_5())>0.06
//					|| !checkPastDaysMACDTrends_NDBL_UP(pastStockList3, 1)
					|| (1>0
//					&& sdd.getClose_rise()<0    // ����
//					&& sdd.getClose()<sdd.getMa_20() 		// ������20��������
					&& (sdd.getHigh()+sdd.getLow())/2<sdd.getMa_20() // ���۵���20�վ���
					&& sdd.getMa_macd()<=sdd_b1.getMa_macd() && sdd_b1.getMa_macd()<=sdd_b2.getMa_macd()  // ��������MACD�µ�
					)	 // macd ����������	
//					||(sdd.getHigh()>sdd.getMa_20()) 	// �����ϳ嵽20�վ����ϣ���ֹӯ���� 
					
					)
					{
						// ������CCI����ָ��
	//					TransactionRecordData trd=new TransactionRecordData();
	//					StockDayData buySDD=shs.getBuySDD();
						trd.setStockcode(sdd.getCode());
						trd.setBuySDD(buySDD);
						trd.setSaleSDD(sdd);
						
						// �������
						double transactionProfit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getOpen())/trd.getBuySDD().getOpen())*100-0.2;
						trd.setTransactionProfit(transactionProfit);
						
						accountDD.saleTransList.add(trd);
						
						if(lastSalePrice==10000 || sdd.getClose()>lastSalePrice)
						{
							lastSalePrice=sdd.getClose(); // ��¼��һ������ʱ�ļ۸�
						}
						
						// ����accountDD�ֲ��б�
						accountDD.stockHoldList.remove(j);
						
						// ����accountDD�ֽ��ֵ
						int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
						int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
						accountDD.setCashValue(newCashValue);
						accountDD.setStockValue(newStockValue);
						
						
					}
					else
					{
						// �粻�������ͼ������в��䣬���³ֲּ۸�
						shs.setCurDate(transDate);
						shs.setCurPrice(sdd.getClose());	
					}
					
				}
				
				
				// ����Ʊ���ﱸѡ�Ĺ�Ʊ����������پ����Ƿ����룬�����³ֲֹ�Ʊ
				Iterator it=stockDataMap.keySet().iterator();
				while(it.hasNext())
				{
					
					// �ӱ�ѡ��Ʊ����ȡ��һֻ��Ʊ
					String stockcode=it.next().toString();  
					List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
					if (checkStockHoldList(stockHoldList, stockcode)==true)  // ����Ѿ��ֹɣ�������������
					{
						continue;
					}
					
					// ȡ���˹�ǰ���������
					StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
					StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
					StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
					StockDayData sdd_b3=CommonTool.getStockDayData(stockDataRecordList, transDate, -3);
	//				StockDayData sdd_b4=CommonTool.getStockDayData(stockDataRecordList, transDate, -4);
	//				StockDayData sdd_b5=CommonTool.getStockDayData(stockDataRecordList, transDate, -5);
	//				StockDayData sdd_b6=CommonTool.getStockDayData(stockDataRecordList, transDate, -6);
	//				StockDayData sdd_b7=CommonTool.getStockDayData(stockDataRecordList, transDate, -7);
	//				StockDayData sdd_b8=CommonTool.getStockDayData(stockDataRecordList, transDate, -8);
	//				StockDayData sdd_b9=CommonTool.getStockDayData(stockDataRecordList, transDate, -9);
					
					
	//				if (sdd!=null && sdd_b1!=null)
	//				{
	//					System.out.println(sdd_b1.getName()+" "+sdd_b1.getCode()+" "+sdd_b1.getDate()+" "+sdd_b1.getClose());
	//					System.out.println(sdd.getName()+" "+sdd.getCode()+" "+sdd.getDate()+" "+sdd.getClose());
	//				}
					
					if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null)
					{
						continue;
					}
					
	//				if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null || sdd_b4==null || sdd_b5==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
	//				{
	//					continue;
	//				}
	//				
	//				if (sdd_b6==null || sdd_b7==null || sdd_b8==null || sdd_b9==null)
	//				{
	//					continue;
	//				}
	//				
	//				if (sdd_b10==null || sdd_b11==null || sdd_b12==null || sdd_b13==null || sdd_b14==null || sdd_b15==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
	//				{
	//					continue;
	//				}
					
					// ��ȡǰ���������
					List pastStockList2=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 2); 
					List pastStockList3=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 3);  
					List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
					List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);
					List pastStockList15=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 15);
					List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
					List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
					List pastStockList100=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 100);
					List pastStockList150=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 150);
	//				String dateb1=sdd_b1.getDate();   // debug����
	//				System.out.println(dateb1);
					
					if (sdd_b1.getDate().contains("2021/08/09"))
					{
						int t=1;
						t++;
					}
					
					
// *****************************  �жϴ˹ɵ�ǰ���ƣ������Ƿ�����  *****************************  
					
					if ( 
						
//						calculatePriceGapRatio(sdd_b1.getClose(), sdd_b1.getMa_5())<0.04  //ǰһ������̼���ma5�ϣ������ܽ�
						sdd_b1.getSwing()<7    // ǰһ��û��̫��ƫ��5����
						&& sdd_b1.getReal_rise()>0		 // ǰһ��������
						&& sdd_b1.getClose()>sdd_b1.getMa_5()  //  ǰһ����������5�վ�����
//						&& sdd_b1.getMa_5()>sdd_b1.getMa_60()  //  MA5>ma60
						&& checkDayData_MA_dtpl(pastStockList3)    // ��ȥ2�ճʶ�ͷ��������
//						&& checkPastDaysHighPrice(sdd_b1, stockDataRecordList, sdd_b1.getPosNum(), 120)
//						&& !(sdd_b1.getMa_60()>sdd_b1.getMa_5() && sdd_b1.getMa_60()>sdd_b1.getMa_10() && sdd_b1.getMa_60()>sdd_b1.getMa_20())
						&& checkPastDaysMACDTrends_UP(pastStockList3, 0)	 // macd ����������

//						&& sdd_b6.getMa_5()>sdd_b6.getMa_60()     // �ǳ���Ҫ��һ����������׼ȷ������������̬	
							
						)
					{
						
						// �����ֶ�ͷ���У������룬����¼���뽻��
						TransactionRecordData trd=new TransactionRecordData();
						trd.setBuySDD(sdd);
						accountDD.buyTransList.add(trd);
						
						// ����accountDD�ֲ��б�
						StockHoldShare shs=new StockHoldShare();
						
						// ����������Ʊ����
	//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
	//					int amount=0;
	//					if (accountDD.cashValue>eachStockInvestMoney)
	//					{
	//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // ʣ���ֽ��㹻Ͷ��һ�ݵ�ǰ��Ʊ
	//					}
	//					else
	//					{
	//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ𲻹�Ͷ��һ�ݵ�ǰ��Ʊ����ȫ������
	//					}
						
						int amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ�ȫ������
						
						// ���������ĳֲֹ�Ʊ
						shs.setAmount(amount);
						shs.setCode(sdd.getCode());
						shs.setName(sdd.getName());
						shs.setBuyPrice(sdd.getOpen());
						shs.setBuyDate(sdd.getDate());
						shs.setCurPrice(sdd.getClose());
						shs.setCurDate(sdd.getDate());
						shs.setBuySDD(sdd);
						stockHoldList.add(shs);
						
						// ����accountDD�ֽ��ֵ
						int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
						int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
						accountDD.setCashValue(newCashValue);
						accountDD.setStockValue(newStockValue);
						
					}
					else
					{
						
						// ���δ���ϼ������ǣ����Ǽ����µ��ˣ�WR100�ؼ�������80���ϣ���˵�������ѻ������ܼ����ùɼ۽����ķ�����
						// Ҫ�ȴ�WR100�ٴλص�20�����ٴη���һ���µ�����
						if (sdd.getWR100()>80)   
						{
	//						System.out.println("SDD WR: "+sdd.getDate()+"  "+sdd.getWR100());
							lastSalePrice=10000;  
						}
						
					}
					
				}
				
				// ���¸����˻���ÿ���˻���Ϣ
				Map accountDataMap=psa.getAccountDataMap();
				accountDataMap.put(transDate, accountDD);
				accountDD_pre=accountDD;
				
			}
			
			// ���Ͷ�ʽ��׼�¼��ģ�⽻�׽��仯���ߣ��Ա��������ײ���
			String modelName="Ͷ�����_MACD�¶�ͷ����ָ��";
			List transactionDataList=generateTransactionDataListFromPSA(psa);
			String reportLine=outputTransactionRecordReport(transactionDataList, modelName);
			// code name date_c saledate year days buy_price sale_price profit 
			
	//		outputAccountRecordReport(psa); // ���account��ÿ��Ͷ�����ݣ��۸�仯���ֽ��ֵ/�ܼ�ֵ  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
			
	//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
	//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, �׷������� 
			
			ModelEvaluationReport mer=new ModelEvaluationReport();
			mer.setTransactionDataList(transactionDataList);
			mer.setReportLine(reportLine);
			mer.setModelName(modelName);
			
			return mer;
		}	
		
		
		// ģ��Ͷ�� - macd new dtpl ma20�¶�ͷ����ָ�����
		public ModelEvaluationReport processInvestmentByStrategy_macd_ndtpl_ma20(Map stockDataMap, String startDate, String endDate)
		{
			
			// ����һ������ģ���˻�
			PersonalStockAccount psa=new PersonalStockAccount();
			
			List dateList=CommonTool.generateTimeReferenceList(startDate, endDate, dateType);
			
			// ���������accountDD_pre
	 		AccountDayData accountDD_pre=new AccountDayData();  
			accountDD_pre.setCashValue(psa.investMoney);
			
			double lastSalePrice=10000;  // ��һ���׳�ʱ�ļ۸�, ��ʼֵ10000
			String lastSaleDate="";
			boolean isMACDChanged=false;   // ��һ���׳�������MACD 5>60�������Ƿ�ı�
			boolean isStockSaleDay=false;
			
			// ģ��ÿ�������ս���
			for (int i=0; i<dateList.size(); i++)
			{
				
				// ȡ��һ����������
				String transDate=dateList.get(i).toString();
				isStockSaleDay=false;  // ��Ĭ�ϲ��ǹ�Ʊ������
				
				// ����һ�����յĽ����˻�����accountDD�����̳����յĳֲֺ��ֽ�
				AccountDayData accountDD=new AccountDayData();
				accountDD.setPosNum(i);
				accountDD.setDate(transDate);
				accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // �̳����յĳֲ�
				accountDD.setCashValue(accountDD_pre.getCashValue());	// �̳����յ��ֽ�
				
				// ��鵱ǰ�ֲֵĹ�Ʊ����״�����Ⱦ����Ƿ������������³ֲֹ�Ʊ�����ɳֲּ۸�
				List stockHoldList=accountDD.getStockHoldList();
				int stockHoldSize=stockHoldList.size();
				for (int j=stockHoldSize-1; j>=0; j--)
				{
					// ȡ��һ���ֹɶ���
					StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
					
					// ��ô˳ֹɵ���ʷ����
					String stockcode=shs.getCode();
					List stockDataRecordList=(List)stockDataMap.get(stockcode);
					
					// ȡ���˹�ǰ���������
					StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
					StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
					StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
					
					
					if (sdd==null || sdd_b1==null || sdd_b2==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
					{
						shs.setCurDate(transDate);
						continue;
					}
					
					TransactionRecordData trd=new TransactionRecordData();
					StockDayData buySDD=shs.getBuySDD();
					
					
					double macd_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
					
					// ��ȡǰ���������
					List pastStockList3=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 3);
					List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
					List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10); 
					List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
					List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
					
	//				sdd_b1=(StockDayData)pastStockList.get(1);   // ��������ȡ��
							
	//				System.out.println(i);
					
					
// *****************************  �жϴ˹ɵ�ǰ���ƣ������Ƿ�����  *****************************  

					if ( 
					i==dateList.size()-2     // ���˽��׶��е����һ�죬������
//					|| calculatePriceGapRatio(sdd.getClose(), sdd.getMa_5())>0.06
//					|| !checkPastDaysMACDTrends_NDBL_UP(pastStockList3, 1)
					|| (1>0
//					&& sdd.getClose_rise()<0    // ����
//					&& sdd.getClose()<sdd.getMa_20() 		// ������20��������
					&& (sdd_b1.getHigh()+sdd_b1.getLow())/2<sdd_b1.getMa_20() // ���۵���20�վ���
//					&& sdd.getHigh()<sdd.getMa_20()  // �����������20�վ���
					&& (sdd_b1.getHigh()+sdd_b1.getLow())/2>(sdd.getHigh()+sdd.getLow())/2// ����תΪ����
//					&& (sdd.getHigh()+sdd.getLow())/2<sdd.getMa_5() // ���۵���5�վ���
//					&& sdd.getMa_macd()<=sdd_b1.getMa_macd() && sdd_b1.getMa_macd()<=sdd_b2.getMa_macd()  // ��������MACD�µ�
					)	 // macd ����������	
//					||(sdd.getHigh()>sdd.getMa_20()) 	// �����ϳ嵽20�վ����ϣ���ֹӯ���� 
					
					)
					{
						
						isStockSaleDay=true;  // ����������������������Ϊ�����ձ�־
						
						// ������CCI����ָ��
	//					TransactionRecordData trd=new TransactionRecordData();
	//					StockDayData buySDD=shs.getBuySDD();
						trd.setStockcode(sdd.getCode());
						trd.setBuySDD(buySDD);
						trd.setSaleSDD(sdd);
						
						// �������
						double transactionProfit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getOpen())/trd.getBuySDD().getOpen())*100-0.2;
						trd.setTransactionProfit(transactionProfit);
						
						accountDD.saleTransList.add(trd);
						
						if(lastSalePrice==10000 || sdd.getClose()>lastSalePrice)
						{
							lastSalePrice=sdd.getClose(); // ��¼��һ������ʱ�ļ۸�
						}
						
						// ����accountDD�ֲ��б�
						accountDD.stockHoldList.remove(j);
						
						// ����accountDD�ֽ��ֵ
						int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
						int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
						accountDD.setCashValue(newCashValue);
						accountDD.setStockValue(newStockValue);
						
						
					}
					else
					{
						// �粻�������ͼ������в��䣬���³ֲּ۸�
						shs.setCurDate(transDate);
						shs.setCurPrice(sdd.getClose());	
					}
					
				}
				
				
				// ����Ʊ���ﱸѡ�Ĺ�Ʊ����������پ����Ƿ����룬�����³ֲֹ�Ʊ
				Iterator it=stockDataMap.keySet().iterator();
				while(it.hasNext())
				{
					
					// �ӱ�ѡ��Ʊ����ȡ��һֻ��Ʊ
					String stockcode=it.next().toString();  
					List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
					if (checkStockHoldList(stockHoldList, stockcode)==true || isStockSaleDay)  // ����Ѿ��ֹɣ����ߵ����������գ�������������
					{
						continue;
					}
					
					// ȡ���˹�ǰ���������
					StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
					StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
					StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
					StockDayData sdd_b3=CommonTool.getStockDayData(stockDataRecordList, transDate, -3);
	//				StockDayData sdd_b4=CommonTool.getStockDayData(stockDataRecordList, transDate, -4);
	//				StockDayData sdd_b5=CommonTool.getStockDayData(stockDataRecordList, transDate, -5);
	//				StockDayData sdd_b6=CommonTool.getStockDayData(stockDataRecordList, transDate, -6);
	//				StockDayData sdd_b7=CommonTool.getStockDayData(stockDataRecordList, transDate, -7);
	//				StockDayData sdd_b8=CommonTool.getStockDayData(stockDataRecordList, transDate, -8);
	//				StockDayData sdd_b9=CommonTool.getStockDayData(stockDataRecordList, transDate, -9);
					
					
	//				if (sdd!=null && sdd_b1!=null)
	//				{
	//					System.out.println(sdd_b1.getName()+" "+sdd_b1.getCode()+" "+sdd_b1.getDate()+" "+sdd_b1.getClose());
	//					System.out.println(sdd.getName()+" "+sdd.getCode()+" "+sdd.getDate()+" "+sdd.getClose());
	//				}
					
					if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null)
					{
						continue;
					}
					
	//				if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null || sdd_b4==null || sdd_b5==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
	//				{
	//					continue;
	//				}
	//				
	//				if (sdd_b6==null || sdd_b7==null || sdd_b8==null || sdd_b9==null)
	//				{
	//					continue;
	//				}
	//				
	//				if (sdd_b10==null || sdd_b11==null || sdd_b12==null || sdd_b13==null || sdd_b14==null || sdd_b15==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
	//				{
	//					continue;
	//				}
					
					// ��ȡǰ���������
					List pastStockList2=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 2); 
					List pastStockList3=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 3);  
					List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
					List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);
					List pastStockList15=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 15);
					List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
					List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
					List pastStockList100=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 100);
					List pastStockList150=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 150);
	//				String dateb1=sdd_b1.getDate();   // debug����
	//				System.out.println(dateb1);
					
					if (sdd_b1.getDate().contains("2021/08/09"))
					{
						int t=1;
						t++;
					}
					
					
// *****************************  �жϴ˹ɵ�ǰ���ƣ������Ƿ�����  *****************************  
					
					if ( 
						1>0
//						calculatePriceGapRatio(sdd_b1.getClose(), sdd_b1.getMa_5())<0.04  //ǰһ������̼���ma5�ϣ������ܽ�
						&& sdd_b1.getSwing()<7    // ǰһ��û��̫��ƫ��5����
//						&& sdd_b1.getReal_rise()>0		 // ǰһ��������
//						&& sdd_b1.getClose()>sdd_b1.getMa_5()  //  ǰһ����������5�վ�����
						&& sdd_b1.getClose()>sdd_b1.getMa_10()  //  ǰһ����������20�վ�����
//						&& sdd.getClose()>sdd.getMa_20()
//						&& sdd_b1.getMa_5()>sdd_b1.getMa_60()  //  MA5>ma60
//						&& checkDayData_MA_dtpl(sdd_b1)    // ��ȥ1�ճʶ�ͷ��������
//						&& checkPastDaysHighPrice(sdd_b1, stockDataRecordList, sdd_b1.getPosNum(), 500)
//						&& !(sdd_b1.getMa_60()>sdd_b1.getMa_5() && sdd_b1.getMa_60()>sdd_b1.getMa_10() && sdd_b1.getMa_60()>sdd_b1.getMa_20())
//						&& checkPastDaysMACDTrends_UP(pastStockList3, 0)	 // macd ����������

//						&& sdd_b6.getMa_5()>sdd_b6.getMa_60()     // �ǳ���Ҫ��һ����������׼ȷ������������̬	
						
						&& checkPastDaysMACDTrends_MA20(pastStockList5, 5)
//						&& checkPastDaysMACDTrends_MA10(pastStockList5, 5)
						)
					{
						
						
						// �����ֶ�ͷ���У������룬����¼���뽻��
						TransactionRecordData trd=new TransactionRecordData();
						trd.setBuySDD(sdd);
						accountDD.buyTransList.add(trd);
						
						// ����accountDD�ֲ��б�
						StockHoldShare shs=new StockHoldShare();
						
						// ����������Ʊ����
	//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
	//					int amount=0;
	//					if (accountDD.cashValue>eachStockInvestMoney)
	//					{
	//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // ʣ���ֽ��㹻Ͷ��һ�ݵ�ǰ��Ʊ
	//					}
	//					else
	//					{
	//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ𲻹�Ͷ��һ�ݵ�ǰ��Ʊ����ȫ������
	//					}
						
						int amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ�ȫ������
						
						// ���������ĳֲֹ�Ʊ
						shs.setAmount(amount);
						shs.setCode(sdd.getCode());
						shs.setName(sdd.getName());
						shs.setBuyPrice(sdd.getOpen());
						shs.setBuyDate(sdd.getDate());
						shs.setCurPrice(sdd.getClose());
						shs.setCurDate(sdd.getDate());
						shs.setBuySDD(sdd);
						stockHoldList.add(shs);
						
						// ����accountDD�ֽ��ֵ
						int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
						int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
						accountDD.setCashValue(newCashValue);
						accountDD.setStockValue(newStockValue);
						
					}
					else
					{
						
						// ���δ���ϼ������ǣ����Ǽ����µ��ˣ�WR100�ؼ�������80���ϣ���˵�������ѻ������ܼ����ùɼ۽����ķ�����
						// Ҫ�ȴ�WR100�ٴλص�20�����ٴη���һ���µ�����
						if (sdd.getWR100()>80)   
						{
	//						System.out.println("SDD WR: "+sdd.getDate()+"  "+sdd.getWR100());
							lastSalePrice=10000;  
						}
						
					}
					
				}
				
				// ���¸����˻���ÿ���˻���Ϣ
				Map accountDataMap=psa.getAccountDataMap();
				accountDataMap.put(transDate, accountDD);
				accountDD_pre=accountDD;
				
			}
			
			// ���Ͷ�ʽ��׼�¼��ģ�⽻�׽��仯���ߣ��Ա��������ײ���
			String modelName="Ͷ�����_MACD�¶�ͷ����ָ��_MA20";
			List transactionDataList=generateTransactionDataListFromPSA(psa);
			String reportLine=outputTransactionRecordReport(transactionDataList, modelName);
			// code name date_c saledate year days buy_price sale_price profit 
			
	//		outputAccountRecordReport(psa); // ���account��ÿ��Ͷ�����ݣ��۸�仯���ֽ��ֵ/�ܼ�ֵ  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
			
	//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
	//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, �׷������� 
			
			ModelEvaluationReport mer=new ModelEvaluationReport();
			mer.setTransactionDataList(transactionDataList);
			mer.setReportLine(reportLine);
			mer.setModelName(modelName);
			
			return mer;
		}	
		
		
		// ģ��Ͷ�� - zspm ��������minuteָ�����
		public ModelEvaluationReport processInvestmentByStrategy_zspm_minute(Map stockDataMap, String startDate, String endDate)
		{
			
			// ����һ������ģ���˻�
			PersonalStockAccount psa=new PersonalStockAccount();
			
			List dateList=CommonTool.generateTimeReferenceList(startDate, endDate, dateType);
			
			// ���������accountDD_pre
	 		AccountDayData accountDD_pre=new AccountDayData();  
			accountDD_pre.setCashValue(psa.investMoney);
			
			double lastSalePrice=10000;  // ��һ���׳�ʱ�ļ۸�, ��ʼֵ10000
			String lastSaleDate="";
			boolean isMACDChanged=false;   // ��һ���׳�������MACD 5>60�������Ƿ�ı�
			boolean isStockSaleDay=false;
			
			// ģ��ÿ�������ս���
			for (int i=0; i<dateList.size(); i++)
			{
				
				// ȡ��һ����������
				String transDate=dateList.get(i).toString();
				isStockSaleDay=false;  // ��Ĭ�ϲ��ǹ�Ʊ������
				
				// ����һ�����յĽ����˻�����accountDD�����̳����յĳֲֺ��ֽ�
				AccountDayData accountDD=new AccountDayData();
				accountDD.setPosNum(i);
				accountDD.setDate(transDate);
				accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // �̳����յĳֲ�
				accountDD.setCashValue(accountDD_pre.getCashValue());	// �̳����յ��ֽ�
				
				// ��鵱ǰ�ֲֵĹ�Ʊ����״�����Ⱦ����Ƿ������������³ֲֹ�Ʊ�����ɳֲּ۸�
				List stockHoldList=accountDD.getStockHoldList();
				int stockHoldSize=stockHoldList.size();
				for (int j=stockHoldSize-1; j>=0; j--)
				{
					// ȡ��һ���ֹɶ���
					StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
					
					// ��ô˳ֹɵ���ʷ����
					String stockcode=shs.getCode();
					List stockDataRecordList=(List)stockDataMap.get(stockcode);
					
					// ȡ���˹�ǰ���������
					StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
					StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
					StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
					
					
					if (sdd==null || sdd_b1==null || sdd_b2==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
					{
						shs.setCurDate(transDate);
						continue;
					}
					
					TransactionRecordData trd=new TransactionRecordData();
					StockDayData buySDD=shs.getBuySDD();
					
					
					double macd_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
					
					// ��ȡǰ���������
					List pastStockList3=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 3);
					List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
					List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10); 
					List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
					List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
					
	//				sdd_b1=(StockDayData)pastStockList.get(1);   // ��������ȡ��
							
	//				System.out.println(i);
					
					
// *****************************  �жϴ˹ɵ�ǰ���ƣ������Ƿ�����  *****************************  

					if ( 
					i==dateList.size()-2     // ���˽��׶��е����һ�죬������
//					|| calculatePriceGapRatio(sdd.getClose(), sdd.getMa_5())>0.06
//					|| !checkPastDaysMACDTrends_NDBL_UP(pastStockList3, 1)
					|| (1>0
//					&& sdd.getClose()<sdd.getMa_20()
					&& sdd.getDate().substring(0, 10).compareTo(buySDD.getDate().substring(0,10))>0  // ����ڶ���������
//					&& sdd.getDate().endsWith("001")   // ��������
//					&& sdd.getClose_rise()<0    // ����
//					&& sdd.getClose()<sdd.getMa_20() 		// ������20��������
//					&& (sdd_b1.getHigh()+sdd_b1.getLow())/2<sdd_b1.getMa_20() // ���۵���20�վ���
//					&& sdd.getHigh()<sdd.getMa_20()  // �����������20�վ���
//					&& (sdd_b1.getHigh()+sdd_b1.getLow())/2>(sdd.getHigh()+sdd.getLow())/2// ����תΪ����
//					&& (sdd.getHigh()+sdd.getLow())/2<sdd.getMa_5() // ���۵���5�վ���
//					&& sdd.getMa_macd()<=sdd_b1.getMa_macd() && sdd_b1.getMa_macd()<=sdd_b2.getMa_macd()  // ��������MACD�µ�
					)	 // macd ����������	
//					||(sdd.getHigh()>sdd.getMa_20()) 	// �����ϳ嵽20�վ����ϣ���ֹӯ���� 
					
					)
					{
						
						isStockSaleDay=true;  // ����������������������Ϊ�����ձ�־
						
						// ������CCI����ָ��
	//					TransactionRecordData trd=new TransactionRecordData();
	//					StockDayData buySDD=shs.getBuySDD();
						trd.setStockcode(sdd.getCode());
						trd.setBuySDD(buySDD);
						trd.setSaleSDD(sdd);
						
						// �������
						double transactionProfit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getOpen())/trd.getBuySDD().getOpen())*100-0.2;
						trd.setTransactionProfit(transactionProfit);
						
						accountDD.saleTransList.add(trd);
						
						if(lastSalePrice==10000 || sdd.getClose()>lastSalePrice)
						{
							lastSalePrice=sdd.getClose(); // ��¼��һ������ʱ�ļ۸�
						}
						
						// ����accountDD�ֲ��б�
						accountDD.stockHoldList.remove(j);
						
						// ����accountDD�ֽ��ֵ
						int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
						int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
						accountDD.setCashValue(newCashValue);
						accountDD.setStockValue(newStockValue);
						
						
					}
					else
					{
						// �粻�������ͼ������в��䣬���³ֲּ۸�
						shs.setCurDate(transDate);
						shs.setCurPrice(sdd.getClose());	
					}
					
				}
				
				
				// ����Ʊ���ﱸѡ�Ĺ�Ʊ����������پ����Ƿ����룬�����³ֲֹ�Ʊ
				Iterator it=stockDataMap.keySet().iterator();
				while(it.hasNext())
				{
					
					// �ӱ�ѡ��Ʊ����ȡ��һֻ��Ʊ
					String stockcode=it.next().toString();  
					List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
					if (checkStockHoldList(stockHoldList, stockcode)==true || isStockSaleDay)  // ����Ѿ��ֹɣ����ߵ����������գ�������������
					{
						continue;
					}
					
					// ȡ���˹�ǰ���������
					StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
					StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
					StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
					StockDayData sdd_b3=CommonTool.getStockDayData(stockDataRecordList, transDate, -3);
	//				StockDayData sdd_b4=CommonTool.getStockDayData(stockDataRecordList, transDate, -4);
	//				StockDayData sdd_b5=CommonTool.getStockDayData(stockDataRecordList, transDate, -5);
	//				StockDayData sdd_b6=CommonTool.getStockDayData(stockDataRecordList, transDate, -6);
	//				StockDayData sdd_b7=CommonTool.getStockDayData(stockDataRecordList, transDate, -7);
	//				StockDayData sdd_b8=CommonTool.getStockDayData(stockDataRecordList, transDate, -8);
	//				StockDayData sdd_b9=CommonTool.getStockDayData(stockDataRecordList, transDate, -9);
					
					
	//				if (sdd!=null && sdd_b1!=null)
	//				{
	//					System.out.println(sdd_b1.getName()+" "+sdd_b1.getCode()+" "+sdd_b1.getDate()+" "+sdd_b1.getClose());
	//					System.out.println(sdd.getName()+" "+sdd.getCode()+" "+sdd.getDate()+" "+sdd.getClose());
	//				}
					
					if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null)
					{
						continue;
					}
					
	//				if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null || sdd_b4==null || sdd_b5==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
	//				{
	//					continue;
	//				}
	//				
	//				if (sdd_b6==null || sdd_b7==null || sdd_b8==null || sdd_b9==null)
	//				{
	//					continue;
	//				}
	//				
	//				if (sdd_b10==null || sdd_b11==null || sdd_b12==null || sdd_b13==null || sdd_b14==null || sdd_b15==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
	//				{
	//					continue;
	//				}
					
					// ��ȡǰ���������
					List pastStockList2=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 2); 
					List pastStockList3=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 3);  
					List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
					List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);
					List pastStockList15=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 15);
					List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
					List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
					List pastStockList100=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 100);
					List pastStockList150=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 150);
	//				String dateb1=sdd_b1.getDate();   // debug����
	//				System.out.println(dateb1);
					
					if (sdd_b1.getDate().contains("2021/08/09"))
					{
						int t=1;
						t++;
					}
					
					
// *****************************  �жϴ˹ɵ�ǰ���ƣ������Ƿ�����  *****************************  
					
					if ( 
							1>0
							&& sdd.getClose_rise()>1 // �Ƿ�����1�͸�������
							&& sdd.getReal_rise()>1  // �����Ƿ�>1
							&& sdd.getClose()>sdd.getMa_5() && sdd.getMa_5()>sdd.getMa_10()
//							calculatePriceGapRatio(sdd_b1.getClose(), sdd_b1.getMa_5())<0.04  //ǰһ������̼���ma5�ϣ������ܽ�
//							&& sdd_b1.getSwing()<7    // ǰһ��û��̫��ƫ��5����
//							&& sdd_b1.getReal_rise()>0		 // ǰһ��������
//							&& sdd_b1.getClose()>sdd_b1.getMa_5()  //  ǰһ����������5�վ�����
//							&& sdd_b1.getClose()>sdd_b1.getMa_10()  //  ǰһ����������20�վ�����
//							&& sdd.getClose()>sdd.getMa_20()
//							&& sdd_b1.getMa_5()>sdd_b1.getMa_60()  //  MA5>ma60
//							&& checkDayData_MA_dtpl(sdd_b1)    // ��ȥ1�ճʶ�ͷ��������
//							&& checkPastDaysHighPrice(sdd_b1, stockDataRecordList, sdd_b1.getPosNum(), 500)
//							&& !(sdd_b1.getMa_60()>sdd_b1.getMa_5() && sdd_b1.getMa_60()>sdd_b1.getMa_10() && sdd_b1.getMa_60()>sdd_b1.getMa_20())
//							&& checkPastDaysMACDTrends_UP(pastStockList3, 0)	 // macd ����������
//							&& sdd_b6.getMa_5()>sdd_b6.getMa_60()     // �ǳ���Ҫ��һ����������׼ȷ������������̬	
//							&& checkPastDaysMACDTrends_MA20(pastStockList5, 5)
//							&& checkPastDaysMACDTrends_MA10(pastStockList5, 5)
							
							)
					{
						
						
						// �����ֶ�ͷ���У������룬����¼���뽻��
						TransactionRecordData trd=new TransactionRecordData();
						trd.setBuySDD(sdd);
						accountDD.buyTransList.add(trd);
						
						// ����accountDD�ֲ��б�
						StockHoldShare shs=new StockHoldShare();
						
						// ����������Ʊ����
	//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
	//					int amount=0;
	//					if (accountDD.cashValue>eachStockInvestMoney)
	//					{
	//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // ʣ���ֽ��㹻Ͷ��һ�ݵ�ǰ��Ʊ
	//					}
	//					else
	//					{
	//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ𲻹�Ͷ��һ�ݵ�ǰ��Ʊ����ȫ������
	//					}
						
						int amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ�ȫ������
						
						// ���������ĳֲֹ�Ʊ
						shs.setAmount(amount);
						shs.setCode(sdd.getCode());
						shs.setName(sdd.getName());
						shs.setBuyPrice(sdd.getOpen());
						shs.setBuyDate(sdd.getDate());
						shs.setCurPrice(sdd.getClose());
						shs.setCurDate(sdd.getDate());
						shs.setBuySDD(sdd);
						stockHoldList.add(shs);
						
						// ����accountDD�ֽ��ֵ
						int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
						int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
						accountDD.setCashValue(newCashValue);
						accountDD.setStockValue(newStockValue);
						
					}
					else
					{
						
						// ���δ���ϼ������ǣ����Ǽ����µ��ˣ�WR100�ؼ�������80���ϣ���˵�������ѻ������ܼ����ùɼ۽����ķ�����
						// Ҫ�ȴ�WR100�ٴλص�20�����ٴη���һ���µ�����
						if (sdd.getWR100()>80)   
						{
	//						System.out.println("SDD WR: "+sdd.getDate()+"  "+sdd.getWR100());
							lastSalePrice=10000;  
						}
						
					}
					
				}
				
				// ���¸����˻���ÿ���˻���Ϣ
				Map accountDataMap=psa.getAccountDataMap();
				accountDataMap.put(transDate, accountDD);
				accountDD_pre=accountDD;
				
			}
			
			// ���Ͷ�ʽ��׼�¼��ģ�⽻�׽��仯���ߣ��Ա��������ײ���
			String modelName="Ͷ�����_MACD�¶�ͷ����ָ��_MA20";
			List transactionDataList=generateTransactionDataListFromPSA(psa);
			String reportLine=outputTransactionRecordReport(transactionDataList, modelName);
			// code name date_c saledate year days buy_price sale_price profit 
			
	//		outputAccountRecordReport(psa); // ���account��ÿ��Ͷ�����ݣ��۸�仯���ֽ��ֵ/�ܼ�ֵ  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
			
	//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
	//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, �׷������� 
			
			ModelEvaluationReport mer=new ModelEvaluationReport();
			mer.setTransactionDataList(transactionDataList);
			mer.setReportLine(reportLine);
			mer.setModelName(modelName);
			
			return mer;
		}	
		
		// ģ��Ͷ�� - zzyl ׷��ӯ��minuteָ�����
		public ModelEvaluationReport processInvestmentByStrategy_zzyl_minute(Map stockDataMap, String startDate, String endDate)
		{
			
			// ����һ������ģ���˻�
			PersonalStockAccount psa=new PersonalStockAccount();
			
			List dateList=CommonTool.generateTimeReferenceList(startDate, endDate, dateType);
			
			// ���������accountDD_pre
	 		AccountDayData accountDD_pre=new AccountDayData();  
			accountDD_pre.setCashValue(psa.investMoney);
			
			double lastSalePrice=10000;  // ��һ���׳�ʱ�ļ۸�, ��ʼֵ10000
			String lastSaleDate="";
			boolean isMACDChanged=false;   // ��һ���׳�������MACD 5>60�������Ƿ�ı�
			boolean isStockSaleDay=false;
			
			// ģ��ÿ�������ս���
			for (int i=0; i<dateList.size(); i++)
			{
				
				// ȡ��һ����������
				String transDate=dateList.get(i).toString();
				isStockSaleDay=false;  // ��Ĭ�ϲ��ǹ�Ʊ������
				
				// ����һ�����յĽ����˻�����accountDD�����̳����յĳֲֺ��ֽ�
				AccountDayData accountDD=new AccountDayData();
				accountDD.setPosNum(i);
				accountDD.setDate(transDate);
				accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // �̳����յĳֲ�
				accountDD.setCashValue(accountDD_pre.getCashValue());	// �̳����յ��ֽ�
				
				// ��鵱ǰ�ֲֵĹ�Ʊ����״�����Ⱦ����Ƿ������������³ֲֹ�Ʊ�����ɳֲּ۸�
				List stockHoldList=accountDD.getStockHoldList();
				int stockHoldSize=stockHoldList.size();
				for (int j=stockHoldSize-1; j>=0; j--)
				{
					// ȡ��һ���ֹɶ���
					StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
					
					// ��ô˳ֹɵ���ʷ����
					String stockcode=shs.getCode();
					List stockDataRecordList=(List)stockDataMap.get(stockcode);
					
					// ȡ���˹�ǰ���������
					StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
					StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
					StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
					
					
					if (sdd==null || sdd_b1==null || sdd_b2==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
					{
						shs.setCurDate(transDate);
						continue;
					}
					
					TransactionRecordData trd=new TransactionRecordData();
					StockDayData buySDD=shs.getBuySDD();
					
					
					double macd_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
					
					// ��ȡǰ���������
					List pastStockList3=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 3);
					List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
					List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10); 
					List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
					List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
					
	//				sdd_b1=(StockDayData)pastStockList.get(1);   // ��������ȡ��
							
	//				System.out.println(i);
					
					
// *****************************  �жϴ˹ɵ�ǰ���ƣ������Ƿ�����  *****************************  

					if ( 
					i==dateList.size()-2     // ���˽��׶��е����һ�죬������
//					|| calculatePriceGapRatio(sdd.getClose(), sdd.getMa_5())>0.06
//					|| !checkPastDaysMACDTrends_NDBL_UP(pastStockList3, 1)
					|| (1>0
					&& sdd.getClose()<sdd.getMa_20()
					&& sdd.getDate().substring(0, 10).compareTo(buySDD.getDate().substring(0,10))>0  // ����ڶ���������
//					&& sdd.getDate().endsWith("001")   // ��������
//					&& sdd.getClose_rise()<0    // ����
//					&& sdd.getClose()<sdd.getMa_20() 		// ������20��������
//					&& (sdd_b1.getHigh()+sdd_b1.getLow())/2<sdd_b1.getMa_20() // ���۵���20�վ���
//					&& sdd.getHigh()<sdd.getMa_20()  // �����������20�վ���
//					&& (sdd_b1.getHigh()+sdd_b1.getLow())/2>(sdd.getHigh()+sdd.getLow())/2// ����תΪ����
//					&& (sdd.getHigh()+sdd.getLow())/2<sdd.getMa_5() // ���۵���5�վ���
//					&& sdd.getMa_macd()<=sdd_b1.getMa_macd() && sdd_b1.getMa_macd()<=sdd_b2.getMa_macd()  // ��������MACD�µ�
					)	 // macd ����������	
//					||(sdd.getHigh()>sdd.getMa_20()) 	// �����ϳ嵽20�վ����ϣ���ֹӯ���� 
					
					)
					{
						
						isStockSaleDay=true;  // ����������������������Ϊ�����ձ�־
						
						// ������CCI����ָ��
	//					TransactionRecordData trd=new TransactionRecordData();
	//					StockDayData buySDD=shs.getBuySDD();
						trd.setStockcode(sdd.getCode());
						trd.setBuySDD(buySDD);
						trd.setSaleSDD(sdd);
						
						// ������� - �������򣬿����׼���profit
						double transactionProfit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getClose())/trd.getBuySDD().getClose())*100-0.2;
						trd.setTransactionProfit(transactionProfit);
						
						accountDD.saleTransList.add(trd);
						
						if(lastSalePrice==10000 || sdd.getClose()>lastSalePrice)
						{
							lastSalePrice=sdd.getClose(); // ��¼��һ������ʱ�ļ۸�
						}
						
						// ����accountDD�ֲ��б�
						accountDD.stockHoldList.remove(j);
						
						// ����accountDD�ֽ��ֵ
						int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
						int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
						accountDD.setCashValue(newCashValue);
						accountDD.setStockValue(newStockValue);
						
						
					}
					else
					{
						// �粻�������ͼ������в��䣬���³ֲּ۸�
						shs.setCurDate(transDate);
						shs.setCurPrice(sdd.getClose());	
					}
					
				}
				
				
				// ����Ʊ���ﱸѡ�Ĺ�Ʊ����������پ����Ƿ����룬�����³ֲֹ�Ʊ
				Iterator it=stockDataMap.keySet().iterator();
				while(it.hasNext())
				{
					
					// �ӱ�ѡ��Ʊ����ȡ��һֻ��Ʊ
					String stockcode=it.next().toString();  
					List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
					if (checkStockHoldList(stockHoldList, stockcode)==true || isStockSaleDay)  // ����Ѿ��ֹɣ����ߵ����������գ�������������
					{
						continue;
					}
					
					// ȡ���˹�ǰ���������
					StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
					StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
					StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
					StockDayData sdd_b3=CommonTool.getStockDayData(stockDataRecordList, transDate, -3);
	//				StockDayData sdd_b4=CommonTool.getStockDayData(stockDataRecordList, transDate, -4);
	//				StockDayData sdd_b5=CommonTool.getStockDayData(stockDataRecordList, transDate, -5);
	//				StockDayData sdd_b6=CommonTool.getStockDayData(stockDataRecordList, transDate, -6);
	//				StockDayData sdd_b7=CommonTool.getStockDayData(stockDataRecordList, transDate, -7);
	//				StockDayData sdd_b8=CommonTool.getStockDayData(stockDataRecordList, transDate, -8);
	//				StockDayData sdd_b9=CommonTool.getStockDayData(stockDataRecordList, transDate, -9);
					
					
	//				if (sdd!=null && sdd_b1!=null)
	//				{
	//					System.out.println(sdd_b1.getName()+" "+sdd_b1.getCode()+" "+sdd_b1.getDate()+" "+sdd_b1.getClose());
	//					System.out.println(sdd.getName()+" "+sdd.getCode()+" "+sdd.getDate()+" "+sdd.getClose());
	//				}
					
					if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null)
					{
						continue;
					}
					
	//				if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null || sdd_b4==null || sdd_b5==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
	//				{
	//					continue;
	//				}
	//				
	//				if (sdd_b6==null || sdd_b7==null || sdd_b8==null || sdd_b9==null)
	//				{
	//					continue;
	//				}
	//				
	//				if (sdd_b10==null || sdd_b11==null || sdd_b12==null || sdd_b13==null || sdd_b14==null || sdd_b15==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
	//				{
	//					continue;
	//				}
					
					// ��ȡǰ���������
					List pastStockList2=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 2); 
					List pastStockList3=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 3);  
					List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
					List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);
					List pastStockList15=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 15);
					List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
					List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
					List pastStockList100=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 100);
					List pastStockList150=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 150);
	//				String dateb1=sdd_b1.getDate();   // debug����
	//				System.out.println(dateb1);
					
					
// *****************************  �жϴ˹ɵ�ǰ���ƣ������Ƿ�����  *****************************  
					
					if ( 
						1>0
						&& sdd.getClose_rise()>1 // �Ƿ�����1�͸�������
						&& sdd.getReal_rise()>1  // �����Ƿ�>1
						&& sdd.getClose()>sdd.getMa_5() && sdd.getMa_5()>sdd.getMa_10()
//						calculatePriceGapRatio(sdd_b1.getClose(), sdd_b1.getMa_5())<0.04  //ǰһ������̼���ma5�ϣ������ܽ�
//						&& sdd_b1.getSwing()<7    // ǰһ��û��̫��ƫ��5����
//						&& sdd_b1.getReal_rise()>0		 // ǰһ��������
//						&& sdd_b1.getClose()>sdd_b1.getMa_5()  //  ǰһ����������5�վ�����
//						&& sdd_b1.getClose()>sdd_b1.getMa_10()  //  ǰһ����������20�վ�����
//						&& sdd.getClose()>sdd.getMa_20()
//						&& sdd_b1.getMa_5()>sdd_b1.getMa_60()  //  MA5>ma60
//						&& checkDayData_MA_dtpl(sdd_b1)    // ��ȥ1�ճʶ�ͷ��������
//						&& checkPastDaysHighPrice(sdd_b1, stockDataRecordList, sdd_b1.getPosNum(), 500)
//						&& !(sdd_b1.getMa_60()>sdd_b1.getMa_5() && sdd_b1.getMa_60()>sdd_b1.getMa_10() && sdd_b1.getMa_60()>sdd_b1.getMa_20())
//						&& checkPastDaysMACDTrends_UP(pastStockList3, 0)	 // macd ����������
//						&& sdd_b6.getMa_5()>sdd_b6.getMa_60()     // �ǳ���Ҫ��һ����������׼ȷ������������̬	
//						&& checkPastDaysMACDTrends_MA20(pastStockList5, 5)
//						&& checkPastDaysMACDTrends_MA10(pastStockList5, 5)
						
						)
					{
						
						
						// �����ֶ�ͷ���У������룬����¼���뽻��
						TransactionRecordData trd=new TransactionRecordData();
						trd.setBuySDD(sdd);
						accountDD.buyTransList.add(trd);
						
						// ����accountDD�ֲ��б�
						StockHoldShare shs=new StockHoldShare();
						
						// ����������Ʊ����
	//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
	//					int amount=0;
	//					if (accountDD.cashValue>eachStockInvestMoney)
	//					{
	//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // ʣ���ֽ��㹻Ͷ��һ�ݵ�ǰ��Ʊ
	//					}
	//					else
	//					{
	//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ𲻹�Ͷ��һ�ݵ�ǰ��Ʊ����ȫ������
	//					}
						
						int amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ�ȫ������
						
						// ���������ĳֲֹ�Ʊ
						shs.setAmount(amount);
						shs.setCode(sdd.getCode());
						shs.setName(sdd.getName());
						shs.setBuyPrice(sdd.getOpen());
						shs.setBuyDate(sdd.getDate());
						shs.setCurPrice(sdd.getClose());
						shs.setCurDate(sdd.getDate());
						shs.setBuySDD(sdd);
						stockHoldList.add(shs);
						
						// ����accountDD�ֽ��ֵ
						int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
						int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
						accountDD.setCashValue(newCashValue);
						accountDD.setStockValue(newStockValue);
						
					}
					else
					{
						
						// ���δ���ϼ������ǣ����Ǽ����µ��ˣ�WR100�ؼ�������80���ϣ���˵�������ѻ������ܼ����ùɼ۽����ķ�����
						// Ҫ�ȴ�WR100�ٴλص�20�����ٴη���һ���µ�����
						if (sdd.getWR100()>80)   
						{
	//						System.out.println("SDD WR: "+sdd.getDate()+"  "+sdd.getWR100());
							lastSalePrice=10000;  
						}
						
					}
					
				}
				
				// ���¸����˻���ÿ���˻���Ϣ
				Map accountDataMap=psa.getAccountDataMap();
				accountDataMap.put(transDate, accountDD);
				accountDD_pre=accountDD;
				
			}
			
			// ���Ͷ�ʽ��׼�¼��ģ�⽻�׽��仯���ߣ��Ա��������ײ���
			String modelName="Ͷ�����_׷��ӯ��_Minute30";
			List transactionDataList=generateTransactionDataListFromPSA(psa);
			String reportLine=outputTransactionRecordReport(transactionDataList, modelName);
			// code name date_c saledate year days buy_price sale_price profit 
			
	//		outputAccountRecordReport(psa); // ���account��ÿ��Ͷ�����ݣ��۸�仯���ֽ��ֵ/�ܼ�ֵ  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
			
	//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
	//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, �׷������� 
			
			ModelEvaluationReport mer=new ModelEvaluationReport();
			mer.setTransactionDataList(transactionDataList);
			mer.setReportLine(reportLine);
			mer.setModelName(modelName);
			
			return mer;
		}
		
		
		// ģ��Ͷ�� - zzpm ׷������ minute ָ�����
		public ModelEvaluationReport processInvestmentByStrategy_zzpm_minute(Map stockDataMap, String startDate, String endDate)
		{
			
			// ����һ������ģ���˻�
			PersonalStockAccount psa=new PersonalStockAccount();
			
			List dateList=CommonTool.generateTimeReferenceList(startDate, endDate, dateType);
			
			// ���������accountDD_pre
	 		AccountDayData accountDD_pre=new AccountDayData();  
			accountDD_pre.setCashValue(psa.investMoney);
			
			double lastSalePrice=10000;  // ��һ���׳�ʱ�ļ۸�, ��ʼֵ10000
			String lastSaleDate="";
			boolean isMACDChanged=false;   // ��һ���׳�������MACD 5>60�������Ƿ�ı�
			boolean isStockSaleDay=false;
			
			// ģ��ÿ�������ս���
			for (int i=0; i<dateList.size(); i++)
			{
				
				// ȡ��һ����������
				String transDate=dateList.get(i).toString();
				isStockSaleDay=false;  // ��Ĭ�ϲ��ǹ�Ʊ������
				
				// ����һ�����յĽ����˻�����accountDD�����̳����յĳֲֺ��ֽ�
				AccountDayData accountDD=new AccountDayData();
				accountDD.setPosNum(i);
				accountDD.setDate(transDate);
				accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // �̳����յĳֲ�
				accountDD.setCashValue(accountDD_pre.getCashValue());	// �̳����յ��ֽ�
				
				// ��鵱ǰ�ֲֵĹ�Ʊ����״�����Ⱦ����Ƿ������������³ֲֹ�Ʊ�����ɳֲּ۸�
				List stockHoldList=accountDD.getStockHoldList();
				int stockHoldSize=stockHoldList.size();
				for (int j=stockHoldSize-1; j>=0; j--)
				{
					// ȡ��һ���ֹɶ���
					StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
					
					// ��ô˳ֹɵ���ʷ����
					String stockcode=shs.getCode();
					List stockDataRecordList=(List)stockDataMap.get(stockcode);
					
					// ȡ���˹�ǰ���������
					StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
					StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
					StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
					
					
					if (sdd==null || sdd_b1==null || sdd_b2==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
					{
						shs.setCurDate(transDate);
						continue;
					}
					
					TransactionRecordData trd=new TransactionRecordData();
					StockDayData buySDD=shs.getBuySDD();
					
					
					double macd_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
					
					// ��ȡǰ���������
					List pastStockList3=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 3);
					List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
					List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10); 
					List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
					List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
					
	//				sdd_b1=(StockDayData)pastStockList.get(1);   // ��������ȡ��
							
	//				System.out.println(i);
					
					
// *****************************  �жϴ˹ɵ�ǰ���ƣ������Ƿ�����  *****************************  

					if ( 
					i==dateList.size()-2     // ���˽��׶��е����һ�죬������
//					|| calculatePriceGapRatio(sdd.getClose(), sdd.getMa_5())>0.06
//					|| !checkPastDaysMACDTrends_NDBL_UP(pastStockList3, 1)
					|| (1>0
//					&& sdd.getClose()<sdd.getMa_20()
					&& sdd.getDate().substring(0, 10).compareTo(buySDD.getDate().substring(0,10))>0  // �ڶ��쿪��������
//					&& sdd.getDate().endsWith("001")   // ��������
//					&& sdd.getClose_rise()<0    // ����
//					&& sdd.getClose()<sdd.getMa_20() 		// ������20��������
//					&& (sdd_b1.getHigh()+sdd_b1.getLow())/2<sdd_b1.getMa_20() // ���۵���20�վ���
//					&& sdd.getHigh()<sdd.getMa_20()  // �����������20�վ���
//					&& (sdd_b1.getHigh()+sdd_b1.getLow())/2>(sdd.getHigh()+sdd.getLow())/2// ����תΪ����
//					&& (sdd.getHigh()+sdd.getLow())/2<sdd.getMa_5() // ���۵���5�վ���
//					&& sdd.getMa_macd()<=sdd_b1.getMa_macd() && sdd_b1.getMa_macd()<=sdd_b2.getMa_macd()  // ��������MACD�µ�
					)	 // macd ����������	
//					||(sdd.getHigh()>sdd.getMa_20()) 	// �����ϳ嵽20�վ����ϣ���ֹӯ���� 
					
					)
					{
						
						isStockSaleDay=true;  // ����������������������Ϊ�����ձ�־
						
						// ������CCI����ָ��
	//					TransactionRecordData trd=new TransactionRecordData();
	//					StockDayData buySDD=shs.getBuySDD();
						trd.setStockcode(sdd.getCode());
						trd.setBuySDD(buySDD);
						trd.setSaleSDD(sdd);
						
						// ������� - �������򣬿����׼���profit
						double transactionProfit=0;
						if (sdd.getOpen()<sdd.getMa_10())    // ���̵��� ma10�����ף�����ȸ�sdd������
						{
							transactionProfit=((trd.getSaleSDD().getOpen()-trd.getBuySDD().getOpen())/trd.getBuySDD().getOpen())*100-0.2;
						}
						else
						{
							transactionProfit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getOpen())/trd.getBuySDD().getOpen())*100-0.2;
						}
						trd.setTransactionProfit(transactionProfit);
						
						accountDD.saleTransList.add(trd);
						
						if(lastSalePrice==10000 || sdd.getClose()>lastSalePrice)
						{
							lastSalePrice=sdd.getClose(); // ��¼��һ������ʱ�ļ۸�
						}
						
						// ����accountDD�ֲ��б�
						accountDD.stockHoldList.remove(j);
						
						// ����accountDD�ֽ��ֵ
						int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
						int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
						accountDD.setCashValue(newCashValue);
						accountDD.setStockValue(newStockValue);
						
						
					}
					else
					{
						// �粻�������ͼ������в��䣬���³ֲּ۸�
						shs.setCurDate(transDate);
						shs.setCurPrice(sdd.getClose());	
					}
					
				}
				
				
				// ����Ʊ���ﱸѡ�Ĺ�Ʊ����������پ����Ƿ����룬�����³ֲֹ�Ʊ
				Iterator it=stockDataMap.keySet().iterator();
				while(it.hasNext())
				{
					
					// �ӱ�ѡ��Ʊ����ȡ��һֻ��Ʊ
					String stockcode=it.next().toString();  
					List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
					if (checkStockHoldList(stockHoldList, stockcode)==true || isStockSaleDay)  // ����Ѿ��ֹɣ����ߵ����������գ�������������
					{
						continue;
					}
					
					// ȡ���˹�ǰ���������
					StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
					StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
					StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
					StockDayData sdd_b3=CommonTool.getStockDayData(stockDataRecordList, transDate, -3);
	//				StockDayData sdd_b4=CommonTool.getStockDayData(stockDataRecordList, transDate, -4);
	//				StockDayData sdd_b5=CommonTool.getStockDayData(stockDataRecordList, transDate, -5);
	//				StockDayData sdd_b6=CommonTool.getStockDayData(stockDataRecordList, transDate, -6);
	//				StockDayData sdd_b7=CommonTool.getStockDayData(stockDataRecordList, transDate, -7);
	//				StockDayData sdd_b8=CommonTool.getStockDayData(stockDataRecordList, transDate, -8);
	//				StockDayData sdd_b9=CommonTool.getStockDayData(stockDataRecordList, transDate, -9);
					
					
	//				if (sdd!=null && sdd_b1!=null)
	//				{
	//					System.out.println(sdd_b1.getName()+" "+sdd_b1.getCode()+" "+sdd_b1.getDate()+" "+sdd_b1.getClose());
	//					System.out.println(sdd.getName()+" "+sdd.getCode()+" "+sdd.getDate()+" "+sdd.getClose());
	//				}
					
					if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null)
					{
						continue;
					}
					
	//				if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null || sdd_b4==null || sdd_b5==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
	//				{
	//					continue;
	//				}
	//				
	//				if (sdd_b6==null || sdd_b7==null || sdd_b8==null || sdd_b9==null)
	//				{
	//					continue;
	//				}
	//				
	//				if (sdd_b10==null || sdd_b11==null || sdd_b12==null || sdd_b13==null || sdd_b14==null || sdd_b15==null) // ����ͣ�ƣ�û�н��׼�¼�����¼�������ڼ�֮ǰ�ļ۸�
	//				{
	//					continue;
	//				}
					
					// ��ȡǰ���������
					List pastStockList2=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 2); 
					List pastStockList3=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 3);  
					List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
					List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);
					List pastStockList15=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 15);
					List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
					List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
					List pastStockList100=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 100);
					List pastStockList150=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 150);
	//				String dateb1=sdd_b1.getDate();   // debug����
	//				System.out.println(dateb1);
					
					
// *****************************  �жϴ˹ɵ�ǰ���ƣ������Ƿ�����  *****************************  
					
					if ( 
						1>0
//						&& sdd_b1.getDate().endsWith("001")
						&& sdd_b1.getRise_speed_rank()<=1  // ����������һ
//						&& sdd_b1.getClose_rise()>0.5 // ���Ƿ�����0.5%
						&& sdd_b1.getReal_rise()>1  // �����Ƿ�����1
						&& sdd_b1.getClose()>sdd_b1.getMa_5() && sdd_b1.getMa_5()>sdd_b1.getMa_10()
//						calculatePriceGapRatio(sdd_b1.getClose(), sdd_b1.getMa_5())<0.04  //ǰһ������̼���ma5�ϣ������ܽ�
//						&& sdd_b1.getSwing()<7    // ǰһ��û��̫��ƫ��5����
//						&& sdd_b1.getReal_rise()>0		 // ǰһ��������
//						&& sdd_b1.getClose()>sdd_b1.getMa_5()  //  ǰһ����������5�վ�����
//						&& sdd_b1.getClose()>sdd_b1.getMa_10()  //  ǰһ����������20�վ�����
//						&& sdd.getClose()>sdd.getMa_20()
//						&& sdd_b1.getMa_5()>sdd_b1.getMa_60()  //  MA5>ma60
//						&& checkDayData_MA_dtpl(sdd_b1)    // ��ȥ1�ճʶ�ͷ��������
//						&& checkPastDaysHighPrice(sdd_b1, stockDataRecordList, sdd_b1.getPosNum(), 500)
//						&& !(sdd_b1.getMa_60()>sdd_b1.getMa_5() && sdd_b1.getMa_60()>sdd_b1.getMa_10() && sdd_b1.getMa_60()>sdd_b1.getMa_20())
//						&& checkPastDaysMACDTrends_UP(pastStockList3, 0)	 // macd ����������
//						&& sdd_b6.getMa_5()>sdd_b6.getMa_60()     // �ǳ���Ҫ��һ����������׼ȷ������������̬	
//						&& checkPastDaysMACDTrends_MA20(pastStockList5, 5)
//						&& checkPastDaysMACDTrends_MA10(pastStockList5, 5)
						
						)
					{
						
						
						// �����ֶ�ͷ���У������룬����¼���뽻��
						TransactionRecordData trd=new TransactionRecordData();
						trd.setBuySDD(sdd);
						accountDD.buyTransList.add(trd);
						
						// ����accountDD�ֲ��б�
						StockHoldShare shs=new StockHoldShare();
						
						// ����������Ʊ����
	//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
	//					int amount=0;
	//					if (accountDD.cashValue>eachStockInvestMoney)
	//					{
	//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // ʣ���ֽ��㹻Ͷ��һ�ݵ�ǰ��Ʊ
	//					}
	//					else
	//					{
	//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ𲻹�Ͷ��һ�ݵ�ǰ��Ʊ����ȫ������
	//					}
						
						int amount=(int)(accountDD.cashValue/sdd.getOpen());   // ʣ���ֽ�ȫ������
						
						// ���������ĳֲֹ�Ʊ
						shs.setAmount(amount);
						shs.setCode(sdd.getCode());
						shs.setName(sdd.getName());
						shs.setBuyPrice(sdd.getOpen());
						shs.setBuyDate(sdd.getDate());
						shs.setCurPrice(sdd.getClose());
						shs.setCurDate(sdd.getDate());
						shs.setBuySDD(sdd);
						stockHoldList.add(shs);
						
						// ����accountDD�ֽ��ֵ
						int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
						int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
						accountDD.setCashValue(newCashValue);
						accountDD.setStockValue(newStockValue);
						
					}
					else
					{
						
						// ���δ���ϼ������ǣ����Ǽ����µ��ˣ�WR100�ؼ�������80���ϣ���˵�������ѻ������ܼ����ùɼ۽����ķ�����
						// Ҫ�ȴ�WR100�ٴλص�20�����ٴη���һ���µ�����
						if (sdd.getWR100()>80)   
						{
	//						System.out.println("SDD WR: "+sdd.getDate()+"  "+sdd.getWR100());
							lastSalePrice=10000;  
						}
						
					}
					
				}
				
				// ���¸����˻���ÿ���˻���Ϣ
				Map accountDataMap=psa.getAccountDataMap();
				accountDataMap.put(transDate, accountDD);
				accountDD_pre=accountDD;
				
			}
			
			// ���Ͷ�ʽ��׼�¼��ģ�⽻�׽��仯���ߣ��Ա��������ײ���
			String modelName="Ͷ�����_��������_Minute15";
			List transactionDataList=generateTransactionDataListFromPSA(psa);
			String reportLine=outputTransactionRecordReport(transactionDataList, modelName);
			// code name date_c saledate year days buy_price sale_price profit 
			
	//		outputAccountRecordReport(psa); // ���account��ÿ��Ͷ�����ݣ��۸�仯���ֽ��ֵ/�ܼ�ֵ  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
			
	//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
	//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, �׷������� 
			
			ModelEvaluationReport mer=new ModelEvaluationReport();
			mer.setTransactionDataList(transactionDataList);
			mer.setReportLine(reportLine);
			mer.setModelName(modelName);
			
			return mer;
		}	
		
		
}
