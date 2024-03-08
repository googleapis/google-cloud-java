/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.models;

import com.google.api.core.BetaApi;
import com.google.auto.value.AutoValue;
import com.google.protobuf.ByteString;
import java.io.Serializable;
import javax.annotation.Nonnull;

/**
 * Wrapper class for the {@link com.google.bigtable.v2.Value} protobuf message.
 *
 * @see com.google.bigtable.v2.Value
 */
@BetaApi
public abstract class Value implements Serializable {
  private Value() {}

  public enum ValueType {
    Int64,
    RawTimestamp,
    RawValue
  }

  /** Creates a "raw" value that simply passes through "value" as raw byres. */
  public static Value rawValue(@Nonnull ByteString value) {
    return RawValue.create(value);
  }

  /** Creates a "raw" timestamp value that simply passes through "timestamp" as a long. */
  public static Value rawTimestamp(long timestamp) {
    return RawTimestamp.create(timestamp);
  }

  /** Creates an int64 value. */
  public static Value intValue(long value) {
    return IntValue.create(value);
  }

  @AutoValue
  public abstract static class IntValue extends Value {
    public static IntValue create(long value) {
      return new AutoValue_Value_IntValue(value);
    }

    public abstract long getValue();

    @Override
    public ValueType getValueType() {
      return ValueType.Int64;
    }

    @Override
    void buildTo(com.google.bigtable.v2.Value.Builder builder) {
      builder.setIntValue(getValue());
    }
  }

  @AutoValue
  public abstract static class RawTimestamp extends Value {
    public static RawTimestamp create(long value) {
      return new AutoValue_Value_RawTimestamp(value);
    }

    public abstract long getValue();

    @Override
    public ValueType getValueType() {
      return ValueType.RawTimestamp;
    }

    @Override
    void buildTo(com.google.bigtable.v2.Value.Builder builder) {
      builder.setRawTimestampMicros(getValue());
    }
  }

  @AutoValue
  public abstract static class RawValue extends Value {
    public static RawValue create(@Nonnull ByteString value) {
      return new AutoValue_Value_RawValue(value);
    }

    @Nonnull
    public abstract ByteString getValue();

    @Override
    public ValueType getValueType() {
      return ValueType.RawValue;
    }

    @Override
    void buildTo(com.google.bigtable.v2.Value.Builder builder) {
      builder.setRawValue(getValue());
    }
  }

  com.google.bigtable.v2.Value toProto() {
    com.google.bigtable.v2.Value.Builder builder = com.google.bigtable.v2.Value.newBuilder();
    buildTo(builder);
    return builder.build();
  }

  abstract void buildTo(com.google.bigtable.v2.Value.Builder builder);

  public abstract ValueType getValueType();

  public static Value fromProto(com.google.bigtable.v2.Value source) {
    switch (source.getKindCase()) {
      case INT_VALUE:
        return IntValue.create(source.getIntValue());
      case RAW_VALUE:
        return RawValue.create(source.getRawValue());
      case RAW_TIMESTAMP_MICROS:
        return RawTimestamp.create(source.getRawTimestampMicros());
    }
    throw new UnsupportedOperationException();
  }
}
