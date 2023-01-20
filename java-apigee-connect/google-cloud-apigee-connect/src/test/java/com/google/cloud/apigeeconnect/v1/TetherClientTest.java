/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.apigeeconnect.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.protobuf.Duration;
import com.google.rpc.Status;
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
public class TetherClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockTether mockTether;
  private LocalChannelProvider channelProvider;
  private TetherClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockTether = new MockTether();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockTether));
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
    TetherSettings settings =
        TetherSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TetherClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void egressTest() throws Exception {
    EgressRequest expectedResponse =
        EgressRequest.newBuilder()
            .setId("id3355")
            .setPayload(Payload.newBuilder().build())
            .setEndpoint(TetherEndpoint.forNumber(0))
            .setProject("project-309310695")
            .setTraceId("traceId-1067401920")
            .setTimeout(Duration.newBuilder().build())
            .build();
    mockTether.addResponse(expectedResponse);
    EgressResponse request =
        EgressResponse.newBuilder()
            .setId("id3355")
            .setHttpResponse(HttpResponse.newBuilder().build())
            .setStatus(Status.newBuilder().build())
            .setProject("project-309310695")
            .setTraceId("traceId-1067401920")
            .setEndpoint(TetherEndpoint.forNumber(0))
            .setName("name3373707")
            .build();

    MockStreamObserver<EgressRequest> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<EgressResponse, EgressRequest> callable = client.egressCallable();
    ApiStreamObserver<EgressResponse> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<EgressRequest> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void egressExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTether.addException(exception);
    EgressResponse request =
        EgressResponse.newBuilder()
            .setId("id3355")
            .setHttpResponse(HttpResponse.newBuilder().build())
            .setStatus(Status.newBuilder().build())
            .setProject("project-309310695")
            .setTraceId("traceId-1067401920")
            .setEndpoint(TetherEndpoint.forNumber(0))
            .setName("name3373707")
            .build();

    MockStreamObserver<EgressRequest> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<EgressResponse, EgressRequest> callable = client.egressCallable();
    ApiStreamObserver<EgressResponse> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<EgressRequest> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
