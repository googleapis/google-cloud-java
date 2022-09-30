/*
 * Copyright 2017 Google LLC
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

import static com.google.cloud.BaseService.EXCEPTION_HANDLER;
import static com.google.cloud.RetryHelper.runWithRetries;

import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.concurrent.Callable;

public class NotificationImpl implements Notification {

  private final Storage storage;

  private NotificationImpl(Storage storage) {
    this.storage = storage;
  }

  @Override
  public Notification create(Storage storage) {
    return new NotificationImpl(storage);
  }

  public static class DefaultNotificationFactory {
    public Notification create(Storage storage) {
      return new NotificationImpl(storage);
    }
  }

  @Override
  public boolean deleteNotification(final String bucket, final String notification) {
    try {
      return runWithRetries(
          new Callable<Boolean>() {
            @Override
            public Boolean call() {
              return ((StorageRpc) storage.getOptions().getRpc())
                  .deleteNotification(bucket, notification);
            }
          },
          storage.getOptions().getRetrySettings(),
          EXCEPTION_HANDLER,
          storage.getOptions().getClock());
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }

  @Override
  public List<NotificationInfo> listNotifications(final String bucket) {
    try {
      List<com.google.api.services.storage.model.Notification> answer =
          runWithRetries(
              new Callable<List<com.google.api.services.storage.model.Notification>>() {
                @Override
                public List<com.google.api.services.storage.model.Notification> call() {
                  return ((StorageRpc) storage.getOptions().getRpc()).listNotifications(bucket);
                }
              },
              storage.getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              storage.getOptions().getClock());
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
      return NotificationInfo.fromPb(
          runWithRetries(
              new Callable<com.google.api.services.storage.model.Notification>() {
                @Override
                public com.google.api.services.storage.model.Notification call() {
                  return ((StorageRpc) storage.getOptions().getRpc())
                      .createNotification(bucket, notificationPb);
                }
              },
              storage.getOptions().getRetrySettings(),
              EXCEPTION_HANDLER,
              storage.getOptions().getClock()));
    } catch (RetryHelperException e) {
      throw StorageException.translateAndThrow(e);
    }
  }
}
