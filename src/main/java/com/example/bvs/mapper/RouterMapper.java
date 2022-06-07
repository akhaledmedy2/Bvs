package com.example.bvs.mapper;

import com.example.bvs.dto.RouterDto;
import com.example.bvs.entity.Router;
import org.mapstruct.Mapper;

@Mapper
public interface RouterMapper {

    RouterDto mapToRouterDto(Router entity);
}