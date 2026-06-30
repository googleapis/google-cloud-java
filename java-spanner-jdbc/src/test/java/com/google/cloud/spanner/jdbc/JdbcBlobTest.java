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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.rpc.Code;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class JdbcBlobTest {

  private static final class PosLength {
    private final long pos;
    private final int len;

    private static PosLength of(long pos, int len) {
      return new PosLength(pos, len);
    }

    private PosLength(long pos, int len) {
      this.pos = pos;
      this.len = len;
    }

    @Override
    public String toString() {
      return "pos: " + pos + ", len: " + len;
    }
  }

  private static final class PosBytes {
    private final long pos;
    private final byte[] bytes;

    private static PosBytes of(long pos, byte[] bytes) {
      return new PosBytes(pos, bytes);
    }

    private PosBytes(long pos, byte[] bytes) {
      this.pos = pos;
      this.bytes = bytes;
    }

    @Override
    public String toString() {
      return "pos: " + pos + ", bytes: " + Arrays.toString(bytes);
    }
  }

  @Test
  public void testLength() throws SQLException {
    JdbcBlob blob = new JdbcBlob();
    assertEquals(0L, blob.length());
    blob.setBytes(1L, new byte[] {1, 2, 3});
    assertEquals(3L, blob.length());
    blob.free();
    assertEquals(0L, blob.length());
  }

  @Test
  public void testGetBytes() throws SQLException {
    JdbcBlob blob = new JdbcBlob();
    blob.setBytes(1L, new byte[] {1, 2, 3, 4, 5});
    assertArrayEquals(new byte[] {1, 2, 3, 4, 5}, blob.getBytes(1L, 5));
    assertArrayEquals(new byte[] {2, 3, 4, 5}, blob.getBytes(2L, 5));
    assertArrayEquals(new byte[] {2, 3, 4}, blob.getBytes(2L, 3));
    assertArrayEquals(new byte[] {}, blob.getBytes(1L, 0));

    // test invalid parameters
    PosLength[] params =
        new PosLength[] {PosLength.of(0L, 4), PosLength.of(-1L, 4), PosLength.of(1L, -1)};
    for (PosLength param : params) {
      SQLException sqlException =
          assertThrows(SQLException.class, () -> blob.getBytes(param.pos, param.len));
      assertTrue(sqlException instanceof JdbcSqlException);
      JdbcSqlException jdbcSqlException = (JdbcSqlException) sqlException;
      assertEquals(Code.INVALID_ARGUMENT, jdbcSqlException.getCode());
    }
  }

  @Test
  public void testGetBinaryStream() throws SQLException, IOException {
    JdbcBlob blob = new JdbcBlob();
    blob.setBytes(1L, new byte[] {1, 2, 3, 4, 5});
    byte[] buf = new byte[5];
    try (InputStream is = blob.getBinaryStream()) {
      int b;
      int index = 0;
      while ((b = is.read()) > -1) {
        buf[index] = (byte) b;
        index++;
      }
    }
    assertArrayEquals(new byte[] {1, 2, 3, 4, 5}, buf);

    buf = new byte[10];
    try (InputStream is = blob.getBinaryStream()) {
      assertEquals(5, is.read(buf));
      assertEquals(-1, is.read());
    }
    assertArrayEquals(new byte[] {1, 2, 3, 4, 5, 0, 0, 0, 0, 0}, buf);
  }

  @Test
  public void testPosition() throws SQLException {
    JdbcBlob blob = new JdbcBlob();
    blob.setBytes(1L, new byte[] {1, 2, 3, 4, 5});
    assertEquals(1L, blob.position(new byte[] {1}, 1L));
    assertEquals(1L, blob.position(new byte[] {1, 2}, 1L));
    assertEquals(2L, blob.position(new byte[] {2}, 1L));
    // note that the spec says that the method should return the position within the BLOB where the
    // pattern can be found, so it's not relative to the starting position.
    assertEquals(2L, blob.position(new byte[] {2}, 2L));
    assertEquals(1L, blob.position(new byte[] {1, 2, 3, 4, 5}, 1L));
    assertEquals(-1L, blob.position(new byte[] {1, 2, 3, 4, 5, 6}, 1L));
    assertEquals(-1L, blob.position(new byte[] {1, 2, 3, 4, 5}, 2L));
    assertEquals(-1L, blob.position(new byte[] {2}, 3L));
    assertEquals(-1L, blob.position(new byte[] {1}, 6L));

    // test invalid parameters
    PosBytes[] params =
        new PosBytes[] {
          PosBytes.of(0L, new byte[] {}), PosBytes.of(-1L, new byte[] {}), PosBytes.of(1L, null)
        };
    for (PosBytes param : params) {
      SQLException sqlException =
          assertThrows(SQLException.class, () -> blob.position(param.bytes, param.pos));
      assertTrue(sqlException instanceof JdbcSqlException);
      JdbcSqlException jdbcSqlException = (JdbcSqlException) sqlException;
      assertEquals(Code.INVALID_ARGUMENT, jdbcSqlException.getCode());
    }
  }

  @Test
  public void testPositionBlob() throws SQLException {
    JdbcBlob blob = new JdbcBlob();
    blob.setBytes(1L, new byte[] {1, 2, 3, 4, 5});

    assertEquals(1L, blob.position(createBlob((byte) 1), 1L));
    assertEquals(1L, blob.position(createBlob((byte) 1, (byte) 2), 1L));
    assertEquals(2L, blob.position(createBlob((byte) 2), 1L));
    // note that the spec says that the method should return the position within the BLOB where the
    // pattern can be found, so it's not relative to the starting position.
    assertEquals(2L, blob.position(createBlob((byte) 2), 2L));
    assertEquals(1L, blob.position(createBlob(new byte[] {1, 2, 3, 4, 5}), 1L));
    assertEquals(-1L, blob.position(createBlob(new byte[] {1, 2, 3, 4, 5, 6}), 1L));
    assertEquals(-1L, blob.position(createBlob(new byte[] {1, 2, 3, 4, 5}), 2L));
    assertEquals(-1L, blob.position(createBlob(new byte[] {2}), 3L));
    assertEquals(-1L, blob.position(createBlob(new byte[] {1}), 6L));

    // test invalid parameters
    PosBytes[] params =
        new PosBytes[] {
          PosBytes.of(0L, new byte[] {}), PosBytes.of(-1L, new byte[] {}), PosBytes.of(1L, null)
        };
    for (PosBytes param : params) {
      SQLException sqlException =
          assertThrows(SQLException.class, () -> blob.position(createBlob(param.bytes), param.pos));
      assertTrue(sqlException instanceof JdbcSqlException);
      JdbcSqlException jdbcSqlException = (JdbcSqlException) sqlException;
      assertEquals(Code.INVALID_ARGUMENT, jdbcSqlException.getCode());
    }
  }

  private JdbcBlob createBlob(byte... bytes) throws SQLException {
    if (bytes == null) {
      return null;
    }
    JdbcBlob res = new JdbcBlob();
    res.setBytes(1L, bytes);
    return res;
  }

  @Test
  public void testSetBytes() throws SQLException {
    JdbcBlob blob = new JdbcBlob();
    blob.setBytes(1L, new byte[] {1, 2, 3});
    assertArrayEquals(new byte[] {1, 2, 3}, blob.getBytes(1L, 10));
    blob.setBytes(2L, new byte[] {1});
    assertArrayEquals(new byte[] {1, 1, 3}, blob.getBytes(1L, 10));
    blob.setBytes(4L, new byte[] {4});
    assertArrayEquals(new byte[] {1, 1, 3, 4}, blob.getBytes(1L, 10));
    blob.setBytes(8L, new byte[] {8});
    assertArrayEquals(new byte[] {1, 1, 3, 4, 0, 0, 0, 8}, blob.getBytes(1L, 10));
  }

  @Test
  public void testSetBytesOffsetLength() throws SQLException {
    JdbcBlob blob = new JdbcBlob();
    blob.setBytes(4L, new byte[] {1, 2, 3}, 0, 3);
    assertArrayEquals(new byte[] {0, 0, 0, 1, 2, 3}, blob.getBytes(1L, 10));
    blob.free();
    blob.setBytes(4L, new byte[] {1, 2, 3}, 1, 3);
    assertArrayEquals(new byte[] {0, 0, 0, 2, 3}, blob.getBytes(1L, 10));
    blob.free();
    blob.setBytes(4L, new byte[] {1, 2, 3}, 3, 3);
    assertArrayEquals(new byte[] {0, 0, 0}, blob.getBytes(1L, 10));
    blob.free();
    blob.setBytes(4L, new byte[] {1, 2, 3}, 4, 3);
    assertArrayEquals(new byte[] {0, 0, 0}, blob.getBytes(1L, 10));
    blob.setBytes(2L, new byte[] {1, 2, 3}, 0, 10);
    assertArrayEquals(new byte[] {0, 1, 2, 3}, blob.getBytes(1L, 10));
    blob.setBytes(3L, new byte[] {1, 2, 3}, 2, 10);
    assertArrayEquals(new byte[] {0, 1, 3, 3}, blob.getBytes(1L, 10));
    blob.setBytes(10L, new byte[] {1, 2, 3}, 2, 10);
    assertArrayEquals(new byte[] {0, 1, 3, 3, 0, 0, 0, 0, 0, 3}, blob.getBytes(1L, 20));
  }

  @Test
  public void testSetBinaryStream() throws SQLException, IOException {
    JdbcBlob blob = new JdbcBlob();
    blob.setBytes(1L, new byte[] {1, 2, 3, 4, 5});
    try (OutputStream os = blob.setBinaryStream(1L)) {
      os.write(6);
      // no flush yet, so it should be unchanged
      assertArrayEquals(new byte[] {1, 2, 3, 4, 5}, blob.getBytes(1L, 20));
      os.flush();
      assertArrayEquals(new byte[] {6, 2, 3, 4, 5}, blob.getBytes(1L, 20));
      os.write(7);
    }
    // closing the stream should also flush the changes
    assertArrayEquals(new byte[] {6, 7, 3, 4, 5}, blob.getBytes(1L, 20));

    // test writing beyond the end of the stream
    try (OutputStream os = blob.setBinaryStream(1L)) {
      os.write(new byte[] {1, 2, 3, 4, 5, 6, 7});
      // no flush yet, so it should be unchanged
      assertArrayEquals(new byte[] {6, 7, 3, 4, 5}, blob.getBytes(1L, 20));
      os.flush();
      assertArrayEquals(new byte[] {1, 2, 3, 4, 5, 6, 7}, blob.getBytes(1L, 20));
    }
    assertArrayEquals(new byte[] {1, 2, 3, 4, 5, 6, 7}, blob.getBytes(1L, 20));

    // test writing from a position that is larger than 1
    try (OutputStream os = blob.setBinaryStream(5L)) {
      os.write(new byte[] {1, 2, 3});
      // no flush yet, so it should be unchanged
      assertArrayEquals(new byte[] {1, 2, 3, 4, 5, 6, 7}, blob.getBytes(1L, 20));
      os.flush();
      assertArrayEquals(new byte[] {1, 2, 3, 4, 1, 2, 3}, blob.getBytes(1L, 20));
    }

    // test writing from a position that is larger than the current length
    try (OutputStream os = blob.setBinaryStream(10L)) {
      os.write(new byte[] {1, 2, 3});
      // no flush yet, so it should be unchanged
      assertArrayEquals(new byte[] {1, 2, 3, 4, 1, 2, 3}, blob.getBytes(1L, 20));
      os.flush();
      assertArrayEquals(new byte[] {1, 2, 3, 4, 1, 2, 3, 0, 0, 1, 2, 3}, blob.getBytes(1L, 20));
    }

    // test writing a large number of bytes
    try (OutputStream os = blob.setBinaryStream(1L)) {
      os.write(new byte[2000]);
      // no flush yet, so it should be unchanged
      assertArrayEquals(new byte[] {1, 2, 3, 4, 1, 2, 3, 0, 0, 1, 2, 3}, blob.getBytes(1L, 3000));
      os.flush();
      assertArrayEquals(new byte[2000], blob.getBytes(1L, 3000));
    }
  }

  @Test
  public void testTruncate() throws SQLException {
    JdbcBlob blob = new JdbcBlob();
    blob.setBytes(1L, new byte[] {1, 2, 3, 4, 5});
    assertArrayEquals(new byte[] {1, 2, 3, 4, 5}, blob.getBytes(1L, 20));
    blob.truncate(3);
    assertArrayEquals(new byte[] {1, 2, 3}, blob.getBytes(1L, 20));
    blob.truncate(0);
    assertArrayEquals(new byte[] {}, blob.getBytes(1L, 20));
  }

  @Test
  public void testFree() throws SQLException {
    JdbcBlob blob = new JdbcBlob();
    blob.setBytes(1L, new byte[] {1, 2, 3, 4, 5});
    assertArrayEquals(new byte[] {1, 2, 3, 4, 5}, blob.getBytes(1L, 20));
    blob.free();
    assertArrayEquals(new byte[] {}, blob.getBytes(1L, 20));
  }

  @Test
  public void testGetBinaryStreamPosLength() throws SQLException, IOException {
    JdbcBlob blob = new JdbcBlob();
    blob.setBytes(1L, new byte[] {1, 2, 3, 4, 5});

    byte[] buf = new byte[5];
    try (InputStream is = blob.getBinaryStream(1L, 3)) {
      int b;
      int index = 0;
      while ((b = is.read()) > -1) {
        buf[index] = (byte) b;
        index++;
      }
    }
    assertArrayEquals(new byte[] {1, 2, 3, 0, 0}, buf);

    buf = new byte[10];
    try (InputStream is = blob.getBinaryStream(4L, 10)) {
      assertEquals(2, is.read(buf));
      assertEquals(-1, is.read());
    }
    assertArrayEquals(new byte[] {4, 5, 0, 0, 0, 0, 0, 0, 0, 0}, buf);

    buf = new byte[10];
    try (InputStream is = blob.getBinaryStream(6L, 10)) {
      assertEquals(-1L, is.read(buf));
    }
    assertArrayEquals(new byte[10], buf);
  }
}
