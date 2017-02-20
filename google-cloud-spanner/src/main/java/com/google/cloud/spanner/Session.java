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

/**
 * A {@code Session} can be used to perform transactions that read and/or modify data in a Cloud
 * Spanner database.
 *
 * <p>Sessions can only execute one transaction at a time. To execute multiple concurrent
 * read-write/write-only transactions, create multiple sessions. Note that standalone reads and
 * queries use a transaction internally, and count toward the one transaction limit.
 *
 * <p>Cloud Spanner limits the number of sessions that can exist at any given time; thus, it is a
 * good idea to delete idle and/or unneeded sessions. Aside from explicit deletes, Cloud Spanner can
 * delete sessions for which no operations are sent for more than an hour, or due to internal
 * errors. If a session is deleted, requests to it return {@link ErrorCode#NOT_FOUND}.
 *
 * <p>Idle sessions can be kept alive by sending a trivial SQL query periodically, for example,
 * {@code SELECT 1}.
 *
 * <p>Sessions are long-lived objects intended to be reused for many consecutive operations; a
 * typical application will maintain a pool of sessions to use during its lifetime.
 *
 * <p>Since only one transaction can be performed at a time within any given session, instances
 * require external synchronization; {@code Session} implementations are not required to be
 * thread-safe.
 */
public interface Session extends DatabaseClient, AutoCloseable {
  /** Returns the resource name associated with this session. */
  String getName();

  /**
   * Prepares a transaction for use by a subsequent {@link #readWriteTransaction()} or {@link
   * #write(Iterable)} call. It is not necessary to call this method before running a transaction or
   * performing a write, but doing so may allow one round trip of the protocol to be performed in
   * advance; calling this method on an idle session that is expected to execute a transaction or
   * write in the near future may reduce the latency of the subsequent transaction/write.
   */
  void prepareReadWriteTransaction();

  @Override
  void close();
}
