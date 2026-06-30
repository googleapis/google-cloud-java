/*
 * Copyright 2025 Google LLC
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

import com.google.api.core.BetaApi;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParametersInfo;
import java.sql.ParameterMetaData;
import java.sql.SQLException;
import java.sql.Types;

/**
 * {@link JdbcSimpleParameterMetaData} implements {@link ParameterMetaData} without a round-trip to
 * Spanner. This is an experimental feature that can be removed in a future version without prior
 * warning.
 */
@BetaApi
class JdbcSimpleParameterMetaData implements ParameterMetaData {
  static final String USE_SIMPLE_PARAMETER_METADATA_KEY =
      "spanner.jdbc.use_simple_parameter_metadata";
  private final ParametersInfo parametersInfo;

  /**
   * This is an experimental feature that can be removed in a future version without prior warning.
   */
  @BetaApi
  static boolean useSimpleParameterMetadata() {
    return Boolean.parseBoolean(System.getProperty(USE_SIMPLE_PARAMETER_METADATA_KEY, "false"));
  }

  JdbcSimpleParameterMetaData(ParametersInfo parametersInfo) {
    this.parametersInfo = parametersInfo;
  }

  @Override
  public int getParameterCount() throws SQLException {
    return this.parametersInfo.numberOfParameters;
  }

  @Override
  public int isNullable(int param) throws SQLException {
    return ParameterMetaData.parameterNullableUnknown;
  }

  @Override
  public boolean isSigned(int param) throws SQLException {
    return false;
  }

  @Override
  public int getPrecision(int param) throws SQLException {
    return 0;
  }

  @Override
  public int getScale(int param) throws SQLException {
    return 0;
  }

  @Override
  public int getParameterType(int param) throws SQLException {
    return Types.OTHER;
  }

  @Override
  public String getParameterTypeName(int param) throws SQLException {
    return "unknown";
  }

  @Override
  public String getParameterClassName(int param) throws SQLException {
    return Object.class.getName();
  }

  @Override
  public int getParameterMode(int param) throws SQLException {
    return ParameterMetaData.parameterModeIn;
  }

  @Override
  public <T> T unwrap(Class<T> iface) throws SQLException {
    throw new SQLException("This is not a wrapper for " + iface.getName());
  }

  @Override
  public boolean isWrapperFor(Class<?> iface) throws SQLException {
    return false;
  }
}
