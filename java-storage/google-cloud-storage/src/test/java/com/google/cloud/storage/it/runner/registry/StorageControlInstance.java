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

package com.google.cloud.storage.it.runner.registry;

import com.google.storage.control.v2.StorageControlClient;
import com.google.storage.control.v2.StorageControlSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

final class StorageControlInstance implements ManagedLifecycle {

  private final StorageControlSettings settings;

  private StorageControlClient ctrl;

  StorageControlInstance(StorageControlSettings settings) {
    this.settings = settings;
  }

  StorageControlClient getCtrl() {
    return ctrl;
  }

  @Override
  public Object get() {
    return ctrl;
  }

  @Override
  public void start() {
    try {
      ctrl = StorageControlClient.create(settings);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void stop() {
    try {
      ctrl.shutdownNow();
      ctrl.awaitTermination(30, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new RuntimeException(e);
    }
  }
}
