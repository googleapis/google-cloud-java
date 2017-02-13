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

import static com.google.common.base.Preconditions.checkArgument;

import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;

/**
 * Represents a Cloud Spanner database. {@code Database} adds a layer of service related
 * functionality over {@code DatabaseInfo}.
 */
public class Database extends DatabaseInfo {

  private final DatabaseAdminClient dbClient;

  public Database(DatabaseId id, State state, DatabaseAdminClient dbClient) {
    super(id, state);
    this.dbClient = dbClient;
  }

  /** Fetches the database's current information. */
  public Database reload() throws SpannerException {
    return dbClient.getDatabase(instance(), database());
  }

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
  public Operation<Void, UpdateDatabaseDdlMetadata> updateDdl(
      Iterable<String> statements, String operationId) throws SpannerException {
    return dbClient.updateDatabaseDdl(instance(), database(), statements, operationId);
  }

  /** Drops this database. */
  public void drop() throws SpannerException {
    dbClient.dropDatabase(instance(), database());
  }

  /**
   * Returns the schema of a Cloud Spanner database as a list of formatted DDL statements. This
   * method does not show pending schema updates.
   */
  public Iterable<String> getDdl() throws SpannerException {
    return dbClient.getDatabaseDdl(instance(), database());
  }

  private String instance() {
    return getId().getInstanceId().getInstance();
  }

  private String database() {
    return getId().getDatabase();
  }

  static Database fromProto(
      com.google.spanner.admin.database.v1.Database proto, DatabaseAdminClient client) {
    checkArgument(!proto.getName().isEmpty(), "Missing expected 'name' field");
    return new Database(DatabaseId.of(proto.getName()), fromProtoState(proto.getState()), client);
  }

  static DatabaseInfo.State fromProtoState(
      com.google.spanner.admin.database.v1.Database.State protoState) {
    switch (protoState) {
      case STATE_UNSPECIFIED:
        return DatabaseInfo.State.UNSPECIFIED;
      case CREATING:
        return DatabaseInfo.State.CREATING;
      case READY:
        return DatabaseInfo.State.READY;
      default:
        throw new IllegalArgumentException("Unrecognized state " + protoState);
    }
  }
}
