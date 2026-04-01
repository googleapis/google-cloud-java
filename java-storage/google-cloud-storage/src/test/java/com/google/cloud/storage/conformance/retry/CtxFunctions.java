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

import static com.google.common.collect.Sets.newHashSet;

import com.google.api.gax.paging.Page;
import com.google.cloud.conformance.storage.v1.Resource;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Acl.Role;
import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.HmacKey;
import com.google.cloud.storage.HmacKey.HmacKeyMetadata;
import com.google.cloud.storage.HmacKey.HmacKeyState;
import com.google.cloud.storage.NotificationInfo;
import com.google.cloud.storage.NotificationInfo.PayloadFormat;
import com.google.cloud.storage.ServiceAccount;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.ComposeRequest;
import com.google.cloud.storage.conformance.retry.Functions.CtxFunction;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.pubsub.v1.TopicName;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;

/**
 * Define a set of {@link CtxFunction} which are used in mappings as well as general setup/tear down
 * of specific tests.
 *
 * <p>Functions are grouped into nested classes which try to hint at the area they operate within.
 * Client side-only, or performing an RPC, setup or tear down and so on.
 *
 * @see RpcMethodMapping
 * @see RpcMethodMapping.Builder
 * @see RpcMethodMappings
 */
final class CtxFunctions {

  static final class Local {

    /**
     * Populate a copy destination for the state present in the ctx.
     *
     * @see State#getCopyDest()
     */
    static final CtxFunction blobCopy =
        (ctx, c) -> ctx.map(s -> s.withCopyDest(BlobId.of(c.getBucketName2(), c.getObjectName())));

    /**
     * Populate a bucket info for the state present in the ctx.
     *
     * <p>this is primarily useful in the case when you want to insert a bucket during the test
     *
     * @see State#getBucketInfo()
     */
    static final CtxFunction bucketInfo =
        (ctx, c) -> ctx.map(s -> s.with(BucketInfo.of(c.getBucketName())));

    /**
     * Populate a compose request for the state present in the ctx.
     *
     * @see State#getComposeRequest()
     */
    static final CtxFunction composeRequest =
        (ctx, c) ->
            ctx.map(
                state -> {
                  Blob blob = state.getBlob();
                  String bucket = blob.getBucket();
                  final BlobInfo target;
                  if (c.isPreconditionsProvided()) {
                    target = BlobInfo.newBuilder(BlobId.of(bucket, "blob-full", 0L)).build();
                  } else {
                    target = BlobInfo.newBuilder(BlobId.of(bucket, "blob-full")).build();
                  }
                  ComposeRequest.Builder builder =
                      ComposeRequest.newBuilder()
                          // source bucket is resolved from the target, as compose must be within
                          // the same bucket
                          .addSource(blob.getName(), blob.getGeneration())
                          .addSource(blob.getName(), blob.getGeneration())
                          .setTarget(target);
                  if (c.isPreconditionsProvided()) {
                    builder = builder.setTargetOptions(BlobTargetOption.generationMatch());
                  }
                  ComposeRequest r = builder.build();
                  return state.with(r);
                });

    private static final CtxFunction blobIdAndBlobInfo =
        (ctx, c) -> ctx.map(state -> state.with(BlobInfo.newBuilder(state.getBlobId()).build()));
    private static final CtxFunction blobIdWithoutGeneration =
        (ctx, c) -> ctx.map(s -> s.with(BlobId.of(c.getBucketName(), c.getObjectName())));
    private static final CtxFunction blobIdWithGenerationZero =
        (ctx, c) -> ctx.map(s -> s.with(BlobId.of(c.getBucketName(), c.getObjectName(), 0L)));

    /**
     * Populate a blobId and blob info for the state present in the ctx which specifies a null
     * generation. Use when a generation value shouldn't be part of a request or other evaluation.
     *
     * @see State#getBlobId()
     * @see State#getBlobInfo()
     */
    static final CtxFunction blobInfoWithoutGeneration =
        blobIdWithoutGeneration.andThen(blobIdAndBlobInfo);

    /**
     * Populate a blobId and blob info for the state present in the ctx which specifies a generation
     * of 0 (zero).
     *
     * @see State#getBlobId()
     * @see State#getBlobInfo()
     */
    static final CtxFunction blobInfoWithGenerationZero =
        blobIdWithGenerationZero.andThen(blobIdAndBlobInfo);
  }

  static final class Rpc {
    static final CtxFunction createEmptyBlob =
        (ctx, c) -> ctx.map(state -> state.with(ctx.getStorage().create(state.getBlobInfo())));
    static final CtxFunction bucketIamPolicy =
        (ctx, c) ->
            ctx.map(
                state -> state.with(ctx.getStorage().getIamPolicy(state.getBucket().getName())));
  }

  static final class ResourceSetup {
    private static final CtxFunction bucket =
        (ctx, c) -> {
          BucketInfo bucketInfo = BucketInfo.newBuilder(c.getBucketName()).build();
          Bucket resolvedBucket = ctx.getStorage().create(bucketInfo);
          return ctx.map(s -> s.with(resolvedBucket));
        };

    /**
     * Create a new object in the {@link State#getBucket()} and populate a blobId, blob info and
     * blob for the state present in the ctx.
     *
     * <p>This method will issue an RPC.
     *
     * @see State#getBlob()
     * @see State#getBlobId()
     * @see State#getBlobInfo()
     */
    static final CtxFunction object =
        (ctx, c) -> {
          BlobInfo blobInfo =
              BlobInfo.newBuilder(ctx.getState().getBucket().getName(), c.getObjectName()).build();
          Blob resolvedBlob = ctx.getStorage().create(blobInfo, c.getHelloWorldUtf8Bytes());
          return ctx.map(
              s ->
                  s.with(resolvedBlob)
                      .with((BlobInfo) resolvedBlob)
                      .with(resolvedBlob.getBlobId()));
        };

    static final CtxFunction serviceAccount =
        (ctx, c) ->
            ctx.map(s -> s.with(ServiceAccount.of(c.getServiceAccountSigner().getAccount())));
    private static final CtxFunction hmacKey =
        (ctx, c) ->
            ctx.map(
                s -> {
                  HmacKey hmacKey1 = ctx.getStorage().createHmacKey(s.getServiceAccount());
                  return s.withHmacKey(hmacKey1).with(hmacKey1.getMetadata());
                });

    static final CtxFunction pubsubTopic =
        (ctx, c) -> {
          String projectId = c.getProjectId();
          TopicName name = TopicName.of(projectId, c.getTopicName());
          return ctx.map(s -> s.with(name));
        };

    static final CtxFunction notification =
        (ctx, c) ->
            ctx.map(
                state -> {
                  PayloadFormat format = PayloadFormat.JSON_API_V1;
                  Map<String, String> attributes = ImmutableMap.of("label1", "value1");
                  NotificationInfo notificationInfo =
                      NotificationInfo.newBuilder(state.getTopicName().toString())
                          .setCustomAttributes(attributes)
                          .setPayloadFormat(format)
                          .build();
                  return state.with(
                      ctx.getStorage().createNotification(c.getBucketName(), notificationInfo));
                });

    private static final CtxFunction processResources =
        (ctx, c) -> {
          HashSet<Resource> resources = newHashSet(c.getMethod().getResourcesList());
          CtxFunction f = CtxFunction.identity();
          if (resources.contains(Resource.BUCKET)) {
            f = f.andThen(ResourceSetup.bucket);
            resources.remove(Resource.BUCKET);
          }

          if (resources.contains(Resource.OBJECT)) {
            f = f.andThen(ResourceSetup.object);
            resources.remove(Resource.OBJECT);
          }

          if (resources.contains(Resource.HMAC_KEY)) {
            f = f.andThen(serviceAccount).andThen(hmacKey);
            resources.remove(Resource.HMAC_KEY);
          }

          if (resources.contains(Resource.NOTIFICATION)) {
            f = f.andThen(pubsubTopic).andThen(notification);
            resources.remove(Resource.NOTIFICATION);
          }

          if (!resources.isEmpty()) {
            throw new IllegalStateException(
                String.format(
                    Locale.US, "Unhandled Method Resource [%s]", Joiner.on(", ").join(resources)));
          }

          return f.apply(ctx, c);
        };

    private static final CtxFunction allUsersReaderAcl =
        (ctx, c) -> ctx.map(s -> s.with(Acl.of(User.ofAllUsers(), Role.READER)));

    static final CtxFunction defaultSetup = processResources.andThen(allUsersReaderAcl);

    static final CtxFunction pubsubTopicSetup = defaultSetup.andThen(pubsubTopic);

    static final CtxFunction notificationSetup = pubsubTopicSetup.andThen(notification);
  }

  static final class ResourceTeardown {
    private static final CtxFunction deleteAllObjects =
        (ctx, c) ->
            ctx.map(
                s -> {
                  Storage storage = ctx.getStorage();
                  deleteBucket(storage, c.getBucketName());
                  deleteBucket(storage, c.getBucketName2());
                  State newState =
                      s.with((Blob) null)
                          .with((BlobInfo) null)
                          .with((BlobId) null)
                          .with((Bucket) null);

                  if (s.hasHmacKeyMetadata()) {
                    HmacKeyMetadata metadata = s.getHmacKeyMetadata();
                    if (metadata.getState() == HmacKeyState.ACTIVE) {
                      metadata = storage.updateHmacKeyState(metadata, HmacKeyState.INACTIVE);
                    }
                    storage.deleteHmacKey(metadata);
                    newState.with((HmacKeyMetadata) null).withHmacKey(null);
                  }

                  return newState;
                });

    static final CtxFunction defaultTeardown = deleteAllObjects;

    private static void deleteBucket(Storage storage, String bucketName) {
      Bucket bucket = storage.get(bucketName);
      if (bucket != null) {
        emptyBucket(storage, bucketName);
        bucket.delete();
      }
    }

    private static void emptyBucket(Storage storage, String bucketName) {
      Page<Blob> blobs = storage.list(bucketName);
      for (Blob blob : blobs.iterateAll()) {
        blob.delete();
      }
    }
  }
}
