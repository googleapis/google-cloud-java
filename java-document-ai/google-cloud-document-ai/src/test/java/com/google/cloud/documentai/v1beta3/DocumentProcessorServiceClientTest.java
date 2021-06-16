/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.documentai.v1beta3;

import static com.google.cloud.documentai.v1beta3.DocumentProcessorServiceClient.ListProcessorsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
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
public class DocumentProcessorServiceClientTest {
  private static MockDocumentProcessorService mockDocumentProcessorService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DocumentProcessorServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDocumentProcessorService = new MockDocumentProcessorService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDocumentProcessorService));
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
    DocumentProcessorServiceSettings settings =
        DocumentProcessorServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DocumentProcessorServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void processDocumentTest() throws Exception {
    ProcessResponse expectedResponse =
        ProcessResponse.newBuilder()
            .setDocument(Document.newBuilder().build())
            .setHumanReviewOperation("humanReviewOperation1807415298")
            .setHumanReviewStatus(HumanReviewStatus.newBuilder().build())
            .build();
    mockDocumentProcessorService.addResponse(expectedResponse);

    ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");

    ProcessResponse actualResponse = client.processDocument(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ProcessRequest actualRequest = ((ProcessRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void processDocumentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
      client.processDocument(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void processDocumentTest2() throws Exception {
    ProcessResponse expectedResponse =
        ProcessResponse.newBuilder()
            .setDocument(Document.newBuilder().build())
            .setHumanReviewOperation("humanReviewOperation1807415298")
            .setHumanReviewStatus(HumanReviewStatus.newBuilder().build())
            .build();
    mockDocumentProcessorService.addResponse(expectedResponse);

    String name = "name3373707";

    ProcessResponse actualResponse = client.processDocument(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ProcessRequest actualRequest = ((ProcessRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void processDocumentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      String name = "name3373707";
      client.processDocument(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchProcessDocumentsTest() throws Exception {
    BatchProcessResponse expectedResponse = BatchProcessResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchProcessDocumentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocumentProcessorService.addResponse(resultOperation);

    ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");

    BatchProcessResponse actualResponse = client.batchProcessDocumentsAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchProcessRequest actualRequest = ((BatchProcessRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchProcessDocumentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
      client.batchProcessDocumentsAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void batchProcessDocumentsTest2() throws Exception {
    BatchProcessResponse expectedResponse = BatchProcessResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("batchProcessDocumentsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocumentProcessorService.addResponse(resultOperation);

    String name = "name3373707";

    BatchProcessResponse actualResponse = client.batchProcessDocumentsAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchProcessRequest actualRequest = ((BatchProcessRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchProcessDocumentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      String name = "name3373707";
      client.batchProcessDocumentsAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void fetchProcessorTypesTest() throws Exception {
    FetchProcessorTypesResponse expectedResponse =
        FetchProcessorTypesResponse.newBuilder()
            .addAllProcessorTypes(new ArrayList<ProcessorType>())
            .build();
    mockDocumentProcessorService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    FetchProcessorTypesResponse actualResponse = client.fetchProcessorTypes(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchProcessorTypesRequest actualRequest = ((FetchProcessorTypesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchProcessorTypesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.fetchProcessorTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchProcessorTypesTest2() throws Exception {
    FetchProcessorTypesResponse expectedResponse =
        FetchProcessorTypesResponse.newBuilder()
            .addAllProcessorTypes(new ArrayList<ProcessorType>())
            .build();
    mockDocumentProcessorService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    FetchProcessorTypesResponse actualResponse = client.fetchProcessorTypes(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchProcessorTypesRequest actualRequest = ((FetchProcessorTypesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchProcessorTypesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.fetchProcessorTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProcessorsTest() throws Exception {
    Processor responsesElement = Processor.newBuilder().build();
    ListProcessorsResponse expectedResponse =
        ListProcessorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllProcessors(Arrays.asList(responsesElement))
            .build();
    mockDocumentProcessorService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListProcessorsPagedResponse pagedListResponse = client.listProcessors(parent);

    List<Processor> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProcessorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProcessorsRequest actualRequest = ((ListProcessorsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProcessorsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listProcessors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProcessorsTest2() throws Exception {
    Processor responsesElement = Processor.newBuilder().build();
    ListProcessorsResponse expectedResponse =
        ListProcessorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllProcessors(Arrays.asList(responsesElement))
            .build();
    mockDocumentProcessorService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListProcessorsPagedResponse pagedListResponse = client.listProcessors(parent);

    List<Processor> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProcessorsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProcessorsRequest actualRequest = ((ListProcessorsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProcessorsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listProcessors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createProcessorTest() throws Exception {
    Processor expectedResponse =
        Processor.newBuilder()
            .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
            .setType("type3575610")
            .setDisplayName("displayName1714148973")
            .setDefaultProcessorVersion("defaultProcessorVersion-1428555705")
            .setProcessEndpoint("processEndpoint-891502300")
            .setCreateTime(Timestamp.newBuilder().build())
            .setKmsKeyName("kmsKeyName412586233")
            .build();
    mockDocumentProcessorService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Processor processor = Processor.newBuilder().build();

    Processor actualResponse = client.createProcessor(parent, processor);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateProcessorRequest actualRequest = ((CreateProcessorRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(processor, actualRequest.getProcessor());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createProcessorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Processor processor = Processor.newBuilder().build();
      client.createProcessor(parent, processor);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createProcessorTest2() throws Exception {
    Processor expectedResponse =
        Processor.newBuilder()
            .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
            .setType("type3575610")
            .setDisplayName("displayName1714148973")
            .setDefaultProcessorVersion("defaultProcessorVersion-1428555705")
            .setProcessEndpoint("processEndpoint-891502300")
            .setCreateTime(Timestamp.newBuilder().build())
            .setKmsKeyName("kmsKeyName412586233")
            .build();
    mockDocumentProcessorService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Processor processor = Processor.newBuilder().build();

    Processor actualResponse = client.createProcessor(parent, processor);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateProcessorRequest actualRequest = ((CreateProcessorRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(processor, actualRequest.getProcessor());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createProcessorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      String parent = "parent-995424086";
      Processor processor = Processor.newBuilder().build();
      client.createProcessor(parent, processor);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteProcessorTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteProcessorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocumentProcessorService.addResponse(resultOperation);

    ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");

    client.deleteProcessorAsync(name).get();

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteProcessorRequest actualRequest = ((DeleteProcessorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteProcessorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
      client.deleteProcessorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteProcessorTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteProcessorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocumentProcessorService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteProcessorAsync(name).get();

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteProcessorRequest actualRequest = ((DeleteProcessorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteProcessorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteProcessorAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void enableProcessorTest() throws Exception {
    EnableProcessorResponse expectedResponse = EnableProcessorResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("enableProcessorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocumentProcessorService.addResponse(resultOperation);

    EnableProcessorRequest request =
        EnableProcessorRequest.newBuilder()
            .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
            .build();

    EnableProcessorResponse actualResponse = client.enableProcessorAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    EnableProcessorRequest actualRequest = ((EnableProcessorRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void enableProcessorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      EnableProcessorRequest request =
          EnableProcessorRequest.newBuilder()
              .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
              .build();
      client.enableProcessorAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void disableProcessorTest() throws Exception {
    DisableProcessorResponse expectedResponse = DisableProcessorResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("disableProcessorTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocumentProcessorService.addResponse(resultOperation);

    DisableProcessorRequest request =
        DisableProcessorRequest.newBuilder()
            .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
            .build();

    DisableProcessorResponse actualResponse = client.disableProcessorAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DisableProcessorRequest actualRequest = ((DisableProcessorRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void disableProcessorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      DisableProcessorRequest request =
          DisableProcessorRequest.newBuilder()
              .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
              .build();
      client.disableProcessorAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void reviewDocumentTest() throws Exception {
    ReviewDocumentResponse expectedResponse =
        ReviewDocumentResponse.newBuilder().setGcsDestination("gcsDestination-1612392329").build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("reviewDocumentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocumentProcessorService.addResponse(resultOperation);

    HumanReviewConfigName humanReviewConfig =
        HumanReviewConfigName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");

    ReviewDocumentResponse actualResponse = client.reviewDocumentAsync(humanReviewConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReviewDocumentRequest actualRequest = ((ReviewDocumentRequest) actualRequests.get(0));

    Assert.assertEquals(humanReviewConfig.toString(), actualRequest.getHumanReviewConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reviewDocumentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      HumanReviewConfigName humanReviewConfig =
          HumanReviewConfigName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
      client.reviewDocumentAsync(humanReviewConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void reviewDocumentTest2() throws Exception {
    ReviewDocumentResponse expectedResponse =
        ReviewDocumentResponse.newBuilder().setGcsDestination("gcsDestination-1612392329").build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("reviewDocumentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocumentProcessorService.addResponse(resultOperation);

    String humanReviewConfig = "humanReviewConfig-620962169";

    ReviewDocumentResponse actualResponse = client.reviewDocumentAsync(humanReviewConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReviewDocumentRequest actualRequest = ((ReviewDocumentRequest) actualRequests.get(0));

    Assert.assertEquals(humanReviewConfig, actualRequest.getHumanReviewConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reviewDocumentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      String humanReviewConfig = "humanReviewConfig-620962169";
      client.reviewDocumentAsync(humanReviewConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
