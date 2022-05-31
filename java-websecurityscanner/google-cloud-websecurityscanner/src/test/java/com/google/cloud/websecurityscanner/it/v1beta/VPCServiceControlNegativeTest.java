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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.rpc.PermissionDeniedException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.websecurityscanner.v1beta.CreateScanConfigRequest;
import com.google.cloud.websecurityscanner.v1beta.ListScanConfigsRequest;
import com.google.cloud.websecurityscanner.v1beta.ProjectName;
import com.google.cloud.websecurityscanner.v1beta.ScanConfig;
import com.google.cloud.websecurityscanner.v1beta.WebSecurityScannerClient;
import com.google.cloud.websecurityscanner.v1beta.WebSecurityScannerClient.ListScanConfigsPagedResponse;
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

/** Negative Integration tests for VPC-SC. */
@RunWith(JUnit4.class)
public class VPCServiceControlNegativeTest {

  private static final String IN_VPCSC_GOOGLE_CLOUD_TEST_ENV = "GOOGLE_CLOUD_TESTS_IN_VPCSC";
  private static final String OUT_VPCSC_PROJECT_ENV =
      "GOOGLE_CLOUD_TESTS_VPCSC_OUTSIDE_PERIMETER_PROJECT";
  private static final String OUT_VPCSC_HOSTNAME_ENV =
      "GOOGLE_CLOUD_WEBSECURITYSCANNER_OUTSIDE_HOSTNAME";
  private static final String GOOGLE_CREDENTIAL_DEFAULT_ENV = "GOOGLE_APPLICATION_CREDENTIALS";
  private static final String GOOGLE_API_CLOUD_PLATFORM_LINK =
      "https://www.googleapis.com/auth/cloud-platform";

  private static final String IN_VPCSC_TEST = System.getenv(IN_VPCSC_GOOGLE_CLOUD_TEST_ENV);
  private static final String OUT_VPCSC_PROJECT = System.getenv(OUT_VPCSC_PROJECT_ENV);
  private static final String OUT_VPCSC_HOSTNAME = System.getenv(OUT_VPCSC_HOSTNAME_ENV);
  private static final String OUT_VPCSC_GOOGLE_CREDENTIAL =
      System.getenv(GOOGLE_CREDENTIAL_DEFAULT_ENV);

  private String testScanConfigCreationDisplayName;

  private static boolean isNotEmpty(String value) {
    return value != null && value.length() != 0;
  }

  @BeforeClass
  public static void setUpClass() {
    assumeTrue(
        "To run tests, GOOGLE_CLOUD_TESTS_IN_VPCSC environment variable needs to be set to true",
        IN_VPCSC_TEST != null && IN_VPCSC_TEST.equalsIgnoreCase("true"));

    assertTrue(
        OUT_VPCSC_PROJECT_ENV
            + " environment variable needs to be set to a GCP "
            + "project that is out of the VPC perimeter",
        isNotEmpty(OUT_VPCSC_PROJECT));

    assertTrue(
        OUT_VPCSC_HOSTNAME_ENV + " must be set to a webapp that resides in " + OUT_VPCSC_PROJECT,
        isNotEmpty(OUT_VPCSC_HOSTNAME));

    assertTrue(
        GOOGLE_CREDENTIAL_DEFAULT_ENV
            + " must be set to google application credentials "
            + "that is outside VPCSC perimeter",
        isNotEmpty(OUT_VPCSC_GOOGLE_CREDENTIAL));
  }

  @Before
  public void setup() {
    DateTimeFormatter formatter =
        ISODateTimeFormat.basicDateTime().withZone(DateTimeZone.forID("America/Los_Angeles"));
    String currentTime = formatter.print(DateTime.now(DateTimeZone.forID("America/Los_Angeles")));
    testScanConfigCreationDisplayName = "vpcsc-neg-test" + currentTime + "-0";
  }

  private WebSecurityScannerSettings getWssSettingWithCredentials() throws IOException {
    GoogleCredentials credentials =
        GoogleCredentials.fromStream(new FileInputStream(OUT_VPCSC_GOOGLE_CREDENTIAL))
            .createScoped(Lists.newArrayList(GOOGLE_API_CLOUD_PLATFORM_LINK));
    return WebSecurityScannerSettings.newBuilder()
        .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
        .build();
  }

  @Test
  public void testScanConfigCreation() throws IOException {
    WebSecurityScannerSettings wssSetting = getWssSettingWithCredentials();
    final String formattedParent = ProjectName.format(OUT_VPCSC_PROJECT);
    try (WebSecurityScannerClient wssClient = WebSecurityScannerClient.create(wssSetting)) {
      ScanConfig scanConfig =
          ScanConfig.newBuilder()
              .addAllStartingUrls(Lists.newArrayList(OUT_VPCSC_HOSTNAME))
              .setDisplayName(testScanConfigCreationDisplayName)
              .build();
      CreateScanConfigRequest request =
          CreateScanConfigRequest.newBuilder()
              .setParent(formattedParent)
              .setScanConfig(scanConfig)
              .build();

      ScanConfig responseScanConfig = wssClient.createScanConfig(request);
      fail("Exception must occur for non-accessible project");
    } catch (PermissionDeniedException expected) {
    }
  }

  @Test
  public void testScanConfigList() throws IOException {
    // try to get the list of scan configs - it must fail
    WebSecurityScannerSettings wssSetting = getWssSettingWithCredentials();
    final String formattedParent = ProjectName.format(OUT_VPCSC_PROJECT);
    try (WebSecurityScannerClient wssClient = WebSecurityScannerClient.create(wssSetting)) {
      ListScanConfigsRequest lscRequest =
          ListScanConfigsRequest.newBuilder().setParent(formattedParent).build();
      ListScanConfigsPagedResponse scanConfigsList = wssClient.listScanConfigs(lscRequest);
      fail("Exception must occur for non-acceessible project scan-configs");
    } catch (PermissionDeniedException expected) {
    }
  }
}
