package com.lapissea.vec.color;

import com.lapissea.util.MathUtil;
import com.lapissea.util.NotNull;

import java.awt.*;

public class ColorMRead implements IColorM{
	
	protected float r, g, b, a;
	
	public ColorMRead(@NotNull IColorM color){
		this(color.r(), color.g(), color.b(), color.a());
	}
	
	public ColorMRead(){
		r=g=b=a=1;
	}
	
	public ColorMRead(double r, double g, double b){
		this((float)r, (float)g, (float)b);
	}
	
	public ColorMRead(@NotNull Color color){
		this(color.getRed()/256F, color.getGreen()/256F, color.getBlue()/256F, color.getAlpha()/256F);
	}
	
	public ColorMRead(double r, double g, double b, double a){
		this((float)r, (float)g, (float)b, (float)a);
	}
	
	public ColorMRead(float r, float g, float b){
		this.r=MathUtil.snap(r, 0, 1);
		this.g=MathUtil.snap(g, 0, 1);
		this.b=MathUtil.snap(b, 0, 1);
		a=1;
	}
	
	public ColorMRead(float r, float g, float b, float a){
		this.r=MathUtil.snap(r, 0, 1);
		this.g=MathUtil.snap(g, 0, 1);
		this.b=MathUtil.snap(b, 0, 1);
//		System.out.println(a+"\t"+MathUtil.snap(a, 0, 1));
		this.a=MathUtil.snap(a, 0, 1);
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
	
	@NotNull
	@Override
	public String toString(){
		return "(r="+r()+", g="+g()+", b="+b()+", a="+a()+")";
	}
	
	@Override
	public int hashCode(){
		return ((int)(a*255+0.5)&0xFF)<<24|((int)(r*255+0.5)&0xFF)<<16|((int)(g*255+0.5)&0xFF)<<8|((int)(b*255+0.5)&0xFF);
	}
	
	@Override
	public boolean equals(Object obj){
		return obj instanceof IColorM&&equals((IColorM)obj);
	}
	
	public boolean equals(@NotNull IColorM obj){
		return (obj.r()==r()||obj.rInt()==rInt())&&(obj.g()==g()||obj.gInt()==gInt())&&(obj.b()==b()||obj.bInt()==bInt())&&(obj.a()==a()||obj.aInt()==aInt());
	}
	
}
