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
import com.google.api.services.compute.model.Instance;
import com.google.api.services.compute.model.InstanceGroup;
import com.google.api.services.compute.model.InstanceGroupsListInstances;
import com.google.api.services.compute.model.InstanceGroupsListInstancesRequest;
import com.google.api.services.compute.model.InstanceList;
import com.google.api.services.compute.model.InstanceWithNamedPorts;
import com.google.api.services.compute.model.Operation;
import com.google.cloud.compute.v1.ProjectZoneOperationName;
import com.google.cloud.compute.v1.ZoneOperationClient;
import com.google.cloud.examples.compute.v1.ComputeInstanceGroupExample;
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

/** Integration tests for {@link ComputeInstanceGroupExample} */
public class ITComputeInstanceGroupExample {

  private static final String PROJECT_PROPERTY_NAME = "bigtable.project";
  private static final String INSTANCE_GROUP_PREFIX = "instance-group";
  private static final String ZONE = "us-east1-b";
  private static String projectId;
  private static String instanceGroupId;
  private static Compute computeService;
  private static ComputeInstanceGroupExample instanceGroup;

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
    Compute.Instances.Delete request =
        computeService.instances().delete(projectId, ZONE, "test-instance");
    Operation response = request.execute();
    waitForOperationCompletion(response);
    garbageCollect();
  }

  @Before
  public void setUp() throws Exception {
    if (computeService == null) {
      throw new AssumptionViolatedException("Compute Service not set, skipping integration tests.");
    }
    instanceGroupId = generateInstanceGroupId();
    instanceGroup = new ComputeInstanceGroupExample(projectId, instanceGroupId, ZONE);
    InstanceGroup requestBody = new InstanceGroup().setName(instanceGroupId);
    Compute.InstanceGroups.Insert request =
        computeService.instanceGroups().insert(projectId, ZONE, requestBody);
    Operation response = request.execute();
    waitForOperationCompletion(response);
  }

  @After
  public void after() throws Exception {
    Compute.InstanceGroups.Delete request =
        computeService.instanceGroups().delete(projectId, ZONE, instanceGroupId);
    Operation response = request.execute();
    waitForOperationCompletion(response);
  }

  @Test
  public void testCreateComputeService() throws IOException, GeneralSecurityException {
    Compute computeService = instanceGroup.createComputeService();
    Assert.assertNotNull(computeService);
  }

  @Test(expected = GoogleJsonResponseException.class)
  public void testCreateAndDeleteInstanceGroup() throws Exception {
    // Create instance
    String testInstanceGroupId = generateInstanceGroupId();
    ComputeInstanceGroupExample testInstanceGroup =
        new ComputeInstanceGroupExample(projectId, testInstanceGroupId, ZONE);
    testInstanceGroup.createInstanceGroup();
    Compute.InstanceGroups.Get request =
        computeService.instanceGroups().get(projectId, ZONE, testInstanceGroupId);
    InstanceGroup response = request.execute();
    Assert.assertEquals(response.getName(), testInstanceGroupId);

    // Delete instance
    testInstanceGroup.deleteInstanceGroup();
    Compute.InstanceGroups.Get requestDeleted =
        computeService.instanceGroups().get(projectId, ZONE, testInstanceGroupId);
    InstanceGroup responseDeleted = requestDeleted.execute();
    Assert.assertNull(responseDeleted);
  }

  @Test
  public void testAddAndRemoveInstancesFromGroup() throws Exception {
    instanceGroup.createInstance();
    instanceGroup.addInstancesToGroup();
    boolean found = findInstanceInGroup();
    Assert.assertTrue(found);

    // Remove instance from instance group
    instanceGroup.removeInstancesFromGroup();
    found = findInstanceInGroup();
    Assert.assertFalse(found);
  }

  @Test
  public void testSetNamedPort() throws Exception {
    instanceGroup.setNamedPort();
  }

  @Test
  public void testGetInstanceGroup() throws IOException {
    Assert.assertEquals(instanceGroup.getInstanceGroup().getName(), instanceGroupId);
  }

  // TODO: add test for instanceGroup.run()

  private boolean findInstanceInGroup() throws IOException {
    InstanceGroupsListInstancesRequest requestBody = new InstanceGroupsListInstancesRequest();
    Compute.InstanceGroups.ListInstances request =
        computeService
            .instanceGroups()
            .listInstances(projectId, ZONE, instanceGroupId, requestBody);
    InstanceGroupsListInstances response;
    boolean found = false;
    do {
      response = request.execute();
      if (response.getItems() == null) {
        continue;
      }
      for (InstanceWithNamedPorts instanceWithNamedPorts : response.getItems()) {
        if (instanceWithNamedPorts.getInstance().contains("test-instance")) {
          found = true;
        }
      }
      request.setPageToken(response.getNextPageToken());
    } while (response.getNextPageToken() != null);
    return found;
  }

  private static void waitForOperationCompletion(Operation operation) throws Exception {
    ZoneOperationClient zoneOperationClient = ZoneOperationClient.create();
    ;
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

  private static String generateInstanceGroupId() {
    return String.format(
        "%s-%016x-%d", INSTANCE_GROUP_PREFIX, System.currentTimeMillis(), new Random().nextLong());
  }

  private static void garbageCollect() throws Exception {
    Pattern timestampPattern = Pattern.compile(INSTANCE_GROUP_PREFIX + "-([0-9]+)");
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
