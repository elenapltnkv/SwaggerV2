package Dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Product {

        @JsonProperty("id")
        private Integer id;
        @JsonProperty("title")
        private String title;
        @JsonProperty("price")
        private Integer price;
        @JsonProperty("categoryTitle")
        private String categoryTitle;

        public void withTitle(String ingredient) {
        }
}
