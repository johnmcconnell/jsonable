package "com.example.foo"

import java.util.List;

public class Answer {
  
    private String text;
  
    private Boolean valid;
  
  public static unmarshal(JSONObject object) {
  
    
      String text = object.getString("text");
    
  
    
      Boolean valid = object.getBoolean("valid");
    
  
    return new Answer(text, valid);
  }

  public toJSONObject() {
    JSONObject object = new JSONObject();
  
    object.put("text", text)
  
    object.put("valid", valid)
  
    return object;
  }

  public Answer(String text, Boolean valid){
  
    this.text = text;
  
    this.valid = valid;
  
  }

  
  public String getText() {
    return text;
  }
  
  public Boolean getValid() {
    return valid;
  }
  
}
