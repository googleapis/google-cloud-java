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

/**
 * An interface for Cloud Spanner. Typically, there would only be one instance of this for the
 * lifetime of the application which must be closed by invoking {@link #close()} when it is no
 * longer needed. Failure to do so may result in leaking session resources and exhausting session
 * quota.
 */
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
   * Returns a {@code BatchClient} to do batch operations on Cloud Spanner databases. Batch client
   * is useful when one wants to read/query a large amount of data from Cloud
   * Spanner across multiple processes, even across different machines. It allows to create
   * partitions of Cloud Spanner database and then read/query over each partition independently
   * yet at the same snapshot.
   *
   * <p> For all other use cases, {@code DatabaseClient} is more appropriate and performant.
   */
  BatchClient getBatchClient(DatabaseId db);

  /**
   * Closes all the clients associated with this instance and frees up all the resources. This
   * method will block until it can clean up all the resources. Specifically, it deletes all the
   * underlying sessions (which involves rpcs) and closes all the gRPC channels. Once this method
   * called, this object is no longer usable. It is strongly advised to call this method when you
   * are done with the {@code Spanner} object, typically when your application shuts down. There is
   * a hard limit on number of sessions in Cloud Spanner and not calling this method can lead to
   * unused sessions piling up on the backend.
   */
  void close();
}
