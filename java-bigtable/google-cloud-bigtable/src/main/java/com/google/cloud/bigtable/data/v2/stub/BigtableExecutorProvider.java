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
package com.google.cloud.bigtable.data.v2.stub;

import com.google.api.gax.core.ExecutorProvider;
import java.util.concurrent.ScheduledExecutorService;

// TODO: migrate to gax's FixedExecutorProvider once the change is merged
class BigtableExecutorProvider implements ExecutorProvider {

  private final ScheduledExecutorService executorService;
  private final boolean shouldAutoClose;

  @Override
  public boolean shouldAutoClose() {
    return shouldAutoClose;
  }

  @Override
  public ScheduledExecutorService getExecutor() {
    return executorService;
  }

  static BigtableExecutorProvider create(
      ScheduledExecutorService executor, boolean shouldAutoClose) {
    return new BigtableExecutorProvider(executor, shouldAutoClose);
  }

  private BigtableExecutorProvider(
      ScheduledExecutorService executorService, boolean shouldAutoClose) {
    this.shouldAutoClose = shouldAutoClose;
    this.executorService = executorService;
  }
}
