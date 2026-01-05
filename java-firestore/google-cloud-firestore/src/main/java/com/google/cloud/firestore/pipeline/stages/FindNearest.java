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

import static com.google.cloud.firestore.PipelineUtils.encodeValue;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.cloud.firestore.VectorValue;
import com.google.cloud.firestore.pipeline.expressions.Expression;
import com.google.common.collect.ImmutableList;
import com.google.firestore.v1.Value;

@BetaApi
public final class FindNearest extends Stage {

  public static final class DistanceMeasure {

    final String protoString;

    private DistanceMeasure(String protoString) {
      this.protoString = protoString;
    }

    public static final DistanceMeasure EUCLIDEAN = new DistanceMeasure("euclidean");
    public static final DistanceMeasure COSINE = new DistanceMeasure("cosine");
    public static final DistanceMeasure DOT_PRODUCT = new DistanceMeasure("dot_product");

    public static DistanceMeasure generic(String name) {
      return new DistanceMeasure(name);
    }

    Value toProto() {
      return encodeValue(protoString);
    }
  }

  private final Expression property;
  private final VectorValue vector;
  private final DistanceMeasure distanceMeasure;

  @InternalApi
  public FindNearest(
      Expression property,
      VectorValue vector,
      DistanceMeasure distanceMeasure,
      FindNearestOptions options) {
    super("find_nearest", options.options);
    this.property = property;
    this.vector = vector;
    this.distanceMeasure = distanceMeasure;
  }

  @Override
  Iterable<Value> toStageArgs() {
    return ImmutableList.of(encodeValue(property), encodeValue(vector), distanceMeasure.toProto());
  }
}
