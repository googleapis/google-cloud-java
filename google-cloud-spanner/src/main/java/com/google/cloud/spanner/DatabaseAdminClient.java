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

import com.google.cloud.Page;
import com.google.cloud.spanner.Options.ListOption;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import java.util.List;
import javax.annotation.Nullable;

/** Client to do admin operations on a Cloud Spanner Database. */
public interface DatabaseAdminClient {
  /**
   * Creates a new database in a Cloud Spanner instance.
   *
   * @param instanceId the id of the instance in which to create the database.
   * @param databaseId the id of the database which will be created. It must conform to the regular
   *     expression [a-z][a-z0-9_\-]*[a-z0-9] and be between 2 and 30 characters in length
   * @param statements DDL statements to run while creating the database, for example {@code CREATE
   *     TABLE MyTable ( ... )}. This should not include {@code CREATE DATABASE} statement.
   */
  Operation<Database, CreateDatabaseMetadata> createDatabase(
      String instanceId, String databaseId, Iterable<String> statements) throws SpannerException;

  /** Gets the current state of a Cloud Spanner database. */
  Database getDatabase(String instanceId, String databaseId) throws SpannerException;

  /**
   * Enqueues the given DDL statements to be applied, in order but not necessarily all at once, to
   * the database schema at some point (or points) in the future. The server checks that the
   * statements are executable (syntactically valid, name tables that exist, etc.) before enqueueing
   * them, but they may still fail upon later execution (e.g., if a statement from another batch of
   * statements is applied first and it conflicts in some way, or if there is some data-related
   * problem like a `NULL` value in a column to which `NOT NULL` would be added). If a statement
   * fails, all subsequent statements in the batch are automatically cancelled.
   *
   * @param operationId Operation id assigned to this operation. If null, system will autogenerate
   *     one. This must be unique within a database abd must be a valid identifier
   *     [a-zA-Z][a-zA-Z0-9_]*.
   */
  Operation<Void, UpdateDatabaseDdlMetadata> updateDatabaseDdl(
      String instanceId,
      String databaseId,
      Iterable<String> statements,
      @Nullable String operationId)
      throws SpannerException;

  /** Drops a Cloud Spanner database. */
  void dropDatabase(String instanceId, String databaseId) throws SpannerException;

  /**
   * Returns the schema of a Cloud Spanner database as a list of formatted DDL statements. This
   * method does not show pending schema updates.
   */
  List<String> getDatabaseDdl(String instanceId, String databaseId);

  /** Returns the list of Cloud Spanner database in the given instance. */
  Page<Database> listDatabases(String instanceId, ListOption... options);
}
