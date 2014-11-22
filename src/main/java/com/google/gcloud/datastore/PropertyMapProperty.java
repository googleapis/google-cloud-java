package com.google.gcloud.datastore;

import static com.google.api.client.util.Preconditions.checkNotNull;
import static com.google.api.services.datastore.DatastoreV1.Value.ENTITY_VALUE_FIELD_NUMBER;

import com.google.api.services.datastore.DatastoreV1;
import com.google.api.services.datastore.DatastoreV1.Entity;
import com.google.api.services.datastore.DatastoreV1.Value;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

public final class PropertyMapProperty extends
    Property<Map<String, Property<?, ?, ?>>, PropertyMapProperty, PropertyMapProperty.Builder> {

  private final Key key;

  static final Marshaller<Map<String, Property<?, ?, ?>>, PropertyMapProperty, Builder> MARSHALLER =
      new BaseMarshaller<Map<String, Property<?, ?, ?>>, PropertyMapProperty, Builder>() {

    @Override
    public int getProtoFieldId() {
      return ENTITY_VALUE_FIELD_NUMBER;
    }

    @Override
    protected Builder newBuilder(Value from) {
      Builder builder = new Builder();
      Entity entityPb = from.getEntityValue();
      if (entityPb.hasKey()) {
        builder.setKey(Key.fromPb(entityPb.getKey()));
      }
      for (DatastoreV1.Property propertyPb : entityPb.getPropertyList()) {
        builder.addProperty(propertyPb.getName(), Property.fromPb(propertyPb.getValue()));
      }
      return builder;
    }

    @Override
    protected void setValueField(PropertyMapProperty from, DatastoreV1.Value.Builder to) {
      Entity.Builder entityPb = Entity.newBuilder();
      entityPb.setKey(from.getKey().toPb());
      for (Map.Entry<String, Property<?, ?, ?>> entry : from.getValue().entrySet()) {
        Property<?, ?, ?> property = entry.getValue();
        DatastoreV1.Property.Builder propertyPb = DatastoreV1.Property.newBuilder();
        propertyPb.setName(entry.getKey());
        propertyPb.setValue(property.toPb());
      }
    }
  };

  public static final class Builder extends
      Property.BaseBuilder<Map<String, Property<?, ?, ?>>, PropertyMapProperty, Builder> {

    private Key key;
    private ImmutableMap.Builder<String, Property<?, ?, ?>> mapBuilder = ImmutableMap.builder();

    public Builder() {
      super(Type.PROPERTY_MAP);
      setIndexed(false);
    }

    public Key getKey() {
      return key;
    }

    public Builder setKey(Key key) {
      this.key = key;
      return this;
    }

    public Builder addProperty(String name, Property<?, ?, ?> property) {
      mapBuilder.put(name, property);
      return this;
    }

    @Override
    public Builder setValue(Map<String, Property<?, ?, ?>> value) {
      mapBuilder = ImmutableMap.<String, Property<?, ?, ?>>builder().putAll(checkNotNull(value));
      return this;
    }

    @Override
    public Map<String, Property<?, ?, ?>> getValue() {
      return mapBuilder.build();
    }

    @Override
    protected Builder self() {
      return this;
    }

    @Override
    public PropertyMapProperty build() {
      return new PropertyMapProperty(this);
    }
  }

  public PropertyMapProperty(Key key, Map<String, Property<?, ?, ?>> properties) {
    this(new Builder().setValue(properties).setKey(key));
  }

  PropertyMapProperty(Builder builder) {
    super(builder);
    key = builder.key;
  }

  public Key getKey() {
    return key;
  }
}
