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

load("@rules_java//java:defs.bzl", "java_test")

def java_tests(name, srcs, runtime_deps, size):
    classNames = []
    for src in srcs:
        # convert .java file path to fully qualified class name
        className = src[(src.index("/com/") + 1):-5].replace("/", ".")
        classNames.append(className)
        java_test(
            name = className,
            test_class = className,
            runtime_deps = runtime_deps,
            size = size,
        )
    if classNames:
        native.test_suite(
            name = name,
            tests = classNames,
        )

def google_java_format(name, srcs, formatter):
    native.genrule(
        name = name,
        outs = ["%s.sh" % name],
        srcs = srcs,
        # TODO: this may fail if list of files is too long (exceeds max command line limit in shell).
        #       Split the command into multiple executions if this ever fails (good enough for now)
        cmd = "echo ' $(location %s) --replace $(SRCS)' > $@" % formatter,
        executable = True,
        tools = [formatter],
        local = 1,
    )

def _google_java_format_verification_impl(ctx):
    src_files = [src.path for src in ctx.files.srcs]
    output_file = ctx.outputs.output_file
    formatter = ctx.executable.formatter

    ctx.actions.run_shell(
        inputs = ctx.files.srcs,
        arguments = ["--dry-run", "--set-exit-if-changed"] + src_files,
        tools = [formatter],
        command = "%s $@ > %s" % (formatter.path, output_file.path),
        outputs = [output_file],
        progress_message =
            "If this target fails check the list of files that must be formatted in %s" % output_file.path,
    )

google_java_format_verification = rule(
    attrs = {
        "srcs": attr.label_list(allow_files = True),
        "formatter": attr.label(
            executable = True,
            cfg = "exec",
        ),
    },
    outputs = {"output_file": "%{name}.txt"},
    implementation = _google_java_format_verification_impl,
)
