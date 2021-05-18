package com.example.Gitaar.Webshop.mapper;

import com.example.Gitaar.Webshop.domain.Review;
import com.example.Gitaar.Webshop.domain.User;
import com.example.Gitaar.Webshop.dto.RegistrationRequestDto;
import com.example.Gitaar.Webshop.dto.product.ProductResponseDto;
import com.example.Gitaar.Webshop.dto.review.ReviewRequestDto;
import com.example.Gitaar.Webshop.dto.user.UserRequestDto;
import com.example.Gitaar.Webshop.dto.user.UserResponseDto;
import com.example.Gitaar.Webshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ModelMapper modelMapper;
    private final ProductMapper productMapper;
    private final UserService userService;

    private User convertToEntity(UserRequestDto userRequestDto) {
        return modelMapper.map(userRequestDto, User.class);
    }

    private User convertToEntity(RegistrationRequestDto registrationRequestDto) {
        return modelMapper.map(registrationRequestDto, User.class);
    }

    private Review convertToEntity(ReviewRequestDto reviewRequestDto) {
        return modelMapper.map(reviewRequestDto, Review.class);
    }

    public UserResponseDto convertToResponseDto(User user) {
        return modelMapper.map(user, UserResponseDto.class);
    }

    public UserResponseDto findUserById(Long userId) {
        return convertToResponseDto(userService.findUserById(userId));
    }

    public UserResponseDto findUserByEmail(String email) {
        return convertToResponseDto(userService.findUserByEmail(email));
    }

    public List<ProductResponseDto> getCart(List<Long> productsIds) {
        return productMapper.convertListToResponseDto(userService.getCart(productsIds));
    }

    public List<UserResponseDto> findAllUsers() {
        return userService.findAllUsers()
                .stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    public UserResponseDto findByPasswordResetCode(String code) {
        return convertToResponseDto(userService.findByPasswordResetCode(code));
    }

    public Map<String, Object> login(String email) {
        return userService.login(email);
    }

    public boolean registerUser(RegistrationRequestDto registrationRequestDto) {
        return userService.registerUser(convertToEntity(registrationRequestDto));
    }

    public boolean activateUser(String code) {
        return userService.activateUser(code);
    }

    public boolean sendPasswordResetCode(String email) {
        return userService.sendPasswordResetCode(email);
    }

    public void passwordReset(String email, String password) {
        userService.passwordReset(email, password);
    }

    public void userSave(String username, Map<String, String> form, UserRequestDto userRequestDto) {
        userService.userSave(username, form, convertToEntity(userRequestDto));
    }

    public UserResponseDto updateProfile(String email, UserRequestDto userRequestDto) {
        return convertToResponseDto(userService.updateProfile(email, convertToEntity(userRequestDto)));
    }

    public void addReviewToProduct(ReviewRequestDto reviewRequestDto, Long perfumeId) {
        userService.addReviewToProduct(convertToEntity(reviewRequestDto), perfumeId);
    }
}
