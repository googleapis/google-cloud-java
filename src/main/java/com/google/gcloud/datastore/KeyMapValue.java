package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1.Value.Builder;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class KeyMapValue extends Property {

  private final Key key;
  private final ImmutableMap<String, Property> values;

  static final Provider<KeyMapValue> PROVIDER = new Provider<KeyMapValue>() {
    @Override
    KeyMapValue get(com.google.api.services.datastore.DatastoreV1.Value proto, boolean indexed,
        Integer meaning) {
      // TODO: implement
      return new KeyMapValue(indexed);
    }
  };

  KeyMapValue(boolean indexed) {
    super(Type.KEY_MAP_VALUE, indexed, 0);
    key = null;
    values = null;
    // TODO Auto-generated constructor stub
  }

  public Key getKey() {
    return key;
  }

  public Map<String, Property> getValues() {
    return values;
  }

  @Override
  protected void addValueToProto(Builder builder) {
    // TODO Auto-generated method stub
  }
}
