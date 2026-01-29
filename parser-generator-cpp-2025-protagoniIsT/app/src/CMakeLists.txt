# TODO: Add sources.
target_sources(parser-generator PRIVATE
    "${CMAKE_CURRENT_SOURCE_DIR}/main.cpp"
    "${CMAKE_CURRENT_SOURCE_DIR}/Translator.cpp"
    "${CMAKE_CURRENT_SOURCE_DIR}/MyGrammarVisitor.cpp"
    "${CMAKE_CURRENT_SOURCE_DIR}/Generator.cpp"
    "${CMAKE_CURRENT_SOURCE_DIR}/LexerGenerator.cpp"
    "${CMAKE_CURRENT_SOURCE_DIR}/ParserGenerator.cpp"
)
