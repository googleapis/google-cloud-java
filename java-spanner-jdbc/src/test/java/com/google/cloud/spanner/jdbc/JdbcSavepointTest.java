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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.sql.Savepoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class JdbcSavepointTest {

  @Test
  public void testNamed() throws SQLException {
    Savepoint savepoint = JdbcSavepoint.named("test");
    assertEquals("test", savepoint.getSavepointName());
    assertThrows(SQLException.class, savepoint::getSavepointId);
  }

  @Test
  public void testUnnamed() throws SQLException {
    Savepoint savepoint = JdbcSavepoint.unnamed();
    assertTrue(
        String.format("Savepoint id: %d", savepoint.getSavepointId()),
        savepoint.getSavepointId() > 0);
    assertThrows(SQLException.class, savepoint::getSavepointName);
  }
}
