package com.google.gcloud.datastore;

import static com.google.api.services.datastore.DatastoreV1.Value.LIST_VALUE_FIELD_NUMBER;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public final class ListValue extends
    Value<List<Value<?, ?, ?>>, ListValue, ListValue.Builder> {

  private static final long serialVersionUID = -5461475706792576395L;

  static final BaseMarshaller<List<Value<?, ?, ?>>, ListValue, Builder> MARSHALLER =
      new BaseMarshaller<List<Value<?, ?, ?>>, ListValue, Builder>() {

    @Override
    public int getProtoFieldId() {
      return LIST_VALUE_FIELD_NUMBER;
    }

    @Override
    public Builder newBuilder(List<Value<?, ?, ?>> values) {
      return new Builder().set(values);
    }

    @Override
    protected List<Value<?, ?, ?>> getValue(DatastoreV1.Value from) {
      List<Value<?, ?, ?>> properties = new ArrayList<>(from.getListValueCount());
      for (DatastoreV1.Value valuePb : from.getListValueList()) {
        properties.add(Value.fromPb(valuePb));
      }
      return properties;
    }

    @Override
    protected void setValue(ListValue from, DatastoreV1.Value.Builder to) {
      for (Value<?, ?, ?> property : from.get()) {
        to.addListValue(property.toPb());
      }
    }
  };

  public static final class Builder extends
      Value.BaseBuilder<List<Value<?, ?, ?>>, ListValue, Builder> {

    private ImmutableList.Builder<Value<?, ?, ?>> listBuilder = ImmutableList.builder();

    public Builder() {
      super(Type.LIST);
      indexed(false);
    }

    public Builder addValue(Value<?, ?, ?> value) {
      Preconditions.checkArgument(value.getType() != Type.LIST, "Cannot contain another list");
      listBuilder.add(value);
      return this;
    }

    public Builder addValue(Value<?, ?, ?> first, Value<?, ?, ?>... other) {
      addValue(first);
      for (Value<?, ?, ?> value : other) {
        addValue(value);
      }
      return this;
    }

    @Override
    public Builder set(List<Value<?, ?, ?>> properties) {
      listBuilder = ImmutableList.<Value<?, ?, ?>>builder();
      for (Value<?, ?, ?> property : properties) {
        addValue(property);
      }
      return this;
    }

    @Override
    public List<Value<?, ?, ?>> get() {
      return listBuilder.build();
    }

    @Override
    public ListValue build() {
      Preconditions.checkState(!get().isEmpty(), "value list could not be empty");
      return new ListValue(this);
    }
  }

  public ListValue(List<Value<?, ?, ?>> properties) {
    this(new Builder().set(properties));
  }

  public ListValue(Value<?, ?, ?> first, Value<?, ?, ?>... other) {
    this(new Builder().addValue(first, other));
  }

  ListValue(Builder builder) {
    super(builder);
  }
}
