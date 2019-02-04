/*
 * Copyright 2019 Google LLC.  All Rights Reserved.
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
package com.google.cloud.examples.compute;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.compute.Compute;
import com.google.api.services.compute.Compute.Builder;
import com.google.api.services.compute.model.AccessConfig;
import com.google.api.services.compute.model.AttachedDisk;
import com.google.api.services.compute.model.AttachedDiskInitializeParams;
import com.google.api.services.compute.model.Instance;
import com.google.api.services.compute.model.InstanceList;
import com.google.api.services.compute.model.NetworkInterface;
import com.google.api.services.compute.model.Operation;
import com.google.cloud.compute.v1.ProjectZoneOperationName;
import com.google.cloud.compute.v1.ZoneOperationClient;
import com.google.cloud.examples.compute.v1.ComputeInstanceExample;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/** Integration tests for {@link ComputeInstanceExample} */
public class ITComputeInstanceExample {

  private static final String PROJECT_PROPERTY_NAME = "bigtable.project";
  private static final String INSTANCE_PREFIX = "instance";
  private static final String ZONE = "us-east1-b";
  private static String projectId;
  private static String instanceId;
  private static Compute computeService;
  private static ComputeInstanceExample instance;

  @BeforeClass
  public static void beforeClass() throws IOException, GeneralSecurityException {
    projectId = System.getProperty(PROJECT_PROPERTY_NAME);
    if (projectId == null) {
      computeService = null;
      return;
    }
    HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
    JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
    GoogleCredential credential = GoogleCredential.getApplicationDefault();
    if (credential.createScopedRequired()) {
      credential =
          credential.createScoped(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"));
    }
    computeService =
        new Builder(httpTransport, jsonFactory, credential)
            .setApplicationName("Google-ComputeSample/0.1")
            .build();
  }

  @AfterClass
  public static void afterClass() throws Exception {
    garbageCollect();
  }

  @Before
  public void setUp() throws Exception {
    if (computeService == null) {
      throw new AssumptionViolatedException("Compute Service not set, skipping integration tests.");
    }
    instanceId = generateInstanceId();
    instance = new ComputeInstanceExample(projectId, instanceId, ZONE);
    Instance requestBody =
        new Instance()
            .setName(instanceId)
            .setZone("projects/" + projectId + "zones/" + ZONE)
            .setMachineType("zones/" + ZONE + "/machineTypes/n1-standard-1")
            .setDisks(
                Lists.newArrayList(
                    new AttachedDisk()
                        .setType("PERSISTENT")
                        .setBoot(true)
                        .setMode("READ_WRITE")
                        .setAutoDelete(true)
                        .setDeviceName(instanceId)
                        .setInitializeParams(
                            new AttachedDiskInitializeParams()
                                .setSourceImage(
                                    "projects/debian-cloud/global/images/debian-9-stretch-v20181210")
                                .setDiskType(
                                    "projects/grass-clump-479/zones/us-east1-b/diskTypes/pd-standard")
                                .setDiskSizeGb(10L))))
            .setCanIpForward(false)
            .setNetworkInterfaces(
                Lists.newArrayList(
                    new NetworkInterface()
                        .setSubnetwork(
                            "projects/" + projectId + "/regions/us-east1/subnetworks/default")
                        .setAccessConfigs(
                            Lists.newArrayList(
                                new AccessConfig()
                                    .setName("External NAT")
                                    .setType("ONE_TO_ONE_NAT")))));
    Compute.Instances.Insert request =
        computeService.instances().insert(projectId, ZONE, requestBody);
    Operation response = request.execute();
    waitForOperationCompletion(response);
  }

  @After
  public void after() throws Exception {
    Compute.Instances.Delete request =
        computeService.instances().delete(projectId, ZONE, instanceId);
    Operation response = request.execute();
    waitForOperationCompletion(response);
  }

  @Test
  public void testCreateComputeService() throws IOException, GeneralSecurityException {
    Compute computeService = instance.createComputeService();
    Assert.assertNotNull(computeService);
  }

  @Test(expected = GoogleJsonResponseException.class)
  public void testCreateAndDeleteInstance() throws Exception {
    // Create instance
    String testInstanceId = generateInstanceId();
    ComputeInstanceExample testInstance =
        new ComputeInstanceExample(projectId, testInstanceId, ZONE);
    testInstance.createInstance();
    Compute.Instances.Get request = computeService.instances().get(projectId, ZONE, testInstanceId);
    Instance response = request.execute();
    Assert.assertEquals(response.getName(), testInstanceId);

    // Delete instance
    testInstance.deleteInstance();
    Compute.Instances.Get requestDeleted =
        computeService.instances().get(projectId, ZONE, testInstanceId);
    requestDeleted.execute();
  }

  // TODO: add test for instance.printInstances()
  // TODO: add test for instance.getAggregatedInstancesList()
  // TODO: add test for instance.resetInstance()
  // TODO: add test for instance.run()

  @Test
  public void testGetInstance() throws IOException {
    Instance getInstance = instance.getInstance();
    Assert.assertEquals(getInstance.getName(), instanceId);
  }

  @Test
  public void testStopInstance() throws Exception {
    instance.stopInstance();
    Compute.Instances.Get request = computeService.instances().get(projectId, ZONE, instanceId);
    Instance response = request.execute();
    Assert.assertEquals(response.getStatus(), "TERMINATED");
  }

  @Test
  public void testStartInstance() throws Exception {
    instance.startInstance();
    Compute.Instances.Get request = computeService.instances().get(projectId, ZONE, instanceId);
    Instance response = request.execute();
    Assert.assertEquals(response.getStatus(), "RUNNING");
  }

  private static void waitForOperationCompletion(Operation operation) throws Exception {
    ZoneOperationClient zoneOperationClient = ZoneOperationClient.create();
    ProjectZoneOperationName zoneOperationName =
        ProjectZoneOperationName.of(operation.getName(), projectId, ZONE);
    com.google.cloud.compute.v1.Operation actualResponse;
    do {
      actualResponse = zoneOperationClient.getZoneOperation(zoneOperationName);
      Thread.sleep(1000);
    } while (!(actualResponse.getStatus().equals("DONE") || actualResponse.getProgress() == 100));
    if (actualResponse.getError() != null) {
      throw new RuntimeException();
    }
  }

  private static String generateInstanceId() {
    return String.format(
        "%s-%016x-%d", INSTANCE_PREFIX, System.currentTimeMillis(), new Random().nextLong());
  }

  public static void garbageCollect() throws Exception {
    Pattern timestampPattern = Pattern.compile(INSTANCE_PREFIX + "-([0-9]+)");
    Compute.Instances.List request = computeService.instances().list(projectId, ZONE);
    InstanceList response;
    do {
      response = request.execute();
      if (response.getItems() == null) {
        continue;
      }
      for (Instance instance : response.getItems()) {
        Matcher matcher = timestampPattern.matcher(instance.getName());
        if (!matcher.matches()) {
          continue;
        }
        String timestampStr = matcher.group(1);
        long timestamp = Long.parseLong(timestampStr, 16);
        if (System.currentTimeMillis() - timestamp < TimeUnit.MINUTES.toMillis(10)) {
          continue;
        }
        System.out.println("Garbage collecting orphaned instance: " + instance.getName());
        Compute.Instances.Delete deleteRequest =
            computeService.instances().delete(projectId, ZONE, instance.getName());
        Operation deleteResponse = deleteRequest.execute();
        waitForOperationCompletion(deleteResponse);
      }
      request.setPageToken(response.getNextPageToken());
    } while (response.getNextPageToken() != null);
  }
}
