package com.practice.test.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.practice.test.model.User;

@RestController
@RequestMapping("/users") // Unificación de url --- nivel de clase

//Versionado y estructuración de URL en application.properties --Buenas prácticas

public class UserController {
	
	private List<User> users  = new ArrayList<>(Arrays.asList(
			new User(1,"Chema", 23, "123", "Hola"),
			new User(2, "Pepe", 6, "aztecas", "Quiovo"),
			new User(3, "Jose", 8, "kyogre", "Que onda"),
			new User(4, "Manuel", 20, "casa", "Que hay")
			)); 
 	
	
	/*
	 *A nivel de método es: 
	 *@RequestMapping(method = RequestMethod.GET)
	 *Es lo mismo, su uso dependerá de las especificaciones que se quieran o no agregar
	 *para parametro se agrega (value = "/{id}"
	 */
	@GetMapping //("/users") ya no es necesario ya que se unificaron las rutas, igual en las demás rutas
	public ResponseEntity<List<User>> getUsers () {
		return ResponseEntity.ok(users);
		//return users;
	}
	
	@GetMapping("/{username}") // se borra /users ya que se unificaron las rutas
	public ResponseEntity<?> getUser(@PathVariable String username){
		for(User u : users) {	
			if(u.getName().equalsIgnoreCase(username)) {
				return ResponseEntity.ok(u);
				//return u;
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado con username: " + username);
		//return null;
	}
	@PostMapping
	public ResponseEntity<?> postUser(@RequestBody User user) {
		users.add(user);
		
		URI location =  ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{username}")
				.buildAndExpand(user.getName())
				.toUri();
		
		// Buenas prácticas de REST, al crear un post 201 de estatus, es buena práctica generar la URI
		
		//return ResponseEntity.created(location).build(); // para crear 201 con URI
		
		return ResponseEntity.created(location).body(user); // lo mismo que arriba pero da por consola el objeto user
		
		//return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado éxitosamente: " + user.getName());
		//return user;
	}
	
	@PutMapping
	public ResponseEntity<?> putUser(@RequestBody User user) {
		for(User u : users) {
			if(u.getId() == user.getId()) {
				u.setName(user.getName());
				u.setAge(user.getAge());
				u.setPassword(user.getPassword());
				u.setGreeting(user.getGreeting());

				return ResponseEntity.noContent().build(); // tipo de respuesta 204
				//return u;
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id) {
		for (User u : users) {
			if(u.getId() == id) {
				users.remove(u);
				return ResponseEntity.noContent().build();
				//return u;
			}
		}
		return ResponseEntity.notFound().build(); //404 not found
	}
	
	@PatchMapping
	public ResponseEntity<?> patchUser(@RequestBody User user) {
		for(User u : users) {
			if(u.getId() == user.getId()) {
				
				if(user.getName() != null) {
					u.setName(user.getName());
				}
				if(user.getAge() != null) {
					u.setAge(user.getAge());
				}
				if(user.getPassword() != null) {
					u.setPassword(user.getPassword());
				}
				if(user.getGreeting() != null) {
					u.setGreeting(user.getGreeting());
				}
				return ResponseEntity.ok("Usuario modificado satisfactoriamente con el ID:  " + user.getId());
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado con ID: " + user.getId());
	}
}
