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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class ITAddressesTest extends BaseTest {

  private static List<Address> addresses;
  private static AddressesClient addressesClient;
  private static String name;

  @BeforeClass
  public static void setUp() throws IOException {
    addresses = new ArrayList<>();
    AddressesSettings addressesSettings = AddressesSettings.newBuilder().build();
    addressesClient = AddressesClient.create(addressesSettings);
    Util.cleanUpComputeAddresses(addressesClient, DEFAULT_PROJECT, DEFAULT_REGION, COMPUTE_PREFIX);
  }

  @Before
  public void setUpMethod() {
    name = generateRandomName("address");
  }

  @AfterClass
  public static void tearDown() throws ExecutionException, InterruptedException {
    for (Address address : addresses) {
      addressesClient.deleteAsync(DEFAULT_PROJECT, DEFAULT_REGION, address.getName()).get();
    }
    addressesClient.close();
  }

  @Test
  public void testCRD() {
    insertAddress();
    Address address = addressesClient.get(DEFAULT_PROJECT, DEFAULT_REGION, name);
    Assert.assertEquals(name, address.getName());
    Assert.assertEquals("test", address.getDescription());
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

  @Ignore("Non ascii symbols are not converted correctly, b/188905787")
  @Test
  public void testNonAscii() {
    insertAddress("тест");
    Address address = addressesClient.get(DEFAULT_PROJECT, DEFAULT_REGION, name);
    Assert.assertEquals(name, address.getName());
    Assert.assertEquals("тест", address.getDescription());
  }

  private void insertAddress() {
    insertAddress("test");
  }

  private void insertAddress(String description) {
    Address address = Address.newBuilder().setName(name).setDescription(description).build();
    try {
      addressesClient
          .insertAsync(DEFAULT_PROJECT, DEFAULT_REGION, address)
          .get(60, TimeUnit.SECONDS);
    } catch (InterruptedException | ExecutionException | TimeoutException e) {
      fail("Insert operation failed: " + e.getMessage());
    }
    addresses.add(address);
  }
}
