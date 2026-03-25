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

import com.google.common.collect.ImmutableMap;
import com.google.spanner.admin.database.v1.DatabaseDialect;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Dialect {
  GOOGLE_STANDARD_SQL {
    @Override
    public String createDatabaseStatementFor(String databaseName) {
      return "CREATE DATABASE `" + databaseName + "`";
    }

    @Override
    public DatabaseDialect toProto() {
      return DatabaseDialect.GOOGLE_STANDARD_SQL;
    }

    @Override
    public String getDefaultSchema() {
      return "";
    }
  },
  POSTGRESQL {
    @Override
    public String createDatabaseStatementFor(String databaseName) {
      return "CREATE DATABASE \"" + databaseName + "\"";
    }

    @Override
    public DatabaseDialect toProto() {
      return DatabaseDialect.POSTGRESQL;
    }

    @Override
    public String getDefaultSchema() {
      return "public";
    }
  };

  private static final Map<DatabaseDialect, Dialect> protoToDialect =
      ImmutableMap.of(
          DatabaseDialect.DATABASE_DIALECT_UNSPECIFIED, Dialect.GOOGLE_STANDARD_SQL,
          DatabaseDialect.GOOGLE_STANDARD_SQL, Dialect.GOOGLE_STANDARD_SQL,
          DatabaseDialect.POSTGRESQL, Dialect.POSTGRESQL);

  public abstract String createDatabaseStatementFor(String databaseName);

  public abstract DatabaseDialect toProto();

  public abstract String getDefaultSchema();

  public static Dialect fromProto(DatabaseDialect databaseDialect) {
    final Dialect dialect = protoToDialect.get(databaseDialect);
    if (dialect == null) {
      throw new IllegalArgumentException(
          String.format(
              "Invalid dialect: %s. Dialect must be one of [%s]",
              databaseDialect,
              protoToDialect.keySet().stream()
                  .map(DatabaseDialect::name)
                  .collect(Collectors.joining(", "))));
    }
    return dialect;
  }

  public static Dialect fromName(String name) {
    try {
      return Dialect.valueOf(name);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException(
          String.format(
              "Invalid dialect: %s. Dialect must be one of %s",
              name, Arrays.toString(Dialect.values())));
    }
  }
}
