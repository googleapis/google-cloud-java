package com.google.gcloud.datastore;

import static com.google.api.client.util.Preconditions.checkNotNull;
import static com.google.api.services.datastore.DatastoreV1.Value.LIST_VALUE_FIELD_NUMBER;

import com.google.api.services.datastore.DatastoreV1.Value;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import java.util.List;

public final class PropertyListProperty extends
    Property<List<Property<?, ?, ?>>, PropertyListProperty, PropertyListProperty.Builder> {

  private static final long serialVersionUID = -5461475706792576395L;

  static final Marshaller<List<Property<?, ?, ?>>, PropertyListProperty, Builder> MARSHALLER =
      new BaseMarshaller<List<Property<?, ?, ?>>, PropertyListProperty, Builder>() {

    @Override
    public int getProtoFieldId() {
      return LIST_VALUE_FIELD_NUMBER;
    }

    @Override
    protected Builder newBuilder(Value from) {
      Builder builder = new Builder();
      for (Value valuePb : from.getListValueList()) {
        builder.addProperty(Property.fromPb(valuePb));
      }
      return builder;
    }

    @Override
    protected void setValueField(PropertyListProperty from, Value.Builder to) {
      for (Property<?, ?, ?> property : from.getValue()) {
        to.addListValue(property.toPb());
      }
    }
  };

  public static final class Builder extends
      Property.BaseBuilder<List<Property<?, ?, ?>>, PropertyListProperty, Builder> {

    private ImmutableList.Builder<Property<?, ?, ?>> listBuilder = ImmutableList.builder();

    public Builder() {
      super(Type.PROPERTY_LIST);
      setIndexed(false);
    }

    public Builder addProperty(Property<?, ?, ?> property) {
      listBuilder.add(property);
      return this;
    }

    @Override
    public Builder setValue(List<Property<?, ?, ?>> value) {
      listBuilder = ImmutableList.<Property<?, ?, ?>>builder().addAll(checkNotNull(value));
      return this;
    }

    @Override
    public List<Property<?, ?, ?>> getValue() {
      return listBuilder.build();
    }

    @Override
    protected Builder self() {
      return this;
    }

    @Override
    public PropertyListProperty build() {
      Preconditions.checkState(!getValue().isEmpty(), "Property list could not be empty");
      return new PropertyListProperty(this);
    }
  }

  public PropertyListProperty(List<Property<?, ?, ?>> properties) {
    this(new Builder().setValue(properties));
  }

  PropertyListProperty(Builder builder) {
    super(builder);
  }
}
