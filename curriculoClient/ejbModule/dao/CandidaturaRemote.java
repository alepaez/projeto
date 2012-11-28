package dao;

import java.util.List;

import models.Candidato;
import models.Candidatura;
import models.Empresa;
import models.Vaga;

public interface CandidaturaRemote {
	public void save(Candidatura c);
	public void update(Candidatura c);
	public void delete(Candidatura c);
	public Candidatura find(int id);
	public Candidatura find(String login);
	public List<Candidatura> list();
	public List<Candidatura> list(Empresa empresa);
	public List<Candidatura> list(Vaga vaga);
	public List<Candidatura> list(Candidato candidato);

}
