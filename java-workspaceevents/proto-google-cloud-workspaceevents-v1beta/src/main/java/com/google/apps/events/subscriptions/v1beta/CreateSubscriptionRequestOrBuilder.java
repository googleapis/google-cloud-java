/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/apps/events/subscriptions/v1beta/subscriptions_service.proto

// Protobuf Java Version: 3.25.8
package com.google.apps.events.subscriptions.v1beta;

public interface CreateSubscriptionRequestOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.apps.events.subscriptions.v1beta.CreateSubscriptionRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Required. The subscription resource to create.
   * </pre>
   *
   * <code>
   * .google.apps.events.subscriptions.v1beta.Subscription subscription = 1 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   *
   * @return Whether the subscription field is set.
   */
  boolean hasSubscription();

  /**
   *
   *
   * <pre>
   * Required. The subscription resource to create.
   * </pre>
   *
   * <code>
   * .google.apps.events.subscriptions.v1beta.Subscription subscription = 1 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   *
   * @return The subscription.
   */
  com.google.apps.events.subscriptions.v1beta.Subscription getSubscription();

  /**
   *
   *
   * <pre>
   * Required. The subscription resource to create.
   * </pre>
   *
   * <code>
   * .google.apps.events.subscriptions.v1beta.Subscription subscription = 1 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   */
  com.google.apps.events.subscriptions.v1beta.SubscriptionOrBuilder getSubscriptionOrBuilder();

  /**
   *
   *
   * <pre>
   * Optional. If set to `true`, validates and previews the request, but doesn't
   * create the subscription.
   * </pre>
   *
   * <code>bool validate_only = 2 [(.google.api.field_behavior) = OPTIONAL];</code>
   *
   * @return The validateOnly.
   */
  boolean getValidateOnly();
}
