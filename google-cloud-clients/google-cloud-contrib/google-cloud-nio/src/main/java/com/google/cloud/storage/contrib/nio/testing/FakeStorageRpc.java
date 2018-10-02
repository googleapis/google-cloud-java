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

package com.google.cloud.storage.contrib.nio.testing;

import com.google.api.services.storage.model.Bucket;
import com.google.api.services.storage.model.BucketAccessControl;
import com.google.api.services.storage.model.Notification;
import com.google.api.services.storage.model.ObjectAccessControl;
import com.google.api.services.storage.model.Policy;
import com.google.api.services.storage.model.ServiceAccount;
import com.google.api.services.storage.model.StorageObject;
import com.google.api.services.storage.model.TestIamPermissionsResponse;
import com.google.cloud.Tuple;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.spi.v1.RpcBatch;
import com.google.cloud.storage.spi.v1.StorageRpc;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * A bare-bones in-memory implementation of StorageRpc, meant for testing.
 *
 * <p>This class is <i>not</i> thread-safe. It's also (currently) limited in the following ways:
 * <ul>
 * <li>Supported
 *   <ul>
 *   <li>object create
 *   <li>object get
 *   <li>object delete
 *   <li>list the contents of a bucket
 *   <li>generations
 *   </ul>
 * <li>Unsupported
 *   <ul>
 *   <li>bucket create
 *   <li>bucket get
 *   <li>bucket delete
 *   <li>list all buckets
 *   <li>file attributes
 *   <li>patch
 *   <li>continueRewrite
 *   <li>createBatch
 *   <li>checksums, etags
 *   <li>IAM operations</li>
 *   <li>BucketLock operations</li>
 *   </ul>
 * </ul>
 */
@NotThreadSafe
class FakeStorageRpc implements StorageRpc {

  // fullname -> metadata
  Map<String, StorageObject> metadata = new HashMap<>();
  // fullname -> contents
  Map<String, byte[]> contents = new HashMap<>();
  // fullname -> future contents that will be visible on close.
  Map<String, byte[]> futureContents = new HashMap<>();

  private final boolean throwIfOption;

  /**
   * @param throwIfOption if true, we throw when given any option
   */
  public FakeStorageRpc(boolean throwIfOption) {
    this.throwIfOption = throwIfOption;
  }

  // remove all files
  void reset() {
    metadata = new HashMap<>();
    contents = new HashMap<>();
  }

  @Override
  public Bucket create(Bucket bucket, Map<Option, ?> options) throws StorageException {
    throw new UnsupportedOperationException();
  }

  @Override
  public StorageObject create(StorageObject object, InputStream content, Map<Option, ?> options)
      throws StorageException {
    potentiallyThrow(options);
    String key = fullname(object);
    metadata.put(key, object);
    try {
      contents.put(key, com.google.common.io.ByteStreams.toByteArray(content));
    } catch (IOException e) {
      throw new StorageException(e);
    }
    // TODO: crc, etc
    return object;
  }

  @Override
  public Tuple<String, Iterable<Bucket>> list(Map<Option, ?> options) throws StorageException {
    throw new UnsupportedOperationException();
  }

  @Override
  public Tuple<String, Iterable<StorageObject>> list(String bucket, Map<Option, ?> options)
      throws StorageException {
    String delimiter = null;
    String preprefix = "";
    for (Map.Entry<Option, ?> e : options.entrySet()) {
      switch (e.getKey()) {
        case PREFIX:
          preprefix = (String) e.getValue();
          if (preprefix.startsWith("/")) {
            preprefix = preprefix.substring(1);
          }
          break;
        case DELIMITER:
          delimiter = (String) e.getValue();
          break;
        case FIELDS:
          // ignore and return all the fields
          break;
        default:
          throw new UnsupportedOperationException("Unknown option: " + e.getKey());
      }
    }
    final String prefix = preprefix;

    List<StorageObject> values = new ArrayList<>();
    Map<String, StorageObject> folders = new HashMap<>();
    for (StorageObject so : metadata.values()) {
      if (!so.getName().startsWith(prefix)) {
        continue;
      }
      if (processedAsFolder(so, delimiter, prefix, folders)) {
        continue;
      }
      values.add(so);
    }
    values.addAll(folders.values());
    // null cursor to indicate there is no more data (empty string would cause us to be called again).
    // The type cast seems to be necessary to help Java's typesystem remember that collections are iterable.
    return Tuple.of(null, (Iterable<StorageObject>) values);
  }

  /**
   * Returns the requested bucket or {@code null} if not found.
   */
  @Override
  public Bucket get(Bucket bucket, Map<Option, ?> options) throws StorageException {
    potentiallyThrow(options);
    return null;
  }

  /**
   * Returns the requested storage object or {@code null} if not found.
   */
  @Override
  public StorageObject get(StorageObject object, Map<Option, ?> options) throws StorageException {
    // we allow the "ID" option because we need to, but then we give a whole answer anyways
    // because the caller won't mind the extra fields.
    if (throwIfOption && !options.isEmpty() && options.size() > 1
        && options.keySet().toArray()[0] != Storage.BlobGetOption.fields(Storage.BlobField.ID)) {
      throw new UnsupportedOperationException();
    }

    String key = fullname(object);
    if (metadata.containsKey(key)) {
      StorageObject ret = metadata.get(key);
      if (contents.containsKey(key)) {
        ret.setSize(BigInteger.valueOf(contents.get(key).length));
      }
      ret.setId(key);

      return ret;
    }
    return null;
  }

  @Override
  public Bucket patch(Bucket bucket, Map<Option, ?> options) throws StorageException {
    potentiallyThrow(options);
    return null;
  }

  @Override
  public StorageObject patch(StorageObject storageObject, Map<Option, ?> options)
      throws StorageException {
    potentiallyThrow(options);
    return null;
  }

  @Override
  public boolean delete(Bucket bucket, Map<Option, ?> options) throws StorageException {
    return false;
  }

  @Override
  public boolean delete(StorageObject object, Map<Option, ?> options) throws StorageException {
    String key = fullname(object);
    contents.remove(key);
    return null != metadata.remove(key);
  }

  @Override
  public RpcBatch createBatch() {
    //return new DefaultRpcBatch(storage);
    throw new UnsupportedOperationException();
  }

  @Override
  public StorageObject compose(Iterable<StorageObject> sources, StorageObject target,
                               Map<Option, ?> targetOptions) throws StorageException {
    return null;
  }

  @Override
  public byte[] load(StorageObject storageObject, Map<Option, ?> options) throws StorageException {
    String key = fullname(storageObject);
    if (!contents.containsKey(key)) {
      throw new StorageException(404, "File not found: " + key);
    }
    return contents.get(key);
  }

  @Override
  public Tuple<String, byte[]> read(
      StorageObject from, Map<Option, ?> options, long zposition, int zbytes)
      throws StorageException {
    // if non-null, then we check the file's at that generation.
    Long generationMatch = null;
    for (Option op : options.keySet()) {
      if (op.equals(StorageRpc.Option.IF_GENERATION_MATCH)) {
        generationMatch = (Long)options.get(op);
      } else {
        throw new UnsupportedOperationException("Unknown option: " + op);
      }
    }
    String key = fullname(from);
    if (!contents.containsKey(key)) {
      throw new StorageException(404, "File not found: " + key);
    }
    checkGeneration(key, generationMatch);
    long position = zposition;
    int bytes = zbytes;
    if (position < 0) {
      position = 0;
    }
    byte[] full = contents.get(key);
    if ((int) position + bytes > full.length) {
      bytes = full.length - (int) position;
    }
    if (bytes <= 0) {
      // special case: you're trying to read past the end
      return Tuple.of("etag-goes-here", new byte[0]);
    }
    byte[] ret = new byte[bytes];
    System.arraycopy(full, (int) position, ret, 0, bytes);
    return Tuple.of("etag-goes-here", ret);
  }

  @Override
  public String open(StorageObject object, Map<Option, ?> options) throws StorageException {
    String key = fullname(object);
    // if non-null, then we check the file's at that generation.
    Long generationMatch = null;
    for (Option option : options.keySet()) {
      // this is a bit of a hack, since we don't implement generations.
      if (option == Option.IF_GENERATION_MATCH) {
        generationMatch = (Long) options.get(option);
      }
    }
    checkGeneration(key, generationMatch);
    metadata.put(key, object);

    return fullname(object);
  }

  @Override
  public void write(String uploadId, byte[] toWrite, int toWriteOffset, long destOffset,
                    int length, boolean last) throws StorageException {
    // this may have a lot more allocations than ideal, but it'll work.
    byte[] bytes;
    if (futureContents.containsKey(uploadId)) {
      bytes = futureContents.get(uploadId);
      if (bytes.length < length + destOffset) {
        byte[] newBytes = new byte[(int) (length + destOffset)];
        System.arraycopy(bytes, 0, newBytes, (int) 0, bytes.length);
        bytes = newBytes;
      }
    } else {
      bytes = new byte[(int) (length + destOffset)];
    }
    System.arraycopy(toWrite, toWriteOffset, bytes, (int) destOffset, length);
    // we want to mimic the GCS behavior that file contents are only visible on close.
    if (last) {
      contents.put(uploadId, bytes);
      futureContents.remove(uploadId);
      if (metadata.containsKey(uploadId)) {
        StorageObject storageObject = metadata.get(uploadId);
        Long generation = storageObject.getGeneration();
        if (null == generation) {
          generation = Long.valueOf(0);
        }
        storageObject.setGeneration(++generation);
        metadata.put(uploadId, storageObject);
      }
    } else {
      futureContents.put(uploadId, bytes);
    }
  }

  @Override
  public RewriteResponse openRewrite(RewriteRequest rewriteRequest) throws StorageException {
    String sourceKey = fullname(rewriteRequest.source);

    // a little hackish, just good enough for the tests to work.
    if (!contents.containsKey(sourceKey)) {
      throw new StorageException(404, "File not found: " + sourceKey);
    }

    // if non-null, then we check the file's at that generation.
    Long generationMatch = null;
    for (Option option : rewriteRequest.targetOptions.keySet()) {
      // this is a bit of a hack, since we don't implement generations.
      if (option == Option.IF_GENERATION_MATCH) {
        generationMatch = (Long) rewriteRequest.targetOptions.get(option);
      }
    }

    String destKey = fullname(rewriteRequest.target);

    checkGeneration(destKey, generationMatch);

    metadata.put(destKey, rewriteRequest.target);

    byte[] data = contents.get(sourceKey);
    contents.put(destKey, Arrays.copyOf(data, data.length));
    return new RewriteResponse(rewriteRequest, rewriteRequest.target, data.length, true,
        "rewriteToken goes here", data.length);
  }

  @Override
  public RewriteResponse continueRewrite(RewriteResponse previousResponse) throws StorageException {
    throw new UnsupportedOperationException();
  }

  @Override
  public BucketAccessControl getAcl(String bucket, String entity, Map<Option, ?> options) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean deleteAcl(String bucket, String entity, Map<Option, ?> options) {
    throw new UnsupportedOperationException();
  }

  @Override
  public BucketAccessControl createAcl(BucketAccessControl acl, Map<Option, ?> options) {
    throw new UnsupportedOperationException();
  }

  @Override
  public BucketAccessControl patchAcl(BucketAccessControl acl, Map<Option, ?> options) {
    throw new UnsupportedOperationException();
  }

  @Override
  public List<BucketAccessControl> listAcls(String bucket, Map<Option, ?> options) {
    throw new UnsupportedOperationException();
  }

  @Override
  public ObjectAccessControl getDefaultAcl(String bucket, String entity) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean deleteDefaultAcl(String bucket, String entity) {
    throw new UnsupportedOperationException();
  }

  @Override
  public ObjectAccessControl createDefaultAcl(ObjectAccessControl acl) {
    throw new UnsupportedOperationException();
  }

  @Override
  public ObjectAccessControl patchDefaultAcl(ObjectAccessControl acl) {
    throw new UnsupportedOperationException();
  }

  @Override
  public List<ObjectAccessControl> listDefaultAcls(String bucket) {
    throw new UnsupportedOperationException();
  }

  @Override
  public ObjectAccessControl getAcl(String bucket, String object, Long generation, String entity) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean deleteAcl(String bucket, String object, Long generation, String entity) {
    throw new UnsupportedOperationException();
  }

  @Override
  public ObjectAccessControl createAcl(ObjectAccessControl acl) {
    throw new UnsupportedOperationException();
  }

  @Override
  public ObjectAccessControl patchAcl(ObjectAccessControl acl) {
    throw new UnsupportedOperationException();
  }

  @Override
  public List<ObjectAccessControl> listAcls(String bucket, String object, Long generation) {
    throw new UnsupportedOperationException();
  }

  private String fullname(StorageObject so) {
    return (so.getBucket() + "/" + so.getName());
  }

  private void potentiallyThrow(Map<Option, ?> options) throws UnsupportedOperationException {
    if (throwIfOption && !options.isEmpty()) {
      throw new UnsupportedOperationException();
    }
  }

  /**
   * Throw if we're asking for generation 0 and the file exists,
   * or if the requested generation number doesn't match what is asked.
   *
   * @param key
   * @param generationMatch
   */
  private void checkGeneration(String key, Long generationMatch) {
    if (null == generationMatch) {
      return;
    }
    if (generationMatch == 0 && metadata.containsKey(key)) {
      throw new StorageException(new FileAlreadyExistsException(key));
    }
    if (generationMatch != 0) {
      Long generation = metadata.get(key).getGeneration();
      if (!generationMatch.equals(generation)) {
        throw new StorageException(404, "Generation mismatch. Requested " + generationMatch + " but got " + generation);
      }
    }
  }

  // Returns true if this is a folder. Adds it to folders if it isn't already there.
  private static boolean processedAsFolder(StorageObject so, String delimiter, String prefix, /* inout */ Map<String, StorageObject> folders) {
    if (delimiter == null) {
      return false;
    }
    int nextSlash = so.getName().indexOf(delimiter, prefix.length());
    if (nextSlash < 0) {
      return false;
    }
    String folderName = so.getName().substring(0, nextSlash + 1);
    if (folders.containsKey(folderName)) {
      return true;
    }
    StorageObject fakeFolder = new StorageObject();
    fakeFolder.setName(folderName);
    fakeFolder.setBucket(so.getBucket());
    fakeFolder.setGeneration(so.getGeneration());
    folders.put(folderName, fakeFolder);
    return true;
  }

  @Override
  public Policy getIamPolicy(String bucket, Map<Option, ?> options) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Policy setIamPolicy(String bucket, Policy policy, Map<Option, ?> options) {
    throw new UnsupportedOperationException();
  }

  @Override
  public TestIamPermissionsResponse testIamPermissions(String bucket, List<String> permissions, Map<Option, ?> options) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean deleteNotification(String bucket, String notification) {
    throw new UnsupportedOperationException();
  }

  @Override
  public List<Notification> listNotifications(String bucket) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Notification createNotification(String bucket, Notification notification) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Bucket lockRetentionPolicy(Bucket bucket, Map<Option, ?> options) {
    throw new UnsupportedOperationException();
  }

  @Override
  public ServiceAccount getServiceAccount(String projectId) {
    return null;
  }
}
