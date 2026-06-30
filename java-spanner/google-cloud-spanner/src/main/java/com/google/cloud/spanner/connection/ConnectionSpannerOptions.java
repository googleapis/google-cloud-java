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

package com.google.cloud.spanner.connection;

import com.google.cloud.spanner.SpannerOptions;

/**
 * This class is used for building {@link SpannerOptions} for {@link Connection} instances. It gives
 * access to (experimental) properties that are not public in the standard {@link SpannerOptions}
 * implementation.
 */
class ConnectionSpannerOptions extends SpannerOptions {
  public static Builder newBuilder() {
    return new Builder();
  }

  static class Builder extends SpannerOptions.Builder {
    Builder() {}

    @Override
    protected SpannerOptions.Builder setUseVirtualThreads(boolean useVirtualThreads) {
      return super.setUseVirtualThreads(useVirtualThreads);
    }

    @Override
    public ConnectionSpannerOptions build() {
      return new ConnectionSpannerOptions(this);
    }
  }

  ConnectionSpannerOptions(Builder builder) {
    super(builder);
  }
}
