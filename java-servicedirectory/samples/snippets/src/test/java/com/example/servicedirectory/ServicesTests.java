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
import com.google.cloud.servicedirectory.v1beta1.ServiceName;
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
public class ServicesTests {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String LOCATION_ID = "us-central1";
  private static final String NAMESPACE_ID = "namespace-" + UUID.randomUUID().toString();
  private static final String SERVICE_ID = "service-" + UUID.randomUUID().toString();

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

    // Setup: create a namespace for the services to live in.
    NamespacesCreate.createNamespace(PROJECT_ID, LOCATION_ID, NAMESPACE_ID);
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
  public void testCreateService() throws Exception {
    ServicesCreate.createService(PROJECT_ID, LOCATION_ID, NAMESPACE_ID, SERVICE_ID);
    String serviceName = ServiceName.format(PROJECT_ID, LOCATION_ID, NAMESPACE_ID, SERVICE_ID);
    String output = bout.toString();
    assertThat(
        output, CoreMatchers.containsString(String.format("Created Service: %s", serviceName)));
  }

  @Test
  public void testResolveService() throws Exception {
    // Setup: create a service.
    ServicesCreate.createService(PROJECT_ID, LOCATION_ID, NAMESPACE_ID, SERVICE_ID);
    String serviceName = ServiceName.format(PROJECT_ID, LOCATION_ID, NAMESPACE_ID, SERVICE_ID);
    // Setup: Create an endpoint in the service.
    EndpointsCreate.createEndpoint(
        PROJECT_ID, LOCATION_ID, NAMESPACE_ID, SERVICE_ID, "default-endpoint");
    String endpointName =
        EndpointName.format(PROJECT_ID, LOCATION_ID, NAMESPACE_ID, SERVICE_ID, "default-endpoint");

    // Resolve the service with the specified ID.
    ServicesResolve.resolveService(PROJECT_ID, LOCATION_ID, NAMESPACE_ID, SERVICE_ID);
    String output = bout.toString();
    assertThat(
        output, CoreMatchers.containsString(String.format("Resolved Service: %s", serviceName)));
    assertThat(
        output, CoreMatchers.containsString(String.format("Endpoints found:\n%s", endpointName)));
  }

  @Test
  public void testDeleteService() throws Exception {
    // Setup: create a service.
    ServicesCreate.createService(PROJECT_ID, LOCATION_ID, NAMESPACE_ID, SERVICE_ID);
    String serviceName = ServiceName.format(PROJECT_ID, LOCATION_ID, NAMESPACE_ID, SERVICE_ID);

    // Delete the service with the specified ID.
    ServicesDelete.deleteService(PROJECT_ID, LOCATION_ID, NAMESPACE_ID, SERVICE_ID);
    String output = bout.toString();
    assertThat(
        output, CoreMatchers.containsString(String.format("Deleted Service: %s", serviceName)));
  }
}
