/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.websecurityscanner.it.v1beta;

import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.rpc.NotFoundException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.websecurityscanner.v1beta.CreateScanConfigRequest;
import com.google.cloud.websecurityscanner.v1beta.DeleteScanConfigRequest;
import com.google.cloud.websecurityscanner.v1beta.GetScanConfigRequest;
import com.google.cloud.websecurityscanner.v1beta.ListScanConfigsRequest;
import com.google.cloud.websecurityscanner.v1beta.ProjectName;
import com.google.cloud.websecurityscanner.v1beta.ScanConfig;
import com.google.cloud.websecurityscanner.v1beta.ScanRun;
import com.google.cloud.websecurityscanner.v1beta.ScanRun.ResultState;
import com.google.cloud.websecurityscanner.v1beta.StartScanRunRequest;
import com.google.cloud.websecurityscanner.v1beta.StopScanRunRequest;
import com.google.cloud.websecurityscanner.v1beta.WebSecurityScannerClient;
import com.google.cloud.websecurityscanner.v1beta.WebSecurityScannerSettings;
import com.google.common.collect.Lists;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Positive Integration Tests for VPC-SC
 */
@RunWith(JUnit4.class)
public class VpcPositiveTest {
  private static final String IN_VPCSC_GOOGLE_CLOUD_TEST_ENV = "GOOGLE_CLOUD_TESTS_IN_VPCSC";
  private static final String IN_VPCSC_PROJECT_ENV =
      "GOOGLE_CLOUD_TESTS_WEB_SECURITY_SCANNER_INSIDE_VPC_PROJECT";
  private static final String IN_VPCSC_HOSTNAME_ENV =
      "GOOGLE_CLOUD_TESTS_WEB_SECURITY_SCANNER_INSIDE_VPC_HOSTNAME";
  private static final String IN_VPCSC_GOOGLE_CREDENTIAL_ENV =
      "GOOGLE_CLOUD_TESTS_WEB_SECURITY_SCANNER_INSIDE_VPC_CREDENTIALS";
  private static final String GOOGLE_CREDENTIAL_DEFAULT_ENV = "GOOGLE_APPLICATION_CREDENTIALS";
  private static final String GOOGLE_API_CLOUD_PLATFORM_LINK =
      "https://www.googleapis.com/auth/cloud-platform";

  private static final String IN_VPCSC_TEST = System.getenv(IN_VPCSC_GOOGLE_CLOUD_TEST_ENV);
  private static final String IN_VPCSC_PROJECT = System.getenv(IN_VPCSC_PROJECT_ENV);
  private static final String IN_VPCSC_HOSTNAME = System.getenv(IN_VPCSC_HOSTNAME_ENV);
  private static final String IN_VPCSC_GOOGLE_CREDENTIAL =
      System.getenv(IN_VPCSC_GOOGLE_CREDENTIAL_ENV);

  private String test0DisplayName;
  private String test1DisplayName;

  @BeforeClass
  public static void setUpClass() {
    assumeTrue(
        "To run tests, GOOGLE_CLOUD_TESTS_IN_VPCSC environment variable needs to be set to true",
        IN_VPCSC_TEST != null && IN_VPCSC_TEST.equalsIgnoreCase("true"));

    assertWithMessage(IN_VPCSC_PROJECT_ENV + " must be set to project that resides inside VPCSC")
        .that(IN_VPCSC_PROJECT)
        .isNotEmpty();

    assertWithMessage(IN_VPCSC_HOSTNAME_ENV + " must be set to host that resides inside VPCSC")
        .that(IN_VPCSC_HOSTNAME)
        .isNotEmpty();

    assertWithMessage(
        IN_VPCSC_GOOGLE_CREDENTIAL_ENV
            + " must be set to google application credentials that resides inside VPCSC")
        .that(IN_VPCSC_GOOGLE_CREDENTIAL)
        .isNotEmpty();

    assertWithMessage(
        GOOGLE_CREDENTIAL_DEFAULT_ENV
            + " must be set to google application credentials that resides inside VPCSC")
        .that(System.getenv(GOOGLE_CREDENTIAL_DEFAULT_ENV))
        .isNotEmpty();
  }

  @Before
  public void setUp() {
    ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
    String currentTime = DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(zonedDateTime);
    test0DisplayName = "vpcsctest-" + currentTime + "-0";
    test1DisplayName = "vpcsctest-" + currentTime + "-1";
  }

  private WebSecurityScannerSettings getWssSettingWithCredentials() throws IOException {
    GoogleCredentials credentials =
        GoogleCredentials.fromStream(new FileInputStream(IN_VPCSC_GOOGLE_CREDENTIAL))
            .createScoped(Lists.newArrayList(GOOGLE_API_CLOUD_PLATFORM_LINK));
    return WebSecurityScannerSettings.newBuilder()
        .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
        .build();
  }

  private WebSecurityScannerSettings getWssSettingWithoutCredentials() throws IOException {
    // If google-credentials is not passed explicitly then google apis uses the authentication
    // credentials provided in environment variable GOOGLE_APPLICATION_CREDENTIALS is used
    return WebSecurityScannerSettings.newBuilder().build();
  }

  @Test
  public void test0() throws IOException {
    try (WebSecurityScannerClient wssClient =
        WebSecurityScannerClient.create(getWssSettingWithoutCredentials())) {
      test(wssClient, test0DisplayName);
    }
  }

  @Test
  public void test1() throws IOException {
    try (WebSecurityScannerClient wssClient =
        WebSecurityScannerClient.create(getWssSettingWithCredentials())) {
      test(wssClient, test1DisplayName);
    }
  }

  private void test(final WebSecurityScannerClient wssClient, final String displayName) {
    // This test performs following steps:
    // 0. Create scan-config
    // 1. Make sure that created scan-config is present
    // 2. Start scan run on created scan-config
    // 3. Make sure that created scan-run is present.
    // 5. Stop the scan-run
    // 6. Make sure that scan-run is stopped
    // 7. Delete scan-config
    // 8. Make sure that deleted scan-config is not present.

    final String formattedParent = ProjectName.format(IN_VPCSC_PROJECT);

    class TestResource implements AutoCloseable {
      private WebSecurityScannerClient wssClient;
      private final String displayName;
      private ScanConfig createdScanConfig;
      private ScanRun startedScanRun;

      TestResource(WebSecurityScannerClient wssClient, String displayName) {
        this.wssClient = wssClient;
        this.displayName = displayName;
      }

      ScanConfig createScanConfig() {
        ScanConfig scanConfig =
            ScanConfig.newBuilder()
                .addAllStartingUrls(Lists.newArrayList(IN_VPCSC_HOSTNAME))
                .setDisplayName(displayName)
                .build();
        CreateScanConfigRequest request =
            CreateScanConfigRequest.newBuilder()
                .setParent(formattedParent)
                .setScanConfig(scanConfig)
                .build();
        createdScanConfig = wssClient.createScanConfig(request);
        return createdScanConfig;
      }

      void deleteScanConfig() {
        DeleteScanConfigRequest deleteScanConfigRequest =
            DeleteScanConfigRequest.newBuilder().setName(createdScanConfig.getName()).build();
        wssClient.deleteScanConfig(deleteScanConfigRequest);
        createdScanConfig = null;
      }

      ScanRun startScanRun() {
        StartScanRunRequest startScanRunRequest =
            StartScanRunRequest.newBuilder().setName(createdScanConfig.getName()).build();
        startedScanRun = wssClient.startScanRun(startScanRunRequest);
        return startedScanRun;
      }

      ScanRun stopScanRun() {
        StopScanRunRequest stopScanRunRequest =
            StopScanRunRequest.newBuilder().setName(startedScanRun.getName()).build();
        ScanRun stoppedScanRun = wssClient.stopScanRun(stopScanRunRequest);
        startedScanRun = null;
        return stoppedScanRun;
      }

      @Override
      public void close() {
        if (startedScanRun != null) {
          stopScanRun();
          startedScanRun = null;
        }

        if (createdScanConfig != null) {
          deleteScanConfig();
          createdScanConfig = null;
        }
      }
    }

    try (TestResource testResource = new TestResource(wssClient, displayName)) {

      ScanConfig responseScanConfig = testResource.createScanConfig();
      assertWithMessage("Display name is response must be equal to display name in request")
          .that(responseScanConfig.getDisplayName())
          .matches(displayName);

      // Make sure that created scan config is present
      GetScanConfigRequest scanConfigRequest =
          GetScanConfigRequest.newBuilder().setName(responseScanConfig.getName()).build();
      ScanConfig obtainedScanConfig = wssClient.getScanConfig(scanConfigRequest);
      assertWithMessage("Scan-Config name must be equal")
          .that(obtainedScanConfig.getName())
          .matches(responseScanConfig.getName());

      ListScanConfigsRequest lscRequest =
          ListScanConfigsRequest.newBuilder().setParent(formattedParent).build();
      boolean oneDisplayNameMatches = false;
      for (ScanConfig sc : wssClient.listScanConfigs(lscRequest).iterateAll()) {
        // since display name is never null so object equality can be used
        if (displayName.equals(sc.getDisplayName())) {
          oneDisplayNameMatches = true;
          break;
        }
      }
      assertWithMessage("One scan-config with " + displayName + " must be present")
          .that(oneDisplayNameMatches)
          .isTrue();

      ScanRun scanRunResponse = testResource.startScanRun();
      assertWithMessage("Scan-run name must not be empty")
          .that(scanRunResponse.getName())
          .isNotEmpty();
      assertWithMessage("Scan-run state must not be KILLED")
          .that(scanRunResponse.getResultState())
          .isNotEqualTo(ResultState.KILLED);

      ScanRun stoppedScanRun = testResource.stopScanRun();
      assertWithMessage("Result state must be killed")
          .that(stoppedScanRun.getResultState())
          .isEqualTo(ResultState.KILLED);

      testResource.deleteScanConfig();

      // make sure that deleted scan-config do not exist
      GetScanConfigRequest getScanConfigRequest =
          GetScanConfigRequest.newBuilder().setName(responseScanConfig.getName()).build();
      try {
        ScanConfig deletedScanConfig = wssClient.getScanConfig(getScanConfigRequest);
        fail("NotFoundException must be throw as scan-config must already be deleted");
      } catch (NotFoundException nfe) {
      }
    }
  }
}
