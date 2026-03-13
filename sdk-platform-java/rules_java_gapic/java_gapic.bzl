# Copyright 2020 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

load("@rules_gapic//:gapic.bzl", "proto_custom_library")

NO_GRPC_CONFIG_ALLOWLIST = ["library"]

def _java_gapic_postprocess_srcjar_impl(ctx):
    gapic_srcjar = ctx.file.gapic_srcjar
    output_srcjar_name = ctx.label.name
    output_main = ctx.outputs.main
    output_test = ctx.outputs.test
    output_samples = ctx.outputs.samples
    output_resource_name = ctx.outputs.resource_name
    formatter = ctx.executable.formatter

    output_dir_name = ctx.label.name
    output_dir_path = "%s/%s" % (output_main.dirname, output_dir_name)

    script = """
    unzip -q {gapic_srcjar}
    # Sync'd to the output file name in Writer.java.
    unzip -q temp-codegen.srcjar -d {output_dir_path}
    # This may fail if there are spaces and/or too many files (exceed max length of command length).
    {formatter} --replace $(find {output_dir_path} -type f -printf "%p ")
    WORKING_DIR=`pwd`

    # Main source files.
    cd {output_dir_path}/src/main
    zip -r $WORKING_DIR/{output_srcjar_name}.srcjar ./

    # Resource name source files.
    PROTO_DIR=$WORKING_DIR/{output_dir_path}/proto/src/main/java
    PROTO_SRCJAR=$WORKING_DIR/{output_srcjar_name}-resource-name.srcjar
    if [ ! -d $PROTO_DIR ]
    then
      # Some APIs don't have resource name helpers, like BigQuery v2.
      # Create an empty file so we can finish building. Gating the resource name rule definition
      # on file existences go against Bazel's design patterns, so we'll simply delete all empty
      # files during the final packaging process (see java_gapic_pkg.bzl)
      mkdir -p $PROTO_DIR
      touch $PROTO_DIR/PlaceholderFile.java
    fi
    cd $WORKING_DIR/{output_dir_path}/proto/src/main/java
    zip -r $PROTO_SRCJAR ./

    # Test source files.
    cd $WORKING_DIR/{output_dir_path}/src/test/java
    zip -r $WORKING_DIR/{output_srcjar_name}-tests.srcjar ./

    # Sample source files.
    cd $WORKING_DIR/{output_dir_path}/samples/snippets/generated/src/main/java
    zip -r $WORKING_DIR/{output_srcjar_name}-samples.srcjar ./

    cd $WORKING_DIR

    mv {output_srcjar_name}.srcjar {output_main}
    mv {output_srcjar_name}-resource-name.srcjar {output_resource_name}
    mv {output_srcjar_name}-tests.srcjar {output_test}
    mv {output_srcjar_name}-samples.srcjar {output_samples}
    """.format(
        gapic_srcjar = gapic_srcjar.path,
        output_srcjar_name = output_srcjar_name,
        formatter = formatter,
        output_dir_name = output_dir_name,
        output_dir_path = output_dir_path,
        output_main = output_main.path,
        output_resource_name = output_resource_name.path,
        output_test = output_test.path,
        output_samples = output_samples.path,
    )

    ctx.actions.run_shell(
        inputs = [gapic_srcjar],
        tools = [formatter],
        command = script,
        outputs = [output_main, output_resource_name, output_test, output_samples],
    )

_java_gapic_postprocess_srcjar = rule(
    attrs = {
        "gapic_srcjar": attr.label(mandatory = True, allow_single_file = True),
        "formatter": attr.label(
            default = Label("//:google_java_format_binary"),
            executable = True,
            cfg = "exec",
        ),
    },
    outputs = {
        "main": "%{name}.srcjar",
        "resource_name": "%{name}-resource-name.srcjar",
        "test": "%{name}-test.srcjar",
        "samples": "%{name}-samples.srcjar",
    },
    implementation = _java_gapic_postprocess_srcjar_impl,
)

def _java_gapic_samples_srcjar_impl(ctx):
    gapic_srcjar = ctx.file.gapic_srcjar
    output_srcjar_name = ctx.label.name
    output_samples = ctx.outputs.samples
    formatter = ctx.executable.formatter

    output_dir_name = ctx.label.name
    output_dir_path = "%s/%s" % (output_samples.dirname, output_dir_name)

    script = """
    unzip -q {gapic_srcjar}
    # Sync'd to the output file name in Writer.java.
    unzip -q temp-codegen.srcjar -d {output_dir_path}
    # This may fail if there are spaces and/or too many files (exceed max length of command length).
    {formatter} --replace $(find {output_dir_path} -type f -printf "%p ")
    WORKING_DIR=`pwd`

    # Sample source files.
    cd $WORKING_DIR/{output_dir_path}/samples/snippets/generated/src/main/java
    zip -r $WORKING_DIR/{output_srcjar_name}-samples.srcjar ./

    cd $WORKING_DIR

    mv {output_srcjar_name}-samples.srcjar {output_samples}
    """.format(
        gapic_srcjar = gapic_srcjar.path,
        output_srcjar_name = output_srcjar_name,
        formatter = formatter,
        output_dir_name = output_dir_name,
        output_dir_path = output_dir_path,
        output_samples = output_samples.path,
    )

    ctx.actions.run_shell(
        inputs = [gapic_srcjar],
        tools = [formatter],
        command = script,
        outputs = [output_samples],
    )

_java_gapic_samples_srcjar = rule(
    attrs = {
        "gapic_srcjar": attr.label(mandatory = True, allow_single_file = True),
        "formatter": attr.label(
            default = Label("//:google_java_format_binary"),
            executable = True,
            cfg = "exec",
        ),
    },
    outputs = {
        "samples": "%{name}-samples.srcjar",
    },
    implementation = _java_gapic_samples_srcjar_impl,
)

def _extract_common_proto_dep(dep):
    return dep[dep.index("/"):] if "//google" in dep else dep

def _append_dep_without_duplicates(dest_deps, new_deps):
    """
    Appends new_deps into dest_deps only if elements in new_deps
    are not already present in dest_deps.
    A workaround for the lack of sets in skylark.
    """

    # Naive dep checking, since the source (i.e. prefixed) repo can vary.
    # Examine only "//google"-prefixed targets, since common proto deps
    # are more likely to be duplicated.
    processed_dest_deps = [_extract_common_proto_dep(dep) for dep in dest_deps]
    processed_new_deps = [_extract_common_proto_dep(dep) for dep in new_deps]
    for i in range(len(new_deps)):
        if processed_new_deps[i] not in processed_dest_deps:
            dest_deps.append(new_deps[i])
    return dest_deps

def _java_gapic_srcjar(
        name,
        srcs,
        grpc_service_config,
        gapic_yaml,
        service_yaml,
        # possible values are: "grpc", "rest", "grpc+rest"
        transport,
        rest_numeric_enums,
        # Can be used to provide a java_library with a customized generator,
        # like the one which dumps descriptor to a file for future debugging.
        java_generator_name = "java_gapic",
        **kwargs):
    file_args_dict = {}

    if grpc_service_config:
        file_args_dict[grpc_service_config] = "grpc-service-config"
    elif not transport or transport == "grpc":
        for keyword in NO_GRPC_CONFIG_ALLOWLIST:
            if keyword not in name:
                fail("Missing a gRPC service config file")

    if gapic_yaml:
        file_args_dict[gapic_yaml] = "gapic-config"

    if service_yaml:
        file_args_dict[service_yaml] = "api-service-config"

    opt_args = []

    if transport:
        opt_args.append("transport=%s" % transport)

    if rest_numeric_enums:
        opt_args.append("rest-numeric-enums")

    # Produces the GAPIC metadata file if this flag is set. to any value.
    # Protoc invocation: --java_gapic_opt=metadata
    plugin_args = ["metadata"]

    proto_custom_library(
        name = name,
        deps = srcs,
        plugin = Label("@gapic_generator_java//:protoc-gen-%s" % java_generator_name),
        plugin_args = plugin_args,
        plugin_file_args = {},
        opt_file_args = file_args_dict,
        output_type = java_generator_name,
        output_suffix = ".srcjar",
        opt_args = opt_args,
        **kwargs
    )

def java_gapic_library(
        name,
        srcs,
        grpc_service_config = None,
        gapic_yaml = None,
        service_yaml = None,
        deps = [],
        test_deps = [],
        # possible values are: "grpc", "rest", "grpc+rest"
        transport = None,
        rest_numeric_enums = False,
        **kwargs):
    srcjar_name = name + "_srcjar"
    raw_srcjar_name = srcjar_name + "_raw"

    _java_gapic_srcjar(
        name = raw_srcjar_name,
        srcs = srcs,
        grpc_service_config = grpc_service_config,
        gapic_yaml = gapic_yaml,
        service_yaml = service_yaml,
        transport = transport,
        rest_numeric_enums = rest_numeric_enums,
        java_generator_name = "java_gapic",
        **kwargs
    )

    _java_gapic_postprocess_srcjar(
        name = srcjar_name,
        gapic_srcjar = "%s.srcjar" % raw_srcjar_name,
        **kwargs
    )

    _java_gapic_samples_srcjar(
        name = "%s_samples" % name,
        gapic_srcjar = "%s.srcjar" % raw_srcjar_name,
        **kwargs
    )

    resource_name_name = "%s_resource_name" % name
    resource_name_deps = [resource_name_name]
    native.java_library(
        name = resource_name_name,
        srcs = ["%s-resource-name.srcjar" % srcjar_name],
        deps = [
            "@com_google_api_api_common//jar",
            "@com_google_guava_guava//jar",
            "@javax_annotation_javax_annotation_api//jar",
        ],
        **kwargs
    )

    # General additional deps.
    actual_deps = deps + resource_name_deps + [
        "@com_google_googleapis//google/rpc:rpc_java_proto",
        "@com_google_googleapis//google/longrunning:longrunning_java_proto",
        "@com_google_protobuf//:protobuf_java",
        "@com_google_api_api_common//jar",
        "@com_google_api_gax_java//gax:gax",
        "@com_google_guava_guava//jar",
        "@com_google_code_findbugs_jsr305//jar",
        "@org_threeten_threetenbp//jar",
        "@io_opencensus_opencensus_api//jar",
        "@com_google_auth_google_auth_library_credentials//jar",
        "@com_google_auth_google_auth_library_oauth2_http//jar",
        "@com_google_http_client_google_http_client//jar",
        "@javax_annotation_javax_annotation_api//jar",
    ]

    if not transport or transport == "grpc":
        actual_deps += [
            "@com_google_api_gax_java//gax-grpc:gax_grpc",
            "@io_grpc_grpc_java//core:core",
            "@io_grpc_grpc_java//protobuf:protobuf",
        ]
    elif transport == "rest":
        actual_deps += [
            "@com_google_api_gax_java//gax-httpjson:gax_httpjson",
        ]
    elif transport == "grpc+rest":
        actual_deps += [
            "@com_google_api_gax_java//gax-grpc:gax_grpc",
            "@io_grpc_grpc_java//core:core",
            "@io_grpc_grpc_java//protobuf:protobuf",
            "@com_google_api_gax_java//gax-httpjson:gax_httpjson",
        ]
    else:
        fail("Unknown transport: %s" % transport)

    native.java_library(
        name = name,
        srcs = ["%s.srcjar" % srcjar_name],
        deps = actual_deps,
        **kwargs
    )

    # Test deps.
    actual_test_deps = [
        "@com_google_googleapis//google/type:type_java_proto",  # Commonly used.
        "@com_google_googleapis//google/geo/type:viewport_java_proto",  # Used by Geo.
        "@com_google_api_gax_java//gax:gax_testlib",
        "@com_google_code_gson_gson//jar",
        "@junit_junit//jar",
    ]

    if not transport or transport == "grpc":
        actual_test_deps += [
            "@com_google_api_gax_java//gax-grpc:gax_grpc_testlib",
            "@io_grpc_grpc_java//auth:auth",
            "@io_grpc_grpc_netty_shaded//jar",
            "@io_grpc_grpc_java//stub:stub",
            "@io_opencensus_opencensus_contrib_grpc_metrics//jar",
        ]
    elif transport == "rest":
        actual_test_deps += [
            "@com_google_api_gax_java//gax-httpjson:gax_httpjson_testlib",
        ]
    elif transport == "grpc+rest":
        actual_test_deps += [
            "@com_google_api_gax_java//gax-grpc:gax_grpc_testlib",
            "@io_grpc_grpc_java//auth:auth",
            "@io_grpc_grpc_netty_shaded//jar",
            "@io_grpc_grpc_java//stub:stub",
            "@io_opencensus_opencensus_contrib_grpc_metrics//jar",
            "@com_google_api_gax_java//gax-httpjson:gax_httpjson_testlib",
        ]
    else:
        fail("Unknown transport: %s" % transport)

    _append_dep_without_duplicates(actual_test_deps, test_deps)
    _append_dep_without_duplicates(actual_test_deps, actual_deps)

    native.java_library(
        name = "%s_test" % name,
        srcs = ["%s-test.srcjar" % srcjar_name],
        deps = [":%s" % name] + actual_test_deps,
        **kwargs
    )

def java_gapic_test(name, runtime_deps, test_classes, **kwargs):
    for test_class in test_classes:
        native.java_test(
            name = test_class,
            test_class = test_class,
            runtime_deps = runtime_deps,
            **kwargs
        )
    native.test_suite(
        name = name,
        tests = test_classes,
        **kwargs
    )

# A debugging rule, to dump CodeGenereatorRequest from protoc as is to a file,
# which then can be used to run gapic-generator directly instead of relying on
# protoc to launch it. This would simplify attaching the debugger and/or
# working with stdin/stderr.
def java_generator_request_dump(
        name,
        srcs,
        grpc_service_config = None,
        gapic_yaml = None,
        service_yaml = None,
        transport = None,
        rest_numeric_enums = False,
        **kwargs):
    _java_gapic_srcjar(
        name = name,
        srcs = srcs,
        grpc_service_config = grpc_service_config,
        gapic_yaml = gapic_yaml,
        service_yaml = service_yaml,
        transport = transport,
        rest_numeric_enums = rest_numeric_enums,
        java_generator_name = "code_generator_request_dumper",
        **kwargs
    )
