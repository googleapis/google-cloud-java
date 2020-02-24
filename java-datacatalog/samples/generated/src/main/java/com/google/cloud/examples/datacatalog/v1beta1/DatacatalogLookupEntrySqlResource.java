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
// DO NOT EDIT! This is a generated sample ("Request",  "datacatalog_lookup_entry_sql_resource")
// sample-metadata:
//   title:
//   description: Lookup Entry using SQL resource
//   usage: gradle run -PmainClass=com.google.cloud.examples.datacatalog.v1beta1.DatacatalogLookupEntrySqlResource [--args='[--sql_name "[SQL Resource Name]"]']

package com.google.cloud.examples.datacatalog.v1beta1;

import com.google.cloud.datacatalog.v1beta1.DataCatalogClient;
import com.google.cloud.datacatalog.v1beta1.Entry;
import com.google.cloud.datacatalog.v1beta1.LookupEntryRequest;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class DatacatalogLookupEntrySqlResource {
  // [START datacatalog_lookup_entry_sql_resource]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.cloud.datacatalog.v1beta1.DataCatalogClient;
   * import com.google.cloud.datacatalog.v1beta1.Entry;
   * import com.google.cloud.datacatalog.v1beta1.LookupEntryRequest;
   */

  public static void sampleLookupEntry() {
    // TODO(developer): Replace these variables before running the sample.
    String sqlName = "[SQL Resource Name]";
    sampleLookupEntry(sqlName);
  }

  /**
   * Lookup Entry using SQL resource
   *
   * @param sqlName The SQL name of the Google Cloud Platform resource the Data Catalog entry
   *     represents. Examples:
   *     bigquery.table.`bigquery-public-data`.new_york_taxi_trips.taxi_zone_geom
   *     pubsub.topic.`pubsub-public-data`.`taxirides-realtime`
   */
  public static void sampleLookupEntry(String sqlName) {
    try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
      LookupEntryRequest request = LookupEntryRequest.newBuilder().setSqlResource(sqlName).build();
      Entry response = dataCatalogClient.lookupEntry(request);
      Entry entry = response;
      System.out.printf("Entry name: %s\n", entry.getName());
      System.out.printf("Entry type: %s\n", entry.getType());
      System.out.printf("Linked resource: %s\n", entry.getLinkedResource());
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END datacatalog_lookup_entry_sql_resource]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(Option.builder("").required(false).hasArg(true).longOpt("sql_name").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String sqlName = cl.getOptionValue("sql_name", "[SQL Resource Name]");

    sampleLookupEntry(sqlName);
  }
}
