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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
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
  public void testFetchSize() throws SQLException {
    assertThat(rs.getFetchSize(), is(equalTo(0)));
    for (int size : new int[] {0, 1, 10, 100}) {
      rs.setFetchSize(size);
      assertThat(rs.getFetchSize(), is(equalTo(size)));
    }
  }

  @Test
  public void testGetType() throws SQLException {
    assertThat(rs.getType(), is(equalTo(ResultSet.TYPE_FORWARD_ONLY)));
  }

  @Test
  public void testGetConcurrency() throws SQLException {
    assertThat(rs.getConcurrency(), is(equalTo(ResultSet.CONCUR_READ_ONLY)));
  }

  @Test
  public void testRowInsertedUpdatedDeleted() throws SQLException {
    assertThat(rs.rowInserted(), is(false));
    assertThat(rs.rowUpdated(), is(false));
    assertThat(rs.rowDeleted(), is(false));
  }

  @Test
  public void testGetFetchDirection() throws SQLException {
    assertThat(rs.getFetchDirection(), is(equalTo(ResultSet.FETCH_FORWARD)));
  }

  @Test
  public void testSetFetchDirection() throws SQLException {
    Set<Integer> supported = Sets.newHashSet(ResultSet.FETCH_FORWARD);
    for (int direction :
        new int[] {ResultSet.FETCH_FORWARD, ResultSet.FETCH_REVERSE, ResultSet.FETCH_UNKNOWN}) {
      try {
        rs.setFetchDirection(direction);
        assertThat(supported.contains(direction), is(true));
      } catch (JdbcSqlExceptionImpl e) {
        assertThat(supported.contains(direction), is(false));
        assertThat(e.getCode(), is(equalTo(Code.INVALID_ARGUMENT)));
      }
    }
  }

  private static interface SqlRunnable {
    void run() throws SQLException;
  }

  @Test
  public void testUnsupportedFeatures() throws SQLException {
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.getCursorName();
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.isLast();
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.beforeFirst();
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.afterLast();
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.first();
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.last();
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.absolute(1);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.relative(1);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.previous();
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateNull(1);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateNull("test");
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateBoolean(1, Boolean.TRUE);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateBoolean("test", Boolean.TRUE);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateByte(1, (byte) 1);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateByte("test", (byte) 1);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateShort(1, (short) 1);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateShort("test", (short) 1);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateInt(1, 1);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateInt("test", 1);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateLong(1, 1L);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateLong("test", 1L);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateFloat(1, 1F);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateFloat("test", 1F);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateDouble(1, 1D);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateDouble("test", 1D);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateBigDecimal(1, BigDecimal.ONE);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateBigDecimal("test", BigDecimal.ONE);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateString(1, "value");
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateString("test", "value");
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateBytes(1, "value".getBytes());
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateBytes("test", "value".getBytes());
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateDate(1, new Date(System.currentTimeMillis()));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateDate("test", new Date(System.currentTimeMillis()));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateTimestamp(1, new Timestamp(System.currentTimeMillis()));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateTimestamp("test", new Timestamp(System.currentTimeMillis()));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateTime(1, new Time(System.currentTimeMillis()));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateTime("test", new Time(System.currentTimeMillis()));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateAsciiStream(1, new ByteArrayInputStream("value".getBytes()));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateAsciiStream("test", new ByteArrayInputStream("value".getBytes()));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateAsciiStream(1, new ByteArrayInputStream("value".getBytes()), 1);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateAsciiStream("test", new ByteArrayInputStream("value".getBytes()), 1);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateAsciiStream(1, new ByteArrayInputStream("value".getBytes()), 1L);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateAsciiStream("test", new ByteArrayInputStream("value".getBytes()), 1L);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateBinaryStream(1, new ByteArrayInputStream("value".getBytes()));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateBinaryStream("test", new ByteArrayInputStream("value".getBytes()));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateBinaryStream(1, new ByteArrayInputStream("value".getBytes()), 1);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateBinaryStream("test", new ByteArrayInputStream("value".getBytes()), 1);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateBinaryStream(1, new ByteArrayInputStream("value".getBytes()), 1L);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateBinaryStream("test", new ByteArrayInputStream("value".getBytes()), 1L);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateCharacterStream(1, new StringReader("value"));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateCharacterStream("test", new StringReader("value"));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateCharacterStream(1, new StringReader("value"), 1);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateCharacterStream("test", new StringReader("value"), 1);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateCharacterStream(1, new StringReader("value"), 1L);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateCharacterStream("test", new StringReader("value"), 1L);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateObject(1, new Object());
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateObject("test", new Object());
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateObject(1, new Object(), 1);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateObject("test", new Object(), 1);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.insertRow();
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateRow();
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.deleteRow();
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.refreshRow();
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.cancelRowUpdates();
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.moveToInsertRow();
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.moveToCurrentRow();
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.getRef(1);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.getRef("test");
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateRef(1, mock(Ref.class));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateRef("test", mock(Ref.class));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateBlob(1, mock(Blob.class));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateBlob("test", mock(Blob.class));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateBlob(1, mock(InputStream.class));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateBlob("test", mock(InputStream.class));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateBlob(1, mock(InputStream.class), 1L);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateBlob("test", mock(InputStream.class), 1L);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateClob(1, mock(Clob.class));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateClob("test", mock(Clob.class));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateClob(1, mock(Reader.class));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateClob("test", mock(Reader.class));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateClob(1, mock(Reader.class), 1L);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateClob("test", mock(Reader.class), 1L);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateArray(1, mock(Array.class));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateArray("test", mock(Array.class));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.getRowId(1);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.getRowId("test");
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateRowId(1, mock(RowId.class));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateRowId("test", mock(RowId.class));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateNString(1, "value");
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateNString("test", "value");
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateNClob(1, mock(NClob.class));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateNClob("test", mock(NClob.class));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateNClob(1, mock(Reader.class));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateNClob("test", mock(Reader.class));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateNClob(1, mock(Reader.class), 1L);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateNClob("test", mock(Reader.class), 1L);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.getSQLXML(1);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.getSQLXML("test");
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateSQLXML(1, mock(SQLXML.class));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateSQLXML("test", mock(SQLXML.class));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateNCharacterStream(1, new StringReader("value"));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateNCharacterStream("test", new StringReader("value"));
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateNCharacterStream(1, new StringReader("value"), 1L);
          }
        });
    assertUnsupported(
        new SqlRunnable() {
          @Override
          public void run() throws SQLException {
            rs.updateNCharacterStream("test", new StringReader("value"), 1L);
          }
        });
  }

  private <T> void assertUnsupported(SqlRunnable runnable) throws SQLException {
    try {
      runnable.run();
      fail("missing expected SQLFeatureNotSupportedException");
    } catch (SQLFeatureNotSupportedException e) {
      // ignore, this is the expected exception.
    } catch (Exception e) {
      throw JdbcSqlExceptionFactory.of("unexpected exception", Code.INTERNAL, e);
    }
  }
}
