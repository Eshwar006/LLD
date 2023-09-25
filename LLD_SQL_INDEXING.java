class ColumnDataType{
	String dataType;

	public ColumnDataType(String dataType){
		this.dataType = dataType;
	}

	public void validate(Object val){
		if(instanceof(val) != dataType)
			// Raise exception
	}
}


class IntDataType {
	
}