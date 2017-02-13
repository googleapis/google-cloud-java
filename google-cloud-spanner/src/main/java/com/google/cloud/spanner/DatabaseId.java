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

import com.google.api.gax.protobuf.PathTemplate;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Objects;

/** Represents an id of a Cloud Spanner database resource. */
public final class DatabaseId {

  private static final PathTemplate NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/instances/{instance}/databases/{database}");

  private final InstanceId instanceId;
  private final String database;

  DatabaseId(InstanceId instanceId, String database) {
    this.instanceId = instanceId;
    this.database = database;
  }

  /** Returns the instance id for this databse. */
  public InstanceId getInstanceId() {
    return instanceId;
  }

  /** Returns the database id. */
  public String getDatabase() {
    return database;
  }

  /** Returns the name of this database. */
  public String getName() {
    return String.format(
        "projects/%s/instances/%s/databases/%s",
        instanceId.getProject(), instanceId.getInstance(), database);
  }

  @Override
  public int hashCode() {
    return Objects.hash(instanceId, database);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DatabaseId that = (DatabaseId) o;
    return that.instanceId.equals(instanceId) && that.database.equals(database);
  }

  @Override
  public String toString() {
    return getName();
  }

  /**
   * Creates a {@code DatabaseId} from the name of the database.
   *
   * @param name the database name of the form {@code
   *     projects/PROJECT_ID/instances/INSTANCE_ID/databases/DATABASE_ID}
   * @throws IllegalArgumentException if {@code name} does not conform to the expected pattern
   */
  static DatabaseId of(String name) {
    ImmutableMap<String, String> parts = NAME_TEMPLATE.match(name);
    Preconditions.checkArgument(
        parts != null, "Name should conform to pattern %s: %s", NAME_TEMPLATE, name);
    return of(parts.get("project"), parts.get("instance"), parts.get("database"));
  }

  /**
   * Creates a {@code DatabaseId} given project, instance and database IDs.
   */
  public static DatabaseId of(String project, String instance, String database) {
    return new DatabaseId(
        new InstanceId(project, instance), database);
  }

  /**
   * Creates a {@code DatabaseId} given the instance identity and database id.
   */
  public static DatabaseId of(InstanceId instanceId, String database) {
    return new DatabaseId(instanceId, database);
  }
}
