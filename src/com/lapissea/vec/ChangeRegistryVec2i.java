package com.lapissea.vec;

import com.lapissea.util.NotNull;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ChangeRegistryVec2i extends Vec2i{
	
	private List<Consumer<ChangeRegistryVec2i>> listeners;
	
	public boolean register(Runnable listener){
		return register(v -> listener.run());
	}
	
	public boolean register(Consumer<ChangeRegistryVec2i> listener){
		if(listeners == null) listeners = new ArrayList<>(2);
		else if(listeners.contains(listener)) return false;
		listeners.add(listener);
		return true;
	}
	
	public boolean unregister(Consumer<ChangeRegistryVec2i> listener){
		return listeners != null && listeners.remove(listener);
	}
	
	public void dispatch(ChangeRegistryVec2i obj){
		if(listeners == null) return;
		for(Consumer<ChangeRegistryVec2i> listener : listeners){
			listener.accept(obj);
		}
	}
	
	
	@Override
	public ChangeRegistryVec2i set(int x, int y){
		if(x() == x && y() == y) return this;
		
		super.set(x, y);
		dispatch(this);
		
		return this;
	}
	
	@NotNull
	@Override
	public ChangeRegistryVec2i x(int x){
		throw new UnsupportedOperationException();
	}
	
	@NotNull
	@Override
	public ChangeRegistryVec2i y(int y){
		throw new UnsupportedOperationException();
	}
	
	public ChangeRegistryVec2i(@NotNull ChangeRegistryVec2i vec2){
		super.set(vec2);
	}
	
	public ChangeRegistryVec2i(@NotNull Point point){
		super.set(point);
	}
	
	public ChangeRegistryVec2i(@NotNull Dimension dimension){
		super.set(dimension);
	}
	
	public ChangeRegistryVec2i(){
	}
	
	public ChangeRegistryVec2i(int x, int y){
		super.set(x, y);
	}
	
	
	@SafeVarargs
	public ChangeRegistryVec2i(int x, int y, @NotNull Consumer<ChangeRegistryVec2i>... listener){
		this(x, y);
		for(Consumer<ChangeRegistryVec2i> l : listener){
			register(l);
		}
	}
	
	@SafeVarargs
	public ChangeRegistryVec2i(@NotNull Consumer<ChangeRegistryVec2i>... listener){
		for(Consumer<ChangeRegistryVec2i> l : listener){
			register(l);
		}
	}
	
}
