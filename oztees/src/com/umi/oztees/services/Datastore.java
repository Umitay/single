package com.umi.oztees.services;
import java.util.List;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

public class Datastore
{
	static {
		ObjectifyService.setFactory(new OfyFactory());
	}
	
	/**
	 * @return our extension to Objectify
	 */
	public static ObjectDatastore ofy() {
		return (ObjectDatastore)ObjectifyService.ofy();
	}

	/**
	 * @return our extension to ObjectifyFactory
	 */
	public static OfyFactory factory() {
		return (OfyFactory)ObjectifyService.factory();
	}
	
	public static ObjectDatastore get(){
		return ofy();
	}
}