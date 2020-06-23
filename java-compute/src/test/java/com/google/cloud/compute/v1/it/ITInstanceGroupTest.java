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
import static org.junit.Assert.assertNotNull;

import com.google.cloud.compute.v1.InstanceGroup;
import com.google.cloud.compute.v1.InstanceGroupClient;
import com.google.cloud.compute.v1.InstanceGroupSettings;
import com.google.cloud.compute.v1.InstanceGroupsListInstancesRequest;
import com.google.cloud.compute.v1.InstanceGroupsScopedList;
import com.google.cloud.compute.v1.InstanceGroupsSetNamedPortsRequest;
import com.google.cloud.compute.v1.InstanceWithNamedPorts;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectZoneInstanceGroupName;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITInstanceGroupTest extends BaseTest {

  private static final String INSTANCE_GROUP = TestHelper.getTestUniqueName("instance-group");
  private static final String INSTANCE_GROUP_LINK =
      String.format("%s/instanceGroups/%s", ZONE_SELF_LINK, INSTANCE_GROUP);
  private static final ProjectZoneInstanceGroupName INSTANCE_GROUP_NAME =
      ProjectZoneInstanceGroupName.of(INSTANCE_GROUP, DEFAULT_PROJECT, ZONE);

  private static InstanceGroupClient instanceGroupClient;

  private static ListMultimap<String, String> resourcesToCleanUp = ArrayListMultimap.create();

  @BeforeClass
  public static void setUp() throws IOException {
    InstanceGroupSettings instanceGroupSettings =
        InstanceGroupSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    instanceGroupClient = InstanceGroupClient.create(instanceGroupSettings);

    InstanceGroup instanceGroupResource =
        InstanceGroup.newBuilder().setName(INSTANCE_GROUP).build();
    Operation completedOperation =
        waitForOperation(
            instanceGroupClient.insertInstanceGroup(PROJECT_ZONE_NAME, instanceGroupResource));
    resourcesToCleanUp.put("instance-group", completedOperation.getTargetLink());
  }

  @AfterClass
  public static void tearDown() {
    for (String instanceGroup : resourcesToCleanUp.get("instance-group")) {
      waitForOperation(instanceGroupClient.deleteInstanceGroup(instanceGroup));
    }
    instanceGroupClient.close();
  }

  @Test
  public void getInstanceGroupTest() {
    InstanceGroup instanceGroup = instanceGroupClient.getInstanceGroup(INSTANCE_GROUP_NAME);
    assertThat(instanceGroup).isNotNull();
    assertThat(instanceGroup.getName()).isEqualTo(INSTANCE_GROUP);
    assertThat(instanceGroup.getSelfLink()).isEqualTo(INSTANCE_GROUP_LINK);
    assertThat(instanceGroup.getZone()).isEqualTo(ZONE_SELF_LINK);
  }

  @Test
  public void listInstanceGroupsTest() {
    List<InstanceGroup> instanceGroups =
        Lists.newArrayList(instanceGroupClient.listInstanceGroups(PROJECT_ZONE_NAME).iterateAll());
    for (InstanceGroup instanceGroup : instanceGroups) {
      if (INSTANCE_GROUP.equals(instanceGroup.getName())) {
        assertThat(instanceGroup.getName()).isEqualTo(INSTANCE_GROUP);
        assertThat(instanceGroup.getSelfLink()).isEqualTo(INSTANCE_GROUP_LINK);
        assertThat(instanceGroup.getZone()).isEqualTo(ZONE_SELF_LINK);
      }
    }
  }

  @Test
  public void listInstancesInstanceGroupsTest() {
    ProjectZoneInstanceGroupName instanceGroup =
        ProjectZoneInstanceGroupName.of(INSTANCE_GROUP, DEFAULT_PROJECT, ZONE);
    InstanceGroupsListInstancesRequest instancesRequest =
        InstanceGroupsListInstancesRequest.newBuilder().build();
    List<InstanceWithNamedPorts> instanceWithNamedPorts =
        Lists.newArrayList(
            instanceGroupClient
                .listInstancesInstanceGroups(instanceGroup, instancesRequest)
                .iterateAll());
    assertThat(instanceWithNamedPorts).isNotNull();
    assertThat(instanceWithNamedPorts.size()).isEqualTo(0);
    assertThat(instanceWithNamedPorts.contains(null)).isFalse();
  }

  @Test
  public void aggregatedListInstanceGroupsTest() {
    List<InstanceGroupsScopedList> scopedLists =
        Lists.newArrayList(
            instanceGroupClient.aggregatedListInstanceGroups(true, PROJECT_NAME).iterateAll());
    for (InstanceGroupsScopedList instanceGroupsScopedList : scopedLists) {
      List<InstanceGroup> instanceGroups = instanceGroupsScopedList.getInstanceGroupsList();
      if (null != instanceGroups && instanceGroups.size() > 0) {
        for (InstanceGroup instanceGroup : instanceGroups) {
          if (INSTANCE_GROUP.equals(instanceGroup.getName())) {
            assertThat(instanceGroup.getName()).isEqualTo(INSTANCE_GROUP);
            assertThat(instanceGroup.getSelfLink()).isEqualTo(INSTANCE_GROUP_LINK);
            assertThat(instanceGroup.getZone()).isEqualTo(ZONE_SELF_LINK);
          }
        }
      }
    }
  }

  @Test
  public void setNamedPortsInstanceGroupTest() {
    ProjectZoneInstanceGroupName instanceGroup =
        ProjectZoneInstanceGroupName.of(INSTANCE_GROUP, DEFAULT_PROJECT, ZONE);
    InstanceGroupsSetNamedPortsRequest instanceGroupsSetNamedPortsRequestResource =
        InstanceGroupsSetNamedPortsRequest.newBuilder().build();
    Operation portsInstanceGroup =
        instanceGroupClient.setNamedPortsInstanceGroup(
            instanceGroup, instanceGroupsSetNamedPortsRequestResource);
    assertNotNull(portsInstanceGroup);
    assertThat(portsInstanceGroup.getOperationType())
        .isEqualTo("compute.instanceGroups.setNamedPorts");
    assertThat(portsInstanceGroup.getStatus()).isEqualTo("DONE");
    assertThat(portsInstanceGroup.getZone()).isEqualTo(ZONE_SELF_LINK);
    assertThat(portsInstanceGroup.getTargetLink()).isEqualTo(INSTANCE_GROUP_LINK);
  }
}
