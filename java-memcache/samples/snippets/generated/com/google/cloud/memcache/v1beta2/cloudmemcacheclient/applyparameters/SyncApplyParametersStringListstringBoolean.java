/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.memcache.v1beta2.samples;

// [START memcache_v1beta2_generated_cloudmemcacheclient_applyparameters_stringliststringboolean_sync]
import com.google.cloud.memcache.v1beta2.CloudMemcacheClient;
import com.google.cloud.memcache.v1beta2.Instance;
import com.google.cloud.memcache.v1beta2.InstanceName;
import java.util.ArrayList;
import java.util.List;

public class SyncApplyParametersStringListstringBoolean {

  public static void main(String[] args) throws Exception {
    syncApplyParametersStringListstringBoolean();
  }

  public static void syncApplyParametersStringListstringBoolean() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (CloudMemcacheClient cloudMemcacheClient = CloudMemcacheClient.create()) {
      String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
      List<String> nodeIds = new ArrayList<>();
      boolean applyAll = true;
      Instance response = cloudMemcacheClient.applyParametersAsync(name, nodeIds, applyAll).get();
    }
  }
}
// [END memcache_v1beta2_generated_cloudmemcacheclient_applyparameters_stringliststringboolean_sync]
