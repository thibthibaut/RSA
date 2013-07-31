package connexpart;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * MySQL client
 * @author Fobec 2010
 */
public class MySQLCli {

    private String dbURL = "";
    private String user = "";
    private String password = "";
    private java.sql.Connection dbConnect = null;
    private java.sql.Statement dbStatement = null;

    /**
     * Constructeur
     * @param url
     * @param user
     * @param password
     */
    public MySQLCli(String url, String user, String password) {
        this.dbURL = url;
        this.user = user;
        this.password = password;
    }

    /**
     * Connecter à la base de donnée
     * @return false en cas d'échec
     */
    public Boolean connect() {
        try {
        	String driver = "com.mysql.jdbc.Driver";
        	Class.forName(driver).newInstance();
        	
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.dbConnect = DriverManager.getConnection("jdbc:mysql:" + this.dbURL, this.user, this.password);
            this.dbStatement = this.dbConnect.createStatement();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MySQLCli.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLCli.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MySQLCli.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MySQLCli.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Executer une requete SQL
     * @param sql
     * @return resultat de la requete
     */
    public ResultSet exec(String sql) {
        try {
            ResultSet rs = this.dbStatement.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MySQLCli.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public void uptade(String cmd){
    	
    	try {
			this.dbStatement.executeUpdate(cmd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    /**
     * Fermer la connexion au serveur de DB
     */
    public void close() {
        try {
            this.dbStatement.close();
            this.dbConnect.close();
            this.dbConnect.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLCli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}