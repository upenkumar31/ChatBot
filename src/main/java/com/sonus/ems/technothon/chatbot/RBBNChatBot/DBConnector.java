package com.sonus.ems.technothon.chatbot.RBBNChatBot;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * Java MongoDB : Query document
 *
 * @author mkyong
 *
 */
public class DBConnector {
    public static Mongo mongo;
    public static DB db ;
    public static DBCollection collection;
    public static DBCollection collection2;

    public DBConnector()
    {
        try {
            mongo = new Mongo("10.54.28.83", 27017);
            db = mongo.getDB("chatbox");
            collection = db.getCollection("troubleResponse");
            collection2 = db.getCollection("generalResponse");
        }catch (UnknownHostException exp)
        {
            exp.getCause();
        }
    }

    public static void insertDummyDocuments(DBCollection collection) {

        List<DBObject> list = new ArrayList<DBObject>();

        Calendar cal = Calendar.getInstance();

        for (int i = 1; i <= 1; i++) {

            BasicDBObject data = new BasicDBObject();
            data.append("id", i);
            data.append("text", "Ribbon" + i);
            // data.append("date", cal.getTime());

            // +1 day
            cal.add(Calendar.DATE, 1);

            list.add(data);

        }

        collection.insert(list);

    }
    public static void insert(int id,String text)
    {
        BasicDBObject data = new BasicDBObject();
        data.append("id", id);
        data.append("text",text);
        collection.insert(data);
    }
    public static void insertGeneralResponse(String entity,String response)
    {
        BasicDBObject data = new BasicDBObject();
        data.append("entity",entity.toLowerCase());
        data.append("text",response.toLowerCase());
        collection2.insert(data);
    }
    public static String searchGeneralResponse(String entity)
    {
        DBObject dbObject1 = new BasicDBObject();
        ((BasicDBObject) dbObject1).append("entity",entity);
        DBObject dbObject = collection2.findOne(dbObject1);
        return dbObject==null?"":dbObject.get("text").toString();
    }
    public static String search(int id)
    {
        DBObject dbObject1 = new BasicDBObject();
        ((BasicDBObject) dbObject1).append("id",id);
        DBObject dbObject = collection.findOne(dbObject1);
        return dbObject==null?"":dbObject.get("text").toString();
    }
    public static void main(String[] args) {

       DBConnector dbConnector = new DBConnector();
       DBObject dbObject = new BasicDBObject();
       //((BasicDBObject) dbObject).append("id",12);
       //collection.remove(dbObject);
        insertGeneralResponse("Ribbon's CFO","Daryl Raiford");
       String res = searchGeneralResponse("call controllers");
       if(res!=null)
           System.out.println(res);
    }
}