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
// DO NOT EDIT! This is a generated sample ("Request",  "datacatalog_lookup_entry")
// sample-metadata:
//   title:
//   description: Lookup Entry
//   usage: gradle run -PmainClass=com.google.cloud.examples.datacatalog.v1beta1.DatacatalogLookupEntry [--args='[--resource_name "[Full Resource Name]"]']

package com.google.cloud.examples.datacatalog.v1beta1;

import com.google.cloud.datacatalog.v1beta1.DataCatalogClient;
import com.google.cloud.datacatalog.v1beta1.Entry;
import com.google.cloud.datacatalog.v1beta1.LookupEntryRequest;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class DatacatalogLookupEntry {
  // [START datacatalog_lookup_entry]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.datacatalog.v1beta1.DataCatalogClient;
   * import com.google.cloud.datacatalog.v1beta1.Entry;
   * import com.google.cloud.datacatalog.v1beta1.LookupEntryRequest;
   */

  public static void sampleLookupEntry() {
    // TODO(developer): Replace these variables before running the sample.
    String resourceName = "[Full Resource Name]";
    sampleLookupEntry(resourceName);
  }

  /**
   * Lookup Entry
   *
   * @param resourceName The full name of the Google Cloud Platform resource the Data Catalog entry
   *     represents. See: https://cloud.google.com/apis/design/resource_names#full_resource_name
   *     Examples:
   *     //bigquery.googleapis.com/projects/bigquery-public-data/datasets/new_york_taxi_trips/tables/taxi_zone_geom
   *     //pubsub.googleapis.com/projects/pubsub-public-data/topics/taxirides-realtime
   */
  public static void sampleLookupEntry(String resourceName) {
    try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
      LookupEntryRequest request =
          LookupEntryRequest.newBuilder().setLinkedResource(resourceName).build();
      Entry response = dataCatalogClient.lookupEntry(request);
      Entry entry = response;
      System.out.printf("Entry name: %s\n", entry.getName());
      System.out.printf("Entry type: %s\n", entry.getType());
      System.out.printf("Linked resource: %s\n", entry.getLinkedResource());
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END datacatalog_lookup_entry]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("resource_name").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String resourceName = cl.getOptionValue("resource_name", "[Full Resource Name]");

    sampleLookupEntry(resourceName);
  }
}
