package com.springmapping.springmapping;
import com.springmapping.springmapping.entities.Client;
import com.springmapping.springmapping.entities.CommandLine;
import com.springmapping.springmapping.entities.Commande;
import com.springmapping.springmapping.entities.Product;
import com.springmapping.springmapping.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;


@SpringBootApplication
@EnableSwagger2
public class SpringMappingApplication implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CommandRepository commandRepository;

	@Autowired
	private CommandLineRepository commandLineRepository;

	@Autowired
	private CommentaireRepository commentaireRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringMappingApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {

		/**Stream.of("Hamed","Ali","Jean","Kevin","Yull")
				.forEach(nom->{
					Client client=new Client();
					client.setId(UUID.randomUUID().toString());
					client.setNom(nom);
					client.setEmail(nom+"773@gmail.com");
					String telephone=Math.random()*0.5>0.67?"77389":"7838834";
					client.setTelephone("+22693"+telephone);

					//produit
					Product product=new Product();
					Double price=Math.random()*7783;
					product.setPrix(price);
					List<String>designations= Arrays.asList("Ampli","iphone","Pc Hp","Sac de Riz","MacBook Pro");
					String designation=designations.get((int)(Math.random()*designations.size()));
					product.setDesignation(designation);
					product.setUrl("https://www.numerama.com/wp-content/uploads/2022/02/dsc00078-scaled.jpg");
					//
					productRepository.save(product);
					//
					Commande commande=new Commande();

					CommandLine commandLine=new CommandLine();
					commandLine.setProduct(product);
					commandLine.setQuantite(2);
					commandLine.setProduct(product);
					commandLine.setCommande(commande);



					commandLineRepository.save(commandLine);

					List<CommandLine>commandLines=commande.getLignesCommande();
					commandLines.add(commandLine);

					commande.setLignesCommande(commandLines);

					commande.setClient(client);
					commande.setDate(new Date());
					commandRepository.save(commande);


					List<Commande>commandes=client.getCommandes();
					commandes.add(commande);

					client.setCommandes(commandes);

					clientRepository.save(client);

				});**/

		//this.commentaireRepository.deleteById(3L);
	}
}
