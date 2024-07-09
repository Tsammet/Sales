package com.hexagonal1;


import application.CreateUserUseCase;
import application.FindUserUseCase;
import application.UpdateUserUseCase;
import domain.service.UserService;
import infrastructure.in.UserController;
import infrastructure.out.UserRepository;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserRepository();
        
        CreateUserUseCase createUserUseCase = new CreateUserUseCase(userService);
        UpdateUserUseCase updateUserUseCase = new UpdateUserUseCase(userService);
        FindUserUseCase findUserUseCase = new FindUserUseCase(userService);
        
        UserController userController = new UserController(createUserUseCase, updateUserUseCase);

        userController.start();

    }
}