/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.storage.it;

import static org.junit.Assume.assumeTrue;

import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.annotations.SingleBackend;
import com.google.cloud.storage.it.runner.annotations.StorageFixture;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@SingleBackend(Backend.PROD)
public final class ITGrpcDirectPathTest {

  @Inject
  @StorageFixture(Transport.GRPC)
  public Storage storage;

  @Ignore(
      "Bypassed because DirectPath over Interconnect (GCI) requires a specialized hybrid network environment (Interconnect and Traffic Director configured for storage-direct) and cannot be validated in standard CI or local workstations.")
  @Test
  public void clientShouldWork_directPathXdsOverInterconnect() throws Exception {
    assumeTrue(
        "Environment cannot resolve storage-direct.googleapis.com", canResolveDirectPathAddress());
    StorageOptions options =
        StorageOptions.grpc()
            .setCredentials(storage.getOptions().getCredentials())
            .setAttemptDirectPathXdsOverInterconnect(true)
            .setEnableGrpcClientMetrics(false)
            .build();
    try (Storage client = options.getService()) {
      client.list(Storage.BucketListOption.pageSize(1));
    }
  }

  private static boolean canResolveDirectPathAddress() {
    try {
      java.net.InetAddress.getAllByName("storage-direct.googleapis.com");
      return true;
    } catch (java.net.UnknownHostException e) {
      return false;
    }
  }
}
