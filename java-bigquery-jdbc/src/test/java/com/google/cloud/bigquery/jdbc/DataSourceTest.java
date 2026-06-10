/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;

public class DataSourceTest {

  @Test
  public void testWrapperMethods() throws SQLException {
    DataSource dataSource = new DataSource();
    assertTrue(dataSource.isWrapperFor(javax.sql.DataSource.class));
    assertTrue(dataSource.isWrapperFor(DataSource.class));
    assertFalse(dataSource.isWrapperFor(java.sql.Connection.class));
    assertFalse(dataSource.isWrapperFor(null));

    Object unwrappedDs = dataSource.unwrap(javax.sql.DataSource.class);
    assertSame(unwrappedDs, dataSource);

    Object unwrappedImpl = dataSource.unwrap(DataSource.class);
    assertSame(unwrappedImpl, dataSource);

    BigQueryJdbcException e =
        assertThrows(
            BigQueryJdbcException.class, () -> dataSource.unwrap(java.sql.Connection.class));
    assertTrue(e.getMessage().contains("Cannot unwrap to java.sql.Connection"));
  }
}
