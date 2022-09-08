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

package com.google.cloud.devtools.containeranalysis.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.resourcenames.ResourceName;
import com.google.containeranalysis.v1.GetVulnerabilityOccurrencesSummaryRequest;
import com.google.containeranalysis.v1.ProjectName;
import com.google.containeranalysis.v1.VulnerabilityOccurrencesSummary;
import com.google.iam.v1.AuditConfig;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ContainerAnalysisClientTest {
  private static MockContainerAnalysis mockContainerAnalysis;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ContainerAnalysisClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockContainerAnalysis = new MockContainerAnalysis();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockContainerAnalysis));
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
    ContainerAnalysisSettings settings =
        ContainerAnalysisSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ContainerAnalysisClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
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
    mockContainerAnalysis.addResponse(expectedResponse);

    ResourceName resource =
        new ResourceName() {
          @Override
          public Map<String, String> getFieldValuesMap() {
            Map<String, String> fieldValuesMap = new HashMap<>();
            fieldValuesMap.put("resource", "projects/project-8432/notes/note-8432");
            return fieldValuesMap;
          }

          @Override
          public String getFieldValue(String fieldName) {
            return getFieldValuesMap().get(fieldName);
          }

          @Override
          public String toString() {
            return "projects/project-8432/notes/note-8432";
          }
        };
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContainerAnalysis.getRequests();
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
    mockContainerAnalysis.addException(exception);

    try {
      ResourceName resource =
          new ResourceName() {
            @Override
            public Map<String, String> getFieldValuesMap() {
              Map<String, String> fieldValuesMap = new HashMap<>();
              fieldValuesMap.put("resource", "projects/project-8432/notes/note-8432");
              return fieldValuesMap;
            }

            @Override
            public String getFieldValue(String fieldName) {
              return getFieldValuesMap().get(fieldName);
            }

            @Override
            public String toString() {
              return "projects/project-8432/notes/note-8432";
            }
          };
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
    mockContainerAnalysis.addResponse(expectedResponse);

    String resource = "resource-341064690";
    Policy policy = Policy.newBuilder().build();

    Policy actualResponse = client.setIamPolicy(resource, policy);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContainerAnalysis.getRequests();
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
    mockContainerAnalysis.addException(exception);

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
  public void getIamPolicyTest() throws Exception {
    Policy expectedResponse =
        Policy.newBuilder()
            .setVersion(351608024)
            .addAllBindings(new ArrayList<Binding>())
            .addAllAuditConfigs(new ArrayList<AuditConfig>())
            .setEtag(ByteString.EMPTY)
            .build();
    mockContainerAnalysis.addResponse(expectedResponse);

    ResourceName resource =
        new ResourceName() {
          @Override
          public Map<String, String> getFieldValuesMap() {
            Map<String, String> fieldValuesMap = new HashMap<>();
            fieldValuesMap.put("resource", "projects/project-8432/notes/note-8432");
            return fieldValuesMap;
          }

          @Override
          public String getFieldValue(String fieldName) {
            return getFieldValuesMap().get(fieldName);
          }

          @Override
          public String toString() {
            return "projects/project-8432/notes/note-8432";
          }
        };

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContainerAnalysis.getRequests();
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
    mockContainerAnalysis.addException(exception);

    try {
      ResourceName resource =
          new ResourceName() {
            @Override
            public Map<String, String> getFieldValuesMap() {
              Map<String, String> fieldValuesMap = new HashMap<>();
              fieldValuesMap.put("resource", "projects/project-8432/notes/note-8432");
              return fieldValuesMap;
            }

            @Override
            public String getFieldValue(String fieldName) {
              return getFieldValuesMap().get(fieldName);
            }

            @Override
            public String toString() {
              return "projects/project-8432/notes/note-8432";
            }
          };
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
    mockContainerAnalysis.addResponse(expectedResponse);

    String resource = "resource-341064690";

    Policy actualResponse = client.getIamPolicy(resource);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContainerAnalysis.getRequests();
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
    mockContainerAnalysis.addException(exception);

    try {
      String resource = "resource-341064690";
      client.getIamPolicy(resource);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void testIamPermissionsTest() throws Exception {
    TestIamPermissionsResponse expectedResponse =
        TestIamPermissionsResponse.newBuilder().addAllPermissions(new ArrayList<String>()).build();
    mockContainerAnalysis.addResponse(expectedResponse);

    ResourceName resource =
        new ResourceName() {
          @Override
          public Map<String, String> getFieldValuesMap() {
            Map<String, String> fieldValuesMap = new HashMap<>();
            fieldValuesMap.put("resource", "projects/project-8432/notes/note-8432");
            return fieldValuesMap;
          }

          @Override
          public String getFieldValue(String fieldName) {
            return getFieldValuesMap().get(fieldName);
          }

          @Override
          public String toString() {
            return "projects/project-8432/notes/note-8432";
          }
        };
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContainerAnalysis.getRequests();
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
    mockContainerAnalysis.addException(exception);

    try {
      ResourceName resource =
          new ResourceName() {
            @Override
            public Map<String, String> getFieldValuesMap() {
              Map<String, String> fieldValuesMap = new HashMap<>();
              fieldValuesMap.put("resource", "projects/project-8432/notes/note-8432");
              return fieldValuesMap;
            }

            @Override
            public String getFieldValue(String fieldName) {
              return getFieldValuesMap().get(fieldName);
            }

            @Override
            public String toString() {
              return "projects/project-8432/notes/note-8432";
            }
          };
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
    mockContainerAnalysis.addResponse(expectedResponse);

    String resource = "resource-341064690";
    List<String> permissions = new ArrayList<>();

    TestIamPermissionsResponse actualResponse = client.testIamPermissions(resource, permissions);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContainerAnalysis.getRequests();
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
    mockContainerAnalysis.addException(exception);

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
  public void getVulnerabilityOccurrencesSummaryTest() throws Exception {
    VulnerabilityOccurrencesSummary expectedResponse =
        VulnerabilityOccurrencesSummary.newBuilder()
            .addAllCounts(new ArrayList<VulnerabilityOccurrencesSummary.FixableTotalByDigest>())
            .build();
    mockContainerAnalysis.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    String filter = "filter-1274492040";

    VulnerabilityOccurrencesSummary actualResponse =
        client.getVulnerabilityOccurrencesSummary(parent, filter);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContainerAnalysis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVulnerabilityOccurrencesSummaryRequest actualRequest =
        ((GetVulnerabilityOccurrencesSummaryRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVulnerabilityOccurrencesSummaryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContainerAnalysis.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      String filter = "filter-1274492040";
      client.getVulnerabilityOccurrencesSummary(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getVulnerabilityOccurrencesSummaryTest2() throws Exception {
    VulnerabilityOccurrencesSummary expectedResponse =
        VulnerabilityOccurrencesSummary.newBuilder()
            .addAllCounts(new ArrayList<VulnerabilityOccurrencesSummary.FixableTotalByDigest>())
            .build();
    mockContainerAnalysis.addResponse(expectedResponse);

    String parent = "parent-995424086";
    String filter = "filter-1274492040";

    VulnerabilityOccurrencesSummary actualResponse =
        client.getVulnerabilityOccurrencesSummary(parent, filter);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContainerAnalysis.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetVulnerabilityOccurrencesSummaryRequest actualRequest =
        ((GetVulnerabilityOccurrencesSummaryRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getVulnerabilityOccurrencesSummaryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContainerAnalysis.addException(exception);

    try {
      String parent = "parent-995424086";
      String filter = "filter-1274492040";
      client.getVulnerabilityOccurrencesSummary(parent, filter);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
