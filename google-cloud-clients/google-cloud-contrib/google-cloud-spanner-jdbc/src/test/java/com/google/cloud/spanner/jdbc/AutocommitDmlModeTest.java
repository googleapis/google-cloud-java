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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TransactionContext;
import com.google.cloud.spanner.TransactionManager;
import com.google.cloud.spanner.TransactionRunner;
import com.google.cloud.spanner.TransactionRunner.TransactionCallable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

@RunWith(JUnit4.class)
public class AutocommitDmlModeTest {
  private static final String UPDATE = "UPDATE foo SET bar=1";
  private static final String URI =
      "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database";

  private DatabaseClient dbClient;
  private TransactionContext txContext;

  @SuppressWarnings("unchecked")
  private ConnectionImpl createConnection(ConnectionOptions options) {
    dbClient = mock(DatabaseClient.class);
    txContext = mock(TransactionContext.class);
    Spanner spanner = mock(Spanner.class);
    SpannerPool spannerPool = mock(SpannerPool.class);
    when(spannerPool.getSpanner(any(ConnectionOptions.class), any(ConnectionImpl.class)))
        .thenReturn(spanner);
    DdlClient ddlClient = mock(DdlClient.class);
    TransactionRunner txRunner = mock(TransactionRunner.class);
    when(dbClient.readWriteTransaction()).thenReturn(txRunner);
    when(txRunner.run(any(TransactionCallable.class)))
        .thenAnswer(
            new Answer<Long>() {
              @Override
              public Long answer(InvocationOnMock invocation) throws Throwable {
                TransactionCallable<Long> callable =
                    (TransactionCallable<Long>) invocation.getArguments()[0];
                return callable.run(txContext);
              }
            });

    TransactionManager txManager = mock(TransactionManager.class);
    when(txManager.begin()).thenReturn(txContext);
    when(dbClient.transactionManager()).thenReturn(txManager);

    return new ConnectionImpl(options, spannerPool, ddlClient, dbClient);
  }

  @Test
  public void testAutocommitDmlModeTransactional() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      assertThat(connection.isAutocommit(), is(true));
      assertThat(connection.isReadOnly(), is(false));
      assertThat(connection.getAutocommitDmlMode(), is(AutocommitDmlMode.TRANSACTIONAL));

      connection.execute(Statement.of(UPDATE));
      verify(txContext).executeUpdate(Statement.of(UPDATE));
      verify(dbClient, never()).executePartitionedUpdate(Statement.of(UPDATE));
    }
  }

  @Test
  public void testAutocommitDmlModePartitioned() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      assertThat(connection.isAutocommit(), is(true));
      assertThat(connection.isReadOnly(), is(false));
      connection.setAutocommitDmlMode(AutocommitDmlMode.PARTITIONED_NON_ATOMIC);
      assertThat(connection.getAutocommitDmlMode(), is(AutocommitDmlMode.PARTITIONED_NON_ATOMIC));

      connection.execute(Statement.of(UPDATE));
      verify(txContext, never()).executeUpdate(Statement.of(UPDATE));
      verify(dbClient).executePartitionedUpdate(Statement.of(UPDATE));
    }
  }
}
