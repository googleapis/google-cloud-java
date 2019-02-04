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
package com.google.cloud.examples.compute.v1;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.compute.Compute;
import com.google.api.services.compute.model.AccessConfig;
import com.google.api.services.compute.model.AttachedDisk;
import com.google.api.services.compute.model.AttachedDiskInitializeParams;
import com.google.api.services.compute.model.Instance;
import com.google.api.services.compute.model.InstanceAggregatedList;
import com.google.api.services.compute.model.InstanceList;
import com.google.api.services.compute.model.InstancesScopedList;
import com.google.api.services.compute.model.NetworkInterface;
import com.google.api.services.compute.model.Operation;
import com.google.cloud.compute.v1.ProjectZoneOperationName;
import com.google.cloud.compute.v1.ZoneOperationClient;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Map;

/**
 * This sample demonstrates how to use Google Compute Engine instances by using Java and the Google
 * Compute Engine API.
 */
public class ComputeInstanceExample {

  private static String projectId;
  private static String zone;
  private final String instanceId;
  private final Compute computeService;

  public static void main(String[] args) throws Exception {

    if (args.length != 2) {
      System.out.println("Missing required project id or zone");
    } else {
      projectId = args[0];
      zone = args[1];
      ComputeInstanceExample instance =
          new ComputeInstanceExample(projectId, "test-instance", zone);
      instance.run();
    }
  }

  public ComputeInstanceExample(String projectId, String instanceId, String zone)
      throws IOException, GeneralSecurityException {
    this.projectId = projectId;
    this.instanceId = instanceId;
    this.zone = zone;
    computeService = createComputeService();
  }

  public void run() throws Exception {
    createInstance();
    printInstances();
    getInstance();
    getAggregatedInstancesList();
    resetInstance();
    stopInstance();
    startInstance();
    deleteInstance();
  }

  /**
   * Creates a {@link Compute} object for listing instances.
   *
   * @return {@link Compute} object
   * @throws IOException
   * @throws GeneralSecurityException
   */
  public Compute createComputeService() throws IOException, GeneralSecurityException {
    HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
    JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
    GoogleCredential credential = GoogleCredential.getApplicationDefault();
    if (credential.createScopedRequired()) {
      credential =
          credential.createScoped(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"));
    }
    return new Compute.Builder(httpTransport, jsonFactory, credential)
        .setApplicationName("Google-ComputeSample/0.1")
        .build();
  }

  /**
   * Creates an instance resource in the specified project using the data included in the request.
   *
   * @throws Exception
   */
  public void createInstance() throws Exception {
    System.out.println("Creating instance");
    Instance requestBody =
        new Instance()
            .setName(instanceId)
            .setZone("projects/" + projectId + "zones/" + zone)
            .setMachineType("zones/" + zone + "/machineTypes/n1-standard-1")
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
        computeService.instances().insert(projectId, zone, requestBody);
    Operation response = request.execute();
    waitForOperationCompletion(response);
    System.out.printf("Instance created: %s%n", instanceId);
  }

  /**
   * Prints the list of instances contained within the specified zone.
   *
   * @throws IOException
   */
  public void printInstances() throws IOException {
    System.out.println("Listing Compute Engine Instances");
    Compute.Instances.List request = computeService.instances().list(projectId, zone);
    InstanceList response;
    do {
      response = request.execute();
      if (response.getItems() == null) {
        continue;
      }
      for (Instance instance : response.getItems()) {
        System.out.println(instance.toPrettyString());
      }
      request.setPageToken(response.getNextPageToken());
    } while (response.getNextPageToken() != null);
  }

  /**
   * Returns the specified instance resource. Gets a list of available instances by making a list()
   * request.
   *
   * @return an {@link Instance} object
   * @throws IOException
   */
  public Instance getInstance() throws IOException {
    System.out.println("Getting instance");
    Compute.Instances.Get request = computeService.instances().get(projectId, zone, instanceId);
    Instance response = request.execute();
    return response;
  }

  /**
   * Deletes the specified Instance resource.
   *
   * @throws Exception
   */
  public void deleteInstance() throws Exception {
    System.out.println("Deleting an Instance");
    Compute.Instances.Delete request =
        computeService.instances().delete(projectId, zone, instanceId);
    Operation response = request.execute();
    waitForOperationCompletion(response);
    System.out.printf("Deleted instance: %s%n", instanceId);
  }

  /**
   * Retrieves aggregated list of all of the instances in your project across all regions and zones.
   *
   * @throws IOException
   */
  public void getAggregatedInstancesList() throws IOException {
    System.out.println("Getting an aggregated list of all instances");
    Compute.Instances.AggregatedList request = computeService.instances().aggregatedList(projectId);
    InstanceAggregatedList response;
    do {
      response = request.execute();
      if (response.getItems() == null) {
        continue;
      }
      for (Map.Entry<String, InstancesScopedList> item : response.getItems().entrySet()) {
        System.out.println(item.getKey() + " " + item.getValue());
      }
      request.setPageToken(response.getNextPageToken());
    } while (response.getNextPageToken() != null);
  }

  /**
   * Stops a running instance, shutting it down cleanly, and allows you to restart the instance at a
   * later time. Stopped instances do not incur VM usage charges while they are stopped. However,
   * resources that the VM is using, such as persistent disks and static IP addresses, will continue
   * to be charged until they are deleted. For more information, @see <a
   * href="https://cloud.google.com/compute/docs/instances/stop-start-instance">Stopping an instance
   * </a>
   *
   * @throws Exception
   */
  public void stopInstance() throws Exception {
    System.out.println("Stopping an instance");
    Compute.Instances.Stop request = computeService.instances().stop(projectId, zone, instanceId);
    Operation response = request.execute();
    waitForOperationCompletion(response);
    System.out.println("Instance stopped successfully");
  }

  /**
   * Starts an instance that was stopped using the instances().stop method. For more information,
   *
   * @see <a
   *     href="https://cloud.google.com/compute/docs/instances/restarting-an-instance">Restarting an
   *     instance</a>
   * @throws Exception
   */
  public void startInstance() throws Exception {
    System.out.println("Starting an instance");
    Compute.Instances.Start request = computeService.instances().start(projectId, zone, instanceId);
    Operation response = request.execute();
    waitForOperationCompletion(response);
    System.out.println("Instance started successfully");
  }

  /**
   * Performs a reset on the instance. This is a hard reset; the VM does not do a graceful shutdown.
   * For more information, @see <a
   * href="https://cloud.google.com/compute/docs/instances/restarting-an-instance#resetting_an_instance">Resetting
   * an instance</a>
   *
   * @throws Exception
   */
  public void resetInstance() throws Exception {
    System.out.println("Resetting instance");
    Compute.Instances.Reset request = computeService.instances().reset(projectId, zone, instanceId);
    Operation response = request.execute();
    waitForOperationCompletion(response);
    System.out.println("Instance reset successfully");
  }

  /**
   * Waits for operation completion.
   *
   * @param operation an {@link Operation} object
   * @throws Exception
   */
  private void waitForOperationCompletion(Operation operation) throws Exception {
    ZoneOperationClient zoneOperationClient = ZoneOperationClient.create();
    ProjectZoneOperationName zoneOperationName =
        ProjectZoneOperationName.of(operation.getName(), projectId, zone);
    com.google.cloud.compute.v1.Operation actualResponse;
    do {
      actualResponse = zoneOperationClient.getZoneOperation(zoneOperationName);
      Thread.sleep(1000);
    } while (!(actualResponse.getStatus().equals("DONE") || actualResponse.getProgress() == 100));
    if (actualResponse.getError() != null) {
      throw new RuntimeException();
    }
  }
}
