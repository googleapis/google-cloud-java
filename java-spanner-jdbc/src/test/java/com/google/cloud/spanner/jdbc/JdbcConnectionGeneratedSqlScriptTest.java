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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.connection.AbstractConnectionImplTest;
import com.google.cloud.spanner.connection.AbstractSqlScriptVerifier.GenericConnection;
import com.google.cloud.spanner.connection.AbstractSqlScriptVerifier.GenericConnectionProvider;
import com.google.cloud.spanner.connection.ConnectionImplTest;
import com.google.cloud.spanner.connection.ConnectionOptions;
import com.google.cloud.spanner.jdbc.JdbcSqlScriptVerifier.JdbcGenericConnection;
import io.opentelemetry.api.OpenTelemetry;
import java.sql.SQLException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * This test executes a SQL script that has been generated from the log of all the subclasses of
 * {@link AbstractConnectionImplTest} and covers the same test cases. Its aim is to verify that the
 * connection reacts correctly in all possible states (i.e. DML statements should not be allowed
 * when the connection is in read-only mode, or when a read-only transaction has started etc.)
 */
@RunWith(Parameterized.class)
public class JdbcConnectionGeneratedSqlScriptTest {
  @Parameter public Dialect dialect;

  @Parameters(name = "dialect = {0}")
  public static Object[] data() {
    return Dialect.values();
  }

  static class TestConnectionProvider implements GenericConnectionProvider {
    private final Dialect dialect;

    TestConnectionProvider(Dialect dialect) {
      this.dialect = dialect;
    }

    @Override
    public GenericConnection getConnection() {
      ConnectionOptions options = mock(ConnectionOptions.class);
      when(options.getUri()).thenReturn(ConnectionImplTest.URI);
      com.google.cloud.spanner.connection.Connection spannerConnection =
          ConnectionImplTest.createConnection(options, dialect);
      Spanner spanner = spannerConnection.getSpanner();
      SpannerOptions spannerOptions = mock(SpannerOptions.class);
      when(spannerOptions.getOpenTelemetry()).thenReturn(OpenTelemetry.noop());
      when(spanner.getOptions()).thenReturn(spannerOptions);
      when(spannerConnection.getDialect()).thenReturn(dialect);
      when(options.getConnection()).thenReturn(spannerConnection);
      when(options.getDatabaseId()).thenReturn(DatabaseId.of("project", "instance", "database"));
      try {
        JdbcConnection connection =
            new JdbcConnection(
                "jdbc:cloudspanner://localhost/projects/project/instances/instance/databases/database;credentialsUrl=url",
                options);
        JdbcGenericConnection res = JdbcGenericConnection.of(connection);
        res.setStripCommentsBeforeExecute(true);
        return res;
      } catch (SQLException e) {
        throw SpannerExceptionFactory.asSpannerException(e);
      }
    }
  }

  @Test
  public void testGeneratedScript() throws Exception {
    JdbcSqlScriptVerifier verifier = new JdbcSqlScriptVerifier(new TestConnectionProvider(dialect));
    String prefix = dialect == Dialect.POSTGRESQL ? "PostgreSQL/" : "";
    verifier.verifyStatementsInFile(
        prefix + "ConnectionImplGeneratedSqlScriptTest.sql", getClass(), false);
  }
}
