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

import static com.google.cloud.spanner.SpannerMatchers.isSpannerException;
import static com.google.common.truth.Truth.assertThat;
import static com.google.longrunning.Operation.newBuilder;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.google.cloud.Clock;
import com.google.cloud.WaitForOption;
import com.google.cloud.spanner.spi.SpannerRpc;
import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.rpc.Code;
import com.google.rpc.Status;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;

/** Unit tests for {@link Operation}. */
@RunWith(JUnit4.class)
public class OperationTest {
  private static final String NAME =
      "projects/test-project/instances/test-instance/databases/database-1";

  @Mock SpannerRpc rpc;
  @Mock DatabaseAdminClient dbClient;
  @Mock Clock clock;

  @Rule public ExpectedException expectedException = ExpectedException.none();

  private class ParserImpl implements Operation.Parser<Database, String> {

    @Override
    public Database parseResult(Any response) {
      try {
        return Database.fromProto(
            response.unpack(com.google.spanner.admin.database.v1.Database.class), dbClient);
      } catch (InvalidProtocolBufferException e) {
        return null;
      }
    }

    @Override
    public String parseMetadata(Any metadata) {
      try {
        return metadata.unpack(CreateDatabaseMetadata.class).getDatabase();
      } catch (InvalidProtocolBufferException e) {
        return null;
      }
    }
  }

  @Before
  public void setUp() {
    initMocks(this);
  }

  @Test
  public void failedOperation() {
    com.google.longrunning.Operation proto =
        newBuilder()
            .setName("op1")
            .setDone(true)
            .setError(Status.newBuilder().setCode(Code.NOT_FOUND.getNumber()))
            .build();
    Operation<Database, String> op = Operation.create(rpc, proto, new ParserImpl());
    assertThat(op.getName()).isEqualTo("op1");
    assertThat(op.isDone()).isTrue();
    assertThat(op.isSuccessful()).isFalse();
    assertThat(op.getMetadata()).isNull();
    expectedException.expect(isSpannerException(ErrorCode.NOT_FOUND));
    op.getResult();
  }

  @Test
  public void successfulOperation() {
    com.google.spanner.admin.database.v1.Database db =
        com.google.spanner.admin.database.v1.Database.newBuilder()
            .setName(NAME)
            .setState(com.google.spanner.admin.database.v1.Database.State.READY)
            .build();

    com.google.longrunning.Operation proto =
        newBuilder().setName("op1").setDone(true).setResponse(Any.pack(db)).build();
    Operation<Database, String> op = Operation.create(rpc, proto, new ParserImpl());
    assertThat(op.getName()).isEqualTo("op1");
    assertThat(op.isDone()).isTrue();
    assertThat(op.isSuccessful()).isTrue();
    assertThat(op.getMetadata()).isNull();
    assertThat(op.getResult().getId().getName()).isEqualTo(NAME);
  }

  @Test
  public void pendingOperation() {
    com.google.longrunning.Operation proto =
        newBuilder()
            .setName("op1")
            .setDone(false)
            .setMetadata(Any.pack(CreateDatabaseMetadata.newBuilder().setDatabase(NAME).build()))
            .build();
    Operation<Database, String> op = Operation.create(rpc, proto, new ParserImpl());
    assertThat(op.getName()).isEqualTo("op1");
    assertThat(op.isDone()).isFalse();
    assertThat(op.isSuccessful()).isFalse();
    assertThat(op.getMetadata()).isEqualTo(NAME);
    assertThat(op.getResult()).isNull();
  }

  @Test
  public void reload() {
    com.google.longrunning.Operation proto = newBuilder().setName("op1").setDone(false).build();
    Operation<Database, String> op = Operation.create(rpc, proto, new ParserImpl());
    com.google.spanner.admin.database.v1.Database db =
        com.google.spanner.admin.database.v1.Database.newBuilder()
            .setName(NAME)
            .setState(com.google.spanner.admin.database.v1.Database.State.READY)
            .build();
    proto = newBuilder().setName("op1").setDone(true).setResponse(Any.pack(db)).build();
    when(rpc.getOperation("op1")).thenReturn(proto);
    op = op.reload();
    assertThat(op.getName()).isEqualTo("op1");
    assertThat(op.isDone()).isTrue();
    assertThat(op.isSuccessful()).isTrue();
    assertThat(op.getMetadata()).isNull();
    assertThat(op.getResult().getId().getName()).isEqualTo(NAME);
  }

  @Test
  public void waitForCompletes() throws Exception {
    com.google.longrunning.Operation proto = newBuilder().setName("op1").setDone(false).build();
    Operation<Database, String> op = Operation.create(rpc, proto, new ParserImpl());
    com.google.spanner.admin.database.v1.Database db =
        com.google.spanner.admin.database.v1.Database.newBuilder()
            .setName(NAME)
            .setState(com.google.spanner.admin.database.v1.Database.State.READY)
            .build();
    com.google.longrunning.Operation proto2 =
        newBuilder().setName("op1").setDone(true).setResponse(Any.pack(db)).build();
    when(rpc.getOperation("op1")).thenReturn(proto, proto2);

    op = op.waitFor(WaitForOption.checkEvery(0, TimeUnit.MILLISECONDS));
    assertThat(op.getName()).isEqualTo("op1");
    assertThat(op.isDone()).isTrue();
    assertThat(op.isSuccessful()).isTrue();
    assertThat(op.getMetadata()).isNull();
    assertThat(op.getResult().getId().getName()).isEqualTo(NAME);
  }

  @Test
  public void waitForTimesout() throws Exception {
    com.google.longrunning.Operation proto = newBuilder().setName("op1").setDone(false).build();
    Operation<Database, String> op = Operation.create(rpc, proto, new ParserImpl(), clock);
    when(rpc.getOperation("op1")).thenReturn(proto);
    when(clock.millis()).thenReturn(0L, 50L, 100L, 150L);

    expectedException.expect(isSpannerException(ErrorCode.DEADLINE_EXCEEDED));
    op.waitFor(
        WaitForOption.checkEvery(0, TimeUnit.MILLISECONDS),
        WaitForOption.timeout(100, TimeUnit.MILLISECONDS));
  }
}
