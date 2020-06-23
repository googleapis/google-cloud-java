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

import static org.junit.Assert.fail;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.compute.v1.DiskTypeSettings;
import com.google.cloud.compute.v1.GlobalOperationClient;
import com.google.cloud.compute.v1.GlobalOperationSettings;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectGlobalOperationName;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectRegionName;
import com.google.cloud.compute.v1.ProjectRegionOperationName;
import com.google.cloud.compute.v1.ProjectZoneName;
import com.google.cloud.compute.v1.ProjectZoneOperationName;
import com.google.cloud.compute.v1.RegionOperationClient;
import com.google.cloud.compute.v1.RegionOperationSettings;
import com.google.cloud.compute.v1.ZoneOperationClient;
import com.google.cloud.compute.v1.ZoneOperationSettings;
import java.io.IOException;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseTest {

  protected static final String DEFAULT_PROJECT = ServiceOptions.getDefaultProjectId();
  protected static final ProjectName PROJECT_NAME = ProjectName.of(DEFAULT_PROJECT);
  protected static final String PROJECT_LINK =
      String.format("https://www.googleapis.com/compute/v1/projects/%s", DEFAULT_PROJECT);
  protected static final String ZONE = "us-central1-a";
  protected static final String ZONE_SELF_LINK = String.format("%s/zones/%s", PROJECT_LINK, ZONE);

  protected static final String REGION = "us-central1";
  protected static final String REGION_LINK = String.format("%s/regions/%s", PROJECT_LINK, REGION);
  protected static final ProjectRegionName PROJECT_REGION_NAME =
      ProjectRegionName.of(DEFAULT_PROJECT, REGION);
  protected static final String IP_PROTOCOL = "TCP";
  protected static final ProjectZoneName PROJECT_ZONE_NAME =
      ProjectZoneName.of(DEFAULT_PROJECT, ZONE);

  private static GlobalOperationClient globalOperationClient;
  private static RegionOperationClient regionOperationClient;
  private static ZoneOperationClient zoneOperationClient;
  protected static CredentialsProvider credentialsProvider;

  @BeforeClass
  public static void setUpOperationClients() throws IOException {
    Credentials credentials =
        GoogleCredentials.getApplicationDefault()
            .createScoped(DiskTypeSettings.getDefaultServiceScopes());
    credentialsProvider = FixedCredentialsProvider.create(credentials);

    GlobalOperationSettings globalOperationSettings =
        GlobalOperationSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    globalOperationClient = GlobalOperationClient.create(globalOperationSettings);

    RegionOperationSettings regionOperationSettings =
        RegionOperationSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    regionOperationClient = RegionOperationClient.create(regionOperationSettings);

    ZoneOperationSettings zoneOperationSettings =
        ZoneOperationSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    zoneOperationClient = ZoneOperationClient.create(zoneOperationSettings);
  }

  @AfterClass
  public static void tearDownOperationClients() {
    globalOperationClient.close();
    regionOperationClient.close();
    zoneOperationClient.close();
  }

  protected static Operation waitForOperation(Operation operation) {
    Operation completedOperation;
    if (operation.getZone() != null) {
      completedOperation =
          zoneOperationClient.waitZoneOperation(
              ProjectZoneOperationName.of(operation.getName(), DEFAULT_PROJECT, ZONE));
    } else if (operation.getRegion() != null) {
      completedOperation =
          regionOperationClient.waitRegionOperation(
              ProjectRegionOperationName.of(operation.getName(), DEFAULT_PROJECT, REGION));
    } else {
      completedOperation =
          globalOperationClient.waitGlobalOperation(
              ProjectGlobalOperationName.of(operation.getName(), DEFAULT_PROJECT));
    }
    if (completedOperation.getError() != null) {
      fail("Operation failed: " + completedOperation.getError().toString());
    }
    return completedOperation;
  }
}
