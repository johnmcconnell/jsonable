package com.bareknucklecoding.plato.json_models;

import java.util.List;

import org.json.JSONObject;
import org.json.JSONException;

public class Quiz {
  
    private Integer id;
  
    private String subject;
  
    private String level;
  
    private String topic;
  
    private List<Answer> answers;
  
    private List<Question> questions;
  
  public static Quiz unmarshal(JSONObject object) throws JSONException {
  
    
      Integer id = object.getInteger("id");
    
  
    
      String subject = object.getString("subject");
    
  
    
      String level = object.getString("level");
    
  
    
      String topic = object.getString("topic");
    
  
    
       List<Answer> answers = new List<Answer>();
       for(JSONObject answersObject : object.getJSONArray("answers")) {
         answers.add(Answer.unmarshal(answersObject));
       }
    
  
    
       List<Question> questions = new List<Question>();
       for(JSONObject questionsObject : object.getJSONArray("questions")) {
         questions.add(Question.unmarshal(questionsObject));
       }
    
  
    return new Quiz(id, subject, level, topic, answers, questions);
  }

  public JSONObject toJSONObject() throws JSONException {
    JSONObject object = new JSONObject();
  
    object.put("id", id);
  
    object.put("subject", subject);
  
    object.put("level", level);
  
    object.put("topic", topic);
  
    JSONArray answersArray = new JSONArray();
    for (Answer answer : answers) {
      answersArray.put(answer.toJSONObject());
    }
    object.put("answers", answersArray);
  
    JSONArray questionsArray = new JSONArray();
    for (Question question : questions) {
      questionsArray.put(question.toJSONObject());
    }
    object.put("questions", questionsArray);
  
    return object;
  }

  public Quiz(Integer id, String subject, String level, String topic, List<Answer> answers, List<Question> questions){
  
    this.id = id;
  
    this.subject = subject;
  
    this.level = level;
  
    this.topic = topic;
  
    this.answers = answers;
  
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
  
  public List<Answer> getAnswers() {
    return answers;
  }
  
  public List<Question> getQuestions() {
    return questions;
  }
  
}
