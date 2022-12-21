package com.lapissea.vec.color;

import com.lapissea.util.NotNull;
import com.lapissea.util.Rand;

import java.nio.ByteBuffer;

public interface IColorMSolid{
	float r();
	
	float g();
	
	float b();
	
	default int rInt(){
		return (int)(r()*255 + 0.5F);
	}
	
	default int gInt(){
		return (int)(g()*255 + 0.5F);
	}
	
	default int bInt(){
		return (int)(b()*255 + 0.5F);
	}
	
	@NotNull
	static ColorMSolid randomRGB(){
		return randomRGB(new ColorMSolid());
	}
	
	@NotNull
	static <T extends ColorMSolid> T randomRGB(@NotNull T target){
		target.r(Rand.f());
		target.g(Rand.f());
		target.b(Rand.f());
		return target;
	}
	
	default void putRGB(@NotNull ByteBuffer dest){
		dest.putFloat(r());
		dest.putFloat(g());
		dest.putFloat(b());
	}
}
