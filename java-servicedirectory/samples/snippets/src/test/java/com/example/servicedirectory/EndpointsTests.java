/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.servicedirectory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import com.google.cloud.servicedirectory.v1beta1.EndpointName;
import com.google.cloud.servicedirectory.v1beta1.LocationName;
import com.google.cloud.servicedirectory.v1beta1.Namespace;
import com.google.cloud.servicedirectory.v1beta1.RegistrationServiceClient;
import com.google.cloud.servicedirectory.v1beta1.RegistrationServiceClient.ListNamespacesPagedResponse;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.UUID;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EndpointsTests {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String LOCATION_ID = "us-central1";
  private static final String NAMESPACE_ID = "namespace-" + UUID.randomUUID().toString();
  private static final String SERVICE_ID = "service-" + UUID.randomUUID().toString();
  private static final String ENDPOINT_ID = "endpoint-" + UUID.randomUUID().toString();

  private ByteArrayOutputStream bout;

  private static void requireEnvVar(String varName) {
    assertNotNull(
        String.format("Environment variable '%s' must be set to perform these tests.", varName),
        System.getenv(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
  }

  @Before
  public void setUp() throws Exception {
    bout = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bout));

    // Setup: create a namespace for the endpoints to live in.
    NamespacesCreate.createNamespace(PROJECT_ID, LOCATION_ID, NAMESPACE_ID);

    // Setup: create a service for the endpoints to live in.
    ServicesCreate.createService(PROJECT_ID, LOCATION_ID, NAMESPACE_ID, SERVICE_ID);
  }

  @After
  public void tearDown() throws Exception {
    System.setOut(null);
    bout.reset();

    // Deletes all resources created during these tests.
    try (RegistrationServiceClient client = RegistrationServiceClient.create()) {
      // List the namespaces.
      String locationPath = LocationName.format(PROJECT_ID, LOCATION_ID);
      ListNamespacesPagedResponse response = client.listNamespaces(locationPath);

      // Delete each namespace.
      for (Namespace namespace : response.iterateAll()) {
        client.deleteNamespace(namespace.getName());
      }
    }
  }

  @Test
  public void testCreateEndpoint() throws Exception {
    EndpointsCreate.createEndpoint(PROJECT_ID, LOCATION_ID, NAMESPACE_ID, SERVICE_ID, ENDPOINT_ID);
    String endpointName =
        EndpointName.format(PROJECT_ID, LOCATION_ID, NAMESPACE_ID, SERVICE_ID, ENDPOINT_ID);
    String output = bout.toString();
    assertThat(
        output, CoreMatchers.containsString(String.format("Created Endpoint: %s", endpointName)));
  }

  @Test
  public void testDeleteService() throws Exception {
    // Setup: create an endpoint.
    EndpointsCreate.createEndpoint(PROJECT_ID, LOCATION_ID, NAMESPACE_ID, SERVICE_ID, ENDPOINT_ID);
    String endpointName =
        EndpointName.format(PROJECT_ID, LOCATION_ID, NAMESPACE_ID, SERVICE_ID, ENDPOINT_ID);

    // Delete the endpoint with the specified ID.
    EndpointsDelete.deleteEndpoint(PROJECT_ID, LOCATION_ID, NAMESPACE_ID, SERVICE_ID, ENDPOINT_ID);
    String output = bout.toString();
    assertThat(
        output, CoreMatchers.containsString(String.format("Deleted Endpoint: %s", endpointName)));
  }
}
