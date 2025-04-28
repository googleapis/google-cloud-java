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
import com.google.type.Interval;
import google.cloud.chronicle.v1.stub.HttpJsonRuleServiceStub;
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
public class RuleServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static RuleServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonRuleServiceStub.getMethodDescriptors(),
            RuleServiceSettings.getDefaultEndpoint());
    RuleServiceSettings settings =
        RuleServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                RuleServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = RuleServiceClient.create(settings);
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
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    Rule rule = Rule.newBuilder().build();

    Rule actualResponse = client.createRule(parent, rule);
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
  public void createRuleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
    Rule rule = Rule.newBuilder().build();

    Rule actualResponse = client.createRule(parent, rule);
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
  public void createRuleExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
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
    mockService.addResponse(expectedResponse);

    RuleName name = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");

    Rule actualResponse = client.getRule(name);
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
  public void getRuleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1209/locations/location-1209/instances/instance-1209/rules/rule-1209";

    Rule actualResponse = client.getRule(name);
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
  public void getRuleExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1209/locations/location-1209/instances/instance-1209/rules/rule-1209";
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
    mockService.addResponse(expectedResponse);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");

    ListRulesPagedResponse pagedListResponse = client.listRules(parent);

    List<Rule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRulesList().get(0), resources.get(0));

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
  public void listRulesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";

    ListRulesPagedResponse pagedListResponse = client.listRules(parent);

    List<Rule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRulesList().get(0), resources.get(0));

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
  public void listRulesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
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
    mockService.addResponse(expectedResponse);

    Rule rule =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    Rule actualResponse = client.updateRule(rule, updateMask);
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
  public void updateRuleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Rule rule =
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
    mockService.addResponse(expectedResponse);

    RuleName name = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");

    client.deleteRule(name);

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
  public void deleteRuleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1209/locations/location-1209/instances/instance-1209/rules/rule-1209";

    client.deleteRule(name);

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
  public void deleteRuleExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1209/locations/location-1209/instances/instance-1209/rules/rule-1209";
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
    mockService.addResponse(expectedResponse);

    RuleName name = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");

    ListRuleRevisionsPagedResponse pagedListResponse = client.listRuleRevisions(name);

    List<Rule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRulesList().get(0), resources.get(0));

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
  public void listRuleRevisionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1209/locations/location-1209/instances/instance-1209/rules/rule-1209";

    ListRuleRevisionsPagedResponse pagedListResponse = client.listRuleRevisions(name);

    List<Rule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRulesList().get(0), resources.get(0));

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
  public void listRuleRevisionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1209/locations/location-1209/instances/instance-1209/rules/rule-1209";
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
    mockService.addResponse(resultOperation);

    RuleName parent = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");
    Retrohunt retrohunt = Retrohunt.newBuilder().build();

    Retrohunt actualResponse = client.createRetrohuntAsync(parent, retrohunt).get();
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
  public void createRetrohuntExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RuleName parent = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");
      Retrohunt retrohunt = Retrohunt.newBuilder().build();
      client.createRetrohuntAsync(parent, retrohunt).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent =
        "projects/project-1846/locations/location-1846/instances/instance-1846/rules/rule-1846";
    Retrohunt retrohunt = Retrohunt.newBuilder().build();

    Retrohunt actualResponse = client.createRetrohuntAsync(parent, retrohunt).get();
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
  public void createRetrohuntExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-1846/locations/location-1846/instances/instance-1846/rules/rule-1846";
      Retrohunt retrohunt = Retrohunt.newBuilder().build();
      client.createRetrohuntAsync(parent, retrohunt).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    RetrohuntName name =
        RetrohuntName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]", "[RETROHUNT]");

    Retrohunt actualResponse = client.getRetrohunt(name);
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
  public void getRetrohuntExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-917/locations/location-917/instances/instance-917/rules/rule-917/retrohunts/retrohunt-917";

    Retrohunt actualResponse = client.getRetrohunt(name);
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
  public void getRetrohuntExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-917/locations/location-917/instances/instance-917/rules/rule-917/retrohunts/retrohunt-917";
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
    mockService.addResponse(expectedResponse);

    RuleName parent = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");

    ListRetrohuntsPagedResponse pagedListResponse = client.listRetrohunts(parent);

    List<Retrohunt> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRetrohuntsList().get(0), resources.get(0));

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
  public void listRetrohuntsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-1846/locations/location-1846/instances/instance-1846/rules/rule-1846";

    ListRetrohuntsPagedResponse pagedListResponse = client.listRetrohunts(parent);

    List<Retrohunt> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRetrohuntsList().get(0), resources.get(0));

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
  public void listRetrohuntsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-1846/locations/location-1846/instances/instance-1846/rules/rule-1846";
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
    mockService.addResponse(expectedResponse);

    RuleDeploymentName name =
        RuleDeploymentName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");

    RuleDeployment actualResponse = client.getRuleDeployment(name);
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
  public void getRuleDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2019/locations/location-2019/instances/instance-2019/rules/rule-2019/deployment";

    RuleDeployment actualResponse = client.getRuleDeployment(name);
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
  public void getRuleDeploymentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2019/locations/location-2019/instances/instance-2019/rules/rule-2019/deployment";
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
    mockService.addResponse(expectedResponse);

    RuleName parent = RuleName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]");

    ListRuleDeploymentsPagedResponse pagedListResponse = client.listRuleDeployments(parent);

    List<RuleDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRuleDeploymentsList().get(0), resources.get(0));

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
  public void listRuleDeploymentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-1846/locations/location-1846/instances/instance-1846/rules/rule-1846";

    ListRuleDeploymentsPagedResponse pagedListResponse = client.listRuleDeployments(parent);

    List<RuleDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRuleDeploymentsList().get(0), resources.get(0));

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
  public void listRuleDeploymentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-1846/locations/location-1846/instances/instance-1846/rules/rule-1846";
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
    mockService.addResponse(expectedResponse);

    RuleDeployment ruleDeployment =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    RuleDeployment actualResponse = client.updateRuleDeployment(ruleDeployment, updateMask);
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
  public void updateRuleDeploymentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RuleDeployment ruleDeployment =
          RuleDeployment.newBuilder()
              .setName(
                  RuleDeploymentName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[RULE]")
                      .toString())
              .setEnabled(true)
              .setAlerting(true)
              .setArchived(true)
              .setArchiveTime(Timestamp.newBuilder().build())
              .setRunFrequency(RunFrequency.forNumber(0))
              .addAllProducerRules(new ArrayList<String>())
              .addAllConsumerRules(new ArrayList<String>())
              .setLastAlertStatusChangeTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateRuleDeployment(ruleDeployment, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
