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

package com.google.cloud.spanner.connection;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyList;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.common.base.Suppliers;
import com.google.common.io.ByteStreams;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DdlClientTests {

  private final String projectId = "test-project";
  private final String instanceId = "test-instance";
  private final String databaseId = "test-database";

  private DdlClient createSubject(DatabaseAdminClient client) {
    return DdlClient.newBuilder()
        .setDialectSupplier(Suppliers.ofInstance(Dialect.GOOGLE_STANDARD_SQL))
        .setProjectId(projectId)
        .setInstanceId(instanceId)
        .setDatabaseName(databaseId)
        .setDatabaseAdminClient(client)
        .build();
  }

  @Test
  public void testExecuteDdl() throws InterruptedException, ExecutionException {
    byte[] protoDescriptors;
    try {
      InputStream in =
          DdlBatchTest.class
              .getClassLoader()
              .getResourceAsStream("com/google/cloud/spanner/descriptors.pb");
      assertNotNull(in);
      protoDescriptors = ByteStreams.toByteArray(in);
    } catch (Exception e) {
      throw SpannerExceptionFactory.newSpannerException(e);
    }

    DatabaseAdminClient client = mock(DatabaseAdminClient.class);
    Database database = mock(Database.class);
    Database.Builder databaseBuilder = mock(Database.Builder.class);
    @SuppressWarnings("unchecked")
    OperationFuture<Void, UpdateDatabaseDdlMetadata> operation = mock(OperationFuture.class);

    when(operation.get()).thenReturn(null);
    when(client.newDatabaseBuilder((DatabaseId.of(projectId, instanceId, databaseId))))
        .thenReturn(databaseBuilder);
    when(databaseBuilder.setProtoDescriptors(protoDescriptors)).thenReturn(databaseBuilder);
    when(databaseBuilder.build()).thenReturn(database);
    when(client.updateDatabaseDdl(eq(database), anyList(), isNull())).thenReturn(operation);

    DdlClient subject = createSubject(client);
    String ddl = "CREATE TABLE FOO";
    subject.executeDdl(ddl, null);
    verify(databaseBuilder, never()).setProtoDescriptors(any(byte[].class));
    verify(client).updateDatabaseDdl(database, Collections.singletonList(ddl), null);

    subject = createSubject(client);
    List<String> ddlList = Arrays.asList("CREATE TABLE FOO", "DROP TABLE FOO");
    subject.executeDdl(ddlList, null);
    verify(databaseBuilder, never()).setProtoDescriptors(any(byte[].class));
    verify(client).updateDatabaseDdl(database, ddlList, null);

    subject = createSubject(client);
    ddlList = Arrays.asList("CREATE PROTO BUNDLE", "CREATE TABLE FOO");
    subject.executeDdl(ddlList, protoDescriptors);
    verify(databaseBuilder).setProtoDescriptors(protoDescriptors);
    verify(client).updateDatabaseDdl(database, ddlList, null);
  }

  @Test
  public void testIsCreateDatabase() {
    for (Dialect dialect : Dialect.values()) {
      assertTrue(DdlClient.isCreateDatabaseStatement(dialect, "CREATE DATABASE foo"));
      assertTrue(DdlClient.isCreateDatabaseStatement(dialect, "CREATE DATABASE \"foo\""));
      assertTrue(DdlClient.isCreateDatabaseStatement(dialect, "CREATE DATABASE `foo`"));
      assertTrue(DdlClient.isCreateDatabaseStatement(dialect, "CREATE DATABASE\tfoo"));
      assertTrue(DdlClient.isCreateDatabaseStatement(dialect, "CREATE DATABASE\n foo"));
      assertTrue(DdlClient.isCreateDatabaseStatement(dialect, "CREATE DATABASE\t\n foo"));
      assertTrue(DdlClient.isCreateDatabaseStatement(dialect, "CREATE DATABASE"));
      assertTrue(DdlClient.isCreateDatabaseStatement(dialect, "CREATE\t \n DATABASE  foo"));
      assertTrue(DdlClient.isCreateDatabaseStatement(dialect, "create\t \n DATABASE  foo"));
      assertTrue(DdlClient.isCreateDatabaseStatement(dialect, "create database foo"));

      assertFalse(DdlClient.isCreateDatabaseStatement(dialect, "CREATE VIEW foo"));
      assertFalse(DdlClient.isCreateDatabaseStatement(dialect, "CREATE DATABAS foo"));
      assertFalse(DdlClient.isCreateDatabaseStatement(dialect, "CREATE DATABASEfoo"));
      assertFalse(DdlClient.isCreateDatabaseStatement(dialect, "CREATE foo"));
    }
  }
}
