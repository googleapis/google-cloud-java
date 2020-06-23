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

import com.google.cloud.compute.v1.MachineType;
import com.google.cloud.compute.v1.MachineTypeClient;
import com.google.cloud.compute.v1.MachineTypeSettings;
import com.google.cloud.compute.v1.MachineTypesScopedList;
import com.google.cloud.compute.v1.ProjectZoneMachineTypeName;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITMachineTypeTest extends BaseTest {

  private static final String MACHINE_TYPE = "n1-standard-1";
  private static final String MACHINE_TYPE_LINK =
      String.format("%s/machineTypes/%s", ZONE_SELF_LINK, MACHINE_TYPE);

  private static MachineTypeClient machineTypeClient;

  @BeforeClass
  public static void setUp() throws IOException {
    MachineTypeSettings machineTypeSettings =
        MachineTypeSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    machineTypeClient = MachineTypeClient.create(machineTypeSettings);
  }

  @AfterClass
  public static void tearDown() {
    machineTypeClient.close();
  }

  @Test
  public void getMachineTypeTest() {
    ProjectZoneMachineTypeName machineTypeName =
        ProjectZoneMachineTypeName.of(MACHINE_TYPE, DEFAULT_PROJECT, ZONE);
    MachineType machineType = machineTypeClient.getMachineType(machineTypeName);
    assertThat(machineTypeName).isNotNull();
    assertThat(machineType.getIsSharedCpu()).isFalse();
    assertThat(machineType.getName()).isEqualTo(MACHINE_TYPE);
    assertThat(machineType.getSelfLink()).isEqualTo(MACHINE_TYPE_LINK);
    assertThat(machineType.getZone()).isEqualTo(ZONE);
  }

  @Test
  public void listMachineTypesTest() {
    List<MachineType> machineTypes =
        Lists.newArrayList(machineTypeClient.listMachineTypes(PROJECT_ZONE_NAME).iterateAll());
    for (MachineType machineType : machineTypes) {
      if (MACHINE_TYPE.equals(machineType.getName())) {
        assertThat(machineType.getIsSharedCpu()).isFalse();
        assertThat(machineType.getName()).isEqualTo(MACHINE_TYPE);
        assertThat(machineType.getSelfLink()).isEqualTo(MACHINE_TYPE_LINK);
        assertThat(machineType.getZone()).isEqualTo(ZONE);
      }
    }
  }

  @Test
  public void aggregatedListMachineTypesTest() {
    List<MachineTypesScopedList> scopedLists =
        Lists.newArrayList(
            machineTypeClient.aggregatedListMachineTypes(true, PROJECT_NAME).iterateAll());
    for (MachineTypesScopedList scopedList : scopedLists) {
      List<MachineType> machineTypes = scopedList.getMachineTypesList();
      if (null != machineTypes && machineTypes.size() > 0) {
        for (MachineType machineType : machineTypes) {
          if (null != machineType && MACHINE_TYPE.equals(machineType.getName())) {
            assertThat(machineType.getIsSharedCpu()).isFalse();
            assertThat(machineType.getName()).isEqualTo(MACHINE_TYPE);
          }
        }
      }
    }
  }
}
