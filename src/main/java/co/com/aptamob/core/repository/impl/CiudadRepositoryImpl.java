package co.com.aptamob.core.repository.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import co.com.aptamob.core.bo.Ciudad;
import co.com.aptamob.core.repository.ICiudadRepository;

public class CiudadRepositoryImpl implements ICiudadRepository {

	@Override
	public List<Ciudad> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ciudad> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Ciudad> List<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public Ciudad saveAndFlush(Ciudad entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Ciudad> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public Page<Ciudad> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Ciudad> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ciudad findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Ciudad> findAll(Iterable<Long> ids) {
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
	public void delete(Ciudad entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Ciudad> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public Ciudad findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ciudad> findByDepartamentoId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ciudad> findByNombreIgnoreCaseContaining(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
