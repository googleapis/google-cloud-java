/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.admin.v2;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.bigtable.admin.v2.OptimizeRestoredTableMetadata;
import com.google.bigtable.admin.v2.TableName;
import com.google.cloud.bigtable.admin.v2.stub.AwaitConsistencyCallableV2;
import com.google.cloud.bigtable.admin.v2.stub.EnhancedBigtableTableAdminStub;
import com.google.cloud.bigtable.admin.v2.stub.GrpcBigtableTableAdminStub;
import com.google.protobuf.Empty;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

@RunWith(JUnit4.class)
public class BigtableTableAdminClientV2Test {
  @Rule public final MockitoRule mockitoRule = MockitoJUnit.rule();

  private static final String TABLE_NAME =
      "projects/my-project/instances/my-instance/tables/my-table";

  private GrpcBigtableTableAdminStub mockStub;

  @Mock private AwaitConsistencyCallableV2 mockAwaitConsistencyCallable;

  @Mock
  private OperationCallable<Void, Empty, OptimizeRestoredTableMetadata>
      mockOptimizeRestoredTableCallable;

  private BigtableTableAdminClientV2 client;

  @Before
  public void setUp() {
    mockStub =
        Mockito.mock(GrpcBigtableTableAdminStub.class, Mockito.withSettings().withoutAnnotations());
    client =
        new BigtableTableAdminClientV2(
            mockStub, null, false, mockAwaitConsistencyCallable, mockOptimizeRestoredTableCallable);
  }

  @Test
  public void testWaitForConsistencyWithToken() {
    // Setup
    String token = "my-token";
    ConsistencyRequest expectedRequest =
        ConsistencyRequest.forReplicationFromTableName(TABLE_NAME, token);

    final AtomicBoolean wasCalled = new AtomicBoolean(false);

    Mockito.when(mockAwaitConsistencyCallable.futureCall(expectedRequest))
        .thenAnswer(
            (Answer<ApiFuture<Void>>)
                invocationOnMock -> {
                  wasCalled.set(true);
                  return ApiFutures.immediateFuture(null);
                });

    // Execute
    client.waitForConsistency(TABLE_NAME, token);

    // Verify
    assertThat(wasCalled.get()).isTrue();
  }

  @Test
  public void testWaitForConsistencyWithTableName() {
    // Setup
    String token = "my-token";
    TableName tableName = TableName.of("my-project", "my-instance", "my-table");
    ConsistencyRequest expectedRequest =
        ConsistencyRequest.forReplicationFromTableName(tableName.toString(), token);

    final AtomicBoolean wasCalled = new AtomicBoolean(false);

    Mockito.when(mockAwaitConsistencyCallable.futureCall(expectedRequest))
        .thenAnswer(
            (Answer<ApiFuture<Void>>)
                invocationOnMock -> {
                  wasCalled.set(true);
                  return ApiFutures.immediateFuture(null);
                });

    // Execute
    client.waitForConsistency(tableName, token);

    // Verify
    assertThat(wasCalled.get()).isTrue();
  }

  @Test
  public void testAwaitOptimizeRestoredTable() throws Exception {
    // Setup
    String optimizeToken = "my-optimization-token";

    // 1. Mock the Token
    OptimizeRestoredTableOperationToken mockToken =
        Mockito.mock(OptimizeRestoredTableOperationToken.class);
    Mockito.when(mockToken.getOperationName()).thenReturn(optimizeToken);

    // 2. Mock the Result (wrapping the token)
    RestoredTableResult mockResult = Mockito.mock(RestoredTableResult.class);
    Mockito.when(mockResult.getOptimizeRestoredTableOperationToken()).thenReturn(mockToken);

    // 3. Mock the Input Future (returning immediate result)
    ApiFuture<RestoredTableResult> restoreFuture = ApiFutures.immediateFuture(mockResult);

    // 4. Mock the Stub's behavior (resuming the Optimize Op)
    OperationFuture<Empty, OptimizeRestoredTableMetadata> mockOptimizeOp =
        Mockito.mock(OperationFuture.class);
    Mockito.when(mockOptimizeOp.get()).thenReturn(Empty.getDefaultInstance());
    Mockito.doAnswer(
            invocation -> {
              Runnable runnable = invocation.getArgument(0);
              Executor executor = invocation.getArgument(1);
              executor.execute(runnable);
              return null;
            })
        .when(mockOptimizeOp)
        .addListener(Mockito.any(Runnable.class), Mockito.any(Executor.class));
    Mockito.when(mockOptimizeRestoredTableCallable.resumeFutureCall(optimizeToken))
        .thenReturn(mockOptimizeOp);

    // Execute
    ApiFuture<Empty> result = client.awaitOptimizeRestoredTable(restoreFuture);

    // Verify
    assertThat(result.get()).isEqualTo(Empty.getDefaultInstance());
    Mockito.verify(mockOptimizeRestoredTableCallable).resumeFutureCall(optimizeToken);
  }

  @Test
  public void testAwaitOptimizeRestoredTable_NoOp() throws Exception {
    // Setup: Result with NO optimization token (null or empty)
    RestoredTableResult mockResult = Mockito.mock(RestoredTableResult.class);
    Mockito.when(mockResult.getOptimizeRestoredTableOperationToken()).thenReturn(null);

    // Mock the Input Future (returning immediate result)
    ApiFuture<RestoredTableResult> restoreFuture = ApiFutures.immediateFuture(mockResult);

    // Execute
    ApiFuture<Empty> result = client.awaitOptimizeRestoredTable(restoreFuture);

    // Verify: Returns immediate success (Empty) without calling the stub
    assertThat(result.get()).isEqualTo(Empty.getDefaultInstance());
  }

  @Test
  public void testCreateClientWithSettings() throws Exception {
    BaseBigtableTableAdminSettings settings =
        BaseBigtableTableAdminSettings.newBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setEndpoint("localhost:8080")
            .build();
    try (BigtableTableAdminClientV2 settingsClient = BigtableTableAdminClientV2.create(settings)) {
      // Verify that the underlying stub is NOT an Enhanced stub by default
      // but the client has successfully initialized its own callables.
      assertThat(settingsClient.getStub()).isNotInstanceOf(EnhancedBigtableTableAdminStub.class);
    }
  }

  @Test
  public void testAwaitConsistency_ThrowsWhenNotInitialized() {
    BigtableTableAdminClientV2 uninitializedClient =
        new BigtableTableAdminClientV2(mockStub, null, false, null, null);

    try {
      uninitializedClient.waitForConsistency(TABLE_NAME, "token");
      org.junit.Assert.fail("Expected IllegalStateException");
    } catch (IllegalStateException e) {
      assertThat(e.getMessage())
          .contains("BigtableTableAdminClientV2.create(BaseBigtableTableAdminSettings)");
    }
  }

  @Test
  public void testOptimizeRestoredTable_ThrowsWhenNotInitialized() {
    BigtableTableAdminClientV2 uninitializedClient =
        new BigtableTableAdminClientV2(mockStub, null, false, null, null);

    OptimizeRestoredTableOperationToken mockToken =
        Mockito.mock(OptimizeRestoredTableOperationToken.class);
    Mockito.when(mockToken.getOperationName()).thenReturn("op-name");

    try {
      uninitializedClient.awaitOptimizeRestoredTableAsync(mockToken);
      org.junit.Assert.fail("Expected IllegalStateException");
    } catch (IllegalStateException e) {
      assertThat(e.getMessage())
          .contains("BigtableTableAdminClientV2.create(BaseBigtableTableAdminSettings)");
    }
  }
}
