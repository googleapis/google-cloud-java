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

package com.google.cloud.firestore.pipeline.stages;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.cloud.firestore.PipelineUtils;
import com.google.firestore.v1.Value;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@InternalApi
public final class Literals extends Stage {

  private final List<Map<String, Object>> data;

  @BetaApi
  public Literals(Map<String, Object>... data) {
    super("literals", InternalOptions.EMPTY);
    this.data = Arrays.asList(data);
  }

  @Override
  Iterable<Value> toStageArgs() {
    List<Value> args = new ArrayList<>();
    for (Map<String, Object> map : data) {
      args.add(encodeLiteralMap(map));
    }
    return args;
  }

  private Value encodeLiteralMap(Map<?, ?> map) {
    com.google.firestore.v1.MapValue.Builder mapValue =
        com.google.firestore.v1.MapValue.newBuilder();
    for (Map.Entry<?, ?> entry : map.entrySet()) {
      String key = String.valueOf(entry.getKey());
      Object v = entry.getValue();
      if (v instanceof com.google.cloud.firestore.pipeline.expressions.Expression) {
        mapValue.putFields(
            key,
            PipelineUtils.encodeValue(
                (com.google.cloud.firestore.pipeline.expressions.Expression) v));
      } else if (v instanceof Map) {
        mapValue.putFields(key, encodeLiteralMap((Map<?, ?>) v));
      } else {
        mapValue.putFields(key, PipelineUtils.encodeValue(v));
      }
    }
    return Value.newBuilder().setMapValue(mapValue.build()).build();
  }
}
