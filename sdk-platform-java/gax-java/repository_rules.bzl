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

def _com_google_api_gax_java_properties_impl(ctx):
    props_path = ctx.path(ctx.attr.file)
    result = ctx.execute(["cat", props_path])

    if result.return_code != 0:
        fail("Could not load dependencies from properties file, error_code %s" + str(result.return_code))

    props = result.stdout.splitlines()
    props_as_map = {}

    for prop in props:
        p = prop.strip()
        if len(p) <= 0 or p.startswith("#"):
            continue
        key_value = p.split("=", 1)
        props_as_map[key_value[0]] = key_value[1]

    props_name = ctx.attr.file.name
    dependencies_bzl = """
# DO NOT EDIT. This file was generated from {properties_file}.
PROPERTIES = {props_as_map}
     """.format(
        properties_file = props_name,
        props_as_map = str(props_as_map),
     )
    ctx.file("BUILD.bazel", "")
    ctx.file("%s.bzl" % props_name, dependencies_bzl)


com_google_api_gax_java_properties = repository_rule(
    implementation = _com_google_api_gax_java_properties_impl,
    attrs = {
        "file": attr.label(),
    },
    local = True,
)

