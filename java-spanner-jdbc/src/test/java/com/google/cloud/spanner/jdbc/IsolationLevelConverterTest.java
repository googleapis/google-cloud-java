/*
 * Copyright 2025 Google LLC
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

import static com.google.cloud.spanner.jdbc.IsolationLevelConverter.convertToJdbc;
import static com.google.cloud.spanner.jdbc.IsolationLevelConverter.convertToSpanner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class IsolationLevelConverterTest {

  @Test
  public void testConvertToSpanner() throws SQLException {
    assertEquals(
        IsolationLevel.SERIALIZABLE, convertToSpanner(Connection.TRANSACTION_SERIALIZABLE));
    assertEquals(
        IsolationLevel.REPEATABLE_READ, convertToSpanner(Connection.TRANSACTION_REPEATABLE_READ));

    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> convertToSpanner(Connection.TRANSACTION_READ_COMMITTED));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> convertToSpanner(Connection.TRANSACTION_READ_UNCOMMITTED));
    assertThrows(
        SQLFeatureNotSupportedException.class, () -> convertToSpanner(Connection.TRANSACTION_NONE));

    assertThrows(IllegalArgumentException.class, () -> convertToSpanner(-1));
  }

  @Test
  public void testConvertToJdbc() {
    // There is no 'unspecified' isolation level in JDBC, so we convert this to the default
    // SERIALIZABLE isolation level in Spanner.
    assertEquals(
        Connection.TRANSACTION_SERIALIZABLE,
        convertToJdbc(IsolationLevel.ISOLATION_LEVEL_UNSPECIFIED));
    assertEquals(Connection.TRANSACTION_SERIALIZABLE, convertToJdbc(IsolationLevel.SERIALIZABLE));
    assertEquals(
        Connection.TRANSACTION_REPEATABLE_READ, convertToJdbc(IsolationLevel.REPEATABLE_READ));

    assertThrows(IllegalArgumentException.class, () -> convertToJdbc(IsolationLevel.UNRECOGNIZED));
  }
}
