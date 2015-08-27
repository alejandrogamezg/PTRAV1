package itchetumal.edu.mx.serviciosocial.centroinnovacion;

/**
 * Created by PC07 on 07/05/2015.
 */
public class Lugares {
    private String id;
    private String nombre;
    private String ubicacion;
    private String inagurado;
    private String gobernador;
    private String descripcion;
    private String escultor;

    public String getInagurado() {
        return inagurado;
    }

    public void setInagurado(String inagurado) {
        this.inagurado = inagurado;
    }

    public String getGobernador() {
        return gobernador;
    }

    public void setGobernador(String gobernador) {
        this.gobernador = gobernador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEscultor() {
        return escultor;
    }

    public void setEscultor(String escultor) {
        this.escultor = escultor;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id= id;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre= nombre;
    }

}
