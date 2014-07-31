package com.umi.oztees.services;
import java.util.List;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.impl.ObjectifyImpl;

public class ObjectDatastore extends ObjectifyImpl<ObjectDatastore>
{
	/** */
	public ObjectDatastore(OfyFactory base) {
		super(base);
	}

	/** More wrappers, fun */
	@Override
	public OfyLoader load() {
		return new OfyLoader(this);
	}
	
	public OfyLoader get()
	{
		return new OfyLoader(this);
	}
	
	public OfyLoader find()
	{
		return load();
	}
	public <E> List<E> find(Class<E> type, String feild, String value)
	{
		return load().type(type).filter(feild+" ==",value).list();
	}	
	public <E> List<E> find(Class<E> type, String feild, long value)
	{
		return load().type(type).filter(feild+" ==",value).list();
	}
	public <E> List<E> find(Class<E> type, String feild, Boolean value)
	{
		return load().type(type).filter(feild+" ==",value).list();
	}
	
	public <E> E load(Class<E> type,String id) {
		return load().type(type).id(id).now();
	}
	
	public <E> E load(Class<E> type,long id) {
		return load().type(type).id(id).now();
	}
	
	public <E> E update(E object)
	{
		this.save().entity(object).now();
		return object;
	}
	
	public <E> E store(E object)
	{
		this.save().entity(object).now();
		return object;
	}
	
	public <T> Key<T> createKey(T pojo){
		return Key.create(pojo);
	}
}
