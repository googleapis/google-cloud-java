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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.cloud.NoCredentials;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.ReadOnlyTransaction;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TimestampBound;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Matchers;

@RunWith(JUnit4.class)
public class ReadOnlyStalenessTest {
  private static final String URI =
      "cloudspanner:/projects/test-project-123/instances/test-instance/databases/test-database?readOnly=true";
  private static final String SELECT = "select foo from bar";

  private final DatabaseClient dbClient = mock(DatabaseClient.class);

  private ConnectionImpl createConnection(ConnectionOptions options) {
    Spanner spanner = mock(Spanner.class);
    SpannerPool spannerPool = mock(SpannerPool.class);
    when(spannerPool.getSpanner(any(ConnectionOptions.class), any(ConnectionImpl.class)))
        .thenReturn(spanner);
    DdlClient ddlClient = mock(DdlClient.class);
    ReadOnlyTransaction singleUseReadOnlyTx = mock(ReadOnlyTransaction.class);
    when(singleUseReadOnlyTx.executeQuery(Statement.of(SELECT))).thenReturn(mock(ResultSet.class));
    when(dbClient.singleUseReadOnlyTransaction(Matchers.any(TimestampBound.class)))
        .thenReturn(singleUseReadOnlyTx);
    ReadOnlyTransaction readOnlyTx = mock(ReadOnlyTransaction.class);
    when(readOnlyTx.executeQuery(Statement.of(SELECT))).thenReturn(mock(ResultSet.class));
    when(dbClient.readOnlyTransaction(Matchers.any(TimestampBound.class))).thenReturn(readOnlyTx);

    return new ConnectionImpl(options, spannerPool, ddlClient, dbClient);
  }

  @Test
  public void testDefaultReadOnlyStalenessAutocommitOnce() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      assertThat(connection.isAutocommit(), is(true));
      assertThat(connection.isReadOnly(), is(true));
      connection.execute(Statement.of(SELECT));
      verify(dbClient).singleUseReadOnlyTransaction(TimestampBound.strong());
    }
  }

  @Test
  public void testDefaultReadOnlyStalenessAutocommitTwice() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      assertThat(connection.isAutocommit(), is(true));
      assertThat(connection.isReadOnly(), is(true));
      connection.execute(Statement.of(SELECT));
      connection.execute(Statement.of(SELECT));
      verify(dbClient, times(2)).singleUseReadOnlyTransaction(TimestampBound.strong());
    }
  }

  @Test
  public void testDefaultReadOnlyStalenessAutocommitChanging() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      assertThat(connection.isAutocommit(), is(true));
      assertThat(connection.isReadOnly(), is(true));
      connection.execute(Statement.of(SELECT));
      verify(dbClient).singleUseReadOnlyTransaction(TimestampBound.strong());

      connection.setReadOnlyStaleness(TimestampBound.ofExactStaleness(10L, TimeUnit.SECONDS));
      connection.execute(Statement.of(SELECT));
      verify(dbClient)
          .singleUseReadOnlyTransaction(TimestampBound.ofExactStaleness(10L, TimeUnit.SECONDS));

      connection.setReadOnlyStaleness(TimestampBound.ofMaxStaleness(5L, TimeUnit.SECONDS));
      connection.execute(Statement.of(SELECT));
      verify(dbClient)
          .singleUseReadOnlyTransaction(TimestampBound.ofMaxStaleness(5L, TimeUnit.SECONDS));

      connection.setReadOnlyStaleness(TimestampBound.ofReadTimestamp(Timestamp.MIN_VALUE));
      connection.execute(Statement.of(SELECT));
      verify(dbClient)
          .singleUseReadOnlyTransaction(TimestampBound.ofReadTimestamp(Timestamp.MIN_VALUE));

      connection.setReadOnlyStaleness(TimestampBound.ofMinReadTimestamp(Timestamp.MAX_VALUE));
      connection.execute(Statement.of(SELECT));
      verify(dbClient)
          .singleUseReadOnlyTransaction(TimestampBound.ofMinReadTimestamp(Timestamp.MAX_VALUE));
    }
  }

  @Test
  public void testDefaultReadOnlyStalenessTransactionalOnce() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setAutocommit(false);
      assertThat(connection.isAutocommit(), is(false));
      assertThat(connection.isReadOnly(), is(true));
      connection.execute(Statement.of(SELECT));
      verify(dbClient).readOnlyTransaction(TimestampBound.strong());
    }
  }

  @Test
  public void testDefaultReadOnlyStalenessTransactionalTwice() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setAutocommit(false);
      assertThat(connection.isAutocommit(), is(false));
      assertThat(connection.isReadOnly(), is(true));
      connection.execute(Statement.of(SELECT));
      connection.execute(Statement.of(SELECT));
      connection.commit();
      // one transaction
      verify(dbClient, times(1)).readOnlyTransaction(TimestampBound.strong());

      connection.execute(Statement.of(SELECT));
      connection.commit();
      connection.execute(Statement.of(SELECT));
      // two transactions (plus one above)
      verify(dbClient, times(3)).readOnlyTransaction(TimestampBound.strong());
    }
  }

  @Test
  public void testDefaultReadOnlyStalenessTransactionalChanging() {
    try (Connection connection =
        createConnection(
            ConnectionOptions.newBuilder()
                .setCredentials(NoCredentials.getInstance())
                .setUri(URI)
                .build())) {
      connection.setAutocommit(false);
      assertThat(connection.isAutocommit(), is(false));
      assertThat(connection.isReadOnly(), is(true));
      connection.execute(Statement.of(SELECT));
      verify(dbClient).readOnlyTransaction(TimestampBound.strong());
      connection.commit();

      connection.setReadOnlyStaleness(TimestampBound.ofExactStaleness(10L, TimeUnit.SECONDS));
      connection.execute(Statement.of(SELECT));
      verify(dbClient).readOnlyTransaction(TimestampBound.ofExactStaleness(10L, TimeUnit.SECONDS));
      connection.commit();

      connection.setReadOnlyStaleness(TimestampBound.ofReadTimestamp(Timestamp.MIN_VALUE));
      connection.execute(Statement.of(SELECT));
      verify(dbClient).readOnlyTransaction(TimestampBound.ofReadTimestamp(Timestamp.MIN_VALUE));
      connection.commit();
    }
  }
}
