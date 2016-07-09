package co.com.aptamob.core.repository.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import co.com.aptamob.core.bo.Propiedad;
import co.com.aptamob.core.repository.IPropiedadRepository;

public class PropiedadRepositoryImpl implements IPropiedadRepository {

	@Override
	public List<Propiedad> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Propiedad> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Propiedad> List<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public Propiedad saveAndFlush(Propiedad entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Propiedad> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public Page<Propiedad> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Propiedad> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Propiedad findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Propiedad> findAll(Iterable<Long> ids) {
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
	public void delete(Propiedad entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Propiedad> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
