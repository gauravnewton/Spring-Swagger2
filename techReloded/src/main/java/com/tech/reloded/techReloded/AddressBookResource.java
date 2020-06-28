package com.tech.reloded.techReloded;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class AddressBookResource.
 */
@RestController
@RequestMapping("/api")
public class AddressBookResource {
	
	/** The contacts. */
	ConcurrentHashMap<String, Contact> contacts = new ConcurrentHashMap<>();
	
	/**
	 * Gets the contact.
	 *
	 * @param id the id
	 * @return the contact
	 */
	@GetMapping("/{id}")
	public Contact getContact(@PathVariable String id) {
		return contacts.get(id);
	}
	
	/**
	 * Gets the all contact.
	 *
	 * @return the all contact
	 */
	@GetMapping("/")
	public  List<Contact> getAllContact(){
		return new ArrayList<Contact>(contacts.values());
	}
	
	/**
	 * Adds the contact.
	 *
	 * @param contact the contact
	 * @return the contact
	 */
	@PostMapping("/")
	public  Contact addContact(@RequestBody Contact contact) {
		contacts.put(contact.getId(), contact);
		return contact;
	}
}
