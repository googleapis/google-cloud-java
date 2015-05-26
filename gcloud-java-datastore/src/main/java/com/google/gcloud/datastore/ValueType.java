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

import com.google.common.collect.ImmutableMap;

/**
 * The type of a Datastore property.
 *
 * @see <a href="http://cloud.google.com/datastore/docs/concepts/entities#Datastore_Properties_and_value_types">Google Cloud Datastore types</a>
 */
public enum ValueType {

  /**
   * Represents a {@code null} value.
   */
  NULL(NullValue.MARSHALLER),

  /**
   * Represents a {@code string} value.
   */
  STRING(StringValue.MARSHALLER),

  /**
   * Represents an entity value.
   */
  ENTITY(EntityValue.MARSHALLER),

  /**
   * Represents a {@code list} of {@link Value}s.
   */
  LIST(ListValue.MARSHALLER),

  /**
   * Represents a {@code key} as a value.
   */
  KEY(KeyValue.MARSHALLER),

  /**
   * Represents a {@code long} value.
   */
  LONG(LongValue.MARSHALLER),

  /**
   * Represents a {@code double} value.
   */
  DOUBLE(DoubleValue.MARSHALLER),

  /**
   * Represents a {@code boolean} value.
   */
  BOOLEAN(BooleanValue.MARSHALLER),

  /**
   * Represents a {@link DateTime} value.
   */
  DATE_TIME(DateTimeValue.MARSHALLER),

  /**
   * Represents a {@link Blob} value.
   */
  BLOB(BlobValue.MARSHALLER),

  /**
   * Represents a raw/unparsed value.
   */
  RAW_VALUE(RawValue.MARSHALLER);


  private static final ImmutableMap<Integer, ValueType> DESCRIPTOR_TO_TYPE_MAP;

  @SuppressWarnings("rawtypes") private final ValueMarshaller marshaller;

  static {
    ImmutableMap.Builder<Integer, ValueType> builder = ImmutableMap.builder();
    for (ValueType valueType : ValueType.values()) {
      int fieldId = valueType.getMarshaller().getProtoFieldId();
      if (fieldId > 0) {
        builder.put(fieldId, valueType);
      }
    }
    DESCRIPTOR_TO_TYPE_MAP = builder.build();
  }


  <V, P extends Value<V>, B extends ValueBuilder<V, P, B>> ValueType(ValueMarshaller<V, P, B> marshaller) {
    this.marshaller = marshaller;
  }

  ValueMarshaller getMarshaller() {
    return marshaller;
  }

  static ValueType getByDescriptorId(int descriptorId) {
    return DESCRIPTOR_TO_TYPE_MAP.get(descriptorId);
  }
}
