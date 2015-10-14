/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.storage;

import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableList;
import com.google.gcloud.storage.BatchResponse.Result;

import org.junit.Test;

import java.util.List;

public class BatchResponseTest {

  private static final BlobInfo BLOB_INFO_1 = BlobInfo.builder("b", "o1").build();
  private static final BlobInfo BLOB_INFO_2 = BlobInfo.builder("b", "o2").build();
  private static final BlobInfo BLOB_INFO_3 = BlobInfo.builder("b", "o3").build();

  @Test
  public void testBatchResponse() {
    List<Result<Boolean>> deletes = ImmutableList.of(Result.of(true), Result.of(false));
    List<Result<BlobInfo>> updates = ImmutableList.of(Result.of(BLOB_INFO_1), Result.of(BLOB_INFO_2));
    List<Result<BlobInfo>> gets = ImmutableList.of(Result.of(BLOB_INFO_2), Result.of(BLOB_INFO_3));
    BatchResponse response = new BatchResponse(deletes, updates, gets);

    assertEquals(deletes, response.deletes());
    assertEquals(updates, response.updates());
    assertEquals(gets, response.gets());
  }
}
