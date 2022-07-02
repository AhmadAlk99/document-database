package Doa;

public interface AdminDao {

    public boolean addUser(String name, String password);

    public boolean removeUser(String name);

    public boolean addDataBase(String dataBaseName);

    public boolean deleteDataBase(String dataBaseName);

    public boolean addSchema(String dataBaseName , String schemaName);

    public boolean deleteSchema(String dataBaseName , String schemaName);

    public boolean addSchemaJson(String dataBaseName , String schemaName,String schemaJson);

    public boolean addDocument(String dataBaseName, String schemaName,String jsonObj);

    public boolean deleteDocument(String path1,String SchemaName,int id);

    public boolean  addIndex(String path1,String SchemaName,String index);


}
