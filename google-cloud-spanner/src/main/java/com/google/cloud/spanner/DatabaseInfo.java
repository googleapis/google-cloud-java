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

import java.util.Objects;

/** Represents a Cloud Spanner database. */
public class DatabaseInfo {

  /** State of the database. */
  public enum State {
    // Not specified.
    UNSPECIFIED,
    // The database is still being created and is not ready to use.
    CREATING,
    // The database is fully created and ready to use.
    READY;
  }

  private final DatabaseId id;
  private final State state;

  public DatabaseInfo(DatabaseId id, State state) {
    this.id = id;
    this.state = state;
  }

  /** Returns the database id. */
  public DatabaseId getId() {
    return id;
  }

  /** Returns the state of the database. */
  public State getState() {
    return state;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DatabaseInfo that = (DatabaseInfo) o;
    return id.equals(that.id) && state == that.state;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, state);
  }

  @Override
  public String toString() {
    return String.format("Database[%s, %s]", id.getName(), state);
  }
}
