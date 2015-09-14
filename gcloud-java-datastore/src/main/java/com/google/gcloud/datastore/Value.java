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
public abstract class Value<V> extends Serializable<com.google.datastore.v1beta3.Value> {

  private static final long serialVersionUID = -1899638277588872742L;


  private final transient ValueType valueType;
  private final transient boolean excludeFromIndexes;
  private final transient int meaning;
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
    public final B fromProto(com.google.datastore.v1beta3.Value proto) {
      B builder = newBuilder(getValue(proto));
      builder.excludeFromIndexes(proto.getExcludeFromIndexes());
      builder.meaning(proto.getMeaning());
      return builder;
    }

    @SuppressWarnings("deprecation")
    @Override
    public final com.google.datastore.v1beta3.Value toProto(P value) {
      com.google.datastore.v1beta3.Value.Builder builder = com.google.datastore.v1beta3.Value.newBuilder();
      builder.setExcludeFromIndexes(value.excludeFromIndexes());
      builder.setMeaning(value.meaning());
      setValue(value, builder);
      return builder.build();
    }

    protected abstract V getValue(com.google.datastore.v1beta3.Value from);

    protected abstract void setValue(P from, com.google.datastore.v1beta3.Value.Builder to);
  }

  @SuppressWarnings("deprecation")
  abstract static class BaseBuilder<V, P extends Value<V>, B extends BaseBuilder<V, P, B>>
      implements ValueBuilder<V, P, B> {

    private final ValueType valueType;
    private boolean excludeFromIndexes;
    private int meaning;
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
      excludeFromIndexes = other.excludeFromIndexes();
      meaning = other.meaning();
      set(other.get());
      return self();
    }

    @Override
    public boolean getExcludeFromIndexes() {
      return excludeFromIndexes;
    }

    @Override
    public B excludeFromIndexes(boolean excludeFromIndexes) {
      this.excludeFromIndexes = excludeFromIndexes;
      return self();
    }

    @Override
    public int getMeaning() {
      return meaning;
    }

    @Override
    public B meaning(int meaning) {
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
    excludeFromIndexes = builder.getExcludeFromIndexes();
    meaning = builder.getMeaning();
    value = builder.get();
  }

  public final ValueType type() {
    return valueType;
  }

  public final boolean excludeFromIndexes() {
    return excludeFromIndexes;
  }

  @Deprecated
  public final int meaning() {
    return meaning;
  }

  public final V get() {
    return value;
  }

  public abstract ValueBuilder<?, ?, ?> toBuilder();

  @Override
  public int hashCode() {
    return Objects.hash(valueType, excludeFromIndexes, meaning, value);
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
        && Objects.equals(excludeFromIndexes, other.excludeFromIndexes)
        && Objects.equals(meaning, other.meaning)
        && Objects.equals(value, other.value);
  }

  @Override
  @SuppressWarnings("unchecked")
  protected com.google.datastore.v1beta3.Value toPb() {
    return type().getMarshaller().toProto(this);
  }

  static Value<?> fromPb(com.google.datastore.v1beta3.Value proto) {
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
    return fromPb(com.google.datastore.v1beta3.Value.parseFrom(bytesPb));
  }
}
