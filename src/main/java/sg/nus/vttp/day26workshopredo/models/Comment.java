package sg.nus.vttp.day26workshopredo.models;

import jakarta.json.JsonObject;

public class Comment {

    private String c_id;
    private String user;
    private int rating;
    private String c_text;
    private int gid;

    public static Comment fromJson(JsonObject jsonObject){
        Comment comment = new Comment();
        String c_id = jsonObject.getString("c_id");
        String user = jsonObject.getString("user");
        int rating = jsonObject.getInt("rating");
        String c_text = jsonObject.getString("c_text");
        int gid = jsonObject.getInt("gid");
        comment.setC_id(c_id);
        comment.setUser(user);
        comment.setRating(rating);
        comment.setC_text(c_text);
        comment.setGid(gid);
        return comment;
    }


    public String getC_id() {
        return c_id;
    }
    public void setC_id(String c_id) {
        this.c_id = c_id;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getC_text() {
        return c_text;
    }
    public void setC_text(String c_text) {
        this.c_text = c_text;
    }
    public int getGid() {
        return gid;
    }
    public void setGid(int gid) {
        this.gid = gid;
    }
    
}
