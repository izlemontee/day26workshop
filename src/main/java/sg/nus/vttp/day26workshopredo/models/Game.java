package sg.nus.vttp.day26workshopredo.models;

import org.bson.Document;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

public class Game {

    private int gid;
    private String name;
    private int year;
    private int ranking;
    private int users_rated;
    private String url;
    private String image;

    public static Game fromJson(JsonObject jsonObject){
        Game game = new Game();
        int gid = jsonObject.getInt("gid");
        String name = jsonObject.getString("name");
        int year = jsonObject.getInt("year");
        int ranking = jsonObject.getInt("ranking");
        int users_rated = jsonObject.getInt("users_rated");
        String url = jsonObject.getString("url");
        String image = jsonObject.getString("image");
        game.setGid(gid);
        game.setName(name);
        game.setYear(year);
        game.setRanking(ranking);
        game.setUsers_rated(users_rated);
        game.setUrl(url);
        game.setImage(image);
        return game;
    }

    public static Game create(Document document){
        Game game = new Game();
        int gid = document.getInteger("gid");
        String name = document.get("name","name");
    
        // int year = document.getInteger("year");
        //int ranking = document.getInteger("ranking");
        // int users_rated = document.getInteger("users_rated");
        // String url = document.getString("url");
        // String image = document.getString("image");
        game.setGid(gid);
        game.setName(name);
        // game.setYear(year);
        //game.setRanking(ranking);
        // game.setUsers_rated(users_rated);
        // game.setUrl(url);
        // game.setImage(image);
        return game;
    }

    public static Game createFull(Document document){
        Game game = new Game();
        int gid = document.getInteger("gid");
        String name = document.get("name","name");
    
        int year = document.getInteger("year");
        int ranking = document.getInteger("ranking");
        int users_rated = document.getInteger("users_rated");
        String url = document.getString("url");
        String image = document.getString("image");
        game.setGid(gid);
        game.setName(name);
        game.setYear(year);
        game.setRanking(ranking);
        game.setUsers_rated(users_rated);
        game.setUrl(url);
        game.setImage(image);
        return game;
    }

    public JsonObject toJson(){
        JsonObjectBuilder JOB = Json.createObjectBuilder();
        return JOB.add("gid",gid)
            .add("name",name)
            // .add("year",year)
            //.add("ranking",ranking)
            // .add("users_rated",users_rated)
            // .add("url",url)
            // .add("image",image)
            .build();
    }

    public JsonObject toJsonFull(){
        JsonObjectBuilder JOB = Json.createObjectBuilder();
        return JOB.add("gid",gid)
            .add("name",name)
            .add("year",year)
            .add("ranking",ranking)
            .add("users_rated",users_rated)
            .add("url",url)
            .add("image",image)
            .build();
    }



    public int getGid() {
        return gid;
    }
    public void setGid(int gid) {
        this.gid = gid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getRanking() {
        return ranking;
    }
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
    public int getUsers_rated() {
        return users_rated;
    }
    public void setUsers_rated(int users_rated) {
        this.users_rated = users_rated;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    
}
