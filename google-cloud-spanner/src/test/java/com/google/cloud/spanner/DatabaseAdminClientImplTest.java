/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.cloud.spanner.spi.v1.SpannerRpc.Paginated;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.protobuf.Any;
import com.google.protobuf.Message;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.database.v1.Database;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;

/** Unit tests for {@link com.google.cloud.spanner.SpannerImpl.DatabaseAdminClientImpl}. */
@RunWith(JUnit4.class)
public class DatabaseAdminClientImplTest {
  private static final String PROJECT_ID = "my-project";
  private static final String INSTANCE_ID = "my-instance";
  private static final String INSTANCE_NAME = "projects/my-project/instances/my-instance";
  private static final String DB_ID = "my-db";
  private static final String DB_NAME = "projects/my-project/instances/my-instance/databases/my-db";
  private static final String DB_NAME2 =
      "projects/my-project/instances/my-instance/databases/my-db2";

  @Mock SpannerRpc rpc;
  SpannerImpl.DatabaseAdminClientImpl client;

  @Before
  public void setUp() {
    initMocks(this);
    client = new SpannerImpl.DatabaseAdminClientImpl(PROJECT_ID, rpc);
  }

  private Database getDatabaseProto() {
    return Database.newBuilder().setName(DB_NAME).setState(Database.State.READY).build();
  }

  private Database getAnotherDatabaseProto() {
    return Database.newBuilder().setName(DB_NAME2).setState(Database.State.READY).build();
  }

  static Any toAny(Message message) {
    return Any.newBuilder()
        .setTypeUrl("type.googleapis.com/" + message.getDescriptorForType().getFullName())
        .setValue(message.toByteString())
        .build();
  }

  @Test
  public void getDatabase() {
    when(rpc.getDatabase(DB_NAME)).thenReturn(getDatabaseProto());
    com.google.cloud.spanner.Database db = client.getDatabase(INSTANCE_ID, DB_ID);
    assertThat(db.getId().getName()).isEqualTo(DB_NAME);
    assertThat(db.getState()).isEqualTo(DatabaseInfo.State.READY);
  }

  @Test
  public void createDatabase() {
    when(rpc.createDatabase(
            INSTANCE_NAME, "CREATE DATABASE `" + DB_ID + "`", Collections.<String>emptyList()))
        .thenReturn(
            com.google.longrunning.Operation.newBuilder()
                .setDone(true)
                .setName("my-op")
                .setResponse(toAny(getDatabaseProto()))
                .build());
    Operation<com.google.cloud.spanner.Database, CreateDatabaseMetadata> op =
        client.createDatabase(INSTANCE_ID, DB_ID, Collections.<String>emptyList());
    assertThat(op.isDone()).isTrue();
    assertThat(op.getResult().getId().getName()).isEqualTo(DB_NAME);
  }

  @Test
  public void updateDatabaseDdl() {
    String opName = DB_NAME + "/operations/myop";
    String opId = "myop";
    List<String> ddl = ImmutableList.of();
    when(rpc.updateDatabaseDdl(DB_NAME, ddl, opId))
        .thenReturn(
            com.google.longrunning.Operation.newBuilder().setDone(true).setName(opName).build());
    Operation<Void, UpdateDatabaseDdlMetadata> op =
        client.updateDatabaseDdl(INSTANCE_ID, DB_ID, ddl, opId);
    assertThat(op.isDone());
    assertThat(op.getName()).isEqualTo(opName);
  }

  @Test
  public void updateDatabaseDdlOpAlreadyExists() {
    String opName = DB_NAME + "/operations/myop";
    String opId = "myop";
    List<String> ddl = ImmutableList.of();
    when(rpc.updateDatabaseDdl(DB_NAME, ddl, opId))
        .thenThrow(SpannerExceptionFactory.newSpannerException(ErrorCode.ALREADY_EXISTS, ""));
    Operation<Void, UpdateDatabaseDdlMetadata> op =
        client.updateDatabaseDdl(INSTANCE_ID, DB_ID, ddl, opId);
    assertThat(op.getName()).isEqualTo(opName);
  }

  @Test
  public void dropDatabase() {
    client.dropDatabase(INSTANCE_ID, DB_ID);
    verify(rpc).dropDatabase(DB_NAME);
  }

  @Test
  public void getDatabaseDdl() {
    List<String> ddl = ImmutableList.of("CREATE TABLE mytable()");
    when(rpc.getDatabaseDdl(DB_NAME)).thenReturn(ddl);
    assertThat(client.getDatabaseDdl(INSTANCE_ID, DB_ID)).isEqualTo(ddl);
  }

  @Test
  public void listDatabases() {
    String pageToken = "token";
    when(rpc.listDatabases(INSTANCE_NAME, 1, null))
        .thenReturn(new Paginated<>(ImmutableList.<Database>of(getDatabaseProto()), pageToken));
    when(rpc.listDatabases(INSTANCE_NAME, 1, pageToken))
        .thenReturn(new Paginated<>(ImmutableList.<Database>of(getAnotherDatabaseProto()), ""));
    List<com.google.cloud.spanner.Database> dbs =
        Lists.newArrayList(client.listDatabases(INSTANCE_ID, Options.pageSize(1)).iterateAll());
    assertThat(dbs.get(0).getId().getName()).isEqualTo(DB_NAME);
    assertThat(dbs.get(1).getId().getName()).isEqualTo(DB_NAME2);
    assertThat(dbs.size()).isEqualTo(2);
  }
}
