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

package google.cloud.chronicle.v1;

import static google.cloud.chronicle.v1.ReferenceListServiceClient.ListReferenceListsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.Lists;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import google.cloud.chronicle.v1.stub.HttpJsonReferenceListServiceStub;
import java.io.IOException;
import java.util.ArrayList;
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
public class ReferenceListServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ReferenceListServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonReferenceListServiceStub.getMethodDescriptors(),
            ReferenceListServiceSettings.getDefaultEndpoint());
    ReferenceListServiceSettings settings =
        ReferenceListServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ReferenceListServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ReferenceListServiceClient.create(settings);
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
  public void getReferenceListTest() throws Exception {
    ReferenceList expectedResponse =
        ReferenceList.newBuilder()
            .setName(
                ReferenceListName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[REFERENCE_LIST]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllEntries(new ArrayList<ReferenceListEntry>())
            .addAllRules(new ArrayList<String>())
            .setSyntaxType(ReferenceListSyntaxType.forNumber(0))
            .setRuleAssociationsCount(-1522562875)
            .setScopeInfo(ScopeInfo.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ReferenceListName name =
        ReferenceListName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[REFERENCE_LIST]");

    ReferenceList actualResponse = client.getReferenceList(name);
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
  public void getReferenceListExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReferenceListName name =
          ReferenceListName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[REFERENCE_LIST]");
      client.getReferenceList(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getReferenceListTest2() throws Exception {
    ReferenceList expectedResponse =
        ReferenceList.newBuilder()
            .setName(
                ReferenceListName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[REFERENCE_LIST]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllEntries(new ArrayList<ReferenceListEntry>())
            .addAllRules(new ArrayList<String>())
            .setSyntaxType(ReferenceListSyntaxType.forNumber(0))
            .setRuleAssociationsCount(-1522562875)
            .setScopeInfo(ScopeInfo.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-112/locations/location-112/instances/instance-112/referenceLists/referenceList-112";

    ReferenceList actualResponse = client.getReferenceList(name);
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
  public void getReferenceListExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-112/locations/location-112/instances/instance-112/referenceLists/referenceList-112";
      client.getReferenceList(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReferenceListsTest() throws Exception {
    ReferenceList responsesElement = ReferenceList.newBuilder().build();
    ListReferenceListsResponse expectedResponse =
        ListReferenceListsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReferenceLists(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListReferenceListsPagedResponse pagedListResponse = client.listReferenceLists(parent);

    List<ReferenceList> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReferenceListsList().get(0), resources.get(0));

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
  public void listReferenceListsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listReferenceLists(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReferenceListsTest2() throws Exception {
    ReferenceList responsesElement = ReferenceList.newBuilder().build();
    ListReferenceListsResponse expectedResponse =
        ListReferenceListsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReferenceLists(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";

    ListReferenceListsPagedResponse pagedListResponse = client.listReferenceLists(parent);

    List<ReferenceList> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReferenceListsList().get(0), resources.get(0));

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
  public void listReferenceListsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      client.listReferenceLists(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createReferenceListTest() throws Exception {
    ReferenceList expectedResponse =
        ReferenceList.newBuilder()
            .setName(
                ReferenceListName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[REFERENCE_LIST]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllEntries(new ArrayList<ReferenceListEntry>())
            .addAllRules(new ArrayList<String>())
            .setSyntaxType(ReferenceListSyntaxType.forNumber(0))
            .setRuleAssociationsCount(-1522562875)
            .setScopeInfo(ScopeInfo.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    ReferenceList referenceList = ReferenceList.newBuilder().build();
    String referenceListId = "referenceListId676417924";

    ReferenceList actualResponse =
        client.createReferenceList(parent, referenceList, referenceListId);
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
  public void createReferenceListExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      ReferenceList referenceList = ReferenceList.newBuilder().build();
      String referenceListId = "referenceListId676417924";
      client.createReferenceList(parent, referenceList, referenceListId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createReferenceListTest2() throws Exception {
    ReferenceList expectedResponse =
        ReferenceList.newBuilder()
            .setName(
                ReferenceListName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[REFERENCE_LIST]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllEntries(new ArrayList<ReferenceListEntry>())
            .addAllRules(new ArrayList<String>())
            .setSyntaxType(ReferenceListSyntaxType.forNumber(0))
            .setRuleAssociationsCount(-1522562875)
            .setScopeInfo(ScopeInfo.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
    ReferenceList referenceList = ReferenceList.newBuilder().build();
    String referenceListId = "referenceListId676417924";

    ReferenceList actualResponse =
        client.createReferenceList(parent, referenceList, referenceListId);
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
  public void createReferenceListExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      ReferenceList referenceList = ReferenceList.newBuilder().build();
      String referenceListId = "referenceListId676417924";
      client.createReferenceList(parent, referenceList, referenceListId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateReferenceListTest() throws Exception {
    ReferenceList expectedResponse =
        ReferenceList.newBuilder()
            .setName(
                ReferenceListName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[REFERENCE_LIST]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllEntries(new ArrayList<ReferenceListEntry>())
            .addAllRules(new ArrayList<String>())
            .setSyntaxType(ReferenceListSyntaxType.forNumber(0))
            .setRuleAssociationsCount(-1522562875)
            .setScopeInfo(ScopeInfo.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ReferenceList referenceList =
        ReferenceList.newBuilder()
            .setName(
                ReferenceListName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[REFERENCE_LIST]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .addAllEntries(new ArrayList<ReferenceListEntry>())
            .addAllRules(new ArrayList<String>())
            .setSyntaxType(ReferenceListSyntaxType.forNumber(0))
            .setRuleAssociationsCount(-1522562875)
            .setScopeInfo(ScopeInfo.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ReferenceList actualResponse = client.updateReferenceList(referenceList, updateMask);
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
  public void updateReferenceListExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReferenceList referenceList =
          ReferenceList.newBuilder()
              .setName(
                  ReferenceListName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[REFERENCE_LIST]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setRevisionCreateTime(Timestamp.newBuilder().build())
              .setDescription("description-1724546052")
              .addAllEntries(new ArrayList<ReferenceListEntry>())
              .addAllRules(new ArrayList<String>())
              .setSyntaxType(ReferenceListSyntaxType.forNumber(0))
              .setRuleAssociationsCount(-1522562875)
              .setScopeInfo(ScopeInfo.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateReferenceList(referenceList, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
