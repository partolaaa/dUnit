package com.willofd.dunit.util.mappers;

import com.willofd.dunit.dto.SimpleUserHeaderDTO;
import com.willofd.dunit.entities.SimpleUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Ivan Partola
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface SimpleUserMapper {
    SimpleUserHeaderDTO simpleUserToHeaderDTO(SimpleUser simpleUser);
}
