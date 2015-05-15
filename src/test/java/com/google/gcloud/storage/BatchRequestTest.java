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

import static com.google.gcloud.storage.StorageService.PredefinedAcl.PUBLIC_READ;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.Iterables;
import com.google.gcloud.storage.StorageService.BlobSourceOption;
import com.google.gcloud.storage.StorageService.BlobTargetOption;

import org.junit.Test;

import java.util.Iterator;
import java.util.Map.Entry;

public class BatchRequestTest {

  @Test
  public void testBatchRequest() {
    BatchRequest request = BatchRequest.builder()
        .delete("b1", "o1")
        .delete("b1", "o2", BlobSourceOption.generationMatch(1),
            BlobSourceOption.metagenerationMatch(2))
        .update(Blob.of("b2", "o1"), BlobTargetOption.predefinedAcl(PUBLIC_READ))
        .update(Blob.of("b2", "o2"))
        .get("b3", "o1")
        .get("b3", "o2", BlobSourceOption.generationMatch(1))
        .get("b3", "o3")
        .build();

    Iterator<Entry<Blob, Iterable<BlobSourceOption>>> deletes = request
        .toDelete().entrySet().iterator();
    Entry<Blob, Iterable<BlobSourceOption>> delete = deletes.next();
    assertEquals(Blob.of("b1", "o1"), delete.getKey());
    assertTrue(Iterables.isEmpty(delete.getValue()));
    delete = deletes.next();
    assertEquals(Blob.of("b1", "o2"), delete.getKey());
    assertEquals(2, Iterables.size(delete.getValue()));
    assertFalse(deletes.hasNext());

    Iterator<Entry<Blob, Iterable<BlobTargetOption>>> updates = request
        .toUpdate().entrySet().iterator();
    Entry<Blob, Iterable<BlobTargetOption>> update = updates.next();
    assertEquals(Blob.of("b2", "o1"), update.getKey());
    assertEquals(1, Iterables.size(update.getValue()));
    assertEquals(BlobTargetOption.predefinedAcl(PUBLIC_READ),
        Iterables.getFirst(update.getValue(), null));
    update = updates.next();
    assertEquals(Blob.of("b2", "o2"), update.getKey());
    assertTrue(Iterables.isEmpty(update.getValue()));
    assertFalse(updates.hasNext());

    Iterator<Entry<Blob, Iterable<BlobSourceOption>>> gets = request
        .toGet().entrySet().iterator();
    Entry<Blob, Iterable<BlobSourceOption>> get = gets.next();
    assertEquals(Blob.of("b3", "o1"), get.getKey());
    assertTrue(Iterables.isEmpty(get.getValue()));
    get = gets.next();
    assertEquals(Blob.of("b3", "o2"), get.getKey());
    assertEquals(1, Iterables.size(get.getValue()));
    assertEquals(BlobSourceOption.generationMatch(1),
        Iterables.getFirst(get.getValue(), null));
    get = gets.next();
    assertEquals(Blob.of("b3", "o3"), get.getKey());
    assertTrue(Iterables.isEmpty(get.getValue()));
    assertFalse(gets.hasNext());
  }
}
