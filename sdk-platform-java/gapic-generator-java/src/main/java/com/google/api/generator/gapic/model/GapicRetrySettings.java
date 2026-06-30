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
import com.google.protobuf.Duration;
import io.grpc.serviceconfig.MethodConfig.RetryPolicy;

@AutoValue
public abstract class GapicRetrySettings {
  public enum Kind {
    NONE, // No retry policy and no timeout.
    NO_RETRY, // No retry policy, timeout only.
    FULL // Retry policy and timeout.
  };

  public abstract Duration timeout();

  public abstract RetryPolicy retryPolicy();

  public abstract Kind kind();

  public static Builder builder() {
    return new AutoValue_GapicRetrySettings.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setTimeout(Duration timeout);

    public abstract Builder setRetryPolicy(RetryPolicy retryPolicy);

    public abstract Builder setKind(Kind kind);

    public abstract GapicRetrySettings build();
  }
}
