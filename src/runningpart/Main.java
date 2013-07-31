package runningpart;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import connexpart.MySQLCli;

import cypherpart.KeyGeneration;


public class Main {

	
	
	public static void main(String[] args) throws IOException {
	
		
		 MySQLCli mysqlCli = new MySQLCli("//localhost", "root", "");
		 System.out.println(mysqlCli.connect());
		 
		 mysqlCli.uptade("INSERT INTO `securechat`.`minichat` (`id`, `pseudo`, `message`, `timestamp`) VALUES (NULL, 'ZBRA', 'ZBROU', NOW());");
		
    }
}
		
		
	
