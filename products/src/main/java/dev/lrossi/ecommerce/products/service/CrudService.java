package dev.lrossi.ecommerce.products.service;

import dev.lrossi.ecommerce.products.exceptions.NotFoundException;
import dev.lrossi.ecommerce.products.utils.mapper.GenericMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
public abstract class CrudService<E, R> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CrudService.class);

    @Autowired
    private JpaRepository<E, Long> repository;

    private GenericMapper<E, R> mapper = GenericMapper.MAPPER;

    public R create(@Validated R request) {
        LOGGER.info("m=save request={}", request);
        return saveOrUpdate(request);
    }

    public R findById(Long id) {
        LOGGER.info("m=findById id={}", id);
        return repository.findById(id)
                .map(mapper::entityToResponse)
                .orElseThrow(NotFoundException::new);
    }

    public Page<R> findAll(Pageable pageable) {
        LOGGER.info("m=findAll pageable={}", pageable);
        return repository.findAll(pageable)
                .map(mapper::entityToResponse);
    }

    public R update(@Validated R request) {
        LOGGER.info("m=update request={}", request);
        return saveOrUpdate(request);
    }

    public void delete(R request) {
        LOGGER.info("m=delete request={}", request);
        E entity = mapper.requestToEntity(request);
        repository.delete(entity);
    }

    private R saveOrUpdate(R request) {
        E entity = mapper.requestToEntity(request);
        E persistedEntity = repository.save(entity);
        LOGGER.info("m=saveOrUpdate persisted={}", persistedEntity);
        return mapper.entityToResponse(persistedEntity);
    }
}
