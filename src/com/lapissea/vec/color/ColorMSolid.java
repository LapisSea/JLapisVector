package com.lapissea.vec.color;

import com.lapissea.util.MathUtil;
import com.lapissea.util.NotNull;
import com.lapissea.vec.interf.Calculateable;
import com.lapissea.vec.interf.IVec3fR;
import com.lapissea.vec.interf.Interpolateble;
import com.lapissea.vec.interf.SimpleLoadable;
import gnu.trove.list.TFloatList;

import java.awt.*;

public class ColorMSolid extends ColorMSolidRead implements Calculateable<ColorMSolid>, Interpolateble<ColorMSolid>, SimpleLoadable<ColorMSolid>{
	
	public ColorMSolid(@NotNull IVec3fR vec){
		super(vec.x(), vec.y(), vec.z());
	}
	
	public ColorMSolid(){
		super();
	}
	
	public ColorMSolid(int rgb){
		set(rgb);
	}
	
	public ColorMSolid(@NotNull IColorMSolid color){
		set(color);
	}
	
	public ColorMSolid(Color color){
		super(color);
	}
	
	public ColorMSolid(int offset, float[] data){
		load(offset, data);
	}
	
	public ColorMSolid(float[] data){
		load(data);
	}
	
	public ColorMSolid(float r, float g, float b){
		set(r, g, b);
	}
	
	public ColorMSolid(String data){
		super();
		load(data);
	}
	
	@NotNull
	public ColorMSolid r(float r){
		this.r=MathUtil.snap(r, 0, 1);
		return this;
	}
	
	@NotNull
	public ColorMSolid g(float g){
		this.g=MathUtil.snap(g, 0, 1);
		return this;
	}
	
	@NotNull
	public ColorMSolid b(float b){
		this.b=MathUtil.snap(b, 0, 1);
		return this;
	}
	
	@NotNull
	public ColorMSolid negative(){
		return this;
	}
	
	@NotNull
	public ColorMSolid add(float var){
		r(r()+var);
		g(g()+var);
		b(b()+var);
		return this;
	}
	
	@NotNull
	public ColorMSolid addR(float r){
		r(r()+r);
		return this;
	}
	
	@NotNull
	public ColorMSolid addG(float r){
		g(g()+g);
		return this;
	}
	
	@NotNull
	public ColorMSolid addB(float b){
		b(b()+b);
		return this;
	}
	
	@NotNull
	@Override
	public ColorMSolid add(@NotNull ColorMSolid var){
		r(r()+var.r());
		g(g()+var.g());
		b(b()+var.b());
		return this;
	}
	
	@NotNull
	public ColorMSolid div(float var){
		r(r()/var);
		g(g()/var);
		b(b()/var);
		return this;
	}
	
	@NotNull
	public ColorMSolid divR(float r){
		r(r()/r);
		return this;
	}
	
	@NotNull
	public ColorMSolid divG(float r){
		g(g()/g);
		return this;
	}
	
	@NotNull
	public ColorMSolid divB(float b){
		b(b()/b);
		return this;
	}
	
	@NotNull
	@Override
	public ColorMSolid div(@NotNull ColorMSolid var){
		r(r()/var.r());
		g(g()/var.g());
		b(b()/var.b());
		return this;
	}
	
	@NotNull
	@Override
	public ColorMSolid mul(float var){
		r(r()*var);
		g(g()*var);
		b(b()*var);
		return this;
	}
	
	@NotNull
	public ColorMSolid mulR(float r){
		r(r()*r);
		return this;
	}
	
	@NotNull
	public ColorMSolid mulG(float g){
		g(g()*g);
		return this;
	}
	
	@NotNull
	public ColorMSolid mulB(float b){
		b(b()*b);
		return this;
	}
	
	
	@NotNull
	@Override
	public ColorMSolid mul(@NotNull ColorMSolid var){
		r(r()*var.r());
		g(g()*var.g());
		b(b()*var.b());
		return this;
	}
	
	@NotNull
	public ColorMSolid sub(float var){
		r(r()-var);
		g(g()-var);
		b(b()-var);
		return this;
	}
	
	@NotNull
	public ColorMSolid subR(float r){
		r(r()-r);
		return this;
	}
	
	@NotNull
	public ColorMSolid subG(float r){
		g(g()-g);
		return this;
	}
	
	@NotNull
	public ColorMSolid subB(float b){
		b(b()-b);
		return this;
	}
	
	@NotNull
	@Override
	public ColorMSolid sub(@NotNull ColorMSolid var){
		r(r()-var.r());
		g(g()-var.g());
		b(b()-var.b());
		return this;
	}
	
	@NotNull
	@Override
	public ColorMSolid clone(){
		return new ColorMSolid(r, g, b);
	}
	
	@NotNull
	public static ColorMSolid toColorM(IColorM color){
		return color instanceof ColorMSolid?(ColorMSolid)color:new ColorMSolid(color);
	}
	
	@NotNull
	@Override
	public ColorMSolid subRev(@NotNull ColorMSolid c){
		return c.sub(this);
	}
	
	@NotNull
	@Override
	public ColorMSolid abs(){
		return this;
	}
	
	@NotNull
	@Override
	public ColorMSolid sqrt(){
		r=MathUtil.sqrt(r());
		g=MathUtil.sqrt(g());
		b=MathUtil.sqrt(b());
		return this;
	}
	
	@NotNull
	@Override
	public ColorMSolid sq(){
		r=MathUtil.sq(r());
		g=MathUtil.sq(g());
		b=MathUtil.sq(b());
		return this;
	}
	
	@NotNull
	public ColorMSolid set(int rgb){
		r=(rgb>>16&0xFF)/256F;
		g=(rgb>>8&0xFF)/256F;
		b=(rgb&0xFF)/256F;
		return this;
	}
	
	@NotNull
	@Override
	public ColorMSolid set(@NotNull ColorMSolid src){
		r=src.r();
		g=src.g();
		b=src.b();
		return this;
	}
	
	@NotNull
	public ColorMSolid set(@NotNull IColorMSolid src){
		r=src.r();
		g=src.g();
		b=src.b();
		return this;
	}
	
	@NotNull
	public ColorMSolid set(float r, float g, float b){
		r(r);
		g(g);
		b(b);
		return this;
	}
	
	@NotNull
	public static ColorMSolid interpolate(@NotNull ColorMSolid dest, @NotNull IColorMSolid v1, @NotNull IColorMSolid v2, float percent){
		if(percent==0) return dest.set(v1);
		else if(percent==1) return dest.set(v2);
		return dest.set(v1.r()+(v2.r()-v1.r())*percent, v1.g()+(v2.g()-v1.g())*percent, v1.b()+(v2.b()-v1.b())*percent);
	}
	
	@NotNull
	@Override
	public ColorMSolid interpolate(@NotNull ColorMSolid v, float percent){
		return interpolate(this, this, v, percent);
	}
	
	@NotNull
	@Override
	public ColorMSolid interpolate(@NotNull ColorMSolid v1, @NotNull ColorMSolid v2, float percent){
		return interpolate(this, v1, v2, percent);
	}
	
	@NotNull
	public ColorMSolid interpolate(@NotNull IColorM v, float percent){
		return interpolate(this, this, v, percent);
	}
	
	@NotNull
	public ColorMSolid interpolate(@NotNull IColorM v1, @NotNull IColorM v2, float percent){
		return interpolate(this, v1, v2, percent);
	}
	
	@Override
	public int getValueCount(){
		return 4;
	}
	
	@Override
	public void loadValue(int id, float value){
		// @formatter:off
		switch(id){
		case 0:r(value);break;
		case 1:g(value);break;
		case 2:b(value);break;
		}
		// @formatter:on
	}
	
	@Override
	public void loadValue(char c, float value){
		// @formatter:off
		switch(c){
		case 'r':r(value);break;
		case 'g':g(value);break;
		case 'b':b(value);break;
		}
		// @formatter:on
	}
	
	@NotNull
	@Override
	public ColorMSolid load(int offset, float[] data){
		return set(data[offset], data[offset+1], data[offset+2]);
	}
	
	@NotNull
	@Override
	public ColorMSolid load(int offset, @NotNull TFloatList data){
		return set(data.get(offset), data.get(offset+1), data.get(offset+2));
	}
	
}
