package dev.lrossi.ecommerce.products.utils.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GenericMapper<E, R> {

    GenericMapper MAPPER = Mappers.getMapper(GenericMapper.class);

    R entityToResponse(E entity);

    E requestToEntity(R request);
}
