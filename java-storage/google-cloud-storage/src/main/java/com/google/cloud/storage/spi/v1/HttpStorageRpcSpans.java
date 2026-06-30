/*
 * Copyright 2018 Google LLC
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

package com.google.cloud.storage.spi.v1;

import io.opencensus.trace.EndSpanOptions;
import java.util.Locale;

/** Helper class for instrumenting {@link HttpStorageRpc} with Open Census APIs. */
class HttpStorageRpcSpans {
  // OpenCensus span name prefix, 'Sent' for client and 'RECV' for server.
  static final String SPAN_NAME_CLIENT_PREFIX = "Sent";

  static final String SPAN_NAME_CREATE_BUCKET = getTraceSpanName("create(Bucket,Map)");
  static final String SPAN_NAME_CREATE_OBJECT =
      getTraceSpanName("create(StorageObject,InputStream,Map)");
  static final String SPAN_NAME_LIST_BUCKETS = getTraceSpanName("list(Map)");
  static final String SPAN_NAME_LIST_OBJECTS = getTraceSpanName("list(String,Map)");
  static final String SPAN_NAME_GET_BUCKET = getTraceSpanName("get(Bucket,Map)");
  static final String SPAN_NAME_GET_OBJECT = getTraceSpanName("get(StorageObject,Map)");
  static final String SPAN_NAME_RESTORE_OBJECT = getTraceSpanName("restore(StorageObject, Map)");
  static final String SPAN_NAME_PATCH_BUCKET = getTraceSpanName("patch(Bucket,Map)");
  static final String SPAN_NAME_PATCH_OBJECT = getTraceSpanName("patch(StorageObject,Map)");
  static final String SPAN_NAME_DELETE_BUCKET = getTraceSpanName("delete(Bucket,Map)");
  static final String SPAN_NAME_DELETE_OBJECT = getTraceSpanName("delete(StorageObject,Map)");
  static final String SPAN_NAME_CREATE_BATCH = getTraceSpanName("createBatch()");
  static final String SPAN_NAME_COMPOSE = getTraceSpanName("compose(Iterable,StorageObject,Map)");
  static final String SPAN_NAME_LOAD = getTraceSpanName("load(StorageObject,Map");
  static final String SPAN_NAME_READ = getTraceSpanName("read(StorageObject,Map,long,int)");
  static final String SPAN_NAME_OPEN = getTraceSpanName("open(StorageObject,Map)");
  static final String SPAN_NAME_WRITE =
      getTraceSpanName("write(String,byte[],int,long,int,boolean)");
  static final String SPAN_NAME_OPEN_REWRITE = getTraceSpanName("openRewrite(RewriteRequest)");
  static final String SPAN_NAME_CONTINUE_REWRITE =
      getTraceSpanName("continueRewrite(RewriteResponse)");
  static final String SPAN_NAME_GET_BUCKET_ACL = getTraceSpanName("getAcl(String,String,Map)");
  static final String SPAN_NAME_DELETE_BUCKET_ACL =
      getTraceSpanName("deleteAcl(String,String,Map)");
  static final String SPAN_NAME_CREATE_BUCKET_ACL =
      getTraceSpanName("createAcl(BucketAccessControl,Map)");
  static final String SPAN_NAME_PATCH_BUCKET_ACL =
      getTraceSpanName("patchAcl(BucketAccessControl,Map)");
  static final String SPAN_NAME_LIST_BUCKET_ACLS = getTraceSpanName("listAcls(String,Map)");
  static final String SPAN_NAME_GET_OBJECT_DEFAULT_ACL =
      getTraceSpanName("getDefaultAcl(String,String)");
  static final String SPAN_NAME_DELETE_OBJECT_DEFAULT_ACL =
      getTraceSpanName("deleteDefaultAcl(String,String)");
  static final String SPAN_NAME_CREATE_OBJECT_DEFAULT_ACL =
      getTraceSpanName("createDefaultAcl(ObjectAccessControl)");
  static final String SPAN_NAME_PATCH_OBJECT_DEFAULT_ACL =
      getTraceSpanName("patchDefaultAcl(ObjectAccessControl)");
  static final String SPAN_NAME_LIST_OBJECT_DEFAULT_ACLS =
      getTraceSpanName("listDefaultAcls(String)");
  static final String SPAN_NAME_GET_OBJECT_ACL =
      getTraceSpanName("getAcl(String,String,Long,String)");
  static final String SPAN_NAME_DELETE_OBJECT_ACL =
      getTraceSpanName("deleteAcl(String,String,Long,String)");
  static final String SPAN_NAME_CREATE_OBJECT_ACL =
      getTraceSpanName("createAcl(ObjectAccessControl)");
  static final String SPAN_NAME_PATCH_OBJECT_ACL =
      getTraceSpanName("patchAcl(ObjectAccessControl)");
  static final String SPAN_NAME_LIST_OBJECT_ACLS = getTraceSpanName("listAcls(String,String,Long)");
  static final String SPAN_NAME_CREATE_HMAC_KEY = getTraceSpanName("createHmacKey(String)");
  static final String SPAN_NAME_GET_HMAC_KEY = getTraceSpanName("getHmacKey(String)");
  static final String SPAN_NAME_DELETE_HMAC_KEY = getTraceSpanName("deleteHmacKey(String)");
  static final String SPAN_NAME_LIST_HMAC_KEYS =
      getTraceSpanName("listHmacKeys(String,String,Long)");
  static final String SPAN_NAME_UPDATE_HMAC_KEY =
      getTraceSpanName("updateHmacKey(HmacKeyMetadata)");
  static final String SPAN_NAME_GET_BUCKET_IAM_POLICY =
      getTraceSpanName("getIamPolicy(String,Map)");
  static final String SPAN_NAME_SET_BUCKET_IAM_POLICY =
      getTraceSpanName("setIamPolicy(String,Policy,Map)");
  static final String SPAN_NAME_TEST_BUCKET_IAM_PERMISSIONS =
      getTraceSpanName("testIamPermissions(String,List,Map)");
  static final String SPAN_NAME_DELETE_NOTIFICATION =
      getTraceSpanName("deleteNotification(String,String)");
  static final String SPAN_NAME_LIST_NOTIFICATIONS = getTraceSpanName("listNotifications(String)");
  static final String SPAN_NAME_CREATE_NOTIFICATION =
      getTraceSpanName("createNotification(String,Notification)");
  static final String SPAN_NAME_GET_NOTIFICATION =
      getTraceSpanName("getNotification(String,String)");
  static final String SPAN_LOCK_RETENTION_POLICY =
      getTraceSpanName("lockRetentionPolicy(String,Long)");
  static final String SPAN_NAME_GET_SERVICE_ACCOUNT = getTraceSpanName("getServiceAccount(String)");
  static final String SPAN_NAME_BATCH_SUBMIT =
      getTraceSpanName(RpcBatch.class.getName() + ".submit()");
  static final EndSpanOptions END_SPAN_OPTIONS =
      EndSpanOptions.builder().setSampleToLocalSpanStore(true).build();

  static String getTraceSpanName(String methodDescriptor) {
    return String.format(
        Locale.US,
        "%s.%s.%s",
        SPAN_NAME_CLIENT_PREFIX,
        HttpStorageRpc.class.getName(),
        methodDescriptor);
  }

  private HttpStorageRpcSpans() {}
}
