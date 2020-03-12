import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Mario de Leon
 * @author Jose Ramos
 *
 */
public class MainMaps {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//tenemos aca el codigo para poder
		//hacerle el profile al codigo y medir el tiempo
		long startTime = System.nanoTime();
	
		System.out.println("***Cards***");
		String path = (new File("")).getAbsolutePath()+File.separator+"cards_desc.txt";
		
		
		
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	    FileWriter fichero  = null;
		PrintWriter pw = null;
		
		
	    
	    
	    Scanner eleccion1 = new Scanner(System.in);
	    System.out.println("Que hacer? \n1.Agregar Carta \n2.Ver carta \n3.Mostrar todas las cartas \n4.Mostrar estadisticas de las cartas (cantidad de cartas de cada tipo)");
	    String eleccion1A = eleccion1.nextLine();
	    
	    /**
	     * Agregar carta
	     * Creemos un arraylist temporal para usar .contains() y evitar nombres repetidos
	     */
	    if(eleccion1A.equals("1")) {
	    	ArrayList<String> tipos = new ArrayList<String>();
	    	tipos.add("Hechizo");
	    	tipos.add("Monstruo");
	    	tipos.add("Trampa");
	    	
	    	ArrayList<String> nombres = new ArrayList<String>();
	    	
			try
				{
				    String filename= "cards_desc.txt";
				    
				    String linea = "";
		
					archivo = new File (path);
			        fr = new FileReader (archivo);
			        br = new BufferedReader(fr);
			        
			        String linea1;
			         while((linea1=br.readLine())!=null)
			         {
			        	//System.out.println(linea);
			        	String[] partes = linea1.split("\\|",2);
			        	if(partes.length >= 2) {
			        		String k = partes[0];
			        		String v = partes[1];
			        		
			        		nombres.add(k);
			        	}
			         }
			         
			         Scanner nombre = new Scanner(System.in);
			         System.out.println("Nombre: ");
			         String nombre1 = nombre.nextLine();
			         
			         if (nombres.contains(nombre1)) {
			        	 System.out.println("Carta ya existe en el deck.");
			         }else {
			        	Scanner tipo = new Scanner(System.in);
						System.out.println("Tipo: ");
						String tipo1 = tipo.nextLine();
						if(!tipos.contains(tipo1)) {
							System.out.println("Tipo de carta no valido.");
						}else {
							linea = nombre1+"|"+tipo1;
							FileWriter fw = new FileWriter(filename,true); //the true will append the new data
						    fw.write("\n"+linea+"\n");//appends the string to the file
						    fw.close();
						    System.out.println("Nueva carta agregada!");
						}
			         }
			         
			        
				}
				catch(IOException ioe)
				{
				    System.out.println("Archivo no encontrado!");
				}
		
	    }
	    
	    /**
	     * Ver una carta
	     */
	    else if(eleccion1A.equals("2")) {
	    	System.out.println("***Tipo de una carta***");
	    	Scanner s = new Scanner(System.in);
	    	System.out.println("Nombre de la carta: ");
	    	String nombre1 = s.nextLine();
	    	
	    	/**
	    	 * Armemos un mapa temporal para  utilizar .get()
	    	 */
	    	HashMap<String, String> map = new HashMap<String,String>();
		    try {
		         // Apertura del fichero y creacion de BufferedReader para poder
		         // hacer una lectura comoda (disponer del metodo readLine()).
		         archivo = new File (path);
		         fr = new FileReader (archivo);
		         br = new BufferedReader(fr);
		         
		         String linea;
		         while((linea=br.readLine())!=null)
		         {
		        	//System.out.println(linea);
		        	String[] partes = linea.split("\\|",2);
		        	if(partes.length >= 2) {
		        		String k = partes[0];
		        		String v = partes[1];
		        		
		        		map.put(k, v);
		        	}else {
		        		System.out.println("");;
		        	}	
		         }
	      
		    }catch(Exception e){
		    	System.out.println("Hubo un error!");
		         
		         
		      }finally{
		         // En el finally cerramos el fichero, para asegurarnos
		         // que se cierra tanto si todo va bien como si salta 
		         // una excepcion.
		         try{                    
		            if( null != fr ){   
		               fr.close();     
		            }                  
		         }catch (Exception e2){ 
		        	 System.out.println("Hubo un error!");
		         }
		      }
	    	
		    String tipo_carta = map.get(nombre1);
		    
		    if(tipo_carta!=null) {
		    	System.out.println("Tipo de la carta " + nombre1 + " es " + tipo_carta);
		    	System.out.println("Cantidad de esta carta en la coleccion: 1");
		    }else {
		    	System.out.println("Carta no encontrada en el deck.");
		    }
	    	
	    }
	    
	    
	    
	    /**
	     * Ver baraja completa
	     */
	    else if(eleccion1A.equals("3")) {
	    	
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Metodo para proseguir: \n1.HashMap \n2.TreeMap \n3.LinkedHashMap");
	    String tipoMapa = scanner.nextLine();
	    
	    
	    
	    /**
	     * Ver baraja completa usando HashMap
	     */
	    if(tipoMapa.equals("1")) {
	    	
	    	Scanner por_tipo = new Scanner(System.in);
	    	System.out.println("Por tipo? s/n ");
	    	String por_tipo1 = por_tipo.nextLine();
	    	
	    	HashMap<String, String> map = new HashMap<String,String>();
	    	
	    	
	    	if(por_tipo1.equals("s")) {
	    		
	    		try {
			         // Apertura del fichero y creacion de BufferedReader para poder
			         // hacer una lectura comoda (disponer del metodo readLine()).
			         archivo = new File (path);
			         fr = new FileReader (archivo);
			         br = new BufferedReader(fr);
			         
			         String linea;
			         while((linea=br.readLine())!=null)
			         {
			        	//System.out.println(linea);
			        	String[] partes = linea.split("\\|",2);
			        	if(partes.length >= 2) {
			        		String k = partes[0];
			        		String v = partes[1];
			        		
			        		map.put(k, v);			        		
			        		
			        	}else {
			        		System.out.println("Linea ignorada: " + linea);
			        	}	
			         }
				
				List<Entry<String,String>> sort = new LinkedList<Entry<String,String>>(map.entrySet());

		        		Collections.sort(sort, new Comparator<Entry<String,String>>() {
							@Override
							public int compare(Entry<String, String> o1, Entry<String, String> o2) {
								// TODO Auto-generated method stub
								return o1.getValue().compareTo(o2.getValue());
							}
						});
		        		
		        		for (Entry<String,String> item: sort) {
		        			System.out.println(item);
		        		}
			         
			         
			         
			    }catch(Exception e){
			    	System.out.println("Hubo un error!");
			         
			         
			      }finally{
			         // En el finally cerramos el fichero, para asegurarnos
			         // que se cierra tanto si todo va bien como si salta 
			         // una excepcion.
			         try{                    
			            if( null != fr ){   
			               fr.close();     
			            }                  
			         }catch (Exception e2){ 
			        	 System.out.println("Hubo un error!");
			         }
			      }
	    		    		
	    	}else if(por_tipo1.equals("n")) {
			    
			    try {
			         // Apertura del fichero y creacion de BufferedReader para poder
			         // hacer una lectura comoda (disponer del metodo readLine()).
			         archivo = new File (path);
			         fr = new FileReader (archivo);
			         br = new BufferedReader(fr);
			         
			         String linea;
			         while((linea=br.readLine())!=null)
			         {
			        	//System.out.println(linea);
			        	String[] partes = linea.split("\\|",2);
			        	if(partes.length >= 2) {
			        		String k = partes[0];
			        		String v = partes[1];
			        		
			        		map.put(k, v);
			        	}else {
			        		System.out.println("Linea ignorada: " + linea);
			        	}	
			         }
			         //Regresa las keys con un set de valores
			         for (String key : map.keySet())
			         {
			             System.out.println(key + ":" + map.get(key));
			         }
		      
			    }catch(Exception e){
			         e.printStackTrace();
			         
			         
			      }finally{
			         // En el finally cerramos el fichero, para asegurarnos
			         // que se cierra tanto si todo va bien como si salta 
			         // una excepcion.
			         try{                    
			            if( null != fr ){   
			               fr.close();     
			            }                  
			         }catch (Exception e2){ 
			        	 System.out.println("Hubo un error!");
			         }
			      }
		
	    	}else {
	    		System.out.println("Opcion no valida.");
	    	}
		    
		    /**
		     * Ver baraja completa usando TreeMap
		     */
		    }else if (tipoMapa.equals("2")){
		    	
		    	TreeMap<String, String> map = new TreeMap<String, String>();
		    	
		    	Scanner por_tipo = new Scanner(System.in);
		    	System.out.println("Por tipo? s/n ");
		    	String por_tipo1 = por_tipo.nextLine();
		    	
		    	if(por_tipo1.equals("s")) {
		    		try {
				         // Apertura del fichero y creacion de BufferedReader para poder
				         // hacer una lectura comoda (disponer del metodo readLine()).
				         archivo = new File (path);
				         fr = new FileReader (archivo);
				         br = new BufferedReader(fr);
				         
				         String linea;
				         while((linea=br.readLine())!=null)
				         {
				        	//System.out.println(linea);
				        	String[] partes = linea.split("\\|",2);
				        	if(partes.length >= 2) {
				        		String k = partes[0];
				        		String v = partes[1];
				        		
				        		map.put(k, v);
				        		
						}else {
				        		System.out.println("Linea ignorada: " + linea);
				        	}	
				         }
				         
					List<Entry<String,String>> sort = new LinkedList<Entry<String,String>>(map.entrySet());

		        		Collections.sort(sort, new Comparator<Entry<String,String>>() {
							@Override
							public int compare(Entry<String, String> o1, Entry<String, String> o2) {
								// TODO Auto-generated method stub
								return o1.getValue().compareTo(o2.getValue());
							}
						});
		        		
		        		for (Entry<String,String> item: sort) {
		        			System.out.println(item);
		        		}
				         
				         
				    }catch(Exception e){
				    	System.out.println("Hubo un error!");
				         
				         
				      }finally{
				         // En el finally cerramos el fichero, para asegurarnos
				         // que se cierra tanto si todo va bien como si salta 
				         // una excepcion.
				         try{                    
				            if( null != fr ){   
				               fr.close();     
				            }                  
				         }catch (Exception e2){ 
				        	 System.out.println("Hubo un error!");
				         }
				      }
		    		
		    	}else if(por_tipo1.equals("n")) {
		    	
				    try {
				         // Apertura del fichero y creacion de BufferedReader para poder
				         // hacer una lectura comoda (disponer del metodo readLine()).
				         archivo = new File (path);
				         fr = new FileReader (archivo);
				         br = new BufferedReader(fr);
				         
				         String linea;
				         while((linea=br.readLine())!=null)
				         {
				        	//System.out.println(linea);
				        	String[] partes = linea.split("\\|",2);
				        	if(partes.length >= 2) {
				        		String k = partes[0];
				        		String v = partes[1];
				        		
				        		map.put(k, v);
				        	}else {
				        		System.out.println("Linea ignorada: " + linea);
				        	}	
				         }
				         //Regresa las keys con un set de valores
				         for (String key : map.keySet())
				         {
				             System.out.println(key + ":" + map.get(key));
				         }
			      
				    }catch(Exception e){
				    	System.out.println("Hubo un error!");
				         
				         
				      }finally{
				         // En el finally cerramos el fichero, para asegurarnos
				         // que se cierra tanto si todo va bien como si salta 
				         // una excepcion.
				         try{                    
				            if( null != fr ){   
				               fr.close();     
				            }                  
				         }catch (Exception e2){ 
				        	 System.out.println("Hubo un error!");
				         }
			    	
				      }
		    	}else {
		    		System.out.println("Opcion no valida.");
		    	}
			    
			    /**
			     * Ver baraja completa usando LinkedHashMap
			     */
		    }else if(tipoMapa.equals("3")) {
		    	LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		    	
		    	
		    	Scanner por_tipo = new Scanner(System.in);
		    	System.out.println("Por tipo? s/n ");
		    	String por_tipo1 = por_tipo.nextLine();
		    	
		    	if(por_tipo1.equals("s")) {
		    		try {
				         // Apertura del fichero y creacion de BufferedReader para poder
				         // hacer una lectura comoda (disponer del metodo readLine()).
				         archivo = new File (path);
				         fr = new FileReader (archivo);
				         br = new BufferedReader(fr);
				         
				         String linea;
				         while((linea=br.readLine())!=null)
				         {
				        	//System.out.println(linea);
				        	String[] partes = linea.split("\\|",2);
				        	if(partes.length >= 2) {
				        		String k = partes[0];
				        		String v = partes[1];
				        		
				        		map.put(k, v);
			
				        	}else {
				        		System.out.println("Linea ignorada: " + linea);
				        	}	
				         }
				         	
					List<Entry<String,String>> sort = new LinkedList<Entry<String,String>>(map.entrySet());

		        		Collections.sort(sort, new Comparator<Entry<String,String>>() {
							@Override
							public int compare(Entry<String, String> o1, Entry<String, String> o2) {
								// TODO Auto-generated method stub
								return o1.getValue().compareTo(o2.getValue());
							}
						});
		        		
		        		for (Entry<String,String> item: sort) {
		        			System.out.println(item);
		        		}
					
				    }catch(Exception e){
				    	System.out.println("Hubo un error!");
				         
				         
				      }finally{
				         // En el finally cerramos el fichero, para asegurarnos
				         // que se cierra tanto si todo va bien como si salta 
				         // una excepcion.
				         try{                    
				            if( null != fr ){   
				               fr.close();     
				            }                  
				         }catch (Exception e2){ 
				        	 System.out.println("Hubo un error!");
				         }
				      }
		    	}else if(por_tipo1.equals("n")) {
				    try {
				         // Apertura del fichero y creacion de BufferedReader para poder
				         // hacer una lectura comoda (disponer del metodo readLine()).
				         archivo = new File (path);
				         fr = new FileReader (archivo);
				         br = new BufferedReader(fr);
				         
				         String linea;
				         while((linea=br.readLine())!=null)
				         {
				        	//System.out.println(linea);
				        	String[] partes = linea.split("\\|",2);
				        	if(partes.length >= 2) {
				        		String k = partes[0];
				        		String v = partes[1];
				        		
				        		map.put(k, v);
				        	}else {
				        		System.out.println("Linea ignorada: " + linea);
				        	}	
				         }
				         //Regresa las keys con un set de valores
				         for (String key : map.keySet())
				         {
				             System.out.println(key + ":" + map.get(key));
				         }
			      
				    }catch(Exception e){
				    	System.out.println("Hubo un error!");
				         
				         
				      }finally{
				         // En el finally cerramos el fichero, para asegurarnos
				         // que se cierra tanto si todo va bien como si salta 
				         // una excepcion.
				         try{                    
				            if( null != fr ){   
				               fr.close();     
				            }                  
				         }catch (Exception e2){ 
				        	 System.out.println("Hubo un error!");
				         }
			    	
				      }
	
			    	}else {
			    		System.out.println("Opcion no valida.");
			    	}
		    }else{
		    	System.out.println("Opcion no valida.");
		    }
	    
	    /**
	     * Estadisticas: Cantidad de cada tipo
	     */
	    }else if(eleccion1A.equals("4")) {
	    	
	    	/**
	    	 * Armemos listas temporals para  utilizar .size()
	    	 */
	    	
	    	HashMap<String, String> map = new HashMap<String,String>();
	    	ArrayList<String> monstruo = new ArrayList<String>();
	    	ArrayList<String> trampa = new ArrayList<String>();
	    	ArrayList<String> hechizo = new ArrayList<String>();
		    try {
		         // Apertura del fichero y creacion de BufferedReader para poder
		         // hacer una lectura comoda (disponer del metodo readLine()).
		         archivo = new File (path);
		         fr = new FileReader (archivo);
		         br = new BufferedReader(fr);
		         
		         String linea;
		         while((linea=br.readLine())!=null)
		         {
		        	//System.out.println(linea);
		        	String[] partes = linea.split("\\|",2);
		        	if(partes.length >= 2) {
		        		String k = partes[0];
		        		String v = partes[1];
		        		
		        		if(v.equals("Trampa")) {
		        			trampa.add(v);
		        		}else if(v.equals("Monstruo")) {
		        			monstruo.add(v);		        			
		        		}else if(v.equals("Hechizo")) {
		        			hechizo.add(v);
		        		}
		        	}else {
		        		System.out.println("");;
		        	}	
		         }
	      
		    }catch(Exception e){
		    	System.out.println("Hubo un error!");      
		      }finally{
		         // En el finally cerramos el fichero, para asegurarnos
		         // que se cierra tanto si todo va bien como si salta 
		         // una excepcion.
		         try{                    
		            if( null != fr ){   
		               fr.close();     
		            }                  
		         }catch (Exception e2){ 
		        	 System.out.println("Hubo un error!");
		         }
		      }
		    	
		    System.out.println("Cantidad de cartas tipo Trampa: "+trampa.size());
		    System.out.println("Cantidad de cartas tipo Monstruo: "+monstruo.size());
		    System.out.println("Cantidad de cartas tipo Hechizo: "+hechizo.size());
	    	 	
	    }else {
	    	System.out.println("Opcion no valida.");
	    }

		long endTime = System.nanoTime();
		
		//Diferencia en Ns
		long timeElapsed = endTime - startTime;
		
		System.out.println("Tiempo de ejecucion en nanosegundos  : " + timeElapsed);
	}
}
