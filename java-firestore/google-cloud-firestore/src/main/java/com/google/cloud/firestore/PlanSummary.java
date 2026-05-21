/*
 * Copyright 2017 Google LLC
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

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;

/** A Plan contains information about the planning stage of a query. */
public final class PlanSummary {
  private final @Nonnull List<Map<String, Object>> indexesUsed;

  PlanSummary(com.google.firestore.v1.PlanSummary proto) {
    indexesUsed = Lists.transform(proto.getIndexesUsedList(), UserDataConverter::decodeStruct);
  }

  /*
   * Returns the indexes used to serve the query.
   */
  @Nonnull
  public List<Map<String, Object>> getIndexesUsed() {
    return this.indexesUsed;
  }
}
