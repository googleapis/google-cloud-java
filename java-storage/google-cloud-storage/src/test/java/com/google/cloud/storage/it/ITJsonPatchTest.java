/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.BucketInfo.LifecycleRule;
import com.google.cloud.storage.BucketInfo.LifecycleRule.LifecycleAction;
import com.google.cloud.storage.BucketInfo.LifecycleRule.LifecycleCondition;
import com.google.cloud.storage.Cors;
import com.google.cloud.storage.Cors.Origin;
import com.google.cloud.storage.HttpMethod;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.BucketTargetOption;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    backends = {Backend.PROD},
    transports = {Transport.HTTP, Transport.GRPC})
public final class ITJsonPatchTest {

  @Inject public Storage storage;
  @Inject public BucketInfo bucket;
  @Inject public Generator generator;

  @Test
  public void object() throws Exception {
    String cacheControl = "max-age=60";
    String contentDisposition = "attachment";
    String contentEncoding = "identity";
    String contentLanguage = "en-US";
    String contentType = "text/plain";
    BlobInfo info =
        BlobInfo.newBuilder(bucket, generator.randomObjectName())
            .setCacheControl(cacheControl)
            .setContentDisposition(contentDisposition)
            .setContentEncoding(contentEncoding)
            .setContentLanguage(contentLanguage)
            .setContentType(contentType)
            .build();

    Blob gen1 = storage.create(info);
    assertAll(
        () -> assertThat(gen1.getCacheControl()).isEqualTo(cacheControl),
        () -> assertThat(gen1.getContentDisposition()).isEqualTo(contentDisposition),
        () -> assertThat(gen1.getContentEncoding()).isEqualTo(contentEncoding),
        () -> assertThat(gen1.getContentLanguage()).isEqualTo(contentLanguage),
        () -> assertThat(gen1.getContentType()).isEqualTo(contentType));
    BlobInfo update =
        gen1.toBuilder()
            .setCacheControl(null)
            .setContentDisposition(null)
            .setContentEncoding(null)
            .setContentLanguage(null)
            .setContentType(null)
            .build();
    Blob gen2 =
        storage.update(update, BlobTargetOption.metagenerationMatch(gen1.getMetageneration()));
    assertAll(
        () -> assertThat(gen2.getCacheControl()).isAnyOf("", null),
        () -> assertThat(gen2.getContentDisposition()).isAnyOf("", null),
        () -> assertThat(gen2.getContentEncoding()).isAnyOf("", null),
        () -> assertThat(gen2.getContentLanguage()).isAnyOf("", null),
        () -> assertThat(gen2.getContentType()).isAnyOf("", null));
  }

  @Test
  public void bucket() throws Exception {
    ImmutableList<LifecycleRule> lifecycleRules =
        ImmutableList.of(
            new LifecycleRule(
                LifecycleAction.newDeleteAction(),
                LifecycleCondition.newBuilder()
                    .setMatchesPrefix(ImmutableList.of("blahblahblah"))
                    .build()));
    ImmutableList<Cors> cors =
        ImmutableList.of(
            Cors.newBuilder()
                .setMaxAgeSeconds(300)
                .setMethods(ImmutableList.of(HttpMethod.GET))
                .setOrigins(ImmutableList.of(Origin.any()))
                .setResponseHeaders(ImmutableList.of("blah2blah"))
                .build());
    String indexPage = "index.html";
    String notFoundPage = "404.html";
    BucketInfo info =
        BucketInfo.newBuilder(generator.randomBucketName())
            .setLifecycleRules(lifecycleRules)
            .setCors(cors)
            .setIndexPage(indexPage)
            .setNotFoundPage(notFoundPage)
            .build();

    try (TemporaryBucket tmpBucket =
        TemporaryBucket.newBuilder().setBucketInfo(info).setStorage(storage).build()) {
      BucketInfo gen1 = tmpBucket.getBucket();

      assertAll(
          () -> assertThat(gen1.getLifecycleRules()).isEqualTo(lifecycleRules),
          () -> assertThat(gen1.getCors()).isEqualTo(cors),
          () -> assertThat(gen1.getIndexPage()).isEqualTo(indexPage),
          () -> assertThat(gen1.getNotFoundPage()).isEqualTo(notFoundPage));
      BucketInfo update =
          gen1.toBuilder()
              .setLifecycleRules(ImmutableList.of())
              .setCors(ImmutableList.of())
              .setIndexPage(null)
              .setNotFoundPage(null)
              .build();
      Bucket gen2 = storage.update(update, BucketTargetOption.metagenerationMatch());
      assertAll(
          () -> assertThat(gen2.getLifecycleRules()).isAnyOf(ImmutableList.of(), null),
          () -> assertThat(gen2.getCors()).isAnyOf(ImmutableList.of(), null),
          () -> assertThat(gen2.getIndexPage()).isAnyOf("", null),
          () -> assertThat(gen2.getNotFoundPage()).isAnyOf("", null));
    }
  }
}
