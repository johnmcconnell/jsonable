require_relative 'model'

class JSONableConfig
  attr_reader :models

  def self.unmarshal(json_config)
    params = json_config.inject({}) do |params, (key, value)|
      params[key.to_sym] = value
      params
    end
    params[:models].map! do |json_model|
      Model.unmarshal(json_model)
    end
    new(params)
  end

  def initialize(params)
    @models = params[:models]
  end
end
