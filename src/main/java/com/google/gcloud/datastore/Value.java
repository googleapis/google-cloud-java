package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.datastore.DatastoreV1;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

/**
 * Base class for all Google Cloud Datastore value types.
 * All values must be associated with a non-null content (except {@link NullValue}).
 * All values are immutable (including their content). To edit (a copy) use {@link #toBuilder()}.
 * Unsupported value (deprecated or unrecognized) would be represented by {@link RawValue}.
 *
 * @param <V> the type of the content for this value
 */
public abstract class Value<V> extends Serializable<DatastoreV1.Value> {

  private static final long serialVersionUID = -1899638277588872742L;
  private static final Map<Integer, Type> DESCRIPTOR_TO_TYPE_MAP = new HashMap<>();

  private final transient Type type;
  private final transient Boolean indexed;
  private final transient Integer meaning;
  private final transient V value;

  /**
   * The type of a property.
   *
   * @see <a href="http://cloud.google.com/datastore/docs/concepts/entities#Datastore_Properties_and_value_types">Google Cloud Datastore types</a>
   */
  public enum Type {

    /**
     * Represents a {@code null} value.
     */
    NULL(NullValue.MARSHALLER, NullValue.MARSHALLER),

    /**
     * Represents a {@code string} value.
     */
    STRING(StringValue.MARSHALLER, StringValue.MARSHALLER),

    /**
     * Represents an entity ({@link PartialEntity} or {@link Entity}) value.
     */
    ENTITY(EntityValue.MARSHALLER, EntityValue.MARSHALLER),

    /**
     * Represents a {@code list} of {@link Value}s.
     */
    LIST(ListValue.MARSHALLER, ListValue.MARSHALLER),

    /**
     * Represents a {@code key} as a value.
     */
    KEY(KeyValue.MARSHALLER, KeyValue.MARSHALLER),

    /**
     * Represents a {@code long} value.
     */
    LONG(LongValue.MARSHALLER, LongValue.MARSHALLER),

    /**
     * Represents a {@code double} value.
     */
    DOUBLE(DoubleValue.MARSHALLER, DoubleValue.MARSHALLER),

    /**
     * Represents a {@code boolean} value.
     */
    BOOLEAN(BooleanValue.MARSHALLER, BooleanValue.MARSHALLER),

    /**
     * Represents a {@link DateTime} value.
     */
    DATE_TIME(DateTimeValue.MARSHALLER, DateTimeValue.MARSHALLER),

    /**
     * Represents a {@link Blob} value.
     */
    BLOB(BlobValue.MARSHALLER, BlobValue.MARSHALLER),

    /**
     * Represents a raw/unparsed value.
     */
    RAW_VALUE(RawValue.MARSHALLER, RawValue.MARSHALLER);


    @SuppressWarnings("rawtypes") private final BuilderFactory builderFactory;
    @SuppressWarnings("rawtypes") private final Marshaller marshaller;

    <V, P extends Value<V>, B extends Builder<V, P, B>> Type(Marshaller<V, P, B> marshaller,
        BuilderFactory<V, P, B> builderFactory) {
      this.marshaller = marshaller;
      this.builderFactory = builderFactory;
      int fieldId = marshaller.getProtoFieldId();
      if (fieldId > 0) {
        DESCRIPTOR_TO_TYPE_MAP.put(fieldId, this);
      }
    }

    <V, P extends Value<V>, B extends Builder<V, P, B>> Marshaller<V, P, B> getMarshaller() {
      return marshaller;
    }

    <V, P extends Value<V>, B extends Builder<V, P, B>> BuilderFactory<V, P, B>
        getBuilderFactory() {
      return builderFactory;
    }
  }

  interface BuilderFactory<V, P extends Value<V>, B extends Builder<V, P, B>> {

    B newBuilder(V value);
  }

  interface Builder<V, P extends Value<V>, B extends Builder<V, P, B>> {

    Type getType();

    B mergeFrom(P other);

    Boolean getIndexed();

    B indexed(boolean indexed);

    Integer getMeaning();

    B meaning(Integer meaning);

    V get();

    B set(V value);

    P build();
  }

  interface Marshaller<V, P extends Value<V>, B extends Builder<V, P, B>> {

    B fromProto(DatastoreV1.Value proto);

    DatastoreV1.Value toProto(P value);

    int getProtoFieldId();
  }

  abstract static class BaseMarshaller<V, P extends Value<V>, B extends Builder<V, P, B>>
      implements Marshaller<V, P, B>, BuilderFactory<V, P, B> {

    @Override
    public final B fromProto(DatastoreV1.Value proto) {
      B builder = newBuilder(getValue(proto));
      if (proto.hasIndexed()) {
        builder.indexed(proto.getIndexed());
      }
      if (proto.hasMeaning()) {
        builder.meaning(proto.getMeaning());
      }
      return builder;
    }

    @Override
    public final DatastoreV1.Value toProto(P value) {
      DatastoreV1.Value.Builder builder = DatastoreV1.Value.newBuilder();
      if (value.hasIndexed()) {
        builder.setIndexed(value.indexed());
      }
      if (value.hasMeaning()) {
        builder.setMeaning(value.meaning());
      }
      setValue(value, builder);
      return builder.build();
    }

    protected abstract V getValue(DatastoreV1.Value from);

    protected abstract void setValue(P from, DatastoreV1.Value.Builder to);
  }

  abstract static class BaseBuilder<V, P extends Value<V>, B extends BaseBuilder<V, P, B>>
      implements Builder<V, P, B> {

    private final Type type;
    private Boolean indexed;
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
      indexed = other.indexed();
      meaning = other.meaning();
      set(other.get());
      return self();
    }

    @Override
    public Boolean getIndexed() {
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

  <P extends Value<V>, B extends BaseBuilder<V, P, B>> Value(Builder<V, P, B> builder) {
    type = builder.getType();
    indexed = builder.getIndexed();
    meaning = builder.getMeaning();
    // some validations:
    if (meaning != null && indexed != null) {
      // TODO: consider supplying Ranges for allowed meaning and validating it here
      // more specific validation could be done on the specific types themselves
      // upon construction [e.g. integer with a meaning 13 should be in the range [0,100]]
      checkArgument(!indexed || meaning != 15 && meaning != 22,
          "Indexed values should not have meaning with 15 or 22");
    }
    value = builder.get();
  }

  public final Type type() {
    return type;
  }

  public final boolean hasIndexed() {
    return indexed != null;
  }

  public final Boolean indexed() {
    return indexed;
  }

  public final boolean hasMeaning() {
    return meaning != null;
  }

  public final Integer meaning() {
    return meaning;
  }

  public final V get() {
    return value;
  }

  public abstract Builder<?, ?, ?> toBuilder();

  @Override
  public int hashCode() {
    return Objects.hash(type, indexed, meaning, value);
  }

  @Override
  @SuppressWarnings("unchecked")
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!getClass().isInstance(obj)) {
      return false;
    }
    Value<V> other = (Value<V>) obj;
    return Objects.equals(type, other.type)
        && Objects.equals(indexed, other.indexed)
        && Objects.equals(meaning, other.meaning)
        && Objects.equals(value, other.value);
  }

  @Override
  @SuppressWarnings({"unchecked", "rawtypes"})
  protected DatastoreV1.Value toPb() {
    return type().getMarshaller().toProto((Value) this);
  }

  static Value<?> fromPb(DatastoreV1.Value proto) {
    for (Entry<FieldDescriptor, Object> entry : proto.getAllFields().entrySet()) {
      FieldDescriptor descriptor = entry.getKey();
      if (descriptor.getName().endsWith("_value")) {
        Type type = DESCRIPTOR_TO_TYPE_MAP.get(descriptor.getNumber());
        if (type == null) {
          // unsupported type
          return RawValue.MARSHALLER.fromProto(proto).build();
        }
        return type.getMarshaller().fromProto(proto).build();
      }
    }
    return NullValue.MARSHALLER.fromProto(proto).build();
  }

  @Override
  protected Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
    return fromPb(DatastoreV1.Value.parseFrom(bytesPb));
  }
}
