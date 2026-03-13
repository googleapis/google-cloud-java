# Copyright 2024 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
from collections import defaultdict
from typing import Any
from typing import Dict
from typing import List
from common.model.config_change import ChangeType
from common.model.config_change import ConfigChange
from common.model.config_change import LibraryChange
from common.model.config_change import HashLibrary
from common.model.gapic_config import GapicConfig
from common.model.generation_config import GenerationConfig
from common.model.library_config import LibraryConfig


def compare_config(
    baseline_config: GenerationConfig, current_config: GenerationConfig
) -> ConfigChange:
    """
    Compare two GenerationConfig object and output a mapping from ConfigChange
    to a list of ConfigChange objects.
    All libraries in the current configuration will be affected if one of the
    repository level parameters is changed.

    :param baseline_config: the baseline GenerationConfig object
    :param current_config: the current GenerationConfig object
    :return: a ConfigChange objects.
    """
    diff = defaultdict(list[LibraryChange])
    # Exclude `libraries` because an empty library list (e.g., by library
    # removal) will cause this parameter appears in the sorted param list,
    # which leads to unequal list of parameters.
    excluded_params = {"libraries"}
    baseline_params = __convert_params_to_sorted_list(
        obj=baseline_config, excluded_params=excluded_params
    )
    current_params = __convert_params_to_sorted_list(
        obj=current_config, excluded_params=excluded_params
    )

    for baseline_param, current_param in zip(baseline_params, current_params):
        if baseline_param == current_param:
            continue
        if baseline_param[0] == "googleapis_commitish":
            diff[ChangeType.GOOGLEAPIS_COMMIT] = []
        else:
            config_change = LibraryChange(
                changed_param=current_param[0],
                current_value=current_param[1],
            )
            diff[ChangeType.REPO_LEVEL_CHANGE].append(config_change)

    __compare_libraries(
        diff=diff,
        baseline_library_configs=baseline_config.libraries,
        current_library_configs=current_config.libraries,
    )
    return ConfigChange(
        change_to_libraries=diff,
        baseline_config=baseline_config,
        current_config=current_config,
    )


def __compare_libraries(
    diff: Dict[ChangeType, list[LibraryChange]],
    baseline_library_configs: List[LibraryConfig],
    current_library_configs: List[LibraryConfig],
) -> None:
    """
    Compare two lists of LibraryConfig and put the difference into a
    given Dict.

    :param diff: a mapping from ConfigChange to a list of ConfigChange objects.
    :param baseline_library_configs: a list of LibraryConfig object.
    :param current_library_configs: a list of LibraryConfig object.
    """
    baseline_libraries = __convert_to_hashed_library_dict(baseline_library_configs)
    current_libraries = __convert_to_hashed_library_dict(current_library_configs)
    changed_libraries = []
    # 1st round comparison.
    for library_name, hash_library in baseline_libraries.items():
        # 1. find any library removed from baseline_libraries.
        # a library is removed from baseline_libraries if the library_name
        # is not in current_libraries.
        # please see the reason of comment out these lines of code in the
        # comment of ChangeType.LIBRARIES_REMOVAL.
        # if library_name not in current_libraries:
        #     config_change = ConfigChange(
        #         changed_param="", current_value="", library_name=library_name
        #     )
        #     diff[ChangeType.LIBRARIES_REMOVAL].append(config_change)

        # 2. find any library that exists in both configs but at least one
        # parameter is changed, which means the hash value is different.
        if (
            library_name in current_libraries
            and hash_library.hash_value != current_libraries[library_name].hash_value
        ):
            changed_libraries.append(library_name)
    # 2nd round comparison.
    for library_name in current_libraries:
        # find any library added to current_libraries.
        # a library is added to current_libraries if the library_name
        # is not in baseline_libraries.
        if library_name not in baseline_libraries:
            config_change = LibraryChange(
                changed_param="", current_value="", library_name=library_name
            )
            diff[ChangeType.LIBRARIES_ADDITION].append(config_change)
    # 3rd round comparison.
    __compare_changed_libraries(
        diff=diff,
        baseline_libraries=baseline_libraries,
        current_libraries=current_libraries,
        changed_libraries=changed_libraries,
    )


def __convert_to_hashed_library_dict(
    libraries: List[LibraryConfig],
) -> Dict[str, HashLibrary]:
    """
    Convert a list of LibraryConfig objects to a Dict.
    For each library object, the key is the library_name of the object, the
    value is a HashLibrary object.

    :param libraries: a list of LibraryConfig object.
    :return: a mapping from library_name to HashLibrary object.
    """
    return {
        library.get_library_name(): HashLibrary(hash(library), library)
        for library in libraries
    }


def __compare_changed_libraries(
    diff: Dict[ChangeType, list[LibraryChange]],
    baseline_libraries: Dict[str, HashLibrary],
    current_libraries: Dict[str, HashLibrary],
    changed_libraries: List[str],
) -> None:
    """
    Compare each library with the same library_name to find what parameters are
    changed.

    :param diff: a mapping from ConfigChange to a list of ConfigChange objects.
    :param baseline_libraries: a mapping from library_name to HashLibrary
    object.
    :param current_libraries: a mapping from library_name to HashLibrary object.
    :param changed_libraries: a list of library_name of changed libraries.
    :raise ValueError: if api_shortname of a library is changed but library_name
    remains the same.
    """
    for library_name in changed_libraries:
        baseline_library = baseline_libraries[library_name].library
        current_library = current_libraries[library_name].library
        baseline_params = __convert_params_to_sorted_list(baseline_library)
        current_params = __convert_params_to_sorted_list(current_library)
        for baseline_param, current_param in zip(baseline_params, current_params):
            if baseline_param == current_param:
                continue
            if baseline_param[0] == "api_shortname":
                raise ValueError(
                    f"{library_name}: api_shortname must not change when library_name remains the same."
                )
            else:
                config_change = LibraryChange(
                    changed_param=current_param[0],
                    current_value=current_param[1],
                    library_name=library_name,
                )
                diff[ChangeType.LIBRARY_LEVEL_CHANGE].append(config_change)

        # compare gapic_configs
        baseline_gapic_configs = baseline_library.gapic_configs
        current_gapic_configs = current_library.gapic_configs
        __compare_gapic_configs(
            diff=diff,
            library_name=library_name,
            baseline_gapic_configs=baseline_gapic_configs,
            current_gapic_configs=current_gapic_configs,
        )


def __compare_gapic_configs(
    diff: Dict[ChangeType, list[LibraryChange]],
    library_name: str,
    baseline_gapic_configs: List[GapicConfig],
    current_gapic_configs: List[GapicConfig],
) -> None:
    baseline_proto_paths = {config.proto_path for config in baseline_gapic_configs}
    current_proto_paths = {config.proto_path for config in current_gapic_configs}
    # 1st round of comparison, find any versioned proto_path is removed
    # from baseline gapic configs.
    # please see the reason of comment out these lines of code in the
    # comment of ChangeType.GAPIC_REMOVAL.
    # for proto_path in baseline_proto_paths:
    #     if proto_path in current_proto_paths:
    #         continue
    #     config_change = ConfigChange(
    #         changed_param="", current_value=proto_path, library_name=library_name
    #     )
    #     diff[ChangeType.GAPIC_REMOVAL].append(config_change)

    # 2nd round of comparison, find any versioned proto_path is added
    # to current gapic configs.
    for proto_path in current_proto_paths:
        if proto_path in baseline_proto_paths:
            continue
        config_change = LibraryChange(
            changed_param="", current_value=proto_path, library_name=library_name
        )
        diff[ChangeType.GAPIC_ADDITION].append(config_change)


def __convert_params_to_sorted_list(obj: Any, excluded_params=None) -> List[tuple]:
    """
    Convert the parameter and its value of a given object to a sorted list of
    tuples.

    Only the following types of parameters will be considered:

    - str
    - bool
    - list[str]
    - None

    Note that built-in params, e.g., __str__, and methods will be skipped.

    :param obj: an object.
    :param excluded_params: excluded params.
    :return: a sorted list of tuples.
    """
    if excluded_params is None:
        excluded_params = set()
    param_and_values = []
    for param, value in vars(obj).items():
        if (
            param in excluded_params
            or param.startswith("__")  # skip built-in params
            or callable(getattr(obj, param))  # skip methods
            # skip if the type of param is not one of the following types
            # 1. str
            # 2. bool
            # 3. list[str]
            # 4. None
            or not (
                isinstance(getattr(obj, param), str)
                or isinstance(getattr(obj, param), bool)
                or __is_list_of_str(obj=obj, param=param)
                or getattr(obj, param) is None
            )
        ):
            continue
        param_and_values.append((param, value))
    return sorted(param_and_values)


def __is_list_of_str(obj: Any, param: str) -> bool:
    """
    Returns True if the type of param of a given object is a list of str; False
    otherwise.

    This method is a workaround of https://bugs.python.org/issue28339.
    """
    value = getattr(obj, param)
    if not isinstance(value, list):
        return False
    for v in value:
        if not isinstance(v, str):
            return False
    return True
