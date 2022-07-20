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

import com.google.cloud.servicedirectory.v1.LocationName;
import com.google.cloud.servicedirectory.v1.Namespace;
import com.google.cloud.servicedirectory.v1.NamespaceName;
import com.google.cloud.servicedirectory.v1.RegistrationServiceClient;
import com.google.cloud.servicedirectory.v1.RegistrationServiceClient.ListNamespacesPagedResponse;
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
public class NamespacesTests {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String LOCATION_ID = "us-central1";
  private static final String NAMESPACE_ID = "namespace-" + UUID.randomUUID().toString();

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
  public void setUp() {
    bout = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bout));
  }

  @After
  public void tearDown() throws Exception {
    System.setOut(null);
    bout.reset();

    // Deletes any namespaces created during these tests.
    try (RegistrationServiceClient client = RegistrationServiceClient.create()) {
      // List the namespaces.
      String locationPath = LocationName.format(PROJECT_ID, LOCATION_ID);
      ListNamespacesPagedResponse response = client.listNamespaces(locationPath);

      // Delete each namespace.
      for (Namespace ns : response.iterateAll()) {
        client.deleteNamespace(ns.getName());
      }
    }
  }

  @Test
  public void testCreateNamespace() throws Exception {
    NamespacesCreate.createNamespace(PROJECT_ID, LOCATION_ID, NAMESPACE_ID);
    String namespaceName = NamespaceName.format(PROJECT_ID, LOCATION_ID, NAMESPACE_ID);
    String output = bout.toString();
    assertThat(
        output, CoreMatchers.containsString(String.format("Created Namespace: %s", namespaceName)));
  }

  @Test
  public void testDeleteNamespace() throws Exception {
    // Setup: create a namespace.
    NamespacesCreate.createNamespace(PROJECT_ID, LOCATION_ID, NAMESPACE_ID);
    String namespaceName = NamespaceName.format(PROJECT_ID, LOCATION_ID, NAMESPACE_ID);

    // Delete the namespace with the specified ID.
    NamespacesDelete.deleteNamespace(PROJECT_ID, LOCATION_ID, NAMESPACE_ID);
    String output = bout.toString();
    assertThat(
        output, CoreMatchers.containsString(String.format("Deleted Namespace: %s", namespaceName)));
  }
}
