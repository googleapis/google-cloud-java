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
package com.google.cloud.bigtable.admin.v2.models;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.BetaApi;
import com.google.auto.value.AutoValue;
import javax.annotation.Nonnull;

/**
 * Wrapper class for the {@link com.google.bigtable.admin.v2.Type} protobuf message.
 *
 * @see com.google.bigtable.admin.v2.Type
 */
@BetaApi
public interface Type {
  /**
   * These types are marker types that allow types to be used as the input to aggregate function.
   */
  public static interface SumAggregateInput extends Type {}

  public static interface MinAggregateInput extends Type {}

  public static interface MaxAggregateInput extends Type {}

  public static interface HllAggregateInput extends Type {}

  com.google.bigtable.admin.v2.Type toProto();

  static Type fromProto(com.google.bigtable.admin.v2.Type source) {
    switch (source.getKindCase()) {
      case INT64_TYPE:
        return Int64.fromProto(source.getInt64Type());
      case BYTES_TYPE:
        return Bytes.fromProto(source.getBytesType());
      case AGGREGATE_TYPE:
        return Aggregate.fromProto(source.getAggregateType());
      case KIND_NOT_SET:
        return Raw.create();
    }
    throw new UnsupportedOperationException();
  }

  /** The raw type denotes the absence of a type. */
  public static Raw raw() {
    return Raw.create();
  }

  /**
   * Creates a Bytes type with a "raw" encoding, leaving the bytes encoded as they are passed in.
   */
  public static Bytes rawBytes() {
    return Bytes.create(Bytes.Encoding.raw());
  }

  /** Creates a Bytes type with the specified encoding */
  public static Bytes bytes(Bytes.Encoding encoding) {
    return Bytes.create(encoding);
  }

  /**
   * Creates an Int64 type with a big-endian encoding. The bytes are then encoded in "raw" format.
   */
  public static Int64 bigEndianInt64() {
    return Int64.create(Int64.Encoding.BigEndianBytes.create());
  }

  /** Creates an Int64 type with the specified encoding. */
  public static Int64 int64(Int64.Encoding encoding) {
    return Int64.create(encoding);
  }

  /** Creates an Aggregate type with a SUM aggregator and Int64 input type. */
  public static Aggregate int64Sum() {
    return sum(bigEndianInt64());
  }

  /** Creates an Aggregate type with a SUM aggregator and specified input type. */
  public static Aggregate sum(SumAggregateInput inputType) {
    return Aggregate.create(inputType, Aggregate.Aggregator.Sum.create());
  }

  /** Creates an Aggregate type with a MIN aggregator and Int64 input type. */
  public static Aggregate int64Min() {
    return min(bigEndianInt64());
  }

  /** Creates an Aggregate type with a MIN aggregator and specified input type. */
  public static Aggregate min(MinAggregateInput inputType) {
    return Aggregate.create(inputType, Aggregate.Aggregator.Min.create());
  }

  /** Creates an Aggregate type with a MAX aggregator and Int64 input type. */
  public static Aggregate int64Max() {
    return max(bigEndianInt64());
  }

  /** Creates an Aggregate type with a MAX aggregator and specified input type. */
  public static Aggregate max(MaxAggregateInput inputType) {
    return Aggregate.create(inputType, Aggregate.Aggregator.Max.create());
  }

  /** Creates an Aggregate type with a HLL aggregator and Int64 input type. */
  public static Aggregate int64Hll() {
    return hll(bigEndianInt64());
  }

  /** Creates an Aggregate type with a HLL aggregator and specified input type. */
  public static Aggregate hll(HllAggregateInput inputType) {
    return Aggregate.create(inputType, Aggregate.Aggregator.Hll.create());
  }

  /** Represents a string of bytes with a specific encoding. */
  @AutoValue
  public abstract static class Bytes implements Type {
    public static Bytes create(Encoding encoding) {
      return new AutoValue_Type_Bytes(encoding);
    }

    @Nonnull
    public abstract Encoding getEncoding();

    @Override
    public com.google.bigtable.admin.v2.Type toProto() {
      com.google.bigtable.admin.v2.Type.Builder builder =
          com.google.bigtable.admin.v2.Type.newBuilder();
      builder.getBytesTypeBuilder().setEncoding(getEncoding().toProto());
      return builder.build();
    }

    static Bytes fromProto(com.google.bigtable.admin.v2.Type.Bytes source) {
      return create(Encoding.fromProto(source.getEncoding()));
    }

    public abstract static class Encoding {

      abstract com.google.bigtable.admin.v2.Type.Bytes.Encoding toProto();

      static Encoding fromProto(com.google.bigtable.admin.v2.Type.Bytes.Encoding source) {
        switch (source.getEncodingCase()) {
          case RAW:
          case ENCODING_NOT_SET:
            return Raw.create();
        }
        throw new UnsupportedOperationException();
      }

      public static Encoding raw() {
        return Raw.create();
      }

      @AutoValue
      public abstract static class Raw extends Encoding {
        public static Raw create() {
          return new AutoValue_Type_Bytes_Encoding_Raw();
        }

        private static final com.google.bigtable.admin.v2.Type.Bytes.Encoding PROTO_INSTANCE =
            com.google.bigtable.admin.v2.Type.Bytes.Encoding.newBuilder()
                .setRaw(com.google.bigtable.admin.v2.Type.Bytes.Encoding.Raw.getDefaultInstance())
                .build();

        @Override
        public com.google.bigtable.admin.v2.Type.Bytes.Encoding toProto() {
          return PROTO_INSTANCE;
        }
      }
    }
  }

  /** Represents a 64-bit integer with a specific encoding. */
  @AutoValue
  public abstract static class Int64
      implements SumAggregateInput, MinAggregateInput, MaxAggregateInput, HllAggregateInput {
    public static Int64 create(Encoding encoding) {
      return new AutoValue_Type_Int64(encoding);
    }

    @Nonnull
    public abstract Encoding getEncoding();

    public abstract static class Encoding {

      abstract com.google.bigtable.admin.v2.Type.Int64.Encoding toProto();

      static Encoding fromProto(com.google.bigtable.admin.v2.Type.Int64.Encoding source) {
        switch (source.getEncodingCase()) {
          case BIG_ENDIAN_BYTES:
            return BigEndianBytes.create();
          case ENCODING_NOT_SET:
            return BigEndianBytes.create();
        }
        throw new UnsupportedOperationException();
      }

      @AutoValue
      public abstract static class BigEndianBytes extends Encoding {

        public static BigEndianBytes create() {
          return new AutoValue_Type_Int64_Encoding_BigEndianBytes();
        }

        @Override
        public com.google.bigtable.admin.v2.Type.Int64.Encoding toProto() {
          com.google.bigtable.admin.v2.Type.Int64.Encoding.Builder builder =
              com.google.bigtable.admin.v2.Type.Int64.Encoding.newBuilder();
          builder.getBigEndianBytesBuilder();
          return builder.build();
        }
      }
    }

    @Override
    public com.google.bigtable.admin.v2.Type toProto() {
      com.google.bigtable.admin.v2.Type.Builder builder =
          com.google.bigtable.admin.v2.Type.newBuilder();
      builder.getInt64TypeBuilder().setEncoding(getEncoding().toProto());
      return builder.build();
    }

    static Int64 fromProto(com.google.bigtable.admin.v2.Type.Int64 source) {
      return Int64.create(Encoding.fromProto(source.getEncoding()));
    }
  }

  @AutoValue
  public abstract static class Raw implements Type {
    public static Raw create() {
      return new AutoValue_Type_Raw();
    }

    @Override
    public com.google.bigtable.admin.v2.Type toProto() {
      return com.google.bigtable.admin.v2.Type.getDefaultInstance();
    }
  }

  /**
   * A value that combines incremental updates into a summarized value.
   *
   * <p>Data is never directly written or read using type `Aggregate`. Writes will provide either
   * the `input_type` or `state_type`, and reads will always return the `state_type` .
   */
  @AutoValue
  public abstract static class Aggregate implements Type {
    public static Aggregate create(Type inputType, Aggregator aggregator) {
      return new AutoValue_Type_Aggregate(inputType, aggregator);
    }

    @Nonnull
    public abstract Type getInputType();

    @Nonnull
    public abstract Aggregator getAggregator();

    public abstract static class Aggregator {
      @AutoValue
      public abstract static class Sum extends Aggregator {
        public static Sum create() {
          return new AutoValue_Type_Aggregate_Aggregator_Sum();
        }

        @Override
        void buildTo(com.google.bigtable.admin.v2.Type.Aggregate.Builder builder) {
          builder.setSum(com.google.bigtable.admin.v2.Type.Aggregate.Sum.getDefaultInstance());
        }
      }

      @AutoValue
      public abstract static class Min extends Aggregator {
        public static Min create() {
          return new AutoValue_Type_Aggregate_Aggregator_Min();
        }

        @Override
        void buildTo(com.google.bigtable.admin.v2.Type.Aggregate.Builder builder) {
          builder.setMin(com.google.bigtable.admin.v2.Type.Aggregate.Min.getDefaultInstance());
        }
      }

      @AutoValue
      public abstract static class Max extends Aggregator {
        public static Max create() {
          return new AutoValue_Type_Aggregate_Aggregator_Max();
        }

        @Override
        void buildTo(com.google.bigtable.admin.v2.Type.Aggregate.Builder builder) {
          builder.setMax(com.google.bigtable.admin.v2.Type.Aggregate.Max.getDefaultInstance());
        }
      }

      @AutoValue
      public abstract static class Hll extends Aggregator {
        public static Hll create() {
          return new AutoValue_Type_Aggregate_Aggregator_Hll();
        }

        @Override
        void buildTo(com.google.bigtable.admin.v2.Type.Aggregate.Builder builder) {
          builder.setHllppUniqueCount(
              com.google.bigtable.admin.v2.Type.Aggregate.HyperLogLogPlusPlusUniqueCount
                  .getDefaultInstance());
        }
      }

      abstract void buildTo(com.google.bigtable.admin.v2.Type.Aggregate.Builder builder);
    }

    @Override
    public com.google.bigtable.admin.v2.Type toProto() {
      com.google.bigtable.admin.v2.Type.Builder typeBuilder =
          com.google.bigtable.admin.v2.Type.newBuilder();
      com.google.bigtable.admin.v2.Type.Aggregate.Builder aggregateBuilder =
          typeBuilder.getAggregateTypeBuilder();
      getAggregator().buildTo(aggregateBuilder);
      aggregateBuilder.setInputType(getInputType().toProto());
      return typeBuilder.build();
    }

    static Aggregate fromProto(com.google.bigtable.admin.v2.Type.Aggregate source) {
      Type inputType = Type.fromProto(source.getInputType());
      Aggregator aggregator = null;
      switch (source.getAggregatorCase()) {
        case SUM:
          aggregator = Aggregator.Sum.create();
          break;
        case MIN:
          aggregator = Aggregator.Min.create();
          break;
        case MAX:
          aggregator = Aggregator.Max.create();
          break;
        case HLLPP_UNIQUE_COUNT:
          aggregator = Aggregator.Hll.create();
          break;
        case AGGREGATOR_NOT_SET:
          throw new UnsupportedOperationException();
      }
      return Aggregate.create(inputType, checkNotNull(aggregator));
    }
  }
}
