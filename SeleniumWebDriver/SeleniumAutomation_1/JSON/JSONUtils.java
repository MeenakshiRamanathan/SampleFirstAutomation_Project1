package JSON;

import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

public class JSONUtils {
 
  public List<HashMap<String,String>> getJsonDataToMap(String filePath)
  {
	  
	  
	  FileUtils.readFileToString(new file(filePath)
, StandardCharsets.UTF_8);
	  
   
     ObjectMapper mapper=new ObjectMapper();
     
     List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>() { });   
     return data;
}
  }


