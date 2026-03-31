/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.storage.it;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BucketTargetOption;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

public final class DedupeOptionTest {

  @Test
  public void dedupe_varargs() {
    BucketTargetOption[] dedupe =
        BucketTargetOption.dedupe(
            BucketTargetOption.userProject("abc"),
            BucketTargetOption.metagenerationMatch(),
            BucketTargetOption.userProject("xyz"));

    assertThat(dedupe)
        .asList()
        .containsExactly(
            BucketTargetOption.metagenerationMatch(), BucketTargetOption.userProject("xyz"));
  }

  @Test
  public void dedupe_collection_varargs() {
    BucketTargetOption[] dedupe =
        BucketTargetOption.dedupe(
            ImmutableList.of(
                BucketTargetOption.userProject("abc"), BucketTargetOption.metagenerationMatch()),
            BucketTargetOption.userProject("xyz"));

    assertThat(dedupe)
        .asList()
        .containsExactly(
            BucketTargetOption.metagenerationMatch(), BucketTargetOption.userProject("xyz"));
  }

  @Test
  public void dedupe_array_varargs() {
    BucketTargetOption[] dedupe =
        BucketTargetOption.dedupe(
            new BucketTargetOption[] {
              BucketTargetOption.userProject("abc"), BucketTargetOption.metagenerationMatch()
            },
            BucketTargetOption.userProject("xyz"));

    assertThat(dedupe)
        .asList()
        .containsExactly(
            BucketTargetOption.metagenerationMatch(), BucketTargetOption.userProject("xyz"));
  }

  @Test
  public void allClasses_varargs() {
    Storage.BlobGetOption.dedupe();
    Storage.BlobListOption.dedupe();
    Storage.BlobSourceOption.dedupe();
    Storage.BlobTargetOption.dedupe();
    Storage.BlobWriteOption.dedupe();
    Storage.BucketGetOption.dedupe();
    Storage.BucketListOption.dedupe();
    Storage.BucketSourceOption.dedupe();
    Storage.BucketTargetOption.dedupe();
    Storage.CreateHmacKeyOption.dedupe();
    Storage.DeleteHmacKeyOption.dedupe();
    Storage.GetHmacKeyOption.dedupe();
    Storage.ListHmacKeysOption.dedupe();
    Storage.UpdateHmacKeyOption.dedupe();

    Bucket.BlobTargetOption.dedupe();
    Bucket.BlobWriteOption.dedupe();
    Bucket.BucketSourceOption.dedupe();

    Blob.BlobSourceOption.dedupe();
  }

  @Test
  public void allClasses_collection_varargs() {
    Storage.BlobGetOption.dedupe(ImmutableList.of());
    Storage.BlobListOption.dedupe(ImmutableList.of());
    Storage.BlobSourceOption.dedupe(ImmutableList.of());
    Storage.BlobTargetOption.dedupe(ImmutableList.of());
    Storage.BlobWriteOption.dedupe(ImmutableList.of());
    Storage.BucketGetOption.dedupe(ImmutableList.of());
    Storage.BucketListOption.dedupe(ImmutableList.of());
    Storage.BucketSourceOption.dedupe(ImmutableList.of());
    Storage.BucketTargetOption.dedupe(ImmutableList.of());
    Storage.CreateHmacKeyOption.dedupe(ImmutableList.of());
    Storage.DeleteHmacKeyOption.dedupe(ImmutableList.of());
    Storage.GetHmacKeyOption.dedupe(ImmutableList.of());
    Storage.ListHmacKeysOption.dedupe(ImmutableList.of());
    Storage.UpdateHmacKeyOption.dedupe(ImmutableList.of());

    Bucket.BlobTargetOption.dedupe(ImmutableList.of());
    Bucket.BlobWriteOption.dedupe(ImmutableList.of());
    Bucket.BucketSourceOption.dedupe(ImmutableList.of());

    Blob.BlobSourceOption.dedupe(ImmutableList.of());
  }

  @Test
  public void allClasses_array_varargs() {
    String p = "proj";
    Storage.BlobGetOption.dedupe(
        new Storage.BlobGetOption[0], Storage.BlobGetOption.userProject(p));
    Storage.BlobListOption.dedupe(
        new Storage.BlobListOption[0], Storage.BlobListOption.userProject(p));
    Storage.BlobSourceOption.dedupe(
        new Storage.BlobSourceOption[0], Storage.BlobSourceOption.userProject(p));
    Storage.BlobTargetOption.dedupe(
        new Storage.BlobTargetOption[0], Storage.BlobTargetOption.userProject(p));
    Storage.BlobWriteOption.dedupe(
        new Storage.BlobWriteOption[0], Storage.BlobWriteOption.userProject(p));
    Storage.BucketGetOption.dedupe(
        new Storage.BucketGetOption[0], Storage.BucketGetOption.userProject(p));
    Storage.BucketListOption.dedupe(
        new Storage.BucketListOption[0], Storage.BucketListOption.userProject(p));
    Storage.BucketSourceOption.dedupe(
        new Storage.BucketSourceOption[0], Storage.BucketSourceOption.userProject(p));
    Storage.BucketTargetOption.dedupe(
        new Storage.BucketTargetOption[0], Storage.BucketTargetOption.userProject(p));
    Storage.CreateHmacKeyOption.dedupe(
        new Storage.CreateHmacKeyOption[0], Storage.CreateHmacKeyOption.userProject(p));
    Storage.DeleteHmacKeyOption.dedupe(
        new Storage.DeleteHmacKeyOption[0], Storage.DeleteHmacKeyOption.userProject(p));
    Storage.GetHmacKeyOption.dedupe(
        new Storage.GetHmacKeyOption[0], Storage.GetHmacKeyOption.userProject(p));
    Storage.ListHmacKeysOption.dedupe(
        new Storage.ListHmacKeysOption[0], Storage.ListHmacKeysOption.userProject(p));
    Storage.UpdateHmacKeyOption.dedupe(
        new Storage.UpdateHmacKeyOption[0], Storage.UpdateHmacKeyOption.userProject(p));

    Bucket.BlobTargetOption.dedupe(
        new Bucket.BlobTargetOption[0], Bucket.BlobTargetOption.userProject(p));
    Bucket.BlobWriteOption.dedupe(
        new Bucket.BlobWriteOption[0], Bucket.BlobWriteOption.userProject(p));
    Bucket.BucketSourceOption.dedupe(
        new Bucket.BucketSourceOption[0], Bucket.BucketSourceOption.userProject(p));

    Blob.BlobSourceOption.dedupe(
        new Blob.BlobSourceOption[0], Blob.BlobSourceOption.userProject(p));
  }
}
