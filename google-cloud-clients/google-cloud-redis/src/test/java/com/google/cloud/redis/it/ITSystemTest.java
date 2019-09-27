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

import com.google.cloud.ServiceOptions;
import com.google.cloud.redis.v1beta1.CloudRedisClient;
import com.google.cloud.redis.v1beta1.Instance;
import com.google.cloud.redis.v1beta1.InstanceName;
import com.google.cloud.redis.v1beta1.LocationName;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ITSystemTest {

  private CloudRedisClient client;
  private String projectId;

  private static final Instance.Tier TIER = Instance.Tier.BASIC;
  private static final String INSTANCE = "test-instance-basic";
  private static final String LOCATION = "us-central1";
  private static final int MEMORY_SIZE_GB = 1;

  @Before
  public void before() throws IOException {
    client = CloudRedisClient.create();
    projectId = ServiceOptions.getDefaultProjectId();
  }

  @After
  public void tearDown() {
    client.close();
  }

  @Test
  public void createInstanceTest() throws Exception {
    LocationName parent = LocationName.of(projectId, LOCATION);
    Instance instance = Instance.newBuilder().setTier(TIER).setMemorySizeGb(MEMORY_SIZE_GB).build();
    Instance response = client.createInstanceAsync(parent, INSTANCE, instance).get();
    Assert.assertEquals(TIER, response.getTier());
    Assert.assertEquals(MEMORY_SIZE_GB, response.getMemorySizeGb());
  }

  @Test
  public void getInstanceTest() {
    InstanceName name = InstanceName.of(projectId, LOCATION, INSTANCE);
    Instance response = client.getInstance(name);
    Assert.assertEquals(TIER, response.getTier());
    Assert.assertEquals(MEMORY_SIZE_GB, response.getMemorySizeGb());
  }

  @Test
  public void listInstanceTest() {
    LocationName parent = LocationName.of(projectId, LOCATION);
    CloudRedisClient.ListInstancesPagedResponse pagedListResponse = client.listInstances(parent);
    List<Instance> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
  }

  @Test
  public void deleteInstanceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    InstanceName name = InstanceName.of(projectId, LOCATION, INSTANCE);
    Empty actualResponse = client.deleteInstanceAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);
  }
}
