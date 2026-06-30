/*
 * Copyright 2015 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.storage;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BucketField;
import com.google.cloud.storage.Storage.BucketGetOption;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.it.BucketCleaner;
import com.google.storage.control.v2.StorageLayoutName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** Tests for quickstart sample. */
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class QuickstartSampleIT extends TestBase {

  private String bucketName;

  @Before
  public void setUp() {
    bucketName = generator.randomBucketName();
  }

  @After
  public void tearDown() {
    Bucket bucket = storage.get(bucketName, BucketGetOption.fields(BucketField.NAME));
    if (bucket != null) {
      BucketCleaner.doCleanup(bucketName, storage);
    }
  }

  @Test
  public void testQuickstart() throws Exception {
    QuickstartSample.main(bucketName);
    String got = stdOut.getCapturedOutputAsUtf8String();
    assertThat(got).contains(String.format("Bucket %s created.", bucketName));
  }

  @Test
  public void testQuickstartGrpc() throws Exception {
    QuickstartGrpcSample.main(bucketName);
    String got = stdOut.getCapturedOutputAsUtf8String();
    assertThat(got).contains(String.format("Bucket %s created.", bucketName));
  }

  @Test
  public void testQuickstartGrpcDp() throws Exception {
    QuickstartGrpcDpSample.main(bucketName);
    String got = stdOut.getCapturedOutputAsUtf8String();
    assertThat(got).contains(String.format("Bucket %s created.", bucketName));
  }

  @Test
  public void testQuickstartStorageControl() throws Exception {
    Storage storageClient = StorageOptions.getDefaultInstance().getService();
    storageClient.create(BucketInfo.of(bucketName));
    QuickstartStorageControlSample.main(bucketName);
    String got = stdOut.getCapturedOutputAsUtf8String();
    assertThat(got)
        .contains(
            String.format(
                "Performed getStorageLayout request for %s",
                StorageLayoutName.format("_", bucketName)));
  }

  @Test
  public void testQuickstartOpenTelemetry() throws Exception {
    QuickstartOpenTelemetrySample.main();
    String got = stdOut.getCapturedOutputAsUtf8String();
    assertThat(got).contains("Created an instance of storage with OpenTelemetry configured");
  }
}
