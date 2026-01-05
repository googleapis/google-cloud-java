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

import com.google.firestore.v1.Value;
import java.util.HashMap;
import java.util.Map;

public final class TestUtil {
  public static Map<String, Object> getAggregateSnapshotData(AggregateQuerySnapshot snapshot) {
    Map<String, Object> result = new HashMap<>();
    for (Map.Entry<String, Value> entry : snapshot.getData().entrySet()) {
      if (entry.getValue().hasIntegerValue()) {
        result.put(entry.getKey(), entry.getValue().getIntegerValue());
      } else if (entry.getValue().hasDoubleValue()) {
        result.put(entry.getKey(), entry.getValue().getDoubleValue());
      } else if (entry.getValue().hasNullValue()) {
        result.put(entry.getKey(), null);
      } else {
        throw new IllegalArgumentException("AggregateSnapshot has unrecognized value type");
      }
    }

    return result;
  }
}
