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

import static com.google.common.truth.Truth.assertThat;

import java.sql.SQLException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AbstractJdbcWrapperTest {
  /** Create a concrete sub class to use for testing. */
  private static class TestWrapper extends AbstractJdbcWrapper {
    @Override
    public boolean isClosed() throws SQLException {
      return false;
    }
  }

  /** Add a sub class for the test class for testing wrapping. */
  private static class SubTestWrapper extends TestWrapper {}

  @Test
  public void testIsWrapperFor() throws SQLException {
    TestWrapper subject = new TestWrapper();
    assertThat(subject.isWrapperFor(TestWrapper.class)).isTrue();
    assertThat(subject.isWrapperFor(SubTestWrapper.class)).isFalse();
    assertThat(subject.isWrapperFor(Object.class)).isTrue();
    assertThat(subject.isWrapperFor(getClass())).isFalse();

    subject = new SubTestWrapper();
    assertThat(subject.isWrapperFor(TestWrapper.class)).isTrue();
    assertThat(subject.isWrapperFor(SubTestWrapper.class)).isTrue();
    assertThat(subject.isWrapperFor(Object.class)).isTrue();
    assertThat(subject.isWrapperFor(getClass())).isFalse();
  }

  @Test
  public void testUnwrap() throws SQLException {
    TestWrapper subject = new TestWrapper();
    assertThat(unwrapSucceeds(subject, TestWrapper.class)).isTrue();
    assertThat(unwrapSucceeds(subject, SubTestWrapper.class)).isFalse();
    assertThat(unwrapSucceeds(subject, Object.class)).isTrue();
    assertThat(unwrapSucceeds(subject, getClass())).isFalse();
  }

  private static interface CheckedCastChecker<V> {
    boolean cast(V val);
  }

  private static final class CheckedCastToByteChecker implements CheckedCastChecker<Long> {
    @Override
    public boolean cast(Long val) {
      try {
        AbstractJdbcWrapper.checkedCastToByte(val);
        return true;
      } catch (SQLException e) {
        return false;
      }
    }
  }

  @Test
  public void testCheckedCastToByte() throws SQLException {
    CheckedCastToByteChecker checker = new CheckedCastToByteChecker();
    assertThat(checker.cast(0L)).isTrue();
    assertThat(checker.cast(1L)).isTrue();
    assertThat(checker.cast(Long.valueOf(Byte.MAX_VALUE))).isTrue();
    assertThat(checker.cast(Long.valueOf(Byte.MAX_VALUE) + 1L)).isFalse();
    assertThat(checker.cast(Long.MAX_VALUE)).isFalse();
    assertThat(checker.cast(-1L)).isTrue();
    assertThat(checker.cast(Long.valueOf(Byte.MIN_VALUE))).isTrue();
    assertThat(checker.cast(Long.valueOf(Byte.MIN_VALUE) - 1L)).isFalse();
    assertThat(checker.cast(Long.MIN_VALUE)).isFalse();
  }

  private static final class CheckedCastToShortChecker implements CheckedCastChecker<Long> {
    @Override
    public boolean cast(Long val) {
      try {
        AbstractJdbcWrapper.checkedCastToShort(val);
        return true;
      } catch (SQLException e) {
        return false;
      }
    }
  }

  @Test
  public void testCheckedCastToShort() throws SQLException {
    CheckedCastToShortChecker checker = new CheckedCastToShortChecker();
    assertThat(checker.cast(0L)).isTrue();
    assertThat(checker.cast(1L)).isTrue();
    assertThat(checker.cast(Long.valueOf(Short.MAX_VALUE))).isTrue();
    assertThat(checker.cast(Long.valueOf(Short.MAX_VALUE) + 1L)).isFalse();
    assertThat(checker.cast(Long.MAX_VALUE)).isFalse();
    assertThat(checker.cast(-1L)).isTrue();
    assertThat(checker.cast(Long.valueOf(Short.MIN_VALUE))).isTrue();
    assertThat(checker.cast(Long.valueOf(Short.MIN_VALUE) - 1L)).isFalse();
    assertThat(checker.cast(Long.MIN_VALUE)).isFalse();
  }

  private static final class CheckedCastToIntChecker implements CheckedCastChecker<Long> {
    @Override
    public boolean cast(Long val) {
      try {
        AbstractJdbcWrapper.checkedCastToInt(val);
        return true;
      } catch (SQLException e) {
        return false;
      }
    }
  }

  @Test
  public void testCheckedCastToInt() throws SQLException {
    CheckedCastToIntChecker checker = new CheckedCastToIntChecker();
    assertThat(checker.cast(0L)).isTrue();
    assertThat(checker.cast(1L)).isTrue();
    assertThat(checker.cast(Long.valueOf(Integer.MAX_VALUE))).isTrue();
    assertThat(checker.cast(Long.valueOf(Integer.MAX_VALUE) + 1L)).isFalse();
    assertThat(checker.cast(Long.MAX_VALUE)).isFalse();
    assertThat(checker.cast(-1L)).isTrue();
    assertThat(checker.cast(Long.valueOf(Integer.MIN_VALUE))).isTrue();
    assertThat(checker.cast(Long.valueOf(Integer.MIN_VALUE) - 1L)).isFalse();
    assertThat(checker.cast(Long.MIN_VALUE)).isFalse();
  }

  private static final class CheckedCastToFloatChecker implements CheckedCastChecker<Double> {
    @Override
    public boolean cast(Double val) {
      try {
        AbstractJdbcWrapper.checkedCastToFloat(val);
        return true;
      } catch (SQLException e) {
        return false;
      }
    }
  }

  @Test
  public void testCheckedCastToFloat() throws SQLException {
    CheckedCastToFloatChecker checker = new CheckedCastToFloatChecker();
    assertThat(checker.cast(0D)).isTrue();
    assertThat(checker.cast(1D)).isTrue();
    assertThat(checker.cast(Double.valueOf(Float.MAX_VALUE))).isTrue();
    assertThat(checker.cast(Double.valueOf(Float.MAX_VALUE) * 2.0D)).isFalse();
    assertThat(checker.cast(Double.MAX_VALUE)).isFalse();
    assertThat(checker.cast(-1D)).isTrue();
    assertThat(checker.cast(Double.valueOf(Float.MIN_VALUE))).isTrue();
    assertThat(checker.cast(Double.valueOf(-Float.MAX_VALUE * 2))).isFalse();
    assertThat(checker.cast(-Double.MAX_VALUE)).isFalse();
  }

  private boolean unwrapSucceeds(AbstractJdbcWrapper subject, Class<?> iface) {
    try {
      subject.unwrap(iface);
      return true;
    } catch (SQLException e) {
      return false;
    }
  }
}
