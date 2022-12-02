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

package com.google.cloud.resourcemanager.v3;

import static com.google.cloud.resourcemanager.v3.TagKeysClient.ListTagKeysPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.resourcemanager.v3.stub.HttpJsonTagKeysStub;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.Policy;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class TagKeysClientHttpJsonTest {
  private static MockHttpService mockService;
  private static TagKeysClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonTagKeysStub.getMethodDescriptors(), TagKeysSettings.getDefaultEndpoint());
    TagKeysSettings settings =
        TagKeysSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                TagKeysSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TagKeysClient.create(settings);
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
  public void listTagKeysTest() throws Exception {
    TagKey responsesElement = TagKey.newBuilder().build();
    ListTagKeysResponse expectedResponse =
        ListTagKeysResponse.newBuilder()
            .setNextPageToken("")
            .addAllTagKeys(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ResourceName parent = FolderName.of("[FOLDER]");

    ListTagKeysPagedResponse pagedListResponse = client.listTagKeys(parent);

    List<TagKey> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTagKeysList().get(0), resources.get(0));

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
  public void listTagKeysExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ResourceName parent = FolderName.of("[FOLDER]");
      client.listTagKeys(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTagKeysTest2() throws Exception {
    TagKey responsesElement = TagKey.newBuilder().build();
    ListTagKeysResponse expectedResponse =
        ListTagKeysResponse.newBuilder()
            .setNextPageToken("")
            .addAllTagKeys(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTagKeysPagedResponse pagedListResponse = client.listTagKeys(parent);

    List<TagKey> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTagKeysList().get(0), resources.get(0));

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
  public void listTagKeysExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTagKeys(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTagKeyTest() throws Exception {
    TagKey expectedResponse =
        TagKey.newBuilder()
            .setName(TagKeyName.of("[TAG_KEY]").toString())
            .setParent("parent-995424086")
            .setShortName("shortName-2028219097")
            .setNamespacedName("namespacedName-1877415788")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    TagKeyName name = TagKeyName.of("[TAG_KEY]");

    TagKey actualResponse = client.getTagKey(name);
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
  public void getTagKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TagKeyName name = TagKeyName.of("[TAG_KEY]");
      client.getTagKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTagKeyTest2() throws Exception {
    TagKey expectedResponse =
        TagKey.newBuilder()
            .setName(TagKeyName.of("[TAG_KEY]").toString())
            .setParent("parent-995424086")
            .setShortName("shortName-2028219097")
            .setNamespacedName("namespacedName-1877415788")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "tagKeys/tagKey-130";

    TagKey actualResponse = client.getTagKey(name);
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
  public void getTagKeyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "tagKeys/tagKey-130";
      client.getTagKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTagKeyTest() throws Exception {
    TagKey expectedResponse =
        TagKey.newBuilder()
            .setName(TagKeyName.of("[TAG_KEY]").toString())
            .setParent("parent-995424086")
            .setShortName("shortName-2028219097")
            .setNamespacedName("namespacedName-1877415788")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTagKeyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    TagKey tagKey = TagKey.newBuilder().build();

    TagKey actualResponse = client.createTagKeyAsync(tagKey).get();
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
  public void createTagKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TagKey tagKey = TagKey.newBuilder().build();
      client.createTagKeyAsync(tagKey).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateTagKeyTest() throws Exception {
    TagKey expectedResponse =
        TagKey.newBuilder()
            .setName(TagKeyName.of("[TAG_KEY]").toString())
            .setParent("parent-995424086")
            .setShortName("shortName-2028219097")
            .setNamespacedName("namespacedName-1877415788")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateTagKeyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    TagKey tagKey =
        TagKey.newBuilder()
            .setName(TagKeyName.of("[TAG_KEY]").toString())
            .setParent("parent-995424086")
            .setShortName("shortName-2028219097")
            .setNamespacedName("namespacedName-1877415788")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TagKey actualResponse = client.updateTagKeyAsync(tagKey, updateMask).get();
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
  public void updateTagKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TagKey tagKey =
          TagKey.newBuilder()
              .setName(TagKeyName.of("[TAG_KEY]").toString())
              .setParent("parent-995424086")
              .setShortName("shortName-2028219097")
              .setNamespacedName("namespacedName-1877415788")
              .setDescription("description-1724546052")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setEtag("etag3123477")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTagKeyAsync(tagKey, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteTagKeyTest() throws Exception {
    TagKey expectedResponse =
        TagKey.newBuilder()
            .setName(TagKeyName.of("[TAG_KEY]").toString())
            .setParent("parent-995424086")
            .setShortName("shortName-2028219097")
            .setNamespacedName("namespacedName-1877415788")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTagKeyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    TagKeyName name = TagKeyName.of("[TAG_KEY]");

    TagKey actualResponse = client.deleteTagKeyAsync(name).get();
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
  public void deleteTagKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TagKeyName name = TagKeyName.of("[TAG_KEY]");
      client.deleteTagKeyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteTagKeyTest2() throws Exception {
    TagKey expectedResponse =
        TagKey.newBuilder()
            .setName(TagKeyName.of("[TAG_KEY]").toString())
            .setParent("parent-995424086")
            .setShortName("shortName-2028219097")
            .setNamespacedName("namespacedName-1877415788")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setEtag("etag3123477")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTagKeyTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "tagKeys/tagKey-130";

    TagKey actualResponse = client.deleteTagKeyAsync(name).get();
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
  public void deleteTagKeyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "tagKeys/tagKey-130";
      client.deleteTagKeyAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    ResourceName resource = TagKeyName.of("[TAG_KEY]");

    Policy actualResponse = client.getIamPolicy(resource);
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
  public void getIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ResourceName resource = TagKeyName.of("[TAG_KEY]");
      client.getIamPolicy(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    String resource = "tagKeys/tagKey-8405";

    Policy actualResponse = client.getIamPolicy(resource);
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
  public void getIamPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String resource = "tagKeys/tagKey-8405";
      client.getIamPolicy(resource);
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
    mockService.addResponse(expectedResponse);

    ResourceName resource = TagKeyName.of("[TAG_KEY]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
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
  public void setIamPolicyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ResourceName resource = TagKeyName.of("[TAG_KEY]");
      Policy policy = Policy.newBuilder().build();
      client.setIamPolicy(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest2() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    String resource = "tagKeys/tagKey-8405";
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
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
  public void setIamPolicyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String resource = "tagKeys/tagKey-8405";
      Policy policy = Policy.newBuilder().build();
      client.setIamPolicy(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockService.addResponse(expectedResponse);

    ResourceName resource = TagKeyName.of("[TAG_KEY]");
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
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
  public void testIamPermissionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ResourceName resource = TagKeyName.of("[TAG_KEY]");
      List<String> permissions = new ArrayList<>();
      client.testIamPermissions(resource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest2() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockService.addResponse(expectedResponse);

    String resource = "tagKeys/tagKey-8405";
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
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
  public void testIamPermissionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String resource = "tagKeys/tagKey-8405";
      List<String> permissions = new ArrayList<>();
      client.testIamPermissions(resource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
