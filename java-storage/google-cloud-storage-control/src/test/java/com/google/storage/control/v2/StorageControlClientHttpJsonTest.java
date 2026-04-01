/*
 * Copyright 2026 Google LLC
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

package com.google.storage.control.v2;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.storage.control.v2.stub.HttpJsonStorageControlStub;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class StorageControlClientHttpJsonTest {
  private static MockHttpService mockService;
  private static StorageControlClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonStorageControlStub.getMethodDescriptors(),
            StorageControlSettings.getDefaultEndpoint());
    StorageControlSettings settings =
        StorageControlSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                StorageControlSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = StorageControlClient.create(settings);
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
  public void createFolderUnsupportedMethodTest() throws Exception {
    // The createFolder() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void deleteFolderUnsupportedMethodTest() throws Exception {
    // The deleteFolder() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void getFolderUnsupportedMethodTest() throws Exception {
    // The getFolder() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void listFoldersUnsupportedMethodTest() throws Exception {
    // The listFolders() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void renameFolderUnsupportedMethodTest() throws Exception {
    // The renameFolder() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void deleteFolderRecursiveUnsupportedMethodTest() throws Exception {
    // The deleteFolderRecursive() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void getStorageLayoutUnsupportedMethodTest() throws Exception {
    // The getStorageLayout() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void createManagedFolderUnsupportedMethodTest() throws Exception {
    // The createManagedFolder() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void deleteManagedFolderUnsupportedMethodTest() throws Exception {
    // The deleteManagedFolder() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void getManagedFolderUnsupportedMethodTest() throws Exception {
    // The getManagedFolder() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void listManagedFoldersUnsupportedMethodTest() throws Exception {
    // The listManagedFolders() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void createAnywhereCacheUnsupportedMethodTest() throws Exception {
    // The createAnywhereCache() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void updateAnywhereCacheUnsupportedMethodTest() throws Exception {
    // The updateAnywhereCache() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void disableAnywhereCacheUnsupportedMethodTest() throws Exception {
    // The disableAnywhereCache() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void pauseAnywhereCacheUnsupportedMethodTest() throws Exception {
    // The pauseAnywhereCache() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void resumeAnywhereCacheUnsupportedMethodTest() throws Exception {
    // The resumeAnywhereCache() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void getAnywhereCacheUnsupportedMethodTest() throws Exception {
    // The getAnywhereCache() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void listAnywhereCachesUnsupportedMethodTest() throws Exception {
    // The listAnywhereCaches() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void getProjectIntelligenceConfigTest() throws Exception {
    IntelligenceConfig expectedResponse =
        IntelligenceConfig.newBuilder()
            .setName(
                IntelligenceConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFilter(IntelligenceConfig.Filter.newBuilder().build())
            .setEffectiveIntelligenceConfig(
                IntelligenceConfig.EffectiveIntelligenceConfig.newBuilder().build())
            .setTrialConfig(IntelligenceConfig.TrialConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    IntelligenceConfigName name =
        IntelligenceConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]");

    IntelligenceConfig actualResponse = client.getProjectIntelligenceConfig(name);
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
  public void getProjectIntelligenceConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IntelligenceConfigName name =
          IntelligenceConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]");
      client.getProjectIntelligenceConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getProjectIntelligenceConfigTest2() throws Exception {
    IntelligenceConfig expectedResponse =
        IntelligenceConfig.newBuilder()
            .setName(
                IntelligenceConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFilter(IntelligenceConfig.Filter.newBuilder().build())
            .setEffectiveIntelligenceConfig(
                IntelligenceConfig.EffectiveIntelligenceConfig.newBuilder().build())
            .setTrialConfig(IntelligenceConfig.TrialConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-8842/locations/location-8842/intelligenceConfig";

    IntelligenceConfig actualResponse = client.getProjectIntelligenceConfig(name);
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
  public void getProjectIntelligenceConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-8842/locations/location-8842/intelligenceConfig";
      client.getProjectIntelligenceConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateProjectIntelligenceConfigTest() throws Exception {
    IntelligenceConfig expectedResponse =
        IntelligenceConfig.newBuilder()
            .setName(
                IntelligenceConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFilter(IntelligenceConfig.Filter.newBuilder().build())
            .setEffectiveIntelligenceConfig(
                IntelligenceConfig.EffectiveIntelligenceConfig.newBuilder().build())
            .setTrialConfig(IntelligenceConfig.TrialConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    IntelligenceConfig intelligenceConfig =
        IntelligenceConfig.newBuilder()
            .setName(
                IntelligenceConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFilter(IntelligenceConfig.Filter.newBuilder().build())
            .setEffectiveIntelligenceConfig(
                IntelligenceConfig.EffectiveIntelligenceConfig.newBuilder().build())
            .setTrialConfig(IntelligenceConfig.TrialConfig.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    IntelligenceConfig actualResponse =
        client.updateProjectIntelligenceConfig(intelligenceConfig, updateMask);
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
  public void updateProjectIntelligenceConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IntelligenceConfig intelligenceConfig =
          IntelligenceConfig.newBuilder()
              .setName(
                  IntelligenceConfigName.ofProjectLocationName("[PROJECT]", "[LOCATION]")
                      .toString())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setFilter(IntelligenceConfig.Filter.newBuilder().build())
              .setEffectiveIntelligenceConfig(
                  IntelligenceConfig.EffectiveIntelligenceConfig.newBuilder().build())
              .setTrialConfig(IntelligenceConfig.TrialConfig.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateProjectIntelligenceConfig(intelligenceConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFolderIntelligenceConfigTest() throws Exception {
    IntelligenceConfig expectedResponse =
        IntelligenceConfig.newBuilder()
            .setName(
                IntelligenceConfigName.ofFolderLocationName("[FOLDER]", "[LOCATION]").toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFilter(IntelligenceConfig.Filter.newBuilder().build())
            .setEffectiveIntelligenceConfig(
                IntelligenceConfig.EffectiveIntelligenceConfig.newBuilder().build())
            .setTrialConfig(IntelligenceConfig.TrialConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    IntelligenceConfigName name =
        IntelligenceConfigName.ofFolderLocationName("[FOLDER]", "[LOCATION]");

    IntelligenceConfig actualResponse = client.getFolderIntelligenceConfig(name);
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
  public void getFolderIntelligenceConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IntelligenceConfigName name =
          IntelligenceConfigName.ofFolderLocationName("[FOLDER]", "[LOCATION]");
      client.getFolderIntelligenceConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFolderIntelligenceConfigTest2() throws Exception {
    IntelligenceConfig expectedResponse =
        IntelligenceConfig.newBuilder()
            .setName(
                IntelligenceConfigName.ofFolderLocationName("[FOLDER]", "[LOCATION]").toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFilter(IntelligenceConfig.Filter.newBuilder().build())
            .setEffectiveIntelligenceConfig(
                IntelligenceConfig.EffectiveIntelligenceConfig.newBuilder().build())
            .setTrialConfig(IntelligenceConfig.TrialConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "folders/folder-8383/locations/location-8383/intelligenceConfig";

    IntelligenceConfig actualResponse = client.getFolderIntelligenceConfig(name);
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
  public void getFolderIntelligenceConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "folders/folder-8383/locations/location-8383/intelligenceConfig";
      client.getFolderIntelligenceConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateFolderIntelligenceConfigTest() throws Exception {
    IntelligenceConfig expectedResponse =
        IntelligenceConfig.newBuilder()
            .setName(
                IntelligenceConfigName.ofFolderLocationName("[FOLDER]", "[LOCATION]").toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFilter(IntelligenceConfig.Filter.newBuilder().build())
            .setEffectiveIntelligenceConfig(
                IntelligenceConfig.EffectiveIntelligenceConfig.newBuilder().build())
            .setTrialConfig(IntelligenceConfig.TrialConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    IntelligenceConfig intelligenceConfig =
        IntelligenceConfig.newBuilder()
            .setName(
                IntelligenceConfigName.ofFolderLocationName("[FOLDER]", "[LOCATION]").toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFilter(IntelligenceConfig.Filter.newBuilder().build())
            .setEffectiveIntelligenceConfig(
                IntelligenceConfig.EffectiveIntelligenceConfig.newBuilder().build())
            .setTrialConfig(IntelligenceConfig.TrialConfig.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    IntelligenceConfig actualResponse =
        client.updateFolderIntelligenceConfig(intelligenceConfig, updateMask);
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
  public void updateFolderIntelligenceConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IntelligenceConfig intelligenceConfig =
          IntelligenceConfig.newBuilder()
              .setName(
                  IntelligenceConfigName.ofFolderLocationName("[FOLDER]", "[LOCATION]").toString())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setFilter(IntelligenceConfig.Filter.newBuilder().build())
              .setEffectiveIntelligenceConfig(
                  IntelligenceConfig.EffectiveIntelligenceConfig.newBuilder().build())
              .setTrialConfig(IntelligenceConfig.TrialConfig.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFolderIntelligenceConfig(intelligenceConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOrganizationIntelligenceConfigTest() throws Exception {
    IntelligenceConfig expectedResponse =
        IntelligenceConfig.newBuilder()
            .setName(IntelligenceConfigName.ofOrgLocationName("[ORG]", "[LOCATION]").toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFilter(IntelligenceConfig.Filter.newBuilder().build())
            .setEffectiveIntelligenceConfig(
                IntelligenceConfig.EffectiveIntelligenceConfig.newBuilder().build())
            .setTrialConfig(IntelligenceConfig.TrialConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    IntelligenceConfigName name = IntelligenceConfigName.ofOrgLocationName("[ORG]", "[LOCATION]");

    IntelligenceConfig actualResponse = client.getOrganizationIntelligenceConfig(name);
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
  public void getOrganizationIntelligenceConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IntelligenceConfigName name = IntelligenceConfigName.ofOrgLocationName("[ORG]", "[LOCATION]");
      client.getOrganizationIntelligenceConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getOrganizationIntelligenceConfigTest2() throws Exception {
    IntelligenceConfig expectedResponse =
        IntelligenceConfig.newBuilder()
            .setName(IntelligenceConfigName.ofOrgLocationName("[ORG]", "[LOCATION]").toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFilter(IntelligenceConfig.Filter.newBuilder().build())
            .setEffectiveIntelligenceConfig(
                IntelligenceConfig.EffectiveIntelligenceConfig.newBuilder().build())
            .setTrialConfig(IntelligenceConfig.TrialConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "organizations/organization-1958/locations/location-1958/intelligenceConfig";

    IntelligenceConfig actualResponse = client.getOrganizationIntelligenceConfig(name);
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
  public void getOrganizationIntelligenceConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "organizations/organization-1958/locations/location-1958/intelligenceConfig";
      client.getOrganizationIntelligenceConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateOrganizationIntelligenceConfigTest() throws Exception {
    IntelligenceConfig expectedResponse =
        IntelligenceConfig.newBuilder()
            .setName(IntelligenceConfigName.ofOrgLocationName("[ORG]", "[LOCATION]").toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFilter(IntelligenceConfig.Filter.newBuilder().build())
            .setEffectiveIntelligenceConfig(
                IntelligenceConfig.EffectiveIntelligenceConfig.newBuilder().build())
            .setTrialConfig(IntelligenceConfig.TrialConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    IntelligenceConfig intelligenceConfig =
        IntelligenceConfig.newBuilder()
            .setName(IntelligenceConfigName.ofOrgLocationName("[ORG]", "[LOCATION]").toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFilter(IntelligenceConfig.Filter.newBuilder().build())
            .setEffectiveIntelligenceConfig(
                IntelligenceConfig.EffectiveIntelligenceConfig.newBuilder().build())
            .setTrialConfig(IntelligenceConfig.TrialConfig.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    IntelligenceConfig actualResponse =
        client.updateOrganizationIntelligenceConfig(intelligenceConfig, updateMask);
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
  public void updateOrganizationIntelligenceConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IntelligenceConfig intelligenceConfig =
          IntelligenceConfig.newBuilder()
              .setName(IntelligenceConfigName.ofOrgLocationName("[ORG]", "[LOCATION]").toString())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setFilter(IntelligenceConfig.Filter.newBuilder().build())
              .setEffectiveIntelligenceConfig(
                  IntelligenceConfig.EffectiveIntelligenceConfig.newBuilder().build())
              .setTrialConfig(IntelligenceConfig.TrialConfig.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateOrganizationIntelligenceConfig(intelligenceConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyUnsupportedMethodTest() throws Exception {
    // The getIamPolicy() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void setIamPolicyUnsupportedMethodTest() throws Exception {
    // The setIamPolicy() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void testIamPermissionsUnsupportedMethodTest() throws Exception {
    // The testIamPermissions() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }
}
