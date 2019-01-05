/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.admin.v2.stub;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.retrying.PollException;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.gax.rpc.testing.FakeApiException;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.bigtable.admin.v2.CheckConsistencyRequest;
import com.google.bigtable.admin.v2.CheckConsistencyResponse;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenRequest;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenResponse;
import com.google.bigtable.admin.v2.TableName;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.threeten.bp.Duration;

@RunWith(MockitoJUnitRunner.class)
public class AwaitReplicationCallableTest {
  private static final TableName TABLE_NAME = TableName.of("my-project", "my-instance", "my-table");
  private static final ApiCallContext CALL_CONTEXT = FakeCallContext.createDefault();

  @Mock
  private UnaryCallable<GenerateConsistencyTokenRequest, GenerateConsistencyTokenResponse>
      mockGenerateConsistencyTokenCallable;

  @Mock
  private UnaryCallable<CheckConsistencyRequest, CheckConsistencyResponse>
      mockCheckConsistencyCallable;

  private AwaitReplicationCallable callable;

  @Before
  public void setUp() {
    ClientContext clientContext =
        ClientContext.newBuilder().setDefaultCallContext(CALL_CONTEXT).build();

    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setTotalTimeout(Duration.ofMillis(100))
            // Delay settings: 1 ms const
            .setInitialRetryDelay(Duration.ofMillis(1))
            .setMaxRetryDelay(Duration.ofMillis(1))
            .setRetryDelayMultiplier(1.0)
            // RPC timeout: ignored const 1 s
            .setInitialRpcTimeout(Duration.ofSeconds(1))
            .setMaxRpcTimeout(Duration.ofSeconds(1))
            .setRpcTimeoutMultiplier(1.0)
            .build();

    callable =
        AwaitReplicationCallable.create(
            mockGenerateConsistencyTokenCallable,
            mockCheckConsistencyCallable,
            clientContext,
            retrySettings);
  }

  @Test
  public void testGenerateFailure() throws Exception {
    GenerateConsistencyTokenRequest expectedRequest =
        GenerateConsistencyTokenRequest.newBuilder().setName(TABLE_NAME.toString()).build();
    FakeApiException fakeError = new FakeApiException("fake", null, Code.INTERNAL, false);

    Mockito.when(mockGenerateConsistencyTokenCallable.futureCall(expectedRequest, CALL_CONTEXT))
        .thenReturn(ApiFutures.<GenerateConsistencyTokenResponse>immediateFailedFuture(fakeError));

    ApiFuture<Void> future = callable.futureCall(TABLE_NAME, CALL_CONTEXT);

    Throwable actualError = null;

    try {
      future.get();
    } catch (ExecutionException e) {
      actualError = e.getCause();
    }

    assertThat(actualError).isSameAs(fakeError);
  }

  @Test
  public void testCheckFailure() throws Exception {
    GenerateConsistencyTokenRequest expectedRequest =
        GenerateConsistencyTokenRequest.newBuilder().setName(TABLE_NAME.toString()).build();
    GenerateConsistencyTokenResponse expectedResponse =
        GenerateConsistencyTokenResponse.newBuilder().setConsistencyToken("fake-token").build();

    Mockito.when(mockGenerateConsistencyTokenCallable.futureCall(expectedRequest, CALL_CONTEXT))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    CheckConsistencyRequest expectedRequest2 =
        CheckConsistencyRequest.newBuilder()
            .setName(TABLE_NAME.toString())
            .setConsistencyToken("fake-token")
            .build();

    FakeApiException expectedError = new FakeApiException("fake", null, Code.INTERNAL, false);

    Mockito.when(mockCheckConsistencyCallable.futureCall(expectedRequest2, CALL_CONTEXT))
        .thenReturn(ApiFutures.<CheckConsistencyResponse>immediateFailedFuture(expectedError));

    ApiFuture<Void> future = callable.futureCall(TABLE_NAME, CALL_CONTEXT);

    Throwable actualError = null;

    try {
      future.get();
    } catch (ExecutionException e) {
      actualError = e.getCause();
    }

    assertThat(actualError).isSameAs(expectedError);
  }

  @Test
  public void testImmediatelyConsistent() throws Exception {
    GenerateConsistencyTokenRequest expectedRequest =
        GenerateConsistencyTokenRequest.newBuilder().setName(TABLE_NAME.toString()).build();

    GenerateConsistencyTokenResponse expectedResponse =
        GenerateConsistencyTokenResponse.newBuilder().setConsistencyToken("fake-token").build();

    Mockito.when(mockGenerateConsistencyTokenCallable.futureCall(expectedRequest, CALL_CONTEXT))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    CheckConsistencyRequest expectedRequest2 =
        CheckConsistencyRequest.newBuilder()
            .setName(TABLE_NAME.toString())
            .setConsistencyToken("fake-token")
            .build();
    CheckConsistencyResponse expectedResponse2 =
        CheckConsistencyResponse.newBuilder().setConsistent(true).build();

    Mockito.when(mockCheckConsistencyCallable.futureCall(expectedRequest2, CALL_CONTEXT))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse2));

    ApiFuture<Void> consistentFuture = callable.futureCall(TABLE_NAME, CALL_CONTEXT);

    consistentFuture.get(1, TimeUnit.MILLISECONDS);
  }

  @Test
  public void testPolling() throws Exception {
    GenerateConsistencyTokenRequest expectedRequest =
        GenerateConsistencyTokenRequest.newBuilder().setName(TABLE_NAME.toString()).build();

    GenerateConsistencyTokenResponse expectedResponse =
        GenerateConsistencyTokenResponse.newBuilder().setConsistencyToken("fake-token").build();

    Mockito.when(mockGenerateConsistencyTokenCallable.futureCall(expectedRequest, CALL_CONTEXT))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    CheckConsistencyRequest expectedRequest2 =
        CheckConsistencyRequest.newBuilder()
            .setName(TABLE_NAME.toString())
            .setConsistencyToken("fake-token")
            .build();

    CheckConsistencyResponse expectedResponse2 =
        CheckConsistencyResponse.newBuilder().setConsistent(false).build();

    CheckConsistencyResponse expectedResponse3 =
        CheckConsistencyResponse.newBuilder().setConsistent(true).build();

    Mockito.when(mockCheckConsistencyCallable.futureCall(expectedRequest2, CALL_CONTEXT))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse2))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse3));

    ApiFuture<Void> consistentFuture = callable.futureCall(TABLE_NAME, CALL_CONTEXT);

    consistentFuture.get(1, TimeUnit.SECONDS);
  }

  @Test
  public void testPollingTimeout() throws Exception {
    GenerateConsistencyTokenRequest expectedRequest =
        GenerateConsistencyTokenRequest.newBuilder().setName(TABLE_NAME.toString()).build();

    GenerateConsistencyTokenResponse expectedResponse =
        GenerateConsistencyTokenResponse.newBuilder().setConsistencyToken("fake-token").build();

    Mockito.when(mockGenerateConsistencyTokenCallable.futureCall(expectedRequest, CALL_CONTEXT))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse));

    CheckConsistencyRequest expectedRequest2 =
        CheckConsistencyRequest.newBuilder()
            .setName(TABLE_NAME.toString())
            .setConsistencyToken("fake-token")
            .build();

    CheckConsistencyResponse expectedResponse2 =
        CheckConsistencyResponse.newBuilder().setConsistent(false).build();

    Mockito.when(mockCheckConsistencyCallable.futureCall(expectedRequest2, CALL_CONTEXT))
        .thenReturn(ApiFutures.immediateFuture(expectedResponse2));

    ApiFuture<Void> consistentFuture = callable.futureCall(TABLE_NAME, CALL_CONTEXT);

    Throwable actualError = null;
    try {
      consistentFuture.get(1, TimeUnit.SECONDS);
    } catch (ExecutionException e) {
      actualError = e.getCause();
    }

    assertThat(actualError).isInstanceOf(PollException.class);
  }
}
