/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.datacatalog.v1beta1;

import static com.google.cloud.datacatalog.v1beta1.DataCatalogClient.ListTagsPagedResponse;
import static com.google.cloud.datacatalog.v1beta1.DataCatalogClient.SearchCatalogPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.datacatalog.CreateTagRequest;
import com.google.cloud.datacatalog.CreateTagTemplateFieldRequest;
import com.google.cloud.datacatalog.CreateTagTemplateRequest;
import com.google.cloud.datacatalog.DeleteTagRequest;
import com.google.cloud.datacatalog.DeleteTagTemplateFieldRequest;
import com.google.cloud.datacatalog.DeleteTagTemplateRequest;
import com.google.cloud.datacatalog.Entry;
import com.google.cloud.datacatalog.GetEntryRequest;
import com.google.cloud.datacatalog.GetTagTemplateRequest;
import com.google.cloud.datacatalog.ListTagsRequest;
import com.google.cloud.datacatalog.ListTagsResponse;
import com.google.cloud.datacatalog.RenameTagTemplateFieldRequest;
import com.google.cloud.datacatalog.SearchCatalogRequest;
import com.google.cloud.datacatalog.SearchCatalogResponse;
import com.google.cloud.datacatalog.SearchCatalogResult;
import com.google.cloud.datacatalog.Tag;
import com.google.cloud.datacatalog.TagTemplate;
import com.google.cloud.datacatalog.TagTemplateField;
import com.google.cloud.datacatalog.UpdateEntryRequest;
import com.google.cloud.datacatalog.UpdateTagRequest;
import com.google.cloud.datacatalog.UpdateTagTemplateFieldRequest;
import com.google.cloud.datacatalog.UpdateTagTemplateRequest;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class DataCatalogClientTest {
  private static MockDataCatalog mockDataCatalog;
  private static MockServiceHelper serviceHelper;
  private DataCatalogClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockDataCatalog = new MockDataCatalog();
    serviceHelper =
        new MockServiceHelper("in-process-1", Arrays.<MockGrpcService>asList(mockDataCatalog));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    DataCatalogSettings settings =
        DataCatalogSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataCatalogClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void searchCatalogTest() {
    String nextPageToken = "";
    SearchCatalogResult resultsElement = SearchCatalogResult.newBuilder().build();
    List<SearchCatalogResult> results = Arrays.asList(resultsElement);
    SearchCatalogResponse expectedResponse =
        SearchCatalogResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllResults(results)
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    SearchCatalogRequest.Scope scope = SearchCatalogRequest.Scope.newBuilder().build();
    String query = "query107944136";
    String orderBy = "orderBy1234304744";

    SearchCatalogPagedResponse pagedListResponse = client.searchCatalog(scope, query, orderBy);

    List<SearchCatalogResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchCatalogRequest actualRequest = (SearchCatalogRequest) actualRequests.get(0);

    Assert.assertEquals(scope, actualRequest.getScope());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertEquals(orderBy, actualRequest.getOrderBy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void searchCatalogExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      SearchCatalogRequest.Scope scope = SearchCatalogRequest.Scope.newBuilder().build();
      String query = "query107944136";
      String orderBy = "orderBy1234304744";

      client.searchCatalog(scope, query, orderBy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateEntryTest() {
    String name = "name3373707";
    String linkedResource = "linkedResource1544625012";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    Entry expectedResponse =
        Entry.newBuilder()
            .setName(name)
            .setLinkedResource(linkedResource)
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    Entry entry = Entry.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Entry actualResponse = client.updateEntry(entry, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEntryRequest actualRequest = (UpdateEntryRequest) actualRequests.get(0);

    Assert.assertEquals(entry, actualRequest.getEntry());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateEntryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      Entry entry = Entry.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateEntry(entry, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getEntryTest() {
    String name2 = "name2-1052831874";
    String linkedResource = "linkedResource1544625012";
    String displayName = "displayName1615086568";
    String description = "description-1724546052";
    Entry expectedResponse =
        Entry.newBuilder()
            .setName(name2)
            .setLinkedResource(linkedResource)
            .setDisplayName(displayName)
            .setDescription(description)
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    String formattedName =
        DataCatalogClient.formatEntryName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");

    Entry actualResponse = client.getEntry(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEntryRequest actualRequest = (GetEntryRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getEntryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String formattedName =
          DataCatalogClient.formatEntryName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");

      client.getEntry(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createTagTemplateTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    TagTemplate expectedResponse =
        TagTemplate.newBuilder().setName(name).setDisplayName(displayName).build();
    mockDataCatalog.addResponse(expectedResponse);

    String formattedParent = DataCatalogClient.formatLocationName("[PROJECT]", "[LOCATION]");
    String tagTemplateId = "tagTemplateId-2020335141";
    TagTemplate tagTemplate = TagTemplate.newBuilder().build();

    TagTemplate actualResponse =
        client.createTagTemplate(formattedParent, tagTemplateId, tagTemplate);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTagTemplateRequest actualRequest = (CreateTagTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertEquals(tagTemplateId, actualRequest.getTagTemplateId());
    Assert.assertEquals(tagTemplate, actualRequest.getTagTemplate());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createTagTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String formattedParent = DataCatalogClient.formatLocationName("[PROJECT]", "[LOCATION]");
      String tagTemplateId = "tagTemplateId-2020335141";
      TagTemplate tagTemplate = TagTemplate.newBuilder().build();

      client.createTagTemplate(formattedParent, tagTemplateId, tagTemplate);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getTagTemplateTest() {
    String name2 = "name2-1052831874";
    String displayName = "displayName1615086568";
    TagTemplate expectedResponse =
        TagTemplate.newBuilder().setName(name2).setDisplayName(displayName).build();
    mockDataCatalog.addResponse(expectedResponse);

    String formattedName =
        DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");

    TagTemplate actualResponse = client.getTagTemplate(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTagTemplateRequest actualRequest = (GetTagTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getTagTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String formattedName =
          DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");

      client.getTagTemplate(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateTagTemplateTest() {
    String name = "name3373707";
    String displayName = "displayName1615086568";
    TagTemplate expectedResponse =
        TagTemplate.newBuilder().setName(name).setDisplayName(displayName).build();
    mockDataCatalog.addResponse(expectedResponse);

    TagTemplate tagTemplate = TagTemplate.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TagTemplate actualResponse = client.updateTagTemplate(tagTemplate, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTagTemplateRequest actualRequest = (UpdateTagTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(tagTemplate, actualRequest.getTagTemplate());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateTagTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      TagTemplate tagTemplate = TagTemplate.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateTagTemplate(tagTemplate, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteTagTemplateTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataCatalog.addResponse(expectedResponse);

    String formattedName =
        DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
    boolean force = false;

    client.deleteTagTemplate(formattedName, force);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTagTemplateRequest actualRequest = (DeleteTagTemplateRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertEquals(force, actualRequest.getForce());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteTagTemplateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String formattedName =
          DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
      boolean force = false;

      client.deleteTagTemplate(formattedName, force);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createTagTemplateFieldTest() {
    String displayName = "displayName1615086568";
    TagTemplateField expectedResponse =
        TagTemplateField.newBuilder().setDisplayName(displayName).build();
    mockDataCatalog.addResponse(expectedResponse);

    String formattedParent =
        DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
    String tagTemplateFieldId = "tagTemplateFieldId-92144832";
    TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();

    TagTemplateField actualResponse =
        client.createTagTemplateField(formattedParent, tagTemplateFieldId, tagTemplateField);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTagTemplateFieldRequest actualRequest =
        (CreateTagTemplateFieldRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertEquals(tagTemplateFieldId, actualRequest.getTagTemplateFieldId());
    Assert.assertEquals(tagTemplateField, actualRequest.getTagTemplateField());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createTagTemplateFieldExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String formattedParent =
          DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
      String tagTemplateFieldId = "tagTemplateFieldId-92144832";
      TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();

      client.createTagTemplateField(formattedParent, tagTemplateFieldId, tagTemplateField);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateTagTemplateFieldTest() {
    String displayName = "displayName1615086568";
    TagTemplateField expectedResponse =
        TagTemplateField.newBuilder().setDisplayName(displayName).build();
    mockDataCatalog.addResponse(expectedResponse);

    String formattedName =
        DataCatalogClient.formatFieldName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
    TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TagTemplateField actualResponse =
        client.updateTagTemplateField(formattedName, tagTemplateField, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTagTemplateFieldRequest actualRequest =
        (UpdateTagTemplateFieldRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertEquals(tagTemplateField, actualRequest.getTagTemplateField());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateTagTemplateFieldExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String formattedName =
          DataCatalogClient.formatFieldName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
      TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateTagTemplateField(formattedName, tagTemplateField, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void renameTagTemplateFieldTest() {
    String displayName = "displayName1615086568";
    TagTemplateField expectedResponse =
        TagTemplateField.newBuilder().setDisplayName(displayName).build();
    mockDataCatalog.addResponse(expectedResponse);

    String formattedName =
        DataCatalogClient.formatFieldName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
    String newTagTemplateFieldId = "newTagTemplateFieldId-1668354591";

    TagTemplateField actualResponse =
        client.renameTagTemplateField(formattedName, newTagTemplateFieldId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RenameTagTemplateFieldRequest actualRequest =
        (RenameTagTemplateFieldRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertEquals(newTagTemplateFieldId, actualRequest.getNewTagTemplateFieldId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void renameTagTemplateFieldExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String formattedName =
          DataCatalogClient.formatFieldName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
      String newTagTemplateFieldId = "newTagTemplateFieldId-1668354591";

      client.renameTagTemplateField(formattedName, newTagTemplateFieldId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteTagTemplateFieldTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataCatalog.addResponse(expectedResponse);

    String formattedName =
        DataCatalogClient.formatFieldName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
    boolean force = false;

    client.deleteTagTemplateField(formattedName, force);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTagTemplateFieldRequest actualRequest =
        (DeleteTagTemplateFieldRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertEquals(force, actualRequest.getForce());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteTagTemplateFieldExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String formattedName =
          DataCatalogClient.formatFieldName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
      boolean force = false;

      client.deleteTagTemplateField(formattedName, force);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createTagTest() {
    String name = "name3373707";
    String template = "template-1321546630";
    String templateDisplayName = "templateDisplayName-532252787";
    String column = "column-1354837162";
    Tag expectedResponse =
        Tag.newBuilder()
            .setName(name)
            .setTemplate(template)
            .setTemplateDisplayName(templateDisplayName)
            .setColumn(column)
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    String formattedParent =
        DataCatalogClient.formatEntryName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
    Tag tag = Tag.newBuilder().build();

    Tag actualResponse = client.createTag(formattedParent, tag);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTagRequest actualRequest = (CreateTagRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertEquals(tag, actualRequest.getTag());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createTagExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String formattedParent =
          DataCatalogClient.formatEntryName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
      Tag tag = Tag.newBuilder().build();

      client.createTag(formattedParent, tag);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateTagTest() {
    String name = "name3373707";
    String template = "template-1321546630";
    String templateDisplayName = "templateDisplayName-532252787";
    String column = "column-1354837162";
    Tag expectedResponse =
        Tag.newBuilder()
            .setName(name)
            .setTemplate(template)
            .setTemplateDisplayName(templateDisplayName)
            .setColumn(column)
            .build();
    mockDataCatalog.addResponse(expectedResponse);

    Tag tag = Tag.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Tag actualResponse = client.updateTag(tag, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTagRequest actualRequest = (UpdateTagRequest) actualRequests.get(0);

    Assert.assertEquals(tag, actualRequest.getTag());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateTagExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      Tag tag = Tag.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateTag(tag, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteTagTest() {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataCatalog.addResponse(expectedResponse);

    String formattedName =
        DataCatalogClient.formatTagName(
            "[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]", "[TAG]");

    client.deleteTag(formattedName);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTagRequest actualRequest = (DeleteTagRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteTagExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String formattedName =
          DataCatalogClient.formatTagName(
              "[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]", "[TAG]");

      client.deleteTag(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listTagsTest() {
    String nextPageToken = "";
    Tag tagsElement = Tag.newBuilder().build();
    List<Tag> tags = Arrays.asList(tagsElement);
    ListTagsResponse expectedResponse =
        ListTagsResponse.newBuilder().setNextPageToken(nextPageToken).addAllTags(tags).build();
    mockDataCatalog.addResponse(expectedResponse);

    String formattedParent =
        DataCatalogClient.formatEntryName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");

    ListTagsPagedResponse pagedListResponse = client.listTags(formattedParent);

    List<Tag> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTagsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTagsRequest actualRequest = (ListTagsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listTagsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String formattedParent =
          DataCatalogClient.formatEntryName("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");

      client.listTags(formattedParent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockDataCatalog.addResponse(expectedResponse);

    String formattedResource =
        DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(formattedResource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = (SetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(formattedResource, actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String formattedResource =
          DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
      Policy policy = Policy.newBuilder().build();

      client.setIamPolicy(formattedResource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyTest() {
    int version = 351608024;
    ByteString etag = ByteString.copyFromUtf8("21");
    Policy expectedResponse = Policy.newBuilder().setVersion(version).setEtag(etag).build();
    mockDataCatalog.addResponse(expectedResponse);

    String formattedResource =
        DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");

    Policy actualResponse = client.getIamPolicy(formattedResource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = (GetIamPolicyRequest) actualRequests.get(0);

    Assert.assertEquals(formattedResource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String formattedResource =
          DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");

      client.getIamPolicy(formattedResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsTest() {
    TestIamPermissionsResponse expectedResponse = TestIamPermissionsResponse.newBuilder().build();
    mockDataCatalog.addResponse(expectedResponse);

    String formattedResource =
        DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse =
        client.testIamPermissions(formattedResource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataCatalog.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = (TestIamPermissionsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedResource, actualRequest.getResource());
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDataCatalog.addException(exception);

    try {
      String formattedResource =
          DataCatalogClient.formatTagTemplateName("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
      List<String> permissions = new ArrayList<>();

      client.testIamPermissions(formattedResource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
