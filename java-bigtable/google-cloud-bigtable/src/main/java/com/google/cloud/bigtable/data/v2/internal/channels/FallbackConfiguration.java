/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.bigtable.data.v2.internal.channels;

import com.google.auto.value.AutoValue;
import java.time.Duration;

@AutoValue
public abstract class FallbackConfiguration {
  public abstract boolean isEnabled();

  public abstract double getErrorRate();

  public abstract Duration getCheckInterval();

  public abstract String getPrimaryName();

  public abstract String getFallbackName();

  public abstract ChannelPool getPrimaryChannelPool();

  public abstract ChannelPool getFallbackChannelPool();

  public abstract Builder toBuilder();

  public static Builder builder() {
    return new AutoValue_FallbackConfiguration.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setEnabled(boolean enabled);

    public abstract Builder setErrorRate(double errorRate);

    public abstract Builder setCheckInterval(Duration checkInterval);

    protected abstract Builder setPrimaryName(String primaryName);

    protected abstract Builder setFallbackName(String fallbackName);

    protected abstract Builder setPrimaryChannelPool(ChannelPool primaryChannelPool);

    protected abstract Builder setFallbackChannelPool(ChannelPool fallbackChannelPool);

    public Builder setPrimary(String name, ChannelPool pool) {
      return setPrimaryName(name).setPrimaryChannelPool(pool);
    }

    public Builder setFallback(String name, ChannelPool pool) {
      return setFallbackName(name).setFallbackChannelPool(pool);
    }

    public abstract FallbackConfiguration build();
  }
}
