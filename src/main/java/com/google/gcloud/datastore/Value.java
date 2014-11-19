package com.google.gcloud.datastore;

import static com.google.api.services.datastore.DatastoreV1.Value.STRING_VALUE_FIELD_NUMBER;
import static com.google.common.base.Preconditions.checkArgument;

import com.google.api.services.datastore.DatastoreV1.Value.Builder;
import com.google.protobuf.Descriptors.FieldDescriptor;

import java.util.Objects;

public abstract class Value {

  abstract static class Provider<V extends Value> {

    final V get(com.google.api.services.datastore.DatastoreV1.Value proto) {
      return get(proto, proto.getIndexed(), proto.hasMeaning() ? proto.getMeaning() : null);
    }

    abstract V get(com.google.api.services.datastore.DatastoreV1.Value proto, boolean indexed,
        Integer meaning);
  }

  public enum Type {
    NULL(NullValue.PROVIDER, 0),
    STRING(StringValue.PROVIDER, STRING_VALUE_FIELD_NUMBER),
    /*
    TODO: implement
    LONG(LongValue.class, INTEGER_VALUE_FIELD_NUMBER),
    DOUBLE(DoubleValue.class, DOUBLE_VALUE_FIELD_NUMBER),
    // TODO: make sure that getContent returns an immutable value or at least a copy
    TIMESTAMP(TimestampValue.class, TIMESTAMP_MICROSECONDS_VALUE_FIELD_NUMBER),
    BOOLEAN(BooleanValue.class, BOOLEAN_VALUE_FIELD_NUMBER),
    BLOB(BlobValue.class, BLOB_VALUE_FIELD_NUMBER),
    BLOB_KEY(BlobKeyValue.class, BLOB_KEY_VALUE_FIELD_NUMBER),
    */
    // TODO: does not seem to be public...
    // GEO_POINT(GeoPointValue.class, 8),
    COMPLETE_KEY_VALUE(CompleteKeyValue.PROVIDER, KEY_VALUE_FIELD_NUMBER),
    KEY_MAP_VALUE(KeyMapValue.class, ENTITY_VALUE_FIELD_NUMBER),
    List_VALUE(ListValue.class, LIST_VALUE_FIELD_NUMBER);

    private final Provider<? extends Value> provider;
    private FieldDescriptor field;

    Type(Provider<? extends Value> provider, int idx) {
      this.provider = provider;
      this.field = com.google.api.services.datastore.DatastoreV1.Value.getDescriptor()
          .findFieldByNumber(idx);
    }

    Provider<? extends Value> getProvider() {
      return provider;
    }

    FieldDescriptor getDescriptor() {
      return field;
    }
  }

  private final Type type;
  private final boolean indexed;
  private final Integer meaning;

  Value(Type type, boolean indexed, Integer meaning) {
    this.type = type;
    this.indexed = indexed;
    this.meaning = meaning;
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

    Value otherValue = (Value) other;
    return Objects.equals(type, otherValue.type)
        && Objects.equals(indexed, otherValue.indexed)
        && Objects.equals(meaning, otherValue.meaning);
  }

  final com.google.api.services.datastore.DatastoreV1.Value toProto() {
    Builder builder = com.google.api.services.datastore.DatastoreV1.Value.newBuilder();
    builder.setIndexed(indexed);
    if (meaning != null) {
      builder.setMeaning(meaning);
    }
    addValueToProto(builder);
    return builder.build();
  }

  static Value fromProto(com.google.api.services.datastore.DatastoreV1.Value proto) {
    for (Type type : Type.values()) {
      if (proto.hasField(type.getDescriptor())) {
        return type.getProvider().get(proto);
      }
    }
    return NullValue.PROVIDER.get(proto);
  }

  protected abstract void addValueToProto(Builder builder);
}
