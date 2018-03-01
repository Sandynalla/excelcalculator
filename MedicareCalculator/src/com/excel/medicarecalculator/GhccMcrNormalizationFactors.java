package com.excel.medicarecalculator;

import java.util.Collection;

public class GhccMcrNormalizationFactors {
 
	private int dosYear;
	private double normalizationFactor;
	private double maCodingAdjustmentPercent;
	
	public GhccMcrNormalizationFactors(int dosYear, double normalizationFactors, double maCodingAdjustmentPercent) {
		super();
		this.dosYear = dosYear;
		this.normalizationFactor = normalizationFactors;
		this.maCodingAdjustmentPercent = maCodingAdjustmentPercent;	
	}

	public int getDosYear() {
		return dosYear;
	}

	public void setDosYear(int dosYear) {
		this.dosYear = dosYear;
	}

	public double getNormalizationFactor() {
		return normalizationFactor;
	}

	public void setNormalizationFactor(int normalizationFactor) {
		this.normalizationFactor = normalizationFactor;
	}

	public double getMaCodingAdjustmentPercent() {
		return maCodingAdjustmentPercent;
	}

	public void setMaCodingAdjustmentPercent(int maCodingAdjustmentPercent) {
		this.maCodingAdjustmentPercent = maCodingAdjustmentPercent;
	}

}

