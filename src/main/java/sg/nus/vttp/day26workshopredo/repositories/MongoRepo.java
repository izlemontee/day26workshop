package sg.nus.vttp.day26workshopredo.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class MongoRepo {

    @Autowired
    private MongoTemplate mongoTemplate;


    public List<Document> getAllGames(int offset, int limit){
        Criteria criteria = Criteria.where("gid").exists(true);

        Query query = new Query().skip(offset).limit(limit);
        //.with(Sort.by(Sort.Direction.ASC,"gid")).skip(offset).limit(limit);
        // query.fields()
        //     .include("gid","name","ranking");
        List<Document> result = mongoTemplate.find(query, Document.class,"game");
        return result;
    }

    public List<Document> getGamesRanked(int offset, int limit){
        Query query = new Query()
        .with(Sort.by(Sort.Direction.ASC,"ranking")).skip(offset).limit(limit);
        //query.fields().include("gid","name","ranking");
        List<Document> result = mongoTemplate.find(query,Document.class,"game");
        return result;

    }
    
    public List<Document> getSpecificGame(int id){
        Criteria criteria = Criteria.where("gid").is(id);
        Query query = new Query(criteria).limit(1);
        List<Document> result = mongoTemplate.find(query, Document.class,"game");
        return result;
    }
}