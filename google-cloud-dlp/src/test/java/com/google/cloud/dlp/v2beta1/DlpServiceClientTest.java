/*
 * Copyright 2017, Google LLC All rights reserved.
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
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.longrunning.Operation;
import com.google.privacy.dlp.v2beta1.AnalyzeDataSourceRiskRequest;
import com.google.privacy.dlp.v2beta1.BigQueryTable;
import com.google.privacy.dlp.v2beta1.CloudStorageOptions;
import com.google.privacy.dlp.v2beta1.CloudStorageOptions.FileSet;
import com.google.privacy.dlp.v2beta1.ContentItem;
import com.google.privacy.dlp.v2beta1.CreateInspectOperationRequest;
import com.google.privacy.dlp.v2beta1.DeidentifyConfig;
import com.google.privacy.dlp.v2beta1.DeidentifyContentRequest;
import com.google.privacy.dlp.v2beta1.DeidentifyContentResponse;
import com.google.privacy.dlp.v2beta1.InfoType;
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
import com.google.privacy.dlp.v2beta1.PrivacyMetric;
import com.google.privacy.dlp.v2beta1.RedactContentRequest;
import com.google.privacy.dlp.v2beta1.RedactContentRequest.ReplaceConfig;
import com.google.privacy.dlp.v2beta1.RedactContentResponse;
import com.google.privacy.dlp.v2beta1.ResultName;
import com.google.privacy.dlp.v2beta1.RiskAnalysisOperationResult;
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
        DlpServiceSettings.newBuilder()
            .setTransportChannelProvider(serviceHelper.createChannelProvider())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DlpServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void deidentifyContentTest() {
    DeidentifyContentResponse expectedResponse = DeidentifyContentResponse.newBuilder().build();
    mockDlpService.addResponse(expectedResponse);

    DeidentifyConfig deidentifyConfig = DeidentifyConfig.newBuilder().build();
    InspectConfig inspectConfig = InspectConfig.newBuilder().build();
    List<ContentItem> items = new ArrayList<>();

    DeidentifyContentResponse actualResponse =
        client.deidentifyContent(deidentifyConfig, inspectConfig, items);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeidentifyContentRequest actualRequest = (DeidentifyContentRequest) actualRequests.get(0);

    Assert.assertEquals(deidentifyConfig, actualRequest.getDeidentifyConfig());
    Assert.assertEquals(inspectConfig, actualRequest.getInspectConfig());
    Assert.assertEquals(items, actualRequest.getItemsList());
  }

  @Test
  @SuppressWarnings("all")
  public void deidentifyContentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      DeidentifyConfig deidentifyConfig = DeidentifyConfig.newBuilder().build();
      InspectConfig inspectConfig = InspectConfig.newBuilder().build();
      List<ContentItem> items = new ArrayList<>();

      client.deidentifyContent(deidentifyConfig, inspectConfig, items);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void analyzeDataSourceRiskTest() throws Exception {
    RiskAnalysisOperationResult expectedResponse = RiskAnalysisOperationResult.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("analyzeDataSourceRiskTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDlpService.addResponse(resultOperation);

    PrivacyMetric privacyMetric = PrivacyMetric.newBuilder().build();
    BigQueryTable sourceTable = BigQueryTable.newBuilder().build();

    RiskAnalysisOperationResult actualResponse =
        client.analyzeDataSourceRiskAsync(privacyMetric, sourceTable).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<GeneratedMessageV3> actualRequests = mockDlpService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AnalyzeDataSourceRiskRequest actualRequest =
        (AnalyzeDataSourceRiskRequest) actualRequests.get(0);

    Assert.assertEquals(privacyMetric, actualRequest.getPrivacyMetric());
    Assert.assertEquals(sourceTable, actualRequest.getSourceTable());
  }

  @Test
  @SuppressWarnings("all")
  public void analyzeDataSourceRiskExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockDlpService.addException(exception);

    try {
      PrivacyMetric privacyMetric = PrivacyMetric.newBuilder().build();
      BigQueryTable sourceTable = BigQueryTable.newBuilder().build();

      client.analyzeDataSourceRiskAsync(privacyMetric, sourceTable).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void inspectContentTest() {
    InspectContentResponse expectedResponse = InspectContentResponse.newBuilder().build();
    mockDlpService.addResponse(expectedResponse);

    String name = "EMAIL_ADDRESS";
    InfoType infoTypesElement = InfoType.newBuilder().setName(name).build();
    List<InfoType> infoTypes = Arrays.asList(infoTypesElement);
    InspectConfig inspectConfig = InspectConfig.newBuilder().addAllInfoTypes(infoTypes).build();
    String type = "text/plain";
    String value = "My email is example@example.com.";
    ContentItem itemsElement = ContentItem.newBuilder().setType(type).setValue(value).build();
    List<ContentItem> items = Arrays.asList(itemsElement);

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
      String name = "EMAIL_ADDRESS";
      InfoType infoTypesElement = InfoType.newBuilder().setName(name).build();
      List<InfoType> infoTypes = Arrays.asList(infoTypesElement);
      InspectConfig inspectConfig = InspectConfig.newBuilder().addAllInfoTypes(infoTypes).build();
      String type = "text/plain";
      String value = "My email is example@example.com.";
      ContentItem itemsElement = ContentItem.newBuilder().setType(type).setValue(value).build();
      List<ContentItem> items = Arrays.asList(itemsElement);

      client.inspectContent(inspectConfig, items);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void redactContentTest() {
    RedactContentResponse expectedResponse = RedactContentResponse.newBuilder().build();
    mockDlpService.addResponse(expectedResponse);

    String name = "EMAIL_ADDRESS";
    InfoType infoTypesElement = InfoType.newBuilder().setName(name).build();
    List<InfoType> infoTypes = Arrays.asList(infoTypesElement);
    InspectConfig inspectConfig = InspectConfig.newBuilder().addAllInfoTypes(infoTypes).build();
    String type = "text/plain";
    String value = "My email is example@example.com.";
    ContentItem itemsElement = ContentItem.newBuilder().setType(type).setValue(value).build();
    List<ContentItem> items = Arrays.asList(itemsElement);
    String name2 = "EMAIL_ADDRESS";
    InfoType infoType = InfoType.newBuilder().setName(name2).build();
    String replaceWith = "REDACTED";
    RedactContentRequest.ReplaceConfig replaceConfigsElement =
        RedactContentRequest.ReplaceConfig.newBuilder()
            .setInfoType(infoType)
            .setReplaceWith(replaceWith)
            .build();
    List<RedactContentRequest.ReplaceConfig> replaceConfigs = Arrays.asList(replaceConfigsElement);

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
      String name = "EMAIL_ADDRESS";
      InfoType infoTypesElement = InfoType.newBuilder().setName(name).build();
      List<InfoType> infoTypes = Arrays.asList(infoTypesElement);
      InspectConfig inspectConfig = InspectConfig.newBuilder().addAllInfoTypes(infoTypes).build();
      String type = "text/plain";
      String value = "My email is example@example.com.";
      ContentItem itemsElement = ContentItem.newBuilder().setType(type).setValue(value).build();
      List<ContentItem> items = Arrays.asList(itemsElement);
      String name2 = "EMAIL_ADDRESS";
      InfoType infoType = InfoType.newBuilder().setName(name2).build();
      String replaceWith = "REDACTED";
      RedactContentRequest.ReplaceConfig replaceConfigsElement =
          RedactContentRequest.ReplaceConfig.newBuilder()
              .setInfoType(infoType)
              .setReplaceWith(replaceWith)
              .build();
      List<RedactContentRequest.ReplaceConfig> replaceConfigs =
          Arrays.asList(replaceConfigsElement);

      client.redactContent(inspectConfig, items, replaceConfigs);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createInspectOperationTest() throws Exception {
    ResultName name2 = ResultName.of("[RESULT]");
    InspectOperationResult expectedResponse =
        InspectOperationResult.newBuilder().setNameWithResultName(name2).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createInspectOperationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDlpService.addResponse(resultOperation);

    String name = "EMAIL_ADDRESS";
    InfoType infoTypesElement = InfoType.newBuilder().setName(name).build();
    List<InfoType> infoTypes = Arrays.asList(infoTypesElement);
    InspectConfig inspectConfig = InspectConfig.newBuilder().addAllInfoTypes(infoTypes).build();
    String url = "gs://example_bucket/example_file.png";
    CloudStorageOptions.FileSet fileSet =
        CloudStorageOptions.FileSet.newBuilder().setUrl(url).build();
    CloudStorageOptions cloudStorageOptions =
        CloudStorageOptions.newBuilder().setFileSet(fileSet).build();
    StorageConfig storageConfig =
        StorageConfig.newBuilder().setCloudStorageOptions(cloudStorageOptions).build();
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
      String name = "EMAIL_ADDRESS";
      InfoType infoTypesElement = InfoType.newBuilder().setName(name).build();
      List<InfoType> infoTypes = Arrays.asList(infoTypesElement);
      InspectConfig inspectConfig = InspectConfig.newBuilder().addAllInfoTypes(infoTypes).build();
      String url = "gs://example_bucket/example_file.png";
      CloudStorageOptions.FileSet fileSet =
          CloudStorageOptions.FileSet.newBuilder().setUrl(url).build();
      CloudStorageOptions cloudStorageOptions =
          CloudStorageOptions.newBuilder().setFileSet(fileSet).build();
      StorageConfig storageConfig =
          StorageConfig.newBuilder().setCloudStorageOptions(cloudStorageOptions).build();
      OutputStorageConfig outputConfig = OutputStorageConfig.newBuilder().build();

      client.createInspectOperationAsync(inspectConfig, storageConfig, outputConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listInspectFindingsTest() {
    String nextPageToken = "nextPageToken-1530815211";
    ListInspectFindingsResponse expectedResponse =
        ListInspectFindingsResponse.newBuilder().setNextPageToken(nextPageToken).build();
    mockDlpService.addResponse(expectedResponse);

    ResultName name = ResultName.of("[RESULT]");

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
      ResultName name = ResultName.of("[RESULT]");

      client.listInspectFindings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listInfoTypesTest() {
    ListInfoTypesResponse expectedResponse = ListInfoTypesResponse.newBuilder().build();
    mockDlpService.addResponse(expectedResponse);

    String category = "PII";
    String languageCode = "en";

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
      String category = "PII";
      String languageCode = "en";

      client.listInfoTypes(category, languageCode);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void listRootCategoriesTest() {
    ListRootCategoriesResponse expectedResponse = ListRootCategoriesResponse.newBuilder().build();
    mockDlpService.addResponse(expectedResponse);

    String languageCode = "en";

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
      String languageCode = "en";

      client.listRootCategories(languageCode);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
