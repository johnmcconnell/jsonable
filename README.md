# Jsonable

JSONable takes in json schema describing a model
For example:
```
{
  "model" : "Car",
  "fields" : {
    "color" : {
      "type" :"String"
    },
    "manufacturer" : {
      "reference_to" : "CarCompany"
    },
    "wheels" : {
      "references_to" : "Wheel"
    }
  }
}
```

will produce the following Java code:

```
import java.util.List;
import java.util.ArrayList;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

public class JSONCar {
    private String color;
    private CarCompany manufacturer;
    private List<Wheel> wheels;
    public JSONCar unmarshal(JSONObject object) throws JSONException {
      String color = object.getString("color");
      CarCompany manufacturer = new
        CarCompany().unmarshal(object.getJSONObject(manufacturer));
      List<Wheel> wheels = new ArrayList<Wheel>();
      for(int x = 0; x < object.getJSONArray("wheels").length(); x++) {
        JSONObject wheelsObject = object.getJSONArray("wheels")
          .getJSONObject(x);
        wheels.add(new Wheel().unmarshal(wheelsObject));
      }
      return new JSONCar(color, manufacturer, wheels);
    }

    public JSONObject toJSONObject() throws JSONException {
      JSONObject object = new JSONObject();
      object.put("color", color);
      object.put("manufacturer", manufacturer.toJSONObject());
      JSONArray wheelsArray = new JSONArray();
      for (Wheel wheel : wheels) {
        wheelsArray.put(wheel.toJSONObject());
      }
      object.put("wheels", wheelsArray);
      return object;
    }

  public JSONCar(){
  }

  public JSONCar(String color, CarCompany manufacturer, List<Wheel> wheels){
    this.color = color;
    this.manufacturer = manufacturer;
    this.wheels = wheels;
  }

  public String getColor() {
    return color;
  }

  public CarCompany getManufacturer() {
    return manufacturer;
  }

  public List<Wheel> getWheels() {
    return wheels;
  }
}

```

Kind of cuts down on your code writing

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'jsonable'
```

And then execute:

    $ bundle

Or install it yourself as:

    $ gem install jsonable

## Usage

TODO: Write usage instructions here

## Contributing

1. Fork it ( https://github.com/[my-github-username]/jsonable/fork )
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Add some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create a new Pull Request
=======
jsonable
========

JSON serializer and deserializer code generator using ERB.
