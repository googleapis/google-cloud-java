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

package com.google.cloud.datacatalog.v1;

import static com.google.cloud.datacatalog.v1.PolicyTagManagerClient.ListPolicyTagsPagedResponse;
import static com.google.cloud.datacatalog.v1.PolicyTagManagerClient.ListTaxonomiesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.datacatalog.v1.stub.HttpJsonPolicyTagManagerStub;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.GetPolicyOptions;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
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
public class PolicyTagManagerClientHttpJsonTest {
  private static MockHttpService mockService;
  private static PolicyTagManagerClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonPolicyTagManagerStub.getMethodDescriptors(),
            PolicyTagManagerSettings.getDefaultEndpoint());
    PolicyTagManagerSettings settings =
        PolicyTagManagerSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                PolicyTagManagerSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = PolicyTagManagerClient.create(settings);
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
  public void createTaxonomyTest() throws Exception {
    Taxonomy expectedResponse =
        Taxonomy.newBuilder()
            .setName(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPolicyTagCount(1074340189)
            .setTaxonomyTimestamps(SystemTimestamps.newBuilder().build())
            .addAllActivatedPolicyTypes(new ArrayList<Taxonomy.PolicyType>())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Taxonomy taxonomy = Taxonomy.newBuilder().build();

    Taxonomy actualResponse = client.createTaxonomy(parent, taxonomy);
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
  public void createTaxonomyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Taxonomy taxonomy = Taxonomy.newBuilder().build();
      client.createTaxonomy(parent, taxonomy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTaxonomyTest2() throws Exception {
    Taxonomy expectedResponse =
        Taxonomy.newBuilder()
            .setName(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPolicyTagCount(1074340189)
            .setTaxonomyTimestamps(SystemTimestamps.newBuilder().build())
            .addAllActivatedPolicyTypes(new ArrayList<Taxonomy.PolicyType>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    Taxonomy taxonomy = Taxonomy.newBuilder().build();

    Taxonomy actualResponse = client.createTaxonomy(parent, taxonomy);
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
  public void createTaxonomyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Taxonomy taxonomy = Taxonomy.newBuilder().build();
      client.createTaxonomy(parent, taxonomy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTaxonomyTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    TaxonomyName name = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");

    client.deleteTaxonomy(name);

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
  public void deleteTaxonomyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TaxonomyName name = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");
      client.deleteTaxonomy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTaxonomyTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9503/locations/location-9503/taxonomies/taxonomie-9503";

    client.deleteTaxonomy(name);

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
  public void deleteTaxonomyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9503/locations/location-9503/taxonomies/taxonomie-9503";
      client.deleteTaxonomy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTaxonomyTest() throws Exception {
    Taxonomy expectedResponse =
        Taxonomy.newBuilder()
            .setName(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPolicyTagCount(1074340189)
            .setTaxonomyTimestamps(SystemTimestamps.newBuilder().build())
            .addAllActivatedPolicyTypes(new ArrayList<Taxonomy.PolicyType>())
            .build();
    mockService.addResponse(expectedResponse);

    Taxonomy taxonomy =
        Taxonomy.newBuilder()
            .setName(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPolicyTagCount(1074340189)
            .setTaxonomyTimestamps(SystemTimestamps.newBuilder().build())
            .addAllActivatedPolicyTypes(new ArrayList<Taxonomy.PolicyType>())
            .build();

    Taxonomy actualResponse = client.updateTaxonomy(taxonomy);
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
  public void updateTaxonomyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Taxonomy taxonomy =
          Taxonomy.newBuilder()
              .setName(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .setPolicyTagCount(1074340189)
              .setTaxonomyTimestamps(SystemTimestamps.newBuilder().build())
              .addAllActivatedPolicyTypes(new ArrayList<Taxonomy.PolicyType>())
              .build();
      client.updateTaxonomy(taxonomy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTaxonomiesTest() throws Exception {
    Taxonomy responsesElement = Taxonomy.newBuilder().build();
    ListTaxonomiesResponse expectedResponse =
        ListTaxonomiesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTaxonomies(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListTaxonomiesPagedResponse pagedListResponse = client.listTaxonomies(parent);

    List<Taxonomy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTaxonomiesList().get(0), resources.get(0));

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
  public void listTaxonomiesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listTaxonomies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTaxonomiesTest2() throws Exception {
    Taxonomy responsesElement = Taxonomy.newBuilder().build();
    ListTaxonomiesResponse expectedResponse =
        ListTaxonomiesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTaxonomies(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListTaxonomiesPagedResponse pagedListResponse = client.listTaxonomies(parent);

    List<Taxonomy> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTaxonomiesList().get(0), resources.get(0));

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
  public void listTaxonomiesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listTaxonomies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTaxonomyTest() throws Exception {
    Taxonomy expectedResponse =
        Taxonomy.newBuilder()
            .setName(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPolicyTagCount(1074340189)
            .setTaxonomyTimestamps(SystemTimestamps.newBuilder().build())
            .addAllActivatedPolicyTypes(new ArrayList<Taxonomy.PolicyType>())
            .build();
    mockService.addResponse(expectedResponse);

    TaxonomyName name = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");

    Taxonomy actualResponse = client.getTaxonomy(name);
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
  public void getTaxonomyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TaxonomyName name = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");
      client.getTaxonomy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTaxonomyTest2() throws Exception {
    Taxonomy expectedResponse =
        Taxonomy.newBuilder()
            .setName(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPolicyTagCount(1074340189)
            .setTaxonomyTimestamps(SystemTimestamps.newBuilder().build())
            .addAllActivatedPolicyTypes(new ArrayList<Taxonomy.PolicyType>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9503/locations/location-9503/taxonomies/taxonomie-9503";

    Taxonomy actualResponse = client.getTaxonomy(name);
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
  public void getTaxonomyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9503/locations/location-9503/taxonomies/taxonomie-9503";
      client.getTaxonomy(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPolicyTagTest() throws Exception {
    PolicyTag expectedResponse =
        PolicyTag.newBuilder()
            .setName(
                PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setParentPolicyTag("parentPolicyTag973173630")
            .addAllChildPolicyTags(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    TaxonomyName parent = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");
    PolicyTag policyTag = PolicyTag.newBuilder().build();

    PolicyTag actualResponse = client.createPolicyTag(parent, policyTag);
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
  public void createPolicyTagExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TaxonomyName parent = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");
      PolicyTag policyTag = PolicyTag.newBuilder().build();
      client.createPolicyTag(parent, policyTag);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPolicyTagTest2() throws Exception {
    PolicyTag expectedResponse =
        PolicyTag.newBuilder()
            .setName(
                PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setParentPolicyTag("parentPolicyTag973173630")
            .addAllChildPolicyTags(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-1472/locations/location-1472/taxonomies/taxonomie-1472";
    PolicyTag policyTag = PolicyTag.newBuilder().build();

    PolicyTag actualResponse = client.createPolicyTag(parent, policyTag);
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
  public void createPolicyTagExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-1472/locations/location-1472/taxonomies/taxonomie-1472";
      PolicyTag policyTag = PolicyTag.newBuilder().build();
      client.createPolicyTag(parent, policyTag);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePolicyTagTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    PolicyTagName name = PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]");

    client.deletePolicyTag(name);

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
  public void deletePolicyTagExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PolicyTagName name =
          PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]");
      client.deletePolicyTag(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePolicyTagTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1130/locations/location-1130/taxonomies/taxonomie-1130/policyTags/policyTag-1130";

    client.deletePolicyTag(name);

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
  public void deletePolicyTagExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1130/locations/location-1130/taxonomies/taxonomie-1130/policyTags/policyTag-1130";
      client.deletePolicyTag(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePolicyTagTest() throws Exception {
    PolicyTag expectedResponse =
        PolicyTag.newBuilder()
            .setName(
                PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setParentPolicyTag("parentPolicyTag973173630")
            .addAllChildPolicyTags(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    PolicyTag policyTag =
        PolicyTag.newBuilder()
            .setName(
                PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setParentPolicyTag("parentPolicyTag973173630")
            .addAllChildPolicyTags(new ArrayList<String>())
            .build();

    PolicyTag actualResponse = client.updatePolicyTag(policyTag);
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
  public void updatePolicyTagExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PolicyTag policyTag =
          PolicyTag.newBuilder()
              .setName(
                  PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .setParentPolicyTag("parentPolicyTag973173630")
              .addAllChildPolicyTags(new ArrayList<String>())
              .build();
      client.updatePolicyTag(policyTag);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPolicyTagsTest() throws Exception {
    PolicyTag responsesElement = PolicyTag.newBuilder().build();
    ListPolicyTagsResponse expectedResponse =
        ListPolicyTagsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicyTags(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    TaxonomyName parent = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");

    ListPolicyTagsPagedResponse pagedListResponse = client.listPolicyTags(parent);

    List<PolicyTag> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPolicyTagsList().get(0), resources.get(0));

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
  public void listPolicyTagsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TaxonomyName parent = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");
      client.listPolicyTags(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPolicyTagsTest2() throws Exception {
    PolicyTag responsesElement = PolicyTag.newBuilder().build();
    ListPolicyTagsResponse expectedResponse =
        ListPolicyTagsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPolicyTags(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-1472/locations/location-1472/taxonomies/taxonomie-1472";

    ListPolicyTagsPagedResponse pagedListResponse = client.listPolicyTags(parent);

    List<PolicyTag> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPolicyTagsList().get(0), resources.get(0));

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
  public void listPolicyTagsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-1472/locations/location-1472/taxonomies/taxonomie-1472";
      client.listPolicyTags(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPolicyTagTest() throws Exception {
    PolicyTag expectedResponse =
        PolicyTag.newBuilder()
            .setName(
                PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setParentPolicyTag("parentPolicyTag973173630")
            .addAllChildPolicyTags(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    PolicyTagName name = PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]");

    PolicyTag actualResponse = client.getPolicyTag(name);
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
  public void getPolicyTagExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PolicyTagName name =
          PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]");
      client.getPolicyTag(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPolicyTagTest2() throws Exception {
    PolicyTag expectedResponse =
        PolicyTag.newBuilder()
            .setName(
                PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setParentPolicyTag("parentPolicyTag973173630")
            .addAllChildPolicyTags(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1130/locations/location-1130/taxonomies/taxonomie-1130/policyTags/policyTag-1130";

    PolicyTag actualResponse = client.getPolicyTag(name);
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
  public void getPolicyTagExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1130/locations/location-1130/taxonomies/taxonomie-1130/policyTags/policyTag-1130";
      client.getPolicyTag(name);
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
    mockService.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(
                PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
                    .toString())
            .setOptions(GetPolicyOptions.newBuilder().build())
            .build();

    Policy actualResponse = client.getIamPolicy(request);
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
      GetIamPolicyRequest request =
          GetIamPolicyRequest.newBuilder()
              .setResource(
                  PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
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
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockService.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(
                PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
                    .toString())
            .setPolicy(Policy.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    Policy actualResponse = client.setIamPolicy(request);
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
      SetIamPolicyRequest request =
          SetIamPolicyRequest.newBuilder()
              .setResource(
                  PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
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
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockService.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(
                PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
                    .toString())
            .addAllPermissions(new ArrayList<String>())
            .build();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(request);
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
      TestIamPermissionsRequest request =
          TestIamPermissionsRequest.newBuilder()
              .setResource(
                  PolicyTagName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]", "[POLICY_TAG]")
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
