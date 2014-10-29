require 'erb'

class JavaBuilder
  def render(model)
    @model = model
    template = File.read(File.join('templates', 'java.erb'))
    ERB.new(template).result get_binding
  end

  def class_name(model)
    camel_case model.name
  end

  def constructor_call_args(fields)
    fields.map { |f| field_name f }.join(', ')
  end
  def json_field_call_setter(field)
    "set#{field_type field}(\"#{field_name field}\")"
  end

  def json_field_call_getter(field)
    "get#{field_type field}(\"#{field_name field}\")"
  end

  def constructor_declaration_args(fields)
    fields.map { |field| field_def field }.join(', ')
  end

  def constructor_set(field)
    "this.#{field_name field} = #{field_name field};"
  end

  def field_def(field)
    "#{field_type field} #{field_name field}"
  end

  def field_name(field)
    camel_back field.name
  end

  def field_type(field)
    java_type(field.type)
  end

  def java_type(type_name)
    if type_name =~ /^Array\[.*\]$/
      name = /^Array\[(.*)\]$/.match(type_name)[1]
      "List<#{java_type name}>"
    else
      camel_case type_name
    end
  end

  def getter_name(name)
    "get#{camel_case name}"
  end

  def camel_case(text)
    return '' if text.nil?
    return text if text =~ /^[A-Z][a-zA-Z]+$/
    word = text.split(/_|\s+/).map { |part| part.capitalize }.join
    fail "invalid '#{word}' for camelcase" unless word =~ /^[A-Z][a-zA-Z]+$/
    word
  end

  def camel_back(text)
    return text if text =~ /^[A-Z][a-zA-Z]+$/
    first, remaining = * text.split(/_|\s+/)
    word = first + Array(remaining).map do |part|
      part.capitalize
    end.join
    fail "invalid '#{word}' for camelback" unless word =~ /^[a-z][a-zA-Z]+$/
    word
  end

  def get_binding()
    binding
  end
end
