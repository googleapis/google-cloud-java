package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.api.services.datastore.DatastoreV1.Value;
import com.google.protobuf.Descriptors.FieldDescriptor;

import java.util.Objects;

public abstract class Property<V, P extends Property<V, P, B>,
    B extends Property.Builder<V, P, B>>  {

  private final Type type;
  private final boolean indexed;
  private final Integer meaning;
  private final V value;

  public enum Type {

    NULL(NullProperty.MARSHALLER),
    STRING(StringProperty.MARSHALLER);
    // MapValue -> MapValueProperty
    // ListValue -> ListValueProperty
    // CompleteKey -> CompleteKeyProperty
    // COMPLETE_KEY_VALUE(CompleteKeyValue.PROVIDER, KEY_VALUE_FIELD_NUMBER),
    //KEY_MAP_VALUE(KeyMapValue.MARSHALLER);
    // List_VALUE(ListValue.class, LIST_VALUE_FIELD_NUMBER);

    /*
    TODO: Also implement
    LONG(LongValue.class, INTEGER_VALUE_FIELD_NUMBER),
    DOUBLE(DoubleValue.class, DOUBLE_VALUE_FIELD_NUMBER),
    // TODO: make sure that getContent returns an immutable value or at least a copy
    TIMESTAMP(TimestampValue.class, TIMESTAMP_MICROSECONDS_VALUE_FIELD_NUMBER),
    BOOLEAN(BooleanValue.class, BOOLEAN_VALUE_FIELD_NUMBER),
    BLOB(BlobValue.class, BLOB_VALUE_FIELD_NUMBER),
    BLOB_KEY(BlobKeyValue.class, BLOB_KEY_VALUE_FIELD_NUMBER),
    // GEO_POINT(GeoPointValue.class, 8) // Does not seem to be public yet...
     */

    @SuppressWarnings("rawtypes")
    private final Marshaller marshaller;
    private FieldDescriptor field;

    <V, P extends Property<V, P, B>, B extends Builder<V, P, B>>
        Type(Marshaller<V, P, B> marshaller) {
      this.marshaller = marshaller;
      field = Value.getDescriptor().findFieldByNumber(marshaller.getProtoFieldId());
    }

    <V, P extends Property<V, P, B>, B extends Builder<V, P, B>> Marshaller<V, P, B>
        getMarshaller() {
      return marshaller;
    }

    FieldDescriptor getDescriptor() {
      return field;
    }
  }

  interface Marshaller<V, P extends Property<V, P, B>, B extends Builder<V, P, B>> {

    B newBuilder();

    P fromProto(Value proto);

    Value toProto(P property);

    int getProtoFieldId();
  }

  abstract static class BaseMarshaller<V, P extends Property<V, P, B>, B extends Builder<V, P, B>>
      implements Marshaller<V, P, B> {

    @Override
    public P fromProto(Value proto) {
      B builder = newBuilder();
      builder.setIndexed(proto.getIndexed());
      if (proto.hasMeaning()) {
        builder.setMeaning(proto.getMeaning());
      }
      set(proto, builder);
      return builder.build();
    }

    @Override
    public final Value toProto(P property) {
      Value.Builder builder = Value.newBuilder();
      builder.setIndexed(property.isIndexed());
      if (property.getMeaning() != null) {
        builder.setMeaning(property.getMeaning());
      }
      set(property, builder);
      return builder.build();
    }

    protected abstract void set(Value from, B to);

    protected abstract void set(P from, Value.Builder to);
  }

  public abstract static class Builder<V, P extends Property<V, P, B>, B extends Builder<V, P, B>> {

    private final Type type;
    private boolean indexed = true;
    private Integer meaning;
    private V value;

    protected Builder(Type type) {
      this.type = type;
    }

    public Type getType() {
      return type;
    }

    public B mergeFrom(P other) {
      indexed = other.isIndexed();
      meaning = other.getMeaning();
      setValue(other.getValue());
      return self();
    }

    public boolean isIndexed() {
      return indexed;
    }

    public B setIndexed(boolean indexed) {
      this.indexed = indexed;
      return self();
    }

    public Integer getMeaning() {
      return meaning;
    }

    public B setMeaning(Integer meaning) {
      this.meaning = meaning;
      return self();
    }

    public V getValue() {
      return value;
    }

    public B setValue(V value) {
      this.value = validate(value);
      return self();
    }

    protected V validate(V value) {
      return value;
    }

    protected abstract B self();

    public abstract P build();
  }

  Property(Builder<V, P, B> builder) {
    type = builder.getType();
    indexed = builder.isIndexed();
    meaning = builder.getMeaning();
    // some validations:
    if (meaning != null) {
      // TODO: consider supplying Ranges for allowed meaning and validating it here
      // more specific validation could be done on the specific types themselves
      // upon construction [e.g. integer with a meaning 13 should be in the range [0,100]]
      if (indexed) {
        checkArgument(meaning != 15 && meaning != 22,
            "Indexed values should not have meaning with 15 or 22");
      }
    }
    value = builder.getValue();
  }

  public final Type getType() {
    return type;
  }

  public final boolean isIndexed() {
    return indexed;
  }

  public final Integer getMeaning() {
    return meaning;
  }

  public final V getValue() {
    return value;
  }

  @SuppressWarnings("unchecked")
  public Builder<V, P, B> toBuilder() {
    @SuppressWarnings("rawtypes")
    Builder builder = getType().getMarshaller().newBuilder();
    builder.mergeFrom(this);
    return builder;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getType(), isIndexed(), getMeaning());
  }

  @SuppressWarnings("unchecked")
  @Override
  public boolean equals(Object other) {
    if (!getClass().isInstance(other)) {
      return false;
    }

    Property<V, P, B> otherProperty = (Property<V, P, B>) other;
    return Objects.equals(type, otherProperty.getType())
        && Objects.equals(indexed, otherProperty.isIndexed())
        && Objects.equals(meaning, otherProperty.getMeaning())
        && Objects.equals(getValue(), otherProperty.getValue());
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  final Value toProto() {
    return ((Marshaller) getType().getMarshaller()).toProto(this);
  }

  // TODO: toString, clone?, serialize?, toBuilder, fromBuilder,...

  @SuppressWarnings("unchecked")
  static <V, P extends Property<V, P, B>, B extends Property.Builder<V, P, B>> Property<V, P, B>
      fromProto(Value proto) {
    for (Type type : Type.values()) {
      if (proto.hasField(type.getDescriptor())) {
        return (Property<V, P, B>) type.getMarshaller().fromProto(proto);
      }
    }
    // change strategy to return RawProperty (package scope constructor)
    // when no match instead of null. This could only be done
    // when using the V1 API which added a NullValue type to distinct the cases
    // and the use of oneof which generates an enum of all possible values.
    return (Property<V, P, B>) NullProperty.MARSHALLER.fromProto(proto);
  }
}
