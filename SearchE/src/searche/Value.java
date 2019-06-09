package searche;

import java.util.ArrayList;

public class Value {

	
	private ArrayList<PageNameCounter> pageNameCounters;
	private ArrayList<String> PageName;
	public ArrayList<String> getPageName() {
		return PageName;
	}
	public void setPageName(ArrayList<String> pageName) {
		PageName = pageName;
	}
	private int NumberOfTimes;
	
	public int getNumberOfTimes() {
		return NumberOfTimes;
	}
	public void setNumberOfTimes(int numberOfTimes) {
		NumberOfTimes = numberOfTimes;
	}
	public ArrayList<PageNameCounter> getPageNameCounters() {
		return pageNameCounters;
	}
	public void setPageNameCounters(ArrayList<PageNameCounter> pageNameCounters) {
		this.pageNameCounters = pageNameCounters;
	}
	private String occurence;
	//private int nunberOFTimes =0;
	private int EditDistance=0;
	public int getEditDistance() {
		return EditDistance;
	}
	public void setEditDistance(int editDistance) {
		EditDistance = editDistance;
	}
	
	public String getOccurence() {
		return occurence;
	}
	public void setOccurence(String occurence) {
		this.occurence = occurence;
	}
	

	
	
}
