package "com.example.foo"

import java.util.List;

public class Question {
  
    private String type;
  
    private String text;
  
    private List<Answer> answers;
  
  public static Question unmarshal(JSONObject object) {
  
    
      String type = object.getString("type");
    
  
    
      String text = object.getString("text");
    
  
    
       List<Answer> answers = new List<Answer>();
       for(JSONObject answersObject : object.getJSONArray("answers")) {
         answers.add(Answer.unmarshal(answersObject));
       }
    
  
    return new Question(type, text, answers);
  }

  public JSONObject toJSONObject() {
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
