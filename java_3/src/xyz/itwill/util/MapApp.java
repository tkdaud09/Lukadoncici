package xyz.itwill.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//Map 인터페이스를 상속받은 콜렉션 클래스 - HashMap, Hashtable, ★Properties★ 등
// => 이름(Key)과 객체(Value)를 하나의 그룹으로 묵어 Map 객체에 저장하여 관리
// => 엔트리(Entry) : Map 객체에 이름과 객체를 하나로 묶어 저장하기 위한 단위
// => 이름(Key)을 이용하여 객체(Map)를 빠르게 검색하여 제공하기 위한 콜렉션 클래스
// => 
public class MapApp {
	public static void main(String[] args) {
		//이름과 저장 객체에 대한 제네릭 타입 2개에 자료형 전달하여 객체 생성
		Map<String, String> map=new HashMap<String, String>();
		
		//Map.put(K Key, V value) : Map 객체에 엔트리를 추가하는 메소드
		// => Map 객체에 저장되는 엔트리는 이름(Key)을 Set 객체로 저장되므로 중복 저장 불가능
		// => 이름(Key)은 중복 저장 불가능
		map.put("1000", "홍길동");
		map.put("2000", "임꺽정");
		map.put("3000", "전우치");
		map.put("4000", "일지매");
		map.put("5000", "장길산");
		
		//Map.toString() : Map 객체에 저장된 모든 엔트리를 문자열로 변환하여 반환하는 메소드
		//System.out.println("map.toString() ="+map.toString());
		System.out.println("map = "+map);
		System.out.println("==============================================================");
		//Map.put(K Key, V value) 메소드 호출시 이름(Key)이 중복된 경우 해당 이름의 엔트리의
		//객체(Value)를 변경하여 저장
		map.put("2000", "임꺽정");
		System.out.println("map = "+map);
		System.out.println("==============================================================");
		//Map.remove(K Key) : Map 객체에 저장된 엔트리에서 매개변수로 전달받은 이름(Key)에
		//대한 엔트리를 검색하여 삭제하는 메소드
		map.remove("4000");
		System.out.println("map = "+map);
		System.out.println("==============================================================");
		//Map.get(K Key) : Map 객체에 저장된 엔트리에서 매개변수로 전달받은 이름(Key)에
		//대한 엔트리를 검색하여 엔트리의 객체를 반환하는 메소드
		// => 이름(Key)에 대한 엔트리가 없는 경우 null 반환
		String name=map.get("6000");
		System.out.println("name = "+name);
		System.out.println("==============================================================");
		//★map은 일괄처리가 목표xx★
		//Map.KeySet() : Map 객체에 저장된 모든 엔트리의 이름(Key)을 Set 객체로 반환하는 메소드
		Iterator<String> iteratorkey=map.keySet().iterator();
		
		while(iteratorkey.hasNext()) {
			String key = iteratorkey.next();
			String value = map.get(key);
			System.out.println(key+" = "+value);
		}
		System.out.println("==============================================================");
		for(String key : map.keySet()) {
			System.out.println(key+" = "+map.get(key));
		}
		System.out.println("==============================================================");
		//Map.values() : Map 객체에 저장된 모든 엔트리의 객체(Value)를 Collection 객체
		//(List 객체)로 반환하는 메소드
		Iterator<String> iteratorValue=map.values().iterator();
		
		while(iteratorValue.hasNext()) {
			String value = iteratorValue.next();
			System.out.println(value);
		}
		System.out.println("==============================================================");
		for(String value : map.values()) {
			System.out.println(value);
		}
	}
}	