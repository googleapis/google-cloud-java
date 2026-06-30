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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import com.google.cloud.spanner.jdbc.JdbcSqlExceptionFactory.JdbcSqlExceptionImpl;
import com.google.common.collect.Sets;
import com.google.rpc.Code;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.SQLType;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AbstractJdbcResultSetTest {

  private JdbcResultSet rs;

  @Before
  public void setup() {
    rs = JdbcResultSet.of(mock(Statement.class), JdbcResultSetTest.getMockResultSet());
  }

  @Test
  public void testFetchSize() {
    assertEquals(0, rs.getFetchSize());
    for (int size : new int[] {0, 1, 10, 100}) {
      rs.setFetchSize(size);
      assertEquals(size, rs.getFetchSize());
    }
  }

  @Test
  public void testGetType() {
    assertEquals(ResultSet.TYPE_FORWARD_ONLY, rs.getType());
  }

  @Test
  public void testGetConcurrency() {
    assertEquals(ResultSet.CONCUR_READ_ONLY, rs.getConcurrency());
  }

  @Test
  public void testRowInsertedUpdatedDeleted() {
    assertFalse(rs.rowInserted());
    assertFalse(rs.rowUpdated());
    assertFalse(rs.rowDeleted());
  }

  @Test
  public void testGetFetchDirection() {
    assertEquals(ResultSet.FETCH_FORWARD, rs.getFetchDirection());
  }

  @Test
  public void testSetFetchDirection() throws SQLException {
    Set<Integer> supported = Sets.newHashSet(ResultSet.FETCH_FORWARD);
    for (int direction :
        new int[] {ResultSet.FETCH_FORWARD, ResultSet.FETCH_REVERSE, ResultSet.FETCH_UNKNOWN}) {
      try {
        rs.setFetchDirection(direction);
        assertTrue(supported.contains(direction));
      } catch (JdbcSqlExceptionImpl e) {
        assertFalse(supported.contains(direction));
        assertEquals(Code.INVALID_ARGUMENT, e.getCode());
      }
    }
  }

  @Test
  public void testUnsupportedFeatures() {
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.getCursorName());
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.isLast());
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.beforeFirst());
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.afterLast());
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.first());
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.last());
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.absolute(1));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.relative(1));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.previous());
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateNull(1));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateNull("test"));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateBoolean(1, Boolean.TRUE));
    assertThrows(
        SQLFeatureNotSupportedException.class, () -> rs.updateBoolean("test", Boolean.TRUE));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateByte(1, (byte) 1));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateByte("test", (byte) 1));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateShort(1, (short) 1));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateShort("test", (short) 1));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateInt(1, 1));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateInt("test", 1));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateLong(1, 1L));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateLong("test", 1L));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateFloat(1, 1F));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateFloat("test", 1F));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateDouble(1, 1D));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateDouble("test", 1D));
    assertThrows(
        SQLFeatureNotSupportedException.class, () -> rs.updateBigDecimal(1, BigDecimal.ONE));
    assertThrows(
        SQLFeatureNotSupportedException.class, () -> rs.updateBigDecimal("test", BigDecimal.ONE));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateString(1, "value"));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateString("test", "value"));
    assertThrows(
        SQLFeatureNotSupportedException.class, () -> rs.updateBytes(1, "value".getBytes()));
    assertThrows(
        SQLFeatureNotSupportedException.class, () -> rs.updateBytes("test", "value".getBytes()));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateDate(1, new Date(System.currentTimeMillis())));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateDate("test", new Date(System.currentTimeMillis())));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateTimestamp(1, new Timestamp(System.currentTimeMillis())));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateTimestamp("test", new Timestamp(System.currentTimeMillis())));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateTime(1, new Time(System.currentTimeMillis())));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateTime("test", new Time(System.currentTimeMillis())));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateAsciiStream(1, new ByteArrayInputStream("value".getBytes())));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateAsciiStream("test", new ByteArrayInputStream("value".getBytes())));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateAsciiStream(1, new ByteArrayInputStream("value".getBytes()), 1));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateAsciiStream("test", new ByteArrayInputStream("value".getBytes()), 1));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateAsciiStream(1, new ByteArrayInputStream("value".getBytes()), 1L));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateAsciiStream("test", new ByteArrayInputStream("value".getBytes()), 1L));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateBinaryStream(1, new ByteArrayInputStream("value".getBytes())));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateBinaryStream("test", new ByteArrayInputStream("value".getBytes())));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateBinaryStream(1, new ByteArrayInputStream("value".getBytes()), 1));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateBinaryStream("test", new ByteArrayInputStream("value".getBytes()), 1));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateBinaryStream(1, new ByteArrayInputStream("value".getBytes()), 1L));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateBinaryStream("test", new ByteArrayInputStream("value".getBytes()), 1L));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateCharacterStream(1, new StringReader("value")));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateCharacterStream("test", new StringReader("value")));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateCharacterStream(1, new StringReader("value"), 1));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateCharacterStream("test", new StringReader("value"), 1));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateCharacterStream(1, new StringReader("value"), 1L));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateCharacterStream("test", new StringReader("value"), 1L));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateObject(1, new Object()));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateObject(1, new Object(), 1));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateObject(1, new Object(), mock(SQLType.class)));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateObject(1, new Object(), mock(SQLType.class), 0));
    assertThrows(
        SQLFeatureNotSupportedException.class, () -> rs.updateObject("test", new Object()));
    assertThrows(
        SQLFeatureNotSupportedException.class, () -> rs.updateObject("test", new Object(), 1));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateObject("test", new Object(), mock(SQLType.class)));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateObject("test", new Object(), mock(SQLType.class), 1));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.insertRow());
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateRow());
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.deleteRow());
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.refreshRow());
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.cancelRowUpdates());
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.moveToInsertRow());
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.moveToCurrentRow());
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.getRef(1));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.getRef("test"));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateRef(1, mock(Ref.class)));
    assertThrows(
        SQLFeatureNotSupportedException.class, () -> rs.updateRef("test", mock(Ref.class)));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateBlob(1, mock(Blob.class)));
    assertThrows(
        SQLFeatureNotSupportedException.class, () -> rs.updateBlob("test", mock(Blob.class)));
    assertThrows(
        SQLFeatureNotSupportedException.class, () -> rs.updateBlob(1, mock(InputStream.class)));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateBlob("test", mock(InputStream.class)));
    assertThrows(
        SQLFeatureNotSupportedException.class, () -> rs.updateBlob(1, mock(InputStream.class), 1L));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateBlob("test", mock(InputStream.class), 1L));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateClob(1, mock(Clob.class)));
    assertThrows(
        SQLFeatureNotSupportedException.class, () -> rs.updateClob("test", mock(Clob.class)));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateClob(1, mock(Reader.class)));
    assertThrows(
        SQLFeatureNotSupportedException.class, () -> rs.updateClob("test", mock(Reader.class)));
    assertThrows(
        SQLFeatureNotSupportedException.class, () -> rs.updateClob(1, mock(Reader.class), 1L));
    assertThrows(
        SQLFeatureNotSupportedException.class, () -> rs.updateClob("test", mock(Reader.class), 1L));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateArray(1, mock(Array.class)));
    assertThrows(
        SQLFeatureNotSupportedException.class, () -> rs.updateArray("test", mock(Array.class)));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.getRowId(1));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.getRowId("test"));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateRowId(1, mock(RowId.class)));
    assertThrows(
        SQLFeatureNotSupportedException.class, () -> rs.updateRowId("test", mock(RowId.class)));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateNString(1, "value"));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateNString("test", "value"));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.updateNClob(1, mock(NClob.class)));
    assertThrows(
        SQLFeatureNotSupportedException.class, () -> rs.updateNClob("test", mock(NClob.class)));
    assertThrows(
        SQLFeatureNotSupportedException.class, () -> rs.updateNClob(1, mock(Reader.class)));
    assertThrows(
        SQLFeatureNotSupportedException.class, () -> rs.updateNClob("test", mock(Reader.class)));
    assertThrows(
        SQLFeatureNotSupportedException.class, () -> rs.updateNClob(1, mock(Reader.class), 1L));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateNClob("test", mock(Reader.class), 1L));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.getSQLXML(1));
    assertThrows(SQLFeatureNotSupportedException.class, () -> rs.getSQLXML("test"));
    assertThrows(
        SQLFeatureNotSupportedException.class, () -> rs.updateSQLXML(1, mock(SQLXML.class)));
    assertThrows(
        SQLFeatureNotSupportedException.class, () -> rs.updateSQLXML("test", mock(SQLXML.class)));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateNCharacterStream(1, new StringReader("value")));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateNCharacterStream("test", new StringReader("value")));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateNCharacterStream(1, new StringReader("value"), 1L));
    assertThrows(
        SQLFeatureNotSupportedException.class,
        () -> rs.updateNCharacterStream("test", new StringReader("value"), 1L));
  }
}
