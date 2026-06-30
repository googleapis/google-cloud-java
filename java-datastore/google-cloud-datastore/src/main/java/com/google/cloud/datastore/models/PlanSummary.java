/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.datastore.models;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.cloud.Structs;
import com.google.common.base.Objects;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** Model class for {@link com.google.datastore.v1.PlanSummary} */
@BetaApi
public class PlanSummary {
  private final List<Map<String, Object>> indexesUsed;

  @InternalApi
  public PlanSummary(com.google.datastore.v1.PlanSummary proto) {
    this.indexesUsed =
        proto.getIndexesUsedList().stream().map(Structs::asMap).collect(Collectors.toList());
  }

  /** Returns the indexes selected for the query. */
  public List<Map<String, Object>> getIndexesUsed() {
    return indexesUsed;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof PlanSummary)) return false;
    PlanSummary planSummary = (PlanSummary) o;
    return Objects.equal(indexesUsed, planSummary.indexesUsed);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(indexesUsed);
  }
}
