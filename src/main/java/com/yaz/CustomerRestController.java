package com.yaz;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
//	@Autowired
	private CustomerDAO customerDAO;
	
	public CustomerRestController() {
		
	}
	
	public CustomerRestController(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@GetMapping("/frusers")
	public Iterable<Customer> getCustomers(){
		return customerDAO.findAll();
	}
	
	@PostMapping("/frusers")
	public Customer addCustomer(@RequestBody Customer theCustomer){
		
		//theCustomer.setId(0);
		
		customerDAO.save(theCustomer);
		
		return theCustomer;
	}
	
	@PutMapping("/frusers")
	public Customer updateCustomer(@RequestBody Customer theCustomer){
		
		customerDAO.save(theCustomer);
		
		return theCustomer;
	}
	
	@DeleteMapping("/frusers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId){
		
		Optional<Customer> tempCustomer = customerDAO.findById(customerId);
		
		if(tempCustomer == null)
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		
		customerDAO.deleteById(customerId);
		
		return "Deleted Customer id - " + customerId;
	}
	
//	@PostMapping("/frusers/user/pass")
//	public Customer getCustomer(@RequestHeader String userName, @RequestHeader String password){
//		Customer theCustomer = customerDAO.getCustomer(userName, password);
//		
//		if(theCustomer == null)
//			throw new CustomerNotFoundException("UserName or password not found - " + userName + " " +password);
//		
//		return theCustomer;
//	}
//	
//	@PostMapping("/frusers/user")
//	public Customer getCustomer(@RequestHeader String userName){
//		Customer theCustomer = customerDAO.getCustomer(userName);
//		
//		if(theCustomer == null)
//			throw new CustomerNotFoundException("UserName not found - " + userName);
//		
//		return theCustomer;
//	}
//	
//	@PostMapping("/frusers/find")
//	public Customer getCustomer(@RequestHeader int customerId){
//		Customer theCustomer = customerDAO.getCustomer(customerId);
//		
//		if(theCustomer == null)
//			throw new CustomerNotFoundException("Customer id not found - " + customerId);
//		
//		return theCustomer;
//	}
//	
//	
//	@PostMapping("/frusers/multiple")
//	public Customer[] addCustomers(@RequestBody Customer[] theCustomers){
//		
//		for(int i = 0; i < theCustomers.length; i++) {
//			theCustomers[i].setId(0);
//			
//			customerDAO.saveCustomer(theCustomers[i]);
//		}
//		
//		return theCustomers;
//	}
//	
//	
//	
////-----------------------------------KAMPANYALAR----------------------------------
//	
//	@GetMapping("/kampanyalar")
//	public List<Kampanya> getKampanyalar(){
//		return customerDAO.getKampanyalar();
//	}
//	
//	@PostMapping("/kampanyalar")
//	public Kampanya addKampanya(@RequestBody Kampanya kampanya){
//		
//		kampanya.setId(0);
//		
//		customerDAO.saveKampanya(kampanya);
//		
//		return kampanya;
//	}
//	
//	@PutMapping("/kampanyalar")
//	public Kampanya updateKampanya(@RequestBody Kampanya kampanya){
//		
//		customerDAO.saveKampanya(kampanya);
//		
//		return kampanya;
//	}
//	
//	@DeleteMapping("/kampanyalar/{kampanyaId}")
//	public String deleteKampanya(@PathVariable int kampanyaId){
//		
//		Kampanya kampanya = customerDAO.getKampanya(kampanyaId);
//		
//		if(kampanya == null)
//			throw new CustomerNotFoundException("Kampanya id not found - " + kampanyaId);
//		
//		customerDAO.deleteKampanya(kampanyaId);
//		
//		return "Deleted Kampanya id - " + kampanyaId;
//	}
//	
//	
////-----------------------------------HESAP HAREKET�----------------------------------
//
//	@GetMapping("/hesapHareketleri")
//	public List<HesapHareketi> getHesapHareketleri(){
//		return customerDAO.getHesapHareketleri();
//	}
//	
//	@PostMapping("/hesapHareketleri")
//	public HesapHareketi addHesapHareketi(@RequestBody HesapHareketi hesapHareketi){
//		
//		hesapHareketi.setId(0);
//		
//		customerDAO.saveHesapHareketi(hesapHareketi);
//		
//		return hesapHareketi;
//	}
//	
//	@PutMapping("/hesapHareketleri")
//	public HesapHareketi updateHesapHareketi(@RequestBody HesapHareketi hesapHareketi){
//		
//		customerDAO.saveHesapHareketi(hesapHareketi);
//		
//		return hesapHareketi;
//	}
//	
//	@DeleteMapping("/hesapHareketleri/{hesapHareketiId}")
//	public String deleteHesapHareketi(@PathVariable int hesapHareketiId){
//		
//		HesapHareketi hesapHareketi = customerDAO.getHesapHareketi(hesapHareketiId);
//		
//		if(hesapHareketi == null)
//			throw new CustomerNotFoundException("HesapHareketi id not found - " + hesapHareketiId);
//		
//		customerDAO.deleteHesapHareketi(hesapHareketiId);
//		
//		return "Deleted HesapHareketi id - " + hesapHareketiId;
//	}
}
