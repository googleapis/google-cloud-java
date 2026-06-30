/*
 * Copyright 2022 Google LLC
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

package com.example.storage.bucket;

import static com.example.storage.Env.GOOGLE_CLOUD_PROJECT;
import static com.google.common.truth.Truth.assertThat;

import com.example.storage.TestBase;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.BucketInfo.Autoclass;
import com.google.cloud.storage.StorageClass;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import org.junit.Test;

public class AutoclassTest extends TestBase {

  @Test
  public void testSetGetBucketAutoclass() throws Exception {
    String autoclassBucket = RemoteStorageHelper.generateBucketName();
    storage.create(
        BucketInfo.newBuilder(autoclassBucket)
            .setAutoclass(Autoclass.newBuilder().setEnabled(true).build())
            .build());
    try {
      SetBucketAutoclass.setBucketAutoclass(
          GOOGLE_CLOUD_PROJECT, autoclassBucket, StorageClass.NEARLINE);
      Autoclass autoclass = storage.get(autoclassBucket).getAutoclass();
      assertThat(autoclass.getEnabled()).isTrue();

      GetBucketAutoclass.getBucketAutoclass(GOOGLE_CLOUD_PROJECT, autoclassBucket);
      assertThat(stdOut.getCapturedOutputAsUtf8String())
          .contains(autoclass.getToggleTime().toString());
    } finally {
      RemoteStorageHelper.forceDelete(storage, autoclassBucket);
    }
  }
}
