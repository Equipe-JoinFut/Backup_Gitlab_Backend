package com.ages.joinfut.config.mappers;

import com.ages.joinfut.dto.SubgroupDTO;
import com.ages.joinfut.model.Subgroup;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SubgroupMapper {

    SubgroupMapper MAPPER = Mappers.getMapper(SubgroupMapper.class);

    SubgroupDTO SubgroupToSubgroupDTO(Subgroup subgroup);
    Subgroup SubgroupDTOToSubgroup(SubgroupDTO subgroupDTO);
}
