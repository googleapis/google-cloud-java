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

import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DdlClientTest {

  private final String instanceId = "test-instance";
  private final String databaseId = "test-database";

  private DdlClient createSubject(DatabaseAdminClient client) {
    return DdlClient.newBuilder()
        .setInstanceId(instanceId)
        .setDatabaseName(databaseId)
        .setDatabaseAdminClient(client)
        .build();
  }

  @Test
  public void testExecuteDdl() throws InterruptedException, ExecutionException {
    DatabaseAdminClient client = mock(DatabaseAdminClient.class);
    @SuppressWarnings("unchecked")
    OperationFuture<Void, UpdateDatabaseDdlMetadata> operation = mock(OperationFuture.class);
    when(operation.get()).thenReturn(null);
    when(client.updateDatabaseDdl(
            eq(instanceId), eq(databaseId), anyListOf(String.class), isNull(String.class)))
        .thenReturn(operation);
    DdlClient subject = createSubject(client);
    String ddl = "CREATE TABLE FOO";
    subject.executeDdl(ddl);
    verify(client).updateDatabaseDdl(instanceId, databaseId, Arrays.asList(ddl), null);

    subject = createSubject(client);
    List<String> ddlList = Arrays.asList("CREATE TABLE FOO", "DROP TABLE FOO");
    subject.executeDdl(ddlList);
    verify(client).updateDatabaseDdl(instanceId, databaseId, ddlList, null);
  }
}
