/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.biglake.v1;

import com.google.cloud.biglake.hive.v1beta.CreateHiveCatalogRequest;
import com.google.cloud.biglake.hive.v1beta.HiveCatalog;
import com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceClient;
import com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceSettings;
import com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsRequest;
import com.google.cloud.biglake.v1.CreateIcebergCatalogRequest;
import com.google.cloud.biglake.v1.IcebergCatalog;
import com.google.cloud.biglake.v1.IcebergCatalogServiceClient;
import com.google.cloud.biglake.v1.IcebergCatalogServiceSettings;
import com.google.cloud.biglake.v1.ListIcebergCatalogsRequest;
import java.io.IOException;

public class BiglakeDemo {
  public static void main(String[] args) {
    String projectId = System.getenv("GOOGLE_CLOUD_PROJECT");
    if (projectId == null || projectId.isEmpty()) {
      System.err.println("Error: GOOGLE_CLOUD_PROJECT environment variable is not defined.");
      System.exit(1);
    }

    System.out.println("Starting BigLake Client library demo execution...");
    System.out.println("Target Project ID: " + projectId);

    try {
      runHiveMetastoreDemo(projectId);
      runIcebergCatalogDemo(projectId);
    } catch (Exception e) {
      System.err.println("Demo Execution encountered error:");
      e.printStackTrace();
      System.exit(1);
    }
  }

  private static void runHiveMetastoreDemo(String projectId) throws IOException {
    System.out.println("\nExecuting Hive Metastore affected requests test...");
    HiveMetastoreServiceSettings settings =
        HiveMetastoreServiceSettings.newHttpJsonBuilder().build();

    try (HiveMetastoreServiceClient client = HiveMetastoreServiceClient.create(settings)) {
      String parent = String.format("projects/%s", projectId);
      
      // Call ListHiveCatalogsRequest verifying corrected query parameters
      System.out.println("Requesting ListHiveCatalogs...");
      ListHiveCatalogsRequest listRequest =
          ListHiveCatalogsRequest.newBuilder()
              .setParent(parent)
              .setPageSize(10)
              .build();
      
      client.listHiveCatalogs(listRequest).iterateAll().forEach(
          catalog -> System.out.println(" -> Found Catalog: " + catalog.getName())
      );

      // Call CreateHiveCatalogRequest verifying query parameter primary_location serialization
      System.out.println("Requesting CreateHiveCatalog (dry-run / testing)...");
      CreateHiveCatalogRequest createRequest =
          CreateHiveCatalogRequest.newBuilder()
              .setParent(parent)
              .setHiveCatalogId("test-demo-catalog-" + System.currentTimeMillis())
              .setPrimaryLocation("us-central1")
              .setHiveCatalog(HiveCatalog.newBuilder().build())
              .build();

      try {
        HiveCatalog response = client.createHiveCatalog(createRequest);
        System.out.println(" -> Successfully Created Catalog: " + response.getName());
      } catch (Exception e) {
        System.out.println(" -> Create catalog call failed: " + e.getMessage());
      }
    }
  }

  private static void runIcebergCatalogDemo(String projectId) throws IOException {
    System.out.println("\nExecuting Iceberg Catalog affected requests test...");
    IcebergCatalogServiceSettings settings =
        IcebergCatalogServiceSettings.newHttpJsonBuilder().build();

    try (IcebergCatalogServiceClient client = IcebergCatalogServiceClient.create(settings)) {
      String parent = String.format("projects/%s", projectId);

      // Call ListIcebergCatalogsRequest verifying corrected query parameters
      System.out.println("Requesting ListIcebergCatalogs...");
      ListIcebergCatalogsRequest listRequest =
          ListIcebergCatalogsRequest.newBuilder()
              .setParent(parent)
              .setPageSize(10)
              .build();

      client.listIcebergCatalogs(listRequest).iterateAll().forEach(
          catalog -> System.out.println(" -> Found Iceberg Catalog: " + catalog.getName())
      );

      // Call CreateIcebergCatalogRequest verifying corrected parameter
      System.out.println("Requesting CreateIcebergCatalog...");
      CreateIcebergCatalogRequest createRequest =
          CreateIcebergCatalogRequest.newBuilder()
              .setParent(parent)
              .setIcebergCatalogId("test-demo-iceberg-" + System.currentTimeMillis())
              .setIcebergCatalog(IcebergCatalog.newBuilder().build())
              .build();

      try {
        IcebergCatalog response = client.createIcebergCatalog(createRequest);
        System.out.println(" -> Successfully Created Iceberg Catalog: " + response.getName());
      } catch (Exception e) {
        System.out.println(" -> Create iceberg call failed: " + e.getMessage());
      }
    }
  }
}
