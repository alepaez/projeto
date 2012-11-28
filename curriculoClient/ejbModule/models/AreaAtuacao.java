package models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: AreaAtuacao
 *
 */
@Entity
@Table(name="areasAtuacao")
public class AreaAtuacao implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
    int id;
    
    @Column(name="nome")
    String nome;

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
    
    public String toString(){
    	return nome;
    }
}
