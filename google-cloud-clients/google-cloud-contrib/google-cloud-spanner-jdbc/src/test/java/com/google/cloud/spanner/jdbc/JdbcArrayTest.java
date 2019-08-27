/*
 * Copyright 2019 Google LLC
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

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class JdbcArrayTest {

  @Test
  public void testCreateArrayTypeName() throws SQLException {
    // Note that JDBC array indices start at 1.
    JdbcArray array;
    array = JdbcArray.createArray("BOOL", new Boolean[] {true, false, true});
    assertEquals(array.getBaseType(), Types.BOOLEAN);
    assertEquals(((Boolean[]) array.getArray(1, 1))[0], Boolean.TRUE);

    array = JdbcArray.createArray("BYTES", new byte[][] {new byte[] {1, 2}, new byte[] {3, 4}});
    assertEquals(array.getBaseType(), Types.BINARY);
    assertEquals(((byte[][]) array.getArray(1, 1))[0][1], (byte) 2);

    array =
        JdbcArray.createArray("DATE", new Date[] {new Date(1L), new Date(100L), new Date(1000L)});
    assertEquals(array.getBaseType(), Types.DATE);
    assertEquals(((Date[]) array.getArray(1, 1))[0], new Date(1L));

    array = JdbcArray.createArray("FLOAT64", new Double[] {1.1D, 2.2D, Math.PI});
    assertEquals(array.getBaseType(), Types.DOUBLE);
    assertEquals(((Double[]) array.getArray(1, 3))[2], Double.valueOf(Math.PI));

    array = JdbcArray.createArray("INT64", new Long[] {1L, 2L, 3L});
    assertEquals(array.getBaseType(), Types.BIGINT);
    assertEquals(((Long[]) array.getArray(1, 1))[0], Long.valueOf(1L));

    array = JdbcArray.createArray("STRING", new String[] {"foo", "bar", "baz"});
    assertEquals(array.getBaseType(), Types.NVARCHAR);
    assertEquals(((String[]) array.getArray(1, 1))[0], "foo");

    array =
        JdbcArray.createArray(
            "TIMESTAMP",
            new Timestamp[] {new Timestamp(1L), new Timestamp(100L), new Timestamp(1000L)});
    assertEquals(array.getBaseType(), Types.TIMESTAMP);
    assertEquals(((Timestamp[]) array.getArray(1, 1))[0], new Timestamp(1L));
  }
}
