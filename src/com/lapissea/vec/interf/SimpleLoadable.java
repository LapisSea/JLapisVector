package com.lapissea.vec.interf;

import com.lapissea.util.NotNull;
import gnu.trove.list.TFloatList;

@SuppressWarnings("unchecked")
public interface SimpleLoadable<T>{
	
	int getValueCount();
	
	void loadValue(int id, float value);
	
	void loadValue(char c, float value);
	
	default T load(float[] data){
		return load(0, data);
	}
	
	T load(int offset, float[] data);
	
	T load(int offset, TFloatList data);
	
	default T load(@NotNull String string){
		return load(string, 0);
	}
	
	default T load(@NotNull String string, int start){
		return load(string, start, string.length());
	}
	
	default T load(@NotNull String string, int start, int end){
		if(end>string.length()) throw new IllegalArgumentException("End " + end + " can not be larger than total length of " + string.length());
		if(start<0) throw new IllegalArgumentException("Start has to be positive!");
		if(start>=end) throw new IllegalArgumentException("Start has to be smaller than end!");
		
		boolean       begin   = true, lastSpace = false;
		StringBuilder buff    = new StringBuilder();
		int           valueId = 0;
		for(int i = start; i<end; i++){
			char    c     = string.charAt(i);
			boolean space = c == ',' || Character.isWhitespace(c);
			if(begin){
				if(space) continue;
				else begin = false;
			}
			if(lastSpace && space) continue;
			
			if(lastSpace = space){
				int pos = buff.indexOf("=");
				if(pos == -1) loadValue(valueId, Float.parseFloat(buff.toString()));
				else loadValue(buff.charAt(0), Float.parseFloat(buff.substring(pos + 1).trim()));
				
				valueId = (valueId + 1)%getValueCount();
				buff.setLength(0);
			}else buff.append(c);
			
		}
		if(buff.length()>0){
			int pos = buff.indexOf("=");
			if(pos == -1) loadValue(valueId, Float.parseFloat(buff.toString()));
			else loadValue(buff.charAt(0), Float.parseFloat(buff.substring(pos + 1).trim()));
		}
		
		return (T)this;
	}
}
