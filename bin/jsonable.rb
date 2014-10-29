#!/usr/bin/env ruby

require 'jsonable'
require 'optparse'

options = { output: '.' }

OptionParser.new do |opts|
  opts.banner = "Usage: jsonable [config-file]"

  opts.on("-o", "--out", "output directory") do |path|
    options[:output] = path
  end
end.parse!

config_path = ARGV.shift
puts "using config in '#{config_path}'..."

config = JSONable.parse_config(File.read(config_path))
puts "found '#{config.models.size}' models in config..."

models = JSONable.build_models(config)
puts "created '#{models.size}' models..."

JSONable.create_source for: models, into: options[:output]
