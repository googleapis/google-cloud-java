/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.executor.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.spanner.executor.v1.SpannerAction;
import com.google.spanner.executor.v1.SpannerActionOutcome;
import com.google.spanner.executor.v1.SpannerAsyncActionRequest;
import com.google.spanner.executor.v1.SpannerAsyncActionResponse;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class SpannerExecutorProxyClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockSpannerExecutorProxy mockSpannerExecutorProxy;
  private LocalChannelProvider channelProvider;
  private SpannerExecutorProxyClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSpannerExecutorProxy = new MockSpannerExecutorProxy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockSpannerExecutorProxy));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    SpannerExecutorProxySettings settings =
        SpannerExecutorProxySettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SpannerExecutorProxyClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void executeActionAsyncTest() throws Exception {
    SpannerAsyncActionResponse expectedResponse =
        SpannerAsyncActionResponse.newBuilder()
            .setActionId(198295492)
            .setOutcome(SpannerActionOutcome.newBuilder().build())
            .build();
    mockSpannerExecutorProxy.addResponse(expectedResponse);
    SpannerAsyncActionRequest request =
        SpannerAsyncActionRequest.newBuilder()
            .setActionId(198295492)
            .setAction(SpannerAction.newBuilder().build())
            .build();

    MockStreamObserver<SpannerAsyncActionResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<SpannerAsyncActionRequest, SpannerAsyncActionResponse> callable =
        client.executeActionAsyncCallable();
    ApiStreamObserver<SpannerAsyncActionRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<SpannerAsyncActionResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void executeActionAsyncExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSpannerExecutorProxy.addException(exception);
    SpannerAsyncActionRequest request =
        SpannerAsyncActionRequest.newBuilder()
            .setActionId(198295492)
            .setAction(SpannerAction.newBuilder().build())
            .build();

    MockStreamObserver<SpannerAsyncActionResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<SpannerAsyncActionRequest, SpannerAsyncActionResponse> callable =
        client.executeActionAsyncCallable();
    ApiStreamObserver<SpannerAsyncActionRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<SpannerAsyncActionResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
