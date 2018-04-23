package com.lapissea.vec;

import com.lapissea.util.LogUtil;
import com.lapissea.util.NotNull;
import com.lapissea.util.Nullable;
import com.lapissea.vec.interf.*;
import gnu.trove.list.TFloatList;

import java.nio.ByteBuffer;

public class Vec3f implements IVec3fR, IVec3fW, Interpolateble<Vec3f>, IRotation, SimpleLoadable<Vec3f>{
	
	private static final Quat4 ROTATION_QUAT=new Quat4();
	
	private static final long serialVersionUID=8084946802516068121L;
	
	@NotNull
	public static Vec3f interpolate(@NotNull Vec3f dest, @NotNull IVec3fR v1, @NotNull IVec3fR v2, float percent){
		return dest.set(v1).add((v2.x()-v1.x())*percent, (v2.y()-v1.y())*percent, (v2.z()-v1.z())*percent);
	}
	
	public static Vec3f single(float f){
		return new Vec3f(f, f, f);
	}
	
	private float x, y, z;
	
	public Vec3f(){
		this(0);
	}
	
	public Vec3f(float x){
		this(x, 0);
	}
	
	public Vec3f(float x, float y){
		this(x, y, 0);
	}
	
	public Vec3f(float x, float y, float z){
		set(x, y, z);
	}
	
	public Vec3f(float[] data){
		this(data[0], data[1], data[2]);
	}
	
	public Vec3f(@NotNull String string){
		load(string);
	}
	
	public Vec3f(@NotNull String string, int start){
		load(string, start);
	}
	
	public Vec3f(@NotNull IVec3fR src){
		this(src.x(), src.y(), src.z());
	}
	
	@NotNull
	public Vec3f abs(){
		if(x()<0) x(-x());
		if(y()<0) y(-y());
		if(z()<0) z(-z());
		return this;
	}
	
	@NotNull
	public Vec3f add(float f){
		return add(f, f, f);
	}
	
	@NotNull
	public Vec3f add(float x, float y, float z){
		this.x+=x;
		this.y+=y;
		this.z+=z;
		return this;
	}
	
	@NotNull
	public Vec3f add(@NotNull IVec3fR vec){
		return add(vec.x(), vec.y(), vec.z());
	}
	
	@NotNull
	public Vec3f addX(float x){
		x(x()+x);
		return this;
	}
	
	@NotNull
	public Vec3f addY(float y){
		y(y()+y);
		return this;
	}
	
	@NotNull
	public Vec3f addZ(float z){
		z(z()+z);
		return this;
	}
	
	@NotNull
	public Vec3f addXZ(@NotNull IVec2iR vec){
		return addXZ(vec.x(), vec.y());
	}
	
	@NotNull
	public Vec3f addXZ(@NotNull Vec2f vec){
		return addXZ(vec.x(), vec.y());
	}
	
	@NotNull
	public Vec3f addXZ(float x, float z){
		return addX(x).addZ(z);
	}
	
	@NotNull
	@Override
	public Vec3f clone(){
		return new Vec3f(x(), y(), z());
	}
	
	@NotNull
	public <T extends IVec3fW> T crossProduct(@NotNull IVec3fR vec, @NotNull T dest){
		dest.set(y()*vec.z()-z()*vec.y(), z()*vec.x()-x()*vec.z(), x()*vec.y()-y()*vec.x());
		return dest;
	}
	
	@NotNull
	public Vec3f directionToEuler(){
		
		float distanceX=-x(), distanceY=-y(), distanceZ=-z();
		x((float)-Math.atan2(distanceY, Math.sqrt(distanceX*distanceX+distanceZ*distanceZ)));
		//		x((float)-Math.atan2(distanceY, MathUtil.length(-distanceX, -distanceZ)));
		y((float)Math.atan2(distanceX, -distanceZ));
		z(0);
		return this;
	}
	
	@NotNull
	public Vec3f div(float f){
		x(x()/f);
		y(y()/f);
		z(z()/f);
		return this;
	}
	
	@NotNull
	public Vec3f div(float x, float y, float z){
		x(x()/x);
		y(y()/y);
		z(z()/z);
		return this;
	}
	
	@NotNull
	public Vec3f div(@NotNull IVec3fR c){
		x(x()/c.x());
		y(y()/c.y());
		z(z()/c.z());
		return this;
	}
	
	@NotNull
	public Vec3f eulerToDirection(){
		double xCos=Math.cos(x());
		double xSin=Math.sin(x());
		
		double y   =z()+Math.PI/2;
		double yCos=Math.cos(y);
		double ySin=Math.sin(y);
		
		set(xCos*yCos, -xSin, -xCos*ySin);
		return this;
	}
	
	@NotNull
	@Override
	public Vec3f set(float x, float y, float z){
		this.x=x;
		this.y=y;
		this.z=z;
		return this;
	}
	
	@Override
	public int getValueCount(){
		return 3;
	}
	
	@NotNull
	@Override
	public Vec3f interpolate(@NotNull Vec3f second, float percent){
		return interpolate(this, this, second, percent);
	}
	
	@NotNull
	@Override
	public Vec3f interpolate(@NotNull Vec3f first, @NotNull Vec3f second, float percent){
		return interpolate(this, first, second, percent);
	}
	
	@NotNull
	@Override
	public Vec3f load(int offset, float[] data){
		return set(data[offset], data[offset+1], data[offset+2]);
	}
	
	@NotNull
	@Override
	public Vec3f load(int offset, @NotNull TFloatList data){
		return set(data.get(offset), data.get(offset+1), data.get(offset+2));
	}
	
	@NotNull
	@Override
	public Vec3f load(@NotNull String string){
		return load(string, 0);
	}
	
	@NotNull
	@Override
	public Vec3f load(@NotNull String string, int start){
		return load(string, start, string.length());
	}
	
	@NotNull
	@Override
	public Vec3f load(@NotNull String string, int start, int end){
		if(end>string.length()) throw new IllegalArgumentException("End "+end+" can not be larger than total length of "+string.length());
		if(start<0) throw new IllegalArgumentException("Start has to be positive!");
		if(start>=end) throw new IllegalArgumentException("Start has to be smaller than end!");
		
		boolean       begin=true, lastSpace=false;
		StringBuilder buff =new StringBuilder();
		int           rgba =0;
		for(int i=start;i<end;i++){
			char    c    =string.charAt(i);
			boolean space=c==','||Character.isWhitespace(c);
			if(begin){
				if(space) continue;
				else begin=false;
			}
			if(lastSpace&&space) continue;
			
			if(lastSpace=space){
				load(buff, rgba);
				rgba=(rgba+1)%3;
				buff.setLength(0);
			}else buff.append(c);
			
		}
		if(buff.length()>0) load(buff, rgba);
		
		return this;
	}
	
	private void load(@NotNull StringBuilder buff, int rgba){
		int pos=buff.indexOf("=");
		if(pos==-1){
			float num=Float.parseFloat(buff.toString());
			// @formatter:off
			switch(rgba){
			case 0:x(num);break;
			case 1:y(num);break;
			case 2:z(num);break;
			}
			// @formatter:on
		}else{
			float num=Float.parseFloat(buff.substring(pos+1).trim());
			// @formatter:off
			switch(buff.charAt(0)){
			case 'x':x(num);break;
			case 'y':y(num);break;
			case 'z':z(num);break;
			}
			// @formatter:on
		}
	}
	
	@Override
	public void loadValue(char c, float value){
		// @formatter:off
		switch(c){
		case 'x':x(value);break;
		case 'y':y(value);break;
		case 'z':z(value);break;
		}
		// @formatter:on
	}
	
	@Override
	public void loadValue(int id, float value){
		// @formatter:off
		switch(id){
		case 0:x(value);break;
		case 1:y(value);break;
		case 2:z(value);break;
		}
		// @formatter:on
	}
	
	@NotNull
	public Vec3f mul(float f){
		x(x()*f);
		y(y()*f);
		z(z()*f);
		return this;
	}
	
	@NotNull
	public Vec3f mul(float x, float y, float z){
		x(x()*x);
		y(y()*y);
		z(z()*z);
		return this;
	}
	
	@NotNull
	public Vec3f mul(@NotNull IVec3fR c){
		x(x()*c.x());
		y(y()*c.y());
		z(z()*c.z());
		return this;
	}
	
	@NotNull
	public Vec3f mulX(int x){
		return x(x()*x);
	}
	
	@NotNull
	public Vec3f mulY(int y){
		return y(y()*y);
	}
	
	@NotNull
	public Vec3f mulZ(int z){
		return z(z()*z);
	}
	
	@NotNull
	@Override
	public <T extends IVec3fR&IVec3fW> T rotate(@NotNull T src, @NotNull T dest){
		synchronized(ROTATION_QUAT){
			return ROTATION_QUAT.set(this).rotate(src, dest);
		}
	}
	
	public void set(double x, double y, double z){
		set((float)x, (float)y, (float)z);
	}
	
	@NotNull
	public Vec3f set(@NotNull IVec3fR src){
		x=src.x();
		y=src.y();
		z=src.z();
		return this;
	}
	
	@NotNull
	public <T extends IVec3fW> T normalise(@NotNull T dest){
		float l=(float)length();
		dest.set(x/l, y/l, z/l);
		return dest;
	}
	
	@NotNull
	public Vec3f normalise(){
		return normalise(this);
	}
	
	/**
	 * The dot product of two vectors is calculated as
	 * v1.x * v2.x + v1.y * v2.y + v1.z * v2.z
	 *
	 * @param left  The LHS vector
	 * @param right The RHS vector
	 * @return left dot right
	 */
	public static float dot(@NotNull Vec3f left, @NotNull Vec3f right){
		return left.x*right.x+left.y*right.y+left.z*right.z;
	}
	
	/**
	 * Calculate the angle between two vectors, in radians
	 *
	 * @param a A vector
	 * @param b The other vector
	 * @return the angle between the two vectors, in radians
	 */
	public static float angle(@NotNull Vec3f a, @NotNull Vec3f b){
		float dls=(float)(dot(a, b)/(a.length()*b.length()));
		if(dls<-1f) dls=-1f;
		else if(dls>1.0f) dls=1.0f;
		return (float)Math.acos(dls);
	}
	
	@NotNull
	public Vec3f set(@NotNull Vec3f src){
		x(src.x());
		y(src.y());
		z(src.z());
		return this;
	}
	
	@NotNull
	public Vec3f setMax(@NotNull Vec3f vec){
		if(x()<vec.x()) x(vec.x());
		if(y()<vec.y()) y(vec.y());
		if(z()<vec.z()) z(vec.z());
		return this;
	}
	
	@NotNull
	public Vec3f sq(){
		x(x()*x());
		y(y()*y());
		z(z()*z());
		return this;
	}
	
	@NotNull
	public Vec3f sqrt(){
		x((float)Math.sqrt(x()));
		y((float)Math.sqrt(y()));
		z((float)Math.sqrt(z()));
		return this;
	}
	
	@NotNull
	public Vec3f sub(float x, float y, float z){
		return x(x()-x).y(y()-y).z(z()-z);
	}
	
	@NotNull
	public Vec3f sub(@NotNull IVec3fR c){
		return sub(c.x(), c.y(), c.z());
	}
	
	@NotNull
	public Vec3f sub(@NotNull Vec3f c){
		return sub(c.x(), c.y(), c.z());
	}
	
	@NotNull
	public Vec3f subRev(@NotNull Vec3f c){
		x(c.x()-x());
		y(c.y()-y());
		z(c.z()-z());
		return this;
	}
	
	@NotNull
	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder(20);
		
		sb.append("Vec3f[");
		sb.append(x);
		sb.append(", ");
		sb.append(y);
		sb.append(", ");
		sb.append(z);
		sb.append(']');
		return sb.toString();
	}
	
	@Override
	public float w(){
		return 1;
	}
	
	@Override
	public float x(){
		return x;
	}
	
	@NotNull
	@Override
	public Vec3f x(float x){
		this.x=x;
		return this;
	}
	
	@Override
	public float y(){
		return y;
	}
	
	@NotNull
	@Override
	public Vec3f y(float y){
		this.y=y;
		return this;
	}
	
	@Override
	public float z(){
		return z;
	}
	
	@NotNull
	@Override
	public Vec3f z(float z){
		this.z=z;
		return this;
	}
	
	@Override
	public boolean equals(@Nullable Object obj){
		if(obj==null||!(obj instanceof IVec3fR)) return false;
		IVec3fR o=(IVec3fR)obj;
		return x()==o.x()&&y()==o.y()&&z()==o.z();
	}
	
	public void write(int destPos, @NotNull TFloatList dest){
		dest.set(destPos+0, x());
		dest.set(destPos+1, y());
		dest.set(destPos+2, z());
	}
	
	public void clampX(float min, float max){
		if(x()<min) x(min);
		else if(x()>max) x(max);
	}
	
}
