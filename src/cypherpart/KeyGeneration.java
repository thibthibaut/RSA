package cypherpart;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Random;

public class KeyGeneration {

	private BigInteger p;
	private BigInteger q;
	private BigInteger n;
	private BigInteger phi;
	private BigInteger e;
	private BigInteger d;
	
	public BigInteger cypher; //TODO Remove !
		
	
	public KeyGeneration(long a, long b, long c){
		
		generatePandQ(a,b);
		generateN();
		generatePhi();
		generateE(c);
		generateD();
		
		String pub1 = n.toString(36);
		String pub2= d.toString(36);
		String k=pub2 + "$" + pub1;
		try {
			this.createFile(k);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		testmethod();
		
	}

	public BigInteger getP() {
		
		return p;
	}


	public void setP(BigInteger p) {
		this.p = p;
	}
		
	
	public BigInteger getQ() {
		return q;
	}

	public void setQ(BigInteger bigInteger) {
		this.q = bigInteger;
	}

	public BigInteger getN() {
		return n;
	}

	public void setN(BigInteger n) {
		this.n = n;
	}

	public BigInteger getPhi() {
		return phi;
	}

	public void setPhi(BigInteger phi) {
		this.phi = phi;
	}

	public BigInteger getE() {
		return e;
	}

	public void setE(BigInteger e) {
		this.e = e;
	}

	public BigInteger getD() {
		return d;
	}

	public void setD(BigInteger d) {
		this.d = d;
	}

	public void generatePandQ(long param, long param2){
		
		Random rnd = new Random(System.currentTimeMillis()+param);
		Random rnd2 = new Random(System.currentTimeMillis()+param-1);
		setP(BigInteger.probablePrime(2048, rnd));
		setQ(BigInteger.probablePrime(2048, rnd2));
		System.out.println("P et Q générés");
	}
	
	public void generateN(){
		
		setN(p.multiply(q));
		System.out.println("N généré");
		
	}
	
	public void generatePhi(){
		
		BigInteger pm1 = p.subtract(BigInteger.ONE);
		BigInteger qm1 = q.subtract(BigInteger.ONE);
		setPhi(pm1.multiply(qm1));
		System.out.println("Phi généré");
	}

	public void generateE(long randomnbr){
		
		Random rnd = new Random(randomnbr);
		BigInteger t = new BigInteger(2047, rnd); //TODO Générer e sur plus <> et tester e<phi
		BigInteger one = BigInteger.ONE;
		BigInteger zero = BigInteger.ZERO;
		BigInteger l=zero;
		
		while(l.equals(one)==false){
			l=t.gcd(phi);
			t=t.add(one);
		}

		setE(t.subtract(BigInteger.ONE));
		System.out.println("E généré");
		
	}
	
	public void generateD(){
		setD(this.e.modInverse(phi));
		System.out.println("D généré");
	}
	
	public void createFile(String pubkey) throws IOException{
		
	    PrintWriter ecrivain;
		ecrivain =  new PrintWriter(new BufferedWriter (new FileWriter("KEYS.txt")));
	   
	    ecrivain.println("Bonjour !");
	    ecrivain.println("Voici votre clé privée, elle doit rester absolument secrete !");
	    ecrivain.println("----------");
	    ecrivain.println("CLE_PRIVE");
	    ecrivain.println("----------");
	    ecrivain.println("Et Voici votre clé publique : ");
	    ecrivain.println("----------");
	    ecrivain.println(pubkey);
	    ecrivain.println("----------");
	    ecrivain.close();
	  }
	
	public void testmethod(){ //TODO: REMOVE !
		
		BigInteger message = new BigInteger("1234567890987654321");
		long time2 = System.currentTimeMillis();
		this.cypher = message.modPow(e, n);
		System.out.println("Time to decrypt : " + (System.currentTimeMillis() - time2) + " milliseconds");
		System.out.println(cypher);
		
	}
	
	
}
