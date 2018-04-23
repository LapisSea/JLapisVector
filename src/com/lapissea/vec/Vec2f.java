package com.lapissea.vec;

import com.lapissea.util.NotNull;
import com.lapissea.vec.interf.Calculateable;
import com.lapissea.vec.interf.IVec2iR;
import com.lapissea.vec.interf.SimpleLoadable;
import gnu.trove.list.TFloatList;

import static com.lapissea.util.ObjectSize.*;

public class Vec2f implements Calculateable<Vec2f>, SimpleLoadable<Vec2f>{
	
	public static final int SIZE=sizeof(Vec2f.class);
	
	public static final Vec2f ZERO=new Vec2f(){
		
		@Override
		public float x(){
			return 0;
		}
		
		@Override
		public float y(){
			return 0;
		}
	};
	
	private float x, y;
	
	public Vec2f(){
		this(0, 0);
	}
	
	public Vec2f(@NotNull IVec2iR vec){
		this(vec.x(), vec.y());
	}
	
	public Vec2f(float x){
		this(x, 0);
	}
	
	public Vec2f(float x, float y){
		set(x, y);
	}
	
	public Vec2f(@NotNull String string){
		load(string);
	}
	
	public Vec2f(@NotNull String string, int start){
		load(string, start);
	}
	
	public Vec2f(float[] data){
		load(0, data);
	}
	
	public Vec2f(float[] data, int start){
		load(start, data);
	}
	
	@NotNull
	public Vec2f set(float x, float y){
		x(x);
		y(y);
		return this;
	}
	
	public float x(){
		return x;
	}
	
	@NotNull
	public Vec2f x(float x){
		this.x=x;
		return this;
	}
	
	public float y(){
		return y;
	}
	
	@NotNull
	public Vec2f y(float y){
		this.y=y;
		return this;
	}
	
	@NotNull
	public Vec2f add(float x, float y){
		x(x()+x);
		y(y()+y);
		return this;
	}
	
	@NotNull
	@Override
	public Vec2f add(@NotNull Vec2f c){
		return add(c.x(), c.y());
	}
	
	@NotNull
	@Override
	public Vec2f sub(@NotNull Vec2f c){
		x(x()-c.x());
		y(y()-c.y());
		return this;
	}
	
	@NotNull
	public Vec2f sub(float x, float y){
		x(x()-x);
		y(y()-y);
		return this;
	}
	
	@NotNull
	public Vec2f sub(@NotNull IVec2iR vec){
		x(x()-vec.x());
		y(y()-vec.y());
		return this;
	}
	
	@NotNull
	public Vec2f sub(float xy){
		x(x()-xy);
		y(y()-xy);
		return this;
	}
	
	@NotNull
	@Override
	public Vec2f subRev(@NotNull Vec2f c){
		x(c.x()-x());
		y(c.y()-y());
		return this;
	}
	
	@NotNull
	@Override
	public Vec2f mul(@NotNull Vec2f c){
		x(x()*c.x());
		y(y()*c.y());
		return this;
	}
	
	@NotNull
	@Override
	public Vec2f div(@NotNull Vec2f c){
		x(x()/c.x());
		y(y()/c.y());
		return this;
	}
	
	@NotNull
	public Vec2f div(@NotNull IVec2iR c){
		x(x()/c.x());
		y(y()/c.y());
		return this;
	}
	
	@NotNull
	public Vec2f div(float xy){
		x(x()/xy);
		y(y()/xy);
		return this;
	}
	@NotNull
	public Vec2f div(float x, float y){
		x(x()/x);
		y(y()/y);
		return this;
	}
	
	@NotNull
	@Override
	public Vec2f abs(){
		x(Math.abs(x()));
		y(Math.abs(y()));
		return this;
	}
	
	@NotNull
	@Override
	public Vec2f sqrt(){
		x((float)Math.sqrt(x()));
		y((float)Math.sqrt(y()));
		return this;
	}
	
	@NotNull
	@Override
	public Vec2f sq(){
		x(x()*x());
		y(y()*y());
		return this;
	}
	
	@NotNull
	@Override
	public Vec2f clone(){
		return new Vec2f(x(), y());
	}
	
	@NotNull
	@Override
	public Vec2f mul(float f){
		x(x()*f);
		y(y()*f);
		return this;
	}
	
	@NotNull
	@Override
	public Vec2f set(@NotNull Vec2f src){
		x(src.x());
		y(src.y());
		return this;
	}
	
	@NotNull
	@Override
	public String toString(){
		return "Vec2f{x="+x()+", y="+y()+"}";
	}
	
	@NotNull
	public Vec2f set(@NotNull IVec2iR src){
		x(src.x());
		y(src.y());
		return this;
	}
	
	public float divXy(){
		return x()/y();
	}
	
	public float divYx(){
		return y()/x();
	}
	
	@Override
	public int getValueCount(){
		return 2;
	}
	
	@Override
	public void loadValue(int id, float value){
		// @formatter:off
		switch(id){
		case 0:x(value);break;
		case 1:y(value);break;
		}
		// @formatter:on
	}
	
	@Override
	public void loadValue(char c, float value){
		// @formatter:off
		switch(c){
		case 'x':x(value);break;
		case 'y':y(value);break;
		}
		// @formatter:on
	}
	
	@NotNull
	@Override
	public Vec2f load(int offset, float[] data){
		set(data[offset], data[offset+1]);
		return this;
	}
	
	@NotNull
	@Override
	public Vec2f load(int offset, @NotNull TFloatList data){
		return set(data.get(offset), data.get(offset+1));
	}
	
	public double length(){
		return Math.sqrt(x()*x()+y()*y());
	}
	
	public double distanceTo(@NotNull IVec2iR pos){
		float x=x()-pos.x(), y=y()-pos.y();
		return Math.sqrt(x*x+y*y);
	}
	
	@NotNull
	public Vec2f flipXY(){
		return set(y(), x());
	}
}
