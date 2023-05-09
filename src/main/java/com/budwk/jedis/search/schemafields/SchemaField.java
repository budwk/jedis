package com.budwk.jedis.search.schemafields;

import com.budwk.jedis.params.IParams;
import com.budwk.jedis.search.FieldName;

public abstract class SchemaField implements IParams {

  protected final FieldName fieldName;

  public SchemaField(String fieldName) {
    this.fieldName = new FieldName(fieldName);
  }

  public SchemaField(FieldName fieldName) {
    this.fieldName = fieldName;
  }

  public SchemaField as(String attribute) {
    fieldName.as(attribute);
    return this;
  }
}
