package com.like.core.web.util;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.like.core.web.response.ResponseObject;
import com.like.core.web.response.ResponseObjectList;
import com.like.core.web.response.ResponseObjectMap;

public abstract class ResponseEntityUtil {		
			
	/**
	 * ResponseEntity 객체를 반환한다.
	 * @param data			결과 payload 데이터
	 * @param size			data의 사이즈
	 * @param success		성공 여부
	 * @param message		결과 메세지
	 * @param httpStatus	Http 응답 코드
	 * @return Rest 요청 결과 
	 */
	public static ResponseEntity<ResponseObjectList> toList(List<?> data, int size, String message, HttpStatus httpStatus) {
									
		ResponseObjectList obj = new ResponseObjectList(data, size, message);			      
	    
	    return new ResponseEntity<ResponseObjectList>(obj, getResponseHeaders(), httpStatus);	    	    	    	    	
	}
	
	public static ResponseEntity<ResponseObjectList> toList(List<?> data, String message, HttpStatus httpStatus) {
		
		ResponseObjectList obj = new ResponseObjectList(data, data == null ? 0 : data.size(), message);			      
	    
	    return new ResponseEntity<ResponseObjectList>(obj, getResponseHeaders(), httpStatus);	    	    	    	    	
	}
	
	public static ResponseEntity<ResponseObjectList> toList(List<?> data, String message) {
		
		ResponseObjectList obj = new ResponseObjectList(data, data == null ? 0 : data.size(), message);			      
	    
	    return new ResponseEntity<ResponseObjectList>(obj, getResponseHeaders(), HttpStatus.OK);	    	    	    	    	
	}
	
	/**
	 * ResponseEntity 객체를 반환한다.
	 * @param data			결과 payload 데이터
	 * @param size			data의 사이즈
	 * @param success		성공 여부
	 * @param message		결과 메세지
	 * @param httpStatus	Http 응답 코드
	 * @return Rest 요청 결과 
	 */	
	public static <T> ResponseEntity<ResponseObject<T>> toOne(T data, int size, String message, HttpStatus httpStatus) {
		
		ResponseObject<T> obj = new ResponseObject<T>(data, size, message);		
					    	    
	    return new ResponseEntity<ResponseObject<T>>(obj, getResponseHeaders(), httpStatus);	    	    	    	    	
	}
		
	public static<T> ResponseEntity<ResponseObject<T>> toOne(T data, String message, HttpStatus httpStatus) {
		ResponseObject<T> obj = new ResponseObject<T>(data, data == null ? 0 : 1, message);
		
		return new ResponseEntity<ResponseObject<T>>(obj, getResponseHeaders(), httpStatus);
	}
	
	public static<T> ResponseEntity<ResponseObject<T>> toOne(T data, String message) {
		ResponseObject<T> obj = new ResponseObject<T>(data, data == null ? 0 : 1, message);
		
		return new ResponseEntity<ResponseObject<T>>(obj, getResponseHeaders(), HttpStatus.OK);
	}
	
	public static <K, V> ResponseEntity<ResponseObjectMap<K, V>> toMap(Map<K, V> data, int size, String message, HttpStatus httpStatus) {
		
		ResponseObjectMap<K, V> obj = new ResponseObjectMap<K, V>(data, size, message);		
					    	    
	    return new ResponseEntity<ResponseObjectMap<K, V>>(obj, getResponseHeaders(), httpStatus);	    	    	    	    	
	}
		
	public static<K, V> ResponseEntity<ResponseObjectMap<K, V>> toMap(Map<K, V> data, String message, HttpStatus httpStatus) {
		ResponseObjectMap<K, V> obj = new ResponseObjectMap<K, V>(data, data == null ? 0 : 1, message);
		
		return new ResponseEntity<ResponseObjectMap<K, V>>(obj, getResponseHeaders(), httpStatus);
	}
	
	public static<K, V> ResponseEntity<ResponseObjectMap<K, V>> toMap(Map<K, V> data, String message) {
		ResponseObjectMap<K, V> obj = new ResponseObjectMap<K, V>(data, data == null ? 0 : 1, message);
		
		return new ResponseEntity<ResponseObjectMap<K, V>>(obj, getResponseHeaders(), HttpStatus.OK);
	}
	
	private static HttpHeaders getResponseHeaders() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		return responseHeaders;		
	}		 
	
}
