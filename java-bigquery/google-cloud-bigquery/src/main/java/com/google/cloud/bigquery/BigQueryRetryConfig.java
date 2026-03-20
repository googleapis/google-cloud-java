/*
 * Copyright 2021 Google LLC
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
package com.google.cloud.bigquery;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableSet;

public class BigQueryRetryConfig {
  private final ImmutableSet<String> retriableErrorMessages;
  private final ImmutableSet<String> retriableRegExes;

  private BigQueryRetryConfig(Builder builder) {
    retriableErrorMessages = builder.retriableErrorMessages.build();
    retriableRegExes = builder.retriableRegExes.build();
  }

  public ImmutableSet<String> getRetriableErrorMessages() {
    return retriableErrorMessages;
  }

  public ImmutableSet<String> getRetriableRegExes() {
    return retriableRegExes;
  }

  // BigQueryRetryConfig builder
  public static class Builder {
    private final ImmutableSet.Builder<String> retriableErrorMessages = ImmutableSet.builder();
    private final ImmutableSet.Builder<String> retriableRegExes = ImmutableSet.builder();

    private Builder() {}

    public final Builder retryOnMessage(String... errorMessages) {
      for (String errorMessage : errorMessages) {
        retriableErrorMessages.add(checkNotNull(errorMessage));
      }
      return this;
    }

    public final Builder retryOnRegEx(String... regExPatterns) {
      for (String regExPattern : regExPatterns) {
        retriableRegExes.add(checkNotNull(regExPattern));
      }
      return this;
    }

    public BigQueryRetryConfig build() {
      return new BigQueryRetryConfig(this);
    }
  }

  public static Builder newBuilder() {
    return new Builder();
  }
}
