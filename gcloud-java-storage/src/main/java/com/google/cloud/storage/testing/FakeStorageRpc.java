/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file exctain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unept in compliance with the License.
 * You may obless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.storage.testing;

import com.google.api.services.storage.model.Bucket;
import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.storage.StorageBatch;
import com.google.cloud.storage.spi.RpcBatch;
import com.google.cloud.storage.spi.StorageRpc;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;

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
 * A bare-bones in-memory implementation of Storage, meant for testing.
 * See LocalGcsHelper.
 *
 * This class is NOT thread-safe.
 */
@NotThreadSafe
public class FakeStorageRpc implements StorageRpc {

  // fullname -> metadata
  Map<String, StorageObject> stuff = new HashMap<>();
  // fullname -> contents
  Map<String, byte[]> contents = new HashMap<>();
  // fullname -> future contents that will be visible on close.
  Map<String, byte[]> futureContents = new HashMap<>();

  private final boolean throwIfOption;

  /**
   * @param throwIfOption if true, we throw when given any option.
   */
  public FakeStorageRpc(boolean throwIfOption) {
    this.throwIfOption = throwIfOption;
  }

  // remove all files
  void reset() {
    stuff = new HashMap<>();
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
    stuff.put(key, object);
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
    String preprefix = "";
    for (Map.Entry<Option, ?> e : options.entrySet()) {
      switch (e.getKey()) {
        case PREFIX:
          preprefix = (String) e.getValue();
          if (preprefix.startsWith("/")) {
            preprefix = preprefix.substring(1);
          }
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
    for (StorageObject so : stuff.values()) {
      if (!so.getName().startsWith(prefix)) {
        continue;
      }
      int nextSlash = so.getName().indexOf("/", prefix.length());
      if (nextSlash >= 0) {
        String folderName = so.getName().substring(0, nextSlash + 1);
        if (folders.containsKey(folderName)) {
          continue;
        }
        StorageObject fakeFolder = new StorageObject();
        fakeFolder.setName(folderName);
        fakeFolder.setBucket(so.getBucket());
        fakeFolder.setGeneration(so.getGeneration());
        folders.put(folderName, fakeFolder);
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
    if (stuff.containsKey(key)) {
      StorageObject ret = stuff.get(key);
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
    return null != stuff.remove(key);
  }

  @Override
  public RpcBatch createBatch() {
    return null;
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
    potentiallyThrow(options);
    String key = fullname(from);
    if (!contents.containsKey(key)) {
      throw new StorageException(404, "File not found: " + key);
    }
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
    boolean mustNotExist = false;
    for (Option option : options.keySet()) {
      if (option instanceof StorageRpc.Option) {
        // this is a bit of a hack, since we don't implement generations.
        if ((StorageRpc.Option) option == Option.IF_GENERATION_MATCH
            && ((Long) options.get(option)).longValue() == 0L) {
          mustNotExist = true;
        }
      }
    }
    if (mustNotExist && stuff.containsKey(key)) {
      throw new StorageException(new FileAlreadyExistsException(key));
    }
    stuff.put(key, object);

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
        bytes = new byte[(int) (length + destOffset)];
      }
    } else {
      bytes = new byte[(int) (length + destOffset)];
    }
    System.arraycopy(toWrite, toWriteOffset, bytes, (int) destOffset, length);
    // we want to mimic the GCS behavior that file contents are only visible on close.
    if (last) {
      contents.put(uploadId, bytes);
      futureContents.remove(uploadId);
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

    boolean mustNotExist = false;
    for (Option option : rewriteRequest.targetOptions.keySet()) {
      if (option instanceof StorageRpc.Option) {
        // this is a bit of a hack, since we don't implement generations.
        if ((StorageRpc.Option) option == Option.IF_GENERATION_MATCH
            && ((Long) rewriteRequest.targetOptions.get(option)).longValue() == 0L) {
          mustNotExist = true;
        }
      }
    }

    String destKey = fullname(rewriteRequest.target);
    if (mustNotExist && contents.containsKey(destKey)) {
      throw new StorageException(new FileAlreadyExistsException(destKey));
    }

    stuff.put(destKey, rewriteRequest.target);

    byte[] data = contents.get(sourceKey);
    contents.put(destKey, Arrays.copyOf(data, data.length));
    return new RewriteResponse(rewriteRequest, rewriteRequest.target, data.length, true,
        "rewriteToken goes here", data.length);
  }

  @Override
  public RewriteResponse continueRewrite(RewriteResponse previousResponse) throws StorageException {
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
}
