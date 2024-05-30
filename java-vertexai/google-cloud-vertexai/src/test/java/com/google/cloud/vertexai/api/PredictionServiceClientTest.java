/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.vertexai.api;

import static com.google.cloud.vertexai.api.PredictionServiceClient.ListLocationsPagedResponse;

import com.google.api.HttpBody;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Value;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class PredictionServiceClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockPredictionService mockPredictionService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private PredictionServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockPredictionService = new MockPredictionService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockPredictionService, mockLocations, mockIAMPolicy));
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
    PredictionServiceSettings settings =
        PredictionServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PredictionServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void predictTest() throws Exception {
    PredictResponse expectedResponse =
        PredictResponse.newBuilder()
            .addAllPredictions(new ArrayList<Value>())
            .setDeployedModelId("deployedModelId-1817547906")
            .setModel("model104069929")
            .setModelVersionId("modelVersionId-2006125846")
            .setModelDisplayName("modelDisplayName1578770308")
            .setMetadata(Value.newBuilder().setBoolValue(true).build())
            .build();
    mockPredictionService.addResponse(expectedResponse);

    EndpointName endpoint =
        EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
    List<Value> instances = new ArrayList<>();
    Value parameters = Value.newBuilder().setBoolValue(true).build();

    PredictResponse actualResponse = client.predict(endpoint, instances, parameters);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPredictionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PredictRequest actualRequest = ((PredictRequest) actualRequests.get(0));

    Assert.assertEquals(endpoint.toString(), actualRequest.getEndpoint());
    Assert.assertEquals(instances, actualRequest.getInstancesList());
    Assert.assertEquals(parameters, actualRequest.getParameters());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void predictExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPredictionService.addException(exception);

    try {
      EndpointName endpoint =
          EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
      List<Value> instances = new ArrayList<>();
      Value parameters = Value.newBuilder().setBoolValue(true).build();
      client.predict(endpoint, instances, parameters);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void predictTest2() throws Exception {
    PredictResponse expectedResponse =
        PredictResponse.newBuilder()
            .addAllPredictions(new ArrayList<Value>())
            .setDeployedModelId("deployedModelId-1817547906")
            .setModel("model104069929")
            .setModelVersionId("modelVersionId-2006125846")
            .setModelDisplayName("modelDisplayName1578770308")
            .setMetadata(Value.newBuilder().setBoolValue(true).build())
            .build();
    mockPredictionService.addResponse(expectedResponse);

    String endpoint = "endpoint1741102485";
    List<Value> instances = new ArrayList<>();
    Value parameters = Value.newBuilder().setBoolValue(true).build();

    PredictResponse actualResponse = client.predict(endpoint, instances, parameters);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPredictionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PredictRequest actualRequest = ((PredictRequest) actualRequests.get(0));

    Assert.assertEquals(endpoint, actualRequest.getEndpoint());
    Assert.assertEquals(instances, actualRequest.getInstancesList());
    Assert.assertEquals(parameters, actualRequest.getParameters());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void predictExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPredictionService.addException(exception);

    try {
      String endpoint = "endpoint1741102485";
      List<Value> instances = new ArrayList<>();
      Value parameters = Value.newBuilder().setBoolValue(true).build();
      client.predict(endpoint, instances, parameters);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rawPredictTest() throws Exception {
    HttpBody expectedResponse =
        HttpBody.newBuilder()
            .setContentType("contentType-389131437")
            .setData(ByteString.EMPTY)
            .addAllExtensions(new ArrayList<Any>())
            .build();
    mockPredictionService.addResponse(expectedResponse);

    EndpointName endpoint =
        EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
    HttpBody httpBody = HttpBody.newBuilder().build();

    HttpBody actualResponse = client.rawPredict(endpoint, httpBody);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPredictionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RawPredictRequest actualRequest = ((RawPredictRequest) actualRequests.get(0));

    Assert.assertEquals(endpoint.toString(), actualRequest.getEndpoint());
    Assert.assertEquals(httpBody, actualRequest.getHttpBody());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rawPredictExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPredictionService.addException(exception);

    try {
      EndpointName endpoint =
          EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
      HttpBody httpBody = HttpBody.newBuilder().build();
      client.rawPredict(endpoint, httpBody);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rawPredictTest2() throws Exception {
    HttpBody expectedResponse =
        HttpBody.newBuilder()
            .setContentType("contentType-389131437")
            .setData(ByteString.EMPTY)
            .addAllExtensions(new ArrayList<Any>())
            .build();
    mockPredictionService.addResponse(expectedResponse);

    String endpoint = "endpoint1741102485";
    HttpBody httpBody = HttpBody.newBuilder().build();

    HttpBody actualResponse = client.rawPredict(endpoint, httpBody);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPredictionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RawPredictRequest actualRequest = ((RawPredictRequest) actualRequests.get(0));

    Assert.assertEquals(endpoint, actualRequest.getEndpoint());
    Assert.assertEquals(httpBody, actualRequest.getHttpBody());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rawPredictExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPredictionService.addException(exception);

    try {
      String endpoint = "endpoint1741102485";
      HttpBody httpBody = HttpBody.newBuilder().build();
      client.rawPredict(endpoint, httpBody);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void streamRawPredictTest() throws Exception {
    HttpBody expectedResponse =
        HttpBody.newBuilder()
            .setContentType("contentType-389131437")
            .setData(ByteString.EMPTY)
            .addAllExtensions(new ArrayList<Any>())
            .build();
    mockPredictionService.addResponse(expectedResponse);
    StreamRawPredictRequest request =
        StreamRawPredictRequest.newBuilder()
            .setEndpoint(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .setHttpBody(HttpBody.newBuilder().build())
            .build();

    MockStreamObserver<HttpBody> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<StreamRawPredictRequest, HttpBody> callable =
        client.streamRawPredictCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<HttpBody> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void streamRawPredictExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPredictionService.addException(exception);
    StreamRawPredictRequest request =
        StreamRawPredictRequest.newBuilder()
            .setEndpoint(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .setHttpBody(HttpBody.newBuilder().build())
            .build();

    MockStreamObserver<HttpBody> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<StreamRawPredictRequest, HttpBody> callable =
        client.streamRawPredictCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<HttpBody> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void directPredictTest() throws Exception {
    DirectPredictResponse expectedResponse =
        DirectPredictResponse.newBuilder()
            .addAllOutputs(new ArrayList<Tensor>())
            .setParameters(Tensor.newBuilder().build())
            .build();
    mockPredictionService.addResponse(expectedResponse);

    DirectPredictRequest request =
        DirectPredictRequest.newBuilder()
            .setEndpoint(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .addAllInputs(new ArrayList<Tensor>())
            .setParameters(Tensor.newBuilder().build())
            .build();

    DirectPredictResponse actualResponse = client.directPredict(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPredictionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DirectPredictRequest actualRequest = ((DirectPredictRequest) actualRequests.get(0));

    Assert.assertEquals(request.getEndpoint(), actualRequest.getEndpoint());
    Assert.assertEquals(request.getInputsList(), actualRequest.getInputsList());
    Assert.assertEquals(request.getParameters(), actualRequest.getParameters());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void directPredictExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPredictionService.addException(exception);

    try {
      DirectPredictRequest request =
          DirectPredictRequest.newBuilder()
              .setEndpoint(
                  EndpointName.ofProjectLocationEndpointName(
                          "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                      .toString())
              .addAllInputs(new ArrayList<Tensor>())
              .setParameters(Tensor.newBuilder().build())
              .build();
      client.directPredict(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void directRawPredictTest() throws Exception {
    DirectRawPredictResponse expectedResponse =
        DirectRawPredictResponse.newBuilder().setOutput(ByteString.EMPTY).build();
    mockPredictionService.addResponse(expectedResponse);

    DirectRawPredictRequest request =
        DirectRawPredictRequest.newBuilder()
            .setEndpoint(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .setMethodName("methodName-723163380")
            .setInput(ByteString.EMPTY)
            .build();

    DirectRawPredictResponse actualResponse = client.directRawPredict(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPredictionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DirectRawPredictRequest actualRequest = ((DirectRawPredictRequest) actualRequests.get(0));

    Assert.assertEquals(request.getEndpoint(), actualRequest.getEndpoint());
    Assert.assertEquals(request.getMethodName(), actualRequest.getMethodName());
    Assert.assertEquals(request.getInput(), actualRequest.getInput());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void directRawPredictExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPredictionService.addException(exception);

    try {
      DirectRawPredictRequest request =
          DirectRawPredictRequest.newBuilder()
              .setEndpoint(
                  EndpointName.ofProjectLocationEndpointName(
                          "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                      .toString())
              .setMethodName("methodName-723163380")
              .setInput(ByteString.EMPTY)
              .build();
      client.directRawPredict(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void streamDirectPredictTest() throws Exception {
    StreamDirectPredictResponse expectedResponse =
        StreamDirectPredictResponse.newBuilder()
            .addAllOutputs(new ArrayList<Tensor>())
            .setParameters(Tensor.newBuilder().build())
            .build();
    mockPredictionService.addResponse(expectedResponse);
    StreamDirectPredictRequest request =
        StreamDirectPredictRequest.newBuilder()
            .setEndpoint(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .addAllInputs(new ArrayList<Tensor>())
            .setParameters(Tensor.newBuilder().build())
            .build();

    MockStreamObserver<StreamDirectPredictResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<StreamDirectPredictRequest, StreamDirectPredictResponse> callable =
        client.streamDirectPredictCallable();
    ApiStreamObserver<StreamDirectPredictRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<StreamDirectPredictResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void streamDirectPredictExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPredictionService.addException(exception);
    StreamDirectPredictRequest request =
        StreamDirectPredictRequest.newBuilder()
            .setEndpoint(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .addAllInputs(new ArrayList<Tensor>())
            .setParameters(Tensor.newBuilder().build())
            .build();

    MockStreamObserver<StreamDirectPredictResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<StreamDirectPredictRequest, StreamDirectPredictResponse> callable =
        client.streamDirectPredictCallable();
    ApiStreamObserver<StreamDirectPredictRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<StreamDirectPredictResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void streamDirectRawPredictTest() throws Exception {
    StreamDirectRawPredictResponse expectedResponse =
        StreamDirectRawPredictResponse.newBuilder().setOutput(ByteString.EMPTY).build();
    mockPredictionService.addResponse(expectedResponse);
    StreamDirectRawPredictRequest request =
        StreamDirectRawPredictRequest.newBuilder()
            .setEndpoint(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .setMethodName("methodName-723163380")
            .setInput(ByteString.EMPTY)
            .build();

    MockStreamObserver<StreamDirectRawPredictResponse> responseObserver =
        new MockStreamObserver<>();

    BidiStreamingCallable<StreamDirectRawPredictRequest, StreamDirectRawPredictResponse> callable =
        client.streamDirectRawPredictCallable();
    ApiStreamObserver<StreamDirectRawPredictRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<StreamDirectRawPredictResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void streamDirectRawPredictExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPredictionService.addException(exception);
    StreamDirectRawPredictRequest request =
        StreamDirectRawPredictRequest.newBuilder()
            .setEndpoint(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .setMethodName("methodName-723163380")
            .setInput(ByteString.EMPTY)
            .build();

    MockStreamObserver<StreamDirectRawPredictResponse> responseObserver =
        new MockStreamObserver<>();

    BidiStreamingCallable<StreamDirectRawPredictRequest, StreamDirectRawPredictResponse> callable =
        client.streamDirectRawPredictCallable();
    ApiStreamObserver<StreamDirectRawPredictRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<StreamDirectRawPredictResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void streamingPredictTest() throws Exception {
    StreamingPredictResponse expectedResponse =
        StreamingPredictResponse.newBuilder()
            .addAllOutputs(new ArrayList<Tensor>())
            .setParameters(Tensor.newBuilder().build())
            .build();
    mockPredictionService.addResponse(expectedResponse);
    StreamingPredictRequest request =
        StreamingPredictRequest.newBuilder()
            .setEndpoint(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .addAllInputs(new ArrayList<Tensor>())
            .setParameters(Tensor.newBuilder().build())
            .build();

    MockStreamObserver<StreamingPredictResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<StreamingPredictRequest, StreamingPredictResponse> callable =
        client.streamingPredictCallable();
    ApiStreamObserver<StreamingPredictRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<StreamingPredictResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void streamingPredictExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPredictionService.addException(exception);
    StreamingPredictRequest request =
        StreamingPredictRequest.newBuilder()
            .setEndpoint(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .addAllInputs(new ArrayList<Tensor>())
            .setParameters(Tensor.newBuilder().build())
            .build();

    MockStreamObserver<StreamingPredictResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<StreamingPredictRequest, StreamingPredictResponse> callable =
        client.streamingPredictCallable();
    ApiStreamObserver<StreamingPredictRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<StreamingPredictResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void serverStreamingPredictTest() throws Exception {
    StreamingPredictResponse expectedResponse =
        StreamingPredictResponse.newBuilder()
            .addAllOutputs(new ArrayList<Tensor>())
            .setParameters(Tensor.newBuilder().build())
            .build();
    mockPredictionService.addResponse(expectedResponse);
    StreamingPredictRequest request =
        StreamingPredictRequest.newBuilder()
            .setEndpoint(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .addAllInputs(new ArrayList<Tensor>())
            .setParameters(Tensor.newBuilder().build())
            .build();

    MockStreamObserver<StreamingPredictResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<StreamingPredictRequest, StreamingPredictResponse> callable =
        client.serverStreamingPredictCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<StreamingPredictResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void serverStreamingPredictExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPredictionService.addException(exception);
    StreamingPredictRequest request =
        StreamingPredictRequest.newBuilder()
            .setEndpoint(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .addAllInputs(new ArrayList<Tensor>())
            .setParameters(Tensor.newBuilder().build())
            .build();

    MockStreamObserver<StreamingPredictResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<StreamingPredictRequest, StreamingPredictResponse> callable =
        client.serverStreamingPredictCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<StreamingPredictResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void streamingRawPredictTest() throws Exception {
    StreamingRawPredictResponse expectedResponse =
        StreamingRawPredictResponse.newBuilder().setOutput(ByteString.EMPTY).build();
    mockPredictionService.addResponse(expectedResponse);
    StreamingRawPredictRequest request =
        StreamingRawPredictRequest.newBuilder()
            .setEndpoint(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .setMethodName("methodName-723163380")
            .setInput(ByteString.EMPTY)
            .build();

    MockStreamObserver<StreamingRawPredictResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<StreamingRawPredictRequest, StreamingRawPredictResponse> callable =
        client.streamingRawPredictCallable();
    ApiStreamObserver<StreamingRawPredictRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<StreamingRawPredictResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void streamingRawPredictExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPredictionService.addException(exception);
    StreamingRawPredictRequest request =
        StreamingRawPredictRequest.newBuilder()
            .setEndpoint(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .setMethodName("methodName-723163380")
            .setInput(ByteString.EMPTY)
            .build();

    MockStreamObserver<StreamingRawPredictResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<StreamingRawPredictRequest, StreamingRawPredictResponse> callable =
        client.streamingRawPredictCallable();
    ApiStreamObserver<StreamingRawPredictRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<StreamingRawPredictResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void explainTest() throws Exception {
    ExplainResponse expectedResponse =
        ExplainResponse.newBuilder()
            .addAllExplanations(new ArrayList<Explanation>())
            .setDeployedModelId("deployedModelId-1817547906")
            .addAllPredictions(new ArrayList<Value>())
            .build();
    mockPredictionService.addResponse(expectedResponse);

    EndpointName endpoint =
        EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
    List<Value> instances = new ArrayList<>();
    Value parameters = Value.newBuilder().setBoolValue(true).build();
    String deployedModelId = "deployedModelId-1817547906";

    ExplainResponse actualResponse =
        client.explain(endpoint, instances, parameters, deployedModelId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPredictionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExplainRequest actualRequest = ((ExplainRequest) actualRequests.get(0));

    Assert.assertEquals(endpoint.toString(), actualRequest.getEndpoint());
    Assert.assertEquals(instances, actualRequest.getInstancesList());
    Assert.assertEquals(parameters, actualRequest.getParameters());
    Assert.assertEquals(deployedModelId, actualRequest.getDeployedModelId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void explainExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPredictionService.addException(exception);

    try {
      EndpointName endpoint =
          EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
      List<Value> instances = new ArrayList<>();
      Value parameters = Value.newBuilder().setBoolValue(true).build();
      String deployedModelId = "deployedModelId-1817547906";
      client.explain(endpoint, instances, parameters, deployedModelId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void explainTest2() throws Exception {
    ExplainResponse expectedResponse =
        ExplainResponse.newBuilder()
            .addAllExplanations(new ArrayList<Explanation>())
            .setDeployedModelId("deployedModelId-1817547906")
            .addAllPredictions(new ArrayList<Value>())
            .build();
    mockPredictionService.addResponse(expectedResponse);

    String endpoint = "endpoint1741102485";
    List<Value> instances = new ArrayList<>();
    Value parameters = Value.newBuilder().setBoolValue(true).build();
    String deployedModelId = "deployedModelId-1817547906";

    ExplainResponse actualResponse =
        client.explain(endpoint, instances, parameters, deployedModelId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPredictionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExplainRequest actualRequest = ((ExplainRequest) actualRequests.get(0));

    Assert.assertEquals(endpoint, actualRequest.getEndpoint());
    Assert.assertEquals(instances, actualRequest.getInstancesList());
    Assert.assertEquals(parameters, actualRequest.getParameters());
    Assert.assertEquals(deployedModelId, actualRequest.getDeployedModelId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void explainExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPredictionService.addException(exception);

    try {
      String endpoint = "endpoint1741102485";
      List<Value> instances = new ArrayList<>();
      Value parameters = Value.newBuilder().setBoolValue(true).build();
      String deployedModelId = "deployedModelId-1817547906";
      client.explain(endpoint, instances, parameters, deployedModelId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateContentTest() throws Exception {
    GenerateContentResponse expectedResponse =
        GenerateContentResponse.newBuilder()
            .addAllCandidates(new ArrayList<Candidate>())
            .setPromptFeedback(GenerateContentResponse.PromptFeedback.newBuilder().build())
            .setUsageMetadata(GenerateContentResponse.UsageMetadata.newBuilder().build())
            .build();
    mockPredictionService.addResponse(expectedResponse);

    String model = "model104069929";
    List<Content> contents = new ArrayList<>();

    GenerateContentResponse actualResponse = client.generateContent(model, contents);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockPredictionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateContentRequest actualRequest = ((GenerateContentRequest) actualRequests.get(0));

    Assert.assertEquals(model, actualRequest.getModel());
    Assert.assertEquals(contents, actualRequest.getContentsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateContentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPredictionService.addException(exception);

    try {
      String model = "model104069929";
      List<Content> contents = new ArrayList<>();
      client.generateContent(model, contents);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void streamGenerateContentTest() throws Exception {
    GenerateContentResponse expectedResponse =
        GenerateContentResponse.newBuilder()
            .addAllCandidates(new ArrayList<Candidate>())
            .setPromptFeedback(GenerateContentResponse.PromptFeedback.newBuilder().build())
            .setUsageMetadata(GenerateContentResponse.UsageMetadata.newBuilder().build())
            .build();
    mockPredictionService.addResponse(expectedResponse);
    GenerateContentRequest request =
        GenerateContentRequest.newBuilder()
            .setModel("model104069929")
            .addAllContents(new ArrayList<Content>())
            .setSystemInstruction(Content.newBuilder().build())
            .addAllTools(new ArrayList<Tool>())
            .addAllSafetySettings(new ArrayList<SafetySetting>())
            .setGenerationConfig(GenerationConfig.newBuilder().build())
            .build();

    MockStreamObserver<GenerateContentResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<GenerateContentRequest, GenerateContentResponse> callable =
        client.streamGenerateContentCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<GenerateContentResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void streamGenerateContentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockPredictionService.addException(exception);
    GenerateContentRequest request =
        GenerateContentRequest.newBuilder()
            .setModel("model104069929")
            .addAllContents(new ArrayList<Content>())
            .setSystemInstruction(Content.newBuilder().build())
            .addAllTools(new ArrayList<Tool>())
            .addAllSafetySettings(new ArrayList<SafetySetting>())
            .setGenerationConfig(GenerationConfig.newBuilder().build())
            .build();

    MockStreamObserver<GenerateContentResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<GenerateContentRequest, GenerateContentResponse> callable =
        client.streamGenerateContentCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<GenerateContentResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPolicy(), actualRequest.getPolicy());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(
                  EndpointName.ofProjectLocationEndpointName(
                          "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                      .toString())
              .setPolicy(Policy.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.setIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockIAMPolicy.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getOptions(), actualRequest.getOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(
                  EndpointName.ofProjectLocationEndpointName(
                          "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                      .toString())
              .setOptions(GetPolicyOptions.newBuilder().build())
              .build();
      client.getIamPolicy(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockIAMPolicy.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(
                EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                    .toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockIAMPolicy.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getResource(), actualRequest.getResource());
    Assert.assertEquals(request.getPermissionsList(), actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockIAMPolicy.addException(exception);

    try {
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(
                  EndpointName.ofProjectLocationEndpointName(
                          "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
                      .toString())
              .addAllPermissions(new ArrayList<String>())
              .build();
      client.testIamPermissions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
