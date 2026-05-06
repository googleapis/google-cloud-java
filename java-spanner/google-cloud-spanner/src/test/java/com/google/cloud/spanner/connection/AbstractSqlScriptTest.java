/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.spanner.connection;

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.connection.AbstractSqlScriptVerifier.GenericConnection;
import com.google.cloud.spanner.connection.AbstractSqlScriptVerifier.GenericConnectionProvider;
import com.google.cloud.spanner.connection.SqlScriptVerifier.SpannerGenericConnection;
import com.google.common.base.Preconditions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public abstract class AbstractSqlScriptTest {

  @Parameter public Dialect dialect;

  @Parameters(name = "dialect = {0}")
  public static Object[] data() {
    return Dialect.values();
  }

  static class TestConnectionProvider implements GenericConnectionProvider {
    final Dialect dialect;

    TestConnectionProvider(Dialect dialect) {
      this.dialect = Preconditions.checkNotNull(dialect);
    }

    @Override
    public GenericConnection getConnection() {
      return SpannerGenericConnection.of(
          ConnectionImplTest.createConnection(
              ConnectionOptions.newBuilder()
                  .setCredentials(NoCredentials.getInstance())
                  .setUri(ConnectionImplTest.URI)
                  .build(),
              dialect));
    }
  }
}
