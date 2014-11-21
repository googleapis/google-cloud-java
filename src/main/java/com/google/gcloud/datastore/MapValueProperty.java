package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1.Value;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class MapValueProperty extends Property<String, StringProperty, StringProperty.Builder> {

  private final Key key;
  private final ImmutableMap<String, Property> values;

  static final Marshaller<MapValueProperty> MARSHALLER = new Marshaller<MapValueProperty>() {
    @Override
    MapValueProperty get(Value proto, boolean indexed, Integer meaning) {
      // TODO: implement
      return new MapValueProperty(indexed);
    }

    @Override
    public Builder<MapValueProperty> newBuilder() {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public MapValueProperty fromProto(Value proto) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public Value toProto(MapValueProperty property) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public int getProtoFieldId() {
      return ENTITY_VALUE_FIELD_NUMBER;;
    }
  };

  MapValueProperty(boolean indexed) {
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
