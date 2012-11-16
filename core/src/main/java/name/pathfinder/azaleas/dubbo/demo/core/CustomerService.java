package name.pathfinder.azaleas.dubbo.demo.core;


public interface CustomerService {

	public Customer get(String name);

	public void create(Customer customer);

	public void update(String name, Customer customer) throws IllegalAccessException;

	public void delete(String name);

}