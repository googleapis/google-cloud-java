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

package com.google.cloud.spanner;

import javax.annotation.Nullable;

class RetryOnDifferentGrpcChannelException extends SpannerException {
  private final int channel;

  RetryOnDifferentGrpcChannelException(
      @Nullable String message, int channel, @Nullable Throwable cause) {
    // Note: We set retryable=false, as the exception is not retryable in the standard way.
    super(
        DoNotConstructDirectly.ALLOWED, ErrorCode.INTERNAL, /* retryable= */ false, message, cause);
    this.channel = channel;
  }

  int getChannel() {
    return this.channel;
  }
}
