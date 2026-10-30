/*
 * Copyright 2026 Google LLC
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

import com.google.cloud.spanner.Type.StructField;
import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DatabaseMetadataTest {
  private static final Type OPTION_TYPE =
      Type.struct(
          StructField.of("option_name", Type.string()),
          StructField.of("option_value", Type.string()));

  private static Struct option(String name, String value) {
    return Struct.newBuilder().set("option_name").to(name).set("option_value").to(value).build();
  }

  private static DatabaseMetadata fromOptions(Struct... options) {
    try (ResultSet resultSet = ResultSets.forRows(OPTION_TYPE, Arrays.asList(options))) {
      return DatabaseMetadata.fromResultSet(resultSet);
    }
  }

  @Test
  public void testFromResultSetWithoutOptionsReturnsDefaults() {
    DatabaseMetadata metadata = fromOptions();

    assertEquals(Dialect.GOOGLE_STANDARD_SQL, metadata.getDialect());
    assertEquals(IsolationLevel.ISOLATION_LEVEL_UNSPECIFIED, metadata.getDefaultIsolationLevel());
  }

  @Test
  public void testFromResultSetReadsAllOptions() {
    DatabaseMetadata metadata =
        fromOptions(
            option(DatabaseMetadata.DATABASE_DIALECT_OPTION, "POSTGRESQL"),
            option(DatabaseMetadata.DEFAULT_TRANSACTION_ISOLATION_OPTION, "repeatable read"));

    assertEquals(Dialect.POSTGRESQL, metadata.getDialect());
    assertEquals(IsolationLevel.REPEATABLE_READ, metadata.getDefaultIsolationLevel());
  }

  @Test
  public void testFromResultSetWithSerializable() {
    DatabaseMetadata metadata =
        fromOptions(option(DatabaseMetadata.DEFAULT_TRANSACTION_ISOLATION_OPTION, "serializable"));

    assertEquals(IsolationLevel.SERIALIZABLE, metadata.getDefaultIsolationLevel());
  }

  @Test
  public void testFromResultSetWithNullIsolationLevelReturnsDefault() {
    DatabaseMetadata metadata =
        fromOptions(option(DatabaseMetadata.DEFAULT_TRANSACTION_ISOLATION_OPTION, null));

    assertEquals(IsolationLevel.ISOLATION_LEVEL_UNSPECIFIED, metadata.getDefaultIsolationLevel());
  }

  @Test
  public void testFromResultSetWithUnknownIsolationLevel() {
    DatabaseMetadata metadata =
        fromOptions(
            option(DatabaseMetadata.DEFAULT_TRANSACTION_ISOLATION_OPTION, "read committed"));

    assertEquals(IsolationLevel.UNRECOGNIZED, metadata.getDefaultIsolationLevel());
  }

  @Test
  public void testFromResultSetWithUnknownDialect() {
    DatabaseMetadata metadata =
        fromOptions(
            option(DatabaseMetadata.DATABASE_DIALECT_OPTION, "UNKNOWN_DIALECT"),
            option(DatabaseMetadata.DEFAULT_TRANSACTION_ISOLATION_OPTION, "repeatable read"));

    assertThrows(IllegalArgumentException.class, metadata::getDialect);
    // The other options can still be read.
    assertEquals(IsolationLevel.REPEATABLE_READ, metadata.getDefaultIsolationLevel());
  }
}
