/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigquery;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
final class ArrowSerializationOptionsConverter {

  private ArrowSerializationOptionsConverter() {}

  static com.google.api.services.bigquery.model.@Nullable ArrowSerializationOptions toPb(
      @Nullable ArrowSerializationOptions options) {
    if (options == null) {
      return null;
    }
    com.google.api.services.bigquery.model.ArrowSerializationOptions optionsPb =
        new com.google.api.services.bigquery.model.ArrowSerializationOptions();
    optionsPb.setBufferCompression(options.getBufferCompression().getValue());
    optionsPb.setPicosTimestampPrecision(options.getPicosTimestampPrecision().getValue());
    return optionsPb;
  }

  static @Nullable ArrowSerializationOptions fromPb(@Nullable Object optionsPbObj) {
    if (optionsPbObj == null) {
      return null;
    }
    com.google.api.services.bigquery.model.ArrowSerializationOptions optionsPb =
        (com.google.api.services.bigquery.model.ArrowSerializationOptions) optionsPbObj;
    ArrowSerializationOptions.Builder builder = ArrowSerializationOptions.newBuilder();
    if (optionsPb.getBufferCompression() != null) {
      for (ArrowSerializationOptions.CompressionCodec codec :
          ArrowSerializationOptions.CompressionCodec.values()) {
        if (codec.getValue().equalsIgnoreCase(optionsPb.getBufferCompression())) {
          builder.setBufferCompression(codec);
          break;
        }
      }
    }
    if (optionsPb.getPicosTimestampPrecision() != null) {
      for (ArrowSerializationOptions.TimestampPrecision precision :
          ArrowSerializationOptions.TimestampPrecision.values()) {
        if (precision.getValue().equalsIgnoreCase(optionsPb.getPicosTimestampPrecision())) {
          builder.setPicosTimestampPrecision(precision);
          break;
        }
      }
    }
    return builder.build();
  }
}
