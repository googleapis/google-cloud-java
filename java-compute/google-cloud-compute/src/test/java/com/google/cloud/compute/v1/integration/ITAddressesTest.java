/*
 * Copyright 2021 Google LLC
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
package com.google.cloud.compute.v1.integration;

import static org.junit.Assert.fail;

import com.google.cloud.compute.v1.Address;
import com.google.cloud.compute.v1.AddressesClient;
import com.google.cloud.compute.v1.AddressesScopedList;
import com.google.cloud.compute.v1.AddressesSettings;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.RegionOperationsClient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITAddressesTest extends BaseTest {

  private static List<Address> addresses;
  private static AddressesClient addressesClient;
  private static RegionOperationsClient regionOperationsClient;
  private static String name;

  @BeforeClass
  public static void setUp() throws IOException {
    addresses = new ArrayList<>();
    AddressesSettings addressesSettings = AddressesSettings.newBuilder().build();
    addressesClient = AddressesClient.create(addressesSettings);
    regionOperationsClient = RegionOperationsClient.create();
  }

  @Before
  public void setUpMethod() {
    name = generateRandomName("address");
  }

  @AfterClass
  public static void tearDown() {
    for (Address address : addresses) {
      addressesClient.delete(DEFAULT_PROJECT, DEFAULT_REGION, address.getName());
    }
    addressesClient.close();
  }

  @Test
  public void testCRD() {
    insertAddress();
    Address address = addressesClient.get(DEFAULT_PROJECT, DEFAULT_REGION, name);
    Assert.assertEquals(name, address.getName());
  }

  @Test
  public void testList() {
    insertAddress();
    AddressesClient.ListPagedResponse response =
        addressesClient.list(DEFAULT_PROJECT, DEFAULT_REGION);
    boolean presented = false;
    for (Address element : response.iterateAll()) {
      if (element.getName().equals(name)) {
        presented = true;
      }
    }
    System.out.println(presented);
    Assert.assertTrue(presented);
  }

  public void insertAddress() {
    Address address = Address.newBuilder().setName(name).build();
    Operation operation = addressesClient.insert(DEFAULT_PROJECT, DEFAULT_REGION, address);
    addresses.add(address);
    boolean success = false;
    long startTime = System.currentTimeMillis();
    while ((System.currentTimeMillis() - startTime) < 15000) {
      Operation op =
          regionOperationsClient.get(DEFAULT_PROJECT, DEFAULT_REGION, operation.getName());
      if (op.getStatus() == Status.DONE) {
        success = true;
        break;
      }
    }
    if (!success) {
      fail("Insert did not finish with success.");
    }
  }

  @Test
  public void testAggregatedList() {
    insertAddress();
    AddressesClient.AggregatedListPagedResponse response =
        addressesClient.aggregatedList(DEFAULT_PROJECT);
    boolean presented = false;
    for (Map.Entry<String, AddressesScopedList> entry : response.iterateAll()) {
      if (entry.getKey().equals("regions/" + DEFAULT_REGION)) {
        for (Address elem : entry.getValue().getAddressesList()) {
          if (elem.getName().equals(name)) {
            presented = true;
          }
        }
      }
    }
    Assert.assertTrue(presented);
  }
}
