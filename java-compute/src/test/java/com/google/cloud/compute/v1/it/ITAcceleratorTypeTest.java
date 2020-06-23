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

import com.google.cloud.compute.v1.AcceleratorType;
import com.google.cloud.compute.v1.AcceleratorTypeClient;
import com.google.cloud.compute.v1.AcceleratorTypeSettings;
import com.google.cloud.compute.v1.AcceleratorTypesScopedList;
import com.google.cloud.compute.v1.ProjectZoneName;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITAcceleratorTypeTest extends BaseTest {

  private static AcceleratorTypeClient acceleratorTypeClient;

  private static final ProjectZoneName PROJECT_ZONE_NAME =
      ProjectZoneName.of(DEFAULT_PROJECT, ZONE);

  @BeforeClass
  public static void setUp() throws IOException {
    AcceleratorTypeSettings acceleratorTypeSettings =
        AcceleratorTypeSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    acceleratorTypeClient = AcceleratorTypeClient.create(acceleratorTypeSettings);
  }

  public static void tearDown() {
    acceleratorTypeClient.close();
  }

  @Test
  public void listAcceleratorTypesTest() {
    List<AcceleratorType> acceleratorTypes =
        Lists.newArrayList(
            acceleratorTypeClient.listAcceleratorTypes(PROJECT_ZONE_NAME).iterateAll());
    assertThat(acceleratorTypes).isNotNull();
    assertThat(acceleratorTypes.size()).isGreaterThan(0);
    assertThat(acceleratorTypes.contains(null)).isFalse();
  }

  @Test
  public void aggregatedListAcceleratorTypesTest() {
    List<AcceleratorTypesScopedList> typesScopedLists =
        Lists.newArrayList(
            acceleratorTypeClient.aggregatedListAcceleratorTypes(true, PROJECT_NAME).iterateAll());
    assertThat(typesScopedLists).isNotNull();
    assertThat(typesScopedLists.size()).isGreaterThan(0);
    assertThat(typesScopedLists.contains(null)).isFalse();
  }
}
