/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.datastore.DatastoreV1;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.InvalidProtocolBufferException;

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


  private final transient ValueType valueType;
  private final transient Boolean indexed;
  private final transient Integer meaning;
  private final transient V value;

  interface BuilderFactory<V, P extends Value<V>, B extends ValueBuilder<V, P, B>>
      extends java.io.Serializable {
    B newBuilder(V value);
  }

  abstract static class BaseMarshaller<V, P extends Value<V>, B extends ValueBuilder<V, P, B>>
      implements ValueMarshaller<V, P, B>, BuilderFactory<V, P, B> {

    private static final long serialVersionUID = 2880767488942992985L;

    @SuppressWarnings("deprecation")
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

    @SuppressWarnings("deprecation")
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

  @SuppressWarnings("deprecation")
  abstract static class BaseBuilder<V, P extends Value<V>, B extends BaseBuilder<V, P, B>>
      implements ValueBuilder<V, P, B> {

    private final ValueType valueType;
    private Boolean indexed;
    private Integer meaning;
    private V value;

    BaseBuilder(ValueType valueType) {
      this.valueType = valueType;
    }

    @Override
    public ValueType getValueType() {
      return valueType;
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

  <P extends Value<V>, B extends BaseBuilder<V, P, B>> Value(ValueBuilder<V, P, B> builder) {
    valueType = builder.getValueType();
    indexed = builder.getIndexed();
    meaning = builder.getMeaning();
    value = builder.get();
  }

  public final ValueType type() {
    return valueType;
  }

  public final boolean hasIndexed() {
    return indexed != null;
  }

  public final Boolean indexed() {
    return indexed;
  }

  @Deprecated
  public final boolean hasMeaning() {
    return meaning != null;
  }

  @Deprecated
  public final Integer meaning() {
    return meaning;
  }

  public final V get() {
    return value;
  }

  public abstract ValueBuilder<?, ?, ?> toBuilder();

  @Override
  public int hashCode() {
    return Objects.hash(valueType, indexed, meaning, value);
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
    return Objects.equals(valueType, other.valueType)
        && Objects.equals(indexed, other.indexed)
        && Objects.equals(meaning, other.meaning)
        && Objects.equals(value, other.value);
  }

  @Override
  @SuppressWarnings("unchecked")
  protected DatastoreV1.Value toPb() {
    return type().getMarshaller().toProto(this);
  }

  static Value<?> fromPb(DatastoreV1.Value proto) {
    for (Entry<FieldDescriptor, Object> entry : proto.getAllFields().entrySet()) {
      FieldDescriptor descriptor = entry.getKey();
      if (descriptor.getName().endsWith("_value")) {
        ValueType valueType = ValueType.getByDescriptorId(descriptor.getNumber());
        if (valueType == null) {
          // unsupported type
          return RawValue.MARSHALLER.fromProto(proto).build();
        }
        return valueType.getMarshaller().fromProto(proto).build();
      }
    }
    return NullValue.MARSHALLER.fromProto(proto).build();
  }

  @Override
  protected Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
    return fromPb(DatastoreV1.Value.parseFrom(bytesPb));
  }
}
