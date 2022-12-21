package com.lapissea.vec.interf;


public interface IRotation{
	
	float x();
	
	float y();
	
	float z();
	
	float w();
	
	default <T extends IVec3fR & IVec3fW> T rotate(T srcDest){
		return rotate(srcDest, srcDest);
	}
	
	<T extends IVec3fR & IVec3fW> T rotate(T src, T dest);
}
