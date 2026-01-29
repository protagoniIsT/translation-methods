add_library(itmoantlr)

setup_target(itmoantlr)

target_include_directories(itmoantlr PUBLIC "include")
target_include_directories(itmoantlr PUBLIC "generated")

add_subdirectory("generated")
add_subdirectory("src")

target_link_libraries(itmoantlr PRIVATE antlr4_static)
