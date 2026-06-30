// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.generator.gapic.model;

import com.google.auto.value.AutoValue;

/** Represents the LRO retry settings in a gapic.yaml file. */
@AutoValue
public abstract class GapicLroRetrySettings {
  public abstract String protoPakkage();

  public abstract String serviceName();

  public abstract String methodName();

  public abstract long initialPollDelayMillis();

  public abstract double pollDelayMultiplier();

  public abstract long maxPollDelayMillis();

  public abstract long totalPollTimeoutMillis();

  public static Builder builder() {
    return new AutoValue_GapicLroRetrySettings.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setProtoPakkage(String protoPakkage);

    public abstract Builder setServiceName(String serviceName);

    public abstract Builder setMethodName(String methodName);

    public abstract Builder setInitialPollDelayMillis(long initialPollDelayMillis);

    public abstract Builder setPollDelayMultiplier(double pollDelayMultiplier);

    public abstract Builder setMaxPollDelayMillis(long maxPollDelayMillis);

    public abstract Builder setTotalPollTimeoutMillis(long totalPollTimeoutMillis);

    public abstract GapicLroRetrySettings build();
  }
}
