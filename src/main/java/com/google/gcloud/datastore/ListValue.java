package com.google.gcloud.datastore;

import static com.google.api.services.datastore.DatastoreV1.Value.LIST_VALUE_FIELD_NUMBER;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public final class ListValue extends Value<List<? extends Value<?>>> {

  private static final long serialVersionUID = -5461475706792576395L;

  static final BaseMarshaller<List<? extends Value<?>>, ListValue, Builder> MARSHALLER =
      new BaseMarshaller<List<? extends Value<?>>, ListValue, Builder>() {

    @Override
    public int getProtoFieldId() {
      return LIST_VALUE_FIELD_NUMBER;
    }

    @Override
    public Builder newBuilder(List<? extends Value<?>> values) {
      return builder().set(values);
    }

    @Override
    protected List<Value<?>> getValue(DatastoreV1.Value from) {
      List<Value<?>> properties = new ArrayList<>(from.getListValueCount());
      for (DatastoreV1.Value valuePb : from.getListValueList()) {
        properties.add(Value.fromPb(valuePb));
      }
      return properties;
    }

    @Override
    protected void setValue(ListValue from, DatastoreV1.Value.Builder to) {
      for (Value<?> property : from.get()) {
        to.addListValue(property.toPb());
      }
    }
  };

  public static final class Builder extends
      Value.BaseBuilder<List<? extends Value<?>>, ListValue, Builder> {

    private ImmutableList.Builder<Value<?>> listBuilder = ImmutableList.builder();

    private Builder() {
      super(Type.LIST);
    }

    public Builder addValue(Value<?> value) {
      Preconditions.checkArgument(value.type() != Type.LIST, "Cannot contain another list");
      listBuilder.add(value);
      return this;
    }

    public Builder addValue(Value<?> first, Value<?>... other) {
      addValue(first);
      for (Value<?> value : other) {
        addValue(value);
      }
      return this;
    }

    @Override
    public Builder indexed(boolean indexed) {
      // see b/18704917
      DatastoreServiceException.throwInvalidRequest("ListValue can't specify index");
      return this;
    }

    /**
     * Copy the list of values.
     *
     * @see com.google.gcloud.datastore.Value.BaseBuilder#set(java.lang.Object)
     */
    @Override
    public Builder set(List<? extends Value<?>> values) {
      listBuilder = ImmutableList.<Value<?>>builder();
      for (Value<?> value : values) {
        addValue(value);
      }
      return this;
    }

    @Override
    public List<? extends Value<?>> get() {
      return listBuilder.build();
    }

    @Override
    public ListValue build() {
      Preconditions.checkState(!get().isEmpty(), "value list could not be empty");
      return new ListValue(this);
    }
  }

  public ListValue(List<? extends Value<?>> values) {
    this(builder().set(values));
  }

  public ListValue(Value<?> first, Value<?>... other) {
    this(new Builder().addValue(first, other));
  }

  private ListValue(Builder builder) {
    super(builder);
  }

  @Override
  public Builder toBuilder() {
    return new Builder().mergeFrom(this);
  }

  public static Builder builder() {
    return new Builder();
  }
}
