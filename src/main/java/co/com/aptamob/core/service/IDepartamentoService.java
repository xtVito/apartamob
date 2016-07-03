package co.com.aptamob.core.service;

import java.util.List;

import co.com.aptamob.core.api.departamento.DepartamentoApi;

public interface IDepartamentoService {
	public DepartamentoApi createDepartamento(DepartamentoApi departamentoRequest);
	public DepartamentoApi saveDepartamento(DepartamentoApi departamentoRequest, String codigo);
	public DepartamentoApi getDepartamento(String codigo);
	public List<DepartamentoApi> getDepartamentos();
	public List<DepartamentoApi> getDepartamentos(String nombre);
	public void deleteDepartamento(DepartamentoApi departamentoRequest, String codigo);
}
