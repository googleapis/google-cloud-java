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

import static com.google.storage.control.v2.StorageControlClient.ListFoldersPagedResponse;
import static com.google.storage.control.v2.StorageControlClient.ListIntelligenceFindingRevisionsPagedResponse;
import static com.google.storage.control.v2.StorageControlClient.ListIntelligenceFindingsPagedResponse;
import static com.google.storage.control.v2.StorageControlClient.SummarizeIntelligenceFindingsPagedResponse;

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
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.storage.control.v2.stub.HttpJsonStorageControlStub;
import com.google.type.Interval;
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
  public void createFolderTest() throws Exception {
    Folder expectedResponse =
        Folder.newBuilder()
            .setName(FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]").toString())
            .setMetageneration(1048558813)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPendingRenameInfo(PendingRenameInfo.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    BucketName parent = BucketName.of("[PROJECT]", "[BUCKET]");
    Folder folder = Folder.newBuilder().build();
    String folderId = "folderId294109737";

    Folder actualResponse = client.createFolder(parent, folder, folderId);
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
  public void createFolderExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BucketName parent = BucketName.of("[PROJECT]", "[BUCKET]");
      Folder folder = Folder.newBuilder().build();
      String folderId = "folderId294109737";
      client.createFolder(parent, folder, folderId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFolderTest2() throws Exception {
    Folder expectedResponse =
        Folder.newBuilder()
            .setName(FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]").toString())
            .setMetageneration(1048558813)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPendingRenameInfo(PendingRenameInfo.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-1468/buckets/bucket-1468";
    Folder folder = Folder.newBuilder().build();
    String folderId = "folderId294109737";

    Folder actualResponse = client.createFolder(parent, folder, folderId);
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
  public void createFolderExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-1468/buckets/bucket-1468";
      Folder folder = Folder.newBuilder().build();
      String folderId = "folderId294109737";
      client.createFolder(parent, folder, folderId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteFolderTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    FolderName name = FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]");

    client.deleteFolder(name);

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
  public void deleteFolderExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FolderName name = FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]");
      client.deleteFolder(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteFolderTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3692/buckets/bucket-3692/folders/folder-3692";

    client.deleteFolder(name);

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
  public void deleteFolderExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3692/buckets/bucket-3692/folders/folder-3692";
      client.deleteFolder(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFolderTest() throws Exception {
    Folder expectedResponse =
        Folder.newBuilder()
            .setName(FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]").toString())
            .setMetageneration(1048558813)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPendingRenameInfo(PendingRenameInfo.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    FolderName name = FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]");

    Folder actualResponse = client.getFolder(name);
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
  public void getFolderExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FolderName name = FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]");
      client.getFolder(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFolderTest2() throws Exception {
    Folder expectedResponse =
        Folder.newBuilder()
            .setName(FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]").toString())
            .setMetageneration(1048558813)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPendingRenameInfo(PendingRenameInfo.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3692/buckets/bucket-3692/folders/folder-3692";

    Folder actualResponse = client.getFolder(name);
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
  public void getFolderExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3692/buckets/bucket-3692/folders/folder-3692";
      client.getFolder(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFoldersTest() throws Exception {
    Folder responsesElement = Folder.newBuilder().build();
    ListFoldersResponse expectedResponse =
        ListFoldersResponse.newBuilder()
            .setNextPageToken("")
            .addAllFolders(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    BucketName parent = BucketName.of("[PROJECT]", "[BUCKET]");

    ListFoldersPagedResponse pagedListResponse = client.listFolders(parent);

    List<Folder> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFoldersList().get(0), resources.get(0));

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
  public void listFoldersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      BucketName parent = BucketName.of("[PROJECT]", "[BUCKET]");
      client.listFolders(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFoldersTest2() throws Exception {
    Folder responsesElement = Folder.newBuilder().build();
    ListFoldersResponse expectedResponse =
        ListFoldersResponse.newBuilder()
            .setNextPageToken("")
            .addAllFolders(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-1468/buckets/bucket-1468";

    ListFoldersPagedResponse pagedListResponse = client.listFolders(parent);

    List<Folder> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFoldersList().get(0), resources.get(0));

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
  public void listFoldersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-1468/buckets/bucket-1468";
      client.listFolders(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void renameFolderTest() throws Exception {
    Folder expectedResponse =
        Folder.newBuilder()
            .setName(FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]").toString())
            .setMetageneration(1048558813)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPendingRenameInfo(PendingRenameInfo.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("renameFolderTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    FolderName name = FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]");
    String destinationFolderId = "destinationFolderId-480084905";

    Folder actualResponse = client.renameFolderAsync(name, destinationFolderId).get();
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
  public void renameFolderExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FolderName name = FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]");
      String destinationFolderId = "destinationFolderId-480084905";
      client.renameFolderAsync(name, destinationFolderId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void renameFolderTest2() throws Exception {
    Folder expectedResponse =
        Folder.newBuilder()
            .setName(FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]").toString())
            .setMetageneration(1048558813)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setPendingRenameInfo(PendingRenameInfo.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("renameFolderTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-3692/buckets/bucket-3692/folders/folder-3692";
    String destinationFolderId = "destinationFolderId-480084905";

    Folder actualResponse = client.renameFolderAsync(name, destinationFolderId).get();
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
  public void renameFolderExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3692/buckets/bucket-3692/folders/folder-3692";
      String destinationFolderId = "destinationFolderId-480084905";
      client.renameFolderAsync(name, destinationFolderId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteFolderRecursiveTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFolderRecursiveTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    FolderName name = FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]");

    client.deleteFolderRecursiveAsync(name).get();

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
  public void deleteFolderRecursiveExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FolderName name = FolderName.of("[PROJECT]", "[BUCKET]", "[FOLDER]");
      client.deleteFolderRecursiveAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteFolderRecursiveTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteFolderRecursiveTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-3692/buckets/bucket-3692/folders/folder-3692";

    client.deleteFolderRecursiveAsync(name).get();

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
  public void deleteFolderRecursiveExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3692/buckets/bucket-3692/folders/folder-3692";
      client.deleteFolderRecursiveAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getStorageLayoutTest() throws Exception {
    StorageLayout expectedResponse =
        StorageLayout.newBuilder()
            .setName(StorageLayoutName.of("[PROJECT]", "[BUCKET]").toString())
            .setLocation("location1901043637")
            .setLocationType("locationType-58277745")
            .setCustomPlacementConfig(StorageLayout.CustomPlacementConfig.newBuilder().build())
            .setHierarchicalNamespace(StorageLayout.HierarchicalNamespace.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    StorageLayoutName name = StorageLayoutName.of("[PROJECT]", "[BUCKET]");

    StorageLayout actualResponse = client.getStorageLayout(name);
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
  public void getStorageLayoutExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      StorageLayoutName name = StorageLayoutName.of("[PROJECT]", "[BUCKET]");
      client.getStorageLayout(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getStorageLayoutTest2() throws Exception {
    StorageLayout expectedResponse =
        StorageLayout.newBuilder()
            .setName(StorageLayoutName.of("[PROJECT]", "[BUCKET]").toString())
            .setLocation("location1901043637")
            .setLocationType("locationType-58277745")
            .setCustomPlacementConfig(StorageLayout.CustomPlacementConfig.newBuilder().build())
            .setHierarchicalNamespace(StorageLayout.HierarchicalNamespace.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9051/buckets/bucket-9051/storageLayout";

    StorageLayout actualResponse = client.getStorageLayout(name);
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
  public void getStorageLayoutExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9051/buckets/bucket-9051/storageLayout";
      client.getStorageLayout(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
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
  public void updateManagedFolderUnsupportedMethodTest() throws Exception {
    // The updateManagedFolder() method is not supported in REST transport.
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
  public void createRapidCacheUnsupportedMethodTest() throws Exception {
    // The createRapidCache() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void updateRapidCacheUnsupportedMethodTest() throws Exception {
    // The updateRapidCache() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void getRapidCacheUnsupportedMethodTest() throws Exception {
    // The getRapidCache() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void listRapidCachesUnsupportedMethodTest() throws Exception {
    // The listRapidCaches() method is not supported in REST transport.
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

  @Test
  public void getIntelligenceFindingTest() throws Exception {
    IntelligenceFinding expectedResponse =
        IntelligenceFinding.newBuilder()
            .setName(
                IntelligenceFindingName.of("[PROJECT]", "[LOCATION]", "[INTELLIGENCE_FINDING]")
                    .toString())
            .setDescription("description-1724546052")
            .setType(FindingType.forNumber(0))
            .setCategory(FindingCategory.forNumber(0))
            .setSeverity(FindingSeverity.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setTargetResource("targetResource-1933150017")
            .addAllAssociatedResources(new ArrayList<String>())
            .setObservationPeriod(Interval.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    IntelligenceFindingName name =
        IntelligenceFindingName.of("[PROJECT]", "[LOCATION]", "[INTELLIGENCE_FINDING]");

    IntelligenceFinding actualResponse = client.getIntelligenceFinding(name);
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
  public void getIntelligenceFindingExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IntelligenceFindingName name =
          IntelligenceFindingName.of("[PROJECT]", "[LOCATION]", "[INTELLIGENCE_FINDING]");
      client.getIntelligenceFinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIntelligenceFindingTest2() throws Exception {
    IntelligenceFinding expectedResponse =
        IntelligenceFinding.newBuilder()
            .setName(
                IntelligenceFindingName.of("[PROJECT]", "[LOCATION]", "[INTELLIGENCE_FINDING]")
                    .toString())
            .setDescription("description-1724546052")
            .setType(FindingType.forNumber(0))
            .setCategory(FindingCategory.forNumber(0))
            .setSeverity(FindingSeverity.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setTargetResource("targetResource-1933150017")
            .addAllAssociatedResources(new ArrayList<String>())
            .setObservationPeriod(Interval.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4423/locations/location-4423/intelligenceFindings/intelligenceFinding-4423";

    IntelligenceFinding actualResponse = client.getIntelligenceFinding(name);
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
  public void getIntelligenceFindingExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4423/locations/location-4423/intelligenceFindings/intelligenceFinding-4423";
      client.getIntelligenceFinding(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIntelligenceFindingsTest() throws Exception {
    IntelligenceFinding responsesElement = IntelligenceFinding.newBuilder().build();
    ListIntelligenceFindingsResponse expectedResponse =
        ListIntelligenceFindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllIntelligenceFindings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListIntelligenceFindingsPagedResponse pagedListResponse =
        client.listIntelligenceFindings(parent);

    List<IntelligenceFinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIntelligenceFindingsList().get(0), resources.get(0));

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
  public void listIntelligenceFindingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listIntelligenceFindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIntelligenceFindingsTest2() throws Exception {
    IntelligenceFinding responsesElement = IntelligenceFinding.newBuilder().build();
    ListIntelligenceFindingsResponse expectedResponse =
        ListIntelligenceFindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllIntelligenceFindings(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListIntelligenceFindingsPagedResponse pagedListResponse =
        client.listIntelligenceFindings(parent);

    List<IntelligenceFinding> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIntelligenceFindingsList().get(0), resources.get(0));

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
  public void listIntelligenceFindingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listIntelligenceFindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void summarizeIntelligenceFindingsTest() throws Exception {
    FindingSummary responsesElement = FindingSummary.newBuilder().build();
    SummarizeIntelligenceFindingsResponse expectedResponse =
        SummarizeIntelligenceFindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFindingSummaries(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    SummarizeIntelligenceFindingsPagedResponse pagedListResponse =
        client.summarizeIntelligenceFindings(parent);

    List<FindingSummary> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFindingSummariesList().get(0), resources.get(0));

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
  public void summarizeIntelligenceFindingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.summarizeIntelligenceFindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIntelligenceFindingRevisionTest() throws Exception {
    IntelligenceFindingRevision expectedResponse =
        IntelligenceFindingRevision.newBuilder()
            .setName(
                IntelligenceFindingRevisionName.of(
                        "[PROJECT]", "[LOCATION]", "[INTELLIGENCE_FINDING]", "[REVISION]")
                    .toString())
            .setSnapshot(IntelligenceFinding.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    IntelligenceFindingRevisionName name =
        IntelligenceFindingRevisionName.of(
            "[PROJECT]", "[LOCATION]", "[INTELLIGENCE_FINDING]", "[REVISION]");

    IntelligenceFindingRevision actualResponse = client.getIntelligenceFindingRevision(name);
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
  public void getIntelligenceFindingRevisionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IntelligenceFindingRevisionName name =
          IntelligenceFindingRevisionName.of(
              "[PROJECT]", "[LOCATION]", "[INTELLIGENCE_FINDING]", "[REVISION]");
      client.getIntelligenceFindingRevision(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIntelligenceFindingRevisionTest2() throws Exception {
    IntelligenceFindingRevision expectedResponse =
        IntelligenceFindingRevision.newBuilder()
            .setName(
                IntelligenceFindingRevisionName.of(
                        "[PROJECT]", "[LOCATION]", "[INTELLIGENCE_FINDING]", "[REVISION]")
                    .toString())
            .setSnapshot(IntelligenceFinding.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3187/locations/location-3187/intelligenceFindings/intelligenceFinding-3187/revisions/revision-3187";

    IntelligenceFindingRevision actualResponse = client.getIntelligenceFindingRevision(name);
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
  public void getIntelligenceFindingRevisionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3187/locations/location-3187/intelligenceFindings/intelligenceFinding-3187/revisions/revision-3187";
      client.getIntelligenceFindingRevision(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIntelligenceFindingRevisionsTest() throws Exception {
    IntelligenceFindingRevision responsesElement = IntelligenceFindingRevision.newBuilder().build();
    ListIntelligenceFindingRevisionsResponse expectedResponse =
        ListIntelligenceFindingRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllIntelligenceFindingRevisions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    IntelligenceFindingName parent =
        IntelligenceFindingName.of("[PROJECT]", "[LOCATION]", "[INTELLIGENCE_FINDING]");

    ListIntelligenceFindingRevisionsPagedResponse pagedListResponse =
        client.listIntelligenceFindingRevisions(parent);

    List<IntelligenceFindingRevision> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getIntelligenceFindingRevisionsList().get(0), resources.get(0));

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
  public void listIntelligenceFindingRevisionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IntelligenceFindingName parent =
          IntelligenceFindingName.of("[PROJECT]", "[LOCATION]", "[INTELLIGENCE_FINDING]");
      client.listIntelligenceFindingRevisions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIntelligenceFindingRevisionsTest2() throws Exception {
    IntelligenceFindingRevision responsesElement = IntelligenceFindingRevision.newBuilder().build();
    ListIntelligenceFindingRevisionsResponse expectedResponse =
        ListIntelligenceFindingRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllIntelligenceFindingRevisions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-2922/locations/location-2922/intelligenceFindings/intelligenceFinding-2922";

    ListIntelligenceFindingRevisionsPagedResponse pagedListResponse =
        client.listIntelligenceFindingRevisions(parent);

    List<IntelligenceFindingRevision> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(
        expectedResponse.getIntelligenceFindingRevisionsList().get(0), resources.get(0));

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
  public void listIntelligenceFindingRevisionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-2922/locations/location-2922/intelligenceFindings/intelligenceFinding-2922";
      client.listIntelligenceFindingRevisions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
