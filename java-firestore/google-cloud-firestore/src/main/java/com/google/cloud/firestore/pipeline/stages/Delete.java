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
import com.google.firestore.v1.Value;
import java.util.ArrayList;

@InternalApi
public final class Delete extends Stage {
  private Delete(InternalOptions options) {
    super("delete", options);
  }

  @BetaApi
  public Delete() {
    this(InternalOptions.EMPTY);
  }

  @Override
  Iterable<Value> toStageArgs() {
    return new ArrayList<>();
  }
}
