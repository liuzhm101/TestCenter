package com.finance.stock.gui;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

import com.finance.stock.data.*;


public class ModelCenter {

	String stockAllDataFull="C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode\\StockAllDataFull";
	String fundAllDataFull="C:\\Users\\scnzli\\Documents\\MyWork\\Finance\\MySASCode\\FundAllDataFull";
	String stockFileFolder=stockAllDataFull+"\\all";  // 原模型及数据所在目录
	String stockSecondFileFolder=stockAllDataFull+"\\each";
	
	String dateType="";  // stock 数据研究类型
	
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
			System.out.println("Total time: "+time+"秒");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public void analyzeDataByModel()
	{
		
		// 读取全部指数数据
//		stockIndexMap=CommonTool.getAllStockIndexDataMap();  // 结构 (type, indexDataList)
		
		// 调取历史整体市场数据
//		marketDataRecordMap=CommonTool.loadMarketDataRecordMap("all");
		
		// 读取全部股票代码
		System.out.println("Read all stock code list.");
		String stockCodeListFile="stockcodelist";
		ResultSet rs=CommonTool.readDataFromSASDataSet(stockAllDataFull, stockCodeListFile);
		List stockCodeList=CommonTool.getColumnDataList(rs, "stockcode");
		
		// 对股票代码按规则进行选取
		List researchStockCodeList=new ArrayList();
		
		// 全部选股
		researchStockCodeList=stockCodeList; 	// 选全部股票作为研究样本
		
		// 按板块选股
//		researchStockCodeList=CommonTool.getAllStock_600(stockCodeList);  // 按600板块选股
//		researchStockCodeList=CommonTool.getAllStock_300(stockCodeList);  // 按300板块选股
//		researchStockCodeList=CommonTool.getAllStock_000(stockCodeList);  // 按000板块选股
//		researchStockCodeList=CommonTool.getAllStock_002(stockCodeList);  // 按002板块选股
		
		// 随机选股
//		researchStockCodeList=CommonTool.getAllStock_Random(stockCodeList, 100);    // 全部股票随机选股n个
//		researchStockCodeList=CommonTool.getAllStock_Random(researchStockCodeList, 500);  // 某个板块随机选股n个
//		researchStockCodeList=CommonTool.getAllStock_ByOrderNo(researchStockCodeList, 0, 10);
//		researchStockCodeList=CommonTool.getAllStock_ByMarketValue(researchStockCodeList, 50, "top");
		
		// 指定选股
//		researchStockCodeList.add("sh600516");  // 方大碳素
//		researchStockCodeList.add("sh600698");  // 湖南天雁
//		researchStockCodeList.add("sz300676");  // 华大基因
//		researchStockCodeList.add("sh600519");  // 贵州茅台
//		researchStockCodeList.add("sz000651");  // 格力电器
//		researchStockCodeList.add("sh601318");  // 中国平安
//		researchStockCodeList.add("sz002230");  // 科大讯飞
//		researchStockCodeList.add("sh601313");  // 江南嘉捷
//		researchStockCodeList.add("sh600530");  // 交大昂立
//		researchStockCodeList.add("sz000858");  // 五粮液
//		researchStockCodeList.add("sh600903");  // 贵州燃气
//		researchStockCodeList.add("sz000877");  // 天山股份
//		researchStockCodeList.add("sh601111");  // 中国国航
//		researchStockCodeList.add("sh600036");  // 招商银行
//		researchStockCodeList.add("sh601398");  // 工商银行
//		researchStockCodeList.add("sh600104");  // 上汽集团
//		researchStockCodeList.add("sh600547");  // 山东黄金
//		researchStockCodeList.add("sh600887");  // 伊利股份
//		researchStockCodeList.add("sz002751");  // 易尚展示
//		researchStockCodeList.add("sh600097");  // 开创国际
//		researchStockCodeList.add("sz002330");  // 得利斯
//		researchStockCodeList.add("sh600848");  // 上海临港
//		researchStockCodeList.add("sh601857");  // 中国石油
//		researchStockCodeList.add("sz000700");  // 模塑科技
//		researchStockCodeList.add("sz002239");  // 奥特佳
//		researchStockCodeList.add("sz002328");  // 新朋股份
//		researchStockCodeList.add("sz002838");  // 道恩股份
//		researchStockCodeList.add("sz002481");  // 双塔食品
		
		
//		researchStockCodeList.add("index510050");  // 50ETF
//		researchStockCodeList.add("index510500");  // 500ETF	
//		researchStockCodeList.add("index510300");  // 300ETF

//		researchStockCodeList.add("index159949");  // 创业板50		
//		researchStockCodeList.add("index159915");  // 创业板
//		researchStockCodeList.add("index159902");  // 中小板

		
		
		// 按照模型对所选股票的历史交易记录进行分析并输出结果
//		processStockByModel_dtplgj(researchStockCodeList,  "2008/01/01", "2020/12/01");  // 多头排列改进模型
		
//		processStockByModel_cmwd(researchStockCodeList,  "2010/01/01", "2017/12/01");  // 筹码稳定模型
		
//		processStockByModel_dztd(researchStockCodeList, "2010/01/01", "2020/12/01");	 // 单针探底模型		
		
//		processStockByModel_wjz(researchStockCodeList, "2016/01/01", "2019/12/01");		 // 王佳忠选股
//		processStockByModel_wjzgj(researchStockCodeList, "2016/01/01", "2018/01/01");	 // 王佳忠选股改进模型
		
//		processStockByModel_macdgj(researchStockCodeList,  "2000/01/01", "2019/12/01");  // macd改进模型
		
//		processStockByModel_yg(researchStockCodeList, "2010/01/01", "2020/12/30");	  	 // 妖股模型
//		processStockByModel_ygtp(researchStockCodeList, "2016/01/01", "2020/12/30");	 // 妖股突破模型
//		processStockByModel_yggj(researchStockCodeList, "2015/01/01", "2018/02/15");	 // 妖股改进模型
//		processStockByModel_ygsb(researchStockCodeList, "2014/01/01", "2019/12/31");	 // 妖股双板模型
//		processStockByModel_yghdy(researchStockCodeList, "2015/01/01", "2018/01/12");	 // 妖股后大阳模型
		
//		processStockByModel_ztb(researchStockCodeList, "2017/12/15", "2018/01/06");		 // 涨停板
//		processStockByModel_ztbyj(researchStockCodeList, "2017/11/01", "2018/02/01");	 // 涨停板研究
//		processStockByModel_slb(researchStockCodeList, "2016/01/04", "2018/02/01");		 // 涨停三连板研究  
		
//		processStockByModel_lztp(researchStockCodeList);	 							 // 连涨突破模型
//		processStockByModel_lzgs(researchStockCodeList);	 							 // 连涨跟随模型
//		processStockByModel_hptp(researchStockCodeList, "2017/01/01", "2018/01/26");  	 // 横盘突破模型		
//		processStockByModel_tztp(researchStockCodeList, "2017/01/01", "2019/01/01");  	 // 调整突破模型	
//		processStockByModel_ztdb(researchStockCodeList, "2013/01/01", "2020/12/31");  	 // 涨停对比模型	
//		processStockByModel_zddb5(researchStockCodeList, "2015/01/01", "2015/12/31");  	 // 涨跌5%对比模型	
		
//		processStockByModel_syft(researchStockCodeList);	 							 // 上影反弹模型
//		processStockByModel_zxsz(researchStockCodeList, 2000, 2017);  					 // 最小市值
//		processStockByModel_zfpm(researchStockCodeList, "2017/10/01", "2017/12/01", 0);  // 涨幅排名
//		processStockByModel_kpqzt(researchStockCodeList, "2017/01/03", "2017/01/31");    // 开盘抢涨停
//		processStockByModel_wrjx(researchStockCodeList);  								 // 五日均线模型

//		processStockByModel_dzzh(researchStockCodeList, "2017/01/01", "2018/01/13");	 // 大涨之后模型
//		processStockByModel_bkzj(researchStockCodeList, "2016/01/01", "2018/01/13");	 // 被困资金模型
		
//		processStockByModel_macd_ddz(researchStockCodeList, "2010/01/01", "2018/06/30");    // MACD DDZ模型
//		processStockByModel_macd_zth(researchStockCodeList, "2010/01/01", "2018/04/05");	// MACD_ZTH模型
//		processStockByModel_macd_zdd(researchStockCodeList, "2015/01/01", "2018/06/30");    // MACD ZDD 最低点模型
//		processStockByModel_macd_dbl(researchStockCodeList, "2010/01/01", "2018/06/30");    // MACD DBL 底背离模型
//		processStockByModel_macd_trend(researchStockCodeList, "2017/12/01", "2018/01/16");  // MACD 趋势模型
		
//		processStockByModel_fundselect();   												// 基金选股
//		processStockByModel_beststock(researchStockCodeList, "2010/01/01", "2018/02/23");	// 最佳股票
		
		
		
		// 按照投资策略模拟输出历史交易记录及结果比对
//		List stockPoolCodeList=getStockPoolCodeList(researchStockCodeList);  // 获得初步备选选股池
//		List stockPoolCodeList=getStockPoolCodeListByStable(researchStockCodeList);  // 根据稳定性获得初步备选选股池
		

		List stockPoolCodeList=new ArrayList();

		// 个股
//		stockPoolCodeList.add("sh600519");	// 贵州茅台
//		stockPoolCodeList.add("sz000858");  // 五粮液
//		stockPoolCodeList.add("sz002304");  // 洋河股份
//		stockPoolCodeList.add("sh601111");  // 中国国航
//		stockPoolCodeList.add("sh600036");  // 招商银行
//		stockPoolCodeList.add("sz000651");  // 格力电器
//		stockPoolCodeList.add("sh601318");  // 中国平安
//		stockPoolCodeList.add("sh600000");  // 浦发银行
//		stockPoolCodeList.add("sh601668");  // 中国建筑
//		stockPoolCodeList.add("sh601766");  // 中国中车
//		stockPoolCodeList.add("sh601857");  // 中国石油
//		stockPoolCodeList.add("sh600383");  // 金地集团
//		stockPoolCodeList.add("sz002751");  // 易尚展示
//		stockPoolCodeList.add("sh600097");  // 开创国际
//		stockPoolCodeList.add("sz002330");  // 得利斯
//		stockPoolCodeList.add("sh600848");  // 上海临港
//		stockPoolCodeList.add("sz000700");  // 模塑科技
//		stockPoolCodeList.add("sz002239");  // 奥特佳
//		stockPoolCodeList.add("sz002328");  // 新朋股份
//		stockPoolCodeList.add("sz002838");  // 道恩股份
//		stockPoolCodeList.add("sz002481");  // 双塔食品
		
		// ETF
//		stockPoolCodeList.add("index510050");  // 50ETF
//		stockPoolCodeList.add("index510500");  // 500ETF	
//		stockPoolCodeList.add("index510300");  // 300ETF
//		stockPoolCodeList.add("index159949");  // 创业板50		
//		stockPoolCodeList.add("index159915");  // 创业板
//		stockPoolCodeList.add("index159902");  // 中小板
		
		// 板块
//		stockPoolCodeList.add("index880380");  // 酿酒板块
//		stockPoolCodeList.add("index880471");  // 银行板块
//		stockPoolCodeList.add("index880472");  // 证券板块
//		stockPoolCodeList.add("index880473");  // 保险板块
//		stockPoolCodeList.add("index880398");  // 医疗板块
//		stockPoolCodeList.add("index880400");  // 医药板块
//		stockPoolCodeList.add("index880324");  // 有色板块
//		stockPoolCodeList.add("index880301");  // 煤炭板块
//		stockPoolCodeList.add("index880318");  // 钢铁板块
//		stockPoolCodeList.add("index880310");  // 石油板块
//		stockPoolCodeList.add("index880494");  // 互联网板块
//		stockPoolCodeList.add("index880464");  // 仓储物流板块
		
		
		// ETF分时线
//		stockPoolCodeList.add("minute510050");	// 50ETF分时
//		stockPoolCodeList.add("minute510500");  // 500ETF分时
//		stockPoolCodeList.add("minute510300");	// 300ETF分时
//		stockPoolCodeList.add("minute159915");	// 创业板分时
//		stockPoolCodeList.add("minute515050");  // "5GETF分时"
//		stockPoolCodeList.add("minute512690");  // "酒ETF分时"
//		stockPoolCodeList.add("minute512010");  // "医药ETF分时"
//		stockPoolCodeList.add("minute512880");  // "证券ETF分时"
//		stockPoolCodeList.add("minute512800");  // "银行ETF分时"
		 
		
		// 龙头股分时线
//		stockPoolCodeList.add("minute600519"); //"贵州茅台分时"
//		stockPoolCodeList.add("minute600036"); //"招商银行分时"
//		stockPoolCodeList.add("minute000858"); //"五粮液分时"
//		stockPoolCodeList.add("minute603259"); //"药明康德分时"
//		stockPoolCodeList.add("minute000725"); //"京东方Ａ分时"
//		stockPoolCodeList.add("minute600760"); //"中航沈飞分时"
//		stockPoolCodeList.add("minute600309"); //"万华化学分时"
//		stockPoolCodeList.add("minute601111"); //"中国国航分时"
//		stockPoolCodeList.add("minute601766"); //"中国中车"
//		stockPoolCodeList.add("minute601857"); //"中国石油"
//		stockPoolCodeList.add("minute601012"); //"隆基股份"
		

		
		// 绩差股，普通股，妖股
//		stockPoolCodeList.add("601111");  // 中国国航
//		stockPoolCodeList.add("601857");  // 中国石油
//		stockPoolCodeList.add("601766");  // 中国中车
//		stockPoolCodeList.add("000651");  // 格力电器
//		stockPoolCodeList.add("600097");  // 开创国际
//		stockPoolCodeList.add("002330");  // 得利斯
//		stockPoolCodeList.add("600848");  // 上海临港
//		stockPoolCodeList.add("000700");  // 模塑科技
		
		// 大牛股
//		stockPoolCodeList.add("600519");  // 贵州茅台
//		stockPoolCodeList.add("000858");  // 五粮液
//		stockPoolCodeList.add("000333");  // 美的集团
//		stockPoolCodeList.add("000002");  // 万科A
//		stockPoolCodeList.add("000568");  // 泸州老窖
//		stockPoolCodeList.add("600036");  // 招商银行
//		stockPoolCodeList.add("601318");  // 中国平安
//		stockPoolCodeList.add("600309");  // 万华化学
//		stockPoolCodeList.add("601012");  // 隆基股份
//		stockPoolCodeList.add("600703");  // 三安光电
//		stockPoolCodeList.add("600276");  // 恒瑞医药
//		stockPoolCodeList.add("600438");  // 通威股份
//		stockPoolCodeList.add("600588");  // 用友网络
//		stockPoolCodeList.add("600887");  // 伊利股份
//		stockPoolCodeList.add("601888");  // 中国中免
//		stockPoolCodeList.add("603259");  // 药明康德
//		stockPoolCodeList.add("603288");  // 海天味业
//		stockPoolCodeList.add("300014");  // 亿纬锂能
//		stockPoolCodeList.add("300122");  // 智飞生物
//		stockPoolCodeList.add("300601");  // 康泰生物
//		stockPoolCodeList.add("300760");  // 迈瑞医疗
//		stockPoolCodeList.add("300450");  // 先导智能

//		stockPoolCodeList.add("600519");  // 贵州茅台
		
//		stockPoolCodeList.add("600009");  // 上海机场
//		stockPoolCodeList.add("600018");  // 上港集团
//		stockPoolCodeList.add("600895");  // 张江高科
//		stockPoolCodeList.add("000333");  // 美的集团
//		stockPoolCodeList.add("000002");  // 万科A
//		stockPoolCodeList.add("600036");  // 招商银行
//		stockPoolCodeList.add("601318");  // 中国平安
//		stockPoolCodeList.add("600379");  // 宝光股份
//		stockPoolCodeList.add("600101");  // 明星电力
//		
//		stockPoolCodeList.add("600429");  // 三元股份
//		stockPoolCodeList.add("300106");  // 西部牧业
//		stockPoolCodeList.add("300257");  // 开山股份
//		stockPoolCodeList.add("603619");  // 中曼石油
//		stockPoolCodeList.add("603323");  // 苏农银行
//		stockPoolCodeList.add("600674");  // 川投能源
//		stockPoolCodeList.add("600661");  // 昂立教育
		
//		stockPoolCodeList.add("515220");  // "煤炭ETF"
//		stockPoolCodeList.add("513100");  // 纳指ETF
		
		// 指数ETF
//		stockPoolCodeList.add("510050");  // 50ETF
//		stockPoolCodeList.add("510500");  // 500ETF
//		stockPoolCodeList.add("510300");  // 300ETF
//		stockPoolCodeList.add("159949");  // 创业板50
//		stockPoolCodeList.add("159915");  // 创业板		
//		stockPoolCodeList.add("588000");  // 科创50ETF
//		stockPoolCodeList.add("510900");  // H股ETF
//		stockPoolCodeList.add("513520");  // 日经ETF
//		stockPoolCodeList.add("513100");  // 纳指ETF
//		stockPoolCodeList.add("513500");  // 标普500ETF
//
//		stockPoolCodeList.add("512010");  // 医药ETF
//		stockPoolCodeList.add("512170");  // 医疗ETF
//		stockPoolCodeList.add("515220");  // 煤炭ETF
//		stockPoolCodeList.add("515050");  // 5GETF
//		stockPoolCodeList.add("512690");  // 酒ETF
//		stockPoolCodeList.add("512880");  // 证券ETF
//		stockPoolCodeList.add("512800");  // 银行ETF
//		stockPoolCodeList.add("512660");  // 军工ETF
//		stockPoolCodeList.add("515210");  // 钢铁ETF
//		stockPoolCodeList.add("512200");  // 房地产ETF
//		stockPoolCodeList.add("512480");  // 半导体ETF
//		stockPoolCodeList.add("512760");  // 芯片ETF
//		stockPoolCodeList.add("515030");  // 新能源车ETF
//		stockPoolCodeList.add("515790");  // 光伏ETF
//
//
//		stockPoolCodeList.add("516110");  // 汽车ETF		
//		stockPoolCodeList.add("516970");  // 基建50ETF
//		stockPoolCodeList.add("512400");  // 有色ETF
//		stockPoolCodeList.add("518880");  // 黄金ETF
//		stockPoolCodeList.add("516020");  // 化工ETF
//		stockPoolCodeList.add("515880");  // 通信ETF
//		stockPoolCodeList.add("515000");  // 科技ETF		
//		stockPoolCodeList.add("159996");  // 家电ETF
//		stockPoolCodeList.add("512720");  // 计算机ETF
//		stockPoolCodeList.add("159852");  // 软件ETF
//		stockPoolCodeList.add("159869");  // 游戏ETF
//		stockPoolCodeList.add("159939");  // 信息技术ETF
		
		
		// 涨速排名测试ETF
		stockPoolCodeList.add("512010");  // 医药ETF
		stockPoolCodeList.add("515220");  // 煤炭ETF
		stockPoolCodeList.add("512690");  // 酒ETF
		stockPoolCodeList.add("512880");  // 证券ETF
		stockPoolCodeList.add("512800");  // 银行ETF
		stockPoolCodeList.add("512660");  // 军工ETF
		stockPoolCodeList.add("512200");  // 房地产ETF
		stockPoolCodeList.add("512480");  // 半导体ETF
		stockPoolCodeList.add("516020");  // 化工ETF
		stockPoolCodeList.add("516970");  // 基建50ETF
		stockPoolCodeList.add("516110");  // 汽车ETF		
		stockPoolCodeList.add("159996");  // 家电ETF
		
//		stockPoolCodeList.add("510050");  // 50ETF
//		stockPoolCodeList.add("510500");  // 500ETF
//		stockPoolCodeList.add("159949");  // 创业板50
//		stockPoolCodeList.add("588000");  // 科创50ETF
//		stockPoolCodeList.add("510900");  // H股ETF
		
		
		//stock 数据研究类型
//		dateType=StockKey.day;  
//		dateType=StockKey.minute1;  
//		dateType=StockKey.minute5;
		dateType=StockKey.minute15;  
//		dateType=StockKey.minute30; 
//		dateType=StockKey.minute60; 

		
		System.out.println("Get pool stock data.");
		Map stockDataMap=getStockAllDataMap(stockPoolCodeList);	 // 获得备选池股票的历史数据
		
//		processInvestmentByStrategy_dtpl(stockDataMap, "2004/01/01", "2020/12/01");  // 模拟投资策略输出交易记录及结果
//		processInvestmentByStrategy_jjcl(stockCodeList, "2010/01/01", "2019/12/30");
//		processInvestmentByStrategy_znzj(stockDataMap, "2010/01/01", "2020/12/31"); 
//		processInvestmentByStrategy_znzj(stockDataMap, "2011/01/01", "2012/01/01"); 
		
//		processInvestmentByStrategy_wrzb(stockDataMap, "2010/01/01", "2020/12/31"); 
//		processInvestmentByStrategy_wrzbfs(stockDataMap, "2010/01/01", "2020/12/31"); 
//		processInvestmentByStrategy_wrzbcd(stockDataMap, "2010/06/15", "2020/12/31"); 
//		processInvestmentByStrategy_wrzbcdgj(stockDataMap, "2015/06/15", "2020/12/31"); 
		
//		processInvestmentByStrategy_cci(stockDataMap, "2010/01/01", "2020/12/31"); 

//		processInvestmentByStrategy_wr100(stockDataMap, "2020/01/01", "2020/12/31");
		
		
		// 全部交易评估

//		processEvaluationByMultipleStock(stockDataMap, "2014/01/01", "2014/12/31");  // 牛市
//		processEvaluationByMultipleStock(stockDataMap, "2015/01/01", "2015/12/31");	 // 牛市
//		processEvaluationByMultipleStock(stockDataMap, "2008/01/01", "2008/12/31");  // 熊市
//		processEvaluationByMultipleStock(stockDataMap, "2018/01/01", "2018/12/31");  // 熊市
		
//		processEvaluationByMultipleStock(stockDataMap, "2000/01/01", "2021/12/31");  // 全市
//		processEvaluationByMultipleStock(stockDataMap, "2000/01/01", "2010/12/31");  // 全市上十年
//		processEvaluationByMultipleStock(stockDataMap, "2011/01/01", "2021/12/31");  // 全市下十年
		
		processEvaluationByMultipleStock(stockDataMap, "2021/01/01", "2022/03/31");  // 分时
		
	}
	
	public void processEvaluationByMultipleStock(Map stockDataMap, String startDate, String endDate)
	{
		
		// 对涨速排序
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

			// 用模型测试每只股票
//			mer=processInvestmentByStrategy_wr100_K60(singleStockDataMap, startDate, endDate);
//			mer=processInvestmentByStrategy_macd_ndbl(singleStockDataMap, startDate, endDate);
//			mer=processInvestmentByStrategy_macd_ndtpl(singleStockDataMap, startDate, endDate); 
//			mer=processInvestmentByStrategy_macd_ndtpl_ma20(singleStockDataMap, startDate, endDate);
//			mer=processInvestmentByStrategy_zspm_minute(singleStockDataMap, startDate, endDate); // 涨速排名
//			mer=processInvestmentByStrategy_zzyl_minute(singleStockDataMap, startDate, endDate); // 追涨盈利
			mer=processInvestmentByStrategy_zzpm_minute(singleStockDataMap, startDate, endDate); // 追涨排名
			
			allTransactionDataList.addAll(mer.getTransactionDataList());
			double selfProfit=CommonTool.getReferenceProfit(stockCode, "day", startDate, endDate);
			reportLineList.add(mer.getReportLine()+"  "+CommonTool.getDoubleNumberWithTwoBit(selfProfit)+"%");
			
		}
		
		
		outputTransactionRecordReport_total(allTransactionDataList, mer.getModelName());
		
		System.out.println(mer.getModelName()+" "+startDate+" - "+endDate);
//		String reportTitle=CommonTool.formatStringLength("股票名称", 25)
//				+CommonTool.formatStringLength("股票代码",12)
//				+CommonTool.formatStringLength("交易次数",10)
//				+CommonTool.formatStringLength("成功",14)
//				+CommonTool.formatStringLength("失败",14)
//				+CommonTool.formatStringLength("胜率",15)
//				+CommonTool.formatStringLength("总涨幅(DBJ)",12)
//				+CommonTool.formatStringLength("总涨幅(FL)",12)
//				+CommonTool.formatStringLength("同期本股",10)
//				+CommonTool.formatStringLength("同期50ETF",10)
//				+CommonTool.formatStringLength("同期300ETF",10)
//				+CommonTool.formatStringLength("同期基金",10);
		String reportTitle="股票名称"+"\t\t"
				+"股票代码"+"\t\t"
				+"交易次数"+"\t"
				+"成功"+"\t"
				+"失败"+"\t"
				+"胜率"+"\t\t"
				+"总涨幅(DBJ)"+"\t"
				+"总涨幅(FL)"+"\t"
				+"同期本股"+"\t";
		
		System.out.println(reportTitle);
		for (int i=0; i<reportLineList.size(); i++)
		{
			String reportLine=(String)reportLineList.get(i);
			System.out.println(reportLine);
		}
		
	}
	
	
	// 模拟投资 - CMDN 筹码动能策略
	public ModelEvaluationReport processInvestmentByStrategy_CMDN(Map stockDataMap, String startDate, String endDate)
	{
		
		// 创建一个个人模拟账户
		PersonalStockAccount psa=new PersonalStockAccount();
		
		List dateList=CommonTool.generateTimeReferenceList(startDate, endDate, dateType);
		
		// 创建昨天的accountDD_pre
 		AccountDayData accountDD_pre=new AccountDayData();  
		accountDD_pre.setCashValue(psa.investMoney);
		
		double lastSalePrice=10000;  // 上一次抛出时的价格, 初始值10000
		String lastSaleDate="";
		boolean isMACDChanged=false;   // 上一次抛出到现在MACD 5>60的趋势是否改变
		
		
		// 模拟每个交易日交易
		for (int i=0; i<dateList.size(); i++)
		{
			
			// 取出一个交易日期
			String transDate=dateList.get(i).toString();
			
			// 创建一个当日的交易账户对象accountDD，并继承昨日的持仓和现金
			AccountDayData accountDD=new AccountDayData();
			accountDD.setPosNum(i);
			accountDD.setDate(transDate);
			accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // 继承昨日的持仓
			accountDD.setCashValue(accountDD_pre.getCashValue());	// 继承昨日的现金
			
			// 检查当前持仓的股票走势状况，先决定是否卖出，并更新持仓股票及各股持仓价格
			List stockHoldList=accountDD.getStockHoldList();
			int stockHoldSize=stockHoldList.size();
			for (int j=stockHoldSize-1; j>=0; j--)
			{
				// 取出一个持股对象
				StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
				
				// 获得此持股的历史数据
				String stockcode=shs.getCode();
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
				// 取出此股前几天的数据
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
				
				
				if (sdd==null || sdd_b1==null || sdd_b2==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
				{
					shs.setCurDate(transDate);
					continue;
				}
				
				TransactionRecordData trd=new TransactionRecordData();
				StockDayData buySDD=shs.getBuySDD();
				
				double wr_wave=sdd.getWR10()-sdd_b1.getWR10();
				double wr_wave1=sdd_b1.getWR10()-sdd_b2.getWR10();
				double wr_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
				
				// 获取前几天的数据
				List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
				List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10); 
				List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
				List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
				
//				sdd_b1=(StockDayData)pastStockList.get(1);   // 从序列中取出
						
//				System.out.println(i);
				
				
				// 判断此股当前形势，是否出现超买趋势，决定是否卖出
				int wr_vavel=70;
				if ( 
				i==dateList.size()-2     // 到了交易队列的最后一天
				
//				||(sdd_b1.getWR100()<wr_vavel && sdd.getWR100()>wr_vavel) 	// WR100上穿40
//				||(sdd_b1.getWR100()>wr_vavel && sdd.getWR100()>sdd_b1.getWR100())  // 40以上，继续向上，此情况针对中途下车后再买入的情况
//				||(checkPastdays_WR100_Rise(pastStockList5, sdd)>20)   // 当前WR100值相对于过去几天的最低点上涨了多少
//				||(checkPastdays_TopRiseDown(pastStockList20, sdd)<-10)  // 从最高点下跌15%就止损抛出
				 
//				sdd_b1.getCCI14()>100 && sdd.getCCI14()<100
//				(sdd_b2.getWR10()<30 && sdd_b1.getWR10()>30 ) &&
						
//				 (sdd_b1.getWR42()<50 && sdd.getWR42()>50) 
						
//				 ( 
//				 sdd.getDate().endsWith("7")  // 在14:30看盘卖出
//				 &&		 
//				 sdd.getWR42()>70	// 第二天中途出现反向上穿30卖出, 这个值居然是越大越好，因为越大可以避免大波段上涨中途多次下车
//				 ||
//				 sdd.getDate().endsWith("8")  // 第二天收盘卖出
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
//				 (sdd_b1.getReal_rise()<0 && sdd.getReal_rise()<0 && sdd_b1.getClose_rise()+sdd.getClose_rise()<-5 ) ||  // 连续双阴  

//				 (sdd.getReal_rise()<-5) ||  // 当日收阴，阴柱幅度大于5%		
//				 (sdd.getReal_rise()<0 && (sdd.getLow()+sdd.getHigh())/2<sdd.getMa_20())   // 当日收阴，且中位价跌破20日线
				 
//				 (sdd.getReal_rise()<0 && sdd.getHigh_rise()-sdd.getLow_rise()>5)   // 当日收阴，最高点到收盘跌幅大于5%	
				 
//				  sdd.getWR100()<10 || sdd.getWR100()>50 
				
				)
				{
					// 当出现CCI超卖指标
//					TransactionRecordData trd=new TransactionRecordData();
//					StockDayData buySDD=shs.getBuySDD();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(buySDD);
					trd.setSaleSDD(sdd);
					
					// wr 收益计算
					double transactionProfit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getClose())/trd.getBuySDD().getClose())*100-0.2;
					trd.setTransactionProfit(transactionProfit);
					
					accountDD.saleTransList.add(trd);
					
					if(lastSalePrice==10000 || sdd.getClose()>lastSalePrice)
					{
						lastSalePrice=sdd.getClose(); // 记录上一次卖出时的价格
					}
					
					// 更新accountDD持仓列表
					accountDD.stockHoldList.remove(j);
					
					// 更新accountDD现金价值
					int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
					int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
					
					
				}
				else
				{
					// 如不卖出，就继续持有不变，更新持仓价格
					shs.setCurDate(transDate);
					shs.setCurPrice(sdd.getClose());	
				}
				
			}
			
			
			// 检查股票池里备选的股票走势情况，再决定是否买入，并更新持仓股票
			Iterator it=stockDataMap.keySet().iterator();
			while(it.hasNext())
			{
				
				// 从备选股票池中取出一只股票
				String stockcode=it.next().toString();  
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
			
				if (checkStockHoldList(stockHoldList, stockcode)==true)  // 如果已经持股，则不做增仓买入
				{
					continue;
				}
				
				// 取出此股前几天的数据
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
				
//				if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null || sdd_b4==null || sdd_b5==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
//				{
//					continue;
//				}
//				
//				if (sdd_b6==null || sdd_b7==null || sdd_b8==null || sdd_b9==null)
//				{
//					continue;
//				}
//				
//				if (sdd_b10==null || sdd_b11==null || sdd_b12==null || sdd_b13==null || sdd_b14==null || sdd_b15==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
//				{
//					continue;
//				}
				
				// 获取前几天的数据
				List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
				List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);
				List pastStockList15=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 15);
				List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
				List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
				List pastStockList100=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 100);
				List pastStockList150=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 150);
//				String dateb1=sdd_b1.getDate();   // debug代码
//				System.out.println(dateb1);
//				if (sdd_b1.getDate().contains("2020/11/02"))
//				{
//					int t=1;
//					t++;
//				}
				
				
				// 当开盘价格比昨日中位价高，且昨日收阳柱，则决定买入
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
//					sdd_b2.getWR6()>75 && sdd_b2.getWR6()-sdd_b1.getWR6()>10    // WR下穿10个点
//					sdd_b2.getWR6()>50
//					sdd_b2.getWR6()<75 && sdd_b1.getWR6()>75    // WR下穿70
//					&& sdd_b1.getWR6()-sdd_b2.getWR6()>30
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_10()
//					&& !(sdd_b1.getMa_5()<sdd_b1.getMa_10() && sdd_b1.getMa_10()<sdd_b1.getMa_20())   // 非MACD空头排列
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_20()     
//					&& !(sdd_b1.getReal_rise()<0 && sdd_b2.getReal_rise()<0 && sdd_b3.getReal_rise()<0)   // 非三连阴柱
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2) 


//					&& checkPastdaysWR42(transDate, -20, 90);  // 检查从transDate之前20天，是否有超过90的值
//					&& sdd_b1.getWR42()>85 
//					( checkPastdays_WR42_TopNumber_TopNumber(pastStockList10, 85)==1 && checkPastdays_WR42_EndNumber(pastStockList5, 60)>=1 )
//					||
						
//					( 
//					sdd_b1.getDate().endsWith("7")  // 在14:30看盘
//					&&
//					checkPastdays_WR42_TopNumber(pastStockList20, 50)==0   // 是从高位下穿							
//					&& 
//					checkPastdays_WR42_EndNumber(pastStockList40, 20)>=20   // 收盘前多次进入WR42的20以下区域
//					&& 
//					sdd_b1.getWR42()<20 	// 收盘时WR42在20以下
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
//					&& sdd_b6.getMa_5()>sdd_b6.getMa_60()     // 非常重要的一个条件！！准确描述了走势形态	
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2)
//					&& checkDayData_MA_dtpl(sdd_b3)
//					&& checkDayData_MA_dtpl(sdd_b4)
//					&& checkDayData_MA_dtpl(sdd_b5)
					
//					&& sdd_b2.getWR100()>50 && sdd_b1.getWR100()<50    // WR100下穿50
						
					)
				{
					
					// 当出现多头排列，就买入，并记录买入交易
					TransactionRecordData trd=new TransactionRecordData();
					trd.setBuySDD(sdd);
					accountDD.buyTransList.add(trd);
					
					// 更新accountDD持仓列表
					StockHoldShare shs=new StockHoldShare();
					
					// 计算可买入股票数量
//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
//					int amount=0;
//					if (accountDD.cashValue>eachStockInvestMoney)
//					{
//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // 剩余现金足够投资一份当前股票
//					}
//					else
//					{
//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金不够投资一份当前股票，则全部买入
//					}
					
					int amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金全部买入
					
					// 添加新买入的持仓股票
					shs.setAmount(amount);
					shs.setCode(sdd.getCode());
					shs.setName(sdd.getName());
					shs.setBuyPrice(sdd.getOpen());
					shs.setBuyDate(sdd.getDate());
					shs.setCurPrice(sdd.getClose());
					shs.setCurDate(sdd.getDate());
					shs.setBuySDD(sdd);
					stockHoldList.add(shs);
					
					// 更新accountDD现金价值
					int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
					int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
					
				}
				else
				{
					
					// 如果未接上继续上涨，而是继续下跌了，WR100回继续冲向80以上，这说明走势已坏，不能继续用股价接力的方法，
					// 要等待WR100再次回到20以下再次发动一轮新的上涨
					if (sdd.getWR100()>80)   
					{
//						System.out.println("SDD WR: "+sdd.getDate()+"  "+sdd.getWR100());
						lastSalePrice=10000;  
					}
					
				}
				
			}
			
			// 更新个人账户的每日账户信息
			Map accountDataMap=psa.getAccountDataMap();
			accountDataMap.put(transDate, accountDD);
			accountDD_pre=accountDD;
			
		}
		
		// 输出投资交易记录，模拟交易金额变化曲线，对比评估交易策略
		String modelName="投资组合_CMDN";
		List transactionDataList=generateTransactionDataListFromPSA(psa);
		String reportLine=outputTransactionRecordReport(transactionDataList, modelName);
		// code name date_c saledate year days buy_price sale_price profit 
		
//		outputAccountRecordReport(psa); // 输出account的每日投资内容，价格变化，现金价值/总价值  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
		
//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, 易方达消费 
		
		ModelEvaluationReport mer=new ModelEvaluationReport();
		mer.setTransactionDataList(transactionDataList);
		mer.setReportLine(reportLine);
		mer.setModelName(modelName);
		
		return mer;
	}
	
	
	// 模拟投资 - WR100 指标策略
	public ModelEvaluationReport processInvestmentByStrategy_wr100_K60(Map stockDataMap, String startDate, String endDate)
	{
		
		// 创建一个个人模拟账户
		PersonalStockAccount psa=new PersonalStockAccount();
		
		List dateList=CommonTool.generateTimeReferenceList(startDate, endDate, dateType);
		
		// 创建昨天的accountDD_pre
 		AccountDayData accountDD_pre=new AccountDayData();  
		accountDD_pre.setCashValue(psa.investMoney);
		
		double lastSalePrice=10000;  // 上一次抛出时的价格, 初始值10000
		String lastSaleDate="";
		boolean isMACDChanged=false;   // 上一次抛出到现在MACD 5>60的趋势是否改变
		
		
		// 模拟每个交易日交易
		for (int i=0; i<dateList.size(); i++)
		{
			
			// 取出一个交易日期
			String transDate=dateList.get(i).toString();
			
			// 创建一个当日的交易账户对象accountDD，并继承昨日的持仓和现金
			AccountDayData accountDD=new AccountDayData();
			accountDD.setPosNum(i);
			accountDD.setDate(transDate);
			accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // 继承昨日的持仓
			accountDD.setCashValue(accountDD_pre.getCashValue());	// 继承昨日的现金
			
			// 检查当前持仓的股票走势状况，先决定是否卖出，并更新持仓股票及各股持仓价格
			List stockHoldList=accountDD.getStockHoldList();
			int stockHoldSize=stockHoldList.size();
			for (int j=stockHoldSize-1; j>=0; j--)
			{
				// 取出一个持股对象
				StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
				
				// 获得此持股的历史数据
				String stockcode=shs.getCode();
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
				// 取出此股前几天的数据
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
				
				
				if (sdd==null || sdd_b1==null || sdd_b2==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
				{
					shs.setCurDate(transDate);
					continue;
				}
				
				TransactionRecordData trd=new TransactionRecordData();
				StockDayData buySDD=shs.getBuySDD();
				
				double wr_wave=sdd.getWR10()-sdd_b1.getWR10();
				double wr_wave1=sdd_b1.getWR10()-sdd_b2.getWR10();
				double wr_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
				
				// 获取前几天的数据
				List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
				List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10); 
				List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
				List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
				
//				sdd_b1=(StockDayData)pastStockList.get(1);   // 从序列中取出
						
//				System.out.println(i);
				
				
				// 判断此股当前形势，是否出现超买趋势，决定是否卖出
				int wr_vavel=70;
				if ( 
				i==dateList.size()-2     // 到了交易队列的最后一天
				||(sdd_b1.getWR100()<wr_vavel && sdd.getWR100()>wr_vavel) 	// WR100上穿40
//				||(sdd_b1.getWR100()>wr_vavel && sdd.getWR100()>sdd_b1.getWR100())  // 40以上，继续向上，此情况针对中途下车后再买入的情况
//				||(checkPastdays_WR100_Rise(pastStockList5, sdd)>20)   // 当前WR100值相对于过去几天的最低点上涨了多少
//				||(checkPastdays_TopRiseDown(pastStockList20, sdd)<-10)  // 从最高点下跌15%就止损抛出
				 
//				sdd_b1.getCCI14()>100 && sdd.getCCI14()<100
//				(sdd_b2.getWR10()<30 && sdd_b1.getWR10()>30 ) &&
						
//				 (sdd_b1.getWR42()<50 && sdd.getWR42()>50) 
						
//				 ( 
//				 sdd.getDate().endsWith("7")  // 在14:30看盘卖出
//				 &&		 
//				 sdd.getWR42()>70	// 第二天中途出现反向上穿30卖出, 这个值居然是越大越好，因为越大可以避免大波段上涨中途多次下车
//				 ||
//				 sdd.getDate().endsWith("8")  // 第二天收盘卖出
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
//				 (sdd_b1.getReal_rise()<0 && sdd.getReal_rise()<0 && sdd_b1.getClose_rise()+sdd.getClose_rise()<-5 ) ||  // 连续双阴  

//				 (sdd.getReal_rise()<-5) ||  // 当日收阴，阴柱幅度大于5%		
//				 (sdd.getReal_rise()<0 && (sdd.getLow()+sdd.getHigh())/2<sdd.getMa_20())   // 当日收阴，且中位价跌破20日线
				 
//				 (sdd.getReal_rise()<0 && sdd.getHigh_rise()-sdd.getLow_rise()>5)   // 当日收阴，最高点到收盘跌幅大于5%	
				 
//				  sdd.getWR100()<10 || sdd.getWR100()>50 
				
				)
				{
					// 当出现CCI超卖指标
//					TransactionRecordData trd=new TransactionRecordData();
//					StockDayData buySDD=shs.getBuySDD();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(buySDD);
					trd.setSaleSDD(sdd);
					
					// wr 收益计算
					double transactionProfit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getClose())/trd.getBuySDD().getClose())*100-0.2;
					trd.setTransactionProfit(transactionProfit);
					
					accountDD.saleTransList.add(trd);
					
					if(lastSalePrice==10000 || sdd.getClose()>lastSalePrice)
					{
						lastSalePrice=sdd.getClose(); // 记录上一次卖出时的价格
					}
					
					// 更新accountDD持仓列表
					accountDD.stockHoldList.remove(j);
					
					// 更新accountDD现金价值
					int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
					int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
					
					
				}
				else
				{
					// 如不卖出，就继续持有不变，更新持仓价格
					shs.setCurDate(transDate);
					shs.setCurPrice(sdd.getClose());	
				}
				
			}
			
			
			// 检查股票池里备选的股票走势情况，再决定是否买入，并更新持仓股票
			Iterator it=stockDataMap.keySet().iterator();
			while(it.hasNext())
			{
				
				// 从备选股票池中取出一只股票
				String stockcode=it.next().toString();  
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
			
				if (checkStockHoldList(stockHoldList, stockcode)==true)  // 如果已经持股，则不做增仓买入
				{
					continue;
				}
				
				// 取出此股前几天的数据
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
				
//				if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null || sdd_b4==null || sdd_b5==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
//				{
//					continue;
//				}
//				
//				if (sdd_b6==null || sdd_b7==null || sdd_b8==null || sdd_b9==null)
//				{
//					continue;
//				}
//				
//				if (sdd_b10==null || sdd_b11==null || sdd_b12==null || sdd_b13==null || sdd_b14==null || sdd_b15==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
//				{
//					continue;
//				}
				
				// 获取前几天的数据
				List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
				List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);
				List pastStockList15=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 15);
				List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
				List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
				List pastStockList100=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 100);
				List pastStockList150=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 150);
//				String dateb1=sdd_b1.getDate();   // debug代码
//				System.out.println(dateb1);
//				if (sdd_b1.getDate().contains("2020/11/02"))
//				{
//					int t=1;
//					t++;
//				}
				
				
				// 当出WR超卖决定买入
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
//					sdd_b2.getWR6()>75 && sdd_b2.getWR6()-sdd_b1.getWR6()>10    // WR下穿10个点
//					sdd_b2.getWR6()>50
//					sdd_b2.getWR6()<75 && sdd_b1.getWR6()>75    // WR下穿70
//					&& sdd_b1.getWR6()-sdd_b2.getWR6()>30
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_10()
//					&& !(sdd_b1.getMa_5()<sdd_b1.getMa_10() && sdd_b1.getMa_10()<sdd_b1.getMa_20())   // 非MACD空头排列
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_20()     
//					&& !(sdd_b1.getReal_rise()<0 && sdd_b2.getReal_rise()<0 && sdd_b3.getReal_rise()<0)   // 非三连阴柱
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2) 


//					&& checkPastdaysWR42(transDate, -20, 90);  // 检查从transDate之前20天，是否有超过90的值
//					&& sdd_b1.getWR42()>85 
//					( checkPastdays_WR42_TopNumber_TopNumber(pastStockList10, 85)==1 && checkPastdays_WR42_EndNumber(pastStockList5, 60)>=1 )
//					||
						
//					( 
//					sdd_b1.getDate().endsWith("7")  // 在14:30看盘
//					&&
//					checkPastdays_WR42_TopNumber(pastStockList20, 50)==0   // 是从高位下穿							
//					&& 
//					checkPastdays_WR42_EndNumber(pastStockList40, 20)>=20   // 收盘前多次进入WR42的20以下区域
//					&& 
//					sdd_b1.getWR42()<20 	// 收盘时WR42在20以下
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
//					&& sdd_b6.getMa_5()>sdd_b6.getMa_60()     // 非常重要的一个条件！！准确描述了走势形态	
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2)
//					&& checkDayData_MA_dtpl(sdd_b3)
//					&& checkDayData_MA_dtpl(sdd_b4)
//					&& checkDayData_MA_dtpl(sdd_b5)
					
//					&& sdd_b2.getWR100()>50 && sdd_b1.getWR100()<50    // WR100下穿50
						
					)
				{
					
					// 当出现多头排列，就买入，并记录买入交易
					TransactionRecordData trd=new TransactionRecordData();
					trd.setBuySDD(sdd);
					accountDD.buyTransList.add(trd);
					
					// 更新accountDD持仓列表
					StockHoldShare shs=new StockHoldShare();
					
					// 计算可买入股票数量
//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
//					int amount=0;
//					if (accountDD.cashValue>eachStockInvestMoney)
//					{
//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // 剩余现金足够投资一份当前股票
//					}
//					else
//					{
//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金不够投资一份当前股票，则全部买入
//					}
					
					int amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金全部买入
					
					// 添加新买入的持仓股票
					shs.setAmount(amount);
					shs.setCode(sdd.getCode());
					shs.setName(sdd.getName());
					shs.setBuyPrice(sdd.getOpen());
					shs.setBuyDate(sdd.getDate());
					shs.setCurPrice(sdd.getClose());
					shs.setCurDate(sdd.getDate());
					shs.setBuySDD(sdd);
					stockHoldList.add(shs);
					
					// 更新accountDD现金价值
					int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
					int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
					
				}
				else
				{
					
					// 如果未接上继续上涨，而是继续下跌了，WR100回继续冲向80以上，这说明走势已坏，不能继续用股价接力的方法，
					// 要等待WR100再次回到20以下再次发动一轮新的上涨
					if (sdd.getWR100()>80)   
					{
//						System.out.println("SDD WR: "+sdd.getDate()+"  "+sdd.getWR100());
						lastSalePrice=10000;  
					}
					
				}
				
			}
			
			// 更新个人账户的每日账户信息
			Map accountDataMap=psa.getAccountDataMap();
			accountDataMap.put(transDate, accountDD);
			accountDD_pre=accountDD;
			
		}
		
		// 输出投资交易记录，模拟交易金额变化曲线，对比评估交易策略
		String modelName="投资组合_WR100指标_K60";
		List transactionDataList=generateTransactionDataListFromPSA(psa);
		String reportLine=outputTransactionRecordReport(transactionDataList, modelName);
		// code name date_c saledate year days buy_price sale_price profit 
		
//		outputAccountRecordReport(psa); // 输出account的每日投资内容，价格变化，现金价值/总价值  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
		
//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, 易方达消费 
		
		ModelEvaluationReport mer=new ModelEvaluationReport();
		mer.setTransactionDataList(transactionDataList);
		mer.setReportLine(reportLine);
		mer.setModelName(modelName);
		
		return mer;
	}
	
	
	
	
	
	// 模拟投资 - WR100 指标策略
	public ModelEvaluationReport processInvestmentByStrategy_wr100(Map stockDataMap, String startDate, String endDate)
	{
		
		// 创建一个个人模拟账户
		PersonalStockAccount psa=new PersonalStockAccount();
		
		List dateList=CommonTool.generateTimeReferenceList(startDate, endDate, dateType);
		
		// 创建昨天的accountDD_pre
 		AccountDayData accountDD_pre=new AccountDayData();  
		accountDD_pre.setCashValue(psa.investMoney);
		
		double lastSalePrice=10000;  // 上一次抛出时的价格, 初始值10000
		String lastSaleDate="";
		boolean isMACDChanged=false;   // 上一次抛出到现在MACD 5>60的趋势是否改变
		
		
		// 模拟每个交易日交易
		for (int i=0; i<dateList.size(); i++)
		{
			
			// 取出一个交易日期
			String transDate=dateList.get(i).toString();
			
			// 创建一个当日的交易账户对象accountDD，并继承昨日的持仓和现金
			AccountDayData accountDD=new AccountDayData();
			accountDD.setPosNum(i);
			accountDD.setDate(transDate);
			accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // 继承昨日的持仓
			accountDD.setCashValue(accountDD_pre.getCashValue());	// 继承昨日的现金
			
			// 检查当前持仓的股票走势状况，先决定是否卖出，并更新持仓股票及各股持仓价格
			List stockHoldList=accountDD.getStockHoldList();
			int stockHoldSize=stockHoldList.size();
			for (int j=stockHoldSize-1; j>=0; j--)
			{
				// 取出一个持股对象
				StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
				
				// 获得此持股的历史数据
				String stockcode=shs.getCode();
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
				// 取出此股前几天的数据
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
				
				
				if (sdd==null || sdd_b1==null || sdd_b2==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
				{
					shs.setCurDate(transDate);
					continue;
				}
				
				TransactionRecordData trd=new TransactionRecordData();
				StockDayData buySDD=shs.getBuySDD();
				
				double wr_wave=sdd.getWR10()-sdd_b1.getWR10();
				double wr_wave1=sdd_b1.getWR10()-sdd_b2.getWR10();
				double wr_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
				
				// 获取前几天的数据
				List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
				List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10); 
				List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
				List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
				
//				sdd_b1=(StockDayData)pastStockList.get(1);   // 从序列中取出
						
//				System.out.println(i);
				
				
				// 判断此股当前形势，是否出现超买趋势，决定是否卖出
				int wr_vavel=1000;
				if ( 
				i==dateList.size()-2     // 到了交易队列的最后一天
				||(sdd_b1.getWR100()<wr_vavel && sdd.getWR100()>wr_vavel) 	// WR100上穿40
				||(sdd_b1.getWR100()>wr_vavel && sdd.getWR100()>sdd_b1.getWR100())  // 40以上，继续向上，此情况针对中途下车后再买入的情况
//				||(checkPastdays_WR100_Rise(pastStockList5, sdd)>20)   // 当前WR100值相对于过去几天的最低点上涨了多少
//				||(checkPastdays_TopRiseDown(pastStockList20, sdd)<-10)  // 从最高点下跌15%就止损抛出
				 
//				sdd_b1.getCCI14()>100 && sdd.getCCI14()<100
//				(sdd_b2.getWR10()<30 && sdd_b1.getWR10()>30 ) &&
						
//				 (sdd_b1.getWR42()<50 && sdd.getWR42()>50) 
						
//				 ( 
//				 sdd.getDate().endsWith("7")  // 在14:30看盘卖出
//				 &&		 
//				 sdd.getWR42()>70	// 第二天中途出现反向上穿30卖出, 这个值居然是越大越好，因为越大可以避免大波段上涨中途多次下车
//				 ||
//				 sdd.getDate().endsWith("8")  // 第二天收盘卖出
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
//				 (sdd_b1.getReal_rise()<0 && sdd.getReal_rise()<0 && sdd_b1.getClose_rise()+sdd.getClose_rise()<-5 ) ||  // 连续双阴  

//				 (sdd.getReal_rise()<-5) ||  // 当日收阴，阴柱幅度大于5%		
//				 (sdd.getReal_rise()<0 && (sdd.getLow()+sdd.getHigh())/2<sdd.getMa_20())   // 当日收阴，且中位价跌破20日线
				 
//				 (sdd.getReal_rise()<0 && sdd.getHigh_rise()-sdd.getLow_rise()>5)   // 当日收阴，最高点到收盘跌幅大于5%	
				 
//				  sdd.getWR100()<10 || sdd.getWR100()>50 
				
				)
				{
					// 当出现CCI超卖指标
//					TransactionRecordData trd=new TransactionRecordData();
//					StockDayData buySDD=shs.getBuySDD();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(buySDD);
					trd.setSaleSDD(sdd);
					
					// cci 收益计算
					double transactionProfit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getClose())/trd.getBuySDD().getClose())*100-0.2;
					trd.setTransactionProfit(transactionProfit);
					
					accountDD.saleTransList.add(trd);
					
					if(lastSalePrice==10000 || sdd.getClose()>lastSalePrice)
					{
						lastSalePrice=sdd.getClose(); // 记录上一次卖出时的价格
					}
					
					// 更新accountDD持仓列表
					accountDD.stockHoldList.remove(j);
					
					// 更新accountDD现金价值
					int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
					int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
					
					
				}
				else
				{
					// 如不卖出，就继续持有不变，更新持仓价格
					shs.setCurDate(transDate);
					shs.setCurPrice(sdd.getClose());	
				}
				
			}
			
			
			// 检查股票池里备选的股票走势情况，再决定是否买入，并更新持仓股票
			Iterator it=stockDataMap.keySet().iterator();
			while(it.hasNext())
			{
				
				// 从备选股票池中取出一只股票
				String stockcode=it.next().toString();  
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
			
				if (checkStockHoldList(stockHoldList, stockcode)==true)  // 如果已经持股，则不做增仓买入
				{
					continue;
				}
				
				// 取出此股前几天的数据
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
				
//				if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null || sdd_b4==null || sdd_b5==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
//				{
//					continue;
//				}
//				
//				if (sdd_b6==null || sdd_b7==null || sdd_b8==null || sdd_b9==null)
//				{
//					continue;
//				}
//				
//				if (sdd_b10==null || sdd_b11==null || sdd_b12==null || sdd_b13==null || sdd_b14==null || sdd_b15==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
//				{
//					continue;
//				}
				
				// 获取前几天的数据
				List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
				List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);
				List pastStockList15=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 15);
				List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
				List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
				List pastStockList100=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 100);
				List pastStockList150=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 150);
//				String dateb1=sdd_b1.getDate();   // debug代码
//				System.out.println(dateb1);
//				if (sdd_b1.getDate().contains("2020/11/02"))
//				{
//					int t=1;
//					t++;
//				}
				
				
				// 当出WR超卖决定买入
//				if ( sdd_b1.getWR10()>90 && sdd_b1.getWR6()>90 )
				if ( 
					
					sdd.getWR100()<10 
					|| (sdd.getClose()>lastSalePrice && sdd.getMa_5()>sdd.getMa_20() && sdd.getMa_20()>sdd.getMa_60() && sdd.getWR100()<50) 
//					&& sdd.getDate().compareTo(lastSaleDate)>0)
//					&& checkPastdays_WR42_TopNumber(pastStockList150, 80)>=1
					
//					sdd_b1.getCCI14()<100 && sdd.getCCI14()>100
//					sdd_b2.getWR6()>75 && sdd_b2.getWR6()-sdd_b1.getWR6()>10    // WR下穿10个点
//					sdd_b2.getWR6()>50
//					sdd_b2.getWR6()<75 && sdd_b1.getWR6()>75    // WR下穿70
//					&& sdd_b1.getWR6()-sdd_b2.getWR6()>30
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_10()
//					&& !(sdd_b1.getMa_5()<sdd_b1.getMa_10() && sdd_b1.getMa_10()<sdd_b1.getMa_20())   // 非MACD空头排列
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_20()     
//					&& !(sdd_b1.getReal_rise()<0 && sdd_b2.getReal_rise()<0 && sdd_b3.getReal_rise()<0)   // 非三连阴柱
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2) 


//					&& checkPastdaysWR42(transDate, -20, 90);  // 检查从transDate之前20天，是否有超过90的值
//					&& sdd_b1.getWR42()>85 
//					( checkPastdays_WR42_TopNumber_TopNumber(pastStockList10, 85)==1 && checkPastdays_WR42_EndNumber(pastStockList5, 60)>=1 )
//					||
						
//					( 
//					sdd_b1.getDate().endsWith("7")  // 在14:30看盘
//					&&
//					checkPastdays_WR42_TopNumber(pastStockList20, 50)==0   // 是从高位下穿							
//					&& 
//					checkPastdays_WR42_EndNumber(pastStockList40, 20)>=20   // 收盘前多次进入WR42的20以下区域
//					&& 
//					sdd_b1.getWR42()<20 	// 收盘时WR42在20以下
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
//					&& sdd_b6.getMa_5()>sdd_b6.getMa_60()     // 非常重要的一个条件！！准确描述了走势形态	
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2)
//					&& checkDayData_MA_dtpl(sdd_b3)
//					&& checkDayData_MA_dtpl(sdd_b4)
//					&& checkDayData_MA_dtpl(sdd_b5)
					
//					&& sdd_b2.getWR100()>50 && sdd_b1.getWR100()<50    // WR100下穿50
						
					)
				{
					
					// 当出现多头排列，就买入，并记录买入交易
					TransactionRecordData trd=new TransactionRecordData();
					trd.setBuySDD(sdd);
					accountDD.buyTransList.add(trd);
					
					// 更新accountDD持仓列表
					StockHoldShare shs=new StockHoldShare();
					
					// 计算可买入股票数量
//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
//					int amount=0;
//					if (accountDD.cashValue>eachStockInvestMoney)
//					{
//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // 剩余现金足够投资一份当前股票
//					}
//					else
//					{
//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金不够投资一份当前股票，则全部买入
//					}
					
					int amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金全部买入
					
					// 添加新买入的持仓股票
					shs.setAmount(amount);
					shs.setCode(sdd.getCode());
					shs.setName(sdd.getName());
					shs.setBuyPrice(sdd.getOpen());
					shs.setBuyDate(sdd.getDate());
					shs.setCurPrice(sdd.getClose());
					shs.setCurDate(sdd.getDate());
					shs.setBuySDD(sdd);
					stockHoldList.add(shs);
					
					// 更新accountDD现金价值
					int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
					int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
					
				}
				else
				{
					
					// 如果未接上继续上涨，而是继续下跌了，WR100回继续冲向80以上，这说明走势已坏，不能继续用股价接力的方法，
					// 要等待WR100再次回到20以下再次发动一轮新的上涨
					if (sdd.getWR100()>80)   
					{
//						System.out.println("SDD WR: "+sdd.getDate()+"  "+sdd.getWR100());
						lastSalePrice=10000;  
					}
					
				}
				
			}
			
			// 更新个人账户的每日账户信息
			Map accountDataMap=psa.getAccountDataMap();
			accountDataMap.put(transDate, accountDD);
			accountDD_pre=accountDD;
			
		}
		
		// 输出投资交易记录，模拟交易金额变化曲线，对比评估交易策略
		String modelName="投资组合_WR100指标";
		List transactionDataList=generateTransactionDataListFromPSA(psa);
		String reportLine=outputTransactionRecordReport(transactionDataList, modelName);
		// code name date_c saledate year days buy_price sale_price profit 
		
//		outputAccountRecordReport(psa); // 输出account的每日投资内容，价格变化，现金价值/总价值  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
		
//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, 易方达消费 
		
		ModelEvaluationReport mer=new ModelEvaluationReport();
		mer.setTransactionDataList(transactionDataList);
		mer.setReportLine(reportLine);
		mer.setModelName(modelName);
		
		return mer;
	}
	
	
	// 模拟投资 - CCI指标策略
	public void processInvestmentByStrategy_cci(Map stockDataMap, String startDate, String endDate)
	{
		
		// 创建一个个人模拟账户
		PersonalStockAccount psa=new PersonalStockAccount();
		
		// 获得参考交易日期队列  - 切换日线数据/分时数据的时间标尺
		List dateList=CommonTool.getDateReferenceList(startDate, endDate);		// 以上证指数的交易日期为参考值
//		List dateList=CommonTool.getDateReferenceList(startDate, endDate, 30);		// 以上证指数的交易分时为参考值 - 待开发
				
		// 创建昨天的accountDD_pre
 		AccountDayData accountDD_pre=new AccountDayData();  
		accountDD_pre.setCashValue(psa.investMoney);
		
		double lastSalePrice=0;  // 上一次抛出时的价格
		boolean isMACDChanged=false;   // 上一次抛出到现在MACD 5>60的趋势是否改变
		
		// 模拟每个交易日交易
		for (int i=0; i<dateList.size(); i++)
		{
			
			// 取出一个交易日期
			String transDate=dateList.get(i).toString();
			
			// 创建一个当日的交易账户对象accountDD，并继承昨日的持仓和现金
			AccountDayData accountDD=new AccountDayData();
			accountDD.setPosNum(i);
			accountDD.setDate(transDate);
			accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // 继承昨日的持仓
			accountDD.setCashValue(accountDD_pre.getCashValue());	// 继承昨日的现金
			
			// 检查当前持仓的股票走势状况，先决定是否卖出，并更新持仓股票及各股持仓价格
			List stockHoldList=accountDD.getStockHoldList();
			int stockHoldSize=stockHoldList.size();
			for (int j=stockHoldSize-1; j>=0; j--)
			{
				// 取出一个持股对象
				StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
				
				// 获得此持股的历史数据
				String stockcode=shs.getCode();
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
				// 取出此股前几天的数据
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
			
				
				if (sdd==null || sdd_b1==null || sdd_b2==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
				{
					shs.setCurDate(transDate);
					continue;
				}
				
				TransactionRecordData trd=new TransactionRecordData();
				StockDayData buySDD=shs.getBuySDD();
				
				double wr_wave=sdd.getWR10()-sdd_b1.getWR10();
				double wr_wave1=sdd_b1.getWR10()-sdd_b2.getWR10();
				double wr_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
				
				// 获取前几天的数据
				List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
				List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);  
//				sdd_b1=(StockDayData)pastStockList.get(1);   // 从序列中取出
						
				// 判断此股当前形势，是否出现超买趋势，决定是否卖出
				if ( 
				
				sdd_b1.getCCI14()>100 && sdd.getCCI14()<100
//				(sdd_b2.getWR10()<30 && sdd_b1.getWR10()>30 ) &&
						
//				 (sdd_b1.getWR42()<50 && sdd.getWR42()>50) 
						
//				 ( 
//				 sdd.getDate().endsWith("7")  // 在14:30看盘卖出
//				 &&		 
//				 sdd.getWR42()>70	// 第二天中途出现反向上穿30卖出, 这个值居然是越大越好，因为越大可以避免大波段上涨中途多次下车
//				 ||
//				 sdd.getDate().endsWith("8")  // 第二天收盘卖出
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
//				 (sdd_b1.getReal_rise()<0 && sdd.getReal_rise()<0 && sdd_b1.getClose_rise()+sdd.getClose_rise()<-5 ) ||  // 连续双阴  

//				 (sdd.getReal_rise()<-5) ||  // 当日收阴，阴柱幅度大于5%		
//				 (sdd.getReal_rise()<0 && (sdd.getLow()+sdd.getHigh())/2<sdd.getMa_20())   // 当日收阴，且中位价跌破20日线
				 
//				 (sdd.getReal_rise()<0 && sdd.getHigh_rise()-sdd.getLow_rise()>5)   // 当日收阴，最高点到收盘跌幅大于5%	
				 
//				  sdd.getWR100()<10 || sdd.getWR100()>50 
				
				)
				{
					// 当出现CCI超卖指标
//					TransactionRecordData trd=new TransactionRecordData();
//					StockDayData buySDD=shs.getBuySDD();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(buySDD);
					trd.setSaleSDD(sdd);
					
					// cci 收益计算
					double transactionProfit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getClose())/trd.getBuySDD().getClose())*100-0.2;
					trd.setTransactionProfit(transactionProfit);
					
					accountDD.saleTransList.add(trd);
					
					lastSalePrice=sdd.getClose();  // 记录上一次卖出时的价格
					
					// 更新accountDD持仓列表
					accountDD.stockHoldList.remove(j);
					
					// 更新accountDD现金价值
					int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
					int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
				}
				else
				{
					// 如不卖出，就继续持有不变，更新持仓价格
					shs.setCurDate(transDate);
					shs.setCurPrice(sdd.getClose());	
				}
				
			}
			
			
			// 检查股票池里备选的股票走势情况，再决定是否买入，并更新持仓股票
			Iterator it=stockDataMap.keySet().iterator();
			while(it.hasNext())
			{
				
				// 从备选股票池中取出一只股票
				String stockcode=it.next().toString();  
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
			
				if (checkStockHoldList(stockHoldList, stockcode)==true)  // 如果已经持股，则不做增仓买入
				{
					continue;
				}
				
				// 取出此股前几天的数据
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
				
//				if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null || sdd_b4==null || sdd_b5==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
//				{
//					continue;
//				}
//				
//				if (sdd_b6==null || sdd_b7==null || sdd_b8==null || sdd_b9==null)
//				{
//					continue;
//				}
//				
//				if (sdd_b10==null || sdd_b11==null || sdd_b12==null || sdd_b13==null || sdd_b14==null || sdd_b15==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
//				{
//					continue;
//				}
				
				// 获取前几天的数据
				List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
				List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);
				List pastStockList15=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 15);
				List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
				List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
				List pastStockList100=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 100);
				
//				String dateb1=sdd_b1.getDate();   // debug代码
//				System.out.println(dateb1);
//				if (sdd_b1.getDate().contains("2020/11/02"))
//				{
//					int t=1;
//					t++;
//				}
				
				
				// 当出WR超卖决定买入
//				if ( sdd_b1.getWR10()>90 && sdd_b1.getWR6()>90 )
				if ( 
					
					(sdd_b1.getCCI14()<100 && sdd.getCCI14()>100) 
//					sdd_b2.getWR6()>75 && sdd_b2.getWR6()-sdd_b1.getWR6()>10    // WR下穿10个点
//					sdd_b2.getWR6()>50
//					sdd_b2.getWR6()<75 && sdd_b1.getWR6()>75    // WR下穿70
//					&& sdd_b1.getWR6()-sdd_b2.getWR6()>30
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_10()
//					&& !(sdd_b1.getMa_5()<sdd_b1.getMa_10() && sdd_b1.getMa_10()<sdd_b1.getMa_20())   // 非MACD空头排列
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_20()     
//					&& !(sdd_b1.getReal_rise()<0 && sdd_b2.getReal_rise()<0 && sdd_b3.getReal_rise()<0)   // 非三连阴柱
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2) 


//					&& checkPastdaysWR42(transDate, -20, 90);  // 检查从transDate之前20天，是否有超过90的值
//					&& sdd_b1.getWR42()>85 
//					( checkPastdays_WR42_TopNumber(pastStockList, 85)==1 && checkPastdays_WR42_EndNumber(pastStockList1, 60)>=1 )
//					||
						
//					( 
//					sdd_b1.getDate().endsWith("7")  // 在14:30看盘
//					&&
//					checkPastdays_WR42_TopNumber(pastStockList20, 50)==0   // 是从高位下穿							
//					&& 
//					checkPastdays_WR42_EndNumber(pastStockList40, 20)>=20   // 收盘前多次进入WR42的20以下区域
//					&& 
//					sdd_b1.getWR42()<20 	// 收盘时WR42在20以下
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
//					&& sdd_b6.getMa_5()>sdd_b6.getMa_60()     // 非常重要的一个条件！！准确描述了走势形态	
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2)
//					&& checkDayData_MA_dtpl(sdd_b3)
//					&& checkDayData_MA_dtpl(sdd_b4)
//					&& checkDayData_MA_dtpl(sdd_b5)
					
//					&& sdd_b2.getWR100()>50 && sdd_b1.getWR100()<50    // WR100下穿50
						
					)
				{
					
					// 当出现多头排列，就买入，并记录买入交易
					TransactionRecordData trd=new TransactionRecordData();
					trd.setBuySDD(sdd);
					accountDD.buyTransList.add(trd);
					
					// 更新accountDD持仓列表
					StockHoldShare shs=new StockHoldShare();
					
					// 计算可买入股票数量
//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
//					int amount=0;
//					if (accountDD.cashValue>eachStockInvestMoney)
//					{
//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // 剩余现金足够投资一份当前股票
//					}
//					else
//					{
//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金不够投资一份当前股票，则全部买入
//					}
					
					int amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金全部买入
					
					// 添加新买入的持仓股票
					shs.setAmount(amount);
					shs.setCode(sdd.getCode());
					shs.setName(sdd.getName());
					shs.setBuyPrice(sdd.getOpen());
					shs.setBuyDate(sdd.getDate());
					shs.setCurPrice(sdd.getClose());
					shs.setCurDate(sdd.getDate());
					shs.setBuySDD(sdd);
					stockHoldList.add(shs);
					
					// 更新accountDD现金价值
					int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
					int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
					
				}
				
			}
			
			// 更新个人账户的每日账户信息
			Map accountDataMap=psa.getAccountDataMap();
			accountDataMap.put(transDate, accountDD);
			accountDD_pre=accountDD;
			
		}
		
		// 输出投资交易记录，模拟交易金额变化曲线，对比评估交易策略
		List transactionDataList=generateTransactionDataListFromPSA(psa);
		outputTransactionRecordReport(transactionDataList, "投资组合_CCI指标");
		// code name date_c saledate year days buy_price sale_price profit 
		
//		outputAccountRecordReport(psa); // 输出account的每日投资内容，价格变化，现金价值/总价值  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
		
//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, 易方达消费 
		
	}
	
	// 模拟投资 - 威廉指标策略 WR42 分时
	public void processInvestmentByStrategy_wrzbfs(Map stockDataMap, String startDate, String endDate)
	{
		
		// 创建一个个人模拟账户
		PersonalStockAccount psa=new PersonalStockAccount();
		
		// 获得参考交易日期队列  - 切换日线数据/分时数据的时间标尺
//		List dateList=CommonTool.getDateReferenceList(startDate, endDate);		// 以上证指数的交易日期为参考值
		List dateList=CommonTool.getDateReferenceList(startDate, endDate, 30);		// 以上证指数的交易分时为参考值 - 待开发
				
		// 创建昨天的accountDD_pre
 		AccountDayData accountDD_pre=new AccountDayData();  
		accountDD_pre.setCashValue(psa.investMoney);
		
		double lastSalePrice=0;  // 上一次抛出时的价格
		boolean isMACDChanged=false;   // 上一次抛出到现在MACD 5>60的趋势是否改变
		
		// 模拟每个交易日交易
		for (int i=0; i<dateList.size(); i++)
		{
			
			// 取出一个交易日期
			String transDate=dateList.get(i).toString();
			
			// 创建一个当日的交易账户对象accountDD，并继承昨日的持仓和现金
			AccountDayData accountDD=new AccountDayData();
			accountDD.setPosNum(i);
			accountDD.setDate(transDate);
			accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // 继承昨日的持仓
			accountDD.setCashValue(accountDD_pre.getCashValue());	// 继承昨日的现金
			
			// 检查当前持仓的股票走势状况，先决定是否卖出，并更新持仓股票及各股持仓价格
			List stockHoldList=accountDD.getStockHoldList();
			int stockHoldSize=stockHoldList.size();
			for (int j=stockHoldSize-1; j>=0; j--)
			{
				// 取出一个持股对象
				StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
				
				// 获得此持股的历史数据
				String stockcode=shs.getCode();
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
				// 取出此股前几天的数据
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
			
				
				if (sdd==null || sdd_b1==null || sdd_b2==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
				{
					shs.setCurDate(transDate);
					continue;
				}
				
				TransactionRecordData trd=new TransactionRecordData();
				StockDayData buySDD=shs.getBuySDD();
				
				double wr_wave=sdd.getWR10()-sdd_b1.getWR10();
				double wr_wave1=sdd_b1.getWR10()-sdd_b2.getWR10();
				double wr_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
				
				// 获取前几天的数据
				List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
				List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);  
//				sdd_b1=(StockDayData)pastStockList.get(1);   // 从序列中取出
						
				// 判断此股当前形势，是否出现超买趋势，决定是否卖出
				if ( 
//				(sdd_b2.getWR10()<30 && sdd_b1.getWR10()>30 ) &&
						
//				 (sdd_b1.getWR42()<50 && sdd.getWR42()>50) 
						
//				 ( 
//				 sdd.getDate().endsWith("7")  // 在14:30看盘卖出
//				 &&		 
//				 sdd.getWR42()>70	// 第二天中途出现反向上穿30卖出, 这个值居然是越大越好，因为越大可以避免大波段上涨中途多次下车
//				 ||
//				 sdd.getDate().endsWith("8")  // 第二天收盘卖出
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
//				 (sdd_b1.getReal_rise()<0 && sdd.getReal_rise()<0 && sdd_b1.getClose_rise()+sdd.getClose_rise()<-5 ) ||  // 连续双阴  

//				 (sdd.getReal_rise()<-5) ||  // 当日收阴，阴柱幅度大于5%		
//				 (sdd.getReal_rise()<0 && (sdd.getLow()+sdd.getHigh())/2<sdd.getMa_20())   // 当日收阴，且中位价跌破20日线
				 
//				 (sdd.getReal_rise()<0 && sdd.getHigh_rise()-sdd.getLow_rise()>5)   // 当日收阴，最高点到收盘跌幅大于5%	
				 
//				  sdd.getWR100()<10 || sdd.getWR100()>50 
				
				)
				{
					// 当出现WR超卖指标
//					TransactionRecordData trd=new TransactionRecordData();
//					StockDayData buySDD=shs.getBuySDD();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(buySDD);
					trd.setSaleSDD(sdd);
					accountDD.saleTransList.add(trd);
					
					lastSalePrice=sdd.getClose();  // 记录上一次卖出时的价格
					
					// 更新accountDD持仓列表
					accountDD.stockHoldList.remove(j);
					
					// 更新accountDD现金价值
					int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
					int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
				}
				else
				{
					// 如不卖出，就继续持有不变，更新持仓价格
					shs.setCurDate(transDate);
					shs.setCurPrice(sdd.getClose());	
				}
				
			}
			
			
			// 检查股票池里备选的股票走势情况，再决定是否买入，并更新持仓股票
			Iterator it=stockDataMap.keySet().iterator();
			while(it.hasNext())
			{
				
				// 从备选股票池中取出一只股票
				String stockcode=it.next().toString();  
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
			
				if (checkStockHoldList(stockHoldList, stockcode)==true)  // 如果已经持股，则不做增仓买入
				{
					continue;
				}
				
				// 取出此股前几天的数据
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
				
//				if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null || sdd_b4==null || sdd_b5==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
//				{
//					continue;
//				}
//				
//				if (sdd_b6==null || sdd_b7==null || sdd_b8==null || sdd_b9==null)
//				{
//					continue;
//				}
//				
//				if (sdd_b10==null || sdd_b11==null || sdd_b12==null || sdd_b13==null || sdd_b14==null || sdd_b15==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
//				{
//					continue;
//				}
				
				// 获取前几天的数据
				List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
				List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);
				List pastStockList15=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 15);
				List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
				List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
				List pastStockList100=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 100);
				
//				String dateb1=sdd_b1.getDate();   // debug代码
//				System.out.println(dateb1);
//				if (sdd_b1.getDate().contains("2020/11/02"))
//				{
//					int t=1;
//					t++;
//				}
				
				
				// 当出WR超卖决定买入
//				if ( sdd_b1.getWR10()>90 && sdd_b1.getWR6()>90 )
				if ( 
//					sdd_b2.getWR6()>75 && sdd_b2.getWR6()-sdd_b1.getWR6()>10    // WR下穿10个点
//					sdd_b2.getWR6()>50
//					sdd_b2.getWR6()<75 && sdd_b1.getWR6()>75    // WR下穿70
//					&& sdd_b1.getWR6()-sdd_b2.getWR6()>30
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_10()
//					&& !(sdd_b1.getMa_5()<sdd_b1.getMa_10() && sdd_b1.getMa_10()<sdd_b1.getMa_20())   // 非MACD空头排列
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_20()     
//					&& !(sdd_b1.getReal_rise()<0 && sdd_b2.getReal_rise()<0 && sdd_b3.getReal_rise()<0)   // 非三连阴柱
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2) 


//					&& checkPastdaysWR42(transDate, -20, 90);  // 检查从transDate之前20天，是否有超过90的值
//					&& sdd_b1.getWR42()>85 
//					( checkPastdays_WR42_TopNumber(pastStockList, 85)==1 && checkPastdays_WR42_EndNumber(pastStockList1, 60)>=1 )
//					||
						
//					( 
//					sdd_b1.getDate().endsWith("7")  // 在14:30看盘
//					&&
//					checkPastdays_WR42_TopNumber(pastStockList20, 50)==0   // 是从高位下穿							
//					&& 
//					checkPastdays_WR42_EndNumber(pastStockList40, 20)>=20   // 收盘前多次进入WR42的20以下区域
//					&& 
//					sdd_b1.getWR42()<20 	// 收盘时WR42在20以下
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
//					&& sdd_b6.getMa_5()>sdd_b6.getMa_60()     // 非常重要的一个条件！！准确描述了走势形态	
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2)
//					&& checkDayData_MA_dtpl(sdd_b3)
//					&& checkDayData_MA_dtpl(sdd_b4)
//					&& checkDayData_MA_dtpl(sdd_b5)
					
//					&& sdd_b2.getWR100()>50 && sdd_b1.getWR100()<50    // WR100下穿50
						
					)
				{
					
					// 当出现多头排列，就买入，并记录买入交易
					TransactionRecordData trd=new TransactionRecordData();
					trd.setBuySDD(sdd);
					accountDD.buyTransList.add(trd);
					
					// 更新accountDD持仓列表
					StockHoldShare shs=new StockHoldShare();
					
					// 计算可买入股票数量
//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
//					int amount=0;
//					if (accountDD.cashValue>eachStockInvestMoney)
//					{
//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // 剩余现金足够投资一份当前股票
//					}
//					else
//					{
//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金不够投资一份当前股票，则全部买入
//					}
					
					int amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金全部买入
					
					// 添加新买入的持仓股票
					shs.setAmount(amount);
					shs.setCode(sdd.getCode());
					shs.setName(sdd.getName());
					shs.setBuyPrice(sdd.getOpen());
					shs.setBuyDate(sdd.getDate());
					shs.setCurPrice(sdd.getClose());
					shs.setCurDate(sdd.getDate());
					shs.setBuySDD(sdd);
					stockHoldList.add(shs);
					
					// 更新accountDD现金价值
					int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
					int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
					
				}
				
			}
			
			// 更新个人账户的每日账户信息
			Map accountDataMap=psa.getAccountDataMap();
			accountDataMap.put(transDate, accountDD);
			accountDD_pre=accountDD;
			
		}
			
		// 输出投资交易记录，模拟交易金额变化曲线，对比评估交易策略
		List transactionDataList=generateTransactionDataListFromPSA(psa);
		outputTransactionRecordReport(transactionDataList, "投资组合_威廉指标");
		// code name date_c saledate year days buy_price sale_price profit 
		
//		outputAccountRecordReport(psa); // 输出account的每日投资内容，价格变化，现金价值/总价值  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
		
//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, 易方达消费 
		
	}
	
	
	
	// 模拟投资 - 威廉指标策略 WR42
	public void processInvestmentByStrategy_wrzb(Map stockDataMap, String startDate, String endDate)
	{
		
		// 创建一个个人模拟账户
		PersonalStockAccount psa=new PersonalStockAccount();
		
		// 获得参考交易日期队列  - 切换日线数据/分时数据的时间标尺
//		List dateList=CommonTool.getDateReferenceList(startDate, endDate);		// 以上证指数的交易日期为参考值
		List dateList=CommonTool.getDateReferenceList(startDate, endDate, 30);		// 以上证指数的交易分时为参考值 - 待开发
				
		// 创建昨天的accountDD_pre
 		AccountDayData accountDD_pre=new AccountDayData();  
		accountDD_pre.setCashValue(psa.investMoney);
		
		double lastSalePrice=0;  // 上一次抛出时的价格
		boolean isMACDChanged=false;   // 上一次抛出到现在MACD 5>60的趋势是否改变
		
		// 模拟每个交易日交易
		for (int i=0; i<dateList.size(); i++)
		{
			
			// 取出一个交易日期
			String transDate=dateList.get(i).toString();
			
			// 创建一个当日的交易账户对象accountDD，并继承昨日的持仓和现金
			AccountDayData accountDD=new AccountDayData();
			accountDD.setPosNum(i);
			accountDD.setDate(transDate);
			accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // 继承昨日的持仓
			accountDD.setCashValue(accountDD_pre.getCashValue());	// 继承昨日的现金
			
			// 检查当前持仓的股票走势状况，先决定是否卖出，并更新持仓股票及各股持仓价格
			List stockHoldList=accountDD.getStockHoldList();
			int stockHoldSize=stockHoldList.size();
			for (int j=stockHoldSize-1; j>=0; j--)
			{
				// 取出一个持股对象
				StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
				
				// 获得此持股的历史数据
				String stockcode=shs.getCode();
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
				// 取出此股前几天的数据
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
			
				
				if (sdd==null || sdd_b1==null || sdd_b2==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
				{
					shs.setCurDate(transDate);
					continue;
				}
				
				TransactionRecordData trd=new TransactionRecordData();
				StockDayData buySDD=shs.getBuySDD();
				
				double wr_wave=sdd.getWR10()-sdd_b1.getWR10();
				double wr_wave1=sdd_b1.getWR10()-sdd_b2.getWR10();
				double wr_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
				
				// 获取前几天的数据
				List pastStockList=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
//				sdd_b1=(StockDayData)pastStockList.get(1);   // 从序列中取出
						
				// 判断此股当前形势，是否出现超买趋势，决定是否卖出
				if ( 
//				(sdd_b2.getWR10()<30 && sdd_b1.getWR10()>30 ) &&
						
//				 (sdd_b1.getWR42()<50 && sdd.getWR42()>50) 
						
//				 ( 
//				 sdd.getDate().endsWith("7")  // 在14:30看盘卖出
//				 &&		 
				 sdd.getWR42()>70	// 第二天中途出现反向上穿30卖出, 这个值居然是越大越好，因为越大可以避免大波段上涨中途多次下车
//				 ||
//				 sdd.getDate().endsWith("8")  // 第二天收盘卖出
//				 && checkPastdays_WR42_EndNumberRise(pastStockList)>30 
//				 ) 
//				 || 
				 
//				 || checkPastdays_WR42_TopNumber(pastStockList, 85)>2
//				 sdd.getWR42()>50 
						
//				 || wr_profit<-5
//				 (sdd.getHigh_rise()-sdd.getLow_rise()>4 && sdd.getReal_rise()<0) ||
//				 (!checkDayData_MA_dtpl_5_10(sdd_b1)) || (!checkDayData_MA_dtpl_10_20(sdd_b1)) ||
//				 (sdd_b1.getReal_rise()<0 && sdd.getReal_rise()<0 && sdd_b1.getClose_rise()+sdd.getClose_rise()<-5 ) ||  // 连续双阴  

//				 (sdd.getReal_rise()<-5) ||  // 当日收阴，阴柱幅度大于5%		
//				 (sdd.getReal_rise()<0 && (sdd.getLow()+sdd.getHigh())/2<sdd.getMa_20())   // 当日收阴，且中位价跌破20日线
				 
//				 (sdd.getReal_rise()<0 && sdd.getHigh_rise()-sdd.getLow_rise()>5)   // 当日收阴，最高点到收盘跌幅大于5%	
				 
//				  sdd.getWR100()<10 || sdd.getWR100()>50 
				
				)
				{
					// 当出现WR超卖指标
//					TransactionRecordData trd=new TransactionRecordData();
//					StockDayData buySDD=shs.getBuySDD();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(buySDD);
					trd.setSaleSDD(sdd);
					accountDD.saleTransList.add(trd);
					
					lastSalePrice=sdd.getClose();  // 记录上一次卖出时的价格
					
					// 更新accountDD持仓列表
					accountDD.stockHoldList.remove(j);
					
					// 更新accountDD现金价值
					int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
					int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
				}
				else
				{
					// 如不卖出，就继续持有不变，更新持仓价格
					shs.setCurDate(transDate);
					shs.setCurPrice(sdd.getClose());	
				}
				
			}
			
			
			// 检查股票池里备选的股票走势情况，再决定是否买入，并更新持仓股票
			Iterator it=stockDataMap.keySet().iterator();
			while(it.hasNext())
			{
				
				// 从备选股票池中取出一只股票
				String stockcode=it.next().toString();  
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
			
				if (checkStockHoldList(stockHoldList, stockcode)==true)  // 如果已经持股，则不做增仓买入
				{
					continue;
				}
				
				// 取出此股前几天的数据
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
				
//				if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null || sdd_b4==null || sdd_b5==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
//				{
//					continue;
//				}
//				
//				if (sdd_b6==null || sdd_b7==null || sdd_b8==null || sdd_b9==null)
//				{
//					continue;
//				}
//				
//				if (sdd_b10==null || sdd_b11==null || sdd_b12==null || sdd_b13==null || sdd_b14==null || sdd_b15==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
//				{
//					continue;
//				}
				
				// 获取前几天的数据
				List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
				List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);
				List pastStockList15=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 15);
				List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
				List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
				List pastStockList100=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 100);
				
//				String dateb1=sdd_b1.getDate();   // debug代码
//				System.out.println(dateb1);
//				if (sdd_b1.getDate().contains("2020/11/02"))
//				{
//					int t=1;
//					t++;
//				}
				
				
				// 当出WR超卖决定买入
//				if ( sdd_b1.getWR10()>90 && sdd_b1.getWR6()>90 )
				if ( 
//					sdd_b2.getWR6()>75 && sdd_b2.getWR6()-sdd_b1.getWR6()>10    // WR下穿10个点
//					sdd_b2.getWR6()>50
//					sdd_b2.getWR6()<75 && sdd_b1.getWR6()>75    // WR下穿70
//					&& sdd_b1.getWR6()-sdd_b2.getWR6()>30
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_10()
//					&& !(sdd_b1.getMa_5()<sdd_b1.getMa_10() && sdd_b1.getMa_10()<sdd_b1.getMa_20())   // 非MACD空头排列
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_20()     
//					&& !(sdd_b1.getReal_rise()<0 && sdd_b2.getReal_rise()<0 && sdd_b3.getReal_rise()<0)   // 非三连阴柱
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2) 


//					&& checkPastdaysWR42(transDate, -20, 90);  // 检查从transDate之前20天，是否有超过90的值
//					&& sdd_b1.getWR42()>85 
//					( checkPastdays_WR42_TopNumber(pastStockList, 85)==1 && checkPastdays_WR42_EndNumber(pastStockList1, 60)>=1 )
//					||
						
					( 
//					sdd_b1.getDate().endsWith("7")  // 在14:30看盘
//					&&
//					checkPastdays_WR42_TopNumber(pastStockList20, 50)==0   // 是从高位下穿							
//					&& 
//					checkPastdays_WR42_EndNumber(pastStockList40, 20)>=20   // 收盘前多次进入WR42的20以下区域
//					&& 
					sdd_b1.getWR42()<20 	// 收盘时WR42在20以下
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
//					&& sdd_b6.getMa_5()>sdd_b6.getMa_60()     // 非常重要的一个条件！！准确描述了走势形态	
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2)
//					&& checkDayData_MA_dtpl(sdd_b3)
//					&& checkDayData_MA_dtpl(sdd_b4)
//					&& checkDayData_MA_dtpl(sdd_b5)
					
//					&& sdd_b2.getWR100()>50 && sdd_b1.getWR100()<50    // WR100下穿50
						
					)
				{
					
					// 当出现多头排列，就买入，并记录买入交易
					TransactionRecordData trd=new TransactionRecordData();
					trd.setBuySDD(sdd);
					accountDD.buyTransList.add(trd);
					
					// 更新accountDD持仓列表
					StockHoldShare shs=new StockHoldShare();
					
					// 计算可买入股票数量
//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
//					int amount=0;
//					if (accountDD.cashValue>eachStockInvestMoney)
//					{
//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // 剩余现金足够投资一份当前股票
//					}
//					else
//					{
//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金不够投资一份当前股票，则全部买入
//					}
					
					int amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金全部买入
					
					// 添加新买入的持仓股票
					shs.setAmount(amount);
					shs.setCode(sdd.getCode());
					shs.setName(sdd.getName());
					shs.setBuyPrice(sdd.getOpen());
					shs.setBuyDate(sdd.getDate());
					shs.setCurPrice(sdd.getClose());
					shs.setCurDate(sdd.getDate());
					shs.setBuySDD(sdd);
					stockHoldList.add(shs);
					
					// 更新accountDD现金价值
					int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
					int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
					
				}
				
			}
			
			// 更新个人账户的每日账户信息
			Map accountDataMap=psa.getAccountDataMap();
			accountDataMap.put(transDate, accountDD);
			accountDD_pre=accountDD;
			
		}
			
		// 输出投资交易记录，模拟交易金额变化曲线，对比评估交易策略
		List transactionDataList=generateTransactionDataListFromPSA(psa);
		outputTransactionRecordReport(transactionDataList, "投资组合_威廉指标");
		// code name date_c saledate year days buy_price sale_price profit 
		
//		outputAccountRecordReport(psa); // 输出account的每日投资内容，价格变化，现金价值/总价值  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
		
//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, 易方达消费 
		
	}
	
	
	
	
	// 模拟投资 - 威廉指标抄底改进策略 WR10
	public void processInvestmentByStrategy_wrzbcdgj(Map stockDataMap, String startDate, String endDate)
	{
		
		// 创建一个个人模拟账户
		PersonalStockAccount psa=new PersonalStockAccount();
		
		// 获得参考交易日期队列
		List dateList=CommonTool.getDateReferenceList(startDate, endDate);		
		
		// 创建昨天的accountDD_pre
		AccountDayData accountDD_pre=new AccountDayData();  
		accountDD_pre.setCashValue(psa.investMoney);
		
		double lastSalePrice=0;  // 上一次抛出时的价格
		boolean isMACDChanged=false;   // 上一次抛出到现在MACD 5>60的趋势是否改变
		
		// 模拟每个交易日交易
		for (int i=0; i<dateList.size(); i++)
		{
			
			// 取出一个交易日期
			String transDate=dateList.get(i).toString();
			
			// 创建一个当日的交易账户对象accountDD，并继承昨日的持仓和现金
			AccountDayData accountDD=new AccountDayData();
			accountDD.setPosNum(i);
			accountDD.setDate(transDate);
			accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // 继承昨日的持仓
			accountDD.setCashValue(accountDD_pre.getCashValue());	// 继承昨日的现金
			
			// 检查当前持仓的股票走势状况，先决定是否卖出，并更新持仓股票及各股持仓价格
			List stockHoldList=accountDD.getStockHoldList();
			int stockHoldSize=stockHoldList.size();
			for (int j=stockHoldSize-1; j>=0; j--)
			{
				// 取出一个持股对象
				StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
				
				// 获得此持股的历史数据
				String stockcode=shs.getCode();
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
				// 取出此股前几天的数据
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
			
				
				if (sdd==null || sdd_b1==null || sdd_b2==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
				{
					shs.setCurDate(transDate);
					continue;
				}
				
				TransactionRecordData trd=new TransactionRecordData();
				StockDayData buySDD=shs.getBuySDD();
				
				double wr_wave=sdd.getWR10()-sdd_b1.getWR10();
				double wr_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
				// 判断此股当前形势，是否出现超买趋势，决定是否卖出
				if (
				
				 wr_profit<-10   // 止损点
				 || (wr_wave>0)  // 出现WR反向上涨
//				 (sdd_b1.getWR10()<40 && sdd.getWR10()>40)  // 出现WR反向上涨
//				 || (sdd_b2.getWR10()<40 && sdd_b1.getWR10()>40)  // 出现WR反向上涨
//				 || (sdd.getReal_rise()<-5)   // 当日收阴，阴柱幅度大于5%		
//				 (sdd.getReal_rise()<0 && (sdd.getLow()+sdd.getHigh())/2<sdd.getMa_20())  // 当日收阴，且中位价跌破20日线

//				 ||(checkDayData_MA_ktpl(sdd_b1))
//				 ||(sdd.getWR10()>80)
//				 ||(sdd.getClose()<sdd.getMa_5()&&sdd.getClose()<sdd.getMa_10()&&sdd.getClose()<sdd.getMa_20()&&sdd.getClose()<sdd.getMa_60() )
//				 && sdd_b1.getWR10()<40
//				(sdd_b2.getWR10()<30 && sdd_b1.getWR10()>30 ) &&
//				 sdd_b1.getWR6()<50 && sdd.getWR6()>50 
//				 (sdd.getHigh_rise()-sdd.getLow_rise()>4 && sdd.getReal_rise()<0) ||
//				 (!checkDayData_MA_dtpl_5_10(sdd_b1)) || (!checkDayData_MA_dtpl_10_20(sdd_b1)) ||
//				 (sdd_b1.getReal_rise()<0 && sdd.getReal_rise()<0 && sdd_b1.getClose_rise()+sdd.getClose_rise()<-5 ) ||  // 连续双阴  

//				 (sdd.getReal_rise()<-5) ||  // 当日收阴，阴柱幅度大于5%		
//				 (sdd.getReal_rise()<0 && sdd.getHigh_rise()-sdd.getClose_rise()>5) ||  // 当日收阴，最高点到收盘跌幅大于5%	
//				 (sdd.getReal_rise()<0 && (sdd.getLow()+sdd.getHigh())/2<sdd.getMa_20())  // 当日收阴，且中位价跌破20日线
				 
//				  sdd.getWR100()<10 || sdd.getWR100()>50 
				
				)
				{
					// 当出现WR超卖指标

					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(buySDD);
					trd.setSaleSDD(sdd);
					accountDD.saleTransList.add(trd);
					
					lastSalePrice=sdd.getClose();  // 记录上一次卖出时的价格
					
					// 更新accountDD持仓列表
					accountDD.stockHoldList.remove(j);
					
					// 更新accountDD现金价值
					int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
					int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
				}
				else
				{
					// 如不卖出，就继续持有不变，更新持仓价格
					shs.setCurDate(transDate);
					shs.setCurPrice(sdd.getClose());	
				}
				
			}
			
			
			// 检查股票池里备选的股票走势情况，再决定是否买入，并更新持仓股票
			Iterator it=stockDataMap.keySet().iterator();
			while(it.hasNext())
			{
				
				// 从备选股票池中取出一只股票
				String stockcode=it.next().toString();  
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
			
				if (checkStockHoldList(stockHoldList, stockcode)==true)  // 如果已经持股，则不做增仓买入
				{
					continue;
				}
				
				// 取出此股前几天的数据
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
				
				if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null || sdd_b4==null || sdd_b5==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
				{
					continue;
				}
				
				if (sdd_b6==null || sdd_b7==null || sdd_b8==null || sdd_b9==null)
				{
					continue;
				}
				
				if (sdd_b10==null || sdd_b11==null || sdd_b12==null || sdd_b13==null || sdd_b14==null || sdd_b15==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
				{
					continue;
				}
				
				// 当出WR超卖决定买入
//				if ( sdd_b1.getWR10()>90 && sdd_b1.getWR6()>90 )
				double wr_value1=sdd_b2.getWR10();
				double wr_wave1=sdd_b2.getWR10()-sdd_b1.getWR10();
				double rise_wave1=sdd_b1.getClose_rise();
				double wr_speed1=(rise_wave1/wr_wave1)*100;  // 例如：最大10*100/20=50, 最小0/100=0, 普通2*100/40=5，越小越好
				
				double wr_value2=sdd_b3.getWR10();
				double wr_wave2=sdd_b3.getWR10()-sdd_b1.getWR10();
				double rise_wave2=sdd_b2.getClose_rise()+sdd_b1.getClose_rise();
				double wr_speed2=(rise_wave2/wr_wave2)*100;  // 例如：最大10*100/20=50, 最小0/100=0, 普通2*100/40=5，越小越好

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
//					sdd_b2.getWR6()>75 && sdd_b2.getWR6()-sdd_b1.getWR6()>10    // WR下穿10个点
//					sdd_b2.getWR6()>50
//					sdd_b2.getWR6()<75 && sdd_b1.getWR6()>75    // WR下穿70
//					&& sdd_b1.getWR6()-sdd_b2.getWR6()>30
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_10()
//					&& !(sdd_b1.getMa_5()<sdd_b1.getMa_10() && sdd_b1.getMa_10()<sdd_b1.getMa_20())   // 非MACD空头排列
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_20()     
//					&& !(sdd_b1.getReal_rise()<0 && sdd_b2.getReal_rise()<0 && sdd_b3.getReal_rise()<0)   // 非三连阴柱
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2) 


//					&& checkPastdaysWR42(transDate, -20, 90);  // 检查从transDate之前20天，是否有超过90的值
//					&& sdd_b1.getWR42()<50
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_60()
//					&& sdd_b4.getWR42()-sdd_b1.getWR42()>10
//					&& (sdd_b4.getWR42()-sdd_b1.getWR42()>15 || sdd.getOpen()>lastSalePrice) 
//					&& checkDayData_MA_dtpl(sdd_b2)
//					&& checkDayData_MA_dtpl(sdd_b3)
//					&& checkDayData_MA_dtpl(sdd_b4)
					
//					&& sdd_b6.getWR42()<50
//					&& sdd_b10.getWR42()-sdd_b6.getWR42()>15				
//					&& sdd_b6.getMa_5()>sdd_b6.getMa_60()     // 非常重要的一个条件！！准确描述了走势形态	
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2)
//					&& checkDayData_MA_dtpl(sdd_b3)
//					&& checkDayData_MA_dtpl(sdd_b4)
//					&& checkDayData_MA_dtpl(sdd_b5)
					
//					&& sdd_b2.getWR100()>50 && sdd_b1.getWR100()<50    // WR100下穿50
						
					)
				{
					
					// 当出现多头排列，就买入，并记录买入交易
					TransactionRecordData trd=new TransactionRecordData();
					trd.setBuySDD(sdd);
					accountDD.buyTransList.add(trd);
					
					// 更新accountDD持仓列表
					StockHoldShare shs=new StockHoldShare();
					
					// 计算可买入股票数量
//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
//					int amount=0;
//					if (accountDD.cashValue>eachStockInvestMoney)
//					{
//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // 剩余现金足够投资一份当前股票
//					}
//					else
//					{
//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金不够投资一份当前股票，则全部买入
//					}
					
					int amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金全部买入
					
					// 添加新买入的持仓股票
					shs.setAmount(amount);
					shs.setCode(sdd.getCode());
					shs.setName(sdd.getName());
					shs.setBuyPrice(sdd.getOpen());
					shs.setBuyDate(sdd.getDate());
					shs.setCurPrice(sdd.getClose());
					shs.setCurDate(sdd.getDate());
					shs.setBuySDD(sdd);
					stockHoldList.add(shs);
					
					// 更新accountDD现金价值
					int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
					int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
					
				}
				
			}
			
			// 更新个人账户的每日账户信息
			Map accountDataMap=psa.getAccountDataMap();
			accountDataMap.put(transDate, accountDD);
			accountDD_pre=accountDD;
			
		}
			
		// 输出投资交易记录，模拟交易金额变化曲线，对比评估交易策略
		List transactionDataList=generateTransactionDataListFromPSA(psa);
		outputTransactionRecordReport(transactionDataList, "投资组合_威廉指标抄底改进");
		// code name date_c saledate year days buy_price sale_price profit 
		
//		outputAccountRecordReport(psa); // 输出account的每日投资内容，价格变化，现金价值/总价值  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
		
//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, 易方达消费 
		
	}
	
	
	// 模拟投资 - 威廉指标抄底策略 WR10
	public void processInvestmentByStrategy_wrzbcd(Map stockDataMap, String startDate, String endDate)
	{
		
		// 创建一个个人模拟账户
		PersonalStockAccount psa=new PersonalStockAccount();
		
		// 获得参考交易日期队列
		List dateList=CommonTool.getDateReferenceList(startDate, endDate);		
		
		// 创建昨天的accountDD_pre
		AccountDayData accountDD_pre=new AccountDayData();  
		accountDD_pre.setCashValue(psa.investMoney);
		
		double lastSalePrice=0;  // 上一次抛出时的价格
		boolean isMACDChanged=false;   // 上一次抛出到现在MACD 5>60的趋势是否改变
		
		// 模拟每个交易日交易
		for (int i=0; i<dateList.size(); i++)
		{
			
			// 取出一个交易日期
			String transDate=dateList.get(i).toString();
			
			// 创建一个当日的交易账户对象accountDD，并继承昨日的持仓和现金
			AccountDayData accountDD=new AccountDayData();
			accountDD.setPosNum(i);
			accountDD.setDate(transDate);
			accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // 继承昨日的持仓
			accountDD.setCashValue(accountDD_pre.getCashValue());	// 继承昨日的现金
			
			// 检查当前持仓的股票走势状况，先决定是否卖出，并更新持仓股票及各股持仓价格
			List stockHoldList=accountDD.getStockHoldList();
			int stockHoldSize=stockHoldList.size();
			for (int j=stockHoldSize-1; j>=0; j--)
			{
				// 取出一个持股对象
				StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
				
				// 获得此持股的历史数据
				String stockcode=shs.getCode();
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
				// 取出此股前几天的数据
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
			
				
				if (sdd==null || sdd_b1==null || sdd_b2==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
				{
					shs.setCurDate(transDate);
					continue;
				}
				
				TransactionRecordData trd=new TransactionRecordData();
				StockDayData buySDD=shs.getBuySDD();
				
				double wr_wave=sdd.getWR10()-sdd_b1.getWR10();
				double wr_wave1=sdd_b1.getWR10()-sdd_b2.getWR10();
				double wr_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
				// 判断此股当前形势，是否出现超买趋势，决定是否卖出
				if (
				
				 wr_profit<-10   // 止损点
				 || (wr_wave1>0 && sdd_b1.getWR10()>50)
//				 || (sdd_b1.getWR10()<40 && sdd.getWR10()>40)  // 出现WR反向上涨
				 || (sdd_b2.getWR10()<40 && sdd_b1.getWR10()>40)  // 出现WR反向上涨
//				 || (sdd.getReal_rise()<-5)   // 当日收阴，阴柱幅度大于5%		
//				 (sdd.getReal_rise()<0 && (sdd.getLow()+sdd.getHigh())/2<sdd.getMa_20())  // 当日收阴，且中位价跌破20日线

//				 ||(checkDayData_MA_ktpl(sdd_b1))
//				 ||(sdd.getWR10()>80)
//				 ||(sdd.getClose()<sdd.getMa_5()&&sdd.getClose()<sdd.getMa_10()&&sdd.getClose()<sdd.getMa_20()&&sdd.getClose()<sdd.getMa_60() )
//				 && sdd_b1.getWR10()<40
//				(sdd_b2.getWR10()<30 && sdd_b1.getWR10()>30 ) &&
//				 sdd_b1.getWR6()<50 && sdd.getWR6()>50 
//				 (sdd.getHigh_rise()-sdd.getLow_rise()>4 && sdd.getReal_rise()<0) ||
//				 (!checkDayData_MA_dtpl_5_10(sdd_b1)) || (!checkDayData_MA_dtpl_10_20(sdd_b1)) ||
//				 (sdd_b1.getReal_rise()<0 && sdd.getReal_rise()<0 && sdd_b1.getClose_rise()+sdd.getClose_rise()<-5 ) ||  // 连续双阴  

//				 (sdd.getReal_rise()<-5) ||  // 当日收阴，阴柱幅度大于5%		
//				 (sdd.getReal_rise()<0 && sdd.getHigh_rise()-sdd.getClose_rise()>5) ||  // 当日收阴，最高点到收盘跌幅大于5%	
//				 (sdd.getReal_rise()<0 && (sdd.getLow()+sdd.getHigh())/2<sdd.getMa_20())  // 当日收阴，且中位价跌破20日线
				 
//				  sdd.getWR100()<10 || sdd.getWR100()>50 
				
				)
				{
					// 当出现WR超卖指标

					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(buySDD);
					trd.setSaleSDD(sdd);
					accountDD.saleTransList.add(trd);
					
					lastSalePrice=sdd.getClose();  // 记录上一次卖出时的价格
					
					// 更新accountDD持仓列表
					accountDD.stockHoldList.remove(j);
					
					// 更新accountDD现金价值
					int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
					int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
				}
				else
				{
					// 如不卖出，就继续持有不变，更新持仓价格
					shs.setCurDate(transDate);
					shs.setCurPrice(sdd.getClose());	
				}
				
			}
			
			
			// 检查股票池里备选的股票走势情况，再决定是否买入，并更新持仓股票
			Iterator it=stockDataMap.keySet().iterator();
			while(it.hasNext())
			{
				
				// 从备选股票池中取出一只股票
				String stockcode=it.next().toString();  
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
			
				if (checkStockHoldList(stockHoldList, stockcode)==true)  // 如果已经持股，则不做增仓买入
				{
					continue;
				}
				
				// 取出此股前几天的数据
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
				
				if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null || sdd_b4==null || sdd_b5==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
				{
					continue;
				}
				
				if (sdd_b6==null || sdd_b7==null || sdd_b8==null || sdd_b9==null)
				{
					continue;
				}
				
				if (sdd_b10==null || sdd_b11==null || sdd_b12==null || sdd_b13==null || sdd_b14==null || sdd_b15==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
				{
					continue;
				}
				
				// 当出WR超卖决定买入
//				if ( sdd_b1.getWR10()>90 && sdd_b1.getWR6()>90 )
				double wr_value1=sdd_b2.getWR10();
				double wr_wave1=sdd_b2.getWR10()-sdd_b1.getWR10();
				double rise_wave1=sdd_b1.getClose_rise();
				double wr_speed1=(rise_wave1/wr_wave1)*100;  // 例如：最大10*100/20=50, 最小0/100=0, 普通2*100/40=5，越小越好
				
				double wr_value2=sdd_b3.getWR10();
				double wr_wave2=sdd_b3.getWR10()-sdd_b1.getWR10();
				double rise_wave2=sdd_b2.getClose_rise()+sdd_b1.getClose_rise();
				double wr_speed2=(rise_wave2/wr_wave2)*100;  // 例如：最大10*100/20=50, 最小0/100=0, 普通2*100/40=5，越小越好

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
//					sdd_b2.getWR6()>75 && sdd_b2.getWR6()-sdd_b1.getWR6()>10    // WR下穿10个点
//					sdd_b2.getWR6()>50
//					sdd_b2.getWR6()<75 && sdd_b1.getWR6()>75    // WR下穿70
//					&& sdd_b1.getWR6()-sdd_b2.getWR6()>30
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_10()
//					&& !(sdd_b1.getMa_5()<sdd_b1.getMa_10() && sdd_b1.getMa_10()<sdd_b1.getMa_20())   // 非MACD空头排列
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_20()     
//					&& !(sdd_b1.getReal_rise()<0 && sdd_b2.getReal_rise()<0 && sdd_b3.getReal_rise()<0)   // 非三连阴柱
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2) 


//					&& checkPastdaysWR42(transDate, -20, 90);  // 检查从transDate之前20天，是否有超过90的值
//					&& sdd_b1.getWR42()<50
//					&& sdd_b1.getMa_5()>sdd_b1.getMa_60()
//					&& sdd_b4.getWR42()-sdd_b1.getWR42()>10
//					&& (sdd_b4.getWR42()-sdd_b1.getWR42()>15 || sdd.getOpen()>lastSalePrice) 
//					&& checkDayData_MA_dtpl(sdd_b2)
//					&& checkDayData_MA_dtpl(sdd_b3)
//					&& checkDayData_MA_dtpl(sdd_b4)
					
//					&& sdd_b6.getWR42()<50
//					&& sdd_b10.getWR42()-sdd_b6.getWR42()>15				
//					&& sdd_b6.getMa_5()>sdd_b6.getMa_60()     // 非常重要的一个条件！！准确描述了走势形态	
//					&& checkDayData_MA_dtpl(sdd_b1)
//					&& checkDayData_MA_dtpl(sdd_b2)
//					&& checkDayData_MA_dtpl(sdd_b3)
//					&& checkDayData_MA_dtpl(sdd_b4)
//					&& checkDayData_MA_dtpl(sdd_b5)
					
//					&& sdd_b2.getWR100()>50 && sdd_b1.getWR100()<50    // WR100下穿50
						
					)
				{
					
					// 当出现多头排列，就买入，并记录买入交易
					TransactionRecordData trd=new TransactionRecordData();
					trd.setBuySDD(sdd);
					accountDD.buyTransList.add(trd);
					
					// 更新accountDD持仓列表
					StockHoldShare shs=new StockHoldShare();
					
					// 计算可买入股票数量
//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
//					int amount=0;
//					if (accountDD.cashValue>eachStockInvestMoney)
//					{
//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // 剩余现金足够投资一份当前股票
//					}
//					else
//					{
//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金不够投资一份当前股票，则全部买入
//					}
					
					int amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金全部买入
					
					// 添加新买入的持仓股票
					shs.setAmount(amount);
					shs.setCode(sdd.getCode());
					shs.setName(sdd.getName());
					shs.setBuyPrice(sdd.getOpen());
					shs.setBuyDate(sdd.getDate());
					shs.setCurPrice(sdd.getClose());
					shs.setCurDate(sdd.getDate());
					shs.setBuySDD(sdd);
					stockHoldList.add(shs);
					
					// 更新accountDD现金价值
					int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
					int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
					
				}
				
			}
			
			// 更新个人账户的每日账户信息
			Map accountDataMap=psa.getAccountDataMap();
			accountDataMap.put(transDate, accountDD);
			accountDD_pre=accountDD;
			
		}
			
		// 输出投资交易记录，模拟交易金额变化曲线，对比评估交易策略
		List transactionDataList=generateTransactionDataListFromPSA(psa);
		outputTransactionRecordReport(transactionDataList, "投资组合_威廉指标抄底");
		// code name date_c saledate year days buy_price sale_price profit 
		
//		outputAccountRecordReport(psa); // 输出account的每日投资内容，价格变化，现金价值/总价值  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
		
//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, 易方达消费 
		
	}
	
	

	
	
	// 模拟投资 - 多头排列策略
	public void processInvestmentByStrategy_dtpl(Map stockDataMap, String startDate, String endDate)
	{
		
		// 创建一个个人模拟账户
		PersonalStockAccount psa=new PersonalStockAccount();
		
		// 获得参考交易日期队列
		List dateList=CommonTool.getDateReferenceList(startDate, endDate);		
		
		// 创建昨天的accountDD_pre
		AccountDayData accountDD_pre=new AccountDayData();  
		accountDD_pre.setCashValue(psa.investMoney);
		
		// 模拟每个交易日交易
		for (int i=0; i<dateList.size(); i++)
		{
			
			// 取出一个交易日期
			String transDate=dateList.get(i).toString();
			
			// 创建一个当日的交易账户对象accountDD，并继承昨日的持仓和现金
			AccountDayData accountDD=new AccountDayData();
			accountDD.setPosNum(i);
			accountDD.setDate(transDate);
			accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // 继承昨日的持仓
			accountDD.setCashValue(accountDD_pre.getCashValue());	// 继承昨日的现金
			
			// 检查当前持仓的股票走势状况，先决定是否卖出，并更新持仓股票及各股持仓价格
			List stockHoldList=accountDD.getStockHoldList();
			int stockHoldSize=stockHoldList.size();
			for (int j=stockHoldSize-1; j>=0; j--)
			{
				// 取出一个持股对象
				StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
				
				// 获得此持股的历史数据
				String stockcode=shs.getCode();
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
				// 取出此股前几天的数据
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
				
				if (sdd==null || sdd_b1==null || sdd_b2==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
				{
					shs.setCurDate(transDate);
					continue;
				}
				
				// 判断此股当前形势，决定是否卖出
//				if (sdd_b1.getReal_rise()<0 && sdd.getOpen_rise()<0) 
				if (checkDayData_MA_dtpl_10_20(sdd_b2) && !checkDayData_MA_dtpl_10_20(sdd_b1))
//				if (checkDayData_MA_dtpl_5_10(sdd_b2) && !checkDayData_MA_dtpl_5_10(sdd_b1))
				{
					// 当出现两连跌就卖出，记录卖出交易
					TransactionRecordData trd=new TransactionRecordData();
					StockDayData buySDD=shs.getBuySDD();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(buySDD);
					trd.setSaleSDD(sdd);
					accountDD.saleTransList.add(trd);
					
					// 更新accountDD持仓列表
					accountDD.stockHoldList.remove(j);
					
					// 更新accountDD现金价值
					int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
					int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
				}
				else
				{
					// 如不卖出，就继续持有不变，更新持仓价格
					shs.setCurDate(transDate);
					shs.setCurPrice(sdd.getClose());	
				}
				
			}
			
			
			// 检查股票池里备选的股票走势情况，再决定是否买入，并更新持仓股票
			Iterator it=stockDataMap.keySet().iterator();
			while(it.hasNext())
			{
				
				// 从备选股票池中取出一只股票
				String stockcode=it.next().toString();  
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
			
				// 取出此股前几天的数据
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
				StockDayData sdd_b3=CommonTool.getStockDayData(stockDataRecordList, transDate, -3);
				
				if (sdd!=null && sdd_b1!=null)
				{
					System.out.println(sdd_b1.getName()+" "+sdd_b1.getCode()+" "+sdd_b1.getDate()+" "+sdd_b1.getClose());
					System.out.println(sdd.getName()+" "+sdd.getCode()+" "+sdd.getDate()+" "+sdd.getClose());
				}
				
				// 当出现多头排列决定买入
//				if (checkDayData_MA_dtpl(sdd_b1)&&checkDayData_MA_dtpl(sdd_b2)&&checkDayData_MA_dtpl(sdd_b3))
				if (checkDayData_MA_dtpl_10_20(sdd_b1) && !checkDayData_MA_dtpl_10_20(sdd_b2)
//				if (checkDayData_MA_dtpl_5_10(sdd_b1) && !checkDayData_MA_dtpl_5_10(sdd_b2)
//				&& sdd_b1.getClose()>sdd_b1.getMa_60()
//				&& sdd_b2.getClose()>sdd_b2.getMa_60()
//				&& sdd_b1.getMa_10()>sdd_b1.getMa_60()
//				&& sdd_b1.getMa_20()>sdd_b1.getMa_60()
				)
				{
					
					// 当出现多头排列，就买入，并记录买入交易
					TransactionRecordData trd=new TransactionRecordData();
					trd.setBuySDD(sdd);
					accountDD.buyTransList.add(trd);
					
					// 更新accountDD持仓列表
					StockHoldShare shs=new StockHoldShare();
					
					// 计算可买入股票数量
//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
//					int amount=0;
//					if (accountDD.cashValue>eachStockInvestMoney)
//					{
//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // 剩余现金足够投资一份当前股票
//					}
//					else
//					{
//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金不够投资一份当前股票，则全部买入
//					}
					
					int amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金全部买入
					
					// 添加新买入的持仓股票
					shs.setAmount(amount);
					shs.setCode(sdd.getCode());
					shs.setName(sdd.getName());
					shs.setBuyPrice(sdd.getOpen());
					shs.setBuyDate(sdd.getDate());
					shs.setCurPrice(sdd.getClose());
					shs.setCurDate(sdd.getDate());
					shs.setBuySDD(sdd);
					stockHoldList.add(shs);
					
					// 更新accountDD现金价值
					int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
					int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
					
				}
				
			}
			
			// 更新个人账户的每日账户信息
			Map accountDataMap=psa.getAccountDataMap();
			accountDataMap.put(transDate, accountDD);
			accountDD_pre=accountDD;
			
		}
			
		// 输出投资交易记录，模拟交易金额变化曲线，对比评估交易策略
		List transactionDataList=generateTransactionDataListFromPSA(psa);
		outputTransactionRecordReport(transactionDataList, "投资组合_多头排列");
		// code name date_c saledate year days buy_price sale_price profit 
		
		outputAccountRecordReport(psa); // 输出account的每日投资内容，价格变化，现金价值/总价值  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
		
//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, 易方达消费 
		
	}
	
	
	
	// 模拟投资 - 筹码稳定策略
	public void processInvestmentByStrategy_cmwd(Map stockDataMap, String startDate, String endDate)
	{
		
		// 创建一个个人模拟账户
		PersonalStockAccount psa=new PersonalStockAccount();
		
		// 获得参考交易日期队列
		List dateList=CommonTool.getDateReferenceList(startDate, endDate);		
		
		// 创建昨天的accountDD_pre
		AccountDayData accountDD_pre=new AccountDayData();  
		accountDD_pre.setCashValue(psa.investMoney);
		
		// 模拟每个交易日交易
		for (int i=0; i<dateList.size(); i++)
		{
			
			// 取出一个交易日期
			String transDate=dateList.get(i).toString();
			
			// 创建一个当日的交易账户对象accountDD，并继承昨日的持仓和现金
			AccountDayData accountDD=new AccountDayData();
			accountDD.setPosNum(i);
			accountDD.setDate(transDate);
			accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // 继承昨日的持仓
			accountDD.setCashValue(accountDD_pre.getCashValue());	// 继承昨日的现金
			
			// 检查当前持仓的股票走势状况，先决定是否卖出，并更新持仓股票及各股持仓价格
			List stockHoldList=accountDD.getStockHoldList();
			int stockHoldSize=stockHoldList.size();
			for (int j=stockHoldSize-1; j>=0; j--)
			{
				// 取出一个持股对象
				StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
				
				// 获得此持股的历史数据
				String stockcode=shs.getCode();
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
				// 取出此股前几天的数据
				StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
				StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
				StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
				
				if (sdd==null || sdd_b1==null || sdd_b2==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
				{
					shs.setCurDate(transDate);
					continue;
				}
				
				// 判断此股当前形势，如果当天收盘价格低于昨天大部分筹码价格，则当天卖出
				double sdd_sale=sdd_b1.getLow()+(sdd_b1.getHigh()-sdd_b1.getLow())*0.2;   // 低于80%前天股价区间，就卖出
				StockDayData buySDD=shs.getBuySDD();
				
//				double sdd_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
				
				if ( 
//					sdd_profit<-5 || 
					sdd.getClose()<sdd_sale
				)
				{
					// 记录交易
					TransactionRecordData trd=new TransactionRecordData();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(buySDD);
					trd.setSaleSDD(sdd);
					accountDD.saleTransList.add(trd);
					
					// 更新accountDD持仓列表
					accountDD.stockHoldList.remove(j);
					
					// 更新accountDD现金价值
					int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
					int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
				}
				else
				{
					// 如不卖出，就继续持有不变，更新持仓价格
					shs.setCurDate(transDate);
					shs.setCurPrice(sdd.getClose());	
				}
				
			}
			
			
			// 检查股票池里备选的股票走势情况，再决定是否买入，并更新持仓股票
			Iterator it=stockDataMap.keySet().iterator();
			while(it.hasNext())
			{
				
				// 从备选股票池中取出一只股票
				String stockcode=it.next().toString();  
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
			
				// 取出此股前几天的数据
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
				
				// 当昨天收盘价超过前天大部分筹码价格，今天开盘买入
				double sdd_buy=sdd_b2.getLow()+(sdd_b2.getHigh()-sdd_b2.getLow())*0.8;   // 高于80%前天股价区间，就买入
				if ( sdd_b1.getClose()>sdd_buy
//					 && checkDayData_MA_dtpl_5_10(sdd_b1)
//					 && checkDayData_MA_dtpl_10_20(sdd_b1)
					 && checkDayData_MA_dtpl(sdd_b1)
					)
				{
					
					// 当出现多头排列，就买入，并记录买入交易
					TransactionRecordData trd=new TransactionRecordData();
					trd.setBuySDD(sdd);
					accountDD.buyTransList.add(trd);
					
					// 更新accountDD持仓列表
					StockHoldShare shs=new StockHoldShare();
					
					// 计算可买入股票数量
//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
//					int amount=0;
//					if (accountDD.cashValue>eachStockInvestMoney)
//					{
//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // 剩余现金足够投资一份当前股票
//					}
//					else
//					{
//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金不够投资一份当前股票，则全部买入
//					}
					
					int amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金全部买入,以收盘价买入
					
					// 添加新买入的持仓股票
					shs.setAmount(amount);
					shs.setCode(sdd.getCode());
					shs.setName(sdd.getName());
					shs.setBuyPrice(sdd.getOpen());
					shs.setBuyDate(sdd.getDate());
					shs.setCurPrice(sdd.getClose());
					shs.setCurDate(sdd.getDate());
					shs.setBuySDD(sdd);
					stockHoldList.add(shs);
					
					// 更新accountDD现金价值
					int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
					int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
					accountDD.setCashValue(newCashValue);
					accountDD.setStockValue(newStockValue);
					
				}
				
			}
			
			// 更新个人账户的每日账户信息
			Map accountDataMap=psa.getAccountDataMap();
			accountDataMap.put(transDate, accountDD);
			accountDD_pre=accountDD;
			
		}
			
		// 输出投资交易记录，模拟交易金额变化曲线，对比评估交易策略
		List transactionDataList=generateTransactionDataListFromPSA(psa);
		outputTransactionRecordReport(transactionDataList, "投资组合_筹码稳定");
		// code name date_c saledate year days buy_price sale_price profit 
		
//		outputAccountRecordReport(psa); // 输出account的每日投资内容，价格变化，现金价值/总价值  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
		
//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, 易方达消费 
		
	}


	// 模拟投资 - 妖股策略
	public void processInvestmentByStrategy_ygcl(String startDate, String endDate)
	{
		
		
		
		
		
		
		
		
	}
	
	// 模拟投资 - 周内最佳
	public void processInvestmentByStrategy_znzj(Map stockDataMap, String startDate, String endDate)
	{
		
		
		// 创建一个个人模拟账户
		PersonalStockAccount psa=new PersonalStockAccount();
		
		// 获得参考交易日期队列
		List dateList=CommonTool.getDateReferenceList(startDate, endDate);		
		
		// 创建昨天的accountDD_pre
		AccountDayData accountDD_pre=new AccountDayData();  
		accountDD_pre.setCashValue(psa.investMoney);
		
		List xq1List=new ArrayList();
		List xq2List=new ArrayList();
		List xq3List=new ArrayList();
		List xq4List=new ArrayList();
		List xq5List=new ArrayList();
		
		// 模拟每个交易日交易
		for (int i=0; i<dateList.size(); i++)
		{
			
			// 取出一个交易日期
			String transDate=dateList.get(i).toString();
		
			// 检查股票池里备选的股票走势情况，再决定是否买入，并更新持仓股票
			Iterator it=stockDataMap.keySet().iterator();
			while(it.hasNext())
			{
				
				// 从备选股票池中取出一只股票
				String stockcode=it.next().toString();  
				List stockDataRecordList=(List)stockDataMap.get(stockcode);
			
				// 取出此股前几天的数据
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
		
		// 读取全部指数数据
		stockIndexMap=CommonTool.getAllStockIndexDataMap();  // 结构 (type, indexDataList)
		
		// 读取全部股票代码
		String stockCodeListFile="stockcodelist";
		ResultSet rs=CommonTool.readDataFromSASDataSet(stockAllDataFull, stockCodeListFile);
		List stockCodeList=CommonTool.getColumnDataList(rs, "stockcode");
		
		// 对股票代码按规则进行选取
		List researchStockCodeList=new ArrayList();
		
		// 全部选股
		researchStockCodeList=stockCodeList; 	// 选全部股票作为研究样本
		
		// 按板块选股
//		researchStockCodeList=CommonTool.getAllStock_600(stockCodeList);  // 按600板块选股
//		researchStockCodeList=CommonTool.getAllStock_300(stockCodeList);  // 按300板块选股
//		researchStockCodeList=CommonTool.getAllStock_000(stockCodeList);  // 按000板块选股
//		researchStockCodeList=CommonTool.getAllStock_002(stockCodeList);  // 按002板块选股
		
//		String startDate="2017/12/01";
//		String endDate="2017/12/29";
		
		List transactionDataList=search_yg(researchStockCodeList, startDate, endDate, 3);  // 之前3天的数据作为参考
		
		outputTransactionRecordReport(transactionDataList, "妖股选股");
		
	}
	
	
	// 多头排列选股模型
	public void processStockByModel_dtpl(List researchStockCodeList)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename);
			
			System.out.println("Process stock: "+stockcode);
			
			// 例如：0-59(启动前60天), 60-64(买前5日), 65(买入日)
			int obv_days=100; // 观察期
			int sta_days=5;  // 上涨期
			int prof_days=30; // 收益期最少天数
			int pre_days=obv_days+sta_days;
			
			int total_days=obv_days+sta_days+prof_days;  // 总共的交易记录天数
			
			if(stockDataList.size()<total_days)   // 交易记录天数不够判断，放弃
				return;
			
			for (int j=pre_days; j<stockDataList.size(); j++)
			{	
				
				// 多头排列上涨期每天的数据
				StockDayData sdd=(StockDayData)stockDataList.get(j);  // 买入日为j
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				StockDayData sdd_b4=(StockDayData)stockDataList.get(j-4);
				StockDayData sdd_b5=(StockDayData)stockDataList.get(j-5);
				StockDayData sdd_b6=(StockDayData)stockDataList.get(j-6);
				
				// 多头排列上涨期总涨幅
				double total_rise_b=sdd_b1.getClose_rise()+sdd_b2.getClose_rise()+sdd_b3.getClose_rise()+sdd_b4.getClose_rise()+sdd_b5.getClose_rise();
				double sdd_total_value=CommonTool.getDoubleNumberWithTwoBit(sdd.getLiquid_value()/100000000);
				double current_total_value=CommonTool.getStockCurrentLiquidValue(stockDataList);
				
				if (1>0 
				 && checkDayData_MA(sdd_b1) 
				 && checkDayData_MA(sdd_b2) 
				 && checkDayData_MA(sdd_b3) 
				 && checkDayData_MA(sdd_b4) 
				 && checkDayData_MA(sdd_b5) 
				 && checkPastDaysHighPrice(sdd_b1, stockDataList, j, 120) // 检查是否突破了前n天价位
//				 && current_total_value>1000
				 && sdd_b6.getLow()<sdd_b6.getMa_5()  // b6启动前价格在五日均线下
	//			 && total_rise_b>15 && total_rise_b<30  // b1-b5总涨幅大于15%,小于30%
				 && sdd_b1.getClose_rise()>-2 && sdd_b1.getClose_rise()-sdd_b1.getOpen_rise()>-2   // b1为红柱 
				 && sdd_b2.getClose_rise()>-2 && sdd_b2.getClose_rise()-sdd_b2.getOpen_rise()>-2   // b2为红柱 
				 && sdd_b3.getClose_rise()>-2 && sdd_b3.getClose_rise()-sdd_b3.getOpen_rise()>-2   // b3为红柱 
				 && sdd_b4.getClose_rise()>-2 && sdd_b4.getClose_rise()-sdd_b4.getOpen_rise()>-2   // b4为红柱 
				 && sdd_b5.getClose_rise()>-2 && sdd_b5.getClose_rise()-sdd_b5.getOpen_rise()>-2   // b5为红柱 
	//			 && sdd_b1.getMa_5()-sdd_b1.getMa_20()>sdd_b5.getMa_5()-sdd_b5.getMa_20()  // b1的5,20线距大于b5的5,20线距,呈发散
	//			 && (sdd_b1.getMa_5()-sdd_b1.getMa_60())/sdd_b1.getMa_5()<0.3  // b1的5日均线还没有远离60日均线，处于启动期
				)
				{
					
					List preDaysDataList=stockDataList.subList(j-pre_days, j-sta_days-1);
//					int preStockTrend=checkStockTrend(preDaysDataList);  // 0: flat, 1: small rise, 2: middle rise, 3: big rise
					
//					if (preStockTrend==0)
					{
						// 记录输出记录并计算后续收益，动态分析最佳抛出日并记录抛出时的收益值
						for (int k=j; k<stockDataList.size()-3 && k<j+120 ; k++)
						{
							StockDayData sdd_a1=(StockDayData)stockDataList.get(k);
							StockDayData sdd_a2=(StockDayData)stockDataList.get(k+1);
							if (sdd_a1.getOpen()>sdd_a1.getClose() && sdd_a2.getOpen()>sdd_a2.getClose()  // 两个绿柱
							 && sdd_a1.getClose()>sdd_a2.getClose()  // 连续两天下跌
							 && sdd_a2.getLow()<sdd_a2.getMa_10())  // 第二个绿柱最低价刺穿10日均线
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
		
		
		outputTransactionRecordReport(transactionDataList, "多头排列");
		
	}
	

	// 多头排列改进选股模型
	public List processStockByModel_dtplgj(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只ETF或股票的历史所有数据
			String researchcode=((String)researchStockCodeList.get(i));
			List stockDataList;
			if (researchcode.startsWith("index"))
			{
				String stockfilename=researchcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
				System.out.println("Process stock: "+researchcode);
			}
			else
			{
				String stockcode=researchcode.substring(2); // 去掉前缀 sh, sz
				String stockfilename="stock"+stockcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
				System.out.println("Process stock: "+stockcode);
			}
			
			
			// 例如：0-59(启动前60天), 60-64(买前5日), 65(买入日)
			int obv_days=10; // 观察期
			int rise_days=0;  // 上涨期
			int pre_days=obv_days+rise_days;  // 买入前总共时间
			int pastHighPriceDays_distance=0;   // 过去同价位出现时间的距离
//			int hold_days=2500;  // 持有时间
//			int hold_days=15;  // 持有时间
			int hold_days=1000;  // 持有时间
			
			boolean checkAssetsBack=true;
//			boolean checkAssetsBack=false;			
			String assetsBackDate="";   // 资产可用日期：因为持有天数而导致的无资金可用，需要用一个日期来标识资产回笼的日期
			
			for (int j=pre_days; j<stockDataList.size(); j++)
			{	
				
				// 多头排列上涨期每天的数据
				StockDayData sdd=(StockDayData)stockDataList.get(j);  // 买入日为j
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
				
				if (sdd.getDate().compareTo(assetsBackDate)<=0 && checkAssetsBack)   // 检查当前资产是否可用，如果还没有回笼则不能交易
					continue;
				
				// 多头排列上涨期总涨幅
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
//				 && checkPastDaysHighPrice(sdd_b1, stockDataList, j, obv_days) // 检查是否突破了前n天价位
//				 && current_total_value>1000
//				 && sdd_b6.getLow()<sdd_b6.getMa_5()    // b6启动前价格在五日均线下
//				 && total_rise_b>15 && total_rise_b<30  // b1-b5总涨幅大于15%,小于30%
//				 && sdd_b1.getClose_rise()>-2 && sdd_b1.getClose_rise()-sdd_b1.getOpen_rise()>-2   // b1为红柱 
//				 && sdd_b2.getClose_rise()>-2 && sdd_b2.getClose_rise()-sdd_b2.getOpen_rise()>-2   // b2为红柱 
//				 && sdd_b3.getClose_rise()>-2 && sdd_b3.getClose_rise()-sdd_b3.getOpen_rise()>-2   // b3为红柱 
//				 && sdd_b4.getClose_rise()>-2 && sdd_b4.getClose_rise()-sdd_b4.getOpen_rise()>-2   // b4为红柱 
//				 && sdd_b5.getClose_rise()>-2 && sdd_b5.getClose_rise()-sdd_b5.getOpen_rise()>-2   // b5为红柱 
	//			 && sdd_b1.getMa_5()-sdd_b1.getMa_20()>sdd_b5.getMa_5()-sdd_b5.getMa_20()  // b1的5,20线距大于b5的5,20线距,呈发散
	//			 && (sdd_b1.getMa_5()-sdd_b1.getMa_60())/sdd_b1.getMa_5()<0.3  // b1的5日均线还没有远离60日均线，处于启动期
				)
				{
					
						double buy_price=sdd.getOpen();  // 第二天开盘就买，无论价格高低
						
						TransactionRecordData trd=new TransactionRecordData();
						trd.setModelType("dtplgj");
						trd.setModelParam("多头排列天数: 10 "+"多头排列方式: close>5>10>20>60 "+" 持有天数: "+hold_days+" 检查重复持有: "+checkAssetsBack);
						trd.setStockPrt(calculateStockPrt_dtplgj(sdd_b1));
						
						trd.setStockcode(sdd.getCode());
						trd.setBuySDD(sdd);
						trd.setTransactionBuyPrice(buy_price);
						
						int hold_endday_pos=j+hold_days;
						if (hold_endday_pos>stockDataList.size()-1)
						{
							hold_endday_pos=stockDataList.size()-1;
						}
						
						// 设置一个默认的卖出日对象
						StockDayData sdd_end=(StockDayData)stockDataList.get(hold_endday_pos);  // 买入日为j
						double sale_price=sdd_end.getClose();
						double profit=(sdd_end.getClose()-buy_price)/buy_price*100-0.2; 
						sdd_end.setProfit(profit);
						trd.setSaleSDD(sdd_end);   // 默认先把购买当天作为卖出日sdd，以避免为空
						trd.setTransactionSalePrice(sale_price);  // 购买日的收盘价格默认作为卖出价格price
						
						
						for (int s=j+1; s<hold_endday_pos; s++)	// 查看后续n天内的交易决定哪天卖出s
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
							
//							if (sdd_s.getHigh()>sale_price)  // 如果某一天盘中价格上冲到预估的卖出价格，则卖出止盈
//							{
//									double profit=(sdd_s.getClose()-buy_price)/buy_price*100;
//									sdd_s.setProfit(profit);
//									trd.setSaleSDD(sdd_s);
//									trd.setTransactionProfit(profit);
//									break;
//							}
							
//							MarketRDDayData mdd=(MarketRDDayData)marketDataRecordMap.get(sdd_s.getDate());
//							if (mdd!=null && mdd.getDown10()>500) // 如果某一天大盘出现大面积跌停，则收盘时卖出止损
//							{
//									System.out.println(mdd.getDate()+" Down10: "+mdd.getDown10());
//									double profit=(sdd_s.getClose()-buy_price)/buy_price*100-0.2;
//									sdd_s.setProfit(profit);
//									trd.setSaleSDD(sdd_s);
//									trd.setTransactionProfit(profit);
//									break;
//							}
							
//							else if (sdd_s.getClose()<sdd_s.getMa_20()    // 如果某一天收盘出现大跌穿5，10，20日均线，则止损
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
							
							else   // 如果大盘没有发生风险，则记录最后收盘时的收益
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
		
		
		outputTransactionRecordReport(transactionDataList, "多头排列改进");
		
		return transactionDataList;
		
	}
	
	
	// 筹码稳定模型
	public List processStockByModel_cmwd(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只ETF或股票的历史所有数据
			String researchcode=((String)researchStockCodeList.get(i));
			List stockDataList;
			if (researchcode.startsWith("index"))
			{
				String stockfilename=researchcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
				System.out.println("Process stock: "+researchcode);
			}
			else
			{
				String stockcode=researchcode.substring(2); // 去掉前缀 sh, sz
				String stockfilename="stock"+stockcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
				System.out.println("Process stock: "+stockcode);
			}
			
			
			// 例如：0-59(启动前60天), 60-64(买前5日), 65(买入日)
			int obv_days=10; // 观察期
			int rise_days=0;  // 上涨期
			int pre_days=obv_days+rise_days;  // 买入前总共时间
			int hold_days=1000;  // 持有时间
			
			boolean checkAssetsBack=true;
//			boolean checkAssetsBack=false;			
			String assetsBackDate="";   // 资产可用日期：因为持有天数而导致的无资金可用，需要用一个日期来标识资产回笼的日期
			
			for (int j=pre_days; j<stockDataList.size(); j++)
			{
				
				// 多头排列上涨期每天的数据
				StockDayData sdd=(StockDayData)stockDataList.get(j);  // 买入日为j
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
				
				if (sdd.getDate().compareTo(assetsBackDate)<=0 && checkAssetsBack)   // 检查当前资产是否可用，如果还没有回笼则不能交易
					continue;
				
				// 多头排列上涨期总涨幅
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
//				 && checkPastDaysHighPrice(sdd_b1, stockDataList, j, obv_days) // 检查是否突破了前n天价位
//				 && current_total_value>1000
//				 && sdd_b6.getLow()<sdd_b6.getMa_5()    // b6启动前价格在五日均线下
//				 && total_rise_b>15 && total_rise_b<30  // b1-b5总涨幅大于15%,小于30%
//				 && sdd_b1.getClose_rise()>-2 && sdd_b1.getClose_rise()-sdd_b1.getOpen_rise()>-2   // b1为红柱 
//				 && sdd_b2.getClose_rise()>-2 && sdd_b2.getClose_rise()-sdd_b2.getOpen_rise()>-2   // b2为红柱 
//				 && sdd_b3.getClose_rise()>-2 && sdd_b3.getClose_rise()-sdd_b3.getOpen_rise()>-2   // b3为红柱 
//				 && sdd_b4.getClose_rise()>-2 && sdd_b4.getClose_rise()-sdd_b4.getOpen_rise()>-2   // b4为红柱 
//				 && sdd_b5.getClose_rise()>-2 && sdd_b5.getClose_rise()-sdd_b5.getOpen_rise()>-2   // b5为红柱 
	//			 && sdd_b1.getMa_5()-sdd_b1.getMa_20()>sdd_b5.getMa_5()-sdd_b5.getMa_20()  // b1的5,20线距大于b5的5,20线距,呈发散
	//			 && (sdd_b1.getMa_5()-sdd_b1.getMa_60())/sdd_b1.getMa_5()<0.3  // b1的5日均线还没有远离60日均线，处于启动期
				)
				{
					
						double buy_price=0;
						if (sdd.getOpen()> sdd_b1.getClose())  // 第二天开盘超过昨天最高，开盘就买，无论价格高低
						{
							buy_price=sdd.getOpen();  
						}
//						else if (sdd.getHigh()>sdd_b1.getHigh())  // 第二天盘中超过昨天最高，则盘中超过时买
//						{
//							buy_price=sdd_b1.getHigh(); 
//						}
						
						TransactionRecordData trd=new TransactionRecordData();
						trd.setModelType("cmwd");
						trd.setModelParam("筹码稳定: 检查重复持有: "+checkAssetsBack);
						trd.setStockPrt(calculateStockPrt_dtplgj(sdd_b1));
						
						trd.setStockcode(sdd.getCode());
						trd.setBuySDD(sdd);
						trd.setTransactionBuyPrice(buy_price);
						
						int hold_endday_pos=j+hold_days;
						if (hold_endday_pos>stockDataList.size()-1)
						{
							hold_endday_pos=stockDataList.size()-1;
						}
						
						// 设置一个默认的卖出日对象
						StockDayData sdd_end=(StockDayData)stockDataList.get(hold_endday_pos);  // 买入日为j
						double sale_price=sdd_end.getClose();
						double profit=(sdd_end.getClose()-buy_price)/buy_price*100-0.2; 
						sdd_end.setProfit(profit);
						trd.setSaleSDD(sdd_end);   // 默认先把购买当天作为卖出日sdd，以避免为空
						trd.setTransactionSalePrice(sale_price);  // 购买日的收盘价格默认作为卖出价格price
						
						
						for (int s=j+1; s<hold_endday_pos; s++)	// 查看后续n天内的交易决定哪天卖出s
						{
							
							StockDayData sdd_s=(StockDayData)stockDataList.get(s);
							StockDayData sdd_s1=(StockDayData)stockDataList.get(s+1);
							
							
							if ( sdd.getReal_rise()<0 )  // 买入当天跌，sdd_s第二天开盘卖出
							{
								
								sale_price=sdd_s.getOpen();
								
								profit=(sale_price-buy_price)/buy_price*100-0.2;  
								sdd_s.setProfit(profit);
								trd.setSaleSDD(sdd_s);
								trd.setTransactionProfit(profit);
								trd.setTransactionSalePrice(sale_price);
								
								break;
								
							}
							else if ( checkPastDays_CMSD(sdd, sdd_s) )  // 买后第二天出现筹码松动，收盘卖出
							{
								
								sale_price=getSalePrice_CMSD(sdd, sdd_s);
								
								profit=(sale_price-buy_price)/buy_price*100-0.2; 
								sdd_s.setProfit(profit);
								trd.setSaleSDD(sdd_s);
								trd.setTransactionProfit(profit);
								trd.setTransactionSalePrice(sale_price);
								
								break;
							}
							else if ( checkPastDays_CMSD(sdd_s, sdd_s1) ) // 后续天数出现筹码松动，收盘卖出
							{
								sale_price=getSalePrice_CMSD(sdd_s, sdd_s1);
								
								profit=(sale_price-buy_price)/buy_price*100-0.2; 
								sdd_s1.setProfit(profit);
								trd.setSaleSDD(sdd_s1);
								trd.setTransactionProfit(profit);
								trd.setTransactionSalePrice(sale_price);
								
								break;
								
								
							}
							
//							if (sdd_s.getHigh()>sale_price)  // 如果某一天盘中价格上冲到预估的卖出价格，则卖出止盈
//							{
//									double profit=(sdd_s.getClose()-buy_price)/buy_price*100;
//									sdd_s.setProfit(profit);
//									trd.setSaleSDD(sdd_s);
//									trd.setTransactionProfit(profit);
//									break;
//							}
							
//							MarketRDDayData mdd=(MarketRDDayData)marketDataRecordMap.get(sdd_s.getDate());
//							if (mdd!=null && mdd.getDown10()>500) // 如果某一天大盘出现大面积跌停，则收盘时卖出止损
//							{
//									System.out.println(mdd.getDate()+" Down10: "+mdd.getDown10());
//									double profit=(sdd_s.getClose()-buy_price)/buy_price*100-0.2;
//									sdd_s.setProfit(profit);
//									trd.setSaleSDD(sdd_s);
//									trd.setTransactionProfit(profit);
//									break;
//							}
							
//							else if (sdd_s.getClose()<sdd_s.getMa_20()    // 如果某一天收盘出现大跌穿5，10，20日均线，则止损
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
							
							else   // 如果大盘没有发生风险，则记录最后收盘时的收益，继续持有
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
		
		
		outputTransactionRecordReport(transactionDataList, "筹码稳定");
		
		return transactionDataList;
		
	}
	
	
	// 妖股选股模型
	public void processStockByModel_yg(List researchStockCodeList, String startDate, String endDate)
	{
		
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			// 必须的交易记录天数
			int total_days=10;  
		
			if(stockDataList.size()<=total_days)   // 交易记录天数不够判断，放弃
				continue;
			
			int hold_days=2;  // 持有时间
			
//			boolean checkAssetsBack=true;
			boolean checkAssetsBack=false;			
			String assetsBackDate="";   // 资产可用日期：因为持有天数而导致的无资金可用，需要用一个日期来标识资产回笼的日期
			
			for (int j=5; j<stockDataList.size(); j++)
			{	
				
				StockDayData sdd=(StockDayData)stockDataList.get(j);  // 买入日为j
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				StockDayData sdd_b4=(StockDayData)stockDataList.get(j-4);
				StockDayData sdd_b5=(StockDayData)stockDataList.get(j-5);
				
				double total_rise_b=sdd_b1.getClose_rise()+sdd_b2.getClose_rise()+sdd_b3.getClose_rise();
				double sdd_c_openRate=(sdd.getOpen()-sdd_b1.getLow())/(sdd_b1.getHigh()-sdd_b1.getLow());

				if (sdd.getDate().compareTo(assetsBackDate)<0 && checkAssetsBack)   // 检查当前资产是否可用，如果还没有回笼则不能交易
					continue;
				
				if (1>0 
				 && sdd_b1.getClose_rise()<9.9 
				 && sdd_b1.getClose_rise()>0
				 && sdd_b1.getClose()-sdd_b1.getOpen()>=0   // b1为红柱非板 
				 && sdd_b2.getClose_rise()>9.9
				 && sdd_b2.getClose()-sdd_b2.getOpen()>=0   // b2为红柱涨停板 
				 && sdd_b3.getClose_rise()>0
				 && sdd_b3.getClose()-sdd_b3.getOpen()>=0   // b3为红柱 
				 && total_rise_b>20
				 && total_rise_b<30  	// b1-b3总涨幅大于20%,小于30%
				 && sdd.getOpen_rise()<3 && sdd.getOpen_rise()>-9 // 买入当天开盘为低开或小幅高开
//				 && sdd_c.getOpen()<sdd_b1.getOpen()
//				 && sdd_c_openRate<0.2
	//			 && checkIndexEnv(sdd_c)  // 查看之前的指数情况
	//			 && checkOpenEnv(sdd_c)   // 查看当天开盘的盘面情况		
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
						// 创建交易记录对象
						TransactionRecordData trd=new TransactionRecordData();
						
						double buy_price=sdd.getOpen();
						
						// 记录买入日sdd信息
						trd.setStockcode(stockcode);
						trd.setBuySDD(sdd);
						trd.setPreStockDayDataList(preStockDayDataList);   // 在交易对象trd中保存前几天的stock股票数据
						trd.setPreIndexDayDataList(preIndexDayDataList);   // 在交易对象trd中保存前几天的index指数数据
						
						trd.setModelType("yg");
						trd.setModelParam("妖股前检查天数: 3 "+"妖股形态: 2涨停+1红柱 "+" 持有天数: "+hold_days+" 检查重复持有: "+checkAssetsBack);
						trd.setTransactionBuyPrice(buy_price);
						
						
						// 判断并决定卖出日sdd信息
						StockDayData sdd_s;
						if (j+1<stockDataList.size()) // 如果后一天超过，则以最后一天为sdd_a1
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
		
		outputTransactionRecordReport_yg(transactionDataList, "妖股");
	
		
	}
	
	
	// 妖股突破选股模型
	public void processStockByModel_ygtp(List researchStockCodeList, String startDate, String endDate)
	{
		
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			// 必须的交易记录天数
			int total_days=10;  
		
			if(stockDataList.size()<=total_days)   // 交易记录天数不够判断，放弃
				continue;
			
			int hold_days=2;  // 持有时间
			
//			boolean checkAssetsBack=true;
			boolean checkAssetsBack=false;			
			String assetsBackDate="";   // 资产可用日期：因为持有天数而导致的无资金可用，需要用一个日期来标识资产回笼的日期
			
			for (int j=5; j<stockDataList.size(); j++)
			{	
				
				StockDayData sdd=(StockDayData)stockDataList.get(j);  // 买入日为j
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				StockDayData sdd_b4=(StockDayData)stockDataList.get(j-4);
				StockDayData sdd_b5=(StockDayData)stockDataList.get(j-5);
				
				double total_rise_b=sdd_b1.getClose_rise()+sdd_b2.getClose_rise()+sdd_b3.getClose_rise();
				double sdd_c_openRate=(sdd.getOpen()-sdd_b1.getLow())/(sdd_b1.getHigh()-sdd_b1.getLow());

				if (sdd.getDate().compareTo(assetsBackDate)<0 && checkAssetsBack)   // 检查当前资产是否可用，如果还没有回笼则不能交易
					continue;
				
				StockDayData sdd_down=checkPastDaysExistDownDay(stockDataList, sdd_b1.getPosNum(), 2);  // 检查是否有出现首阴
				
				if (sdd_down==null)
				{
					continue;
				}
				
				double riseRate=checkPastDaysRiseRate(stockDataList, sdd_down.getPosNum(), 5);  // 检查down日前几天的涨幅是否巨大
				
				if (riseRate<30)
				{
					continue;
				}
				
				if (1>0 
				 && checkPastDaysHighPrice(sdd_b1, stockDataList, sdd_b1.getPosNum(), 100) // sdd_b1是否突破了前100天的最高点
				 && sdd.getOpen_rise()<9.9 && sdd.getOpen_rise()>-9 // 买入当天开盘可以买入
//				 && sdd_c.getOpen()<sdd_b1.getOpen()
//				 && sdd_c_openRate<0.2
	//			 && checkIndexEnv(sdd_c)  // 查看之前的指数情况
	//			 && checkOpenEnv(sdd_c)   // 查看当天开盘的盘面情况		
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
						// 创建交易记录对象
						TransactionRecordData trd=new TransactionRecordData();
						
						double buy_price=sdd.getOpen();
						
						// 记录买入日sdd信息
						trd.setStockcode(stockcode);
						trd.setBuySDD(sdd);
						trd.setPreStockDayDataList(preStockDayDataList);   // 在交易对象trd中保存前几天的stock股票数据
						trd.setPreIndexDayDataList(preIndexDayDataList);   // 在交易对象trd中保存前几天的index指数数据
						
						trd.setModelType("ygtp");
						trd.setModelParam("妖股前检查天数: 5 "+"妖股形态: 首阴加突破 "+" 持有天数: "+hold_days+" 检查重复持有: "+checkAssetsBack);
						trd.setTransactionBuyPrice(buy_price);
						
						
						// 判断并决定卖出日sdd信息
						StockDayData sdd_s=new StockDayData();
						if (j+1<stockDataList.size()) // 如果后一天超过，则以最后一天为sdd_a1
						{
							for (int k=j+1;k<stockDataList.size();k++)
							{
								sdd_s=(StockDayData)stockDataList.get(k);
								if (sdd_s.getClose_rise()<0 || sdd_s.getReal_rise()<0)  // 出现首阴或者首跌就卖掉
								{
									break;
								}
							}
						
						}
						else
						{
							sdd_s=(StockDayData)stockDataList.get(j);		// 否则就以最后一个交易日抛出卖掉
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
		
		outputTransactionRecordReport_yg(transactionDataList, "妖股突破");
	
		
	}
	
	
	
	
	// 妖股改进选股模型
	public void processStockByModel_yggj(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			// 必须的交易记录天数
			int total_days=5;  
			int pre_days=100;
		
			if(stockDataList.size()<=total_days)   // 交易记录天数不够判断，放弃
				continue;
			
			for (int j=pre_days; j<stockDataList.size(); j++)
			{	
				
				StockDayData sdd_c=(StockDayData)stockDataList.get(j);  // 买入日为j
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				
				double total_rise_b=sdd_b1.getClose_rise()+sdd_b2.getClose_rise()+sdd_b3.getClose_rise();
						
				if (1>0 
				 && sdd_b1.getClose_rise()<9.9 
				 && sdd_b1.getClose_rise()>0
				 && sdd_b1.getClose()-sdd_b1.getOpen()>=0   // b1为红柱非板 
				 && sdd_b2.getClose_rise()>9.9
				 && sdd_b2.getClose()-sdd_b2.getLow()>1   // b2为红柱涨停板 
				 && sdd_b3.getClose_rise()>0
				 && sdd_b3.getClose()-sdd_b3.getLow()>1   // b3为红柱  
				 && total_rise_b>20 && total_rise_b<30  	// b1-b3总涨幅大于25%,小于30%
				 && sdd_c.getOpen_rise()<0 && sdd_c.getOpen_rise()>-9 // 买入当天开盘为低开或小幅高开
	//			 && checkIndexEnv(sdd_c)  // 查看之前的指数情况
	//			 && checkOpenEnv(sdd_c)   // 查看当天开盘的盘面情况		 
	//			 && sdd_c.getClose_rise()-sdd_c.getOpen_rise()>0 && sdd_c.getClose_rise()-sdd_c.getOpen_rise()<4
	//			 && sdd_c.getClose_rise()>0
				 && checkPastDaysHighPrice(sdd_b1, stockDataList, j, pre_days) // 检查是否突破了前n天价位
				)
				{
	
						// 创建交易记录对象
						TransactionRecordData trd=new TransactionRecordData();
						
						// 记录买入日sdd信息
						trd.setStockcode(stockcode);
						trd.setBuySDD(sdd_c);
						
						// 判断并决定卖出日sdd信息
						StockDayData sdd_a1;
						if (j+1<stockDataList.size()) // 如果后一天超过，则以最后一天为sdd_a1
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
		
		outputTransactionRecordReport(transactionDataList, "妖股改进");
	
		
	}
	
	// 妖股双板选股模型
	public void processStockByModel_ygsb(List researchStockCodeList, String startDate, String endDate)
	{
		
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			// 必须的交易记录天数
			int total_days=6;  
		
			if(stockDataList.size()<=total_days)   // 交易记录天数不够判断，放弃
				continue;
			
			for (int j=4; j<stockDataList.size()-1; j++)
			{	
				
				StockDayData sdd_c=(StockDayData)stockDataList.get(j);  // 买入日为j
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				StockDayData sdd_b4=(StockDayData)stockDataList.get(j-4);
				
				double total_rise_b=sdd_b1.getClose_rise()+sdd_b2.getClose_rise()+sdd_b3.getClose_rise();
				
				if (
				 (1>0
				 && sdd_b1.getClose_rise()>9.9
				 && sdd_b1.getClose_rise()-sdd_b1.getOpen_rise()>1   // b1为红柱涨停板 
				 && sdd_b2.getClose_rise()>9.9
				 && sdd_b2.getClose_rise()-sdd_b2.getOpen_rise()>1   // b2为红柱涨停板 
//				 && sdd_b3.getClose_rise()+sdd_b4.getClose_rise()<6  // 此条件不好，限制很多高收益
				 && sdd_c.getOpen_rise()<8
//				 ||
//				 (1>0
//				 && sdd_b1.getClose_rise()<9.9 
//				 && sdd_b1.getClose()-sdd_b1.getOpen()>=0   // b1为红柱非板 
//				 && sdd_b2.getClose_rise()>9.9
//				 && sdd_b2.getClose()-sdd_b2.getLow()>=1   // b2为红柱涨停板 
//				 && sdd_b3.getClose_rise()>0
//				 && sdd_b3.getClose()-sdd_b3.getOpen()>=0   // b3为红柱 
//				 && total_rise_b>20 
//				 && total_rise_b<30  	// b1-b3总涨幅大于20%,小于30%
//				 && sdd_c.getOpen_rise()<3 && sdd_c.getOpen_rise()>-9 // 买入当天开盘为低开或小幅高开
				 )
				 
	//		     && sdd_b3.getClose_rise()+sdd_b4.getClose_rise()<6
	//			 && sdd_c.getOpen_rise()<3 && sdd_c.getOpen_rise()>-9 // 买入当天开盘为低开或小幅高开
	//			 && checkIndexEnv(sdd_c)  // 查看之前的指数情况
	//			 && checkOpenEnv(sdd_c)   // 查看当天开盘的盘面情况		 
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
						// 创建交易记录对象
						TransactionRecordData trd=new TransactionRecordData();
						
						// 记录买入日sdd信息
						trd.setStockcode(stockcode);
						trd.setBuySDD(sdd_c);
						
						// 判断并决定卖出日sdd信息
						StockDayData sdd_a1;
						if (j+1<stockDataList.size()) // 如果后一天超过，则以最后一天为sdd_a1
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
		
		outputTransactionRecordReport(transactionDataList, "妖股双板");
	
		
	}
	

	
	
	
	// 妖股选股模型
	public List search_yg(List researchStockCodeList, String startDate, String endDate, int preRefDays)
	{
		
		
		String preStartDate=CommonTool.getStockTransDate(startDate, -preRefDays+1);  // 找出含所有参考日期交易记录的起始日期
		
		List transactionDataList=new ArrayList(); 
		

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+preStartDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Search stock by model_yg: "+stockcode);
			
			// 必须的交易记录天数
			int total_days=preRefDays;  
		
			if(stockDataList.size()<total_days)   // 交易记录天数不够判断，放弃
				continue;
			
			for (int j=preRefDays-1; j<stockDataList.size(); j++)
			{	
				
//				StockDayData sdd_c=(StockDayData)stockDataList.get(j);  // 买入日为j
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-2);
				
				double total_rise_b=sdd_b1.getClose_rise()+sdd_b2.getClose_rise()+sdd_b3.getClose_rise();
						
				if (1>0 
				 && sdd_b1.getClose_rise()<9.9 
				 && sdd_b1.getClose_rise()>0
				 && sdd_b1.getClose()-sdd_b1.getOpen()>=0   // b1为红柱非板 
				 && sdd_b2.getClose_rise()>9.9
				 && sdd_b2.getClose()-sdd_b2.getOpen()>=0   // b2为红柱涨停板 
				 && sdd_b3.getClose_rise()>0
				 && sdd_b3.getClose()-sdd_b3.getOpen()>=0   // b3为红柱  
				 && total_rise_b>20 && total_rise_b<30  	// b1-b3总涨幅大于15%,小于30%
//				 && sdd_c.getOpen_rise()<3 && sdd_c.getOpen_rise()>-9 // 买入当天开盘为低开或小幅高开
	//			 && checkIndexEnv(sdd_c)  // 查看之前的指数情况
	//			 && checkOpenEnv(sdd_c)   // 查看当天开盘的盘面情况		 
	//			 && sdd_c.getClose_rise()-sdd_c.getOpen_rise()>0 && sdd_c.getClose_rise()-sdd_c.getOpen_rise()<4
	//			 && sdd_c.getClose_rise()>0
				 
				)
				{

						// 创建交易记录对象
						TransactionRecordData trd=new TransactionRecordData();
						
						// 记录买入日sdd信息
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
		
		// 根据股票类型选择出相应的股指
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
		
		// 查看股指内容
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
//					idd_b1.getReal_rise()<0 && idd_b1.getClose_rise()<0)  // b1, b2股指均为阴柱向下
//				{
//					result=false;  // 不买
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

	
	
	//	横盘突破模型
	public void processStockByModel_hptp(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			int trend_days=100; // 前n天股票走势横盘平坦 5个月
			int pre_days=120;  // 高于过去多少天的股价8个月
			int total_value=300; // 总市值1000亿以上
			double max_wave=20; // 最大波动15%
			
			int prof_days=10;
			int total_days=pre_days+prof_days;  // 总共的交易记录天数
			if(stockDataList.size()<total_days)   // 交易记录天数不够判断，放弃
				continue;
			
			for (int j=pre_days; j<stockDataList.size(); j++)
			{	
				
				// 多头排列上涨期每天的数据
				StockDayData sdd=(StockDayData)stockDataList.get(j);  // 买入日为j
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				
				// 当前总市值
				double sdd_total_value=CommonTool.getDoubleNumberWithTwoBit(sdd.getTotal_value()/100000000);
				double current_total_value=CommonTool.getStockCurrentLiquidValue(stockDataList);
				
				if (1>0 
				 && checkPastDaysHighPrice(sdd_b1, stockDataList, j, pre_days) // 检查是否突破了前n天价位
//				 && sdd_total_value>total_value
//				 && sdd.getClose()/sdd_b3.getOpen()>1.1
//				 && sdd_b1.getClose_rise()>9.9
				)
				{
					
					List preDaysDataList=stockDataList.subList(j-trend_days, j-1);
					boolean preStockTrend=checkStockPreTrend_DDR_RUR(preDaysDataList, max_wave); 
					
					if (preStockTrend==true)
					{
						
						// 记录输出记录并计算后续收益，动态分析最佳抛出日并记录抛出时的收益值
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
							if (srd.getDDR()>15) // 出现回撤超过10%时就结束，计算收益
							{
								break;								
							}
							
						}
						
						transactionDataList.add(trd);
						
				
					}
					
				}  // end if 
				
			}
			
		} // end for 
		
		
		outputTransactionRecordReport(transactionDataList, "横盘突破");
		
	}
	
	
	//	调整突破模型
	public void processStockByModel_tztp(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			int n=10; // 观察前n天股票走势
//			double max_wave=15; // 最大波动15%
		
			if(stockDataList.size()<n)   // 交易记录天数不够判断，放弃
				continue;
			
			for (int j=n; j<stockDataList.size()-2; j++) // 从第n天开始判断是否买入,之前有0~n-1个趋势观测日
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
				
				// 趋势观测日list
				List observeList=stockDataList.subList(j-n, j);    // 过去n天的观测
				StockDayData highestPriceSDD=getHighestPriceSDD(observeList);  // 过去n天的最高价日
				int highPos=highestPriceSDD.getPosNum();
				List beforeHighestList=stockDataList.subList(j-n, highPos);
				
				// 检查是否突破了前n天价位
				if (
					sdd_buy.getClose()>highestPriceSDD.getClose()		   // 当日收盘创新高
					&& sdd_buy.getPosNum()-highestPriceSDD.getPosNum()>2  // 调整天数>=3天
					&& sdd_buy.getPosNum()-highestPriceSDD.getPosNum()<5
//					&& checkDayData_MA_dtpl(sdd_buy)					   // 当天是多头排列
					&& checkDayData_MA_dtpl(beforeHighestList)			   // highest前几天都是多头排列
					&& checkDayData_MA_dtfs(beforeHighestList)			   // highest前几天都是多头发散
					&& sdd_buy.getReal_rise()>0 						   // 当天rise是阳柱上涨
					&& sdd_buy.getMa_macd()>0 							   // 当天macd是阳柱
	//				&& sdd_buy.getMa_macd()>=sdd_buy_b1.getMa_macd()	   // 当天macd比昨天的macd红柱上涨
	//				&& sdd_buy.getClose()/highestPriceSDD.getClose()<1.1   // 买入价比前期高点不能上涨太多
				)
				{
						
						// 如果符合条件，则记录买入，动态分析最佳抛出日并记录抛出时的收益值
						TransactionRecordData trd=new TransactionRecordData();
						trd.setStockcode(stockcode);
						trd.setBuySDD(sdd_buy_a1);  // j+1第二天开盘买入
						trd.setSaleSDD(sdd_buy_a2); // 默认在第三天收盘卖掉
						
						System.out.print("BuyDate: "+sdd_buy_a1.getDate()+" ");
						int days=sdd_buy.getPosNum()-highestPriceSDD.getPosNum();
						System.out.print(" "+highestPriceSDD.getDate()+" ");
						System.out.print(" "+days+" ");
						
						for (int k=j+2; k<stockDataList.size()-1; k++)   // 计算后续收益
						{
							
							StockDayData sdd_sale=(StockDayData)stockDataList.get(k);  // 遍历后面的交易日
							StockDayData sdd_sale_b1=(StockDayData)stockDataList.get(k-1);
							
							if (
							sdd_sale.getReal_rise()<0				// 当天是阴柱下跌
							&& sdd_sale.getClose_rise()<0			// 当天实际是收跌
							&& sdd_sale.getMa_macd()<=sdd_sale_b1.getMa_macd() // 当天macd比昨天的macd出现下降									
							)
							{
								trd.setSaleSDD(sdd_sale);		// 就在当天收盘时以收盘价卖出
								System.out.println("SaleDate: "+sdd_sale.getDate());
								
								break;
							}
							
//							List profitDayDataList=stockDataList.subList(j, k);
//							StockRecordDDR srd=CommonTool.calculateMaxDrawDownBySDD(profitDayDataList);
//							if (srd.getDDR()>15) // 出现回撤超过10%时就结束，计算收益
//							{
//								break;								
//							}
							
						}
						
						transactionDataList.add(trd);
						
				
				}  // end if 
				
			}
			
		} // end for 
		
		
		outputTransactionRecordReport(transactionDataList, "调整突破");
		
	}
	
	
	//	涨停对比模型
	public void processStockByModel_ztdb(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			String code=(String)researchStockCodeList.get(i);
			
			List stockDataList=new ArrayList();
			String stockcode="";
			if (code.startsWith("index"))
			{
				// 获得一只指数的历史所有数据
				stockcode=((String)researchStockCodeList.get(i)).substring(5); // 去掉前缀 index
				String stockfilename="index"+stockcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);

			}
			else
			{
				// 获得一只股票的历史所有数据
				stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
				String stockfilename="stock"+stockcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
				
			}
			
			
			System.out.println("Process stock: "+stockcode);
			
			String stockType=CommonTool.getStockMarketType(stockcode);
			Map stockMarketDataRecordMap=CommonTool.getStockMarketDataRecordMap(stockType); 
			
			int n=2; // 观察前n天股票走势
		
			if(stockDataList.size()<n)   // 交易记录天数不够判断，放弃
				continue;
			
			for (int j=n; j<stockDataList.size()-2; j++) // 从第n天开始判断是否买入,之前有0~n-1个趋势观测日
			{
				
				StockDayData sdd_buy=(StockDayData)stockDataList.get(j);
				StockDayData sdd_buy_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_buy_a1=(StockDayData)stockDataList.get(j+1);
				MarketRDDayData mdd_buy=(MarketRDDayData)stockMarketDataRecordMap.get(sdd_buy.getDate());
				MarketRDDayData mdd_buy_b1=(MarketRDDayData)stockMarketDataRecordMap.get(sdd_buy_b1.getDate());
				MarketRDDayData mdd_buy_a1=(MarketRDDayData)stockMarketDataRecordMap.get(sdd_buy_a1.getDate());
				
				// 检查涨停板变化
				double ztb_riseRate=(double)mdd_buy.getRise10()/(double)mdd_buy_b1.getRise10();
				if (
					1>0
					&& ztb_riseRate>1.7   // 市场涨停板比前一天大幅增加
//					&& mdd_buy.getRise10()>80
					&& sdd_buy.getReal_rise()>0  // 当天是红柱上涨
//					&& sdd_buy.getMa_ddz()-sdd_buy_b1.getMa_ddz()>0  // macd是红柱
//					&& mdd_buy.getRise10()>70 && mdd_buy.getRise10()<200
//					&& sdd_buy.getMa_ddz()>=0
//					&& sdd_buy_b1.getClose_rise()>-3
//					&& checkDayData_MA(sdd_buy)
//					&& mdd_buy.getRise10()>40		// 当天市场涨停板多于m家
				)
				{
						
						// 如果符合条件，则记录买入，动态分析最佳抛出日并记录抛出时的收益值
						TransactionRecordData trd=new TransactionRecordData();
						trd.setStockcode(stockcode);
						trd.setBuySDD(sdd_buy);  // 当天收盘买入,如碰到ETF涨停则必须半途买入，这种极其罕见，历史上只出现过一次
						trd.setSaleSDD(sdd_buy_a1); // 默认在第二天收盘卖掉，如碰到ETF跌停则必须半途卖出，这种也极其罕见
						
						System.out.print("BuyDate: "+sdd_buy.getDate()+" ");						
						
						for (int k=j+1; k<stockDataList.size()-1; k++)   // 计算后续收益
						{
							
							StockDayData sdd_sale=(StockDayData)stockDataList.get(k);  // 遍历后面的交易日
							StockDayData sdd_sale_b1=(StockDayData)stockDataList.get(k-1);
							MarketRDDayData mdd_sale=(MarketRDDayData)stockMarketDataRecordMap.get(sdd_sale.getDate());
							MarketRDDayData mdd_sale_b1=(MarketRDDayData)stockMarketDataRecordMap.get(sdd_sale_b1.getDate());
							
							double profit=0;
							
							// 对于大跌，盘中止损
							double profit_low=((sdd_sale.getLow()-sdd_buy.getClose())/sdd_buy.getClose())*100-0.2;  // 减去手续费0.16和买入价损
							if (profit_low<-2)
							{
								profit=-2;
								
								sdd_sale.profit=profit;
								trd.setSaleSDD(sdd_sale);		// 就在当天收盘时以收盘价卖出
								trd.setTransactionProfit(profit);
								System.out.println("SaleDate: "+sdd_sale.getDate()+" Profit: "+profit);
								
								break;
							}
							else
							{
								// 对于盘中非大跌，按收盘涨停对比决定
								double ztb_downRate=(double)(mdd_sale.getRise10()/(double)mdd_sale_b1.getRise10());
								if (
										1>0
//										&& sdd_sale.getReal_rise()<0
//										&& sdd_sale.getClose_rise()<0
										&& ztb_downRate<0.7	
//										
								)
								{
									
									profit=((sdd_sale.getClose()-sdd_buy.getClose())/sdd_buy.getClose())*100-0.2;  // 减去手续费0.16和买入价损								
									
									sdd_sale.profit=profit;
									trd.setSaleSDD(sdd_sale);		// 就在当天收盘时以收盘价卖出
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
		
		
		outputTransactionRecordReport(transactionDataList, "涨停对比");
		
	}
	
	
	
	//	5%涨跌对比模型
	public void processStockByModel_zddb5(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			String code=(String)researchStockCodeList.get(i);
			
			List stockDataList=new ArrayList();
			String stockcode="";
			if (code.startsWith("index"))
			{
				// 获得一只指数的历史所有数据
				stockcode=((String)researchStockCodeList.get(i)).substring(5); // 去掉前缀 index
				String stockfilename="index"+stockcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);

			}
			else
			{
				// 获得一只股票的历史所有数据
				stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
				String stockfilename="stock"+stockcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
				
			}
			
			
			System.out.println("Process stock: "+stockcode);
			
			String stockType=CommonTool.getStockMarketType(stockcode);
			Map stockMarketDataRecordMap=CommonTool.getStockMarketDataRecordMap(stockType); 
			
			int n=2; // 观察前n天股票走势
		
			if(stockDataList.size()<n)   // 交易记录天数不够判断，放弃
				continue;
			
			for (int j=n; j<stockDataList.size()-2; j++) // 从第n天开始判断是否买入,之前有0~n-1个趋势观测日
			{
				
				StockDayData sdd_buy=(StockDayData)stockDataList.get(j);
				StockDayData sdd_buy_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_buy_a1=(StockDayData)stockDataList.get(j+1);
				MarketRDDayData mdd_buy=(MarketRDDayData)stockMarketDataRecordMap.get(sdd_buy.getDate());
				MarketRDDayData mdd_buy_b1=(MarketRDDayData)stockMarketDataRecordMap.get(sdd_buy_b1.getDate());
				MarketRDDayData mdd_buy_a1=(MarketRDDayData)stockMarketDataRecordMap.get(sdd_buy_a1.getDate());
				
				// 检查5%涨跌对比
				double zd5_compareRate_buy=(double)(mdd_buy.getRise10()+mdd_buy.getRise7()+mdd_buy.getRise5())
						/(double)(mdd_buy.getDown10()+mdd_buy.getDown7()+mdd_buy.getDown5());
				if (
					mdd_buy.getDate().compareTo(lastSaleDate)>0
					&& zd5_compareRate_buy>3   // 市场涨跌5%的家数对比
					&& sdd_buy.getReal_rise()>0  // 当天是红柱上涨
//					&& sdd_buy_b1.getReal_rise()<0  // 昨天是绿柱下跌
//					&& sdd_buy.getMa_5()>sdd_buy.getMa_10() 
//					&& sdd_buy.getMa_10()>sdd_buy.getMa_20()
//					&& mdd_buy.getRise10()>40		// 当天市场涨停板多于m家
				)
				{
						
						// 如果符合条件，则记录买入，动态分析最佳抛出日并记录抛出时的收益值
						TransactionRecordData trd=new TransactionRecordData();
						trd.setStockcode(stockcode);
						trd.setBuySDD(sdd_buy);  // 当天收盘买入,如碰到ETF涨停则必须半途买入，这种极其罕见，历史上只出现过一次
						trd.setSaleSDD(sdd_buy_a1); // 默认在第二天收盘卖掉，如碰到ETF跌停则必须半途卖出，这种也极其罕见
						
						System.out.print("BuyDate: "+sdd_buy.getDate()+" ");						
						
						for (int k=j+1; k<stockDataList.size()-1; k++)   // 计算后续收益
						{
							
							StockDayData sdd_sale=(StockDayData)stockDataList.get(k);  // 遍历后面的交易日
							StockDayData sdd_sale_b1=(StockDayData)stockDataList.get(k-1);
							MarketRDDayData mdd_sale=(MarketRDDayData)stockMarketDataRecordMap.get(sdd_sale.getDate());
							MarketRDDayData mdd_sale_b1=(MarketRDDayData)stockMarketDataRecordMap.get(sdd_sale_b1.getDate());
							
							double profit=0;
							
							// 对于大跌，盘中止损
							if (sdd_sale.getLow_rise()<-2)
							{
								
								profit=((sdd_sale_b1.getClose()*0.98-sdd_buy.getClose())/sdd_buy.getClose())*100-0.2;  // 减去手续费0.16和买入价损
								
								sdd_sale.profit=profit;
								trd.setSaleSDD(sdd_sale);		// 就在当天收盘时以收盘价卖出
								trd.setTransactionProfit(profit);
								System.out.println("SaleDate: "+sdd_sale.getDate()+" Profit: "+profit);
								
								lastSaleDate=sdd_sale.getDate();
								
								break;
							}
							else
							{
								// 对于盘中非大跌，按收盘涨停对比决定
								double zd5_compareRate_sale=(double)(mdd_sale.getRise10()+mdd_sale.getRise7()+mdd_sale.getRise5())
										/(double)(mdd_sale.getDown10()+mdd_sale.getDown7()+mdd_sale.getDown5());
								if (
										1>0
										&& sdd_sale.getReal_rise()<0
										&& zd5_compareRate_sale<2						
								)
								{
									
									profit=((sdd_sale.getClose()-sdd_buy.getClose())/sdd_buy.getClose())*100-0.2;  // 减去手续费0.16和买入价损								
									
									sdd_sale.profit=profit;
									trd.setSaleSDD(sdd_sale);		// 就在当天收盘时以收盘价卖出
									trd.setTransactionProfit(profit);
									System.out.println("SaleDate: "+sdd_sale.getDate()+" Profit: "+profit);
									
									lastSaleDate=sdd_sale.getDate();
									
									break;
								}
						
								
								if (k==stockDataList.size()-2)   // 到了数据的最后一天，则就以最后一天为卖出日计算
								{

									profit=((sdd_sale.getClose()-sdd_buy.getClose())/sdd_buy.getClose())*100-0.2;  // 减去手续费0.16和买入价损								
									
									sdd_sale.profit=profit;
									trd.setSaleSDD(sdd_sale);		// 就在当天收盘时以收盘价卖出
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
		
		
		outputTransactionRecordReport(transactionDataList, "涨跌5对比");
		
	}
	

	//	连涨跟随模型
	public void processStockByModel_lzgs(List researchStockCodeList)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename);
			
			System.out.println("Process stock: "+stockcode);	
	
			int obv_days=100; // 观察期
			int sta_days=5;  // 上涨期
			int prof_days=30; // 收益期最少天数
			int pre_days=obv_days+sta_days;
			
			int total_days=obv_days+sta_days+prof_days;  // 总共的交易记录天数
			
			if(stockDataList.size()<total_days)   // 交易记录天数不够判断，放弃
				return;
			
			for (int j=pre_days; j<stockDataList.size(); j++)
			{	
				
				// 多头排列上涨期每天的数据
				StockDayData sdd=(StockDayData)stockDataList.get(j);  // 买入日为j
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				StockDayData sdd_b4=(StockDayData)stockDataList.get(j-4);
				StockDayData sdd_b5=(StockDayData)stockDataList.get(j-5);
				
				// 多头排列上涨期总涨幅
				double total_rise_b=sdd_b1.getClose_rise()+sdd_b2.getClose_rise()+sdd_b3.getClose_rise()+sdd_b4.getClose_rise()+sdd_b5.getClose_rise();
				double sdd_total_value=CommonTool.getDoubleNumberWithTwoBit(sdd.getLiquid_value()/100000000);
				double current_total_value=CommonTool.getStockCurrentLiquidValue(stockDataList);
				
				if (1>0 
	//			 && checkDayData_MA(sdd_b1) 
				 && checkDayData_MA(sdd_b2) 
				 && checkDayData_MA(sdd_b3) 
				 && checkDayData_MA(sdd_b4) 
	//			 && checkDayData_MA(sdd_b5) 
				 && checkPastDaysHighPrice(sdd, stockDataList, j, 120) // 检查是否突破了前n天价位
	//			 && current_total_value>1000
	//			 && sdd_b6.getLow()<sdd_b6.getMa_5()  // b6启动前价格在五日均线下
	//			 && total_rise_b>15 && total_rise_b<30  // b1-b5总涨幅大于15%,小于30%
				 && sdd.getClose_rise()>0 && sdd.getClose()>sdd.getOpen() && sdd.getClose()>sdd_b1.getHigh()   // c当天为红柱
				 && sdd_b1.getClose()-sdd_b1.getOpen()<0   // b1为绿柱 
				 && sdd_b2.getClose_rise()>0 && sdd_b2.getClose()-sdd_b2.getOpen()>0   // b2为红柱 
				 && sdd_b3.getClose_rise()>0 && sdd_b3.getClose()-sdd_b3.getOpen()>0   // b3为红柱 
				 && sdd_b4.getClose_rise()>0 && sdd_b4.getClose()-sdd_b4.getOpen()>0   // b4为红柱 
	//			 && sdd_b1.getMa_5()-sdd_b1.getMa_20()>sdd_b5.getMa_5()-sdd_b5.getMa_20()  // b1的5,20线距大于b5的5,20线距,呈发散
	//			 && (sdd_b1.getMa_5()-sdd_b1.getMa_60())/sdd_b1.getMa_5()<0.3  // b1的5日均线还没有远离60日均线，处于启动期
				)
				{
					
	//				List preDaysDataList=stockDataList.subList(j-pre_days, j-sta_days-1);
	//				int preStockTrend=checkStockTrend(preDaysDataList);  // 0: flat, 1: small rise, 2: middle rise, 3: big rise
	//				
	//				if (preStockTrend==0)
					{
						// 记录输出记录并计算后续收益，动态分析最佳抛出日并记录抛出时的收益值
						for (int k=j+1; k<stockDataList.size()-3 && k<j+120 ; k++)
						{
							StockDayData sdd_a1=(StockDayData)stockDataList.get(k);
	//						StockDayData sdd_a2=(StockDayData)stockDataList.get(k+1);
							if (sdd_a1.getOpen()>sdd_a1.getClose() )  // 出现绿柱
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
		
		
		outputTransactionRecordReport(transactionDataList, "连涨跟随");
		
		
	}
	
	
	// 上影反弹模型
	public void processStockByModel_syft(List researchStockCodeList)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename);
			
			System.out.println("Process stock: "+stockcode);
			int upPercent=3;
			int downPercent=4;
			double profit=3;
			for (int j=10; j<stockDataList.size()-1; j++)
			{	
				
				// 每天的数据
				StockDayData sdd=(StockDayData)stockDataList.get(j); 
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1); 
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);  // 涨停
				
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				StockDayData sdd_b4=(StockDayData)stockDataList.get(j-4);
				StockDayData sdd_b5=(StockDayData)stockDataList.get(j-5);
				StockDayData sdd_b6=(StockDayData)stockDataList.get(j-6);
				StockDayData sdd_b7=(StockDayData)stockDataList.get(j-7);
				
				StockDayData sdd_a1=(StockDayData)stockDataList.get(j+1);
				
				
					
				if 
				(
					sdd_b3.getClose_rise()<9.9  // b3 非一字涨停，跌停，去掉次新股
					&& sdd_b3.getClose_rise()<9.9
					&& sdd_b4.getClose_rise()<9.9
					&& sdd_b5.getClose_rise()<9.9
					&& sdd_b6.getClose_rise()<9.9
					 && checkDayData_MA(sdd_b3)
					 && checkDayData_MA(sdd_b4) 
					 && checkDayData_MA(sdd_b5) 
					 && checkDayData_MA(sdd_b6) 
					 && checkDayData_MA(sdd_b7)  
					&& sdd_b2.getClose_rise()>9.9 	// b2 是涨停
					&& sdd_b1.getHigh_rise()-sdd_b1.getClose_rise()>upPercent  // b1有长上影线>4%
					&& sdd_b1.getOpen_rise()>0	// b1高开
					&& sdd_b1.getClose()-sdd_b1.getOpen()>0	// b1是红柱
					&& sdd.getLow_rise()<-downPercent	// c当日有大幅下探<-4%
				)
				{
				
					// 创建交易记录
					TransactionRecordData trd=new TransactionRecordData();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(sdd);
					
					// 计算买入、卖出的价格标准
					double buyPrice=sdd_b1.getClose()*(1-downPercent/100);
					double salePrice=buyPrice*(1+profit/100);
					
					// 根据第二天情况计算profit收益
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
					
					// 记录交易结果
					transactionDataList.add(trd);
					
				}
				
			}
			
		}
		
		// 输出全部交易记录到表中
		outputTransactionRecordReport(transactionDataList, "上影反弹");
		
	}
	
	
	//	单针探底模型
	public List processStockByModel_dztd(List researchStockCodeList, String startDate, String endDate)
	{
		
		// 调取历史整体市场数据
		marketDataRecordMap=CommonTool.loadMarketDataRecordMap("all");
		
		List transactionDataList=new ArrayList();
				 
		// 取出每只  股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只ETF或股票的历史所有数据
			String researchcode=((String)researchStockCodeList.get(i));
			List stockDataList;
			if (researchcode.startsWith("index"))
			{
				String stockfilename=researchcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
				System.out.println("Process stock: "+researchcode);
			}
			else
			{
				String stockcode=researchcode.substring(2); // 去掉前缀 sh, sz
				String stockfilename="stock"+stockcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
				System.out.println("Process stock: "+stockcode);
			}
			
			
			int check_days=5;   // 单针后检查买入点的天数
			int hold_days=20;    // 买入后持有的天数
			double td_length=1.5;  // 单针探底的长度: 收盘点比最低点高几个点（计算平均的下探针长度，那些少数远高于平均值的下探针都是交易对象）
//			double buy_rise=2;   // 买入点: 买入点比最低点高几个点（这个不重要，关键是买入价格在下探针的筹码中价格要够低，接近主力的成本）
//			double sale_rise=2;  // 卖出点: 卖出点比买入点高几个点 （可以分批卖出，不要贪财，有赚就行）
//			double over_rise=8;  // 过高获益点: 主力获利比最低点高几个点（如果主力出现盈利较大的卖价，就不能再介入了，以防主力筹码逃走）
//			double loss_rise=5;  // 低止损点: 出现亏损比最低点低几个点（可以补仓一次，摊低成本，一旦解套则立即卖出）
			double down10=500;   // 止损跌停数
			boolean checkAssetsBack=true;
			String assetsBackDate="";   // 资产可用日期：因为持有天数而导致的无资金可用，需要用一个日期来标识资产回笼的日期
			
			for (int j=0; j<stockDataList.size(); j++)
			{	
				
				// 每天的数据
				StockDayData sdd=(StockDayData)stockDataList.get(j); 
				
				if (sdd.getDate().compareTo(assetsBackDate)<0 && checkAssetsBack)   // 检查当前资产是否可用，如果还没有回笼则不能交易
					continue;
				
				double dz_rise=0;
				if (sdd.getClose()>sdd.getOpen())
				{
					// 红柱针
					dz_rise=sdd.getOpen_rise()-sdd.getLow_rise();
				}
				else
				{
					// 绿柱针
					dz_rise=sdd.getClose_rise()-sdd.getLow_rise();
				}
				
				if (dz_rise>td_length)
				{
//					double buy_price=(sdd.getLow()+sdd.getHigh())/2;   // 预估的买入价格：单针日的中间价
//					double buy_price=sdd.getHigh();
//					double over_price=sdd.getLow()*(1+over_rise/100);   // 预估的可能出现高点价格：5个点涨幅
//					double sale_price=buy_price*(1+sale_rise/100);   // 预估的卖出价格：2个点套利
//					double loss_price=sdd.getLow()*(1-loss_rise/100);   // 预估的可能止损点价格： 5个点跌幅
					
					
					int check_endday_pos=j+check_days;
					if (check_endday_pos>stockDataList.size()-1)
					{
						check_endday_pos=stockDataList.size()-1;
					}
						
					for (int b=j+1; b<=check_endday_pos; b++)  // 查看后续check_days天内的交易决定哪天买入b
					{
						
						StockDayData sdd_b=(StockDayData)stockDataList.get(b);
						
//						if ( sdd_b.getHigh()>over_price )  // 如果出现了较高涨幅，则不再进行交易操作
//						{
//							break;
//						}							
						
//						if ( sdd_b.getLow()<buy_price )  // 如果盘中下探到预估的买入价格，则盘中买入
						{
//							
//							if (sdd_b.getOpen()<buy_price)   // 如果是开盘就低于买入价格，则开盘买入
//							{
//								buy_price=sdd_b.getOpen();  
//							}								
							
							double buy_price=sdd_b.getOpen();  // 第二天开盘就买，无论价格高低
							
							TransactionRecordData trd=new TransactionRecordData();
							trd.setModelType("dztd");
							trd.setModelParam("单针探底长度: "+td_length+" 持有天数: "+hold_days+"止损条件当天跌停数: "+down10);
							trd.setStockPrt(calculateStockPrt_dztd(sdd));
							
							trd.setStockcode(sdd.getCode());
							trd.setBuySDD(sdd_b);
							trd.setTransactionBuyPrice(buy_price);
							
							
							int hold_endday_pos=b+hold_days;
							if (hold_endday_pos>stockDataList.size()-1)
							{
								hold_endday_pos=stockDataList.size()-1;
							}
							
							for (int s=b+1; s<=hold_endday_pos; s++)	// 查看后续n天内的交易决定哪天卖出s
							{
								StockDayData sdd_s=(StockDayData)stockDataList.get(s);
//								if (sdd_s.getHigh()>sale_price)  // 如果某一天盘中价格上冲到预估的卖出价格，则卖出止盈
//								{
//										double profit=(sdd_s.getClose()-buy_price)/buy_price*100;
//										sdd_s.setProfit(profit);
//										trd.setSaleSDD(sdd_s);
//										trd.setTransactionProfit(profit);
//										break;
//								}
								
								MarketRDDayData mdd=(MarketRDDayData)marketDataRecordMap.get(sdd_s.getDate());
								
								if (mdd!=null && mdd.getDown10()>down10) // 如果某一天大盘出现大面积跌停，则收盘时卖出止损
								{
										System.out.println(mdd.getDate()+" Down10: "+mdd.getDown10());
										double profit=(sdd_s.getClose()-buy_price)/buy_price*100-0.2;
										sdd_s.setProfit(profit);
										trd.setSaleSDD(sdd_s);
										trd.setTransactionProfit(profit);
										break;
								}
								else   // 如果大盘没有发生风险，则记录最后收盘时的收益
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
							
							break;  // 只做第一次
							
						}
						
					}	
						
				
				}	
				
			}
			
		}
		
		outputTransactionRecordReport(transactionDataList, "单针探底");	
		
		return transactionDataList;
		
	}
	
	
	//	最小市值型
	public void processStockByModel_zxsz(List stockCodeList, int startyear, int endyear)
	{
		
		List transactionDataList=new ArrayList();
		
		List totalMonthStartDateList=getTotalMonthStartDateList();
		
		
		// 获取期间内所有每月第一个交易日的日期
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
		
		
			
		// 查看所有股票历史信息，获得每月1号的所有股票交易记录sdd，并放入可排序的TreeMap中
		Map minlvSddMap=new TreeMap(); // minlvSddMap结构: TreeMap(monthStartDate, TreeMap(marketvalue, sdd));
		
		String stockFileFolder=stockAllDataFull+"\\all";
		for (int i=0; i<stockCodeList.size(); i++)   // 获得每只股票的数据 sddList
		{
				
			// 获得每只股票的历史所有数据
			String stockcode=((String)stockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename);
			
			for (int j=0; j<stockDataList.size(); j++)  // 获得每只股票每天的数据 sdd
			{
				
				StockDayData sdd=(StockDayData)stockDataList.get(j);
				if (sdd.getOpen_rise()>9.9)
				{
					continue;
				}
				
				for (int d=0; d<monthStartDateList.size(); d++)  // 获得每个 monthStartDate
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
							lvSddMap.put(sdd.getLiquid_value(), sdd);  // 按流动市值排序
//							lvSddMap.put(sdd.getTotal_value(), sdd);   // 按总市值排序
							minlvSddMap.put(monthStartDate, lvSddMap);
							
							System.out.println(monthStartDate+": create "+sdd.getCode()+" "+sdd.getDate());
						}
						else
						{
							Map lvSddMap=(TreeMap)minlvSddMap.get(monthStartDate);
							lvSddMap.put(sdd.getLiquid_value(), sdd);  // 按流动市值排序
//							lvSddMap.put(sdd.getTotal_value(), sdd);   // 按总市值排序
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
				if (count>9)  // 仅取前十条市值最小的股票作为交易对象
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
		
		
		outputTransactionRecordReport(transactionDataList, "最小市值");	
		
		
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
		
		// 读取全部股票代码
		String monthstartdatelistfile="monthstartdate";
		String filePath=stockAllDataFull+"\\totalresult\\total_最小市值";
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
	

	
	public boolean checkDayData_MA(StockDayData sdd)  // 默认检测 ma5, ma10, ma20, ma60 数值"多头排列"
	{
		boolean result = false;
		
		if (1>0 
		  && sdd.getClose()>sdd.getMa_10()
		  && sdd.getMa_5()>sdd.getMa_10()
		  && sdd.getMa_10()>sdd.getMa_20()
		  && sdd.getMa_20()>sdd.getMa_60()     // 60日均线是一个蛮重要的指标，必须在20日均线下方才行，否则在行情不好的时候成功率很低
//		  && sdd.getMa_5()>sdd.getMa_60()
		)
		{
			result=true;
		}
		
		return result;	
	}
	
	public boolean checkDayData_MA_dtpl_10_20(StockDayData sdd)  // 最基本的单日ma5, ma10, ma20, ma60 数值"多头排列"
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
	
	public boolean checkDayData_MA_dtpl_5_10(StockDayData sdd)  // 最基本的单日ma5, ma10, ma20, ma60 数值"多头排列"
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
	
	
	public boolean checkDayData_MA_dtpl(StockDayData sdd)  // 最基本的单日ma5, ma10, ma20, ma60 数值"多头排列"
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
	
	

	public boolean checkDayData_MA_dtpl(List sddList)  // 检测多日数据的sdd ma的"多头排列"
	{
		boolean result = true;

		for (int i=0; i<sddList.size(); i++)
		{
			StockDayData sdd=(StockDayData)sddList.get(i);
			boolean sdd_result=checkDayData_MA_dtpl(sdd);
			if (sdd_result==false)  // 只要有一天的ma不符合就返回false
			{
				result=false;
				return result; 
			}
		}
		
		return result;	
		
	}
	
	
	public boolean checkDayData_MA_ktpl(StockDayData sdd)  // 最基本的单日ma5, ma10, ma20, ma60 数值"空头排列"
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
	
	
	public boolean checkDayData_MA_ktpl(List sddList)  // 检测多日数据的sdd ma的"空头排列"
	{
		boolean result = true;

		for (int i=0; i<sddList.size(); i++)
		{
			StockDayData sdd=(StockDayData)sddList.get(i);
			boolean sdd_result=checkDayData_MA_ktpl(sdd);
			if (sdd_result==false)  // 只要有一天的ma不符合就返回false
			{
				result=false;
				return result; 
			}
		}
		
		return result;	
		
	}
	
	
	public boolean checkDayData_MA_dtfs(StockDayData sdd_b1, StockDayData sdd_b2)  // 检测连续2日的ma5, 10, 20, 60 数值"多头发散"
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
	
	public boolean checkDayData_MA_dtfs(List sddList)   // 检测连续多日的ma5, 10, 20, 60 数值"多头发散"
	{
		boolean result = true;
		
		if (sddList.size()<2)
			return false;
		
		for (int i=0; i<sddList.size()-1; i++)
		{
			StockDayData sdd_b1=(StockDayData)sddList.get(i);
			StockDayData sdd_b2=(StockDayData)sddList.get(i+1);
			boolean sdd_result=checkDayData_MA_dtfs(sdd_b1, sdd_b2);
			if (sdd_result==false)  // 只要有一天的ma不符合就返回false
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
		double last=((StockDayData)stockDataList.get(stockDataList.size()-1)).getClose();  // 最后一天收盘值
		
		if (min==0)
		{
			min=100;
		}
		
		double last_min_rise=CommonTool.getDoubleNumberWithTwoBit((last-min)/min);  // 最后一天相比最低点的涨幅
		double max_min_rise=CommonTool.getDoubleNumberWithTwoBit((max-min)/min);  // 最高点和最低点之间波动的涨幅
		
		
		
		
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
		
		// 实际交易日数buyDateNo大于要检查的交易日数days
		if (buyDateNo>days)
		{
			// 从购买日往前数第i个交易日，如果最高价超过当前收盘价，则当前不是新高，之前有套牢盘
			for (int i=1; i<=days; i++)
			{
				StockDayData preSdd=(StockDayData)sddList.get(buyDateNo-i);  // 获得第前i天的数据
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
			
			// 如果实际交易日数buyDateNo不够要检查的交易日数days，则按实际交易日数算
			for (int i=1; i<=buyDateNo; i++)
			{
				StockDayData preSdd=(StockDayData)sddList.get(buyDateNo-i);  // 获得第前i天的数据
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
		
		stockPrt=sdd.getLiquid_value();   // 按市值来决定多头排列用哪个
		
		return stockPrt;
		
	}
	
	public double calculateStockPrt_dztd(StockDayData sdd)
	{
		double stockPrt=0;
		
		stockPrt=sdd.getLiquid_value();   // 按市值来决定多头排列用哪个
		
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
		
		// 实际交易日数buyDateNo大于要检查的交易日数days
		double lowestPrice=10000;
		if (buyDateNo>days)
		{
			// 从购买日往前数第i个交易日,比较最低点价格
			for (int i=1; i<=days; i++)
			{
				StockDayData preSdd=(StockDayData)sddList.get(buyDateNo-i);  // 获得第前i天的数据
				if (preSdd.getMa_ddz()>0)
				{
					return lowestPrice;
				}
				lowestPrice=Math.min(lowestPrice, preSdd.getLow());
			}	
		}
		else
		{
			// 如果实际交易日数buyDateNo不够要检查的交易日数days，则按实际交易日数算
			for (int i=1; i<=buyDateNo; i++)
			{
				StockDayData preSdd=(StockDayData)sddList.get(buyDateNo-i);  // 获得第前i天的数据
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
			// 从购买日往前数第i个交易日，如果最大涨幅超过5%就不参与了
			for (int i=1; i<=days; i++)
			{
				StockDayData preSdd=(StockDayData)sddList.get(buyDateNo-i);  // 获得第前i天的数据
				if (preSdd.getClose_rise()>6)
				{
					result=false;
					break;
				}
			}
			
		}
		else
		{
			// 没有足够的前置交易日记录可供参考，也不参与
			result=false;
		}
		
		return result;
		
	}
	
	
	public StockDayData checkPastDaysExistDownDay(List sddList, int buyDateNo, int days)
	{
		
		StockDayData downDayData=null;
		
		if (buyDateNo>days)
		{
			// 从购买日往前数第i个交易日，如果最大涨幅超过5%就不参与了
			for (int i=1; i<=days; i++)
			{
				StockDayData preSdd=(StockDayData)sddList.get(buyDateNo-i);  // 获得第前i天的数据
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
			// 从购买日往前数第i个交易日，如果最大涨幅超过5%就不参与了
			for (int i=1; i<=days; i++)
			{
				StockDayData preSdd=(StockDayData)sddList.get(buyDateNo-i);  // 获得第前i天的数据
				totalRiseRate=totalRiseRate+preSdd.getClose_rise();
			}
			
		}

		return totalRiseRate;
		
	}
	
	
	
	public boolean checkPastDaysKDJ(List sddList, StockDayData ztSdd, int days)
	{
		
		boolean result=false;
		int ztDateNo=ztSdd.getPosNum();
		
		if (ztDateNo>days)    // ztDateNo: 涨停日序号    days: 之前考察日天数
		{
			// 从购买日往前数第i个交易日，查看KDJ指标
			for (int i=3; i<=days; i++)
			{
				StockDayData sdd_b1=(StockDayData)sddList.get(ztDateNo-i+2);  // 获得第前i-2天的数据
				StockDayData sdd_b3=(StockDayData)sddList.get(ztDateNo-i);  // 获得第前i天的数据
				if (
						sdd_b1.getKdj_k()<20 && sdd_b1.getKdj_d()<20   // K,D<20		
						&& sdd_b1.getKdj_k()>sdd_b1.getKdj_d()	// KD金叉
						&& sdd_b3.getKdj_k()<sdd_b3.getKdj_d()	// KD金叉
						&& sdd_b1.getEq_ratio()>1			// 量比大于1
						&& sdd_b1.getClose()>sdd_b1.getMa_5()   // 站上5日均线		
						
				)
				{
					result=true;
					break;
				}
			}
			
		}
		else
		{
			// 没有足够的前置交易日记录可供参考，也不参与
			result=false;
		}
		
		return result;
		
	}
	
	
	public boolean checkPastDaysZTB(List sddList, StockDayData ztSdd, int days)
	{
		
		boolean result=true;
		int ztDateNo=ztSdd.getPosNum();
		
		if (ztDateNo>days)    // ztDateNo: 涨停日序号    days: 之前考察日天数
		{
			// 从购买日往前数第i个交易日，查看KDJ指标
			for (int i=1; i<=days; i++)
			{

				StockDayData sdd_b=(StockDayData)sddList.get(ztDateNo-i);  // 获得第前i天的数据
				if (
						sdd_b.getClose_rise()>9.9		
				)
				{
					result=false;   // 只要有一个是涨停，就算含有涨停板，就设置结果为false
					break;
				}
			}
			
		}
		else
		{
			// 没有足够的前置交易日记录可供参考，也不参与
			result=true;
		}
		
		return result;
		
	}
	
	
	public boolean checkPastDays_PZZF(List sddList, double topRise)
	{
		
		boolean result=true;
		
		for (int i=0; i<sddList.size(); i++)
		{

			StockDayData sdd=(StockDayData)sddList.get(i);  // 获得第前i天的数据
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
		
		double ddz_ratio=0;  // 返回一个比值，最大ddz柱长和最小ddz柱长的比值，如果根本不满足条件，则返回0
		int m=0;
		int curDDZDateNo=curDDZSdd.getPosNum();
		double max_ddz=-10000;
		double min_ddz=10000;
		
		if (curDDZDateNo>days)    // curDDZDateNo: DDZ的日序号    days: 之前考察的天数
		{
			// 从购买日往前数第i个交易日，查看DDZ指标
			for (int i=1; i<=days; i++)
			{
				
				StockDayData preDDZSdd=(StockDayData)sddList.get(curDDZDateNo-i);  // 获得第前i天的数据
				curDDZSdd=(StockDayData)sddList.get(curDDZDateNo-i+1);  // 获得第前i+1天的数据
				if ( preDDZSdd.getMa_ddz()>0 )
				{
					ddz_ratio=0;
					break;
				}
				else
				{
					max_ddz=Math.max(max_ddz, curDDZSdd.getMa_ddz());   // 找出最大的ddz值
					min_ddz=Math.min(min_ddz, curDDZSdd.getMa_ddz());   // 找出最小的ddz值
					if ( preDDZSdd.getMa_ddz()>curDDZSdd.getMa_ddz() )	// 记录后一天比前一天ddz负值变更大的次数
					{
						m++;
					}
				}
		
			}
			
			if (m>days-1)  // 对于days天，必须要有days-1次不断变小
			{
				ddz_ratio=Math.abs(min_ddz/max_ddz);  // 最大负柱长/最小负柱长
			}

		}
		else
		{
			// 没有足够的前置交易日记录可供参考，也不参与
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
				
				break;		// 只查看之前的b1, b2的macd, 只要macd值没有大跌就交易，而不是查看过去全部macd变化
			}
			else
			{
				break;
			}
			
		}
		
		return result;
		
	}
	
	public boolean checkPastDaysMACDTrends_UP(List pastDaysSddList, int trend)  // 检查MACD上升趋势
	{
		
		boolean result=false;
		int days=pastDaysSddList.size();
		
		for (int i=0; i<days-1; i++)
		{
			StockDayData curSdd=(StockDayData)pastDaysSddList.get(i);
			StockDayData preSdd=(StockDayData)pastDaysSddList.get(i+1); 	
			
			if ( trend==0 || (preSdd.getMa_macd()*trend>0 && curSdd.getMa_macd()*trend>0) )  // 绿柱：trend=-1  红柱：trend=1  无所谓：trend=0
			{
		
				if (preSdd.getMa_macd()<curSdd.getMa_macd())   
				{
					result=true; 
					continue;  // 继续检查下一组macd对比
				}
				else
				{
					result=false;
					break;  // 终止macd对比，返回false
				}
				
			}
			
		}
		
		return result;
		
	}
	
	
	public boolean checkPastDaysMACDTrends_DOWN(List pastDaysSddList, int trend)  // 检查MACD下降趋势
	{
		
		boolean result=false;
		int days=pastDaysSddList.size();
		
		for (int i=0; i<days-1; i++)
		{
			StockDayData curSdd=(StockDayData)pastDaysSddList.get(i);
			StockDayData preSdd=(StockDayData)pastDaysSddList.get(i+1); 	
			
			if ( trend==0 || (preSdd.getMa_macd()*trend>0 && curSdd.getMa_macd()*trend>0) )  // 绿柱：trend=-1  红柱：trend=1  无所谓：trend=0
			{
		
				if (preSdd.getMa_macd()>curSdd.getMa_macd())   
				{
					result=true; 
					continue;  // 继续检查下一组macd对比
				}
				else
				{
					result=false;
					break;  // 终止macd对比，返回false
				}
				
			}

			
			
		}
		
		return result;
		
	}
	
	
	public boolean checkPastDaysMACDTrends_NDBL_DEEP(List pastDaysSddList, double deep)   // 检查MACD底背离深度
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
					maxDeep=preSdd.getMa_macd();  // 找出macd最深度底
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
	
	
	public boolean checkPastDaysMACDTrends_MA20(List pastDaysSddList, int maxDays)  // 检查MACD趋势
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
	
	public boolean checkPastDaysMACDTrends_MA10(List pastDaysSddList, int maxDays)  // 检查MACD趋势
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
		
		String stockcode=buySdd.getCode(); // 去掉前缀 sh, sz
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
				|| sdd_b1.getClose_rise()+sdd_b2.getClose_rise()+sdd_b3.getClose_rise()>10)  // 前几天涨幅过高，不考虑
				{
					result=null;
				}
				else
				{
					String date=sdd.getDate();
					List stockSecondDataRecordList=CommonTool.getStockSecondDataRecordList(stockSecondFileFolder, date, stockcode);
					
					StockSecondData ssd=(StockSecondData)stockSecondDataRecordList.get(0); // 获得9:25分集合竞价的数据
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

	
	// 输出单只股票交易结果，但不生成数据集文件
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
			System.out.print(trd.getSaleSDD().getDate().trim()+" "+days+"天  "+CommonTool.getDoubleNumberWithTwoBit(profit)+"%");
			System.out.println("");
			
		}
		
		double winRate=0;
		int totalCount=rise_count+down_count;
		if (totalCount>0)
		{
			winRate=(double)rise_count/totalCount*100;
		}
		
//		CommonTool.insertDataToSASDataSet(resultFileFolder, filename, transDataList);  // 创建结果表并插入表中
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
	
	// 输出所有交易，包含多只股票，写入数据集文件
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
			System.out.print(trd.getSaleSDD().getDate().trim()+" "+days+"天  "+CommonTool.getDoubleNumberWithTwoBit(profit)+"%");
			System.out.println("");
			
		}
		
		double winRate=0;
		int totalCount=rise_count+down_count;
		if (totalCount>0)
		{
			winRate=(double)rise_count/totalCount*100;
		}
		
		CommonTool.insertDataToSASDataSet(resultFileFolder, filename, transDataList);  // 创建结果表并插入表中
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
				getColumnDef_currentDayData() + "," +   // 买入当天
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
							"'"+getMacdChangeData(trd, 5)+"',"+  // 获得连续5天的变化值拼成一个字符串
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
			System.out.print(trd.getSaleSDD().getDate().trim()+" "+days+"天  "+CommonTool.getDoubleNumberWithTwoBit(profit)+"%");
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
				;    // PE变化，earn变化，profit每年变化单独右键详细查询
		
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
			
//			double profit=trd.getSaleSDD().getOpen_rise()-0.2;  // 默认是第二天收盘抛出，即收盘涨幅
			double profit=0;  // 默认是第二天收盘抛出，即收盘涨幅
			if (trd.getBuySDD().getOpen()!=0)
			{
				profit=((trd.getSaleSDD().getOpen()-trd.getBuySDD().getHigh())/trd.getBuySDD().getHigh())*100;
			}
			
			double profit_open=trd.getSaleSDD().getOpen_rise()-0.2;  // 默认是第二天开盘抛出，即开盘涨幅
			double profit_high=trd.getSaleSDD().getHigh_rise()-0.2;  // 默认是第二天开盘抛出，即开盘涨幅
			double profit_low=trd.getSaleSDD().getLow_rise()-0.2;  // 默认是第二天开盘抛出，即开盘涨幅
			double profit_close=trd.getSaleSDD().getClose_rise()-0.2;  // 默认是第二天开盘抛出，即开盘涨幅
			
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
			
			double profit=0;  // 默认是第二天收盘抛出，即收盘涨幅
			if (trd.getBuySDD().getOpen()!=0)
			{
				profit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getOpen())/trd.getBuySDD().getOpen())*100-0.2;
			}
			
			
			double profit_open=trd.getSaleSDD().getOpen_rise()-0.2;  // 默认是第二天开盘抛出，即开盘涨幅
			double profit_high=trd.getSaleSDD().getHigh_rise()-0.2;  // 默认是第二天开盘抛出，即开盘涨幅
			double profit_low=trd.getSaleSDD().getLow_rise()-0.2;  // 默认是第二天开盘抛出，即开盘涨幅
			double profit_close=trd.getSaleSDD().getClose_rise()-0.2;  // 默认是第二天开盘抛出，即开盘涨幅
			
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
				"buy1Amount varchar(20), sale1Amount varchar(20), count varchar(20), money varchar(20), amount varchar(20), bsp varchar(5)";   // 笔数   成交额	成交量	买卖盘

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
	
	//	涨幅排行
	public void processStockByModel_zfpm(List researchStockCodeList, String startDate, String endDate, int minRiseDays)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename);
			
			System.out.println("Process stock: "+stockcode);
			
			List researchStockDayDataList=new ArrayList();
			for (int j=0; j<stockDataList.size(); j++)
			{	
				
				// 每天的数据
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
				for (int n=m; n<researchStockDayDataList.size(); n++)  // 从当前价格值往后查找最大价格值
				{		
					StockDayData sddn=(StockDayData)researchStockDayDataList.get(n);
					if (sddn.getClose()>maxSdd.getClose())
					{
						maxSdd=sddn;
					}
				}
				
				double RUR=CommonTool.getDoubleNumberWithTwoBit((maxSdd.getClose()-sddm.getClose())*100/sddm.getClose()); // 计算当前价格值为买入点的最大涨幅
				maxSdd.setProfit(RUR);
				
				StockRecordRUR srr=new StockRecordRUR();
				srr.setCurSDD(sddm);
				srr.setMaxSDD(maxSdd);
				srr.setRUR(RUR);
			
				// 记录每日为起点之后的最大上涨波段记录
				RURList.add(srr);
			}
			
			// 再找出所有最大上涨波段记录中最最大的那个
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
		
		outputTransactionRecordReport(transactionDataList, "涨幅排名");	
		
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
			
			// 获取买入日之前此股票的财务信息作为参考数据
			String startDate=buySDD.getDate();
			String stockfilename="stock"+buySDD.getCode();
			String monitorStartDate=CommonTool.getStockTransDate(startDate, -600);	  // 过去三年观测的起始日期
			String monitorEndDate=CommonTool.getStockTransDate(startDate, -1);	
			String condition3=" date>=\""+monitorStartDate+"\" and date<=\""+monitorEndDate+"\"";  // sql 条件中必须用双引号将string数据括起来
			List researchStockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition3);
			StockFinanceIndicator sfi=CommonTool.calculateStockFinanceIndicator(researchStockDataList);
		
			
			// 根据收益统计交易总涨跌家数
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
	
	
	//	开盘抢涨停
	public void processStockByModel_kpqzt(List researchStockCodeList, String startDate, String endDate)
	{
		
		double open_high=0;
		double open_low=-9;
		int top_count=100;
		
		List transactionDataList=new ArrayList();
		TreeMap allDaysStockMap=new TreeMap();  // key=date, value=stockOneDayAllStockMap
		
		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition); 
			
			System.out.println("Process stock: "+stockcode+"("+stockDataList.size()+")");
			
			for (int j=0; j<stockDataList.size()-1; j++)
			{	
				
				// 每天的数据
				StockDayData sdd=(StockDayData)stockDataList.get(j); 
				StockDayData sdd_a1=(StockDayData)stockDataList.get(j+1); // 取得第二天的sdd
				sdd.setSaleSDD(sdd_a1);  // 设置第二天sdd为卖出日
				
				if (sdd.getOpen_rise()>open_high || sdd.getOpen_rise()<open_low)  // 对于开盘涨幅超过open_high和低于open_low的就不考虑了
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
		
		// 对每天的全体股票集合竞价排名进行分析
		Iterator it=allDaysStockMap.keySet().iterator();
		while(it.hasNext())
		{
			// 取出某一天的竞价排名股票数据
			TreeMap stockOneDayAllStockMap=(TreeMap)allDaysStockMap.get(it.next());	
			Iterator sit=stockOneDayAllStockMap.descendingKeySet().iterator();
			int count=1;
			while(sit.hasNext())
			{
				if (count>top_count)  // 仅取前top_count支涨幅最高的股票作为考察对象
					break;
				
				StockDayData sdd=(StockDayData)stockOneDayAllStockMap.get(sit.next());
				
				StockSecondData ssd=checkOpenEnviroment(sdd);  // 如果集合竞价ssd参数符合要求，且前几天的sdd走势也符合要求，返回ssd
				if ( ssd!=null )
				{
					TransactionRecordData trd=new TransactionRecordData();
					trd.setStockcode(sdd.getCode());
					double profit=0;
//					if (sdd.getReal_rise()>0)
					if (1<0)
					{
						profit=((sdd.getSaleSDD().getClose()-sdd.getOpen())/sdd.getOpen())*100-0.2;  // 减去手续费0.16和开盘价损
					}
					else
					{
						profit=((sdd.getSaleSDD().getOpen()-sdd.getOpen())/sdd.getOpen())*100-0.16;  // 减去手续费0.16和开盘价损
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
		
		
		outputTransactionRecordReport_kpqzt(transactionDataList, "开盘抢涨停");	
		
	}
	
	
	//	五日均线模型
	public void processStockByModel_wrjx(List researchStockCodeList)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
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
				 && sdd_total_value>1000 // 500亿流动市值
				 )
				{
					
					TransactionRecordData trd=new TransactionRecordData();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(sdd);
										
					// 记录输出记录并计算后续收益，动态分析最佳抛出日并记录抛出时的收益值
//					for (int k=j+1; k<stockDataList.size()-3 && k<j+120; k++)
					{
						int k=j+1;
						StockDayData sdd_a1=(StockDayData)stockDataList.get(k);
//						if (sdd_a1.getReal_rise()<-2 && sdd_a1.getClose_rise()<0) // 出现绿柱且收盘下跌
						{
							
							double profit=0;
							profit=((sdd_a1.getClose()-sdd.getOpen())/sdd.getOpen())*100-0.2;  // 减去手续费0.16和开盘价损
							sdd_a1.setProfit(profit);
							trd.setSaleSDD(sdd_a1);
							transactionDataList.add(trd);
							break;
							
						}
						
					}
										
					
				}
				
				
			}
				
		}
		
		outputTransactionRecordReport(transactionDataList, "五日均线");	
		
	}
	
	
	//	机构持股
	public void processStockByModel_zjcg(List researchStockCodeList)
	{
		
		// 读入持股记录
		
		
		
		// 循环计算此股票在持股之前三个月，前一个月，后一个月，后三个月
		
		
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename);
			
			System.out.println("Process stock: "+stockcode);
			
			for (int j=0; j<stockDataList.size(); j++)
			{	
				
				// 每天的数据
				StockDayData sdd=(StockDayData)stockDataList.get(j); 
				
				
			}
			
		}
		
		outputTransactionRecordReport(transactionDataList, "");	
		
	}
	
	
	
	//	王佳忠模型
	public void processStockByModel_wjz(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只ETF或股票的历史所有数据
			String researchcode=((String)researchStockCodeList.get(i));
			List stockDataList;
			if (researchcode.startsWith("index"))
			{
				String stockfilename=researchcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
				System.out.println("Process stock: "+researchcode);
			}
			else
			{
				String stockcode=researchcode.substring(2); // 去掉前缀 sh, sz
				String stockfilename="stock"+stockcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
				System.out.println("Process stock: "+stockcode);
			}
			
			int hold_days=20;    // 买入后持有的天数
			double eq_ratio=1.5;
			int k_value=20;
			int d_value=20;
//			double sale_rise=2;  // 卖出点: 卖出点比买入点高几个点 （可以分批卖出，不要贪财，有赚就行）
//			double over_rise=8;  // 过高获益点: 主力获利比最低点高几个点（如果主力出现盈利较大的卖价，就不能再介入了，以防主力筹码逃走）
//			double loss_rise=5;  // 低止损点: 出现亏损比最低点低几个点（可以补仓一次，摊低成本，一旦解套则立即卖出）
			boolean checkAssetsBack=true;
			String assetsBackDate="";   // 资产可用日期：因为持有天数而导致的无资金可用，需要用一个日期来标识资产回笼的日期
			
			
			for (int j=10; j<stockDataList.size()-1; j++)
			{

				StockDayData sdd=(StockDayData)stockDataList.get(j);
		
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				StockDayData sdd_b4=(StockDayData)stockDataList.get(j-4);
				StockDayData sdd_b5=(StockDayData)stockDataList.get(j-5);

				if (sdd.getDate().compareTo(assetsBackDate)<0 && checkAssetsBack)   // 检查当前资产是否可用，如果还没有回笼则不能交易
					continue;
				
				double sdd_total_value=CommonTool.getDoubleNumberWithTwoBit(sdd.getTotal_value()/100000000);
				double current_liquid_value=CommonTool.getStockCurrentLiquidValue(stockDataList);
				
				if (
				sdd_b1.getKdj_k()<k_value && sdd_b1.getKdj_d()<d_value   // K,D<20		
				&& sdd_b1.getKdj_k()>sdd_b1.getKdj_d()	// KD金叉
				&& sdd_b3.getKdj_k()<sdd_b3.getKdj_d()	// KD金叉
				&& sdd_b1.getEq_ratio()>eq_ratio			// 量比大于1
				&& sdd_b1.getOpen()>sdd_b1.getMa_5() && sdd_b1.getClose()>sdd_b1.getMa_5()    // 站上5日均线
//				&& sdd.getReal_rise()>0
				)
				{
					
					double buy_price=sdd.getOpen();  // 第二天开盘就买，无论价格高低
					
					TransactionRecordData trd=new TransactionRecordData();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(sdd);
					trd.setTransactionBuyPrice(buy_price);
					
					
					int hold_endday_pos=j+hold_days;
					if (hold_endday_pos>stockDataList.size()-1)
					{
						hold_endday_pos=stockDataList.size()-1;
					}
					
					for (int s=j+1; s<=hold_endday_pos; s++)	// 查看后续10天内的交易决定哪天卖出s
					{
						StockDayData sdd_s=(StockDayData)stockDataList.get(s);
//						if (sdd_s.getHigh()>sale_price)  // 如果某一天盘中价格上冲到预估的卖出价格，则卖出止盈
//						{
//								double profit=(sdd_s.getClose()-buy_price)/buy_price*100;
//								sdd_s.setProfit(profit);
//								trd.setSaleSDD(sdd_s);
//								trd.setTransactionProfit(profit);
//								break;
//						}
						
//						MarketRDDayData mdd=(MarketRDDayData)marketDataRecordMap.get(sdd_s.getDate());
//						
//						if (mdd.getDown10()>500) // 如果某一天大盘出现大面积跌停，则收盘时卖出止损
//						{
//								double profit=(sdd_s.getClose()-buy_price)/buy_price*100-0.2;
//								sdd_s.setProfit(profit);
//								trd.setSaleSDD(sdd_s);
//								trd.setTransactionProfit(profit);
//								break;
//						}
//						else   // 如果大盘没有发生风险，则记录最后收盘时的收益
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
		
		outputTransactionRecordReport(transactionDataList, "王佳忠选股");	
		
	}	
	
	
	
	//	王佳忠模型初始研究
	public void processStockByModel_wjzcs(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
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
				&& sdd_b1.getKdj_k()>sdd_b1.getKdj_d()	// KD金叉
				&& sdd_b3.getKdj_k()<sdd_b3.getKdj_d()	// KD金叉
				&& sdd_b1.getEq_ratio()>2			// 量比大于1
				&& sdd_b1.getClose()>sdd_b1.getMa_5()   // 站上5日均线
//				&& sdd.getReal_rise()>0
				)
				{
					TransactionRecordData trd=new TransactionRecordData();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(sdd);
					
					// 记录输出记录并计算后续收益，动态分析最佳抛出日并记录抛出时的收益值
					for (int k=j+1; k<stockDataList.size()-3 && k<j+120; k++)
					{
						
						StockDayData sdd_a1=(StockDayData)stockDataList.get(k);
						StockDayData sdd_a2=(StockDayData)stockDataList.get(k+1);
						double profit=((sdd_a2.getClose()-sdd.getOpen())/sdd.getOpen())*100-0.2;  // 减去手续费0.16和开盘价损
//						double profit=((sdd_a2.getClose()-sdd.getClose())/sdd.getClose())*100-0.2;  // 减去手续费0.16和开盘价损
						if (profit<-10)
						{
							// 当收盘出现总亏损大于-5%，止损
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
							// 当收盘出现连续两个非阳柱且连续下跌且刺破10日均线，止盈
							if(sdd_a1.getOpen()>=sdd_a1.getClose() && sdd_a2.getOpen()>=sdd_a2.getClose()  // 两个绿柱
							 && sdd_a1.getClose()>sdd_a2.getClose()  // 连续两天下跌
							 && sdd_a2.getLow()<sdd_a2.getMa_10())  // 第二个绿柱最低价刺穿10日均线
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
		
		outputTransactionRecordReport(transactionDataList, "王佳忠选股");	
		
	}
	
	
	//	王佳忠改进模型
	public void processStockByModel_wjzgj(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			int days=30; // 前期KDJ考察天数
			
			for (int j=days; j<stockDataList.size()-1; j++)  
			{

				StockDayData sdd=(StockDayData)stockDataList.get(j);  // 买入日 1天
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);	// 涨停日 1天

				double sdd_total_value=CommonTool.getDoubleNumberWithTwoBit(sdd.getTotal_value()/100000000);
				double current_liquid_value=CommonTool.getStockCurrentLiquidValue(stockDataList);
				
				if (
					sdd_b1.getClose_rise()>9.9  // 涨停日
					&& sdd_b1.getEq_ratio()>1.8	// 涨停日量比>1.8
					&& sdd.getOpen_rise()<9.9  // 涨停日后一天能买进
					&& checkPastDaysKDJ(stockDataList, sdd_b1, days-1)  // 涨停日前 days-1 天
				)
				{
					
					TransactionRecordData trd=new TransactionRecordData();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(sdd);
					
					
						// 记录输出记录并计算后续收益，动态分析最佳抛出日并记录抛出时的收益值
						for (int k=j+1; k<stockDataList.size()-3 && k<j+120; k++)
						{
							
							StockDayData sdd_a1=(StockDayData)stockDataList.get(k);
							StockDayData sdd_a2=(StockDayData)stockDataList.get(k+1);						
							
							
							double profit=((sdd_a2.getClose()-sdd.getOpen())/sdd.getOpen())*100-0.2;  // 减去手续费0.16和开盘价损
	//						double profit=((sdd_a2.getClose()-sdd.getClose())/sdd.getClose())*100-0.2;  // 减去手续费0.16和开盘价损
							if (profit<-20)
							{
								// 当收盘出现总亏损大于-5%，止损
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
								// 当收盘出现连续两个非阳柱且连续下跌且刺破10日均线，止盈
								if(sdd_a1.getOpen()>=sdd_a1.getClose() && sdd_a2.getOpen()>=sdd_a2.getClose()  // 两个绿柱
								 && sdd_a1.getClose()>sdd_a2.getClose()  // 连续两天下跌
								 && sdd_a2.getLow()<sdd_a2.getMa_10())  // 第二个绿柱最低价刺穿10日均线
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
						
					
					break;   // 只找第一个涨停
					
				}
			
			
			}
			
		}
		
		outputTransactionRecordReport(transactionDataList, "王佳忠选股改进");	
		
	}
	
	
	
	//	涨停板分析模型
	public void processStockByModel_ztb(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			int days=10; // 前期考察天数
			
			for (int j=days; j<stockDataList.size()-1; j++)
			{
				
				// 每天的数据
				StockDayData sdd=(StockDayData)stockDataList.get(j); 
				
				if (
						sdd.getClose_rise()>9  // 涨停日
						&& sdd.getReal_rise()>3  // 涨停当天可买入，有筹码交换，非一字涨停
//						&& checkPastDaysZTB(stockDataList, sdd, days-1)   // 之前days天没有涨停出现
					)
					{
						
						TransactionRecordData trd=new TransactionRecordData();
						trd.setStockcode(sdd.getCode());
						trd.setBuySDD(sdd);
						
						// 判断并决定卖出日sdd信息
						StockDayData sdd_a1=(StockDayData)stockDataList.get(j+1);
						trd.setSaleSDD(sdd_a1);
							
						transactionDataList.add(trd);
					
					}
				
			}
			
		}
		
		outputTransactionRecordReport_ztb(transactionDataList, "涨停板");	
		
	}
	
	
	//	涨停板分析研究模型
	public void processStockByModel_ztbyj(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			int days=5; // 前期考察天数
			
			for (int j=days; j<stockDataList.size()-1; j++)
			{
				
				// 每天的数据
				StockDayData sdd=(StockDayData)stockDataList.get(j); 
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1); 
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				
				if (
						sdd.getHigh_rise()>9  // 涨停日
						&& sdd.getOpen_rise()<7
//						&& sdd.getHigh_rise()-sdd.getLow_rise()>7  // 涨停当天可买入，有筹码交换，非一字涨停
						&& sdd_b1.getClose_rise()>9.9   // 昨日涨停
						&& sdd_b1.getReal_rise()>2
						&& sdd_b2.getClose_rise()>9.9	// 前日涨停
						&& sdd_b2.getReal_rise()>2
//						&& checkPastDaysZTB(stockDataList, sdd_b2, days-3)   // 之前days天没有涨停出现
					)
					{
						
						TransactionRecordData trd=new TransactionRecordData();
						trd.setStockcode(sdd.getCode());
						trd.setBuySDD(sdd);
						
						// 判断并决定卖出日sdd信息
						StockDayData sdd_a1=(StockDayData)stockDataList.get(j+1);
						trd.setSaleSDD(sdd_a1);
							
						transactionDataList.add(trd);
					
					}
				
			}
			
		}
		
		outputTransactionRecordReport_ztb(transactionDataList, "涨停板研究");	
		
	}
	
	
	//	三连板分析模型
	public void processStockByModel_slb(List researchStockCodeList, String startDate, String endDate)
	{
		
		int days=100; // 前期考察天数
		startDate=CommonTool.getStockTransDate(startDate, -100);  // 获得含实际需要天数的开始日期
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			int startPos=10;
			if (stockDataList.size()>days)
			{
				startPos=days;
			}
			
			for (int j=startPos; j<stockDataList.size()-1; j++)
			{
				
				// 每天的数据
				StockDayData sdd=(StockDayData)stockDataList.get(j); 
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1); 
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				
				List preStockDataList=new ArrayList();
				for (int s=1; s<=7; s++)
				{
					preStockDataList.add(stockDataList.get(j-3-s));  // 取得b3前7天的交易数据
				}
				
				if (
						sdd.getOpen_rise()<8  // 当天能买入
						&& sdd_b1.getClose_rise()>9.9  // 涨停日
						&& sdd_b1.getOpen_rise()>0
						&& sdd_b1.getReal_rise()>1
						&& sdd_b1.getLow()>sdd_b2.getHigh()
						&& sdd_b2.getClose_rise()>9.9  // 涨停日
						&& sdd_b2.getOpen_rise()>0
						&& sdd_b2.getReal_rise()>1
						&& sdd_b2.getLow()>sdd_b3.getHigh()
						&& sdd_b3.getClose_rise()>9.9  // 涨停日
//						&& sdd_b3.getReal_rise()>1
//						&& sdd_b2.getReal_rise()>1
//						&& sdd.getLow()>sdd_b1.getHigh()
//						&& sdd_b1.getLow()>sdd_b1.getHigh()
//						&& checkPastDaysZTB(stockDataList, sdd, days-1)   // 之前days天没有涨停出现
//						&& checkStockPreTrend_DDR_RUR(preStockDataList, 15)
						&& checkPastDaysHighPrice(sdd_b1, stockDataList, sdd_b3.getPosNum(), days)
					)
					{
						
						TransactionRecordData trd=new TransactionRecordData();
						trd.setStockcode(sdd.getCode());
						trd.setBuySDD(sdd);
						
						// 判断并决定卖出日sdd信息
						StockDayData sdd_a1=(StockDayData)stockDataList.get(j+1);
						trd.setSaleSDD(sdd_a1);
							
						transactionDataList.add(trd);
					
					}
				
			}
			
		}
		
		outputTransactionRecordReport_slb(transactionDataList, "三连板");	
		
	}
	
	//	妖股后大阳分析模型
	public void processStockByModel_yghdy(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			int days=10; // 前期考察天数
			
			for (int j=days; j<stockDataList.size()-1; j++)
			{
				
				// 每天的数据
				StockDayData sdd=(StockDayData)stockDataList.get(j); 
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1); 
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3); 
				
				if (
						sdd.getOpen_rise()<-4  // 当天能买入
						&& sdd_b1.getClose_rise()>9.9  // 涨停日
						&& sdd_b2.getClose_rise()>9.9  // 涨停日
						&& sdd.getHigh_rise()-sdd.getLow_rise()>10
						&& sdd.getHigh_rise()>5
//						&& sdd.getLow()>sdd_b1.getHigh()
//						&& sdd_b1.getLow()>sdd_b1.getHigh()
//						&& checkPastDaysZTB(stockDataList, sdd, days-1)   // 之前days天没有涨停出现
					)
					{
						
						TransactionRecordData trd=new TransactionRecordData();
						trd.setStockcode(sdd.getCode());
						trd.setBuySDD(sdd);
						
						// 判断并决定卖出日sdd信息
						StockDayData sdd_a1=(StockDayData)stockDataList.get(j+1);
						
						double profit=0;
						if (sdd.getReal_rise()>=0)
						{
							// 如果sdd是阳柱，第二天收盘抛
							profit=sdd_a1.getClose_rise()+(sdd.getClose_rise()-sdd.getLow_rise()-10);
						}
						else
						{
							// 如果sdd是阴柱，第二天开盘就抛
							profit=sdd_a1.getOpen_rise()+(sdd.getClose_rise()-sdd.getLow_rise()-10);
						}
						
						sdd_a1.setProfit(profit);
						trd.setSaleSDD(sdd_a1);
						
						transactionDataList.add(trd);
					
					}
				
			}
			
		}
		
		outputTransactionRecordReport(transactionDataList, "妖股后大阳");	
		
	}
	
	
	//	大涨之后模板
	public void processStockByModel_dzzh(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);

			int days=10; // 前期考察天数：0 到 days-1 天
			double zyd=2;  // 止盈点
			
			for (int j=days; j<stockDataList.size(); j++)  
			{
				
				if(j+2<stockDataList.size())
				{

					// 每天的数据
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
		
		outputTransactionRecordReport(transactionDataList, "大涨之后");	
		
	}
	
	
	//	被困资金模板
	public void processStockByModel_bkzj(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			int days=10; // 前期考察天数
			
			for (int j=days; j<stockDataList.size()-1; j++)  
			{
				
					// 每天的数据
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
							if (srd.getDDR()>10) // 出现回撤超过10%时就结束，计算收益
							{
								break;								
							}
							
						}
						
						transactionDataList.add(trd);
						
						
					}
				
			}
			
		}
		
		outputTransactionRecordReport(transactionDataList, "被困资金");	
		
	}
	
	
	//	模型模板
	public void processStockByModel_fundselect()
	{
		
		List transactionDataList=new ArrayList();
		
		try
		{
			
			//	读出fund表中每一行数据
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
				String date=rs.getString("date").trim();			// 本季度开始日
				
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
				
				String preDate=CommonTool.getStockTransDate(date, -40);	  // 上季度持仓公布日, 暂时不用
				String startDate=CommonTool.getStockTransDate(date, 20);  // 本季度持仓公布日
				String endDate=CommonTool.getStockTransDate(date, 80);	  // 下季度持仓公布日
				
				String stockfilename="stock"+stockcode;
				String condition2=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
				List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition2);
				
				for (int j=0; j<stockDataList.size(); j++)  
				{
					
					// 每天的数据
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
//						double profit=((saleSdd.getClose()-sdd.getOpen())/sdd.getOpen())*100-0.2;  // 减去手续费0.16和开盘价损
//						profit=CommonTool.getDoubleNumberWithTwoBit(profit);
//						transactionDataList.add(trd);
					
						
						// 记录输出记录并计算后续收益，动态分析最佳抛出日并记录抛出时的收益值
						StockDayData sdd_a1=(StockDayData)stockDataList.get(j);
						StockDayData sdd_a2=(StockDayData)stockDataList.get(j);
						double profit=0;
						for (int k=j+1; k<stockDataList.size()-1 && k<j+120; k++)
						{
							
							sdd_a1=(StockDayData)stockDataList.get(k);
							sdd_a2=(StockDayData)stockDataList.get(k+1);
							profit=((sdd_a2.getClose()-sdd.getOpen())/sdd.getOpen())*100-0.2;  // 减去手续费0.16和开盘价损
							
							if (profit<-10)
							{
								// 当收盘出现总亏损大于-15%，止损
								break;
							}
							else if (profit>10)
							{
								// 当收盘出现连续两个非阳柱且连续下跌且刺破10日均线，止盈
								if(sdd_a1.getOpen()>=sdd_a1.getClose() && sdd_a2.getOpen()>=sdd_a2.getClose()  // 两个绿柱
								 && sdd_a1.getClose()>sdd_a2.getClose()  // 连续两天下跌
								 && sdd_a2.getLow()<sdd_a2.getMa_10())  // 第二个绿柱最低价刺穿10日均线
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
		

		
		outputTransactionRecordReport_fundselect(transactionDataList, "基金选股");	
		
	}
	
	
	//	王佳忠模型
	public void processStockByModel_macd_ddz(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
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
					ddz_ratio>0			// ddz柱长最大与最小比值>8
				    && sdd_b2.getMa_ddz()<-100   // ddz值<-100 --- 这个也是一个重要的条件，跌得不够大不足以反弹
//					&& sdd_b2.getMa_ddz()>-900   // ddz值>-900 
					&& sdd_b1.getMa_ddz()>sdd_b2.getMa_ddz() // b1的ddz值比b2的ddz值变大了 --- 这个是重要的转折条件，否则会出现很多重复买点
//					&& sdd_b1.getReal_rise()<4    // b1涨幅不能太大，要小于3%  
					&& sdd.getOpen_rise()>-9      // 买入日不能是跌停开盘   
					&& sdd_total_value>500      // 单位是亿
//					&& ma_trends
//					&& sdd_b2.getKdj_k()<20
//					&& sdd_b2.getKdj_d()<20
//					&& sdd_b2.getEq_ratio()>1
				)
				{
					TransactionRecordData trd=new TransactionRecordData();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(sdd);
					
					// 记录输出记录并计算后续收益，动态分析最佳抛出日并记录抛出时的收益值
					for (int k=j+1; k<stockDataList.size()-3 && k<j+120; k++)
					{
						
						StockDayData sdd_a1=(StockDayData)stockDataList.get(k);
						StockDayData sdd_a2=(StockDayData)stockDataList.get(k+1);
						double profit=((sdd_a1.getClose()-sdd.getOpen())/sdd.getOpen())*100-0.2;  // 减去手续费0.16和开盘价损
						double profit_high=((sdd_a1.getHigh()-sdd.getOpen())/sdd.getOpen())*100-0.2; 
						double profit_low=((sdd_a1.getLow()-sdd.getOpen())/sdd.getOpen())*100-0.2; 
						
						if (profit_low<-5)
						{
							// 当收盘出现总亏损大于-10%，止损
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
							
							// 当收盘出现-5%以上亏损，则止损							
							sdd_a1.setProfit(-5);
							trd.setSaleSDD(sdd_a1);
							transactionDataList.add(trd);
							break;
							
						}
						else 
						{
							// 当出现ddz红柱后并走弱，则抛出
//							if(sdd_a1.getMa_ddz()>0 && sdd_a2.getMa_ddz()>0
//							&& sdd_a1.getMa_ddz()>sdd_a2.getMa_ddz())
//							{
//								profit=((sdd_a2.getClose()-sdd.getOpen())/sdd.getOpen())*100-0.2;
//								sdd_a2.setProfit(profit);
//								trd.setSaleSDD(sdd_a2);
//								transactionDataList.add(trd);
//								break;
//							}
							
							// 当盘中出现5%以上盈利，则止盈		
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
		
		outputTransactionRecordReport(transactionDataList, "MACD_DDZ选股");	
		
	}
	
	
	//	MACD 最低点模型
	public void processStockByModel_macd_zdd(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			for (int j=10; j<stockDataList.size()-1; j++)
			{

				StockDayData sdd=(StockDayData)stockDataList.get(j);   // 当天数据
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);


				double sdd_total_value=CommonTool.getDoubleNumberWithTwoBit(sdd.getTotal_value()/100000000);
				double current_liquid_value=CommonTool.getStockCurrentLiquidValue(stockDataList);
				
				
				boolean ma_trends=false;
				
				// 捕捉到macd变换的时点
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
					&& ddz_ratio>8			// ddz柱长最大与最小比值>8
					
				)
				{
					TransactionRecordData trd=new TransactionRecordData();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(sdd);
					
					// 记录输出记录并计算后续收益，动态分析最佳抛出日并记录抛出时的收益值
					for (int k=j+1; k<stockDataList.size()-3 && k<j+120; k++)
					{
						
						StockDayData sdd_a1=(StockDayData)stockDataList.get(k);
						StockDayData sdd_a2=(StockDayData)stockDataList.get(k+1);
						double profit=((sdd_a1.getClose()-sdd.getOpen())/sdd.getOpen())*100-0.2;  // 减去手续费0.16和开盘价损
						double profit_high=((sdd_a1.getHigh()-sdd.getOpen())/sdd.getOpen())*100-0.2; 
						double profit_low=((sdd_a1.getLow()-sdd.getOpen())/sdd.getOpen())*100-0.2; 
						
						if (profit_low<-5)
						{
							// 当收盘出现总亏损大于-10%，止损
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
							
							// 当收盘出现-5%以上亏损，则止损							
							sdd_a1.setProfit(-5);
							trd.setSaleSDD(sdd_a1);
							transactionDataList.add(trd);
							break;
							
						}
						else 
						{
							// 当出现ddz红柱后并走弱，则抛出
//							if(sdd_a1.getMa_ddz()>0 && sdd_a2.getMa_ddz()>0
//							&& sdd_a1.getMa_ddz()>sdd_a2.getMa_ddz())
//							{
//								profit=((sdd_a2.getClose()-sdd.getOpen())/sdd.getOpen())*100-0.2;
//								sdd_a2.setProfit(profit);
//								trd.setSaleSDD(sdd_a2);
//								transactionDataList.add(trd);
//								break;
//							}
							
							// 当盘中出现5%以上盈利，则止盈		
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
		
		outputTransactionRecordReport(transactionDataList, "MACD_ZDD选股");	
		
	}	
	
	
	//	MACD 底背离模型
	public void processStockByModel_macd_dbl(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++) 
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			for (int j=10; j<stockDataList.size()-1; j++)
			{

				StockDayData sdd=(StockDayData)stockDataList.get(j);   // 当天数据
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);

				double sdd_total_value=CommonTool.getDoubleNumberWithTwoBit(sdd.getTotal_value()/100000000);
				double current_liquid_value=CommonTool.getStockCurrentLiquidValue(stockDataList);
				
				boolean ma_trends=false;
				double buy_price=0;
				
				// 捕捉到macd底背离变换的时点
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
					&& ddz_ratio>1			// ddz 负柱长最大与最小比值>6
					
				)
				{
					TransactionRecordData trd=new TransactionRecordData();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(sdd);
					
					// 记录输出记录并计算后续收益，分析最佳抛出日并记录抛出时的收益值
					for (int k=j+1; k<j+2; k++)
					{
						
						StockDayData sdd_a1=(StockDayData)stockDataList.get(k);
						double profit=((sdd_a1.getClose()-buy_price)/buy_price)*100-0.2;  // 减去手续费0.16和开盘价损
						double profit_open=((sdd_a1.getOpen()-buy_price)/buy_price)*100-0.2;  // 减去手续费0.16和开盘价损
						double profit_high=((sdd_a1.getHigh()-buy_price)/buy_price)*100-0.2; 
						double profit_low=((sdd_a1.getLow()-buy_price)/buy_price)*100-0.2; 
						
//						if (profit_low<-4)
//						{							
//							// 当收盘出现-4%以上亏损，则止损							
//							sdd_a1.setProfit(-4);
//							trd.setSaleSDD(sdd_a1);
//							transactionDataList.add(trd);
//							break;
//						}
//						else 
						{
							
							// 当盘中出现2%以上盈利，则止盈		
							if (profit_open>2)
							{
								sdd_a1.setProfit(profit_open);  
								trd.setSaleSDD(sdd_a1);
								transactionDataList.add(trd);
							}
							else if (profit_high>1.2)
							{
								sdd_a1.setProfit(1.2-0.2);  // 减去手续费0.16和开盘价损
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
		
		outputTransactionRecordReport(transactionDataList, "MACD_DBL选股");	
		
	}		
	
	
	//	MACD TREND趋势模型
	public void processStockByModel_macd_trend(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++) 
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			for (int j=10; j<stockDataList.size()-1; j++)
			{

				StockDayData sdd=(StockDayData)stockDataList.get(j);   // 当天数据
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);  // 前一天数据
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);  // 前两天数据 

				double sdd_total_value=CommonTool.getDoubleNumberWithTwoBit(sdd.getTotal_value()/100000000);
				double current_liquid_value=CommonTool.getStockCurrentLiquidValue(stockDataList);
				
				boolean ma_trends=false;
				double buy_price=0;
				double macd_change=0;
				if (sdd_b1.getMa_macd()!=0)
				{
				   macd_change=Math.abs((sdd.getMa_macd()-sdd_b1.getMa_macd())/sdd_b1.getMa_macd());
				}
				
				// 捕捉到macd趋势点
				if (1>0 ||
				sdd.getMa_macd()-sdd_b1.getMa_macd()>0
//				&& macd_change>0.2    // 买入趋势较为明显
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
//					&& ddz_ratio>1			// ddz 负柱长最大与最小比值>6
				)
				{
					TransactionRecordData trd=new TransactionRecordData();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(sdd);
					
					// 记录输出记录并计算后续收益，分析最佳抛出日并记录抛出时的收益值
					for (int k=j+1; k<j+2; k++)
					{
						
						StockDayData sdd_a1=(StockDayData)stockDataList.get(k);					
						double profit_open=((sdd_a1.getOpen()-buy_price)/buy_price)*100-0.2;  // 减去手续费0.16和开盘价损
						double profit_high=((sdd_a1.getHigh()-buy_price)/buy_price)*100-0.2; 
						double profit_low=((sdd_a1.getLow()-buy_price)/buy_price)*100-0.2; 
						double profit_close=((sdd_a1.getClose()-buy_price)/buy_price)*100-0.2;  // 减去手续费0.16和开盘价损
						
//						if (profit_low<-4)
//						{							
//							// 当收盘出现-4%以上亏损，则止损							
//							sdd_a1.setProfit(-4);
//							trd.setSaleSDD(sdd_a1);
//							transactionDataList.add(trd);
//							break;
//						}
//						else 
						{
							
							// 当第二天出现跳空低开，则开盘抛出	
							if (sdd_a1.getOpen()<sdd.getLow())
							{
								sdd_a1.setProfit(profit_open);  
								trd.setSaleSDD(sdd_a1);
								transactionDataList.add(trd);
							}
							// 当第二天没有出现跳空低开，则盘尾抛出
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
		
		outputTransactionRecordReport(transactionDataList, "MACD_trend选股");	
		
	}	
	
	
	//	模型模板
	public void processStockByModel_beststock(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			if (stockDataList.size()<=0)
				continue;
			
			System.out.println("Process stock: "+stockcode);
			
			// 每天的数据
			StockDayData sdd_start=(StockDayData)stockDataList.get(0); 
			StockDayData sdd_end=(StockDayData)stockDataList.get(stockDataList.size()-1); 

			double profit=0;
			if (sdd_start.getOpen()!=0)
			{
				profit=((sdd_end.getClose()-sdd_start.getOpen())/sdd_start.getOpen())*100-0.2;  // 减去手续费0.16和开盘价损
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
		
		outputTransactionRecordReport_beststock(transactionDataList, "最佳股票");	
		
	}
	
	
	//	模型模板  MACD_涨停后高开
	public void processStockByModel_macd_zth(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			int days=10; // 前期考察天数
			
			for (int j=days; j<stockDataList.size()-1; j++)  
			{
				
				// 每天的数据
				StockDayData sdd_c=(StockDayData)stockDataList.get(j);  // 买入日为j
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
					&& sdd_b1.getClose_rise()-sdd_b1.getOpen_rise()>0   // b1为红柱涨停板 
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
							// 创建交易记录对象
							TransactionRecordData trd=new TransactionRecordData();
							
							// 记录买入日sdd信息
							trd.setStockcode(stockcode);
							trd.setBuySDD(sdd_c);
							
							// 判断并决定卖出日sdd信息
							StockDayData sdd_a1;
							if (j+1<stockDataList.size()) // 如果后一天超过，则以最后一天为sdd_a1
							{
								sdd_a1=(StockDayData)stockDataList.get(j+1);
							}
							else
							{
								sdd_a1=(StockDayData)stockDataList.get(j);
							}
			
//							// 买入后第二天开盘就抛 --- 数据证明这种开盘抛的方式亏损很大，远不如收盘抛
//							double profit=0;
//							if (sdd_c.getOpen()!=0)
//							{
//								profit=((sdd_a1.getOpen()-sdd_c.getOpen())/sdd_c.getOpen())*100-0.2;  // 减去手续费0.16和开盘价损
//							}		
//							sdd_a1.setProfit(profit);
							
							trd.setSaleSDD(sdd_a1);
								
							transactionDataList.add(trd);
								
						}
						
						
					}					
					
					
				}
				
			}
			
		
		
		outputTransactionRecordReport(transactionDataList, "MACD_涨停后");	
		
	}
	
	
	// macd 改进选股模型
	public List processStockByModel_macdgj(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只ETF或股票的历史所有数据
			String researchcode=((String)researchStockCodeList.get(i));
			List stockDataList;
			if (researchcode.startsWith("index"))
			{
				String stockfilename=researchcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
				System.out.println("Process stock: "+researchcode);
			}
			else
			{
				String stockcode=researchcode.substring(2); // 去掉前缀 sh, sz
				String stockfilename="stock"+stockcode;
				String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
				System.out.println("Process stock: "+stockcode);
			}
			
			
			// 例如：0-59(启动前60天), 60-64(买前5日), 65(买入日)
			int obv_days=6; // 观察期
			int rise_days=0;  // 上涨期
			int pre_days=obv_days+rise_days;  // 买入前总共时间
			int pastHighPriceDays_distance=0;   // 过去同价位出现时间的距离
//			int hold_days=2500;  // 持有时间
			int hold_days=2500;  // 持有时间
			
			boolean checkAssetsBack=true;
//			boolean checkAssetsBack=false;			
			String assetsBackDate="";   // 资产可用日期：因为持有天数而导致的无资金可用，需要用一个日期来标识资产回笼的日期
			
			for (int j=pre_days; j<stockDataList.size(); j++)
			{	
				
				// 多头排列上涨期每天的数据
				StockDayData sdd=(StockDayData)stockDataList.get(j);  // 买入日为j
				StockDayData sdd_b1=(StockDayData)stockDataList.get(j-1);
				StockDayData sdd_b2=(StockDayData)stockDataList.get(j-2);
				StockDayData sdd_b3=(StockDayData)stockDataList.get(j-3);
				StockDayData sdd_b4=(StockDayData)stockDataList.get(j-4);
				StockDayData sdd_b5=(StockDayData)stockDataList.get(j-5);
				StockDayData sdd_b6=(StockDayData)stockDataList.get(j-6);
				
				if (sdd.getDate().compareTo(assetsBackDate)<=0 && checkAssetsBack)   // 检查当前资产是否可用，如果还没有回笼则不能交易
					continue;
				
				// 多头排列上涨期总涨幅
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
//				 && checkPastDaysHighPrice(sdd_b1, stockDataList, j, obv_days) // 检查是否突破了前n天价位
//				 && current_total_value>1000
//				 && sdd_b6.getLow()<sdd_b6.getMa_5()    // b6启动前价格在五日均线下
//				 && total_rise_b>15 && total_rise_b<30  // b1-b5总涨幅大于15%,小于30%
//				 && sdd_b1.getClose_rise()>-2 && sdd_b1.getClose_rise()-sdd_b1.getOpen_rise()>-2   // b1为红柱 
//				 && sdd_b2.getClose_rise()>-2 && sdd_b2.getClose_rise()-sdd_b2.getOpen_rise()>-2   // b2为红柱 
//				 && sdd_b3.getClose_rise()>-2 && sdd_b3.getClose_rise()-sdd_b3.getOpen_rise()>-2   // b3为红柱 
//				 && sdd_b4.getClose_rise()>-2 && sdd_b4.getClose_rise()-sdd_b4.getOpen_rise()>-2   // b4为红柱 
//				 && sdd_b5.getClose_rise()>-2 && sdd_b5.getClose_rise()-sdd_b5.getOpen_rise()>-2   // b5为红柱 
	//			 && sdd_b1.getMa_5()-sdd_b1.getMa_20()>sdd_b5.getMa_5()-sdd_b5.getMa_20()  // b1的5,20线距大于b5的5,20线距,呈发散
	//			 && (sdd_b1.getMa_5()-sdd_b1.getMa_60())/sdd_b1.getMa_5()<0.3  // b1的5日均线还没有远离60日均线，处于启动期
				)
				{
					
						double buy_price=sdd.getOpen();  // 第二天开盘就买，无论价格高低
						
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
							trd.setSaleSDD(sdd);   // 默认先把购买当天作为卖出日sdd，以避免为空
							trd.setTransactionSalePrice(sale_price);  // 购买日的收盘价格默认作为卖出价格price
						}
						
						for (int s=j+1; s<=hold_endday_pos; s++)	// 查看后续n天内的交易决定哪天卖出s
						{
							
							StockDayData sdd_s=(StockDayData)stockDataList.get(s);
//								if (sdd_s.getHigh()>sale_price)  // 如果某一天盘中价格上冲到预估的卖出价格，则卖出止盈
//								{
//										double profit=(sdd_s.getClose()-buy_price)/buy_price*100;
//										sdd_s.setProfit(profit);
//										trd.setSaleSDD(sdd_s);
//										trd.setTransactionProfit(profit);
//										break;
//								}
							
							MarketRDDayData mdd=(MarketRDDayData)marketDataRecordMap.get(sdd_s.getDate());
							
							if (mdd!=null && mdd.getDown10()>500) // 如果某一天大盘出现大面积跌停，则收盘时卖出止损
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
							else   // 如果大盘没有发生风险，则记录最后收盘时的收益
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
		
		
		outputTransactionRecordReport(transactionDataList, "macd改进");
		
		return transactionDataList;
		
	}
	
	
	
	//	出水芙蓉
	public void processStockByModel_csfr(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			int days=30; // 前期考察天数
			
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
//					&& ddz_ratio>0			// ddz柱长最大与最小比值>8
//				    && sdd_b2.getMa_ddz()<-100   // ddz值<-100 --- 这个也是一个重要的条件，跌得不够大不足以反弹
//					&& sdd_b2.getMa_ddz()>-900   // ddz值>-900 
//					&& sdd_b1.getMa_ddz()>sdd_b2.getMa_ddz() // b1的ddz值比b2的ddz值变大了 --- 这个是重要的转折条件，否则会出现很多重复买点
//					&& sdd_b1.getReal_rise()<4    // b1涨幅不能太大，要小于3%  
//					&& sdd.getOpen_rise()>-9      // 买入日不能是跌停开盘   
//					&& sdd_total_value>500      // 单位是亿
//					&& ma_trends
//					&& sdd_b2.getKdj_k()<20
//					&& sdd_b2.getKdj_d()<20
//					&& sdd_b2.getEq_ratio()>1
				)
				{
					TransactionRecordData trd=new TransactionRecordData();
					trd.setStockcode(sdd.getCode());
					trd.setBuySDD(sdd);
					
					// 记录输出记录并计算后续收益，动态分析最佳抛出日并记录抛出时的收益值
					for (int k=j+1; k<stockDataList.size()-3 && k<j+120; k++)
					{
						
						StockDayData sdd_a1=(StockDayData)stockDataList.get(k);
						StockDayData sdd_a2=(StockDayData)stockDataList.get(k+1);
						double profit=((sdd_a1.getClose()-sdd.getOpen())/sdd.getOpen())*100-0.2;  // 减去手续费0.16和开盘价损
						double profit_high=((sdd_a1.getHigh()-sdd.getOpen())/sdd.getOpen())*100-0.2; 
						double profit_low=((sdd_a1.getLow()-sdd.getOpen())/sdd.getOpen())*100-0.2; 
						
						if (profit_low<-5)
						{
							// 当收盘出现总亏损大于-10%，止损
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
							
							// 当收盘出现-5%以上亏损，则止损							
							sdd_a1.setProfit(-5);
							trd.setSaleSDD(sdd_a1);
							transactionDataList.add(trd);
							break;
							
						}
						else 
						{
							// 当出现ddz红柱后并走弱，则抛出
//							if(sdd_a1.getMa_ddz()>0 && sdd_a2.getMa_ddz()>0
//							&& sdd_a1.getMa_ddz()>sdd_a2.getMa_ddz())
//							{
//								profit=((sdd_a2.getClose()-sdd.getOpen())/sdd.getOpen())*100-0.2;
//								sdd_a2.setProfit(profit);
//								trd.setSaleSDD(sdd_a2);
//								transactionDataList.add(trd);
//								break;
//							}
							
							// 当盘中出现5%以上盈利，则止盈		
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
		
		outputTransactionRecordReport(transactionDataList, "出水芙蓉");	
		
	}
	
	//	模型模板
	public void processStockByModel(List researchStockCodeList, String startDate, String endDate)
	{
		
		List transactionDataList=new ArrayList();

		// 取出每只股票的历史记录进行分析
		for (int i=0; i<researchStockCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据
			String stockcode=((String)researchStockCodeList.get(i)).substring(2); // 去掉前缀 sh, sz
			String stockfilename="stock"+stockcode;
			String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
			List stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
			
			System.out.println("Process stock: "+stockcode);
			
			int days=30; // 前期考察天数
			
			for (int j=days; j<stockDataList.size()-1; j++)  
			{
				
				// 每天的数据
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
		" index_macd_b"+dayNo+" double precision format 12.2, " +	// yg 所在大盘macd指数
		" index_ddz_b"+dayNo+" double precision format 12.2, " +	// yg 所在大盘ddz指数
		" index_yg_b"+dayNo+" double precision format 12.2 ";    // yg 当天的yg指数
		
		return columnDef;
		
	}
	
	public String getDataDef_preDayData(TransactionRecordData trd, int days)
	{
		
		List preStockDayDataList=trd.getPreStockDayDataList();	
		List preIndexDayDataList=trd.getPreIndexDayDataList();
		
		String dataDef="";
		if (preStockDayDataList.get(days-1)!=null && preIndexDayDataList.get(days-1)!=null)    // 序号必须减1
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
					CommonTool.getDoubleNumberWithTwoBit(idd.getMa_ddz());  // 将来换成yg指数
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
//		" index_macd_c double precision format 12.2, " +	// yg 所在大盘macd指数
//		" index_ddz_c double precision format 12.2, " +	// yg 所在大盘ddz指数
//		" index_yg_c double precision format 12.2 ";    // yg 当天的yg指数
		
		return columnDef;
		
	}
	
	
	public String getDataDef_currentDayData(TransactionRecordData trd)
	{
		
			String dataDef="";
			
			if (trd.getBuySDD()!=null)    // 序号必须减1
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
//					CommonTool.getDoubleNumberWithTwoBit(idd.getMa_ddz());  // 将来换成yg指数
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
		
		dataDef=dataDef.substring(1);   // 去掉第一个"-"号
		
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
		
		dataDef=dataDef.substring(1);   // 去掉第一个"-"号
		
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
		
		dataDef=dataDef.substring(1);   // 去掉第一个"-"号
		
		return dataDef;
		
	}
	
	public Map getStockMapByIndustry(List researchStockCodeList, String startDate, String endDate)
	{
			
			Map stockMapByIndustry=new TreeMap();	

			// 取出每只股票的历史记录进行分析
			for (int i=0; i<researchStockCodeList.size(); i++)  
			{
				
				// 获得一只ETF或股票的历史所有数据
				String researchcode=((String)researchStockCodeList.get(i));
				List stockDataList;
				if (researchcode.startsWith("index"))
				{
					String stockfilename=researchcode;
					String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
					stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename, condition);
					System.out.println("Process stock: "+researchcode);
				}
				else
				{
					String stockcode=researchcode.substring(2); // 去掉前缀 sh, sz
					String stockfilename="stock"+stockcode;
					String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
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
			
			// 对某个industry的stocklist排序
			Collections.sort(stockListByIndustry, new Comparator <StockDayData>() {
			
				public int compare(StockDayData sdd1, StockDayData sdd2) 
				{
					double diff = sdd1.getLiquid_value()-sdd2.getLiquid_value();  // 比较流动市值
					if (diff > 0) {
						return -1;
					}else if (diff < 0) {
						return 1;
					}
						return 0; //相等为0
				}
			
			}); 
			
			for (int i=0; i<stockListByIndustry.size(); i++)
			{

				
				StockDayData sdd=(StockDayData)stockListByIndustry.get(i);
				
				stockPoolCodeList.add(sdd.getCode());
				
				double liquidValue=sdd.getLiquid_value()/100000000;
				
				System.out.println(sdd.getIndustry()+" "+sdd.getCode()+" "+sdd.getName()+" "+liquidValue+"亿");

				if (liquidValue<1000 && i>=4) // 只取排名前5的
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
		
		Map stockDataMap=new TreeMap();  // (stockcode, sddList)  每只股票的历史全部数据，可放入内存的对象	
		
		stockFileFolder=stockAllDataFull+"\\all\\"+dateType;  // 根据research code类型选择不同的数据目录, day/minute1/minute30/minute60
		
		
		// 取出每只股票的历史记录进行分析
		for (int i=0; i<stockPoolCodeList.size(); i++)  
		{
			
			// 获得一只股票的历史所有数据 - 从数据文件中
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
				String stockcode=researchcode.substring(5); // 去掉前缀 index
				String stockfilename=researchcode;
		//		String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename);
				
				System.out.println("Process index: "+stockcode);
				stockDataMap.put(stockcode, stockDataList);
			}
			else if (researchcode.startsWith("minute"))
			{
				String stockcode=researchcode.substring(6); // 去掉前缀 minute
				String stockfilename=researchcode;
		//		String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename);
				
				System.out.println("Process minute: "+stockcode);
				stockDataMap.put(stockcode, stockDataList);
			}
			else if (researchcode.startsWith("day"))
			{
				String stockcode=researchcode.substring(3); // 去掉前缀 minute
				String stockfilename=researchcode;
		//		String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename);
				
				System.out.println("Process day: "+stockcode);
				stockDataMap.put(stockcode, stockDataList);
			}
			else 
			{
				String stockcode=researchcode.substring(2); // 去掉前缀 sh, sz
				String stockfilename="stock"+stockcode;
		//		String condition=" date>=\""+startDate+"\" and date<=\""+endDate+"\"";  // sql 条件中必须用双引号将string数据括起来
				stockDataList=CommonTool.getStockDataRecordList(stockFileFolder, stockfilename);
				
				System.out.println("Process stock: "+stockcode);
				stockDataMap.put(stockcode, stockDataList);
			}
	
			
			// 获得一只股票的历史所有数据 - 从内存表中
			
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
				String holdStr=shs.getBuyDate()+" "+shs.getCurDate()+" "+shs.getCode()+" "+shs.getName()+" "+shs.getCurPrice()+" "+shs.getAmount()+"股 "+(int)shs.getCurPrice()*shs.getAmount()+"元 ";
				System.out.println(holdStr);
			}
			
			System.out.println("【"+date+"】 持仓: "+accountDD.getStockValue()+"元  现金: "+accountDD.getCashValue()+"元  总金额: "+accountDD.getTotalValue()+"元 ");
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
		
		System.out.println("星期"+xqj+": "+CommonTool.getDoubleNumberWithTwoBit(avgRise)
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
	        w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。

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
	
	
	// 检查过去几天有几个顶
	public int checkPastdays_WR42_TopNumber(List stockDayDataList, int wrValve)  
	{
		
		int topNumber=0;
		
		for (int i=0; i<stockDayDataList.size(); i++)
		{
			
			StockDayData sdd=(StockDayData)stockDayDataList.get(i);
			
			if (sdd.getWR42()>wrValve)
			{
				topNumber++;  // 前几天有几个>85的值
			}
				
		}
		
		return topNumber;
		
	}
	
	// 检查过去几天有几个顶
	public int checkPastdays_WR100_TopNumber(List stockDayDataList, int wrValve)  
	{
		
		int topNumber=0;
		
		for (int i=0; i<stockDayDataList.size(); i++)
		{
			
			StockDayData sdd=(StockDayData)stockDayDataList.get(i);
			
			if (sdd.getWR100()>wrValve)
			{
				topNumber++;  // 前几天有几个>85的值
			}
				
		}
		
		return topNumber;
		
	}
	
	
	// 检查过去几天有几个底
	public int checkPastdays_WR42_EndNumber(List stockDayDataList, int wrValve)  
	{
		
		int endNumber=0;
		
		for (int i=0; i<stockDayDataList.size(); i++)
		{
			
			StockDayData sdd=(StockDayData)stockDayDataList.get(i);
			
			if (sdd.getWR42()<wrValve)
			{
				endNumber++;  // 前几天有几个<50的值
			}
		}
		
		return endNumber;
		
	}
	
	// 检查过去几天幅度变化总值
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
	
	// 检查过去几天WR100值上最多涨了多少
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
	
	// 检查过去几天WR100值上最多下跌了多少
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
	
	
	// 检查过去几天WR100值最大涨了多少
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
	
	

		
		
		
		// 模拟投资 - macd new dbl 新底背离指标策略
		public ModelEvaluationReport processInvestmentByStrategy_macd_ndbl(Map stockDataMap, String startDate, String endDate)
		{
			
			// 创建一个个人模拟账户
			PersonalStockAccount psa=new PersonalStockAccount();
			List dateList=CommonTool.generateTimeReferenceList(startDate, endDate, dateType);
			
			// 创建昨天的accountDD_pre
	 		AccountDayData accountDD_pre=new AccountDayData();  
			accountDD_pre.setCashValue(psa.investMoney);
			
			double lastSalePrice=10000;  // 上一次抛出时的价格, 初始值10000
			String lastSaleDate="";
			boolean isMACDChanged=false;   // 上一次抛出到现在MACD 5>60的趋势是否改变
			
			
			// 模拟每个交易日交易
			for (int i=0; i<dateList.size(); i++)
			{
				
				// 取出一个交易日期
				String transDate=dateList.get(i).toString();
				
				// 创建一个当日的交易账户对象accountDD，并继承昨日的持仓和现金
				AccountDayData accountDD=new AccountDayData();
				accountDD.setPosNum(i);
				accountDD.setDate(transDate);
				accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // 继承昨日的持仓
				accountDD.setCashValue(accountDD_pre.getCashValue());	// 继承昨日的现金
				
				// 检查当前持仓的股票走势状况，先决定是否卖出，并更新持仓股票及各股持仓价格
				List stockHoldList=accountDD.getStockHoldList();
				int stockHoldSize=stockHoldList.size();
				for (int j=stockHoldSize-1; j>=0; j--)
				{
					// 取出一个持股对象
					StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
					
					// 获得此持股的历史数据
					String stockcode=shs.getCode();
					List stockDataRecordList=(List)stockDataMap.get(stockcode);
					
					// 取出此股前几天的数据
					StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
					StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
					StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
					
					
					if (sdd==null || sdd_b1==null || sdd_b2==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
					{
						shs.setCurDate(transDate);
						continue;
					}
					
					TransactionRecordData trd=new TransactionRecordData();
					StockDayData buySDD=shs.getBuySDD();
					
					
					double current_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
					
					// 获取前几天的数据
					List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
					List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10); 
					List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
					List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
					
	//				sdd_b1=(StockDayData)pastStockList.get(1);   // 从序列中取出
							
	//				System.out.println(i);
					
					
    // *****************************  判断此股当前形势，决定是否卖出  *****************************  
	
					if ( 
					i==dateList.size()-2     // 到了交易队列的最后一天，则卖出
					||(sdd.getHigh()>=sdd.getMa_20()*0.95) 	// 盘中上冲到20日均线上，则止盈卖出 
//					||(sdd.getHigh()>=sdd.getMa_10()) 	// 盘中上冲到10日均线上，则止盈卖出 
//					||(sdd.getClose()<sdd.getMa_5())    // 收盘价跌到5日均线下方，则止损卖出
//					||(current_profit<-3)  // 收盘损失超过5%，则止损卖出
//					||(checkPastDays_DownLowestPrice(pastStockList20, sdd)) // 跌破前期最低点价位
					
					)
					{
						// 当出现超卖指标
						trd.setStockcode(sdd.getCode());
						trd.setBuySDD(buySDD);
						trd.setSaleSDD(sdd);
						
						// 收益计算
						double transactionProfit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getOpen())/trd.getBuySDD().getOpen())*100-0.2;
						trd.setTransactionProfit(transactionProfit);
						
						accountDD.saleTransList.add(trd);
						
						if(lastSalePrice==10000 || sdd.getClose()>lastSalePrice)
						{
							lastSalePrice=sdd.getClose(); // 记录上一次卖出时的价格
						}
						
						// 更新accountDD持仓列表
						accountDD.stockHoldList.remove(j);
						
						// 更新accountDD现金价值
						int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
						int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
						accountDD.setCashValue(newCashValue);
						accountDD.setStockValue(newStockValue);
						
						
					}
					else
					{
						// 如不卖出，就继续持有不变，更新持仓价格
						shs.setCurDate(transDate);
						shs.setCurPrice(sdd.getClose());	
					}
					
				}
				
				
				// 检查股票池里备选的股票走势情况，再决定是否买入，并更新持仓股票
				Iterator it=stockDataMap.keySet().iterator();
				while(it.hasNext())
				{
					
					// 从备选股票池中取出一只股票
					String stockcode=it.next().toString();  
					List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
					if (checkStockHoldList(stockHoldList, stockcode)==true)  // 如果已经持股，则不做增仓买入
					{
						continue;
					}
					
					// 取出此股前几天的数据
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
					
					
					// 获取前几天的连续数据
					List pastStockList3=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 3);  
					List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
					List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);
					List pastStockList15=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 15);
					List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
					List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
					List pastStockList100=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 100);
					List pastStockList150=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 150);
	//				String dateb1=sdd_b1.getDate();   // debug代码
	//				System.out.println(dateb1);
					
//					if (sdd_b1.getDate().contains("2021/08/09"))
//					{
//						int t=1;
//						t++;
//					}
					
	
// *****************************  判断此股当前形势，决定是否买入  *****************************  
					
					// 当出macd 新底背离决定买入
					if ( 
						
						sdd_b2.getClose()<sdd_b2.getMa_5()     //前二天的收盘价在ma5下
						&& (sdd_b1.getClose()+sdd_b1.getHigh())/2>sdd_b1.getMa_5()  //前一天的收盘价或中位值在ma5上
						&& (sdd_b1.getClose()+sdd_b1.getHigh())/2<sdd_b1.getMa_10() //前一天的收盘价或中位值在ma10下
//						&& sdd.getOpen()<(sdd_b1.getMa_10()+sdd_b1.getMa_5())/2
//						&& sdd_b1.getClose_rise()<3			   //前一天的涨幅不能太大，要小于3
						&& sdd_b1.getReal_rise()>0  		   //前一天是阳柱
						&& checkPastDaysMACDTrends_UP(pastStockList3, 0)	 // macd 阴柱趋势向上
//						&& checkPastDaysMACDTrends_NDBL_DEEP(pastStockList3, -0.3)	// 最底macd值必须下探超过-0.6
						&& checkDayData_MA_ktpl(sdd_b1)  // 前一天的macd呈空头排列

							
						)
					{
						
//						sdd.setOpen(sdd_b1.getClose());  // 按昨日收盘时买操作
						
						// 当出现多头排列，就买入，并记录买入交易
						TransactionRecordData trd=new TransactionRecordData();
						trd.setBuySDD(sdd);
						accountDD.buyTransList.add(trd);
						
						// 更新accountDD持仓列表
						StockHoldShare shs=new StockHoldShare();
						
						// 计算可买入股票数量
	//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
	//					int amount=0;
	//					if (accountDD.cashValue>eachStockInvestMoney)
	//					{
	//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // 剩余现金足够投资一份当前股票
	//					}
	//					else
	//					{
	//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金不够投资一份当前股票，则全部买入
	//					}
						
						int amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金全部买入
						
						// 添加新买入的持仓股票
						shs.setAmount(amount);
						shs.setCode(sdd.getCode());
						shs.setName(sdd.getName());
						shs.setBuyPrice(sdd.getOpen());
						shs.setBuyDate(sdd.getDate());
						shs.setCurPrice(sdd.getClose());
						shs.setCurDate(sdd.getDate());
						shs.setBuySDD(sdd);
						stockHoldList.add(shs);
						
						// 更新accountDD现金价值
						int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
						int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
						accountDD.setCashValue(newCashValue);
						accountDD.setStockValue(newStockValue);
						
					}
					else
					{
						
						// 如果未接上继续上涨，而是继续下跌了，WR100回继续冲向80以上，这说明走势已坏，不能继续用股价接力的方法，
						// 要等待WR100再次回到20以下再次发动一轮新的上涨
						if (sdd.getWR100()>80)   
						{
	//						System.out.println("SDD WR: "+sdd.getDate()+"  "+sdd.getWR100());
							lastSalePrice=10000;  
						}
						
					}
					
				}
				
				// 更新个人账户的每日账户信息
				Map accountDataMap=psa.getAccountDataMap();
				accountDataMap.put(transDate, accountDD);
				accountDD_pre=accountDD;
				
			}
			
			// 输出投资交易记录，模拟交易金额变化曲线，对比评估交易策略
			String modelName="投资组合_MACD新底背离指标";
			List transactionDataList=generateTransactionDataListFromPSA(psa);
			String reportLine=outputTransactionRecordReport(transactionDataList, modelName);
			// code name date_c saledate year days buy_price sale_price profit 
			
	//		outputAccountRecordReport(psa); // 输出account的每日投资内容，价格变化，现金价值/总价值  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
			
	//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
	//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, 易方达消费 
			
			ModelEvaluationReport mer=new ModelEvaluationReport();
			mer.setTransactionDataList(transactionDataList);
			mer.setReportLine(reportLine);
			mer.setModelName(modelName);
			
			return mer;
		}	
			
		
		
		
		
		// 模拟投资 - macd new dtpl 新多头排列指标策略
		public ModelEvaluationReport processInvestmentByStrategy_macd_ndtpl(Map stockDataMap, String startDate, String endDate)
		{
			
			// 创建一个个人模拟账户
			PersonalStockAccount psa=new PersonalStockAccount();
			
			List dateList=CommonTool.generateTimeReferenceList(startDate, endDate, dateType);
			
			// 创建昨天的accountDD_pre
	 		AccountDayData accountDD_pre=new AccountDayData();  
			accountDD_pre.setCashValue(psa.investMoney);
			
			double lastSalePrice=10000;  // 上一次抛出时的价格, 初始值10000
			String lastSaleDate="";
			boolean isMACDChanged=false;   // 上一次抛出到现在MACD 5>60的趋势是否改变
			
			
			// 模拟每个交易日交易
			for (int i=0; i<dateList.size(); i++)
			{
				
				// 取出一个交易日期
				String transDate=dateList.get(i).toString();
				
				// 创建一个当日的交易账户对象accountDD，并继承昨日的持仓和现金
				AccountDayData accountDD=new AccountDayData();
				accountDD.setPosNum(i);
				accountDD.setDate(transDate);
				accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // 继承昨日的持仓
				accountDD.setCashValue(accountDD_pre.getCashValue());	// 继承昨日的现金
				
				// 检查当前持仓的股票走势状况，先决定是否卖出，并更新持仓股票及各股持仓价格
				List stockHoldList=accountDD.getStockHoldList();
				int stockHoldSize=stockHoldList.size();
				for (int j=stockHoldSize-1; j>=0; j--)
				{
					// 取出一个持股对象
					StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
					
					// 获得此持股的历史数据
					String stockcode=shs.getCode();
					List stockDataRecordList=(List)stockDataMap.get(stockcode);
					
					// 取出此股前几天的数据
					StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
					StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
					StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
					
					
					if (sdd==null || sdd_b1==null || sdd_b2==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
					{
						shs.setCurDate(transDate);
						continue;
					}
					
					TransactionRecordData trd=new TransactionRecordData();
					StockDayData buySDD=shs.getBuySDD();
					
					
					double macd_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
					
					// 获取前几天的数据
					List pastStockList3=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 3);
					List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
					List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10); 
					List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
					List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
					
	//				sdd_b1=(StockDayData)pastStockList.get(1);   // 从序列中取出
							
	//				System.out.println(i);
					
					
// *****************************  判断此股当前形势，决定是否卖出  *****************************  

					if ( 
					i==dateList.size()-2     // 到了交易队列的最后一天，则卖出
//					|| calculatePriceGapRatio(sdd.getClose(), sdd.getMa_5())>0.06
//					|| !checkPastDaysMACDTrends_NDBL_UP(pastStockList3, 1)
					|| (1>0
//					&& sdd.getClose_rise()<0    // 阴柱
//					&& sdd.getClose()<sdd.getMa_20() 		// 收盘在20日线以下
					&& (sdd.getHigh()+sdd.getLow())/2<sdd.getMa_20() // 均价跌破20日均线
					&& sdd.getMa_macd()<=sdd_b1.getMa_macd() && sdd_b1.getMa_macd()<=sdd_b2.getMa_macd()  // 连续三天MACD下跌
					)	 // macd 柱趋势向下	
//					||(sdd.getHigh()>sdd.getMa_20()) 	// 盘中上冲到20日均线上，则止盈卖出 
					
					)
					{
						// 当出现CCI超卖指标
	//					TransactionRecordData trd=new TransactionRecordData();
	//					StockDayData buySDD=shs.getBuySDD();
						trd.setStockcode(sdd.getCode());
						trd.setBuySDD(buySDD);
						trd.setSaleSDD(sdd);
						
						// 收益计算
						double transactionProfit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getOpen())/trd.getBuySDD().getOpen())*100-0.2;
						trd.setTransactionProfit(transactionProfit);
						
						accountDD.saleTransList.add(trd);
						
						if(lastSalePrice==10000 || sdd.getClose()>lastSalePrice)
						{
							lastSalePrice=sdd.getClose(); // 记录上一次卖出时的价格
						}
						
						// 更新accountDD持仓列表
						accountDD.stockHoldList.remove(j);
						
						// 更新accountDD现金价值
						int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
						int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
						accountDD.setCashValue(newCashValue);
						accountDD.setStockValue(newStockValue);
						
						
					}
					else
					{
						// 如不卖出，就继续持有不变，更新持仓价格
						shs.setCurDate(transDate);
						shs.setCurPrice(sdd.getClose());	
					}
					
				}
				
				
				// 检查股票池里备选的股票走势情况，再决定是否买入，并更新持仓股票
				Iterator it=stockDataMap.keySet().iterator();
				while(it.hasNext())
				{
					
					// 从备选股票池中取出一只股票
					String stockcode=it.next().toString();  
					List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
					if (checkStockHoldList(stockHoldList, stockcode)==true)  // 如果已经持股，则不做增仓买入
					{
						continue;
					}
					
					// 取出此股前几天的数据
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
					
	//				if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null || sdd_b4==null || sdd_b5==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
	//				{
	//					continue;
	//				}
	//				
	//				if (sdd_b6==null || sdd_b7==null || sdd_b8==null || sdd_b9==null)
	//				{
	//					continue;
	//				}
	//				
	//				if (sdd_b10==null || sdd_b11==null || sdd_b12==null || sdd_b13==null || sdd_b14==null || sdd_b15==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
	//				{
	//					continue;
	//				}
					
					// 获取前几天的数据
					List pastStockList2=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 2); 
					List pastStockList3=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 3);  
					List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
					List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);
					List pastStockList15=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 15);
					List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
					List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
					List pastStockList100=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 100);
					List pastStockList150=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 150);
	//				String dateb1=sdd_b1.getDate();   // debug代码
	//				System.out.println(dateb1);
					
					if (sdd_b1.getDate().contains("2021/08/09"))
					{
						int t=1;
						t++;
					}
					
					
// *****************************  判断此股当前形势，决定是否买入  *****************************  
					
					if ( 
						
//						calculatePriceGapRatio(sdd_b1.getClose(), sdd_b1.getMa_5())<0.04  //前一天的收盘价在ma5上，且相距很近
						sdd_b1.getSwing()<7    // 前一天没有太大偏离5日线
						&& sdd_b1.getReal_rise()>0		 // 前一天是阳柱
						&& sdd_b1.getClose()>sdd_b1.getMa_5()  //  前一天收盘收于5日均线上
//						&& sdd_b1.getMa_5()>sdd_b1.getMa_60()  //  MA5>ma60
						&& checkDayData_MA_dtpl(pastStockList3)    // 过去2日呈多头排列趋势
//						&& checkPastDaysHighPrice(sdd_b1, stockDataRecordList, sdd_b1.getPosNum(), 120)
//						&& !(sdd_b1.getMa_60()>sdd_b1.getMa_5() && sdd_b1.getMa_60()>sdd_b1.getMa_10() && sdd_b1.getMa_60()>sdd_b1.getMa_20())
						&& checkPastDaysMACDTrends_UP(pastStockList3, 0)	 // macd 柱趋势向上

//						&& sdd_b6.getMa_5()>sdd_b6.getMa_60()     // 非常重要的一个条件！！准确描述了走势形态	
							
						)
					{
						
						// 当出现多头排列，就买入，并记录买入交易
						TransactionRecordData trd=new TransactionRecordData();
						trd.setBuySDD(sdd);
						accountDD.buyTransList.add(trd);
						
						// 更新accountDD持仓列表
						StockHoldShare shs=new StockHoldShare();
						
						// 计算可买入股票数量
	//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
	//					int amount=0;
	//					if (accountDD.cashValue>eachStockInvestMoney)
	//					{
	//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // 剩余现金足够投资一份当前股票
	//					}
	//					else
	//					{
	//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金不够投资一份当前股票，则全部买入
	//					}
						
						int amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金全部买入
						
						// 添加新买入的持仓股票
						shs.setAmount(amount);
						shs.setCode(sdd.getCode());
						shs.setName(sdd.getName());
						shs.setBuyPrice(sdd.getOpen());
						shs.setBuyDate(sdd.getDate());
						shs.setCurPrice(sdd.getClose());
						shs.setCurDate(sdd.getDate());
						shs.setBuySDD(sdd);
						stockHoldList.add(shs);
						
						// 更新accountDD现金价值
						int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
						int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
						accountDD.setCashValue(newCashValue);
						accountDD.setStockValue(newStockValue);
						
					}
					else
					{
						
						// 如果未接上继续上涨，而是继续下跌了，WR100回继续冲向80以上，这说明走势已坏，不能继续用股价接力的方法，
						// 要等待WR100再次回到20以下再次发动一轮新的上涨
						if (sdd.getWR100()>80)   
						{
	//						System.out.println("SDD WR: "+sdd.getDate()+"  "+sdd.getWR100());
							lastSalePrice=10000;  
						}
						
					}
					
				}
				
				// 更新个人账户的每日账户信息
				Map accountDataMap=psa.getAccountDataMap();
				accountDataMap.put(transDate, accountDD);
				accountDD_pre=accountDD;
				
			}
			
			// 输出投资交易记录，模拟交易金额变化曲线，对比评估交易策略
			String modelName="投资组合_MACD新多头排列指标";
			List transactionDataList=generateTransactionDataListFromPSA(psa);
			String reportLine=outputTransactionRecordReport(transactionDataList, modelName);
			// code name date_c saledate year days buy_price sale_price profit 
			
	//		outputAccountRecordReport(psa); // 输出account的每日投资内容，价格变化，现金价值/总价值  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
			
	//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
	//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, 易方达消费 
			
			ModelEvaluationReport mer=new ModelEvaluationReport();
			mer.setTransactionDataList(transactionDataList);
			mer.setReportLine(reportLine);
			mer.setModelName(modelName);
			
			return mer;
		}	
		
		
		// 模拟投资 - macd new dtpl ma20新多头排列指标策略
		public ModelEvaluationReport processInvestmentByStrategy_macd_ndtpl_ma20(Map stockDataMap, String startDate, String endDate)
		{
			
			// 创建一个个人模拟账户
			PersonalStockAccount psa=new PersonalStockAccount();
			
			List dateList=CommonTool.generateTimeReferenceList(startDate, endDate, dateType);
			
			// 创建昨天的accountDD_pre
	 		AccountDayData accountDD_pre=new AccountDayData();  
			accountDD_pre.setCashValue(psa.investMoney);
			
			double lastSalePrice=10000;  // 上一次抛出时的价格, 初始值10000
			String lastSaleDate="";
			boolean isMACDChanged=false;   // 上一次抛出到现在MACD 5>60的趋势是否改变
			boolean isStockSaleDay=false;
			
			// 模拟每个交易日交易
			for (int i=0; i<dateList.size(); i++)
			{
				
				// 取出一个交易日期
				String transDate=dateList.get(i).toString();
				isStockSaleDay=false;  // 先默认不是股票卖出日
				
				// 创建一个当日的交易账户对象accountDD，并继承昨日的持仓和现金
				AccountDayData accountDD=new AccountDayData();
				accountDD.setPosNum(i);
				accountDD.setDate(transDate);
				accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // 继承昨日的持仓
				accountDD.setCashValue(accountDD_pre.getCashValue());	// 继承昨日的现金
				
				// 检查当前持仓的股票走势状况，先决定是否卖出，并更新持仓股票及各股持仓价格
				List stockHoldList=accountDD.getStockHoldList();
				int stockHoldSize=stockHoldList.size();
				for (int j=stockHoldSize-1; j>=0; j--)
				{
					// 取出一个持股对象
					StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
					
					// 获得此持股的历史数据
					String stockcode=shs.getCode();
					List stockDataRecordList=(List)stockDataMap.get(stockcode);
					
					// 取出此股前几天的数据
					StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
					StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
					StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
					
					
					if (sdd==null || sdd_b1==null || sdd_b2==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
					{
						shs.setCurDate(transDate);
						continue;
					}
					
					TransactionRecordData trd=new TransactionRecordData();
					StockDayData buySDD=shs.getBuySDD();
					
					
					double macd_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
					
					// 获取前几天的数据
					List pastStockList3=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 3);
					List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
					List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10); 
					List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
					List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
					
	//				sdd_b1=(StockDayData)pastStockList.get(1);   // 从序列中取出
							
	//				System.out.println(i);
					
					
// *****************************  判断此股当前形势，决定是否卖出  *****************************  

					if ( 
					i==dateList.size()-2     // 到了交易队列的最后一天，则卖出
//					|| calculatePriceGapRatio(sdd.getClose(), sdd.getMa_5())>0.06
//					|| !checkPastDaysMACDTrends_NDBL_UP(pastStockList3, 1)
					|| (1>0
//					&& sdd.getClose_rise()<0    // 阴柱
//					&& sdd.getClose()<sdd.getMa_20() 		// 收盘在20日线以下
					&& (sdd_b1.getHigh()+sdd_b1.getLow())/2<sdd_b1.getMa_20() // 均价跌破20日均线
//					&& sdd.getHigh()<sdd.getMa_20()  // 连续两天跌破20日均线
					&& (sdd_b1.getHigh()+sdd_b1.getLow())/2>(sdd.getHigh()+sdd.getLow())/2// 重心转为向下
//					&& (sdd.getHigh()+sdd.getLow())/2<sdd.getMa_5() // 均价跌破5日均线
//					&& sdd.getMa_macd()<=sdd_b1.getMa_macd() && sdd_b1.getMa_macd()<=sdd_b2.getMa_macd()  // 连续三天MACD下跌
					)	 // macd 柱趋势向下	
//					||(sdd.getHigh()>sdd.getMa_20()) 	// 盘中上冲到20日均线上，则止盈卖出 
					
					)
					{
						
						isStockSaleDay=true;  // 满足卖出日条件，则设置为卖出日标志
						
						// 当出现CCI超卖指标
	//					TransactionRecordData trd=new TransactionRecordData();
	//					StockDayData buySDD=shs.getBuySDD();
						trd.setStockcode(sdd.getCode());
						trd.setBuySDD(buySDD);
						trd.setSaleSDD(sdd);
						
						// 收益计算
						double transactionProfit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getOpen())/trd.getBuySDD().getOpen())*100-0.2;
						trd.setTransactionProfit(transactionProfit);
						
						accountDD.saleTransList.add(trd);
						
						if(lastSalePrice==10000 || sdd.getClose()>lastSalePrice)
						{
							lastSalePrice=sdd.getClose(); // 记录上一次卖出时的价格
						}
						
						// 更新accountDD持仓列表
						accountDD.stockHoldList.remove(j);
						
						// 更新accountDD现金价值
						int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
						int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
						accountDD.setCashValue(newCashValue);
						accountDD.setStockValue(newStockValue);
						
						
					}
					else
					{
						// 如不卖出，就继续持有不变，更新持仓价格
						shs.setCurDate(transDate);
						shs.setCurPrice(sdd.getClose());	
					}
					
				}
				
				
				// 检查股票池里备选的股票走势情况，再决定是否买入，并更新持仓股票
				Iterator it=stockDataMap.keySet().iterator();
				while(it.hasNext())
				{
					
					// 从备选股票池中取出一只股票
					String stockcode=it.next().toString();  
					List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
					if (checkStockHoldList(stockHoldList, stockcode)==true || isStockSaleDay)  // 如果已经持股，或者当天是卖出日，则不做增仓买入
					{
						continue;
					}
					
					// 取出此股前几天的数据
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
					
	//				if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null || sdd_b4==null || sdd_b5==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
	//				{
	//					continue;
	//				}
	//				
	//				if (sdd_b6==null || sdd_b7==null || sdd_b8==null || sdd_b9==null)
	//				{
	//					continue;
	//				}
	//				
	//				if (sdd_b10==null || sdd_b11==null || sdd_b12==null || sdd_b13==null || sdd_b14==null || sdd_b15==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
	//				{
	//					continue;
	//				}
					
					// 获取前几天的数据
					List pastStockList2=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 2); 
					List pastStockList3=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 3);  
					List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
					List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);
					List pastStockList15=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 15);
					List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
					List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
					List pastStockList100=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 100);
					List pastStockList150=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 150);
	//				String dateb1=sdd_b1.getDate();   // debug代码
	//				System.out.println(dateb1);
					
					if (sdd_b1.getDate().contains("2021/08/09"))
					{
						int t=1;
						t++;
					}
					
					
// *****************************  判断此股当前形势，决定是否买入  *****************************  
					
					if ( 
						1>0
//						calculatePriceGapRatio(sdd_b1.getClose(), sdd_b1.getMa_5())<0.04  //前一天的收盘价在ma5上，且相距很近
						&& sdd_b1.getSwing()<7    // 前一天没有太大偏离5日线
//						&& sdd_b1.getReal_rise()>0		 // 前一天是阳柱
//						&& sdd_b1.getClose()>sdd_b1.getMa_5()  //  前一天收盘收于5日均线上
						&& sdd_b1.getClose()>sdd_b1.getMa_10()  //  前一天收盘收于20日均线上
//						&& sdd.getClose()>sdd.getMa_20()
//						&& sdd_b1.getMa_5()>sdd_b1.getMa_60()  //  MA5>ma60
//						&& checkDayData_MA_dtpl(sdd_b1)    // 过去1日呈多头排列趋势
//						&& checkPastDaysHighPrice(sdd_b1, stockDataRecordList, sdd_b1.getPosNum(), 500)
//						&& !(sdd_b1.getMa_60()>sdd_b1.getMa_5() && sdd_b1.getMa_60()>sdd_b1.getMa_10() && sdd_b1.getMa_60()>sdd_b1.getMa_20())
//						&& checkPastDaysMACDTrends_UP(pastStockList3, 0)	 // macd 柱趋势向上

//						&& sdd_b6.getMa_5()>sdd_b6.getMa_60()     // 非常重要的一个条件！！准确描述了走势形态	
						
						&& checkPastDaysMACDTrends_MA20(pastStockList5, 5)
//						&& checkPastDaysMACDTrends_MA10(pastStockList5, 5)
						)
					{
						
						
						// 当出现多头排列，就买入，并记录买入交易
						TransactionRecordData trd=new TransactionRecordData();
						trd.setBuySDD(sdd);
						accountDD.buyTransList.add(trd);
						
						// 更新accountDD持仓列表
						StockHoldShare shs=new StockHoldShare();
						
						// 计算可买入股票数量
	//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
	//					int amount=0;
	//					if (accountDD.cashValue>eachStockInvestMoney)
	//					{
	//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // 剩余现金足够投资一份当前股票
	//					}
	//					else
	//					{
	//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金不够投资一份当前股票，则全部买入
	//					}
						
						int amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金全部买入
						
						// 添加新买入的持仓股票
						shs.setAmount(amount);
						shs.setCode(sdd.getCode());
						shs.setName(sdd.getName());
						shs.setBuyPrice(sdd.getOpen());
						shs.setBuyDate(sdd.getDate());
						shs.setCurPrice(sdd.getClose());
						shs.setCurDate(sdd.getDate());
						shs.setBuySDD(sdd);
						stockHoldList.add(shs);
						
						// 更新accountDD现金价值
						int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
						int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
						accountDD.setCashValue(newCashValue);
						accountDD.setStockValue(newStockValue);
						
					}
					else
					{
						
						// 如果未接上继续上涨，而是继续下跌了，WR100回继续冲向80以上，这说明走势已坏，不能继续用股价接力的方法，
						// 要等待WR100再次回到20以下再次发动一轮新的上涨
						if (sdd.getWR100()>80)   
						{
	//						System.out.println("SDD WR: "+sdd.getDate()+"  "+sdd.getWR100());
							lastSalePrice=10000;  
						}
						
					}
					
				}
				
				// 更新个人账户的每日账户信息
				Map accountDataMap=psa.getAccountDataMap();
				accountDataMap.put(transDate, accountDD);
				accountDD_pre=accountDD;
				
			}
			
			// 输出投资交易记录，模拟交易金额变化曲线，对比评估交易策略
			String modelName="投资组合_MACD新多头排列指标_MA20";
			List transactionDataList=generateTransactionDataListFromPSA(psa);
			String reportLine=outputTransactionRecordReport(transactionDataList, modelName);
			// code name date_c saledate year days buy_price sale_price profit 
			
	//		outputAccountRecordReport(psa); // 输出account的每日投资内容，价格变化，现金价值/总价值  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
			
	//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
	//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, 易方达消费 
			
			ModelEvaluationReport mer=new ModelEvaluationReport();
			mer.setTransactionDataList(transactionDataList);
			mer.setReportLine(reportLine);
			mer.setModelName(modelName);
			
			return mer;
		}	
		
		
		// 模拟投资 - zspm 涨速排名minute指标策略
		public ModelEvaluationReport processInvestmentByStrategy_zspm_minute(Map stockDataMap, String startDate, String endDate)
		{
			
			// 创建一个个人模拟账户
			PersonalStockAccount psa=new PersonalStockAccount();
			
			List dateList=CommonTool.generateTimeReferenceList(startDate, endDate, dateType);
			
			// 创建昨天的accountDD_pre
	 		AccountDayData accountDD_pre=new AccountDayData();  
			accountDD_pre.setCashValue(psa.investMoney);
			
			double lastSalePrice=10000;  // 上一次抛出时的价格, 初始值10000
			String lastSaleDate="";
			boolean isMACDChanged=false;   // 上一次抛出到现在MACD 5>60的趋势是否改变
			boolean isStockSaleDay=false;
			
			// 模拟每个交易日交易
			for (int i=0; i<dateList.size(); i++)
			{
				
				// 取出一个交易日期
				String transDate=dateList.get(i).toString();
				isStockSaleDay=false;  // 先默认不是股票卖出日
				
				// 创建一个当日的交易账户对象accountDD，并继承昨日的持仓和现金
				AccountDayData accountDD=new AccountDayData();
				accountDD.setPosNum(i);
				accountDD.setDate(transDate);
				accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // 继承昨日的持仓
				accountDD.setCashValue(accountDD_pre.getCashValue());	// 继承昨日的现金
				
				// 检查当前持仓的股票走势状况，先决定是否卖出，并更新持仓股票及各股持仓价格
				List stockHoldList=accountDD.getStockHoldList();
				int stockHoldSize=stockHoldList.size();
				for (int j=stockHoldSize-1; j>=0; j--)
				{
					// 取出一个持股对象
					StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
					
					// 获得此持股的历史数据
					String stockcode=shs.getCode();
					List stockDataRecordList=(List)stockDataMap.get(stockcode);
					
					// 取出此股前几天的数据
					StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
					StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
					StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
					
					
					if (sdd==null || sdd_b1==null || sdd_b2==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
					{
						shs.setCurDate(transDate);
						continue;
					}
					
					TransactionRecordData trd=new TransactionRecordData();
					StockDayData buySDD=shs.getBuySDD();
					
					
					double macd_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
					
					// 获取前几天的数据
					List pastStockList3=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 3);
					List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
					List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10); 
					List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
					List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
					
	//				sdd_b1=(StockDayData)pastStockList.get(1);   // 从序列中取出
							
	//				System.out.println(i);
					
					
// *****************************  判断此股当前形势，决定是否卖出  *****************************  

					if ( 
					i==dateList.size()-2     // 到了交易队列的最后一天，则卖出
//					|| calculatePriceGapRatio(sdd.getClose(), sdd.getMa_5())>0.06
//					|| !checkPastDaysMACDTrends_NDBL_UP(pastStockList3, 1)
					|| (1>0
//					&& sdd.getClose()<sdd.getMa_20()
					&& sdd.getDate().substring(0, 10).compareTo(buySDD.getDate().substring(0,10))>0  // 必须第二天后才能卖
//					&& sdd.getDate().endsWith("001")   // 开盘卖出
//					&& sdd.getClose_rise()<0    // 阴柱
//					&& sdd.getClose()<sdd.getMa_20() 		// 收盘在20日线以下
//					&& (sdd_b1.getHigh()+sdd_b1.getLow())/2<sdd_b1.getMa_20() // 均价跌破20日均线
//					&& sdd.getHigh()<sdd.getMa_20()  // 连续两天跌破20日均线
//					&& (sdd_b1.getHigh()+sdd_b1.getLow())/2>(sdd.getHigh()+sdd.getLow())/2// 重心转为向下
//					&& (sdd.getHigh()+sdd.getLow())/2<sdd.getMa_5() // 均价跌破5日均线
//					&& sdd.getMa_macd()<=sdd_b1.getMa_macd() && sdd_b1.getMa_macd()<=sdd_b2.getMa_macd()  // 连续三天MACD下跌
					)	 // macd 柱趋势向下	
//					||(sdd.getHigh()>sdd.getMa_20()) 	// 盘中上冲到20日均线上，则止盈卖出 
					
					)
					{
						
						isStockSaleDay=true;  // 满足卖出日条件，则设置为卖出日标志
						
						// 当出现CCI超卖指标
	//					TransactionRecordData trd=new TransactionRecordData();
	//					StockDayData buySDD=shs.getBuySDD();
						trd.setStockcode(sdd.getCode());
						trd.setBuySDD(buySDD);
						trd.setSaleSDD(sdd);
						
						// 收益计算
						double transactionProfit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getOpen())/trd.getBuySDD().getOpen())*100-0.2;
						trd.setTransactionProfit(transactionProfit);
						
						accountDD.saleTransList.add(trd);
						
						if(lastSalePrice==10000 || sdd.getClose()>lastSalePrice)
						{
							lastSalePrice=sdd.getClose(); // 记录上一次卖出时的价格
						}
						
						// 更新accountDD持仓列表
						accountDD.stockHoldList.remove(j);
						
						// 更新accountDD现金价值
						int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
						int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
						accountDD.setCashValue(newCashValue);
						accountDD.setStockValue(newStockValue);
						
						
					}
					else
					{
						// 如不卖出，就继续持有不变，更新持仓价格
						shs.setCurDate(transDate);
						shs.setCurPrice(sdd.getClose());	
					}
					
				}
				
				
				// 检查股票池里备选的股票走势情况，再决定是否买入，并更新持仓股票
				Iterator it=stockDataMap.keySet().iterator();
				while(it.hasNext())
				{
					
					// 从备选股票池中取出一只股票
					String stockcode=it.next().toString();  
					List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
					if (checkStockHoldList(stockHoldList, stockcode)==true || isStockSaleDay)  // 如果已经持股，或者当天是卖出日，则不做增仓买入
					{
						continue;
					}
					
					// 取出此股前几天的数据
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
					
	//				if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null || sdd_b4==null || sdd_b5==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
	//				{
	//					continue;
	//				}
	//				
	//				if (sdd_b6==null || sdd_b7==null || sdd_b8==null || sdd_b9==null)
	//				{
	//					continue;
	//				}
	//				
	//				if (sdd_b10==null || sdd_b11==null || sdd_b12==null || sdd_b13==null || sdd_b14==null || sdd_b15==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
	//				{
	//					continue;
	//				}
					
					// 获取前几天的数据
					List pastStockList2=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 2); 
					List pastStockList3=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 3);  
					List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
					List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);
					List pastStockList15=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 15);
					List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
					List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
					List pastStockList100=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 100);
					List pastStockList150=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 150);
	//				String dateb1=sdd_b1.getDate();   // debug代码
	//				System.out.println(dateb1);
					
					if (sdd_b1.getDate().contains("2021/08/09"))
					{
						int t=1;
						t++;
					}
					
					
// *****************************  判断此股当前形势，决定是否买入  *****************************  
					
					if ( 
							1>0
							&& sdd.getClose_rise()>1 // 涨幅大于1就跟随买入
							&& sdd.getReal_rise()>1  // 红柱涨幅>1
							&& sdd.getClose()>sdd.getMa_5() && sdd.getMa_5()>sdd.getMa_10()
//							calculatePriceGapRatio(sdd_b1.getClose(), sdd_b1.getMa_5())<0.04  //前一天的收盘价在ma5上，且相距很近
//							&& sdd_b1.getSwing()<7    // 前一天没有太大偏离5日线
//							&& sdd_b1.getReal_rise()>0		 // 前一天是阳柱
//							&& sdd_b1.getClose()>sdd_b1.getMa_5()  //  前一天收盘收于5日均线上
//							&& sdd_b1.getClose()>sdd_b1.getMa_10()  //  前一天收盘收于20日均线上
//							&& sdd.getClose()>sdd.getMa_20()
//							&& sdd_b1.getMa_5()>sdd_b1.getMa_60()  //  MA5>ma60
//							&& checkDayData_MA_dtpl(sdd_b1)    // 过去1日呈多头排列趋势
//							&& checkPastDaysHighPrice(sdd_b1, stockDataRecordList, sdd_b1.getPosNum(), 500)
//							&& !(sdd_b1.getMa_60()>sdd_b1.getMa_5() && sdd_b1.getMa_60()>sdd_b1.getMa_10() && sdd_b1.getMa_60()>sdd_b1.getMa_20())
//							&& checkPastDaysMACDTrends_UP(pastStockList3, 0)	 // macd 柱趋势向上
//							&& sdd_b6.getMa_5()>sdd_b6.getMa_60()     // 非常重要的一个条件！！准确描述了走势形态	
//							&& checkPastDaysMACDTrends_MA20(pastStockList5, 5)
//							&& checkPastDaysMACDTrends_MA10(pastStockList5, 5)
							
							)
					{
						
						
						// 当出现多头排列，就买入，并记录买入交易
						TransactionRecordData trd=new TransactionRecordData();
						trd.setBuySDD(sdd);
						accountDD.buyTransList.add(trd);
						
						// 更新accountDD持仓列表
						StockHoldShare shs=new StockHoldShare();
						
						// 计算可买入股票数量
	//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
	//					int amount=0;
	//					if (accountDD.cashValue>eachStockInvestMoney)
	//					{
	//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // 剩余现金足够投资一份当前股票
	//					}
	//					else
	//					{
	//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金不够投资一份当前股票，则全部买入
	//					}
						
						int amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金全部买入
						
						// 添加新买入的持仓股票
						shs.setAmount(amount);
						shs.setCode(sdd.getCode());
						shs.setName(sdd.getName());
						shs.setBuyPrice(sdd.getOpen());
						shs.setBuyDate(sdd.getDate());
						shs.setCurPrice(sdd.getClose());
						shs.setCurDate(sdd.getDate());
						shs.setBuySDD(sdd);
						stockHoldList.add(shs);
						
						// 更新accountDD现金价值
						int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
						int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
						accountDD.setCashValue(newCashValue);
						accountDD.setStockValue(newStockValue);
						
					}
					else
					{
						
						// 如果未接上继续上涨，而是继续下跌了，WR100回继续冲向80以上，这说明走势已坏，不能继续用股价接力的方法，
						// 要等待WR100再次回到20以下再次发动一轮新的上涨
						if (sdd.getWR100()>80)   
						{
	//						System.out.println("SDD WR: "+sdd.getDate()+"  "+sdd.getWR100());
							lastSalePrice=10000;  
						}
						
					}
					
				}
				
				// 更新个人账户的每日账户信息
				Map accountDataMap=psa.getAccountDataMap();
				accountDataMap.put(transDate, accountDD);
				accountDD_pre=accountDD;
				
			}
			
			// 输出投资交易记录，模拟交易金额变化曲线，对比评估交易策略
			String modelName="投资组合_MACD新多头排列指标_MA20";
			List transactionDataList=generateTransactionDataListFromPSA(psa);
			String reportLine=outputTransactionRecordReport(transactionDataList, modelName);
			// code name date_c saledate year days buy_price sale_price profit 
			
	//		outputAccountRecordReport(psa); // 输出account的每日投资内容，价格变化，现金价值/总价值  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
			
	//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
	//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, 易方达消费 
			
			ModelEvaluationReport mer=new ModelEvaluationReport();
			mer.setTransactionDataList(transactionDataList);
			mer.setReportLine(reportLine);
			mer.setModelName(modelName);
			
			return mer;
		}	
		
		// 模拟投资 - zzyl 追涨盈利minute指标策略
		public ModelEvaluationReport processInvestmentByStrategy_zzyl_minute(Map stockDataMap, String startDate, String endDate)
		{
			
			// 创建一个个人模拟账户
			PersonalStockAccount psa=new PersonalStockAccount();
			
			List dateList=CommonTool.generateTimeReferenceList(startDate, endDate, dateType);
			
			// 创建昨天的accountDD_pre
	 		AccountDayData accountDD_pre=new AccountDayData();  
			accountDD_pre.setCashValue(psa.investMoney);
			
			double lastSalePrice=10000;  // 上一次抛出时的价格, 初始值10000
			String lastSaleDate="";
			boolean isMACDChanged=false;   // 上一次抛出到现在MACD 5>60的趋势是否改变
			boolean isStockSaleDay=false;
			
			// 模拟每个交易日交易
			for (int i=0; i<dateList.size(); i++)
			{
				
				// 取出一个交易日期
				String transDate=dateList.get(i).toString();
				isStockSaleDay=false;  // 先默认不是股票卖出日
				
				// 创建一个当日的交易账户对象accountDD，并继承昨日的持仓和现金
				AccountDayData accountDD=new AccountDayData();
				accountDD.setPosNum(i);
				accountDD.setDate(transDate);
				accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // 继承昨日的持仓
				accountDD.setCashValue(accountDD_pre.getCashValue());	// 继承昨日的现金
				
				// 检查当前持仓的股票走势状况，先决定是否卖出，并更新持仓股票及各股持仓价格
				List stockHoldList=accountDD.getStockHoldList();
				int stockHoldSize=stockHoldList.size();
				for (int j=stockHoldSize-1; j>=0; j--)
				{
					// 取出一个持股对象
					StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
					
					// 获得此持股的历史数据
					String stockcode=shs.getCode();
					List stockDataRecordList=(List)stockDataMap.get(stockcode);
					
					// 取出此股前几天的数据
					StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
					StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
					StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
					
					
					if (sdd==null || sdd_b1==null || sdd_b2==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
					{
						shs.setCurDate(transDate);
						continue;
					}
					
					TransactionRecordData trd=new TransactionRecordData();
					StockDayData buySDD=shs.getBuySDD();
					
					
					double macd_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
					
					// 获取前几天的数据
					List pastStockList3=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 3);
					List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
					List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10); 
					List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
					List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
					
	//				sdd_b1=(StockDayData)pastStockList.get(1);   // 从序列中取出
							
	//				System.out.println(i);
					
					
// *****************************  判断此股当前形势，决定是否卖出  *****************************  

					if ( 
					i==dateList.size()-2     // 到了交易队列的最后一天，则卖出
//					|| calculatePriceGapRatio(sdd.getClose(), sdd.getMa_5())>0.06
//					|| !checkPastDaysMACDTrends_NDBL_UP(pastStockList3, 1)
					|| (1>0
					&& sdd.getClose()<sdd.getMa_20()
					&& sdd.getDate().substring(0, 10).compareTo(buySDD.getDate().substring(0,10))>0  // 必须第二天后才能卖
//					&& sdd.getDate().endsWith("001")   // 开盘卖出
//					&& sdd.getClose_rise()<0    // 阴柱
//					&& sdd.getClose()<sdd.getMa_20() 		// 收盘在20日线以下
//					&& (sdd_b1.getHigh()+sdd_b1.getLow())/2<sdd_b1.getMa_20() // 均价跌破20日均线
//					&& sdd.getHigh()<sdd.getMa_20()  // 连续两天跌破20日均线
//					&& (sdd_b1.getHigh()+sdd_b1.getLow())/2>(sdd.getHigh()+sdd.getLow())/2// 重心转为向下
//					&& (sdd.getHigh()+sdd.getLow())/2<sdd.getMa_5() // 均价跌破5日均线
//					&& sdd.getMa_macd()<=sdd_b1.getMa_macd() && sdd_b1.getMa_macd()<=sdd_b2.getMa_macd()  // 连续三天MACD下跌
					)	 // macd 柱趋势向下	
//					||(sdd.getHigh()>sdd.getMa_20()) 	// 盘中上冲到20日均线上，则止盈卖出 
					
					)
					{
						
						isStockSaleDay=true;  // 满足卖出日条件，则设置为卖出日标志
						
						// 当出现CCI超卖指标
	//					TransactionRecordData trd=new TransactionRecordData();
	//					StockDayData buySDD=shs.getBuySDD();
						trd.setStockcode(sdd.getCode());
						trd.setBuySDD(buySDD);
						trd.setSaleSDD(sdd);
						
						// 收益计算 - 按收盘买，开盘抛计算profit
						double transactionProfit=((trd.getSaleSDD().getClose()-trd.getBuySDD().getClose())/trd.getBuySDD().getClose())*100-0.2;
						trd.setTransactionProfit(transactionProfit);
						
						accountDD.saleTransList.add(trd);
						
						if(lastSalePrice==10000 || sdd.getClose()>lastSalePrice)
						{
							lastSalePrice=sdd.getClose(); // 记录上一次卖出时的价格
						}
						
						// 更新accountDD持仓列表
						accountDD.stockHoldList.remove(j);
						
						// 更新accountDD现金价值
						int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
						int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
						accountDD.setCashValue(newCashValue);
						accountDD.setStockValue(newStockValue);
						
						
					}
					else
					{
						// 如不卖出，就继续持有不变，更新持仓价格
						shs.setCurDate(transDate);
						shs.setCurPrice(sdd.getClose());	
					}
					
				}
				
				
				// 检查股票池里备选的股票走势情况，再决定是否买入，并更新持仓股票
				Iterator it=stockDataMap.keySet().iterator();
				while(it.hasNext())
				{
					
					// 从备选股票池中取出一只股票
					String stockcode=it.next().toString();  
					List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
					if (checkStockHoldList(stockHoldList, stockcode)==true || isStockSaleDay)  // 如果已经持股，或者当天是卖出日，则不做增仓买入
					{
						continue;
					}
					
					// 取出此股前几天的数据
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
					
	//				if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null || sdd_b4==null || sdd_b5==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
	//				{
	//					continue;
	//				}
	//				
	//				if (sdd_b6==null || sdd_b7==null || sdd_b8==null || sdd_b9==null)
	//				{
	//					continue;
	//				}
	//				
	//				if (sdd_b10==null || sdd_b11==null || sdd_b12==null || sdd_b13==null || sdd_b14==null || sdd_b15==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
	//				{
	//					continue;
	//				}
					
					// 获取前几天的数据
					List pastStockList2=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 2); 
					List pastStockList3=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 3);  
					List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
					List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);
					List pastStockList15=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 15);
					List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
					List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
					List pastStockList100=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 100);
					List pastStockList150=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 150);
	//				String dateb1=sdd_b1.getDate();   // debug代码
	//				System.out.println(dateb1);
					
					
// *****************************  判断此股当前形势，决定是否买入  *****************************  
					
					if ( 
						1>0
						&& sdd.getClose_rise()>1 // 涨幅大于1就跟随买入
						&& sdd.getReal_rise()>1  // 红柱涨幅>1
						&& sdd.getClose()>sdd.getMa_5() && sdd.getMa_5()>sdd.getMa_10()
//						calculatePriceGapRatio(sdd_b1.getClose(), sdd_b1.getMa_5())<0.04  //前一天的收盘价在ma5上，且相距很近
//						&& sdd_b1.getSwing()<7    // 前一天没有太大偏离5日线
//						&& sdd_b1.getReal_rise()>0		 // 前一天是阳柱
//						&& sdd_b1.getClose()>sdd_b1.getMa_5()  //  前一天收盘收于5日均线上
//						&& sdd_b1.getClose()>sdd_b1.getMa_10()  //  前一天收盘收于20日均线上
//						&& sdd.getClose()>sdd.getMa_20()
//						&& sdd_b1.getMa_5()>sdd_b1.getMa_60()  //  MA5>ma60
//						&& checkDayData_MA_dtpl(sdd_b1)    // 过去1日呈多头排列趋势
//						&& checkPastDaysHighPrice(sdd_b1, stockDataRecordList, sdd_b1.getPosNum(), 500)
//						&& !(sdd_b1.getMa_60()>sdd_b1.getMa_5() && sdd_b1.getMa_60()>sdd_b1.getMa_10() && sdd_b1.getMa_60()>sdd_b1.getMa_20())
//						&& checkPastDaysMACDTrends_UP(pastStockList3, 0)	 // macd 柱趋势向上
//						&& sdd_b6.getMa_5()>sdd_b6.getMa_60()     // 非常重要的一个条件！！准确描述了走势形态	
//						&& checkPastDaysMACDTrends_MA20(pastStockList5, 5)
//						&& checkPastDaysMACDTrends_MA10(pastStockList5, 5)
						
						)
					{
						
						
						// 当出现多头排列，就买入，并记录买入交易
						TransactionRecordData trd=new TransactionRecordData();
						trd.setBuySDD(sdd);
						accountDD.buyTransList.add(trd);
						
						// 更新accountDD持仓列表
						StockHoldShare shs=new StockHoldShare();
						
						// 计算可买入股票数量
	//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
	//					int amount=0;
	//					if (accountDD.cashValue>eachStockInvestMoney)
	//					{
	//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // 剩余现金足够投资一份当前股票
	//					}
	//					else
	//					{
	//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金不够投资一份当前股票，则全部买入
	//					}
						
						int amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金全部买入
						
						// 添加新买入的持仓股票
						shs.setAmount(amount);
						shs.setCode(sdd.getCode());
						shs.setName(sdd.getName());
						shs.setBuyPrice(sdd.getOpen());
						shs.setBuyDate(sdd.getDate());
						shs.setCurPrice(sdd.getClose());
						shs.setCurDate(sdd.getDate());
						shs.setBuySDD(sdd);
						stockHoldList.add(shs);
						
						// 更新accountDD现金价值
						int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
						int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
						accountDD.setCashValue(newCashValue);
						accountDD.setStockValue(newStockValue);
						
					}
					else
					{
						
						// 如果未接上继续上涨，而是继续下跌了，WR100回继续冲向80以上，这说明走势已坏，不能继续用股价接力的方法，
						// 要等待WR100再次回到20以下再次发动一轮新的上涨
						if (sdd.getWR100()>80)   
						{
	//						System.out.println("SDD WR: "+sdd.getDate()+"  "+sdd.getWR100());
							lastSalePrice=10000;  
						}
						
					}
					
				}
				
				// 更新个人账户的每日账户信息
				Map accountDataMap=psa.getAccountDataMap();
				accountDataMap.put(transDate, accountDD);
				accountDD_pre=accountDD;
				
			}
			
			// 输出投资交易记录，模拟交易金额变化曲线，对比评估交易策略
			String modelName="投资组合_追涨盈利_Minute30";
			List transactionDataList=generateTransactionDataListFromPSA(psa);
			String reportLine=outputTransactionRecordReport(transactionDataList, modelName);
			// code name date_c saledate year days buy_price sale_price profit 
			
	//		outputAccountRecordReport(psa); // 输出account的每日投资内容，价格变化，现金价值/总价值  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
			
	//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
	//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, 易方达消费 
			
			ModelEvaluationReport mer=new ModelEvaluationReport();
			mer.setTransactionDataList(transactionDataList);
			mer.setReportLine(reportLine);
			mer.setModelName(modelName);
			
			return mer;
		}
		
		
		// 模拟投资 - zzpm 追涨排名 minute 指标策略
		public ModelEvaluationReport processInvestmentByStrategy_zzpm_minute(Map stockDataMap, String startDate, String endDate)
		{
			
			// 创建一个个人模拟账户
			PersonalStockAccount psa=new PersonalStockAccount();
			
			List dateList=CommonTool.generateTimeReferenceList(startDate, endDate, dateType);
			
			// 创建昨天的accountDD_pre
	 		AccountDayData accountDD_pre=new AccountDayData();  
			accountDD_pre.setCashValue(psa.investMoney);
			
			double lastSalePrice=10000;  // 上一次抛出时的价格, 初始值10000
			String lastSaleDate="";
			boolean isMACDChanged=false;   // 上一次抛出到现在MACD 5>60的趋势是否改变
			boolean isStockSaleDay=false;
			
			// 模拟每个交易日交易
			for (int i=0; i<dateList.size(); i++)
			{
				
				// 取出一个交易日期
				String transDate=dateList.get(i).toString();
				isStockSaleDay=false;  // 先默认不是股票卖出日
				
				// 创建一个当日的交易账户对象accountDD，并继承昨日的持仓和现金
				AccountDayData accountDD=new AccountDayData();
				accountDD.setPosNum(i);
				accountDD.setDate(transDate);
				accountDD.setStockHoldList(CommonTool.cloneStockHoldList(accountDD_pre.getStockHoldList())); // 继承昨日的持仓
				accountDD.setCashValue(accountDD_pre.getCashValue());	// 继承昨日的现金
				
				// 检查当前持仓的股票走势状况，先决定是否卖出，并更新持仓股票及各股持仓价格
				List stockHoldList=accountDD.getStockHoldList();
				int stockHoldSize=stockHoldList.size();
				for (int j=stockHoldSize-1; j>=0; j--)
				{
					// 取出一个持股对象
					StockHoldShare shs=(StockHoldShare)stockHoldList.get(j);
					
					// 获得此持股的历史数据
					String stockcode=shs.getCode();
					List stockDataRecordList=(List)stockDataMap.get(stockcode);
					
					// 取出此股前几天的数据
					StockDayData sdd=CommonTool.getStockDayData(stockDataRecordList, transDate);
					StockDayData sdd_b1=CommonTool.getStockDayData(stockDataRecordList, transDate, -1);
					StockDayData sdd_b2=CommonTool.getStockDayData(stockDataRecordList, transDate, -2);
					
					
					if (sdd==null || sdd_b1==null || sdd_b2==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
					{
						shs.setCurDate(transDate);
						continue;
					}
					
					TransactionRecordData trd=new TransactionRecordData();
					StockDayData buySDD=shs.getBuySDD();
					
					
					double macd_profit=CommonTool.calculateTransactionProfit(buySDD, sdd);
					
					// 获取前几天的数据
					List pastStockList3=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 3);
					List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
					List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10); 
					List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
					List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
					
	//				sdd_b1=(StockDayData)pastStockList.get(1);   // 从序列中取出
							
	//				System.out.println(i);
					
					
// *****************************  判断此股当前形势，决定是否卖出  *****************************  

					if ( 
					i==dateList.size()-2     // 到了交易队列的最后一天，则卖出
//					|| calculatePriceGapRatio(sdd.getClose(), sdd.getMa_5())>0.06
//					|| !checkPastDaysMACDTrends_NDBL_UP(pastStockList3, 1)
					|| (1>0
//					&& sdd.getClose()<sdd.getMa_20()
					&& sdd.getDate().substring(0, 10).compareTo(buySDD.getDate().substring(0,10))>0  // 第二天开盘立即卖
//					&& sdd.getDate().endsWith("001")   // 开盘卖出
//					&& sdd.getClose_rise()<0    // 阴柱
//					&& sdd.getClose()<sdd.getMa_20() 		// 收盘在20日线以下
//					&& (sdd_b1.getHigh()+sdd_b1.getLow())/2<sdd_b1.getMa_20() // 均价跌破20日均线
//					&& sdd.getHigh()<sdd.getMa_20()  // 连续两天跌破20日均线
//					&& (sdd_b1.getHigh()+sdd_b1.getLow())/2>(sdd.getHigh()+sdd.getLow())/2// 重心转为向下
//					&& (sdd.getHigh()+sdd.getLow())/2<sdd.getMa_5() // 均价跌破5日均线
//					&& sdd.getMa_macd()<=sdd_b1.getMa_macd() && sdd_b1.getMa_macd()<=sdd_b2.getMa_macd()  // 连续三天MACD下跌
					)	 // macd 柱趋势向下	
//					||(sdd.getHigh()>sdd.getMa_20()) 	// 盘中上冲到20日均线上，则止盈卖出 
					
					)
					{
						
						isStockSaleDay=true;  // 满足卖出日条件，则设置为卖出日标志
						
						// 当出现CCI超卖指标
	//					TransactionRecordData trd=new TransactionRecordData();
	//					StockDayData buySDD=shs.getBuySDD();
						trd.setStockcode(sdd.getCode());
						trd.setBuySDD(buySDD);
						trd.setSaleSDD(sdd);
						
						// 收益计算 - 按开盘买，开盘抛计算profit
						double transactionProfit=0;
						if (sdd.getOpen()<sdd.getMa_10())    // 开盘低于 ma10立即抛，否则等该sdd收盘抛
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
							lastSalePrice=sdd.getClose(); // 记录上一次卖出时的价格
						}
						
						// 更新accountDD持仓列表
						accountDD.stockHoldList.remove(j);
						
						// 更新accountDD现金价值
						int newCashValue=accountDD.getCashValue()+(int)sdd.getOpen()*shs.getAmount();
						int newStockValue=accountDD.getStockValue()-(int)sdd.getOpen()*shs.getAmount();
						accountDD.setCashValue(newCashValue);
						accountDD.setStockValue(newStockValue);
						
						
					}
					else
					{
						// 如不卖出，就继续持有不变，更新持仓价格
						shs.setCurDate(transDate);
						shs.setCurPrice(sdd.getClose());	
					}
					
				}
				
				
				// 检查股票池里备选的股票走势情况，再决定是否买入，并更新持仓股票
				Iterator it=stockDataMap.keySet().iterator();
				while(it.hasNext())
				{
					
					// 从备选股票池中取出一只股票
					String stockcode=it.next().toString();  
					List stockDataRecordList=(List)stockDataMap.get(stockcode);
				
					if (checkStockHoldList(stockHoldList, stockcode)==true || isStockSaleDay)  // 如果已经持股，或者当天是卖出日，则不做增仓买入
					{
						continue;
					}
					
					// 取出此股前几天的数据
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
					
	//				if (sdd==null || sdd_b1==null || sdd_b2==null || sdd_b3==null || sdd_b4==null || sdd_b5==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
	//				{
	//					continue;
	//				}
	//				
	//				if (sdd_b6==null || sdd_b7==null || sdd_b8==null || sdd_b9==null)
	//				{
	//					continue;
	//				}
	//				
	//				if (sdd_b10==null || sdd_b11==null || sdd_b12==null || sdd_b13==null || sdd_b14==null || sdd_b15==null) // 当天停牌，没有交易记录，则记录当天日期及之前的价格
	//				{
	//					continue;
	//				}
					
					// 获取前几天的数据
					List pastStockList2=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 2); 
					List pastStockList3=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 3);  
					List pastStockList5=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 5);  
					List pastStockList10=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 10);
					List pastStockList15=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 15);
					List pastStockList20=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 20);
					List pastStockList40=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 40);
					List pastStockList100=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 100);
					List pastStockList150=CommonTool.getPastStockDayDataList(stockDataRecordList, sdd, 150);
	//				String dateb1=sdd_b1.getDate();   // debug代码
	//				System.out.println(dateb1);
					
					
// *****************************  判断此股当前形势，决定是否买入  *****************************  
					
					if ( 
						1>0
//						&& sdd_b1.getDate().endsWith("001")
						&& sdd_b1.getRise_speed_rank()<=1  // 涨速排名第一
//						&& sdd_b1.getClose_rise()>0.5 // 总涨幅大于0.5%
						&& sdd_b1.getReal_rise()>1  // 红柱涨幅大于1
						&& sdd_b1.getClose()>sdd_b1.getMa_5() && sdd_b1.getMa_5()>sdd_b1.getMa_10()
//						calculatePriceGapRatio(sdd_b1.getClose(), sdd_b1.getMa_5())<0.04  //前一天的收盘价在ma5上，且相距很近
//						&& sdd_b1.getSwing()<7    // 前一天没有太大偏离5日线
//						&& sdd_b1.getReal_rise()>0		 // 前一天是阳柱
//						&& sdd_b1.getClose()>sdd_b1.getMa_5()  //  前一天收盘收于5日均线上
//						&& sdd_b1.getClose()>sdd_b1.getMa_10()  //  前一天收盘收于20日均线上
//						&& sdd.getClose()>sdd.getMa_20()
//						&& sdd_b1.getMa_5()>sdd_b1.getMa_60()  //  MA5>ma60
//						&& checkDayData_MA_dtpl(sdd_b1)    // 过去1日呈多头排列趋势
//						&& checkPastDaysHighPrice(sdd_b1, stockDataRecordList, sdd_b1.getPosNum(), 500)
//						&& !(sdd_b1.getMa_60()>sdd_b1.getMa_5() && sdd_b1.getMa_60()>sdd_b1.getMa_10() && sdd_b1.getMa_60()>sdd_b1.getMa_20())
//						&& checkPastDaysMACDTrends_UP(pastStockList3, 0)	 // macd 柱趋势向上
//						&& sdd_b6.getMa_5()>sdd_b6.getMa_60()     // 非常重要的一个条件！！准确描述了走势形态	
//						&& checkPastDaysMACDTrends_MA20(pastStockList5, 5)
//						&& checkPastDaysMACDTrends_MA10(pastStockList5, 5)
						
						)
					{
						
						
						// 当出现多头排列，就买入，并记录买入交易
						TransactionRecordData trd=new TransactionRecordData();
						trd.setBuySDD(sdd);
						accountDD.buyTransList.add(trd);
						
						// 更新accountDD持仓列表
						StockHoldShare shs=new StockHoldShare();
						
						// 计算可买入股票数量
	//					int eachStockInvestMoney=(int)psa.investMoney/psa.holdCount;
	//					int amount=0;
	//					if (accountDD.cashValue>eachStockInvestMoney)
	//					{
	//						amount=(int)(eachStockInvestMoney/sdd.getOpen());  // 剩余现金足够投资一份当前股票
	//					}
	//					else
	//					{
	//						amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金不够投资一份当前股票，则全部买入
	//					}
						
						int amount=(int)(accountDD.cashValue/sdd.getOpen());   // 剩余现金全部买入
						
						// 添加新买入的持仓股票
						shs.setAmount(amount);
						shs.setCode(sdd.getCode());
						shs.setName(sdd.getName());
						shs.setBuyPrice(sdd.getOpen());
						shs.setBuyDate(sdd.getDate());
						shs.setCurPrice(sdd.getClose());
						shs.setCurDate(sdd.getDate());
						shs.setBuySDD(sdd);
						stockHoldList.add(shs);
						
						// 更新accountDD现金价值
						int newCashValue=(int)(accountDD.getCashValue()-sdd.getOpen()*amount);
						int newStockValue=(int)(accountDD.getStockValue()+sdd.getOpen()*amount);
						accountDD.setCashValue(newCashValue);
						accountDD.setStockValue(newStockValue);
						
					}
					else
					{
						
						// 如果未接上继续上涨，而是继续下跌了，WR100回继续冲向80以上，这说明走势已坏，不能继续用股价接力的方法，
						// 要等待WR100再次回到20以下再次发动一轮新的上涨
						if (sdd.getWR100()>80)   
						{
	//						System.out.println("SDD WR: "+sdd.getDate()+"  "+sdd.getWR100());
							lastSalePrice=10000;  
						}
						
					}
					
				}
				
				// 更新个人账户的每日账户信息
				Map accountDataMap=psa.getAccountDataMap();
				accountDataMap.put(transDate, accountDD);
				accountDD_pre=accountDD;
				
			}
			
			// 输出投资交易记录，模拟交易金额变化曲线，对比评估交易策略
			String modelName="投资组合_涨速排名_Minute15";
			List transactionDataList=generateTransactionDataListFromPSA(psa);
			String reportLine=outputTransactionRecordReport(transactionDataList, modelName);
			// code name date_c saledate year days buy_price sale_price profit 
			
	//		outputAccountRecordReport(psa); // 输出account的每日投资内容，价格变化，现金价值/总价值  stockhold(code, name, amount, buyprice, curprice, value) stockvalue cashvalue totalvalue
			
	//		List stockDayDataList=generateStockDayDataListFromPSA(psa);
	//		compareInvestmentByChart_normal(stockDayDataList);  // 50ETF, 500ETF, 易方达消费 
			
			ModelEvaluationReport mer=new ModelEvaluationReport();
			mer.setTransactionDataList(transactionDataList);
			mer.setReportLine(reportLine);
			mer.setModelName(modelName);
			
			return mer;
		}	
		
		
}
