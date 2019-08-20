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

import com.google.cloud.spanner.jdbc.AbstractSqlScriptVerifier.GenericConnection;
import com.google.cloud.spanner.jdbc.AbstractSqlScriptVerifier.GenericConnectionProvider;
import com.google.cloud.spanner.jdbc.JdbcSqlScriptVerifier.JdbcGenericConnection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * This test executes a SQL script that has been generated from the log of all the subclasses of
 * {@link AbstractConnectionImplTest} and covers the same test cases. Its aim is to verify that the
 * connection reacts correctly in all possible states (i.e. DML statements should not be allowed
 * when the connection is in read-only mode, or when a read-only transaction has started etc.)
 */
@RunWith(JUnit4.class)
public class JdbcConnectionGeneratedSqlScriptTest {

  static class TestConnectionProvider implements GenericConnectionProvider {
    @Override
    public GenericConnection getConnection() {
      ConnectionOptions options = mock(ConnectionOptions.class);
      when(options.getUri()).thenReturn(ConnectionImplTest.URI);
      com.google.cloud.spanner.jdbc.Connection spannerConnection =
          ConnectionImplTest.createConnection(options);
      when(options.getConnection()).thenReturn(spannerConnection);
      JdbcConnection connection =
          new JdbcConnection(
              "jdbc:cloudspanner://localhost/projects/project/instances/instance/databases/database;credentialsUrl=url",
              options);
      JdbcGenericConnection res = JdbcGenericConnection.of(connection);
      res.setStripCommentsBeforeExecute(true);
      return res;
    }
  }

  @Test
  public void testGeneratedScript() throws Exception {
    JdbcSqlScriptVerifier verifier = new JdbcSqlScriptVerifier(new TestConnectionProvider());
    verifier.verifyStatementsInFile(
        "ConnectionImplGeneratedSqlScriptTest.sql", SqlScriptVerifier.class);
  }
}
