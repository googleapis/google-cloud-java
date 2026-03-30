/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.storage.it.runner.registry;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Phaser;
import org.junit.runners.model.RunnerScheduler;

final class ParallelScheduler implements RunnerScheduler {

  private final ExecutorService executorService;
  private final Phaser childCounter;

  ParallelScheduler(ExecutorService executorService) {
    this.executorService = executorService;
    childCounter = new Phaser();
  }

  @Override
  public void schedule(Runnable childStatement) {
    childCounter.register();
    executorService.submit(
        () -> {
          try {
            childStatement.run();
          } finally {
            childCounter.arrive();
          }
        });
  }

  @Override
  public void finished() {
    childCounter.awaitAdvance(0);
  }
}
