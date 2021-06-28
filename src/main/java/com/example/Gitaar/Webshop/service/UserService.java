package com.example.Gitaar.Webshop.service;

import com.example.Gitaar.Webshop.domain.Product;
import com.example.Gitaar.Webshop.domain.Review;
import com.example.Gitaar.Webshop.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    User findUserById(Long userId);

    User findUserByEmail(String email);

    List<User> findAllUsers();

    User findByPasswordResetCode(String code);

    List<Product> getCart(List<Long> productIds);

    Map<String, Object> login(String email);

    boolean registerUser(User user);

    boolean activateUser(String code);

    boolean sendPasswordResetCode(String email);

    void passwordReset(String email, String password);

    void userSave(String username, Map<String, String> form, User user);

    User updateProfile(String email, User user);

    void addReviewToProduct(Review review, Long productId);

}
