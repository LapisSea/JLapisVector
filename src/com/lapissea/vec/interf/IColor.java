package com.lapissea.vec.interf;


import com.lapissea.util.NotNull;

public interface IColor{
	
	float r();
	float g();
	float b();
	float a();
	@NotNull
	IVec3fR r(float x);
	@NotNull
	IVec3fR g(float x);
	@NotNull
	IVec3fR b(float x);
	@NotNull
	IVec3fR a(float x);
}
