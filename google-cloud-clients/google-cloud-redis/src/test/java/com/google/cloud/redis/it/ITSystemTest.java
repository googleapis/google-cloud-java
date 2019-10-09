/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.redis.it;

import static org.junit.Assert.assertEquals;

import com.google.cloud.ServiceOptions;
import com.google.cloud.redis.v1beta1.CloudRedisClient;
import com.google.cloud.redis.v1beta1.Instance;
import com.google.cloud.redis.v1beta1.InstanceName;
import com.google.cloud.redis.v1beta1.LocationName;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITSystemTest {

  private static CloudRedisClient client;
  private static String projectId;

  private static final Logger log = Logger.getLogger(ITSystemTest.class.getName());
  private static final Instance.Tier TIER = Instance.Tier.BASIC;
  private static final String INSTANCE_NAME_PREFIX = "test-instance";
  private static final String INSTANCE =
      INSTANCE_NAME_PREFIX + "-" + UUID.randomUUID().toString().substring(0, 8);
  private static final String LOCATION = "us-central1";
  private static final int MEMORY_SIZE_GB = 1;
  private static final String AUTHORIZED_NETWORK = System.getProperty("redis.network", "default");

  @BeforeClass
  public static void beforeClass() throws Exception {
    client = CloudRedisClient.create();
    projectId = ServiceOptions.getDefaultProjectId();

    /** Creates a Redis instance based on the specified tier and memory size. */
    LocationName parent = LocationName.of(projectId, LOCATION);
    String authorizedNetwork = "projects/" + projectId + "/global/networks/" + AUTHORIZED_NETWORK;
    Instance instance =
        Instance.newBuilder()
            .setTier(TIER)
            .setMemorySizeGb(MEMORY_SIZE_GB)
            .setAuthorizedNetwork(authorizedNetwork)
            .build();
    client.createInstanceAsync(parent, INSTANCE, instance).get();
    log.info("redis instance created successfully.");
  }

  @AfterClass
  public static void afterClass() {

    /** Deletes a specific Redis instance. Instance stops serving and data is deleted. */
    InstanceName name = InstanceName.of(projectId, LOCATION, INSTANCE);
    client.deleteInstanceAsync(name);
    log.info("redis instance deleted successfully.");
    client.close();
  }

  @Test
  public void testGetInstance() {
    InstanceName name = InstanceName.of(projectId, LOCATION, INSTANCE);
    Instance response = client.getInstance(name);
    assertEquals(TIER, response.getTier());
    assertEquals(MEMORY_SIZE_GB, response.getMemorySizeGb());
  }

  @Test
  public void testListInstance() {
    LocationName parent = LocationName.of(projectId, LOCATION);
    CloudRedisClient.ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);
    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    int instance = 0, count = 0;
    while (instance < resources.size()) {
      count++;
      instance++;
    }
    assertEquals(count, resources.size());
  }
}
