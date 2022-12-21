package com.lapissea.vec;

import com.lapissea.util.NotNull;
import com.lapissea.vec.interf.IVec2iR;

import java.awt.Dimension;
import java.awt.Point;
import java.io.Serializable;
import java.util.function.BiConsumer;

public class Vec2iFinal implements Serializable, IVec2iR{
	
	private static final long serialVersionUID = 7737581116406153679L;
	
	private final int x;
	private final int y;
	
	public Vec2iFinal(@NotNull IVec2iR vec2){
		this(vec2.x(), vec2.y());
	}
	
	public Vec2iFinal(@NotNull Point point){
		this(point.x, point.y);
	}
	
	public Vec2iFinal(@NotNull Dimension dimension){
		this(dimension.width, dimension.height);
	}
	
	public Vec2iFinal(){
		this(0, 0);
	}
	
	public Vec2iFinal(int x){
		this(x, 0);
	}
	
	public Vec2iFinal(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int x(){
		return x;
	}
	
	@Override
	public int y(){
		return y;
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
		return "Vec2iF{x=" + x() + ", y=" + y() + "}";
	}
	
	@NotNull
	@Override
	public Vec2iFinal clone(){
		return new Vec2iFinal(x(), y());
	}
	
	@NotNull
	public static Vec2iFinal immutable(IVec2iR pos){
		if(pos instanceof Vec2iFinal) return (Vec2iFinal)pos;
		return new Vec2iFinal(pos);
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof IVec2iR)) return false;
		IVec2iR other = (IVec2iR)obj;
		return x() == other.x() && y() == other.y();
	}
	
	@Override
	public int hashCode(){
		return (x()<<16) + y();
	}
	
	@NotNull
	@Override
	public Vec2iFinal immutable(){
		return this;
	}
}
