/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.storage.conformance.retry;

import static java.util.Objects.requireNonNull;

import com.google.api.gax.paging.Page;
import com.google.cloud.Policy;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.CopyWriter;
import com.google.cloud.storage.HmacKey;
import com.google.cloud.storage.HmacKey.HmacKeyMetadata;
import com.google.cloud.storage.Notification;
import com.google.cloud.storage.ServiceAccount;
import com.google.cloud.storage.Storage.ComposeRequest;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.Immutable;
import com.google.pubsub.v1.TopicName;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * A specialized wrapper around an immutable map allowing for declaration of named get/has/with
 * methods without the need for individual fields.
 *
 * <p>Every mutation returns a copy with the mutation result.
 *
 * <p>Over the course of executing an individual test for a specific mapping some fields will be
 * updated.
 *
 * <p>This approach was taken after multiple attempts to create more type safe alternatives which
 * turned into far too much duplication given the possible permutations of state for various
 * mappings.
 */
@Immutable
final class State {

  private static final State EMPTY = new State();
  private static final Key<Acl> KEY_ACL = new Key<>("acl");
  private static final Key<Blob> KEY_BLOB = new Key<>("blob");
  private static final Key<BlobId> KEY_BLOB_ID = new Key<>("blobId");
  private static final Key<BlobId> KEY_COPY_DEST = new Key<>("copyDest");
  private static final Key<BlobInfo> KEY_BLOB_INFO = new Key<>("blobInfo");
  private static final Key<Boolean> KEY_BOOL = new Key<>("bool");
  private static final Key<Bucket> KEY_BUCKET = new Key<>("bucket");
  private static final Key<BucketInfo> KEY_BUCKET_INFO = new Key<>("bucketInfo");
  private static final Key<CopyWriter> KEY_COPY = new Key<>("copy");
  private static final Key<HmacKey> KEY_HMAC_KEY = new Key<>("hmacKey");
  private static final Key<HmacKeyMetadata> KEY_HMAC_KEY_METADATA = new Key<>("hmacKeyMetadata");
  private static final Key<Policy> KEY_POLICY = new Key<>("policy");
  private static final Key<ServiceAccount> KEY_SERVICE_ACCOUNT = new Key<>("serviceAccount");
  private static final Key<List<?>> KEY_LIST_OBJECTS = new Key<>("list<object>");
  private static final Key<List<Boolean>> KEY_TEST_IAM_PERMISSIONS_RESULTS =
      new Key<>("testIamPermissionsResults");
  private static final Key<List<Acl>> KEY_ACLS = new Key<>("acls");
  private static final Key<byte[]> KEY_BYTES = new Key<>("bytes");
  private static final Key<ComposeRequest> KEY_COMPOSE_REQUEST = new Key<>("composeRequest");
  private static final Key<TopicName> KEY_PUBSUB_TOPIC = new Key<>("topicName");
  private static final Key<Notification> KEY_NOTIFICATION = new Key<>("notification");
  private static final Key<List<Notification>> KEY_LIST_NOTIFICATION =
      new Key<>("lise<notification>");

  private final ImmutableMap<Key<?>, Object> data;

  public State() {
    this(ImmutableMap.of());
  }

  public State(ImmutableMap<Key<?>, Object> data) {
    this.data = data;
  }

  static State empty() {
    return EMPTY;
  }

  public boolean hasAcl() {
    return hasValue(KEY_ACL);
  }

  public Acl getAcl() {
    return getValue(KEY_ACL);
  }

  public State with(Acl acl) {
    return newStateWith(KEY_ACL, acl);
  }

  public boolean hasBlob() {
    return hasValue(KEY_BLOB);
  }

  public Blob getBlob() {
    return getValue(KEY_BLOB);
  }

  public State with(Blob blob) {
    return newStateWith(KEY_BLOB, blob);
  }

  public boolean hasBlobId() {
    return hasValue(KEY_BLOB_ID);
  }

  public BlobId getBlobId() {
    return getValue(KEY_BLOB_ID);
  }

  public State with(BlobId blobId) {
    return newStateWith(KEY_BLOB_ID, blobId);
  }

  public boolean hasCopyDest() {
    return hasValue(KEY_COPY_DEST);
  }

  public BlobId getCopyDest() {
    return getValue(KEY_COPY_DEST);
  }

  public State withCopyDest(BlobId copyDest) {
    return newStateWith(KEY_COPY_DEST, copyDest);
  }

  public boolean hasBlobInfo() {
    return hasValue(KEY_BLOB_INFO);
  }

  public BlobInfo getBlobInfo() {
    return getValue(KEY_BLOB_INFO);
  }

  public State with(BlobInfo blobInfo) {
    return newStateWith(KEY_BLOB_INFO, blobInfo);
  }

  public boolean hasBool() {
    return hasValue(KEY_BOOL);
  }

  public Boolean getBool() {
    return getValue(KEY_BOOL);
  }

  public State with(Boolean bool) {
    return newStateWith(KEY_BOOL, bool);
  }

  public boolean hasBucket() {
    return hasValue(KEY_BUCKET);
  }

  public Bucket getBucket() {
    return getValue(KEY_BUCKET);
  }

  public State with(Bucket bucket) {
    return newStateWith(KEY_BUCKET, bucket);
  }

  public boolean hasBucketInfo() {
    return hasValue(KEY_BUCKET_INFO);
  }

  public BucketInfo getBucketInfo() {
    return getValue(KEY_BUCKET_INFO);
  }

  public State with(BucketInfo bucketInfo) {
    return newStateWith(KEY_BUCKET_INFO, bucketInfo);
  }

  public boolean hasCopy() {
    return hasValue(KEY_COPY);
  }

  public CopyWriter getCopy() {
    return getValue(KEY_COPY);
  }

  public State with(CopyWriter copy) {
    return newStateWith(KEY_COPY, copy);
  }

  public boolean hasHmacKey() {
    return hasValue(KEY_HMAC_KEY);
  }

  public HmacKey getHmacKey() {
    return getValue(KEY_HMAC_KEY);
  }

  public State withHmacKey(HmacKey hmacKey) {
    return newStateWith(KEY_HMAC_KEY, hmacKey);
  }

  public boolean hasHmacKeyMetadata() {
    return hasValue(KEY_HMAC_KEY_METADATA);
  }

  public HmacKeyMetadata getHmacKeyMetadata() {
    return getValue(KEY_HMAC_KEY_METADATA);
  }

  public State with(HmacKeyMetadata hmacKeyMetadata) {
    return newStateWith(KEY_HMAC_KEY_METADATA, hmacKeyMetadata);
  }

  public boolean hasPolicy() {
    return hasValue(KEY_POLICY);
  }

  public Policy getPolicy() {
    return getValue(KEY_POLICY);
  }

  public State with(Policy policy) {
    return newStateWith(KEY_POLICY, policy);
  }

  public boolean hasServiceAccount() {
    return hasValue(KEY_SERVICE_ACCOUNT);
  }

  public ServiceAccount getServiceAccount() {
    return getValue(KEY_SERVICE_ACCOUNT);
  }

  public State with(ServiceAccount serviceAccount) {
    return newStateWith(KEY_SERVICE_ACCOUNT, serviceAccount);
  }

  public boolean hasBytes() {
    return hasValue(KEY_BYTES);
  }

  public byte[] getBytes() {
    return getValue(KEY_BYTES);
  }

  public State with(byte[] bytes) {
    return newStateWith(KEY_BYTES, bytes);
  }

  public boolean hasTestIamPermissionsResults() {
    return hasValue(KEY_TEST_IAM_PERMISSIONS_RESULTS);
  }

  public List<Boolean> getTestIamPermissionsResults() {
    return getValue(KEY_TEST_IAM_PERMISSIONS_RESULTS);
  }

  public State withTestIamPermissionsResults(List<Boolean> testIamPermissionsResults) {
    return newStateWith(KEY_TEST_IAM_PERMISSIONS_RESULTS, testIamPermissionsResults);
  }

  public boolean hasAcls() {
    return hasValue(KEY_ACLS);
  }

  public List<Acl> getAcls() {
    return getValue(KEY_ACLS);
  }

  public State withAcls(List<Acl> acls) {
    return newStateWith(KEY_ACLS, acls);
  }

  public <T> State consume(Page<T> page) {
    List<T> collect =
        StreamSupport.stream(page.iterateAll().spliterator(), false).collect(Collectors.toList());
    return newStateWith(KEY_LIST_OBJECTS, collect);
  }

  public State with(ComposeRequest composeRequest) {
    return newStateWith(KEY_COMPOSE_REQUEST, composeRequest);
  }

  public ComposeRequest getComposeRequest() {
    return getValue(KEY_COMPOSE_REQUEST);
  }

  public boolean hasComposeRequest() {
    return hasValue(KEY_COMPOSE_REQUEST);
  }

  public boolean hasTopicName() {
    return hasValue(KEY_PUBSUB_TOPIC);
  }

  public TopicName getTopicName() {
    return getValue(KEY_PUBSUB_TOPIC);
  }

  public State with(TopicName topic) {
    return newStateWith(KEY_PUBSUB_TOPIC, topic);
  }

  public boolean hasNotification() {
    return hasValue(KEY_NOTIFICATION);
  }

  public Notification getNotification() {
    return getValue(KEY_NOTIFICATION);
  }

  public State with(Notification notification) {
    return newStateWith(KEY_NOTIFICATION, notification);
  }

  public boolean hasNotifications() {
    return hasValue(KEY_LIST_NOTIFICATION);
  }

  public List<Notification> getNotifications() {
    return getValue(KEY_LIST_NOTIFICATION);
  }

  public State with(List<Notification> notifications) {
    return newStateWith(KEY_LIST_NOTIFICATION, notifications);
  }

  private <T> T getValue(Key<T> key) {
    Object o = data.get(key);
    requireNonNull(o, () -> String.format(Locale.US, "%s was not found in state", key.name));
    return key.cast(o);
  }

  private <T> boolean hasValue(Key<T> key) {
    return data.containsKey(key);
  }

  private <T> State newStateWith(Key<T> key, T t) {
    Map<Key<?>, Object> tmp = new HashMap<>(data);
    if (t != null) {
      tmp.put(key, t);
    } else {
      tmp.remove(key);
    }
    return new State(ImmutableMap.copyOf(tmp));
  }

  private static final class Key<T> {

    private final String name;

    public Key(String name) {
      this.name = requireNonNull(name, "name must be non null");
    }

    T cast(Object t) {
      return (T) t;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Key)) {
        return false;
      }
      Key<?> key = (Key<?>) o;
      return name.equals(key.name);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name);
    }
  }
}
