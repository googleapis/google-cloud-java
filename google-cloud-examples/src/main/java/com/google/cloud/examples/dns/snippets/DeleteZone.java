/*
 * Copyright 2016 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in README's and javadoc. Any change to this file should be reflected in
 * the project's README's and package-info.java.
 */

package com.google.cloud.examples.dns.snippets;

import com.google.cloud.dns.ChangeRequest;
import com.google.cloud.dns.ChangeRequestInfo;
import com.google.cloud.dns.Dns;
import com.google.cloud.dns.DnsOptions;
import com.google.cloud.dns.RecordSet;

/**
 * A snippet for Google Cloud DNS showing how to delete a zone. It also shows how to list and delete
 * DNS records.
 */
public class DeleteZone {

  public static void main(String... args) {
    // Create a service object.
    // The project ID and credentials will be inferred from the environment.
    Dns dns = DnsOptions.getDefaultInstance().getService();

    // Change this to a zone name that exists within your project and that you want to delete.
    String zoneName = "my-unique-zone";

    // Get iterable for the existing record sets which have to be deleted before deleting the zone
    Iterable<RecordSet> recordIterable = dns.listRecordSets(zoneName).iterateAll();

    // Make a change for deleting the records
    ChangeRequestInfo.Builder changeBuilder = ChangeRequestInfo.newBuilder();
    for (RecordSet current : recordIterable) {
      // SOA and NS records cannot be deleted
      if (!RecordSet.Type.SOA.equals(current.getType())
          && !RecordSet.Type.NS.equals(current.getType())) {
        changeBuilder.delete(current);
      }
    }

    // Build and apply the change request to our zone if it contains records to delete
    ChangeRequestInfo changeRequest = changeBuilder.build();
    if (!changeRequest.getDeletions().isEmpty()) {
      ChangeRequest pendingRequest = dns.applyChangeRequest(zoneName, changeRequest);

      // Wait for the change request to complete
      while (!pendingRequest.isDone()) {
        System.out.println("Waiting for change to complete. Going to sleep for 500ms...");
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          System.err.println(
              "The thread was interrupted while waiting for change request to be " + "processed.");
        }
      }
    }

    // Delete the zone
    boolean result = dns.delete(zoneName);
    if (result) {
      System.out.println("Zone was deleted.");
    } else {
      System.out.println("Zone was not deleted because it does not exist.");
    }
  }
}
