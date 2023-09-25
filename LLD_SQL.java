class Row{
	String rowId;
	Date createdAt;
	Date updatedAt;
	Map<String, String> columnValuesMap;

	public Row(String rowId, HashMap<String, String> map, Date createdAt, Date updatedAt){
		this.createdAt = createdAt;
		this.updateAt = updatedAt;
		this.rowId = rowId;
		this.columnValuesMap = map;
	}

	// All getters and setters
	public Map<String, String> getColumnValuesMap(){
		return this.columnValuesMap;
	}

	public void setUpdatedAt(Date d){
		this.updatedAt = d;
	}
}


class Table{
	String tableName;
	HashMap<String, Row> rows;
	Date createdAt;

	public Table(String tableName){
		this.tableName = tableName;
		this.rows = new HashMap<>();
		this.createdAt = new Date();
	}

	public void insertEntry(String rowId, Map<String, String> columnValues){
		if(rows.contains(rowId)){
			// "Duplicate primary Key"
		} else{
			Row row = new Row(rowId, columnValues, new Date(), new Date());
			this.rows.put(rowId, row);
		}
	}

	public void deleteEntry(String rowId){
		rows.remove(rowId);
	}

	public HashMap<String, String> getRow(String rowId){
		return row.get(rowId).getColumnValuesMap();
	}

	public void updateEntry(String rowId, Map<String, String> values){
		Row row = rows.get(rowId);
		values.forEach( (k,v) -> {
			row.getColumnValuesMap().put(k, v);
		});
		row.setUpdateAt(new Date());
	}

	public List<Map<String, String> getAll(){
		List<Map<String, String>> result = new HashMap<>();
		rows.forEach( (k, v) -> {
			result.add(v.getColumnValuesMap());
		});
		return result;
	}
}


class Database{
	String name;
	Map<String, Table> tablesMap;
	Date createdAt;

	public Database(String name){
		this.name = name;
		tablesMap = new HashMap<>();
		this.createdAt = new Date();
	}

	public Table createTable(String tableName){
		if(tablesMap.contains(tableName)){
			// Raise execption
			return;
		}
		Table table = new Table(tableName);
		tablesMap.put(tableName, table);
		return table;
	}

	public void dropTable(String tableName){
		tablesMap.remove(tableName);
	}

	// All setters and getters
}



