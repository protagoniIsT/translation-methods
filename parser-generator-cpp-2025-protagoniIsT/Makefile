BUILD_DIR := build
BUILD_USE_SANITIZERS := ON
CMAKE_BUILD_TYPE := Debug
CMAKE_TOOLCHAIN_FILE := ""

TARGET_NAME = parser-generator
TARGET_PATH = $(BUILD_DIR)/bin/$(TARGET_NAME)

OUTPUT_PATH = out

.PHONY: all antlr build clean rebuild run
.SILENT: all antlr build clean rebuild run
.ONESHELL:

all: rebuild

antlr:
	antlr4 ./resources/Grammar.g4 -o ./app/antlr -Dlanguage=Cpp -Xexact-output-dir -visitor -listener

build:
	cmake . -D CMAKE_BUILD_TYPE=$(CMAKE_BUILD_TYPE) -D CMAKE_TOOLCHAIN_FILE=$(CMAKE_TOOLCHAIN_FILE) -D BUILD_USE_SANITIZERS=$(BUILD_USE_SANITIZERS) -S . -B $(BUILD_DIR)
	cmake --build $(BUILD_DIR)

clean:
	rm -rf $(BUILD_DIR)

rebuild: clean antlr build

run: $(TARGET_PATH)
	./$(TARGET_PATH)