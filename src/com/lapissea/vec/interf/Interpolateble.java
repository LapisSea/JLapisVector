package com.lapissea.vec.interf;

public interface Interpolateble<T extends Interpolateble<T>>{
	
	T interpolate(T second, float percent);
	
	T interpolate(T first, T second, float percent);
}
