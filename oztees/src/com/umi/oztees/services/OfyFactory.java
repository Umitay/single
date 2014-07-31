package com.umi.oztees.services;

import javax.inject.Singleton;
import com.umi.oztees.models.*;
import com.googlecode.objectify.ObjectifyFactory;

@Singleton
public class OfyFactory extends ObjectifyFactory
{
	/** Register our entity types*/
	public OfyFactory() {
		super();
		this.register(Product.class);
	}

	@Override
	public ObjectDatastore begin() {
		return new ObjectDatastore(this);
	}
}