package com.lapissea.vec.color;

import com.lapissea.util.MathUtil;
import com.lapissea.util.NotNull;

import java.awt.Color;

public final class ColorMFinal implements IColorM{
	
	private final float r, g, b, a;
	private final int rInt, gInt, bInt, aInt, hash;
	
	public ColorMFinal(){
		this(1, 1, 1);
	}
	
	public ColorMFinal(@NotNull Color color){
		this(color.getRed()/255F, color.getGreen()/255F, color.getBlue()/255F, color.getAlpha()/255F);
	}
	
	public ColorMFinal(@NotNull IColorM color){
		this(color.r(), color.g(), color.b(), color.a());
	}
	
	public ColorMFinal(float r, float g, float b){
		this(r, g, b, 1);
	}
	
	public ColorMFinal(float r, float g, float b, float a){
		this.r = MathUtil.snap(r, 0, 1);
		this.g = MathUtil.snap(g, 0, 1);
		this.b = MathUtil.snap(b, 0, 1);
		this.a = MathUtil.snap(a, 0, 1);
		rInt = (int)(r*255 + 0.5F);
		gInt = (int)(g*255 + 0.5F);
		bInt = (int)(b*255 + 0.5F);
		aInt = (int)(a*255 + 0.5F);
		
		hash = (aInt&0xFF)<<24|(rInt&0xFF)<<16|(gInt&0xFF)<<8|(bInt&0xFF)<<0;
	}
	
	@Override
	public float r(){
		return r;
	}
	
	@Override
	public float g(){
		return g;
	}
	
	@Override
	public float b(){
		return b;
	}
	
	@Override
	public float a(){
		return a;
	}
	
	@Override
	public int rInt(){
		return rInt;
	}
	
	@Override
	public int gInt(){
		return gInt;
	}
	
	@Override
	public int bInt(){
		return bInt;
	}
	
	@Override
	public int aInt(){
		return aInt;
	}
	
	public static ColorMFinal convert(@NotNull Color color){
		return new ColorMFinal(color);
	}
	
	@Override
	public String toString(){
		return "(r=" + r() + ", g=" + g() + ", b=" + b() + ", a=" + a() + ")";
	}
	
	@Override
	public int hashCode(){
		return hash;
	}
	
	@Override
	public boolean equals(Object obj){
		return obj instanceof IColorM && equals((IColorM)obj);
	}
	
	public boolean equals(@NotNull IColorM obj){
		return (obj.r() == r() || obj.rInt() == rInt()) && (obj.g() == g() || obj.gInt() == gInt()) && (obj.b() == b() || obj.bInt() == bInt()) && (obj.a() == a() || obj.aInt() == aInt());
	}
	
}
