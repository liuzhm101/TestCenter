package com.finance.stock.data;

public class StockDayMarketSumData {

	public String date;
	public String type;
	public double total_liquid_value;
	public double total_money;  
	public int count;

	public int rise_count;
	public int down_count;
	public double rd_ratio;
	
	public int rise10_count;
	public int down10_count;
	public double rd10_ratio;

	public int rise7_count;
	public int down7_count;
	public double rd7_ratio;

	public int rise5_count;
	public int down5_count;
	public double rd5_ratio;

	public int rise3_count;
	public int down3_count;
	public double rd3_ratio;


	public int rise0_count;
	public int down0_count;
	public double rd0_ratio;	
	
	public int flat_count;
	


	public int rise_count_open;
	public int down_count_open;
	public double rd_ratio_open;
	
	public int rise10_count_open;
	public int down10_count_open;
	public double rd10_ratio_open;

	public int rise7_count_open;
	public int down7_count_open;
	public double rd7_ratio_open;

	public int rise5_count_open;
	public int down5_count_open;
	public double rd5_ratio_open;

	public int rise3_count_open;
	public int down3_count_open;
	public double rd3_ratio_open;


	public int rise0_count_open;
	public int down0_count_open;
	public double rd0_ratio_open;	
	
	public int flat_count_open;
	
	
	
	public double total_rise_percent;
	public double avg_total_rise_percent;

	public double total_down_percent;
	public double avg_total_down_percent;
	public double rd_total_ratio;
	
	public double actual_rise_percent;
	public double avg_actual_rise_percent;
	public double actual_down_percent;
	public double avg_actual_down_percent;
	public double rd_actual_ratio;	
	
	public double equalWeightRise;
	public double equalWeightTotalRise;
	public int equalWeightCount=0;
	
	public double getEqualWeightRise() {
		return equalWeightRise;
	}
	public void setEqualWeightRise(double equalWeightRise) {
		this.equalWeightRise = equalWeightRise;
	}
	public void setTotal_money(double total_money) {
		this.total_money = total_money;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getTotal_liquid_value() { 
		return total_liquid_value; 
	}
	public void setTotal_liquid_value(double total_liquid_value) {
		this.total_liquid_value = total_liquid_value;
	}
	public double getTotal_money() {
		return total_money;
	}
	public void setTotal_amount(double total_money) {
		this.total_money = total_money;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getRise_count() {
		return rise_count;
	}
	public void setRise_count(int rise_count) {
		this.rise_count = rise_count;
	}
	public int getDown_count() {
		return down_count;
	}
	public void setDown_count(int down_count) {
		this.down_count = down_count;
	}
	public double getRd_ratio() {
		return rd_ratio;
	}
	public void setRd_ratio(double rd_ratio) {
		this.rd_ratio = rd_ratio;
	}
	public int getRise10_count() {
		return rise10_count;
	}
	public void setRise10_count(int rise10_count) {
		this.rise10_count = rise10_count;
	}
	public int getDown10_count() {
		return down10_count;
	}
	public void setDown10_count(int down10_count) {
		this.down10_count = down10_count;
	}
	public double getRd10_ratio() {
		return rd10_ratio;
	}
	public void setRd10_ratio(double rd10_ratio) {
		this.rd10_ratio = rd10_ratio;
	}
	public int getRise7_count() {
		return rise7_count;
	}
	public void setRise7_count(int rise7_count) {
		this.rise7_count = rise7_count;
	}
	public int getDown7_count() {
		return down7_count;
	}
	public void setDown7_count(int down7_count) {
		this.down7_count = down7_count;
	}
	public double getRd7_ratio() {
		return rd7_ratio;
	}
	public void setRd7_ratio(double rd7_ratio) {
		this.rd7_ratio = rd7_ratio;
	}
	public int getRise5_count() {
		return rise5_count;
	}
	public void setRise5_count(int rise5_count) {
		this.rise5_count = rise5_count;
	}
	public int getDown5_count() {
		return down5_count;
	}
	public void setDown5_count(int down5_count) {
		this.down5_count = down5_count;
	}
	public double getRd5_ratio() {
		return rd5_ratio;
	}
	public void setRd5_ratio(double rd5_ratio) {
		this.rd5_ratio = rd5_ratio;
	}
	public int getRise3_count() {
		return rise3_count;
	}
	public void setRise3_count(int rise3_count) {
		this.rise3_count = rise3_count;
	}
	public int getDown3_count() {
		return down3_count;
	}
	public void setDown3_count(int down3_count) {
		this.down3_count = down3_count;
	}
	public double getRd3_ratio() {
		return rd3_ratio;
	}
	public void setRd3_ratio(double rd3_ratio) {
		this.rd3_ratio = rd3_ratio;
	}
	public double getTotal_rise_percent() {
		return total_rise_percent;
	}
	public void setTotal_rise_percent(double total_rise_percent) {
		this.total_rise_percent = total_rise_percent;
	}
	public double getTotal_down_percent() {
		return total_down_percent;
	}
	public void setTotal_down_percent(double total_down_percent) {
		this.total_down_percent = total_down_percent;
	}
	public double getRd_total_ratio() {
		return rd_total_ratio;
	}
	public void setRd_total_ratio(double rd_total_ratio) {
		this.rd_total_ratio = rd_total_ratio;
	}
	public double getActual_rise_percent() {
		return actual_rise_percent;
	}
	public void setActual_rise_percent(double actual_rise_percent) {
		this.actual_rise_percent = actual_rise_percent;
	}
	public double getActual_down_percent() {
		return actual_down_percent;
	}
	public void setActual_down_percent(double actual_down_percent) {
		this.actual_down_percent = actual_down_percent;
	}
	public double getRd_actual_ratio() {
		return rd_actual_ratio;
	}
	public void setRd_actual_ratio(double rd_actual_ratio) {
		this.rd_actual_ratio = rd_actual_ratio;
	}
	public int getRise0_count() {
		return rise0_count;
	}
	public void setRise0_count(int rise0_count) {
		this.rise0_count = rise0_count;
	}
	public int getDown0_count() {
		return down0_count;
	}
	public void setDown0_count(int down0_count) {
		this.down0_count = down0_count;
	}
	public double getRd0_ratio() {
		return rd0_ratio;
	}
	public void setRd0_ratio(double rd0_ratio) {
		this.rd0_ratio = rd0_ratio;
	}
	public int getFlat_count() {
		return flat_count;
	}
	public void setFlat_count(int flat_count) {
		this.flat_count = flat_count;
	}
	
	
	public int getRise_count_open() {
		return rise_count_open;
	}
	public void setRise_count_open(int rise_count_open) {
		this.rise_count_open = rise_count_open;
	}
	public int getDown_count_open() {
		return down_count_open;
	}
	public void setDown_count_open(int down_count_open) {
		this.down_count_open = down_count_open;
	}
	public double getRd_ratio_open() {
		return rd_ratio_open;
	}
	public void setRd_ratio_open(double rd_ratio_open) {
		this.rd_ratio_open = rd_ratio_open;
	}
	public int getRise10_count_open() {
		return rise10_count_open;
	}
	public void setRise10_count_open(int rise10_count_open) {
		this.rise10_count_open = rise10_count_open;
	}
	public int getDown10_count_open() {
		return down10_count_open;
	}
	public void setDown10_count_open(int down10_count_open) {
		this.down10_count_open = down10_count_open;
	}
	public double getRd10_ratio_open() {
		return rd10_ratio_open;
	}
	public void setRd10_ratio_open(double rd10_ratio_open) {
		this.rd10_ratio_open = rd10_ratio_open;
	}
	public int getRise7_count_open() {
		return rise7_count_open;
	}
	public void setRise7_count_open(int rise7_count_open) {
		this.rise7_count_open = rise7_count_open;
	}
	public int getDown7_count_open() {
		return down7_count_open;
	}
	public void setDown7_count_open(int down7_count_open) {
		this.down7_count_open = down7_count_open;
	}
	public double getRd7_ratio_open() {
		return rd7_ratio_open;
	}
	public void setRd7_ratio_open(double rd7_ratio_open) {
		this.rd7_ratio_open = rd7_ratio_open;
	}
	public int getRise5_count_open() {
		return rise5_count_open;
	}
	public void setRise5_count_open(int rise5_count_open) {
		this.rise5_count_open = rise5_count_open;
	}
	public int getDown5_count_open() {
		return down5_count_open;
	}
	public void setDown5_count_open(int down5_count_open) {
		this.down5_count_open = down5_count_open;
	}
	public double getRd5_ratio_open() {
		return rd5_ratio_open;
	}
	public void setRd5_ratio_open(double rd5_ratio_open) {
		this.rd5_ratio_open = rd5_ratio_open;
	}
	public int getRise3_count_open() {
		return rise3_count_open;
	}
	public void setRise3_count_open(int rise3_count_open) {
		this.rise3_count_open = rise3_count_open;
	}
	public int getDown3_count_open() {
		return down3_count_open;
	}
	public void setDown3_count_open(int down3_count_open) {
		this.down3_count_open = down3_count_open;
	}
	public double getRd3_ratio_open() {
		return rd3_ratio_open;
	}
	public void setRd3_ratio_open(double rd3_ratio_open) {
		this.rd3_ratio_open = rd3_ratio_open;
	}
	public int getRise0_count_open() {
		return rise0_count_open;
	}
	public void setRise0_count_open(int rise0_count_open) {
		this.rise0_count_open = rise0_count_open;
	}
	public int getDown0_count_open() {
		return down0_count_open;
	}
	public void setDown0_count_open(int down0_count_open) {
		this.down0_count_open = down0_count_open;
	}
	public double getRd0_ratio_open() {
		return rd0_ratio_open;
	}
	public void setRd0_ratio_open(double rd0_ratio_open) {
		this.rd0_ratio_open = rd0_ratio_open;
	}
	public int getFlat_count_open() {
		return flat_count_open;
	}
	public void setFlat_count_open(int flat_count_open) {
		this.flat_count_open = flat_count_open;
	}
	
	
	
	public double getAvg_total_rise_percent() {
		return avg_total_rise_percent;
	}
	public void setAvg_total_rise_percent(double avg_total_rise_percent) {
		this.avg_total_rise_percent = avg_total_rise_percent;
	}
	public double getAvg_total_down_percent() {
		return avg_total_down_percent;
	}
	public void setAvg_total_down_percent(double avg_total_down_percent) {
		this.avg_total_down_percent = avg_total_down_percent;
	}
	public double getAvg_actual_rise_percent() {
		return avg_actual_rise_percent;
	}
	public void setAvg_actual_rise_percent(double avg_actual_rise_percent) {
		this.avg_actual_rise_percent = avg_actual_rise_percent;
	}
	public double getAvg_actual_down_percent() {
		return avg_actual_down_percent;
	}
	public void setAvg_actual_down_percent(double avg_actual_down_percent) {
		this.avg_actual_down_percent = avg_actual_down_percent;
	}
	public double getEqualWeightTotalRise() {
		return equalWeightTotalRise;
	}
	public void setEqualWeightTotalRise(double equalWeightTotalRise) {
		this.equalWeightTotalRise = equalWeightTotalRise;
	}
	public int getEqualWeightCount() {
		return equalWeightCount;
	}
	public void setEqualWeightCount(int equalWeightCount) {
		this.equalWeightCount = equalWeightCount;
	}
}
