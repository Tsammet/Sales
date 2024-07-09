package com.hexagonal1;


import application.CreateUserUseCase;
import application.UpdateUserUseCase;
import domain.service.UserService;
import infrastructure.out.UserRepository;
import infrastructure.in.UserController;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserRepository();
        
        CreateUserUseCase createUserUseCase = new CreateUserUseCase(userService);
        UpdateUserUseCase updateUserUseCase = new UpdateUserUseCase(userService);
        
        UserController userController = new UserController(createUserUseCase, updateUserUseCase);

        userController.start();

    }
}