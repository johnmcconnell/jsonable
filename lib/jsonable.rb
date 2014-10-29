require 'jsonable/version'
require 'json'
require 'jsonable_config'

module JSONable
  def self.parse_config(json_text)
    json_config = JSON.parse(json_text)
    JSONableConfig.unmarshal(json_config)
  end

  def self.build_models(config)
    config.models
  end

  def self.create_source(opts)
    opts[:for]
    opts[:into]
  end
end
