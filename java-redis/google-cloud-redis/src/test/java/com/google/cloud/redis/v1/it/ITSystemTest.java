/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.redis.v1.it;

import static org.junit.Assert.assertEquals;

import com.google.cloud.ServiceOptions;
import com.google.cloud.Timestamp;
import com.google.cloud.redis.v1.CloudRedisClient;
import com.google.cloud.redis.v1.CloudRedisSettings;
import com.google.cloud.redis.v1.Instance;
import com.google.cloud.redis.v1.InstanceName;
import com.google.cloud.redis.v1.LocationName;
import com.google.cloud.redis.v1.UpdateInstanceRequest;
import com.google.common.collect.Lists;
import com.google.protobuf.FieldMask;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.threeten.bp.Duration;

public class ITSystemTest {

  private static CloudRedisClient client;

  private static final Logger LOG = Logger.getLogger(ITSystemTest.class.getName());
  private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private static final String NETWORK = System.getProperty("redis.network", "redis-vpc");
  private static final String INSTANCE =
      "test-instance-" + UUID.randomUUID().toString().substring(0, 8);
  private static final String LOCATION = "us-central1";
  private static final String AUTHORIZED_NETWORK =
      "projects/" + PROJECT_ID + "/global/networks/" + NETWORK;
  private static final Instance.Tier TIER = Instance.Tier.BASIC;
  private static final LocationName PARENT = LocationName.of(PROJECT_ID, LOCATION);
  private static final InstanceName INSTANCE_NAME = InstanceName.of(PROJECT_ID, LOCATION, INSTANCE);

  @BeforeClass
  public static void setUp() throws Exception {
    CloudRedisSettings.Builder cloudRedisSettingsBuilder = CloudRedisSettings.newBuilder();
    cloudRedisSettingsBuilder
        .getInstanceSettings()
        .setRetrySettings(
            cloudRedisSettingsBuilder
                .getInstanceSettings()
                .getRetrySettings()
                .toBuilder()
                .setTotalTimeout(Duration.ofSeconds(900))
                .build());
    CloudRedisSettings cloudRedisSettings = cloudRedisSettingsBuilder.build();
    client = CloudRedisClient.create(cloudRedisSettings);
    /* Clean up old instances that were not deleted. */
    cleanUpOldInstances();
    /* Creates a Redis instance based on the specified tier and memory size. */
    Instance instance =
        Instance.newBuilder()
            .setTier(TIER)
            .setMemorySizeGb(1)
            .setAuthorizedNetwork(AUTHORIZED_NETWORK)
            .build();
    client.createInstanceAsync(PARENT, INSTANCE, instance).get();
    LOG.info("redis instance created successfully.");
  }

  @AfterClass
  public static void tearDown() {
    /* Deletes a specific Redis instance. Instance stops serving and data is deleted. */
    client.deleteInstanceAsync(INSTANCE_NAME);
    LOG.info("redis instance deleted successfully.");
    client.close();
  }

  public static void cleanUpOldInstances() throws ParseException {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, -1);
    Timestamp cutoff = Timestamp.of(calendar.getTime());

    List<Instance> instances = Lists.newArrayList(client.listInstances(PARENT).iterateAll());
    for (Instance old_instance : instances) {
      Timestamp createdAt =
          Timestamp.ofTimeSecondsAndNanos(
              old_instance.getCreateTime().getSeconds(), old_instance.getCreateTime().getNanos());
      if (createdAt.compareTo(cutoff) < 0) {
        client.deleteInstanceAsync(old_instance.getName());
        LOG.info("redis instance " + old_instance.getName() + " deleted successfully.");
      }
    }
  }

  @Test
  public void testGetInstance() {
    Instance response = client.getInstance(INSTANCE_NAME);
    assertEquals(TIER, response.getTier());
    assertEquals(INSTANCE_NAME.toString(), response.getName());
  }

  @Test
  public void testListInstances() {
    List<Instance> instances = Lists.newArrayList(client.listInstances(PARENT).iterateAll());
    for (Instance instance : instances) {
      if (INSTANCE_NAME.toString().equals(instance.getName())) {
        assertEquals(TIER, instance.getTier());
        assertEquals(INSTANCE_NAME.toString(), instance.getName());
      }
    }
  }

  @Test
  public void testUpdateInstance() throws ExecutionException, InterruptedException {
    int memorySizeGb = 4;
    FieldMask updateMask =
        FieldMask.newBuilder().addAllPaths(Arrays.asList("memory_size_gb")).build();
    Instance instance =
        Instance.newBuilder()
            .setName(INSTANCE_NAME.toString())
            .setMemorySizeGb(memorySizeGb)
            .build();
    UpdateInstanceRequest updateInstanceRequest =
        UpdateInstanceRequest.newBuilder().setInstance(instance).setUpdateMask(updateMask).build();
    Instance actualInstance = client.updateInstanceAsync(updateInstanceRequest).get();
    assertEquals(memorySizeGb, actualInstance.getMemorySizeGb());
  }
}
