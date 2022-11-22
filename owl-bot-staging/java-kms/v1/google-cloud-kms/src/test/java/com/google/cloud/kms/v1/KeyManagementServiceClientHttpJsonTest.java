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

package com.google.cloud.kms.v1;

import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListCryptoKeyVersionsPagedResponse;
import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListCryptoKeysPagedResponse;
import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListImportJobsPagedResponse;
import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListKeyRingsPagedResponse;
import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.kms.v1.stub.HttpJsonKeyManagementServiceStub;
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
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Int64Value;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class KeyManagementServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static KeyManagementServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonKeyManagementServiceStub.getMethodDescriptors(),
            KeyManagementServiceSettings.getDefaultEndpoint());
    KeyManagementServiceSettings settings =
        KeyManagementServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                KeyManagementServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = KeyManagementServiceClient.create(settings);
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
  public void listKeyRingsTest() throws Exception {
    KeyRing responsesElement = KeyRing.newBuilder().build();
    ListKeyRingsResponse expectedResponse =
        ListKeyRingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllKeyRings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListKeyRingsPagedResponse pagedListResponse = client.listKeyRings(parent);

    List<KeyRing> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getKeyRingsList().get(0), resources.get(0));

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
  public void listKeyRingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listKeyRings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listKeyRingsTest2() throws Exception {
    KeyRing responsesElement = KeyRing.newBuilder().build();
    ListKeyRingsResponse expectedResponse =
        ListKeyRingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllKeyRings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListKeyRingsPagedResponse pagedListResponse = client.listKeyRings(parent);

    List<KeyRing> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getKeyRingsList().get(0), resources.get(0));

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
  public void listKeyRingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listKeyRings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCryptoKeysTest() throws Exception {
    CryptoKey responsesElement = CryptoKey.newBuilder().build();
    ListCryptoKeysResponse expectedResponse =
        ListCryptoKeysResponse.newBuilder()
            .setNextPageToken("")
            .addAllCryptoKeys(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    KeyRingName parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");

    ListCryptoKeysPagedResponse pagedListResponse = client.listCryptoKeys(parent);

    List<CryptoKey> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCryptoKeysList().get(0), resources.get(0));

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
  public void listCryptoKeysExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      KeyRingName parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
      client.listCryptoKeys(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCryptoKeysTest2() throws Exception {
    CryptoKey responsesElement = CryptoKey.newBuilder().build();
    ListCryptoKeysResponse expectedResponse =
        ListCryptoKeysResponse.newBuilder()
            .setNextPageToken("")
            .addAllCryptoKeys(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-7749/locations/location-7749/keyRings/keyRing-7749";

    ListCryptoKeysPagedResponse pagedListResponse = client.listCryptoKeys(parent);

    List<CryptoKey> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCryptoKeysList().get(0), resources.get(0));

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
  public void listCryptoKeysExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7749/locations/location-7749/keyRings/keyRing-7749";
      client.listCryptoKeys(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCryptoKeyVersionsTest() throws Exception {
    CryptoKeyVersion responsesElement = CryptoKeyVersion.newBuilder().build();
    ListCryptoKeyVersionsResponse expectedResponse =
        ListCryptoKeyVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCryptoKeyVersions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    CryptoKeyName parent =
        CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");

    ListCryptoKeyVersionsPagedResponse pagedListResponse = client.listCryptoKeyVersions(parent);

    List<CryptoKeyVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCryptoKeyVersionsList().get(0), resources.get(0));

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
  public void listCryptoKeyVersionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CryptoKeyName parent =
          CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
      client.listCryptoKeyVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCryptoKeyVersionsTest2() throws Exception {
    CryptoKeyVersion responsesElement = CryptoKeyVersion.newBuilder().build();
    ListCryptoKeyVersionsResponse expectedResponse =
        ListCryptoKeyVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCryptoKeyVersions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-7206/locations/location-7206/keyRings/keyRing-7206/cryptoKeys/cryptoKey-7206";

    ListCryptoKeyVersionsPagedResponse pagedListResponse = client.listCryptoKeyVersions(parent);

    List<CryptoKeyVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCryptoKeyVersionsList().get(0), resources.get(0));

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
  public void listCryptoKeyVersionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-7206/locations/location-7206/keyRings/keyRing-7206/cryptoKeys/cryptoKey-7206";
      client.listCryptoKeyVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listImportJobsTest() throws Exception {
    ImportJob responsesElement = ImportJob.newBuilder().build();
    ListImportJobsResponse expectedResponse =
        ListImportJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllImportJobs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    KeyRingName parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");

    ListImportJobsPagedResponse pagedListResponse = client.listImportJobs(parent);

    List<ImportJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getImportJobsList().get(0), resources.get(0));

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
  public void listImportJobsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      KeyRingName parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
      client.listImportJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listImportJobsTest2() throws Exception {
    ImportJob responsesElement = ImportJob.newBuilder().build();
    ListImportJobsResponse expectedResponse =
        ListImportJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllImportJobs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-7749/locations/location-7749/keyRings/keyRing-7749";

    ListImportJobsPagedResponse pagedListResponse = client.listImportJobs(parent);

    List<ImportJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getImportJobsList().get(0), resources.get(0));

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
  public void listImportJobsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7749/locations/location-7749/keyRings/keyRing-7749";
      client.listImportJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getKeyRingTest() throws Exception {
    KeyRing expectedResponse =
        KeyRing.newBuilder()
            .setName(KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    KeyRingName name = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");

    KeyRing actualResponse = client.getKeyRing(name);
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
  public void getKeyRingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      KeyRingName name = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
      client.getKeyRing(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getKeyRingTest2() throws Exception {
    KeyRing expectedResponse =
        KeyRing.newBuilder()
            .setName(KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4820/locations/location-4820/keyRings/keyRing-4820";

    KeyRing actualResponse = client.getKeyRing(name);
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
  public void getKeyRingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4820/locations/location-4820/keyRings/keyRing-4820";
      client.getKeyRing(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCryptoKeyTest() throws Exception {
    CryptoKey expectedResponse =
        CryptoKey.newBuilder()
            .setName(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setPrimary(CryptoKeyVersion.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setNextRotationTime(Timestamp.newBuilder().build())
            .setVersionTemplate(CryptoKeyVersionTemplate.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setImportOnly(true)
            .setDestroyScheduledDuration(Duration.newBuilder().build())
            .setCryptoKeyBackend(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .build();
    mockService.addResponse(expectedResponse);

    CryptoKeyName name = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");

    CryptoKey actualResponse = client.getCryptoKey(name);
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
  public void getCryptoKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CryptoKeyName name =
          CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
      client.getCryptoKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCryptoKeyTest2() throws Exception {
    CryptoKey expectedResponse =
        CryptoKey.newBuilder()
            .setName(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setPrimary(CryptoKeyVersion.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setNextRotationTime(Timestamp.newBuilder().build())
            .setVersionTemplate(CryptoKeyVersionTemplate.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setImportOnly(true)
            .setDestroyScheduledDuration(Duration.newBuilder().build())
            .setCryptoKeyBackend(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5355/locations/location-5355/keyRings/keyRing-5355/cryptoKeys/cryptoKey-5355";

    CryptoKey actualResponse = client.getCryptoKey(name);
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
  public void getCryptoKeyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5355/locations/location-5355/keyRings/keyRing-5355/cryptoKeys/cryptoKey-5355";
      client.getCryptoKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCryptoKeyVersionTest() throws Exception {
    CryptoKeyVersion expectedResponse =
        CryptoKeyVersion.newBuilder()
            .setName(
                CryptoKeyVersionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[KEY_RING]",
                        "[CRYPTO_KEY]",
                        "[CRYPTO_KEY_VERSION]")
                    .toString())
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .setAttestation(KeyOperationAttestation.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setGenerateTime(Timestamp.newBuilder().build())
            .setDestroyTime(Timestamp.newBuilder().build())
            .setDestroyEventTime(Timestamp.newBuilder().build())
            .setImportJob("importJob-208547368")
            .setImportTime(Timestamp.newBuilder().build())
            .setImportFailureReason("importFailureReason985493705")
            .setExternalProtectionLevelOptions(ExternalProtectionLevelOptions.newBuilder().build())
            .setReimportEligible(true)
            .build();
    mockService.addResponse(expectedResponse);

    CryptoKeyVersionName name =
        CryptoKeyVersionName.of(
            "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");

    CryptoKeyVersion actualResponse = client.getCryptoKeyVersion(name);
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
  public void getCryptoKeyVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CryptoKeyVersionName name =
          CryptoKeyVersionName.of(
              "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
      client.getCryptoKeyVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCryptoKeyVersionTest2() throws Exception {
    CryptoKeyVersion expectedResponse =
        CryptoKeyVersion.newBuilder()
            .setName(
                CryptoKeyVersionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[KEY_RING]",
                        "[CRYPTO_KEY]",
                        "[CRYPTO_KEY_VERSION]")
                    .toString())
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .setAttestation(KeyOperationAttestation.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setGenerateTime(Timestamp.newBuilder().build())
            .setDestroyTime(Timestamp.newBuilder().build())
            .setDestroyEventTime(Timestamp.newBuilder().build())
            .setImportJob("importJob-208547368")
            .setImportTime(Timestamp.newBuilder().build())
            .setImportFailureReason("importFailureReason985493705")
            .setExternalProtectionLevelOptions(ExternalProtectionLevelOptions.newBuilder().build())
            .setReimportEligible(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9504/locations/location-9504/keyRings/keyRing-9504/cryptoKeys/cryptoKey-9504/cryptoKeyVersions/cryptoKeyVersion-9504";

    CryptoKeyVersion actualResponse = client.getCryptoKeyVersion(name);
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
  public void getCryptoKeyVersionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9504/locations/location-9504/keyRings/keyRing-9504/cryptoKeys/cryptoKey-9504/cryptoKeyVersions/cryptoKeyVersion-9504";
      client.getCryptoKeyVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPublicKeyTest() throws Exception {
    PublicKey expectedResponse =
        PublicKey.newBuilder()
            .setPem("pem110872")
            .setPemCrc32C(Int64Value.newBuilder().build())
            .setName("name3373707")
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    CryptoKeyVersionName name =
        CryptoKeyVersionName.of(
            "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");

    PublicKey actualResponse = client.getPublicKey(name);
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
  public void getPublicKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CryptoKeyVersionName name =
          CryptoKeyVersionName.of(
              "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
      client.getPublicKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPublicKeyTest2() throws Exception {
    PublicKey expectedResponse =
        PublicKey.newBuilder()
            .setPem("pem110872")
            .setPemCrc32C(Int64Value.newBuilder().build())
            .setName("name3373707")
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9504/locations/location-9504/keyRings/keyRing-9504/cryptoKeys/cryptoKey-9504/cryptoKeyVersions/cryptoKeyVersion-9504";

    PublicKey actualResponse = client.getPublicKey(name);
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
  public void getPublicKeyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9504/locations/location-9504/keyRings/keyRing-9504/cryptoKeys/cryptoKey-9504/cryptoKeyVersions/cryptoKeyVersion-9504";
      client.getPublicKey(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getImportJobTest() throws Exception {
    ImportJob expectedResponse =
        ImportJob.newBuilder()
            .setName(
                ImportJobName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[IMPORT_JOB]")
                    .toString())
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setGenerateTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setExpireEventTime(Timestamp.newBuilder().build())
            .setPublicKey(ImportJob.WrappingPublicKey.newBuilder().build())
            .setAttestation(KeyOperationAttestation.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ImportJobName name = ImportJobName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[IMPORT_JOB]");

    ImportJob actualResponse = client.getImportJob(name);
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
  public void getImportJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ImportJobName name =
          ImportJobName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[IMPORT_JOB]");
      client.getImportJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getImportJobTest2() throws Exception {
    ImportJob expectedResponse =
        ImportJob.newBuilder()
            .setName(
                ImportJobName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[IMPORT_JOB]")
                    .toString())
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setGenerateTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setExpireEventTime(Timestamp.newBuilder().build())
            .setPublicKey(ImportJob.WrappingPublicKey.newBuilder().build())
            .setAttestation(KeyOperationAttestation.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6111/locations/location-6111/keyRings/keyRing-6111/importJobs/importJob-6111";

    ImportJob actualResponse = client.getImportJob(name);
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
  public void getImportJobExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6111/locations/location-6111/keyRings/keyRing-6111/importJobs/importJob-6111";
      client.getImportJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createKeyRingTest() throws Exception {
    KeyRing expectedResponse =
        KeyRing.newBuilder()
            .setName(KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String keyRingId = "keyRingId-2027180374";
    KeyRing keyRing = KeyRing.newBuilder().build();

    KeyRing actualResponse = client.createKeyRing(parent, keyRingId, keyRing);
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
  public void createKeyRingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String keyRingId = "keyRingId-2027180374";
      KeyRing keyRing = KeyRing.newBuilder().build();
      client.createKeyRing(parent, keyRingId, keyRing);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createKeyRingTest2() throws Exception {
    KeyRing expectedResponse =
        KeyRing.newBuilder()
            .setName(KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    String keyRingId = "keyRingId-2027180374";
    KeyRing keyRing = KeyRing.newBuilder().build();

    KeyRing actualResponse = client.createKeyRing(parent, keyRingId, keyRing);
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
  public void createKeyRingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      String keyRingId = "keyRingId-2027180374";
      KeyRing keyRing = KeyRing.newBuilder().build();
      client.createKeyRing(parent, keyRingId, keyRing);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCryptoKeyTest() throws Exception {
    CryptoKey expectedResponse =
        CryptoKey.newBuilder()
            .setName(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setPrimary(CryptoKeyVersion.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setNextRotationTime(Timestamp.newBuilder().build())
            .setVersionTemplate(CryptoKeyVersionTemplate.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setImportOnly(true)
            .setDestroyScheduledDuration(Duration.newBuilder().build())
            .setCryptoKeyBackend(KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    KeyRingName parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
    String cryptoKeyId = "cryptoKeyId-1643185255";
    CryptoKey cryptoKey = CryptoKey.newBuilder().build();

    CryptoKey actualResponse = client.createCryptoKey(parent, cryptoKeyId, cryptoKey);
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
  public void createCryptoKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      KeyRingName parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
      String cryptoKeyId = "cryptoKeyId-1643185255";
      CryptoKey cryptoKey = CryptoKey.newBuilder().build();
      client.createCryptoKey(parent, cryptoKeyId, cryptoKey);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCryptoKeyTest2() throws Exception {
    CryptoKey expectedResponse =
        CryptoKey.newBuilder()
            .setName(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setPrimary(CryptoKeyVersion.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setNextRotationTime(Timestamp.newBuilder().build())
            .setVersionTemplate(CryptoKeyVersionTemplate.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setImportOnly(true)
            .setDestroyScheduledDuration(Duration.newBuilder().build())
            .setCryptoKeyBackend(KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-7749/locations/location-7749/keyRings/keyRing-7749";
    String cryptoKeyId = "cryptoKeyId-1643185255";
    CryptoKey cryptoKey = CryptoKey.newBuilder().build();

    CryptoKey actualResponse = client.createCryptoKey(parent, cryptoKeyId, cryptoKey);
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
  public void createCryptoKeyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7749/locations/location-7749/keyRings/keyRing-7749";
      String cryptoKeyId = "cryptoKeyId-1643185255";
      CryptoKey cryptoKey = CryptoKey.newBuilder().build();
      client.createCryptoKey(parent, cryptoKeyId, cryptoKey);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCryptoKeyVersionTest() throws Exception {
    CryptoKeyVersion expectedResponse =
        CryptoKeyVersion.newBuilder()
            .setName(
                CryptoKeyVersionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[KEY_RING]",
                        "[CRYPTO_KEY]",
                        "[CRYPTO_KEY_VERSION]")
                    .toString())
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .setAttestation(KeyOperationAttestation.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setGenerateTime(Timestamp.newBuilder().build())
            .setDestroyTime(Timestamp.newBuilder().build())
            .setDestroyEventTime(Timestamp.newBuilder().build())
            .setImportJob("importJob-208547368")
            .setImportTime(Timestamp.newBuilder().build())
            .setImportFailureReason("importFailureReason985493705")
            .setExternalProtectionLevelOptions(ExternalProtectionLevelOptions.newBuilder().build())
            .setReimportEligible(true)
            .build();
    mockService.addResponse(expectedResponse);

    CryptoKeyName parent =
        CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
    CryptoKeyVersion cryptoKeyVersion = CryptoKeyVersion.newBuilder().build();

    CryptoKeyVersion actualResponse = client.createCryptoKeyVersion(parent, cryptoKeyVersion);
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
  public void createCryptoKeyVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CryptoKeyName parent =
          CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
      CryptoKeyVersion cryptoKeyVersion = CryptoKeyVersion.newBuilder().build();
      client.createCryptoKeyVersion(parent, cryptoKeyVersion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCryptoKeyVersionTest2() throws Exception {
    CryptoKeyVersion expectedResponse =
        CryptoKeyVersion.newBuilder()
            .setName(
                CryptoKeyVersionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[KEY_RING]",
                        "[CRYPTO_KEY]",
                        "[CRYPTO_KEY_VERSION]")
                    .toString())
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .setAttestation(KeyOperationAttestation.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setGenerateTime(Timestamp.newBuilder().build())
            .setDestroyTime(Timestamp.newBuilder().build())
            .setDestroyEventTime(Timestamp.newBuilder().build())
            .setImportJob("importJob-208547368")
            .setImportTime(Timestamp.newBuilder().build())
            .setImportFailureReason("importFailureReason985493705")
            .setExternalProtectionLevelOptions(ExternalProtectionLevelOptions.newBuilder().build())
            .setReimportEligible(true)
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-7206/locations/location-7206/keyRings/keyRing-7206/cryptoKeys/cryptoKey-7206";
    CryptoKeyVersion cryptoKeyVersion = CryptoKeyVersion.newBuilder().build();

    CryptoKeyVersion actualResponse = client.createCryptoKeyVersion(parent, cryptoKeyVersion);
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
  public void createCryptoKeyVersionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-7206/locations/location-7206/keyRings/keyRing-7206/cryptoKeys/cryptoKey-7206";
      CryptoKeyVersion cryptoKeyVersion = CryptoKeyVersion.newBuilder().build();
      client.createCryptoKeyVersion(parent, cryptoKeyVersion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importCryptoKeyVersionTest() throws Exception {
    CryptoKeyVersion expectedResponse =
        CryptoKeyVersion.newBuilder()
            .setName(
                CryptoKeyVersionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[KEY_RING]",
                        "[CRYPTO_KEY]",
                        "[CRYPTO_KEY_VERSION]")
                    .toString())
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .setAttestation(KeyOperationAttestation.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setGenerateTime(Timestamp.newBuilder().build())
            .setDestroyTime(Timestamp.newBuilder().build())
            .setDestroyEventTime(Timestamp.newBuilder().build())
            .setImportJob("importJob-208547368")
            .setImportTime(Timestamp.newBuilder().build())
            .setImportFailureReason("importFailureReason985493705")
            .setExternalProtectionLevelOptions(ExternalProtectionLevelOptions.newBuilder().build())
            .setReimportEligible(true)
            .build();
    mockService.addResponse(expectedResponse);

    ImportCryptoKeyVersionRequest request =
        ImportCryptoKeyVersionRequest.newBuilder()
            .setParent(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setCryptoKeyVersion(
                CryptoKeyVersionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[KEY_RING]",
                        "[CRYPTO_KEY]",
                        "[CRYPTO_KEY_VERSION]")
                    .toString())
            .setImportJob("importJob-208547368")
            .setWrappedKey(ByteString.EMPTY)
            .build();

    CryptoKeyVersion actualResponse = client.importCryptoKeyVersion(request);
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
  public void importCryptoKeyVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ImportCryptoKeyVersionRequest request =
          ImportCryptoKeyVersionRequest.newBuilder()
              .setParent(
                  CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                      .toString())
              .setCryptoKeyVersion(
                  CryptoKeyVersionName.of(
                          "[PROJECT]",
                          "[LOCATION]",
                          "[KEY_RING]",
                          "[CRYPTO_KEY]",
                          "[CRYPTO_KEY_VERSION]")
                      .toString())
              .setImportJob("importJob-208547368")
              .setWrappedKey(ByteString.EMPTY)
              .build();
      client.importCryptoKeyVersion(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createImportJobTest() throws Exception {
    ImportJob expectedResponse =
        ImportJob.newBuilder()
            .setName(
                ImportJobName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[IMPORT_JOB]")
                    .toString())
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setGenerateTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setExpireEventTime(Timestamp.newBuilder().build())
            .setPublicKey(ImportJob.WrappingPublicKey.newBuilder().build())
            .setAttestation(KeyOperationAttestation.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    KeyRingName parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
    String importJobId = "importJobId1449444627";
    ImportJob importJob = ImportJob.newBuilder().build();

    ImportJob actualResponse = client.createImportJob(parent, importJobId, importJob);
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
  public void createImportJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      KeyRingName parent = KeyRingName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]");
      String importJobId = "importJobId1449444627";
      ImportJob importJob = ImportJob.newBuilder().build();
      client.createImportJob(parent, importJobId, importJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createImportJobTest2() throws Exception {
    ImportJob expectedResponse =
        ImportJob.newBuilder()
            .setName(
                ImportJobName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[IMPORT_JOB]")
                    .toString())
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setGenerateTime(Timestamp.newBuilder().build())
            .setExpireTime(Timestamp.newBuilder().build())
            .setExpireEventTime(Timestamp.newBuilder().build())
            .setPublicKey(ImportJob.WrappingPublicKey.newBuilder().build())
            .setAttestation(KeyOperationAttestation.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-7749/locations/location-7749/keyRings/keyRing-7749";
    String importJobId = "importJobId1449444627";
    ImportJob importJob = ImportJob.newBuilder().build();

    ImportJob actualResponse = client.createImportJob(parent, importJobId, importJob);
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
  public void createImportJobExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7749/locations/location-7749/keyRings/keyRing-7749";
      String importJobId = "importJobId1449444627";
      ImportJob importJob = ImportJob.newBuilder().build();
      client.createImportJob(parent, importJobId, importJob);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCryptoKeyTest() throws Exception {
    CryptoKey expectedResponse =
        CryptoKey.newBuilder()
            .setName(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setPrimary(CryptoKeyVersion.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setNextRotationTime(Timestamp.newBuilder().build())
            .setVersionTemplate(CryptoKeyVersionTemplate.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setImportOnly(true)
            .setDestroyScheduledDuration(Duration.newBuilder().build())
            .setCryptoKeyBackend(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .build();
    mockService.addResponse(expectedResponse);

    CryptoKey cryptoKey =
        CryptoKey.newBuilder()
            .setName(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setPrimary(CryptoKeyVersion.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setNextRotationTime(Timestamp.newBuilder().build())
            .setVersionTemplate(CryptoKeyVersionTemplate.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setImportOnly(true)
            .setDestroyScheduledDuration(Duration.newBuilder().build())
            .setCryptoKeyBackend(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CryptoKey actualResponse = client.updateCryptoKey(cryptoKey, updateMask);
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
  public void updateCryptoKeyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CryptoKey cryptoKey =
          CryptoKey.newBuilder()
              .setName(
                  CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                      .toString())
              .setPrimary(CryptoKeyVersion.newBuilder().build())
              .setCreateTime(Timestamp.newBuilder().build())
              .setNextRotationTime(Timestamp.newBuilder().build())
              .setVersionTemplate(CryptoKeyVersionTemplate.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setImportOnly(true)
              .setDestroyScheduledDuration(Duration.newBuilder().build())
              .setCryptoKeyBackend(
                  CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                      .toString())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCryptoKey(cryptoKey, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCryptoKeyVersionTest() throws Exception {
    CryptoKeyVersion expectedResponse =
        CryptoKeyVersion.newBuilder()
            .setName(
                CryptoKeyVersionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[KEY_RING]",
                        "[CRYPTO_KEY]",
                        "[CRYPTO_KEY_VERSION]")
                    .toString())
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .setAttestation(KeyOperationAttestation.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setGenerateTime(Timestamp.newBuilder().build())
            .setDestroyTime(Timestamp.newBuilder().build())
            .setDestroyEventTime(Timestamp.newBuilder().build())
            .setImportJob("importJob-208547368")
            .setImportTime(Timestamp.newBuilder().build())
            .setImportFailureReason("importFailureReason985493705")
            .setExternalProtectionLevelOptions(ExternalProtectionLevelOptions.newBuilder().build())
            .setReimportEligible(true)
            .build();
    mockService.addResponse(expectedResponse);

    CryptoKeyVersion cryptoKeyVersion =
        CryptoKeyVersion.newBuilder()
            .setName(
                CryptoKeyVersionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[KEY_RING]",
                        "[CRYPTO_KEY]",
                        "[CRYPTO_KEY_VERSION]")
                    .toString())
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .setAttestation(KeyOperationAttestation.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setGenerateTime(Timestamp.newBuilder().build())
            .setDestroyTime(Timestamp.newBuilder().build())
            .setDestroyEventTime(Timestamp.newBuilder().build())
            .setImportJob("importJob-208547368")
            .setImportTime(Timestamp.newBuilder().build())
            .setImportFailureReason("importFailureReason985493705")
            .setExternalProtectionLevelOptions(ExternalProtectionLevelOptions.newBuilder().build())
            .setReimportEligible(true)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    CryptoKeyVersion actualResponse = client.updateCryptoKeyVersion(cryptoKeyVersion, updateMask);
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
  public void updateCryptoKeyVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CryptoKeyVersion cryptoKeyVersion =
          CryptoKeyVersion.newBuilder()
              .setName(
                  CryptoKeyVersionName.of(
                          "[PROJECT]",
                          "[LOCATION]",
                          "[KEY_RING]",
                          "[CRYPTO_KEY]",
                          "[CRYPTO_KEY_VERSION]")
                      .toString())
              .setProtectionLevel(ProtectionLevel.forNumber(0))
              .setAttestation(KeyOperationAttestation.newBuilder().build())
              .setCreateTime(Timestamp.newBuilder().build())
              .setGenerateTime(Timestamp.newBuilder().build())
              .setDestroyTime(Timestamp.newBuilder().build())
              .setDestroyEventTime(Timestamp.newBuilder().build())
              .setImportJob("importJob-208547368")
              .setImportTime(Timestamp.newBuilder().build())
              .setImportFailureReason("importFailureReason985493705")
              .setExternalProtectionLevelOptions(
                  ExternalProtectionLevelOptions.newBuilder().build())
              .setReimportEligible(true)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCryptoKeyVersion(cryptoKeyVersion, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCryptoKeyPrimaryVersionTest() throws Exception {
    CryptoKey expectedResponse =
        CryptoKey.newBuilder()
            .setName(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setPrimary(CryptoKeyVersion.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setNextRotationTime(Timestamp.newBuilder().build())
            .setVersionTemplate(CryptoKeyVersionTemplate.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setImportOnly(true)
            .setDestroyScheduledDuration(Duration.newBuilder().build())
            .setCryptoKeyBackend(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .build();
    mockService.addResponse(expectedResponse);

    CryptoKeyName name = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
    String cryptoKeyVersionId = "cryptoKeyVersionId987674581";

    CryptoKey actualResponse = client.updateCryptoKeyPrimaryVersion(name, cryptoKeyVersionId);
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
  public void updateCryptoKeyPrimaryVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CryptoKeyName name =
          CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
      String cryptoKeyVersionId = "cryptoKeyVersionId987674581";
      client.updateCryptoKeyPrimaryVersion(name, cryptoKeyVersionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCryptoKeyPrimaryVersionTest2() throws Exception {
    CryptoKey expectedResponse =
        CryptoKey.newBuilder()
            .setName(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .setPrimary(CryptoKeyVersion.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setNextRotationTime(Timestamp.newBuilder().build())
            .setVersionTemplate(CryptoKeyVersionTemplate.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setImportOnly(true)
            .setDestroyScheduledDuration(Duration.newBuilder().build())
            .setCryptoKeyBackend(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
                    .toString())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5355/locations/location-5355/keyRings/keyRing-5355/cryptoKeys/cryptoKey-5355";
    String cryptoKeyVersionId = "cryptoKeyVersionId987674581";

    CryptoKey actualResponse = client.updateCryptoKeyPrimaryVersion(name, cryptoKeyVersionId);
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
  public void updateCryptoKeyPrimaryVersionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5355/locations/location-5355/keyRings/keyRing-5355/cryptoKeys/cryptoKey-5355";
      String cryptoKeyVersionId = "cryptoKeyVersionId987674581";
      client.updateCryptoKeyPrimaryVersion(name, cryptoKeyVersionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void destroyCryptoKeyVersionTest() throws Exception {
    CryptoKeyVersion expectedResponse =
        CryptoKeyVersion.newBuilder()
            .setName(
                CryptoKeyVersionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[KEY_RING]",
                        "[CRYPTO_KEY]",
                        "[CRYPTO_KEY_VERSION]")
                    .toString())
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .setAttestation(KeyOperationAttestation.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setGenerateTime(Timestamp.newBuilder().build())
            .setDestroyTime(Timestamp.newBuilder().build())
            .setDestroyEventTime(Timestamp.newBuilder().build())
            .setImportJob("importJob-208547368")
            .setImportTime(Timestamp.newBuilder().build())
            .setImportFailureReason("importFailureReason985493705")
            .setExternalProtectionLevelOptions(ExternalProtectionLevelOptions.newBuilder().build())
            .setReimportEligible(true)
            .build();
    mockService.addResponse(expectedResponse);

    CryptoKeyVersionName name =
        CryptoKeyVersionName.of(
            "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");

    CryptoKeyVersion actualResponse = client.destroyCryptoKeyVersion(name);
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
  public void destroyCryptoKeyVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CryptoKeyVersionName name =
          CryptoKeyVersionName.of(
              "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
      client.destroyCryptoKeyVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void destroyCryptoKeyVersionTest2() throws Exception {
    CryptoKeyVersion expectedResponse =
        CryptoKeyVersion.newBuilder()
            .setName(
                CryptoKeyVersionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[KEY_RING]",
                        "[CRYPTO_KEY]",
                        "[CRYPTO_KEY_VERSION]")
                    .toString())
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .setAttestation(KeyOperationAttestation.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setGenerateTime(Timestamp.newBuilder().build())
            .setDestroyTime(Timestamp.newBuilder().build())
            .setDestroyEventTime(Timestamp.newBuilder().build())
            .setImportJob("importJob-208547368")
            .setImportTime(Timestamp.newBuilder().build())
            .setImportFailureReason("importFailureReason985493705")
            .setExternalProtectionLevelOptions(ExternalProtectionLevelOptions.newBuilder().build())
            .setReimportEligible(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9504/locations/location-9504/keyRings/keyRing-9504/cryptoKeys/cryptoKey-9504/cryptoKeyVersions/cryptoKeyVersion-9504";

    CryptoKeyVersion actualResponse = client.destroyCryptoKeyVersion(name);
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
  public void destroyCryptoKeyVersionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9504/locations/location-9504/keyRings/keyRing-9504/cryptoKeys/cryptoKey-9504/cryptoKeyVersions/cryptoKeyVersion-9504";
      client.destroyCryptoKeyVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void restoreCryptoKeyVersionTest() throws Exception {
    CryptoKeyVersion expectedResponse =
        CryptoKeyVersion.newBuilder()
            .setName(
                CryptoKeyVersionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[KEY_RING]",
                        "[CRYPTO_KEY]",
                        "[CRYPTO_KEY_VERSION]")
                    .toString())
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .setAttestation(KeyOperationAttestation.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setGenerateTime(Timestamp.newBuilder().build())
            .setDestroyTime(Timestamp.newBuilder().build())
            .setDestroyEventTime(Timestamp.newBuilder().build())
            .setImportJob("importJob-208547368")
            .setImportTime(Timestamp.newBuilder().build())
            .setImportFailureReason("importFailureReason985493705")
            .setExternalProtectionLevelOptions(ExternalProtectionLevelOptions.newBuilder().build())
            .setReimportEligible(true)
            .build();
    mockService.addResponse(expectedResponse);

    CryptoKeyVersionName name =
        CryptoKeyVersionName.of(
            "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");

    CryptoKeyVersion actualResponse = client.restoreCryptoKeyVersion(name);
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
  public void restoreCryptoKeyVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CryptoKeyVersionName name =
          CryptoKeyVersionName.of(
              "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
      client.restoreCryptoKeyVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void restoreCryptoKeyVersionTest2() throws Exception {
    CryptoKeyVersion expectedResponse =
        CryptoKeyVersion.newBuilder()
            .setName(
                CryptoKeyVersionName.of(
                        "[PROJECT]",
                        "[LOCATION]",
                        "[KEY_RING]",
                        "[CRYPTO_KEY]",
                        "[CRYPTO_KEY_VERSION]")
                    .toString())
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .setAttestation(KeyOperationAttestation.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setGenerateTime(Timestamp.newBuilder().build())
            .setDestroyTime(Timestamp.newBuilder().build())
            .setDestroyEventTime(Timestamp.newBuilder().build())
            .setImportJob("importJob-208547368")
            .setImportTime(Timestamp.newBuilder().build())
            .setImportFailureReason("importFailureReason985493705")
            .setExternalProtectionLevelOptions(ExternalProtectionLevelOptions.newBuilder().build())
            .setReimportEligible(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9504/locations/location-9504/keyRings/keyRing-9504/cryptoKeys/cryptoKey-9504/cryptoKeyVersions/cryptoKeyVersion-9504";

    CryptoKeyVersion actualResponse = client.restoreCryptoKeyVersion(name);
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
  public void restoreCryptoKeyVersionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9504/locations/location-9504/keyRings/keyRing-9504/cryptoKeys/cryptoKey-9504/cryptoKeyVersions/cryptoKeyVersion-9504";
      client.restoreCryptoKeyVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void encryptTest() throws Exception {
    EncryptResponse expectedResponse =
        EncryptResponse.newBuilder()
            .setName("name3373707")
            .setCiphertext(ByteString.EMPTY)
            .setCiphertextCrc32C(Int64Value.newBuilder().build())
            .setVerifiedPlaintextCrc32C(true)
            .setVerifiedAdditionalAuthenticatedDataCrc32C(true)
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    ResourceName name = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
    ByteString plaintext = ByteString.EMPTY;

    EncryptResponse actualResponse = client.encrypt(name, plaintext);
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
  public void encryptExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ResourceName name = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
      ByteString plaintext = ByteString.EMPTY;
      client.encrypt(name, plaintext);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void encryptTest2() throws Exception {
    EncryptResponse expectedResponse =
        EncryptResponse.newBuilder()
            .setName("name3373707")
            .setCiphertext(ByteString.EMPTY)
            .setCiphertextCrc32C(Int64Value.newBuilder().build())
            .setVerifiedPlaintextCrc32C(true)
            .setVerifiedAdditionalAuthenticatedDataCrc32C(true)
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4975/locations/location-4975/keyRings/keyRing-4975/cryptoKeys/cryptoKey-4975";
    ByteString plaintext = ByteString.EMPTY;

    EncryptResponse actualResponse = client.encrypt(name, plaintext);
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
  public void encryptExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4975/locations/location-4975/keyRings/keyRing-4975/cryptoKeys/cryptoKey-4975";
      ByteString plaintext = ByteString.EMPTY;
      client.encrypt(name, plaintext);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void decryptTest() throws Exception {
    DecryptResponse expectedResponse =
        DecryptResponse.newBuilder()
            .setPlaintext(ByteString.EMPTY)
            .setPlaintextCrc32C(Int64Value.newBuilder().build())
            .setUsedPrimary(true)
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    CryptoKeyName name = CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
    ByteString ciphertext = ByteString.EMPTY;

    DecryptResponse actualResponse = client.decrypt(name, ciphertext);
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
  public void decryptExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CryptoKeyName name =
          CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]");
      ByteString ciphertext = ByteString.EMPTY;
      client.decrypt(name, ciphertext);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void decryptTest2() throws Exception {
    DecryptResponse expectedResponse =
        DecryptResponse.newBuilder()
            .setPlaintext(ByteString.EMPTY)
            .setPlaintextCrc32C(Int64Value.newBuilder().build())
            .setUsedPrimary(true)
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5355/locations/location-5355/keyRings/keyRing-5355/cryptoKeys/cryptoKey-5355";
    ByteString ciphertext = ByteString.EMPTY;

    DecryptResponse actualResponse = client.decrypt(name, ciphertext);
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
  public void decryptExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5355/locations/location-5355/keyRings/keyRing-5355/cryptoKeys/cryptoKey-5355";
      ByteString ciphertext = ByteString.EMPTY;
      client.decrypt(name, ciphertext);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void asymmetricSignTest() throws Exception {
    AsymmetricSignResponse expectedResponse =
        AsymmetricSignResponse.newBuilder()
            .setSignature(ByteString.EMPTY)
            .setSignatureCrc32C(Int64Value.newBuilder().build())
            .setVerifiedDigestCrc32C(true)
            .setName("name3373707")
            .setVerifiedDataCrc32C(true)
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    CryptoKeyVersionName name =
        CryptoKeyVersionName.of(
            "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
    Digest digest = Digest.newBuilder().build();

    AsymmetricSignResponse actualResponse = client.asymmetricSign(name, digest);
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
  public void asymmetricSignExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CryptoKeyVersionName name =
          CryptoKeyVersionName.of(
              "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
      Digest digest = Digest.newBuilder().build();
      client.asymmetricSign(name, digest);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void asymmetricSignTest2() throws Exception {
    AsymmetricSignResponse expectedResponse =
        AsymmetricSignResponse.newBuilder()
            .setSignature(ByteString.EMPTY)
            .setSignatureCrc32C(Int64Value.newBuilder().build())
            .setVerifiedDigestCrc32C(true)
            .setName("name3373707")
            .setVerifiedDataCrc32C(true)
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9504/locations/location-9504/keyRings/keyRing-9504/cryptoKeys/cryptoKey-9504/cryptoKeyVersions/cryptoKeyVersion-9504";
    Digest digest = Digest.newBuilder().build();

    AsymmetricSignResponse actualResponse = client.asymmetricSign(name, digest);
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
  public void asymmetricSignExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9504/locations/location-9504/keyRings/keyRing-9504/cryptoKeys/cryptoKey-9504/cryptoKeyVersions/cryptoKeyVersion-9504";
      Digest digest = Digest.newBuilder().build();
      client.asymmetricSign(name, digest);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void asymmetricDecryptTest() throws Exception {
    AsymmetricDecryptResponse expectedResponse =
        AsymmetricDecryptResponse.newBuilder()
            .setPlaintext(ByteString.EMPTY)
            .setPlaintextCrc32C(Int64Value.newBuilder().build())
            .setVerifiedCiphertextCrc32C(true)
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    CryptoKeyVersionName name =
        CryptoKeyVersionName.of(
            "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
    ByteString ciphertext = ByteString.EMPTY;

    AsymmetricDecryptResponse actualResponse = client.asymmetricDecrypt(name, ciphertext);
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
  public void asymmetricDecryptExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CryptoKeyVersionName name =
          CryptoKeyVersionName.of(
              "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
      ByteString ciphertext = ByteString.EMPTY;
      client.asymmetricDecrypt(name, ciphertext);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void asymmetricDecryptTest2() throws Exception {
    AsymmetricDecryptResponse expectedResponse =
        AsymmetricDecryptResponse.newBuilder()
            .setPlaintext(ByteString.EMPTY)
            .setPlaintextCrc32C(Int64Value.newBuilder().build())
            .setVerifiedCiphertextCrc32C(true)
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9504/locations/location-9504/keyRings/keyRing-9504/cryptoKeys/cryptoKey-9504/cryptoKeyVersions/cryptoKeyVersion-9504";
    ByteString ciphertext = ByteString.EMPTY;

    AsymmetricDecryptResponse actualResponse = client.asymmetricDecrypt(name, ciphertext);
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
  public void asymmetricDecryptExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9504/locations/location-9504/keyRings/keyRing-9504/cryptoKeys/cryptoKey-9504/cryptoKeyVersions/cryptoKeyVersion-9504";
      ByteString ciphertext = ByteString.EMPTY;
      client.asymmetricDecrypt(name, ciphertext);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void macSignTest() throws Exception {
    MacSignResponse expectedResponse =
        MacSignResponse.newBuilder()
            .setName("name3373707")
            .setMac(ByteString.EMPTY)
            .setMacCrc32C(Int64Value.newBuilder().build())
            .setVerifiedDataCrc32C(true)
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    CryptoKeyVersionName name =
        CryptoKeyVersionName.of(
            "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
    ByteString data = ByteString.EMPTY;

    MacSignResponse actualResponse = client.macSign(name, data);
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
  public void macSignExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CryptoKeyVersionName name =
          CryptoKeyVersionName.of(
              "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
      ByteString data = ByteString.EMPTY;
      client.macSign(name, data);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void macSignTest2() throws Exception {
    MacSignResponse expectedResponse =
        MacSignResponse.newBuilder()
            .setName("name3373707")
            .setMac(ByteString.EMPTY)
            .setMacCrc32C(Int64Value.newBuilder().build())
            .setVerifiedDataCrc32C(true)
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9504/locations/location-9504/keyRings/keyRing-9504/cryptoKeys/cryptoKey-9504/cryptoKeyVersions/cryptoKeyVersion-9504";
    ByteString data = ByteString.EMPTY;

    MacSignResponse actualResponse = client.macSign(name, data);
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
  public void macSignExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9504/locations/location-9504/keyRings/keyRing-9504/cryptoKeys/cryptoKey-9504/cryptoKeyVersions/cryptoKeyVersion-9504";
      ByteString data = ByteString.EMPTY;
      client.macSign(name, data);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void macVerifyTest() throws Exception {
    MacVerifyResponse expectedResponse =
        MacVerifyResponse.newBuilder()
            .setName("name3373707")
            .setSuccess(true)
            .setVerifiedDataCrc32C(true)
            .setVerifiedMacCrc32C(true)
            .setVerifiedSuccessIntegrity(true)
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    CryptoKeyVersionName name =
        CryptoKeyVersionName.of(
            "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
    ByteString data = ByteString.EMPTY;
    ByteString mac = ByteString.EMPTY;

    MacVerifyResponse actualResponse = client.macVerify(name, data, mac);
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
  public void macVerifyExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CryptoKeyVersionName name =
          CryptoKeyVersionName.of(
              "[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]", "[CRYPTO_KEY_VERSION]");
      ByteString data = ByteString.EMPTY;
      ByteString mac = ByteString.EMPTY;
      client.macVerify(name, data, mac);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void macVerifyTest2() throws Exception {
    MacVerifyResponse expectedResponse =
        MacVerifyResponse.newBuilder()
            .setName("name3373707")
            .setSuccess(true)
            .setVerifiedDataCrc32C(true)
            .setVerifiedMacCrc32C(true)
            .setVerifiedSuccessIntegrity(true)
            .setProtectionLevel(ProtectionLevel.forNumber(0))
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9504/locations/location-9504/keyRings/keyRing-9504/cryptoKeys/cryptoKey-9504/cryptoKeyVersions/cryptoKeyVersion-9504";
    ByteString data = ByteString.EMPTY;
    ByteString mac = ByteString.EMPTY;

    MacVerifyResponse actualResponse = client.macVerify(name, data, mac);
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
  public void macVerifyExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9504/locations/location-9504/keyRings/keyRing-9504/cryptoKeys/cryptoKey-9504/cryptoKeyVersions/cryptoKeyVersion-9504";
      ByteString data = ByteString.EMPTY;
      ByteString mac = ByteString.EMPTY;
      client.macVerify(name, data, mac);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateRandomBytesTest() throws Exception {
    GenerateRandomBytesResponse expectedResponse =
        GenerateRandomBytesResponse.newBuilder()
            .setData(ByteString.EMPTY)
            .setDataCrc32C(Int64Value.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String location = "projects/project-7132/locations/location-7132";
    int lengthBytes = -745661998;
    ProtectionLevel protectionLevel = ProtectionLevel.forNumber(0);

    GenerateRandomBytesResponse actualResponse =
        client.generateRandomBytes(location, lengthBytes, protectionLevel);
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
  public void generateRandomBytesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String location = "projects/project-7132/locations/location-7132";
      int lengthBytes = -745661998;
      ProtectionLevel protectionLevel = ProtectionLevel.forNumber(0);
      client.generateRandomBytes(location, lengthBytes, protectionLevel);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
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
    mockService.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("projects/project-3664")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

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
  public void listLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("projects/project-3664")
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
    mockService.addResponse(expectedResponse);

    GetLocationRequest request =
        GetLocationRequest.newBuilder()
            .setName("projects/project-9062/locations/location-9062")
            .build();

    Location actualResponse = client.getLocation(request);
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
  public void getLocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetLocationRequest request =
          GetLocationRequest.newBuilder()
              .setName("projects/project-9062/locations/location-9062")
              .build();
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
    mockService.addResponse(expectedResponse);

    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
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
                  CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
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
    mockService.addResponse(expectedResponse);

    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
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
                  CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
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
    mockService.addResponse(expectedResponse);

    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(
                CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
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
                  CryptoKeyName.of("[PROJECT]", "[LOCATION]", "[KEY_RING]", "[CRYPTO_KEY]")
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
