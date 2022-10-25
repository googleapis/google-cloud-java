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

import static com.google.cloud.contentwarehouse.v1.DocumentSchemaServiceClient.ListDocumentSchemasPagedResponse;

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
public class DocumentSchemaServiceClientTest {
  private static MockDocumentSchemaService mockDocumentSchemaService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DocumentSchemaServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDocumentSchemaService = new MockDocumentSchemaService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDocumentSchemaService));
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
    DocumentSchemaServiceSettings settings =
        DocumentSchemaServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DocumentSchemaServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createDocumentSchemaTest() throws Exception {
    DocumentSchema expectedResponse =
        DocumentSchema.newBuilder()
            .setName(
                DocumentSchemaName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT_SCHEMA]").toString())
            .setDisplayName("displayName1714148973")
            .addAllPropertyDefinitions(new ArrayList<PropertyDefinition>())
            .setDocumentIsFolder(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockDocumentSchemaService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    DocumentSchema documentSchema = DocumentSchema.newBuilder().build();

    DocumentSchema actualResponse = client.createDocumentSchema(parent, documentSchema);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentSchemaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDocumentSchemaRequest actualRequest =
        ((CreateDocumentSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(documentSchema, actualRequest.getDocumentSchema());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDocumentSchemaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentSchemaService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      DocumentSchema documentSchema = DocumentSchema.newBuilder().build();
      client.createDocumentSchema(parent, documentSchema);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDocumentSchemaTest2() throws Exception {
    DocumentSchema expectedResponse =
        DocumentSchema.newBuilder()
            .setName(
                DocumentSchemaName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT_SCHEMA]").toString())
            .setDisplayName("displayName1714148973")
            .addAllPropertyDefinitions(new ArrayList<PropertyDefinition>())
            .setDocumentIsFolder(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockDocumentSchemaService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    DocumentSchema documentSchema = DocumentSchema.newBuilder().build();

    DocumentSchema actualResponse = client.createDocumentSchema(parent, documentSchema);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentSchemaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDocumentSchemaRequest actualRequest =
        ((CreateDocumentSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(documentSchema, actualRequest.getDocumentSchema());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDocumentSchemaExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentSchemaService.addException(exception);

    try {
      String parent = "parent-995424086";
      DocumentSchema documentSchema = DocumentSchema.newBuilder().build();
      client.createDocumentSchema(parent, documentSchema);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDocumentSchemaTest() throws Exception {
    DocumentSchema expectedResponse =
        DocumentSchema.newBuilder()
            .setName(
                DocumentSchemaName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT_SCHEMA]").toString())
            .setDisplayName("displayName1714148973")
            .addAllPropertyDefinitions(new ArrayList<PropertyDefinition>())
            .setDocumentIsFolder(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockDocumentSchemaService.addResponse(expectedResponse);

    DocumentSchemaName name = DocumentSchemaName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT_SCHEMA]");
    DocumentSchema documentSchema = DocumentSchema.newBuilder().build();

    DocumentSchema actualResponse = client.updateDocumentSchema(name, documentSchema);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentSchemaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDocumentSchemaRequest actualRequest =
        ((UpdateDocumentSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(documentSchema, actualRequest.getDocumentSchema());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDocumentSchemaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentSchemaService.addException(exception);

    try {
      DocumentSchemaName name =
          DocumentSchemaName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT_SCHEMA]");
      DocumentSchema documentSchema = DocumentSchema.newBuilder().build();
      client.updateDocumentSchema(name, documentSchema);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDocumentSchemaTest2() throws Exception {
    DocumentSchema expectedResponse =
        DocumentSchema.newBuilder()
            .setName(
                DocumentSchemaName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT_SCHEMA]").toString())
            .setDisplayName("displayName1714148973")
            .addAllPropertyDefinitions(new ArrayList<PropertyDefinition>())
            .setDocumentIsFolder(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockDocumentSchemaService.addResponse(expectedResponse);

    String name = "name3373707";
    DocumentSchema documentSchema = DocumentSchema.newBuilder().build();

    DocumentSchema actualResponse = client.updateDocumentSchema(name, documentSchema);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentSchemaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDocumentSchemaRequest actualRequest =
        ((UpdateDocumentSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(documentSchema, actualRequest.getDocumentSchema());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDocumentSchemaExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentSchemaService.addException(exception);

    try {
      String name = "name3373707";
      DocumentSchema documentSchema = DocumentSchema.newBuilder().build();
      client.updateDocumentSchema(name, documentSchema);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDocumentSchemaTest() throws Exception {
    DocumentSchema expectedResponse =
        DocumentSchema.newBuilder()
            .setName(
                DocumentSchemaName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT_SCHEMA]").toString())
            .setDisplayName("displayName1714148973")
            .addAllPropertyDefinitions(new ArrayList<PropertyDefinition>())
            .setDocumentIsFolder(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockDocumentSchemaService.addResponse(expectedResponse);

    DocumentSchemaName name = DocumentSchemaName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT_SCHEMA]");

    DocumentSchema actualResponse = client.getDocumentSchema(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentSchemaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDocumentSchemaRequest actualRequest = ((GetDocumentSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDocumentSchemaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentSchemaService.addException(exception);

    try {
      DocumentSchemaName name =
          DocumentSchemaName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT_SCHEMA]");
      client.getDocumentSchema(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDocumentSchemaTest2() throws Exception {
    DocumentSchema expectedResponse =
        DocumentSchema.newBuilder()
            .setName(
                DocumentSchemaName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT_SCHEMA]").toString())
            .setDisplayName("displayName1714148973")
            .addAllPropertyDefinitions(new ArrayList<PropertyDefinition>())
            .setDocumentIsFolder(true)
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .build();
    mockDocumentSchemaService.addResponse(expectedResponse);

    String name = "name3373707";

    DocumentSchema actualResponse = client.getDocumentSchema(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDocumentSchemaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDocumentSchemaRequest actualRequest = ((GetDocumentSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDocumentSchemaExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentSchemaService.addException(exception);

    try {
      String name = "name3373707";
      client.getDocumentSchema(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDocumentSchemaTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDocumentSchemaService.addResponse(expectedResponse);

    DocumentSchemaName name = DocumentSchemaName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT_SCHEMA]");

    client.deleteDocumentSchema(name);

    List<AbstractMessage> actualRequests = mockDocumentSchemaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDocumentSchemaRequest actualRequest =
        ((DeleteDocumentSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDocumentSchemaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentSchemaService.addException(exception);

    try {
      DocumentSchemaName name =
          DocumentSchemaName.of("[PROJECT]", "[LOCATION]", "[DOCUMENT_SCHEMA]");
      client.deleteDocumentSchema(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDocumentSchemaTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDocumentSchemaService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteDocumentSchema(name);

    List<AbstractMessage> actualRequests = mockDocumentSchemaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDocumentSchemaRequest actualRequest =
        ((DeleteDocumentSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDocumentSchemaExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentSchemaService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteDocumentSchema(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDocumentSchemasTest() throws Exception {
    DocumentSchema responsesElement = DocumentSchema.newBuilder().build();
    ListDocumentSchemasResponse expectedResponse =
        ListDocumentSchemasResponse.newBuilder()
            .setNextPageToken("")
            .addAllDocumentSchemas(Arrays.asList(responsesElement))
            .build();
    mockDocumentSchemaService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListDocumentSchemasPagedResponse pagedListResponse = client.listDocumentSchemas(parent);

    List<DocumentSchema> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDocumentSchemasList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDocumentSchemaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDocumentSchemasRequest actualRequest = ((ListDocumentSchemasRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDocumentSchemasExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentSchemaService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listDocumentSchemas(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDocumentSchemasTest2() throws Exception {
    DocumentSchema responsesElement = DocumentSchema.newBuilder().build();
    ListDocumentSchemasResponse expectedResponse =
        ListDocumentSchemasResponse.newBuilder()
            .setNextPageToken("")
            .addAllDocumentSchemas(Arrays.asList(responsesElement))
            .build();
    mockDocumentSchemaService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDocumentSchemasPagedResponse pagedListResponse = client.listDocumentSchemas(parent);

    List<DocumentSchema> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDocumentSchemasList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDocumentSchemaService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDocumentSchemasRequest actualRequest = ((ListDocumentSchemasRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDocumentSchemasExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDocumentSchemaService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDocumentSchemas(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
