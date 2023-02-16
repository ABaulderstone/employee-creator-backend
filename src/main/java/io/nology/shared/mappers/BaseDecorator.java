package io.nology.shared.mappers;

public abstract class BaseDecorator implements BaseMapper {

  @Override
  public String trim(String value) {
    if (value == null) {
      return null;
    }
    return value.trim();
  }
}
