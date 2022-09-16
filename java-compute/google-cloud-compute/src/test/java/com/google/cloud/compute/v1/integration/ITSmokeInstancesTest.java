/*
 * Copyright 2021 Google LLC
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
package com.google.cloud.compute.v1.integration;

import static junit.framework.TestCase.fail;

import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.compute.v1.Allowed;
import com.google.cloud.compute.v1.AttachedDisk;
import com.google.cloud.compute.v1.AttachedDiskInitializeParams;
import com.google.cloud.compute.v1.Firewall;
import com.google.cloud.compute.v1.FirewallsClient;
import com.google.cloud.compute.v1.GetInstanceRequest;
import com.google.cloud.compute.v1.Instance;
import com.google.cloud.compute.v1.InstanceGroupManager;
import com.google.cloud.compute.v1.InstanceGroupManagersClient;
import com.google.cloud.compute.v1.InstanceTemplate;
import com.google.cloud.compute.v1.InstanceTemplatesClient;
import com.google.cloud.compute.v1.InstancesClient;
import com.google.cloud.compute.v1.InstancesScopedList;
import com.google.cloud.compute.v1.InstancesSettings;
import com.google.cloud.compute.v1.NetworkInterface;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ShieldedInstanceConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITSmokeInstancesTest extends BaseTest {
  private static InstancesClient instancesClient;
  private static List<Instance> instances;
  private static final String DEFAULT_IMAGE =
      "projects/debian-cloud/global/images/family/debian-10";
  private static final AttachedDisk DISK =
      AttachedDisk.newBuilder()
          .setBoot(true)
          .setAutoDelete(true)
          .setType(AttachedDisk.Type.PERSISTENT.toString())
          .setInitializeParams(
              AttachedDiskInitializeParams.newBuilder().setSourceImage(DEFAULT_IMAGE).build())
          .build();
  private static final String MACHINE_TYPE =
      "https://www.googleapis.com/compute/v1/projects/"
          + DEFAULT_PROJECT
          + "/zones/us-central1-a/machineTypes/n1-standard-1";
  private static final NetworkInterface NETWORK_INTERFACE =
      NetworkInterface.newBuilder().setName("default").build();
  private static String INSTANCE;

  @BeforeClass
  public static void setUp() throws IOException {
    instances = new ArrayList<>();
    InstancesSettings instanceSettings = InstancesSettings.newBuilder().build();
    instancesClient = InstancesClient.create(instanceSettings);

    Util.cleanUpComputeInstances(instancesClient, DEFAULT_PROJECT, DEFAULT_ZONE);
  }

  @Before
  public void setUpMethod() {
    INSTANCE = generateRandomName("instance");
  }

  @AfterClass
  public static void tearDown() throws ExecutionException, InterruptedException {
    for (Instance instance : instances) {
      instancesClient.deleteAsync(DEFAULT_PROJECT, DEFAULT_ZONE, instance.getName());
    }
    instancesClient.close();
  }

  @Test
  public void testInsertInstance() throws ExecutionException, InterruptedException {
    Instance resultInstance = insertInstance();
    assertInstanceDetails(resultInstance);
  }

  @Test
  public void testUpdateInstanceDescToEmpty() throws ExecutionException, InterruptedException {
    // We test here: 1)set body field to an empty string
    //               2)unset body field
    Instance resultInstance = insertInstance();
    Assert.assertEquals("test", resultInstance.getDescription());
    Assert.assertEquals(0, resultInstance.getScheduling().getMinNodeCpus());
    Instance descInstance = resultInstance.toBuilder().setDescription("").build();
    instancesClient.updateAsync(DEFAULT_PROJECT, DEFAULT_ZONE, INSTANCE, descInstance).get();
    Instance updated = getInstance();
    assertInstanceDetails(updated);
    Assert.assertEquals("", updated.getDescription());
    Assert.assertEquals(0, resultInstance.getScheduling().getMinNodeCpus());
  }

  @Test
  public void testResizeGroupToZero() throws IOException, ExecutionException, InterruptedException {
    // We test here: 1)set body field to zero
    //               2)set query param to zero
    List<String> instanceGroupManagersToClean = new ArrayList<>();
    List<String> instanceTemplatesToClean = new ArrayList<>();
    InstanceTemplatesClient instanceTemplatesClient = InstanceTemplatesClient.create();
    InstanceGroupManagersClient instanceGroupManagersClient = InstanceGroupManagersClient.create();
    String templateName = generateRandomName("template");
    String instanceGroupManagerName = generateRandomName("igm");
    Instance instance = insertInstance();
    InstanceTemplate instanceTemplate =
        InstanceTemplate.newBuilder()
            .setSourceInstance(instance.getSelfLink())
            .setName(templateName)
            .build();
    Operation insertOperation =
        instanceTemplatesClient.insertAsync(DEFAULT_PROJECT, instanceTemplate).get();
    instanceTemplatesToClean.add(templateName);
    try {
      InstanceGroupManager instanceGroupManager =
          InstanceGroupManager.newBuilder()
              .setName(instanceGroupManagerName)
              .setBaseInstanceName("java-gapic")
              .setInstanceTemplate(insertOperation.getTargetLink())
              .setTargetSize(0)
              .build();
      instanceGroupManagersClient
          .insertAsync(DEFAULT_PROJECT, DEFAULT_ZONE, instanceGroupManager)
          .get();
      instanceGroupManagersToClean.add(instanceGroupManagerName);
      InstanceGroupManager fetched =
          instanceGroupManagersClient.get(DEFAULT_PROJECT, DEFAULT_ZONE, instanceGroupManagerName);
      Assert.assertEquals(0, fetched.getTargetSize());

      instanceGroupManagersClient
          .resizeAsync(DEFAULT_PROJECT, DEFAULT_ZONE, instanceGroupManagerName, 1)
          .get();

      InstanceGroupManager resizedIGM =
          instanceGroupManagersClient.get(DEFAULT_PROJECT, DEFAULT_ZONE, instanceGroupManagerName);
      Assert.assertEquals(1, resizedIGM.getTargetSize());

      instanceGroupManagersClient
          .resizeAsync(DEFAULT_PROJECT, DEFAULT_ZONE, instanceGroupManagerName, 0)
          .get();

      InstanceGroupManager instanceGroupManagerResized =
          instanceGroupManagersClient.get(DEFAULT_PROJECT, DEFAULT_ZONE, instanceGroupManagerName);
      Assert.assertEquals(0, instanceGroupManagerResized.getTargetSize());

    } finally {
      for (String name : instanceGroupManagersToClean) {
        instanceGroupManagersClient.deleteAsync(DEFAULT_PROJECT, DEFAULT_ZONE, name).get();
      }
      for (String name : instanceTemplatesToClean) {
        instanceTemplatesClient.deleteAsync(DEFAULT_PROJECT, name).get();
      }
    }
  }

  @Test
  public void testAggregatedList() throws ExecutionException, InterruptedException {
    insertInstance();
    boolean presented = false;
    InstancesClient.AggregatedListPagedResponse response =
        instancesClient.aggregatedList(DEFAULT_PROJECT);
    for (Map.Entry<String, InstancesScopedList> entry : response.iterateAll()) {
      if (entry.getKey().equals("zones/" + DEFAULT_ZONE)) {
        for (Instance instance : entry.getValue().getInstancesList()) {
          if (instance.getName().equals(INSTANCE)) {
            presented = true;
            assertInstanceDetails(instance);
          }
        }
      }
    }
    Assert.assertTrue(presented);
  }

  @Test
  public void testDefaultClient() throws IOException, ExecutionException, InterruptedException {
    InstancesClient defaultClient = InstancesClient.create();
    Instance instanceResource =
        Instance.newBuilder()
            .setName(INSTANCE)
            .setMachineType(MACHINE_TYPE)
            .addDisks(DISK)
            .addNetworkInterfaces(NETWORK_INTERFACE)
            .build();
    defaultClient.insertAsync(DEFAULT_PROJECT, DEFAULT_ZONE, instanceResource).get();
    instances.add(instanceResource);
    assertInstanceDetails(getInstance());
  }

  @Test
  public void testDefaultResource() throws InterruptedException {
    Instance instanceResource = Instance.newBuilder().build();
    try {
      instancesClient.insertAsync(DEFAULT_PROJECT, DEFAULT_ZONE, instanceResource).get();
      fail("Did not catch the exception");
    } catch (ExecutionException ex) {
      String message = "com.google.api.gax.rpc.InvalidArgumentException: Bad Request";
      Assert.assertEquals(message, ex.getMessage());
    }
  }

  @Test
  public void testApiError() {
    try {
      getInstance();
      fail("Did not catch the exception");
    } catch (NotFoundException ex) {
      String message = "Not Found";
      Assert.assertEquals(message, ex.getMessage());
    }
  }

  @Test
  public void testCapitalLetterField()
      throws IOException, ExecutionException, InterruptedException {
    // we want to test a field like "IPProtocol"
    String name = generateRandomName("fw-rule");
    FirewallsClient firewallsClient = FirewallsClient.create();
    Firewall firewall =
        Firewall.newBuilder()
            .setName(name)
            .addAllowed(Allowed.newBuilder().setIPProtocol("tcp").addPorts("80").build())
            .addSourceRanges("0.0.0.0/0")
            .build();
    try {
      firewallsClient.insertAsync(DEFAULT_PROJECT, firewall).get();
      Firewall fetched = firewallsClient.get(DEFAULT_PROJECT, name);
      Assert.assertEquals(name, fetched.getName());
      Assert.assertEquals("tcp", fetched.getAllowed(0).getIPProtocol());
    } finally {
      firewallsClient.deleteAsync(DEFAULT_PROJECT, name).get();
    }
  }

  @Test
  public void testPatch() throws ExecutionException, InterruptedException {
    Instance resultInstance = insertInstance();
    Assert.assertFalse(resultInstance.getShieldedInstanceConfig().getEnableSecureBoot());
    instancesClient.stopAsync(DEFAULT_PROJECT, DEFAULT_ZONE, INSTANCE).get();
    ShieldedInstanceConfig shieldedInstanceConfigResource =
        ShieldedInstanceConfig.newBuilder().setEnableSecureBoot(true).build();
    instancesClient
        .updateShieldedInstanceConfigAsync(
            DEFAULT_PROJECT, DEFAULT_ZONE, INSTANCE, shieldedInstanceConfigResource)
        .get();
    Instance updInstance = getInstance();
    Assert.assertTrue(updInstance.getShieldedInstanceConfig().getEnableSecureBoot());
  }

  private Instance insertInstance() throws ExecutionException, InterruptedException {
    Instance instanceResource =
        Instance.newBuilder()
            .setName(INSTANCE)
            .setMachineType(MACHINE_TYPE)
            .addDisks(DISK)
            .addNetworkInterfaces(NETWORK_INTERFACE)
            .setDescription("test")
            .build();
    instancesClient.insertAsync(DEFAULT_PROJECT, DEFAULT_ZONE, instanceResource).get();
    instances.add(instanceResource);
    return getInstance();
  }

  private Instance getInstance() {
    GetInstanceRequest request =
        GetInstanceRequest.newBuilder()
            .setProject(DEFAULT_PROJECT)
            .setZone(DEFAULT_ZONE)
            .setInstance(INSTANCE)
            .build();
    return instancesClient.get(request);
  }

  private void assertInstanceDetails(Instance instance) {
    Assert.assertNotNull(instance);
    Assert.assertEquals(instance.getName(), INSTANCE);
    Assert.assertNotNull(instance.getFingerprint());
    Assert.assertEquals(instance.getMachineType(), MACHINE_TYPE);
    Assert.assertEquals(instance.getDisksCount(), 1);
    Assert.assertEquals(
        instance.getDisksList().get(0).getType(), AttachedDisk.Type.PERSISTENT.toString());
    Assert.assertEquals(instance.getNetworkInterfacesCount(), 1);
  }
}
