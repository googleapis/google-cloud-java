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
import static org.junit.Assert.*;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.compute.v1.AttachedDisk;
import com.google.cloud.compute.v1.Disk;
import com.google.cloud.compute.v1.DiskClient;
import com.google.cloud.compute.v1.DiskSettings;
import com.google.cloud.compute.v1.DiskTypeSettings;
import com.google.cloud.compute.v1.GlobalOperationClient;
import com.google.cloud.compute.v1.GlobalOperationSettings;
import com.google.cloud.compute.v1.InstanceGroupManager;
import com.google.cloud.compute.v1.InstanceGroupManagerClient;
import com.google.cloud.compute.v1.InstanceGroupManagerSettings;
import com.google.cloud.compute.v1.InstanceGroupManagersScopedList;
import com.google.cloud.compute.v1.InstanceProperties;
import com.google.cloud.compute.v1.InstanceTemplate;
import com.google.cloud.compute.v1.InstanceTemplateClient;
import com.google.cloud.compute.v1.InstanceTemplateSettings;
import com.google.cloud.compute.v1.NetworkInterface;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectGlobalOperationName;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectZoneName;
import com.google.cloud.compute.v1.ProjectZoneOperationName;
import com.google.cloud.compute.v1.ZoneOperationClient;
import com.google.cloud.compute.v1.ZoneOperationSettings;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITInstanceGroupManagerTest {
  private static final String DEFAULT_PROJECT = ServiceOptions.getDefaultProjectId();
  private static final ProjectName PROJECT_NAME = ProjectName.of(DEFAULT_PROJECT);
  private static final String ZONE = "us-central1-a";
  private static final String UID = UUID.randomUUID().toString();
  private static final String ID = UID.substring(0, 8);
  private static final ProjectZoneName PROJECT_ZONE_NAME =
      ProjectZoneName.of(DEFAULT_PROJECT, ZONE);

  private static DiskClient diskClient;
  private static InstanceGroupManagerClient instanceGroupManagerClient;
  private static InstanceTemplateClient instanceTemplateClient;
  private static GlobalOperationClient globalOperationClient;
  private static ZoneOperationClient zoneOperationClient;

  private static ListMultimap<String, String> resourcesToCleanUp = ArrayListMultimap.create();

  private static String instanceGroupManagerSelfLink;

  @BeforeClass
  public static void setUp() throws IOException {
    Credentials credentials =
        GoogleCredentials.getApplicationDefault()
            .createScoped(DiskTypeSettings.getDefaultServiceScopes());
    FixedCredentialsProvider credentialsProvider = FixedCredentialsProvider.create(credentials);

    DiskSettings diskSettings =
        DiskSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    diskClient = DiskClient.create(diskSettings);

    InstanceTemplateSettings instanceTemplateSettings =
        InstanceTemplateSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    instanceTemplateClient = InstanceTemplateClient.create(instanceTemplateSettings);

    InstanceGroupManagerSettings instanceGroupManagerSettings =
        InstanceGroupManagerSettings.newBuilder()
            .setCredentialsProvider(credentialsProvider)
            .build();
    instanceGroupManagerClient = InstanceGroupManagerClient.create(instanceGroupManagerSettings);

    GlobalOperationSettings globalOperationSettings =
        GlobalOperationSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    globalOperationClient = GlobalOperationClient.create(globalOperationSettings);

    ZoneOperationSettings zoneOperationSettings =
        ZoneOperationSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    zoneOperationClient = ZoneOperationClient.create(zoneOperationSettings);

    // create a disk
    Disk disk = Disk.newBuilder().setName("test-" + ID).build();
    Operation completedOperation = waitForOperation(diskClient.insertDisk(PROJECT_ZONE_NAME, disk));
    resourcesToCleanUp.put("disk", completedOperation.getTargetLink());

    // create an instance template
    InstanceTemplate instanceTemplate =
        InstanceTemplate.newBuilder()
            .setName("test-" + ID)
            .setProperties(
                InstanceProperties.newBuilder()
                    .setMachineType("n1-standard-1")
                    .addDisks(
                        AttachedDisk.newBuilder()
                            .setType("PERSISTENT")
                            .setSource("test-" + ID)
                            .setBoot(true)
                            .build())
                    .addNetworkInterfaces(
                        NetworkInterface.newBuilder().setNetwork("global/networks/default").build())
                    .build())
            .build();
    completedOperation =
        waitForOperation(
            instanceTemplateClient.insertInstanceTemplate(
                ProjectName.of(DEFAULT_PROJECT), instanceTemplate));
    String instanceTemplateSelfLink = completedOperation.getTargetLink();
    resourcesToCleanUp.put("instance-template", instanceTemplateSelfLink);

    // Create an instance group manager
    InstanceGroupManager instanceGroupManager =
        InstanceGroupManager.newBuilder()
            .setBaseInstanceName("base-instance-" + ID)
            .setName("test-instance-group-" + ID)
            .setTargetSize(0)
            .setInstanceTemplate(instanceTemplateSelfLink)
            .build();
    completedOperation =
        waitForOperation(
            instanceGroupManagerClient.insertInstanceGroupManager(
                PROJECT_ZONE_NAME, instanceGroupManager));
    instanceGroupManagerSelfLink = completedOperation.getTargetLink();
    assertNotNull(instanceGroupManagerSelfLink);
    resourcesToCleanUp.put("instance-group-manager", instanceGroupManagerSelfLink);
  }

  @AfterClass
  public static void tearDown() {
    for (String instanceGroupManager : resourcesToCleanUp.get("instance-group-manager")) {
      waitForOperation(instanceGroupManagerClient.deleteInstanceGroupManager(instanceGroupManager));
    }
    for (String instanceTemplate : resourcesToCleanUp.get("instance-template")) {
      waitForOperation(instanceTemplateClient.deleteInstanceTemplate(instanceTemplate));
    }
    for (String disk : resourcesToCleanUp.get("disk")) {
      waitForOperation(diskClient.deleteDisk(disk));
    }

    diskClient.close();
    instanceGroupManagerClient.close();
    instanceTemplateClient.close();
    globalOperationClient.close();
    zoneOperationClient.close();
  }

  @Test
  public void getInstanceGroupManagerTest() {
    InstanceGroupManager instanceGroupManager =
        instanceGroupManagerClient.getInstanceGroupManager(instanceGroupManagerSelfLink);
    assertEquals(instanceGroupManagerSelfLink, instanceGroupManager.getSelfLink());
  }

  @Test
  public void listInstanceGroupManagerTest() {
    // list instance groups and ensure we find the one we just created
    List<InstanceGroupManager> instanceGroupManagers =
        Lists.newArrayList(
            instanceGroupManagerClient.listInstanceGroupManagers(PROJECT_ZONE_NAME).iterateAll());
    assertThat(instanceGroupManagers).isNotNull();
    assertThat(instanceGroupManagers.size()).isGreaterThan(0);
    for (InstanceGroupManager manager : instanceGroupManagers) {
      if (manager.getSelfLink().equals(instanceGroupManagerSelfLink)) {
        // successfully found the expected instance
        return;
      }
    }
    fail("expected to find the inserted instance group manager");
  }

  @Test
  public void aggregatedListInstanceGroupManagersTest() {
    // list aggregated instance group managers
    List<InstanceGroupManagersScopedList> managersScopedLists =
        Lists.newArrayList(
            instanceGroupManagerClient
                .aggregatedListInstanceGroupManagers(true, PROJECT_NAME)
                .iterateAll());
    assertThat(managersScopedLists).isNotNull();
    assertThat(managersScopedLists.size()).isGreaterThan(0);
    for (InstanceGroupManagersScopedList instanceGroupManagersScopedList : managersScopedLists) {
      List<InstanceGroupManager> managers =
          instanceGroupManagersScopedList.getInstanceGroupManagersList();
      if (managers == null) {
        continue;
      }
      for (InstanceGroupManager manager : managers) {
        if (manager.getSelfLink().equals(instanceGroupManagerSelfLink)) {
          // successfully found the expected instance
          return;
        }
      }
    }
    fail("expected to find the inserted instance group manager");
  }

  private static Operation waitForOperation(Operation operation) {
    if (operation.getZone() != null) {
      return zoneOperationClient.waitZoneOperation(
          ProjectZoneOperationName.of(operation.getName(), DEFAULT_PROJECT, ZONE));
    }
    return globalOperationClient.waitGlobalOperation(
        ProjectGlobalOperationName.of(operation.getName(), DEFAULT_PROJECT));
  }
}
