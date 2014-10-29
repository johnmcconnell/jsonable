class Model
  attr_reader :name, :fields

  def self.unmarshal(json_model)
    params = json_model.inject({}) do |params, (key, value)|
      params[key.to_sym] = value
      params
    end
    new(params)
  end

  def initialize(params)
    @name = params[:name]
    @fields = params[:fields]
  end
end
