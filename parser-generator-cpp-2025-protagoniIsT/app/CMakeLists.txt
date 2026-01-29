add_executable(parser-generator)

setup_target(parser-generator)

target_include_directories(parser-generator PUBLIC "include")
target_include_directories(parser-generator PUBLIC "antlr")

add_subdirectory("antlr")
add_subdirectory("src")

target_link_libraries(parser-generator PRIVATE antlr4_static)
