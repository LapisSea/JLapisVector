package com.lapissea.vec.color;

import com.lapissea.util.MathUtil;
import com.lapissea.util.NotNull;
import com.lapissea.util.Rand;

import java.awt.Color;
import java.nio.ByteBuffer;

public interface IColorM extends IColorMSolid{
	
	IColorMSolid BLACK      = ColorMFinal.convert(Color.BLACK);
	IColorMSolid BLUE       = ColorMFinal.convert(Color.BLUE);
	IColorMSolid CYAN       = ColorMFinal.convert(Color.CYAN);
	IColorMSolid DARK_GRAY  = ColorMFinal.convert(Color.DARK_GRAY);
	IColorMSolid GRAY       = ColorMFinal.convert(Color.GRAY);
	IColorMSolid GREEN      = ColorMFinal.convert(Color.GREEN);
	IColorMSolid LIGHT_GRAY = ColorMFinal.convert(Color.LIGHT_GRAY);
	IColorMSolid MAGENTA    = ColorMFinal.convert(Color.MAGENTA);
	IColorMSolid ORANGE     = ColorMFinal.convert(Color.ORANGE);
	IColorMSolid PINK       = ColorMFinal.convert(Color.PINK);
	IColorMSolid RED        = ColorMFinal.convert(Color.RED);
	IColorMSolid WHITE      = ColorMFinal.convert(Color.WHITE);
	IColorMSolid YELLOW     = ColorMFinal.convert(Color.YELLOW);
	IColorMSolid ZERO       = ColorMFinal.convert(Color.YELLOW);
	
	float a();
	
	default int aInt(){
		return (int)(a()*255 + 0.5F);
	}
	
	@NotNull
	static ColorM randomRGBA(){
		return randomRGBA(new ColorM());
	}
	
	@NotNull
	static <T extends ColorM> T randomRGBA(@NotNull T target){
		target.r(Rand.f());
		target.g(Rand.f());
		target.b(Rand.f());
		target.a(Rand.f());
		return target;
	}
	
	@NotNull
	default <T extends ColorM> T mix(@NotNull T target){
		return mix(target, 1, 1);
	}
	
	@NotNull
	static <T extends ColorM> T mix(@NotNull T target, @NotNull IColorM color){
		return mix(target, color, 1, 1);
	}
	
	@NotNull
	default <T extends ColorM> T mix(@NotNull T target, float scale1, float scale2){
		return mix(target, this, scale1, scale2);
	}
	
	@NotNull
	static <T extends ColorM> T mix(@NotNull T target, @NotNull IColorM color, float scale1, float scale2){
		target.r((target.r()*scale1 + color.r()*scale2)/(scale1 + scale2));
		target.g((target.g()*scale1 + color.g()*scale2)/(scale1 + scale2));
		target.b((target.b()*scale1 + color.b()*scale2)/(scale1 + scale2));
		target.a((target.a()*scale1 + color.a()*scale2)/(scale1 + scale2));
		return target;
	}
	
	
	default float brightness(){
		return MathUtil.max(r(), g(), b());
	}
	
	default void putRGBA(@NotNull ByteBuffer dest){
		putRGB(dest);
		dest.putFloat(a());
	}
}
