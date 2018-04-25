/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.gaxx.retrying;

import com.google.api.core.AbstractApiFuture;
import com.google.api.core.InternalApi;

// TODO: Remove this class once the gax version becomes public
/**
 * A future which cannot be cancelled from the external package. Its a copy of {@link
 * com.google.api.gax.retrying.NonCancellableFuture}, which is marked as {@link InternalApi}.
 *
 * <p>For internal use, public for technical reasons.
 *
 * @param <ResponseT> future response type
 */
@InternalApi
public final class NonCancellableFuture<ResponseT> extends AbstractApiFuture<ResponseT> {
  @Override
  public boolean cancel(boolean mayInterruptIfRunning) {
    return false;
  }

  void cancelPrivately() {
    super.cancel(false);
  }

  boolean setPrivately(ResponseT value) {
    return super.set(value);
  }

  boolean setExceptionPrivately(Throwable throwable) {
    return super.setException(throwable);
  }
}
