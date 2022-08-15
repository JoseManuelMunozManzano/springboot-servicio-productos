package com.jmunoz.springboot.app.productos.models.entity;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    @Serial
    private static final long serialVersionUID = 6521006847234560268L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double precio;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    // Para saber qué instancia está seleccionando el balanceador de carga (Ribbon)
    // NOTA: Tenemos 2 instancias de springboot-servicio-productos.
    //        Una por defecto en el puerto 8001 y la otra en el puerto 9001.
    //        Para esta segunda instancia, hay que editar la configuración y añadir una application nueva
    //        con la opción en la VM siguiente: -Dserver.port=9001
    //        Para poder informar opciones en la VM hay que pulsar Modify Options y luego Add VM Options.
    //        Luego se ejecutan las 2 instancias.
    //
    // Con @Transient indicamos que este atributo no es persistente, no está mapeado a ningún campo en la BD.
    @Transient
    private Integer port;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
