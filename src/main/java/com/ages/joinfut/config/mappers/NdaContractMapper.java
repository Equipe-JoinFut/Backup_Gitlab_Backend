package com.ages.joinfut.config.mappers;

import com.ages.joinfut.dto.NdaContractDTO;
import com.ages.joinfut.model.NdaContract;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NdaContractMapper {

    NdaContractMapper MAPPER = Mappers.getMapper(NdaContractMapper.class);

    NdaContractDTO NdaContractToNdaContractDTO(NdaContract ndaContract);
    NdaContract NdaContractDTOToNdaContract(NdaContractDTO ndaContractDTO);
}
