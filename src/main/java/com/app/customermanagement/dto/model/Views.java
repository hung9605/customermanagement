package com.app.customermanagement.dto.model;

public class Views {
    public static class Summary {
    }     // View chỉ cho dữ liệu tóm tắt (không bao gồm description)
    public static class Detail extends Summary {}  // View chi tiết (bao gồm description)
}