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
import java.io.Reader;
import java.io.Writer;
import java.sql.SQLException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class JdbcClobTest {

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

  private static final class PosString {
    private final long pos;
    private final String str;

    private static PosString of(long pos, String str) {
      return new PosString(pos, str);
    }

    private PosString(long pos, String str) {
      this.pos = pos;
      this.str = str;
    }

    @Override
    public String toString() {
      return "pos: " + pos + ", str: " + str;
    }
  }

  @Test
  public void testLength() throws SQLException {
    JdbcClob clob = new JdbcClob();
    clob.setString(1L, "test");
    assertEquals(4L, clob.length());
    clob.setString(1L, "test-test");
    assertEquals(9L, clob.length());
  }

  @Test
  public void testGetSubstring() throws SQLException {
    JdbcClob clob = new JdbcClob();
    clob.setString(1L, "test");
    assertEquals("test", clob.getSubString(1, 4));
    assertEquals("te", clob.getSubString(1, 2));
    assertEquals("st", clob.getSubString(3, 2));
    assertEquals("test", clob.getSubString(1, 5));
    assertEquals("t", clob.getSubString(4, 5));
    assertEquals("", clob.getSubString(5, 5));
    assertEquals("", clob.getSubString(6, 5));

    // test invalid parameters
    PosLength[] params =
        new PosLength[] {PosLength.of(0L, 4), PosLength.of(-1L, 4), PosLength.of(1L, -1)};
    for (PosLength param : params) {
      SQLException sqlException =
          assertThrows(SQLException.class, () -> clob.getSubString(param.pos, param.len));
      assertTrue(sqlException instanceof JdbcSqlException);
      JdbcSqlException jdbcSqlException = (JdbcSqlException) sqlException;
      assertEquals(Code.INVALID_ARGUMENT, jdbcSqlException.getCode());
    }
  }

  @Test
  public void testGetCharacterStream() throws SQLException, IOException {
    JdbcClob clob = new JdbcClob();
    clob.setString(1L, "test");
    char[] cbuf = new char[4];
    try (Reader reader = clob.getCharacterStream()) {
      assertEquals(4, reader.read(cbuf, 0, 4));
    }
    assertArrayEquals(new char[] {'t', 'e', 's', 't'}, cbuf);
    try (Reader reader = clob.getCharacterStream()) {
      assertEquals(2, reader.read(cbuf, 0, 2));
      assertEquals(2, reader.read(cbuf, 2, 2));
    }
    assertArrayEquals(new char[] {'t', 'e', 's', 't'}, cbuf);
    try (Reader reader = clob.getCharacterStream()) {
      assertEquals(2, reader.read(cbuf, 0, 2));
      // changing the value of the clob will not change a character stream that has already been
      // opened
      clob.setString(1L, "foobar");
      assertEquals(2, reader.read(cbuf, 2, 2));
    }
    assertArrayEquals(new char[] {'t', 'e', 's', 't'}, cbuf);
  }

  @Test
  public void testPositionString() throws SQLException {
    JdbcClob clob = new JdbcClob();
    clob.setString(1L, "test");
    assertEquals(3L, clob.position("st", 1L));
    clob.setString(1L, "foobarfoobar");
    assertEquals(4L, clob.position("bar", 1L));
    assertEquals(4L, clob.position("bar", 2L));
    assertEquals(10L, clob.position("bar", 5L));
    assertEquals(10L, clob.position("bar", 8L));
    assertEquals(10L, clob.position("bar", 10L));
    assertEquals(-1L, clob.position("bar", 11L));
    assertEquals(-1L, clob.position("bar", 100L));
    assertEquals(-1L, clob.position("not_there", 1L));
    // test invalid parameters
    PosString[] params =
        new PosString[] {PosString.of(0L, "bar"), PosString.of(-1L, "bar"), PosString.of(1L, null)};
    for (PosString param : params) {
      SQLException sqlException =
          assertThrows(SQLException.class, () -> clob.position(param.str, param.pos));
      assertTrue(sqlException instanceof JdbcSqlException);
      JdbcSqlException jdbcSqlException = (JdbcSqlException) sqlException;
      assertEquals(Code.INVALID_ARGUMENT, jdbcSqlException.getCode());
    }
  }

  @Test
  public void testPositionClob() throws SQLException {
    JdbcClob clob = new JdbcClob();
    clob.setString(1L, "test");
    JdbcClob search = new JdbcClob();
    search.setString(1L, "st");
    assertEquals(3L, clob.position(search, 1L));
    clob.setString(1L, "foobarfoobar");
    search.setString(1L, "bar");
    assertEquals(4L, clob.position(search, 1L));
    assertEquals(4L, clob.position(search, 2L));
    assertEquals(10L, clob.position(search, 5L));
    assertEquals(10L, clob.position(search, 8L));
    assertEquals(10L, clob.position(search, 10L));
    assertEquals(-1L, clob.position(search, 11L));
    assertEquals(-1L, clob.position(search, 100L));
    search.setString(1L, "not_there");
    assertEquals(-1L, clob.position(search, 1L));
    // test invalid parameters
    PosString[] params =
        new PosString[] {PosString.of(0L, "bar"), PosString.of(-1L, "bar"), PosString.of(1L, null)};
    for (PosString param : params) {
      SQLException sqlException =
          assertThrows(
              SQLException.class,
              () -> {
                search.setString(1L, param.str);
                clob.position(search, param.pos);
              });
      assertTrue(sqlException instanceof JdbcSqlException);
      JdbcSqlException jdbcSqlException = (JdbcSqlException) sqlException;
      assertEquals(Code.INVALID_ARGUMENT, jdbcSqlException.getCode());
    }
  }

  @Test
  public void testSetString() throws SQLException {
    JdbcClob clob = new JdbcClob();
    clob.setString(1L, "test");
    assertEquals("test", clob.getSubString(1L, 4));
    clob.setString(1L, "bar");
    assertEquals("bart", clob.getSubString(1L, 4));
    clob.setString(1L, "foobar");
    assertEquals("foobar", clob.getSubString(1L, 6));
    clob.setString(2L, "foobar");
    assertEquals("ffoobar", clob.getSubString(1L, 7));
    clob.setString(8L, "test");
    assertEquals("ffoobartest", clob.getSubString(1L, 11));
    clob.setString(15, "end");
    assertEquals("ffoobartest   end", clob.getSubString(1L, 17));
    // test invalid parameters
    PosString[] params =
        new PosString[] {PosString.of(0L, "bar"), PosString.of(-1L, "bar"), PosString.of(1L, null)};
    for (PosString param : params) {
      SQLException sqlException =
          assertThrows(SQLException.class, () -> clob.setString(param.pos, param.str));
      assertTrue(sqlException instanceof JdbcSqlException);
      JdbcSqlException jdbcSqlException = (JdbcSqlException) sqlException;
      assertEquals(Code.INVALID_ARGUMENT, jdbcSqlException.getCode());
    }
  }

  @Test
  public void testSetStringOffsetLen() throws SQLException {
    JdbcClob clob = new JdbcClob();
    clob.setString(1L, "test", 2, 3);
    assertEquals("est", clob.getSubString(1L, 4));
    clob.setString(1L, "bar", 1, 1);
    assertEquals("bst", clob.getSubString(1L, 4));
    clob.setString(1L, "foobar", 1, 6);
    assertEquals("foobar", clob.getSubString(1L, 6));
    clob.setString(2L, "foobar", 2, 5);
    assertEquals("foobar", clob.getSubString(1L, 7));
    clob.setString(8L, "test", 4, 1);
    assertEquals("foobar t", clob.getSubString(1L, 8));
    clob.setString(15, "end", 1, 3);
    assertEquals("foobar t      end", clob.getSubString(1L, 17));
  }

  @Test
  public void testSetCharacterStream() throws SQLException, IOException {
    JdbcClob clob = new JdbcClob();
    clob.setString(1, "foobar");
    assertEquals("foobar", clob.getSubString(1L, 6));
    try (Writer writer = clob.setCharacterStream(1L)) {
      writer.write("t");
      // not yet flushed, there should be no change
      assertEquals("foobar", clob.getSubString(1L, 6));
      writer.flush();
      // after a flush the change should be visible
      assertEquals("toobar", clob.getSubString(1L, 6));
      writer.write("est");
    }
    // close should also auto-flush
    assertEquals("testar", clob.getSubString(1L, 6));

    // start all over
    clob.free();
    clob.setString(1, "foobar");
    assertEquals("foobar", clob.getSubString(1L, 6));
    try (Writer writer = clob.setCharacterStream(5L)) {
      writer.write("t");
      // not yet flushed, there should be no change
      assertEquals("foobar", clob.getSubString(1L, 6));
      writer.flush();
      // after a flush the change should be visible
      assertEquals("foobtr", clob.getSubString(1L, 6));
      writer.write("est");
    }
    // close should also auto-flush
    assertEquals("foobtest", clob.getSubString(1L, 8));

    // do a test with multiple flushes
    clob.free();
    clob.setString(1, "foobar");
    assertEquals("foobar", clob.getSubString(1L, 6));
    try (Writer writer = clob.setCharacterStream(1L)) {
      writer.write("t");
      assertEquals("foobar", clob.getSubString(1L, 6));
      writer.flush();
      assertEquals("toobar", clob.getSubString(1L, 6));
      writer.write("est");
      assertEquals("toobar", clob.getSubString(1L, 6));
      writer.flush();
      assertEquals("testar", clob.getSubString(1L, 6));
    }
    assertEquals("testar", clob.getSubString(1L, 8));

    // writer after end
    clob.free();
    clob.setString(1, "foobar");
    assertEquals("foobar", clob.getSubString(1L, 10));
    try (Writer writer = clob.setCharacterStream(10L)) {
      writer.write("t");
      assertEquals("foobar", clob.getSubString(1L, 20));
      writer.flush();
      assertEquals("foobar   t", clob.getSubString(1L, 20));
      writer.write("est");
    }
    assertEquals("foobar   test", clob.getSubString(1L, 20));
  }

  @Test
  public void testTruncate() throws SQLException {
    JdbcClob clob = new JdbcClob();
    clob.setString(1L, "foobar");
    assertEquals("foobar", clob.getSubString(1L, 6));
    clob.truncate(3L);
    assertEquals("foo", clob.getSubString(1L, 6));
    clob.truncate(0L);
    assertEquals("", clob.getSubString(1L, 6));
  }

  @Test
  public void testFree() throws SQLException {
    JdbcClob clob = new JdbcClob();
    clob.setString(1L, "foobar");
    assertEquals("foobar", clob.getSubString(1L, 6));
    clob.free();
    assertEquals("", clob.getSubString(1L, 6));
  }
}
