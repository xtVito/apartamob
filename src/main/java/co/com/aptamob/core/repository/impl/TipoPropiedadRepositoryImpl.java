package co.com.aptamob.core.repository.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import co.com.aptamob.core.bo.TipoPropiedad;
import co.com.aptamob.core.repository.ITipoPropiedadRepository;

public class TipoPropiedadRepositoryImpl implements ITipoPropiedadRepository {

	@Override
	public List<TipoPropiedad> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoPropiedad> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends TipoPropiedad> List<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public TipoPropiedad saveAndFlush(TipoPropiedad entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<TipoPropiedad> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public Page<TipoPropiedad> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends TipoPropiedad> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoPropiedad findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<TipoPropiedad> findAll(Iterable<Long> ids) {
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
	public void delete(TipoPropiedad entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends TipoPropiedad> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
