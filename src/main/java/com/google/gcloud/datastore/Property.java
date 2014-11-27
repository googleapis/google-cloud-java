package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.datastore.DatastoreV1.Value;
import com.google.protobuf.Descriptors.FieldDescriptor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Objects;

// TODO: add javadoc, and mention that null should only be represented by NullValue.
public abstract class
    Property<V, P extends Property<V, P, B>, B extends Property.Builder<V, P, B>>
    implements Serializable {

  private static final long serialVersionUID = -1899638277588872742L;

  private final transient Type type;
  private final transient boolean indexed;
  private final transient Integer meaning;
  private final transient V value;
  private transient Value tempValuePb; // only for deserialization

  public enum Type {

    NULL(NullProperty.MARSHALLER, NullProperty.MARSHALLER),
    STRING(StringProperty.MARSHALLER, StringProperty.MARSHALLER),
    EMBEDDED_ENTITY(EmbeddedEntityProperty.MARSHALLER, EmbeddedEntityProperty.MARSHALLER),
    PROPERTY_LIST(PropertyListProperty.MARSHALLER, PropertyListProperty.MARSHALLER),
    KEY(KeyProperty.MARSHALLER, KeyProperty.MARSHALLER);

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

    <V, P extends Property<V, P, B>, B extends Builder<V, P, B>>
        Type(Marshaller<V, P, B> marshaller, BuilderFactory<V, P, B> builderFactory) {
      this.marshaller = marshaller;
      this.builderFactory = builderFactory;
      field = Value.getDescriptor().findFieldByNumber(marshaller.getProtoFieldId());
    }

    <V, P extends Property<V, P, B>, B extends Builder<V, P, B>> Marshaller<V, P, B>
        getMarshaller() {
      return marshaller;
    }

    <V, P extends Property<V, P, B>, B extends Builder<V, P, B>> BuilderFactory<V, P, B>
        getBuilderFactory() {
      return builderFactory;
    }

    FieldDescriptor getDescriptor() {
      return field;
    }
  }

  interface BuilderFactory<V, P extends Property<V, P, B>, B extends Builder<V, P, B>> {

    B newBuilder(V value);
  }

  interface Builder<V, P extends Property<V, P, B>, B extends Builder<V, P, B>> {

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

  interface Marshaller<V, P extends Property<V, P, B>, B extends Builder<V, P, B>> {

    B fromProto(Value proto);

    Value toProto(P property);

    int getProtoFieldId();
  }

  abstract static class BaseMarshaller<V, P extends Property<V, P, B>, B extends Builder<V, P, B>>
      implements Marshaller<V, P, B>, BuilderFactory<V, P, B> {

    @Override
    public final B fromProto(Value proto) {
      B builder = newBuilder(getValue(proto));
      builder.indexed(proto.getIndexed());
      if (proto.hasMeaning()) {
        builder.meaning(proto.getMeaning());
      }
      return builder;
    }

    @Override
    public final Value toProto(P property) {
      Value.Builder builder = Value.newBuilder();
      builder.setIndexed(property.getIndexed());
      if (property.getMeaning() != null) {
        builder.setMeaning(property.getMeaning());
      }
      setValue(property, builder);
      return builder.build();
    }

    protected abstract V getValue(Value from);

    protected abstract void setValue(P from, Value.Builder to);
  }

  abstract static class BaseBuilder<V, P extends Property<V, P, B>, B extends BaseBuilder<V, P, B>>
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

  Property(Builder<V, P, B> builder) {
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

    Property<V, P, B> otherProperty = (Property<V, P, B>) other;
    return Objects.equals(type, otherProperty.getType())
        && Objects.equals(indexed, otherProperty.getIndexed())
        && Objects.equals(meaning, otherProperty.getMeaning())
        && Objects.equals(value, otherProperty.get());
  }

  @SuppressWarnings("unchecked")
  Value toPb() {
    Marshaller<V, P, B> marshaller = getType().getMarshaller();
    return marshaller.toProto((P) this);
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  static <V, P extends Property<V, P, B>, B extends Property.Builder<V, P, B>> Property<V, P, B>
      fromPb(Value proto) {
    Marshaller marshaller = NullProperty.MARSHALLER;
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
    // change strategy to return RawProperty (package scope constructor)
    // when no match instead of null. This could only be done
    // when using the V3 API which added a NullValue type to distinct the cases
    // and the use of oneof which generates an enum of all possible values.
    return marshaller.fromProto(proto).build();
  }

  private void writeObject(ObjectOutputStream out) throws IOException {
    out.defaultWriteObject();
    out.writeObject(toPb().toByteArray());
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    byte[] bytes = (byte[]) in.readObject();
    tempValuePb = Value.parseFrom(bytes);
  }

  @SuppressWarnings("unused")
  protected Object readResolve() throws ObjectStreamException {
    return fromPb(tempValuePb);
  }
}
