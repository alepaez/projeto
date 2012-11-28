 package create;
 
 import org.hibernate.cfg.AnnotationConfiguration;
 import org.hibernate.tool.hbm2ddl.SchemaExport;
 import models.*;

public class generateDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();

		cfg.addAnnotatedClass(AreaAtuacao.class);
		cfg.addAnnotatedClass(Curriculo.class);
		cfg.addAnnotatedClass(Empresa.class);
		cfg.addAnnotatedClass(Candidato.class);
		cfg.addAnnotatedClass(Universidade.class);
		cfg.addAnnotatedClass(Vaga.class);
		cfg.addAnnotatedClass(Candidatura.class);
		

		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true); 
	}

}