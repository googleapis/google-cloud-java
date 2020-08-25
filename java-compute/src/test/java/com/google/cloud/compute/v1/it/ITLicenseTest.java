/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.it;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.compute.v1.*;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITLicenseTest extends BaseTest {
  private static final String LICENSE = TestHelper.getTestUniqueName("license");
  private static final String LICENSE_LINK =
      String.format("%s/global/licenses/%s", PROJECT_LINK, LICENSE);
  private static final ProjectGlobalLicenseName LICENSE_NAME =
      ProjectGlobalLicenseName.of(LICENSE, DEFAULT_PROJECT);

  private static LicenseClient licenseClient;
  private static ListMultimap<String, String> resourcesToCleanUp = ArrayListMultimap.create();

  @BeforeClass
  public static void setUp() throws IOException {
    LicenseSettings licenseSettings =
        LicenseSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    licenseClient = LicenseClient.create(licenseSettings);

    License license = License.newBuilder().setName(LICENSE).build();
    Operation completedOperation =
        waitForOperation(licenseClient.insertLicense(PROJECT_NAME, license));
    resourcesToCleanUp.put("license", completedOperation.getTargetLink());
  }

  @AfterClass
  public static void tearDown() {
    for (String license : resourcesToCleanUp.get("license")) {
      waitForOperation(licenseClient.deleteLicense(license));
    }
    licenseClient.close();
  }

  @Test
  public void getLicenseTest() {
    License license = licenseClient.getLicense(LICENSE_NAME);
    assertThat(license).isNotNull();
    assertThat(license.getChargesUseFee()).isFalse();
    assertThat(license.getName()).isEqualTo(LICENSE);
    assertThat(license.getSelfLink()).isEqualTo(LICENSE_LINK);
    assertThat(license.getTransferable()).isTrue();
  }

  @Test
  public void listLicensesTest() {
    List<License> licenses =
        Lists.newArrayList(licenseClient.listLicenses(PROJECT_NAME).iterateAll());
    for (License license : licenses) {
      if (LICENSE.equals(license.getName())) {
        assertThat(license.getChargesUseFee()).isFalse();
        assertThat(license.getName()).isEqualTo(LICENSE);
        assertThat(license.getSelfLink()).isEqualTo(LICENSE_LINK);
        assertThat(license.getTransferable()).isTrue();
      }
    }
  }

  @Test
  public void getIamPolicyLicenseTest() {
    ProjectGlobalLicenseResourceName licenseResourceName =
        ProjectGlobalLicenseResourceName.of(DEFAULT_PROJECT, LICENSE);
    Policy policy =
        licenseClient.getIamPolicyLicense(
            GetIamPolicyLicenseHttpRequest.newBuilder()
                .setResource(licenseResourceName.toString())
                .build());
    assertThat(policy).isNotNull();
    assertThat(policy.getEtag()).isEqualTo("ACAB");
  }
}
