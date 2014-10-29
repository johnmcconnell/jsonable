package com.bareknucklecoding.plato.json_models;

import java.util.List;
import java.util.ArrayList;

import org.json.JSONObject;
import org.json.JSONException;

public class Quiz {
  
    private Integer id;
  
    private String subject;
  
    private String level;
  
    private String topic;
  
    private List<Question> questions;
  
  public Quiz unmarshal(JSONObject object) throws JSONException {
  
    
      Integer id = object.getInteger("id");
    
  
    
      String subject = object.getString("subject");
    
  
    
      String level = object.getString("level");
    
  
    
      String topic = object.getString("topic");
    
  
    
       List<Question> questions = new ArrayList<Question>();
       for(int x = 0; x < object.getJSONArray("questions").length(); x++) {
       JSONObject questionsObject = object.getJSONArray("questions")
         .getJSONObject(x);
         questions.add(new List<Question>().unmarshal(questionsObject));
       }
    
  
    return new Quiz(id, subject, level, topic, questions);
  }

  public JSONObject toJSONObject() throws JSONException {
    JSONObject object = new JSONObject();
  
    object.put("id", id);
  
    object.put("subject", subject);
  
    object.put("level", level);
  
    object.put("topic", topic);
  
    JSONArray questionsArray = new JSONArray();
    for (Question question : questions) {
      questionsArray.put(question.toJSONObject());
    }
    object.put("questions", questionsArray);
  
    return object;
  }

  public Quiz(){
  }

  public Quiz(Integer id, String subject, String level, String topic, List<Question> questions){
  
    this.id = id;
  
    this.subject = subject;
  
    this.level = level;
  
    this.topic = topic;
  
    this.questions = questions;
  
  }

  
  public Integer getId() {
    return id;
  }
  
  public String getSubject() {
    return subject;
  }
  
  public String getLevel() {
    return level;
  }
  
  public String getTopic() {
    return topic;
  }
  
  public List<Question> getQuestions() {
    return questions;
  }
  
}
