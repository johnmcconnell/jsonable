package "com.example.foo"

import java.util.List;

public class Quiz {
  
    private Integer id;
  
    private String subject;
  
    private String level;
  
    private String topic;
  
    private Question questions;
  
  public static unmarshal(JSONObject object) {
  
    Integer id = object.getInteger("id");
  
    String subject = object.getString("subject");
  
    String level = object.getString("level");
  
    String topic = object.getString("topic");
  
    Question questions = object.getQuestion("questions");
  
    return new Quiz(id, subject, level, topic, questions);
  }

  public toJSONObject() {
    JSONObject object = new JSONObject();
  
    object.setInteger("id");
  
    object.setString("subject");
  
    object.setString("level");
  
    object.setString("topic");
  
    object.setQuestion("questions");
  
    return object;
  }

  public Quiz(Integer id, String subject, String level, String topic, Question questions){
  
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
  
  public Question getQuestions() {
    return questions;
  }
  
}
