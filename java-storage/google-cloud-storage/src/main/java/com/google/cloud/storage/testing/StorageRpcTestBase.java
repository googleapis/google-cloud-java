/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.storage.testing;

import com.google.api.services.storage.Storage;
import com.google.api.services.storage.model.Bucket;
import com.google.api.services.storage.model.BucketAccessControl;
import com.google.api.services.storage.model.HmacKey;
import com.google.api.services.storage.model.HmacKeyMetadata;
import com.google.api.services.storage.model.Notification;
import com.google.api.services.storage.model.ObjectAccessControl;
import com.google.api.services.storage.model.Policy;
import com.google.api.services.storage.model.ServiceAccount;
import com.google.api.services.storage.model.StorageObject;
import com.google.api.services.storage.model.TestIamPermissionsResponse;
import com.google.cloud.Tuple;
import com.google.cloud.storage.spi.v1.RpcBatch;
import com.google.cloud.storage.spi.v1.StorageRpc;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * A stub implementation of {@link StorageRpc} which can be used outside of the Storage module for
 * testing purposes. All the methods throw an {@code UnsupportedOperationException}.
 */
public class StorageRpcTestBase implements StorageRpc {

  @Override
  public Bucket create(Bucket bucket, Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public StorageObject create(StorageObject object, InputStream content, Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public Tuple<String, Iterable<Bucket>> list(Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public Tuple<String, Iterable<StorageObject>> list(String bucket, Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public Bucket get(Bucket bucket, Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public StorageObject get(StorageObject object, Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public StorageObject restore(StorageObject object, Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public Bucket patch(Bucket bucket, Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public StorageObject patch(StorageObject storageObject, Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public boolean delete(Bucket bucket, Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public boolean delete(StorageObject object, Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public RpcBatch createBatch() {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public StorageObject compose(
      Iterable<StorageObject> sources, StorageObject target, Map<Option, ?> targetOptions) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public byte[] load(StorageObject storageObject, Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public Tuple<String, byte[]> read(
      StorageObject from, Map<Option, ?> options, long position, int bytes) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public long read(
      StorageObject from, Map<Option, ?> options, long position, OutputStream outputStream) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public String open(StorageObject object, Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public String open(String signedURL) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public void write(
      String uploadId,
      byte[] toWrite,
      int toWriteOffset,
      long destOffset,
      int length,
      boolean last) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public long getCurrentUploadOffset(String uploadId) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public StorageObject queryCompletedResumableUpload(String uploadId, long totalBytes) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public StorageObject writeWithResponse(
      String uploadId,
      byte[] toWrite,
      int toWriteOffset,
      long destOffset,
      int length,
      boolean last) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public RewriteResponse openRewrite(RewriteRequest rewriteRequest) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public RewriteResponse continueRewrite(RewriteResponse previousResponse) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public BucketAccessControl getAcl(String bucket, String entity, Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public boolean deleteAcl(String bucket, String entity, Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public BucketAccessControl createAcl(BucketAccessControl acl, Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public BucketAccessControl patchAcl(BucketAccessControl acl, Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public List<BucketAccessControl> listAcls(String bucket, Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public ObjectAccessControl getDefaultAcl(String bucket, String entity) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public boolean deleteDefaultAcl(String bucket, String entity) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public ObjectAccessControl createDefaultAcl(ObjectAccessControl acl) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public ObjectAccessControl patchDefaultAcl(ObjectAccessControl acl) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public List<ObjectAccessControl> listDefaultAcls(String bucket) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public ObjectAccessControl getAcl(String bucket, String object, Long generation, String entity) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public boolean deleteAcl(String bucket, String object, Long generation, String entity) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public ObjectAccessControl createAcl(ObjectAccessControl acl) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public ObjectAccessControl patchAcl(ObjectAccessControl acl) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public List<ObjectAccessControl> listAcls(String bucket, String object, Long generation) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public HmacKey createHmacKey(String serviceAccountEmail, Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public Tuple<String, Iterable<HmacKeyMetadata>> listHmacKeys(Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public HmacKeyMetadata updateHmacKey(HmacKeyMetadata hmacKeyMetadata, Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public HmacKeyMetadata getHmacKey(String accessId, Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public void deleteHmacKey(HmacKeyMetadata hmacKeyMetadata, Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public Policy getIamPolicy(String bucket, Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public Policy setIamPolicy(String bucket, Policy policy, Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public TestIamPermissionsResponse testIamPermissions(
      String bucket, List<String> permissions, Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public boolean deleteNotification(String bucket, String id) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public List<Notification> listNotifications(String bucket) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public Notification createNotification(String bucket, Notification notification) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public Notification getNotification(String bucket, String id) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public Bucket lockRetentionPolicy(Bucket bucket, Map<Option, ?> options) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public ServiceAccount getServiceAccount(String projectId) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public StorageObject moveObject(
      String bucket,
      String sourceObject,
      String destinationObject,
      Map<Option, ?> sourceOptions,
      Map<Option, ?> targetOptions) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public Storage getStorage() {
    throw new UnsupportedOperationException("Not implemented yet");
  }
}
