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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
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
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Positive Integration Tests for VPC-SC */
@RunWith(JUnit4.class)
public class VPCServiceControlPositiveTest {
  private static final String IN_VPCSC_GOOGLE_CLOUD_TEST_ENV = "GOOGLE_CLOUD_TESTS_IN_VPCSC";
  private static final String IN_VPCSC_PROJECT_ENV =
      "GOOGLE_CLOUD_TESTS_VPCSC_INSIDE_PERIMETER_PROJECT";
  private static final String IN_VPCSC_HOSTNAME_ENV = "GOOGLE_CLOUD_WEBSECURITYSCANNER_HOSTNAME";
  private static final String GOOGLE_CREDENTIAL_DEFAULT_ENV = "GOOGLE_APPLICATION_CREDENTIALS";
  private static final String GOOGLE_API_CLOUD_PLATFORM_LINK =
      "https://www.googleapis.com/auth/cloud-platform";

  private static final String IN_VPCSC_TEST = System.getenv(IN_VPCSC_GOOGLE_CLOUD_TEST_ENV);
  private static final String IN_VPCSC_PROJECT = System.getenv(IN_VPCSC_PROJECT_ENV);
  private static final String IN_VPCSC_HOSTNAME = System.getenv(IN_VPCSC_HOSTNAME_ENV);
  private static final String IN_VPCSC_GOOGLE_CREDENTIAL =
      System.getenv(GOOGLE_CREDENTIAL_DEFAULT_ENV);

  private String test0DisplayName;
  private String test1DisplayName;

  private static boolean isNotEmpty(String value) {
    return value != null && value.length() != 0;
  }

  @BeforeClass
  public static void setUpClass() {
    assumeTrue(
        "To run tests, GOOGLE_CLOUD_TESTS_IN_VPCSC environment variable needs to be set to true",
        IN_VPCSC_TEST != null && IN_VPCSC_TEST.equalsIgnoreCase("true"));

    assertTrue(
        IN_VPCSC_PROJECT_ENV
            + " environment variable needs to be set to a GCP "
            + "project that is inside the VPC perimeter",
        isNotEmpty(IN_VPCSC_PROJECT));

    assertTrue(
        IN_VPCSC_HOSTNAME_ENV
            + " environment variable needs to be set to a web "
            + "application that resides inside "
            + IN_VPCSC_PROJECT,
        isNotEmpty(IN_VPCSC_HOSTNAME));

    assertTrue(
        GOOGLE_CREDENTIAL_DEFAULT_ENV
            + " environment variable needs to be set to "
            + "google application credentials that resides inside VPCSC",
        isNotEmpty(IN_VPCSC_GOOGLE_CREDENTIAL));
  }

  @Before
  public void setUp() {
    DateTimeFormatter formatter =
        ISODateTimeFormat.basicDateTime().withZone(DateTimeZone.forID("America/Los_Angeles"));
    String currentTime = formatter.print(DateTime.now(DateTimeZone.forID("America/Los_Angeles")));
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

  private WebSecurityScannerSettings getWssSettingWithDefaultCredentials() throws IOException {
    // If google-credentials is not passed explicitly then google apis uses the authentication
    // credentials provided in environment variable GOOGLE_APPLICATION_CREDENTIALS is used
    return WebSecurityScannerSettings.newBuilder().build();
  }

  @Test
  public void testWithDefaultCredentials() throws IOException {
    try (WebSecurityScannerClient wssClient =
        WebSecurityScannerClient.create(getWssSettingWithDefaultCredentials())) {
      test(wssClient, test0DisplayName);
    }
  }

  @Test
  public void testWithCredentials() throws IOException {
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
      assertEquals(
          "Display name is response must be equal to display name in request",
          displayName,
          responseScanConfig.getDisplayName());

      // Make sure that created scan config is present
      GetScanConfigRequest scanConfigRequest =
          GetScanConfigRequest.newBuilder().setName(responseScanConfig.getName()).build();
      ScanConfig obtainedScanConfig = wssClient.getScanConfig(scanConfigRequest);
      assertEquals(
          "Scan-Config name must be equal",
          responseScanConfig.getName(),
          obtainedScanConfig.getName());

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
      assertTrue("One scan-config with " + displayName + " must be present", oneDisplayNameMatches);

      ScanRun scanRunResponse = testResource.startScanRun();
      assertTrue("Scan-run name must not be empty", isNotEmpty(scanRunResponse.getName()));

      assertNotEquals(
          "Scan-run state must not be KILLED",
          ResultState.KILLED,
          scanRunResponse.getResultState());

      ScanRun stoppedScanRun = testResource.stopScanRun();
      assertEquals(
          "Result state must be killed", ResultState.KILLED, stoppedScanRun.getResultState());
      testResource.deleteScanConfig();

      // make sure that deleted scan-config do not exist
      GetScanConfigRequest getScanConfigRequest =
          GetScanConfigRequest.newBuilder().setName(responseScanConfig.getName()).build();
      try {
        ScanConfig deletedScanConfig = wssClient.getScanConfig(getScanConfigRequest);
        fail("NotFoundException must be throw as scan-config must already be deleted");
      } catch (NotFoundException expected) {
      }
    }
  }
}
