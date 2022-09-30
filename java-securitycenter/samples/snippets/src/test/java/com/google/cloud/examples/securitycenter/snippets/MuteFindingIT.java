/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.examples.securitycenter.snippets;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import com.google.cloud.examples.securitycenter.snippets.muteconfig.BulkMuteFindings;
import com.google.cloud.examples.securitycenter.snippets.muteconfig.CreateMuteRule;
import com.google.cloud.examples.securitycenter.snippets.muteconfig.DeleteMuteRule;
import com.google.cloud.examples.securitycenter.snippets.muteconfig.GetMuteRule;
import com.google.cloud.examples.securitycenter.snippets.muteconfig.ListMuteRules;
import com.google.cloud.examples.securitycenter.snippets.muteconfig.SetMuteFinding;
import com.google.cloud.examples.securitycenter.snippets.muteconfig.SetUnmuteFinding;
import com.google.cloud.examples.securitycenter.snippets.muteconfig.UpdateMuteRule;
import com.google.cloud.securitycenter.v1.CreateSourceRequest;
import com.google.cloud.securitycenter.v1.Finding;
import com.google.cloud.securitycenter.v1.Finding.FindingClass;
import com.google.cloud.securitycenter.v1.Finding.Mute;
import com.google.cloud.securitycenter.v1.Finding.Severity;
import com.google.cloud.securitycenter.v1.Finding.State;
import com.google.cloud.securitycenter.v1.ListFindingsRequest;
import com.google.cloud.securitycenter.v1.ListFindingsResponse.ListFindingsResult;
import com.google.cloud.securitycenter.v1.SecurityCenterClient;
import com.google.cloud.securitycenter.v1.SecurityCenterClient.ListFindingsPagedResponse;
import com.google.cloud.securitycenter.v1.Source;
import com.google.protobuf.Timestamp;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.Instant;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MuteFindingIT {

  // TODO(Developer): Replace the below variables.
  private static final String PROJECT_ID = System.getenv("SCC_PROJECT_ID");
  private static final String ORGANIZATION_ID = System.getenv("SCC_PROJECT_ORG_ID");

  private static final String MUTE_RULE_CREATE = "random-mute-id-" + UUID.randomUUID();
  private static final String MUTE_RULE_UPDATE = "random-mute-id-" + UUID.randomUUID();
  private static Source SOURCE;
  // The findings will be used to test bulk mute.
  private static Finding FINDING_1;
  private static Finding FINDING_2;
  private static Finding FINDING_3;

  private static ByteArrayOutputStream stdOut;

  // Check if the required environment variables are set.
  public static void requireEnvVar(String envVarName) {
    assertWithMessage(String.format("Missing environment variable '%s' ", envVarName))
        .that(System.getenv(envVarName))
        .isNotEmpty();
  }

  @BeforeClass
  public static void setUp() throws IOException {
    final PrintStream out = System.out;
    stdOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdOut));

    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("SCC_PROJECT_ID");
    requireEnvVar("SCC_PROJECT_ORG_ID");

    // Create mute rules.
    CreateMuteRule.createMuteRule(String.format("projects/%s", PROJECT_ID), MUTE_RULE_CREATE);
    CreateMuteRule.createMuteRule(String.format("projects/%s", PROJECT_ID), MUTE_RULE_UPDATE);
    // Create source.
    SOURCE = createSource(ORGANIZATION_ID);
    // Create findings within the source.
    String uuid = UUID.randomUUID().toString().split("-")[0];
    FINDING_1 = createFinding(SOURCE.getName(), "1testingscc" + uuid);
    FINDING_2 = createFinding(SOURCE.getName(), "2testingscc" + uuid);
    FINDING_3 = createFinding(SOURCE.getName(), "3testingscc" + uuid);

    stdOut = null;
    System.setOut(out);
  }

  @AfterClass
  public static void cleanUp() {
    final PrintStream out = System.out;
    stdOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdOut));
    DeleteMuteRule.deleteMuteRule(PROJECT_ID, MUTE_RULE_CREATE);
    assertThat(stdOut.toString()).contains("Mute rule deleted successfully: " + MUTE_RULE_CREATE);
    DeleteMuteRule.deleteMuteRule(PROJECT_ID, MUTE_RULE_UPDATE);
    assertThat(stdOut.toString()).contains("Mute rule deleted successfully: " + MUTE_RULE_UPDATE);
    stdOut = null;
    System.setOut(out);
  }

  public static Source createSource(String organizationId) throws IOException {
    try (SecurityCenterClient client = SecurityCenterClient.create()) {

      Source source =
          Source.newBuilder()
              .setDisplayName("Custom display name")
              .setDescription("A source that does X")
              .build();

      CreateSourceRequest createSourceRequest =
          CreateSourceRequest.newBuilder()
              .setParent(String.format("organizations/%s", organizationId))
              .setSource(source)
              .build();

      Source response = client.createSource(createSourceRequest);
      System.out.println("Created source : " + response.getName());
      return response;
    }
  }

  public static Finding createFinding(String sourceName, String findingId) throws IOException {
    try (SecurityCenterClient client = SecurityCenterClient.create()) {

      Instant eventTime = Instant.now();

      // The resource this finding applies to. The Cloud Security Command Center UI can link
      // the findings for a resource to the corresponding asset of a resource
      // if there are matches.
      // TODO(Developer): Replace the sample resource name
      String resourceName = "//cloudresourcemanager.googleapis.com/organizations/11232";

      // Set up a request to create a finding in a source.
      Finding finding =
          Finding.newBuilder()
              .setParent(sourceName)
              .setState(State.ACTIVE)
              .setSeverity(Severity.LOW)
              .setMute(Mute.UNMUTED)
              .setFindingClass(FindingClass.OBSERVATION)
              .setResourceName(resourceName)
              .setEventTime(
                  Timestamp.newBuilder()
                      .setSeconds(eventTime.getEpochSecond())
                      .setNanos(eventTime.getNano()))
              .setCategory("LOW_RISK_ONE")
              .build();

      Finding response = client.createFinding(sourceName, findingId, finding);

      System.out.println("Created Finding: " + response);
      return response;
    }
  }

  public static ListFindingsPagedResponse getAllFindings(String sourceName) throws IOException {
    try (SecurityCenterClient client = SecurityCenterClient.create()) {

      ListFindingsRequest request = ListFindingsRequest.newBuilder().setParent(sourceName).build();

      return client.listFindings(request);
    }
  }

  private static String getOrganizationId() {
    return "1081635000895";
  }

  private static String getProject() {
    return "project-a-id";
  }

  @Before
  public void beforeEach() {
    stdOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdOut));
  }

  @After
  public void afterEach() {
    stdOut = null;
    System.setOut(null);
  }

  @Test
  public void testGetMuteRule() {
    GetMuteRule.getMuteRule(PROJECT_ID, MUTE_RULE_CREATE);
    assertThat(stdOut.toString()).contains("Retrieved the mute config: ");
    assertThat(stdOut.toString()).contains(MUTE_RULE_CREATE);
  }

  @Test
  public void testListMuteRules() {
    ListMuteRules.listMuteRules(String.format("projects/%s", PROJECT_ID));
    assertThat(stdOut.toString()).contains(MUTE_RULE_CREATE);
    assertThat(stdOut.toString()).contains(MUTE_RULE_UPDATE);
  }

  @Test
  public void testUpdateMuteRules() {
    UpdateMuteRule.updateMuteRule(
        String.format("projects/%s/muteConfigs/%s", PROJECT_ID, MUTE_RULE_UPDATE));
    GetMuteRule.getMuteRule(PROJECT_ID, MUTE_RULE_UPDATE);
    assertThat(stdOut.toString()).contains("Updated mute config description");
  }

  @Test
  public void testSetMuteFinding() {
    SetMuteFinding.setMute(FINDING_1.getName());
    assertThat(stdOut.toString())
        .contains("Mute value for the finding " + FINDING_1.getName() + " is: " + "MUTED");
    SetUnmuteFinding.setUnmute(FINDING_1.getName());
    assertThat(stdOut.toString())
        .contains("Mute value for the finding " + FINDING_1.getName() + " is: " + "UNMUTED");
  }

  @Test
  public void testBulkMuteFindings() throws IOException {
    // Mute findings that belong to this project.
    BulkMuteFindings.bulkMute(
        String.format("projects/%s", PROJECT_ID),
        String.format("resource.project_display_name=\"%s\"", PROJECT_ID));

    // Get all findings in the source to check if they are muted.
    ListFindingsPagedResponse response =
        getAllFindings(
            String.format("projects/%s/sources/%s", PROJECT_ID, SOURCE.getName().split("/")[3]));
    for (ListFindingsResult finding : response.iterateAll()) {
      Assert.assertEquals(finding.getFinding().getMute(), Mute.MUTED);
    }
  }
}
