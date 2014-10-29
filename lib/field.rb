class Field
  attr_reader :name, :type

  def initialize(params)
    @name = params[:name]
    @type = params[:type]
  end

  def array?
    type =~ /^Array\[.*\]$/
  end
end
