package com.google.gcloud.datastore;

import static com.google.api.services.datastore.DatastoreV1.Value.ENTITY_VALUE_FIELD_NUMBER;
import static com.google.api.services.datastore.DatastoreV1.Value.STRING_VALUE_FIELD_NUMBER;
import static com.google.common.base.Preconditions.checkArgument;

import com.google.api.services.datastore.DatastoreV1.Value;
import com.google.protobuf.Descriptors.FieldDescriptor;

import java.util.Objects;

public abstract class Property<P extends Property<P>>  {

  private final Type type;
  private final boolean indexed;
  private final Integer meaning;

  abstract static class Provider<P extends Property<P>> {

    final P get(Value proto) {
      return get(proto, proto.getIndexed(), proto.hasMeaning() ? proto.getMeaning() : null);
    }

    abstract P get(Value proto, boolean indexed, Integer meaning);
  }

  public enum Type {

    NULL(NullProperty.PROVIDER, 0),
    STRING(StringProperty.PROVIDER, STRING_VALUE_FIELD_NUMBER),
    // COMPLETE_KEY_VALUE(CompleteKeyValue.PROVIDER, KEY_VALUE_FIELD_NUMBER),
    KEY_MAP_VALUE(KeyMapValue.PROVIDER, ENTITY_VALUE_FIELD_NUMBER);
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

    private final Provider<? extends Property<?>> provider;
    private FieldDescriptor field;

    Type(Provider<? extends Property<?>> provider, int idx) {
      this.provider = provider;
      field = Value.getDescriptor().findFieldByNumber(idx);
    }

    Provider<? extends Property<?>> getProvider() {
      return provider;
    }

    FieldDescriptor getDescriptor() {
      return field;
    }
  }

  public abstract static class Builder<P extends Property<P>> {

    private final Type type;
    private boolean indexed = true;
    private Integer meaning;

    protected Builder(Property<P> property) {
      this.type = property.type;
      this.indexed = property.indexed;
      this.meaning = property.meaning;
    }

    protected Builder(Type type) {
      this.type = type;
    }

    public void setIndexed(boolean indexed) {
      this.indexed = indexed;
    }

    public void setMeaning(Integer meaning) {
      this.meaning = meaning;
    }

    public abstract P build();
  }

  Property(Builder<P> builder) {
    this.type = builder.type;
    this.indexed = builder.indexed;
    this.meaning = builder.meaning;
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

  @Override
  public int hashCode() {
    return Objects.hash(type, indexed, meaning);
  }

  @Override
  public boolean equals(Object other) {
    if (!getClass().isInstance(other)) {
      return false;
    }

    Property<?> otherValue = (Property<?>) other;
    return Objects.equals(type, otherValue.type)
        && Objects.equals(indexed, otherValue.indexed)
        && Objects.equals(meaning, otherValue.meaning);
  }

  final Value toProto() {
    Value.Builder builder = Value.newBuilder();
    builder.setIndexed(indexed);
    if (meaning != null) {
      builder.setMeaning(meaning);
    }
    addValueToProto(builder);
    return builder.build();
  }

  // TODO: toString, clone?, serialize?, toBuilder, fromBuilder,...

  static Property<?> fromProto(Value proto) {
    for (Type type : Type.values()) {
      if (proto.hasField(type.getDescriptor())) {
        return type.getProvider().get(proto);
      }
    }
    // change strategy to return RawProperty (package scope constructor)
    // when no match instead of null. This could only be done
    // when using the V1 API which added a NullValue type to distinct the cases
    // and the use of oneof which generates an enum of all possible values.
    return NullProperty.PROVIDER.get(proto);
  }

  public abstract Builder<P> toBuilder();

  protected abstract void addValueToProto(Value.Builder builder);
}
