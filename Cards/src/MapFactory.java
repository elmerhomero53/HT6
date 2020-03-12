/**
 * @author Usuario Dell
 *
 */
public class MapFactory<K,V> {
	public Map<String, String> getMap(String tipoMapa){
		if(tipoMapa == null){
	         return null;
	      }		
	      if(tipoMapa.equalsIgnoreCase("HashMap")){
	         return new HashMap<String, String>();
	         
	      } else if(tipoMapa.equalsIgnoreCase("TreeMap")){
	         return new TreeMap<String,String>();
	         
	      } else if(tipoMapa.equalsIgnoreCase("LinkedHashMap")){
	         return new LinkedHashMap<String, String>();
	      }
	      
	      return null;
	 }
}

