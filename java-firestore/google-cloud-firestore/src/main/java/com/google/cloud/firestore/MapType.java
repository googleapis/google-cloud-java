/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.firestore;

abstract class MapType {
  static final String RESERVED_MAP_KEY = "__type__";
  static final String RESERVED_MAP_KEY_VECTOR_VALUE = "__vector__";
  static final String VECTOR_MAP_VECTORS_KEY = "value";

  // For MinKey type
  static final String RESERVED_MIN_KEY = "__min__";

  // For MaxKey type
  static final String RESERVED_MAX_KEY = "__max__";

  // For Regex type
  static final String RESERVED_REGEX_KEY = "__regex__";
  static final String RESERVED_REGEX_PATTERN_KEY = "pattern";
  static final String RESERVED_REGEX_OPTIONS_KEY = "options";

  // For ObjectId type
  static final String RESERVED_OBJECT_ID_KEY = "__oid__";

  // For Int32 type
  static final String RESERVED_INT32_KEY = "__int__";

  // For Decimal128 type.
  static final String RESERVED_DECIMAL128_KEY = "__decimal128__";

  // For RequestTimestamp
  static final String RESERVED_BSON_TIMESTAMP_KEY = "__request_timestamp__";
  static final String RESERVED_BSON_TIMESTAMP_SECONDS_KEY = "seconds";
  static final String RESERVED_BSON_TIMESTAMP_INCREMENT_KEY = "increment";

  // For BSON Binary Data
  static final String RESERVED_BSON_BINARY_KEY = "__binary__";
}
