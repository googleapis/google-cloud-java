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

import com.google.rpc.Code;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/** Implementation of java.sql.Array for Google Cloud Spanner */
class JdbcArray implements Array {
  private static final String FREE_EXCEPTION =
      "free() has been called, array is no longer available";

  private final JdbcDataType type;
  private Object data;
  private boolean freed = false;

  /**
   * Create a JDBC {@link Array} from the given type name and array elements.
   *
   * @param typeName The Google Cloud Spanner type name to be used as the base type of the array.
   * @param elements The elements to store in the array.
   * @return the initialized {@link Array}.
   * @throws SQLException if the type name is not a valid Cloud Spanner type or if the contents of
   *     the elements array is not compatible with the base type of the array.
   */
  static JdbcArray createArray(String typeName, Object[] elements) throws SQLException {
    for (JdbcDataType type : JdbcDataType.values()) {
      if (type.getTypeName().equalsIgnoreCase(typeName)) {
        return new JdbcArray(type, elements);
      }
    }
    throw JdbcSqlExceptionFactory.of(
        "Data type " + typeName + " is unknown", Code.INVALID_ARGUMENT);
  }

  /**
   * Create a JDBC {@link Array} from the given type name and list.
   *
   * @param typeName The Google Cloud Spanner type name to be used as the base type of the array.
   * @param elements The elements to store in the array.
   * @return the initialized {@link Array}.
   * @throws SQLException if the type name is not a valid Cloud Spanner type or if the contents of
   *     the elements array is not compatible with the base type of the array.
   */
  static JdbcArray createArray(JdbcDataType type, List<? extends Object> elements) {
    return new JdbcArray(type, elements);
  }

  private JdbcArray(JdbcDataType type, Object[] elements) throws SQLException {
    this.type = type;
    if (elements != null) {
      this.data = java.lang.reflect.Array.newInstance(type.getJavaClass(), elements.length);
      try {
        System.arraycopy(elements, 0, this.data, 0, elements.length);
      } catch (Exception e) {
        throw JdbcSqlExceptionFactory.of(
            "Could not copy array elements. Make sure the supplied array only contains elements of class "
                + type.getJavaClass().getName(),
            Code.UNKNOWN,
            e);
      }
    }
  }

  private JdbcArray(JdbcDataType type, List<? extends Object> elements) {
    this.type = type;
    if (elements != null) {
      this.data = java.lang.reflect.Array.newInstance(type.getJavaClass(), elements.size());
      elements.toArray((Object[]) data);
    }
  }

  private void checkFree() throws SQLException {
    if (freed) {
      throw JdbcSqlExceptionFactory.of(FREE_EXCEPTION, Code.FAILED_PRECONDITION);
    }
  }

  @Override
  public String getBaseTypeName() throws SQLException {
    checkFree();
    return type.getTypeName();
  }

  @Override
  public int getBaseType() throws SQLException {
    checkFree();
    return type.getSqlType();
  }

  @Override
  public Object getArray() throws SQLException {
    checkFree();
    return data;
  }

  @Override
  public Object getArray(Map<String, Class<?>> map) throws SQLException {
    checkFree();
    return data;
  }

  @Override
  public Object getArray(long index, int count) throws SQLException {
    checkFree();
    return getArray(index, count, null);
  }

  @Override
  public Object getArray(long index, int count, Map<String, Class<?>> map) throws SQLException {
    checkFree();
    if (data != null) {
      Object res = java.lang.reflect.Array.newInstance(type.getJavaClass(), count);
      System.arraycopy(data, (int) index - 1, res, 0, count);
      return res;
    }
    return null;
  }

  private static final String RESULTSET_NOT_SUPPORTED =
      "Getting a ResultSet from an array is not supported";

  @Override
  public ResultSet getResultSet() throws SQLException {
    throw new SQLFeatureNotSupportedException(RESULTSET_NOT_SUPPORTED);
  }

  @Override
  public ResultSet getResultSet(Map<String, Class<?>> map) throws SQLException {
    throw new SQLFeatureNotSupportedException(RESULTSET_NOT_SUPPORTED);
  }

  @Override
  public ResultSet getResultSet(long index, int count) throws SQLException {
    throw new SQLFeatureNotSupportedException(RESULTSET_NOT_SUPPORTED);
  }

  @Override
  public ResultSet getResultSet(long index, int count, Map<String, Class<?>> map)
      throws SQLException {
    throw new SQLFeatureNotSupportedException(RESULTSET_NOT_SUPPORTED);
  }

  @Override
  public void free() throws SQLException {
    this.freed = true;
    this.data = null;
  }

  @Override
  public String toString() {
    if (data == null) {
      return "null";
    }
    boolean first = true;
    StringBuilder builder = new StringBuilder("{");
    for (Object o : (Object[]) data) {
      if (!first) {
        builder.append(",");
      }
      first = false;
      if (o == null) {
        builder.append("null");
      } else {
        builder.append(o.toString());
      }
    }
    builder.append("}");
    return builder.toString();
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof JdbcArray)) return false;
    JdbcArray array = (JdbcArray) other;
    return this.type == array.type
        && Arrays.deepEquals((Object[]) this.data, (Object[]) array.data);
  }

  @Override
  public int hashCode() {
    return this.type.hashCode() ^ Arrays.deepHashCode((Object[]) data);
  }
}
