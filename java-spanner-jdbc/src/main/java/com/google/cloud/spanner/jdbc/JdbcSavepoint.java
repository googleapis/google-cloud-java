/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.spanner.jdbc;

import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.concurrent.atomic.AtomicInteger;

class JdbcSavepoint implements Savepoint {
  private static final AtomicInteger COUNTER = new AtomicInteger();

  static JdbcSavepoint named(String name) {
    return new JdbcSavepoint(-1, name);
  }

  static JdbcSavepoint unnamed() {
    int id = COUNTER.incrementAndGet();
    return new JdbcSavepoint(id, String.format("s_%d", id));
  }

  private final int id;
  private final String name;

  private JdbcSavepoint(int id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public int getSavepointId() throws SQLException {
    JdbcPreconditions.checkState(this.id >= 0, "This is a named savepoint");
    return id;
  }

  @Override
  public String getSavepointName() throws SQLException {
    JdbcPreconditions.checkState(this.id < 0, "This is an unnamed savepoint");
    return name;
  }

  String internalGetSavepointName() {
    return name;
  }
}
