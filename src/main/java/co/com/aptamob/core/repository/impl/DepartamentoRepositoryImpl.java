package co.com.aptamob.core.repository.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import co.com.aptamob.core.bo.Departamento;
import co.com.aptamob.core.repository.IDepartamentoRepository;

public class DepartamentoRepositoryImpl implements IDepartamentoRepository {

	@Override
	public List<Departamento> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Departamento> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Departamento> List<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public Departamento saveAndFlush(Departamento entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Departamento> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public Page<Departamento> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Departamento> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Departamento findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Departamento> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Departamento entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Departamento> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public Departamento findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Departamento findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Departamento> findByNombreIgnoreCaseContaining(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
