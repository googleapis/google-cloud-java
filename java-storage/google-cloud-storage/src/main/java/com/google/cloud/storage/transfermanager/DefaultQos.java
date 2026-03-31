/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.storage.transfermanager;

final class DefaultQos implements Qos {

  private final long divideAndConquerThreshold;
  private final long parallelCompositeUploadThreshold;
  private boolean threadThresholdMet;

  private DefaultQos(
      long divideAndConquerThreshold,
      long parallelCompositeUploadThreshold,
      boolean threadThresholdMet) {
    this.divideAndConquerThreshold = divideAndConquerThreshold;
    this.parallelCompositeUploadThreshold = parallelCompositeUploadThreshold;
    this.threadThresholdMet = threadThresholdMet;
  }

  @Override
  public boolean divideAndConquer(long objectSize) {
    return objectSize > divideAndConquerThreshold;
  }

  @Override
  public boolean parallelCompositeUpload(long objectSize) {
    return threadThresholdMet && objectSize > parallelCompositeUploadThreshold;
  }

  static DefaultQos of(TransferManagerConfig config) {
    return new DefaultQos(
        128L * 1024 * 1024, 4L * config.getPerWorkerBufferSize(), config.getMaxWorkers() > 2);
  }
}
