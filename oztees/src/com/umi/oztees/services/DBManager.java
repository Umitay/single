package com.umi.oztees.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


import com.googlecode.objectify.Key;
import com.googlecode.objectify.Result;

public class DBManager {

	protected ObjectDatastore m_datastore;
	protected Logger log;

	public DBManager()
	{
		//this(InstallerDatastore.get());
		log = Logger.getLogger(this.getClass().getName());
	}

	public DBManager(ObjectDatastore datastore)
	{
		super();
		this.setM_datastore(datastore);
	}

	public ObjectDatastore getM_datastore()
	{
		return m_datastore;
	}

	public void setM_datastore(ObjectDatastore m_datastore)
	{
		this.m_datastore = m_datastore;
	}

	public <E> E save(E object)
	{
		m_datastore.save().entity(object).now();
		return object;
	}

	public <E> Result<Map<Key<E>, E>> storeList(List<E> list)
	{
		return save(list);
	}
	
	public <E> Result<Map<Key<E>, E>> save(List<E> list)
	{
		return m_datastore.save().entities(list);
	}
	
	public <E> Map<Key<E>, E> saveNow(List<E> list)
	{
		return m_datastore.save().entities(list).now();
	}
	
	public <E> Key<E> createKey(E object)
	{
		return m_datastore.createKey(object);
	}
	
	public <E> List<E> load(List<Key<E>> keys)
	{
		return new ArrayList<E>(m_datastore.load().keys(keys).values());
	}
	
	public <E> E load(Key<E> key)
	{
		return m_datastore.load().key(key).now();
	}

	public <E> void deleteAll(Class<E> type)
	{
		m_datastore.delete().keys(m_datastore.load().type(type).keys());
	}
	
	public <E> void deleteAllNow(Class<E> type)
	{
		m_datastore.delete().keys(m_datastore.load().type(type).keys()).now();
	}
}
