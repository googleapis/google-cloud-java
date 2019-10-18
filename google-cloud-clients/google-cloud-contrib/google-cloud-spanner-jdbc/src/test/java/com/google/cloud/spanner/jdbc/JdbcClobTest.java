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
    assertThat(clob.length(), is(equalTo(4L)));
    clob.setString(1L, "test-test");
    assertThat(clob.length(), is(equalTo(9L)));
  }

  @Test
  public void testGetSubstring() throws SQLException {
    JdbcClob clob = new JdbcClob();
    clob.setString(1L, "test");
    assertThat(clob.getSubString(1, 4), is(equalTo("test")));
    assertThat(clob.getSubString(1, 2), is(equalTo("te")));
    assertThat(clob.getSubString(3, 2), is(equalTo("st")));
    assertThat(clob.getSubString(1, 5), is(equalTo("test")));
    assertThat(clob.getSubString(4, 5), is(equalTo("t")));
    assertThat(clob.getSubString(5, 5), is(equalTo("")));
    assertThat(clob.getSubString(6, 5), is(equalTo("")));

    // test invalid parameters
    PosLength[] params =
        new PosLength[] {PosLength.of(0L, 4), PosLength.of(-1L, 4), PosLength.of(1L, -1)};
    for (PosLength param : params) {
      boolean exception = false;
      try {
        clob.getSubString(param.pos, param.len);
      } catch (SQLException e) {
        exception =
            (e instanceof JdbcSqlException
                && ((JdbcSqlException) e).getCode() == Code.INVALID_ARGUMENT);
      }
      assertThat(param.toString(), exception, is(true));
    }
  }

  @Test
  public void testGetCharacterStream() throws SQLException, IOException {
    JdbcClob clob = new JdbcClob();
    clob.setString(1L, "test");
    char[] cbuf = new char[4];
    try (Reader reader = clob.getCharacterStream()) {
      reader.read(cbuf, 0, 4);
    }
    assertThat(cbuf, is(equalTo(new char[] {'t', 'e', 's', 't'})));
    try (Reader reader = clob.getCharacterStream()) {
      reader.read(cbuf, 0, 2);
      reader.read(cbuf, 2, 2);
    }
    assertThat(cbuf, is(equalTo(new char[] {'t', 'e', 's', 't'})));
    try (Reader reader = clob.getCharacterStream()) {
      reader.read(cbuf, 0, 2);
      // changing the value of the clob will not change a character stream that has already been
      // opened
      clob.setString(1L, "foobar");
      reader.read(cbuf, 2, 2);
    }
    assertThat(cbuf, is(equalTo(new char[] {'t', 'e', 's', 't'})));
  }

  @Test
  public void testPositionString() throws SQLException {
    JdbcClob clob = new JdbcClob();
    clob.setString(1L, "test");
    assertThat(clob.position("st", 1L), is(equalTo(3L)));
    clob.setString(1L, "foobarfoobar");
    assertThat(clob.position("bar", 1L), is(equalTo(4L)));
    assertThat(clob.position("bar", 2L), is(equalTo(4L)));
    assertThat(clob.position("bar", 5L), is(equalTo(10L)));
    assertThat(clob.position("bar", 8L), is(equalTo(10L)));
    assertThat(clob.position("bar", 10L), is(equalTo(10L)));
    assertThat(clob.position("bar", 11L), is(equalTo(-1L)));
    assertThat(clob.position("bar", 100L), is(equalTo(-1L)));
    assertThat(clob.position("not_there", 1L), is(equalTo(-1L)));
    // test invalid parameters
    PosString[] params =
        new PosString[] {PosString.of(0L, "bar"), PosString.of(-1L, "bar"), PosString.of(1L, null)};
    for (PosString param : params) {
      boolean exception = false;
      try {
        clob.position(param.str, param.pos);
      } catch (SQLException e) {
        exception =
            (e instanceof JdbcSqlException
                && ((JdbcSqlException) e).getCode() == Code.INVALID_ARGUMENT);
      }
      assertThat(param.toString(), exception, is(true));
    }
  }

  @Test
  public void testPositionClob() throws SQLException {
    JdbcClob clob = new JdbcClob();
    clob.setString(1L, "test");
    JdbcClob search = new JdbcClob();
    search.setString(1L, "st");
    assertThat(clob.position(search, 1L), is(equalTo(3L)));
    clob.setString(1L, "foobarfoobar");
    search.setString(1L, "bar");
    assertThat(clob.position(search, 1L), is(equalTo(4L)));
    assertThat(clob.position(search, 2L), is(equalTo(4L)));
    assertThat(clob.position(search, 5L), is(equalTo(10L)));
    assertThat(clob.position(search, 8L), is(equalTo(10L)));
    assertThat(clob.position(search, 10L), is(equalTo(10L)));
    assertThat(clob.position(search, 11L), is(equalTo(-1L)));
    assertThat(clob.position(search, 100L), is(equalTo(-1L)));
    search.setString(1L, "not_there");
    assertThat(clob.position(search, 1L), is(equalTo(-1L)));
    // test invalid parameters
    PosString[] params =
        new PosString[] {PosString.of(0L, "bar"), PosString.of(-1L, "bar"), PosString.of(1L, null)};
    for (PosString param : params) {
      boolean exception = false;
      try {
        search.setString(1L, param.str);
        clob.position(search, param.pos);
      } catch (SQLException e) {
        exception =
            (e instanceof JdbcSqlException
                && ((JdbcSqlException) e).getCode() == Code.INVALID_ARGUMENT);
      }
      assertThat(param.toString(), exception, is(true));
    }
  }

  @Test
  public void testSetString() throws SQLException {
    JdbcClob clob = new JdbcClob();
    clob.setString(1L, "test");
    assertThat(clob.getSubString(1L, 4), is(equalTo("test")));
    clob.setString(1L, "bar");
    assertThat(clob.getSubString(1L, 4), is(equalTo("bart")));
    clob.setString(1L, "foobar");
    assertThat(clob.getSubString(1L, 6), is(equalTo("foobar")));
    clob.setString(2L, "foobar");
    assertThat(clob.getSubString(1L, 7), is(equalTo("ffoobar")));
    clob.setString(8L, "test");
    assertThat(clob.getSubString(1L, 11), is(equalTo("ffoobartest")));
    clob.setString(15, "end");
    assertThat(clob.getSubString(1L, 17), is(equalTo("ffoobartest   end")));
    // test invalid parameters
    PosString[] params =
        new PosString[] {PosString.of(0L, "bar"), PosString.of(-1L, "bar"), PosString.of(1L, null)};
    for (PosString param : params) {
      boolean exception = false;
      try {
        clob.setString(param.pos, param.str);
      } catch (SQLException e) {
        exception =
            (e instanceof JdbcSqlException
                && ((JdbcSqlException) e).getCode() == Code.INVALID_ARGUMENT);
      }
      assertThat(param.toString(), exception, is(true));
    }
  }

  @Test
  public void testSetStringOffsetLen() throws SQLException {
    JdbcClob clob = new JdbcClob();
    clob.setString(1L, "test", 2, 3);
    assertThat(clob.getSubString(1L, 4), is(equalTo("est")));
    clob.setString(1L, "bar", 1, 1);
    assertThat(clob.getSubString(1L, 4), is(equalTo("bst")));
    clob.setString(1L, "foobar", 1, 6);
    assertThat(clob.getSubString(1L, 6), is(equalTo("foobar")));
    clob.setString(2L, "foobar", 2, 5);
    assertThat(clob.getSubString(1L, 7), is(equalTo("foobar")));
    clob.setString(8L, "test", 4, 1);
    assertThat(clob.getSubString(1L, 8), is(equalTo("foobar t")));
    clob.setString(15, "end", 1, 3);
    assertThat(clob.getSubString(1L, 17), is(equalTo("foobar t      end")));
  }

  @Test
  public void testSetCharacterStream() throws SQLException, IOException {
    JdbcClob clob = new JdbcClob();
    clob.setString(1, "foobar");
    assertThat(clob.getSubString(1L, 6), is(equalTo("foobar")));
    try (Writer writer = clob.setCharacterStream(1L)) {
      writer.write("t");
      // not yet flushed, there should be no change
      assertThat(clob.getSubString(1L, 6), is(equalTo("foobar")));
      writer.flush();
      // after a flush the change should be visible
      assertThat(clob.getSubString(1L, 6), is(equalTo("toobar")));
      writer.write("est");
    }
    // close should also autoflush
    assertThat(clob.getSubString(1L, 6), is(equalTo("testar")));

    // start all over
    clob.free();
    clob.setString(1, "foobar");
    assertThat(clob.getSubString(1L, 6), is(equalTo("foobar")));
    try (Writer writer = clob.setCharacterStream(5L)) {
      writer.write("t");
      // not yet flushed, there should be no change
      assertThat(clob.getSubString(1L, 6), is(equalTo("foobar")));
      writer.flush();
      // after a flush the change should be visible
      assertThat(clob.getSubString(1L, 6), is(equalTo("foobtr")));
      writer.write("est");
    }
    // close should also autoflush
    assertThat(clob.getSubString(1L, 8), is(equalTo("foobtest")));

    // do a test with multiple flushes
    clob.free();
    clob.setString(1, "foobar");
    assertThat(clob.getSubString(1L, 6), is(equalTo("foobar")));
    try (Writer writer = clob.setCharacterStream(1L)) {
      writer.write("t");
      assertThat(clob.getSubString(1L, 6), is(equalTo("foobar")));
      writer.flush();
      assertThat(clob.getSubString(1L, 6), is(equalTo("toobar")));
      writer.write("est");
      assertThat(clob.getSubString(1L, 6), is(equalTo("toobar")));
      writer.flush();
      assertThat(clob.getSubString(1L, 6), is(equalTo("testar")));
    }
    assertThat(clob.getSubString(1L, 8), is(equalTo("testar")));

    // writer after end
    clob.free();
    clob.setString(1, "foobar");
    assertThat(clob.getSubString(1L, 10), is(equalTo("foobar")));
    try (Writer writer = clob.setCharacterStream(10L)) {
      writer.write("t");
      assertThat(clob.getSubString(1L, 20), is(equalTo("foobar")));
      writer.flush();
      assertThat(clob.getSubString(1L, 20), is(equalTo("foobar   t")));
      writer.write("est");
    }
    assertThat(clob.getSubString(1L, 20), is(equalTo("foobar   test")));
  }

  @Test
  public void testTruncate() throws SQLException {
    JdbcClob clob = new JdbcClob();
    clob.setString(1L, "foobar");
    assertThat(clob.getSubString(1L, 6), is(equalTo("foobar")));
    clob.truncate(3L);
    assertThat(clob.getSubString(1L, 6), is(equalTo("foo")));
    clob.truncate(0L);
    assertThat(clob.getSubString(1L, 6), is(equalTo("")));
  }

  @Test
  public void testFree() throws SQLException {
    JdbcClob clob = new JdbcClob();
    clob.setString(1L, "foobar");
    assertThat(clob.getSubString(1L, 6), is(equalTo("foobar")));
    clob.free();
    assertThat(clob.getSubString(1L, 6), is(equalTo("")));
  }
}
