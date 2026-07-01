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
            "owlbot/bin/*.sh",
            "owlbot/src/*.py",
            "owlbot/templates/java_library/.github/**/*",
            "owlbot/templates/java_library/**/*",
            "owlbot/templates/java_library/.kokoro/build.sh",
            "owlbot/templates/java_library/.kokoro/presubmit/graalvm-*.cfg",
        ],
        "synthtool": ["owlbot/synthtool/**/*"],
    },
)
