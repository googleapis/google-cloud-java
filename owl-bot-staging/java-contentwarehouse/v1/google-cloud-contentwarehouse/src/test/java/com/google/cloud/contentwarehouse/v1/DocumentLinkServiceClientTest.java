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

package com.google.cloud.contentwarehouse.v1;

import static com.google.cloud.contentwarehouse.v1.DocumentLinkServiceClient.ListLinkedSourcesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class DocumentLinkServiceClientTest {
  private static MockDocumentLinkService mockDocumentLinkService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DocumentLinkServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDocumentLinkService = new MockDocumentLinkService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDocumentLinkService));
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
    DocumentLinkServiceSettings settings =
        DocumentLinkServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DocumentLinkServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listLinkedTargetsTest() throws Exception {
    ListLinkedTargetsResponse expectedResponse =
        ListLinkedTargetsResponse.newBuilder()
            .addAllDocumentLinks(new ArrayList<DocumentLink>())
            .setNextPageToken("nextPageToken-1386094857")
            .build();
    mockDocumentLinkService.addResponse(expectedResponse);

    DocumentName parent =
        DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]");

    ListLinkedTargetsResponse actualResponse = client.listLinkedTargets(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentLinkService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLinkedTargetsRequest actualRequest = ((ListLinkedTargetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLinkedTargetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentLinkService.addException(exception);

    try {
      DocumentName parent =
          DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]");
      client.listLinkedTargets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLinkedTargetsTest2() throws Exception {
    ListLinkedTargetsResponse expectedResponse =
        ListLinkedTargetsResponse.newBuilder()
            .addAllDocumentLinks(new ArrayList<DocumentLink>())
            .setNextPageToken("nextPageToken-1386094857")
            .build();
    mockDocumentLinkService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListLinkedTargetsResponse actualResponse = client.listLinkedTargets(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentLinkService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLinkedTargetsRequest actualRequest = ((ListLinkedTargetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLinkedTargetsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentLinkService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listLinkedTargets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLinkedSourcesTest() throws Exception {
    DocumentLink responsesElement = DocumentLink.newBuilder().build();
    ListLinkedSourcesResponse expectedResponse =
        ListLinkedSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDocumentLinks(Arrays.asList(responsesElement))
            .build();
    mockDocumentLinkService.addResponse(expectedResponse);

    DocumentName parent =
        DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]");

    ListLinkedSourcesPagedResponse pagedListResponse = client.listLinkedSources(parent);

    List<DocumentLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDocumentLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDocumentLinkService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLinkedSourcesRequest actualRequest = ((ListLinkedSourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLinkedSourcesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentLinkService.addException(exception);

    try {
      DocumentName parent =
          DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]");
      client.listLinkedSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLinkedSourcesTest2() throws Exception {
    DocumentLink responsesElement = DocumentLink.newBuilder().build();
    ListLinkedSourcesResponse expectedResponse =
        ListLinkedSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllDocumentLinks(Arrays.asList(responsesElement))
            .build();
    mockDocumentLinkService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListLinkedSourcesPagedResponse pagedListResponse = client.listLinkedSources(parent);

    List<DocumentLink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDocumentLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDocumentLinkService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLinkedSourcesRequest actualRequest = ((ListLinkedSourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLinkedSourcesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentLinkService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listLinkedSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDocumentLinkTest() throws Exception {
    DocumentLink expectedResponse =
        DocumentLink.newBuilder()
            .setName(
                DocumentLinkName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT]", "[DOCUMENT_LINK]")
                    .toString())
            .setSourceDocumentReference(DocumentReference.newBuilder().build())
            .setTargetDocumentReference(DocumentReference.newBuilder().build())
            .setDescription("description-1724546052")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockDocumentLinkService.addResponse(expectedResponse);

    DocumentName parent =
        DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]");
    DocumentLink documentLink = DocumentLink.newBuilder().build();

    DocumentLink actualResponse = client.createDocumentLink(parent, documentLink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentLinkService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDocumentLinkRequest actualRequest = ((CreateDocumentLinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(documentLink, actualRequest.getDocumentLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDocumentLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentLinkService.addException(exception);

    try {
      DocumentName parent =
          DocumentName.ofProjectLocationDocumentName("[PROJECT]", "[LOCATION]", "[DOCUMENT]");
      DocumentLink documentLink = DocumentLink.newBuilder().build();
      client.createDocumentLink(parent, documentLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDocumentLinkTest2() throws Exception {
    DocumentLink expectedResponse =
        DocumentLink.newBuilder()
            .setName(
                DocumentLinkName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT]", "[DOCUMENT_LINK]")
                    .toString())
            .setSourceDocumentReference(DocumentReference.newBuilder().build())
            .setTargetDocumentReference(DocumentReference.newBuilder().build())
            .setDescription("description-1724546052")
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockDocumentLinkService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    DocumentLink documentLink = DocumentLink.newBuilder().build();

    DocumentLink actualResponse = client.createDocumentLink(parent, documentLink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentLinkService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDocumentLinkRequest actualRequest = ((CreateDocumentLinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(documentLink, actualRequest.getDocumentLink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDocumentLinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentLinkService.addException(exception);

    try {
      String parent = "parent-995424086";
      DocumentLink documentLink = DocumentLink.newBuilder().build();
      client.createDocumentLink(parent, documentLink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDocumentLinkTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDocumentLinkService.addResponse(expectedResponse);

    DocumentLinkName name =
        DocumentLinkName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT]", "[DOCUMENT_LINK]");

    client.deleteDocumentLink(name);

    List<AbstractMessage> actualRequests = mockDocumentLinkService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDocumentLinkRequest actualRequest = ((DeleteDocumentLinkRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDocumentLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentLinkService.addException(exception);

    try {
      DocumentLinkName name =
          DocumentLinkName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT]", "[DOCUMENT_LINK]");
      client.deleteDocumentLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDocumentLinkTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDocumentLinkService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteDocumentLink(name);

    List<AbstractMessage> actualRequests = mockDocumentLinkService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDocumentLinkRequest actualRequest = ((DeleteDocumentLinkRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDocumentLinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentLinkService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDocumentLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
