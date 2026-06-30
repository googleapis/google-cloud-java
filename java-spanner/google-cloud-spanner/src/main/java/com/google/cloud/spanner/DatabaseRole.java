/*
 * Copyright 2022 Google LLC
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

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.Objects;

/** A Cloud Spanner database role. */
public class DatabaseRole {

  public static class Builder {

    private final String name;

    public Builder(String name) {
      this.name = Preconditions.checkNotNull(name);
    }

    public DatabaseRole build() {
      return new DatabaseRole(this.name);
    }
  }

  private final String name;

  @VisibleForTesting
  DatabaseRole(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || !getClass().equals(o.getClass())) {
      return false;
    }
    DatabaseRole databaseRole = (DatabaseRole) o;
    return Objects.equals(name, databaseRole.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return String.format("DatabaseRole[%s]", name);
  }

  static DatabaseRole fromProto(com.google.spanner.admin.database.v1.DatabaseRole proto) {
    checkArgument(!proto.getName().isEmpty(), "Missing expected 'name' field");
    return new DatabaseRole.Builder(proto.getName()).build();
  }
}
