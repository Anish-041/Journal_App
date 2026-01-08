package com.example.journalapp.apiResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuoteResponse {
    @JsonProperty("q")
    public String quote;

    @JsonProperty("a")
    public String author;

    @JsonProperty("h")
    public String htmlFormat;
}
