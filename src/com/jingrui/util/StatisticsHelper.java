package com.jingrui.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import com.jingrui.domain.NoticePeople;

public class StatisticsHelper {

	public static TreeMap<String,Integer> getStatistics(Set<NoticePeople> noticePeoples){
		TreeMap<String,Integer> table=new TreeMap<String,Integer>();
		for(NoticePeople np : noticePeoples) {
			if(np.getTaskByTaskId().getStatus()==2){
				String key_1 = np.getTaskByTaskId().getDate().substring(0,4);
				if(table.containsKey(key_1)){
					table.put(key_1, table.get(key_1)+np.getTaskByTaskId().getValue());
				}else{
					table.put(key_1, np.getTaskByTaskId().getValue());
				}
				
				String key_2 = np.getTaskByTaskId().getDate().substring(0,7);
				if(table.containsKey(key_2)){
					table.put(key_2, table.get(key_2)+np.getTaskByTaskId().getValue());
				}else{
					table.put(key_2, np.getTaskByTaskId().getValue());
				}
			}
		}
		
		return table;
	}
	
	public static List<NoticePeople> getNoticePeoplesByMonth(String month,Set<NoticePeople> nps){
		List<NoticePeople> snps = new ArrayList();
		for (NoticePeople noticePeople : nps) {
			String date = noticePeople.getTaskByTaskId().getDate();
			if(month.equals(date.substring(0, 7))){
				snps.add(noticePeople);
			}
			
		}
		return snps;
	}
}
