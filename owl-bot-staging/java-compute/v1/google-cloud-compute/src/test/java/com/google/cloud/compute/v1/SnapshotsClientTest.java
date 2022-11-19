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

package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.SnapshotsClient.ListPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.stub.HttpJsonSnapshotsStub;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class SnapshotsClientTest {
  private static MockHttpService mockService;
  private static SnapshotsClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSnapshotsStub.getMethodDescriptors(), SnapshotsSettings.getDefaultEndpoint());
    SnapshotsSettings settings =
        SnapshotsSettings.newBuilder()
            .setTransportChannelProvider(
                SnapshotsSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SnapshotsClient.create(settings);
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
  public void deleteTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setClientOperationId("clientOperationId-1230366697")
            .setCreationTimestamp("creationTimestamp-370203401")
            .setDescription("description-1724546052")
            .setEndTime("endTime-1607243192")
            .setError(Error.newBuilder().build())
            .setHttpErrorMessage("httpErrorMessage1577303431")
            .setHttpErrorStatusCode(0)
            .setId(3355)
            .setInsertTime("insertTime966165798")
            .setKind("kind3292052")
            .setName("name3373707")
            .setOperationGroupId("operationGroupId1716161683")
            .setOperationType("operationType91999553")
            .setProgress(-1001078227)
            .setRegion("region-934795532")
            .setSelfLink("selfLink1191800166")
            .setStartTime("startTime-2129294769")
            .setStatus(Status.DONE)
            .setStatusMessage("statusMessage-958704715")
            .setTargetId(-815576439)
            .setTargetLink("targetLink486368555")
            .setUser("user3599307")
            .addAllWarnings(new ArrayList<Warnings>())
            .setZone("zone3744684")
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-6911";
    String snapshot = "snapshot-5030";

    Operation actualResponse = client.deleteAsync(project, snapshot).get();
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
  public void deleteExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-6911";
      String snapshot = "snapshot-5030";
      client.deleteAsync(project, snapshot).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getTest() throws Exception {
    Snapshot expectedResponse =
        Snapshot.newBuilder()
            .setArchitecture("architecture839674195")
            .setAutoCreated(true)
            .setChainName("chainName1317895404")
            .setCreationSizeBytes(1199141901)
            .setCreationTimestamp("creationTimestamp-370203401")
            .setDescription("description-1724546052")
            .setDiskSizeGb(-757478089)
            .setDownloadBytes(971924980)
            .setId(3355)
            .setKind("kind3292052")
            .setLabelFingerprint("labelFingerprint379449680")
            .putAllLabels(new HashMap<String, String>())
            .addAllLicenseCodes(new ArrayList<Long>())
            .addAllLicenses(new ArrayList<String>())
            .setLocationHint("locationHint-58650660")
            .setName("name3373707")
            .setSatisfiesPzs(true)
            .setSelfLink("selfLink1191800166")
            .setSnapshotEncryptionKey(CustomerEncryptionKey.newBuilder().build())
            .setSnapshotType("snapshotType-931506402")
            .setSourceDisk("sourceDisk-1111923624")
            .setSourceDiskEncryptionKey(CustomerEncryptionKey.newBuilder().build())
            .setSourceDiskId("sourceDiskId888256403")
            .setSourceSnapshotSchedulePolicy("sourceSnapshotSchedulePolicy-1664282744")
            .setSourceSnapshotSchedulePolicyId("sourceSnapshotSchedulePolicyId-1647880509")
            .setStatus("status-892481550")
            .setStorageBytes(2035244455)
            .setStorageBytesStatus("storageBytesStatus-1653482814")
            .addAllStorageLocations(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-6911";
    String snapshot = "snapshot-5030";

    Snapshot actualResponse = client.get(project, snapshot);
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
  public void getExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-6911";
      String snapshot = "snapshot-5030";
      client.get(project, snapshot);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .addAllBindings(new ArrayList<Binding>())
            .setEtag("etag3123477")
            .setIamOwned(true)
            .addAllRules(new ArrayList<Rule>())
            .setVersion(351608024)
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-6911";
    String resource = "resource-756";

    Policy actualResponse = client.getIamPolicy(project, resource);
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
      String project = "project-6911";
      String resource = "resource-756";
      client.getIamPolicy(project, resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void insertTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setClientOperationId("clientOperationId-1230366697")
            .setCreationTimestamp("creationTimestamp-370203401")
            .setDescription("description-1724546052")
            .setEndTime("endTime-1607243192")
            .setError(Error.newBuilder().build())
            .setHttpErrorMessage("httpErrorMessage1577303431")
            .setHttpErrorStatusCode(0)
            .setId(3355)
            .setInsertTime("insertTime966165798")
            .setKind("kind3292052")
            .setName("name3373707")
            .setOperationGroupId("operationGroupId1716161683")
            .setOperationType("operationType91999553")
            .setProgress(-1001078227)
            .setRegion("region-934795532")
            .setSelfLink("selfLink1191800166")
            .setStartTime("startTime-2129294769")
            .setStatus(Status.DONE)
            .setStatusMessage("statusMessage-958704715")
            .setTargetId(-815576439)
            .setTargetLink("targetLink486368555")
            .setUser("user3599307")
            .addAllWarnings(new ArrayList<Warnings>())
            .setZone("zone3744684")
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-6911";
    Snapshot snapshotResource = Snapshot.newBuilder().build();

    Operation actualResponse = client.insertAsync(project, snapshotResource).get();
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
  public void insertExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-6911";
      Snapshot snapshotResource = Snapshot.newBuilder().build();
      client.insertAsync(project, snapshotResource).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listTest() throws Exception {
    Snapshot responsesElement = Snapshot.newBuilder().build();
    SnapshotList expectedResponse =
        SnapshotList.newBuilder()
            .setNextPageToken("")
            .addAllItems(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-6911";

    ListPagedResponse pagedListResponse = client.list(project);

    List<Snapshot> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getItemsList().get(0), resources.get(0));

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
  public void listExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-6911";
      client.list(project);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .addAllBindings(new ArrayList<Binding>())
            .setEtag("etag3123477")
            .setIamOwned(true)
            .addAllRules(new ArrayList<Rule>())
            .setVersion(351608024)
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-6911";
    String resource = "resource-756";
    GlobalSetPolicyRequest globalSetPolicyRequestResource =
        GlobalSetPolicyRequest.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(project, resource, globalSetPolicyRequestResource);
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
      String project = "project-6911";
      String resource = "resource-756";
      GlobalSetPolicyRequest globalSetPolicyRequestResource =
          GlobalSetPolicyRequest.newBuilder().build();
      client.setIamPolicy(project, resource, globalSetPolicyRequestResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setLabelsTest() throws Exception {
    Operation expectedResponse =
        Operation.newBuilder()
            .setClientOperationId("clientOperationId-1230366697")
            .setCreationTimestamp("creationTimestamp-370203401")
            .setDescription("description-1724546052")
            .setEndTime("endTime-1607243192")
            .setError(Error.newBuilder().build())
            .setHttpErrorMessage("httpErrorMessage1577303431")
            .setHttpErrorStatusCode(0)
            .setId(3355)
            .setInsertTime("insertTime966165798")
            .setKind("kind3292052")
            .setName("name3373707")
            .setOperationGroupId("operationGroupId1716161683")
            .setOperationType("operationType91999553")
            .setProgress(-1001078227)
            .setRegion("region-934795532")
            .setSelfLink("selfLink1191800166")
            .setStartTime("startTime-2129294769")
            .setStatus(Status.DONE)
            .setStatusMessage("statusMessage-958704715")
            .setTargetId(-815576439)
            .setTargetLink("targetLink486368555")
            .setUser("user3599307")
            .addAllWarnings(new ArrayList<Warnings>())
            .setZone("zone3744684")
            .build();
    mockService.addResponse(expectedResponse);

    String project = "project-6911";
    String resource = "resource-756";
    GlobalSetLabelsRequest globalSetLabelsRequestResource =
        GlobalSetLabelsRequest.newBuilder().build();

    Operation actualResponse =
        client.setLabelsAsync(project, resource, globalSetLabelsRequestResource).get();
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
  public void setLabelsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String project = "project-6911";
      String resource = "resource-756";
      GlobalSetLabelsRequest globalSetLabelsRequestResource =
          GlobalSetLabelsRequest.newBuilder().build();
      client.setLabelsAsync(project, resource, globalSetLabelsRequestResource).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestPermissionsResponse expectedResponse =
        TestPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockService.addResponse(expectedResponse);

    String project = "project-6911";
    String resource = "resource-756";
    TestPermissionsRequest testPermissionsRequestResource =
        TestPermissionsRequest.newBuilder().build();

    TestPermissionsResponse actualResponse =
        client.testIamPermissions(project, resource, testPermissionsRequestResource);
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
      String project = "project-6911";
      String resource = "resource-756";
      TestPermissionsRequest testPermissionsRequestResource =
          TestPermissionsRequest.newBuilder().build();
      client.testIamPermissions(project, resource, testPermissionsRequestResource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
