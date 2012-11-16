package name.pathfinder.azaleas.dubbo.demo.internal.services;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import name.pathfinder.azaleas.dubbo.demo.core.Customer;
import name.pathfinder.azaleas.dubbo.demo.core.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	
	private ConcurrentMap<String, Customer> cache = new ConcurrentHashMap<String, Customer>();

	public CustomerServiceImpl() {
		Customer tech = new Customer("1", "tech", "TechSupcon", new Date());
		cache.put(tech.getName(), tech);
	}

	/*
	 * (non-Javadoc)
	 * @see name.pathfinder.azleas.virgo.demo.core.CustomerService#get(java.lang.String)
	 */
	@Override
	public Customer get(String name) {
		return cache.get(name);
	}
	
	/*
	 * (non-Javadoc)
	 * @see name.pathfinder.azleas.virgo.demo.core.CustomerService#create(name.pathfinder.azleas.virgo.demo.core.Customer)
	 */
	@Override
	public void create(Customer customer) {
		final String name = customer.getName();
		Customer old = cache.putIfAbsent(name, customer);
		if (null != old) {
			throw new IllegalStateException("The customer[ " + name + "] existed.");
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see name.pathfinder.azleas.virgo.demo.core.CustomerService#update(java.lang.String, name.pathfinder.azleas.virgo.demo.core.Customer)
	 */
	@Override
	public void update(String name, Customer customer) throws IllegalAccessException {
		Customer persisted = cache.get(name);
		if (null == persisted)
			throw new IllegalAccessException("The customer[" + name + "] does not existed, please use create method.");
		if (persisted.getVersion() == customer.getVersion()) {
			persisted.setShortName(customer.getShortName());
			persisted.setFullName(customer.getFullName());
			persisted.setCreateTime(customer.getCreateTime());
			persisted.setVersion(persisted.getVersion() + 1);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see name.pathfinder.azleas.virgo.demo.core.CustomerService#delete(java.lang.String)
	 */
	@Override
	public void delete(String name) {
		cache.remove(name);
	}

}
