package com.ks.keshuoservice.utils.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

/**
 * 说明：参数封装Map
 * 创建人：renzhiq
 * 修改时间：2014年9月20日
 * @version
 */
@SuppressWarnings("rawtypes")
public class PageData extends HashMap {

    private static final long serialVersionUID = 1L;

    Map map = null;
    HttpServletRequest request;
    List<PageData> list = new ArrayList<PageData>();
    

    @SuppressWarnings("unchecked")
	public PageData(HttpServletRequest request) {
        this.request = request;
        Map properties = request.getParameterMap();
        Map returnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            } else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            } else {
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        map = returnMap;
    }

    @SuppressWarnings("unchecked")
	public PageData(HttpServletRequest request , int k) {
    	 this.request = request;
         Map properties = request.getParameterMap();
         
         Map returnMap = new HashMap();
         Iterator entries = properties.entrySet().iterator();
         Entry entry;
         String name = "";
         String value = "";
         while (entries.hasNext()) {
             entry = (Entry) entries.next();
             name = (String) entry.getKey();
             Object valueObj = entry.getValue();
             if (null == valueObj) {
                 value = "";
             } else if (valueObj instanceof String[]) {
                 String[] values = (String[]) valueObj;
                 for (int i = 0; i < values.length; i++) {
                     value = values[i] + ",";
                 }
                 value = value.substring(0, value.length() - 1);
             } else {
                 value = valueObj.toString();
             }
             
             returnMap.put(name, value);
         }

         
    }
    
    public PageData() {
        map = new HashMap();
    }

    @Override
    public Object get(Object key) {
        Object obj = null;
        if (map.get(key) instanceof Object[]) {
            Object[] arr = (Object[]) map.get(key);
            obj = request == null ? arr : (request.getParameter((String) key) == null ? arr : arr[0]);
        } else {
            obj = map.get(key);
        }
        return obj;
    }

    public String getString(Object key) {
    	Object obj  = get(key);
    	if(obj==null) return null;
    	
        return (String) obj;
    }

    public int getInt(Object key) {
        return Integer.parseInt(  get(key).toString());
    }
    
    public Long getLong(Object key) {
    	return Long.parseLong(get(key).toString());
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public Object put(Object key, Object value) {
        return map.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return map.remove(key);
    }

    public void clear() {
        map.clear();
    }

    public boolean containsKey(Object key) {
        // TODO Auto-generated method stub
        return map.containsKey(key);
    }

    public boolean containsValue(Object value) {
        // TODO Auto-generated method stub
        return map.containsValue(value);
    }

    public Set entrySet() {
        // TODO Auto-generated method stub
        return map.entrySet();
    }

    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return map.isEmpty();
    }

    public Set keySet() {
        // TODO Auto-generated method stub
        return map.keySet();
    }

    @SuppressWarnings("unchecked")
    public void putAll(Map t) {
        // TODO Auto-generated method stub
        map.putAll(t);
    }

    public int size() {
        // TODO Auto-generated method stub
        return map.size();
    }

    public Collection values() {
        // TODO Auto-generated method stub
        return map.values();
    }

	public List<PageData> getList() {
		return list;
	}

	public void setList(List<PageData> list) {
		this.list = list;
	}


}
