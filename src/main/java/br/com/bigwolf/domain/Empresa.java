package br.com.bigwolf.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private int id;

    @Column(name = "nome", nullable = false)
    private String nome;


    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    public Empresa (){}
    public Empresa(String nome, String cnpj){
        this.setNome(nome);
        this.setCnpj(cnpj);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return id == empresa.id &&
                Objects.equals(nome, empresa.nome) &&
                Objects.equals(cnpj, empresa.cnpj);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nome, cnpj);
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }
}
