package com.example.davidarisz.restaurant;

import java.util.ArrayList;

public class CategoriesRequest {
    public interface Callback {
        void gotCategories(ArrayList<String> categories);
        void gotCategoriesError(String message);
    }
}
