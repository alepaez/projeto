package dao;

import java.util.List;

import models.Empresa;

public interface EmpresaRemote {
	public void save(Empresa c);
	public void update(Empresa c);
	public void delete(Empresa c);
	public Empresa find(int id);
	public Empresa find(String login);
	public List<Empresa> list();
}
