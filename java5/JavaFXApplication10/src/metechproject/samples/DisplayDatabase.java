package metechproject.samples;

/**
 *
 * @author rmill_000
 */
 import java.sql.Connection;  
 import java.sql.ResultSet;  
 import javafx.beans.property.SimpleStringProperty;  
 import javafx.beans.value.ObservableValue;  
 import javafx.collections.FXCollections;  
 import javafx.collections.ObservableList;  
 import javafx.scene.control.TableColumn;  
 import javafx.scene.control.TableColumn.CellDataFeatures;  
 import javafx.scene.control.TableView;  
 import javafx.util.Callback;    
 public class DisplayDatabase{ 
   private static ObservableList<ObservableList> data;
   public static void buildData(TableView tableview){  
      Connection c ;  
      data = FXCollections.observableArrayList();  
      try{  
       c = DBConnection.connect();  
       String SQL = "SELECT * from lottotest"; 
       ResultSet rs = c.createStatement().executeQuery(SQL);
       for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){   
         final int j = i;          
         TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));  
         col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){            
           public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                 
             return new SimpleStringProperty(param.getValue().get(j).toString());              
           }            
         });  
         tableview.getColumns().addAll(col);  
       }  
       while(rs.next()){ 
         ObservableList<String> row = FXCollections.observableArrayList();  
         for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){ 
           row.add(rs.getString(i));  
         }  
         data.add(row);  
       }  
       tableview.setItems(data);  
      }catch(Exception e){  
        e.printStackTrace();  
        System.out.println("Error on Building Data");        
      }  
    }  
 }  
