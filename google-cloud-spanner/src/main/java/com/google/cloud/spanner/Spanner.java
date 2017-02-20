/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

import com.google.cloud.Service;
import com.google.common.util.concurrent.ListenableFuture;

/** An interface for Cloud Spanner. */
public interface Spanner extends Service<SpannerOptions> {
  /** Returns a {@code DatabaseAdminClient} to do admin operations on Cloud Spanner databases. */
  DatabaseAdminClient getDatabaseAdminClient();

  /** Returns an {@code InstanceAdminClient} to do admin operations on Cloud Spanner instances. */
  InstanceAdminClient getInstanceAdminClient();

  /**
   * Returns a {@code DatabaseClient} for the given database. It uses a pool of sessions to talk to
   * the database.
   */
  DatabaseClient getDatabaseClient(DatabaseId db);

  /**
   * Closes all the clients associated with this instance and frees up all the resources. This
   * method does not block. Return future will complete when cleanup is done. TODO(user): Add
   * logging and tracking of leaked sessions.
   */
  ListenableFuture<Void> closeAsync();
}
