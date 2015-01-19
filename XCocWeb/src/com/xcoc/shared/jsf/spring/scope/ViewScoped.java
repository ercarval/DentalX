package com.xcoc.shared.jsf.spring.scope;

import java.util.Map;

import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class ViewScoped implements Scope {

	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		
		UIViewRoot viewRoot = 
				FacesContext.getCurrentInstance().getViewRoot();
		
		if (viewRoot == null) {
			return null;
		}

		Map<String, Object> viewMap = viewRoot.getViewMap();
		if (viewMap.containsKey(name)) {
			return viewMap.get(name);
		} 

		Object object = objectFactory.getObject();
		viewMap.put(name, object);
		return object;
		
			
	}

	@Override
	public Object remove(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerDestructionCallback(String name, Runnable callback) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object resolveContextualObject(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getConversationId() {
		// TODO Auto-generated method stub
		return null;
	}

}