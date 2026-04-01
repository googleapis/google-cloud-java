# Copyright 2019 Google LLC
#
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions are
# met:
#
#     * Redistributions of source code must retain the above copyright
# notice, this list of conditions and the following disclaimer.
#     * Redistributions in binary form must reproduce the above
# copyright notice, this list of conditions and the following disclaimer
# in the documentation and/or other materials provided with the
# distribution.
#     * Neither the name of Google LLC nor the names of its
# contributors may be used to endorse or promote products derived from
# this software without specific prior written permission.
#
# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
# "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
# LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
# A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
# OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
# SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
# LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
# DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
# THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
# (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
# OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
load("@bazel_tools//tools/build_defs/repo:jvm.bzl", "jvm_maven_import_external")
load("@com_google_api_gax_java_properties//:dependencies.properties.bzl", "PROPERTIES")

def com_google_api_gax_java_repositories():
    # Import dependencies shared between Gradle and Bazel (i.e. maven dependencies)
    for name, artifact in PROPERTIES.items():
        _maybe(
            jvm_maven_import_external,
            name = name,
            strip_repo_prefix = "maven.",
            artifact = _fix_bazel_artifact_format(artifact),
            server_urls = ["https://repo.maven.apache.org/maven2/", "http://repo1.maven.org/maven2/"],
            licenses = ["notice", "reciprocal"],
        )

    # Import Bazel-only dependencies (Gradle version will import maven artifacts of same
    # version, while Bazel will depend on Bazel workspaces). The versions are shared in the
    # properties file.

    _protobuf_version = PROPERTIES["version.com_google_protobuf"]
    _protobuf_version_in_link = "v%s" % _protobuf_version
    _maybe(
        http_archive,
        name = "com_google_protobuf",
        urls = ["https://github.com/protocolbuffers/protobuf/archive/%s.zip" % _protobuf_version_in_link],
        strip_prefix = "protobuf-%s" % _protobuf_version,
    )

    _grpc_version = PROPERTIES["version.io_grpc"]
    _grpc_version_in_link = "v%s" % _grpc_version
    _maybe(
        http_archive,
        name = "io_grpc_grpc_java",
        urls = ["https://github.com/grpc/grpc-java/archive/%s.zip" % _grpc_version_in_link],
        strip_prefix = "grpc-java-%s" % _grpc_version,
    )

    _bazel_skylib_version = "1.0.3"
    _maybe(
        http_archive,
        name = "bazel_skylib",
        strip_prefix = "bazel-skylib-%s" % _bazel_skylib_version,
        urls = ["https://github.com/bazelbuild/bazel-skylib/archive/%s.zip" % _bazel_skylib_version],
    )

    _maybe(
        jvm_maven_import_external,
        name = "com_google_protobuf_java_util",
        artifact = "com.google.protobuf:protobuf-java-util:%s" % PROPERTIES["version.com_google_protobuf"],
        server_urls = ["https://repo.maven.apache.org/maven2/", "http://repo1.maven.org/maven2/"],
        licenses = ["notice", "reciprocal"],
    )

    _maybe(
        jvm_maven_import_external,
        name = "com_google_protobuf_java",
        artifact = "com.google.protobuf:protobuf-java:%s" % PROPERTIES["version.com_google_protobuf"],
        server_urls = ["https://repo.maven.apache.org/maven2/", "http://repo1.maven.org/maven2/"],
        licenses = ["notice", "reciprocal"],
    )

    _maybe(
        jvm_maven_import_external,
        name = "io_grpc_grpc_netty_shaded",
        artifact = "io.grpc:grpc-netty-shaded:%s" % PROPERTIES["version.io_grpc"],
        server_urls = ["https://repo.maven.apache.org/maven2/", "http://repo1.maven.org/maven2/"],
        licenses = ["notice", "reciprocal"],
    )

    _maybe(
        jvm_maven_import_external,
        name = "io_grpc_grpc_grpclb",
        artifact = "io.grpc:grpc-grpclb:%s" % PROPERTIES["version.io_grpc"],
        server_urls = ["https://repo.maven.apache.org/maven2/", "http://repo1.maven.org/maven2/"],
        licenses = ["notice", "reciprocal"],
    )

    _maybe(
        jvm_maven_import_external,
        name = "google_java_format_all_deps",
        artifact = "com.google.googlejavaformat:google-java-format:jar:all-deps:%s" % PROPERTIES["version.google_java_format"],
        server_urls = ["https://repo.maven.apache.org/maven2/", "http://repo1.maven.org/maven2/"],
        licenses = ["notice", "reciprocal"],
    )

    _maybe(
        native.bind,
        name = "guava",
        actual = "@com_google_guava_guava//jar",
    )

    _maybe(
        native.bind,
        name = "gson",
        actual = "@com_google_code_gson_gson//jar",
    )

    _maybe(
        native.bind,
        name = "error_prone_annotations",
        actual = "@com_google_errorprone_error_prone_annotations//jar",
    )

def _maybe(repo_rule, name, strip_repo_prefix = "", **kwargs):
    if not name.startswith(strip_repo_prefix):
        return
    repo_name = name[len(strip_repo_prefix):]
    if repo_name in native.existing_rules():
        return
    repo_rule(name = repo_name, **kwargs)

def _fix_bazel_artifact_format(artifact_id):
    # Fix the artifact id format discrepancy between Bazel & Gradle.
    # This is relevant only when classifier is specified explicitly.
    # Bazel format:  groupId:artifactId:jar:classifier:version
    # Gradle format: groupId:artifactId:version:classifier
    ids = artifact_id.split(":")
    if len(ids) != 4:
        return artifact_id
    return "%s:%s:%s:%s:%s" % (ids[0], ids[1], "jar", ids[3], ids[2])
