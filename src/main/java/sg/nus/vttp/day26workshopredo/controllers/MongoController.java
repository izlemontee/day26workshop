package sg.nus.vttp.day26workshopredo.controllers;

import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.JsonObject;
import sg.nus.vttp.day26workshopredo.models.Game;
import sg.nus.vttp.day26workshopredo.models.Games;
import sg.nus.vttp.day26workshopredo.services.MongoService;

@RestController
public class MongoController {

    @Autowired
    private MongoService mongoService;

    @GetMapping(path = "/games")
    public ResponseEntity<String> getAllGames(@RequestParam(name = "offset",required =false) int offset, 
    @RequestParam(name = "limit" ,required=false) int limit){
        Games games = new Games();
        games.setTimestamp(new Date());
        List<JsonObject> result = mongoService.getAllGames(offset,limit);
        games.setGamesList(result);
        games.setTotal(result.size());
        JsonObject gamesJson = games.toJson();
        ResponseEntity<String> response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
                                            .body(gamesJson.toString())
                                        ;
                                       
        return response;
    }

    @GetMapping(path = "/games/rank")
    public ResponseEntity<String> getGamesRanked(@RequestParam(name = "offset",required =false) int offset, 
    @RequestParam(name = "limit" ,required=false) int limit){
        Games games = new Games();
        games.setTimestamp(new Date());
        List<JsonObject> result = mongoService.getAllGamesRanked(offset,limit);
        games.setGamesList(result);
        games.setTotal(result.size());
        JsonObject gamesJson = games.toJson();
        ResponseEntity<String> response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
                                            .body(gamesJson.toString())
                                        ;
                                       
        return response;
    }

    @GetMapping(path = "/game/{id}")
    public ResponseEntity<String> getSpecificGame(@PathVariable(name = "id") int id){
        List<JsonObject> result = mongoService.getSpecificGame(id);
        JsonObject object = result.get(0);
        ResponseEntity<String> response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
                                            .body(object.toString())
                                        ;
                                       
        return response;
    }
    
}
