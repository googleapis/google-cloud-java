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

import static google.cloud.chronicle.v1.RuleServiceClient.ListRetrohuntsPagedResponse;
import static google.cloud.chronicle.v1.RuleServiceClient.ListRuleDeploymentsPagedResponse;
import static google.cloud.chronicle.v1.RuleServiceClient.ListRuleRevisionsPagedResponse;
import static google.cloud.chronicle.v1.RuleServiceClient.ListRulesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.type.Interval;
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
public class RuleServiceClientTest {
  private static MockRuleService mockRuleService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private RuleServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockRuleService = new MockRuleService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockRuleService));
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
    RuleServiceSettings settings =
        RuleServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = RuleServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createRuleTest() throws Exception {
    Rule expectedResponse =
        Rule.newBuilder()
            .setName(RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString())
            .setRevisionId("revisionId-1507445162")
            .setDisplayName("displayName1714148973")
            .setText("text3556653")
            .setAuthor("author-1406328437")
            .setSeverity(Severity.newBuilder().build())
            .putAllMetadata(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setType(RuleType.forNumber(0))
            .addAllReferenceLists(new ArrayList<String>())
            .addAllAllowedRunFrequencies(new ArrayList<RunFrequency>())
            .setEtag("etag3123477")
            .setScope(
                DataAccessScopeName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]")
                    .toString())
            .addAllCompilationDiagnostics(new ArrayList<CompilationDiagnostic>())
            .setNearRealTimeLiveRuleEligible(true)
            .setInputsUsed(InputsUsed.newBuilder().build())
            .build();
    mockRuleService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    Rule rule = Rule.newBuilder().build();

    Rule actualResponse = client.createRule(parent, rule);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRuleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRuleRequest actualRequest = ((CreateRuleRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(rule, actualRequest.getRule());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      Rule rule = Rule.newBuilder().build();
      client.createRule(parent, rule);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRuleTest2() throws Exception {
    Rule expectedResponse =
        Rule.newBuilder()
            .setName(RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString())
            .setRevisionId("revisionId-1507445162")
            .setDisplayName("displayName1714148973")
            .setText("text3556653")
            .setAuthor("author-1406328437")
            .setSeverity(Severity.newBuilder().build())
            .putAllMetadata(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setType(RuleType.forNumber(0))
            .addAllReferenceLists(new ArrayList<String>())
            .addAllAllowedRunFrequencies(new ArrayList<RunFrequency>())
            .setEtag("etag3123477")
            .setScope(
                DataAccessScopeName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]")
                    .toString())
            .addAllCompilationDiagnostics(new ArrayList<CompilationDiagnostic>())
            .setNearRealTimeLiveRuleEligible(true)
            .setInputsUsed(InputsUsed.newBuilder().build())
            .build();
    mockRuleService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Rule rule = Rule.newBuilder().build();

    Rule actualResponse = client.createRule(parent, rule);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRuleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRuleRequest actualRequest = ((CreateRuleRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(rule, actualRequest.getRule());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleService.addException(exception);

    try {
      String parent = "parent-995424086";
      Rule rule = Rule.newBuilder().build();
      client.createRule(parent, rule);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRuleTest() throws Exception {
    Rule expectedResponse =
        Rule.newBuilder()
            .setName(RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString())
            .setRevisionId("revisionId-1507445162")
            .setDisplayName("displayName1714148973")
            .setText("text3556653")
            .setAuthor("author-1406328437")
            .setSeverity(Severity.newBuilder().build())
            .putAllMetadata(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setType(RuleType.forNumber(0))
            .addAllReferenceLists(new ArrayList<String>())
            .addAllAllowedRunFrequencies(new ArrayList<RunFrequency>())
            .setEtag("etag3123477")
            .setScope(
                DataAccessScopeName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]")
                    .toString())
            .addAllCompilationDiagnostics(new ArrayList<CompilationDiagnostic>())
            .setNearRealTimeLiveRuleEligible(true)
            .setInputsUsed(InputsUsed.newBuilder().build())
            .build();
    mockRuleService.addResponse(expectedResponse);

    RuleName name = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");

    Rule actualResponse = client.getRule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRuleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRuleRequest actualRequest = ((GetRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleService.addException(exception);

    try {
      RuleName name = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");
      client.getRule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRuleTest2() throws Exception {
    Rule expectedResponse =
        Rule.newBuilder()
            .setName(RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString())
            .setRevisionId("revisionId-1507445162")
            .setDisplayName("displayName1714148973")
            .setText("text3556653")
            .setAuthor("author-1406328437")
            .setSeverity(Severity.newBuilder().build())
            .putAllMetadata(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setType(RuleType.forNumber(0))
            .addAllReferenceLists(new ArrayList<String>())
            .addAllAllowedRunFrequencies(new ArrayList<RunFrequency>())
            .setEtag("etag3123477")
            .setScope(
                DataAccessScopeName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]")
                    .toString())
            .addAllCompilationDiagnostics(new ArrayList<CompilationDiagnostic>())
            .setNearRealTimeLiveRuleEligible(true)
            .setInputsUsed(InputsUsed.newBuilder().build())
            .build();
    mockRuleService.addResponse(expectedResponse);

    String name = "name3373707";

    Rule actualResponse = client.getRule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRuleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRuleRequest actualRequest = ((GetRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleService.addException(exception);

    try {
      String name = "name3373707";
      client.getRule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRulesTest() throws Exception {
    Rule responsesElement = Rule.newBuilder().build();
    ListRulesResponse expectedResponse =
        ListRulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRules(Arrays.asList(responsesElement))
            .build();
    mockRuleService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListRulesPagedResponse pagedListResponse = client.listRules(parent);

    List<Rule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRuleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRulesRequest actualRequest = ((ListRulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRulesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      client.listRules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRulesTest2() throws Exception {
    Rule responsesElement = Rule.newBuilder().build();
    ListRulesResponse expectedResponse =
        ListRulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllRules(Arrays.asList(responsesElement))
            .build();
    mockRuleService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRulesPagedResponse pagedListResponse = client.listRules(parent);

    List<Rule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRuleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRulesRequest actualRequest = ((ListRulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRulesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateRuleTest() throws Exception {
    Rule expectedResponse =
        Rule.newBuilder()
            .setName(RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString())
            .setRevisionId("revisionId-1507445162")
            .setDisplayName("displayName1714148973")
            .setText("text3556653")
            .setAuthor("author-1406328437")
            .setSeverity(Severity.newBuilder().build())
            .putAllMetadata(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setType(RuleType.forNumber(0))
            .addAllReferenceLists(new ArrayList<String>())
            .addAllAllowedRunFrequencies(new ArrayList<RunFrequency>())
            .setEtag("etag3123477")
            .setScope(
                DataAccessScopeName.of(
                        "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_ACCESS_SCOPE]")
                    .toString())
            .addAllCompilationDiagnostics(new ArrayList<CompilationDiagnostic>())
            .setNearRealTimeLiveRuleEligible(true)
            .setInputsUsed(InputsUsed.newBuilder().build())
            .build();
    mockRuleService.addResponse(expectedResponse);

    Rule rule = Rule.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Rule actualResponse = client.updateRule(rule, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRuleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateRuleRequest actualRequest = ((UpdateRuleRequest) actualRequests.get(0));

    Assert.assertEquals(rule, actualRequest.getRule());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleService.addException(exception);

    try {
      Rule rule = Rule.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRule(rule, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRuleTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockRuleService.addResponse(expectedResponse);

    RuleName name = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");

    client.deleteRule(name);

    List<AbstractMessage> actualRequests = mockRuleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRuleRequest actualRequest = ((DeleteRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleService.addException(exception);

    try {
      RuleName name = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");
      client.deleteRule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteRuleTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockRuleService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteRule(name);

    List<AbstractMessage> actualRequests = mockRuleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteRuleRequest actualRequest = ((DeleteRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteRuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteRule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRuleRevisionsTest() throws Exception {
    Rule responsesElement = Rule.newBuilder().build();
    ListRuleRevisionsResponse expectedResponse =
        ListRuleRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRules(Arrays.asList(responsesElement))
            .build();
    mockRuleService.addResponse(expectedResponse);

    RuleName name = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");

    ListRuleRevisionsPagedResponse pagedListResponse = client.listRuleRevisions(name);

    List<Rule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRuleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRuleRevisionsRequest actualRequest = ((ListRuleRevisionsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRuleRevisionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleService.addException(exception);

    try {
      RuleName name = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");
      client.listRuleRevisions(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRuleRevisionsTest2() throws Exception {
    Rule responsesElement = Rule.newBuilder().build();
    ListRuleRevisionsResponse expectedResponse =
        ListRuleRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRules(Arrays.asList(responsesElement))
            .build();
    mockRuleService.addResponse(expectedResponse);

    String name = "name3373707";

    ListRuleRevisionsPagedResponse pagedListResponse = client.listRuleRevisions(name);

    List<Rule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRuleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRuleRevisionsRequest actualRequest = ((ListRuleRevisionsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRuleRevisionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleService.addException(exception);

    try {
      String name = "name3373707";
      client.listRuleRevisions(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createRetrohuntTest() throws Exception {
    Retrohunt expectedResponse =
        Retrohunt.newBuilder()
            .setName(
                RetrohuntName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]", "[RETROHUNT]")
                    .toString())
            .setProcessInterval(Interval.newBuilder().build())
            .setExecutionInterval(Interval.newBuilder().build())
            .setProgressPercentage(44324844)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRetrohuntTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockRuleService.addResponse(resultOperation);

    RuleName parent = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");
    Retrohunt retrohunt = Retrohunt.newBuilder().build();

    Retrohunt actualResponse = client.createRetrohuntAsync(parent, retrohunt).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRuleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRetrohuntRequest actualRequest = ((CreateRetrohuntRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(retrohunt, actualRequest.getRetrohunt());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRetrohuntExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleService.addException(exception);

    try {
      RuleName parent = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");
      Retrohunt retrohunt = Retrohunt.newBuilder().build();
      client.createRetrohuntAsync(parent, retrohunt).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createRetrohuntTest2() throws Exception {
    Retrohunt expectedResponse =
        Retrohunt.newBuilder()
            .setName(
                RetrohuntName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]", "[RETROHUNT]")
                    .toString())
            .setProcessInterval(Interval.newBuilder().build())
            .setExecutionInterval(Interval.newBuilder().build())
            .setProgressPercentage(44324844)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createRetrohuntTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockRuleService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Retrohunt retrohunt = Retrohunt.newBuilder().build();

    Retrohunt actualResponse = client.createRetrohuntAsync(parent, retrohunt).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRuleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateRetrohuntRequest actualRequest = ((CreateRetrohuntRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(retrohunt, actualRequest.getRetrohunt());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createRetrohuntExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleService.addException(exception);

    try {
      String parent = "parent-995424086";
      Retrohunt retrohunt = Retrohunt.newBuilder().build();
      client.createRetrohuntAsync(parent, retrohunt).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getRetrohuntTest() throws Exception {
    Retrohunt expectedResponse =
        Retrohunt.newBuilder()
            .setName(
                RetrohuntName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]", "[RETROHUNT]")
                    .toString())
            .setProcessInterval(Interval.newBuilder().build())
            .setExecutionInterval(Interval.newBuilder().build())
            .setProgressPercentage(44324844)
            .build();
    mockRuleService.addResponse(expectedResponse);

    RetrohuntName name =
        RetrohuntName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]", "[RETROHUNT]");

    Retrohunt actualResponse = client.getRetrohunt(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRuleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRetrohuntRequest actualRequest = ((GetRetrohuntRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRetrohuntExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleService.addException(exception);

    try {
      RetrohuntName name =
          RetrohuntName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]", "[RETROHUNT]");
      client.getRetrohunt(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRetrohuntTest2() throws Exception {
    Retrohunt expectedResponse =
        Retrohunt.newBuilder()
            .setName(
                RetrohuntName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]", "[RETROHUNT]")
                    .toString())
            .setProcessInterval(Interval.newBuilder().build())
            .setExecutionInterval(Interval.newBuilder().build())
            .setProgressPercentage(44324844)
            .build();
    mockRuleService.addResponse(expectedResponse);

    String name = "name3373707";

    Retrohunt actualResponse = client.getRetrohunt(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRuleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRetrohuntRequest actualRequest = ((GetRetrohuntRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRetrohuntExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleService.addException(exception);

    try {
      String name = "name3373707";
      client.getRetrohunt(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRetrohuntsTest() throws Exception {
    Retrohunt responsesElement = Retrohunt.newBuilder().build();
    ListRetrohuntsResponse expectedResponse =
        ListRetrohuntsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRetrohunts(Arrays.asList(responsesElement))
            .build();
    mockRuleService.addResponse(expectedResponse);

    RuleName parent = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");

    ListRetrohuntsPagedResponse pagedListResponse = client.listRetrohunts(parent);

    List<Retrohunt> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRetrohuntsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRuleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRetrohuntsRequest actualRequest = ((ListRetrohuntsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRetrohuntsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleService.addException(exception);

    try {
      RuleName parent = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");
      client.listRetrohunts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRetrohuntsTest2() throws Exception {
    Retrohunt responsesElement = Retrohunt.newBuilder().build();
    ListRetrohuntsResponse expectedResponse =
        ListRetrohuntsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRetrohunts(Arrays.asList(responsesElement))
            .build();
    mockRuleService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRetrohuntsPagedResponse pagedListResponse = client.listRetrohunts(parent);

    List<Retrohunt> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRetrohuntsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRuleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRetrohuntsRequest actualRequest = ((ListRetrohuntsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRetrohuntsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRetrohunts(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRuleDeploymentTest() throws Exception {
    RuleDeployment expectedResponse =
        RuleDeployment.newBuilder()
            .setName(
                RuleDeploymentName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString())
            .setEnabled(true)
            .setAlerting(true)
            .setArchived(true)
            .setArchiveTime(Timestamp.newBuilder().build())
            .setRunFrequency(RunFrequency.forNumber(0))
            .addAllProducerRules(new ArrayList<String>())
            .addAllConsumerRules(new ArrayList<String>())
            .setLastAlertStatusChangeTime(Timestamp.newBuilder().build())
            .build();
    mockRuleService.addResponse(expectedResponse);

    RuleDeploymentName name =
        RuleDeploymentName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");

    RuleDeployment actualResponse = client.getRuleDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRuleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRuleDeploymentRequest actualRequest = ((GetRuleDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRuleDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleService.addException(exception);

    try {
      RuleDeploymentName name =
          RuleDeploymentName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");
      client.getRuleDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRuleDeploymentTest2() throws Exception {
    RuleDeployment expectedResponse =
        RuleDeployment.newBuilder()
            .setName(
                RuleDeploymentName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString())
            .setEnabled(true)
            .setAlerting(true)
            .setArchived(true)
            .setArchiveTime(Timestamp.newBuilder().build())
            .setRunFrequency(RunFrequency.forNumber(0))
            .addAllProducerRules(new ArrayList<String>())
            .addAllConsumerRules(new ArrayList<String>())
            .setLastAlertStatusChangeTime(Timestamp.newBuilder().build())
            .build();
    mockRuleService.addResponse(expectedResponse);

    String name = "name3373707";

    RuleDeployment actualResponse = client.getRuleDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRuleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRuleDeploymentRequest actualRequest = ((GetRuleDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRuleDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleService.addException(exception);

    try {
      String name = "name3373707";
      client.getRuleDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRuleDeploymentsTest() throws Exception {
    RuleDeployment responsesElement = RuleDeployment.newBuilder().build();
    ListRuleDeploymentsResponse expectedResponse =
        ListRuleDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRuleDeployments(Arrays.asList(responsesElement))
            .build();
    mockRuleService.addResponse(expectedResponse);

    RuleName parent = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");

    ListRuleDeploymentsPagedResponse pagedListResponse = client.listRuleDeployments(parent);

    List<RuleDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRuleDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRuleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRuleDeploymentsRequest actualRequest = ((ListRuleDeploymentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRuleDeploymentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleService.addException(exception);

    try {
      RuleName parent = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");
      client.listRuleDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRuleDeploymentsTest2() throws Exception {
    RuleDeployment responsesElement = RuleDeployment.newBuilder().build();
    ListRuleDeploymentsResponse expectedResponse =
        ListRuleDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRuleDeployments(Arrays.asList(responsesElement))
            .build();
    mockRuleService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRuleDeploymentsPagedResponse pagedListResponse = client.listRuleDeployments(parent);

    List<RuleDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRuleDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockRuleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRuleDeploymentsRequest actualRequest = ((ListRuleDeploymentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRuleDeploymentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listRuleDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateRuleDeploymentTest() throws Exception {
    RuleDeployment expectedResponse =
        RuleDeployment.newBuilder()
            .setName(
                RuleDeploymentName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]").toString())
            .setEnabled(true)
            .setAlerting(true)
            .setArchived(true)
            .setArchiveTime(Timestamp.newBuilder().build())
            .setRunFrequency(RunFrequency.forNumber(0))
            .addAllProducerRules(new ArrayList<String>())
            .addAllConsumerRules(new ArrayList<String>())
            .setLastAlertStatusChangeTime(Timestamp.newBuilder().build())
            .build();
    mockRuleService.addResponse(expectedResponse);

    RuleDeployment ruleDeployment = RuleDeployment.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    RuleDeployment actualResponse = client.updateRuleDeployment(ruleDeployment, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockRuleService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateRuleDeploymentRequest actualRequest =
        ((UpdateRuleDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(ruleDeployment, actualRequest.getRuleDeployment());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateRuleDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockRuleService.addException(exception);

    try {
      RuleDeployment ruleDeployment = RuleDeployment.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRuleDeployment(ruleDeployment, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
