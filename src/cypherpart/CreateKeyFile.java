package cypherpart;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateKeyFile {
	

	public CreateKeyFile(String a, String b){
		
		try {
			createFile(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void createFile(String pubkey) throws IOException{
		
	    PrintWriter ecrivain;
		ecrivain =  new PrintWriter(new BufferedWriter (new FileWriter("KEYS.txt")));
	   
	    ecrivain.println("Bonour !");
	    ecrivain.println("Voici votre clé privée, elle doit rester absolument secrete !");
	    ecrivain.print("CLE_PRIVE");
	    ecrivain.print("Et Voici votre clé publique : ");
	    ecrivain.print("");
	    ecrivain.println(pubkey);
	    
	    ecrivain.close();
	  }
		
	}
	
	


