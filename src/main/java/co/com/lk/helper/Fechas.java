package co.com.lk.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public final class Fechas {
	
	public static String fechaActual(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date fecha = new Date();
		String date = dateFormat.format(fecha);
		return date;
	}
        
        public static Date fechaActualFD(){
		Date fecha = new Date();
		return fecha;
	}
        
        public static String fechaFormato(Date fecha,String formato){
                
		SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
		
		String date = dateFormat.format(fecha);
		return date;
	}
        
        public static String fechaFormato(Date fecha){
                
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		String date = dateFormat.format(fecha);
		return date;
	}
        
        public static String fechaFormato2(Date fecha){
                
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		String date = dateFormat.format(fecha);
		return date;
	}
        
        public  String fechaFormatoConTiempo(Date fecha){
                
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		String date = dateFormat.format(fecha);
		return date;
	}
        
         public  static String horaActual(Date fecha){
                
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		
		String date = dateFormat.format(fecha);
		return date;
	}
        
        public static String fechaFormatoSinTiempo(Date fecha){
                
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		String date = dateFormat.format(fecha);
                System.out.println("co.com.lk.helper.Fechas.fechaFormatoSinTiempo()"+date);
		return date;
	}
        
        
        public String fechaMesString(Integer mes){
          switch(mes){
                case 1: return "Enero";
                case 2: return "Febrero";
                case 3: return "Marzo";
                case 4:  return "Abril";
                case 5: return "Mayo";
                case 6: return "Junio";
                case 7:  return "Julio";
                case 8: return "Agosto";
                case 9: return "Septiembre";
                case 10: return "Octubre";
                case 11: return "Noviembre";
                case 12: return "Diciembre";
                default: return "Error";
            }
        }
        
        public  String fechaAnio(Date fecha){
                
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		
		String date = dateFormat.format(fecha);
		return date;
	}
        
        public  Integer fechaAnioInt(){
                
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		
		Integer date = Integer.valueOf(dateFormat.format(new Date()));
		return date;
	}
        
         public  String fechaFormatoInvita(Date fecha){
                
                if(fecha!=null){
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String date = dateFormat.format(fecha);
                    return date;
                }
		return "N/A";
	}
                 
        public static String converfecha(Date fecha){
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		String date = dateFormat.format(fecha);
		return date;
	}
	
	public static String anioActual(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		Date fecha = new Date();
		String date = dateFormat.format(fecha);
		return date;
	}
	
	public static String anioActualsinHoras(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = new Date();
		String date = dateFormat.format(fecha);
		return date;
	}
        
        public static Boolean compararFechas(String fechaHoraFinConvocatoria,  String fechaHoraActual) throws ParseException{
                System.out.println("fecha fin convoca:"+fechaHoraFinConvocatoria);
                System.out.println("fecha actual:"+fechaHoraActual);
                
                SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
                
                Date fechaHoraFinConvocatoria1= formateador.parse(fechaHoraFinConvocatoria);
                Date fechaHoraActual1 = formateador.parse(fechaHoraActual);
                
                boolean estado = fechaHoraActual1.before(fechaHoraFinConvocatoria1);
                
                  System.out.println("fecha actual:"+estado);
                return estado;
                
                
                
        }
        
        public static String casteoFecha( String fecha,String title,String fechaSource,String fechaTarget) throws Exception {
        try{
            //yyyy-MM-dd
            SimpleDateFormat dateFormat = new SimpleDateFormat(fechaSource);
            //yyyy-MM-dd
            SimpleDateFormat dateFormat2 = new SimpleDateFormat(fechaTarget);
            Date fc=dateFormat.parse(fecha);
            String date = dateFormat2.format(fc);
            return date;
        }catch(Exception ex){
            throw  new Exception("Formato de fecha no valido en "+title );
        }
    }
        
        public static String fechaNumber(String numer){
            try {
                
                SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                Date date;
                try {
                    try{
                        SimpleDateFormat d = new SimpleDateFormat("ddMMyy H:mm:ss");
                        date = d.parse(numer);
                    }catch(Exception ex){
                        SimpleDateFormat d = new SimpleDateFormat("ddMMyy H:mm:ss");
                        date = d.parse(numer+" 00:00:00");
                    }

                    System.err.println(formateador.format(date));

                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                
                if(!numer.equals("")){    
                    SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                    return originalFormat.format(new Date(Integer.valueOf(numer) * 1000L));
                }else{
                     return "";
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return "";
            }
        
        }
}
