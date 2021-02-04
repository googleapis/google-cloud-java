/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.examples.storage.snippets;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

import com.google.cloud.Identity;
import com.google.cloud.ServiceOptions;
import com.google.cloud.examples.storage.buckets.AddBucketIamConditionalBinding;
import com.google.cloud.examples.storage.buckets.AddBucketIamMember;
import com.google.cloud.examples.storage.buckets.AddBucketLabel;
import com.google.cloud.examples.storage.buckets.ChangeDefaultStorageClass;
import com.google.cloud.examples.storage.buckets.ConfigureBucketCors;
import com.google.cloud.examples.storage.buckets.CreateBucket;
import com.google.cloud.examples.storage.buckets.CreateBucketWithStorageClassAndLocation;
import com.google.cloud.examples.storage.buckets.DeleteBucket;
import com.google.cloud.examples.storage.buckets.DisableBucketVersioning;
import com.google.cloud.examples.storage.buckets.DisableLifecycleManagement;
import com.google.cloud.examples.storage.buckets.DisableRequesterPays;
import com.google.cloud.examples.storage.buckets.EnableBucketVersioning;
import com.google.cloud.examples.storage.buckets.EnableLifecycleManagement;
import com.google.cloud.examples.storage.buckets.EnableRequesterPays;
import com.google.cloud.examples.storage.buckets.GetBucketMetadata;
import com.google.cloud.examples.storage.buckets.ListBucketIamMembers;
import com.google.cloud.examples.storage.buckets.ListBuckets;
import com.google.cloud.examples.storage.buckets.MakeBucketPublic;
import com.google.cloud.examples.storage.buckets.RemoveBucketCors;
import com.google.cloud.examples.storage.buckets.RemoveBucketDefaultKMSKey;
import com.google.cloud.examples.storage.buckets.RemoveBucketIamConditionalBinding;
import com.google.cloud.examples.storage.buckets.RemoveBucketIamMember;
import com.google.cloud.examples.storage.buckets.RemoveBucketLabel;
import com.google.cloud.examples.storage.buckets.SetBucketWebsiteInfo;
import com.google.cloud.examples.storage.objects.DownloadRequesterPaysObject;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Acl.Role;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Cors;
import com.google.cloud.storage.HttpMethod;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageRoles;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

public class ITBucketSnippets {

  private static final Logger log = Logger.getLogger(ITBucketSnippets.class.getName());
  private static final String BUCKET = RemoteStorageHelper.generateBucketName();
  private static final String USER_EMAIL = "test@test.com";
  private static final String BLOB1 = "blob1";
  private static final String BLOB2 = "blob2";
  private static final String BLOB3 = "blob3";
  private static final String BLOB4 = "blob4";
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");

  private static Storage storage;
  private static BucketSnippets bucketSnippets;

  @Rule public ExpectedException thrown = ExpectedException.none();

  @Rule public Timeout globalTimeout = Timeout.seconds(300);

  @BeforeClass
  public static void beforeClass() {
    RemoteStorageHelper helper = RemoteStorageHelper.create();
    storage = helper.getOptions().getService();
    bucketSnippets = new BucketSnippets(storage.create(BucketInfo.of(BUCKET)));
  }

  @AfterClass
  public static void afterClass() throws ExecutionException, InterruptedException {
    if (storage != null) {
      boolean wasDeleted = RemoteStorageHelper.forceDelete(storage, BUCKET, 5, TimeUnit.SECONDS);
      if (!wasDeleted && log.isLoggable(Level.WARNING)) {
        log.log(Level.WARNING, "Deletion of bucket {0} timed out, bucket is not empty", BUCKET);
      }
    }
  }

  @Test
  public void testBucket() throws InterruptedException {
    assertTrue(bucketSnippets.exists());
    Bucket bucket = bucketSnippets.reload();
    assertNotNull(bucket);
    Bucket updatedBucket = bucketSnippets.update();
    assertTrue(updatedBucket.versioningEnabled());
    Blob blob1 = bucketSnippets.createBlobFromByteArray(BLOB1);
    assertNotNull(blob1);
    Blob blob2 = bucketSnippets.createBlobFromByteArrayWithContentType(BLOB2);
    assertNotNull(blob2);
    Blob blob3 = bucketSnippets.createBlobFromInputStream(BLOB3);
    assertNotNull(blob3);
    Blob blob4 = bucketSnippets.createBlobFromInputStreamWithContentType(BLOB4);
    assertNotNull(blob4);
    blob1 = bucketSnippets.getBlob(BLOB1, blob1.getGeneration());
    assertEquals(BLOB1, blob1.getName());
    List<Blob> blobs = bucketSnippets.getBlobFromStrings(BLOB2, BLOB3);
    assertEquals(BLOB2, blobs.get(0).getName());
    assertEquals(BLOB3, blobs.get(1).getName());
    blobs = bucketSnippets.getBlobFromStringIterable(BLOB3, BLOB4);
    assertEquals(BLOB3, blobs.get(0).getName());
    assertEquals(BLOB4, blobs.get(1).getName());
    // test ACLs
    assertNull(bucketSnippets.getAcl());
    assertNotNull(bucketSnippets.createAcl());
    Acl updatedAcl = bucketSnippets.updateAcl();
    assertEquals(Role.OWNER, updatedAcl.getRole());
    Set<Acl> acls = Sets.newHashSet(bucketSnippets.listAcls());
    assertTrue(acls.contains(updatedAcl));
    assertTrue(bucketSnippets.deleteAcl());
    assertNull(bucketSnippets.getAcl());
    // test default ACLs
    assertNull(bucketSnippets.getDefaultAcl());
    assertNotNull(bucketSnippets.createDefaultAcl());
    updatedAcl = bucketSnippets.updateDefaultAcl();
    assertEquals(Role.OWNER, updatedAcl.getRole());
    acls = Sets.newHashSet(bucketSnippets.listDefaultAcls());
    assertTrue(acls.contains(updatedAcl));
    assertTrue(bucketSnippets.deleteDefaultAcl());
    assertNull(bucketSnippets.getDefaultAcl());
    thrown.expect(StorageException.class);
  }

  @Test
  public void testAddBucketLabel() {
    AddBucketLabel.addBucketLabel(PROJECT_ID, BUCKET, "key", "value");
    Bucket remoteBucket = storage.get(BUCKET);
    assertEquals(1, remoteBucket.getLabels().size());
  }

  @Test
  public void testChangeDefaultStorageClass() {
    Bucket remoteBucket = storage.get(BUCKET);
    assertEquals("STANDARD", remoteBucket.getStorageClass().name());
    ChangeDefaultStorageClass.changeDefaultStorageClass(PROJECT_ID, BUCKET);
    remoteBucket = storage.get(BUCKET);
    assertEquals("COLDLINE", remoteBucket.getStorageClass().name());
  }

  @Test
  public void testCreateBucket() {
    String newBucket = RemoteStorageHelper.generateBucketName();
    CreateBucket.createBucket(PROJECT_ID, newBucket);
    try {
      Bucket remoteBucket = storage.get(newBucket);
      assertNotNull(remoteBucket);
    } finally {
      storage.delete(newBucket);
    }
  }

  @Test
  public void testCreateBucketWithStorageClassAndLocation() {
    String newBucket = RemoteStorageHelper.generateBucketName();
    CreateBucketWithStorageClassAndLocation.createBucketWithStorageClassAndLocation(
        PROJECT_ID, newBucket);
    try {
      Bucket remoteBucket = storage.get(newBucket);
      assertNotNull(remoteBucket);
      assertEquals("COLDLINE", remoteBucket.getStorageClass().name());
      assertEquals("ASIA", remoteBucket.getLocation());
    } finally {
      storage.delete(newBucket);
    }
  }

  @Test
  public void testDeleteBucket() {
    String newBucket = RemoteStorageHelper.generateBucketName();
    storage.create(BucketInfo.newBuilder(newBucket).build());
    assertNotNull(storage.get(newBucket));
    try {
      DeleteBucket.deleteBucket(PROJECT_ID, newBucket);
      assertNull(storage.get(newBucket));
    } finally {
      storage.delete(newBucket);
    }
  }

  @Test
  public void testGetBucketMetadata() {
    Bucket bucket =
        storage.get(BUCKET, Storage.BucketGetOption.fields(Storage.BucketField.values()));
    bucket =
        bucket
            .toBuilder()
            .setLabels(ImmutableMap.of("k", "v"))
            .setLifecycleRules(
                ImmutableList.of(
                    new BucketInfo.LifecycleRule(
                        BucketInfo.LifecycleRule.LifecycleAction.newDeleteAction(),
                        BucketInfo.LifecycleRule.LifecycleCondition.newBuilder()
                            .setAge(5)
                            .build())))
            .build()
            .update();

    PrintStream standardOut = System.out;
    final ByteArrayOutputStream snippetOutputCapture = new ByteArrayOutputStream();
    System.setOut(new PrintStream(snippetOutputCapture));
    GetBucketMetadata.getBucketMetadata(PROJECT_ID, BUCKET);
    String snippetOutput = snippetOutputCapture.toString();
    System.setOut(standardOut);
    System.out.println(snippetOutput);
    assertTrue(snippetOutput.contains(("BucketName: " + bucket.getName())));
    assertTrue(
        snippetOutput.contains(("DefaultEventBasedHold: " + bucket.getDefaultEventBasedHold())));
    assertTrue(snippetOutput.contains(("DefaultKmsKeyName: " + bucket.getDefaultKmsKeyName())));
    assertTrue(snippetOutput.contains(("Id: " + bucket.getGeneratedId())));
    assertTrue(snippetOutput.contains(("IndexPage: " + bucket.getIndexPage())));
    assertTrue(snippetOutput.contains(("Location: " + bucket.getLocation())));
    assertTrue(snippetOutput.contains(("LocationType: " + bucket.getLocationType())));
    assertTrue(snippetOutput.contains(("Metageneration: " + bucket.getMetageneration())));
    assertTrue(snippetOutput.contains(("NotFoundPage: " + bucket.getNotFoundPage())));
    assertTrue(
        snippetOutput.contains(("RetentionEffectiveTime: " + bucket.getRetentionEffectiveTime())));
    assertTrue(snippetOutput.contains(("RetentionPeriod: " + bucket.getRetentionPeriod())));
    assertTrue(
        snippetOutput.contains(("RetentionPolicyIsLocked: " + bucket.retentionPolicyIsLocked())));
    assertTrue(snippetOutput.contains(("RequesterPays: " + bucket.requesterPays())));
    assertTrue(snippetOutput.contains(("SelfLink: " + bucket.getSelfLink())));
    assertTrue(snippetOutput.contains(("StorageClass: " + bucket.getStorageClass().name())));
    assertTrue(snippetOutput.contains(("TimeCreated: " + bucket.getCreateTime())));
    assertTrue(snippetOutput.contains(("VersioningEnabled: " + bucket.versioningEnabled())));
    assertTrue(snippetOutput.contains("Labels:"));
    assertTrue(snippetOutput.contains("k=v"));
    assertTrue(snippetOutput.contains("Lifecycle Rules:"));
  }

  @Test
  public void testListBuckets() {
    final ByteArrayOutputStream snippetOutputCapture = new ByteArrayOutputStream();
    System.setOut(new PrintStream(snippetOutputCapture));
    ListBuckets.listBuckets(PROJECT_ID);
    String snippetOutput = snippetOutputCapture.toString();
    System.setOut(System.out);
    assertTrue(snippetOutput.contains(BUCKET));
  }

  @Test
  public void testRemoveBucketLabel() {
    storage.get(BUCKET).toBuilder().setLabels(ImmutableMap.of("k", "v")).build().update();
    assertEquals(1, storage.get(BUCKET).getLabels().size());
    RemoveBucketLabel.removeBucketLabel(PROJECT_ID, BUCKET, "k");
    assertNull(storage.get(BUCKET).getLabels());
  }

  @Test
  public void testEnableLifecycleManagement() {
    EnableLifecycleManagement.enableLifecycleManagement(PROJECT_ID, BUCKET);
    assertEquals(1, storage.get(BUCKET).getLifecycleRules().size());
  }

  @Test
  public void testDisableLifecycleManagement() {
    storage
        .get(BUCKET)
        .toBuilder()
        .setLifecycleRules(
            ImmutableList.of(
                new BucketInfo.LifecycleRule(
                    BucketInfo.LifecycleRule.LifecycleAction.newDeleteAction(),
                    BucketInfo.LifecycleRule.LifecycleCondition.newBuilder().setAge(5).build())))
        .build()
        .update();
    assertEquals(1, storage.get(BUCKET).getLifecycleRules().size());
    DisableLifecycleManagement.disableLifecycleManagement(PROJECT_ID, BUCKET);
    assertEquals(0, storage.get(BUCKET).getLifecycleRules().size());
  }

  @Test
  public void testAddListRemoveBucketIamMembers() {
    storage.update(
        BucketInfo.newBuilder(BUCKET)
            .setIamConfiguration(
                BucketInfo.IamConfiguration.newBuilder()
                    .setIsUniformBucketLevelAccessEnabled(true)
                    .build())
            .build());
    int originalSize = storage.getIamPolicy(BUCKET).getBindingsList().size();
    AddBucketIamMember.addBucketIamMember(PROJECT_ID, BUCKET);
    assertEquals(originalSize + 1, storage.getIamPolicy(BUCKET).getBindingsList().size());
    PrintStream standardOut = System.out;
    final ByteArrayOutputStream snippetOutputCapture = new ByteArrayOutputStream();
    System.setOut(new PrintStream(snippetOutputCapture));
    ListBucketIamMembers.listBucketIamMembers(PROJECT_ID, BUCKET);
    String snippetOutput = snippetOutputCapture.toString();
    System.setOut(standardOut);
    assertTrue(snippetOutput.contains("example@google.com"));
    RemoveBucketIamMember.removeBucketIamMember(PROJECT_ID, BUCKET);
    assertEquals(originalSize, storage.getIamPolicy(BUCKET).getBindingsList().size());
    AddBucketIamConditionalBinding.addBucketIamConditionalBinding(PROJECT_ID, BUCKET);
    assertEquals(originalSize + 1, storage.getIamPolicy(BUCKET).getBindingsList().size());
    RemoveBucketIamConditionalBinding.removeBucketIamConditionalBinding(PROJECT_ID, BUCKET);
    assertEquals(originalSize, storage.getIamPolicy(BUCKET).getBindingsList().size());
    storage.update(
        BucketInfo.newBuilder(BUCKET)
            .setIamConfiguration(
                BucketInfo.IamConfiguration.newBuilder()
                    .setIsUniformBucketLevelAccessEnabled(false)
                    .build())
            .build());
  }

  @Test
  public void testMakeBucketPublic() {
    MakeBucketPublic.makeBucketPublic(PROJECT_ID, BUCKET);
    assertTrue(
        storage
            .getIamPolicy(BUCKET)
            .getBindings()
            .get(StorageRoles.objectViewer())
            .contains(Identity.allUsers()));
  }

  @Test
  public void deleteBucketDefaultKmsKey() {
    storage
        .get(BUCKET)
        .toBuilder()
        .setDefaultKmsKeyName(
            "projects/gcloud-devel/locations/global/keyRings/gcs_kms_key_ring/cryptoKeys/key")
        .build()
        .update();
    assertNotNull(storage.get(BUCKET).getDefaultKmsKeyName());
    RemoveBucketDefaultKMSKey.removeBucketDefaultKmsKey(PROJECT_ID, BUCKET);
    assertNull(storage.get(BUCKET).getDefaultKmsKeyName());
  }

  @Test
  public void testEnableDisableVersioning() {
    EnableBucketVersioning.enableBucketVersioning(PROJECT_ID, BUCKET);
    assertTrue(storage.get(BUCKET).versioningEnabled());
    DisableBucketVersioning.disableBucketVersioning(PROJECT_ID, BUCKET);
    Assert.assertFalse(storage.get(BUCKET).versioningEnabled());
  }

  @Test
  public void testSetBucketWebsiteInfo() {
    SetBucketWebsiteInfo.setBucketWesbiteInfo(PROJECT_ID, BUCKET, "index.html", "404.html");
    Bucket bucket = storage.get(BUCKET);
    assertEquals("index.html", bucket.getIndexPage());
    assertEquals("404.html", bucket.getNotFoundPage());
  }

  @Test
  public void testConfigureBucketCors() {
    System.out.println(PROJECT_ID);
    ConfigureBucketCors.configureBucketCors(
        PROJECT_ID, BUCKET, "http://example.appspot.com", "Content-Type", 3600);
    Cors cors = storage.get(BUCKET).getCors().get(0);
    assertTrue(cors.getOrigins().get(0).toString().contains("example.appspot.com"));
    assertTrue(cors.getResponseHeaders().contains("Content-Type"));
    assertEquals(3600, cors.getMaxAgeSeconds().intValue());
    assertTrue(cors.getMethods().get(0).toString().equalsIgnoreCase("GET"));
  }

  @Test
  public void testRemoveBucketCors() {
    storage
        .get(BUCKET)
        .toBuilder()
        .setCors(
            ImmutableList.of(
                Cors.newBuilder()
                    .setOrigins(ImmutableList.of(Cors.Origin.of("http://example.appspot.com")))
                    .setMethods(ImmutableList.of(HttpMethod.GET))
                    .setResponseHeaders(ImmutableList.of("Content-Type"))
                    .setMaxAgeSeconds(3600)
                    .build()))
        .build()
        .update();
    Cors cors = storage.get(BUCKET).getCors().get(0);
    assertNotNull(cors);
    assertTrue(cors.getOrigins().get(0).toString().contains("example.appspot.com"));
    assertTrue(cors.getResponseHeaders().contains("Content-Type"));
    assertEquals(3600, cors.getMaxAgeSeconds().intValue());
    assertTrue(cors.getMethods().get(0).toString().equalsIgnoreCase("GET"));
    RemoveBucketCors.removeBucketCors(PROJECT_ID, BUCKET);
    assertNull(storage.get(BUCKET).getCors());
  }

  @Test
  public void testRequesterPays() throws Exception {
    EnableRequesterPays.enableRequesterPays(PROJECT_ID, BUCKET);
    Bucket bucket = storage.get(BUCKET);
    assertTrue(bucket.requesterPays());
    String projectId = ServiceOptions.getDefaultProjectId();
    String blobName = "test-create-empty-blob-requester-pays";
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    Blob remoteBlob =
        bucket.create(blobName, content, Bucket.BlobTargetOption.userProject(projectId));
    assertNotNull(remoteBlob);
    DownloadRequesterPaysObject.downloadRequesterPaysObject(
        projectId, BUCKET, blobName, Paths.get(blobName));
    byte[] readBytes = Files.readAllBytes(Paths.get(blobName));
    assertArrayEquals(content, readBytes);
    DisableRequesterPays.disableRequesterPays(PROJECT_ID, BUCKET);
    assertFalse(storage.get(BUCKET).requesterPays());
  }
}
