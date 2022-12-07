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

package com.google.cloud.documentai.v1;

import static com.google.cloud.documentai.v1.DocumentProcessorServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.documentai.v1.DocumentProcessorServiceClient.ListProcessorTypesPagedResponse;
import static com.google.cloud.documentai.v1.DocumentProcessorServiceClient.ListProcessorVersionsPagedResponse;
import static com.google.cloud.documentai.v1.DocumentProcessorServiceClient.ListProcessorsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
public class DocumentProcessorServiceClientTest {
  private static MockDocumentProcessorService mockDocumentProcessorService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DocumentProcessorServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDocumentProcessorService = new MockDocumentProcessorService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDocumentProcessorService, mockLocations));
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
            .setHumanReviewStatus(HumanReviewStatus.newBuilder().build())
            .build();
    mockDocumentProcessorService.addResponse(expectedResponse);

    ResourceName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");

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
      ResourceName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
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

    ResourceName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");

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
      ResourceName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
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
  public void listProcessorTypesTest() throws Exception {
    ProcessorType responsesElement = ProcessorType.newBuilder().build();
    ListProcessorTypesResponse expectedResponse =
        ListProcessorTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllProcessorTypes(Arrays.asList(responsesElement))
            .build();
    mockDocumentProcessorService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListProcessorTypesPagedResponse pagedListResponse = client.listProcessorTypes(parent);

    List<ProcessorType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProcessorTypesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProcessorTypesRequest actualRequest = ((ListProcessorTypesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProcessorTypesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listProcessorTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProcessorTypesTest2() throws Exception {
    ProcessorType responsesElement = ProcessorType.newBuilder().build();
    ListProcessorTypesResponse expectedResponse =
        ListProcessorTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllProcessorTypes(Arrays.asList(responsesElement))
            .build();
    mockDocumentProcessorService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListProcessorTypesPagedResponse pagedListResponse = client.listProcessorTypes(parent);

    List<ProcessorType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProcessorTypesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProcessorTypesRequest actualRequest = ((ListProcessorTypesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProcessorTypesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listProcessorTypes(parent);
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
  public void getProcessorTest() throws Exception {
    Processor expectedResponse =
        Processor.newBuilder()
            .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
            .setType("type3575610")
            .setDisplayName("displayName1714148973")
            .setDefaultProcessorVersion(
                ProcessorVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
                    .toString())
            .setProcessEndpoint("processEndpoint-891502300")
            .setCreateTime(Timestamp.newBuilder().build())
            .setKmsKeyName("kmsKeyName412586233")
            .build();
    mockDocumentProcessorService.addResponse(expectedResponse);

    ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");

    Processor actualResponse = client.getProcessor(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProcessorRequest actualRequest = ((GetProcessorRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProcessorExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      ProcessorName name = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
      client.getProcessor(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProcessorTest2() throws Exception {
    Processor expectedResponse =
        Processor.newBuilder()
            .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
            .setType("type3575610")
            .setDisplayName("displayName1714148973")
            .setDefaultProcessorVersion(
                ProcessorVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
                    .toString())
            .setProcessEndpoint("processEndpoint-891502300")
            .setCreateTime(Timestamp.newBuilder().build())
            .setKmsKeyName("kmsKeyName412586233")
            .build();
    mockDocumentProcessorService.addResponse(expectedResponse);

    String name = "name3373707";

    Processor actualResponse = client.getProcessor(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProcessorRequest actualRequest = ((GetProcessorRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProcessorExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      String name = "name3373707";
      client.getProcessor(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProcessorVersionTest() throws Exception {
    ProcessorVersion expectedResponse =
        ProcessorVersion.newBuilder()
            .setName(
                ProcessorVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDocumentSchema(DocumentSchema.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .setGoogleManaged(true)
            .setDeprecationInfo(ProcessorVersion.DeprecationInfo.newBuilder().build())
            .build();
    mockDocumentProcessorService.addResponse(expectedResponse);

    ProcessorVersionName name =
        ProcessorVersionName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]");

    ProcessorVersion actualResponse = client.getProcessorVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProcessorVersionRequest actualRequest = ((GetProcessorVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProcessorVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      ProcessorVersionName name =
          ProcessorVersionName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]");
      client.getProcessorVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProcessorVersionTest2() throws Exception {
    ProcessorVersion expectedResponse =
        ProcessorVersion.newBuilder()
            .setName(
                ProcessorVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDocumentSchema(DocumentSchema.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .setGoogleManaged(true)
            .setDeprecationInfo(ProcessorVersion.DeprecationInfo.newBuilder().build())
            .build();
    mockDocumentProcessorService.addResponse(expectedResponse);

    String name = "name3373707";

    ProcessorVersion actualResponse = client.getProcessorVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetProcessorVersionRequest actualRequest = ((GetProcessorVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getProcessorVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      String name = "name3373707";
      client.getProcessorVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProcessorVersionsTest() throws Exception {
    ProcessorVersion responsesElement = ProcessorVersion.newBuilder().build();
    ListProcessorVersionsResponse expectedResponse =
        ListProcessorVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllProcessorVersions(Arrays.asList(responsesElement))
            .build();
    mockDocumentProcessorService.addResponse(expectedResponse);

    ProcessorName parent = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");

    ListProcessorVersionsPagedResponse pagedListResponse = client.listProcessorVersions(parent);

    List<ProcessorVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProcessorVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProcessorVersionsRequest actualRequest =
        ((ListProcessorVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProcessorVersionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      ProcessorName parent = ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]");
      client.listProcessorVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listProcessorVersionsTest2() throws Exception {
    ProcessorVersion responsesElement = ProcessorVersion.newBuilder().build();
    ListProcessorVersionsResponse expectedResponse =
        ListProcessorVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllProcessorVersions(Arrays.asList(responsesElement))
            .build();
    mockDocumentProcessorService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListProcessorVersionsPagedResponse pagedListResponse = client.listProcessorVersions(parent);

    List<ProcessorVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getProcessorVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListProcessorVersionsRequest actualRequest =
        ((ListProcessorVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listProcessorVersionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listProcessorVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteProcessorVersionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteProcessorVersionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocumentProcessorService.addResponse(resultOperation);

    ProcessorVersionName name =
        ProcessorVersionName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]");

    client.deleteProcessorVersionAsync(name).get();

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteProcessorVersionRequest actualRequest =
        ((DeleteProcessorVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteProcessorVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      ProcessorVersionName name =
          ProcessorVersionName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]");
      client.deleteProcessorVersionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteProcessorVersionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteProcessorVersionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocumentProcessorService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteProcessorVersionAsync(name).get();

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteProcessorVersionRequest actualRequest =
        ((DeleteProcessorVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteProcessorVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteProcessorVersionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deployProcessorVersionTest() throws Exception {
    DeployProcessorVersionResponse expectedResponse =
        DeployProcessorVersionResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deployProcessorVersionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocumentProcessorService.addResponse(resultOperation);

    ProcessorVersionName name =
        ProcessorVersionName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]");

    DeployProcessorVersionResponse actualResponse = client.deployProcessorVersionAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeployProcessorVersionRequest actualRequest =
        ((DeployProcessorVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deployProcessorVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      ProcessorVersionName name =
          ProcessorVersionName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]");
      client.deployProcessorVersionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deployProcessorVersionTest2() throws Exception {
    DeployProcessorVersionResponse expectedResponse =
        DeployProcessorVersionResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deployProcessorVersionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocumentProcessorService.addResponse(resultOperation);

    String name = "name3373707";

    DeployProcessorVersionResponse actualResponse = client.deployProcessorVersionAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeployProcessorVersionRequest actualRequest =
        ((DeployProcessorVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deployProcessorVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      String name = "name3373707";
      client.deployProcessorVersionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void undeployProcessorVersionTest() throws Exception {
    UndeployProcessorVersionResponse expectedResponse =
        UndeployProcessorVersionResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeployProcessorVersionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocumentProcessorService.addResponse(resultOperation);

    ProcessorVersionName name =
        ProcessorVersionName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]");

    UndeployProcessorVersionResponse actualResponse =
        client.undeployProcessorVersionAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeployProcessorVersionRequest actualRequest =
        ((UndeployProcessorVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeployProcessorVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      ProcessorVersionName name =
          ProcessorVersionName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]");
      client.undeployProcessorVersionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void undeployProcessorVersionTest2() throws Exception {
    UndeployProcessorVersionResponse expectedResponse =
        UndeployProcessorVersionResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeployProcessorVersionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocumentProcessorService.addResponse(resultOperation);

    String name = "name3373707";

    UndeployProcessorVersionResponse actualResponse =
        client.undeployProcessorVersionAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeployProcessorVersionRequest actualRequest =
        ((UndeployProcessorVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeployProcessorVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      String name = "name3373707";
      client.undeployProcessorVersionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createProcessorTest() throws Exception {
    Processor expectedResponse =
        Processor.newBuilder()
            .setName(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
            .setType("type3575610")
            .setDisplayName("displayName1714148973")
            .setDefaultProcessorVersion(
                ProcessorVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
                    .toString())
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
            .setDefaultProcessorVersion(
                ProcessorVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
                    .toString())
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
  public void setDefaultProcessorVersionTest() throws Exception {
    SetDefaultProcessorVersionResponse expectedResponse =
        SetDefaultProcessorVersionResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("setDefaultProcessorVersionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDocumentProcessorService.addResponse(resultOperation);

    SetDefaultProcessorVersionRequest request =
        SetDefaultProcessorVersionRequest.newBuilder()
            .setProcessor(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
            .setDefaultProcessorVersion(
                ProcessorVersionName.of(
                        "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
                    .toString())
            .build();

    SetDefaultProcessorVersionResponse actualResponse =
        client.setDefaultProcessorVersionAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentProcessorService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetDefaultProcessorVersionRequest actualRequest =
        ((SetDefaultProcessorVersionRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProcessor(), actualRequest.getProcessor());
    Assert.assertEquals(
        request.getDefaultProcessorVersion(), actualRequest.getDefaultProcessorVersion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setDefaultProcessorVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentProcessorService.addException(exception);

    try {
      SetDefaultProcessorVersionRequest request =
          SetDefaultProcessorVersionRequest.newBuilder()
              .setProcessor(ProcessorName.of("[PROJECT]", "[LOCATION]", "[PROCESSOR]").toString())
              .setDefaultProcessorVersion(
                  ProcessorVersionName.of(
                          "[PROJECT]", "[LOCATION]", "[PROCESSOR]", "[PROCESSOR_VERSION]")
                      .toString())
              .build();
      client.setDefaultProcessorVersionAsync(request).get();
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
        ReviewDocumentResponse.newBuilder()
            .setGcsDestination("gcsDestination-1612392329")
            .setRejectionReason("rejectionReason1485905837")
            .build();
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
        ReviewDocumentResponse.newBuilder()
            .setGcsDestination("gcsDestination-1612392329")
            .setRejectionReason("rejectionReason1485905837")
            .build();
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
}
