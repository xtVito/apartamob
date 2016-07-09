package co.com.aptamob.core.service;

import java.util.List;

import co.com.aptamob.core.api.departamento.DepartamentoApi;
import co.com.aptamob.core.api.departamento.DepartamentoCreateRequest;

public interface IDepartamentoService {
	public DepartamentoApi createDepartamento(DepartamentoCreateRequest departamentoRequest);
	public DepartamentoApi saveDepartamento(DepartamentoCreateRequest departamentoRequest, String codigo);
	public DepartamentoApi getDepartamento(String codigo);
	public List<DepartamentoApi> getDepartamentos();
	public List<DepartamentoApi> getDepartamentos(String nombre);
	public void deleteDepartamento(String codigo);
}
