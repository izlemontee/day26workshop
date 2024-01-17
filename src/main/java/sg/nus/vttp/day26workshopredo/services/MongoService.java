package sg.nus.vttp.day26workshopredo.services;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.json.JsonObject;
import sg.nus.vttp.day26workshopredo.models.Game;
import sg.nus.vttp.day26workshopredo.repositories.MongoRepo;

@Service
public class MongoService {
    
    @Autowired
    MongoRepo mongoRepo;

    public List<JsonObject> getAllGames(int offset, int limit){
        List<Document> result = mongoRepo.getAllGames(offset, limit);
        List<JsonObject> gamesList = new ArrayList<>();
        System.out.println("reach here");
        for(Document document:result){
            Game game = Game.create(document);
            System.out.println("name: "+game.getName());
            System.out.println("gid: "+game.getGid());
            JsonObject gameObject = game.toJson();
            gamesList.add(gameObject);
        }
        return gamesList;
    }

    public List<JsonObject> getAllGamesRanked(int offset, int limit){
        List<Document> result = mongoRepo.getGamesRanked(offset, limit);
        List<JsonObject> gamesList = new ArrayList<>();
        for(Document document:result){
            Game game = Game.create(document);
            JsonObject gameObject = game.toJson();
            gamesList.add(gameObject);
        }
        return gamesList;
    }

    public List<JsonObject> getSpecificGame(int id){
        List<Document> result = mongoRepo.getSpecificGame(id);
        List<JsonObject> gamesList = new ArrayList<>();
        for(Document document:result){
            Game game = Game.createFull(document);
            JsonObject gameObject = game.toJsonFull();
            gamesList.add(gameObject);
        }
        return gamesList;
    }
    
}
