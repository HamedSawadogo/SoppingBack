package com.springmapping.springmapping;

import com.springmapping.springmapping.entities.Categorie;
import com.springmapping.springmapping.entities.Commentaire;
import com.springmapping.springmapping.entities.Product;
import com.springmapping.springmapping.repository.CategorieRepository;
import com.springmapping.springmapping.repository.CommentaireRepository;
import com.springmapping.springmapping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringMappingApplication implements CommandLineRunner {


	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private CommentaireRepository commentaireRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringMappingApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {

		/**	Optional<Categorie> categorieOptional=this.categorieRepository.findById(4L);
		Categorie categorie=categorieOptional.get();

		categorie.getProduits()
				.forEach(System.out::println);**/


		/**Categorie categorie=new Categorie();
		categorie.setNomCategorie("Alimentation");

		Product product=new Product();
		product.setDesignation("RiZ 50kg");
		product.setPrix(25000d);

		product.getCategorie();

		product.setCategorie(categorie);
		productRepository.save(product);**/


	 /**Optional<Product> product=productRepository.findById(2L);

	 Product product1=product.get();
	 Categorie categorie=new Categorie();
	 categorie.setNomCategorie("Ordinateur");

	 Categorie categorie1=categorieRepository.save(categorie);

	 if(categorie1.getProduits()==null){
		 categorie1.setProduits(new ArrayList<>());
	 }
	 categorie1.getProduits().add(product1);

	 Categorie categorie2=categorieRepository.save(categorie1);
	 product1.setCategorie(categorie2);

	 productRepository.save(product1);**/


	 //Rechercher la categorie
	/**Optional<Categorie>categorieOptional=categorieRepository.findById(3L);
	Categorie categorie=categorieOptional.get();

	if(categorie.getProduits()==null){
			categorie.setProduits(new ArrayList<>());
	}

	//creer et Persister un Produit
	Product product=new Product();
	product.setDesignation("A");
	product.setPrix(5300d);
	Product product1=productRepository.save(product);

	//Ajouter un Produit a la catégorie
	//Le problème est Ici  je fais comment ?
	 categorie.getProduits().add(product1);**/

	/**Product product=productRepository.findByName("Inprimante");
		System.out.println(product.getDesignation());
		System.out.println(product.getPrix());
		System.out.println(product.getId());

	}**/

	}
}
