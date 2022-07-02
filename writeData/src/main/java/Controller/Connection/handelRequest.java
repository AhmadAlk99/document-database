package Controller.Connection;

import Doa.DaoImp.AdminImp;

public class handelRequest {
    private AdminImp admin;

    public handelRequest(AdminImp admin){
        this.admin=admin;
    }

    public boolean handelDataBase(String [] reads){
        if(reads[0].equals("add")){
            return admin.addDataBase(reads[1]);
        }
        else {
            return admin.deleteDataBase(reads[1]);
        }
    }

    public boolean handelSchema(String [] reads){
        if(reads[0].equals("add")){
            return admin.addSchema(reads[1],reads[2]);
        }
        else {
            return admin.deleteSchema(reads[1],reads[2]);
        }
    }

    public boolean handelSchemaJson(String [] reads,String JsonSchema) {
        if (reads[0].equals("add")) {
            return admin.addSchemaJson(reads[1], reads[2], JsonSchema);
        }
        return false;
    }

    public boolean handelDocument(String [] reads,String document){
        if(reads[0].equals("add")){
            return admin.addDocument(reads[1],reads[2],document);
        }
        else {
            int id=Integer.parseInt(reads[3]);
            if(id>=0){
                return admin.deleteDocument(reads[1], reads[2], id);
            }
        }
        return false;
    }
    public boolean handelIndex(String [] reads){
        if(reads[0].equals("add")){

            return admin.addIndex(reads[1],reads[2],reads[3]);
        }
        return false;
    }
}
