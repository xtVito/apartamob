package co.com.aptamob.core.repository.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import co.com.aptamob.core.bo.PrecioPropiedad;
import co.com.aptamob.core.repository.IPrecioPropiedadRepository;

public class PrecioPropiedadRepositoryImpl implements IPrecioPropiedadRepository {

	@Override
	public List<PrecioPropiedad> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PrecioPropiedad> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends PrecioPropiedad> List<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public PrecioPropiedad saveAndFlush(PrecioPropiedad entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<PrecioPropiedad> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public Page<PrecioPropiedad> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends PrecioPropiedad> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrecioPropiedad findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<PrecioPropiedad> findAll(Iterable<Long> ids) {
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
	public void delete(PrecioPropiedad entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends PrecioPropiedad> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}