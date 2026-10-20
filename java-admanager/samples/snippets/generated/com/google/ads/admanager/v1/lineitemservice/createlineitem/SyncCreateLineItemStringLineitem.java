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

package com.google.ads.admanager.v1.samples;

// [START admanager_v1_generated_LineItemService_CreateLineItem_StringLineitem_sync]
import com.google.ads.admanager.v1.LineItem;
import com.google.ads.admanager.v1.LineItemServiceClient;
import com.google.ads.admanager.v1.NetworkName;

public class SyncCreateLineItemStringLineitem {

  public static void main(String[] args) throws Exception {
    syncCreateLineItemStringLineitem();
  }

  public static void syncCreateLineItemStringLineitem() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (LineItemServiceClient lineItemServiceClient = LineItemServiceClient.create()) {
      String parent = NetworkName.of("[NETWORK_CODE]").toString();
      LineItem lineItem = LineItem.newBuilder().build();
      LineItem response = lineItemServiceClient.createLineItem(parent, lineItem);
    }
  }
}
// [END admanager_v1_generated_LineItemService_CreateLineItem_StringLineitem_sync]
