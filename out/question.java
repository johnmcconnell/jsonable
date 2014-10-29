package "com.example.foo"

import java.util.List;

public class Question {
  
    private String type;
  
    private String text;
  
    private List<Answer> answers;
  
  public static unmarshal(JSONObject object) {
  
    String type = object.getString("type");
  
    String text = object.getString("text");
  
    List<Answer> answers = object.getList<Answer>("answers");
  
    return new Question(type, text, answers);
  }

  public toJSONObject() {
    JSONObject object = new JSONObject();
  
    object.setString("type");
  
    object.setString("text");
  
    object.setList<Answer>("answers");
  
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
