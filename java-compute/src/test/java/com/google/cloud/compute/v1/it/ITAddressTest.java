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
package com.google.cloud.compute.v1.it;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.compute.v1.Address;
import com.google.cloud.compute.v1.AddressClient;
import com.google.cloud.compute.v1.AddressSettings;
import com.google.cloud.compute.v1.AddressesScopedList;
import com.google.cloud.compute.v1.GlobalAddressClient;
import com.google.cloud.compute.v1.GlobalAddressSettings;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectRegionAddressName;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITAddressTest extends BaseTest {

  private static AddressClient addressClient;
  private static GlobalAddressClient globalAddressClient;

  private static final String ADDRESS_NAME = TestHelper.getTestUniqueName("address");
  private static final String NETWORK_TIER = "PREMIUM";
  private static final Address ADDRESS =
      Address.newBuilder()
          .setName(ADDRESS_NAME)
          .setNetworkTier(NETWORK_TIER)
          .setRegion(REGION_LINK)
          .build();
  private static final String ADDRESS_TYPE = "EXTERNAL";
  private static final String ADDRESS_OPERATION_STATUS = "RESERVED";
  private static final String ADDRESS_SELF_LINK =
      String.format("%s/addresses/%s", REGION_LINK, ADDRESS_NAME);
  private static final String GLOBAL_ADDRESS_LINK =
      String.format("%s/global/addresses/%s", PROJECT_LINK, ADDRESS_NAME);

  private static ListMultimap<String, String> resourcesToCleanUp = ArrayListMultimap.create();

  @BeforeClass
  public static void setUp() throws IOException {
    AddressSettings addressSettings =
        AddressSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    addressClient = AddressClient.create(addressSettings);

    Operation completedOperation =
        waitForOperation(addressClient.insertAddress(PROJECT_REGION_NAME, ADDRESS));
    resourcesToCleanUp.put("address", completedOperation.getTargetLink());

    GlobalAddressSettings globalAddressSettings =
        GlobalAddressSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    globalAddressClient = GlobalAddressClient.create(globalAddressSettings);
    Address address =
        Address.newBuilder()
            .setName(ADDRESS_NAME)
            .setAddressType(ADDRESS_TYPE)
            .setRegion(PROJECT_REGION_NAME.toString())
            .build();
    completedOperation =
        waitForOperation(globalAddressClient.insertGlobalAddress(PROJECT_NAME, address));
    resourcesToCleanUp.put("global-address", completedOperation.getTargetLink());
  }

  @AfterClass
  public static void tearDown() {
    for (String address : resourcesToCleanUp.get("address")) {
      waitForOperation(addressClient.deleteAddress(address));
    }
    for (String address : resourcesToCleanUp.get("global-address")) {
      waitForOperation(globalAddressClient.deleteGlobalAddress(address));
    }
    globalAddressClient.close();
    addressClient.close();
  }

  @Test
  public void getAddressesTest() {
    ProjectRegionAddressName projectRegionAddressName =
        ProjectRegionAddressName.of(ADDRESS_NAME, DEFAULT_PROJECT, REGION);
    Address address = addressClient.getAddress(projectRegionAddressName);
    assertThat(address).isNotNull();
    assertThat(address.getAddressType()).isEqualTo(ADDRESS_TYPE);
    assertThat(address.getName()).isEqualTo(ADDRESS_NAME);
    assertThat(address.getNetworkTier()).isEqualTo(NETWORK_TIER);
    assertThat(address.getRegion()).isEqualTo(REGION_LINK);
    assertThat(address.getStatus()).isEqualTo(ADDRESS_OPERATION_STATUS);
    assertThat(address.getSelfLink()).isEqualTo(ADDRESS_SELF_LINK);
  }

  @Test
  public void listAddressesTest() {
    List<Address> addresses =
        Lists.newArrayList(addressClient.listAddresses(PROJECT_REGION_NAME).iterateAll());
    assertThat(addresses.size()).isGreaterThan(0);
    for (Address address : addresses) {
      if (ADDRESS_NAME.equals(address.getName())) {
        assertThat(address.getAddressType()).isEqualTo(ADDRESS_TYPE);
        assertThat(address.getName()).isEqualTo(ADDRESS_NAME);
        assertThat(address.getNetworkTier()).isEqualTo(NETWORK_TIER);
        assertThat(address.getRegion()).isEqualTo(REGION_LINK);
        assertThat(address.getStatus()).isEqualTo(ADDRESS_OPERATION_STATUS);
        assertThat(address.getSelfLink()).isEqualTo(ADDRESS_SELF_LINK);
      }
    }
  }

  @Test
  public void aggregatedListAddressesTest() {
    List<AddressesScopedList> addressesScopedLists =
        Lists.newArrayList(addressClient.aggregatedListAddresses(true, PROJECT_NAME).iterateAll());
    for (AddressesScopedList addressesScopedList : addressesScopedLists) {
      List<Address> addresses = addressesScopedList.getAddressesList();
      if (addresses != null) {
        for (Address address : addresses) {
          if (ADDRESS_NAME.equals(address.getName())) {
            assertThat(address.getAddressType()).isEqualTo(ADDRESS_TYPE);
            assertThat(address.getName()).isEqualTo(ADDRESS_NAME);
            assertThat(address.getNetworkTier()).isEqualTo(NETWORK_TIER);
            assertThat(address.getStatus()).isEqualTo(ADDRESS_OPERATION_STATUS);
          }
        }
      }
    }
  }

  @Test
  public void listGlobalAddressesTest() {
    List<Address> addresses =
        Lists.newArrayList(globalAddressClient.listGlobalAddresses(PROJECT_NAME).iterateAll());
    for (Address address : addresses) {
      if (ADDRESS_NAME.equals(address.getName())) {
        assertThat(address.getAddressType()).isEqualTo(ADDRESS_TYPE);
        assertThat(address.getName()).isEqualTo(ADDRESS_NAME);
        assertThat(address.getNetworkTier()).isEqualTo(NETWORK_TIER);
        assertThat(address.getStatus()).isEqualTo(ADDRESS_OPERATION_STATUS);
        assertThat(address.getSelfLink()).isEqualTo(GLOBAL_ADDRESS_LINK);
      }
    }
  }
}
