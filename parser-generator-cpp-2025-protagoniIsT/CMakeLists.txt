cmake_minimum_required(VERSION 3.11)
project(cpp-parser-generator LANGUAGES CXX)

option(BUILD_USE_SANITIZERS "Enable to build with default sanitizers." OFF)

set(CMAKE_CXX_STANDARD 23)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_EXTENSIONS OFF)

set(CMAKE_RUNTIME_OUTPUT_DIRECTORY "${CMAKE_BINARY_DIR}/bin")
set(CMAKE_ARCHIVE_OUTPUT_DIRECTORY "${CMAKE_BINARY_DIR}/bin")
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY "${CMAKE_BINARY_DIR}/lib")

find_package(antlr4-runtime CONFIG REQUIRED)

include(cmake/setup_target.cmake)

add_subdirectory(app)
