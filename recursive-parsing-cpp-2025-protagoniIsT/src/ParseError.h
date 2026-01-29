#pragma once

#include <exception>
#include <string>

class ParseError final : public std::exception
{
public:
    explicit ParseError(const char* message)
        : msg_(message) {}

    explicit ParseError(const std::string& message)
        : msg_(message) {}

    ~ParseError() noexcept override = default;

    const char* what() const noexcept override {
       return msg_.c_str();
    }

private:
    std::string msg_;
};