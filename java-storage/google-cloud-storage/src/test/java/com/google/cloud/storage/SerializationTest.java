/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.storage;

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.BaseSerializationTest;
import com.google.cloud.NoCredentials;
import com.google.cloud.PageImpl;
import com.google.cloud.ReadChannel;
import com.google.cloud.Restorable;
import com.google.cloud.RestorableState;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Acl.Project.ProjectRole;
import com.google.cloud.storage.BlobReadChannelV2.BlobReadChannelContext;
import com.google.cloud.storage.BlobReadChannelV2.BlobReadChannelV2State;
import com.google.cloud.storage.BlobWriteChannelV2.BlobWriteChannelV2State;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.BufferAllocationStrategy;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.ExecutorSupplier;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.PartCleanupStrategy;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.PartMetadataFieldDecorator;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.PartNamingStrategy;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.BucketField;
import com.google.cloud.storage.Storage.ComposeRequest;
import com.google.cloud.storage.Storage.PredefinedAcl;
import com.google.cloud.storage.UnifiedOpts.Opt;
import com.google.cloud.storage.UnifiedOpts.Opts;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.Duration;
import java.util.Base64;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class SerializationTest extends BaseSerializationTest {

  private static final Acl.Domain ACL_DOMAIN = new Acl.Domain("domain");
  private static final Acl.Group ACL_GROUP = new Acl.Group("group");
  private static final Acl.Project ACL_PROJECT_ = new Acl.Project(ProjectRole.VIEWERS, "pid");
  private static final Acl.User ACL_USER = new Acl.User("user");
  private static final Acl.RawEntity ACL_RAW = new Acl.RawEntity("raw");
  private static final Acl ACL = Acl.of(ACL_DOMAIN, Acl.Role.OWNER);
  private static final BlobInfo BLOB_INFO = BlobInfo.newBuilder("b", "n").build();
  private static final BucketInfo BUCKET_INFO = BucketInfo.of("b");
  private static final Cors.Origin ORIGIN = Cors.Origin.any();
  private static final Cors CORS =
      Cors.newBuilder().setMaxAgeSeconds(1).setOrigins(Collections.singleton(ORIGIN)).build();
  private static final StorageException STORAGE_EXCEPTION = new StorageException(42, "message");
  private static final Storage.BlobListOption BLOB_LIST_OPTIONS =
      Storage.BlobListOption.pageSize(100);
  private static final Storage.BlobSourceOption BLOB_SOURCE_OPTIONS =
      Storage.BlobSourceOption.generationMatch(1);
  private static final Storage.BlobTargetOption BLOB_TARGET_OPTIONS =
      Storage.BlobTargetOption.generationMatch();
  private static final Storage.BucketListOption BUCKET_LIST_OPTIONS =
      Storage.BucketListOption.prefix("bla");
  private static final Storage.BucketSourceOption BUCKET_SOURCE_OPTIONS =
      Storage.BucketSourceOption.metagenerationMatch(1);
  private static final Storage.BucketTargetOption BUCKET_TARGET_OPTIONS =
      Storage.BucketTargetOption.metagenerationNotMatch();
  private static final Map<StorageRpc.Option, ?> EMPTY_RPC_OPTIONS = ImmutableMap.of();

  private static Storage STORAGE;
  private static Blob BLOB;
  private static Bucket BUCKET;
  private static PageImpl<Blob> PAGE_RESULT;

  @BeforeClass
  public static void beforeClass() {
    StorageOptions storageOptions =
        StorageOptions.newBuilder()
            .setProjectId("p")
            .setCredentials(NoCredentials.getInstance())
            .build();
    STORAGE = storageOptions.getService();
    BLOB = BLOB_INFO.asBlob(STORAGE);
    BUCKET = BUCKET_INFO.asBucket(STORAGE);
    PAGE_RESULT = new PageImpl<>(null, "c", Collections.singletonList(BLOB));
  }

  @AfterClass
  public static void afterClass() throws Exception {
    if (STORAGE != null) {
      STORAGE.close();
    }
  }

  @Override
  protected Serializable[] serializableObjects() {
    StorageOptions optionsDefault1 =
        StorageOptions.newBuilder()
            .setProjectId("p1")
            .setCredentials(NoCredentials.getInstance())
            .build();
    StorageOptions optionsDefault2 = optionsDefault1.toBuilder().setProjectId("p2").build();
    StorageOptions optionsHttp1 =
        StorageOptions.http()
            .setProjectId("http1")
            .setCredentials(NoCredentials.getInstance())
            .build();
    StorageOptions optionsHttp2 = optionsHttp1.toBuilder().setProjectId("http2").build();
    StorageOptions optionsGrpc1 =
        StorageOptions.grpc()
            .setProjectId("grpc1")
            .setCredentials(NoCredentials.getInstance())
            .build();
    StorageOptions optionsGrpc2 = optionsGrpc1.toBuilder().setProjectId("grpc2").build();

    // echo -n "key" | base64
    String keyBase64 = "a2V5";

    ImmutableList<Opt> serializableOpts =
        ImmutableList.<Opt>builder()
            .add(UnifiedOpts.crc32cMatch("crc32c"))
            .add(UnifiedOpts.currentDirectory())
            .add(UnifiedOpts.decryptionKey(keyBase64))
            .add(UnifiedOpts.delimiter("/"))
            .add(UnifiedOpts.detectContentType())
            .add(UnifiedOpts.disableGzipContent())
            .add(UnifiedOpts.doesNotExist())
            .add(UnifiedOpts.encryptionKey(keyBase64))
            .add(UnifiedOpts.endOffset("end"))
            .add(UnifiedOpts.fields(ImmutableSet.of(BucketField.LOCATION)))
            .add(UnifiedOpts.generationMatch(0))
            .add(UnifiedOpts.generationNotMatch(0))
            .add(UnifiedOpts.kmsKeyName("key"))
            .add(UnifiedOpts.md5Match("md5"))
            .add(UnifiedOpts.metagenerationMatch(1))
            .add(UnifiedOpts.metagenerationNotMatch(1))
            .add(UnifiedOpts.pageSize(3))
            .add(UnifiedOpts.pageToken("token"))
            .add(UnifiedOpts.predefinedAcl(PredefinedAcl.PRIVATE))
            .add(UnifiedOpts.predefinedDefaultObjectAcl(PredefinedAcl.PRIVATE))
            .add(UnifiedOpts.prefix("prefix"))
            .add(UnifiedOpts.projectId("proj"))
            .add(UnifiedOpts.projection("full"))
            .add(UnifiedOpts.requestedPolicyVersion(2))
            .add(UnifiedOpts.returnRawInputStream(false))
            .add(UnifiedOpts.serviceAccount(ServiceAccount.of("x@y.z")))
            .add(UnifiedOpts.setContentType("text/plain"))
            .add(UnifiedOpts.showDeletedKeys(false))
            .add(UnifiedOpts.startOffset("start"))
            .add(UnifiedOpts.userProject("user-proj"))
            .add(UnifiedOpts.versionsFilter(false))
            .add(UnifiedOpts.generationMatchExtractor())
            .add(UnifiedOpts.generationNotMatchExtractor())
            .add(UnifiedOpts.metagenerationMatchExtractor())
            .add(UnifiedOpts.metagenerationNotMatchExtractor())
            .add(UnifiedOpts.crc32cMatchExtractor())
            .add(UnifiedOpts.md5MatchExtractor())
            .build();

    try {
      GrpcStorageOptions grpcStorageOptionsBufferToTemp =
          StorageOptions.grpc()
              .setCredentials(NoCredentials.getInstance())
              .setProjectId("project1")
              .setBlobWriteSessionConfig(BlobWriteSessionConfigs.bufferToTempDirThenUpload())
              .build();

      return new Serializable[] {
        ACL_DOMAIN,
        ACL_GROUP,
        ACL_PROJECT_,
        ACL_USER,
        ACL_RAW,
        ACL,
        BLOB_INFO,
        BLOB,
        BUCKET_INFO,
        BUCKET,
        ORIGIN,
        CORS,
        PAGE_RESULT,
        BLOB_LIST_OPTIONS,
        BLOB_SOURCE_OPTIONS,
        BLOB_TARGET_OPTIONS,
        BUCKET_LIST_OPTIONS,
        BUCKET_SOURCE_OPTIONS,
        BUCKET_TARGET_OPTIONS,
        STORAGE_EXCEPTION,
        optionsDefault1,
        optionsDefault2,
        optionsHttp1,
        optionsHttp2,
        optionsGrpc1,
        optionsGrpc2,
        serializableOpts,
        grpcStorageOptionsBufferToTemp
      };
    } catch (IOException ioe) {
      throw new AssertionError(ioe);
    }
  }

  @Test
  public void avoidNpeHttpStorageOptions_retryDeps() throws IOException, ClassNotFoundException {
    HttpStorageOptions optionsHttp1 =
        StorageOptions.http()
            .setProjectId("http1")
            .setCredentials(NoCredentials.getInstance())
            .build();

    assertThat(optionsHttp1.asRetryDependencies()).isNotNull();

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
      oos.writeObject(optionsHttp1);
    }

    byte[] byteArray = baos.toByteArray();
    try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(byteArray))) {
      Object o = ois.readObject();
      HttpStorageOptions hso = (HttpStorageOptions) o;
      assertThat(hso.asRetryDependencies()).isNotNull();
    }
  }

  @Override
  @SuppressWarnings("resource")
  protected Restorable<?>[] restorableObjects() {
    HttpStorageOptions options = HttpStorageOptions.newBuilder().setProjectId("p2").build();
    ReadChannel readerV2 =
        new BlobReadChannelV2(
            new StorageObject().setBucket("b").setName("n"),
            EMPTY_RPC_OPTIONS,
            BlobReadChannelContext.from(options));
    WriteChannel writer =
        new BlobWriteChannelV2(
            BlobReadChannelContext.from(options),
            JsonResumableWrite.of(
                Conversions.json().blobInfo().encode(BlobInfo.newBuilder("b", "n").build()),
                ImmutableMap.of(),
                "upload-id",
                0,
                Hasher.enabled(),
                Crc32cValue.zero()));
    return new Restorable<?>[] {readerV2, writer};
  }

  @SuppressWarnings({"deprecation", "rawtypes"})
  @Test
  public void restoreOfV1BlobReadChannelShouldReturnV2Channel()
      throws IOException, ClassNotFoundException {

    Properties properties = new Properties();
    try (InputStream is =
        SerializationTest.class
            .getClassLoader()
            .getResourceAsStream("com/google/cloud/storage/blobReadChannel.ser.properties")) {
      properties.load(is);
    }
    String b64bytes = properties.getProperty("b64bytes");
    assertThat(b64bytes).isNotEmpty();

    byte[] decode = Base64.getDecoder().decode(b64bytes);
    try (ByteArrayInputStream bais = new ByteArrayInputStream(decode);
        ObjectInputStream ois = new ObjectInputStream(bais)) {
      Object o = ois.readObject();
      assertThat(o).isInstanceOf(RestorableState.class);
      RestorableState restorableState = (RestorableState) o;
      assertThat(o).isInstanceOf(BlobReadChannel.StateImpl.class);
      BlobReadChannel.StateImpl state = (BlobReadChannel.StateImpl) restorableState;
      ReadChannel restore = state.restore();
      assertThat(restore).isInstanceOf(BlobReadChannelV2.class);
      RestorableState<ReadChannel> capture = restore.capture();
      assertThat(capture).isInstanceOf(BlobReadChannelV2State.class);
    }
  }

  @SuppressWarnings({"deprecation", "rawtypes"})
  @Test
  public void restoreOfV1BlobWriteChannelShouldReturnV2Channel()
      throws IOException, ClassNotFoundException {

    Properties properties = new Properties();
    try (InputStream is =
        SerializationTest.class
            .getClassLoader()
            .getResourceAsStream("com/google/cloud/storage/blobWriteChannel.ser.properties")) {
      properties.load(is);
    }
    String b64bytes = properties.getProperty("b64bytes");
    assertThat(b64bytes).isNotEmpty();

    byte[] decode = Base64.getDecoder().decode(b64bytes);
    try (ByteArrayInputStream bais = new ByteArrayInputStream(decode);
        ObjectInputStream ois = new ObjectInputStream(bais)) {
      Object o = ois.readObject();
      assertThat(o).isInstanceOf(RestorableState.class);
      RestorableState restorableState = (RestorableState) o;
      assertThat(o).isInstanceOf(BlobWriteChannel.StateImpl.class);
      BlobWriteChannel.StateImpl state = (BlobWriteChannel.StateImpl) restorableState;
      WriteChannel restore = state.restore();
      assertThat(restore).isInstanceOf(BlobWriteChannelV2.class);
      RestorableState<WriteChannel> capture = restore.capture();
      assertThat(capture).isInstanceOf(BlobWriteChannelV2State.class);
    }
  }

  @Test
  public void composeRequest() throws IOException, ClassNotFoundException {

    Properties properties = new Properties();
    try (InputStream is =
        SerializationTest.class
            .getClassLoader()
            .getResourceAsStream("com/google/cloud/storage/composeRequest.ser.properties")) {
      properties.load(is);
    }
    String b64bytes = properties.getProperty("b64bytes");
    assertThat(b64bytes).isNotEmpty();

    byte[] decode = Base64.getDecoder().decode(b64bytes);
    try (ByteArrayInputStream bais = new ByteArrayInputStream(decode);
        ObjectInputStream ois = new ObjectInputStream(bais)) {
      Object o = ois.readObject();
      assertThat(o).isInstanceOf(ComposeRequest.class);
      ComposeRequest composeRequest = (ComposeRequest) o;
      assertThat(composeRequest.getSourceBlobs()).hasSize(4);
      assertThat(composeRequest.getTarget().getBucket()).isEqualTo("buck");
      assertThat(composeRequest.getTarget().getName()).isEqualTo("comp");
      assertThat(composeRequest.getTargetOptions())
          .containsExactly(BlobTargetOption.doesNotExist());
      assertThat(composeRequest.getTargetOpts())
          .isEqualTo(Opts.from(UnifiedOpts.generationMatch(0)));
    }
  }

  /**
   * Here we override the super classes implementation to remove the "assertNotSame".
   *
   * <p>We should not enforce that two instances are not the same. As long as they're equal and have
   * the same hashCode that should be sufficient.
   */
  @Test
  @Override
  public void testSerializableObjects() throws Exception {
    for (Serializable obj : firstNonNull(serializableObjects(), new Serializable[0])) {
      Object copy = serializeAndDeserialize(obj);
      assertEquals(obj, obj);
      assertEquals(obj, copy);
      assertEquals(obj.hashCode(), copy.hashCode());
      assertEquals(obj.toString(), copy.toString());
      assertEquals(copy, copy);
    }
  }

  @Test
  public void blobWriteSessionConfig_pcu() throws IOException, ClassNotFoundException {
    ParallelCompositeUploadBlobWriteSessionConfig pcu1 =
        BlobWriteSessionConfigs.parallelCompositeUpload();
    ParallelCompositeUploadBlobWriteSessionConfig pcu1copy = serializeAndDeserialize(pcu1);
    assertThat(pcu1copy).isNotNull();

    ParallelCompositeUploadBlobWriteSessionConfig pcu2 =
        BlobWriteSessionConfigs.parallelCompositeUpload()
            .withBufferAllocationStrategy(BufferAllocationStrategy.fixedPool(1, 3))
            .withPartCleanupStrategy(PartCleanupStrategy.never())
            .withPartNamingStrategy(PartNamingStrategy.prefix("prefix"))
            .withExecutorSupplier(ExecutorSupplier.fixedPool(5))
            .withPartMetadataFieldDecorator(
                PartMetadataFieldDecorator.setCustomTimeInFuture(Duration.ofMinutes(10)));
    ParallelCompositeUploadBlobWriteSessionConfig pcu2copy = serializeAndDeserialize(pcu2);
    assertThat(pcu2copy).isNotNull();

    PartMetadataFieldDecorator noop = PartMetadataFieldDecorator.noOp();
    PartMetadataFieldDecorator noopCopy = serializeAndDeserialize(noop);
    assertThat(noopCopy).isSameInstanceAs(noop);

    InvalidClassException invalidClassException =
        assertThrows(
            InvalidClassException.class,
            () -> {
              Executor executor = command -> {};
              ParallelCompositeUploadBlobWriteSessionConfig pcu3 =
                  BlobWriteSessionConfigs.parallelCompositeUpload()
                      .withExecutorSupplier(ExecutorSupplier.useExecutor(executor));
              // executor is not serializable, this should throw an exception
              serializeAndDeserialize(pcu3);
            });

    assertThat(invalidClassException)
        .hasMessageThat()
        .isEqualTo(
            "com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig$ExecutorSupplier$SuppliedExecutorSupplier;"
                + " Not serializable");
  }
}
