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
    assertThat(blob.length(), is(equalTo(0L)));
    blob.setBytes(1L, new byte[] {1, 2, 3});
    assertThat(blob.length(), is(equalTo(3L)));
    blob.free();
    assertThat(blob.length(), is(equalTo(0L)));
  }

  @Test
  public void testGetBytes() throws SQLException {
    JdbcBlob blob = new JdbcBlob();
    blob.setBytes(1L, new byte[] {1, 2, 3, 4, 5});
    assertThat(blob.getBytes(1L, 5), is(equalTo(new byte[] {1, 2, 3, 4, 5})));
    assertThat(blob.getBytes(2L, 5), is(equalTo(new byte[] {2, 3, 4, 5})));
    assertThat(blob.getBytes(2L, 3), is(equalTo(new byte[] {2, 3, 4})));
    assertThat(blob.getBytes(1L, 0), is(equalTo(new byte[] {})));

    // test invalid parameters
    PosLength[] params =
        new PosLength[] {PosLength.of(0L, 4), PosLength.of(-1L, 4), PosLength.of(1L, -1)};
    for (PosLength param : params) {
      boolean exception = false;
      try {
        blob.getBytes(param.pos, param.len);
      } catch (SQLException e) {
        exception =
            (e instanceof JdbcSqlException
                && ((JdbcSqlException) e).getCode() == Code.INVALID_ARGUMENT);
      }
      assertThat(param.toString(), exception, is(true));
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
    assertThat(buf, is(equalTo(new byte[] {1, 2, 3, 4, 5})));

    buf = new byte[10];
    try (InputStream is = blob.getBinaryStream()) {
      assertThat(is.read(buf), is(equalTo(5)));
      assertThat(is.read(), is(equalTo(-1)));
    }
    assertThat(buf, is(equalTo(new byte[] {1, 2, 3, 4, 5, 0, 0, 0, 0, 0})));
  }

  @Test
  public void testPosition() throws SQLException {
    JdbcBlob blob = new JdbcBlob();
    blob.setBytes(1L, new byte[] {1, 2, 3, 4, 5});
    assertThat(blob.position(new byte[] {1}, 1L), is(equalTo(1L)));
    assertThat(blob.position(new byte[] {1, 2}, 1L), is(equalTo(1L)));
    assertThat(blob.position(new byte[] {2}, 1L), is(equalTo(2L)));
    // note that the spec says that the method should return the position within the BLOB where the
    // pattern can be found, so it's not relative to the starting position.
    assertThat(blob.position(new byte[] {2}, 2L), is(equalTo(2L)));
    assertThat(blob.position(new byte[] {1, 2, 3, 4, 5}, 1L), is(equalTo(1L)));
    assertThat(blob.position(new byte[] {1, 2, 3, 4, 5, 6}, 1L), is(equalTo(-1L)));
    assertThat(blob.position(new byte[] {1, 2, 3, 4, 5}, 2L), is(equalTo(-1L)));
    assertThat(blob.position(new byte[] {2}, 3L), is(equalTo(-1L)));
    assertThat(blob.position(new byte[] {1}, 6L), is(equalTo(-1L)));

    // test invalid parameters
    PosBytes[] params =
        new PosBytes[] {
          PosBytes.of(0L, new byte[] {}), PosBytes.of(-1L, new byte[] {}), PosBytes.of(1L, null)
        };
    for (PosBytes param : params) {
      boolean exception = false;
      try {
        blob.position(param.bytes, param.pos);
      } catch (SQLException e) {
        exception =
            (e instanceof JdbcSqlException
                && ((JdbcSqlException) e).getCode() == Code.INVALID_ARGUMENT);
      }
      assertThat(param.toString(), exception, is(true));
    }
  }

  @Test
  public void testPositionBlob() throws SQLException {
    JdbcBlob blob = new JdbcBlob();
    blob.setBytes(1L, new byte[] {1, 2, 3, 4, 5});

    assertThat(blob.position(createBlob((byte) 1), 1L), is(equalTo(1L)));
    assertThat(blob.position(createBlob((byte) 1, (byte) 2), 1L), is(equalTo(1L)));
    assertThat(blob.position(createBlob((byte) 2), 1L), is(equalTo(2L)));
    // note that the spec says that the method should return the position within the BLOB where the
    // pattern can be found, so it's not relative to the starting position.
    assertThat(blob.position(createBlob((byte) 2), 2L), is(equalTo(2L)));
    assertThat(blob.position(createBlob(new byte[] {1, 2, 3, 4, 5}), 1L), is(equalTo(1L)));
    assertThat(blob.position(createBlob(new byte[] {1, 2, 3, 4, 5, 6}), 1L), is(equalTo(-1L)));
    assertThat(blob.position(createBlob(new byte[] {1, 2, 3, 4, 5}), 2L), is(equalTo(-1L)));
    assertThat(blob.position(createBlob(new byte[] {2}), 3L), is(equalTo(-1L)));
    assertThat(blob.position(createBlob(new byte[] {1}), 6L), is(equalTo(-1L)));

    // test invalid parameters
    PosBytes[] params =
        new PosBytes[] {
          PosBytes.of(0L, new byte[] {}), PosBytes.of(-1L, new byte[] {}), PosBytes.of(1L, null)
        };
    for (PosBytes param : params) {
      boolean exception = false;
      try {
        blob.position(createBlob(param.bytes), param.pos);
      } catch (SQLException e) {
        exception =
            (e instanceof JdbcSqlException
                && ((JdbcSqlException) e).getCode() == Code.INVALID_ARGUMENT);
      }
      assertThat(param.toString(), exception, is(true));
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
    assertThat(blob.getBytes(1L, 10), is(equalTo(new byte[] {1, 2, 3})));
    blob.setBytes(2L, new byte[] {1});
    assertThat(blob.getBytes(1L, 10), is(equalTo(new byte[] {1, 1, 3})));
    blob.setBytes(4L, new byte[] {4});
    assertThat(blob.getBytes(1L, 10), is(equalTo(new byte[] {1, 1, 3, 4})));
    blob.setBytes(8L, new byte[] {8});
    assertThat(blob.getBytes(1L, 10), is(equalTo(new byte[] {1, 1, 3, 4, 0, 0, 0, 8})));
  }

  @Test
  public void testSetBytesOffsetLength() throws SQLException {
    JdbcBlob blob = new JdbcBlob();
    blob.setBytes(4L, new byte[] {1, 2, 3}, 0, 3);
    assertThat(blob.getBytes(1L, 10), is(equalTo(new byte[] {0, 0, 0, 1, 2, 3})));
    blob.free();
    blob.setBytes(4L, new byte[] {1, 2, 3}, 1, 3);
    assertThat(blob.getBytes(1L, 10), is(equalTo(new byte[] {0, 0, 0, 2, 3})));
    blob.free();
    blob.setBytes(4L, new byte[] {1, 2, 3}, 3, 3);
    assertThat(blob.getBytes(1L, 10), is(equalTo(new byte[] {0, 0, 0})));
    blob.free();
    blob.setBytes(4L, new byte[] {1, 2, 3}, 4, 3);
    assertThat(blob.getBytes(1L, 10), is(equalTo(new byte[] {0, 0, 0})));
    blob.setBytes(2L, new byte[] {1, 2, 3}, 0, 10);
    assertThat(blob.getBytes(1L, 10), is(equalTo(new byte[] {0, 1, 2, 3})));
    blob.setBytes(3L, new byte[] {1, 2, 3}, 2, 10);
    assertThat(blob.getBytes(1L, 10), is(equalTo(new byte[] {0, 1, 3, 3})));
    blob.setBytes(10L, new byte[] {1, 2, 3}, 2, 10);
    assertThat(blob.getBytes(1L, 20), is(equalTo(new byte[] {0, 1, 3, 3, 0, 0, 0, 0, 0, 3})));
  }

  @Test
  public void testSetBinaryStream() throws SQLException, IOException {
    JdbcBlob blob = new JdbcBlob();
    blob.setBytes(1L, new byte[] {1, 2, 3, 4, 5});
    try (OutputStream os = blob.setBinaryStream(1L)) {
      os.write(6);
      // no flush yet, so it should be unchanged
      assertThat(blob.getBytes(1L, 20), is(equalTo(new byte[] {1, 2, 3, 4, 5})));
      os.flush();
      assertThat(blob.getBytes(1L, 20), is(equalTo(new byte[] {6, 2, 3, 4, 5})));
      os.write(7);
    }
    // closing the stream should also flush the changes
    assertThat(blob.getBytes(1L, 20), is(equalTo(new byte[] {6, 7, 3, 4, 5})));

    // test writing beyond the end of the stream
    try (OutputStream os = blob.setBinaryStream(1L)) {
      os.write(new byte[] {1, 2, 3, 4, 5, 6, 7});
      // no flush yet, so it should be unchanged
      assertThat(blob.getBytes(1L, 20), is(equalTo(new byte[] {6, 7, 3, 4, 5})));
      os.flush();
      assertThat(blob.getBytes(1L, 20), is(equalTo(new byte[] {1, 2, 3, 4, 5, 6, 7})));
    }
    assertThat(blob.getBytes(1L, 20), is(equalTo(new byte[] {1, 2, 3, 4, 5, 6, 7})));

    // test writing from a position that is larger than 1
    try (OutputStream os = blob.setBinaryStream(5L)) {
      os.write(new byte[] {1, 2, 3});
      // no flush yet, so it should be unchanged
      assertThat(blob.getBytes(1L, 20), is(equalTo(new byte[] {1, 2, 3, 4, 5, 6, 7})));
      os.flush();
      assertThat(blob.getBytes(1L, 20), is(equalTo(new byte[] {1, 2, 3, 4, 1, 2, 3})));
    }

    // test writing from a position that is larger than the current length
    try (OutputStream os = blob.setBinaryStream(10L)) {
      os.write(new byte[] {1, 2, 3});
      // no flush yet, so it should be unchanged
      assertThat(blob.getBytes(1L, 20), is(equalTo(new byte[] {1, 2, 3, 4, 1, 2, 3})));
      os.flush();
      assertThat(
          blob.getBytes(1L, 20), is(equalTo(new byte[] {1, 2, 3, 4, 1, 2, 3, 0, 0, 1, 2, 3})));
    }

    // test writing a large number of bytes
    try (OutputStream os = blob.setBinaryStream(1L)) {
      os.write(new byte[2000]);
      // no flush yet, so it should be unchanged
      assertThat(
          blob.getBytes(1L, 3000), is(equalTo(new byte[] {1, 2, 3, 4, 1, 2, 3, 0, 0, 1, 2, 3})));
      os.flush();
      assertThat(blob.getBytes(1L, 3000), is(equalTo(new byte[2000])));
    }
  }

  @Test
  public void testTruncate() throws SQLException {
    JdbcBlob blob = new JdbcBlob();
    blob.setBytes(1L, new byte[] {1, 2, 3, 4, 5});
    assertThat(blob.getBytes(1L, 20), is(equalTo(new byte[] {1, 2, 3, 4, 5})));
    blob.truncate(3);
    assertThat(blob.getBytes(1L, 20), is(equalTo(new byte[] {1, 2, 3})));
    blob.truncate(0);
    assertThat(blob.getBytes(1L, 20), is(equalTo(new byte[] {})));
  }

  @Test
  public void testFree() throws SQLException {
    JdbcBlob blob = new JdbcBlob();
    blob.setBytes(1L, new byte[] {1, 2, 3, 4, 5});
    assertThat(blob.getBytes(1L, 20), is(equalTo(new byte[] {1, 2, 3, 4, 5})));
    blob.free();
    assertThat(blob.getBytes(1L, 20), is(equalTo(new byte[] {})));
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
    assertThat(buf, is(equalTo(new byte[] {1, 2, 3, 0, 0})));

    buf = new byte[10];
    try (InputStream is = blob.getBinaryStream(4L, 10)) {
      assertThat(is.read(buf), is(equalTo(2)));
      assertThat(is.read(), is(equalTo(-1)));
    }
    assertThat(buf, is(equalTo(new byte[] {4, 5, 0, 0, 0, 0, 0, 0, 0, 0})));

    buf = new byte[10];
    try (InputStream is = blob.getBinaryStream(6L, 10)) {
      assertThat(is.read(buf), is(equalTo(-1)));
    }
    assertThat(buf, is(equalTo(new byte[10])));
  }
}
