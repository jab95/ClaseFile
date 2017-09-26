import java.io.File;
import java.util.Date;

public class ClaseFile {


	public static void muestraArchivos(File archivo){
		
		if(archivo.isDirectory()){
			

			
			File[] arrayArchivosPadre = archivo.listFiles();
			
			//EL METODO LISTFILES DE LA CLASE FILE, TE DA LA RUTA ABSOLUTA DEL ARCHIVO QUE SE ESTA COMPROBANDO
			
		for(int i=0;i<arrayArchivosPadre.length;i++){
			System.out.println(arrayArchivosPadre[i]);

			File archivoHijo=new File(archivo.getAbsolutePath(),archivo.list()[i]);
			System.out.println("La última fecha de modificación del archivo fué: "+new Date(archivoHijo.lastModified()));

			//COGEMOS CADA ARCHIVO QUE ESTE DENTRO DE LA RUTA QUE DECIMOS
			
				
				
				if(archivoHijo.isDirectory()){
					muestraArchivos(archivoHijo);
				}
				
				//SI LO QUE COGEMOS EN LA RUTA HIJA, ES UNA CARPETA, VUELVE A LLMAAR AL METODO DE NUEVO
			
		}
		}else{
			System.out.println("la ruta especificada es un archivo llamado "+archivo.getName());
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
		File archivoInicial = new File(args[0]);

		muestraArchivos(archivoInicial);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Necesita poner parametros");
		}
	}

}
