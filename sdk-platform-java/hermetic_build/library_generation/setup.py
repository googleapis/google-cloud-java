"""
Package information of library_generation python scripts
"""

from setuptools import setup

setup(
    name="library_generation",
    version="0.1",
    python_requires=">=3.12",
    package_dir={
        "library_generation": ".",
        "synthtool": "owlbot/synthtool",
    },
    package_data={
        "library_generation": [
            "generate_library.sh",
            "postprocess_library.sh",
            "utils/utilities.sh",
            "templates/*.j2",
            "gapic-generator-java-wrapper",
            "owlbot/bin/*.sh",
            "owlbot/src/*.py",
            "owlbot/src/poms/*.py",
            "owlbot/templates/clirr/*.j2",
            "owlbot/templates/poms/*.j2",
            "owlbot/templates/java_library/.github/**/*",
            "owlbot/templates/java_library/**/*",
            "owlbot/templates/java_library/.kokoro/build.sh",
            "owlbot/templates/java_library/.kokoro/presubmit/graalvm-*.cfg",
        ],
        "synthtool": ["owlbot/synthtool/**/*"],
    },
)
