package br.com.bigwolf.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tarefa")
public class Tarefa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarefa")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario_fk")
    private Usuario usuario;

    @Column(name = "titulo", nullable = false)
    private String Titulo;

    @Column(name = "descricao")
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_entrada", nullable = false)
    private Date data;

    @Column(name = "hora_entrada", nullable = false)
    private String hora;

    @Column(name = "tarefa_status", nullable = false)
    private String status;

    public Tarefa(){}

    public Tarefa(Usuario usuario, String titulo, Date data, String hora, String status){
        this.setUsuario(usuario);
        this.setTitulo(titulo);
        this.setData(data);
        this.setHora(hora);
        this.setStatus(status);
    }
    public Tarefa(Usuario usuario, String titulo, Date data, String hora, String status, String descricao){
        this(usuario, titulo, data, hora, status);
        this.setDescricao(descricao);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return id == tarefa.id &&
                Objects.equals(usuario, tarefa.usuario) &&
                Objects.equals(Titulo, tarefa.Titulo) &&
                Objects.equals(descricao, tarefa.descricao) &&
                Objects.equals(data, tarefa.data) &&
                Objects.equals(hora, tarefa.hora) &&
                Objects.equals(status, tarefa.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, usuario, Titulo, descricao, data, hora, status);
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", Titulo='" + Titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                ", hora='" + hora + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
