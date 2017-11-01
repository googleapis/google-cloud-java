// /*
//  * Copyright 2015 Google Inc. All Rights Reserved.
//  *
//  * Licensed under the Apache License, Version 2.0 (the "License");
//  * you may not use this file except in compliance with the License.
//  * You may obtain a copy of the License at
//  *
//  *       http://www.apache.org/licenses/LICENSE-2.0
//  *
//  * Unless required by applicable law or agreed to in writing, software
//  * distributed under the License is distributed on an "AS IS" BASIS,
//  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  * See the License for the specific language governing permissions and
//  * limitations under the License.
//  */
//
// package com.google.cloud.notification;
//
// import com.google.cloud.http.HttpTransportOptions;
// import com.google.cloud.ServiceDefaults;
// import com.google.cloud.ServiceOptions;
// import com.google.cloud.ServiceRpc;
// import com.google.cloud.TransportOptions;
// import com.google.cloud.notification.Notification;
// import com.google.cloud.notification.NotificationImpl;
// import com.google.cloud.storage.Notification;
// import com.google.cloud.storage.NotificationOptions;
// import com.google.cloud.storage.StorageFactory;
// import com.google.cloud.storage.StorageOptions;
// import com.google.cloud.storage.spi.v1.HttpNotificationRpc;
// import com.google.cloud.storage.spi.v1.HttpStorageRpc;
// import com.google.cloud.storage.spi.v1.NotificationRpc;
// import com.google.cloud.storage.spi.NotificationRpcFactory;
// import com.google.cloud.storage.spi.v1.StorageRpc;
// import com.google.common.collect.ImmutableSet;
// import java.util.Set;
//
// public class NotificationOptions extends ServiceOptions<Notification, NotificationOptions> {
//
//   private static final long serialVersionUID = -2907268477247502947L;
//   private static final String API_SHORT_NAME = "Notification";
//   private static final String GCS_SCOPE = "https://www.googleapis.com/auth/devstorage.full_control";
//   private static final Set<String> SCOPES = ImmutableSet.of(GCS_SCOPE);
//
//   public static class DefaultNotificationFactory implements StorageFactory {
//
//     private static final NotificationFactory INSTANCE = new DefaultNotificationFactory();
//
//     @Override
//     public Notification create(StorageOptions options) {
//       return new NotificationImpl(options);
//     }
//   }
//
//   public static class Builder extends
//       ServiceOptions.Builder<Notification, NotificationOptions, Builder> {
//
//     private Builder() {}
//
//     private Builder(NotificationOptions options) {
//       super(options);
//     }
//
//     @Override
//     public Builder setTransportOptions(TransportOptions transportOptions) {
//       if (!(transportOptions instanceof HttpTransportOptions)) {
//         throw new IllegalArgumentException(
//             "Only http transport is allowed for " + API_SHORT_NAME + ".");
//       }
//       return super.setTransportOptions(transportOptions);
//     }
//
//     @Override
//     public NotificationOptions build() {
//       return new NotificationOptions(this);
//     }
//   }
//
//   private NotificationOptions(Builder builder) {
//     super(NotificationFactory.class, NotificationRpcFactory.class, builder, new NotificationDefaults());
//   }
//
//   private static class NotificationDefaults implements
//       ServiceDefaults<Notification, NotificationOptions> {
//
//     @Override
//     public NotificationFactory getDefaultServiceFactory() {
//       return DefaultNotificationFactory.INSTANCE;
//     }
//
//     @Override
//     public NotificationRpcFactory getDefaultRpcFactory() {
//       return DefaultNotificationRpcFactory.INSTANCE;
//     }
//
//     @Override
//     public TransportOptions getDefaultTransportOptions() {
//       return getDefaultHttpTransportOptions();
//     }
//   }
//
//   public static HttpTransportOptions getDefaultHttpTransportOptions() {
//     return HttpTransportOptions.newBuilder().build();
//   }
//
//   // Project ID is only required for creating buckets, so we don't require it for creating the
//   // service.
//   @Override
//   protected boolean projectIdRequired() {
//     return false;
//   }
//
//   @Override
//   protected Set<String> getScopes() {
//     return SCOPES;
//   }
//
//   public StorageRpc getNotificationRpcV1() {
//     return (StorageRpc) getRpc();
//   }
//
//   /**
//    * Returns a default {@code NotificationOptions} instance.
//    */
//   public static NotificationOptions getDefaultInstance() {
//     return newBuilder().build();
//   }
//
//   @SuppressWarnings("unchecked")
//   @Override
//   public Builder toBuilder() {
//     return new Builder(this);
//   }
//
//   @Override
//   public int hashCode() {
//     return baseHashCode();
//   }
//
//   @Override
//   public boolean equals(Object obj) {
//     return obj instanceof NotificationOptions && baseEquals((NotificationOptions) obj);
//   }
//
//
//   public static Builder newBuilder() {
//     return new Builder();
//   }
// }
