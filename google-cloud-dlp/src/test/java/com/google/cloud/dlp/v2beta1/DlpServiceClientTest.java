/*
 * Copyright 2017, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.dlp.v2beta1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.ApiException;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.longrunning.Operation;
import com.google.privacy.dlp.v2beta1.ContentItem;
import com.google.privacy.dlp.v2beta1.CreateInspectOperationRequest;
import com.google.privacy.dlp.v2beta1.InspectConfig;
import com.google.privacy.dlp.v2beta1.InspectContentRequest;
import com.google.privacy.dlp.v2beta1.InspectContentResponse;
import com.google.privacy.dlp.v2beta1.InspectOperationResult;
import com.google.privacy.dlp.v2beta1.ListInfoTypesRequest;
import com.google.privacy.dlp.v2beta1.ListInfoTypesResponse;
import com.google.privacy.dlp.v2beta1.ListInspectFindingsRequest;
import com.google.privacy.dlp.v2beta1.ListInspectFindingsResponse;
import com.google.privacy.dlp.v2beta1.ListRootCategoriesRequest;
import com.google.privacy.dlp.v2beta1.ListRootCategoriesResponse;
import com.google.privacy.dlp.v2beta1.OutputStorageConfig;
import com.google.privacy.dlp.v2beta1.RedactContentRequest;
import com.google.privacy.dlp.v2beta1.RedactContentRequest.ReplaceConfig;
import com.google.privacy.dlp.v2beta1.RedactContentResponse;
import com.google.privacy.dlp.v2beta1.ResultName;
import com.google.privacy.dlp.v2beta1.StorageConfig;
import com.google.protobuf.Any;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class DlpServiceClientTest {
  private static MockDlpService mockDlpService;
  private static MockServiceHelper serviceHelper;
  private DlpServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDlpService = new MockDlpService();
    serviceHelper =
        new MockServiceHelper("in-process-1", Arrays.<MockGrpcService>asList(mockDlpService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    DlpServiceSettings settings =
        DlpServiceSettings.defaultBuilder()
            .setChannelProvider(serviceHelper.createChannelProvider())
            .setCredentialsProvider(new NoCredentialsProvider())
            .build();
    client = DlpServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void inspectContentTest() {
    InspectContentResponse expectedResponse = InspectContentResponse.newBuilder().build();
    mockDlpService.addResponse(expectedResponse);

    InspectConfig inspectConfig = InspectConfig.newBuilder().build();
    List<ContentItem> items = new ArrayList<>();

    InspectContentResponse actualResponse = client.inspectContent(inspectConfig, items);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InspectContentRequest actualRequest = (InspectContentRequest) actualRequests.get(0);

    Assert.assertEquals(inspectConfig, actualRequest.getInspectConfig());
    Assert.assertEquals(items, actualRequest.getItemsList());
  }

  @Test
  @SuppressWarnings("all")
  public void inspectContentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      InspectConfig inspectConfig = InspectConfig.newBuilder().build();
      List<ContentItem> items = new ArrayList<>();

      client.inspectContent(inspectConfig, items);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INVALID_ARGUMENT.getCode(), e.getStatusCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void redactContentTest() {
    RedactContentResponse expectedResponse = RedactContentResponse.newBuilder().build();
    mockDlpService.addResponse(expectedResponse);

    InspectConfig inspectConfig = InspectConfig.newBuilder().build();
    List<ContentItem> items = new ArrayList<>();
    List<RedactContentRequest.ReplaceConfig> replaceConfigs = new ArrayList<>();

    RedactContentResponse actualResponse =
        client.redactContent(inspectConfig, items, replaceConfigs);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RedactContentRequest actualRequest = (RedactContentRequest) actualRequests.get(0);

    Assert.assertEquals(inspectConfig, actualRequest.getInspectConfig());
    Assert.assertEquals(items, actualRequest.getItemsList());
    Assert.assertEquals(replaceConfigs, actualRequest.getReplaceConfigsList());
  }

  @Test
  @SuppressWarnings("all")
  public void redactContentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      InspectConfig inspectConfig = InspectConfig.newBuilder().build();
      List<ContentItem> items = new ArrayList<>();
      List<RedactContentRequest.ReplaceConfig> replaceConfigs = new ArrayList<>();

      client.redactContent(inspectConfig, items, replaceConfigs);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INVALID_ARGUMENT.getCode(), e.getStatusCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createInspectOperationTest() throws Exception {
    ResultName name = ResultName.create("[RESULT]");
    InspectOperationResult expectedResponse =
        InspectOperationResult.newBuilder().setNameWithResultName(name).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInspectOperationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDlpService.addResponse(resultOperation);

    InspectConfig inspectConfig = InspectConfig.newBuilder().build();
    StorageConfig storageConfig = StorageConfig.newBuilder().build();
    OutputStorageConfig outputConfig = OutputStorageConfig.newBuilder().build();

    InspectOperationResult actualResponse =
        client.createInspectOperationAsync(inspectConfig, storageConfig, outputConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateInspectOperationRequest actualRequest =
        (CreateInspectOperationRequest) actualRequests.get(0);

    Assert.assertEquals(inspectConfig, actualRequest.getInspectConfig());
    Assert.assertEquals(storageConfig, actualRequest.getStorageConfig());
    Assert.assertEquals(outputConfig, actualRequest.getOutputConfig());
  }

  @Test
  @SuppressWarnings("all")
  public void createInspectOperationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      InspectConfig inspectConfig = InspectConfig.newBuilder().build();
      StorageConfig storageConfig = StorageConfig.newBuilder().build();
      OutputStorageConfig outputConfig = OutputStorageConfig.newBuilder().build();

      client.createInspectOperationAsync(inspectConfig, storageConfig, outputConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(ApiException.class, e.getCause().getClass());
      ApiException apiException = (ApiException) e.getCause();
      Assert.assertEquals(Status.INVALID_ARGUMENT.getCode(), apiException.getStatusCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listInspectFindingsTest() {
    String nextPageToken = "nextPageToken-1530815211";
    ListInspectFindingsResponse expectedResponse =
        ListInspectFindingsResponse.newBuilder().setNextPageToken(nextPageToken).build();
    mockDlpService.addResponse(expectedResponse);

    ResultName name = ResultName.create("[RESULT]");

    ListInspectFindingsResponse actualResponse = client.listInspectFindings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInspectFindingsRequest actualRequest = (ListInspectFindingsRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getNameAsResultName());
  }

  @Test
  @SuppressWarnings("all")
  public void listInspectFindingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      ResultName name = ResultName.create("[RESULT]");

      client.listInspectFindings(name);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INVALID_ARGUMENT.getCode(), e.getStatusCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listInfoTypesTest() {
    ListInfoTypesResponse expectedResponse = ListInfoTypesResponse.newBuilder().build();
    mockDlpService.addResponse(expectedResponse);

    String category = "category50511102";
    String languageCode = "languageCode-412800396";

    ListInfoTypesResponse actualResponse = client.listInfoTypes(category, languageCode);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListInfoTypesRequest actualRequest = (ListInfoTypesRequest) actualRequests.get(0);

    Assert.assertEquals(category, actualRequest.getCategory());
    Assert.assertEquals(languageCode, actualRequest.getLanguageCode());
  }

  @Test
  @SuppressWarnings("all")
  public void listInfoTypesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      String category = "category50511102";
      String languageCode = "languageCode-412800396";

      client.listInfoTypes(category, languageCode);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INVALID_ARGUMENT.getCode(), e.getStatusCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listRootCategoriesTest() {
    ListRootCategoriesResponse expectedResponse = ListRootCategoriesResponse.newBuilder().build();
    mockDlpService.addResponse(expectedResponse);

    String languageCode = "languageCode-412800396";

    ListRootCategoriesResponse actualResponse = client.listRootCategories(languageCode);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRootCategoriesRequest actualRequest = (ListRootCategoriesRequest) actualRequests.get(0);

    Assert.assertEquals(languageCode, actualRequest.getLanguageCode());
  }

  @Test
  @SuppressWarnings("all")
  public void listRootCategoriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      String languageCode = "languageCode-412800396";

      client.listRootCategories(languageCode);
      Assert.fail("No exception raised");
    } catch (ApiException e) {
      Assert.assertEquals(Status.INVALID_ARGUMENT.getCode(), e.getStatusCode());
    }
  }
}
