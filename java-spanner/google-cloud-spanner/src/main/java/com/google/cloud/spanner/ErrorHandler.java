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

import com.google.api.core.BetaApi;
import javax.annotation.Nonnull;

/**
 * The {@link ErrorHandler} interface can be used to implement custom error and retry handling for
 * specific cases. The default implementation does nothing and falls back to the standard error and
 * retry handling in Gax and the Spanner client.
 */
@BetaApi
interface ErrorHandler {
  @Nonnull
  Throwable translateException(@Nonnull Throwable exception);

  int getMaxAttempts();

  class DefaultErrorHandler implements ErrorHandler {
    static final DefaultErrorHandler INSTANCE = new DefaultErrorHandler();

    private DefaultErrorHandler() {}

    @Nonnull
    @Override
    public Throwable translateException(@Nonnull Throwable exception) {
      return exception;
    }

    @Override
    public int getMaxAttempts() {
      return 0;
    }
  }
}
