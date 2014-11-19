package com.google.gcloud.datastore;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class KeyMapValue extends Value {

  private final Key key;
  private final ImmutableMap<String, Value> values;

  KeyMapValue(boolean indexed) {
    super(Type.
    // TODO Auto-generated constructor stub
  }

  public Key getKey() {
    return key;
  }

  public Map<String, Value> getValues() {
    return values;
  }
}
