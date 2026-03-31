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

package com.google.cloud.storage.it.runner.registry;

import com.google.api.core.ApiFuture;
import com.google.api.gax.paging.Page;
import com.google.cloud.Policy;
import com.google.cloud.ReadChannel;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Acl.Entity;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobAppendableUpload;
import com.google.cloud.storage.BlobAppendableUploadConfig;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BlobReadSession;
import com.google.cloud.storage.BlobWriteSession;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.CopyWriter;
import com.google.cloud.storage.HmacKey;
import com.google.cloud.storage.HmacKey.HmacKeyMetadata;
import com.google.cloud.storage.HmacKey.HmacKeyState;
import com.google.cloud.storage.Notification;
import com.google.cloud.storage.NotificationInfo;
import com.google.cloud.storage.PostPolicyV4;
import com.google.cloud.storage.PostPolicyV4.PostConditionsV4;
import com.google.cloud.storage.PostPolicyV4.PostFieldsV4;
import com.google.cloud.storage.ServiceAccount;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageBatch;
import com.google.cloud.storage.StorageOptions;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Define a simplistic class which implements {@link Storage} while also delegating all calls to an
 * underlying instance of {@link Storage}. When this class is extended it can then override
 * individual methods rather than the entire Storage interface.
 */
abstract class AbstractStorageProxy implements Storage {

  protected final Storage delegate;

  protected AbstractStorageProxy(Storage delegate) {
    this.delegate = delegate;
  }

  @Override
  public Bucket create(BucketInfo bucketInfo, BucketTargetOption... options) {
    return delegate.create(bucketInfo, options);
  }

  @Override
  public Blob create(BlobInfo blobInfo, BlobTargetOption... options) {
    return delegate.create(blobInfo, options);
  }

  @Override
  public Blob create(BlobInfo blobInfo, byte[] content, BlobTargetOption... options) {
    return delegate.create(blobInfo, content, options);
  }

  @Override
  public Blob create(
      BlobInfo blobInfo, byte[] content, int offset, int length, BlobTargetOption... options) {
    return delegate.create(blobInfo, content, offset, length, options);
  }

  @Override
  @Deprecated
  public Blob create(BlobInfo blobInfo, InputStream content, BlobWriteOption... options) {
    return delegate.create(blobInfo, content, options);
  }

  @Override
  public Blob createFrom(BlobInfo blobInfo, Path path, BlobWriteOption... options)
      throws IOException {
    return delegate.createFrom(blobInfo, path, options);
  }

  @Override
  public Blob createFrom(BlobInfo blobInfo, Path path, int bufferSize, BlobWriteOption... options)
      throws IOException {
    return delegate.createFrom(blobInfo, path, bufferSize, options);
  }

  @Override
  public Blob createFrom(BlobInfo blobInfo, InputStream content, BlobWriteOption... options)
      throws IOException {
    return delegate.createFrom(blobInfo, content, options);
  }

  @Override
  public Blob createFrom(
      BlobInfo blobInfo, InputStream content, int bufferSize, BlobWriteOption... options)
      throws IOException {
    return delegate.createFrom(blobInfo, content, bufferSize, options);
  }

  @Override
  public Bucket get(String bucket, BucketGetOption... options) {
    return delegate.get(bucket, options);
  }

  @Override
  public Bucket lockRetentionPolicy(BucketInfo bucket, BucketTargetOption... options) {
    return delegate.lockRetentionPolicy(bucket, options);
  }

  @Override
  public Blob get(String bucket, String blob, BlobGetOption... options) {
    return delegate.get(bucket, blob, options);
  }

  @Override
  public Blob get(BlobId blob, BlobGetOption... options) {
    return delegate.get(blob, options);
  }

  @Override
  public Blob get(BlobId blob) {
    return delegate.get(blob);
  }

  @Override
  public Blob restore(BlobId blob, BlobRestoreOption... options) {
    return delegate.restore(blob, options);
  }

  @Override
  public Page<Bucket> list(BucketListOption... options) {
    return delegate.list(options);
  }

  @Override
  public Page<Blob> list(String bucket, BlobListOption... options) {
    return delegate.list(bucket, options);
  }

  @Override
  public Bucket update(BucketInfo bucketInfo, BucketTargetOption... options) {
    return delegate.update(bucketInfo, options);
  }

  @Override
  public Blob update(BlobInfo blobInfo, BlobTargetOption... options) {
    return delegate.update(blobInfo, options);
  }

  @Override
  public Blob update(BlobInfo blobInfo) {
    return delegate.update(blobInfo);
  }

  @Override
  public boolean delete(String bucket, BucketSourceOption... options) {
    return delegate.delete(bucket, options);
  }

  @Override
  public boolean delete(String bucket, String blob, BlobSourceOption... options) {
    return delegate.delete(bucket, blob, options);
  }

  @Override
  public boolean delete(BlobId blob, BlobSourceOption... options) {
    return delegate.delete(blob, options);
  }

  @Override
  public boolean delete(BlobId blob) {
    return delegate.delete(blob);
  }

  @Override
  public Blob compose(ComposeRequest composeRequest) {
    return delegate.compose(composeRequest);
  }

  @Override
  public CopyWriter copy(CopyRequest copyRequest) {
    return delegate.copy(copyRequest);
  }

  @Override
  public byte[] readAllBytes(String bucket, String blob, BlobSourceOption... options) {
    return delegate.readAllBytes(bucket, blob, options);
  }

  @Override
  public byte[] readAllBytes(BlobId blob, BlobSourceOption... options) {
    return delegate.readAllBytes(blob, options);
  }

  @Override
  public StorageBatch batch() {
    return delegate.batch();
  }

  @Override
  public ReadChannel reader(String bucket, String blob, BlobSourceOption... options) {
    return delegate.reader(bucket, blob, options);
  }

  @Override
  public ReadChannel reader(BlobId blob, BlobSourceOption... options) {
    return delegate.reader(blob, options);
  }

  @Override
  public void downloadTo(BlobId blob, Path path, BlobSourceOption... options) {
    delegate.downloadTo(blob, path, options);
  }

  @Override
  public void downloadTo(BlobId blob, OutputStream outputStream, BlobSourceOption... options) {
    delegate.downloadTo(blob, outputStream, options);
  }

  @Override
  public WriteChannel writer(BlobInfo blobInfo, BlobWriteOption... options) {
    return delegate.writer(blobInfo, options);
  }

  @Override
  public WriteChannel writer(URL signedURL) {
    return delegate.writer(signedURL);
  }

  @Override
  public URL signUrl(BlobInfo blobInfo, long duration, TimeUnit unit, SignUrlOption... options) {
    return delegate.signUrl(blobInfo, duration, unit, options);
  }

  @Override
  public PostPolicyV4 generateSignedPostPolicyV4(
      BlobInfo blobInfo,
      long duration,
      TimeUnit unit,
      PostFieldsV4 fields,
      PostConditionsV4 conditions,
      PostPolicyV4Option... options) {
    return delegate.generateSignedPostPolicyV4(
        blobInfo, duration, unit, fields, conditions, options);
  }

  @Override
  public PostPolicyV4 generateSignedPostPolicyV4(
      BlobInfo blobInfo,
      long duration,
      TimeUnit unit,
      PostFieldsV4 fields,
      PostPolicyV4Option... options) {
    return delegate.generateSignedPostPolicyV4(blobInfo, duration, unit, fields, options);
  }

  @Override
  public PostPolicyV4 generateSignedPostPolicyV4(
      BlobInfo blobInfo,
      long duration,
      TimeUnit unit,
      PostConditionsV4 conditions,
      PostPolicyV4Option... options) {
    return delegate.generateSignedPostPolicyV4(blobInfo, duration, unit, conditions, options);
  }

  @Override
  public PostPolicyV4 generateSignedPostPolicyV4(
      BlobInfo blobInfo, long duration, TimeUnit unit, PostPolicyV4Option... options) {
    return delegate.generateSignedPostPolicyV4(blobInfo, duration, unit, options);
  }

  @Override
  public List<Blob> get(BlobId... blobIds) {
    return delegate.get(blobIds);
  }

  @Override
  public List<Blob> get(Iterable<BlobId> blobIds) {
    return delegate.get(blobIds);
  }

  @Override
  public List<Blob> update(BlobInfo... blobInfos) {
    return delegate.update(blobInfos);
  }

  @Override
  public List<Blob> update(Iterable<BlobInfo> blobInfos) {
    return delegate.update(blobInfos);
  }

  @Override
  public List<Boolean> delete(BlobId... blobIds) {
    return delegate.delete(blobIds);
  }

  @Override
  public List<Boolean> delete(Iterable<BlobId> blobIds) {
    return delegate.delete(blobIds);
  }

  @Override
  public Acl getAcl(String bucket, Entity entity, BucketSourceOption... options) {
    return delegate.getAcl(bucket, entity, options);
  }

  @Override
  public Acl getAcl(String bucket, Entity entity) {
    return delegate.getAcl(bucket, entity);
  }

  @Override
  public boolean deleteAcl(String bucket, Entity entity, BucketSourceOption... options) {
    return delegate.deleteAcl(bucket, entity, options);
  }

  @Override
  public boolean deleteAcl(String bucket, Entity entity) {
    return delegate.deleteAcl(bucket, entity);
  }

  @Override
  public Acl createAcl(String bucket, Acl acl, BucketSourceOption... options) {
    return delegate.createAcl(bucket, acl, options);
  }

  @Override
  public Acl createAcl(String bucket, Acl acl) {
    return delegate.createAcl(bucket, acl);
  }

  @Override
  public Acl updateAcl(String bucket, Acl acl, BucketSourceOption... options) {
    return delegate.updateAcl(bucket, acl, options);
  }

  @Override
  public Acl updateAcl(String bucket, Acl acl) {
    return delegate.updateAcl(bucket, acl);
  }

  @Override
  public List<Acl> listAcls(String bucket, BucketSourceOption... options) {
    return delegate.listAcls(bucket, options);
  }

  @Override
  public List<Acl> listAcls(String bucket) {
    return delegate.listAcls(bucket);
  }

  @Override
  public Acl getDefaultAcl(String bucket, Entity entity) {
    return delegate.getDefaultAcl(bucket, entity);
  }

  @Override
  public boolean deleteDefaultAcl(String bucket, Entity entity) {
    return delegate.deleteDefaultAcl(bucket, entity);
  }

  @Override
  public Acl createDefaultAcl(String bucket, Acl acl) {
    return delegate.createDefaultAcl(bucket, acl);
  }

  @Override
  public Acl updateDefaultAcl(String bucket, Acl acl) {
    return delegate.updateDefaultAcl(bucket, acl);
  }

  @Override
  public List<Acl> listDefaultAcls(String bucket) {
    return delegate.listDefaultAcls(bucket);
  }

  @Override
  public Acl getAcl(BlobId blob, Entity entity) {
    return delegate.getAcl(blob, entity);
  }

  @Override
  public boolean deleteAcl(BlobId blob, Entity entity) {
    return delegate.deleteAcl(blob, entity);
  }

  @Override
  public Acl createAcl(BlobId blob, Acl acl) {
    return delegate.createAcl(blob, acl);
  }

  @Override
  public Acl updateAcl(BlobId blob, Acl acl) {
    return delegate.updateAcl(blob, acl);
  }

  @Override
  public List<Acl> listAcls(BlobId blob) {
    return delegate.listAcls(blob);
  }

  @Override
  public HmacKey createHmacKey(ServiceAccount serviceAccount, CreateHmacKeyOption... options) {
    return delegate.createHmacKey(serviceAccount, options);
  }

  @Override
  public Page<HmacKeyMetadata> listHmacKeys(ListHmacKeysOption... options) {
    return delegate.listHmacKeys(options);
  }

  @Override
  public HmacKeyMetadata getHmacKey(String accessId, GetHmacKeyOption... options) {
    return delegate.getHmacKey(accessId, options);
  }

  @Override
  public void deleteHmacKey(HmacKeyMetadata hmacKeyMetadata, DeleteHmacKeyOption... options) {
    delegate.deleteHmacKey(hmacKeyMetadata, options);
  }

  @Override
  public HmacKeyMetadata updateHmacKeyState(
      HmacKeyMetadata hmacKeyMetadata, HmacKeyState state, UpdateHmacKeyOption... options) {
    return delegate.updateHmacKeyState(hmacKeyMetadata, state, options);
  }

  @Override
  public Policy getIamPolicy(String bucket, BucketSourceOption... options) {
    return delegate.getIamPolicy(bucket, options);
  }

  @Override
  public Policy setIamPolicy(String bucket, Policy policy, BucketSourceOption... options) {
    return delegate.setIamPolicy(bucket, policy, options);
  }

  @Override
  public List<Boolean> testIamPermissions(
      String bucket, List<String> permissions, BucketSourceOption... options) {
    return delegate.testIamPermissions(bucket, permissions, options);
  }

  @Override
  public ServiceAccount getServiceAccount(String projectId) {
    return delegate.getServiceAccount(projectId);
  }

  @Override
  public Notification createNotification(String bucket, NotificationInfo notificationInfo) {
    return delegate.createNotification(bucket, notificationInfo);
  }

  @Override
  public Notification getNotification(String bucket, String notificationId) {
    return delegate.getNotification(bucket, notificationId);
  }

  @Override
  public List<Notification> listNotifications(String bucket) {
    return delegate.listNotifications(bucket);
  }

  @Override
  public boolean deleteNotification(String bucket, String notificationId) {
    return delegate.deleteNotification(bucket, notificationId);
  }

  @Override
  public BlobWriteSession blobWriteSession(BlobInfo blobInfo, BlobWriteOption... options) {
    return delegate.blobWriteSession(blobInfo, options);
  }

  @Override
  public ApiFuture<BlobReadSession> blobReadSession(BlobId id, BlobSourceOption... options) {
    return delegate.blobReadSession(id, options);
  }

  @Override
  public BlobAppendableUpload blobAppendableUpload(
      BlobInfo blobInfo, BlobAppendableUploadConfig uploadConfig, BlobWriteOption... options) {
    return delegate.blobAppendableUpload(blobInfo, uploadConfig, options);
  }

  @Override
  public void close() throws Exception {
    delegate.close();
  }

  @Override
  public Blob moveBlob(MoveBlobRequest request) {
    return delegate.moveBlob(request);
  }

  @Override
  public StorageOptions getOptions() {
    return delegate.getOptions();
  }
}
