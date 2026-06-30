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

package com.google.cloud.storage;

import com.google.api.core.BetaApi;
import com.google.cloud.storage.GrpcStorageOptions.GrpcStorageDefaults;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.PartCleanupStrategy;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

/**
 * Factory class to select and construct {@link BlobWriteSessionConfig}s.
 *
 * <p>There are several strategies which can be used to upload a {@link Blob} to Google Cloud
 * Storage. This class provides factories which allow you to select the appropriate strategy for
 * your workload.
 *
 * <table>
 *   <caption>Comparison of Strategies</caption>
 *   <tr>
 *     <th>Strategy</th>
 *     <th>Factory Method(s)</th>
 *     <th>Description</th>
 *     <th>Transport(s) Supported</th>
 *     <th>Considerations</th>
 *     <th>Retry Support</th>
 *     <th>Cloud Storage API used</th>
 *   </tr>
 *   <tr>
 *     <td>Default (Chunk based upload)</td>
 *     <td>{@link #getDefault()}</td>
 *     <td>
 *       Buffer up to a configurable amount of bytes in memory, write to Cloud Storage when
 *       full or close. Buffer size is configurable via
 *       {@link DefaultBlobWriteSessionConfig#withChunkSize(int)}
 *     </td>
 *     <td>gRPC, HTTP</td>
 *     <td>The network will only be used for the following operations:
 *     <ol>
 *       <li>Creating the Resumable Upload Session</li>
 *       <li>Transmitting zero or more incremental chunks</li>
 *       <li>Transmitting the final chunk and finalizing the Resumable Upload Session</li>
 *       <li>
 *         If any of the above are interrupted with a retryable error, the Resumable Upload Session
 *         will be queried to reconcile client side state with Cloud Storage
 *       </li>
 *     </ol>
 *     </td>
 *     <td>
 *       Each chunk is retried up to the limitations specified in
 *       {@link StorageOptions#getRetrySettings()}
 *     </td>
 *     <td><a href="https://cloud.google.com/storage/docs/resumable-uploads">Resumable Upload</a></td>
 *   </tr>
 *   <tr>
 *     <td>Buffer to disk then upload</td>
 *     <td>
 *       <ul>
 *         <li>{@link #bufferToDiskThenUpload(Path)}</li>
 *         <li>{@link #bufferToDiskThenUpload(Collection) bufferToDiskThenUpload(Collection&lt;Path>)}</li>
 *         <li>{@link #bufferToTempDirThenUpload()}</li>
 *       </ul>
 *     </td>
 *     <td>
 *       Buffer bytes to a temporary file on disk. On {@link WritableByteChannel#close() close()}
 *       upload the entire files contents to Cloud Storage. Delete the temporary file.
 *     </td>
 *     <td>gRPC, HTTP</td>
 *     <td>
 *       <ol>
 *         <li>A Resumable Upload Session will be used to upload the file on disk.</li>
 *         <li>
 *           If the upload is interrupted with a retryable error, the Resumable Upload Session will
 *           be queried to restart the upload from Cloud Storage's last received byte
 *         </li>
 *       </ol>
 *     </td>
 *     <td>
 *       Upload the file in the fewest number of RPC possible retrying within the limitations
 *       specified in {@link StorageOptions#getRetrySettings()}
 *     </td>
 *     <td><a href="https://cloud.google.com/storage/docs/resumable-uploads">Resumable Upload</a></td>
 *   </tr>
 *   <tr>
 *     <td>Journal to disk while uploading</td>
 *     <td>{@link #journaling(Collection) journaling(Collection&lt;Path>)}</td>
 *     <td>
 *       Create a Resumable Upload Session, before transmitting bytes to Cloud Storage write
 *       to a recovery file on disk. If the stream to Cloud Storage is interrupted with a
 *       retryable error query the offset of the Resumable Upload Session, then open the recovery
 *       file from the offset and transmit the bytes to Cloud Storage.
 *     </td>
 *     <td>gRPC</td>
 *     <td>
 *       <ol>
 *         <li>
 *           The stream to Cloud Storage will be held open until a) the write is complete
 *           b) the stream is interrupted
 *         </li>
 *         <li>
 *           Because the bytes are journaled to disk, the upload to Cloud Storage can only
 *           be as fast as the disk.
 *         </li>
 *         <li>
 *           The use of <a href="https://cloud.google.com/compute/docs/disks/local-ssd#nvme">Compute
 *           Engine Local NVMe SSD</a> is strongly encouraged compared to Compute Engine Persistent
 *           Disk.
 *         </li>
 *       </ol>
 *     </td>
 *     <td>
 *       Opening the stream for upload will be retried up to the limitations specified in {@link StorageOptions#getRetrySettings()}
 *       All bytes are buffered to disk and allow for recovery from any arbitrary offset.
 *     </td>
 *     <td><a href="https://cloud.google.com/storage/docs/resumable-uploads">Resumable Upload</a></td>
 *   </tr>
 *   <tr>
 *     <td>Parallel Composite Upload</td>
 *     <td>{@link #parallelCompositeUpload()}</td>
 *     <td>
 *       Break the stream of bytes into smaller part objects uploading each part in parallel. Then
 *       composing the parts together to make the ultimate object.
 *     </td>
 *     <td>gRPC, HTTP</td>
 *     <td>
 *       <ol>
 *         <li>
 *           Performing parallel composite uploads costs more money.
 *           <a href="https://cloud.google.com/storage/pricing#operations-by-class">Class A</a>
 *           operations are performed to create each part and to perform each compose. If a storage
 *           tier other than
 *           <a href="https://cloud.google.com/storage/docs/storage-classes"><code>STANDARD</code></a>
 *           is used, early deletion fees apply to deletion of the parts.
 *           <p>An illustrative example. Upload a 5GiB object using 64MiB as the max size per part.
 *           <ol>
 *             <li>80 Parts will be created (Class A)</li>
 *             <li>3 compose calls will be performed (Class A)</li>
 *             <li>Delete 80 Parts along with 2 intermediary Compose objects (Free tier as long as {@code STANDARD} class)</li>
 *           </ol>
 *
 *           Once the parts and intermediary compose objects are deleted, there will be no storage charges related to those temporary objects.
 *         </li>
 *         <li>
 *           The service account/credentials used to perform the parallel composite upload require
 *           <a href="https://cloud.google.com/storage/docs/access-control/iam-permissions#object_permissions">{@code storage.objects.delete}</a>
 *           in order to cleanup the temporary part and intermediary compose objects.
 *           <p><i>To handle handle part and intermediary compose object deletion out of band</i>
 *           passing {@link PartCleanupStrategy#never()} to {@link ParallelCompositeUploadBlobWriteSessionConfig#withPartCleanupStrategy(PartCleanupStrategy)}
 *           will prevent automatic cleanup.
 *         </li>
 *         <li>
 *           Please see the <a href="https://cloud.google.com/storage/docs/parallel-composite-uploads">
 *           Parallel composite uploads</a> documentation for a more in depth explanation of the
 *           limitations of Parallel composite uploads.
 *         </li>
 *         <li>
 *           A failed upload can leave part and intermediary compose objects behind which will count
 *           as storage usage, and you will be billed for it.
 *           <p>By default if an upload fails, an attempt to cleanup the part and intermediary compose
 *           will be made. However if the program were to crash there is no means for the client to
 *           perform the cleanup.
 *           <p>Every part and intermediary compose object will be created with a name which ends in
 *           {@code .part}. An Object Lifecycle Management rule can be setup on your bucket to automatically
 *           cleanup objects with the suffix after some period of time. See
 *           <a href="https://cloud.google.com/storage/docs/lifecycle">Object Lifecycle Management</a>
 *           for full details and a guide on how to setup a <a href="https://cloud.google.com/storage/docs/lifecycle#delete">Delete</a>
 *           rule with a <a href="https://cloud.google.com/storage/docs/lifecycle#matchesprefix-suffix">suffix match</a> condition.
 *         </li>
 *         <li>
 *           Using parallel composite uploads are not a one size fits all solution. They have very
 *           real overhead until uploading a large enough object. The inflection point is dependent
 *           upon many factors, and there is no one size fits all value. You will need to experiment
 *           with your deployment and workload to determine if parallel composite uploads are useful
 *           to you.
 *         </li>
 *       </ol>
 *     </td>
 *     <td>
 *       Automatic retires will be applied for the following:
 *       <ol>
 *         <li>Creation of each individual part</li>
 *         <li>Performing an intermediary compose</li>
 *         <li>Performing a delete to cleanup each part and intermediary compose object</li>
 *       </ol>
 *
 *       Retrying the creation of the final object is contingent upon if an appropriate precondition
 *       is supplied when calling {@link Storage#blobWriteSession(BlobInfo, BlobWriteOption...)}.
 *       Either {@link BlobTargetOption#doesNotExist()} or {@link Storage.BlobTargetOption#generationMatch(long)}
 *       should be specified in order to make the final request idempotent.
 *       <p>Each operation will be retried up to the limitations specified in {@link StorageOptions#getRetrySettings()}
 *     </td>
 *     <td>
 *       <ul>
 *         <li><a href="https://cloud.google.com/storage/docs/parallel-composite-uploads">Parallel composite uploads</a></li>
 *         <li><a href="https://cloud.google.com/storage/docs/uploading-objects-from-memory">Direct uploads</a></li>
 *         <li><a href="https://cloud.google.com/storage/docs/composite-objects">Compose</a></li>
 *         <li><a href="https://cloud.google.com/storage/docs/deleting-objects">Object delete</a></li>
 *       </ul>
 *     </td>
 *   </tr>
 * </table>
 *
 * @see BlobWriteSessionConfig
 * @see GrpcStorageOptions.Builder#setBlobWriteSessionConfig(BlobWriteSessionConfig)
 * @see Storage#blobWriteSession(BlobInfo, BlobWriteOption...)
 * @since 2.26.0 This new api is in preview and is subject to breaking changes.
 */
@BetaApi
public final class BlobWriteSessionConfigs {

  private BlobWriteSessionConfigs() {}

  /**
   * Factory to produce the default configuration for uploading an object to Cloud Storage.
   *
   * <p>Configuration of the chunk size can be performed via {@link
   * DefaultBlobWriteSessionConfig#withChunkSize(int)}.
   *
   * @see GrpcStorageDefaults#getDefaultStorageWriterConfig()
   * @since 2.26.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  @TransportCompatibility({Transport.GRPC, Transport.HTTP})
  public static DefaultBlobWriteSessionConfig getDefault() {
    return new DefaultBlobWriteSessionConfig(ByteSizeConstants._16MiB);
  }

  /**
   * Factory to produce a resumable upload using a bi-directional stream. This should provide a
   * small performance increase compared to a regular resumable upload.
   *
   * <p>Configuration of the buffer size can be performed via {@link
   * BidiBlobWriteSessionConfig#withBufferSize(int)}.
   *
   * @since 2.34.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  @TransportCompatibility({Transport.GRPC})
  public static BidiBlobWriteSessionConfig bidiWrite() {
    return new BidiBlobWriteSessionConfig(ByteSizeConstants._16MiB);
  }

  /**
   * Create a new {@link BlobWriteSessionConfig} which will first buffer the content of the object
   * to a temporary file under {@code java.io.tmpdir}.
   *
   * <p>Once the file on disk is closed, the entire file will then be uploaded to Cloud Storage.
   *
   * @see Storage#blobWriteSession(BlobInfo, BlobWriteOption...)
   * @see GrpcStorageOptions.Builder#setBlobWriteSessionConfig(BlobWriteSessionConfig)
   * @since 2.26.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  @TransportCompatibility({Transport.GRPC, Transport.HTTP})
  public static BlobWriteSessionConfig bufferToTempDirThenUpload() throws IOException {
    return bufferToDiskThenUpload(
        Paths.get(System.getProperty("java.io.tmpdir"), "google-cloud-storage"));
  }

  /**
   * Create a new {@link BlobWriteSessionConfig} which will first buffer the content of the object
   * to a temporary file under the specified {@code path}.
   *
   * <p>Once the file on disk is closed, the entire file will then be uploaded to Cloud Storage.
   *
   * @see Storage#blobWriteSession(BlobInfo, BlobWriteOption...)
   * @see GrpcStorageOptions.Builder#setBlobWriteSessionConfig(BlobWriteSessionConfig)
   * @since 2.26.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  @TransportCompatibility({Transport.GRPC, Transport.HTTP})
  public static BufferToDiskThenUpload bufferToDiskThenUpload(Path path) throws IOException {
    return bufferToDiskThenUpload(ImmutableList.of(path));
  }

  /**
   * Create a new {@link BlobWriteSessionConfig} which will first buffer the content of the object
   * to a temporary file under one of the specified {@code paths}.
   *
   * <p>Once the file on disk is closed, the entire file will then be uploaded to Cloud Storage.
   *
   * <p>The specifics of how the work is spread across multiple paths is undefined and subject to
   * change.
   *
   * @see Storage#blobWriteSession(BlobInfo, BlobWriteOption...)
   * @see GrpcStorageOptions.Builder#setBlobWriteSessionConfig(BlobWriteSessionConfig)
   * @since 2.26.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  @TransportCompatibility({Transport.GRPC, Transport.HTTP})
  public static BufferToDiskThenUpload bufferToDiskThenUpload(Collection<Path> paths)
      throws IOException {
    return new BufferToDiskThenUpload(ImmutableList.copyOf(paths), false);
  }

  /**
   * Create a new {@link BlobWriteSessionConfig} which will journal writes to a temporary file under
   * one of the specified {@code paths} before transmitting the bytes to Cloud Storage.
   *
   * <p>The specifics of how the work is spread across multiple paths is undefined and subject to
   * change.
   *
   * @see Storage#blobWriteSession(BlobInfo, BlobWriteOption...)
   * @see GrpcStorageOptions.Builder#setBlobWriteSessionConfig(BlobWriteSessionConfig)
   * @since 2.27.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  @TransportCompatibility(Transport.GRPC)
  public static JournalingBlobWriteSessionConfig journaling(Collection<Path> paths) {
    return new JournalingBlobWriteSessionConfig(ImmutableList.copyOf(paths), false);
  }

  /**
   * Create a new {@link BlobWriteSessionConfig} which will perform a <a
   * href="https://cloud.google.com/storage/docs/parallel-composite-uploads">Parallel Composite
   * Upload</a> by breaking the stream into parts and composing the parts together to make the
   * ultimate object.
   *
   * @see Storage#blobWriteSession(BlobInfo, BlobWriteOption...)
   * @see GrpcStorageOptions.Builder#setBlobWriteSessionConfig(BlobWriteSessionConfig)
   * @since 2.28.0 This new api is in preview and is subject to breaking changes.
   */
  @BetaApi
  @TransportCompatibility({Transport.GRPC, Transport.HTTP})
  public static ParallelCompositeUploadBlobWriteSessionConfig parallelCompositeUpload() {
    return ParallelCompositeUploadBlobWriteSessionConfig.withDefaults();
  }
}
