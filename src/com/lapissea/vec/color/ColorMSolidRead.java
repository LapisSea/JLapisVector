package com.lapissea.vec.color;

import com.lapissea.util.MathUtil;
import com.lapissea.util.NotNull;

import java.awt.*;

public class ColorMSolidRead implements IColorMSolid{
	
	protected float r, g, b;
	
	public ColorMSolidRead(@NotNull IColorM color){
		this(color.r(), color.g(), color.b());
	}
	
	public ColorMSolidRead(){
		r=g=b=1;
	}
	
	public ColorMSolidRead(double r, double g, double b){
		this((float)r, (float)g, (float)b);
	}
	
	public ColorMSolidRead(@NotNull Color color){
		this(color.getRed()/256F, color.getGreen()/256F, color.getBlue()/256F);
	}
	
	public ColorMSolidRead(float r, float g, float b){
		this.r=MathUtil.snap(r, 0, 1);
		this.g=MathUtil.snap(g, 0, 1);
		this.b=MathUtil.snap(b, 0, 1);
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
	
	@NotNull
	@Override
	public String toString(){
		return "{r="+r()+", g="+g()+", b="+b()+"}";
	}
	
	@Override
	public int hashCode(){
		return ((int)(r*255+0.5)&0xFF)<<16|((int)(g*255+0.5)&0xFF)<<8|((int)(b*255+0.5)&0xFF);
	}
	
	@Override
	public boolean equals(Object obj){
		return obj instanceof IColorM&&equals((IColorM)obj);
	}
	
	public boolean equals(@NotNull IColorM obj){
		return (obj.r()==r()||obj.rInt()==rInt())&&(obj.g()==g()||obj.gInt()==gInt())&&(obj.b()==b()||obj.bInt()==bInt());
	}
	
}
