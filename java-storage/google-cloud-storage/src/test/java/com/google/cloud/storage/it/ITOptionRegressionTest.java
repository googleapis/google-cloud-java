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

import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Bucket.BlobTargetOption;
import com.google.cloud.storage.Bucket.BlobWriteOption;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.CopyWriter;
import com.google.cloud.storage.HmacKey.HmacKeyMetadata;
import com.google.cloud.storage.HmacKey.HmacKeyState;
import com.google.cloud.storage.ServiceAccount;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobField;
import com.google.cloud.storage.Storage.BlobGetOption;
import com.google.cloud.storage.Storage.BlobListOption;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.Storage.BucketField;
import com.google.cloud.storage.Storage.BucketGetOption;
import com.google.cloud.storage.Storage.BucketListOption;
import com.google.cloud.storage.Storage.BucketSourceOption;
import com.google.cloud.storage.Storage.BucketTargetOption;
import com.google.cloud.storage.Storage.ComposeRequest;
import com.google.cloud.storage.Storage.CopyRequest;
import com.google.cloud.storage.Storage.CreateHmacKeyOption;
import com.google.cloud.storage.Storage.DeleteHmacKeyOption;
import com.google.cloud.storage.Storage.GetHmacKeyOption;
import com.google.cloud.storage.Storage.ListHmacKeysOption;
import com.google.cloud.storage.Storage.PredefinedAcl;
import com.google.cloud.storage.Storage.UpdateHmacKeyOption;
import com.google.cloud.storage.StorageClass;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.TestUtils;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.annotations.SingleBackend;
import com.google.cloud.storage.it.runner.annotations.StorageFixture;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("ConstantConditions")
@RunWith(StorageITRunner.class)
@SingleBackend(Backend.TEST_BENCH)
public final class ITOptionRegressionTest {

  private static final ChecksummedTestContent CONTENT = ChecksummedTestContent.of("Hello, World!");
  private static final ChecksummedTestContent CONTENT2 =
      ChecksummedTestContent.of("Goodbye, World!");
  private static final CSEKSupport csekSupport = CSEKSupport.create();
  private static final ServiceAccount SERVICE_ACCOUNT = ServiceAccount.of("x@y.z");

  @Inject
  @StorageFixture(Transport.HTTP)
  public Storage storageFixture;

  @Inject public BucketInfo bucket;
  private Storage s;
  private RequestAuditing requestAuditing;
  private Bucket b;
  private Blob o;
  private Blob e;

  private static int bucketCounter = 0;
  private static int objectCounter = 0;

  @Before
  public void setUp() throws Exception {
    requestAuditing = new RequestAuditing();
    s =
        storageFixture.getOptions().toBuilder()
            .setTransportOptions(requestAuditing)
            .setRetrySettings(RetrySettings.newBuilder().setMaxAttempts(1).build())
            .build()
            .getService();
    b = s.get(bucket.getName());
    o = s.create(BlobInfo.newBuilder(b, "ddeeffaauulltt").build(), CONTENT.getBytes());
    e =
        s.create(
            BlobInfo.newBuilder(b, "encrypteddetpyrcne").build(),
            CONTENT.getBytes(),
            Storage.BlobTargetOption.encryptionKey(csekSupport.getTuple().getKey()));
    requestAuditing.clear();
  }

  @Test
  public void storage_BucketTargetOption_predefinedAcl_PredefinedAcl() {
    s.create(
        BlobInfo.newBuilder(b, objectName()).build(),
        CONTENT.getBytes(),
        Storage.BlobTargetOption.predefinedAcl(PredefinedAcl.PUBLIC_READ));
    requestAuditing.assertQueryParam("predefinedAcl", "publicRead");
  }

  @Test
  public void storage_BucketTargetOption_predefinedDefaultObjectAcl_PredefinedAcl() {
    s.create(
        BucketInfo.of(bucketName()),
        BucketTargetOption.predefinedDefaultObjectAcl(PredefinedAcl.PUBLIC_READ));
    requestAuditing.assertQueryParam("predefinedDefaultObjectAcl", "publicRead");
  }

  @Test
  public void storage_BucketTargetOption_metagenerationMatch_() {
    Bucket bucket = s.create(BucketInfo.of(bucketName()));
    requestAuditing.clear();
    Bucket updated = bucket.toBuilder().setLabels(ImmutableMap.of("foo", "bar")).build();
    s.update(updated, BucketTargetOption.metagenerationMatch());
    requestAuditing.assertQueryParam(
        "ifMetagenerationMatch", bucket.getMetageneration().toString());
  }

  @Test
  public void storage_BucketTargetOption_metagenerationNotMatch_() {
    Bucket bucket1 = s.create(BucketInfo.of(bucketName()));
    Bucket updated = bucket1.toBuilder().setLabels(ImmutableMap.of("foo", "bar")).build();
    s.update(updated);
    requestAuditing.clear();
    s.update(
        bucket1.toBuilder().setStorageClass(StorageClass.COLDLINE).build(),
        BucketTargetOption.metagenerationNotMatch());
    requestAuditing.assertQueryParam("ifMetagenerationNotMatch", "1");
  }

  @Test
  public void storage_BucketTargetOption_userProject_String() {
    s.create(BucketInfo.of(bucketName()), BucketTargetOption.userProject("proj"));
    requestAuditing.assertQueryParam("userProject", "proj");
  }

  @Test
  public void storage_BucketTargetOption_projection_String() {
    Bucket bucket = s.create(BucketInfo.of(bucketName()));
    requestAuditing.clear();
    Bucket update = bucket.toBuilder().setLabels(ImmutableMap.of("a", "b")).build();
    s.update(update, BucketTargetOption.projection("noAcl"));
    requestAuditing.assertQueryParam("projection", "noAcl");
  }

  @Test
  public void storage_BucketSourceOption_metagenerationMatch_long() {
    s.get(o.getBlobId(), BlobGetOption.metagenerationMatch(o.getMetageneration()));
    requestAuditing.assertQueryParam("ifMetagenerationMatch", "1");
  }

  @Test
  public void storage_BucketSourceOption_metagenerationNotMatch_long() {
    s.get(o.getBlobId(), BlobGetOption.metagenerationNotMatch(0L));
    requestAuditing.assertQueryParam("ifMetagenerationNotMatch", "0");
  }

  @Test
  public void storage_BucketSourceOption_userProject_String() {
    s.getIamPolicy(b.getName(), BucketSourceOption.userProject("proj"));
    requestAuditing.assertQueryParam("userProject", "proj");
  }

  @Test
  public void storage_BucketSourceOption_requestedPolicyVersion_long() {
    s.getIamPolicy(b.getName(), BucketSourceOption.requestedPolicyVersion(3L));
    requestAuditing.assertQueryParam("optionsRequestedPolicyVersion", "3");
  }

  @Test
  public void storage_ListHmacKeysOption_serviceAccount_ServiceAccount() {
    s.listHmacKeys(ListHmacKeysOption.serviceAccount(SERVICE_ACCOUNT));
    requestAuditing.assertQueryParam("serviceAccountEmail", SERVICE_ACCOUNT.getEmail());
  }

  @Test
  public void storage_ListHmacKeysOption_maxResults_long() {
    s.listHmacKeys(ListHmacKeysOption.maxResults(1));
    requestAuditing.assertQueryParam("maxResults", "1");
  }

  @Test
  public void storage_ListHmacKeysOption_pageToken_String() {
    s.listHmacKeys(ListHmacKeysOption.pageToken("asdfghjkl"));
    requestAuditing.assertQueryParam("pageToken", "asdfghjkl");
  }

  @Test
  public void storage_ListHmacKeysOption_showDeletedKeys_boolean() {
    s.listHmacKeys(ListHmacKeysOption.showDeletedKeys(true));
    requestAuditing.assertQueryParam("showDeletedKeys", "true");
  }

  @Test
  public void storage_ListHmacKeysOption_userProject_String() {
    s.listHmacKeys(ListHmacKeysOption.userProject("proj"));
    requestAuditing.assertQueryParam("userProject", "proj");
  }

  @Test
  public void storage_ListHmacKeysOption_projectId_String() {
    s.listHmacKeys(ListHmacKeysOption.projectId("proj"));
    requestAuditing.assertPathParam("projects", "proj");
  }

  @Test
  public void storage_CreateHmacKeyOption_userProject_String() {
    s.createHmacKey(SERVICE_ACCOUNT, CreateHmacKeyOption.userProject("proj"));
    requestAuditing.assertQueryParam("userProject", "proj");
  }

  @Test
  public void storage_CreateHmacKeyOption_projectId_String() {
    s.createHmacKey(SERVICE_ACCOUNT, CreateHmacKeyOption.projectId("proj"));
    requestAuditing.assertPathParam("projects", "proj");
  }

  @Test
  public void storage_GetHmacKeyOption_userProject_String() {
    try {
      s.getHmacKey("x", GetHmacKeyOption.userProject("proj"));
    } catch (StorageException ignore) {
    }
    requestAuditing.assertQueryParam("userProject", "proj");
  }

  @Test
  public void storage_GetHmacKeyOption_projectId_String() {
    try {
      s.getHmacKey("x", GetHmacKeyOption.projectId("proj"));
    } catch (StorageException ignore) {
    }
    requestAuditing.assertPathParam("projects", "proj");
  }

  @Test
  public void storage_DeleteHmacKeyOption_userProject_String() {
    HmacKeyMetadata hmacKeyMetadata =
        HmacKeyMetadata.newBuilder(SERVICE_ACCOUNT).setAccessId("x").setProjectId("proj").build();
    try {
      s.deleteHmacKey(hmacKeyMetadata, DeleteHmacKeyOption.userProject("proj"));
    } catch (StorageException ignore) {
    }
    requestAuditing.assertQueryParam("userProject", "proj");
  }

  @Test
  public void storage_UpdateHmacKeyOption_userProject_String() {
    HmacKeyMetadata hmacKeyMetadata =
        HmacKeyMetadata.newBuilder(SERVICE_ACCOUNT).setAccessId("x").setProjectId("proj").build();
    try {
      s.updateHmacKeyState(
          hmacKeyMetadata, HmacKeyState.INACTIVE, UpdateHmacKeyOption.userProject("proj"));
    } catch (StorageException ignore) {
    }
    requestAuditing.assertQueryParam("userProject", "proj");
  }

  @Test
  public void storage_BucketGetOption_metagenerationMatch_long() {
    s.get(b.getName(), BucketGetOption.metagenerationMatch(b.getMetageneration()));
    requestAuditing.assertQueryParam("ifMetagenerationMatch", "1");
  }

  @Test
  public void storage_BucketGetOption_metagenerationNotMatch_long() {
    s.get(b.getName(), BucketGetOption.metagenerationNotMatch(0L));
    requestAuditing.assertQueryParam("ifMetagenerationNotMatch", "0");
  }

  @Test
  public void storage_BucketGetOption_userProject_String() {
    s.get(b.getName(), BucketGetOption.userProject("proj"));
    requestAuditing.assertQueryParam("userProject", "proj");
  }

  @Test
  public void storage_BucketGetOption_fields_BucketField() {
    Set<String> expected =
        treeSet(
            "acl",
            "autoclass",
            "billing",
            "cors",
            "customPlacementConfig",
            "defaultEventBasedHold",
            "defaultObjectAcl",
            "encryption",
            "etag",
            "iamConfiguration",
            "id",
            "ipFilter",
            "labels",
            "lifecycle",
            "location",
            "locationType",
            "logging",
            "metageneration",
            "name",
            "owner",
            "retentionPolicy",
            "rpo",
            "selfLink",
            "storageClass",
            "timeCreated",
            "updated",
            "versioning",
            "website",
            "softDeletePolicy",
            "hierarchicalNamespace",
            "projectNumber");
    s.get(
        b.getName(),
        BucketGetOption.fields(TestUtils.filterOutHttpOnlyBucketFields(BucketField.values())));
    requestAuditing.assertQueryParam("fields", expected, splitOnCommaToSet());
  }

  @Test
  public void storage_BlobTargetOption_predefinedAcl_PredefinedAcl() {
    s.create(
        BlobInfo.newBuilder(b, objectName()).build(),
        CONTENT.getBytes(),
        Storage.BlobTargetOption.predefinedAcl(PredefinedAcl.PUBLIC_READ));
    requestAuditing.assertQueryParam("predefinedAcl", "publicRead");
  }

  @Test
  public void storage_BlobTargetOption_doesNotExist_() {
    s.create(
        BlobInfo.newBuilder(b, objectName()).build(),
        CONTENT.getBytes(),
        Storage.BlobTargetOption.doesNotExist());
    requestAuditing.assertQueryParam("ifGenerationMatch", "0");
  }

  @Test
  public void storage_BlobTargetOption_generationMatch_() {
    Blob blob = s.create(BlobInfo.newBuilder(b, objectName()).build());
    requestAuditing.clear();
    Blob updated = blob.toBuilder().setMetadata(ImmutableMap.of("foo", "bar")).build();
    s.update(updated, Storage.BlobTargetOption.generationMatch());
    requestAuditing.assertQueryParam("ifGenerationMatch", blob.getGeneration().toString());
  }

  @Test
  public void storage_BlobTargetOption_generationNotMatch_() {
    Blob blob1 = s.create(BlobInfo.newBuilder(b, objectName()).build());
    Blob updated = blob1.toBuilder().setMetadata(ImmutableMap.of("foo", "bar")).build();
    s.create(updated, CONTENT2.getBytes());
    requestAuditing.clear();
    s.create(updated, CONTENT.getBytes(), Storage.BlobTargetOption.generationNotMatch());
    requestAuditing.assertQueryParam("ifGenerationNotMatch", blob1.getGeneration().toString());
  }

  @Test
  public void storage_BlobTargetOption_metagenerationMatch_() {
    Blob blob = s.create(BlobInfo.newBuilder(b, objectName()).build());
    requestAuditing.clear();
    Blob updated = blob.toBuilder().setMetadata(ImmutableMap.of("foo", "bar")).build();
    s.update(updated, Storage.BlobTargetOption.metagenerationMatch());
    requestAuditing.assertQueryParam("ifMetagenerationMatch", blob.getMetageneration().toString());
  }

  @Test
  public void storage_BlobTargetOption_metagenerationNotMatch_() {
    Blob blob1 = s.create(BlobInfo.newBuilder(b, objectName()).build());
    Blob updated = blob1.toBuilder().setMetadata(ImmutableMap.of("foo", "bar")).build();
    s.update(updated);
    requestAuditing.clear();
    s.update(
        blob1.toBuilder().setStorageClass(StorageClass.COLDLINE).build(),
        Storage.BlobTargetOption.metagenerationNotMatch());
    requestAuditing.assertQueryParam("ifMetagenerationNotMatch", "1");
  }

  @Test
  public void storage_BlobTargetOption_disableGzipContent_() {
    s.create(
        BlobInfo.newBuilder(b, objectName()).build(),
        CONTENT.getBytes(),
        Storage.BlobTargetOption.disableGzipContent());
    requestAuditing.assertNoContentEncoding();
  }

  @Test
  public void storage_BlobTargetOption_detectContentType_() {
    s.create(
        BlobInfo.newBuilder(b, objectName() + ".txt").build(),
        CONTENT.getBytes(),
        Storage.BlobTargetOption.detectContentType());
    requestAuditing.assertMultipartContentJsonAndText();
  }

  @Test
  public void storage_BlobTargetOption_encryptionKey_Key() {
    s.create(
        BlobInfo.newBuilder(b, objectName()).build(),
        CONTENT.getBytes(),
        Storage.BlobTargetOption.encryptionKey(csekSupport.getKey()));
    requestAuditing.assertEncryptionKeyHeaders(csekSupport.getTuple());
  }

  @Test
  public void storage_BlobTargetOption_userProject_String() {
    s.create(
        BlobInfo.newBuilder(b, objectName()).build(),
        CONTENT.getBytes(),
        Storage.BlobTargetOption.userProject("proj"));
    requestAuditing.assertQueryParam("userProject", "proj");
  }

  @Test
  public void storage_BlobTargetOption_encryptionKey_String() {
    s.create(
        BlobInfo.newBuilder(b, objectName()).build(),
        CONTENT.getBytes(),
        Storage.BlobTargetOption.encryptionKey(csekSupport.getTuple().getKey()));
    requestAuditing.assertEncryptionKeyHeaders(csekSupport.getTuple());
  }

  @Test
  public void storage_BlobTargetOption_kmsKeyName_String() {
    s.create(
        BlobInfo.newBuilder(b, objectName()).build(),
        CONTENT.getBytes(),
        Storage.BlobTargetOption.kmsKeyName("kms-key"));
    requestAuditing.assertQueryParam("kmsKeyName", "kms-key");
  }

  @Test
  public void storage_BlobWriteOption_predefinedAcl_PredefinedAcl() {
    s.create(
        BlobInfo.newBuilder(b, objectName()).build(),
        CONTENT.bytesAsInputStream(),
        Storage.BlobWriteOption.predefinedAcl(PredefinedAcl.PUBLIC_READ));
    requestAuditing.assertQueryParam("predefinedAcl", "publicRead");
  }

  @Test
  public void storage_BlobWriteOption_doesNotExist_() {
    s.create(
        BlobInfo.newBuilder(b, objectName()).build(),
        CONTENT.bytesAsInputStream(),
        Storage.BlobWriteOption.doesNotExist());
    requestAuditing.assertQueryParam("ifGenerationMatch", "0");
  }

  @Test
  public void storage_BlobWriteOption_generationMatch_() {
    Blob blob = s.create(BlobInfo.newBuilder(b, objectName()).build());
    requestAuditing.clear();
    Blob updated =
        blob.toBuilder()
            .setMetadata(ImmutableMap.of("foo", "bar"))
            .setMd5(null)
            .setCrc32c(null)
            .build();
    s.create(updated, CONTENT2.bytesAsInputStream(), Storage.BlobWriteOption.generationMatch());
    requestAuditing.assertQueryParam("ifGenerationMatch", blob.getGeneration().toString());
  }

  @Test
  public void storage_BlobWriteOption_generationNotMatch_() {
    Blob blob1 = s.create(BlobInfo.newBuilder(b, objectName()).build());
    Blob updated =
        blob1.toBuilder()
            .setMetadata(ImmutableMap.of("foo", "bar"))
            .setMd5(null)
            .setCrc32c(null)
            .build();
    s.create(updated, CONTENT2.getBytes());
    requestAuditing.clear();
    s.create(updated, CONTENT.bytesAsInputStream(), Storage.BlobWriteOption.generationNotMatch());
    requestAuditing.assertQueryParam("ifGenerationNotMatch", blob1.getGeneration().toString());
  }

  @Test
  public void storage_BlobWriteOption_metagenerationMatch_() {
    Blob blob = s.create(BlobInfo.newBuilder(b, objectName()).build());
    requestAuditing.clear();
    Blob updated =
        blob.toBuilder()
            .setMetadata(ImmutableMap.of("foo", "bar"))
            .setMd5(null)
            .setCrc32c(null)
            .build();
    s.create(updated, CONTENT2.bytesAsInputStream(), Storage.BlobWriteOption.metagenerationMatch());
    requestAuditing.assertQueryParam("ifMetagenerationMatch", blob.getMetageneration().toString());
  }

  @Test
  public void storage_BlobWriteOption_metagenerationNotMatch_() {
    Blob blob1 = s.create(BlobInfo.newBuilder(b, objectName()).build());
    Blob updated =
        blob1.toBuilder()
            .setMetadata(ImmutableMap.of("foo", "bar"))
            .setMd5(null)
            .setCrc32c(null)
            .build();
    s.update(updated);
    requestAuditing.clear();
    s.create(
        updated.toBuilder().setStorageClass(StorageClass.COLDLINE).build(),
        CONTENT2.bytesAsInputStream(),
        Storage.BlobWriteOption.metagenerationNotMatch());
    requestAuditing.assertQueryParam("ifMetagenerationNotMatch", "1");
  }

  @Test
  public void storage_BlobWriteOption_md5Match_() {
    BlobInfo info = BlobInfo.newBuilder(b, objectName()).setMd5(CONTENT.getMd5Base64()).build();
    s.create(info, CONTENT.bytesAsInputStream(), Storage.BlobWriteOption.md5Match());
    requestAuditing.assertMultipartJsonField("md5Hash", CONTENT.getMd5Base64());
  }

  @Test
  public void storage_BlobWriteOption_crc32cMatch_() {
    BlobInfo info =
        BlobInfo.newBuilder(b, objectName()).setCrc32c(CONTENT.getCrc32cBase64()).build();
    s.create(info, CONTENT.bytesAsInputStream(), Storage.BlobWriteOption.crc32cMatch());
    requestAuditing.assertMultipartJsonField("crc32c", CONTENT.getCrc32cBase64());
  }

  @Test
  public void storage_BlobWriteOption_encryptionKey_Key() {
    s.create(
        BlobInfo.newBuilder(b, objectName()).build(),
        CONTENT.bytesAsInputStream(),
        Storage.BlobWriteOption.encryptionKey(csekSupport.getKey()));
    requestAuditing.assertEncryptionKeyHeaders(csekSupport.getTuple());
  }

  @Test
  public void storage_BlobWriteOption_encryptionKey_String() {
    s.create(
        BlobInfo.newBuilder(b, objectName()).build(),
        CONTENT.bytesAsInputStream(),
        Storage.BlobWriteOption.encryptionKey(csekSupport.getTuple().getKey()));
    requestAuditing.assertEncryptionKeyHeaders(csekSupport.getTuple());
  }

  @Test
  public void storage_BlobWriteOption_kmsKeyName_String() {
    s.create(
        BlobInfo.newBuilder(b, objectName()).build(),
        CONTENT.bytesAsInputStream(),
        Storage.BlobWriteOption.kmsKeyName("kms-key"));
    requestAuditing.assertQueryParam("kmsKeyName", "kms-key");
  }

  @Test
  public void storage_BlobWriteOption_userProject_String() {
    s.create(
        BlobInfo.newBuilder(b, objectName()).build(),
        CONTENT.bytesAsInputStream(),
        Storage.BlobWriteOption.userProject("proj"));
    requestAuditing.assertQueryParam("userProject", "proj");
  }

  @Test
  public void storage_BlobWriteOption_disableGzipContent_() {
    s.create(
        BlobInfo.newBuilder(b, objectName()).build(),
        CONTENT.bytesAsInputStream(),
        Storage.BlobWriteOption.disableGzipContent());
    requestAuditing.assertNoContentEncoding();
  }

  @Test
  public void storage_BlobWriteOption_detectContentType_() {
    s.create(
        BlobInfo.newBuilder(b, objectName() + ".txt").build(),
        CONTENT.bytesAsInputStream(),
        Storage.BlobWriteOption.detectContentType());
    requestAuditing.assertMultipartContentJsonAndText();
  }

  @Test
  public void storage_BlobSourceOption_generationMatch_() {
    s.readAllBytes(o.getBlobId(), BlobSourceOption.generationMatch());
    requestAuditing.assertQueryParam("ifGenerationMatch", o.getGeneration().toString());
  }

  @Test
  public void storage_BlobSourceOption_generationMatch_long() {
    s.readAllBytes(o.getBlobId(), BlobSourceOption.generationMatch(o.getGeneration()));
    requestAuditing.assertQueryParam("ifGenerationMatch", o.getGeneration().toString());
  }

  @Test
  public void storage_BlobSourceOption_generationNotMatch_() {
    try {
      s.readAllBytes(
          BlobId.of(o.getBucket(), o.getName(), 1L), BlobSourceOption.generationNotMatch());
    } catch (StorageException ignore) {
      // this option doesn't make much sense.
      // The generation which is read from to construct the ifGenerationNotMatch condition comes
      //   from the BlobId. However, the same generation value is also included as the generation
      //   query param, thereby leading to a condition that can NEVER be met...
      //   This test is only here to verify plumbing, but it should be deprecated and removed
    }
    requestAuditing.assertQueryParam("ifGenerationNotMatch", "1");
  }

  @Test
  public void storage_BlobSourceOption_generationNotMatch_long() {
    s.readAllBytes(o.getBlobId(), BlobSourceOption.generationNotMatch(0));
    requestAuditing.assertQueryParam("ifGenerationNotMatch", "0");
  }

  @Test
  public void storage_BlobSourceOption_metagenerationMatch_long() {
    s.readAllBytes(o.getBlobId(), BlobSourceOption.metagenerationMatch(o.getMetageneration()));
    requestAuditing.assertQueryParam("ifMetagenerationMatch", "1");
  }

  @Test
  public void storage_BlobSourceOption_metagenerationNotMatch_long() {
    s.readAllBytes(o.getBlobId(), BlobSourceOption.metagenerationNotMatch(0));
    requestAuditing.assertQueryParam("ifMetagenerationNotMatch", "0");
  }

  @Test
  public void storage_BlobSourceOption_decryptionKey_Key() {
    s.readAllBytes(e.getBlobId(), BlobSourceOption.decryptionKey(csekSupport.getKey()));
    requestAuditing.assertEncryptionKeyHeaders(csekSupport.getTuple());
  }

  @Test
  public void storage_BlobSourceOption_decryptionKey_String() {
    s.readAllBytes(e.getBlobId(), BlobSourceOption.decryptionKey(csekSupport.getTuple().getKey()));
    requestAuditing.assertEncryptionKeyHeaders(csekSupport.getTuple());
  }

  @Test
  public void storage_BlobSourceOption_userProject_String() {
    s.readAllBytes(o.getBlobId(), BlobSourceOption.userProject("proj"));
    requestAuditing.assertQueryParam("userProject", "proj");
  }

  @Test
  public void storage_BlobGetOption_generationMatch_() {
    s.get(o.getBlobId(), BlobGetOption.generationMatch());
    requestAuditing.assertQueryParam("ifGenerationMatch", o.getGeneration().toString());
  }

  @Test
  public void storage_BlobGetOption_generationMatch_long() {
    s.get(o.getBlobId(), BlobGetOption.generationMatch(o.getGeneration()));
    requestAuditing.assertQueryParam("ifGenerationMatch", o.getGeneration().toString());
  }

  @Test
  public void storage_BlobGetOption_generationNotMatch_() {
    try {
      s.get(BlobId.of(o.getBucket(), o.getName(), 1L), BlobGetOption.generationNotMatch());
    } catch (StorageException ignore) {
      // this option doesn't make much sense.
      // The generation which is read from to construct the ifGenerationNotMatch condition comes
      //   from the BlobId. However, the same generation value is also included as the generation
      //   query param, thereby leading to a condition that can NEVER be met...
      //   This test is only here to verify plumbing, but it should be deprecated and removed
    }
    requestAuditing.assertQueryParam("ifGenerationNotMatch", "1");
  }

  @Test
  public void storage_BlobGetOption_generationNotMatch_long() {
    s.get(o.getBlobId(), BlobGetOption.generationNotMatch(0));
    requestAuditing.assertQueryParam("ifGenerationNotMatch", "0");
  }

  @Test
  public void storage_BlobGetOption_metagenerationMatch_long() {
    s.get(o.getBlobId(), BlobGetOption.metagenerationMatch(o.getMetageneration()));
    requestAuditing.assertQueryParam("ifMetagenerationMatch", "1");
  }

  @Test
  public void storage_BlobGetOption_metagenerationNotMatch_long() {
    s.get(o.getBlobId(), BlobGetOption.metagenerationNotMatch(0));
    requestAuditing.assertQueryParam("ifMetagenerationNotMatch", "0");
  }

  @Test
  public void storage_BlobGetOption_fields_BlobField() {
    Set<String> expected =
        treeSet(
            "acl",
            "bucket",
            "cacheControl",
            "componentCount",
            "contentDisposition",
            "contentEncoding",
            "contentLanguage",
            "contentType",
            "crc32c",
            "customTime",
            "customerEncryption",
            "etag",
            "eventBasedHold",
            "generation",
            "id",
            "kind",
            "kmsKeyName",
            "md5Hash",
            "mediaLink",
            "metadata",
            "metageneration",
            "name",
            "owner",
            "retentionExpirationTime",
            "selfLink",
            "size",
            "storageClass",
            "temporaryHold",
            "timeCreated",
            "timeDeleted",
            "timeStorageClassUpdated",
            "updated",
            "retention",
            "softDeleteTime",
            "hardDeleteTime",
            "contexts");
    s.get(o.getBlobId(), BlobGetOption.fields(BlobField.values()));
    requestAuditing.assertQueryParam("fields", expected, splitOnCommaToSet());
  }

  @Test
  public void storage_BlobGetOption_userProject_String() {
    s.get(o.getBlobId(), BlobGetOption.userProject("proj"));
    requestAuditing.assertQueryParam("userProject", "proj");
  }

  @Test
  public void storage_BlobGetOption_decryptionKey_Key() {
    s.get(e.getBlobId(), BlobGetOption.decryptionKey(csekSupport.getKey()));
    requestAuditing.assertEncryptionKeyHeaders(csekSupport.getTuple());
  }

  @Test
  public void storage_BlobGetOption_decryptionKey_String() {
    s.get(e.getBlobId(), BlobGetOption.decryptionKey(csekSupport.getTuple().getKey()));
    requestAuditing.assertEncryptionKeyHeaders(csekSupport.getTuple());
  }

  @Test
  public void storage_BucketListOption_pageSize_long() {
    s.list(BucketListOption.pageSize(1));
    requestAuditing.assertQueryParam("maxResults", "1");
  }

  @Test
  public void storage_BucketListOption_pageToken_String() {
    s.list(BucketListOption.pageToken("asdfghjkl"));
    requestAuditing.assertQueryParam("pageToken", "asdfghjkl");
  }

  @Test
  public void storage_BucketListOption_prefix_String() {
    s.list(BucketListOption.prefix("opt"));
    requestAuditing.assertQueryParam("prefix", "opt");
  }

  @Test
  public void storage_BucketListOption_userProject_String() {
    s.list(BucketListOption.userProject("proj"));
    requestAuditing.assertQueryParam("userProject", "proj");
  }

  @Test
  public void storage_BucketListOption_fields_BucketField() {
    Set<String> expected =
        treeSet(
            "nextPageToken",
            "items/acl",
            "items/autoclass",
            "items/billing",
            "items/cors",
            "items/customPlacementConfig",
            "items/defaultEventBasedHold",
            "items/defaultObjectAcl",
            "items/encryption",
            "items/etag",
            "items/iamConfiguration",
            "items/id",
            "items/ipFilter",
            "items/labels",
            "items/lifecycle",
            "items/location",
            "items/locationType",
            "items/logging",
            "items/metageneration",
            "items/name",
            "items/owner",
            "items/retentionPolicy",
            "items/rpo",
            "items/selfLink",
            "items/storageClass",
            "items/timeCreated",
            "items/updated",
            "items/versioning",
            "items/website",
            "items/softDeletePolicy",
            "items/hierarchicalNamespace",
            "items/projectNumber");
    s.list(BucketListOption.fields(TestUtils.filterOutHttpOnlyBucketFields(BucketField.values())));
    requestAuditing.assertQueryParam("fields", expected, splitOnCommaToSet());
  }

  @Test
  public void storage_BlobListOption_pageSize_long() {
    s.list(b.getName(), BlobListOption.pageSize(1));
    requestAuditing.assertQueryParam("maxResults", "1");
  }

  @Test
  public void storage_BlobListOption_pageToken_String() {
    s.list(b.getName(), BlobListOption.pageToken("asdfghjkl"));
    requestAuditing.assertQueryParam("pageToken", "asdfghjkl");
  }

  @Test
  public void storage_BlobListOption_prefix_String() {
    s.list(b.getName(), BlobListOption.prefix("obj"));
    requestAuditing.assertQueryParam("prefix", "obj");
  }

  @Test
  public void storage_BlobListOption_currentDirectory_() {
    s.list(b.getName(), BlobListOption.currentDirectory());
    requestAuditing.assertQueryParam("delimiter", "/");
  }

  @Test
  public void storage_BlobListOption_delimiter_String() {
    s.list(b.getName(), BlobListOption.delimiter(":"));
    requestAuditing.assertQueryParam("delimiter", ":");
  }

  @Test
  public void storage_BlobListOption_startOffset_String() {
    s.list(b.getName(), BlobListOption.startOffset("x"));
    requestAuditing.assertQueryParam("startOffset", "x");
  }

  @Test
  public void storage_BlobListOption_endOffset_String() {
    s.list(b.getName(), BlobListOption.endOffset("x"));
    requestAuditing.assertQueryParam("endOffset", "x");
  }

  @Test
  public void storage_BlobListOption_userProject_String() {
    s.list(b.getName(), BlobListOption.userProject("proj"));
    requestAuditing.assertQueryParam("userProject", "proj");
  }

  @Test
  public void storage_BlobListOption_versions_boolean() {
    s.list(b.getName(), BlobListOption.versions(true));
    requestAuditing.assertQueryParam("versions", "true");
  }

  @Test
  public void storage_BlobListOption_fields_BlobField() {
    Set<String> expected =
        treeSet(
            "nextPageToken",
            "prefixes",
            "items/acl",
            "items/bucket",
            "items/cacheControl",
            "items/componentCount",
            "items/contentDisposition",
            "items/contentEncoding",
            "items/contentLanguage",
            "items/contentType",
            "items/crc32c",
            "items/customTime",
            "items/customerEncryption",
            "items/etag",
            "items/eventBasedHold",
            "items/generation",
            "items/id",
            "items/kind",
            "items/kmsKeyName",
            "items/md5Hash",
            "items/mediaLink",
            "items/metadata",
            "items/metageneration",
            "items/name",
            "items/owner",
            "items/retentionExpirationTime",
            "items/selfLink",
            "items/size",
            "items/storageClass",
            "items/temporaryHold",
            "items/timeCreated",
            "items/timeDeleted",
            "items/timeStorageClassUpdated",
            "items/updated",
            "items/retention",
            "items/softDeleteTime",
            "items/hardDeleteTime",
            "items/contexts");
    s.list(b.getName(), BlobListOption.fields(BlobField.values()));
    requestAuditing.assertQueryParam("fields", expected, splitOnCommaToSet());
  }

  @Test
  public void bucket_BucketSourceOption_metagenerationMatch_() {
    b.exists(Bucket.BucketSourceOption.metagenerationMatch());
    requestAuditing.assertQueryParam("ifMetagenerationMatch", b.getMetageneration().toString());
  }

  @Test
  public void bucket_BucketSourceOption_metagenerationNotMatch_() {
    Bucket bucket1 = s.create(BucketInfo.of(bucketName()));
    s.update(bucket1.toBuilder().setStorageClass(StorageClass.COLDLINE).build());
    requestAuditing.clear();
    bucket1.exists(Bucket.BucketSourceOption.metagenerationNotMatch());
    requestAuditing.assertQueryParam("ifMetagenerationNotMatch", b.getMetageneration().toString());
  }

  @Test
  public void bucket_BucketSourceOption_userProject_String() {
    // attempt to delete a bucket that doesn't exist
    boolean delete = s.delete(bucketName(), BucketSourceOption.userProject("proj"));
    assertThat(delete).isFalse();
    requestAuditing.assertQueryParam("userProject", "proj");
  }

  @Test
  public void bucket_BlobTargetOption_predefinedAcl_PredefinedAcl() {
    b.create(
        objectName(),
        CONTENT.getBytes(),
        BlobTargetOption.predefinedAcl(PredefinedAcl.PUBLIC_READ));
    requestAuditing.assertQueryParam("predefinedAcl", "publicRead");
  }

  @Test
  public void bucket_BlobTargetOption_doesNotExist_() {
    b.create(objectName(), CONTENT.getBytes(), BlobTargetOption.doesNotExist());
    requestAuditing.assertQueryParam("ifGenerationMatch", "0");
  }

  @Test
  public void bucket_BlobTargetOption_generationMatch_long() {
    b.create(objectName(), CONTENT.getBytes(), BlobTargetOption.generationMatch(0));
    requestAuditing.assertQueryParam("ifGenerationMatch", "0");
  }

  @Test
  public void bucket_BlobTargetOption_generationNotMatch_long() {
    b.create(objectName(), CONTENT.getBytes(), BlobTargetOption.generationNotMatch(1L));
    requestAuditing.assertQueryParam("ifGenerationNotMatch", "1");
  }

  @Test
  public void bucket_BlobTargetOption_metagenerationMatch_long() {
    b.create(objectName(), CONTENT.getBytes(), BlobTargetOption.metagenerationMatch(0));
    requestAuditing.assertQueryParam("ifMetagenerationMatch", "0");
  }

  @Test
  public void bucket_BlobTargetOption_metagenerationNotMatch_long() {
    b.create(objectName(), CONTENT.getBytes(), BlobTargetOption.metagenerationNotMatch(1L));
    requestAuditing.assertQueryParam("ifMetagenerationNotMatch", "1");
  }

  @Test
  public void bucket_BlobTargetOption_encryptionKey_Key() {
    b.create(
        objectName(), CONTENT.getBytes(), BlobTargetOption.encryptionKey(csekSupport.getKey()));
    requestAuditing.assertEncryptionKeyHeaders(csekSupport.getTuple());
  }

  @Test
  public void bucket_BlobTargetOption_encryptionKey_String() {
    b.create(
        objectName(),
        CONTENT.getBytes(),
        BlobTargetOption.encryptionKey(csekSupport.getTuple().getKey()));
    requestAuditing.assertEncryptionKeyHeaders(csekSupport.getTuple());
  }

  @Test
  public void bucket_BlobTargetOption_kmsKeyName_String() {
    b.create(objectName(), CONTENT.getBytes(), BlobTargetOption.kmsKeyName("kms-key"));
    requestAuditing.assertQueryParam("kmsKeyName", "kms-key");
  }

  @Test
  public void bucket_BlobTargetOption_userProject_String() {
    b.create(objectName(), CONTENT.getBytes(), BlobTargetOption.userProject("proj"));
    requestAuditing.assertQueryParam("userProject", "proj");
  }

  @Test
  public void bucket_BlobWriteOption_predefinedAcl_PredefinedAcl() {
    b.create(
        objectName(),
        CONTENT.bytesAsInputStream(),
        BlobWriteOption.predefinedAcl(PredefinedAcl.PUBLIC_READ));
    requestAuditing.assertQueryParam("predefinedAcl", "publicRead");
  }

  @Test
  public void bucket_BlobWriteOption_doesNotExist_() {
    b.create(objectName(), CONTENT.bytesAsInputStream(), BlobWriteOption.doesNotExist());
    requestAuditing.assertQueryParam("ifGenerationMatch", "0");
  }

  @Test
  public void bucket_BlobWriteOption_generationMatch_long() {
    b.create(objectName(), CONTENT.bytesAsInputStream(), BlobWriteOption.generationMatch(0));
    requestAuditing.assertQueryParam("ifGenerationMatch", "0");
  }

  @Test
  public void bucket_BlobWriteOption_generationNotMatch_long() {
    b.create(objectName(), CONTENT.bytesAsInputStream(), BlobWriteOption.generationNotMatch(1L));
    requestAuditing.assertQueryParam("ifGenerationNotMatch", "1");
  }

  @Test
  public void bucket_BlobWriteOption_metagenerationMatch_long() {
    b.create(objectName(), CONTENT.bytesAsInputStream(), BlobWriteOption.metagenerationMatch(0));
    requestAuditing.assertQueryParam("ifMetagenerationMatch", "0");
  }

  @Test
  public void bucket_BlobWriteOption_metagenerationNotMatch_long() {
    b.create(
        objectName(), CONTENT.bytesAsInputStream(), BlobWriteOption.metagenerationNotMatch(1L));
    requestAuditing.assertQueryParam("ifMetagenerationNotMatch", "1");
  }

  @Test
  public void bucket_BlobWriteOption_md5Match_String() {
    b.create(
        objectName(),
        CONTENT.bytesAsInputStream(),
        BlobWriteOption.md5Match(CONTENT.getMd5Base64()));
    requestAuditing.assertMultipartJsonField("md5Hash", CONTENT.getMd5Base64());
  }

  @Test
  public void bucket_BlobWriteOption_crc32cMatch_String() {
    b.create(
        objectName(),
        CONTENT.bytesAsInputStream(),
        BlobWriteOption.crc32cMatch(CONTENT.getCrc32cBase64()));
    requestAuditing.assertMultipartJsonField("crc32c", CONTENT.getCrc32cBase64());
  }

  @Test
  public void bucket_BlobWriteOption_encryptionKey_Key() {
    b.create(
        objectName(),
        CONTENT.bytesAsInputStream(),
        BlobWriteOption.encryptionKey(csekSupport.getKey()));
    requestAuditing.assertEncryptionKeyHeaders(csekSupport.getTuple());
  }

  @Test
  public void bucket_BlobWriteOption_encryptionKey_String() {
    b.create(
        objectName(),
        CONTENT.bytesAsInputStream(),
        BlobWriteOption.encryptionKey(csekSupport.getTuple().getKey()));
    requestAuditing.assertEncryptionKeyHeaders(csekSupport.getTuple());
  }

  @Test
  public void bucket_BlobWriteOption_userProject_String() {
    b.create(objectName(), CONTENT.bytesAsInputStream(), BlobWriteOption.userProject("proj"));
    requestAuditing.assertQueryParam("userProject", "proj");
  }

  @Test
  public void blob_BlobSourceOption_generationMatch_() {
    o.getContent(Blob.BlobSourceOption.generationMatch());
    requestAuditing.assertQueryParam("ifGenerationMatch", o.getGeneration().toString());
  }

  @Test
  public void blob_BlobSourceOption_generationNotMatch_() {
    try {
      o.getContent(Blob.BlobSourceOption.generationNotMatch());
    } catch (StorageException ignore) {
      // this option doesn't make much sense.
      // The generation which is read from to construct the ifGenerationNotMatch condition comes
      //   from the BlobId. However, the same generation value is also included as the generation
      //   query param, thereby leading to a condition that can NEVER be met...
      //   This test is only here to verify plumbing, but it should be deprecated and removed
    }
    requestAuditing.assertQueryParam("ifGenerationNotMatch", o.getGeneration().toString());
  }

  @Test
  public void blob_BlobSourceOption_metagenerationMatch_() {
    o.getContent(Blob.BlobSourceOption.metagenerationMatch());
    requestAuditing.assertQueryParam("ifMetagenerationMatch", o.getMetageneration().toString());
  }

  @Test
  public void blob_BlobSourceOption_metagenerationNotMatch_() {
    Blob blob1 = s.create(BlobInfo.newBuilder(b, objectName()).build());
    Blob updated = blob1.toBuilder().setMetadata(ImmutableMap.of("foo", "bar")).build();
    s.update(updated);
    requestAuditing.clear();
    blob1.getContent(Blob.BlobSourceOption.metagenerationNotMatch());
    requestAuditing.assertQueryParam(
        "ifMetagenerationNotMatch", blob1.getMetageneration().toString());
  }

  @Test
  public void blob_BlobSourceOption_decryptionKey_Key() {
    e.getContent(Blob.BlobSourceOption.decryptionKey(csekSupport.getKey()));
    requestAuditing.assertEncryptionKeyHeaders(csekSupport.getTuple());
  }

  @Test
  public void blob_BlobSourceOption_decryptionKey_String() {
    e.getContent(Blob.BlobSourceOption.decryptionKey(csekSupport.getTuple().getKey()));
    requestAuditing.assertEncryptionKeyHeaders(csekSupport.getTuple());
  }

  @Test
  public void blob_BlobSourceOption_userProject_String() {
    o.getContent(Blob.BlobSourceOption.userProject("proj"));
    requestAuditing.assertQueryParam("userProject", "proj");
  }

  @Test
  public void storage_CopyWriter() {
    CopyRequest request =
        CopyRequest.newBuilder()
            .setSource(o.getBlobId())
            .setSourceOptions(Storage.BlobSourceOption.generationMatch())
            .setTarget(
                BlobId.of(b.getName(), objectName(), 57L),
                Storage.BlobTargetOption.generationNotMatch())
            .build();
    CopyWriter copy = s.copy(request);
    requestAuditing.assertQueryParam("ifGenerationNotMatch", "57");
    requestAuditing.assertQueryParam("ifSourceGenerationMatch", o.getGeneration().toString());
    copy.getResult();
  }

  @Test
  public void storage_ComposeRequest() {
    Blob obj = b.create(objectName(), CONTENT.getBytes(), BlobTargetOption.doesNotExist());
    requestAuditing.clear();
    Blob updated = obj.toBuilder().setMd5(null).setCrc32c(null).build();
    ComposeRequest request =
        ComposeRequest.newBuilder()
            .addSource(o.getName())
            .addSource(o.getName())
            .setTarget(updated)
            .setTargetOptions(Storage.BlobTargetOption.metagenerationMatch())
            .build();

    s.compose(request);
    requestAuditing.assertQueryParam("ifMetagenerationMatch", obj.getMetageneration().toString());
  }

  private static String bucketName() {
    return String.format(Locale.US, "bucket-%03d", bucketCounter++);
  }

  private static String objectName() {
    return String.format(Locale.US, "object-%03d", objectCounter++);
  }

  private static Function<String, Set<String>> splitOnCommaToSet() {
    return s -> treeSet(s.split(","));
  }

  /**
   * Util method to make a TreeSet easily. This makes failed assertions easier to read by sorting
   * the values.
   */
  @SafeVarargs
  private static <T extends Comparable<T>> Set<T> treeSet(T... ts) {
    return new TreeSet<>(ImmutableSet.copyOf(ts));
  }
}
