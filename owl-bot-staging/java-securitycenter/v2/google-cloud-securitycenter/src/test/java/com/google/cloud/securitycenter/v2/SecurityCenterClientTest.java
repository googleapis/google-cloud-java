/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.securitycenter.v2;

import static com.google.cloud.securitycenter.v2.SecurityCenterClient.GroupFindingsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListAttackPathsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListBigQueryExportsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListFindingsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListMuteConfigsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListNotificationConfigsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListResourceValueConfigsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListSourcesPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListValuedResourcesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.resourcenames.ResourceName;
import com.google.common.collect.Lists;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.protobuf.Value;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class SecurityCenterClientTest {
  private static MockSecurityCenter mockSecurityCenter;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private SecurityCenterClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSecurityCenter = new MockSecurityCenter();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockSecurityCenter));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    SecurityCenterSettings settings =
        SecurityCenterSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SecurityCenterClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void batchCreateResourceValueConfigsTest() throws Exception {
    BatchCreateResourceValueConfigsResponse expectedResponse =
        BatchCreateResourceValueConfigsResponse.newBuilder()
            .addAllResourceValueConfigs(new ArrayList<ResourceValueConfig>())
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    List<CreateResourceValueConfigRequest> requests = new ArrayList<>();

    BatchCreateResourceValueConfigsResponse actualResponse =
        client.batchCreateResourceValueConfigs(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateResourceValueConfigsRequest actualRequest =
        ((BatchCreateResourceValueConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateResourceValueConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      List<CreateResourceValueConfigRequest> requests = new ArrayList<>();
      client.batchCreateResourceValueConfigs(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateResourceValueConfigsTest2() throws Exception {
    BatchCreateResourceValueConfigsResponse expectedResponse =
        BatchCreateResourceValueConfigsResponse.newBuilder()
            .addAllResourceValueConfigs(new ArrayList<ResourceValueConfig>())
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String parent = "parent-995424086";
    List<CreateResourceValueConfigRequest> requests = new ArrayList<>();

    BatchCreateResourceValueConfigsResponse actualResponse =
        client.batchCreateResourceValueConfigs(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateResourceValueConfigsRequest actualRequest =
        ((BatchCreateResourceValueConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateResourceValueConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String parent = "parent-995424086";
      List<CreateResourceValueConfigRequest> requests = new ArrayList<>();
      client.batchCreateResourceValueConfigs(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void bulkMuteFindingsTest() throws Exception {
    BulkMuteFindingsResponse expectedResponse = BulkMuteFindingsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("bulkMuteFindingsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecurityCenter.addResponse(resultOperation);

    ResourceName parent = FolderName.of("[FOLDER]");

    BulkMuteFindingsResponse actualResponse = client.bulkMuteFindingsAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BulkMuteFindingsRequest actualRequest = ((BulkMuteFindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void bulkMuteFindingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      ResourceName parent = FolderName.of("[FOLDER]");
      client.bulkMuteFindingsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void bulkMuteFindingsTest2() throws Exception {
    BulkMuteFindingsResponse expectedResponse = BulkMuteFindingsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("bulkMuteFindingsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockSecurityCenter.addResponse(resultOperation);

    String parent = "parent-995424086";

    BulkMuteFindingsResponse actualResponse = client.bulkMuteFindingsAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BulkMuteFindingsRequest actualRequest = ((BulkMuteFindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void bulkMuteFindingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String parent = "parent-995424086";
      client.bulkMuteFindingsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createBigQueryExportTest() throws Exception {
    BigQueryExport expectedResponse =
        BigQueryExport.newBuilder()
            .setName(
                BigQueryExportName.ofOrganizationLocationExportName(
                        "[ORGANIZATION]", "[LOCATION]", "[EXPORT]")
                    .toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setDataset("dataset1443214456")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMostRecentEditor("mostRecentEditor-833861941")
            .setPrincipal("principal-1812041682")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
    BigQueryExport bigQueryExport = BigQueryExport.newBuilder().build();
    String bigQueryExportId = "bigQueryExportId1024198583";

    BigQueryExport actualResponse =
        client.createBigQueryExport(parent, bigQueryExport, bigQueryExportId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBigQueryExportRequest actualRequest =
        ((CreateBigQueryExportRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(bigQueryExport, actualRequest.getBigQueryExport());
    Assert.assertEquals(bigQueryExportId, actualRequest.getBigQueryExportId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBigQueryExportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      BigQueryExport bigQueryExport = BigQueryExport.newBuilder().build();
      String bigQueryExportId = "bigQueryExportId1024198583";
      client.createBigQueryExport(parent, bigQueryExport, bigQueryExportId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBigQueryExportTest2() throws Exception {
    BigQueryExport expectedResponse =
        BigQueryExport.newBuilder()
            .setName(
                BigQueryExportName.ofOrganizationLocationExportName(
                        "[ORGANIZATION]", "[LOCATION]", "[EXPORT]")
                    .toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setDataset("dataset1443214456")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMostRecentEditor("mostRecentEditor-833861941")
            .setPrincipal("principal-1812041682")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    BigQueryExport bigQueryExport = BigQueryExport.newBuilder().build();
    String bigQueryExportId = "bigQueryExportId1024198583";

    BigQueryExport actualResponse =
        client.createBigQueryExport(parent, bigQueryExport, bigQueryExportId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBigQueryExportRequest actualRequest =
        ((CreateBigQueryExportRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(bigQueryExport, actualRequest.getBigQueryExport());
    Assert.assertEquals(bigQueryExportId, actualRequest.getBigQueryExportId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBigQueryExportExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      BigQueryExport bigQueryExport = BigQueryExport.newBuilder().build();
      String bigQueryExportId = "bigQueryExportId1024198583";
      client.createBigQueryExport(parent, bigQueryExport, bigQueryExportId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBigQueryExportTest3() throws Exception {
    BigQueryExport expectedResponse =
        BigQueryExport.newBuilder()
            .setName(
                BigQueryExportName.ofOrganizationLocationExportName(
                        "[ORGANIZATION]", "[LOCATION]", "[EXPORT]")
                    .toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setDataset("dataset1443214456")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMostRecentEditor("mostRecentEditor-833861941")
            .setPrincipal("principal-1812041682")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    BigQueryExport bigQueryExport = BigQueryExport.newBuilder().build();
    String bigQueryExportId = "bigQueryExportId1024198583";

    BigQueryExport actualResponse =
        client.createBigQueryExport(parent, bigQueryExport, bigQueryExportId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBigQueryExportRequest actualRequest =
        ((CreateBigQueryExportRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(bigQueryExport, actualRequest.getBigQueryExport());
    Assert.assertEquals(bigQueryExportId, actualRequest.getBigQueryExportId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBigQueryExportExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      BigQueryExport bigQueryExport = BigQueryExport.newBuilder().build();
      String bigQueryExportId = "bigQueryExportId1024198583";
      client.createBigQueryExport(parent, bigQueryExport, bigQueryExportId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBigQueryExportTest4() throws Exception {
    BigQueryExport expectedResponse =
        BigQueryExport.newBuilder()
            .setName(
                BigQueryExportName.ofOrganizationLocationExportName(
                        "[ORGANIZATION]", "[LOCATION]", "[EXPORT]")
                    .toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setDataset("dataset1443214456")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMostRecentEditor("mostRecentEditor-833861941")
            .setPrincipal("principal-1812041682")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String parent = "parent-995424086";
    BigQueryExport bigQueryExport = BigQueryExport.newBuilder().build();
    String bigQueryExportId = "bigQueryExportId1024198583";

    BigQueryExport actualResponse =
        client.createBigQueryExport(parent, bigQueryExport, bigQueryExportId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBigQueryExportRequest actualRequest =
        ((CreateBigQueryExportRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(bigQueryExport, actualRequest.getBigQueryExport());
    Assert.assertEquals(bigQueryExportId, actualRequest.getBigQueryExportId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBigQueryExportExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String parent = "parent-995424086";
      BigQueryExport bigQueryExport = BigQueryExport.newBuilder().build();
      String bigQueryExportId = "bigQueryExportId1024198583";
      client.createBigQueryExport(parent, bigQueryExport, bigQueryExportId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFindingTest() throws Exception {
    Finding expectedResponse =
        Finding.newBuilder()
            .setName(
                FindingName.ofOrganizationSourceFindingName(
                        "[ORGANIZATION]", "[SOURCE]", "[FINDING]")
                    .toString())
            .setCanonicalName("canonicalName2122381727")
            .setParent("parent-995424086")
            .setResourceName("resourceName-384566343")
            .setCategory("category50511102")
            .setExternalUri("externalUri-1153085023")
            .putAllSourceProperties(new HashMap<String, Value>())
            .setSecurityMarks(SecurityMarks.newBuilder().build())
            .setEventTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setIndicator(Indicator.newBuilder().build())
            .setVulnerability(Vulnerability.newBuilder().build())
            .setMuteUpdateTime(Timestamp.newBuilder().build())
            .putAllExternalSystems(new HashMap<String, ExternalSystem>())
            .setMitreAttack(MitreAttack.newBuilder().build())
            .setAccess(Access.newBuilder().build())
            .addAllConnections(new ArrayList<Connection>())
            .setMuteInitiator("muteInitiator1395645462")
            .addAllProcesses(new ArrayList<Process>())
            .putAllContacts(new HashMap<String, ContactDetails>())
            .addAllCompliances(new ArrayList<Compliance>())
            .setParentDisplayName("parentDisplayName-1523759261")
            .setDescription("description-1724546052")
            .setExfiltration(Exfiltration.newBuilder().build())
            .addAllIamBindings(new ArrayList<IamBinding>())
            .setNextSteps("nextSteps1206138868")
            .setModuleName("moduleName-870351081")
            .addAllContainers(new ArrayList<Container>())
            .setKubernetes(Kubernetes.newBuilder().build())
            .setDatabase(Database.newBuilder().build())
            .setAttackExposure(AttackExposure.newBuilder().build())
            .addAllFiles(new ArrayList<File>())
            .setCloudDlpInspection(CloudDlpInspection.newBuilder().build())
            .setCloudDlpDataProfile(CloudDlpDataProfile.newBuilder().build())
            .setKernelRootkit(KernelRootkit.newBuilder().build())
            .addAllOrgPolicies(new ArrayList<OrgPolicy>())
            .setApplication(Application.newBuilder().build())
            .setBackupDisasterRecovery(BackupDisasterRecovery.newBuilder().build())
            .setSecurityPosture(SecurityPosture.newBuilder().build())
            .addAllLogEntries(new ArrayList<LogEntry>())
            .addAllLoadBalancers(new ArrayList<LoadBalancer>())
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    SourceName parent = SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]");
    Finding finding = Finding.newBuilder().build();
    String findingId = "findingId439150212";

    Finding actualResponse = client.createFinding(parent, finding, findingId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFindingRequest actualRequest = ((CreateFindingRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(finding, actualRequest.getFinding());
    Assert.assertEquals(findingId, actualRequest.getFindingId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      SourceName parent = SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]");
      Finding finding = Finding.newBuilder().build();
      String findingId = "findingId439150212";
      client.createFinding(parent, finding, findingId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFindingTest2() throws Exception {
    Finding expectedResponse =
        Finding.newBuilder()
            .setName(
                FindingName.ofOrganizationSourceFindingName(
                        "[ORGANIZATION]", "[SOURCE]", "[FINDING]")
                    .toString())
            .setCanonicalName("canonicalName2122381727")
            .setParent("parent-995424086")
            .setResourceName("resourceName-384566343")
            .setCategory("category50511102")
            .setExternalUri("externalUri-1153085023")
            .putAllSourceProperties(new HashMap<String, Value>())
            .setSecurityMarks(SecurityMarks.newBuilder().build())
            .setEventTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setIndicator(Indicator.newBuilder().build())
            .setVulnerability(Vulnerability.newBuilder().build())
            .setMuteUpdateTime(Timestamp.newBuilder().build())
            .putAllExternalSystems(new HashMap<String, ExternalSystem>())
            .setMitreAttack(MitreAttack.newBuilder().build())
            .setAccess(Access.newBuilder().build())
            .addAllConnections(new ArrayList<Connection>())
            .setMuteInitiator("muteInitiator1395645462")
            .addAllProcesses(new ArrayList<Process>())
            .putAllContacts(new HashMap<String, ContactDetails>())
            .addAllCompliances(new ArrayList<Compliance>())
            .setParentDisplayName("parentDisplayName-1523759261")
            .setDescription("description-1724546052")
            .setExfiltration(Exfiltration.newBuilder().build())
            .addAllIamBindings(new ArrayList<IamBinding>())
            .setNextSteps("nextSteps1206138868")
            .setModuleName("moduleName-870351081")
            .addAllContainers(new ArrayList<Container>())
            .setKubernetes(Kubernetes.newBuilder().build())
            .setDatabase(Database.newBuilder().build())
            .setAttackExposure(AttackExposure.newBuilder().build())
            .addAllFiles(new ArrayList<File>())
            .setCloudDlpInspection(CloudDlpInspection.newBuilder().build())
            .setCloudDlpDataProfile(CloudDlpDataProfile.newBuilder().build())
            .setKernelRootkit(KernelRootkit.newBuilder().build())
            .addAllOrgPolicies(new ArrayList<OrgPolicy>())
            .setApplication(Application.newBuilder().build())
            .setBackupDisasterRecovery(BackupDisasterRecovery.newBuilder().build())
            .setSecurityPosture(SecurityPosture.newBuilder().build())
            .addAllLogEntries(new ArrayList<LogEntry>())
            .addAllLoadBalancers(new ArrayList<LoadBalancer>())
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Finding finding = Finding.newBuilder().build();
    String findingId = "findingId439150212";

    Finding actualResponse = client.createFinding(parent, finding, findingId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFindingRequest actualRequest = ((CreateFindingRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(finding, actualRequest.getFinding());
    Assert.assertEquals(findingId, actualRequest.getFindingId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFindingExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String parent = "parent-995424086";
      Finding finding = Finding.newBuilder().build();
      String findingId = "findingId439150212";
      client.createFinding(parent, finding, findingId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMuteConfigTest() throws Exception {
    MuteConfig expectedResponse =
        MuteConfig.newBuilder()
            .setName(
                MuteConfigName.ofOrganizationMuteConfigName("[ORGANIZATION]", "[MUTE_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMostRecentEditor("mostRecentEditor-833861941")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
    MuteConfig muteConfig = MuteConfig.newBuilder().build();
    String muteConfigId = "muteConfigId1689669942";

    MuteConfig actualResponse = client.createMuteConfig(parent, muteConfig, muteConfigId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMuteConfigRequest actualRequest = ((CreateMuteConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(muteConfig, actualRequest.getMuteConfig());
    Assert.assertEquals(muteConfigId, actualRequest.getMuteConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMuteConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      MuteConfig muteConfig = MuteConfig.newBuilder().build();
      String muteConfigId = "muteConfigId1689669942";
      client.createMuteConfig(parent, muteConfig, muteConfigId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMuteConfigTest2() throws Exception {
    MuteConfig expectedResponse =
        MuteConfig.newBuilder()
            .setName(
                MuteConfigName.ofOrganizationMuteConfigName("[ORGANIZATION]", "[MUTE_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMostRecentEditor("mostRecentEditor-833861941")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    FolderName parent = FolderName.of("[FOLDER]");
    MuteConfig muteConfig = MuteConfig.newBuilder().build();
    String muteConfigId = "muteConfigId1689669942";

    MuteConfig actualResponse = client.createMuteConfig(parent, muteConfig, muteConfigId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMuteConfigRequest actualRequest = ((CreateMuteConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(muteConfig, actualRequest.getMuteConfig());
    Assert.assertEquals(muteConfigId, actualRequest.getMuteConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMuteConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      FolderName parent = FolderName.of("[FOLDER]");
      MuteConfig muteConfig = MuteConfig.newBuilder().build();
      String muteConfigId = "muteConfigId1689669942";
      client.createMuteConfig(parent, muteConfig, muteConfigId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMuteConfigTest3() throws Exception {
    MuteConfig expectedResponse =
        MuteConfig.newBuilder()
            .setName(
                MuteConfigName.ofOrganizationMuteConfigName("[ORGANIZATION]", "[MUTE_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMostRecentEditor("mostRecentEditor-833861941")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    MuteConfig muteConfig = MuteConfig.newBuilder().build();
    String muteConfigId = "muteConfigId1689669942";

    MuteConfig actualResponse = client.createMuteConfig(parent, muteConfig, muteConfigId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMuteConfigRequest actualRequest = ((CreateMuteConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(muteConfig, actualRequest.getMuteConfig());
    Assert.assertEquals(muteConfigId, actualRequest.getMuteConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMuteConfigExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      MuteConfig muteConfig = MuteConfig.newBuilder().build();
      String muteConfigId = "muteConfigId1689669942";
      client.createMuteConfig(parent, muteConfig, muteConfigId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMuteConfigTest4() throws Exception {
    MuteConfig expectedResponse =
        MuteConfig.newBuilder()
            .setName(
                MuteConfigName.ofOrganizationMuteConfigName("[ORGANIZATION]", "[MUTE_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMostRecentEditor("mostRecentEditor-833861941")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    MuteConfig muteConfig = MuteConfig.newBuilder().build();
    String muteConfigId = "muteConfigId1689669942";

    MuteConfig actualResponse = client.createMuteConfig(parent, muteConfig, muteConfigId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMuteConfigRequest actualRequest = ((CreateMuteConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(muteConfig, actualRequest.getMuteConfig());
    Assert.assertEquals(muteConfigId, actualRequest.getMuteConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMuteConfigExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      MuteConfig muteConfig = MuteConfig.newBuilder().build();
      String muteConfigId = "muteConfigId1689669942";
      client.createMuteConfig(parent, muteConfig, muteConfigId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMuteConfigTest5() throws Exception {
    MuteConfig expectedResponse =
        MuteConfig.newBuilder()
            .setName(
                MuteConfigName.ofOrganizationMuteConfigName("[ORGANIZATION]", "[MUTE_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMostRecentEditor("mostRecentEditor-833861941")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    MuteConfig muteConfig = MuteConfig.newBuilder().build();
    String muteConfigId = "muteConfigId1689669942";

    MuteConfig actualResponse = client.createMuteConfig(parent, muteConfig, muteConfigId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMuteConfigRequest actualRequest = ((CreateMuteConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(muteConfig, actualRequest.getMuteConfig());
    Assert.assertEquals(muteConfigId, actualRequest.getMuteConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMuteConfigExceptionTest5() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      MuteConfig muteConfig = MuteConfig.newBuilder().build();
      String muteConfigId = "muteConfigId1689669942";
      client.createMuteConfig(parent, muteConfig, muteConfigId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMuteConfigTest6() throws Exception {
    MuteConfig expectedResponse =
        MuteConfig.newBuilder()
            .setName(
                MuteConfigName.ofOrganizationMuteConfigName("[ORGANIZATION]", "[MUTE_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMostRecentEditor("mostRecentEditor-833861941")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    MuteConfig muteConfig = MuteConfig.newBuilder().build();
    String muteConfigId = "muteConfigId1689669942";

    MuteConfig actualResponse = client.createMuteConfig(parent, muteConfig, muteConfigId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMuteConfigRequest actualRequest = ((CreateMuteConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(muteConfig, actualRequest.getMuteConfig());
    Assert.assertEquals(muteConfigId, actualRequest.getMuteConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMuteConfigExceptionTest6() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      MuteConfig muteConfig = MuteConfig.newBuilder().build();
      String muteConfigId = "muteConfigId1689669942";
      client.createMuteConfig(parent, muteConfig, muteConfigId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMuteConfigTest7() throws Exception {
    MuteConfig expectedResponse =
        MuteConfig.newBuilder()
            .setName(
                MuteConfigName.ofOrganizationMuteConfigName("[ORGANIZATION]", "[MUTE_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMostRecentEditor("mostRecentEditor-833861941")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String parent = "parent-995424086";
    MuteConfig muteConfig = MuteConfig.newBuilder().build();
    String muteConfigId = "muteConfigId1689669942";

    MuteConfig actualResponse = client.createMuteConfig(parent, muteConfig, muteConfigId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMuteConfigRequest actualRequest = ((CreateMuteConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(muteConfig, actualRequest.getMuteConfig());
    Assert.assertEquals(muteConfigId, actualRequest.getMuteConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMuteConfigExceptionTest7() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String parent = "parent-995424086";
      MuteConfig muteConfig = MuteConfig.newBuilder().build();
      String muteConfigId = "muteConfigId1689669942";
      client.createMuteConfig(parent, muteConfig, muteConfigId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNotificationConfigTest() throws Exception {
    NotificationConfig expectedResponse =
        NotificationConfig.newBuilder()
            .setName(
                NotificationConfigName.ofOrganizationLocationNotificationConfigName(
                        "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setPubsubTopic("pubsubTopic255880396")
            .setServiceAccount("serviceAccount1079137720")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
    NotificationConfig notificationConfig = NotificationConfig.newBuilder().build();
    String configId = "configId-580140035";

    NotificationConfig actualResponse =
        client.createNotificationConfig(parent, notificationConfig, configId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNotificationConfigRequest actualRequest =
        ((CreateNotificationConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(notificationConfig, actualRequest.getNotificationConfig());
    Assert.assertEquals(configId, actualRequest.getConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNotificationConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      NotificationConfig notificationConfig = NotificationConfig.newBuilder().build();
      String configId = "configId-580140035";
      client.createNotificationConfig(parent, notificationConfig, configId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNotificationConfigTest2() throws Exception {
    NotificationConfig expectedResponse =
        NotificationConfig.newBuilder()
            .setName(
                NotificationConfigName.ofOrganizationLocationNotificationConfigName(
                        "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setPubsubTopic("pubsubTopic255880396")
            .setServiceAccount("serviceAccount1079137720")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    NotificationConfig notificationConfig = NotificationConfig.newBuilder().build();
    String configId = "configId-580140035";

    NotificationConfig actualResponse =
        client.createNotificationConfig(parent, notificationConfig, configId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNotificationConfigRequest actualRequest =
        ((CreateNotificationConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(notificationConfig, actualRequest.getNotificationConfig());
    Assert.assertEquals(configId, actualRequest.getConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNotificationConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      NotificationConfig notificationConfig = NotificationConfig.newBuilder().build();
      String configId = "configId-580140035";
      client.createNotificationConfig(parent, notificationConfig, configId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNotificationConfigTest3() throws Exception {
    NotificationConfig expectedResponse =
        NotificationConfig.newBuilder()
            .setName(
                NotificationConfigName.ofOrganizationLocationNotificationConfigName(
                        "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setPubsubTopic("pubsubTopic255880396")
            .setServiceAccount("serviceAccount1079137720")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
    NotificationConfig notificationConfig = NotificationConfig.newBuilder().build();
    String configId = "configId-580140035";

    NotificationConfig actualResponse =
        client.createNotificationConfig(parent, notificationConfig, configId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNotificationConfigRequest actualRequest =
        ((CreateNotificationConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(notificationConfig, actualRequest.getNotificationConfig());
    Assert.assertEquals(configId, actualRequest.getConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNotificationConfigExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      NotificationConfig notificationConfig = NotificationConfig.newBuilder().build();
      String configId = "configId-580140035";
      client.createNotificationConfig(parent, notificationConfig, configId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNotificationConfigTest4() throws Exception {
    NotificationConfig expectedResponse =
        NotificationConfig.newBuilder()
            .setName(
                NotificationConfigName.ofOrganizationLocationNotificationConfigName(
                        "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setPubsubTopic("pubsubTopic255880396")
            .setServiceAccount("serviceAccount1079137720")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String parent = "parent-995424086";
    NotificationConfig notificationConfig = NotificationConfig.newBuilder().build();
    String configId = "configId-580140035";

    NotificationConfig actualResponse =
        client.createNotificationConfig(parent, notificationConfig, configId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNotificationConfigRequest actualRequest =
        ((CreateNotificationConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(notificationConfig, actualRequest.getNotificationConfig());
    Assert.assertEquals(configId, actualRequest.getConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNotificationConfigExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String parent = "parent-995424086";
      NotificationConfig notificationConfig = NotificationConfig.newBuilder().build();
      String configId = "configId-580140035";
      client.createNotificationConfig(parent, notificationConfig, configId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSourceTest() throws Exception {
    Source expectedResponse =
        Source.newBuilder()
            .setName(SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCanonicalName("canonicalName2122381727")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    Source source = Source.newBuilder().build();

    Source actualResponse = client.createSource(parent, source);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSourceRequest actualRequest = ((CreateSourceRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(source, actualRequest.getSource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      Source source = Source.newBuilder().build();
      client.createSource(parent, source);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSourceTest2() throws Exception {
    Source expectedResponse =
        Source.newBuilder()
            .setName(SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCanonicalName("canonicalName2122381727")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Source source = Source.newBuilder().build();

    Source actualResponse = client.createSource(parent, source);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSourceRequest actualRequest = ((CreateSourceRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(source, actualRequest.getSource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSourceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String parent = "parent-995424086";
      Source source = Source.newBuilder().build();
      client.createSource(parent, source);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBigQueryExportTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSecurityCenter.addResponse(expectedResponse);

    BigQueryExportName name =
        BigQueryExportName.ofOrganizationLocationExportName(
            "[ORGANIZATION]", "[LOCATION]", "[EXPORT]");

    client.deleteBigQueryExport(name);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBigQueryExportRequest actualRequest =
        ((DeleteBigQueryExportRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBigQueryExportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      BigQueryExportName name =
          BigQueryExportName.ofOrganizationLocationExportName(
              "[ORGANIZATION]", "[LOCATION]", "[EXPORT]");
      client.deleteBigQueryExport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBigQueryExportTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSecurityCenter.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteBigQueryExport(name);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBigQueryExportRequest actualRequest =
        ((DeleteBigQueryExportRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBigQueryExportExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String name = "name3373707";
      client.deleteBigQueryExport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMuteConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSecurityCenter.addResponse(expectedResponse);

    MuteConfigName name =
        MuteConfigName.ofOrganizationMuteConfigName("[ORGANIZATION]", "[MUTE_CONFIG]");

    client.deleteMuteConfig(name);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMuteConfigRequest actualRequest = ((DeleteMuteConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMuteConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      MuteConfigName name =
          MuteConfigName.ofOrganizationMuteConfigName("[ORGANIZATION]", "[MUTE_CONFIG]");
      client.deleteMuteConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMuteConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSecurityCenter.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteMuteConfig(name);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMuteConfigRequest actualRequest = ((DeleteMuteConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMuteConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String name = "name3373707";
      client.deleteMuteConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteNotificationConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSecurityCenter.addResponse(expectedResponse);

    NotificationConfigName name =
        NotificationConfigName.ofOrganizationLocationNotificationConfigName(
            "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION_CONFIG]");

    client.deleteNotificationConfig(name);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNotificationConfigRequest actualRequest =
        ((DeleteNotificationConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNotificationConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      NotificationConfigName name =
          NotificationConfigName.ofOrganizationLocationNotificationConfigName(
              "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION_CONFIG]");
      client.deleteNotificationConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteNotificationConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSecurityCenter.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteNotificationConfig(name);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNotificationConfigRequest actualRequest =
        ((DeleteNotificationConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNotificationConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String name = "name3373707";
      client.deleteNotificationConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteResourceValueConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSecurityCenter.addResponse(expectedResponse);

    ResourceValueConfigName name =
        ResourceValueConfigName.of("[ORGANIZATION]", "[RESOURCE_VALUE_CONFIG]");

    client.deleteResourceValueConfig(name);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteResourceValueConfigRequest actualRequest =
        ((DeleteResourceValueConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteResourceValueConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      ResourceValueConfigName name =
          ResourceValueConfigName.of("[ORGANIZATION]", "[RESOURCE_VALUE_CONFIG]");
      client.deleteResourceValueConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteResourceValueConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockSecurityCenter.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteResourceValueConfig(name);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteResourceValueConfigRequest actualRequest =
        ((DeleteResourceValueConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteResourceValueConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String name = "name3373707";
      client.deleteResourceValueConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBigQueryExportTest() throws Exception {
    BigQueryExport expectedResponse =
        BigQueryExport.newBuilder()
            .setName(
                BigQueryExportName.ofOrganizationLocationExportName(
                        "[ORGANIZATION]", "[LOCATION]", "[EXPORT]")
                    .toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setDataset("dataset1443214456")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMostRecentEditor("mostRecentEditor-833861941")
            .setPrincipal("principal-1812041682")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    BigQueryExportName name =
        BigQueryExportName.ofOrganizationLocationExportName(
            "[ORGANIZATION]", "[LOCATION]", "[EXPORT]");

    BigQueryExport actualResponse = client.getBigQueryExport(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBigQueryExportRequest actualRequest = ((GetBigQueryExportRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBigQueryExportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      BigQueryExportName name =
          BigQueryExportName.ofOrganizationLocationExportName(
              "[ORGANIZATION]", "[LOCATION]", "[EXPORT]");
      client.getBigQueryExport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBigQueryExportTest2() throws Exception {
    BigQueryExport expectedResponse =
        BigQueryExport.newBuilder()
            .setName(
                BigQueryExportName.ofOrganizationLocationExportName(
                        "[ORGANIZATION]", "[LOCATION]", "[EXPORT]")
                    .toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setDataset("dataset1443214456")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMostRecentEditor("mostRecentEditor-833861941")
            .setPrincipal("principal-1812041682")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String name = "name3373707";

    BigQueryExport actualResponse = client.getBigQueryExport(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBigQueryExportRequest actualRequest = ((GetBigQueryExportRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBigQueryExportExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String name = "name3373707";
      client.getBigQueryExport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSimulationTest() throws Exception {
    Simulation expectedResponse =
        Simulation.newBuilder()
            .setName(SimulationName.of("[ORGANIZATION]", "[SIMULATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllResourceValueConfigsMetadata(new ArrayList<ResourceValueConfigMetadata>())
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    SimulationName name = SimulationName.of("[ORGANIZATION]", "[SIMULATION]");

    Simulation actualResponse = client.getSimulation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSimulationRequest actualRequest = ((GetSimulationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSimulationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      SimulationName name = SimulationName.of("[ORGANIZATION]", "[SIMULATION]");
      client.getSimulation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSimulationTest2() throws Exception {
    Simulation expectedResponse =
        Simulation.newBuilder()
            .setName(SimulationName.of("[ORGANIZATION]", "[SIMULATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllResourceValueConfigsMetadata(new ArrayList<ResourceValueConfigMetadata>())
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String name = "name3373707";

    Simulation actualResponse = client.getSimulation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSimulationRequest actualRequest = ((GetSimulationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSimulationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String name = "name3373707";
      client.getSimulation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getValuedResourceTest() throws Exception {
    ValuedResource expectedResponse =
        ValuedResource.newBuilder()
            .setName(
                ValuedResourceName.of("[ORGANIZATION]", "[SIMULATION]", "[VALUED_RESOURCE]")
                    .toString())
            .setResource("resource-341064690")
            .setResourceType("resourceType-384364440")
            .setDisplayName("displayName1714148973")
            .setExposedScore(-1375686989)
            .addAllResourceValueConfigsUsed(new ArrayList<ResourceValueConfigMetadata>())
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    ValuedResourceName name =
        ValuedResourceName.of("[ORGANIZATION]", "[SIMULATION]", "[VALUED_RESOURCE]");

    ValuedResource actualResponse = client.getValuedResource(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetValuedResourceRequest actualRequest = ((GetValuedResourceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getValuedResourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      ValuedResourceName name =
          ValuedResourceName.of("[ORGANIZATION]", "[SIMULATION]", "[VALUED_RESOURCE]");
      client.getValuedResource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getValuedResourceTest2() throws Exception {
    ValuedResource expectedResponse =
        ValuedResource.newBuilder()
            .setName(
                ValuedResourceName.of("[ORGANIZATION]", "[SIMULATION]", "[VALUED_RESOURCE]")
                    .toString())
            .setResource("resource-341064690")
            .setResourceType("resourceType-384364440")
            .setDisplayName("displayName1714148973")
            .setExposedScore(-1375686989)
            .addAllResourceValueConfigsUsed(new ArrayList<ResourceValueConfigMetadata>())
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String name = "name3373707";

    ValuedResource actualResponse = client.getValuedResource(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetValuedResourceRequest actualRequest = ((GetValuedResourceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getValuedResourceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String name = "name3373707";
      client.getValuedResource(name);
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
    mockSecurityCenter.addResponse(expectedResponse);

    ResourceName resource = SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]");

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      ResourceName resource = SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]");
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
    mockSecurityCenter.addResponse(expectedResponse);

    String resource = "resource-341064690";

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIamPolicyRequest actualRequest = ((GetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIamPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String resource = "resource-341064690";
      client.getIamPolicy(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMuteConfigTest() throws Exception {
    MuteConfig expectedResponse =
        MuteConfig.newBuilder()
            .setName(
                MuteConfigName.ofOrganizationMuteConfigName("[ORGANIZATION]", "[MUTE_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMostRecentEditor("mostRecentEditor-833861941")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    MuteConfigName name =
        MuteConfigName.ofOrganizationMuteConfigName("[ORGANIZATION]", "[MUTE_CONFIG]");

    MuteConfig actualResponse = client.getMuteConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMuteConfigRequest actualRequest = ((GetMuteConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMuteConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      MuteConfigName name =
          MuteConfigName.ofOrganizationMuteConfigName("[ORGANIZATION]", "[MUTE_CONFIG]");
      client.getMuteConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMuteConfigTest2() throws Exception {
    MuteConfig expectedResponse =
        MuteConfig.newBuilder()
            .setName(
                MuteConfigName.ofOrganizationMuteConfigName("[ORGANIZATION]", "[MUTE_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMostRecentEditor("mostRecentEditor-833861941")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String name = "name3373707";

    MuteConfig actualResponse = client.getMuteConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMuteConfigRequest actualRequest = ((GetMuteConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMuteConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String name = "name3373707";
      client.getMuteConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNotificationConfigTest() throws Exception {
    NotificationConfig expectedResponse =
        NotificationConfig.newBuilder()
            .setName(
                NotificationConfigName.ofOrganizationLocationNotificationConfigName(
                        "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setPubsubTopic("pubsubTopic255880396")
            .setServiceAccount("serviceAccount1079137720")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    NotificationConfigName name =
        NotificationConfigName.ofOrganizationLocationNotificationConfigName(
            "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION_CONFIG]");

    NotificationConfig actualResponse = client.getNotificationConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNotificationConfigRequest actualRequest =
        ((GetNotificationConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNotificationConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      NotificationConfigName name =
          NotificationConfigName.ofOrganizationLocationNotificationConfigName(
              "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION_CONFIG]");
      client.getNotificationConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNotificationConfigTest2() throws Exception {
    NotificationConfig expectedResponse =
        NotificationConfig.newBuilder()
            .setName(
                NotificationConfigName.ofOrganizationLocationNotificationConfigName(
                        "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setPubsubTopic("pubsubTopic255880396")
            .setServiceAccount("serviceAccount1079137720")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String name = "name3373707";

    NotificationConfig actualResponse = client.getNotificationConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNotificationConfigRequest actualRequest =
        ((GetNotificationConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNotificationConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String name = "name3373707";
      client.getNotificationConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getResourceValueConfigTest() throws Exception {
    ResourceValueConfig expectedResponse =
        ResourceValueConfig.newBuilder()
            .setName(
                ResourceValueConfigName.of("[ORGANIZATION]", "[RESOURCE_VALUE_CONFIG]").toString())
            .setResourceValue(ResourceValue.forNumber(0))
            .addAllTagValues(new ArrayList<String>())
            .setResourceType("resourceType-384364440")
            .setScope("scope109264468")
            .putAllResourceLabelsSelector(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSensitiveDataProtectionMapping(
                ResourceValueConfig.SensitiveDataProtectionMapping.newBuilder().build())
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    ResourceValueConfigName name =
        ResourceValueConfigName.of("[ORGANIZATION]", "[RESOURCE_VALUE_CONFIG]");

    ResourceValueConfig actualResponse = client.getResourceValueConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetResourceValueConfigRequest actualRequest =
        ((GetResourceValueConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getResourceValueConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      ResourceValueConfigName name =
          ResourceValueConfigName.of("[ORGANIZATION]", "[RESOURCE_VALUE_CONFIG]");
      client.getResourceValueConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getResourceValueConfigTest2() throws Exception {
    ResourceValueConfig expectedResponse =
        ResourceValueConfig.newBuilder()
            .setName(
                ResourceValueConfigName.of("[ORGANIZATION]", "[RESOURCE_VALUE_CONFIG]").toString())
            .setResourceValue(ResourceValue.forNumber(0))
            .addAllTagValues(new ArrayList<String>())
            .setResourceType("resourceType-384364440")
            .setScope("scope109264468")
            .putAllResourceLabelsSelector(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSensitiveDataProtectionMapping(
                ResourceValueConfig.SensitiveDataProtectionMapping.newBuilder().build())
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String name = "name3373707";

    ResourceValueConfig actualResponse = client.getResourceValueConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetResourceValueConfigRequest actualRequest =
        ((GetResourceValueConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getResourceValueConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String name = "name3373707";
      client.getResourceValueConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSourceTest() throws Exception {
    Source expectedResponse =
        Source.newBuilder()
            .setName(SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCanonicalName("canonicalName2122381727")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    SourceName name = SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]");

    Source actualResponse = client.getSource(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSourceRequest actualRequest = ((GetSourceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      SourceName name = SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]");
      client.getSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSourceTest2() throws Exception {
    Source expectedResponse =
        Source.newBuilder()
            .setName(SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCanonicalName("canonicalName2122381727")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String name = "name3373707";

    Source actualResponse = client.getSource(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSourceRequest actualRequest = ((GetSourceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSourceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String name = "name3373707";
      client.getSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void groupFindingsTest() throws Exception {
    GroupResult responsesElement = GroupResult.newBuilder().build();
    GroupFindingsResponse expectedResponse =
        GroupFindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGroupByResults(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    SourceName parent = SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]");
    String groupBy = "groupBy293428022";

    GroupFindingsPagedResponse pagedListResponse = client.groupFindings(parent, groupBy);

    List<GroupResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGroupByResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GroupFindingsRequest actualRequest = ((GroupFindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(groupBy, actualRequest.getGroupBy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void groupFindingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      SourceName parent = SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]");
      String groupBy = "groupBy293428022";
      client.groupFindings(parent, groupBy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void groupFindingsTest2() throws Exception {
    GroupResult responsesElement = GroupResult.newBuilder().build();
    GroupFindingsResponse expectedResponse =
        GroupFindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGroupByResults(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String groupBy = "groupBy293428022";

    GroupFindingsPagedResponse pagedListResponse = client.groupFindings(parent, groupBy);

    List<GroupResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGroupByResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GroupFindingsRequest actualRequest = ((GroupFindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(groupBy, actualRequest.getGroupBy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void groupFindingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String parent = "parent-995424086";
      String groupBy = "groupBy293428022";
      client.groupFindings(parent, groupBy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAttackPathsTest() throws Exception {
    AttackPath responsesElement = AttackPath.newBuilder().build();
    ListAttackPathsResponse expectedResponse =
        ListAttackPathsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAttackPaths(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    ValuedResourceName parent =
        ValuedResourceName.of("[ORGANIZATION]", "[SIMULATION]", "[VALUED_RESOURCE]");

    ListAttackPathsPagedResponse pagedListResponse = client.listAttackPaths(parent);

    List<AttackPath> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAttackPathsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAttackPathsRequest actualRequest = ((ListAttackPathsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAttackPathsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      ValuedResourceName parent =
          ValuedResourceName.of("[ORGANIZATION]", "[SIMULATION]", "[VALUED_RESOURCE]");
      client.listAttackPaths(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAttackPathsTest2() throws Exception {
    AttackPath responsesElement = AttackPath.newBuilder().build();
    ListAttackPathsResponse expectedResponse =
        ListAttackPathsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAttackPaths(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAttackPathsPagedResponse pagedListResponse = client.listAttackPaths(parent);

    List<AttackPath> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAttackPathsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAttackPathsRequest actualRequest = ((ListAttackPathsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAttackPathsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAttackPaths(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBigQueryExportsTest() throws Exception {
    BigQueryExport responsesElement = BigQueryExport.newBuilder().build();
    ListBigQueryExportsResponse expectedResponse =
        ListBigQueryExportsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBigQueryExports(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");

    ListBigQueryExportsPagedResponse pagedListResponse = client.listBigQueryExports(parent);

    List<BigQueryExport> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBigQueryExportsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBigQueryExportsRequest actualRequest = ((ListBigQueryExportsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBigQueryExportsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      client.listBigQueryExports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBigQueryExportsTest2() throws Exception {
    BigQueryExport responsesElement = BigQueryExport.newBuilder().build();
    ListBigQueryExportsResponse expectedResponse =
        ListBigQueryExportsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBigQueryExports(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListBigQueryExportsPagedResponse pagedListResponse = client.listBigQueryExports(parent);

    List<BigQueryExport> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBigQueryExportsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBigQueryExportsRequest actualRequest = ((ListBigQueryExportsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBigQueryExportsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listBigQueryExports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBigQueryExportsTest3() throws Exception {
    BigQueryExport responsesElement = BigQueryExport.newBuilder().build();
    ListBigQueryExportsResponse expectedResponse =
        ListBigQueryExportsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBigQueryExports(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListBigQueryExportsPagedResponse pagedListResponse = client.listBigQueryExports(parent);

    List<BigQueryExport> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBigQueryExportsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBigQueryExportsRequest actualRequest = ((ListBigQueryExportsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBigQueryExportsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listBigQueryExports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBigQueryExportsTest4() throws Exception {
    BigQueryExport responsesElement = BigQueryExport.newBuilder().build();
    ListBigQueryExportsResponse expectedResponse =
        ListBigQueryExportsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBigQueryExports(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBigQueryExportsPagedResponse pagedListResponse = client.listBigQueryExports(parent);

    List<BigQueryExport> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBigQueryExportsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBigQueryExportsRequest actualRequest = ((ListBigQueryExportsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBigQueryExportsExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBigQueryExports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFindingsTest() throws Exception {
    ListFindingsResponse.ListFindingsResult responsesElement =
        ListFindingsResponse.ListFindingsResult.newBuilder().build();
    ListFindingsResponse expectedResponse =
        ListFindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllListFindingsResults(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    SourceName parent = SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]");

    ListFindingsPagedResponse pagedListResponse = client.listFindings(parent);

    List<ListFindingsResponse.ListFindingsResult> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getListFindingsResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFindingsRequest actualRequest = ((ListFindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFindingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      SourceName parent = SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]");
      client.listFindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFindingsTest2() throws Exception {
    ListFindingsResponse.ListFindingsResult responsesElement =
        ListFindingsResponse.ListFindingsResult.newBuilder().build();
    ListFindingsResponse expectedResponse =
        ListFindingsResponse.newBuilder()
            .setNextPageToken("")
            .addAllListFindingsResults(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListFindingsPagedResponse pagedListResponse = client.listFindings(parent);

    List<ListFindingsResponse.ListFindingsResult> resources =
        Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getListFindingsResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFindingsRequest actualRequest = ((ListFindingsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFindingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listFindings(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMuteConfigsTest() throws Exception {
    MuteConfig responsesElement = MuteConfig.newBuilder().build();
    ListMuteConfigsResponse expectedResponse =
        ListMuteConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMuteConfigs(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");

    ListMuteConfigsPagedResponse pagedListResponse = client.listMuteConfigs(parent);

    List<MuteConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMuteConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMuteConfigsRequest actualRequest = ((ListMuteConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMuteConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      client.listMuteConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMuteConfigsTest2() throws Exception {
    MuteConfig responsesElement = MuteConfig.newBuilder().build();
    ListMuteConfigsResponse expectedResponse =
        ListMuteConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMuteConfigs(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    FolderName parent = FolderName.of("[FOLDER]");

    ListMuteConfigsPagedResponse pagedListResponse = client.listMuteConfigs(parent);

    List<MuteConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMuteConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMuteConfigsRequest actualRequest = ((ListMuteConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMuteConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      FolderName parent = FolderName.of("[FOLDER]");
      client.listMuteConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMuteConfigsTest3() throws Exception {
    MuteConfig responsesElement = MuteConfig.newBuilder().build();
    ListMuteConfigsResponse expectedResponse =
        ListMuteConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMuteConfigs(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListMuteConfigsPagedResponse pagedListResponse = client.listMuteConfigs(parent);

    List<MuteConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMuteConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMuteConfigsRequest actualRequest = ((ListMuteConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMuteConfigsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listMuteConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMuteConfigsTest4() throws Exception {
    MuteConfig responsesElement = MuteConfig.newBuilder().build();
    ListMuteConfigsResponse expectedResponse =
        ListMuteConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMuteConfigs(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListMuteConfigsPagedResponse pagedListResponse = client.listMuteConfigs(parent);

    List<MuteConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMuteConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMuteConfigsRequest actualRequest = ((ListMuteConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMuteConfigsExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listMuteConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMuteConfigsTest5() throws Exception {
    MuteConfig responsesElement = MuteConfig.newBuilder().build();
    ListMuteConfigsResponse expectedResponse =
        ListMuteConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMuteConfigs(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListMuteConfigsPagedResponse pagedListResponse = client.listMuteConfigs(parent);

    List<MuteConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMuteConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMuteConfigsRequest actualRequest = ((ListMuteConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMuteConfigsExceptionTest5() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listMuteConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMuteConfigsTest6() throws Exception {
    MuteConfig responsesElement = MuteConfig.newBuilder().build();
    ListMuteConfigsResponse expectedResponse =
        ListMuteConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMuteConfigs(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListMuteConfigsPagedResponse pagedListResponse = client.listMuteConfigs(parent);

    List<MuteConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMuteConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMuteConfigsRequest actualRequest = ((ListMuteConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMuteConfigsExceptionTest6() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listMuteConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMuteConfigsTest7() throws Exception {
    MuteConfig responsesElement = MuteConfig.newBuilder().build();
    ListMuteConfigsResponse expectedResponse =
        ListMuteConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMuteConfigs(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMuteConfigsPagedResponse pagedListResponse = client.listMuteConfigs(parent);

    List<MuteConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMuteConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMuteConfigsRequest actualRequest = ((ListMuteConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMuteConfigsExceptionTest7() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMuteConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNotificationConfigsTest() throws Exception {
    NotificationConfig responsesElement = NotificationConfig.newBuilder().build();
    ListNotificationConfigsResponse expectedResponse =
        ListNotificationConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllNotificationConfigs(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");

    ListNotificationConfigsPagedResponse pagedListResponse = client.listNotificationConfigs(parent);

    List<NotificationConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNotificationConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotificationConfigsRequest actualRequest =
        ((ListNotificationConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNotificationConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      client.listNotificationConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNotificationConfigsTest2() throws Exception {
    NotificationConfig responsesElement = NotificationConfig.newBuilder().build();
    ListNotificationConfigsResponse expectedResponse =
        ListNotificationConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllNotificationConfigs(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListNotificationConfigsPagedResponse pagedListResponse = client.listNotificationConfigs(parent);

    List<NotificationConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNotificationConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotificationConfigsRequest actualRequest =
        ((ListNotificationConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNotificationConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listNotificationConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNotificationConfigsTest3() throws Exception {
    NotificationConfig responsesElement = NotificationConfig.newBuilder().build();
    ListNotificationConfigsResponse expectedResponse =
        ListNotificationConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllNotificationConfigs(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListNotificationConfigsPagedResponse pagedListResponse = client.listNotificationConfigs(parent);

    List<NotificationConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNotificationConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotificationConfigsRequest actualRequest =
        ((ListNotificationConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNotificationConfigsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listNotificationConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNotificationConfigsTest4() throws Exception {
    NotificationConfig responsesElement = NotificationConfig.newBuilder().build();
    ListNotificationConfigsResponse expectedResponse =
        ListNotificationConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllNotificationConfigs(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListNotificationConfigsPagedResponse pagedListResponse = client.listNotificationConfigs(parent);

    List<NotificationConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNotificationConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNotificationConfigsRequest actualRequest =
        ((ListNotificationConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNotificationConfigsExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listNotificationConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listResourceValueConfigsTest() throws Exception {
    ResourceValueConfig responsesElement = ResourceValueConfig.newBuilder().build();
    ListResourceValueConfigsResponse expectedResponse =
        ListResourceValueConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllResourceValueConfigs(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListResourceValueConfigsPagedResponse pagedListResponse =
        client.listResourceValueConfigs(parent);

    List<ResourceValueConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourceValueConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListResourceValueConfigsRequest actualRequest =
        ((ListResourceValueConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listResourceValueConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listResourceValueConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listResourceValueConfigsTest2() throws Exception {
    ResourceValueConfig responsesElement = ResourceValueConfig.newBuilder().build();
    ListResourceValueConfigsResponse expectedResponse =
        ListResourceValueConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllResourceValueConfigs(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListResourceValueConfigsPagedResponse pagedListResponse =
        client.listResourceValueConfigs(parent);

    List<ResourceValueConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResourceValueConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListResourceValueConfigsRequest actualRequest =
        ((ListResourceValueConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listResourceValueConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listResourceValueConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSourcesTest() throws Exception {
    Source responsesElement = Source.newBuilder().build();
    ListSourcesResponse expectedResponse =
        ListSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSources(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    FolderName parent = FolderName.of("[FOLDER]");

    ListSourcesPagedResponse pagedListResponse = client.listSources(parent);

    List<Source> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSourcesRequest actualRequest = ((ListSourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSourcesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      FolderName parent = FolderName.of("[FOLDER]");
      client.listSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSourcesTest2() throws Exception {
    Source responsesElement = Source.newBuilder().build();
    ListSourcesResponse expectedResponse =
        ListSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSources(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListSourcesPagedResponse pagedListResponse = client.listSources(parent);

    List<Source> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSourcesRequest actualRequest = ((ListSourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSourcesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSourcesTest3() throws Exception {
    Source responsesElement = Source.newBuilder().build();
    ListSourcesResponse expectedResponse =
        ListSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSources(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListSourcesPagedResponse pagedListResponse = client.listSources(parent);

    List<Source> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSourcesRequest actualRequest = ((ListSourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSourcesExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSourcesTest4() throws Exception {
    Source responsesElement = Source.newBuilder().build();
    ListSourcesResponse expectedResponse =
        ListSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSources(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSourcesPagedResponse pagedListResponse = client.listSources(parent);

    List<Source> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSourcesRequest actualRequest = ((ListSourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSourcesExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listValuedResourcesTest() throws Exception {
    ValuedResource responsesElement = ValuedResource.newBuilder().build();
    ListValuedResourcesResponse expectedResponse =
        ListValuedResourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllValuedResources(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    SimulationName parent = SimulationName.of("[ORGANIZATION]", "[SIMULATION]");

    ListValuedResourcesPagedResponse pagedListResponse = client.listValuedResources(parent);

    List<ValuedResource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getValuedResourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListValuedResourcesRequest actualRequest = ((ListValuedResourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listValuedResourcesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      SimulationName parent = SimulationName.of("[ORGANIZATION]", "[SIMULATION]");
      client.listValuedResources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listValuedResourcesTest2() throws Exception {
    ValuedResource responsesElement = ValuedResource.newBuilder().build();
    ListValuedResourcesResponse expectedResponse =
        ListValuedResourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllValuedResources(Arrays.asList(responsesElement))
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListValuedResourcesPagedResponse pagedListResponse = client.listValuedResources(parent);

    List<ValuedResource> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getValuedResourcesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListValuedResourcesRequest actualRequest = ((ListValuedResourcesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listValuedResourcesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listValuedResources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setFindingStateTest() throws Exception {
    Finding expectedResponse =
        Finding.newBuilder()
            .setName(
                FindingName.ofOrganizationSourceFindingName(
                        "[ORGANIZATION]", "[SOURCE]", "[FINDING]")
                    .toString())
            .setCanonicalName("canonicalName2122381727")
            .setParent("parent-995424086")
            .setResourceName("resourceName-384566343")
            .setCategory("category50511102")
            .setExternalUri("externalUri-1153085023")
            .putAllSourceProperties(new HashMap<String, Value>())
            .setSecurityMarks(SecurityMarks.newBuilder().build())
            .setEventTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setIndicator(Indicator.newBuilder().build())
            .setVulnerability(Vulnerability.newBuilder().build())
            .setMuteUpdateTime(Timestamp.newBuilder().build())
            .putAllExternalSystems(new HashMap<String, ExternalSystem>())
            .setMitreAttack(MitreAttack.newBuilder().build())
            .setAccess(Access.newBuilder().build())
            .addAllConnections(new ArrayList<Connection>())
            .setMuteInitiator("muteInitiator1395645462")
            .addAllProcesses(new ArrayList<Process>())
            .putAllContacts(new HashMap<String, ContactDetails>())
            .addAllCompliances(new ArrayList<Compliance>())
            .setParentDisplayName("parentDisplayName-1523759261")
            .setDescription("description-1724546052")
            .setExfiltration(Exfiltration.newBuilder().build())
            .addAllIamBindings(new ArrayList<IamBinding>())
            .setNextSteps("nextSteps1206138868")
            .setModuleName("moduleName-870351081")
            .addAllContainers(new ArrayList<Container>())
            .setKubernetes(Kubernetes.newBuilder().build())
            .setDatabase(Database.newBuilder().build())
            .setAttackExposure(AttackExposure.newBuilder().build())
            .addAllFiles(new ArrayList<File>())
            .setCloudDlpInspection(CloudDlpInspection.newBuilder().build())
            .setCloudDlpDataProfile(CloudDlpDataProfile.newBuilder().build())
            .setKernelRootkit(KernelRootkit.newBuilder().build())
            .addAllOrgPolicies(new ArrayList<OrgPolicy>())
            .setApplication(Application.newBuilder().build())
            .setBackupDisasterRecovery(BackupDisasterRecovery.newBuilder().build())
            .setSecurityPosture(SecurityPosture.newBuilder().build())
            .addAllLogEntries(new ArrayList<LogEntry>())
            .addAllLoadBalancers(new ArrayList<LoadBalancer>())
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    FindingName name =
        FindingName.ofOrganizationSourceFindingName("[ORGANIZATION]", "[SOURCE]", "[FINDING]");
    Finding.State state = Finding.State.forNumber(0);

    Finding actualResponse = client.setFindingState(name, state);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetFindingStateRequest actualRequest = ((SetFindingStateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(state, actualRequest.getState());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setFindingStateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      FindingName name =
          FindingName.ofOrganizationSourceFindingName("[ORGANIZATION]", "[SOURCE]", "[FINDING]");
      Finding.State state = Finding.State.forNumber(0);
      client.setFindingState(name, state);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setFindingStateTest2() throws Exception {
    Finding expectedResponse =
        Finding.newBuilder()
            .setName(
                FindingName.ofOrganizationSourceFindingName(
                        "[ORGANIZATION]", "[SOURCE]", "[FINDING]")
                    .toString())
            .setCanonicalName("canonicalName2122381727")
            .setParent("parent-995424086")
            .setResourceName("resourceName-384566343")
            .setCategory("category50511102")
            .setExternalUri("externalUri-1153085023")
            .putAllSourceProperties(new HashMap<String, Value>())
            .setSecurityMarks(SecurityMarks.newBuilder().build())
            .setEventTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setIndicator(Indicator.newBuilder().build())
            .setVulnerability(Vulnerability.newBuilder().build())
            .setMuteUpdateTime(Timestamp.newBuilder().build())
            .putAllExternalSystems(new HashMap<String, ExternalSystem>())
            .setMitreAttack(MitreAttack.newBuilder().build())
            .setAccess(Access.newBuilder().build())
            .addAllConnections(new ArrayList<Connection>())
            .setMuteInitiator("muteInitiator1395645462")
            .addAllProcesses(new ArrayList<Process>())
            .putAllContacts(new HashMap<String, ContactDetails>())
            .addAllCompliances(new ArrayList<Compliance>())
            .setParentDisplayName("parentDisplayName-1523759261")
            .setDescription("description-1724546052")
            .setExfiltration(Exfiltration.newBuilder().build())
            .addAllIamBindings(new ArrayList<IamBinding>())
            .setNextSteps("nextSteps1206138868")
            .setModuleName("moduleName-870351081")
            .addAllContainers(new ArrayList<Container>())
            .setKubernetes(Kubernetes.newBuilder().build())
            .setDatabase(Database.newBuilder().build())
            .setAttackExposure(AttackExposure.newBuilder().build())
            .addAllFiles(new ArrayList<File>())
            .setCloudDlpInspection(CloudDlpInspection.newBuilder().build())
            .setCloudDlpDataProfile(CloudDlpDataProfile.newBuilder().build())
            .setKernelRootkit(KernelRootkit.newBuilder().build())
            .addAllOrgPolicies(new ArrayList<OrgPolicy>())
            .setApplication(Application.newBuilder().build())
            .setBackupDisasterRecovery(BackupDisasterRecovery.newBuilder().build())
            .setSecurityPosture(SecurityPosture.newBuilder().build())
            .addAllLogEntries(new ArrayList<LogEntry>())
            .addAllLoadBalancers(new ArrayList<LoadBalancer>())
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String name = "name3373707";
    Finding.State state = Finding.State.forNumber(0);

    Finding actualResponse = client.setFindingState(name, state);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetFindingStateRequest actualRequest = ((SetFindingStateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(state, actualRequest.getState());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setFindingStateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String name = "name3373707";
      Finding.State state = Finding.State.forNumber(0);
      client.setFindingState(name, state);
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
    mockSecurityCenter.addResponse(expectedResponse);

    ResourceName resource = SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]");
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      ResourceName resource = SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]");
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
    mockSecurityCenter.addResponse(expectedResponse);

    String resource = "resource-341064690";
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetIamPolicyRequest actualRequest = ((SetIamPolicyRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertEquals(policy, actualRequest.getPolicy());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setIamPolicyExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String resource = "resource-341064690";
      Policy policy = Policy.newBuilder().build();
      client.setIamPolicy(resource, policy);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setMuteTest() throws Exception {
    Finding expectedResponse =
        Finding.newBuilder()
            .setName(
                FindingName.ofOrganizationSourceFindingName(
                        "[ORGANIZATION]", "[SOURCE]", "[FINDING]")
                    .toString())
            .setCanonicalName("canonicalName2122381727")
            .setParent("parent-995424086")
            .setResourceName("resourceName-384566343")
            .setCategory("category50511102")
            .setExternalUri("externalUri-1153085023")
            .putAllSourceProperties(new HashMap<String, Value>())
            .setSecurityMarks(SecurityMarks.newBuilder().build())
            .setEventTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setIndicator(Indicator.newBuilder().build())
            .setVulnerability(Vulnerability.newBuilder().build())
            .setMuteUpdateTime(Timestamp.newBuilder().build())
            .putAllExternalSystems(new HashMap<String, ExternalSystem>())
            .setMitreAttack(MitreAttack.newBuilder().build())
            .setAccess(Access.newBuilder().build())
            .addAllConnections(new ArrayList<Connection>())
            .setMuteInitiator("muteInitiator1395645462")
            .addAllProcesses(new ArrayList<Process>())
            .putAllContacts(new HashMap<String, ContactDetails>())
            .addAllCompliances(new ArrayList<Compliance>())
            .setParentDisplayName("parentDisplayName-1523759261")
            .setDescription("description-1724546052")
            .setExfiltration(Exfiltration.newBuilder().build())
            .addAllIamBindings(new ArrayList<IamBinding>())
            .setNextSteps("nextSteps1206138868")
            .setModuleName("moduleName-870351081")
            .addAllContainers(new ArrayList<Container>())
            .setKubernetes(Kubernetes.newBuilder().build())
            .setDatabase(Database.newBuilder().build())
            .setAttackExposure(AttackExposure.newBuilder().build())
            .addAllFiles(new ArrayList<File>())
            .setCloudDlpInspection(CloudDlpInspection.newBuilder().build())
            .setCloudDlpDataProfile(CloudDlpDataProfile.newBuilder().build())
            .setKernelRootkit(KernelRootkit.newBuilder().build())
            .addAllOrgPolicies(new ArrayList<OrgPolicy>())
            .setApplication(Application.newBuilder().build())
            .setBackupDisasterRecovery(BackupDisasterRecovery.newBuilder().build())
            .setSecurityPosture(SecurityPosture.newBuilder().build())
            .addAllLogEntries(new ArrayList<LogEntry>())
            .addAllLoadBalancers(new ArrayList<LoadBalancer>())
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    FindingName name =
        FindingName.ofOrganizationSourceFindingName("[ORGANIZATION]", "[SOURCE]", "[FINDING]");
    Finding.Mute mute = Finding.Mute.forNumber(0);

    Finding actualResponse = client.setMute(name, mute);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetMuteRequest actualRequest = ((SetMuteRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(mute, actualRequest.getMute());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setMuteExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      FindingName name =
          FindingName.ofOrganizationSourceFindingName("[ORGANIZATION]", "[SOURCE]", "[FINDING]");
      Finding.Mute mute = Finding.Mute.forNumber(0);
      client.setMute(name, mute);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setMuteTest2() throws Exception {
    Finding expectedResponse =
        Finding.newBuilder()
            .setName(
                FindingName.ofOrganizationSourceFindingName(
                        "[ORGANIZATION]", "[SOURCE]", "[FINDING]")
                    .toString())
            .setCanonicalName("canonicalName2122381727")
            .setParent("parent-995424086")
            .setResourceName("resourceName-384566343")
            .setCategory("category50511102")
            .setExternalUri("externalUri-1153085023")
            .putAllSourceProperties(new HashMap<String, Value>())
            .setSecurityMarks(SecurityMarks.newBuilder().build())
            .setEventTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setIndicator(Indicator.newBuilder().build())
            .setVulnerability(Vulnerability.newBuilder().build())
            .setMuteUpdateTime(Timestamp.newBuilder().build())
            .putAllExternalSystems(new HashMap<String, ExternalSystem>())
            .setMitreAttack(MitreAttack.newBuilder().build())
            .setAccess(Access.newBuilder().build())
            .addAllConnections(new ArrayList<Connection>())
            .setMuteInitiator("muteInitiator1395645462")
            .addAllProcesses(new ArrayList<Process>())
            .putAllContacts(new HashMap<String, ContactDetails>())
            .addAllCompliances(new ArrayList<Compliance>())
            .setParentDisplayName("parentDisplayName-1523759261")
            .setDescription("description-1724546052")
            .setExfiltration(Exfiltration.newBuilder().build())
            .addAllIamBindings(new ArrayList<IamBinding>())
            .setNextSteps("nextSteps1206138868")
            .setModuleName("moduleName-870351081")
            .addAllContainers(new ArrayList<Container>())
            .setKubernetes(Kubernetes.newBuilder().build())
            .setDatabase(Database.newBuilder().build())
            .setAttackExposure(AttackExposure.newBuilder().build())
            .addAllFiles(new ArrayList<File>())
            .setCloudDlpInspection(CloudDlpInspection.newBuilder().build())
            .setCloudDlpDataProfile(CloudDlpDataProfile.newBuilder().build())
            .setKernelRootkit(KernelRootkit.newBuilder().build())
            .addAllOrgPolicies(new ArrayList<OrgPolicy>())
            .setApplication(Application.newBuilder().build())
            .setBackupDisasterRecovery(BackupDisasterRecovery.newBuilder().build())
            .setSecurityPosture(SecurityPosture.newBuilder().build())
            .addAllLogEntries(new ArrayList<LogEntry>())
            .addAllLoadBalancers(new ArrayList<LoadBalancer>())
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    String name = "name3373707";
    Finding.Mute mute = Finding.Mute.forNumber(0);

    Finding actualResponse = client.setMute(name, mute);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetMuteRequest actualRequest = ((SetMuteRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(mute, actualRequest.getMute());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setMuteExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String name = "name3373707";
      Finding.Mute mute = Finding.Mute.forNumber(0);
      client.setMute(name, mute);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockSecurityCenter.addResponse(expectedResponse);

    ResourceName resource = SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]");
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(resource.toString(), actualRequest.getResource());
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      ResourceName resource = SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]");
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
    mockSecurityCenter.addResponse(expectedResponse);

    String resource = "resource-341064690";
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TestIamPermissionsRequest actualRequest = ((TestIamPermissionsRequest) actualRequests.get(0));

    Assert.assertEquals(resource, actualRequest.getResource());
    Assert.assertEquals(permissions, actualRequest.getPermissionsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void testIamPermissionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      String resource = "resource-341064690";
      List<String> permissions = new ArrayList<>();
      client.testIamPermissions(resource, permissions);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateBigQueryExportTest() throws Exception {
    BigQueryExport expectedResponse =
        BigQueryExport.newBuilder()
            .setName(
                BigQueryExportName.ofOrganizationLocationExportName(
                        "[ORGANIZATION]", "[LOCATION]", "[EXPORT]")
                    .toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setDataset("dataset1443214456")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMostRecentEditor("mostRecentEditor-833861941")
            .setPrincipal("principal-1812041682")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    BigQueryExport bigQueryExport = BigQueryExport.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    BigQueryExport actualResponse = client.updateBigQueryExport(bigQueryExport, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBigQueryExportRequest actualRequest =
        ((UpdateBigQueryExportRequest) actualRequests.get(0));

    Assert.assertEquals(bigQueryExport, actualRequest.getBigQueryExport());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBigQueryExportExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      BigQueryExport bigQueryExport = BigQueryExport.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBigQueryExport(bigQueryExport, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateExternalSystemTest() throws Exception {
    ExternalSystem expectedResponse =
        ExternalSystem.newBuilder()
            .setName("name3373707")
            .addAllAssignees(new ArrayList<String>())
            .setExternalUid("externalUid-1153085307")
            .setStatus("status-892481550")
            .setExternalSystemUpdateTime(Timestamp.newBuilder().build())
            .setCaseUri("caseUri554877980")
            .setCasePriority("casePriority1589324020")
            .setCaseSla(Timestamp.newBuilder().build())
            .setCaseCreateTime(Timestamp.newBuilder().build())
            .setCaseCloseTime(Timestamp.newBuilder().build())
            .setTicketInfo(ExternalSystem.TicketInfo.newBuilder().build())
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    ExternalSystem externalSystem = ExternalSystem.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ExternalSystem actualResponse = client.updateExternalSystem(externalSystem, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateExternalSystemRequest actualRequest =
        ((UpdateExternalSystemRequest) actualRequests.get(0));

    Assert.assertEquals(externalSystem, actualRequest.getExternalSystem());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateExternalSystemExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      ExternalSystem externalSystem = ExternalSystem.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateExternalSystem(externalSystem, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateFindingTest() throws Exception {
    Finding expectedResponse =
        Finding.newBuilder()
            .setName(
                FindingName.ofOrganizationSourceFindingName(
                        "[ORGANIZATION]", "[SOURCE]", "[FINDING]")
                    .toString())
            .setCanonicalName("canonicalName2122381727")
            .setParent("parent-995424086")
            .setResourceName("resourceName-384566343")
            .setCategory("category50511102")
            .setExternalUri("externalUri-1153085023")
            .putAllSourceProperties(new HashMap<String, Value>())
            .setSecurityMarks(SecurityMarks.newBuilder().build())
            .setEventTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setIndicator(Indicator.newBuilder().build())
            .setVulnerability(Vulnerability.newBuilder().build())
            .setMuteUpdateTime(Timestamp.newBuilder().build())
            .putAllExternalSystems(new HashMap<String, ExternalSystem>())
            .setMitreAttack(MitreAttack.newBuilder().build())
            .setAccess(Access.newBuilder().build())
            .addAllConnections(new ArrayList<Connection>())
            .setMuteInitiator("muteInitiator1395645462")
            .addAllProcesses(new ArrayList<Process>())
            .putAllContacts(new HashMap<String, ContactDetails>())
            .addAllCompliances(new ArrayList<Compliance>())
            .setParentDisplayName("parentDisplayName-1523759261")
            .setDescription("description-1724546052")
            .setExfiltration(Exfiltration.newBuilder().build())
            .addAllIamBindings(new ArrayList<IamBinding>())
            .setNextSteps("nextSteps1206138868")
            .setModuleName("moduleName-870351081")
            .addAllContainers(new ArrayList<Container>())
            .setKubernetes(Kubernetes.newBuilder().build())
            .setDatabase(Database.newBuilder().build())
            .setAttackExposure(AttackExposure.newBuilder().build())
            .addAllFiles(new ArrayList<File>())
            .setCloudDlpInspection(CloudDlpInspection.newBuilder().build())
            .setCloudDlpDataProfile(CloudDlpDataProfile.newBuilder().build())
            .setKernelRootkit(KernelRootkit.newBuilder().build())
            .addAllOrgPolicies(new ArrayList<OrgPolicy>())
            .setApplication(Application.newBuilder().build())
            .setBackupDisasterRecovery(BackupDisasterRecovery.newBuilder().build())
            .setSecurityPosture(SecurityPosture.newBuilder().build())
            .addAllLogEntries(new ArrayList<LogEntry>())
            .addAllLoadBalancers(new ArrayList<LoadBalancer>())
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    Finding finding = Finding.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Finding actualResponse = client.updateFinding(finding, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFindingRequest actualRequest = ((UpdateFindingRequest) actualRequests.get(0));

    Assert.assertEquals(finding, actualRequest.getFinding());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateFindingExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      Finding finding = Finding.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFinding(finding, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateMuteConfigTest() throws Exception {
    MuteConfig expectedResponse =
        MuteConfig.newBuilder()
            .setName(
                MuteConfigName.ofOrganizationMuteConfigName("[ORGANIZATION]", "[MUTE_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setMostRecentEditor("mostRecentEditor-833861941")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    MuteConfig muteConfig = MuteConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    MuteConfig actualResponse = client.updateMuteConfig(muteConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateMuteConfigRequest actualRequest = ((UpdateMuteConfigRequest) actualRequests.get(0));

    Assert.assertEquals(muteConfig, actualRequest.getMuteConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateMuteConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      MuteConfig muteConfig = MuteConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateMuteConfig(muteConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateNotificationConfigTest() throws Exception {
    NotificationConfig expectedResponse =
        NotificationConfig.newBuilder()
            .setName(
                NotificationConfigName.ofOrganizationLocationNotificationConfigName(
                        "[ORGANIZATION]", "[LOCATION]", "[NOTIFICATION_CONFIG]")
                    .toString())
            .setDescription("description-1724546052")
            .setPubsubTopic("pubsubTopic255880396")
            .setServiceAccount("serviceAccount1079137720")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    NotificationConfig notificationConfig = NotificationConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    NotificationConfig actualResponse =
        client.updateNotificationConfig(notificationConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateNotificationConfigRequest actualRequest =
        ((UpdateNotificationConfigRequest) actualRequests.get(0));

    Assert.assertEquals(notificationConfig, actualRequest.getNotificationConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateNotificationConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      NotificationConfig notificationConfig = NotificationConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateNotificationConfig(notificationConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateResourceValueConfigTest() throws Exception {
    ResourceValueConfig expectedResponse =
        ResourceValueConfig.newBuilder()
            .setName(
                ResourceValueConfigName.of("[ORGANIZATION]", "[RESOURCE_VALUE_CONFIG]").toString())
            .setResourceValue(ResourceValue.forNumber(0))
            .addAllTagValues(new ArrayList<String>())
            .setResourceType("resourceType-384364440")
            .setScope("scope109264468")
            .putAllResourceLabelsSelector(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setSensitiveDataProtectionMapping(
                ResourceValueConfig.SensitiveDataProtectionMapping.newBuilder().build())
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    ResourceValueConfig resourceValueConfig = ResourceValueConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ResourceValueConfig actualResponse =
        client.updateResourceValueConfig(resourceValueConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateResourceValueConfigRequest actualRequest =
        ((UpdateResourceValueConfigRequest) actualRequests.get(0));

    Assert.assertEquals(resourceValueConfig, actualRequest.getResourceValueConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateResourceValueConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      ResourceValueConfig resourceValueConfig = ResourceValueConfig.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateResourceValueConfig(resourceValueConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSecurityMarksTest() throws Exception {
    SecurityMarks expectedResponse =
        SecurityMarks.newBuilder()
            .setName("name3373707")
            .putAllMarks(new HashMap<String, String>())
            .setCanonicalName("canonicalName2122381727")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    SecurityMarks securityMarks = SecurityMarks.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SecurityMarks actualResponse = client.updateSecurityMarks(securityMarks, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSecurityMarksRequest actualRequest = ((UpdateSecurityMarksRequest) actualRequests.get(0));

    Assert.assertEquals(securityMarks, actualRequest.getSecurityMarks());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSecurityMarksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      SecurityMarks securityMarks = SecurityMarks.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSecurityMarks(securityMarks, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSourceTest() throws Exception {
    Source expectedResponse =
        Source.newBuilder()
            .setName(SourceName.ofOrganizationSourceName("[ORGANIZATION]", "[SOURCE]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCanonicalName("canonicalName2122381727")
            .build();
    mockSecurityCenter.addResponse(expectedResponse);

    Source source = Source.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Source actualResponse = client.updateSource(source, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSecurityCenter.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSourceRequest actualRequest = ((UpdateSourceRequest) actualRequests.get(0));

    Assert.assertEquals(source, actualRequest.getSource());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSourceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSecurityCenter.addException(exception);

    try {
      Source source = Source.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSource(source, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
