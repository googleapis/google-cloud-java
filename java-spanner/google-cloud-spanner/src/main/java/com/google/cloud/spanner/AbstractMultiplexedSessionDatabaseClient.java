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

import com.google.cloud.Timestamp;

/**
 * Base class for the Multiplexed Session {@link DatabaseClient} implementation. Throws {@link
 * UnsupportedOperationException} for all methods that are currently not supported for multiplexed
 * sessions. The concrete implementation implements the methods that are supported with multiplexed
 * sessions.
 */
abstract class AbstractMultiplexedSessionDatabaseClient implements DatabaseClient {

  @Override
  public Timestamp writeAtLeastOnce(Iterable<Mutation> mutations) throws SpannerException {
    return writeAtLeastOnceWithOptions(mutations).getCommitTimestamp();
  }
}
