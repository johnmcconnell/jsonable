package com.bareknucklecoding.plato.json_models;

import java.util.List;
import java.util.ArrayList;

import org.json.JSONObject;
import org.json.JSONException;

public class Question {
  
    private String type;
  
    private String text;
  
    private List<Answer> answers;
  
  public static Question unmarshal(JSONObject object) throws JSONException {
  
    
      String type = object.getString("type");
    
  
    
      String text = object.getString("text");
    
  
    
       List<Answer> answers = new ArrayList<Answer>();
       for(int x = 0; x < object.getJSONArray("answers").length(); x++) {
       JSONObject answersObject = object.getJSONArray("answers")
         .getJSONObject(x);
         answers.add(Answer.unmarshal(answersObject));
       }
    
  
    return new Question(type, text, answers);
  }

  public JSONObject toJSONObject() throws JSONException {
    JSONObject object = new JSONObject();
  
    object.put("type", type);
  
    object.put("text", text);
  
    JSONArray answersArray = new JSONArray();
    for (Answer answer : answers) {
      answersArray.put(answer.toJSONObject());
    }
    object.put("answers", answersArray);
  
    return object;
  }

  public Question(String type, String text, List<Answer> answers){
  
    this.type = type;
  
    this.text = text;
  
    this.answers = answers;
  
  }

  
  public String getType() {
    return type;
  }
  
  public String getText() {
    return text;
  }
  
  public List<Answer> getAnswers() {
    return answers;
  }
  
}
