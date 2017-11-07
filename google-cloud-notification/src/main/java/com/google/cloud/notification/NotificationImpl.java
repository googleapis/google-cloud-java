/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.notification;

import static com.google.cloud.RetryHelper.runWithRetries;

import com.google.cloud.BaseService;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.concurrent.Callable;

public class NotificationImpl extends BaseService<StorageOptions> implements Notification {

  private final StorageRpc storageRpc;

  NotificationImpl(StorageOptions options) {
    super(options);
    storageRpc = options.getStorageRpcV1();
  }

  public static class DefaultNotificationFactory implements NotificationFactory {
    @Override
    public Notification create(StorageOptions options) {
      return new NotificationImpl(options);
    }
  }

  @Override
  public boolean deleteNotification(final String bucket, final String notification) {
    try {
      return runWithRetries(new Callable<Boolean>() {
        @Override
        public Boolean call() {
          return storageRpc.deleteNotification(bucket, notification);
        }
      }, getOptions().getRetrySettings(), EXCEPTION_HANDLER, getOptions().getClock());
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public List<NotificationInfo> listNotifications(final String bucket) {
    try {
      List<com.google.api.services.storage.model.Notification> answer = runWithRetries(new Callable<List<com.google.api.services.storage.model.Notification>>() {
        @Override
        public List<com.google.api.services.storage.model.Notification> call() {
          return storageRpc.listNotifications(bucket);
        }
      }, getOptions().getRetrySettings(), EXCEPTION_HANDLER, getOptions().getClock());
      if (answer == null) {
        return null;
      }
      return Lists.transform(answer, NotificationInfo.FROM_PB_FUNCTION);
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public NotificationInfo createNotification(final String bucket, NotificationInfo notification) {
    final com.google.api.services.storage.model.Notification notificationPb = notification.toPb();
    try {
      return NotificationInfo.fromPb(runWithRetries(new Callable<com.google.api.services.storage.model.Notification>() {
        @Override
        public com.google.api.services.storage.model.Notification call() {
          return storageRpc.createNotification(bucket, notificationPb);
        }
      }, getOptions().getRetrySettings(), EXCEPTION_HANDLER, getOptions().getClock()));
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

}
