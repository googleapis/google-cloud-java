package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.datastore.DatastoreV1;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.Objects;

// TODO: add javadoc, and mention that null should only be represented by NullValue.
public abstract class
    Value<V, P extends Value<V, P, B>, B extends Value.Builder<V, P, B>>
    extends Serializable<DatastoreV1.Value> {

  private static final long serialVersionUID = -1899638277588872742L;

  private final transient Type type;
  private final transient boolean indexed;
  private final transient Integer meaning;
  private final transient V value;

  public enum Type {

    NULL(NullValue.MARSHALLER, NullValue.MARSHALLER),
    STRING(StringValue.MARSHALLER, StringValue.MARSHALLER),
    PARTIAL_ENTITY(PartialEntityValue.MARSHALLER, PartialEntityValue.MARSHALLER),
    LIST(ListValue.MARSHALLER, ListValue.MARSHALLER),
    KEY(KeyValue.MARSHALLER, KeyValue.MARSHALLER);

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

    @SuppressWarnings("rawtypes") private final BuilderFactory builderFactory;
    @SuppressWarnings("rawtypes") private final Marshaller marshaller;
    private FieldDescriptor field;

    <V, P extends Value<V, P, B>, B extends Builder<V, P, B>>
        Type(Marshaller<V, P, B> marshaller, BuilderFactory<V, P, B> builderFactory) {
      this.marshaller = marshaller;
      this.builderFactory = builderFactory;
      field = DatastoreV1.Value.getDescriptor().findFieldByNumber(marshaller.getProtoFieldId());
    }

    <V, P extends Value<V, P, B>, B extends Builder<V, P, B>> Marshaller<V, P, B>
        getMarshaller() {
      return marshaller;
    }

    <V, P extends Value<V, P, B>, B extends Builder<V, P, B>> BuilderFactory<V, P, B>
        getBuilderFactory() {
      return builderFactory;
    }

    FieldDescriptor getDescriptor() {
      return field;
    }
  }

  interface BuilderFactory<V, P extends Value<V, P, B>, B extends Builder<V, P, B>> {

    B newBuilder(V value);
  }

  interface Builder<V, P extends Value<V, P, B>, B extends Builder<V, P, B>> {

    Type getType();

    B mergeFrom(P other);

    boolean getIndexed();

    B indexed(boolean indexed);

    Integer getMeaning();

    B meaning(Integer meaning);

    V get();

    B set(V value);

    P build();
  }

  interface Marshaller<V, P extends Value<V, P, B>, B extends Builder<V, P, B>> {

    B fromProto(DatastoreV1.Value proto);

    DatastoreV1.Value toProto(P value);

    int getProtoFieldId();
  }

  abstract static class BaseMarshaller<V, P extends Value<V, P, B>, B extends Builder<V, P, B>>
      implements Marshaller<V, P, B>, BuilderFactory<V, P, B> {

    @Override
    public final B fromProto(DatastoreV1.Value proto) {
      B builder = newBuilder(getValue(proto));
      builder.indexed(proto.getIndexed());
      if (proto.hasMeaning()) {
        builder.meaning(proto.getMeaning());
      }
      return builder;
    }

    @Override
    public final DatastoreV1.Value toProto(P value) {
      DatastoreV1.Value.Builder builder = DatastoreV1.Value.newBuilder();
      builder.setIndexed(value.getIndexed());
      if (value.getMeaning() != null) {
        builder.setMeaning(value.getMeaning());
      }
      setValue(value, builder);
      return builder.build();
    }

    protected abstract V getValue(DatastoreV1.Value from);

    protected abstract void setValue(P from, DatastoreV1.Value.Builder to);
  }

  abstract static class BaseBuilder<V, P extends Value<V, P, B>, B extends BaseBuilder<V, P, B>>
      implements Builder<V, P, B> {

    private final Type type;
    private boolean indexed = true;
    private Integer meaning;
    private V value;

    protected BaseBuilder(Type type) {
      this.type = type;
    }

    @Override
    public Type getType() {
      return type;
    }

    @Override
    public B mergeFrom(P other) {
      indexed = other.getIndexed();
      meaning = other.getMeaning();
      set(other.get());
      return self();
    }

    @Override
    public boolean getIndexed() {
      return indexed;
    }

    @Override
    public B indexed(boolean indexed) {
      this.indexed = indexed;
      return self();
    }

    @Override
    public Integer getMeaning() {
      return meaning;
    }

    @Override
    public B meaning(Integer meaning) {
      this.meaning = meaning;
      return self();
    }

    @Override
    public V get() {
      return value;
    }

    @Override
    public B set(V value) {
      this.value = checkNotNull(value);
      return self();
    }

    @SuppressWarnings("unchecked")
    private B self() {
      return (B) this;
    }

    @Override
    public abstract P build();
  }

  Value(Builder<V, P, B> builder) {
    type = builder.getType();
    indexed = builder.getIndexed();
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
    value = builder.get();
  }

  public final Type getType() {
    return type;
  }

  public final boolean getIndexed() {
    return indexed;
  }

  public final Integer getMeaning() {
    return meaning;
  }

  public final V get() {
    return value;
  }

  @SuppressWarnings("unchecked")
  public final B toBuilder() {
    BuilderFactory<V, P, B> builderFactory = getType().getBuilderFactory();
    B builder = builderFactory.newBuilder(get());
    return builder.mergeFrom((P) this);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, indexed, meaning);
  }

  @SuppressWarnings("unchecked")
  @Override
  public boolean equals(Object other) {
    if (!getClass().isInstance(other)) {
      return false;
    }

    Value<V, P, B> otherValue = (Value<V, P, B>) other;
    return Objects.equals(type, otherValue.getType())
        && Objects.equals(indexed, otherValue.getIndexed())
        && Objects.equals(meaning, otherValue.getMeaning())
        && Objects.equals(value, otherValue.get());
  }

  @Override
  @SuppressWarnings("unchecked")
  protected DatastoreV1.Value toPb() {
    Marshaller<V, P, B> marshaller = getType().getMarshaller();
    return marshaller.toProto((P) this);
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  static <V, P extends Value<V, P, B>, B extends Value.Builder<V, P, B>> Value<V, P, B>
      fromPb(DatastoreV1.Value proto) {
    Marshaller marshaller = NullValue.MARSHALLER;
    for (Type type : Type.values()) {
      FieldDescriptor descriptor = type.getDescriptor();
      if (descriptor != null) {
        if (descriptor.isRepeated()) {
          if (proto.getRepeatedFieldCount(descriptor) > 0) {
            marshaller = type.getMarshaller();
            break;
          }
        } else if (proto.hasField(descriptor)) {
          marshaller = type.getMarshaller();
          break;
        }
      }
    }
    // change strategy to return RawValue (package scope constructor)
    // when no match instead of null. This could only be done
    // when using the V3 API which added a NullValue type to distinct the cases
    // and the use of oneof which generates an enum of all possible values.
    return marshaller.fromProto(proto).build();
  }

  @Override
  protected Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
    return fromPb(DatastoreV1.Value.parseFrom(bytesPb));
  }
}
