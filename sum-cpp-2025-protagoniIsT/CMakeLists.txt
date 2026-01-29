cmake_minimum_required(VERSION 3.11)
project(cpp-sum LANGUAGES CXX)

set(CMAKE_CXX_STANDARD 23)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_EXTENSIONS OFF)

add_executable(sum src/main.cpp)

target_compile_options(sum
    PRIVATE
        -Wall -Wextra
        -pedantic
        -Wold-style-cast -Wextra-semi
        -Woverloaded-virtual
        -Wzero-as-null-pointer-constant
        -Wnull-dereference
)

target_compile_options(sum
    PRIVATE
        -fsanitize=address,leak,undefined
)
target_link_options(sum
    PRIVATE
        -fsanitize=address,leak,undefined
)

target_compile_options(sum
    PRIVATE
        -fno-sanitize-recover=all
        -fno-optimize-sibling-calls
        -fno-omit-frame-pointer
)
