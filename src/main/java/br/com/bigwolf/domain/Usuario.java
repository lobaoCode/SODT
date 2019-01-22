package br.com.bigwolf.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_empresa_fk")
    private Empresa empresa;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "nome", nullable = false)
    private String nome;

    public Usuario(){}
    public Usuario(String senha,Empresa empresa, String nome){
        this.setNome(nome);
        this.setSenha(senha);
        this.setEmpresa(empresa);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id &&
                Objects.equals(empresa, usuario.empresa) &&
                Objects.equals(senha, usuario.senha) &&
                Objects.equals(nome, usuario.nome);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, empresa, senha, nome);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", empresa=" + empresa +
                ", senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
