/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.support.v2beta;

import static com.google.cloud.support.v2beta.CaseAttachmentServiceClient.ListAttachmentsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.support.v2beta.stub.HttpJsonCaseAttachmentServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class CaseAttachmentServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static CaseAttachmentServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonCaseAttachmentServiceStub.getMethodDescriptors(),
            CaseAttachmentServiceSettings.getDefaultEndpoint());
    CaseAttachmentServiceSettings settings =
        CaseAttachmentServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                CaseAttachmentServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CaseAttachmentServiceClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void listAttachmentsTest() throws Exception {
    Attachment responsesElement = Attachment.newBuilder().build();
    ListAttachmentsResponse expectedResponse =
        ListAttachmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAttachments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    CaseName parent = CaseName.ofProjectCaseName("[PROJECT]", "[CASE]");

    ListAttachmentsPagedResponse pagedListResponse = client.listAttachments(parent);

    List<Attachment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAttachmentsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listAttachmentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CaseName parent = CaseName.ofProjectCaseName("[PROJECT]", "[CASE]");
      client.listAttachments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAttachmentsTest2() throws Exception {
    Attachment responsesElement = Attachment.newBuilder().build();
    ListAttachmentsResponse expectedResponse =
        ListAttachmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAttachments(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2178/cases/case-2178";

    ListAttachmentsPagedResponse pagedListResponse = client.listAttachments(parent);

    List<Attachment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAttachmentsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listAttachmentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2178/cases/case-2178";
      client.listAttachments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAttachmentTest() throws Exception {
    Attachment expectedResponse =
        Attachment.newBuilder()
            .setName(
                AttachmentName.ofOrganizationCaseAttachmentIdName(
                        "[ORGANIZATION]", "[CASE]", "[ATTACHMENT_ID]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreator(Actor.newBuilder().build())
            .setFilename("filename-734768633")
            .setMimeType("mimeType-1392120434")
            .setSizeBytes(-1796325715)
            .build();
    mockService.addResponse(expectedResponse);

    AttachmentName name =
        AttachmentName.ofOrganizationCaseAttachmentIdName(
            "[ORGANIZATION]", "[CASE]", "[ATTACHMENT_ID]");

    Attachment actualResponse = client.getAttachment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getAttachmentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AttachmentName name =
          AttachmentName.ofOrganizationCaseAttachmentIdName(
              "[ORGANIZATION]", "[CASE]", "[ATTACHMENT_ID]");
      client.getAttachment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAttachmentTest2() throws Exception {
    Attachment expectedResponse =
        Attachment.newBuilder()
            .setName(
                AttachmentName.ofOrganizationCaseAttachmentIdName(
                        "[ORGANIZATION]", "[CASE]", "[ATTACHMENT_ID]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCreator(Actor.newBuilder().build())
            .setFilename("filename-734768633")
            .setMimeType("mimeType-1392120434")
            .setSizeBytes(-1796325715)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "name-9781/name-9781/cases/case-9781/attachments/attachment-9781";

    Attachment actualResponse = client.getAttachment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getAttachmentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "name-9781/name-9781/cases/case-9781/attachments/attachment-9781";
      client.getAttachment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
