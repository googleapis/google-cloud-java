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

package com.google.cloud.storage;

import com.google.api.gax.retrying.ResultRetryAlgorithm;

/**
 * An implementation of {@link StorageRetryStrategy} where a single algorithm will be returned for
 * both idempotent and non-idempotent cases.
 */
final class UniformStorageRetryStrategy implements StorageRetryStrategy {

  private static final long serialVersionUID = -8606685654893234472L;
  private final ResultRetryAlgorithm<?> algorithm;

  public UniformStorageRetryStrategy(ResultRetryAlgorithm<?> algorithm) {
    this.algorithm = algorithm;
  }

  @Override
  public ResultRetryAlgorithm<?> getIdempotentHandler() {
    return algorithm;
  }

  @Override
  public ResultRetryAlgorithm<?> getNonidempotentHandler() {
    return algorithm;
  }
}
