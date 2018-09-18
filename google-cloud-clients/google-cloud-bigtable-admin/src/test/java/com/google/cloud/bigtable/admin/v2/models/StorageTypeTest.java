/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.admin.v2.models;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.Lists;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StorageTypeTest {
  @Test
  public void testUpToDate() {
    List<com.google.bigtable.admin.v2.StorageType> validProtoValues =
        Lists.newArrayList(com.google.bigtable.admin.v2.StorageType.values());

    // TYPE_UNSPECIFIED is not surfaced
    validProtoValues.remove(com.google.bigtable.admin.v2.StorageType.STORAGE_TYPE_UNSPECIFIED);

    Exception actualError = null;
    try {
      StorageType.fromProto(com.google.bigtable.admin.v2.StorageType.STORAGE_TYPE_UNSPECIFIED);
    } catch (Exception e) {
      actualError = e;
    }
    assertThat(actualError).isInstanceOf(IllegalArgumentException.class);


    List<StorageType> validModelValues = Lists.newArrayList(StorageType.values());

    List<StorageType> actualModelValues = Lists.newArrayList();

    for (com.google.bigtable.admin.v2.StorageType protoValue : validProtoValues) {
      StorageType modelValue = StorageType.fromProto(protoValue);
      actualModelValues.add(modelValue);
    }

    assertThat(actualModelValues).containsExactlyElementsIn(validModelValues);
  }
}