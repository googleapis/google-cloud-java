"""
Package information of library_generation python scripts
"""

from setuptools import setup

setup(
    name="release_note_generation",
    version="0.1",
    python_requires=">=3.12",
    package_dir={
        "release_note_generation": ".",
    },
)
