package com.lapissea.vec.interf;

import com.lapissea.util.NotNull;
import com.lapissea.vec.Vec2iFinal;

/**
 * I Vec 2i R
 * Interface Vector 2 ints readable
 */
public interface IVec2iR{
	
	int x();
	
	int y();
	
	default double length(){
		return Math.sqrt(x()*x()+y()*y());
	}
	
	default double distanceTo(@NotNull IVec2iR pos){
		int x=x()-pos.x(), y=y()-pos.y();
		return Math.sqrt(x*x+y*y);
	}
	
	default float divXY(){
		return x()/(float)y();
	}
	
	default Vec2iFinal immutable(){
		return new Vec2iFinal(this);
	}
	
	
	default boolean isZero(){
		return x()==0&&y()==0;
	}
}
