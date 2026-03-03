# Copyright 2019 Google LLC
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

load("@com_google_api_gax_java_properties//:dependencies.properties.bzl", "PROPERTIES")
load("@com_google_protobuf//:protobuf_version.bzl", "PROTOBUF_JAVA_VERSION")

def _wrapPropertyNamesInBraces(properties):
    wrappedProperties = {}
    for k, v in properties.items():
        wrappedProperties["{{%s}}" % k] = v
    return wrappedProperties

# Before this replacement, there was a problem (e.g., b/284292352) when
# the version of protobuf defined in googleapis is higher than protobuf
# defined in gax-java/dependencies.properties, use this replacement to
# sync the two versions.
SYNCED_PROPERTIES = dict(PROPERTIES)
SYNCED_PROPERTIES.update({"version.com_google_protobuf": PROTOBUF_JAVA_VERSION})
_PROPERTIES = _wrapPropertyNamesInBraces(SYNCED_PROPERTIES)

# ========================================================================
# General packaging helpers.
# ========================================================================

def _construct_package_dir_paths(attr_package_dir, out_pkg, label_name):
    if attr_package_dir:
        package_dir = attr_package_dir
        package_dir_expr = "../{}/".format(package_dir)
        tar_cd_suffix = ".."
        tar_prefix = attr_package_dir
    else:
        package_dir = label_name
        package_dir_expr = "./"
        tar_cd_suffix = "."
        tar_prefix = "."

    # We need to include label in the path to eliminate possible output files duplicates
    # (labels are guaranteed to be unique by bazel itself)
    package_dir_path = "%s/%s/%s" % (out_pkg.dirname, label_name, package_dir)
    return struct(
        package_dir = package_dir,
        package_dir_expr = package_dir_expr,
        package_dir_path = package_dir_path,
        package_dir_sibling_parent = out_pkg,
        package_dir_sibling_basename = label_name,
        tar_cd_suffix = tar_cd_suffix,
        tar_prefix = tar_prefix,
    )

def _put_dep_in_a_bucket(dep, dep_bucket, processed_deps):
    if processed_deps.get(dep):
        return
    dep_bucket.append(dep)
    processed_deps[dep] = True

def _gapic_pkg_tar_impl(ctx):
    deps = []
    for dep in ctx.attr.deps:
        for f in dep.files.to_list():
            deps.append(f)

    samples = []
    for s in ctx.attr.samples:
        for f in s.files.to_list():
            samples.append(f)

    paths = _construct_package_dir_paths(
        ctx.attr.package_dir,
        ctx.outputs.pkg,
        ctx.label.name,
    )

    script = """
    for s in {samples}; do
        mkdir -p {package_dir_path}/{tar_cd_suffix}/{tar_prefix}/samples/snippets/generated/
        unzip -q ./$s -d {package_dir_path}/{tar_cd_suffix}/{tar_prefix}/samples/snippets/generated/
    done

    mkdir -p {package_dir_path}
    for dep in {deps}; do
        tar -xzpf $dep -C {package_dir_path}
    done
    cd {package_dir_path}/{tar_cd_suffix}

    tar -zchpf {tar_prefix}/{package_dir}.tar.gz {tar_prefix}/*
    cd - > /dev/null
    mv {package_dir_path}/{package_dir}.tar.gz {pkg}
    rm -rf {package_dir_path}
    """.format(
        deps = " ".join(["'%s'" % d.path for d in deps]),
        package_dir_path = paths.package_dir_path,
        package_dir = paths.package_dir,
        samples = " ".join(["'%s'" % s.path for s in samples]),
        pkg = ctx.outputs.pkg.path,
        tar_cd_suffix = paths.tar_cd_suffix,
        tar_prefix = paths.tar_prefix,
    )

    ctx.actions.run_shell(
        inputs = deps + samples,
        command = script,
        outputs = [ctx.outputs.pkg],
    )

# The Bazel's native gapic_pkg_tar rule behaves weirdly when package_dir parameter
# is specified (at least on some Linux machines it does not put all the files
# under the package_dir). As a workaround for that bug we provide the custom
# implementation of the gapic_pkg_tar rule.
gapic_pkg_tar = rule(
    attrs = {
        "deps": attr.label_list(mandatory = True),
        "samples": attr.label_list(mandatory = False),
        "package_dir": attr.string(mandatory = False, default = ""),
        "extension": attr.string(mandatory = False, default = "tar.gz"),
    },
    outputs = {"pkg": "%{name}.%{extension}"},
    implementation = _gapic_pkg_tar_impl,
)

# ========================================================================
# Java Gapic package helpers.
# ========================================================================
def _construct_extra_deps(scope_to_deps, versions_map):
    label_name_to_maven_artifact = {
        "policy_proto": "maven.com_google_api_grpc_proto_google_iam_v1",
        "iam_policy_proto": "maven.com_google_api_grpc_proto_google_iam_v1",
        "iam_java_proto": "maven.com_google_api_grpc_proto_google_iam_v1",
        "iam_java_grpc": "maven.com_google_api_grpc_grpc_google_iam_v1",
        "iam_policy_java_grpc": "maven.com_google_api_grpc_grpc_google_iam_v1",
        "location_java_grpc": "maven.com_google_api_grpc_grpc_google_common_protos",
    }
    extra_deps = {}
    for scope, deps in scope_to_deps.items():
        for dep in deps:
            pkg_dependency = _get_gapic_pkg_dependency_name(dep)
            if pkg_dependency:
                key = "{{%s}}" % pkg_dependency
                if not extra_deps.get(key):
                    extra_deps[key] = "%s project(':%s')" % (scope, pkg_dependency)
            elif _is_java_dependency(dep):
                for f in dep[JavaInfo].transitive_compile_time_jars.to_list():
                    maven_artifact = label_name_to_maven_artifact.get(f.owner.name)
                    if not maven_artifact:
                        continue
                    key = "{{%s}}" % maven_artifact
                    if not extra_deps.get(key):
                        extra_deps[key] = "%s '%s'" % (scope, versions_map[key])

    return "\n  ".join(extra_deps.values())

def _is_java_dependency(dep):
    return JavaInfo in dep

def _is_source_dependency(dep):
    return _is_java_dependency(dep) and hasattr(dep[JavaInfo], "source_jars") and dep.label.package != "jar"

def _is_proto_dependency(dep):
    return ProtoInfo in dep

def _get_gapic_pkg_dependency_name(dep):
    files_list = dep.files.to_list()
    if not files_list or len(files_list) != 1:
        return None
    for ext in (".tar.gz", ".gz", ".tgz"):
        if files_list[0].basename.endswith(ext):
            return files_list[0].basename[:-len(ext)]
    return None

# ========================================================================
# Java Gapic package rules.
# ========================================================================

def _java_gapic_build_configs_pkg_impl(ctx):
    expanded_templates = []
    paths = _construct_package_dir_paths(ctx.attr.package_dir, ctx.outputs.pkg, ctx.label.name)

    substitutions = dict(ctx.attr.static_substitutions)
    substitutions["{{extra_deps}}"] = _construct_extra_deps({
        "api": ctx.attr.deps,
        "testImplementation": ctx.attr.test_deps,
    }, substitutions)

    for template in ctx.attr.templates.items():
        expanded_template = ctx.actions.declare_file(
            "%s/%s" % (paths.package_dir_sibling_basename, template[1]),
            sibling = paths.package_dir_sibling_parent,
        )
        expanded_templates.append(expanded_template)
        ctx.actions.expand_template(
            template = template[0].files.to_list()[0],
            substitutions = substitutions,
            output = expanded_template,
        )

    # Note the script is more complicated than it intuitively should be because of the limitations
    # inherent to bazel execution environment: no absolute paths allowed, the generated artifacts
    # must ensure uniqueness within a build. The template output directory manipulations are
    # to modify default 555 file permissions on any generated by bazel file (exectuable read-only,
    # which is not at all what we need for build files). There is no bazel built-in way to change
    # the generated files permissions, also the actual files accessible by the script are symlinks
    # and `chmod`, when applied to a directory, does not change the attributes of symlink targets
    # inside the directory. Chaning the symlink target's permissions is also not an option, because
    # they are on a read-only file system.
    script = """
    mkdir -p {package_dir_path}
    for templ in {templates}; do
        cp $templ {package_dir_path}/
    done
    chmod 644 {package_dir_path}/*
    cd {package_dir_path}/{tar_cd_suffix}
    tar -zchpf {tar_prefix}/{package_dir}.tar.gz {tar_prefix}/*
    cd - > /dev/null
    mv {package_dir_path}/{package_dir}.tar.gz {pkg}
    """.format(
        templates = " ".join(["'%s'" % f.path for f in expanded_templates]),
        package_dir_path = paths.package_dir_path,
        package_dir = paths.package_dir,
        pkg = ctx.outputs.pkg.path,
        tar_cd_suffix = paths.tar_cd_suffix,
        tar_prefix = paths.tar_prefix,
    )

    ctx.actions.run_shell(
        inputs = expanded_templates,
        command = script,
        outputs = [ctx.outputs.pkg],
    )

java_gapic_build_configs_pkg = rule(
    attrs = {
        "deps": attr.label_list(mandatory = True),
        "test_deps": attr.label_list(mandatory = False, allow_empty = True),
        "package_dir": attr.string(mandatory = False),
        "templates": attr.label_keyed_string_dict(mandatory = False, allow_files = True),
        "static_substitutions": attr.string_dict(mandatory = False, allow_empty = True, default = {}),
    },
    outputs = {"pkg": "%{name}.tar.gz"},
    implementation = _java_gapic_build_configs_pkg_impl,
)

def _java_gapic_srcs_pkg_impl(ctx):
    srcs = []
    proto_srcs = []
    for src_dep in ctx.attr.deps:
        if _is_source_dependency(src_dep):
            srcs.extend(src_dep[JavaInfo].source_jars)
        if _is_proto_dependency(src_dep):
            proto_srcs.extend(src_dep[ProtoInfo].check_deps_sources.to_list())

    test_srcs = []
    for test_src_dep in ctx.attr.test_deps:
        if _is_source_dependency(test_src_dep):
            test_srcs.extend(test_src_dep[JavaInfo].source_jars)

    paths = _construct_package_dir_paths(ctx.attr.package_dir, ctx.outputs.pkg, ctx.label.name)

    # Note the script is more complicated than it intuitively should be because of limitations
    # inherent to bazel execution environment: no absolute paths allowed, the generated artifacts
    # must ensure uniqueness within a build.
    script = """
    for src in {srcs}; do
        mkdir -p {package_dir_path}/src/main/java
        unzip -q -o $src -d {package_dir_path}/src/main/java
        rm -r -f {package_dir_path}/src/main/java/META-INF

        # GAPIC libraries generate java/ and resources/ folders, unlike grpc and proto.
        # If this is a GAPIC library, move its output up one directory.
        if [ -d {package_dir_path}/src/main/java/java ]; then
          mv {package_dir_path}/src/main/java {package_dir_path}/src/main/tmp-java
          mv {package_dir_path}/src/main/tmp-java/* {package_dir_path}/src/main
          rm -d {package_dir_path}/src/main/tmp-java
        fi

        # Remove empty files. If there are no resource names, one such file might have
        # been created. See java_gapic.bzl.
        find {package_dir_path}/src/main/java -type f -size 0 | while read f; do rm -f $f; done

        if [ -d {package_dir_path}/src/main/java/samples ]; then
            mv {package_dir_path}/src/main/java/samples {package_dir_path}
        fi
    done
    for proto_src in {proto_srcs}; do
        mkdir -p {package_dir_path}/src/main/proto
        cp -f --parents $proto_src {package_dir_path}/src/main/proto
    done
    for test_src in {test_srcs}; do
        mkdir -p {package_dir_path}/src/test/java
        unzip -q -o $test_src -d {package_dir_path}/src/test/java
        rm -r -f {package_dir_path}/src/test/java/META-INF
    done
    cd {package_dir_path}/{tar_cd_suffix}
    tar -zchpf {tar_prefix}/{package_dir}.tar.gz {tar_prefix}/*
    cd - > /dev/null
    mv {package_dir_path}/{package_dir}.tar.gz {pkg}
    """.format(
        srcs = " ".join(["'%s'" % f.path for f in srcs]),
        proto_srcs = " ".join(["'%s'" % f.path for f in proto_srcs]),
        test_srcs = " ".join(["'%s'" % f.path for f in test_srcs]),
        package_dir_path = paths.package_dir_path,
        package_dir = paths.package_dir,
        pkg = ctx.outputs.pkg.path,
        tar_cd_suffix = paths.tar_cd_suffix,
        tar_prefix = paths.tar_prefix,
    )

    ctx.actions.run_shell(
        inputs = srcs + proto_srcs + test_srcs,
        command = script,
        outputs = [ctx.outputs.pkg],
    )

java_gapic_srcs_pkg = rule(
    attrs = {
        "deps": attr.label_list(mandatory = True),
        "test_deps": attr.label_list(mandatory = False, allow_empty = True),
        "package_dir": attr.string(mandatory = True),
    },
    outputs = {"pkg": "%{name}.tar.gz"},
    implementation = _java_gapic_srcs_pkg_impl,
)

def java_gapic_assembly_gradle_pkg(
        name,
        deps,
        include_samples = False,
        assembly_name = None,
        transport = None,
        **kwargs):
    package_dir = name
    if assembly_name:
        package_dir = "google-cloud-%s-%s" % (assembly_name, name)

    # Rename to avoid target conflicts with the monolith.
    proto_target = "proto-%s" % package_dir
    proto_target_dep = []
    grpc_target = "grpc-%s" % package_dir
    grpc_target_dep = []
    client_target = "gapic-%s" % package_dir
    client_target_dep = []

    client_deps = []
    client_test_deps = []
    grpc_deps = []
    proto_deps = []
    samples = []

    processed_deps = {}  #there is no proper Set in Starlark
    for dep in deps:
        # Use contains instead of endswith since microgenerator testing may use differently-named targets.
        if "_java_gapic" in dep:
            if include_samples:
                samples.append(dep + "_samples")
            _put_dep_in_a_bucket(dep, client_deps, processed_deps)
            _put_dep_in_a_bucket("%s_test" % dep, client_test_deps, processed_deps)
            _put_dep_in_a_bucket("%s_resource_name" % dep, proto_deps, processed_deps)
        elif dep.endswith("_java_grpc"):
            _put_dep_in_a_bucket(dep, grpc_deps, processed_deps)
        else:
            _put_dep_in_a_bucket(dep, proto_deps, processed_deps)

    if proto_deps:
        _java_gapic_gradle_pkg(
            name = proto_target,
            template_label = Label("//rules_java_gapic:resources/gradle/proto.gradle.tmpl"),
            deps = proto_deps,
            **kwargs
        )
        proto_target_dep = [":%s" % proto_target]

    if grpc_deps:
        _java_gapic_gradle_pkg(
            name = grpc_target,
            template_label = Label("//rules_java_gapic:resources/gradle/grpc.gradle.tmpl"),
            deps = proto_target_dep + grpc_deps,
            **kwargs
        )
        grpc_target_dep = ["%s" % grpc_target]

    if client_deps:
        if not transport or transport == "grpc":
            template_label = Label("//rules_java_gapic:resources/gradle/client_grpc.gradle.tmpl")
        elif transport == "rest":
            template_label = Label("//rules_java_gapic:resources/gradle/client_rest.gradle.tmpl")
        elif transport == "grpc+rest":
            template_label = Label("//rules_java_gapic:resources/gradle/client_grpcrest.gradle.tmpl")

        _java_gapic_gradle_pkg(
            name = client_target,
            template_label = template_label,
            deps = proto_target_dep + client_deps,
            test_deps = grpc_target_dep + client_test_deps,
            **kwargs
        )
        client_target_dep = ["%s" % client_target]

    _java_gapic_assembly_gradle_pkg(
        name = name,
        assembly_name = package_dir,
        deps = proto_target_dep + grpc_target_dep + client_target_dep,
        samples = samples,
    )

def _java_gapic_gradle_pkg(
        name,
        template_label,
        deps,
        test_deps = None,
        project_deps = None,
        test_project_deps = None,
        **kwargs):
    resource_target_name = "%s-resources" % name

    static_substitutions = dict(_PROPERTIES)
    static_substitutions["{{name}}"] = name

    java_gapic_build_configs_pkg(
        name = resource_target_name,
        deps = deps,
        test_deps = test_deps,
        package_dir = name,
        templates = {
            template_label: "build.gradle",
        },
        static_substitutions = static_substitutions,
    )

    srcs_gapic_pkg_target_name = "%s-srcs_pkg" % name
    java_gapic_srcs_pkg(
        name = srcs_gapic_pkg_target_name,
        deps = deps,
        test_deps = test_deps,
        package_dir = name,
        **kwargs
    )

    gapic_pkg_tar(
        name = name,
        extension = "tar.gz",
        deps = [
            resource_target_name,
            srcs_gapic_pkg_target_name,
        ],
        **kwargs
    )

def _java_gapic_assembly_gradle_pkg(name, assembly_name, deps, samples = None, visibility = None):
    resource_target_name = "%s-resources" % assembly_name
    java_gapic_build_configs_pkg(
        name = resource_target_name,
        deps = deps,
        templates = {
            Label("//rules_java_gapic:resources/gradle/assembly.gradle.tmpl"): "build.gradle",
            Label("//rules_java_gapic:resources/gradle/settings.gradle.tmpl"): "settings.gradle",
        },
    )

    gapic_pkg_tar(
        name = name,
        extension = "tar.gz",
        deps = [
            Label("//rules_java_gapic:gradlew"),
            resource_target_name,
        ] + deps,
        samples = samples,
        package_dir = assembly_name,
        visibility = visibility,
    )
