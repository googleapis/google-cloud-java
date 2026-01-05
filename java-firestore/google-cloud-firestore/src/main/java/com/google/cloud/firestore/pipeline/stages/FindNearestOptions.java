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

import static com.google.cloud.firestore.pipeline.expressions.Expression.field;

import com.google.api.core.BetaApi;
import com.google.cloud.firestore.pipeline.expressions.Field;

@BetaApi
public final class FindNearestOptions extends AbstractOptions<FindNearestOptions> {

  public FindNearestOptions() {
    this(InternalOptions.EMPTY);
  }

  private FindNearestOptions(InternalOptions options) {
    super(options);
  }

  @Override
  FindNearestOptions self(InternalOptions options) {
    return new FindNearestOptions(options);
  }

  public FindNearestOptions withLimit(long limit) {
    return with("limit", limit);
  }

  public FindNearestOptions withDistanceField(Field distanceField) {
    return with("distance_field", distanceField);
  }

  public FindNearestOptions withDistanceField(String distanceField) {
    return withDistanceField(field(distanceField));
  }
}
