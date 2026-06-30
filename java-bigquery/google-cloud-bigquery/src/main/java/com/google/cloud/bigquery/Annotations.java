/*
 * Copyright 2018 Google LLC
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

import com.google.api.client.util.Data;
import com.google.auto.value.AutoValue;
import com.google.auto.value.extension.memoized.Memoized;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@AutoValue
abstract class Annotations implements Serializable {
  private static final long serialVersionUID = 1L;
  static final Annotations ZERO = of(Collections.<String, String>emptyMap());

  @Nullable
  abstract Map<String, String> userMap();

  @Memoized
  @Nullable
  Map<String, String> toPb() {
    Map<String, String> userMap = userMap();
    if (userMap == null) {
      // converted to JSON null
      return Data.nullOf(HashMap.class);
    }
    if (userMap.isEmpty()) {
      // dropped from JSON
      return null;
    }
    HashMap<String, String> pbMap = new HashMap<>();
    for (Map.Entry<String, String> entry : userMap.entrySet()) {
      String key = entry.getKey();
      String val = entry.getValue();
      if (val == null) {
        val = Data.NULL_STRING;
      }
      pbMap.put(key, val);
    }
    return Collections.unmodifiableMap(pbMap);
  }

  private static Annotations of(Map<String, String> userMap) {
    Preconditions.checkArgument(
        userMap == null || !userMap.containsKey(null), "null keys are not supported");
    return new AutoValue_Annotations(userMap);
  }

  static Annotations fromUser(Map<String, String> map) {
    if (map == null || map instanceof ImmutableMap) {
      return of(map);
    }
    // Not ImmutableMap; we support null values!
    return of(Collections.unmodifiableMap(new HashMap<>(map)));
  }

  static Annotations fromPb(Map<String, String> pb) {
    if (Data.isNull(pb)) {
      return of(null);
    }
    if (pb == null || pb.isEmpty()) {
      return of(Collections.<String, String>emptyMap());
    }

    HashMap<String, String> map = new HashMap<>();
    for (Map.Entry<String, String> entry : pb.entrySet()) {
      String key = entry.getKey();
      String val = entry.getValue();
      if (Data.isNull(val)) {
        val = null;
      }
      map.put(key, val);
    }
    return of(Collections.unmodifiableMap(map));
  }
}
