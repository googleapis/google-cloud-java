/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.datastore;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.GcpLaunchStage;
import com.google.common.base.MoreObjects;
import com.google.datastore.v1.Value.ValueTypeCase;
import java.io.Serializable;
import java.util.Objects;

/**
 * Base class for all Google Cloud Datastore value types. All values must be associated with a
 * non-null content (except {@link NullValue}). All values are immutable (including their content).
 * To edit (a copy) use {@link #toBuilder()}. Unsupported value (deprecated or unrecognized) would
 * be represented by {@link RawValue}.
 *
 * @param <V> the type of the content for this value
 */
public abstract class Value<V> implements Serializable {

  private static final long serialVersionUID = 8532411152601335280L;

  private final ValueType valueType;
  private final boolean excludeFromIndexes;
  private final int meaning;
  private final V value;

  interface BuilderFactory<V, P extends Value<V>, B extends ValueBuilder<V, P, B>>
      extends java.io.Serializable {
    B newBuilder(V value);
  }

  abstract static class BaseMarshaller<V, P extends Value<V>, B extends ValueBuilder<V, P, B>>
      implements ValueMarshaller<V, P, B>, BuilderFactory<V, P, B> {

    private static final long serialVersionUID = -5224067974180563797L;

    @SuppressWarnings("deprecation")
    @Override
    public final B fromProto(com.google.datastore.v1.Value proto) {
      B builder = newBuilder(getValue(proto));
      builder.setExcludeFromIndexes(proto.getExcludeFromIndexes());
      builder.setMeaning(proto.getMeaning());
      return builder;
    }

    @SuppressWarnings("deprecation")
    @Override
    public final com.google.datastore.v1.Value toProto(P value) {
      com.google.datastore.v1.Value.Builder builder = com.google.datastore.v1.Value.newBuilder();
      builder.setExcludeFromIndexes(value.excludeFromIndexes());
      builder.setMeaning(value.getMeaning());
      setValue(value, builder);
      return builder.build();
    }

    BaseMarshaller() {}

    protected abstract V getValue(com.google.datastore.v1.Value from);

    protected abstract void setValue(P from, com.google.datastore.v1.Value.Builder to);
  }

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
      meaning = other.getMeaning();
      set(other.get());
      return self();
    }

    @Override
    public boolean getExcludeFromIndexes() {
      return excludeFromIndexes;
    }

    @Override
    public B setExcludeFromIndexes(boolean excludeFromIndexes) {
      this.excludeFromIndexes = excludeFromIndexes;
      return self();
    }

    @GcpLaunchStage.Deprecated
    @Override
    public int getMeaning() {
      return meaning;
    }

    @GcpLaunchStage.Deprecated
    @Override
    public B setMeaning(int meaning) {
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

  @SuppressWarnings("deprecation")
  <P extends Value<V>, B extends BaseBuilder<V, P, B>> Value(ValueBuilder<V, P, B> builder) {
    valueType = builder.getValueType();
    excludeFromIndexes = builder.getExcludeFromIndexes();
    meaning = builder.getMeaning();
    value = builder.get();
  }

  /** Returns the type of this value. */
  public final ValueType getType() {
    return valueType;
  }

  /** Returns whether this value should be excluded from indexes. */
  public final boolean excludeFromIndexes() {
    return excludeFromIndexes;
  }

  @GcpLaunchStage.Deprecated
  final int getMeaning() {
    return meaning;
  }

  public final V get() {
    return value;
  }

  public abstract ValueBuilder<?, ?, ?> toBuilder();

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("valueType", valueType)
        .add("excludeFromIndexes", excludeFromIndexes)
        .add("meaning", meaning)
        .add("value", value)
        .toString();
  }

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

  @SuppressWarnings("unchecked")
  com.google.datastore.v1.Value toPb() {
    return getType().getMarshaller().toProto(this);
  }

  static Value<?> fromPb(com.google.datastore.v1.Value proto) {
    ValueTypeCase descriptorId = proto.getValueTypeCase();
    ValueType valueType = ValueType.getByDescriptorId(descriptorId.getNumber());
    return valueType == null
        ? RawValue.MARSHALLER.fromProto(proto).build()
        : valueType.getMarshaller().fromProto(proto).build();
  }
}
