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

package com.google.cloud.notebooks.v1beta1.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.api.FieldBehavior;
import com.google.cloud.ServiceOptions;
import com.google.cloud.notebooks.v1beta1.ContainerImage;
import com.google.cloud.notebooks.v1beta1.CreateEnvironmentRequest;
import com.google.cloud.notebooks.v1beta1.CreateInstanceRequest;
import com.google.cloud.notebooks.v1beta1.DeleteEnvironmentRequest;
import com.google.cloud.notebooks.v1beta1.DeleteInstanceRequest;
import com.google.cloud.notebooks.v1beta1.Environment;
import com.google.cloud.notebooks.v1beta1.GetEnvironmentRequest;
import com.google.cloud.notebooks.v1beta1.GetInstanceRequest;
import com.google.cloud.notebooks.v1beta1.Instance;
import com.google.cloud.notebooks.v1beta1.ListEnvironmentsRequest;
import com.google.cloud.notebooks.v1beta1.ListInstancesRequest;
import com.google.cloud.notebooks.v1beta1.NotebookServiceClient;
import com.google.cloud.notebooks.v1beta1.ResetInstanceRequest;
import com.google.cloud.notebooks.v1beta1.SetInstanceAcceleratorRequest;
import com.google.cloud.notebooks.v1beta1.SetInstanceLabelsRequest;
import com.google.cloud.notebooks.v1beta1.SetInstanceMachineTypeRequest;
import com.google.cloud.notebooks.v1beta1.StartInstanceRequest;
import com.google.cloud.notebooks.v1beta1.StopInstanceRequest;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITNotebookServiceClientTest {

  private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private static final String LOCATION = "us-central1-a";
  private static final String PARENT = "projects/" + PROJECT_ID + "/locations/" + LOCATION;
  private static NotebookServiceClient client;
  private static final String ID = UUID.randomUUID().toString().substring(0, 8);
  private static final String NOTEBOOK_INSTANCE_ID = "test-notebook-instance-id-" + ID;
  private static final String ENVIRONMENT_ID = "test-environment-id-" + ID;
  private static final String INSTANCE_NAME = PARENT + "/instances/" + NOTEBOOK_INSTANCE_ID;
  private static final String ENVIRONMENT_NAME = PARENT + "/environments/" + ENVIRONMENT_ID;
  private static Instance expectedNotebookInstance;
  private static Environment expectedEnvironmentResponse;
  private static final String MACHINE_TYPE_A = "n1-standard-4";
  private static final String MACHINE_TYPE_B = "n1-standard-2";

  @BeforeClass
  public static void setUp() throws IOException, ExecutionException, InterruptedException {
    // Create Test Notebook Instance
    client = NotebookServiceClient.create();
    ContainerImage containerImage =
        ContainerImage.newBuilder().setRepository(FieldBehavior.OPTIONAL.name()).build();

    Environment environment =
        Environment.newBuilder()
            .setName(ENVIRONMENT_NAME)
            .setContainerImage(containerImage)
            .build();

    CreateEnvironmentRequest environmentRequest =
        CreateEnvironmentRequest.newBuilder()
            .setParent(PARENT)
            .setEnvironmentId(ENVIRONMENT_ID)
            .setEnvironment(environment)
            .build();

    expectedEnvironmentResponse = client.createEnvironmentAsync(environmentRequest).get();

    Instance notebookInstance =
        Instance.newBuilder()
            .setContainerImage(containerImage)
            .setMachineType(MACHINE_TYPE_A)
            .build();
    CreateInstanceRequest instanceRequest =
        CreateInstanceRequest.newBuilder()
            .setParent(PARENT)
            .setInstanceId(NOTEBOOK_INSTANCE_ID)
            .setInstance(notebookInstance)
            .build();
    expectedNotebookInstance = client.createInstanceAsync(instanceRequest).get();
  }

  @AfterClass
  public static void tearDown() throws ExecutionException, InterruptedException {
    // Delete Test Environment Instance
    DeleteEnvironmentRequest deleteEnvironmentRequest =
        DeleteEnvironmentRequest.newBuilder().setName(ENVIRONMENT_NAME).build();
    client.deleteEnvironmentAsync(deleteEnvironmentRequest).get();
    // Delete Test Notebook Instance
    DeleteInstanceRequest deleteInstanceRequest =
        DeleteInstanceRequest.newBuilder().setName(INSTANCE_NAME).build();
    client.deleteInstanceAsync(deleteInstanceRequest).get();
    client.close();
  }

  private String stopInstance() throws ExecutionException, InterruptedException {
    StopInstanceRequest request = StopInstanceRequest.newBuilder().setName(INSTANCE_NAME).build();
    Instance response = client.stopInstanceAsync(request).get();
    return response.getState().name();
  }

  private String startInstance() throws ExecutionException, InterruptedException {
    StartInstanceRequest request = StartInstanceRequest.newBuilder().setName(INSTANCE_NAME).build();
    Instance response = client.startInstanceAsync(request).get();
    return response.getState().name();
  }

  @Test
  public void testGetInstance() {
    GetInstanceRequest request = GetInstanceRequest.newBuilder().setName(INSTANCE_NAME).build();
    Instance actualNotebookInstance = client.getInstance(request);
    assertEquals(
        expectedNotebookInstance.getContainerImage(), actualNotebookInstance.getContainerImage());
    assertEquals(expectedNotebookInstance.getName(), actualNotebookInstance.getName());
    assertEquals(expectedNotebookInstance.getNetwork(), actualNotebookInstance.getNetwork());
    assertEquals(expectedNotebookInstance.getSubnet(), actualNotebookInstance.getSubnet());
  }

  @Test
  public void testListInstances() {
    ListInstancesRequest request = ListInstancesRequest.newBuilder().setParent(PARENT).build();
    for (Instance element : client.listInstances(request).iterateAll()) {
      if (element.getName().equals(NOTEBOOK_INSTANCE_ID)) {
        assertEquals(expectedNotebookInstance.getContainerImage(), element.getContainerImage());
        assertEquals(expectedNotebookInstance.getName(), element.getName());
        assertEquals(expectedNotebookInstance.getMachineType(), element.getMachineType());
        assertEquals(expectedNotebookInstance.getNetwork(), element.getNetwork());
        assertEquals(expectedNotebookInstance.getSubnet(), element.getSubnet());
      }
    }
  }

  @Test
  public void testGetEnvironment() {
    GetEnvironmentRequest environmentRequest =
        GetEnvironmentRequest.newBuilder().setName(ENVIRONMENT_NAME).build();
    Environment expectedEnvironmentResponse = client.getEnvironment(environmentRequest);
    assertEquals(expectedEnvironmentResponse.getName(), expectedEnvironmentResponse.getName());
    assertEquals(
        expectedEnvironmentResponse.getContainerImage(),
        expectedEnvironmentResponse.getContainerImage());
  }

  @Test
  public void testListEnvironment() {
    ListEnvironmentsRequest request =
        ListEnvironmentsRequest.newBuilder().setParent(PARENT).build();
    for (Environment element : client.listEnvironments(request).iterateAll()) {
      if (element.getName().equals(ENVIRONMENT_ID)) {
        assertEquals(expectedEnvironmentResponse.getName(), element.getName());
        assertEquals(expectedEnvironmentResponse.getContainerImage(), element.getContainerImage());
      }
    }
  }

  @Test
  public void testSetInstanceLabels() throws ExecutionException, InterruptedException {
    SetInstanceLabelsRequest setInstanceLabelsRequest =
        SetInstanceLabelsRequest.newBuilder().setName(INSTANCE_NAME).putLabels("a", "100").build();
    Instance response = client.setInstanceLabelsAsync(setInstanceLabelsRequest).get();
    assertEquals(response.getLabelsMap().get("a"), "100");
  }

  @Test
  public void testSetInstanceMachineType() throws ExecutionException, InterruptedException {
    this.stopInstance();
    SetInstanceMachineTypeRequest request =
        SetInstanceMachineTypeRequest.newBuilder()
            .setName(INSTANCE_NAME)
            .setMachineType(MACHINE_TYPE_B)
            .build();
    Instance response = client.setInstanceMachineTypeAsync(request).get();
    assertTrue(response.getMachineType().endsWith(MACHINE_TYPE_B));
    this.startInstance();
  }

  @Test
  public void testStartInstance() throws ExecutionException, InterruptedException {
    String state = this.stopInstance();
    state = this.startInstance();
    assertEquals(state, "PROVISIONING");
  }

  @Test
  public void testStopInstance() throws ExecutionException, InterruptedException {
    String state = this.stopInstance();
    assertEquals(state, "STOPPED");
    state = this.startInstance();
  }

  @Test
  public void testSetInstanceAccelarator() throws ExecutionException, InterruptedException {
    this.stopInstance();
    SetInstanceAcceleratorRequest request =
        SetInstanceAcceleratorRequest.newBuilder()
            .setName(INSTANCE_NAME)
            .setType(Instance.AcceleratorType.NVIDIA_TESLA_P4)
            .setCoreCount(1L)
            .build();
    Instance response = client.setInstanceAcceleratorAsync(request).get();
    this.startInstance();
    assertEquals(
        response.getAcceleratorConfig().getType().name(),
        Instance.AcceleratorType.NVIDIA_TESLA_P4.name());
  }

  @Test
  public void testResetInstance() throws ExecutionException, InterruptedException {
    ResetInstanceRequest request = ResetInstanceRequest.newBuilder().setName(INSTANCE_NAME).build();
    Instance response = client.resetInstanceAsync(request).get();
    assertTrue(response.getMachineType().endsWith(MACHINE_TYPE_B));
  }
}
