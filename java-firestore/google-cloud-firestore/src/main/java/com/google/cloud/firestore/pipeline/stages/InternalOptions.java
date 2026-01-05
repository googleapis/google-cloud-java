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

package com.google.cloud.firestore.pipeline.stages;

import com.google.common.collect.ImmutableMap;
import com.google.firestore.v1.ArrayValue;
import com.google.firestore.v1.MapValue;
import com.google.firestore.v1.Value;

/**
 * Wither style Key/Value options object.
 *
 * <p>Basic `wither` functionality built upon `ImmutableMap<String, Value>`. Exposes methods to
 * construct, augment, and encode Kay/Value pairs. The wrapped collection `ImmutableMap<String,
 * Value>` is an implementation detail, not to be exposed, since more efficient implementations are
 * possible.
 */
final class InternalOptions {

  public static final InternalOptions EMPTY = new InternalOptions(ImmutableMap.of());

  final ImmutableMap<String, Value> options;

  InternalOptions(ImmutableMap<String, Value> options) {
    this.options = options;
  }

  public static InternalOptions of(String key, Value value) {
    return new InternalOptions(ImmutableMap.of(key, value));
  }

  InternalOptions with(String key, Value value) {
    ImmutableMap.Builder<String, Value> builder =
        ImmutableMap.builderWithExpectedSize(options.size() + 1);
    builder.putAll(options);
    builder.put(key, value);
    return new InternalOptions(builder.buildKeepingLast());
  }

  InternalOptions with(String key, Iterable<Value> values) {
    ArrayValue arrayValue = ArrayValue.newBuilder().addAllValues(values).build();
    return with(key, Value.newBuilder().setArrayValue(arrayValue).build());
  }

  InternalOptions with(String key, InternalOptions value) {
    return with(key, value.toValue());
  }

  InternalOptions adding(AbstractOptions<?> value) {
    ImmutableMap.Builder<String, Value> builder =
        ImmutableMap.builderWithExpectedSize(options.size() + value.toMap().size());
    builder.putAll(options);
    for (ImmutableMap.Entry<String, Value> entry : value.toMap().entrySet()) {
      builder.put(entry.getKey(), entry.getValue());
    }

    return new InternalOptions(builder.buildKeepingLast());
  }

  private Value toValue() {
    MapValue mapValue = MapValue.newBuilder().putAllFields(options).build();
    return Value.newBuilder().setMapValue(mapValue).build();
  }
}
