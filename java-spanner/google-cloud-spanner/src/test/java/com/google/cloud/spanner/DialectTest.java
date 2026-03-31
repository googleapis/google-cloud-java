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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.google.spanner.admin.database.v1.DatabaseDialect;
import org.junit.Test;

public class DialectTest {

  @Test
  public void testCreateDatabaseStatementForGoogleStandardSQLDialect() {
    assertEquals(
        "CREATE DATABASE `my-database`",
        Dialect.GOOGLE_STANDARD_SQL.createDatabaseStatementFor("my-database"));
  }

  @Test
  public void testCreateDatabaseStatementForPostgreSQLDialect() {
    assertEquals(
        "CREATE DATABASE \"my-database\"",
        Dialect.POSTGRESQL.createDatabaseStatementFor("my-database"));
  }

  @Test
  public void testGoogleStandardSQLDialectToProto() {
    assertEquals(DatabaseDialect.GOOGLE_STANDARD_SQL, Dialect.GOOGLE_STANDARD_SQL.toProto());
  }

  @Test
  public void testPostgreSQLToProto() {
    assertEquals(DatabaseDialect.POSTGRESQL, Dialect.POSTGRESQL.toProto());
  }

  @Test
  public void testFromGoogleStandardSQLDialectProto() {
    assertEquals(
        Dialect.GOOGLE_STANDARD_SQL, Dialect.fromProto(DatabaseDialect.GOOGLE_STANDARD_SQL));
  }

  @Test
  public void testFromUnspecifiedDialectProto() {
    assertEquals(
        Dialect.GOOGLE_STANDARD_SQL,
        Dialect.fromProto(DatabaseDialect.DATABASE_DIALECT_UNSPECIFIED));
  }

  @Test
  public void testFromPostgreSQLDialectProto() {
    assertEquals(Dialect.POSTGRESQL, Dialect.fromProto(DatabaseDialect.POSTGRESQL));
  }

  @Test
  public void testFromUnrecognizedDialectProto() {
    assertThrows(
        IllegalArgumentException.class, () -> Dialect.fromProto(DatabaseDialect.UNRECOGNIZED));
  }

  @Test
  public void testFromNullDialectProto() {
    assertThrows(
        IllegalArgumentException.class, () -> Dialect.fromProto(DatabaseDialect.UNRECOGNIZED));
  }

  @Test
  public void testFromGoogleStandardSQLDialectName() {
    assertEquals(Dialect.GOOGLE_STANDARD_SQL, Dialect.fromName("GOOGLE_STANDARD_SQL"));
  }

  @Test
  public void testFromPostgreSQLDialectName() {
    assertEquals(Dialect.POSTGRESQL, Dialect.fromName("POSTGRESQL"));
  }

  @Test
  public void testFromInvalidDialectName() {
    assertThrows(IllegalArgumentException.class, () -> Dialect.fromName("INVALID"));
  }
}
