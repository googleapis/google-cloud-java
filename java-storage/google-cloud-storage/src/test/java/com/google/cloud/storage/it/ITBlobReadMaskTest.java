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

package com.google.cloud.storage.it;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobField;
import com.google.cloud.storage.Storage.BlobGetOption;
import com.google.cloud.storage.Storage.BlobListOption;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.ITBlobReadMaskTest.BlobReadMaskTestParameters;
import com.google.cloud.storage.it.ReadMaskTestUtils.Args;
import com.google.cloud.storage.it.ReadMaskTestUtils.LazyAssertion;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.annotations.ParallelFriendly;
import com.google.cloud.storage.it.runner.annotations.Parameterized;
import com.google.cloud.storage.it.runner.annotations.Parameterized.Parameter;
import com.google.cloud.storage.it.runner.annotations.SingleBackend;
import com.google.cloud.storage.it.runner.annotations.StorageFixture;
import com.google.cloud.storage.it.runner.registry.ObjectsFixture;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@Parameterized(BlobReadMaskTestParameters.class)
@SingleBackend(Backend.PROD)
@ParallelFriendly
public final class ITBlobReadMaskTest {

  @Inject
  @StorageFixture(Transport.HTTP)
  public Storage sh;

  @Inject
  @StorageFixture(Transport.GRPC)
  public Storage sg;

  @Inject public BucketInfo bucket;

  @Inject public ObjectsFixture objectsFixture;

  @Parameter public Args<BlobField, BlobInfo> args;

  private BlobField field;
  private LazyAssertion<BlobInfo> assertion;

  @Before
  public void setUp() throws Exception {
    field = args.getField();
    assertion = args.getAssertion();
  }

  @Test
  public void get() {
    BlobInfo blobJson = getBlob(sh);
    BlobInfo blobGrpc = getBlob(sg);

    assertion.validate(blobJson, blobGrpc);
  }

  @Test
  public void list() {
    List<BlobInfo> blobsJson = listBlobs(sh);
    List<BlobInfo> blobsGrpc = listBlobs(sg);

    assertion.pairwiseList().validate(blobsJson, blobsGrpc);
  }

  private BlobInfo getBlob(Storage s) {
    return s.get(objectsFixture.getInfo1().getBlobId(), BlobGetOption.fields(field)).asBlobInfo();
  }

  private List<BlobInfo> listBlobs(Storage s) {
    Page<Blob> p =
        s.list(
            bucket.getName(),
            BlobListOption.prefix(ReadMaskTestUtils.class.getSimpleName()),
            BlobListOption.fields(field));
    return StreamSupport.stream(p.iterateAll().spliterator(), false)
        .map(Blob::asBlobInfo)
        .collect(Collectors.toList());
  }

  public static final class BlobReadMaskTestParameters implements Parameterized.ParametersProvider {

    @Override
    public ImmutableList<?> parameters() {
      ImmutableList<Args<BlobField, BlobInfo>> args =
          ImmutableList.of(
              new Args<>(BlobField.ACL, LazyAssertion.equal()),
              new Args<>(BlobField.BUCKET, LazyAssertion.equal()),
              new Args<>(
                  BlobField.CACHE_CONTROL,
                  LazyAssertion.apiaryNullGrpcDefault("", BlobInfo::getCacheControl)),
              // for non-composed objects, json and grpc differ in their resulting values. For json,
              // a null will be returned whereas for grpc we will get the type default value which
              // in this case is 0. The only possible way we could guard against this would be if
              // the proto changed component_count to proto3_optional forcing it to generate a
              // hasComponentCount.
              new Args<>(
                  BlobField.COMPONENT_COUNT,
                  (jsonT, grpcT) -> {
                    if (grpcT.getComponentCount() == 0) {
                      assertThat(jsonT.getComponentCount()).isNull();
                    } else {
                      assertThat(grpcT.getComponentCount()).isEqualTo(jsonT.getComponentCount());
                    }
                  }),
              new Args<>(
                  BlobField.CONTENT_DISPOSITION,
                  LazyAssertion.apiaryNullGrpcDefault("", BlobInfo::getContentDisposition)),
              new Args<>(
                  BlobField.CONTENT_ENCODING,
                  LazyAssertion.apiaryNullGrpcDefault("", BlobInfo::getContentEncoding)),
              new Args<>(
                  BlobField.CONTENT_LANGUAGE,
                  LazyAssertion.apiaryNullGrpcDefault("", BlobInfo::getContentLanguage)),
              // we'd expect this to follow the patter of the other Content-* headers, however via
              // the json api GCS will default null contentType to application/octet-stream. Note,
              // however it doesn't carry this forward to composed objects so a composed object can
              // have a null/empty content-type.
              new Args<>(
                  BlobField.CONTENT_TYPE,
                  (jsonT, grpcT) -> {
                    assertThat(jsonT.getContentType()).isAnyOf("application/octet-stream", null);
                    assertThat(grpcT.getContentType()).isAnyOf("application/octet-stream", "");
                  }),
              new Args<>(BlobField.CRC32C, LazyAssertion.equal()),
              new Args<>(BlobField.CUSTOMER_ENCRYPTION, LazyAssertion.equal()),
              new Args<>(BlobField.CUSTOM_TIME, LazyAssertion.equal()),
              new Args<>(BlobField.ETAG, LazyAssertion.equal()),
              new Args<>(
                  BlobField.EVENT_BASED_HOLD,
                  LazyAssertion.apiaryNullGrpcDefault(false, BlobInfo::getEventBasedHold)),
              new Args<>(BlobField.GENERATION, LazyAssertion.equal()),
              new Args<>(
                  BlobField.ID,
                  (jsonT, grpcT) -> {
                    assertThat(jsonT.getGeneratedId()).isNotEmpty();
                    assertThat(grpcT.getGeneratedId()).isNull();
                  }),
              new Args<>(
                  BlobField.KIND,
                  (jsonT, grpcT) -> {
                    // pass - we don't expose kind in the public surface
                  }),
              new Args<>(BlobField.KMS_KEY_NAME, LazyAssertion.equal()),
              new Args<>(BlobField.MD5HASH, LazyAssertion.equal()),
              new Args<>(
                  BlobField.MEDIA_LINK,
                  (jsonT, grpcT) -> {
                    assertThat(jsonT.getMediaLink()).isNotEmpty();
                    assertThat(grpcT.getMediaLink()).isNull();
                  }),
              new Args<>(BlobField.METADATA, LazyAssertion.equal()),
              new Args<>(BlobField.METAGENERATION, LazyAssertion.equal()),
              new Args<>(BlobField.NAME, LazyAssertion.equal()),
              new Args<>(BlobField.OWNER, LazyAssertion.equal()),
              new Args<>(BlobField.RETENTION_EXPIRATION_TIME, LazyAssertion.equal()),
              new Args<>(
                  BlobField.SELF_LINK,
                  (jsonT, grpcT) -> {
                    assertThat(jsonT.getSelfLink()).isNotEmpty();
                    assertThat(grpcT.getSelfLink()).isNull();
                  }),
              new Args<>(BlobField.SIZE, LazyAssertion.equal()),
              new Args<>(BlobField.STORAGE_CLASS, LazyAssertion.equal()),
              new Args<>(
                  BlobField.TEMPORARY_HOLD,
                  LazyAssertion.apiaryNullGrpcDefault(false, BlobInfo::getTemporaryHold)),
              new Args<>(BlobField.TIME_CREATED, LazyAssertion.equal()),
              new Args<>(BlobField.TIME_DELETED, LazyAssertion.equal()),
              new Args<>(BlobField.TIME_STORAGE_CLASS_UPDATED, LazyAssertion.equal()),
              new Args<>(BlobField.UPDATED, LazyAssertion.equal()),
              new Args<>(
                  BlobField.RETENTION,
                  LazyAssertion.skip("TODO: jesse fill in buganizer bug here")),
              new Args<>(BlobField.OBJECT_CONTEXTS, LazyAssertion.equal()),
              new Args<>(BlobField.SOFT_DELETE_TIME, LazyAssertion.equal()),
              new Args<>(BlobField.HARD_DELETE_TIME, LazyAssertion.equal()));
      List<String> argsDefined =
          args.stream().map(Args::getField).map(Enum::name).sorted().collect(Collectors.toList());

      List<String> definedFields =
          Arrays.stream(BlobField.values()).map(Enum::name).sorted().collect(Collectors.toList());

      assertThat(argsDefined).containsExactlyElementsIn(definedFields);
      return args;
    }
  }
}
