package com.hexagonal1;


import java.util.Scanner;

import application.CreateUserUseCase;
import application.DeleteUserUseCase;
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
        DeleteUserUseCase deleteUserUseCase = new DeleteUserUseCase(userService);
        
        UserController userController = new UserController(createUserUseCase, updateUserUseCase, findUserUseCase, deleteUserUseCase);


        
        while(true){
            Scanner scannerM = new Scanner(System.in);
            System.out.println("1. Crear Usuario ");
            System.out.println("2. Eliminar Usuario ");
            System.out.println("3. Actualizar Usuario ");
            System.out.println("4. Encontrar Usuario ");
            System.out.println("5. Salir");

            int choice = scannerM.nextInt();
            scannerM.nextLine();

            switch(choice){
                case 1:

                    userController.createUSer();

                    break;

                case 2:

                    userController.deleteUser();

                    break;

                case 3:

                    userController.updateUser();

                    break;

                case 4:

                    userController.findUser();

                    break;

                default:
                
                    throw new AssertionError();

            }
        }
    }
}