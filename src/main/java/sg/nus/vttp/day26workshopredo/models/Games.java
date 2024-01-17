package sg.nus.vttp.day26workshopredo.models;

import java.util.Date;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

public class Games {
    private List<JsonObject> gamesList;
    private int limit = 25;
    private int offset = 0;
    private int total;
    private Date timestamp;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getTotal() {
        return gamesList.size();
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public List<JsonObject> getGamesList() {
        return gamesList;
    }

    public void setGamesList(List<JsonObject> gamesList) {
        this.gamesList = gamesList;
    }

  

    public JsonObject toJson(){
        JsonObjectBuilder JOB = Json.createObjectBuilder();
  
        JOB.add("games",gamesList.toString())
            .add("limit",limit)
            .add("offset",offset)
            .add("total",total)
            .add("timestamp",timestamp.toString());
        return JOB.build();
    }
    
}
