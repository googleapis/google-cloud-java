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

import com.google.auto.value.AutoValue;

/** Options used to configure explain queries. */
@AutoValue
public abstract class ExplainOptions {
  /**
   * Returns whether analyzing the query is enabled. If enabled, the query will be executed and
   * execution statistics will be returned as part of the [ExplainResults]{@link ExplainResults}.
   */
  public abstract boolean getAnalyze();

  public static Builder builder() {
    return new AutoValue_ExplainOptions.Builder().setAnalyze(false);
  }

  public abstract Builder toBuilder();

  public com.google.firestore.v1.ExplainOptions toProto() {
    return com.google.firestore.v1.ExplainOptions.newBuilder()
        .setAnalyze(this.getAnalyze())
        .build();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * Sets whether analyzing the query is enabled. If true, the query will be executed and
     * execution statistics will be returned as part of the [ExplainResults]{@link ExplainResults}.
     */
    public abstract Builder setAnalyze(boolean enabled);

    public abstract ExplainOptions build();
  }
}
