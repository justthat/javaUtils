package org.qjin.myapp.commons.utils.lang;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

/**
 * @file ListUtils.java
 * @author Jin
 * @brief This file will provide method to handle List
 *
 */

public class ListUtils extends org.apache.commons.collections.ListUtils {
	public static boolean isNotEmpty(Collection<?> collection) throws Exception{
		if(collection == null || collection.size() < 1){
			return false;
		}else{
			return true;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static boolean isNotEmpty(List<?> infos) throws Exception {
		if(infos == null || infos.size() < 1){
			return false;
		}else{
			int emptyCnt = 0;
			for(int i = 0; i < infos.size(); i++){
				if(infos.get(i) instanceof List){
					List chk = (List)infos.get(i);
					if(chk.size() < 1){
						emptyCnt++;
					}
				}
			}
			
			if(emptyCnt == infos.size()) {
				return false;
			}
			return true;
		}
	}
	
	public static boolean isEmpty(Collection<?> collection) throws Exception {
		if(collection != null && collection.size() > 0){
			return false;
		}else{
			return true;
		}
	}
	
	public static boolean isEmpty(List<?> infos) throws Exception{
		if(infos != null && infos.size() > 0){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 대상이 원본을 포함하고 있지 않으면, 목록에 저장
	 * @param sourceList
	 * @param targetList
	 * @return
	 * @throws Exception
	 */
	public static <T> List<T> getUniqueIdList(
			List<T> sourceList,
			List<T> targetList) throws Exception{
		List<T> resultList = new ArrayList<T>();
		for(int i = 0; i < sourceList.size(); i++){
			if(!targetList.contains(sourceList.get(i))){
				resultList.add(sourceList.get(i));
			}
		}
		return resultList;
	}
	
	/**
	 * 대상이 원본을 포함하는 경우, 목록에 저장
	 * @param sourceList
	 * @param targetList
	 * @return
	 * @throws Exception
	 */
	public static <T> List<T> getDupIdList(
			List<T> sourceList,
			List<T> targetList) throws Exception{
		List<T> resultList = new ArrayList<T>();
		for(int i = 0; i < sourceList.size(); i++){
			if(targetList.contains(sourceList.get(i))){
				resultList.add(sourceList.get(i));
			}
		}
		return resultList;
	}
	
	public static boolean containsIgnoreCase(List<String> sourceList, String target){
		int sourceListSize = getLengthIfNull(sourceList);
		for(int i = 0; i < sourceListSize; i++){
			if(StringUtils.equalsIgnoreCase(sourceList.get(i), target)){
				return true;
			}
		}
		return false;
	}
	
	public static <T> int getLengthIfNull(List<T> objArr){
		if(objArr != null){
			return objArr.size();
		}else{
			return 0;
		}
	}
	
	public static <T> int getLengthIfNull(Set<T> objArr){
		if(objArr != null){
			return objArr.size();
		}else{
			return 0;
		}
	}
	
	public static <T> List<T> setToList(Set<T> set){
		if(getLengthIfNull(set) > 0){
			List<T>list = new ArrayList<T>();
			Iterator<T> it = set.iterator();
			while(it.hasNext()){
				list.add(it.next());
			}
			return list;
		}
		return null;
	}
	
	public static <T> Set<T> listToSet(List<T> list){
		if(getLengthIfNull(list) > 0){
			Set<T>set = new HashSet<T>();
			Iterator<T> it = list.iterator();
			while(it.hasNext()){
				set.add(it.next());
			}
			return set;
		}
		return null;
	}
	
	/**
	 * 부모맵내의 리스트가 들어있고, 그 리스트에 자식맵이 들어있는 경우,
	 * 부모맵내의 특정 키의 값으로 리스트가 있으면 해당 리스트를 반환하고,
	 * 없으면 자식맵을 포함하는 타입의 어레이리스트를 생성하여 반환한다.
	 * @param parentMap
	 * @param key
	 * @return
	 */
	public static <PT1, T1, T2> List<Map<T1,T2>> getListInMapIfNull(Map<PT1, List<Map<T1, T2>>> parentMap, String key) {
		return parentMap.get(key) == null ? new ArrayList<Map<T1, T2>>() : parentMap.get(key);
	}
}
