package com.lapissea.vec.color;

import com.lapissea.util.MathUtil;
import com.lapissea.util.NotNull;
import com.lapissea.vec.interf.Calculateable;
import com.lapissea.vec.interf.IVec3fR;
import com.lapissea.vec.interf.Interpolateble;
import com.lapissea.vec.interf.SimpleLoadable;
import gnu.trove.list.TFloatList;

import java.awt.Color;

public class ColorM extends ColorMRead implements Calculateable<ColorM>, Interpolateble<ColorM>, SimpleLoadable<ColorM>{
	
	public ColorM(@NotNull IVec3fR vec){
		super(vec.x(), vec.y(), vec.z());
	}
	
	public ColorM(){
		super();
	}
	
	public ColorM(int rgb){
		set(rgb);
	}
	
	public ColorM(@NotNull IColorM color){
		set(color);
	}
	
	public ColorM(Color color){
		super(color);
	}
	
	public ColorM(int offset, float[] data){
		load(offset, data);
	}
	
	public ColorM(IColorMSolid solid, float a){
		this(solid.r(), solid.g(), solid.b(), a);
	}
	
	public ColorM(float[] data){
		load(data);
	}
	
	public ColorM(float r, float g, float b, float a){
		set(r, g, b, a);
	}
	
	public ColorM(float r, float g, float b){
		set(r, g, b, 1);
	}
	
	public ColorM(String data){
		super();
		load(data);
	}
	
	@NotNull
	public ColorM r(float r){
		this.r = MathUtil.snap(r, 0, 1);
		return this;
	}
	
	@NotNull
	public ColorM g(float g){
		this.g = MathUtil.snap(g, 0, 1);
		return this;
	}
	
	@NotNull
	public ColorM b(float b){
		this.b = MathUtil.snap(b, 0, 1);
		return this;
	}
	
	@NotNull
	public ColorM a(float a){
		this.a = MathUtil.snap(a, 0, 1);
		return this;
	}
	
	@NotNull
	static <T extends ColorM> T convert(@NotNull T target, @NotNull Color color){
		target.r(color.getRed()/255F);
		target.g(color.getGreen()/255F);
		target.b(color.getBlue()/255F);
		target.a(color.getAlpha()/255F);
		return target;
	}
	
	@NotNull
	static ColorM convert(@NotNull Color color){
		return convert(new ColorM(), color);
	}
	
	public ColorM mix(@NotNull Color color){
		return mix(convert(color));
	}
	
	public ColorM mix(@NotNull Color color, float scale1, float scale2){
		return mix(convert(color), scale1, scale2);
	}
	
	@NotNull
	public ColorM negative(){
		return this;
	}
	
	@NotNull
	public ColorM add(float var){
		r(r() + var);
		g(g() + var);
		b(b() + var);
		a(a() + var);
		return this;
	}
	
	@NotNull
	public ColorM addR(float r){
		r(r() + r);
		return this;
	}
	
	@NotNull
	public ColorM addG(float r){
		g(g() + g);
		return this;
	}
	
	@NotNull
	public ColorM addB(float b){
		b(b() + b);
		return this;
	}
	
	@NotNull
	public ColorM addA(float b){
		a(a() + a);
		return this;
	}
	
	@NotNull
	@Override
	public ColorM add(@NotNull ColorM var){
		r(r() + var.r());
		g(g() + var.g());
		b(b() + var.b());
		a(a() + var.a());
		return this;
	}
	
	@NotNull
	public ColorM div(float var){
		r(r()/var);
		g(g()/var);
		b(b()/var);
		a(a()/var);
		return this;
	}
	
	@NotNull
	public ColorM divR(float r){
		r(r()/r);
		return this;
	}
	
	@NotNull
	public ColorM divG(float r){
		g(g()/g);
		return this;
	}
	
	@NotNull
	public ColorM divB(float b){
		b(b()/b);
		return this;
	}
	
	@NotNull
	public ColorM divA(float b){
		a(a()/a);
		return this;
	}
	
	@NotNull
	@Override
	public ColorM div(@NotNull ColorM var){
		r(r()/var.r());
		g(g()/var.g());
		b(b()/var.b());
		a(a()/var.a());
		return this;
	}
	
	@NotNull
	@Override
	public ColorM mul(float var){
		r(r()*var);
		g(g()*var);
		b(b()*var);
		a(a()*var);
		return this;
	}
	
	@NotNull
	public ColorM mulR(float r){
		r(r()*r);
		return this;
	}
	
	@NotNull
	public ColorM mulG(float g){
		g(g()*g);
		return this;
	}
	
	@NotNull
	public ColorM mulB(float b){
		b(b()*b);
		return this;
	}
	
	@NotNull
	public ColorM mulA(float a){
		a(a()*a);
		return this;
	}
	
	@NotNull
	@Override
	public ColorM mul(@NotNull ColorM var){
		r(r()*var.r());
		g(g()*var.g());
		b(b()*var.b());
		a(a()*var.a());
		return this;
	}
	
	@NotNull
	public ColorM sub(float var){
		r(r() - var);
		g(g() - var);
		b(b() - var);
		a(a() - var);
		return this;
	}
	
	@NotNull
	public ColorM subR(float r){
		r(r() - r);
		return this;
	}
	
	@NotNull
	public ColorM subG(float r){
		g(g() - g);
		return this;
	}
	
	@NotNull
	public ColorM subB(float b){
		b(b() - b);
		return this;
	}
	
	@NotNull
	public ColorM subA(float b){
		a(a() - a);
		return this;
	}
	
	@NotNull
	@Override
	public ColorM sub(@NotNull ColorM var){
		r(r() - var.r());
		g(g() - var.g());
		b(b() - var.b());
		a(a() - var.a());
		return this;
	}
	
	@NotNull
	@Override
	public ColorM clone(){
		return new ColorM(r, g, b, a);
	}
	
	@NotNull
	public static ColorM toColorM(IColorM color){
		return color instanceof ColorM? (ColorM)color : new ColorM(color);
	}
	
	@NotNull
	@Override
	public ColorM subRev(@NotNull ColorM c){
		return c.sub(this);
	}
	
	@NotNull
	@Override
	public ColorM abs(){
		return this;
	}
	
	@NotNull
	@Override
	public ColorM sqrt(){
		r = MathUtil.sqrt(r());
		g = MathUtil.sqrt(g());
		b = MathUtil.sqrt(b());
		a = MathUtil.sqrt(a());
		return this;
	}
	
	@NotNull
	@Override
	public ColorM sq(){
		r = MathUtil.sq(r());
		g = MathUtil.sq(g());
		b = MathUtil.sq(b());
		a = MathUtil.sq(a());
		return this;
	}
	
	@NotNull
	public ColorM set(int rgb){
		r = (rgb>>16&0xFF)/256F;
		g = (rgb>>8&0xFF)/256F;
		b = (rgb&0xFF)/256F;
		return this;
	}
	
	@NotNull
	@Override
	public ColorM set(@NotNull ColorM src){
		r = src.r();
		g = src.g();
		b = src.b();
		a = src.a();
		return this;
	}
	
	@NotNull
	public ColorM set(@NotNull IColorM src){
		r = src.r();
		g = src.g();
		b = src.b();
		a = src.a();
		return this;
	}
	
	@NotNull
	public ColorM set(float r, float g, float b, float a){
		r(r);
		g(g);
		b(b);
		a(a);
		return this;
	}
	
	@NotNull
	public ColorM toNoAlpha(){
		r *= a();
		g *= a();
		b *= a();
		a = 1;
		return this;
	}
	
	@NotNull
	public static ColorM interpolate(@NotNull ColorM dest, @NotNull IColorM v1, @NotNull IColorM v2, float percent){
		if(percent == 0) return dest.set(v1);
		else if(percent == 1) return dest.set(v2);
		return dest.set(v1.r() + (v2.r() - v1.r())*percent, v1.g() + (v2.g() - v1.g())*percent, v1.b() + (v2.b() - v1.b())*percent, v1.a() + (v2.a() - v1.a())*percent);
	}
	
	@NotNull
	@Override
	public ColorM interpolate(@NotNull ColorM v, float percent){
		return interpolate(this, this, v, percent);
	}
	
	@NotNull
	@Override
	public ColorM interpolate(@NotNull ColorM v1, @NotNull ColorM v2, float percent){
		return interpolate(this, v1, v2, percent);
	}
	
	@NotNull
	public ColorM interpolate(@NotNull IColorM v, float percent){
		return interpolate(this, this, v, percent);
	}
	
	@NotNull
	public ColorM interpolate(@NotNull IColorM v1, @NotNull IColorM v2, float percent){
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
		case 3:a(value);break;
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
		case 'a':a(value);break;
		}
		// @formatter:on
	}
	
	@NotNull
	@Override
	public ColorM load(int offset, float[] data){
		return set(data[offset], data[offset + 1], data[offset + 2], data[offset + 3]);
	}
	
	@NotNull
	@Override
	public ColorM load(int offset, @NotNull TFloatList data){
		return set(data.get(offset), data.get(offset + 1), data.get(offset + 2), data.get(offset + 3));
	}
	
}
