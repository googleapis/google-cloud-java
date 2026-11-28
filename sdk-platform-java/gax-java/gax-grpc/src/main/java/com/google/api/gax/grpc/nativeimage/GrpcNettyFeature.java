/*
 * Copyright 2022 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.api.gax.grpc.nativeimage;

import static com.google.api.gax.nativeimage.NativeImageUtils.registerClassForJni;
import static com.google.api.gax.nativeimage.NativeImageUtils.registerClassForReflection;
import static com.google.api.gax.nativeimage.NativeImageUtils.registerClassHierarchyForJni;
import static com.google.api.gax.nativeimage.NativeImageUtils.registerClassHierarchyForReflection;
import static com.google.api.gax.nativeimage.NativeImageUtils.registerForReflectiveInstantiation;
import static com.google.api.gax.nativeimage.NativeImageUtils.registerForUnsafeFieldAccess;

import java.lang.reflect.Method;
import org.graalvm.nativeimage.Platform;
import org.graalvm.nativeimage.hosted.Feature;
import org.jspecify.annotations.NullMarked;

/** Configures Native Image settings for the grpc-netty-shaded dependency. */
@NullMarked
final class GrpcNettyFeature implements Feature {

  private static final String GRPC_NETTY_SHADED_CLASS =
      "io.grpc.netty.shaded.io.grpc.netty.NettyServer";

  private static final String GOOGLE_AUTH_CLASS =
      "com.google.auth.oauth2.ServiceAccountCredentials";

  private static final String NETTY_SHADED_PACKAGE =
      "io.grpc.netty.shaded.io.netty.util.internal.shaded.";

  private static final String TCNATIVE_PACKAGE = "io.grpc.netty.shaded.io.netty.internal.tcnative.";

  private static final String[] TCNATIVE_CALLBACK_TYPES = {
    TCNATIVE_PACKAGE + "AsyncSSLPrivateKeyMethod",
    TCNATIVE_PACKAGE + "CertificateCallback",
    TCNATIVE_PACKAGE + "CertificateCompressionAlgo",
    TCNATIVE_PACKAGE + "CertificateRequestedCallback",
    TCNATIVE_PACKAGE + "CertificateVerifier",
    TCNATIVE_PACKAGE + "KeyLogCallback",
    TCNATIVE_PACKAGE + "ResultCallback",
    TCNATIVE_PACKAGE + "SSLPrivateKeyMethod",
    TCNATIVE_PACKAGE + "SSLSessionCache",
    TCNATIVE_PACKAGE + "SniHostNameMatcher",
  };

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
      registerClassHierarchyForReflection(access, GOOGLE_AUTH_CLASS);
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
      registerForUnsafeFieldAccess(
          access, "io.grpc.netty.shaded.io.netty.buffer.AbstractReferenceCountedByteBuf", "refCnt");
      registerForUnsafeFieldAccess(
          access, "io.grpc.netty.shaded.io.netty.util.AbstractReferenceCounted", "refCnt");
      registerClassForReflection(access, "io.grpc.netty.shaded.io.netty.channel.DefaultFileRegion");
      registerClassForReflection(
          access, "io.grpc.netty.shaded.io.netty.channel.unix.PeerCredentials");
      registerClassForReflection(
          access, "io.grpc.netty.shaded.io.netty.channel.DefaultChannelPipeline");
      registerClassForReflection(
          access, "io.grpc.netty.shaded.io.grpc.netty.WriteBufferingAndExceptionHandler");
      registerClassForReflection(
          access, "io.grpc.netty.shaded.io.netty.channel.ProtocolNegotiators");
      registerClassForReflection(access, "io.grpc.netty.shaded.io.netty.handler.ssl.SslHandler");
      registerClassForReflection(access, "io.grpc.netty.shaded.io.grpc.netty.NettyClientHandler");
      registerClassForReflection(
          access, "io.grpc.netty.shaded.io.netty.channel.DefaultChannelPipeline$HeadContext");
      registerClassForReflection(
          access, "io.grpc.netty.shaded.io.netty.channel.DefaultChannelPipeline$TailContext");
      registerClassForReflection(
          access, "io.grpc.netty.shaded.io.grpc.netty.ProtocolNegotiators$WaitUntilActiveHandler");
      registerClassForReflection(
          access, "io.grpc.netty.shaded.io.grpc.netty.ProtocolNegotiators$ClientTlsHandler");
      registerClassForReflection(
          access, "io.grpc.netty.shaded.io.grpc.netty.ProtocolNegotiators$GrpcNegotiationHandler");
      registerClassForReflection(
          access, "io.grpc.netty.shaded.io.netty.channel.ChannelHandlerMask");

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
      registerClassForReflection(
          access,
          "io.grpc.netty.shaded.io.netty.channel.epoll.NativeDatagramPacketArray$NativeDatagramPacket");

      // tcnative
      registerClassForReflection(access, TCNATIVE_PACKAGE + "CertificateCallback");
      registerClassForReflection(access, TCNATIVE_PACKAGE + "CertificateCallbackTask");
      registerClassForReflection(access, TCNATIVE_PACKAGE + "SSLContext");
      registerClassForReflection(access, TCNATIVE_PACKAGE + "SSLPrivateKeyMethodDecryptTask");
      registerClassForReflection(access, TCNATIVE_PACKAGE + "SSLPrivateKeyMethodSignTask");
      registerClassForReflection(access, TCNATIVE_PACKAGE + "SSLPrivateKeyMethodTask");
      registerClassForReflection(access, TCNATIVE_PACKAGE + "SSLTask");

      loadTcnativeJniClasses(access);
      loadGrpcNettyNativeLibraryResources(nettyShadedClass);

      // Unsafe field accesses
      registerForUnsafeFieldAccess(
          access,
          NETTY_SHADED_PACKAGE + "org.jctools.queues.MpscArrayQueueProducerIndexField",
          "producerIndex");
      registerForUnsafeFieldAccess(
          access,
          NETTY_SHADED_PACKAGE + "org.jctools.queues.MpscArrayQueueProducerLimitField",
          "producerLimit");
      registerForUnsafeFieldAccess(
          access,
          NETTY_SHADED_PACKAGE + "org.jctools.queues.MpscArrayQueueConsumerIndexField",
          "consumerIndex");
      registerForUnsafeFieldAccess(
          access,
          NETTY_SHADED_PACKAGE
              + "org.jctools.queues.unpadded.MpscUnpaddedArrayQueueProducerIndexField",
          "producerIndex");
      registerForUnsafeFieldAccess(
          access,
          NETTY_SHADED_PACKAGE
              + "org.jctools.queues.unpadded.MpscUnpaddedArrayQueueProducerLimitField",
          "producerLimit");
      registerForUnsafeFieldAccess(
          access,
          NETTY_SHADED_PACKAGE
              + "org.jctools.queues.unpadded.MpscUnpaddedArrayQueueConsumerIndexField",
          "consumerIndex");
      registerForUnsafeFieldAccess(
          access,
          NETTY_SHADED_PACKAGE + "org.jctools.queues.BaseMpscLinkedArrayQueueProducerFields",
          "producerIndex");
      registerForUnsafeFieldAccess(
          access,
          NETTY_SHADED_PACKAGE + "org.jctools.queues.BaseMpscLinkedArrayQueueColdProducerFields",
          "producerLimit");
      registerForUnsafeFieldAccess(
          access,
          NETTY_SHADED_PACKAGE + "org.jctools.queues.BaseMpscLinkedArrayQueueConsumerFields",
          "consumerIndex");
      registerForUnsafeFieldAccess(
          access,
          NETTY_SHADED_PACKAGE
              + "org.jctools.queues.unpadded.BaseMpscLinkedUnpaddedArrayQueueProducerFields",
          "producerIndex");
      registerForUnsafeFieldAccess(
          access,
          NETTY_SHADED_PACKAGE
              + "org.jctools.queues.unpadded.BaseMpscLinkedUnpaddedArrayQueueColdProducerFields",
          "producerLimit");
      registerForUnsafeFieldAccess(
          access,
          NETTY_SHADED_PACKAGE
              + "org.jctools.queues.unpadded.BaseMpscLinkedUnpaddedArrayQueueConsumerFields",
          "consumerIndex");
    }
  }

  private static void loadTcnativeJniClasses(BeforeAnalysisAccess access) {
    if (access.findClassByName(TCNATIVE_PACKAGE + "Library") == null) {
      return;
    }
    registerClassForJni(access, TCNATIVE_PACKAGE + "AsyncSSLPrivateKeyMethod");
    registerClassForJni(access, TCNATIVE_PACKAGE + "AsyncSSLPrivateKeyMethodAdapter");
    registerClassForJni(access, TCNATIVE_PACKAGE + "AsyncTask");
    registerClassForJni(access, TCNATIVE_PACKAGE + "Buffer");
    registerClassForJni(access, TCNATIVE_PACKAGE + "CertificateCallback");
    registerClassForJni(access, TCNATIVE_PACKAGE + "CertificateCallbackTask");
    registerClassForJni(access, TCNATIVE_PACKAGE + "CertificateCompressionAlgo");
    registerClassForJni(access, TCNATIVE_PACKAGE + "CertificateRequestedCallback");
    registerClassForJni(access, TCNATIVE_PACKAGE + "CertificateVerifier");
    registerClassForJni(access, TCNATIVE_PACKAGE + "CertificateVerifierTask");
    registerClassForJni(access, TCNATIVE_PACKAGE + "KeyLogCallback");
    registerClassForJni(access, TCNATIVE_PACKAGE + "Library");
    registerClassForJni(access, TCNATIVE_PACKAGE + "NativeStaticallyReferencedJniMethods");
    registerClassForJni(access, TCNATIVE_PACKAGE + "ResultCallback");
    registerClassForJni(access, TCNATIVE_PACKAGE + "SSL");
    registerClassForJni(access, TCNATIVE_PACKAGE + "SSLContext");
    registerClassForJni(access, TCNATIVE_PACKAGE + "SSLCredential");
    registerClassForJni(access, TCNATIVE_PACKAGE + "SSLPrivateKeyMethod");
    registerClassForJni(access, TCNATIVE_PACKAGE + "SSLPrivateKeyMethodDecryptTask");
    registerClassForJni(access, TCNATIVE_PACKAGE + "SSLPrivateKeyMethodSignTask");
    registerClassHierarchyForJni(access, TCNATIVE_PACKAGE + "SSLPrivateKeyMethodTask");
    registerClassForJni(access, TCNATIVE_PACKAGE + "SSLSession");
    registerClassForJni(access, TCNATIVE_PACKAGE + "SSLSessionCache");
    registerClassHierarchyForJni(access, TCNATIVE_PACKAGE + "SSLTask");
    registerClassForJni(access, TCNATIVE_PACKAGE + "SessionTicketKey");
    registerClassForJni(access, TCNATIVE_PACKAGE + "SniHostNameMatcher");

    for (String callbackType : TCNATIVE_CALLBACK_TYPES) {
      registerSubtypesForJni(access, callbackType);
    }

    registerClassForJni(access, "java.lang.Exception");
    registerClassForJni(access, "java.lang.IllegalArgumentException");
    registerClassForJni(access, "java.lang.NullPointerException");
    registerClassForJni(access, "java.lang.OutOfMemoryError");
    registerClassForJni(access, "java.lang.String");
    registerClassForJni(access, "java.lang.UnsupportedOperationException");
    registerClassForJni(access, "java.nio.ByteBuffer");
    registerClassForJni(byte[].class);
    registerClassForJni(byte[][].class);
    registerClassForJni(String[].class);
  }

  private static void registerSubtypesForJni(BeforeAnalysisAccess access, String baseClassName) {
    Class<?> baseClass = access.findClassByName(baseClassName);
    if (baseClass != null) {
      access.registerSubtypeReachabilityHandler(
          (duringAccess, subtype) -> {
            for (Class<?> current = subtype;
                current != null && current != Object.class;
                current = current.getSuperclass()) {
              registerClassForJni(current);
            }
          },
          baseClass);
    }
  }

  private static void loadGrpcNettyNativeLibraryResources(Class<?> nettyShadedClass) {
    if (Platform.includedIn(Platform.LINUX_AMD64.class)) {
      registerNativeLibraryResource(
          nettyShadedClass,
          "META-INF/native/libio_grpc_netty_shaded_netty_tcnative_linux_x86_64.so");
      registerNativeLibraryResource(
          nettyShadedClass,
          "META-INF/native/libio_grpc_netty_shaded_netty_transport_native_epoll_x86_64.so");
    } else if (Platform.includedIn(Platform.LINUX_AARCH64.class)) {
      registerNativeLibraryResource(
          nettyShadedClass,
          "META-INF/native/libio_grpc_netty_shaded_netty_tcnative_linux_aarch_64.so");
      registerNativeLibraryResource(
          nettyShadedClass,
          "META-INF/native/libio_grpc_netty_shaded_netty_transport_native_epoll_aarch_64.so");
    } else if (Platform.includedIn(Platform.DARWIN_AMD64.class)) {
      registerNativeLibraryResource(
          nettyShadedClass,
          "META-INF/native/libio_grpc_netty_shaded_netty_tcnative_osx_x86_64.jnilib");
    } else if (Platform.includedIn(Platform.DARWIN_AARCH64.class)) {
      registerNativeLibraryResource(
          nettyShadedClass,
          "META-INF/native/libio_grpc_netty_shaded_netty_tcnative_osx_aarch_64.jnilib");
    } else if (Platform.includedIn(Platform.WINDOWS_AMD64.class)) {
      registerNativeLibraryResource(
          nettyShadedClass,
          "META-INF/native/io_grpc_netty_shaded_netty_tcnative_windows_x86_64.dll");
    }
  }

  private static void registerNativeLibraryResource(Class<?> ownerClass, String resourcePath) {
    ClassLoader classLoader = ownerClass.getClassLoader();
    if (classLoader == null || classLoader.getResource(resourcePath) == null) {
      return;
    }
    // Use reflection to keep gax-grpc compatible with Java 8 compilation (--release 8).
    try {
      Class<?> moduleClass = Class.forName("java.lang.Module");
      Object module = Class.class.getMethod("getModule").invoke(ownerClass);
      Class<?> resourceAccess =
          Class.forName("org.graalvm.nativeimage.hosted.RuntimeResourceAccess");
      Method addResource = resourceAccess.getMethod("addResource", moduleClass, String.class);
      addResource.invoke(null, module, resourcePath);
    } catch (ReflectiveOperationException e) {
      throw new IllegalStateException("Failed to register native resource " + resourcePath, e);
    }
  }

  /** Miscellaneous classes that need to be registered coming from various JARs. */
  private static void loadMiscClasses(BeforeAnalysisAccess access) {
    registerClassHierarchyForReflection(access, "com.google.protobuf.DescriptorProtos");
    registerClassForReflection(access, "com.google.api.FieldBehavior");
    registerClassForReflection(access, "java.time.Instant");
    registerForUnsafeFieldAccess(access, "javax.net.ssl.SSLContext", "contextSpi");
  }
}
