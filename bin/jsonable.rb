#!/usr/bin/env ruby

require 'jsonable'
require 'optparse'

options = { output: '.' }

OptionParser.new do |opts|
  opts.banner = "Usage: jsonable [config-file]"

  opts.on("-o PATH", "--out PATH", "output directory") do |path|
    options[:output] = path
  end
end.parse!

schema_dir = ARGV.shift
puts "using schemas in '#{schema_dir}'..."

schema_paths = Dir["#{schema_dir}/*.json"]
schemas = JSONable.parse_schemas(schema_paths)
puts "found '#{schemas.size}' schemas..."

models = JSONable.build_models(schemas)
puts "created '#{models.size}' models..."

JSONable.create_source models: models, into: options[:output]
