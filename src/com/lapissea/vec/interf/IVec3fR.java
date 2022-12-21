package com.lapissea.vec.interf;

import com.lapissea.util.NotNull;
import gnu.trove.list.TFloatList;

import java.nio.ByteBuffer;

public interface IVec3fR{
	float x();
	
	float y();
	
	float z();
	
	
	default float max(){
		return Math.max(x(), Math.max(y(), z()));
	}
	
	default float min(){
		return Math.min(x(), Math.min(y(), z()));
	}
	
	default double length(){
		return Math.sqrt(lengthSquared());
	}
	
	default double distanceTo(@NotNull IVec3fR vec){
		float x = x() - vec.x();
		float y = y() - vec.y();
		float z = z() - vec.z();
		return Math.sqrt(x*x + y*y + z*z);
	}
	
	default float lengthSquared(){
		return x()*x() + y()*y() + z()*z();
	}
	
	
	default void put(@NotNull TFloatList dest){
		dest.add(x());
		dest.add(y());
		dest.add(z());
	}
	
	default void put(@NotNull ByteBuffer dest){
		dest.putFloat(x());
		dest.putFloat(y());
		dest.putFloat(z());
	}
}
