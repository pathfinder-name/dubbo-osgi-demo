/**
 * 
 */
package name.pathfinder.azaleas.dubbo.demo.internal.consumer;

import name.pathfinder.azaleas.dubbo.demo.core.Customer;
import name.pathfinder.azaleas.dubbo.demo.core.CustomerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yaowei
 *
 */
public class CustomerConsumer {
	
	private CustomerService customerService;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerConsumer.class);

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	public void start() {
		Customer customer = this.customerService.get("1");
		System.out.println("Get " + customer + " from CustomerService.");
	}
}
