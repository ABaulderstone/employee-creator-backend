package io.nology.shared.mappers;

import org.mapstruct.Mapper;

@Mapper
public interface BaseMapper {
  public String trim(String value);
}
