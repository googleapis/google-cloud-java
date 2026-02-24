/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigtable.data.v2.internal.csm.attributes;

import com.google.auto.value.AutoValue;

/** Method specific attributes. */
@AutoValue
public abstract class MethodInfo {

  /** The name of the method. ie "Bigtable.ReadRow" */
  public abstract String getName();

  /** If the method is streaming (ie a scan). */
  public abstract boolean getStreaming();

  public static Builder builder() {
    return new AutoValue_MethodInfo.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setName(String name);

    public abstract Builder setStreaming(boolean isStreaming);

    public abstract MethodInfo build();
  }
}
