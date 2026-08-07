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

import com.google.api.services.bigquery.model.ArrowSerializationOptions;

final class ArrowSerializationOptionsConverter {

  private ArrowSerializationOptionsConverter() {}

  static ArrowSerializationOptions toPb(
      com.google.cloud.bigquery.ArrowSerializationOptions options) {
    if (options == null) {
      return null;
    }
    ArrowSerializationOptions optionsPb = new ArrowSerializationOptions();
    if (options.getBufferCompression() != null) {
      optionsPb.setBufferCompression(options.getBufferCompression());
    }
    if (options.getPicosTimestampPrecision() != null) {
      optionsPb.setPicosTimestampPrecision(options.getPicosTimestampPrecision());
    }
    return optionsPb;
  }

  static com.google.cloud.bigquery.ArrowSerializationOptions fromPb(
      ArrowSerializationOptions optionsPb) {
    if (optionsPb == null) {
      return null;
    }
    return com.google.cloud.bigquery.ArrowSerializationOptions.newBuilder()
        .setBufferCompression(optionsPb.getBufferCompression())
        .setPicosTimestampPrecision(optionsPb.getPicosTimestampPrecision())
        .build();
  }
}
