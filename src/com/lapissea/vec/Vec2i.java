package com.lapissea.vec;

import com.lapissea.util.NotNull;
import com.lapissea.vec.interf.Calculateable;
import com.lapissea.vec.interf.IVec2iR;
import com.lapissea.vec.interf.IVec2iW;

import java.awt.*;
import java.io.Serializable;
import java.util.function.BiConsumer;

public class Vec2i implements Calculateable<Vec2i>, Serializable, IVec2iR, IVec2iW{
	
	private static final long serialVersionUID=7737581116406153679L;
	
	private int x;
	private int y;
	
	public Vec2i(@NotNull IVec2iR vec2){
		this(vec2.x(), vec2.y());
	}
	
	public Vec2i(@NotNull Point point){
		this(point.x, point.y);
	}
	
	public Vec2i(@NotNull Dimension dimension){
		this(dimension.width, dimension.height);
	}
	
	public Vec2i(){
	}
	
	public Vec2i(int x){
		this(x, 0);
	}
	
	public Vec2i(int x, int y){
		set(x, y);
	}
	
	public Vec2i set(int x, int y){
		this.x=x;
		this.y=y;
		return this;
	}
	
	@Override
	public Vec2i x(int x){
		this.x=x;
		return this;
	}
	
	@Override
	public Vec2i y(int y){
		this.y=y;
		return this;
	}
	
	public Vec2i set(@NotNull Dimension dimension){
		return set(dimension.width, dimension.height);
	}
	
	public Vec2i set(@NotNull Point point){
		return set(point.x, point.y);
	}
	
	@Override
	public int x(){
		return x;
	}
	
	
	@Override
	public int y(){
		return y;
	}
	
	
	@NotNull
	@Override
	public Vec2i add(@NotNull Vec2i c){
		set(x()+c.x(), y()+c.y());
		return this;
	}
	
	@NotNull
	@Override
	public Vec2i sub(@NotNull Vec2i c){
		set(x()-c.x(), y()-c.y());
		return this;
	}
	
	@NotNull
	@Override
	public Vec2i subRev(@NotNull Vec2i c){
		set(c.x()-x(), c.y()-y());
		return this;
	}
	
	@NotNull
	@Override
	public Vec2i mul(@NotNull Vec2i c){
		set(x()*c.x(), y()*c.y());
		return this;
	}
	
	@NotNull
	@Override
	public Vec2i div(@NotNull Vec2i c){
		set(x()/c.x(), y()/c.y());
		return this;
	}
	
	@NotNull
	public Vec2i div(int xy){
		set(x()/xy, y()/xy);
		return this;
	}
	
	@NotNull
	@Override
	public Vec2i abs(){
		set(Math.abs(x()), Math.abs(y()));
		return this;
	}
	
	@NotNull
	@Override
	public Vec2i sqrt(){
		set((int)Math.sqrt(x()), (int)Math.sqrt(y()));
		return this;
	}
	
	@NotNull
	@Override
	public Vec2i sq(){
		set(x()*x(), y()*y());
		return this;
	}
	
	public void putXY(@NotNull BiConsumer<String, Integer> put){
		put.accept("x", x());
		put.accept("y", y());
	}
	
	public void putWH(@NotNull BiConsumer<String, Integer> put){
		put.accept("w", x());
		put.accept("h", y());
	}
	
	@NotNull
	@Override
	public String toString(){
		return "Vec2i{x="+x()+", y="+y()+"}";
	}
	
	@NotNull
	@Override
	public Vec2i clone(){
		return new Vec2i(x(), y());
	}
	
	@Override
	public Vec2i mul(float f){
		return set((int)(x()*f), (int)(y()*f));
	}
	
	@Override
	public Vec2i set(@NotNull Vec2i src){
		return set(src.x(), src.y());
	}
	
	public Vec2i set(@NotNull IVec2iR src){
		return set(src.x(), src.y());
	}
	
	@Override
	public double length(){
		return Math.sqrt(x()*x()+y()*y());
	}
	
	@Override
	public double distanceTo(@NotNull IVec2iR pos){
		int x=x()-pos.x(), y=y()-pos.y();
		return Math.sqrt(x*x+y*y);
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof IVec2iR)) return false;
		IVec2iR other=(IVec2iR)obj;
		return x()==other.x()&&y()==other.y();
	}
	
	@Override
	public int hashCode(){
		return (x()<<16)+y();
	}
	
	public void clampX(int min, int max){
		if(x()<min) x(min);
		else if(x()>max) x(max);
	}
	
	@NotNull
	@Override
	public Vec2iFinal immutable(){
		return new Vec2iFinal(this);
	}
}
