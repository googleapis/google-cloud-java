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
import static org.junit.Assert.fail;

import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.compute.v1.AttachedDisk;
import com.google.cloud.compute.v1.AttachedDiskInitializeParams;
import com.google.cloud.compute.v1.Instance;
import com.google.cloud.compute.v1.InstanceClient;
import com.google.cloud.compute.v1.InstanceSettings;
import com.google.cloud.compute.v1.ProjectZoneMachineTypeName;
import com.google.cloud.compute.v1.ProjectZoneName;
import java.io.IOException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITInstanceTest extends BaseTest {
  private static final String DEFAULT_IMAGE =
      "https://www.googleapis.com/compute/v1/projects/debian-cloud/global/images/debian-7-wheezy-v20150710";

  private static InstanceClient instanceClient;

  @BeforeClass
  public static void setUp() throws IOException {
    InstanceSettings instanceSettings =
        InstanceSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    instanceClient = InstanceClient.create(instanceSettings);
  }

  @AfterClass
  public static void tearDown() {
    instanceClient.close();
  }

  @Test
  public void testInsertInstance() {
    String machineType =
        ProjectZoneMachineTypeName.of("n1-standard-1", DEFAULT_PROJECT, ZONE).toString();
    AttachedDisk disk =
        AttachedDisk.newBuilder()
            .setBoot(true)
            .setAutoDelete(true)
            .setType("PERSISTENT")
            .setInitializeParams(
                AttachedDiskInitializeParams.newBuilder().setSourceImage(DEFAULT_IMAGE).build())
            .build();
    Instance instance =
        Instance.newBuilder()
            .setName("mytestinstancetemplate")
            .setMachineType(machineType)
            .addDisks(disk)
            .build();
    try {
      instanceClient.insertInstance(ProjectZoneName.of(DEFAULT_PROJECT, ZONE), instance);
    } catch (InvalidArgumentException e) {
      // Expect a Bad Request HTTP 400 error, but it should NOT be because of a resource name
      // problem.
      assertThat(e.getMessage()).contains("Bad Request");
      assertThat(e.getCause().getMessage())
          .contains("Invalid value for field 'resource.networkInterfaces'");
      return;
    }

    fail("Expected HTTP Bad Request to be returned, but it was not returned.");
  }
}
