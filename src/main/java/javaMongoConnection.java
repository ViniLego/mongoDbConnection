
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


import java.util.Arrays;
import java.util.List;



public class javaMongoConnection {


    String user; // the user name
    String database; // the name of the database in which the user is defined
    char[] password; // the password as a character array
    public static void main(String args[]){
        //MongoCredential credential = MongoCredential.createCredential(user, database, password);
        //MongoClientOptions options = MongoClientOptions.builder().sslEnabled(true).build();
        //MongoClient mongoClient = new MongoClient(new ServerAddress("host1", 27017),
        //                                           Arrays.asList(credential),
        //                                           options);
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        System.out.println("Server connection was successfull!");
        List <String> dbNames = mongoClient.getDatabaseNames();
        System.out.println(dbNames);
        MongoDatabase database = mongoClient.getDatabase("admin");
        MongoCollection<Document> collection = database.getCollection("client");
        collection.find().forEach(printBlock);
    }
    static Block<Document> printBlock = new Block<Document>() {
        @Override
        public void apply(final Document document) {
            System.out.println(document.toJson());
        }
    };
}
