package com.SpringBootTest.test.utill.mappers;

import com.SpringBootTest.test.dto.request.RequestItemDTO;
import com.SpringBootTest.test.entity.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item requsetDtoToEntity(RequestItemDTO requestItemDTO);
}
