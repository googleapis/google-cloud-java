/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.nativeimage.features;

import static com.google.cloud.nativeimage.features.NativeImageUtils.registerClassForReflection;
import static com.google.cloud.nativeimage.features.NativeImageUtils.registerClassHierarchyForReflection;
import static com.google.cloud.nativeimage.features.NativeImageUtils.registerForReflectiveInstantiation;
import static com.google.cloud.nativeimage.features.NativeImageUtils.registerForUnsafeFieldAccess;

import com.oracle.svm.core.annotate.AutomaticFeature;
import org.graalvm.nativeimage.hosted.Feature;

/** Configures Native Image settings for the grpc-netty-shaded dependency. */
@AutomaticFeature
final class GrpcNettyFeature implements Feature {

  private static final String GRPC_NETTY_SHADED_CLASS =
      "io.grpc.netty.shaded.io.grpc.netty.NettyServer";

  private static final String GOOGLE_AUTH_CLASS =
      "com.google.auth.oauth2.ServiceAccountCredentials";

  @Override
  public void beforeAnalysis(BeforeAnalysisAccess access) {
    loadGoogleAuthClasses(access);
    loadGrpcNettyClasses(access);
    loadMiscClasses(access);
  }

  private static void loadGoogleAuthClasses(BeforeAnalysisAccess access) {
    // For com.google.auth:google-auth-library-oauth2-http
    Class<?> authClass = access.findClassByName(GOOGLE_AUTH_CLASS);
    if (authClass != null) {
      registerClassHierarchyForReflection(
          access, "com.google.auth.oauth2.ServiceAccountCredentials");
      registerClassHierarchyForReflection(
          access, "com.google.auth.oauth2.ServiceAccountJwtAccessCredentials");
    }
  }

  private static void loadGrpcNettyClasses(BeforeAnalysisAccess access) {
    // For io.grpc:grpc-netty-shaded
    Class<?> nettyShadedClass = access.findClassByName(GRPC_NETTY_SHADED_CLASS);
    if (nettyShadedClass != null) {
      // Misc. classes used by grpc-netty-shaded
      registerForReflectiveInstantiation(
          access, "io.grpc.netty.shaded.io.netty.channel.socket.nio.NioSocketChannel");
      registerClassForReflection(
          access, "io.grpc.netty.shaded.io.netty.util.internal.NativeLibraryUtil");
      registerClassForReflection(access, "io.grpc.netty.shaded.io.netty.util.ReferenceCountUtil");
      registerClassForReflection(
          access, "io.grpc.netty.shaded.io.netty.buffer.AbstractByteBufAllocator");

      // Epoll Libraries
      registerClassForReflection(access, "io.grpc.netty.shaded.io.netty.channel.epoll.Epoll");
      registerClassForReflection(
          access, "io.grpc.netty.shaded.io.netty.channel.epoll.EpollChannelOption");
      registerClassForReflection(
          access, "io.grpc.netty.shaded.io.netty.channel.epoll.EpollEventLoopGroup");
      registerForReflectiveInstantiation(
          access, "io.grpc.netty.shaded.io.netty.channel.epoll.EpollServerSocketChannel");
      registerForReflectiveInstantiation(
          access, "io.grpc.netty.shaded.io.netty.channel.epoll.EpollSocketChannel");

      // Unsafe field accesses
      registerForUnsafeFieldAccess(
          access,
          "io.grpc.netty.shaded.io.netty.util.internal.shaded."
              + "org.jctools.queues.MpscArrayQueueProducerIndexField",
          "producerIndex");
      registerForUnsafeFieldAccess(
          access,
          "io.grpc.netty.shaded.io.netty.util.internal.shaded."
              + "org.jctools.queues.MpscArrayQueueProducerLimitField",
          "producerLimit");
      registerForUnsafeFieldAccess(
          access,
          "io.grpc.netty.shaded.io.netty.util.internal.shaded."
              + "org.jctools.queues.MpscArrayQueueConsumerIndexField",
          "consumerIndex");
      registerForUnsafeFieldAccess(
          access,
          "io.grpc.netty.shaded.io.netty.util.internal.shaded."
              + "org.jctools.queues.BaseMpscLinkedArrayQueueProducerFields",
          "producerIndex");
      registerForUnsafeFieldAccess(
          access,
          "io.grpc.netty.shaded.io.netty.util.internal.shaded."
              + "org.jctools.queues.BaseMpscLinkedArrayQueueColdProducerFields",
          "producerLimit");
      registerForUnsafeFieldAccess(
          access,
          "io.grpc.netty.shaded.io.netty.util.internal.shaded."
              + "org.jctools.queues.BaseMpscLinkedArrayQueueConsumerFields",
          "consumerIndex");
    }
  }

  /** Miscellaneous classes that need to be registered coming from various JARs. */
  private static void loadMiscClasses(BeforeAnalysisAccess access) {
    registerClassHierarchyForReflection(access, "com.google.protobuf.DescriptorProtos");
    registerClassForReflection(access, "com.google.api.FieldBehavior");

    registerForUnsafeFieldAccess(access, "javax.net.ssl.SSLContext", "contextSpi");
    registerClassForReflection(access, "java.lang.management.ManagementFactory");
    registerClassForReflection(access, "java.lang.management.RuntimeMXBean");
  }
}
